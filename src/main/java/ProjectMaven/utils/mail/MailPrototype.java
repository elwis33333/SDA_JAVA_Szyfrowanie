package ProjectMaven.utils.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MailPrototype {
    private static SimpleEmail INSTANCE;

    private MailPrototype() throws IOException, EmailException {
        Properties properties = new Properties();
         properties.load(new FileReader("./src/main/resources/mail.properties"));
        INSTANCE = new SimpleEmail();
        INSTANCE.setHostName(properties.getProperty("email.host"));
        INSTANCE.setSmtpPort(Integer.parseInt(properties.getProperty("email.port")));
        INSTANCE.setAuthenticator(new DefaultAuthenticator(properties.getProperty("email.user"), properties.getProperty("email.pass")));
        INSTANCE.setSSLOnConnect(true);

        INSTANCE.setFrom(properties.getProperty("email.user"));
        /*INSTANCE.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("foo@bar.com");*/
    }
    public static SimpleEmail getInstance(){
        if(INSTANCE==null){
            try {
                new MailPrototype();
            } catch (IOException | EmailException e) {
                e.printStackTrace();
            }

        }
        return INSTANCE;
    }
}
