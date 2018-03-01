import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FFixture extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String nol;
	Connection con;
	PreparedStatement pst;
	
	private JTable table;
	
	int not;
	int s,d=0;
	private DefaultTableModel model;		//to work with jtable (i.e. row,column)
	private String teamList[]=new String[10];// container of teams name
	//String teamList[]={"Dhaka Dynamites","Comilla Victorians","Chittagong Vikings","Barisal Bulls","Sylhet Royals","Duronto Rajshahi","Rangpur Riders","Khulna Stars"};// container of teams name

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FFixture frame = new FFixture();
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
	public FFixture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JTextField n = new JTextField(); // 'n' is used to get the number of teams
		n.setBackground(new Color(102, 205, 170));
											
		n.setBounds(266, 36, 86, 20);
		contentPane.add(n);
		n.setColumns(10);

		JLabel lblNoOfTeams = new JLabel("No. of Teams ");
		lblNoOfTeams.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNoOfTeams.setBounds(122, 38, 122, 14);
		contentPane.add(lblNoOfTeams);


		JButton btnOk = new JButton("Ok");
		btnOk.setForeground(new Color(255, 69, 0));
		btnOk.setBackground(new Color(0, 128, 128));
		btnOk.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		btnOk.setBounds(401, 36, 55, 20);
		contentPane.add(btnOk);

		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		table.setBackground(new Color(143, 188, 143));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		model = (DefaultTableModel) table.getModel();			// for working with "jtable"
		
		table.getColumnModel().getColumn(0).setPreferredWidth(5);  //set width of column
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.setBounds(153, 112, 305, 157);
		contentPane.add(table);
		
		JButton CreateFixture = new JButton("Create Fixture");
		CreateFixture.setForeground(new Color(255, 255, 255));
		CreateFixture.setBackground(new Color(0, 100, 0));
		CreateFixture.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		CreateFixture.setBounds(242, 280, 135, 23);
		contentPane.add(CreateFixture);
		
		JButton Menu = new JButton("Menu");
		Menu.setForeground(new Color(255, 255, 255));
		Menu.setBackground(new Color(0, 0, 255));
		
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		Menu.setBounds(254, 314, 113, 25);
		contentPane.add(Menu);
		
		JTextArea txtrTeamNameSuggestion = new JTextArea();
		txtrTeamNameSuggestion.setBackground(new Color(152, 251, 152));
		txtrTeamNameSuggestion.setForeground(new Color(0, 0, 255));
		txtrTeamNameSuggestion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtrTeamNameSuggestion.setText("Name Suggestion : 1st Scorchers,Daredevil Part 2,3rd Strikers,Four Renegades,\r\nFurious five,CSE Sixers,Seven Vikings , Eight Warriors, Nine Stars, Rising Ten.");
		txtrTeamNameSuggestion.setBounds(62, 65, 501, 36);
		contentPane.add(txtrTeamNameSuggestion);
		
		JLabel lblCreateFixture = new JLabel("Create Fixture");
		lblCreateFixture.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCreateFixture.setBounds(254, 0, 122, 14);
		contentPane.add(lblCreateFixture);
		
		
		//Self-written code for defining the function of textfield "n"
		n.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c= e.getKeyChar();
				//IF condition checks whether I pressed digit/backspace/delete key
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)))
				{
					getToolkit().beep();  //when we try to press any character, a beep will heard
					e.consume();  //if condition is true, keytyped event is consumed, i.e. it will not be typed
				}
			}
		});
		
		
		//Self-written code for defining the function of 'Ok' button
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nol = n.getText();
				//String nol = n.getText();
				 if(nol.length()==0)	//i.e. if "No. of Teams" field is empty
				 {   
					JOptionPane.showMessageDialog(null, "Fields missing..", "Input error", JOptionPane.ERROR_MESSAGE);
			    s=1;	
				 }
				
				//add rows in the jtable according to the "no. of teams"
				not = Integer.parseInt(nol);		// not=n=number of teams
				for(int i=0;i<not;i++){
					model.addRow(new Object[]{i+1,""});
				}
				JOptionPane.showMessageDialog(null, "Insert Team Name in table",
						"Message Box", JOptionPane.INFORMATION_MESSAGE);
				

			}
		});
		
		// self-written code for reading values from jtable via "testButton"
		CreateFixture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(nol!= null)		// 'nol' is the value of textfield "No. of Teams"
				{
				
					int row = model.getRowCount();
					int count=0;			//'count' is used to count the number of missing field
					for(int i=0;i<row;i++){
						teamList[i]=String.valueOf(table.getValueAt(i, 1));  // '1' means 2nd attribute; '0' means 1st attribute;  i=row
						System.out.println(teamList[i]);
						if (teamList[i].length()==0)
						{
							count++;
						}
						
					}
					
					roundRobin();
					
					//print message
					if (count!=0)   
					{
						JOptionPane.showMessageDialog(null, "Field missing",
								"Input error", JOptionPane.ERROR_MESSAGE);
					}
					
					else if(s==1)	//"s" comes from okbutton actionlistener. When textfield is empty,'ok' button pressed and then 'Create Fixture' button pressed
					{
						
						JOptionPane.showMessageDialog(null, "Insert No. of Teams",
								"Input error", JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Fixture is created",
										"Message Box", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				
				
				else{JOptionPane.showMessageDialog(null, "Insert No. of Teams",
						"Input error", JOptionPane.ERROR_MESSAGE);
			     	}
				
				
				
			}
		});
		
		//Self-written code for defining the function of 'Menu' button
				Menu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								FMenubar nw = null;    //"FMenubar" is the next frame by clicking "Menu" button
								try {
									nw = new FMenubar();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								nw.setVisible(true);
								dispose();       //get exited from current frame
							}
						});
		
		
	}

	
	private void roundRobin(){
	try {
			
			con = getConnection();		
			Statement myStat=con.createStatement();
			
			String sql = null, sqll = null, sqlll = null, sqllll = null, sql2 = null, sql22 = null, sql5=null;
			
			//3. Create Table
			sqll="DROP TABLE IF EXISTS ffixture";
			myStat.execute(sqll);			
			sqll="CREATE TABLE ffixture (id INT(64) NOT NULL AUTO_INCREMENT,team1 VARCHAR(45),team2 VARCHAR(45),winner VARCHAR(45),loser VARCHAR(45),tie VARCHAR(45),status VARCHAR(45),team1_goals INT(64),team2_goals INT(64),gd INT(64),PRIMARY KEY(id))";			
			myStat.execute(sqll);
			
			sqlll="DROP TABLE IF EXISTS fteams";
			myStat.execute(sqlll);			
			sqlll="CREATE TABLE fteams (team VARCHAR(45),match_win INT(64),match_lose INT(64),match_tied INT(64),gd INT(64),PRIMARY KEY(team))";			
			myStat.execute(sqlll);
			sqllll="DROP TABLE IF EXISTS fCoach";
			myStat.execute(sqllll);		
			sqllll="CREATE TABLE fcoach (team VARCHAR(45),coach VARCHAR(45),PRIMARY KEY(team))";			
			myStat.execute(sqllll);
			
			
			//create "teaminfo" table in database
			String sql101="DROP TABLE IF EXISTS fteaminfo";
			myStat.execute(sql101);
			
			//Here we assign "sql10" in "for loop" to add column which indicates certain team name
			
			System.out.println("ZAhid");
			String sql10="CREATE TABLE fteaminfo(id INT(5),";//beginning part of "sql10"
			for(int p=0;p<not-1;p++)
			{
				sql10=sql10 +teamList[p]+ " VARCHAR(45),";//middle part of "sql10"
			}
			sql10=sql10 +teamList[not-1]+ " VARCHAR(45))"; //last part of "sql10"
			System.out.println(sql10);
			myStat.execute(sql10);
			
			//initialize the attributes of "teaminfo" table for 12 players
			String sql1022="";  //A part for creating "a insert statement"
			for(int r=1;r<=not;r++)
			{
				sql1022=sql1022 + ",'Not Set'";
			}
			
			String sql102 = "insert into fteaminfo values("+d+""+sql1022+ ")"; //d=global variable
			for(d=1;d<=12;d++)
			{
				//Our Targeted sql is, sql102 = "insert into teaminfo values('"+d +"','Not Set','Not Set','Not Set','Not Set','Not Set')";
				sql102 = "insert into fteaminfo values("+d+""+sql1022+ ")";
				System.out.println(sql102);
				myStat.executeUpdate(sql102);
			}
			System.out.println(sql102);
			
			
			
			//initialize the attributes of "teams" & "coach" table
			for(int b=0;b<not;b++)
			{
				sql2 = "insert into fteams values('"+ teamList[b] +"',0,0,0,0)";		//initialize the attributes of "teams" table for further work.
				System.out.println("teams are:");
				System.out.println(teamList[b]);
				myStat.executeUpdate(sql2);
				
				sql22 = "insert into fcoach values('"+ teamList[b] +"','')";		//initialize the attributes of "coach" table for further work.
				myStat.executeUpdate(sql22);
				
			}
			
						
			
			//Round-robin Algorithm
			int md;
			int i,j;
			int d=1;
			int t[][]=new int [10][10];
			for(j=0;j<not;j++){
				for(i=1;i<=not;i++){
					if(d==not)
						d=1;
					t[i][j]=d;
					d++;
					
				}
			}
			
			for(i=1;i<=not;i++){
				int temp;
				temp=t[i][i-1];
				t[not][i-1]=temp;
				t[i][i-1]=0;
				
			}
			
			
			
			for(md=1;md<not;md++){
				System.out.println("Match Day: "+md);
				for(i=1;i<=not;i++){
					for(j=0;j<i-1;j++){
						if(t[i][j]==md)
						{
							//4. Execute SQL query	
							//System.out.println(i+"vs"+(j+1));
						//	sql = "insert into fixture(team1,team2,winner,loser) "
						//			+ "values('"+ teamList[i-1] +"','"+teamList[j]+"','Not set','Not set')";
							sql = "insert into ffixture(team1,team2,winner,loser,tie,status,team1_goals,team2_goals,gd) "
									+ "values('"+ teamList[i-1] +"','"+teamList[j]+"','Not set','Not set','Not set','Not Played',0,0,0)";
							myStat.executeUpdate(sql);	
							System.out.println(teamList[i-1]+" vs "+teamList[j]);   //Added code
							//System.out.println("Insert complete"); 
						}
												
					}
				}
				
			}
															
			
			
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
