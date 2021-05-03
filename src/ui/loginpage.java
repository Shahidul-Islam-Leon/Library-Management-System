package ui;

import main.main;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class loginpage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JTextField username;
	private JPasswordField userpassword;
	private JButton login = new JButton("");
	private mousehandeler mh = new mousehandeler();
	private actionHandeler ah = new actionHandeler();
	private main m = new main();
	private String tracker;

	public loginpage(String tracker) {
		super("OB Library-Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Image/icon.png")));
		this.tracker = tracker;
		setBounds(400, 100, 300, 300);
		getContentPane().setLayout(null);

		panel_1.addMouseListener(mh);
		panel.addMouseListener(mh);

		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 83, 286, 180);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel usernamelbl = new JLabel("User Name");
		usernamelbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernamelbl.setForeground(new Color(240, 248, 255));
		usernamelbl.setBounds(10, 10, 105, 36);
		panel.add(usernamelbl);

		username = new JTextField();
		username.setBounds(125, 10, 151, 36);
		panel.add(username);
		username.setColumns(10);

		JLabel userpasswordlbl = new JLabel("Password");
		userpasswordlbl.setForeground(new Color(240, 255, 255));
		userpasswordlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		userpasswordlbl.setBounds(10, 73, 105, 36);
		panel.add(userpasswordlbl);

		userpassword = new JPasswordField();
		userpassword.setBounds(125, 76, 151, 36);
		panel.add(userpassword);
		login.setBackground(new Color(0, 153, 0));

		login.setHorizontalTextPosition(SwingConstants.CENTER);
		login.setBounds(249, 146, 37, 34);
		Image iconlogin = new ImageIcon(this.getClass().getResource("/Image/login.png")).getImage();
		login.setIcon(new ImageIcon(iconlogin));
		panel.add(login);
		login.addActionListener(ah);
		login.addMouseListener(mh);

		JLabel welcomemassage = new JLabel("OPENBook Library");
		welcomemassage.setForeground(new Color(0, 255, 255));
		welcomemassage.setHorizontalAlignment(SwingConstants.CENTER);
		welcomemassage.setFont(new Font("Wide Latin", Font.ITALIC, 15));
		welcomemassage.setBounds(10, 10, 266, 65);
		panel_1.add(welcomemassage);

		panel_1.setBackground(new Color(0, 0, 153));
		panel_1.setBounds(0, 0, 286, 85);
		panel_1.setLayout(null);
		getContentPane().add(panel_1);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private class mousehandeler implements MouseListener, MouseMotionListener {

		public void mouseDragged(MouseEvent e) {

		}

		public void mouseMoved(MouseEvent e) {

		}

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == panel_1) {
				panel_1.setBackground(new Color(0, 0, 130));
			}
			if (e.getSource() == panel) {
				panel.setBackground(new Color(0, 0, 130));
			}
			if (e.getSource() == login) {
			login.setBackground(new Color(0, 250, 0));	
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource() == panel_1) {
				panel_1.setBackground(new Color(0, 0, 153));
			}
			if (e.getSource() == panel) {
				panel.setBackground(new Color(0, 0, 153));
			}
			if (e.getSource() == login) {
			login.setBackground(new Color(0, 153, 0));	
			}
		}

	}

	private class actionHandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == login) {
				if (tracker == "user") {
					String pass = new String(userpassword.getPassword());
					m.userlogin(username.getText(), pass);
					dispose();
				}
				if (tracker == "admin") {
					String pass = new String(userpassword.getPassword());
					m.adminlogin(username.getText(), pass);
					dispose();
				}

			}

		}
	}

}
