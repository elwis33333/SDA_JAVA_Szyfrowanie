package ProjectMaven.tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InputManager implements ActionListener {
    private JTextField output;
    private JTextArea log;
    private final String defaultPath = "./src/main/resources/";
    public InputManager(JTextField JField, JTextArea logArea) {
        output=JField;
        log = logArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(defaultPath);
        final int status = fileChooser.showOpenDialog(null);
        if(status==JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            output.setText(file.getAbsolutePath());
            log.append("Choosen file: "+file.getName()+"\n");
        }else{
            log.append("Canceled"+"\n");
        }
    }
}
