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


public class PointsTable extends JFrame {

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
	int match_played;
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
					PointsTable frame = new PointsTable();
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
	public PointsTable() {
		
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
				"Teams", "Played", "Left", "Win", "Lose", "Points", "NRR"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class, String.class, String.class, Float.class
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
	//	table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.setBounds(40, 89, 389, 169);
		contentPane.add(table);
		
		JLabel lblTeam = new JLabel("Teams");
		lblTeam.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblTeam.setBounds(40, 68, 46, 14);
		contentPane.add(lblTeam);
		
		JLabel lblWin = new JLabel("Win");
		lblWin.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblWin.setBounds(247, 68, 30, 14);
		contentPane.add(lblWin);
		
		JLabel lblLose = new JLabel("Lose");
		lblLose.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblLose.setBounds(287, 68, 35, 14);
		contentPane.add(lblLose);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPoints.setBounds(332, 68, 46, 14);
		contentPane.add(lblPoints);
		
		JLabel lblMatchLeft = new JLabel("Left");
		lblMatchLeft.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblMatchLeft.setBounds(202, 68, 35, 14);
		contentPane.add(lblMatchLeft);
		
		JButton Menu = new JButton("Menu");
		Menu.setForeground(Color.WHITE);
		Menu.setBackground(Color.BLUE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		Menu.setBounds(322, 303, 89, 23);
		contentPane.add(Menu);
		
		JLabel lblPlayed = new JLabel("Played");
		lblPlayed.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPlayed.setBounds(146, 68, 46, 14);
		contentPane.add(lblPlayed);
		
		JLabel lblRunRate = new JLabel("NRR");
		lblRunRate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblRunRate.setBounds(392, 68, 62, 14);
		contentPane.add(lblRunRate);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PointsTable.class.getResource("/Images/Points Table.jpg")));
		lblNewLabel.setBounds(0, 0, 629, 358);
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
						 String sql00 = "select count(id) from fixture";
						 con = getConnection();
						 myStat=con.createStatement();
						 myRs=myStat.executeQuery(sql00);
						 while(myRs.next())
						 {
					     m=myRs.getInt("count(id)");  // t= number of team
					     System.out.println("Number of teams:"+m);
						 }
						 
						//Restriction to "SemiFinal" button 
						String sql0 = "select * from fixture where (winner='Not set' and loser='Not set')";
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
						SemiFinal nw = null; 
						nw = new SemiFinal();

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
			ResultSet rsss=myStmt.executeQuery("select * from teams");
			while(rsss.next()){
				System.out.println("Rahman");
				String na=rsss.getString("team");
				sql6 = "update teams set match_win =0, match_lose=0,match_played=0, runs=0, overs=0, a_runs=0, a_overs=0, net_runrate=0  where team= '" +na+ "' ";
				myStmt3.executeUpdate(sql6);
			}
			
			
			//set the values in "teams" table [i.e.match_win , match_lose, match_played]
			ResultSet r=myStmt.executeQuery("select * from fixture");
			
			ResultSet rss;
			
			String won = null;
			while(r.next()){
				System.out.println("Anonwinner");
				won=r.getString("winner");
				System.out.println(won);
				//float runrate=r.getFloat("runrate");
				//System.out.println(runrate);
			
				rss=myStmt1.executeQuery("select * from teams where team= '" +won+ "'");
				//rs=myStmt.executeQuery("select * from teams where team='c'");
				int win = 0;
				
				int loss = 0,m_played=0;
				while(rss.next()){
					System.out.println("Mehedee");
					win=rss.getInt("match_win");
					System.out.println(win);
					win++;
				
					loss=rss.getInt("match_lose");
					System.out.println(loss);
					m_played = loss+win;
				}
					sql4 = "update teams set match_win = " + win+ "   where team= '" +won+ "' ";
					myStmt2.executeUpdate(sql4);
					String sql444 = "update teams set match_played = " +m_played+ "  where team= '" +won+ "' ";
					myStmt2.executeUpdate(sql444);
					
			
			}
			
			r=myStmt.executeQuery("select * from fixture");		
			String lose = null;
			while(r.next()){
				System.out.println("Anon");
				lose=r.getString("loser");
				System.out.println(lose);
				//float runrate=r.getFloat("runrate");
				rss=myStmt1.executeQuery("select * from teams where team= '" +lose+ "'");
				//rs=myStmt.executeQuery("select * from teams where team='c'");
				int loss = 0;
				
				
				int win = 0,m_played=0;
				//float rrate=0;
				while(rss.next()){
					System.out.println("Mehedee");
					loss=rss.getInt("match_lose");
					System.out.println(loss);
					loss++;
					
					win=rss.getInt("match_win");
					System.out.println(win);
					m_played = loss+win;
					System.out.println(win+loss+"zahidu"+m_played);
					
				}
					sql4 = "update teams set match_lose = " + loss+ "   where team= '" +lose+ "' ";
					myStmt2.executeUpdate(sql4);
					String sql444 = "update teams set match_played = " +m_played+ "  where team= '" +lose+ "' ";
					myStmt2.executeUpdate(sql444);
			}
			
			
	
			//set the values in "teams" table [i.e.team runs,overs,a_runs,a_overs ; when team=team1]
			
			 r=myStmt.executeQuery("select * from fixture");
			 
			 System.out.println("zahidur rahman");
			
			while(r.next()){
				
				String team1=r.getString("team1");
				System.out.println(team1);
				String team2=r.getString("team2");
				System.out.println(team2);
				float r1=r.getFloat("team1_runs");
				System.out.println(r1);
				float r2=r.getFloat("team2_runs");
				System.out.println(r2);
				float o1=r.getFloat("team1_overs");
				System.out.println(o1);
				float o2=r.getFloat("team2_overs");
				System.out.println(o2);
				//System.out.println(runrate);
			
				rss=myStmt1.executeQuery("select * from teams where team='" +team1+ "'");
				float runs=0;
				float overs=0;
				float a_runs=0;
				float a_overs=0;
				float nrr=0;
				
				while(rss.next()){
					System.out.println("Zahid team1");
					String team=rss.getString("team");
					System.out.println(team);
					
					
					runs=rss.getFloat("runs");
				//	System.out.println(runs);
					overs=rss.getFloat("overs");
				//	System.out.println(overs);
					a_runs=rss.getFloat("a_runs");
				//	System.out.println(a_runs);
					a_overs=rss.getFloat("a_overs");
				//	System.out.println(a_overs);
					
						runs= runs + r1;
						overs=overs+o1;
						a_runs=a_runs+r2;
						a_overs=a_overs+o2;
					//	nrr= (runs/overs) - (a_runs/a_overs);
						
						sql4 = "update teams set runs = " + runs+ " ,overs= " + overs+ " , a_runs= " + a_runs+ ", a_overs= " + a_overs+ "  where team= '" +team1+ "' ";
						myStmt2.executeUpdate(sql4);
						
					//	sql44 = "update teams set net_runrate = " + nrr+ "  where team= '" +team1+ "' ";
					//	myStmt2.executeUpdate(sql44);
				}		
			
			}
			
			//set the values in "teams" table [i.e.team runs,overs,a_runs,a_overs ; when team=team2]
			
			r=myStmt.executeQuery("select * from fixture");
			 
			 System.out.println("zahidur rahman cou");
			
			while(r.next()){
				
				String team1=r.getString("team1");
				System.out.println(team1);
				String team2=r.getString("team2");
				System.out.println(team2);
				float r1=r.getFloat("team1_runs");
				System.out.println(r1);
				float r2=r.getFloat("team2_runs");
				System.out.println(r2);
				float o1=r.getFloat("team1_overs");
				System.out.println(o1);
				float o2=r.getFloat("team2_overs");
				System.out.println(o2);
				//System.out.println(runrate);
			
				rss=myStmt1.executeQuery("select * from teams where team='" +team2+ "'");
				float runs=0;
				float overs=0;
				float a_runs=0;
				float a_overs=0;
				float nrr=0;
				
				while(rss.next()){
					System.out.println("Zahid team2");
					String team=rss.getString("team");
					System.out.println(team);
					
					
					runs=rss.getFloat("runs");
					System.out.println(runs);
					overs=rss.getFloat("overs");
					System.out.println(overs);
					a_runs=rss.getFloat("a_runs");
					System.out.println(a_runs);
					a_overs=rss.getFloat("a_overs");
					System.out.println(a_overs);
					
						runs= runs + r2;
						overs=overs+o2;
						a_runs=a_runs+r1;
						a_overs=a_overs+o1;
						
						//nrr= (runs/overs) - (a_runs/a_overs);
						//sql44 = "update teams set runs = " + runs+ " ,overs= " + overs+ " , a_runs= " + a_runs+ ", a_overs= " + a_overs+ ",net_runrate = " + nrr+ "  where team= '" +team2+ "' ";
						sql4 = "update teams set runs = " + runs+ " ,overs= " + overs+ " , a_runs= " + a_runs+ ", a_overs= " + a_overs+ "  where team= '" +team2+ "' ";
						myStmt2.executeUpdate(sql4);
						//sql44 = "update teams set net_runrate = " + nrr+ "  where team= '" +team2+ "' ";
						//myStmt2.executeUpdate(sql44);
						
								
				}		
			
			}
			
			
			// set net_runrate in teams table
			
				r=myStmt4.executeQuery("select * from teams order by match_played desc ");
				float runs=0;
				float overs=0;
				float a_runs=0;
				float a_overs=0;
				float nrr=0;
				int i=0;
				while(r.next()){
					i++;
					System.out.println("Zahid parce");
					System.out.println("Count"+i);
					String t=r.getString("team");
					System.out.println(t);
					
					
					runs=r.getFloat("runs");
					System.out.println(runs);
					overs=r.getFloat("overs");
					System.out.println(overs);
					a_runs=r.getFloat("a_runs");
					System.out.println(a_runs);
					a_overs=r.getFloat("a_overs");
					System.out.println(a_overs);
					
						nrr= (runs/overs) - (a_runs/a_overs);
						
						System.out.println("Run rate"+"	"+nrr);
						sql44 = "update teams set net_runrate = " + nrr+ "  where team= '" +t+ "' ";
						myStmt5.executeUpdate(sql44);
						
								
				}	
		
			
		}catch(Exception e){
			
		}
	}
	
	
	//*****load function**********
	public void load(){				//load function
		int totalMatch=0;
		
		//finding total number of match played by a team
		try {
			
			String sql1 = "select count(team) from teams;";
			con = getConnection();
			myStat=con.createStatement();
			myRs=myStat.executeQuery(sql1);
			while(myRs.next()){
				t=myRs.getInt("count(team)");  // t= number of team
				 totalMatch=t-1;
				
			}
			
			//Set the values in Jtable
			String sql2 = "select * from teams order by match_win desc,net_runrate desc";
			myRs=myStat.executeQuery(sql2);
			while(myRs.next()){
				count=1;
				teams=myRs.getString("team");
				win=myRs.getInt("match_win");
				float runrate=myRs.getFloat("net_runrate");
				//float runrate=0;
				 points=win*3;
				 lose=myRs.getInt("match_lose");
				 match_played=win+lose;
				 match_left=totalMatch-match_played;
				 
				
				//runrate=0;	
				model.addRow(new Object[]{teams,match_played,match_left,win,lose,points,runrate}); //write data in jtable
				count++;
				//System.out.println("Counts:"+count);
		} 
			
			//We show the points table in interface by jtable. So, we need not to create points_table in database
			//But as extra work,in following we create the  points_table in database by retrieving information from jtable
			
			String sql3="DROP TABLE IF EXISTS points_table";
			myStat.execute(sql3);		
			String sql4="CREATE TABLE points_table (team VARCHAR(45),win int(64),lose INT(64),point INT(45),runrate FLOAT(45),PRIMARY KEY(team))";			
			myStat.execute(sql4);
			
			String sql31="DROP TABLE IF EXISTS semifinal";
			myStat.execute(sql31);		
			String sql41="CREATE TABLE semifinal (id INT(64) NOT NULL AUTO_INCREMENT,team1 VARCHAR(45),team2 VARCHAR(45), status VARCHAR(45),PRIMARY KEY(id))";	
			
			myStat.execute(sql41);
			
			//insert data into "points_table" in database
			String sql5=null;
			int row = model.getRowCount();
			for(int i=0;i<row;i++)
			{
				// tm=team ; w =win; l=lose; p=points, r=run rate 
				//i=row; '0' means 1st attribute, '1' means 2nd attribute ... of jtable
				String tm=String.valueOf(table.getValueAt(i, 0));
				String w=String.valueOf(table.getValueAt(i, 3));    
				String l=String.valueOf(table.getValueAt(i, 4));
				String p=String.valueOf(table.getValueAt(i, 5));
				String r=String.valueOf(table.getValueAt(i, 6));
				//System.out.println(tm+" "+w+" "+l+" "+p);
				sql5="insert into points_table values ('"+ tm +"','"+ w +"','"+ l +"','"+ p +"','"+ r +"')";
				myStat.executeUpdate(sql5);
			}
			
			
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
