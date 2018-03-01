
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

public class FInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FInfo frame = new FInfo();
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
	public FInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 388);
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
				FMenubar nw = null;    //"Menubar" is the next frame by clicking "<<Back" button
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
		btnBackToMenu.setBounds(269, 327, 105, 23);
		contentPane.add(btnBackToMenu);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBackground(new Color(240, 240, 240));
		lblInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(286, 11, 46, 23);
		contentPane.add(lblInfo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FInfo.class.getResource("/Images/Finfo.jpg")));
		lblNewLabel.setBounds(0, 0, 639, 350);
		contentPane.add(lblNewLabel);
	}
}
