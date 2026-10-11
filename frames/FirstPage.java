package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.ImageIcon;

public class FirstPage extends JFrame implements ActionListener {
    private JPanel panel;

    private JButton buttonCancle;
    private JButton buttonOK;
    private JLabel lebelUsername;
    private JLabel image;

    public FirstPage() {
        this.initializeComponents();
        this.setTitle("MS COURIER SERVICE");
        this.setSize(1095, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.panel = new JPanel(null);

        this.lebelUsername = new JLabel("WELCOME TO MS COURIER SERVICE");
        this.lebelUsername.setBounds(100, 55, 1080, 65);
        lebelUsername.setFont(new Font("Calibri", Font.BOLD, 60));
        lebelUsername.setForeground(Color.red);
        this.panel.add(this.lebelUsername);

        this.buttonOK = new JButton("SIGNUP");
        this.buttonOK.setBounds(280, 300, 200, 50);
        buttonOK.setFont(new Font("Calibri", Font.BOLD, 40));
        buttonOK.setForeground(Color.WHITE);
        buttonOK.setBackground(new Color(102,255,255));
        this.buttonOK.addActionListener(this);
        this.panel.add(this.buttonOK);

        this.buttonOK = new JButton("LOGIN");
        this.buttonOK.setBounds(580, 300, 200, 50);
        this.buttonOK.addActionListener(this);
        buttonOK.setBackground(Color.GREEN);
        buttonOK.setForeground(Color.white);
        buttonOK.setFont(new Font("Calibri", Font.BOLD, 40));
        this.panel.add(this.buttonOK);

        this.buttonCancle = new JButton("EXIT"); 
        this.buttonCancle.setBounds(850, 620, 200, 50);
        buttonCancle.setBackground(Color.RED);
        buttonCancle.setForeground(Color.white);
        buttonCancle.setFont(new Font("Calibri", Font.BOLD, 40));
        this.buttonCancle.addActionListener(this);
        this.panel.add(this.buttonCancle);

        ImageIcon imageIcon = new ImageIcon(".\\Image\\FIRSTPAGE.jpg");
        this.image = new JLabel(imageIcon);
        this.image.setBounds(0, 0, 1080, 720);
        this.panel.add(this.image);

        this.add(this.panel);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if (buttonText.equals("EXIT")) {
            System.exit(0);
        } else if (buttonText.equals("LOGIN")) {
            new Login();
            dispose();
        } else {
            new Registration();
            dispose();
        }
    }
}
