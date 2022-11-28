package com.company.sales.jmx;

import com.haulmont.cuba.core.app.EmailerAPI;
import com.haulmont.cuba.core.global.EmailAttachment;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.EmailInfoBuilder;
import com.haulmont.cuba.security.app.Authenticated;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import com.haulmont.cuba.core.sys.jmx.JmxBean;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

@JmxBean(module = "sales", alias = "employeeWorkerMBean")
@ManagedResource(description = "JMX bean for some settings")
public interface EmployeeWorkerMBean{

    public void sendGreetings();

    public void Hello() throws EmailException;

    public String sendTestEmail();

    String getFromAddress();
    void setFromAddress(String address);

    String getSmtpHost();
    void setSmtpHost(String host);

    int getSmtpPort();
    void setSmtpPort(int port);

    String getSmtpUser();
    void setSmtpUser(String user);

    boolean getSmtpAuthRequired();
    void setSmtpAuthRequired(boolean authRequired);

    boolean getStarttlsEnable();
    void setStarttlsEnable(boolean enable);

    boolean getSmtpSslEnabled();
    void setSmtpSslEnabled(boolean enabled);

    int getSmtpTimeoutSec();
    void setSmtpTimeoutSec(int timeoutSec);

    int getSmtpConnectionTimeoutSec();
    void setSmtpConnectionTimeoutSec(int timeoutSec);

    @ManagedOperation(description = "Update properties for JavaMail session")
    void updateSession();

}