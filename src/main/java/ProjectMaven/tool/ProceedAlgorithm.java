package ProjectMaven.tool;

import ProjectMaven.CesarCipher;
import ProjectMaven.ICipher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProceedAlgorithm implements ActionListener {
    private JTextField input;
    private JTextField output;
    //private int cipher;
    private JComboBox cipher;
    private JRadioButton encodeButton;
    private JTextArea log;
    private ICipher algorithmCipher;

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
    log.append("Algo: "+ cipher.getSelectedItem() + ((encodeButton.isSelected())?" encode\n":" decode\n"));
    log.append("File in: "+ inFile.getName() + " File out: " + outFile.getName() + "\n");
    //nalezy pobrac algorytm szyfrowania
        algorithmCipher = CipherFactory.getAlgorithm((String) cipher.getSelectedItem());

        try (final BufferedReader fileReader = new BufferedReader(new FileReader(inFile));
            final BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outFile))){
            fileWriter.write("");
            String line;
            while ((line = fileReader.readLine()) != null) {
                String outLine = runAlgorithm(line);
                fileWriter.append(outLine).append("\n");
            }

        }catch (IOException e){
            log.append(e+"ERROR\n");
        }

    }
    private String runAlgorithm(String line) {
        algorithmCipher.setBase(line);
        if (encodeButton.isSelected()) {
            algorithmCipher.encode();
        } else {
            algorithmCipher.decode();
        }
        return (encodeButton.isSelected()) ? algorithmCipher.getEncode() : algorithmCipher.getDecode();
    }
}
