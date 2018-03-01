import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.ImageIcon;


public class FPointsTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	private DefaultTableModel model; //for jtable to add attribute
	Connection con;
	Statement myStat;
	ResultSet myRs;
	
	String teams=null;
	int win;
	int points;
	int lose;
	int match_left;
	int match_played,tie;
	int t,count;
	String m_winner,m_loser;
	int id,m;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FPointsTable frame = new FPointsTable();
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
	public FPointsTable() {
		
		//******Calling loadteam function*********
		loadteam();		//loadteam() function is used to initialize or update "teams" table from "fixture" table
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblPointsTable = new JLabel("Points Table");
		lblPointsTable.setFont(new Font("Calibri", Font.BOLD, 17));
		lblPointsTable.setBounds(261, 11, 127, 29);
		contentPane.add(lblPointsTable);
		
		JButton btnSemiFinal = new JButton("Semi Final");
		btnSemiFinal.setForeground(Color.WHITE);
		btnSemiFinal.setBackground(Color.DARK_GRAY);
		btnSemiFinal.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		
		
		btnSemiFinal.setBounds(322, 269, 92, 23);
		contentPane.add(btnSemiFinal);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 13));
		table.setForeground(Color.BLUE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Teams", "Played", "Left", "Win", "Lose", "Tie", "Points", "GD"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(120);  //set width of column
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		
		table.setBounds(238, 93, 389, 169);
		contentPane.add(table);
		
		JLabel lblTeam = new JLabel("Teams");
		lblTeam.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblTeam.setBounds(238, 68, 46, 14);
		contentPane.add(lblTeam);
		
		JLabel lblWin = new JLabel("Win");
		lblWin.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblWin.setBounds(416, 68, 30, 14);
		contentPane.add(lblWin);
		
		JLabel lblLose = new JLabel("Lose");
		lblLose.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblLose.setBounds(456, 68, 30, 14);
		contentPane.add(lblLose);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPoints.setBounds(545, 68, 35, 14);
		contentPane.add(lblPoints);
		
		JLabel lblMatchLeft = new JLabel("Left");
		lblMatchLeft.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblMatchLeft.setBounds(378, 68, 35, 14);
		contentPane.add(lblMatchLeft);
		
		JButton Menu = new JButton("Menu");
		Menu.setForeground(Color.WHITE);
		Menu.setBackground(Color.BLUE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		Menu.setBounds(322, 303, 89, 23);
		contentPane.add(Menu);
		
		JLabel lblPlayed = new JLabel("Played");
		lblPlayed.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPlayed.setBounds(334, 68, 46, 14);
		contentPane.add(lblPlayed);
		
		JLabel lblRunRate = new JLabel("GD");
		lblRunRate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblRunRate.setBounds(605, 69, 62, 14);
		contentPane.add(lblRunRate);
		
		JLabel lblTie = new JLabel("Tie");
		lblTie.setBounds(504, 68, 20, 14);
		contentPane.add(lblTie);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 333, 46, 14);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FPointsTable.class.getResource("/Images/FPointsTable.jpg")));
		lblNewLabel.setBounds(0, 0, 627, 358);
		contentPane.add(lblNewLabel);
		
		model=(DefaultTableModel) table.getModel();
		
		//*******Calling load function*********
		// our target activities are listed in "load function". By calling it here,we can see the Jtable when this frame is called.
		load();
		
		
		//Self-written code for defining the function of 'SemiFinal' button
				btnSemiFinal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						 try {
						 
						 //find the total number of match in fixture 
						 String sql00 = "select count(id) from ffixture";
						 con = getConnection();
						 myStat=con.createStatement();
						 myRs=myStat.executeQuery(sql00);
						 while(myRs.next())
						 {
					     m=myRs.getInt("count(id)");  // t= number of team
					     System.out.println("Number of teams:"+m);
						 }
						 
						//Restriction to "SemiFinal" button 
						String sql0 = "select * from ffixture where (winner='Not set' and loser='Not set')";
						myRs=myStat.executeQuery(sql0);
						while(myRs.next())
						{
						id=myRs.getInt("id"); 		//id is the value where winner & loser='Not set'
					    m_winner=myRs.getString("winner");
					    m_loser=myRs.getString("loser");
					   // System.out.println(id+" "+m_winner+" "+m_loser);
				
						}
						
						if((id!=m)&&(m_winner!="Not set")&&(m_loser!="Not set"))
						{
						System.out.println(id+" "+m_winner+" "+m_loser);	
						FSemiFinal nw = null; 
						nw = new FSemiFinal();

						nw.setVisible(true);
						dispose(); 
						}
						
						 
						else	
						{
						JOptionPane.showMessageDialog(null, "Yet some matches has left to play.Please go to MENU-->Data Input", "Message Box", JOptionPane.INFORMATION_MESSAGE);
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
				FMenubar nw = null;    //"Menubar" is the next frame by clicking "Menu" button
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

	
	//******loadteam function***********
	public void loadteam(){
		System.out.println("zahid");
		try{
			
			//Connection con=Database
			con = getConnection();
			
			
			Statement myStmt = con.createStatement();
			Statement myStmt1 = con.createStatement();
			Statement myStmt2 = con.createStatement();
			Statement myStmt3 = con.createStatement();
			Statement myStmt4 = con.createStatement();
			Statement myStmt5 = con.createStatement();
			String sql8,sql2, sql3,sql4,sql44,sql6, winner = null, loser = null;
			
			//set the teams table in initial state  i.e. win=0 and lose=0 for all teams
			ResultSet rsss=myStmt.executeQuery("select * from fteams");
			while(rsss.next()){
				System.out.println("Rahman");
				String na=rsss.getString("team");
				sql6 = "update fteams set match_win =0, match_lose=0,match_tied=0,gd=0  where team= '" +na+ "' ";
				myStmt3.executeUpdate(sql6);
			}
			
			
			//set the values in "teams" table [i.e.match_win , match_lose,match_tied, match_played]
			ResultSet r=myStmt.executeQuery("select * from ffixture");
			
			ResultSet rss;
			
			String won = null;
			while(r.next()){
				System.out.println("Anonwinner");
				won=r.getString("winner");
				System.out.println(won);
				int gdd=r.getInt("gd");
				System.out.println(gdd);
			
				rss=myStmt1.executeQuery("select * from fteams where team= '" +won+ "'");
				//rs=myStmt.executeQuery("select * from teams where team='c'");
				int win = 0;	
				int loss = 0,m_played=0;
				int gd=0;
				while(rss.next()){
					System.out.println("Mehedee");
					win=rss.getInt("match_win");
					System.out.println(win);
					win++;
				
					loss=rss.getInt("match_lose");
					System.out.println(loss);
					
				//	m_played = loss+win;
					
					gd=rss.getInt("gd");
					System.out.println(gd);
					gd= gd+gdd;
				}
					sql4 = "update fteams set match_win = " + win+ "   where team= '" +won+ "' ";
					myStmt2.executeUpdate(sql4);
					//String sql444 = "update fteams set match_played = " +m_played+ "  where team= '" +won+ "' ";
					//myStmt2.executeUpdate(sql444);
					String sql4444 = "update fteams set gd = " +gd+ "  where team= '" +won+ "' ";
					myStmt2.executeUpdate(sql4444);
					
			
			}
			
			r=myStmt.executeQuery("select * from ffixture");		
			String lose = null;
			while(r.next()){
				System.out.println("Anon");
				lose=r.getString("loser");
				System.out.println(lose);
				int gdd=r.getInt("gd");
				System.out.println(gdd);
				
				//float runrate=r.getFloat("runrate");
				rss=myStmt1.executeQuery("select * from fteams where team= '" +lose+ "'");
				//rs=myStmt.executeQuery("select * from teams where team='c'");
				int loss = 0;
				
				
				int win = 0,m_played=0;
				int gd=0;
				//float rrate=0;
				while(rss.next()){
					System.out.println("Mehedee");
					loss=rss.getInt("match_lose");
					System.out.println(loss);
					loss++;
					
					win=rss.getInt("match_win");
					System.out.println(win);
					//m_played = loss+win;
					//System.out.println(win+loss+"zahidu"+m_played);
					
					gd=rss.getInt("gd");
					System.out.println(gd);
					gd= gd-gdd;
					
				}
					sql4 = "update fteams set match_lose = " + loss+ "   where team= '" +lose+ "' ";
					myStmt2.executeUpdate(sql4);
					//String sql444 = "update fteams set match_played = " +m_played+ "  where team= '" +lose+ "' ";
					//myStmt2.executeUpdate(sql444);
					String sql4444 = "update fteams set gd = " +gd+ "  where team= '" +lose+ "' ";
					myStmt2.executeUpdate(sql4444);
			}
			
			
			// set tie match when team = team1
			String t="yes";
			r=myStmt.executeQuery("select * from ffixture where tie = '" +t+ "' ");		
			System.out.println("************Anon*********tie");
		//	String lose = null;
			String t1=null;
			//String t2=null;
			while(r.next()){
				System.out.println("Anon");
				t1=r.getString("team1");
				System.out.println(t1);
			//	t2=r.getString("team2");
			//.out.println(t2);
				
				//lose=r.getString("loser");
				//System.out.println(lose);
				int gdd=r.getInt("gd");
				System.out.println(gdd);
				
				//float runrate=r.getFloat("runrate");
				rss=myStmt1.executeQuery("select * from fteams where team= '" +t1 + "' ");
				//rs=myStmt.executeQuery("select * from teams where team='c'");
				int loss = 0;
				
				
				int win = 0,m_played=0;
				int tie=0;
				int gd=0;
				//float rrate=0;
				while(rss.next()){
					System.out.println("Mehedee");
					//loss=rss.getInt("match_lose");
				//	System.out.println(loss);
					//loss++;
					
					tie=rss.getInt("match_tied");
					System.out.println(tie);
					tie++;
					
					//win=rss.getInt("match_win");
					//System.out.println(win);
				//	m_played = loss+win;
				//	System.out.println(win+loss+"zahidu"+m_played);
					
					gd=rss.getInt("gd");
					System.out.println(gd);
					gd= gd+gdd;
					System.out.println("*****"+gd);
					
				}
					//sql4 = "update fteams set match_tied = " + tie+ "   where team= '" +t1 + "' and team= '" +t2 + "' ";
					sql4 = "update fteams set match_tied = " + tie+ "   where team= '" +t1 + "' ";
					myStmt2.executeUpdate(sql4);
					//sql44 = "update fteams set match_tied = " + tie+ "   where team= '" +t2 + "' ";
				//	myStmt2.executeUpdate(sql44);
					
					//String sql444 = "update fteams set match_played = " +m_played+ "  where team= '" +lose+ "' ";
					//myStmt2.executeUpdate(sql444);
					System.out.println("*****team1"+gd);
					String sql4444 = "update fteams set gd = " +gd+ "  where team= '" +t1 + "' ";
					myStmt2.executeUpdate(sql4444);
					
				//	System.out.println("*****team2"+gd);
					//String sql44444 = "update fteams set gd = " +gd+ "  where team= '" +t2 + "' ";
					//myStmt2.executeUpdate(sql44444);
			}
			
			
			// set tie match when team = team2
						String tt="yes";
						r=myStmt.executeQuery("select * from ffixture where tie = '" +tt+ "' ");		
						System.out.println("************Anon*********tie");
					//	String lose = null;
						//String t1=null;
						String t2=null;
						while(r.next()){
							System.out.println("Anon");
						//	t1=r.getString("team1");
						//	System.out.println(t1);
							t2=r.getString("team2");
							System.out.println(t2);
							
							//lose=r.getString("loser");
							//System.out.println(lose);
							int gdd=r.getInt("gd");
							System.out.println(gdd);
							System.out.println("fixture gd"+gdd);
							//float runrate=r.getFloat("runrate");
							rss=myStmt1.executeQuery("select * from fteams where team= '" +t2 + "' ");
							//rs=myStmt.executeQuery("select * from teams where team='c'");
							int loss = 0;
							
							
							int win = 0,m_played=0;
							int tie=0;
							int gd=0;
							//float rrate=0;
							while(rss.next()){
								System.out.println("Mehedee");
								//loss=rss.getInt("match_lose");
							//	System.out.println(loss);
								//loss++;
								
								tie=rss.getInt("match_tied");
								System.out.println(tie);
								tie++;
								
								//win=rss.getInt("match_win");
								//System.out.println(win);
							//	m_played = loss+win;
							//	System.out.println(win+loss+"zahidu"+m_played);
								
								gd=rss.getInt("gd");
								System.out.println(gd);
								gd= gd+gdd;
								System.out.println("*****"+gd);
								
							}
								//sql4 = "update fteams set match_tied = " + tie+ "   where team= '" +t1 + "' and team= '" +t2 + "' ";
								//sql4 = "update fteams set match_tied = " + tie+ "   where team= '" +t1 + "' ";
							//	myStmt2.executeUpdate(sql4);
								sql44 = "update fteams set match_tied = " + tie+ "   where team= '" +t2 + "' ";
								myStmt2.executeUpdate(sql44);
								
								//String sql444 = "update fteams set match_played = " +m_played+ "  where team= '" +lose+ "' ";
								//myStmt2.executeUpdate(sql444);
								//System.out.println("*****team1"+gd);
							//	String sql4444 = "update fteams set gd = " +gd+ "  where team= '" +t1 + "' ";
							//	myStmt2.executeUpdate(sql4444);
								
								System.out.println("*****team2"+gd);
								String sql44444 = "update fteams set gd = " +gd+ "  where team= '" +t2 + "' ";
								myStmt2.executeUpdate(sql44444);
						}
			
	
			
		}catch(Exception e){
			
		}
	}
	
	
	//*****load function**********
	public void load(){				//load function
		int totalMatch=0;
		
		//finding total number of match played by a team
		try {
			
			String sql1 = "select count(team) from fteams;";
			con = getConnection();
			myStat=con.createStatement();
			myRs=myStat.executeQuery(sql1);
			while(myRs.next()){
				t=myRs.getInt("count(team)");  // t= number of team
				 totalMatch=t-1;
				
			}
			
			//Set the values in Jtable
			String sql2 = "select * from fteams order by match_win desc,gd desc";
			myRs=myStat.executeQuery(sql2);
			while(myRs.next()){
				count=1;
				teams=myRs.getString("team");
				win=myRs.getInt("match_win");
				tie=myRs.getInt("match_tied");
				//float runrate=myRs.getFloat("net_runrate");
				int gd=myRs.getInt("gd");
				//float runrate=0;
				 
				points=(win*3)+(tie*1);
				 lose=myRs.getInt("match_lose");
				 match_played=win+lose+tie;
				 match_left=totalMatch-match_played;
				 
				
				//runrate=0;	
				model.addRow(new Object[]{teams,match_played,match_left,win,lose,tie,points,gd}); //write data in jtable
				count++;
				//System.out.println("Counts:"+count);
		} 
			
			//We show the points table in interface by jtable. So, we need not to create points_table in database
			//But as extra work,in following we create the  points_table in database by retrieving information from jtable
			
			String sql3="DROP TABLE IF EXISTS fpoints_table";
			myStat.execute(sql3);		
			String sql4="CREATE TABLE fpoints_table (team VARCHAR(45),win int(64),lose INT(64),tie INT(64),point INT(45),gd INT(45),PRIMARY KEY(team))";			
			myStat.execute(sql4);
			
			String sql31="DROP TABLE IF EXISTS fsemifinal";
			myStat.execute(sql31);		
			String sql41="CREATE TABLE fsemifinal (id INT(64) NOT NULL AUTO_INCREMENT,team1 VARCHAR(45),team2 VARCHAR(45), status VARCHAR(45),PRIMARY KEY(id))";	
			
			myStat.execute(sql41);
		
			
			//insert data into "points_table" in database
			String sql5=null;
			int row = model.getRowCount();
			for(int i=0;i<row;i++)
			{
				// tm=team ; w =win; l=lose; ti=tie; p=points, gd= goal difference 
				//i=row; '0' means 1st attribute, '1' means 2nd attribute ... of jtable
				String tm=String.valueOf(table.getValueAt(i, 0));
				String w=String.valueOf(table.getValueAt(i, 3));    
				String l=String.valueOf(table.getValueAt(i, 4));
				String ti=String.valueOf(table.getValueAt(i, 5));
				String p=String.valueOf(table.getValueAt(i, 6));
				String gd=String.valueOf(table.getValueAt(i, 7));
				//System.out.println(tm+" "+w+" "+l+" "+p);
				sql5="insert into fpoints_table values ('"+ tm +"','"+ w +"','"+ l +"','"+ ti +"','"+ p +"','"+ gd +"')";
				myStat.executeUpdate(sql5);
			}
			/*
			String sql51=null;
			for(int z=1;z<=2;z++)
			{
				sql51="insert into fsemifinal values('Not set','Not set','Not played')";		//insert a row that will be updated later
				myStat.execute(sql51);
				
			}*/
			
			
		}
			catch (Exception e) {
			System.out.println(e);
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
