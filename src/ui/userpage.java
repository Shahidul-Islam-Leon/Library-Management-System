package ui;

import main.main;
import data.MysqlCon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class userpage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton downloadbtn = new JButton("Download");
	private actionhandeler ah = new actionhandeler();
	private MysqlCon db = new MysqlCon();
	private JButton showbookbtn = new JButton("SHOW AVAILABLE BOOKS");
	private JButton back = new JButton("");
	private JButton bookbtn[] = new JButton[36];
	private int bookcounter = -1;
	private ResultSet rs = null;
	private String bookname[] = new String[36];
	private String id[] = new String[36];
	private String author[] = new String[36];
	private String year[] = new String[36];
	private int selectedindex = -1;
	private JLabel selectedbooknamelbl = new JLabel("No Book Selected");
	private JButton infobtn = new JButton("Show Info");
	private JLabel selectedbooklbl = new JLabel("Selected Book ::");
	private JButton userinfobtn = new JButton("YOUR INFO");
	private JButton deleteaccountbtn = new JButton("DELETE YOUR ACCOUNT");
	private String currentuser = null;
	private JLabel welcome;

	public userpage(String name) {
		super("OB User-page");
		currentuser = name;
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Image/icon.png")));
		getContentPane().setBackground(new Color(0, 0, 153));
		setBounds(50, 50, 1280, 720);
		getContentPane().setLayout(null);
		downloadbtn.setForeground(new Color(240, 255, 255));
		downloadbtn.setBackground(new Color(255, 51, 102));

		downloadbtn.setVisible(false);
		downloadbtn.setFont(new Font("Agency FB", Font.PLAIN, 22));
		downloadbtn.setBounds(1151, 649, 115, 34);
		downloadbtn.addActionListener(ah);
		getContentPane().add(downloadbtn);
		userinfobtn.setBackground(new Color(51, 204, 204));
		userinfobtn.setForeground(new Color(240, 255, 255));
		userinfobtn.setFont(new Font("Algerian", Font.PLAIN, 50));

		userinfobtn.setBounds(0, 30, 627, 65);
		userinfobtn.addActionListener(ah);
		getContentPane().add(userinfobtn);

		welcome = new JLabel("Hi " + currentuser);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		welcome.setForeground(new Color(240, 255, 255));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBounds(44, 0, 1222, 31);
		getContentPane().add(welcome);

		deleteaccountbtn.setForeground(new Color(240, 255, 255));
		deleteaccountbtn.setFont(new Font("Algerian", Font.PLAIN, 40));
		deleteaccountbtn.setBackground(new Color(102, 204, 153));
		deleteaccountbtn.setBounds(625, 30, 641, 65);
		getContentPane().add(deleteaccountbtn);

		showbookbtn.setBackground(new Color(102, 204, 102));
		showbookbtn.setForeground(new Color(240, 255, 255));
		showbookbtn.setFont(new Font("Castellar", Font.PLAIN, 40));
		showbookbtn.addActionListener(ah);
		showbookbtn.setBounds(0, 95, 1266, 65);
		getContentPane().add(showbookbtn);

		selectedbooknamelbl.setVisible(false);
		selectedbooknamelbl.setFont(new Font("Agency FB", Font.BOLD, 30));
		selectedbooknamelbl.setForeground(new Color(240, 255, 255));
		selectedbooknamelbl.setBounds(324, 649, 701, 34);
		getContentPane().add(selectedbooknamelbl);

		selectedbooklbl.setVisible(false);
		selectedbooklbl.setFont(new Font("Agency FB", Font.BOLD, 30));
		selectedbooklbl.setForeground(new Color(240, 255, 255));
		selectedbooklbl.setBounds(150, 649, 175, 34);
		getContentPane().add(selectedbooklbl);
		infobtn.setForeground(new Color(240, 255, 255));
		infobtn.setBackground(new Color(153, 51, 255));

		infobtn.setVisible(false);
		infobtn.setFont(new Font("Agency FB", Font.PLAIN, 22));
		infobtn.setBounds(1035, 649, 106, 34);
		infobtn.addActionListener(ah);
		getContentPane().add(infobtn);
		back.setBackground(new Color(0, 204, 0));

		back.setIcon(new ImageIcon(userpage.class.getResource("/Image/back.png")));
		back.setBounds(0, 0, 34, 34);
		getContentPane().add(back);

		int x1 = 28;
		int y1 = 162;
		int x2 = 370;
		int y2 = 41;
		for (int i = 0; i < 36; i++) {
			bookbtn[i] = new JButton();
			bookbtn[i].setBounds(x1, y1, x2, y2);
			bookbtn[i].setFont(new Font("Agency FB", Font.PLAIN, 25));
			bookbtn[i].setForeground(new Color(240, 255, 255));
			bookbtn[i].setBackground(new Color(0, 0, 100));
			bookbtn[i].setVisible(false);
			getContentPane().add(bookbtn[i]);

			y1 = y1 + y2;

			if (i == 11) {
				x1 = 461;
				y1 = 162;
			}
			if (i == 23) {
				x1 = 896;
				y1 = 162;
			}
		}
		bookbtn[0].addActionListener(ah);
		bookbtn[1].addActionListener(ah);
		bookbtn[2].addActionListener(ah);
		bookbtn[3].addActionListener(ah);
		bookbtn[4].addActionListener(ah);
		bookbtn[5].addActionListener(ah);
		bookbtn[6].addActionListener(ah);
		bookbtn[7].addActionListener(ah);
		bookbtn[8].addActionListener(ah);
		bookbtn[9].addActionListener(ah);
		bookbtn[10].addActionListener(ah);
		bookbtn[11].addActionListener(ah);
		bookbtn[12].addActionListener(ah);
		bookbtn[13].addActionListener(ah);
		bookbtn[14].addActionListener(ah);
		bookbtn[15].addActionListener(ah);
		bookbtn[16].addActionListener(ah);
		bookbtn[17].addActionListener(ah);
		bookbtn[18].addActionListener(ah);
		bookbtn[19].addActionListener(ah);
		bookbtn[20].addActionListener(ah);
		bookbtn[21].addActionListener(ah);
		bookbtn[22].addActionListener(ah);
		bookbtn[23].addActionListener(ah);
		bookbtn[24].addActionListener(ah);
		bookbtn[25].addActionListener(ah);
		bookbtn[26].addActionListener(ah);
		bookbtn[27].addActionListener(ah);
		bookbtn[28].addActionListener(ah);
		bookbtn[29].addActionListener(ah);
		bookbtn[30].addActionListener(ah);
		bookbtn[31].addActionListener(ah);
		bookbtn[32].addActionListener(ah);
		bookbtn[33].addActionListener(ah);
		bookbtn[34].addActionListener(ah);
		bookbtn[35].addActionListener(ah);
		back.addActionListener(ah);
		deleteaccountbtn.addActionListener(ah);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void bookbtnviewer(String name, String id, String author, String year) {
		bookcounter++;
		bookbtn[bookcounter].setVisible(true);
		bookbtn[bookcounter].setText(name);
		bookname[bookcounter] = name;
		this.id[bookcounter] = id;
		this.author[bookcounter] = author;
		this.year[bookcounter] = year;
	}

	void infoupdater(String newusername) {
		currentuser = newusername;
		welcome.setText("Hi " + currentuser);
	}

	public class actionhandeler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == downloadbtn) {
				try {
					JFileChooser f = new JFileChooser();
					f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					f.showSaveDialog(null);
					String s = f.getSelectedFile().getPath();
					db.pdfdownload(s, id[selectedindex], bookname[selectedindex]);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				} finally {
				}
			} else if (e.getSource() == showbookbtn) {
				ResultSet rs = db.displaybook();
				try {
					while (rs.next()) {
						String name = rs.getString("book_name");
						String id = rs.getString("book_id");
						String author = rs.getString("book_author");
						String year = rs.getString("published_year");
						bookbtnviewer(name, id, author, year);
					}
					bookcounter = -1;
					rs.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			} else if (e.getSource() == bookbtn[0]) {
				selectedindex = 0;
				selectedbooknamelbl.setText(bookname[0]);

				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[1]) {
				selectedindex = 1;
				selectedbooknamelbl.setText(bookname[1]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[2]) {
				selectedindex = 2;
				selectedbooknamelbl.setText(bookname[2]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[3]) {
				selectedindex = 3;
				selectedbooknamelbl.setText(bookname[3]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[4]) {
				selectedindex = 4;
				selectedbooknamelbl.setText(bookname[4]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[5]) {
				selectedindex = 5;
				selectedbooknamelbl.setText(bookname[5]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[6]) {
				selectedindex = 6;
				selectedbooknamelbl.setText(bookname[6]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[7]) {
				selectedindex = 7;
				selectedbooknamelbl.setText(bookname[7]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[8]) {
				selectedindex = 8;
				selectedbooknamelbl.setText(bookname[8]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[9]) {
				selectedindex = 9;
				selectedbooknamelbl.setText(bookname[9]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[10]) {
				selectedindex = 10;
				selectedbooknamelbl.setText(bookname[10]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[11]) {
				selectedindex = 11;
				selectedbooknamelbl.setText(bookname[11]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[12]) {
				selectedindex = 12;
				selectedbooknamelbl.setText(bookname[12]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[13]) {
				selectedindex = 13;
				selectedbooknamelbl.setText(bookname[13]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[14]) {
				selectedindex = 14;
				selectedbooknamelbl.setText(bookname[14]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[15]) {
				selectedindex = 15;
				selectedbooknamelbl.setText(bookname[15]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[16]) {
				selectedindex = 16;
				selectedbooknamelbl.setText(bookname[16]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[17]) {
				selectedindex = 17;
				selectedbooknamelbl.setText(bookname[17]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[18]) {
				selectedindex = 18;
				selectedbooknamelbl.setText(bookname[18]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[19]) {
				selectedindex = 19;
				selectedbooknamelbl.setText(bookname[19]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[20]) {
				selectedindex = 20;
				selectedbooknamelbl.setText(bookname[20]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[21]) {
				selectedindex = 21;
				selectedbooknamelbl.setText(bookname[21]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[22]) {
				selectedindex = 22;
				selectedbooknamelbl.setText(bookname[22]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[23]) {
				selectedindex = 23;
				selectedbooknamelbl.setText(bookname[23]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[24]) {
				selectedindex = 24;
				selectedbooknamelbl.setText(bookname[24]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[25]) {
				selectedindex = 25;
				selectedbooknamelbl.setText(bookname[25]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[26]) {
				selectedindex = 26;
				selectedbooknamelbl.setText(bookname[26]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[27]) {
				selectedindex = 27;
				selectedbooknamelbl.setText(bookname[27]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[28]) {
				selectedindex = 28;
				selectedbooknamelbl.setText(bookname[28]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[29]) {
				selectedindex = 29;
				selectedbooknamelbl.setText(bookname[29]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[30]) {
				selectedindex = 30;
				selectedbooknamelbl.setText(bookname[30]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[31]) {
				selectedindex = 31;
				selectedbooknamelbl.setText(bookname[31]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[32]) {
				selectedindex = 32;
				selectedbooknamelbl.setText(bookname[32]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[33]) {
				selectedindex = 33;
				selectedbooknamelbl.setText(bookname[33]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[34]) {
				selectedindex = 34;
				selectedbooknamelbl.setText(bookname[34]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == bookbtn[35]) {
				selectedindex = 35;
				selectedbooknamelbl.setText(bookname[35]);
				downloadbtn.setVisible(true);
				infobtn.setVisible(true);
				selectedbooknamelbl.setVisible(true);
				selectedbooklbl.setVisible(true);
			} else if (e.getSource() == infobtn) {
				bookinfo bi = new bookinfo(bookname[selectedindex], author[selectedindex], year[selectedindex]);
			} else if (e.getSource() == userinfobtn) {
				userinfo ui = new userinfo(currentuser, db.getuseremail(currentuser),0);
			} else if (e.getSource() == back) {
				main.wp.setVisible(true);
				dispose();
			} else if (e.getSource() == deleteaccountbtn) {
				JPasswordField pf = new JPasswordField();
				int t = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				if (t == JOptionPane.OK_OPTION) {
					String password = new String(pf.getPassword());
					System.out.print(password);
					int t1 = db.deleteuseraccount(currentuser, password);
					if (t1 == 1) {
						JOptionPane.showMessageDialog(null, "Account Deleted..");
						main.wp.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Wrong Password..");
					}
				}
			}
		}
	}
}
