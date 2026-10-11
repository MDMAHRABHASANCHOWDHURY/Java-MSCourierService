package frames;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame implements ActionListener{
  private JPanel panel;
  private Font f;

  private JLabel labelUsername;
  private JLabel labelPassword;
  private JLabel labelConfirm;
  private JLabel labelEmail;
  private JLabel top;
  
  private JTextField textUser;
  private JPasswordField textPassword;
  private JPasswordField textConfirm;
  private JTextField textEmail;
  private JButton buttonBack;
  private JButton buttonConfirm;
  private JButton buttonExit;
 
 
  private JLabel image;

  public Registration() {
    this.initializeComponents();
    this.setTitle("REGISTRATION PAGE");
    this.setSize(800, 900);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    
  }

private void initializeComponents(){

  this.panel = new JPanel(null);
  f=new Font("Time New Roman",Font.BOLD,20);

this.top=new JLabel("PLEASE SIGN UP");
this.top.setBounds(240,130,300,40);
top.setFont(new Font("Calibri",Font.BOLD,38));
top.setForeground(Color.white);

this.panel.add(this.top);

this.labelUsername=new JLabel("USERNAME");
this.labelUsername.setBounds(50,245,150,35);
labelUsername.setFont(new Font("Calibri",Font.BOLD,25));
labelUsername.setForeground(Color.BLACK);
this.panel.add(this.labelUsername);

this. textUser=new JTextField();
this.textUser.setBounds(290,240,250,35);
textUser.setFont(new Font("Calibri",Font.PLAIN,20));
textUser.setBackground(Color.WHITE);
this.panel.add(this.textUser);

this.labelPassword=new JLabel("PASSWORD");
this.labelPassword.setBounds(50,300,150,50);
labelPassword.setFont(new Font("Calibri",Font.BOLD,25));
labelPassword.setForeground(Color.BLACK);
this.panel.add(this.labelPassword);

this.textPassword=new JPasswordField();
this.textPassword.setBounds(290,308,250,35);
textPassword.setFont(new Font("Calibri",Font.PLAIN,20));
textPassword.setBackground(Color.WHITE);
this.panel.add(this.textPassword);

this.labelConfirm=new JLabel("CONFIRM PASSWORD");
this.labelConfirm.setBounds(50,380,280,35);
labelConfirm.setForeground(Color.BLACK);
this.panel.add(this.labelConfirm);
labelConfirm.setFont(new Font("Calibri",Font.BOLD,25));

this.textConfirm=new JPasswordField();
this.textConfirm.setBounds(290,370,250,35);
textConfirm.setFont(new Font("Calibri",Font.PLAIN,20));
textConfirm.setBackground(Color.WHITE);
this.panel.add(this.textConfirm);

this.labelEmail=new JLabel("EMAIL ADDRESS");
this.labelEmail.setBounds(50,440,280,30);
labelEmail.setFont(new Font("Calibri",Font.BOLD,25));
labelEmail.setForeground(Color.BLACK);
this.panel.add(this.labelEmail);

this.textEmail=new JTextField();
this.textEmail.setBounds(290,435,250,35);
textEmail.setFont(new Font("Calibri",Font.PLAIN,15));
textEmail.setBackground(Color.WHITE);
this.panel.add(this.textEmail);

this.buttonBack=new JButton("BACK");
this.buttonBack.setBounds(200,600,150,30);
buttonBack.setFont(f);
buttonBack.setForeground(Color.WHITE);
buttonBack.setBackground(Color.BLUE);
this.buttonBack.addActionListener(this);
this.panel.add(this.buttonBack);

this.buttonConfirm=new JButton("CONFIRM");
this.buttonConfirm.setBounds(450,600,150,30);
buttonConfirm.setFont(f);
buttonConfirm.setForeground(Color.BLACK);
buttonConfirm.setBackground(Color.GREEN);
this.buttonConfirm.addActionListener(this);
this.panel.add(this.buttonConfirm);

this.buttonExit=new JButton("EXIT");
this.buttonExit.setBounds(320,700,150,30);
buttonExit.setFont(f);
buttonExit.setForeground(Color.WHITE);
buttonExit.setBackground(Color.RED);
this.buttonExit.addActionListener(this);
this.panel.add(this.buttonExit);

ImageIcon imageIcon = new ImageIcon(".\\Image\\registration.jpg");
    this.image = new JLabel(imageIcon);
    this.image.setBounds(0, 0, 800, 950);
    this.panel.add(this.image);


this.add(this.panel);
   
    }
	
  public void actionPerformed(ActionEvent e){
    String buttonText = e.getActionCommand();
	
    if(buttonText.equals("EXIT")){
      System.exit(0);
    }
	else if(buttonText.equals("BACK")){
      new FirstPage();
      dispose();
    }
    else if(buttonText.equals("CONFIRM"))
	{
			String username = textUser.getText();
      char[] passwordChars = textPassword.getPassword();
      String pass = new String(passwordChars);
      char[] confirmPassChars = textConfirm.getPassword();
      String confirmPass = new String(confirmPassChars);
      
      String sEmail = textEmail.getText();
			
			if (username.isEmpty()==false && pass.isEmpty()==false && sEmail.isEmpty()==false && sEmail.isEmpty()==false)
			{
				
				if (confirmPass.equals(pass)) 
				{
					try {
                    	File file = new File(".\\Data\\history.txt");
                    	if (!file.exists()) {
                        	file.createNewFile();
                    	}
                    	FileWriter fw = new FileWriter(file, true);
                    	BufferedWriter bw = new BufferedWriter(fw);
                    	PrintWriter pw = new PrintWriter(bw);
                    	pw.println("User Name : " + username);
                    	pw.println("Password : " + pass);
                    	pw.println("Email : " + sEmail);
						pw.println("===============================================");
                    	pw.close();
                    	
                    	JOptionPane.showMessageDialog(null, "New User Created Successfully.", "User created",JOptionPane.INFORMATION_MESSAGE);
                    	
                      textUser.setText(null);

                      textPassword.setText(null);
                    	textConfirm.setText(null);
                    	textEmail.setText(null);
					}
					
					catch (Exception ex) 
          {
						System.out.print(ex);
						JOptionPane.showMessageDialog(null,"Something Went wrong");
				  }
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Password didn't match");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter valid information in the fields");
			}
      
	{
      new FirstPage();
      dispose();
  
    }

   }
    
  }
}