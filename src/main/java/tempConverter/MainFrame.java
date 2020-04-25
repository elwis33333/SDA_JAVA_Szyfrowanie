package tempConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private JFrame frame;
    private JTextField inputFiled;
    private JLabel fahrenheitLabel;
    private JButton buton1;

    public void showGuiWindow() {
        frame = new JFrame("Celcius Coverter");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
        addActionToConverterBtn();
        //frame.setSize(600, 200);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        /* //lub to
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()-frame.getWidth())/2, (int)(screenSize.getHeight()-frame.getHeight())/2);
*/
    }

    private void addActionToConverterBtn() {
        buton1.addActionListener(this);
    }

    private void addComponents() {
        inputFiled = new JTextField();
        JLabel celciusLabel = new JLabel("Celcius"); //nie wchodzimy z nią w interakcję więc może ona być lokalna
        fahrenheitLabel = new JLabel("Fahrenheit");
        buton1 = new JButton("Convert");
        Insets style = new Insets(5,10,5,10);
        JPanel panel = new JPanel();
        /*panel.add(inputFiled);
        panel.add(celciusLabel);
        panel.add(buton1);
        panel.add(fahrenheitLabel);*/
        //układ leyaut
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(layout);
        c.fill = GridBagConstraints.HORIZONTAL;   ///tak jest dla kazdego
        c.insets = style;                         ///tak jest dla kazdego
        c.gridx = 0;
        c.gridy = 0;
        panel.add(inputFiled, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(celciusLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(buton1, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(fahrenheitLabel, c);



        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //c*1,8+32->F
        double cels = Double.parseDouble(inputFiled.getText());
        double far = cels*1.8+32;
        String temp = String.format("%.2f Farenheit",far);
        System.out.println(temp);
        fahrenheitLabel.setText(temp);
        frame.pack();
    }
}
