import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;

public class FMenubar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMenubar frame = new FMenubar();
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
	public FMenubar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton info = new JButton("Info");
		info.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		

		info.setBounds(472, 56, 147, 29);
		contentPane.add(info);
		
		JButton CreateFixture = new JButton("Create Fixture");
		
		CreateFixture.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		CreateFixture.setBounds(472, 96, 147, 29);
		contentPane.add(CreateFixture);
		
		JLabel lblMenu_1 = new JLabel("Menu");
		lblMenu_1.setForeground(Color.BLUE);
		lblMenu_1.setFont(new Font("Calibri", Font.BOLD, 24));
		lblMenu_1.setBounds(253, 1, 68, 42);
		contentPane.add(lblMenu_1);
		
		JButton ShowFixture = new JButton("Show Fixture");
		ShowFixture.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		ShowFixture.setBounds(472, 136, 147, 29);
		contentPane.add(ShowFixture);
		
		JButton DataInput = new JButton("Data Input");
		DataInput.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		DataInput.setBounds(472, 176, 147, 29);
		contentPane.add(DataInput);
		
		JButton PointsTable = new JButton("Points Table");
		
				
		PointsTable.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		PointsTable.setBounds(472, 216, 147, 29);
		contentPane.add(PointsTable);
		
		JButton TeamInfo = new JButton("Teaminfo Input");
		TeamInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		TeamInfo.setBounds(472, 256, 147, 29);
		contentPane.add(TeamInfo);
		
		JButton ShowTeamInfo = new JButton("Show Teaminfo");
		ShowTeamInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		ShowTeamInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ShowTeamInfo.setBounds(472, 296, 147, 30);
		contentPane.add(ShowTeamInfo);
		
		JButton Home = new JButton("Home");
		Home.setFont(new Font("Tahoma", Font.BOLD, 13));
		Home.setBounds(472, 11, 147, 29);
		contentPane.add(Home);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FMenubar.class.getResource("/Images/FMenu.jpg")));
		lblNewLabel.setBounds(0, 0, 629, 350);
		contentPane.add(lblNewLabel);
		
	    //Self-written code for defining the function of 'Info' button
			info.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FInfo nw = null;    //"Info" is the next frame by clicking "Info" button
					try {
						nw = new FInfo();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nw.setVisible(true);
					dispose();       //get exited from current frame
				}
			});
		
		//Self-written code for defining the function of 'Create Fixture' button
		CreateFixture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FFixture nw = null;    //"Fixture" is the next frame by clicking "Create Fixture" button
				try {
					nw = new FFixture();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.setVisible(true);
				dispose();       //get exited from current frame
			}
		});
		
	   //Self-written code for defining the function of 'Show Fixture' button
			ShowFixture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FShowFixture nw = null;    //"ShowFixture" is the next frame by clicking "Show Fixture" button
					try {
						nw = new FShowFixture();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nw.setVisible(true);
					dispose();       //get exited from current frame
				}
			});
			
	//Self-written code for defining the function of 'Data Input' button
	DataInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FDataInput nw = null;    //"DataInput" is the next frame by clicking "Data Input" button
					try {
						nw = new FDataInput();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nw.setVisible(true);
					dispose();       //get exited from current frame
				}
			});

    //Self-written code for defining the function of 'Points Table' button
    PointsTable.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FPointsTable nw = null;    //"PointsTable" is the next frame by clicking "Points Table" button
					try {
						nw = new FPointsTable();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nw.setVisible(true);
					dispose();       //get exited from current frame
				}
			});
    
   //Self-written code for defining the function of 'Teaminfo Input' button
    TeamInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FTeamInfo nw = null;    //"TeamInfo" is the next frame by clicking "Points Table" button
						try {
							nw = new FTeamInfo();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nw.setVisible(true);
						dispose();       //get exited from current frame
					}
				});
		
  //Self-written code for defining the function of 'ShowTeamInfo' button
    ShowTeamInfo.addActionListener(new ActionListener() {
  					public void actionPerformed(ActionEvent arg0) {
  						FShowTeamInfo nw = null;    //"ShowTeamInfo" is the next frame by clicking "Menu" button
  						try {
  							nw = new FShowTeamInfo();
  						} catch (Exception e1) {
  							// TODO Auto-generated catch block
  							e1.printStackTrace();
  						}
  						nw.setVisible(true);
  						dispose();       //get exited from current frame
  					}
  				});
  //Self-written code for defining the function of 'Home' button
    Home.addActionListener(new ActionListener() {
  					public void actionPerformed(ActionEvent arg0) {
  						Select nw = null;    //"ShowTeamInfo" is the next frame by clicking "Menu" button
  						try {
  							nw = new Select();
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
