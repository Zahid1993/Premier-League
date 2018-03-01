import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;


public class TeamInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	PreparedStatement pst;
	Connection con;
	Statement myStat;
	ResultSet myRs;
	private DefaultTableModel model;
	private JTextField textField;
	
	String Name;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamInfo frame = new TeamInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param <DefaultTable>
	 */
	public <DefaultTable> TeamInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(173, 24, 243, 20);
		contentPane.add(comboBox);
		
		JLabel lblTeams = new JLabel("Teams");
		lblTeams.setForeground(Color.WHITE);
		lblTeams.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeams.setBounds(97, 26, 46, 14);
		contentPane.add(lblTeams);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnOk.setBounds(264, 269, 59, 20);
		contentPane.add(btnOk);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Player"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		model = (DefaultTableModel) table.getModel();				// Create variable "model" to work with "table"
		table.getColumnModel().getColumn(0).setPreferredWidth(5);  //set width of column
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		
		table.setRowHeight(14);										//set height of row
		table.setBounds(169, 89, 257, 172);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Coach");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(97, 293, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 291, 257, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton Done = new JButton("Done");
		Done.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Done.setBounds(436, 291, 89, 23);
		contentPane.add(Done);
		
		JButton Menu = new JButton("Menu");
		Menu.setForeground(Color.WHITE);
		Menu.setBackground(Color.BLUE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		Menu.setBounds(285, 324, 89, 23);
		contentPane.add(Menu);
		
		JButton Clear = new JButton("Clear");
		Clear.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Clear.setBounds(293, 55, 110, 23);
		contentPane.add(Clear);
		
		JButton Add = new JButton("Add");
		Add.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Add.setBounds(173, 55, 110, 23);
		contentPane.add(Add);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\Books\\Y-3,S-1\\Database  Management  System\\Project\\Cricket Tournament\\Cricket Images\\Teaminfo.jpg"));
		lblNewLabel_1.setBounds(0, 0, 629, 358);
		contentPane.add(lblNewLabel_1);
		
		
		
		 // self-written code for set values in ComboBox
		try {
			String sql = "select * from teams";

			con = getConnection();
			myStat=con.createStatement();
			pst = con.prepareStatement(sql);
			ResultSet myRs = pst.executeQuery(sql);

			while (myRs.next()) {
			    Name = myRs.getString("team");
				comboBox.addItem(Name);
			}
				
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		// self-written code for action listener for "Add" button
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con = getConnection();
					myStat=con.createStatement();
					//String tmp =(String) comboBox.getSelectedItem();
					//model.removeRow(0);;
					//table.removeAll();
					for(int i=0;i<12;i++){
						model.addRow(new Object[]{i+1,""});
						
					}
					
					
					JOptionPane.showMessageDialog(null, "Insert Players Name in table",
							"Message Box", JOptionPane.INFORMATION_MESSAGE);
					
				}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		// self-written code for action listener for "Clear" button
				Clear.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 
						 model = (DefaultTableModel) table.getModel();
						 while(model.getRowCount()>0)
						 {
						 for(int l=0;l<model.getRowCount();l++)
						 model.removeRow(l);}
						 
						 textField.setText(null);	//set "textField" to null
						 
						 
					}
				});
	   
	 // self-written code for action listener for 'Ok' button
	    btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int row = model.getRowCount();
					String tmp = (String) comboBox.getSelectedItem();	
					System.out.println("Team Name:" + tmp);
					
					//Work with Jtable
					String g[]=new String[15];
					String sqll;
						
						int count=0;			//'count' is used to count the number of missing field
						for(int i=0;i<row;i++){
							g[i]=String.valueOf(table.getValueAt(i, 1));  // '1' means 2nd attribute; '0' means 1st attribute;  i=row
							System.out.println(g[i]);
							
							//update values in teaminfo table
							sqll = "update teaminfo set "+tmp+" = '" + g[i]+ "'   where id= '" + (i+1) + "' ";
							myStat.executeUpdate(sqll);
							if (g[i].length()==0)
							{
								count++;
							}
							
						}	
						
								
				
				if (count!=0||row==0)   //"row" is the row created in the table
				{
				JOptionPane.showMessageDialog(null, "Field missing","Input error", JOptionPane.ERROR_MESSAGE);
				}
				
				
							
				else{
					JOptionPane.showMessageDialog(null, "Update Successfully",
							"Message Boxr", JOptionPane.INFORMATION_MESSAGE);
				}
				
			
				}
				
			
				
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			}
		});
		
	    
		 // self-written code for action listener for 'Done' button
		Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	 
					try {
						String t = textField.getText();
						String tmp = (String) comboBox.getSelectedItem();
						String sql2 = "update coach set coach = '" + t
								+ "'   where team= '" + tmp + "' ";
						
						int val=myStat.executeUpdate(sql2);
						if((val>=1) && (t.length()!=0)){
							JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
						}
						else	//i.e. if "Coach" field is empty
						 {   
							JOptionPane.showMessageDialog(null, "Fields missing..", "Input error", JOptionPane.ERROR_MESSAGE);	
						 }
						
						
						
					}

					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		
		//Self-written code for defining the function of 'Menu' button
		Menu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Menubar nw = null;    //"Menubar" is the next frame by clicking "Menu" button
						try {
							nw = new Menubar();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nw.setVisible(true);
						dispose();       //get exited from current frame
					}
				});

	}
	
	
	
	public static Connection getConnection() throws Exception {

		try {

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/premierleague";
			String username = "root";
			String password = "root";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username,
					password);
			// System.out.println("Connected");
			return conn;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
