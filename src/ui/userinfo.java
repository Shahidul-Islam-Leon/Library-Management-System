package ui;

import data.MysqlCon;
import main.main;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class userinfo extends JFrame {
	MysqlCon db = new MysqlCon();
	private JTextField usernametext;
	private JTextField emailtext;
	private JPasswordField oldpasstext;
	private JPasswordField newpasstext;
	private JButton editbtn = new JButton("EDIT");
	private actionhandeler ah = new actionhandeler();
	private String editedname = null;
	private String editedemail = null;
	private KeyHandeler kh = new KeyHandeler();
	private JButton updatebtn = new JButton("UPDATE");
	private JLabel namelbl = new JLabel("User Name :");
	private JLabel useremaillbl = new JLabel("Email :");
	private String currentuser = null;
	private JButton cpbtn = new JButton("CHANGE PASSWORD");
	private JLabel oldpasslbl = new JLabel("OLD PASS");
	private JLabel newpasslbl = new JLabel("NEW PASS");
	private JButton confirmbtn = new JButton("CONFIRM");
	private String oldpass = null;
	private String newpass = null;
	private char[] zero = { ' ' };
	private JLabel wrongpasslbl = new JLabel("");

	userinfo(String name, String email, int selector) {
		super("OB Book-Info");
		currentuser = name;
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Image/icon.png")));
		getContentPane().setBackground(new Color(0, 0, 153));
		setBounds(400, 100, 721, 198);
		getContentPane().setLayout(null);

		namelbl.setForeground(new Color(240, 255, 255));
		namelbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
		namelbl.setBounds(10, 10, 91, 25);
		getContentPane().add(namelbl);

		useremaillbl.setForeground(new Color(240, 255, 255));
		useremaillbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
		useremaillbl.setBounds(10, 65, 91, 25);
		getContentPane().add(useremaillbl);

		usernametext = new JTextField(name);
		usernametext.setFont(new Font("Agency FB", Font.PLAIN, 20));
		usernametext.setBounds(91, 10, 461, 25);
		getContentPane().add(usernametext);
		usernametext.setEditable(false);
		usernametext.addKeyListener(kh);
		usernametext.setColumns(10);

		emailtext = new JTextField(email);
		emailtext.setFont(new Font("Agency FB", Font.PLAIN, 20));
		emailtext.setBounds(91, 65, 461, 25);
		emailtext.setEditable(false);
		getContentPane().add(emailtext);
		emailtext.addKeyListener(kh);
		emailtext.setColumns(10);

		editbtn.setBackground(new Color(220, 20, 60));
		editbtn.setForeground(new Color(240, 255, 255));
		editbtn.setFont(new Font("Agency FB", Font.PLAIN, 20));
		editbtn.setBounds(597, 10, 85, 25);
		editbtn.addActionListener(ah);
		if (selector == 1) {
			editbtn.setVisible(false);
		}
		getContentPane().add(editbtn);

		updatebtn.setBackground(new Color(34, 139, 34));
		updatebtn.setForeground(new Color(240, 255, 255));
		updatebtn.setFont(new Font("Agency FB", Font.PLAIN, 20));
		updatebtn.setBounds(597, 65, 85, 25);
		updatebtn.setVisible(false);
		updatebtn.addActionListener(ah);
		getContentPane().add(updatebtn);

		cpbtn.setBackground(new Color(153, 50, 204));
		cpbtn.setForeground(new Color(240, 255, 255));
		cpbtn.setFont(new Font("Agency FB", Font.PLAIN, 15));
		cpbtn.setBounds(10, 126, 133, 25);
		if (selector == 1) {
			cpbtn.setVisible(false);
		}
		cpbtn.addActionListener(ah);
		getContentPane().add(cpbtn);

		oldpasslbl.setVisible(false);
		oldpasslbl.setForeground(new Color(240, 255, 255));
		oldpasslbl.setFont(new Font("Agency FB", Font.PLAIN, 15));
		oldpasslbl.setBounds(153, 126, 58, 25);
		getContentPane().add(oldpasslbl);

		newpasslbl.setVisible(false);
		newpasslbl.setForeground(new Color(240, 255, 255));
		newpasslbl.setFont(new Font("Agency FB", Font.PLAIN, 16));
		newpasslbl.setBounds(344, 126, 58, 25);
		getContentPane().add(newpasslbl);

		oldpasstext = new JPasswordField();
		oldpasstext.setVisible(false);
		oldpasstext.setBounds(209, 126, 125, 25);
		getContentPane().add(oldpasstext);

		newpasstext = new JPasswordField();
		newpasstext.setVisible(false);
		newpasstext.setBounds(401, 126, 125, 25);
		newpasstext.addKeyListener(kh);
		getContentPane().add(newpasstext);

		confirmbtn.setVisible(false);
		confirmbtn.setBackground(new Color(34, 139, 34));
		confirmbtn.setForeground(new Color(240, 255, 255));
		confirmbtn.setFont(new Font("Agency FB", Font.PLAIN, 20));
		confirmbtn.setBounds(597, 126, 100, 25);
		confirmbtn.addActionListener(ah);
		getContentPane().add(confirmbtn);

		wrongpasslbl.setHorizontalAlignment(SwingConstants.LEFT);
		wrongpasslbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
		wrongpasslbl.setForeground(new Color(255, 0, 0));
		wrongpasslbl.setBounds(209, 100, 473, 25);
		getContentPane().add(wrongpasslbl);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

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

	private class actionhandeler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == editbtn) {
				usernametext.setText(null);
				emailtext.setText(null);
				usernametext.setEditable(true);
				emailtext.setEditable(true);
				updatebtn.setVisible(true);
			} else if (e.getSource() == updatebtn) {
				if (editedname == null) {
					usernametext.setForeground(Color.red);
					usernametext.setText(" Username must have 5 character and no emptyspace");
				}
				if (editedemail == null) {
					useremaillbl.setForeground(Color.RED);

				}
				if (editedname != null && editedemail != null) {
					if (db.userinfoupdater(currentuser, editedname, editedemail)) {
						JOptionPane.showMessageDialog(null, "New info Updated successfully..");
						currentuser = editedname;
						main.up.infoupdater(editedname);
					}
				}
			} else if (e.getSource() == cpbtn) {
				oldpasslbl.setVisible(true);
				oldpasstext.setVisible(true);
				newpasslbl.setVisible(true);
				newpasstext.setVisible(true);
				confirmbtn.setVisible(true);
			} else if (e.getSource() == confirmbtn) {
				oldpass = new String(oldpasstext.getPassword());
				if (db.userloginchecker(currentuser, oldpass)) {
					if (newpass != null) {
						if (db.userpasswordupdater(currentuser, newpass)) {
							JOptionPane.showMessageDialog(null,
									"Password successfully updated..\n\n Remember your New password :" + newpass);
							oldpass = null;
							newpass = null;
							oldpasstext.setText(null);
							newpasstext.setText(null);

						} else {
							JOptionPane.showMessageDialog(null, "Password update failed...");
						}
					} else {
						wrongpasslbl.setText("New Password must contain ONE Captial letter and ONE Digit");
					}
				} else {
					wrongpasslbl.setText("Old Password does not match!!");
				}
			}
		}
	}

	private class KeyHandeler implements KeyListener {

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

			if (e.getSource() == usernametext) {
				if (NameChecker(usernametext.getText())) {

					usernametext.setForeground(Color.green);
					editedname = usernametext.getText();
					namelbl.setForeground(new Color(240, 255, 255));
				} else {
					editedname = null;
					usernametext.setForeground(Color.red);
					namelbl.setForeground(Color.red);
				}
			} else if (e.getSource() == emailtext) {
				if ((emailtext.getText()).length() == 0) {
					editedemail = null;
					useremaillbl.setForeground(Color.RED);
				} else {
					editedemail = emailtext.getText();
					useremaillbl.setForeground(new Color(240, 255, 255));
				}
			} else if (e.getSource() == newpasstext) {
				int t = passwordValidityChecker(newpasstext.getPassword());

				if (t == 0) {
					newpass = null;
					wrongpasslbl.setText("New Password must contain ONE Captial letter and ONE Digit");
				} else if (t == 1) {
					newpass = new String(newpasstext.getPassword());
					wrongpasslbl.setText(null);
				}
			}
		}
	}
}
