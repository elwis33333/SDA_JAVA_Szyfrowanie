package ProjectMaven;

import ProjectMaven.tool.InputManager;
import ProjectMaven.tool.MailMenager;
import ProjectMaven.tool.ProceedAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements ActionListener {
    private JTextArea logArea;
    private JTextField inputFile;
    private JTextField outputFile;
    private JComboBox ciphersCombo;
    private JRadioButton encodeButton;
    private JButton runAlgorithmButton;
    public void startGui() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //zmiana stylu na zdefiniowany w javie
        JFrame mainFrame = new JFrame("Crypto app");
        mainFrame.setMinimumSize(new Dimension(400, 200));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setJMenuBar(addMenuBar());
        mainFrame.add(addMainPanel());
        setListeners();
        mainFrame.setVisible(true);
        mainFrame.pack();
    }

    private void setListeners() {
        runAlgorithmButton.addActionListener(new ProceedAlgorithm(inputFile, outputFile, ciphersCombo, encodeButton, logArea));
    }

    private JMenuBar addMenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu optMenu = new JMenu("Options");

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        exit.addActionListener(this);
        fileMenu.add(exit);

        JMenuItem mailing = new JMenuItem("Send email from annarybak95@wp.pl to....");
        mailing.addActionListener(new MailMenager());
        optMenu.add(mailing);


        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(optMenu);

        return menuBar;
    }

    private Component addMainPanel() {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints constr = new GridBagConstraints();
        logArea = new JTextArea(8,10); ///musiała tu zostać zamieszczona żeby z przycisków select można było wypisywać tekst na tym polu
        //TODO get this value from properties
        JLabel titleLabel = new JLabel("Enigma Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLACK);
        constr.fill = GridBagConstraints.CENTER;
        constr.gridx = 0;
        constr.gridy = 0;
        panel.add(titleLabel, constr);
        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridy = 1;
        panel.add(addSubpanelWithControlers(), constr);
        runAlgorithmButton = new JButton("Run and let miracles happen");
        constr.gridy = 2;
        constr.insets = new Insets(5,3,1,3);
        panel.add(runAlgorithmButton, constr);
/////////////////////tu by było  logArea = new JTextArea(8,10);  ale trzeba było to wcześniej zdeninniować
        //logArea.setLineWrap(true);
        logArea.setVisible(true);
        JScrollPane scroll = new JScrollPane (logArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        constr.gridy = 3;
        panel.add(scroll, constr);
        return panel;

    }

    private Component addSubpanelWithControlers() {
        JPanel subPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel sourcelabel = new JLabel("Source file:");
        JLabel destinationlabel = new JLabel("Destination:");
        JLabel chooselabel = new JLabel("Choose cipher:");
        inputFile = new JTextField("input.txt",15);
        outputFile = new JTextField("output.txt",15);
        JButton chooseInput = new JButton("Select");
        chooseInput.addActionListener(new InputManager(inputFile, logArea));
        JButton chooseOutput = new JButton("Select");
        chooseOutput.addActionListener(new InputManager(outputFile, logArea));
        ciphersCombo = new JComboBox(CiphersList.getCiphersList());

        encodeButton = new JRadioButton("Encode");
        encodeButton.setSelected(true);
        JRadioButton decodeButton = new JRadioButton("Decode");
        ButtonGroup grup = new ButtonGroup();
        grup.add(encodeButton);
        grup.add(decodeButton);
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridx = 0;
        subPanel.add(sourcelabel, constraints);
        constraints.gridx = 1;
        subPanel.add(inputFile, constraints);
        constraints.gridx = 2;
        subPanel.add(chooseInput, constraints);
        constraints.gridx = 3;
        subPanel.add(chooselabel, constraints);
        constraints.gridx = 4;
        subPanel.add(encodeButton, constraints);
        constraints.gridy = 1;
        constraints.gridx = 0;
        subPanel.add(destinationlabel, constraints);
        constraints.gridx = 1;
        subPanel.add(outputFile, constraints);
        constraints.gridx = 2;
        subPanel.add(chooseOutput, constraints);
        constraints.gridx = 3;
        subPanel.add(ciphersCombo, constraints);
        constraints.gridx = 4;
        subPanel.add(decodeButton, constraints);
        constraints.gridx = 1;
        return subPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //tosamo co     e.getActionCommand().equalsIgnoreCase("exit");
    if("exit".equalsIgnoreCase(e.getActionCommand())){//tak jest lepeiej bo w przypadku nulla z actionlistenera nie wykrzaczy programu
        System.exit(0);
    }
    }
}
