package frames;
import Data.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import CourierListF.CourierList; 


	public class CourierManager extends JFrame implements ActionListener
	{
		private JPanel panel;
		private JButton buttonAdd;
		private JButton buttonDel;
		private JButton buttonBack;
		private JLabel image;
		private JLabel lebelName;
		private JTextField textuser1;
		private JTextField textuser2;
		private JTextField textuser3;
		JTable table;
		DefaultTableModel model;
		private CourierList courierList;

		public CourierManager()
		{
			this.initializeComponents();
			
			this.courierList = new CourierList();	
			this.createTable();
			this.setTitle("COURIER MANAGEMENT");
			this.setSize(751,540);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocation(560,360);
			this.setVisible(true);
		
		}

		private void initializeComponents()
		{
			this.panel=new JPanel(null);
			
			this.lebelName=new JLabel("COURIER ID");
			this.lebelName.setBounds(20,30,100,25);
			lebelName.setFont(new Font("Calibri",Font.BOLD,20));
			lebelName.setBackground(Color.WHITE);
			lebelName.setForeground(Color.WHITE);
			this.panel.add(this.lebelName);
			
			this.textuser1=new JTextField();
			this.textuser1.setBounds(20,60,100,25);
			this.panel.add(this.textuser1);
			
			this.lebelName=new JLabel("  QUANTITY");
			this.lebelName.setBounds(220,30,100,25);
			lebelName.setFont(new Font("Calibri",Font.BOLD,20));
			lebelName.setBackground(Color.WHITE);
			lebelName.setForeground(Color.WHITE);
			this.panel.add(this.lebelName);
			
			this.textuser2=new JTextField();
			this.textuser2.setBounds(220,60,100,25);
			this.panel.add(this.textuser2);

			this.lebelName=new JLabel("   WEIGHT");
			this.lebelName.setBounds(420,30,100,25);
			lebelName.setFont(new Font("Calibri",Font.BOLD,20));
			lebelName.setBackground(Color.WHITE);
			lebelName.setForeground(Color.WHITE);
			this.panel.add(this.lebelName);
			
			this.textuser3=new JTextField();
			this.textuser3.setBounds(420,60,100,25);
			this.panel.add(this.textuser3);

			this.buttonAdd=new JButton("ADD PARCEL");
			this.buttonAdd.setBounds(530,20,190,50);
			buttonAdd.setFont(new Font("Calibri",Font.BOLD,20));
			buttonAdd.setBackground(new Color(0,255,0));
			buttonAdd.setForeground(new Color(255,255,255));
			this.buttonAdd.addActionListener(this);
			this.panel.add(this.buttonAdd);

			this.buttonDel=new JButton("REMOVE PARCEL");
			this.buttonDel.setBounds(530,80,190,50);
			buttonDel.setFont(new Font("Calibri",Font.BOLD,20));
			buttonDel.setBackground(new Color(0,0,255));
			buttonDel.setForeground(new Color(255,255,255));
			this.buttonDel.addActionListener(this);
			this.panel.add(this.buttonDel);
			
			this.buttonBack=new JButton("BACK");
			this.buttonBack.setBounds(630,450,100,20);
			buttonBack.setFont(new Font("Calibri",Font.BOLD,18));
			buttonBack.setBackground(new Color(255,0,0));
			buttonBack.setForeground(new Color(255,255,255));
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
		

			
			
			this.add(this.panel);
		
		}
		
		public void createTable() {
			this.model = new DefaultTableModel() 
			{
				
				public boolean isCellEditable(int row, int column) 
				{
					return false;
				}

			};
			this.model.addColumn("COURIER ID");
			this.model.addColumn("COURIER QUANTITY");
			this.model.addColumn("COURIER WEIGHT");
			
		
			this.table = new JTable(model);
			table.setFont(new Font("Calibri", Font.BOLD, 20));
			table.setBackground(Color.RED);
			table.setRowHeight(30);
			table.setSelectionBackground(Color.RED);
		
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(20, 150, 560, 360);
			this.panel.add(scrollPane);
			
		
			CourierF.Courier couriers[];
			couriers = this.courierList.getAllCourier();
		
			for (int i = 0; i < couriers.length; i++) 
			{
				if (couriers[i] != null) 
				{
					model.addRow(new Object[]
					{
							couriers[i].getCourierId(),
							couriers[i].getQuantity(),
							couriers[i].getWeight()
					});
				}

			}

			ImageIcon imageIcon = new ImageIcon(".\\Image\\BackGround.jpg");
			this.image = new JLabel(imageIcon);
			this.image.setBounds(0, 0, 751,540);
			this.panel.add(this.image);
			
		}

		public void actionPerformed(ActionEvent E1)
		{	
			Object source = E1.getSource();

			

			
			if (source == buttonAdd)
			{
				try 
				{
					int courierId = Integer.parseInt(textuser1.getText().trim());
					int quantity = Integer.parseInt(textuser2.getText().trim());
					double weight = Double.parseDouble(textuser3.getText().trim());
				
					CourierF.Courier C = new CourierF.Courier(quantity,weight,courierId);
					courierList.insertCourier(C);
					
					model.addRow(new Object[]
						{
								C.getCourierId(),
								C.getQuantity(),
								C.getWeight(),
						});
					
					CourierData.writeInFile(C.toString(),"Data/data.txt",true);
				} 
				catch (NumberFormatException ex) 
				{
					JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
				}		
			}
			else if(source == buttonDel)
			{
				int option = JOptionPane.showConfirmDialog(this,"Are you sure to Delete?");
				if(option == JOptionPane.YES_OPTION)
				{
					int selectedRows[] = table.getSelectedRows();
					Arrays.sort(selectedRows);

					if(selectedRows!=null)
					{
						for(int i=selectedRows.length-1; i>=0 ;i--)
						{
							int courierId = Integer.parseInt
								(
									table.getModel().
									getValueAt(selectedRows[i], 0).
									toString()
								);
											
							courierList.removeCouriersById(courierId);
							model.removeRow(selectedRows[i]);
						}
						
						CourierData.saveCourierListInFile(courierList,"Data/data.txt",false);
						JOptionPane.showMessageDialog(this,"Successfully Deleted","Deleted",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
			else
			{
				new HomePage();
				this.dispose();
			}	
		}

	}