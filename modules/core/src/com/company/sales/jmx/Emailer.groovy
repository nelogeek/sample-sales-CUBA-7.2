import javax.mail.*
import javax.mail.internet.*
/*
 
Get Any JAVAMAIL Dependency 
===============================
Download JAVAMAIL dependency that you need.
download JAVAMAIL at : https://maven.java.net/content/repositories/releases/com/sun/mail/javax.mail/1.5.2/javax.mail-1.5.2.jar
To install, copy & paste the *.jar to installed Groovy lib directory:
eg: C:\Program Files (x86)\Groovy\Groovy-2.1.1\lib
 
*/


public class SMTPAuthenticator extends Authenticator
{
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication('email@gmail.com', 'password111');
    }
}

def  d_email = "email@gmail.com",
     d_uname = "email@gmail.com",
     d_password = "password111",
     d_host = "smtp.gmail.com",
     d_port  = "465", //465,587
     m_to = "email@astrums.net",
     m_subject = "Testing",
     m_text = "Hey, this is the testing email."

def props = new Properties()
props.put("mail.smtp.user", d_email)
props.put("mail.smtp.host", d_host)
props.put("mail.smtp.port", d_port)
props.put("mail.smtp.starttls.enable","true")
props.put("mail.smtp.debug", "true");
props.put("mail.smtp.auth", "true")
props.put("mail.smtp.socketFactory.port", d_port)
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
props.put("mail.smtp.socketFactory.fallback", "false")

def auth = new SMTPAuthenticator()
def session = Session.getInstance(props, auth)
session.setDebug(true);

def msg = new MimeMessage(session)
msg.setText(m_text)
msg.setSubject(m_subject)
msg.setFrom(new InternetAddress(d_email))
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to))

Transport transport = session.getTransport("smtps");
transport.connect(d_host, d_port, d_uname, d_password);
transport.sendMessage(msg, msg.getAllRecipients());
transport.close();