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
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	
	Connection con=null;
	Statement myStat;
	ResultSet result;
	private PreparedStatement statement;
	String userName="",pass="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBackground(Color.WHITE);
		username.setBounds(239, 179, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(128, 179, 86, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(128, 223, 86, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setForeground(Color.BLUE);
		btnLogIn.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		
				//Self-written code for defining the function of 'Log in' button
				btnLogIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String getUser=username.getText();
						String getPass=password.getText();
						if(getUser.length()!=0&&getPass.length()!=0){   //i.e. if both fields are not empty
							if(getUser.equals(userName)&&getPass.equals(pass)){		//equals() method is used instead for  '==' operator
								new Select().setVisible(true);			//if condition is true;go to next Frame(i.e. Menubar) 
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "Wrong access..", "Input error", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Some fields missing..", "Input error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		btnLogIn.setBounds(259, 275, 89, 30);
		contentPane.add(btnLogIn);
		
		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setBounds(239, 222, 86, 20);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/Login1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel_1);
		
		load();
		
		
	}
	private void load(){
		try {
			con = getConnection();
			myStat=con.createStatement();
			ResultSet rs=myStat.executeQuery("select * from login");
			while(rs.next()){
				userName=rs.getString(1);
				pass=rs.getString(2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
public static Connection getConnection() throws Exception{
		
		try{
			
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://127.0.0.1:3306/premierleague";
			String username="root";
			String password="root";
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(url, username, password);
			//System.out.println("Connected");
			return conn;
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}


