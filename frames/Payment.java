package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.awt.*;



public class Payment extends JFrame implements ActionListener 
{
	  private JPanel panel;
	  
	  private JLabel labeleCash;
	  private JLabel fullfill;
	  private JLabel Crd;
	  private JLabel labelCN;
	  private JLabel labelN;
	  private JLabel top;
	  private JLabel Cnum;
	  private JLabel CVV;
	  private JComboBox<String> monthComboBox;
 	  private JComboBox<Integer> yearComboBox;

	  private JTextField textUser;
	  private JPasswordField textEmail;
	  private JTextField textP;
	  private JTextField textConfirm;
	  private JButton buttonConfirm;
	  private JButton buttonPrevious;
	  private JButton buttonExit;
	 
	  private JLabel image;
	  private JLabel image1;
	  private JLabel image2;


		public Payment() 
		{
			this.initializeComponents();
			this.setTitle("Payment Page");
			this.setSize(900, 1286);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}

		private void initializeComponents()
		{

			this.panel = new JPanel(null);

			this.top=new JLabel("PAY YOUR BILL");
			this.top.setBounds(320,30,300,40);
			top.setFont(new Font("Calibri",Font.BOLD,38));
			top.setForeground(Color.black);

			this.panel.add(this.top);

			this.labeleCash=new JLabel("WE ACCPT  ONLINE PAYMENT ONLY");
			this.labeleCash.setBounds(150,108,450,30);
			labeleCash.setFont(new Font("Calibri",Font.BOLD,30));
			labeleCash.setForeground(Color.BLACK);
			this.panel.add(this.labeleCash);

			ImageIcon imagemaster= new ImageIcon(".\\Image\\MasterCard.png");
			this.image1 = new JLabel(imagemaster);
			this.image1.setBounds(608, 100, 67, 38);
			this.panel.add(this.image1);

			ImageIcon imagevisa= new ImageIcon(".\\Image\\Visa.png");
			this.image2 = new JLabel(imagevisa);
			this.image2.setBounds(678, 100, 67,38);
			this.panel.add(this.image2);

			this.fullfill=new JLabel("FILL YOUR CARD INFO");
			this.fullfill.setBounds(320,148,400,50);
			fullfill.setFont(new Font("Calibri",Font.BOLD,23));
			fullfill.setForeground(Color.BLACK);
			this.panel.add(this.fullfill);


			this.Crd=new JLabel("NAME ON CARD:");
			this.Crd.setBounds(20,275,260,30);
			Crd.setForeground(Color.WHITE);
			this.panel.add(this.Crd);
			Crd.setFont(new Font("Calibri",Font.BOLD,30));


			this. textUser=new JTextField();
			this.textUser.setBounds(290,275,500,30);
			textUser.setFont(new Font("Calibri",Font.PLAIN,20));
			textUser.setBackground(Color.WHITE);
			this.panel.add(this.textUser);

			this.labelN=new JLabel("ENTER THE 16-DIGIT CARD NUMBER ON THE CARD  ");
			this.labelN.setBounds(20,325,700,30);
			labelN.setFont(new Font("Calibri",Font.BOLD,12));
			labelN.setForeground(Color.GREEN);
			this.panel.add(this.labelN);

			this.labelCN=new JLabel("CARD NUMBER :");
			this.labelCN.setBounds(20,350,270,30);
			labelCN.setFont(new Font("Calibri",Font.BOLD,30));
			labelCN.setForeground(Color.WHITE);
			this.panel.add(this.labelCN);

			this.textP=new JTextField();
			this.textP.setBounds(290,350,500,30);
			textP.setFont(new Font("Calibri",Font.PLAIN,20));
			textP.setBackground(Color.WHITE);
			this.panel.add(this.textP);

			this.Cnum = new JLabel("EXPIRE DATE:");
			this.Cnum.setBounds(20, 425, 350, 30);
   			Cnum.setForeground(Color.WHITE);
   			this.panel.add(this.Cnum);
    		Cnum.setFont(new Font("Calibri", Font.BOLD, 30));

  
   			String[] months = { "JAN", "FEB", "MAR", "APRIL", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
    		this.monthComboBox = new JComboBox<>(months);
    		this.monthComboBox.setBounds(290, 425, 80, 30);
    		this.monthComboBox.setFont(new Font("Calibri", Font.PLAIN, 20));
    		this.panel.add(this.monthComboBox);

   
    		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
   			Integer[] years = new Integer[10];
   			for (int i = 0; i < years.length; i++) 
			{
      			years[i] = currentYear + i;
    		}

    		this.yearComboBox = new JComboBox<>(years);
   			this.yearComboBox.setBounds(380, 425, 100, 30);
   			this.yearComboBox.setFont(new Font("Calibri", Font.PLAIN, 20));
    		this.panel.add(this.yearComboBox);

			this.CVV=new JLabel("CVV NUMBER:");
			this.CVV.setBounds(20,500,200,30);
			CVV.setForeground(Color.WHITE);
			this.panel.add(this.CVV);
			CVV.setFont(new Font("Calibri",Font.BOLD,30));


			this.textEmail=new JPasswordField();
			this.textEmail.setBounds(290,500,250,30);
			textEmail.setFont(new Font("Calibri",Font.PLAIN,20));
			textEmail.setBackground(Color.WHITE);
			this.panel.add(this.textEmail);


			this.buttonConfirm=new JButton("SEND OTP");
			this.buttonConfirm.setBounds(20,575,380,50);
			buttonConfirm.setFont(new Font("Calibri",Font.BOLD,25));
			buttonConfirm.setForeground(Color.DARK_GRAY);
			buttonConfirm.setBackground(Color.GREEN);
			this.buttonConfirm.addActionListener(this);
			this.panel.add(this.buttonConfirm);

			this.buttonPrevious=new JButton("PREVIOUS");
			this.buttonPrevious.setBounds(490,575,380,50);
			buttonPrevious.setFont(new Font("Calibri",Font.BOLD,20));
			buttonPrevious.setForeground(Color.DARK_GRAY);
			buttonPrevious.setBackground(Color.PINK);
			this.buttonPrevious.addActionListener(this);
			this.panel.add(this.buttonPrevious);

			this.buttonExit=new JButton("EXIT");
			this.buttonExit.setBounds(650,920,220,50);
			buttonExit.setFont(new Font("Calibri",Font.BOLD,20));
			buttonExit.setForeground(Color.white);
			buttonExit.setBackground(Color.RED);
			this.buttonExit.addActionListener(this);
			this.panel.add(this.buttonExit);


			ImageIcon image= new ImageIcon(".\\Image\\Payment.jpg");
			this.image = new JLabel(image);
			this.image.setBounds(0, 0, 900, 1286);
			this.panel.add(this.image);


			this.add(this.panel);


		}

		public void actionPerformed(ActionEvent EX) {
			Object source = EX.getSource();
		
			if (source == buttonConfirm) 
			{
				String cardname = textUser.getText();
				String cardnum = textP.getText();
				char[] cvvChars = textEmail.getPassword();
				String cvv = new String(cvvChars);
				String selectedMonth = (String) monthComboBox.getSelectedItem();
				int selectedYear = (int) yearComboBox.getSelectedItem();
				String expire = selectedMonth + "/" + selectedYear;
		
				if (cardname.isEmpty() == false && cardnum.isEmpty() == false && expire.isEmpty() == false && cvv.isEmpty() == false) {
					if(cardnum.matches("\\d+"))
					{
					try {
						File file = new File(".\\Data\\PaymentData.txt");
						if (!file.exists()) 
						{
							file.createNewFile();
						}
						FileWriter fw = new FileWriter(file, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						pw.println("CARD NAME    : " + cardname);
						pw.println("CARD NUMBER  : " + cardnum);
						pw.println("EXPIRE DATE  : " + expire);
						pw.println("CVV NUMBER   : " + cvv);
						pw.println("===============================================");
						pw.close();
		
						textUser.setText(null);
						textP.setText(null);
						textConfirm.setText(null);
						textEmail.setText(null);
		
					}
					catch (Exception ex) 
					{
						System.out.print(ex);
					}
					int option = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO PROCEED");
					if (option == JOptionPane.YES_OPTION) 
					{
						new OtpFrame();
						dispose();
					}
				} 
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid card number. Please enter only digits.");
				}
			}
		
			} 
			else if (source == buttonPrevious) 
			{
				new Receiver();
				dispose();
			} 
			else if (source == buttonExit) 
			{
				System.exit(0);
			}
		}
		
}
