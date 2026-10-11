package frames;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class OtpFrame extends JFrame
	{
		private JPanel panel;
		private JLabel lebelM1;
		private JTextField textuser;
		private JButton buttonConfirm;
		private JLabel image;
		
		public OtpFrame()
			{
				this.initializeComponents();
				this.setTitle("ENTER YOUR OTP");
				this.setSize(480,358);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
			}
		
		private void initializeComponents()
			{
				this.panel=new JPanel(null);
				
				this.lebelM1=new JLabel("ENTER OTP");
				this.lebelM1.setBounds(160,20,200,40);
				lebelM1.setFont(new Font("Calibri",Font.BOLD,30));
				lebelM1.setForeground(Color.WHITE);
				this.panel.add(this.lebelM1);
				
				this.textuser=new JTextField();
				this.textuser.setBounds(110,80,250,40);
				textuser.setFont(new Font("Calibri",Font.PLAIN,30));
				textuser.setBackground(Color.WHITE);
				this.panel.add(this.textuser);

				this.buttonConfirm=new JButton("CONFIRM PAYMENT");
				this.buttonConfirm.setBounds(110,200,250,40);
				buttonConfirm.setFont(new Font("Calibri",Font.BOLD,25));
				buttonConfirm.setForeground(Color.white);
				buttonConfirm.setBackground(Color.cyan);
				this.panel.add(this.buttonConfirm);
				

				ImageIcon image= new ImageIcon(".\\Image\\Otp.jpg");
				this.image = new JLabel(image);
				this.image.setBounds(0, 0, 480, 320);
				this.panel.add(this.image);

				
				this.add(this.panel);
			}
		
	}