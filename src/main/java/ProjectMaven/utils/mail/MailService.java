package ProjectMaven.utils.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

//eysyłanie maili za pomocą wzorca builder
public class MailService {
    private String mailTo;
    private String mailTitle;
    //private String mailFrom;
    private String mailBody;
    private String information;

    public MailService(MailBuilder mail) {
        this.mailTo = mail.mailTo;
        this.mailTitle = mail.mailTitle;
        //this.mailFrom = mail.mailFrom;
        this.mailBody = mail.mailBody;

    }

    public void send() {
        final SimpleEmail mailer = MailPrototype.getInstance();
        mailer.setSubject(mailTitle);
        try {
            mailer.addTo(mailTo);
            mailer.setMsg(mailBody);
          //  mailer.setFrom(mailFrom);
            information= mailer.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public String getInformation() {
        return information;
    }

    public static class MailBuilder {
            private String mailTo;
            private String mailTitle;
          //  private String mailFrom;
            private String mailBody;

            public MailBuilder(String mailTo, String mailTitle) {
                this.mailTo = mailTo;
                this.mailTitle = mailTitle;
           //     this.mailFrom = "noreply@example.com";
                this.mailBody = "";
            }

           /* public MailBuilder setFrom(String address) {
                this.mailFrom = address;
                return this;
            }*/

            public MailBuilder addBody(String bodyMessage) {
                this.mailBody = bodyMessage;
                return this;
            }

            public MailService build() {
                return new MailService(this);
            }
        }

    }
