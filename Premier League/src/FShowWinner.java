import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class FShowWinner extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	

	Connection con;
	Statement myStat;
	ResultSet myRs;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton Menu;
	private JLabel lblCsePremierLeague;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FShowWinner frame = new FShowWinner();
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
	public FShowWinner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setForeground(new Color(0, 0, 255));
		t1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		t1.setBounds(207, 134, 190, 39);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setForeground(new Color(106, 90, 205));
		t2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		t2.setBounds(207, 184, 190, 29);
		contentPane.add(t2);
		t2.setColumns(10);
		
		lblNewLabel = new JLabel("Champion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(59, 133, 119, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Runner up");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(59, 184, 128, 24);
		contentPane.add(lblNewLabel_1);
		
		Menu = new JButton("Menu");
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Menu.setBackground(Color.BLUE);
		Menu.setForeground(Color.WHITE);
		Menu.setBounds(289, 310, 89, 29);
		contentPane.add(Menu);
		
		lblCsePremierLeague = new JLabel("CSE  Premier  League");
		lblCsePremierLeague.setForeground(Color.WHITE);
		lblCsePremierLeague.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblCsePremierLeague.setBounds(161, 11, 533, 60);
		contentPane.add(lblCsePremierLeague);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(FShowWinner.class.getResource("/Images/FShowWinner.jpg")));
		lblNewLabel_2.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel_2);
		
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
		
		try {
			
			con = getConnection();
			Statement myStat=con.createStatement();
			String sql1 = "select * from ffinal";
			PreparedStatement pst = con.prepareStatement(sql1);
			
			myRs = pst.executeQuery();

			while (myRs.next()) {
				String add = myRs.getString("winner");
				System.out.println(add);
				t1.setText(add);

				
				String bdd = myRs.getString("loser");
				System.out.println(bdd);
				t2.setText(bdd);
				
			}
		}

		catch (Exception e1) {
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
