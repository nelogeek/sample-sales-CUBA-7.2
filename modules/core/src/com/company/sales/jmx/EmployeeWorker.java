package com.company.sales.jmx;

import com.company.sales.entity.City;
import com.company.sales.entity.Employee;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.*;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.core.jmx.Emailer;
import com.haulmont.cuba.security.app.Authenticated;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component("sales_EmployeeWorkerMBean")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    private EmailerAPI emailer;
    protected EmailerConfig config;

    DataManager dataManager;
    @Inject
    private Persistence persistence;
    @Inject
    private TimeSource timeSource;
    @Inject
    private Scripting scripting;
    @Inject
    private EmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(Emailer.class);

    @Inject
    public void setConfiguration(Configuration configuration) {
        this.config = configuration.getConfig(EmailerConfig.class);
    }

    @Override
    public String getFromAddress() {
        return config.getFromAddress();
    }

    @Authenticated
    @Override
    public void setFromAddress(String address) {
        if (address != null) {
            config.setFromAddress(address);
        }
    }

    @Override
    public String getSmtpHost() {
        return config.getSmtpHost();
    }

    @Authenticated
    @Override
    public void setSmtpHost(String host) {
        if (host != null) {
            config.setSmtpHost(host);
        }
    }

    @Override
    public int getSmtpPort() {
        return config.getSmtpPort();
    }

    @Authenticated
    @Override
    public void setSmtpPort(int port) {
        config.setSmtpPort(port);
    }

    @Override
    public String getSmtpUser() {
        return config.getSmtpUser();
    }

    @Authenticated
    @Override
    public void setSmtpUser(String user) {
        if (user != null) {
            config.setSmtpUser(user);
        }
    }

    @Override
    public boolean getSmtpAuthRequired() {
        return config.getSmtpAuthRequired();
    }

    @Authenticated
    @Override
    public void setSmtpAuthRequired(boolean authRequired) {
        config.setSmtpAuthRequired(authRequired);
    }

    @Override
    public boolean getStarttlsEnable() {
        return config.getSmtpStarttlsEnable();
    }

    @Authenticated
    @Override
    public void setStarttlsEnable(boolean enable) {
        config.setSmtpStarttlsEnable(enable);
    }

    @Override
    public boolean getSmtpSslEnabled() {
        return config.getSmtpSslEnabled();
    }

    @Authenticated
    @Override
    public void setSmtpSslEnabled(boolean enable) {
        config.setSmtpSslEnabled(enable);
    }

    @Override
    public int getSmtpTimeoutSec() {
        return config.getSmtpTimeoutSec();
    }

    @Authenticated
    @Override
    public void setSmtpTimeoutSec(int timeoutSec) {
        config.setSmtpTimeoutSec(timeoutSec);
    }

    @Override
    public int getSmtpConnectionTimeoutSec() {
        return config.getSmtpConnectionTimeoutSec();
    }

    @Authenticated
    @Override
    public void setSmtpConnectionTimeoutSec(int timeoutSec) {
        config.setSmtpConnectionTimeoutSec(timeoutSec);
    }


    @Authenticated
    @Override
    public void updateSession() {
        emailer.updateSession();
    }


    @Override
    public void sendGreetings() {
        try (Transaction tx = persistence.createTransaction())
        {
                Date date = new Date();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Query query = persistence.getEntityManager().createNativeQuery(
                        "select " +
                                "last_name, " +
                                "first_name, " +
                                "email, " +
                                "birthday " +
                                "from sales_Employee"
                );

                List list = query.getResultList();

                for (Object o: list) {
                    Object[] row = (Object[]) o;
                    String lastName = (String) row[0];
                    String firstName = (String) row[1];
                    String email = (String) row[2];
                    Integer day = Integer.valueOf( row[3].toString().split("-")[2].trim());
                    Integer month = Integer.valueOf(row[3].toString().split("-")[1].trim());
                    if ( localDate.getDayOfMonth() == day && localDate.getMonthValue() == month){
                        System.out.println(lastName + " " + firstName + " " + email + " ");
//                        String greetingMessage = scripting.runGroovyScript("com/company/sales/service/Emailer.groovy", new Binding());
                    }
                }


            } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

//    @Authenticated
//    private void sendByEmail() throws EmailException {
////        EmailInfo emailInfo = EmailInfoBuilder.create()
////                .setAddresses("lokotaevpr@gmail.com")
////                .setCaption("Тестовое письмо из Cuba")
////                .setFrom("From ME")
////                .build();
////        emailService.sendEmailAsync(emailInfo);
//
//        EmailInfo emailInfo1 = EmailInfoBuilder.create("lokotaevpr@gmail.com", "Тестовая хуйня", "TEST!").build();
//        emailService.sendEmail(emailInfo1);
//    }

    @Authenticated
    @Override
    public void Hello() throws EmailException {
        System.out.println("Hello!");

    }


    @Authenticated
    @Override
    public String sendTestEmail() {
        try {
            String att = "<html><body><h1>Test attachment</h1></body></html>";
            EmailAttachment emailAtt = EmailAttachment.createTextAttachment(att, StandardCharsets.UTF_8.name(), "test attachment.html");
            EmailInfo emailInfo = EmailInfoBuilder.create("orlovava@tyuiu.ru", "Test email", "<html><body><h1>Test email</h1></body></html>")
                    .setAttachments(emailAtt)


                    .build();
            emailer.sendEmail(emailInfo);
            return "Email to '" + "lokotaevpr@gmail.com" + "' sent successfully";
        } catch (Exception e) {
            return ExceptionUtils.getStackTrace(e);
        }
    }


}