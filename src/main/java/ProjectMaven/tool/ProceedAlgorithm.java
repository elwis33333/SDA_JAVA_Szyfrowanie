package ProjectMaven.tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProceedAlgorithm implements ActionListener {
    private JTextField input;
    private JTextField output;
    //private int cipher;
    private JComboBox cipher;
    private JRadioButton encodeButton;
    private JTextArea log;

    public ProceedAlgorithm(JTextField input, JTextField output, JComboBox ciphersCombo, JRadioButton encodeButton, JTextArea logArea) {
    this.encodeButton=encodeButton;
    this.log=logArea;
    this.input = input;
    this.output = output;
    //this.cipher=ciphersCombo.getSelectedItem();
        this.cipher=ciphersCombo;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       File inFile = Path.of(input.getText()).toFile();
        File outFile = Path.of(output.getText()).toFile();
    log.append("Algo: "+ cipher.getSelectedItem() + " encode: " + encodeButton.isSelected() + "\n");
    log.append("File in: "+ inFile.getName() + " File out: " + outFile.getName() + "\n");
    log.append(this.toString()+ "\n");
        try (final BufferedReader fileReader = new BufferedReader(new FileReader(inFile))) {
            final String line = fileReader.readLine();
            log.append("Input: "+ line +"\n");
        }catch (IOException e){
            log.append(e+"ERROR\n");
        }

    }
}
