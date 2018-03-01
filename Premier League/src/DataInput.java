import javax.swing.event.PopupMenuEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.event.PopupMenuListener;
import javax.swing.ImageIcon;

public class DataInput extends JFrame {

	private JPanel contentPane;

	// private JcomboBox s;
	private PreparedStatement statement;
	Connection con;
	// Statement myStat=con.createStatement();
	Statement myStat;
	ResultSet myRs;
	String Name;
	int mid=1;

	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	private JTextField status;
	private JTextField t1w;
	private JTextField t1o;
	private JTextField t1r;
	private JTextField t2r;
	private JTextField t2w;
	private JTextField t2o;

	// private JTextField t1;
	// private JTextField t2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// private PreparedStatement statement;
					// Connection con;
					DataInput frame = new DataInput();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public DataInput() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatchNo = new JLabel("Match No.");
		lblMatchNo.setForeground(new Color(47, 79, 79));
		lblMatchNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMatchNo.setBounds(41, 36, 76, 14);
		contentPane.add(lblMatchNo);

		JLabel lblTeam = new JLabel("Team 1");
		lblTeam.setForeground(new Color(75, 0, 130));
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam.setBounds(41, 61, 46, 14);
		contentPane.add(lblTeam);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		comboBox.setBackground(Color.PINK);
		comboBox.setBounds(123, 31, 66, 23);
		contentPane.add(comboBox);

		JLabel lblTeam_1 = new JLabel("Team 2");
		lblTeam_1.setForeground(new Color(75, 0, 130));
		lblTeam_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam_1.setBounds(368, 57, 46, 23);
		contentPane.add(lblTeam_1);

		JLabel lblStatusOfTeam = new JLabel("Winner");
		lblStatusOfTeam.setForeground(new Color(0, 51, 0));
		lblStatusOfTeam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatusOfTeam.setBounds(26, 248, 97, 14);
		contentPane.add(lblStatusOfTeam);

		JComboBox comboBox_1 = new JComboBox();

		comboBox_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		comboBox_1.setBounds(99, 243, 178, 23);
		contentPane.add(comboBox_1);

		JButton Menu = new JButton("Menu");
		Menu.setForeground(Color.WHITE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Menu.setBackground(Color.BLUE);
		Menu.setBounds(280, 316, 86, 23);
		contentPane.add(Menu);

		JLabel lblNewLabel = new JLabel("Data Input");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(260, -12, 200, 50);
		contentPane.add(lblNewLabel);
		t1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t1.setBackground(Color.CYAN);

		t1.setBounds(97, 57, 180, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		t2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t2.setBackground(Color.CYAN);

		t2.setBounds(424, 57, 180, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnDone.setBackground(Color.DARK_GRAY);
		btnDone.setBounds(289, 287, 66, 23);
		contentPane.add(btnDone);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(335, 248, 46, 14);
		contentPane.add(lblStatus);
		
		status = new JTextField();
		status.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		status.setBackground(new Color(253, 245, 230));
		status.setBounds(395, 244, 209, 20);
		contentPane.add(status);
		status.setColumns(10);
		
		JLabel lblRuns = new JLabel("Runs");
		lblRuns.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRuns.setBounds(41, 186, 46, 14);
		contentPane.add(lblRuns);
		
		JLabel lblWickets = new JLabel("Wickets");
		lblWickets.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWickets.setBounds(178, 186, 66, 14);
		contentPane.add(lblWickets);
		
		t1w = new JTextField();
		t1w.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1w.setBounds(239, 184, 38, 20);
		contentPane.add(t1w);
		t1w.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Overs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(41, 214, 51, 14);
		contentPane.add(lblNewLabel_1);
		
		t1o = new JTextField();
		t1o.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1o.setBounds(99, 212, 38, 20);
		contentPane.add(t1o);
		t1o.setColumns(10);
		
		JLabel label = new JLabel("Runs");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(368, 186, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Wickets");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(501, 186, 66, 14);
		contentPane.add(label_1);
		
		JLabel lblOvers = new JLabel("Overs");
		lblOvers.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOvers.setBounds(368, 214, 46, 14);
		contentPane.add(lblOvers);
		
		t1r = new JTextField();
		t1r.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1r.setBounds(100, 184, 46, 20);
		contentPane.add(t1r);
		t1r.setColumns(10);
		
		t2r = new JTextField();
		t2r.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2r.setBounds(424, 184, 46, 20);
		contentPane.add(t2r);
		t2r.setColumns(10);
		
		t2w = new JTextField();
		t2w.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2w.setBounds(565, 184, 38, 20);
		contentPane.add(t2w);
		t2w.setColumns(10);
		
		t2o = new JTextField();
		t2o.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2o.setBounds(424, 212, 46, 20);
		contentPane.add(t2o);
		t2o.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_2.setBackground(SystemColor.menu);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		comboBox_2.setBounds(99, 88, 51, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblRun = new JLabel("Run");
		lblRun.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblRun.setBounds(71, 91, 46, 14);
		contentPane.add(lblRun);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox_3.setBounds(238, 88, 39, 20);
		contentPane.add(comboBox_3);
		
		JLabel lblWicket = new JLabel("Wicket");
		lblWicket.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblWicket.setBounds(198, 91, 46, 14);
		contentPane.add(lblWicket);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox_4.setBounds(109, 119, 42, 20);
		contentPane.add(comboBox_4);
		
		JLabel lblOver = new JLabel("Overs");
		lblOver.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblOver.setBounds(71, 119, 46, 14);
		contentPane.add(lblOver);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_5.setBounds(238, 119, 39, 20);
		contentPane.add(comboBox_5);
		
		JLabel lblBall = new JLabel("Ball");
		lblBall.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblBall.setBounds(208, 122, 46, 14);
		contentPane.add(lblBall);
		
		JButton Submit1 = new JButton("Submit");
		Submit1.setFont(new Font("Tahoma", Font.BOLD, 11));
		Submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Submit1.setBounds(99, 152, 76, 23);
		contentPane.add(Submit1);
		
		JButton Show1 = new JButton("Show");
		Show1.setFont(new Font("Tahoma", Font.BOLD, 11));
		Show1.setBounds(201, 152, 76, 23);
		contentPane.add(Show1);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		comboBox_6.setBounds(423, 88, 51, 20);
		contentPane.add(comboBox_6);
		
		JLabel label_2 = new JLabel("Run");
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		label_2.setBounds(392, 91, 46, 14);
		contentPane.add(label_2);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox_7.setBounds(565, 88, 39, 20);
		contentPane.add(comboBox_7);
		
		JLabel lblWicket_1 = new JLabel("Wicket");
		lblWicket_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblWicket_1.setBounds(521, 91, 46, 14);
		contentPane.add(lblWicket_1);
		
		JButton InningsEnd1 = new JButton("Innings End");
		InningsEnd1.setFont(new Font("Tahoma", Font.BOLD, 12));
		InningsEnd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		InningsEnd1.setBounds(159, 211, 118, 23);
		contentPane.add(InningsEnd1);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_8.setBounds(433, 119, 42, 20);
		contentPane.add(comboBox_8);
		
		JLabel label_3 = new JLabel("Overs");
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		label_3.setBounds(392, 122, 46, 14);
		contentPane.add(label_3);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_9.setBounds(565, 119, 39, 20);
		contentPane.add(comboBox_9);
		
		JLabel label_4 = new JLabel("Ball");
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		label_4.setBounds(538, 121, 29, 14);
		contentPane.add(label_4);
		
		JButton Submit2 = new JButton("Submit");
		Submit2.setFont(new Font("Tahoma", Font.BOLD, 11));
		Submit2.setBounds(424, 152, 76, 23);
		contentPane.add(Submit2);
		
		JButton Show2 = new JButton("Show");
		Show2.setFont(new Font("Tahoma", Font.BOLD, 11));
		Show2.setBounds(528, 152, 76, 23);
		contentPane.add(Show2);
		
		JButton InningsEnd2 = new JButton("Innings End");
		InningsEnd2.setFont(new Font("Tahoma", Font.BOLD, 12));
		InningsEnd2.setBounds(486, 210, 118, 23);
		contentPane.add(InningsEnd2);
		
		 // self-written code for set values in ComboBox
				try {
					String sql = "select * from fixture";

					con = getConnection();
					// myStat=con.createStatement();
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet myRs = pst.executeQuery(sql);

					while (myRs.next()) {
						Name = myRs.getString("id");
						comboBox.addItem(Name);
						System.out.println(myRs.getString("team1") + " "
								+ myRs.getString("team2"));

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// comboBox.setModel(new javax.swing.DefaultComboBoxModel(new
				// String[]{"ROLL","MEAT","FISH","RICE","DRINKS"}));

		
		// self-written code for action listener for comboBox
	    comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.removeAllItems();
				t1r.setText(null);	//set "textField" to null
				t2r.setText(null);
				t1w.setText(null);
				t2w.setText(null);
				t1o.setText(null);
				t2o.setText(null);
				status.setText(null);
				
				// self-written code for comboBox to show value in textfield t1 and t2
				try {
					int i = 0;
					String tmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(tmp);
					String sql1 = "select * from fixture where id= ?";
					PreparedStatement pst = con.prepareStatement(sql1);
					pst.setInt(1, i);
					// pst.setInt(2,i);
					myRs = pst.executeQuery();

					while (myRs.next()) {
						String add = myRs.getString("team1");
						System.out.println(add);
						t1.setText(add);

						comboBox_1.addItem(add);
						String bdd = myRs.getString("team2");
						System.out.println(bdd);
						t2.setText(bdd);
						comboBox_1.addItem(bdd);
					}
				}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	    
	    //**********Submit1 button***************
		// Self-written code for defining the function of 'Submit1' button
		Submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int i = 0;
					String ttmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(ttmp);
					System.out.println("\nComboBox:" +i);
					Statement myStmt = con.createStatement();
					
					
					ResultSet r=myStmt.executeQuery("select * from mfixture where id= '" + i + "'");
					
					ResultSet rss;
					
					
					int run = 0;
					int wick=0;
					float over=0, ball=0,b=0,o=0;
					
					String tmp = (String) comboBox_2.getSelectedItem();
					run = Integer.parseInt(tmp);
					System.out.println("\nComboBox:Run" +run);
				
					
					String tmp1 = (String) comboBox_3.getSelectedItem();
					wick=Integer.parseInt(tmp1);
					if(wick==1)
						run=0;
					
					String tmp2 = (String) comboBox_4.getSelectedItem();
					o=Integer.parseInt(tmp2);
					//System.out.println("\n Over:" +o);
					String tmp3 = (String) comboBox_5.getSelectedItem();
					b=Integer.parseInt(tmp3);
					System.out.println("\n ball:" +b);
					
					//System.out.println("\n balls:" +ball);
					
					if(b==6)
					{
						ball=0;
						o=o+1;
						over = o+ball;
					}
					else
					{
						ball=b/10;
						over = o+ball;
					}
					
					System.out.println("\nOvers:" +over);
					while(r.next()){
						System.out.println("Anonwinner");
						String srun=r.getString("team1_runs");
						System.out.println(srun);
						int rr=Integer.parseInt(srun);
						run=run+rr;
						System.out.println("\nRuns:" +run);
						String swick=r.getString("team1_wick");
						System.out.println(swick);
						int w=Integer.parseInt(swick);
						wick=wick+w;
						
					}
					
					
					
					String p1 = t1.getText().trim();
					String p2 = t2.getText().trim();
					
					String sql5 = "update mfixture set team1_runs = '" + run
							+ "'   where id= '" + i + "' and team1= '" + p1 + "'";
					String sql6 = "update mfixture set team1_wick = '" + wick
							+ "'   where id= '" + i + "' and team1= '" + p1 + "'";
					String sql7 = "update mfixture set team1_overs = '" + over
							+ "'   where id= '" + i + "' and team1= '" + p1 + "'";
					int val=myStmt.executeUpdate(sql5);
					int val1=myStmt.executeUpdate(sql6);
					int val2=myStmt.executeUpdate(sql7);
					if(val>=1&&val1>=1&&val2>=1)
					{
						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
					}
					
									}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		//*********Show1 button************
		// self-written code for action listener for Show1 button
	    Show1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// self-written code for comboBox to show value in textfield t1 and t2
				try {
					int i = 0;
					String tmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(tmp);
					String sql1 = "select * from mfixture where id= ?";
					PreparedStatement pst = con.prepareStatement(sql1);
					pst.setInt(1, i);
					// pst.setInt(2,i);
					myRs = pst.executeQuery();

					while (myRs.next()) {
						String runs = myRs.getString("team1_runs");
						System.out.println(runs);
						t1r.setText(runs);
						
						String wicket = myRs.getString("team1_wick");
						System.out.println(wicket);
						t1w.setText(wicket);

						String overs = myRs.getString("team1_overs");
						System.out.println(overs);
						t1o.setText(overs);


					}
				}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	    
	    
	    //*******Innings End1 button****************
	 // Self-written code for defining the function of 'Done' button
	    InningsEnd1.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent arg0) {
	 				
	 				try {
	 					
	 					int i = 0;
	 					
	 					String tmp = (String) comboBox.getSelectedItem();
	 					i = Integer.parseInt(tmp);
	 					System.out.println("\nComboBox:" +i);

	 					Statement myStmt = con.createStatement();
	 					String p1 = t1.getText().trim();
						String p2 = t2.getText().trim();
	 			
	 					String sql2, sql3,sql4,sql5,sql6,sql7,sql8, winner = null, loser = null;
	 				
	 					
	 					//set team1  runs,overs
	 					
	 					String r1 = t1r.getText().trim();	//r1 = run of team1
	 					String w1 = t1w.getText().trim();	//w1 = wickets of team1
	 					String o1 = t1o.getText().trim();
	 					
	 					float r11= Float.parseFloat(r1);
	 					float w11= Float.parseFloat(w1);
	 					float o11= Float.parseFloat(o1);

	 					if(w11==10)
	 						o11=15;	      //Assume total over = 15
	 					
	 					sql5 = "update fixture set team1_runs = '" + r11
	 							+ "'   where id= '" + i + "' and team1= '" + p1 + "'";
	 					
	 					sql7 = "update fixture set team1_overs = '" + o11
	 							+ "'   where id= '" + i + "' and team1= '" + p1 + "'";

	 					int val3=myStmt.executeUpdate(sql5);
	 					int val5=myStmt.executeUpdate(sql7);
	 					//if(val>=1&&val1>=1&&val2>=1&&val3>=1&&(p3.length()!=0))
	 					if(val3>=1&&val5>=1)
	 					{
	 						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
	 					}
	 					
	 					
	 				}

	 				catch (Exception e1) {
	 					// TODO Auto-generated catch block
	 					e1.printStackTrace();
	 				}
	 			}
	 		});

	    
	    
	    //*
	    //**********Submit2 button***************
		// Self-written code for defining the function of 'Submit1' button
		Submit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					int i = 0;
					String ttmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(ttmp);
					System.out.println("\nComboBox:" +i);
					
					Statement myStmt = con.createStatement();
					ResultSet r=myStmt.executeQuery("select * from mfixture where id= '" + i + "'");
					ResultSet rss;
					
					int run = 0;
					int wick=0;
					float over=0, ball=0,b=0,o=0;
					
					String tmp = (String) comboBox_6.getSelectedItem();
					run = Integer.parseInt(tmp);
					//System.out.println("\nComboBox:" +i);
					 
					System.out.println("\nRuns:" +run);
					
					String tmp1 = (String) comboBox_7.getSelectedItem();
					wick=Integer.parseInt(tmp1);
					if(wick==1)
						run=0;
				
					
					String tmp2 = (String) comboBox_8.getSelectedItem();
					o=Integer.parseInt(tmp2);
					//System.out.println("\n Over:" +o);
					String tmp3 = (String) comboBox_9.getSelectedItem();
					b=Integer.parseInt(tmp3);
					System.out.println("\n ball:" +b);
					
					//System.out.println("\n balls:" +ball);
					
					if(b==6)
					{
						ball=0;
						o=o+1;
						over = o+ball;
					}
					else
					{
						ball=b/10;
						over = o+ball;
					}
					
					System.out.println("\nOvers:" +over);
					
					while(r.next()){
						System.out.println("Anonwinner");
						String srun=r.getString("team2_runs");
						System.out.println(srun);
						int rr=Integer.parseInt(srun);
						run=run+rr;
						
						String swick=r.getString("team2_wick");
						System.out.println(swick);
						int w=Integer.parseInt(swick);
						wick=wick+w;
					}
					
					
				
					
					String p1 = t1.getText().trim();
					String p2 = t2.getText().trim();
					
					String sql5 = "update mfixture set team2_runs = '" + run
							+ "'   where id= '" + i + "' and team2= '" + p2 + "'";
					String sql6 = "update mfixture set team2_wick = '" + wick
							+ "'   where id= '" + i + "' and team2= '" + p2 + "'";
					String sql7 = "update mfixture set team2_overs = '" + over
							+ "'   where id= '" + i + "' and team2= '" + p2 + "'";
					int val=myStmt.executeUpdate(sql5);
					int val1=myStmt.executeUpdate(sql6);
					int val2=myStmt.executeUpdate(sql7);
					if(val>=1&&val1>=1&&val2>=1)
					{
						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
					}
					
									}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		//*********Show2 button************
		// self-written code for action listener for Show1 button
	    Show2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//comboBox_1.removeAllItems();
				//t1r.setText(null);	//set "textField" to null
			//	t2r.setText(null);
			//	t1w.setText(null);
			//	t2w.setText(null);
			//	t1o.setText(null);
			//	t2o.setText(null);
			//	status.setText(null);
				
				// self-written code for comboBox to show value in textfield t1 and t2
				try {
					int i = 0;
					String tmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(tmp);
					String sql1 = "select * from mfixture where id= ?";
					PreparedStatement pst = con.prepareStatement(sql1);
					pst.setInt(1, i);
					// pst.setInt(2,i);
					myRs = pst.executeQuery();

					while (myRs.next()) {
						String runs = myRs.getString("team2_runs");
						System.out.println(runs);
						t2r.setText(runs);
						
						String wicket = myRs.getString("team2_wick");
						System.out.println(wicket);
						t2w.setText(wicket);

						String overs = myRs.getString("team2_overs");
						System.out.println(overs);
						t2o.setText(overs);


					}
				}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	    
	    
	    //*******Innings End2 button****************
	 // Self-written code for defining the function of 'Done' button
	    InningsEnd2.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent arg0) {
	 				
	 				try {
	 					
	 					int i = 0;
	 					
	 					String tmp = (String) comboBox.getSelectedItem();
	 					i = Integer.parseInt(tmp);
	 					System.out.println("\nComboBox:" +i);

	 					Statement myStmt = con.createStatement();
	 					String p1 = t1.getText().trim();
						String p2 = t2.getText().trim();
	 			
	 					String sql2, sql3,sql4,sql5,sql6,sql7,sql8, winner = null, loser = null;
	 				
	 					
	 					//set team2  runs,overs
	 					
	 					String r2 = t2r.getText().trim();	//r1 = run of team1
	 					String w2 = t2w.getText().trim();	//w1 = wickets of team1
	 					String o2 = t2o.getText().trim();
	 					
	 					float r22= Float.parseFloat(r2);
	 					float w22= Float.parseFloat(w2);
	 					float o22= Float.parseFloat(o2);

	 					if(w22==10)
	 						o22=15;	      //Assume total over = 15
	 					
	 					sql5 = "update fixture set team2_runs = '" + r22
	 							+ "'   where id= '" + i + "' and team2= '" + p2 + "'";
	 					
	 					sql7 = "update fixture set team2_overs = '" + o22
	 							+ "'   where id= '" + i + "' and team2= '" + p2 + "'";

	 					int val3=myStmt.executeUpdate(sql5);
	 					int val5=myStmt.executeUpdate(sql7);
	 					//if(val>=1&&val1>=1&&val2>=1&&val3>=1&&(p3.length()!=0))
	 					if(val3>=1&&val5>=1)
	 					{
	 						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
	 					}
	 				}

	 				catch (Exception e1) {
	 					// TODO Auto-generated catch block
	 					e1.printStackTrace();
	 				}
	 			}
	 		});

	    
	    
	    
		// Self-written code for defining the function of 'Done' button
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					int i = 0;
					
					String tmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(tmp);
					System.out.println("\nComboBox:" +i);
					
					
					String tmp1 = (String) comboBox_1.getSelectedItem();
					tmp1=tmp1.trim();				//trim() method is used to remove unwanted "blank space" in variable
					// String p1=t1.getText();

					Statement myStmt = con.createStatement();
					//Statement myStmt1 = con.createStatement();
					//Statement myStmt2 = con.createStatement();
					String sql2, sql3,sql4,sql5,sql6,sql7,sql8, winner = null, loser = null;
				//	String t3,t4;

					String p1 = t1.getText().trim();
					String p2 = t2.getText().trim();
					String p3 = status.getText().trim();
					System.out.println(p3);
					//String p4 = netrunrate.getText().trim();
					// int count=1;

					if (tmp1.equals(p1)) {		//equals()method is used in place of '==' operator
						winner = p1;
						loser = p2;
						System.out.println("\nWinner is:" + p1);
						
					}
					
					else{
						winner = p2;
						loser = p1;
						System.out.println("\nWinner is:" + p2);
					}
					
					System.out.println(tmp1+","+winner+","+loser);
					
					
					//update values in fixture table
					sql2 = "update fixture set winner = '" + winner
							+ "'   where id= '" + i + "' ";

					sql3 = "update fixture set loser = '" + loser
							+ "'  where id= '" + i + "' ";
					sql4 = "update fixture set status = '" + p3
							+ "'  where id= '" + i + "' ";
					
					//Show message box
					if(p3.length()==0)
					{
						JOptionPane.showMessageDialog(null, "Status Field missing","Input error", JOptionPane.ERROR_MESSAGE);
					}
					
					
					int val=myStmt.executeUpdate(sql2);
					int val1=myStmt.executeUpdate(sql3);
					int val2=myStmt.executeUpdate(sql4);
					
					if(val>=1&&val1>=1&&val2>=1&&(p3.length()!=0))
					{
						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
					}
				}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
	
		
		
		
		
		
		
		//Self-written code for defining the function of textfield "t1r"
		t1r.addKeyListener(new KeyAdapter() {
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
		
		//Self-written code for defining the function of textfield "t1w"
				t1w.addKeyListener(new KeyAdapter() {
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
		
		//Self-written code for defining the function of textfield "t2o"
				t2o.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c= e.getKeyChar();
						//IF condition checks whether I pressed digit/backspace/delete key
						if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_PERIOD)))
						{
							getToolkit().beep();  //when we try to press any character, a beep will heard
							e.consume();  //if condition is true, keytyped event is consumed, i.e. it will not be typed
						}
					}
				});
				
		//Self-written code for defining the function of textfield "t2r"
				t2r.addKeyListener(new KeyAdapter() {
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
		
	   //Self-written code for defining the function of textfield "t2w"
				t2w.addKeyListener(new KeyAdapter() {
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
		
		//Self-written code for defining the function of textfield "t2o"
				t2o.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c= e.getKeyChar();
						//IF condition checks whether I pressed digit/backspace/delete key
						if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_PERIOD)))
						{
							getToolkit().beep();  //when we try to press any character, a beep will heard
							e.consume();  //if condition is true, keytyped event is consumed, i.e. it will not be typed
						}
					}
				});
		// Self-written code for defining the function of 'Menu' button
				Menu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Menubar nw = null; // "Menubar" is the next frame by clicking "Menu" button
												
						try {
							nw = new Menubar();
						} catch (Exception e1) {
							
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
