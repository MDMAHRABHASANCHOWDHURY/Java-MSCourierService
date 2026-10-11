package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class  Receiver extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel labelpanel;
	private JLabel lebelUsername;
	private JLabel lebelPassword;
	private JLabel lebelDepartment;
	private JTextField textuser;
	private JTextField textuser1;
	private JTextField textArea;
	private JTextField textEmail;

	private JButton buttonNext;
	private JButton buttonBack;
	private JComboBox<String> departmentDropDownlist;
	private JLabel image;


	
	public Receiver()
	{
		this.initializeComponents();
		this.setTitle("My Basic Info");
		this.setSize(1095,540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initializeComponents()
	{
	
		this.panel=new JPanel(null);

		this.labelpanel=new JLabel("RECEIVER DETAILS");
		this.labelpanel.setBounds(380,20,400,40);
		labelpanel.setFont(new Font("Calibri",Font.BOLD,30));
		labelpanel.setForeground(Color.BLUE );
		this.panel.add(this.labelpanel);
		
		this.lebelUsername=new JLabel("RECEIVER NAME");
		this.lebelUsername.setBounds(20,80,250,40);
		lebelUsername.setFont(new Font("Calibri",Font.BOLD,30));
		this.panel.add(this.lebelUsername);
		
		this.textuser=new JTextField();
		this.textuser.setBounds(420,80,400,30);
		this.panel.add(this.textuser);
		
		this.lebelPassword=new JLabel("NUMBER");
		this.lebelPassword.setBounds(20,140,200,40);
		lebelPassword.setFont(new Font("Calibri",Font.BOLD,30));
		this.panel.add(this.lebelPassword);
		
				
		this.textuser1=new JTextField();
		this.textuser1.setBounds(420,140,400,30);
		this.panel.add(this.textuser1);
			
		
		this.lebelPassword=new JLabel("EMAIL");
		this.lebelPassword.setBounds(20,200,200,40);
		lebelPassword.setFont(new Font("Calibri",Font.BOLD,30));
		this.panel.add(this.lebelPassword);
		
		this.textEmail=new JTextField();
		this.textEmail.setBounds(420,200,400,30);
		this.panel.add(this.textEmail);
		
		this.lebelDepartment=new JLabel("SHIPPING AREA");
		this.lebelDepartment.setBounds(20,260,300,40);
		lebelDepartment.setFont(new Font("Calibri",Font.BOLD,30));
		this.panel.add(this.lebelDepartment);
		
		String []Departments=new String[]{"DHAKA","RANGPUR","RAJSHAHI","CHITTAGONG","SYLHET","BARISHL","MYMENSINGH","KHULNA",""};
		this.departmentDropDownlist=new JComboBox<>(Departments);
		this.departmentDropDownlist.setBounds(420,260,400,30);
		departmentDropDownlist.setFont(new Font("Calibri",Font.BOLD,24));
		this.panel.add(this.departmentDropDownlist);
		
		
		this.lebelPassword=new JLabel("ADDRESS");
		this.lebelPassword.setBounds(20,320,120,40);
		lebelPassword.setFont(new Font("Calibri",Font.BOLD,30));
		this.panel.add(this.lebelPassword);
		
		this.textArea=new JTextField();
		this.textArea.setBounds(420,320,400,30);
		this.panel.add(this.textArea);
		
	
		this.buttonNext=new JButton("NEXT");
		this.buttonNext.setBounds(220,420,225,60);
		buttonNext.setFont(new Font("Calibri",Font.BOLD,40));
		buttonNext.setForeground(Color.black);
		buttonNext.setBackground(Color.GREEN);
		this.buttonNext.addActionListener(this);
		this.panel.add(this.buttonNext);

		this.buttonBack=new JButton("BACK");
		this.buttonBack.setBounds(650,420,225,60);
		buttonBack.setFont(new Font("Calibri",Font.BOLD,40));
		buttonBack.setForeground(Color.white);
		buttonBack.setBackground(Color.RED);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
			
		ImageIcon imageIcon = new ImageIcon(".\\Image\\Receiver.jpg");
		this.image = new JLabel(imageIcon);
		this.image.setBounds(0, 0, 1080, 540);
		this.panel.add(this.image);
		
		
		this.add(this.panel);
		
	}
	
	public void actionPerformed(ActionEvent e){


		String buttonBack =e.getActionCommand();

		
		if (buttonBack.equals("BACK"))
		{
			new SenderFrame();
			dispose();
		}
			
		
		
		else if (buttonBack.equals("NEXT"))
		{

			String receiver =textuser.getText();
			String number = textuser1.getText();
			String email = textEmail.getText();
			String address =textArea.getText();
			String division = (String) departmentDropDownlist.getSelectedItem();

			if (!receiver.isEmpty() && !number.isEmpty() && !email.isEmpty() && !address.isEmpty()&&!division.isEmpty())
				{
					try {
						File file = new File(".\\Data\\ReceiverDetails.txt");
						if (!file.exists()) {
							file.createNewFile();
						}
	
						FileWriter fw = new FileWriter(file, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						pw.println("FULL NAME         " + receiver);
						pw.println("NID               " + number);
						pw.println("PHONE NUMBER      " + email);
						pw.println("DELIVERY AREA     " + division);
						pw.println("EMAIL             " + address);
						pw.println("===============================================");
						pw.close();

						textuser.setText("null");
						textuser1.setText("null");
						textArea.setText("null");
						departmentDropDownlist.setSelectedItem("null");
						textEmail.setText("null");

						

						new Payment();
						dispose();
					} 
					catch (Exception ex) 
					{
						System.out.print(ex);
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				}
				
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter valid information in all fields");
				}
			}
			 else
				{
				new SenderFrame();
				dispose();
				}
		}
	}

