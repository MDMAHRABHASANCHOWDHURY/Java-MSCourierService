package frames;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.*;

public class  HomePage extends JFrame implements ActionListener
{
	private JPanel panel;
    private JButton buttonDash;
	private JButton buttonout;
	private JButton buttonSend;
	private JLabel image;

	
	public HomePage()
	{
		this.initializeComponents();
		this.setTitle("MS COURIER SERVICE");
		this.setSize(750,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initializeComponents()
	{
		this.panel=new JPanel(null);
		
		this.buttonSend=new JButton("SEND PARCEL");
		this.buttonSend.setBounds(275,240,180,50);
		buttonSend.setFont(new Font("Calibri",Font.BOLD,20));
		buttonSend.setBackground(new Color(0,255,0));
		buttonSend.setForeground(new Color(0,0,0));
		this.buttonSend.addActionListener(this);
		this.panel.add(this.buttonSend);
		
	    this.buttonDash=new JButton("DASH BOARD");
		this.buttonDash.setBounds(275,320,180,50);
		buttonDash.setFont(new Font("Calibri",Font.BOLD,20));
		buttonDash.setBackground(new Color(255, 153, 51));
		buttonDash.setForeground(new Color(0,0,0));
		this.buttonDash.addActionListener(this);
		this.panel.add(this.buttonDash);
		
		this.buttonout=new JButton("LOGOUT");
		this.buttonout.setBounds(580,500,150,50);
		buttonout.setFont(new Font("Calibri",Font.BOLD,20));
		buttonout.setBackground(new Color(255,0,0));
		buttonout.setForeground(new Color(255,255,255));
		this.buttonout.addActionListener(this);
		this.panel.add(this.buttonout);

		ImageIcon imageIcon = new ImageIcon(".\\Image\\Homepage.jpg");
		this.image = new JLabel(imageIcon);
		this.image.setBounds(0, 0, 750,600);
		this.panel.add(this.image);
		
		
		this.add(this.panel);
		
	}
	
	public void actionPerformed(ActionEvent EX)
	{
		String buttonSend = EX.getActionCommand();
		String buttonDash = EX.getActionCommand();
	
		

		if(buttonSend.equals("SEND PARCEL"))
		{
			new SenderFrame();
			dispose();
		}
		
		else if(buttonDash.equals("DASH BOARD"))
		{
			new CourierManager();
			dispose();
		}
		
		else
		{
			new Login();
			dispose();
		};
	}
}
