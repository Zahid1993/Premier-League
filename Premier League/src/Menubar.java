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

public class Menubar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menubar frame = new Menubar();
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
	public Menubar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton info = new JButton("Info");
		info.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		

		info.setBounds(36, 69, 147, 29);
		contentPane.add(info);
		
		JButton CreateFixture = new JButton("Create Fixture");
		
		CreateFixture.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		CreateFixture.setBounds(36, 109, 147, 29);
		contentPane.add(CreateFixture);
		
		JLabel lblMenu_1 = new JLabel("Menu");
		lblMenu_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblMenu_1.setBounds(227, 0, 68, 42);
		contentPane.add(lblMenu_1);
		
		JButton ShowFixture = new JButton("Show Fixture");
		ShowFixture.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		ShowFixture.setBounds(36, 149, 147, 29);
		contentPane.add(ShowFixture);
		
		JButton DataInput = new JButton("Data Input");
		DataInput.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		DataInput.setBounds(36, 189, 147, 29);
		contentPane.add(DataInput);
		
		JButton PointsTable = new JButton("Points Table");
		
				
		PointsTable.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		PointsTable.setBounds(36, 229, 147, 29);
		contentPane.add(PointsTable);
		
		JButton TeamInfo = new JButton("Teaminfo Input");
		TeamInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		TeamInfo.setBounds(36, 269, 147, 29);
		contentPane.add(TeamInfo);
		
		JButton ShowTeamInfo = new JButton("Show Teaminfo");
		ShowTeamInfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		ShowTeamInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ShowTeamInfo.setBounds(36, 309, 147, 30);
		contentPane.add(ShowTeamInfo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Menubar.class.getResource("/Images/Menu.jpg")));
		lblNewLabel.setBounds(0, 0, 639, 350);
		contentPane.add(lblNewLabel);
		
		JButton Home = new JButton("Home");
		Home.setFont(new Font("Tahoma", Font.BOLD, 13));
		Home.setBounds(530, 11, 89, 23);
		contentPane.add(Home);
		
	    //Self-written code for defining the function of 'Info' button
			info.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Info nw = null;    //"Info" is the next frame by clicking "Info" button
					try {
						nw = new Info();
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
				Fixture nw = null;    //"Fixture" is the next frame by clicking "Create Fixture" button
				try {
					nw = new Fixture();
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
					ShowFixture nw = null;    //"ShowFixture" is the next frame by clicking "Show Fixture" button
					try {
						nw = new ShowFixture();
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
					DataInput nw = null;    //"DataInput" is the next frame by clicking "Data Input" button
					try {
						nw = new DataInput();
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
						PointsTable nw = null;    //"PointsTable" is the next frame by clicking "Points Table" button
					try {
						nw = new PointsTable();
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
						TeamInfo nw = null;    //"TeamInfo" is the next frame by clicking "Points Table" button
						try {
							nw = new TeamInfo();
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
  						ShowTeamInfo nw = null;    //"ShowTeamInfo" is the next frame by clicking "Menu" button
  						try {
  							nw = new ShowTeamInfo();
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
