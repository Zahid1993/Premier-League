import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;


public class FShowSemiFinal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel model; //for jtable to add attribute
	Connection con;
	Statement myStat;
	ResultSet myRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FShowSemiFinal frame = new FShowSemiFinal();
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
	public FShowSemiFinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFixture = new JLabel("SemiFinal Result");
		lblFixture.setForeground(Color.BLACK);
		lblFixture.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFixture.setBounds(270, 11, 156, 30);
		contentPane.add(lblFixture);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		table.setBackground(new Color(102, 204, 255));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Team1", "Match", "Team2", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.setBounds(57, 124, 532, 36);
		contentPane.add(table);
		
		JLabel lblMatchNo = new JLabel("Match");
		lblMatchNo.setForeground(Color.WHITE);
		lblMatchNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMatchNo.setBounds(57, 99, 72, 14);
		contentPane.add(lblMatchNo);
		
		JLabel lblTeam = new JLabel("Team1");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeam.setBounds(171, 99, 54, 14);
		contentPane.add(lblTeam);
		
		JLabel lblNewLabel = new JLabel("Team2");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(292, 99, 60, 14);
		contentPane.add(lblNewLabel);
		
		JButton Menu = new JButton("Menu");
		Menu.setBackground(Color.BLUE);
		Menu.setForeground(Color.WHITE);
		Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		JButton Final = new JButton("Final");
		Final.setBounds(267, 256, 85, 30);
		contentPane.add(Final);
		
		//Self-written code for defining the function of 'Final' button
				Final.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FFinal nw = null;    //"Menubar" is the next frame by clicking "Menu" button
						try {
							nw = new FFinal();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nw.setVisible(true);
						dispose();       //get exited from current frame
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
		
		
		Menu.setBounds(267, 297, 85, 27);
		contentPane.add(Menu);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(462, 99, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(FShowSemiFinal.class.getResource("/Images/FShowSemiFinal.jpg")));
		lblNewLabel_1.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel_1);
		
		
		
		model=(DefaultTableModel) table.getModel();
		// our target activities are listed in "load function". By calling it here,we can see the Jtable when this frame is called.
				load();
	}
	
	
	public void load(){
		
		//Set the values in Jtable
		try {
			
			String sql1 = "select * from fsemifinal";
			con = getConnection();
			myStat=con.createStatement();
			ResultSet rs=myStat.executeQuery(sql1);
			while(rs.next()){
				int id=rs.getInt("id");
				String team1=rs.getString("team1");
				String team2=rs.getString("team2");
				String status=rs.getString("status");
				
				
				model.addRow(new Object[]{id,team1,team2,status}); //write data in jtable
			}
		} catch (Exception e) {
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
