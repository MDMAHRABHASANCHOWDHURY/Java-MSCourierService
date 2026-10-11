package frames;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import javax.swing.JPanel;
	import javax.swing.ImageIcon;
	import java.awt.event.ActionListener;
	import java.io.FileReader;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.awt.event.ActionEvent;
	import java.awt.*;
	import java.io.BufferedReader;

	import java.awt.Font;



	public class  Login extends JFrame implements ActionListener
	{
		private JPanel panel;
		private JLabel lebelUsername;
		private JLabel lebelPassword;
		private JTextField textuser;
		private JPasswordField textPassword;
		private JButton buttonLogin;
		private JButton buttonBack;
		private JLabel image;
		

		
		public Login()
		{
			this.initializeComponents();
			this.setTitle("MS COURIER SERVICE");
			this.setSize(735,720);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
		private void initializeComponents()
		{
			this.panel=new JPanel(null);
			
			this.lebelUsername=new JLabel("NEED TO LOG IN");
			this.lebelUsername.setBounds(110,40,500,70);
			lebelUsername.setFont(new Font("Calibri",Font.BOLD,65));
			lebelUsername.setForeground(Color.red);
			this.panel.add(this.lebelUsername);

			
			
			this.lebelUsername=new JLabel("USERNAME");
			this.lebelUsername.setBounds(20,200,500,45);
			lebelUsername.setFont(new Font("Calibri", Font.PLAIN, 40));
        	lebelUsername.setForeground(new Color(102,255,255));
			this.panel.add(this.lebelUsername);

			this.textuser=new JTextField();
			this.textuser.setBounds(230,200,300,45);
			textuser.setForeground(Color.BLACK);
			textuser.setBackground(Color.WHITE);
			this.panel.add(this.textuser);		
			
			this.lebelPassword=new JLabel("PASSWORD");
			this.lebelPassword.setBounds(20,300,390,45);
			lebelPassword.setFont(new Font("Calibri", Font.PLAIN, 40));
        	lebelPassword.setForeground(new Color(102,255,255));
			this.panel.add(this.lebelPassword);	

			this.textPassword=new JPasswordField();
			this.textPassword.setBounds(230,300,300,45);
			textPassword.setForeground(Color.BLACK);
			textPassword.setBackground(Color.WHITE);
			this.panel.add(this.textPassword);		
			
			
			this.buttonLogin=new JButton("LOGIN");
			this.buttonLogin.setBounds(100,520,200,60);
			this.buttonLogin.addActionListener(this);
			buttonLogin.setBackground(Color.GREEN);
			buttonLogin.setFont(new Font("Calibri", Font.BOLD, 40));
			buttonLogin.setForeground(Color.white);
			this.panel.add(this.buttonLogin);
			
				
			this.buttonBack=new JButton("BACK");
			this.buttonBack.setBounds(420,520,200,60);
			this.buttonBack.addActionListener(this);
			buttonBack.setBackground(Color.RED);
			buttonBack.setForeground(Color.white);
			buttonBack.setFont(new Font("Calibri", Font.BOLD, 40));
			this.panel.add(this.buttonBack);

			
			ImageIcon imageIcon = new ImageIcon(".\\Image\\login.jpg");
			this.image = new JLabel(imageIcon);
			this.image.setBounds(0, 0, 720, 720);
			this.panel.add(this.image);
				

			this.add(this.panel);
			
		}
		
		
		public void actionPerformed(ActionEvent e)
		{
			String buttonText = e.getActionCommand();
			String buttonLogin =e.getActionCommand();
			
				if(buttonLogin.equals("LOGIN"))
				{
					String user = textuser.getText();
					char[] passwordChars = textPassword.getPassword();
					String pass = new String(passwordChars);

					if (user.isEmpty()|| pass.isEmpty()) 
					{
						JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
								JOptionPane.WARNING_MESSAGE);
					}
					
					
					else {

						try {
							
							String userNameS = "User Name : " + user;
							String passwordS = "Password : " + pass;
							BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\history.txt"));

							int totalLines = 0;
							while (reader.readLine() != null)
								totalLines++;
							reader.close();

							for (int i = 0; i <= totalLines; i++) 
							{
								String line = Files.readAllLines(Paths.get(".\\Data\\history.txt")).get(i);
								if (line.equals(userNameS)) 
								{
									String line2 = Files.readAllLines(Paths.get(".\\Data\\history.txt")).get((i+1));
									if (line2.equals(passwordS)) 
									{
										
										new HomePage();
										dispose();
										break;

									}
								}
							}
						} 
						catch (Exception ex) 
						{
							JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
							JOptionPane.WARNING_MESSAGE);
						}
					}


				}
		 
				 else if (buttonText.equals("BACK"))
				{
					new FirstPage();
					dispose();
				}
		}
	}
