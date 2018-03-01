

//We need not to create semifinal table in database, We can read value from jtable

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;

public class SemiFinal extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	private DefaultTableModel model; // for jtable to add attribute
	Connection con;
	Statement myStat;
	ResultSet myRs;
	String team_list[] = new String[6];
	
	String tm1,tm2;
	int id;
	private JTextField status;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemiFinal frame = new SemiFinal();
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
	public SemiFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSemiFinal = new JLabel("Semi Final");
		lblSemiFinal.setForeground(new Color(255, 69, 0));
		lblSemiFinal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSemiFinal.setBounds(270, 11, 116, 14);
		contentPane.add(lblSemiFinal);

		JLabel lblMatch = new JLabel("Match 1");
		lblMatch.setFont(new Font("Calibri", Font.BOLD, 12));
		lblMatch.setBounds(151, 69, 46, 14);
		contentPane.add(lblMatch);

		JLabel lblTeam = new JLabel("Team 1");
		lblTeam.setBackground(new Color(0, 0, 0));
		lblTeam.setForeground(new Color(255, 255, 255));
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam.setBounds(166, 158, 46, 14);
		contentPane.add(lblTeam);

		JLabel lblTeam_1 = new JLabel("Team 2");
		lblTeam_1.setForeground(new Color(0, 0, 128));
		lblTeam_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTeam_1.setBounds(166, 194, 46, 14);
		contentPane.add(lblTeam_1);

		JButton Show = new JButton("Show");
		Show.setBackground(new Color(222, 184, 135));
		Show.setForeground(new Color(0, 0, 0));
		//Self-written code for defining the function of 'Show' button
				Show.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
											
						try{
						
						 String sql0 = "select * from final";
						myRs=myStat.executeQuery(sql0);
						while(myRs.next())
						{
							tm1=myRs.getString("team1");
							tm2=myRs.getString("team2");
					    //System.out.println("TEAMS:"+tm1+" "+tm2);
				
						}
						
						if((tm1.equals("Not set"))||(tm2.equals("Not set")))
						{
							JOptionPane.showMessageDialog(null, "Yet some matches has left to play.", "Message Box", JOptionPane.INFORMATION_MESSAGE);
					
						}
						 
						else	
						{
							ShowSemiFinal nw = null; 
							nw = new ShowSemiFinal();
							nw.setVisible(true);
							dispose();
						}
						}
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 
						
					}
				});
		
		Show.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Show.setBounds(297, 299, 89, 23);
		contentPane.add(Show);

		JLabel label = new JLabel("Match");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(166, 125, 46, 14);
		contentPane.add(label);

		t1 = new JTextField();
		t1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t1.setBounds(270, 156, 134, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t2.setBounds(270, 192, 134, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel lblWinner_1 = new JLabel("Winner");
		lblWinner_1.setForeground(new Color(25, 25, 112));
		lblWinner_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWinner_1.setBounds(166, 236, 46, 14);
		contentPane.add(lblWinner_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//ADD contents in Combobox
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 ", "2"}));
		comboBox.setBounds(271, 125, 72, 20);
		contentPane.add(comboBox);

		table = new JTable();
		table.setForeground(new Color(47, 79, 79));
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);  //set width of column
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.setBounds(194, 65, 241, 39);
		table.setRowHeight(20);										//set height of row
		contentPane.add(table);

		JLabel lblMatch_1 = new JLabel("Match 2");
		lblMatch_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblMatch_1.setBounds(151, 86, 46, 14);
		contentPane.add(lblMatch_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(34, 139, 34));
		comboBox_1.setForeground(new Color(240, 248, 255));
		comboBox_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		comboBox_1.setBounds(270, 234, 134, 20);
		contentPane.add(comboBox_1);
		
		JButton btnOk = new JButton("Update");
		btnOk.setForeground(new Color(34, 139, 34));
		btnOk.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int i = 0;
					String tmp = (String) comboBox.getSelectedItem();
					tmp=tmp.trim();
					i = Integer.parseInt(tmp);
					
					String tmp1 = (String) comboBox_1.getSelectedItem();
					tmp1=tmp1.trim();
					
					String zs = null,ms = null;
					// String p1=t1.getText();

					Statement myStmt = con.createStatement();


					String sql4 = null,sql5,sql2, sql3, winner = null, loser = null;

					String p1 = t1.getText().trim();
					String p2 = t2.getText().trim();
					String p3 = status.getText().trim();
					
					//Show message box
					if(p3.length()==0)
					{
						JOptionPane.showMessageDialog(null, "Status Field missing","Input error", JOptionPane.ERROR_MESSAGE);
					}
					
					
					//insert value into semifinal table
                    String sql4444 = null,sql5555 = null ;
					
					if (i==1) 
					{	
						sql4444="insert into semifinal(team1,team2,status) values('"+ team_list[1] +"','"+ team_list[4] +"','"+p3 +"')";		//insert a row that will be updated later
						
					}
					
					
					if (i==2) {
						
			
						//sql5555 = "update fsemifnal set team1 = " +team_list[2]+ " and team2 = " +team_list[3]+ " where id= " +i+ " ";
						sql4444="insert into semifinal(team1,team2,status) values('"+ team_list[2] +"','"+ team_list[3] +"','"+p3 +"')";		//insert a row that will be updated later
						// myStat.execute(sql5555);
					}
					myStat.execute(sql4444);

					//update value into final table
					if (i==1) 
					{
						zs = tmp1;
						sql4 = "update final set team1 = '" + zs
								+ "'";
					}
							
						
		
					if (i==2) {
						ms = tmp1;
						sql4 = "update final set team2 = '" + ms
								+ "'";
					}

					int val=myStmt.executeUpdate(sql4);
					if(val>=1&&p3.length()!=0)
					{
						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
					}

				}

				catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		btnOk.setBounds(297, 265, 89, 23);
		contentPane.add(btnOk);
		
		JButton Menu = new JButton("Menu");
		Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menubar nw = null;    //"Menubar" is the next frame by clicking "<<Back" button
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
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		Menu.setForeground(Color.WHITE);
		Menu.setBackground(Color.BLUE);
		Menu.setBounds(297, 326, 89, 23);
		contentPane.add(Menu);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(414, 237, 46, 14);
		contentPane.add(lblStatus);
		
		status = new JTextField();
		status.setBounds(468, 234, 141, 20);
		contentPane.add(status);
		status.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SemiFinal.class.getResource("/Images/SemiFinal.jpg")));
		lblNewLabel.setBounds(0, 0, 630, 349);
		contentPane.add(lblNewLabel);
		model = (DefaultTableModel) table.getModel();
		load();
		
		//action of combobox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.removeAllItems();
				status.setText(null);
				String item=(String) comboBox.getSelectedItem();
				item=item.trim();
				if(item.equals("1")){
					t1.setText(team_list[1]);
					t2.setText(team_list[4]);
					comboBox_1.addItem(team_list[1]);
					comboBox_1.addItem(team_list[4]);
				}else{
					t1.setText(team_list[2]);
					t2.setText(team_list[3]);
					comboBox_1.addItem(team_list[2]);
					comboBox_1.addItem(team_list[3]);
				}
			}
		});
		
		// Create final table in database
		try{
			con = getConnection();		
			Statement myStat=con.createStatement();
			
			String sql = null;
			String sql2 = null;
			
			//3. Create Table
			sql="DROP TABLE IF EXISTS final";
			myStat.execute(sql);			
			sql="CREATE TABLE final (team1 VARCHAR(45),team2 VARCHAR(45),winner VARCHAR(45),loser VARCHAR(45))";			
			myStat.execute(sql);
			
			sql2="insert into final values('Not set','Not set','','')";		//insert a row that will be updated later
			myStat.execute(sql2);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
	}

	private void load() {
		String team;
		int win = 0, points = 0, lose = 0, count = 0;
		int totalMatch = 0;

		// finding total number of match played by a team
		try {

			String sql1 = "select count(team) from teams;";
			con = getConnection();
			myStat = con.createStatement();
			ResultSet rs = myStat.executeQuery(sql1);
			while (rs.next()) {
				int t = rs.getInt("count(team)"); // t= number of team
				totalMatch = t - 1;

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {

			String sql1 = "select * from teams order by match_win desc";
			con = getConnection();
			myStat = con.createStatement();
			ResultSet rs = myStat.executeQuery(sql1);
			while (rs.next()) {
				team = rs.getString("team");
				count++;
				team_list[count] = team;
				if (count == 4) 
					break; 
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		model.addRow(new Object[] { team_list[1], team_list[4] });		//Write data in jtable
		model.addRow(new Object[] { team_list[2], team_list[3] });		//Write data in jtable
		
	

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
