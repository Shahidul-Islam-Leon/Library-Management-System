/** 
 * This is the Welcome page UI. This is the first page displayed to the user.
 */
package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import main.main;

import javax.swing.JPasswordField;

/**
 * This part of project is written by MD MONIRUZZAMAN(17-34645-2).
 * 
 * @author MD MONIRUZZAMAN
 *
 */
public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private KeyHandeler khandeler = new KeyHandeler();
	private ActionHandeler ahandeler = new ActionHandeler();
	private main m = new main();
	private mousehandeler mh = new mousehandeler();

	private String username = null; // Stores user name.
	private char[] pass = { ' ' }; // Stores password.
	private char[] confirmedpass = { ' ' }; // Stores confirmed password.
	private String Email = null; // stored email.
	private char[] zero = { ' ' };

	private JButton btnAdminLogin = new JButton("Admin Login"); // Administrator Login Button.
	private JButton btnUserLogin = new JButton("User Login"); // User Login button.
	private JButton btnRegesterNew = new JButton("Regester new"); // New member registration button.
	private Label usernamelabel = new Label(); // user name label, Activated when user name is incorrect.
	private Label password = new Label(); // Password Label.Activated when password is incorrect.
	private JTextField Usernametext = new JTextField(); // User Name text field.
	private JPasswordField passwordField = new JPasswordField(); // Password Field.
	private JPasswordField Conformpasswordfield = new JPasswordField();// Takes confirmed password.
	private Label confirmedpassword = new Label(); // confirmed password label. Activated when confirmed password is not
													// matched.
	private JTextField emailtext = new JTextField(); // Email text field.
	private Label email = new Label(); // Email label.. Activated if email is not inserted.
	private JButton confirm = new JButton("CONFIRM"); // Registration confirm button.

	private JLabel lblUserName = new JLabel("User Name");
	private JLabel lblPassword = new JLabel("Password");
	private JLabel lblConfirmPassword = new JLabel("Confirm Password");
	private JLabel lblemail = new JLabel("Email");

	public WelcomePage() {

		setTitle("Welcome to OPENBook Library");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Image/icon.png")));
		setBounds(50, 50, 1280, 720);
		getContentPane().setBackground(new Color(0, 0, 153));
		getContentPane().setLayout(null);

		JLabel label1 = new JLabel(); // Shows welcome Image.
		label1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Image welcome = new ImageIcon(this.getClass().getResource("/Image/welcome.png")).getImage();
		label1.setIcon(new ImageIcon(welcome));
		label1.setBounds(63, 146, 565, 441);
		getContentPane().add(label1);

		/* AdminLogin button..... */
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdminLogin.setForeground(new Color(255, 255, 255));
		btnAdminLogin.setBackground(new Color(119, 136, 153));
		btnAdminLogin.setBounds(779, 27, 139, 46);
		getContentPane().add(btnAdminLogin);
		btnAdminLogin.addMouseListener(mh);
		btnAdminLogin.addActionListener(ahandeler);

		/* UserLogin Button.... */
		btnUserLogin.setForeground(Color.WHITE);
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUserLogin.setBackground(new Color(119, 136, 153));
		btnUserLogin.setBounds(956, 27, 123, 46);
		getContentPane().add(btnUserLogin);
		btnUserLogin.addActionListener(ahandeler);
		btnUserLogin.addMouseListener(mh);

		/* RegesterNew button...... */
		btnRegesterNew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegesterNew.setForeground(Color.WHITE);
		btnRegesterNew.setBackground(new Color(119, 136, 153));
		btnRegesterNew.setBounds(1109, 27, 141, 46);
		getContentPane().add(btnRegesterNew);
		btnRegesterNew.addActionListener(ahandeler);
		btnRegesterNew.addMouseListener(mh);

		/* User Name label....... */
		lblUserName.setForeground(new Color(240, 255, 255));
		lblUserName.setVisible(false);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBounds(798, 146, 94, 13);
		getContentPane().add(lblUserName);

		/* User name text field....... */
		Usernametext.setVisible(false);
		Usernametext.setBounds(928, 146, 190, 20);
		getContentPane().add(Usernametext);
		Usernametext.addKeyListener(khandeler);

		/* User name label. Activated when user name is incorrect..... */
		usernamelabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		usernamelabel.setBounds(928, 166, 322, 13);
		getContentPane().add(usernamelabel);

		/* Password label..... */
		lblPassword.setForeground(new Color(240, 255, 255));
		lblPassword.setVisible(false);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(798, 186, 94, 13);
		getContentPane().add(lblPassword);

		/* Password Field, Takes password....... */
		passwordField.setVisible(false);
		passwordField.setBounds(928, 186, 190, 20);
		getContentPane().add(passwordField);
		passwordField.addKeyListener(khandeler);

		/* password label.Activated when password is incorrect...... */
		password.setFont(new Font("Tahoma", Font.PLAIN, 9));
		password.setBounds(928, 206, 304, 13);
		getContentPane().add(password);

		/* Confirm Password Label...... */
		lblConfirmPassword.setForeground(new Color(240, 255, 255));
		lblConfirmPassword.setVisible(false);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmPassword.setBounds(798, 226, 120, 13);
		getContentPane().add(lblConfirmPassword);

		/* Takes confirm Password..... */
		Conformpasswordfield.setVisible(false);
		Conformpasswordfield.setBounds(928, 226, 190, 20);
		getContentPane().add(Conformpasswordfield);
		Conformpasswordfield.addKeyListener(khandeler);

		/*
		 * Confirmed password label.. activated when confirmed password is not matched..
		 */
		confirmedpassword.setFont(new Font("Tahoma", Font.PLAIN, 9));
		confirmedpassword.setBounds(928, 246, 190, 13);
		getContentPane().add(confirmedpassword);

		/* email label....... */
		lblemail.setForeground(new Color(240, 255, 255));
		lblemail.setVisible(false);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblemail.setBounds(798, 266, 94, 13);
		getContentPane().add(lblemail);

		/* Takes email...... */
		emailtext.setVisible(false);
		emailtext.setBounds(928, 266, 190, 19);
		getContentPane().add(emailtext);
		emailtext.addKeyListener(khandeler);

		/* email label. activated if email is not inserted... */
		email.setFont(new Font("Tahoma", Font.PLAIN, 9));
		email.setBounds(928, 286, 190, 13);
		getContentPane().add(email);

		/* Confirm Button.. Used to confirm registration..... */
		confirm.setVisible(false);
		confirm.setFont(new Font("Verdana", Font.BOLD, 12));
		confirm.setForeground(Color.BLACK);
		confirm.setBackground(new Color(154, 205, 50));
		confirm.setBounds(981, 326, 123, 46);
		getContentPane().add(confirm);
		confirm.addActionListener(ahandeler);
		confirm.addMouseListener(mh);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 * 
	 * @param p //takes char array as parameter.
	 * @return // return 0 if pass is not valid or 1 if password is valid.
	 */
	private int passwordValidityChecker(char[] p) {
		String temp = new String(p);
		if (temp.length() < 8) {
			return 0;
		}
		int cap = 0;
		int num = 0;
		for (int i = 0; i < temp.length(); i++) {
			char c = temp.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				cap = 1;
			}
			if (c >= '0' && c <= '9') {
				num = 1;
			}
		}
		if (cap == 1 && num == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param temp // takes user name as parameter.
	 * @return // return true is user name has at least 5 char one uppercase and one
	 *         digit, or return 0.
	 */
	private boolean NameChecker(String temp) {
		if (temp.length() < 5) {
			return false;
		}
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @author MD MONIRUZZAMAN
	 *
	 */
	private class KeyHandeler implements KeyListener {

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

			if (e.getSource() == Usernametext) {
				if (NameChecker(Usernametext.getText())) {
					usernamelabel.setText("USER NAME accepted");
					usernamelabel.setForeground(Color.green);
					username = Usernametext.getText();
				} else {
					username = null;
					usernamelabel.setText("USER NAME should contain at least FIVE character and no empty space");
					usernamelabel.setForeground(Color.red);
				}
			} else if (e.getSource() == passwordField) {
				int t = passwordValidityChecker(passwordField.getPassword());

				if (t == 0) {
					pass = zero;
					password.setText("Password must contain ONE Captial letter and ONE Digit");
					password.setForeground(Color.red);
				} else if (t == 1) {
					password.setText("Password Accepted");
					password.setForeground(Color.GREEN);
					pass = passwordField.getPassword();
				}
			} else if (e.getSource() == Conformpasswordfield) {
				if ((Arrays.equals(pass, Conformpasswordfield.getPassword()) && pass[0] != ' ')) {
					confirmedpass = Conformpasswordfield.getPassword();
					confirmedpassword.setText("Password match");
					confirmedpassword.setForeground(Color.GREEN);
				} else {
					confirmedpassword.setText("Password does not match");
					confirmedpassword.setForeground(Color.red);
					confirmedpass = zero;

				}
			}

			else if (e.getSource() == emailtext) {
				if ((emailtext.getText()).length() == 0) {
					Email = null;
				} else {
					Email = emailtext.getText();
				}
			}

		}
	}

	private class ActionHandeler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnRegesterNew) {
				lblUserName.setVisible(true);
				Usernametext.setVisible(true);
				Usernametext.setText("");
				lblPassword.setVisible(true);
				passwordField.setVisible(true);
				passwordField.setText("");
				lblConfirmPassword.setVisible(true);
				Conformpasswordfield.setVisible(true);
				Conformpasswordfield.setText("");
				lblemail.setVisible(true);
				emailtext.setVisible(true);
				emailtext.setText("");
				confirm.setVisible(true);
				password.setText("");
				confirmedpassword.setText("");
				usernamelabel.setText("");
				email.setText("");
			} else if (event.getSource() == confirm) {
				int t1 = 0;
				int t2 = 0;
				int t3 = 0;
				if (username == null) {
					usernamelabel.setText("Fillup username");
					usernamelabel.setForeground(Color.red);
				} else {
					usernamelabel.setText("");
					t1 = 1;
				}
				if (!Arrays.equals(pass, confirmedpass) || pass[0] == ' ') {
					password.setText("Fillup password");
					password.setForeground(Color.red);
				} else {
					password.setText("");
					confirmedpassword.setText("");
					t2 = 1;
				}
				if (Email == null) {
					email.setText("Fillup email");
					email.setForeground(Color.red);
				} else {
					email.setText("");
					t3 = 1;
				}
				if (t1 == 1 && t2 == 1 && t3 == 1) {
					String temp = new String(pass);
					if ((m.userDataWritter(username, temp, Email))) {
						Usernametext.setText("");
						passwordField.setText("");
						Conformpasswordfield.setText("");
						emailtext.setText("");
						username = null;
						pass = zero;
						confirmedpass = zero;
						Email = null;
					}

				}
			} else if (event.getSource() == btnUserLogin) {
				lblUserName.setVisible(false);
				Usernametext.setVisible(false);
				lblPassword.setVisible(false);
				passwordField.setVisible(false);
				lblConfirmPassword.setVisible(false);
				Conformpasswordfield.setVisible(false);
				lblemail.setVisible(false);
				emailtext.setVisible(false);
				confirm.setVisible(false);
				password.setText("");
				confirmedpassword.setText("");
				usernamelabel.setText("");
				email.setText("");
				username = null;
				pass = zero;
				confirmedpass = zero;
				Email = null;
				loginpage ul = new loginpage("user");
			} else if (event.getSource() == btnAdminLogin) {
				lblUserName.setVisible(false);
				Usernametext.setVisible(false);
				lblPassword.setVisible(false);
				passwordField.setVisible(false);
				lblConfirmPassword.setVisible(false);
				Conformpasswordfield.setVisible(false);
				lblemail.setVisible(false);
				emailtext.setVisible(false);
				confirm.setVisible(false);
				password.setText("");
				confirmedpassword.setText("");
				usernamelabel.setText("");
				email.setText("");
				username = null;
				pass = zero;
				confirmedpass = zero;
				Email = null;
				loginpage al = new loginpage("admin");
			}
		}
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
			if (e.getSource() == btnAdminLogin) {
				btnAdminLogin.setBackground(new Color(100, 100, 100));
			}

			if (e.getSource() == btnUserLogin) {
				btnUserLogin.setBackground(new Color(100, 100, 100));
			}
			if (e.getSource() == btnRegesterNew) {
				btnRegesterNew.setBackground(new Color(100, 100, 100));
			}
			if (e.getSource() == confirm) {
				confirm.setBackground(new Color(34, 139, 34));
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource() == btnAdminLogin) {
				btnAdminLogin.setBackground(new Color(119, 136, 153));
			}

			if (e.getSource() == btnUserLogin) {
				btnUserLogin.setBackground(new Color(119, 136, 153));
			}
			if (e.getSource() == btnRegesterNew) {
				btnRegesterNew.setBackground(new Color(119, 136, 153));
			}
			if (e.getSource() == confirm) {
				confirm.setBackground(new Color(154, 205, 50));
			}
		}
	}

}
