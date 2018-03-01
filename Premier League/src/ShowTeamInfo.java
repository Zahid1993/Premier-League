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


public class ShowTeamInfo extends JFrame {

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
					ShowTeamInfo frame = new ShowTeamInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowTeamInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 38, 257, 20);
		contentPane.add(comboBox);
		
		JLabel lblTeams = new JLabel("Teams");
		lblTeams.setForeground(Color.WHITE);
		lblTeams.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTeams.setBounds(90, 40, 59, 14);
		contentPane.add(lblTeams);
		
		JButton Show = new JButton("Show");
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Show.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Show.setBounds(215, 64, 89, 23);
		contentPane.add(Show);
		
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
		
		model = (DefaultTableModel) table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(2);  //set width of column
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		
		table.setRowHeight(14);										//set height of row
		table.setBounds(188, 98, 257, 172);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Coach");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(90, 287, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 286, 248, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton Menu = new JButton("Menu");
		Menu.setForeground(Color.WHITE);
		Menu.setBackground(Color.BLUE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		Menu.setBounds(297, 323, 89, 23);
		contentPane.add(Menu);
		
		JButton Clear = new JButton("Clear");
		Clear.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Clear.setBounds(321, 65, 89, 23);
		contentPane.add(Clear);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\Books\\Y-3,S-1\\Database  Management  System\\Project\\Cricket Tournament\\Cricket Images\\Show teaminfo.jpg"));
		lblNewLabel_1.setBounds(0, 0, 619, 357);
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
	
			    
	   
	 // self-written code for action listener for 'Show' button
	    Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int id,k;
					String tmp = (String) comboBox.getSelectedItem();
					System.out.println("Team Name:" + tmp);
					
					//(1)Set the values in Jtable
					
					String player=null;
					String sql2 = "select id,"+tmp+" from teaminfo";
					//String sql2 = "select id from teaminfo";
					//System.out.println("ZAhidTeam Name:" + tmp);
					myRs=myStat.executeQuery(sql2);
					while(myRs.next()){
					id=myRs.getInt("id");
					player=myRs.getString(""+tmp+"");
					System.out.println(myRs.getString("id")+" "+myRs.getString(""+tmp+""));
					
					model.addRow(new Object[]{id,player}); //write data in jtable
						
				}
					//(2)Set the values in textfield
					String coach=null;
					String sql22 = "select coach from coach where team = '" + tmp + "'";
					myRs=myStat.executeQuery(sql22);
					while(myRs.next()){
					coach=myRs.getString("coach");
					System.out.println("Coach:"+ myRs.getString("coach"));
					}
					textField.setText(coach);
					
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
