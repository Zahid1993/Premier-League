import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.ImageIcon;


public class Final extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	
	int z=0;	//for show button
	Connection con;
	Statement myStat;
	ResultSet myRs;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final frame = new Final();
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
	public Final() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFinal = new JLabel("Final");
		lblFinal.setForeground(new Color(0, 128, 0));
		lblFinal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFinal.setBounds(277, 11, 46, 20);
		contentPane.add(lblFinal);
		
		JLabel lblTeam = new JLabel("Team 1");
		lblTeam.setForeground(new Color(255, 255, 255));
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam.setBounds(38, 73, 61, 14);
		contentPane.add(lblTeam);
		
		t1 = new JTextField();
		t1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t1.setBounds(97, 72, 129, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblTeam_1 = new JLabel("Team 2");
		lblTeam_1.setForeground(new Color(0, 0, 255));
		lblTeam_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam_1.setBounds(323, 73, 61, 14);
		contentPane.add(lblTeam_1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		t2.setBounds(380, 72, 129, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblWinner = new JLabel("Winner");
		lblWinner.setForeground(new Color(47, 79, 79));
		lblWinner.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWinner.setBounds(107, 199, 78, 14);
		contentPane.add(lblWinner);
		
		JComboBox comboBox = new JComboBox();		//Declare a comboBox
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		comboBox.setBounds(177, 193, 162, 27);
		contentPane.add(comboBox);
		
		JButton Update = new JButton("Update");
		Update.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		Update.setBounds(277, 259, 89, 27);
		contentPane.add(Update);
		
		JButton Show = new JButton("Show");
		Show.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		//Self-written code for defining the function of 'Show' button
				Show.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//ShowWinner nw = null;    //"ShowWinner" is the next frame by clicking "Show" button
						try {
							//nw = new ShowWinner();
							if(z==1)
							{
								ShowWinner nw = null; 
								nw = new ShowWinner();

								nw.setVisible(true);
								dispose(); 							
							}
							
							else	
							{
								JOptionPane.showMessageDialog(null, "Status Field missing","Input error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					//	nw.setVisible(true);
						//dispose();       //get exited from current frame
					}
				});
			
		Show.setForeground(Color.WHITE);
		Show.setBackground(Color.BLUE);
		Show.setBounds(277, 293, 89, 23);
		contentPane.add(Show);
		
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
		Menu.setBackground(Color.BLUE);
		Menu.setForeground(Color.WHITE);
		Menu.setBounds(277, 327, 89, 23);
		contentPane.add(Menu);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBounds(367, 199, 67, 16);
		contentPane.add(lblStatus);
		
		status = new JTextField();
		status.setBounds(429, 193, 179, 28);
		contentPane.add(status);
		status.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Final.class.getResource("/Images/Final.jpg")));
		lblNewLabel.setBounds(0, 0, 646, 350);
		contentPane.add(lblNewLabel);
		
		
		comboBox.removeAllItems();// Remove previous contents from comboBox
		// self-written code to show value in textfield t1 and t2
		try {
			
			con = getConnection();
			Statement myStat=con.createStatement();
			String sql1 = "select * from final";
			PreparedStatement pst = con.prepareStatement(sql1);
			
			myRs = pst.executeQuery();

			while (myRs.next()) {
				String add = myRs.getString("team1");
				System.out.println(add);
				t1.setText(add);

				comboBox.addItem(add);			// Add contents into comboBox
				String bdd = myRs.getString("team2");
				System.out.println(bdd);
				t2.setText(bdd);
				comboBox.addItem(bdd);
			}
		}

		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int i = 0;
					String tmp = (String) comboBox.getSelectedItem();
					//i = Integer.parseInt(tmp);
					tmp=tmp.trim();		//trim() is used to remove "illegal blank"
					

					Statement myStmt = con.createStatement();


					String sql4,sql2, sql3, winner = null, loser = null;

					String p1 = t1.getText().trim();
					String p2 = t2.getText().trim();
					String p3 = status.getText().trim();
					System.out.println("\nP1:" + p1+" "+"P2"+p2);
					
					//Show message box
					if(p3.length()==0)
					{
						JOptionPane.showMessageDialog(null, "Status Field missing","Input error", JOptionPane.ERROR_MESSAGE);
					}
					
					if (tmp.equals(p1)) {
						winner = p1;
						loser = p2;
					}
					
					if (tmp.equals(p2)) {
						winner = p2;
						loser = p1;
						
					}
					
					//System.out.println(tmp+","+winner+","+loser);
					
				//	t3.setText(winner);
				//	t4.setText(loser);
					System.out.println(tmp+","+winner+","+loser);
					
					String sqlj="update final set winner = '" + winner +"'";
					String sqlj1="update final set loser ='"+loser+"' ";
					String sqlj2="update ffinal set status ='"+p3+"' ";
					//myStmt.executeUpdate(sqlj);
					
					myStmt.executeUpdate(sqlj);
					myStmt.executeUpdate(sqlj1);
					myStmt.executeUpdate(sqlj2);
					
					//int val=myStmt.executeUpdate(sqlj);
					//if(val>=1){
					//	JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
				//	}
					
					if(p3.length()!=0)
					{
						JOptionPane.showMessageDialog(null, "Updated successfully", "SQL info", JOptionPane.INFORMATION_MESSAGE);
						z=1;
					}

					
				}

				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			});

		
		load();
	}
	
	private void load(){
		
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
