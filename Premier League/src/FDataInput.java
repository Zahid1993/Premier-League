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

public class FDataInput extends JFrame {

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
	private JTextField t1g;
	private JTextField t2g;

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
					FDataInput frame = new FDataInput();
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
	public FDataInput() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatchNo = new JLabel("Match No.");
		lblMatchNo.setForeground(Color.WHITE);
		lblMatchNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMatchNo.setBounds(37, 59, 76, 14);
		contentPane.add(lblMatchNo);

		JLabel lblTeam = new JLabel("Team 1");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam.setBounds(37, 89, 46, 14);
		contentPane.add(lblTeam);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		comboBox.setBackground(Color.PINK);
		comboBox.setBounds(115, 54, 66, 23);
		contentPane.add(comboBox);

		JLabel lblTeam_1 = new JLabel("Team 2");
		lblTeam_1.setForeground(Color.WHITE);
		lblTeam_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam_1.setBounds(37, 146, 46, 23);
		contentPane.add(lblTeam_1);

		JButton Menu = new JButton("Menu");
		Menu.setForeground(Color.WHITE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Menu.setBackground(Color.BLUE);
		Menu.setBounds(280, 316, 86, 23);
		contentPane.add(Menu);

		JLabel lblNewLabel = new JLabel("Data Input");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(259, 0, 200, 50);
		contentPane.add(lblNewLabel);
		t1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t1.setBackground(Color.CYAN);

		t1.setBounds(115, 84, 180, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		t2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t2.setBackground(Color.CYAN);

		t2.setBounds(115, 146, 180, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnDone.setBackground(Color.DARK_GRAY);
		btnDone.setBounds(288, 268, 66, 23);
		contentPane.add(btnDone);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(37, 235, 46, 14);
		contentPane.add(lblStatus);
		
		status = new JTextField();
		status.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		status.setBackground(new Color(253, 245, 230));
		status.setBounds(115, 231, 209, 20);
		contentPane.add(status);
		status.setColumns(10);
		
		JLabel lblRuns = new JLabel("Goals");
		lblRuns.setForeground(Color.WHITE);
		lblRuns.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRuns.setBounds(37, 114, 46, 14);
		contentPane.add(lblRuns);
		
		JLabel lblGoals = new JLabel("Goals");
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGoals.setBounds(37, 181, 46, 14);
		contentPane.add(lblGoals);
		
		t1g = new JTextField();
		t1g.setBounds(115, 115, 86, 20);
		contentPane.add(t1g);
		t1g.setColumns(10);
		
		t2g = new JTextField();
		t2g.setBounds(115, 179, 86, 20);
		contentPane.add(t2g);
		t2g.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\Books\\Y-3,S-1\\Database  Management  System\\Project\\Cricket Tournament\\Cricket Images\\Football\\Untitled-1 copy.jpg"));
		lblNewLabel_1.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(FDataInput.class.getResource("/Images/FDataInput.jpg")));
		lblNewLabel_2.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel_2);
		
		 // self-written code for set values in ComboBox
				try {
					String sql = "select * from ffixture";

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
				//comboBox_1.removeAllItems();
				t1g.setText(null);	//set "textField" to null
				t2g.setText(null);
				status.setText(null);
				
				// self-written code for comboBox to show value in textfield t1 and t2
				try {
					int i = 0;
					String tmp = (String) comboBox.getSelectedItem();
					i = Integer.parseInt(tmp);
					String sql1 = "select * from ffixture where id= ?";
					PreparedStatement pst = con.prepareStatement(sql1);
					pst.setInt(1, i);
					// pst.setInt(2,i);
					myRs = pst.executeQuery();

					while (myRs.next()) {
						String add = myRs.getString("team1");
						System.out.println(add);
						t1.setText(add);

						//comboBox_1.addItem(add);
						String bdd = myRs.getString("team2");
						System.out.println(bdd);
						t2.setText(bdd);
						//comboBox_1.addItem(bdd);
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
					
					
					//String tmp1 = (String) comboBox_1.getSelectedItem();
					//tmp1=tmp1.trim();				//trim() method is used to remove unwanted "blank space" in variable
					// String p1=t1.getText();

					Statement myStmt = con.createStatement();
					//Statement myStmt1 = con.createStatement();
					//Statement myStmt2 = con.createStatement();
					String sql2, sql3,sql33,sql4,sql5,sql6,sql7,sql8, winner = null, loser = null, tie=null;
				//	String t3,t4;

					String p1 = t1.getText().trim();
					//int p11=Integer.parseInt(p1);
					
					String p2 = t2.getText().trim();
					//int p22=Integer.parseInt(p2);
					
					String p3 = status.getText().trim();
					
					String r1 = t1g.getText().trim();	//r1 = run of team1
					String r2 = t2g.getText().trim();	//r2 = run of team2
					
					
					int r11= Integer.parseInt(r1);
					int r22= Integer.parseInt(r2);
					
					System.out.println(p3);
					//String p4 = netrunrate.getText().trim();
					// int count=1;
/*
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
					*/
					
					if(r11>r22)
					{
						winner = p1;
						loser = p2;
						tie="no";
						System.out.println("\nWinner is:" + p1);
					}
					
					else if(r11<r22)
					{
						winner = p2;
						loser = p1;
						tie="no";
						System.out.println("\nWinner is:" + p2);
					}
					
					else
					{
						winner = "none";
						loser = "none";
						tie= "yes";
					}
					System.out.println(winner+","+loser);
					
					//update values in ffixture table
					sql2 = "update ffixture set winner = '" + winner
							+ "'   where id= '" + i + "' ";

					sql3 = "update ffixture set loser = '" + loser
							+ "'  where id= '" + i + "' ";
					
					sql33 = "update ffixture set tie = '" + tie
							+ "'  where id= '" + i + "' ";
					
					sql4 = "update ffixture set status = '" + p3
							+ "'  where id= '" + i + "' ";
					
					//Show message box
					if(p3.length()==0)
					{
						JOptionPane.showMessageDialog(null, "Status Field missing","Input error", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					//set goal difference(gd)
					
					int gd=0;
					
					gd=r11-r22;
					if(gd<0)
						gd=-gd;
					System.out.println("\nGD is:" + gd);
				
					
					sql5 = "update ffixture set team1_goals = '" + r11
							+ "'   where id= '" + i + "' and team1= '" + p1 + "'";
					
					sql6 = "update ffixture set team2_goals = '" + r22
							+ "'   where id= '" + i + "' and team2= '" + p2 + "'";
					
					sql7 = "update ffixture set gd = '" + gd
							+ "'   where id= '" + i + "'";
					
					
					
					int val=myStmt.executeUpdate(sql2);
					int val1=myStmt.executeUpdate(sql3);
					int val11=myStmt.executeUpdate(sql33);
					int val2=myStmt.executeUpdate(sql4);
					int val3=myStmt.executeUpdate(sql5);
					int val4=myStmt.executeUpdate(sql6);
					int val5=myStmt.executeUpdate(sql7);
					
					//if(val>=1&&val1>=1&&val2>=1&&val3>=1&&(p3.length()!=0))
					if(val>=1&&val1>=1&&val11>=1&&val2>=1&&val3>=1&&val4>=1&&val5>=1&&(p3.length()!=0))
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
		t1g.addKeyListener(new KeyAdapter() {
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
				
		//Self-written code for defining the function of textfield "t2r"
				t2g.addKeyListener(new KeyAdapter() {
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
		// Self-written code for defining the function of 'Menu' button
				Menu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FMenubar nw = null; // "Menubar" is the next frame by clicking "Menu" button
												
						try {
							nw = new FMenubar();
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
