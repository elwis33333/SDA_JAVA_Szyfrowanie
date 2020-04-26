package ProjectMaven.tool;

import ProjectMaven.utils.mail.MailService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailMenager implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final String addr =JOptionPane.showInputDialog("Add addres to:", "example@email.com");
        final String msg = JOptionPane.showInputDialog("Add body msg:", "Regards from crypto app");
   final MailService service = new MailService.MailBuilder(addr,"CryptoMail").addBody(msg).build();
   service.send();
    }
}
