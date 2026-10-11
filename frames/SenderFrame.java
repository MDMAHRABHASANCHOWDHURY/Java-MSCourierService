package frames;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
	  
import javax.swing.ImageIcon;

public class SenderFrame extends JFrame implements ActionListener

{
	private JPanel panel;
	private JLabel labelpanel;
	private JLabel labelfullname;
	private JTextField fullname;
	private JLabel labelnid;
	private JLabel labelphonenum;
	private JLabel labelcourierID;
	private JLabel  labelemail;
	private JTextField email;
	private JLabel labeldivision;
	private JComboBox<String> division;
	private JLabel labelproducttype;
	private JComboBox<String> producttype;
	private JLabel  labeladdress;
	private JTextArea address;
	private JLabel  labelsize;
	private JButton buttoncancel;
	private JButton buttonconfirm;
	private JLabel image;
	private JLabel labelCourierWeight;
	private JLabel labelCourierQuantity;
	private NumberTextField nid;
	private NumberTextField phonenum;
	private NumberTextField courierID;
	private NumberTextField courierQuantity;
	private NumberTextField courierWeight;
	private NumberTextField size;





	public SenderFrame()
	{
		this.initializeComponents();
		this.setTitle("Sender Frame");
		this.setSize(1095, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  
	}
	
	public void initializeComponents()
	{
		this.panel=new JPanel(null);
		this.labelpanel=new JLabel("SENDER DETAILS");
		this.labelpanel.setBounds(440,20,400,50);
		labelpanel.setFont(new Font("Calibri",Font.BOLD,40));
		labelpanel.setForeground(Color.black);
		this.panel.add(this.labelpanel);
		
		this.labelfullname=new JLabel("FULL NAME");
		this.labelfullname.setBounds(20,100,200,40);
		labelfullname.setFont(new Font("Calibri",Font.BOLD,28));
		labelfullname.setForeground(Color.black);
		this.panel.add(this.labelfullname);
		
		this.fullname=new JTextField();
		this.fullname.setBounds(320,100,500,30);
		this.panel.add(this.fullname);

		this.labelnid=new JLabel("NID ");
		this.labelnid.setBounds(20,150,100,40);
		labelnid.setFont(new Font("Calibri",Font.BOLD,28));
		labelnid.setForeground(Color.black);
		this.panel.add(this.labelnid);
		
		this.nid=new NumberTextField();
		this.nid.setBounds(320,150,500,30);
		this.panel.add(this.nid);

		this.labelphonenum=new JLabel("PHONE NUMBER");
		this.labelphonenum.setBounds(20,200,200,40);
		labelphonenum.setFont(new Font("Calibri",Font.BOLD,28));
		labelphonenum.setForeground(Color.black);
		this.panel.add(this.labelphonenum);
		
		this.phonenum=new NumberTextField();
		this.phonenum.setBounds(320,200,500,30);
		this.panel.add(this.phonenum);
 
		this.labelemail=new JLabel("EMAIL");
		this.labelemail.setBounds(20,250,100,40);
		labelemail.setFont(new Font("Calibri",Font.BOLD,28));
		labelemail.setForeground(Color.black);
		this.panel.add(this.labelemail);
		
		this.email=new JTextField();
		this.email.setBounds(320,250,500,30);
		this.panel.add(this.email);

		this.labeldivision=new JLabel("PICKUP AREA");
		this.labeldivision.setBounds(20,300,200,40);
		labeldivision.setFont(new Font("Calibri",Font.BOLD,28));
		labeldivision.setForeground(Color.black);
		this.panel.add(this.labeldivision);
		
		String[] Divisions = new String[]{"Dhaka","Chattogram","Barishal","Rajshahi","Rangpur","Sylhet","Khulna","Mymensingh"};
		
		this.division=new JComboBox<>(Divisions);
		this.division.setBounds(320,300,500,30);
		division.setFont(new Font("Calibri",Font.PLAIN,24));
		this.panel.add(this.division);

		this.labeladdress=new JLabel("ADDRESS");
		this.labeladdress.setBounds(20,350,200,40);
		labeladdress.setFont(new Font("Calibri",Font.BOLD,28));
		this.panel.add(this.labeladdress);
		
		this.address=new JTextArea();
		this.address.setBounds(320,350,500,30);
		this.panel.add(this.address);

		this.labelproducttype=new JLabel("PRODUCT TYPE");
		this.labelproducttype.setBounds(20,400,200,40);
		labelproducttype.setFont(new Font("Calibri",Font.BOLD,28));
		this.panel.add(this.labelproducttype);
		
		String[] Type = new String[]{"Electronics","Glass","Clothes","Metal","Antique Pieces","'Jwellary"};
		
		this.producttype=new JComboBox<>(Type);
		this.producttype.setBounds(320,400,500,30);
		producttype.setFont(new Font("Calibri",Font.PLAIN,24));
		this.panel.add(this.producttype);

		this.labelsize=new JLabel("PRODUCT SIZE");
		this.labelsize.setBounds(20,450,200,40);
		labelsize.setFont(new Font("Calibri",Font.BOLD,28));
		this.panel.add(this.labelsize);
		
		this.size=new NumberTextField();
		this.size.setBounds(320,450,500,30);
		this.panel.add(this.size);

		this.labelcourierID=new JLabel("COURIER ID ");
		this.labelcourierID.setBounds(20,500,200,40);
		labelcourierID.setFont(new Font("Calibri",Font.BOLD,28));
		this.panel.add(this.labelcourierID);
		
		this.courierID=new NumberTextField();
		this.courierID.setBounds(320,500,500,30);
		this.panel.add(this.courierID);

		this.labelCourierWeight = new JLabel("COURIER WEIGHT");
		this.labelCourierWeight.setBounds(20, 550, 240, 40);
		labelCourierWeight.setFont(new Font("Calibri",Font.BOLD,28));
		this.panel.add(this.labelCourierWeight);
		
		this.courierWeight = new NumberTextField();
		this.courierWeight.setBounds(320, 550, 500, 30);
		this.panel.add(this.courierWeight);
		
		this.labelCourierQuantity = new JLabel("COURIER QUANTITY");
		this.labelCourierQuantity.setBounds(20, 600, 240, 40);
		labelCourierQuantity.setFont(new Font("Calibri",Font.BOLD,28));
		this.panel.add(this.labelCourierQuantity);
		
		this.courierQuantity = new NumberTextField();
		this.courierQuantity.setBounds(320, 600, 500, 30);
		this.panel.add(this.courierQuantity);
		

		this.buttonconfirm=new JButton("NEXT");
		this.buttonconfirm.setBounds(150, 820, 300, 40);
		buttonconfirm.setFont(new Font("Calibri",Font.BOLD,28));
		buttonconfirm.setForeground(Color.DARK_GRAY);
		buttonconfirm.setBackground(Color.GREEN);
		this.buttonconfirm.addActionListener(this);
		this.panel.add(this.buttonconfirm);
		
		this.buttoncancel=new JButton("BACK");
		this.buttoncancel.setBounds(550, 820, 300, 40);
		buttoncancel.setFont(new Font("Calibri",Font.BOLD,28));
		buttoncancel.setForeground(Color.DARK_GRAY);
		buttoncancel.setBackground(Color.RED);
		this.buttoncancel.addActionListener(this);
		this.panel.add(this.buttoncancel);


		ImageIcon imageIcon = new ImageIcon(".\\Image\\Sender.jpg");
		this.image = new JLabel(imageIcon);
		this.image.setBounds(0, 0, 1080,1080);
		this.panel.add(this.image);

		this.add(this.panel);

		}

		public class NumberTextField extends JTextField 
		{
			public NumberTextField() 
			{
				setDocument(new NumericDocument());
			}
		
			private class NumericDocument extends PlainDocument 
			{
			
				public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
					if (str == null) 
					{
						return;
					}
		
					try 
					{
						Integer.parseInt(str);
						super.insertString(offs, str, a);
					} 
					catch (NumberFormatException e) 
					{
						System.out.print(e);
					}
				}
			}
		}

		
		public void actionPerformed(ActionEvent e) {
			String buttonconfirm = e.getActionCommand();
	
			if (buttonconfirm.equals("NEXT")) {
				String fullnameA = fullname.getText();
				String nidA = nid.getText();
				String phonenumberA = phonenum.getText();
				String emailA = email.getText();
				String pareaA = division.getSelectedItem().toString();
				String addressA = address.getText();
				String ptypeA = producttype.getSelectedItem().toString();
				String psizeA = size.getText();
				String pcourierID = courierID.getText();
				String pcourierquantity = courierQuantity.getText();
				String pcourierweight =courierWeight.getText();


	
				if (!fullnameA.isEmpty() && !nidA.isEmpty() && !phonenumberA.isEmpty() && !emailA.isEmpty() &&
					!pareaA.isEmpty() && !addressA.isEmpty() && !ptypeA.isEmpty() && !psizeA.isEmpty()&& !pcourierID.isEmpty()&&
					!pcourierquantity.isEmpty() && !pcourierweight.isEmpty()) {
	
					try {
						File file = new File(".\\Data\\SenderDetails.txt");
						if (!file.exists()) {
							file.createNewFile();
						}
	
						FileWriter fw = new FileWriter(file, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						pw.println("FULL NAME        " + fullnameA);
						pw.println("NID              " + nidA);
						pw.println("PHONE NUMBER     " + phonenumberA);
						pw.println("EMAIL            " + emailA);
						pw.println("DIVISION         " + pareaA);
						pw.println("ADDRESS          " + addressA);
						pw.println("PRODUCT TYPE     " + ptypeA);
						pw.println("PRODUCT SIZE     " + psizeA);
						pw.println("===============================================");
						pw.println("COURIER ID       " +pcourierID);
						pw.println("COURIER QUANTITY "+pcourierquantity);
						pw.println("COURIER WEIGHT   "+pcourierweight);
						pw.println("===============================================");
						pw.close();
	
						
						fullname.setText("null");
						nid.setText("null");
						phonenum.setText("null");
						email.setText("null");
						division.setSelectedItem("null");
						address.setText("null");
						producttype.setSelectedItem("null");
						size.setText("null");
						courierID.setText("null");
						courierQuantity.setText("null");
						courierWeight.setText("null");



						
	
						
						new Receiver();
						dispose();
					} catch (Exception ex) {
						System.out.print(ex);
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter valid information in all fields");
				}
			} else {
				new HomePage();
				dispose();
			}
		}
	}
