
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Select extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select frame = new Select();
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
	public Select() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Cricket = new JButton("Cricket");
		Cricket.setForeground(Color.BLACK);
		Cricket.setBackground(Color.LIGHT_GRAY);
		Cricket.setFont(new Font("Tahoma", Font.BOLD, 13));
		Cricket.setBounds(110, 184, 113, 44);
		contentPane.add(Cricket);
		
		JButton Football = new JButton("Football");
		Football.setForeground(Color.BLACK);
		Football.setBackground(Color.LIGHT_GRAY);
		Football.setFont(new Font("Tahoma", Font.BOLD, 13));
		Football.setBounds(383, 184, 113, 44);
		contentPane.add(Football);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Select.class.getResource("/Images/Select.jpg")));
		lblNewLabel.setBounds(0, 0, 645, 350);
		contentPane.add(lblNewLabel);
		
		
		 //Self-written code for defining the function of 'Cricket' button
	     Cricket.addActionListener(new ActionListener() {
	  					public void actionPerformed(ActionEvent arg0) {
	  						Menubar nw = null;    //"ShowTeamInfo" is the next frame by clicking "Menu" button
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
	     //Self-written code for defining the function of 'Football' button
	     Football.addActionListener(new ActionListener() {
	  					public void actionPerformed(ActionEvent arg0) {
	  						FMenubar nw = null;    //"ShowTeamInfo" is the next frame by clicking "Menu" button
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
}
