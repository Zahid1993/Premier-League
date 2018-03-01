import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTable;

import java.awt.Color;

import javax.swing.ImageIcon;



public class Coverpage {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coverpage window = new Coverpage();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Coverpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.BOLD, 12));
		frame.setBounds(100, 100, 651, 388);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(93, 120, 85, -10);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBackground(Color.ORANGE);
		
		//Self-written code for defining the function of 'next' button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login nw = null;    //"Login" is the next frame by clicking "next" button
				try {
					nw = new Login();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.setVisible(true);
				frame.dispose();		//get exited from current frame
				
			}
		});
		btnNewButton.setBounds(285, 316, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Coverpage.class.getResource("/Images/CSEPL coverpage.jpg")));
		lblNewLabel.setBounds(0, 0, 635, 350);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
