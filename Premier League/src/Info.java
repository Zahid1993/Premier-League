
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
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
	public Info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToMenu = new JButton("Menu");
		btnBackToMenu.setBackground(new Color(47, 79, 79));
		btnBackToMenu.setForeground(new Color(255, 255, 255));
		btnBackToMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		//Self-written code for defining the function of '<<Back' button
		btnBackToMenu.addActionListener(new ActionListener() {
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
		btnBackToMenu.setBounds(261, 305, 105, 23);
		contentPane.add(btnBackToMenu);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblInfo.setForeground(new Color(0, 0, 128));
		lblInfo.setBounds(286, 11, 46, 23);
		contentPane.add(lblInfo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Info.class.getResource("/Images/Info.jpg")));
		lblNewLabel.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel);
	}
}
