package ui;

import main.main;
import data.MysqlCon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class adminpage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MysqlCon db = new MysqlCon();
	private actionhandeler ah = new actionhandeler();
	private mousehandeler mh = new mousehandeler();
	private JTextField bookidtext_d;
	private JButton deletebook = new JButton("DELETE A BOOK");
	private JLabel deletebooklbl = new JLabel("TYPE BOOK ID AND PRESS DELETE");
	private JButton searchuser = new JButton("SEARCH USER");
	private JLabel bookidlbl_d = new JLabel("Book ID");
	private JButton delete = new JButton("DELETE");
	private JTextField srarchusertext;
	private JLabel searchuserlbl = new JLabel("ENTER AN  USERNAME AND PRESS SEARCH");
	private JButton searchuserbtn = new JButton("SEARCH");
	private JLabel usernamelbl_s = new JLabel("User Name");
	private JLabel bookidlbl_s = new JLabel("Book ID");
	private JTextField bookidtext_s = new JTextField();
	private JButton searchbookbtn = new JButton("SEARCH");
	private JLabel searchbooklbl = new JLabel("ENTER A BOOK ID AND PRESS SEARCH");
	private JButton searchbook = new JButton("SEARCH BOOK");
	private JButton showbooklist = new JButton("SHOW ALL BOOKS");
	private JButton showuserlist = new JButton("SHOW ALL USERS");
	private JButton addbook = new JButton("ADD A BOOK");
	private JButton back = new JButton("");
	private JButton browse = new JButton("BROWSE");
	private JButton upload = new JButton("UPLOAD");
	private String filepath = null;
	private JLabel bookid_a = new JLabel("Book ID");
	private JTextField bookidtext_a;
	private JLabel authorlbl = new JLabel("AUTHOR");
	private JTextField authortext = new JTextField();
	private JLabel bookname = new JLabel("NAME");
	private JTextField booknametext = new JTextField();
	private JLabel yearlbl = new JLabel("YEAR");
	private JTextField yeartext = new JTextField();

	private String id = null;
	private String author = null;
	private String name = null;
	private String pyear = null;
	private byte[] pdfdata = null;
	private String bookid_d = null;
	private String bookid_s = null;
	private String username_s = null;

	private KeyHandeler kh = new KeyHandeler();

	public adminpage(String name) {

		setIconImage(Toolkit.getDefaultToolkit().getImage(adminpage.class.getResource("/Image/icon.png")));
		setTitle("OB Library-Admin");
		getContentPane().setBackground(new Color(0, 0, 153));
		getContentPane().setLayout(null);

		deletebooklbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deletebooklbl.setForeground(new Color(240, 255, 255));
		deletebooklbl.setHorizontalAlignment(SwingConstants.CENTER);
		deletebooklbl.setBounds(10, 179, 314, 30);
		deletebooklbl.setVisible(false);

		searchuserbtn.setBackground(new Color(107, 142, 35));
		searchuserbtn.setForeground(new Color(240, 255, 255));
		searchuserbtn.setBounds(1171, 228, 85, 26);
		searchuserbtn.addActionListener(ah);
		searchuserbtn.setVisible(false);

		usernamelbl_s.setFont(new Font("Agency FB", Font.PLAIN, 20));
		usernamelbl_s.setForeground(new Color(240, 255, 255));
		usernamelbl_s.setBounds(942, 228, 74, 26);
		usernamelbl_s.setVisible(false);

		searchbookbtn.setVisible(false);
		authortext.setVisible(false);

		authortext.setBounds(1131, 45, 125, 25);
		authortext.setColumns(10);
		authortext.addKeyListener(kh);
		booknametext.setVisible(false);

		booknametext.setBounds(992, 75, 264, 26);
		booknametext.setColumns(10);
		booknametext.addKeyListener(kh);
		yeartext.setVisible(false);
		yeartext.setBounds(992, 107, 79, 25);
		yeartext.setColumns(10);
		yeartext.addKeyListener(kh);
		browse.setForeground(new Color(255, 255, 255));
		browse.setBackground(new Color(107, 142, 35));
		browse.setVisible(false);
		browse.setFont(new Font("Tahoma", Font.PLAIN, 13));

		browse.setBounds(1076, 107, 85, 25);
		browse.addActionListener(ah);
		upload.setForeground(new Color(255, 255, 255));
		upload.setBackground(new Color(47, 79, 79));
		upload.setVisible(false);

		upload.setFont(new Font("Tahoma", Font.PLAIN, 13));
		upload.addActionListener(ah);
		upload.setBounds(1171, 107, 85, 25);

		getContentPane().add(upload);
		getContentPane().add(browse);

		getContentPane().add(yeartext);
		yearlbl.setVisible(false);
		yearlbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
		yearlbl.setForeground(new Color(240, 255, 255));
		yearlbl.setBounds(935, 110, 46, 21);

		getContentPane().add(yearlbl);

		getContentPane().add(booknametext);
		bookname.setVisible(false);
		bookname.setForeground(new Color(240, 255, 255));
		bookname.setFont(new Font("Agency FB", Font.PLAIN, 20));
		bookname.setBounds(935, 80, 46, 21);

		getContentPane().add(bookname);

		getContentPane().add(authortext);
		authorlbl.setVisible(false);

		authorlbl.setForeground(new Color(240, 255, 255));
		authorlbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
		authorlbl.setBounds(1076, 45, 56, 25);

		getContentPane().add(authorlbl);

		bookidtext_a = new JTextField();
		bookidtext_a.setVisible(false);
		bookidtext_a.setBounds(992, 45, 74, 25);
		getContentPane().add(bookidtext_a);
		bookidtext_a.setColumns(10);
		bookidtext_a.addKeyListener(kh);
		bookid_a.setVisible(false);
		bookid_a.setFont(new Font("Agency FB", Font.PLAIN, 20));
		bookid_a.setForeground(new Color(240, 255, 255));
		bookid_a.setBounds(935, 49, 47, 21);
		getContentPane().add(bookid_a);
		searchbookbtn.setBackground(new Color(51, 204, 0));
		searchbookbtn.setForeground(new Color(245, 255, 250));
		searchbookbtn.setBounds(221, 314, 85, 30);
		searchbookbtn.addActionListener(ah);
		getContentPane().add(searchbookbtn);

		bookidtext_s.setVisible(false);
		bookidtext_s.setBounds(84, 314, 127, 30);
		bookidtext_s.setColumns(10);
		bookidtext_s.addKeyListener(kh);
		getContentPane().add(bookidtext_s);

		bookidlbl_s.setVisible(false);
		bookidlbl_s.setFont(new Font("Agency FB", Font.PLAIN, 20));
		bookidlbl_s.setHorizontalAlignment(SwingConstants.CENTER);
		bookidlbl_s.setForeground(new Color(245, 255, 250));
		bookidlbl_s.setBounds(10, 314, 65, 30);
		getContentPane().add(bookidlbl_s);

		showbooklist.setVerticalAlignment(SwingConstants.TOP);
		showbooklist.setBackground(new Color(50, 50, 105));
		showbooklist.setFont(new Font("Forte", Font.PLAIN, 80));
		showbooklist.setForeground(new Color(0, 204, 0));
		showbooklist.setBounds(0, 477, 1266, 87);
		showbooklist.addActionListener(ah);
		showbooklist.addMouseListener(mh);
		getContentPane().add(showbooklist);

		searchbooklbl.setVisible(false);
		searchbooklbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchbooklbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchbooklbl.setForeground(new Color(245, 255, 250));
		searchbooklbl.setBounds(10, 354, 296, 28);

		getContentPane().add(searchbooklbl);
		getContentPane().add(usernamelbl_s);

		srarchusertext = new JTextField();
		srarchusertext.setBounds(1026, 228, 127, 26);
		getContentPane().add(srarchusertext);
		srarchusertext.setVisible(false);
		srarchusertext.setColumns(10);
		srarchusertext.addKeyListener(kh);
		getContentPane().add(searchuserbtn);

		searchuserlbl.setHorizontalTextPosition(SwingConstants.CENTER);
		searchuserlbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchuserlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchuserlbl.setForeground(new Color(240, 255, 255));
		searchuserlbl.setBounds(950, 264, 306, 31);
		getContentPane().add(searchuserlbl);
		searchuserlbl.setVisible(false);
		getContentPane().add(deletebooklbl);

		bookidtext_d = new JTextField();
		bookidtext_d.setBounds(79, 142, 144, 26);
		getContentPane().add(bookidtext_d);
		bookidtext_d.setVisible(false);
		bookidtext_d.setColumns(10);
		bookidtext_d.addKeyListener(kh);

		bookidlbl_d.setFont(new Font("Agency FB", Font.PLAIN, 20));
		bookidlbl_d.setForeground(new Color(240, 255, 255));
		bookidlbl_d.setBounds(10, 144, 65, 26);
		bookidlbl_d.setVisible(false);
		getContentPane().add(bookidlbl_d);

		delete.setForeground(new Color(240, 255, 255));
		delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		delete.setBackground(new Color(255, 0, 0));
		delete.setBounds(239, 142, 85, 27);
		delete.setVisible(false);
		delete.addActionListener(ah);
		getContentPane().add(delete);

		JLabel welcomemassage = new JLabel("");
		welcomemassage.setFont(new Font("Agency FB", Font.PLAIN, 43));
		welcomemassage.setForeground(new Color(240, 255, 255));
		welcomemassage.setBackground(Color.WHITE);
		welcomemassage.setHorizontalTextPosition(SwingConstants.CENTER);
		welcomemassage.setHorizontalAlignment(SwingConstants.CENTER);
		welcomemassage.setBounds(33, 0, 1233, 41);
		welcomemassage.setText("Hi " + name);
		getContentPane().add(welcomemassage);
		addbook.setVerticalAlignment(SwingConstants.TOP);
		addbook.setVerticalTextPosition(SwingConstants.TOP);
		addbook.setHorizontalTextPosition(SwingConstants.CENTER);
		addbook.setFont(new Font("Forte", Font.PLAIN, 80));
		addbook.setForeground(new Color(0, 204, 0));
		addbook.setBackground(new Color(50, 50, 255));
		addbook.setBounds(0, 45, 1266, 87);
		addbook.addMouseListener(mh);
		addbook.addActionListener(ah);
		getContentPane().add(addbook);

		deletebook.setVerticalAlignment(SwingConstants.TOP);
		deletebook.setBackground(new Color(50, 50, 225));
		deletebook.setForeground(new Color(0, 204, 0));
		deletebook.setFont(new Font("Forte", Font.PLAIN, 80));
		deletebook.setBounds(0, 131, 1266, 87);
		deletebook.addActionListener(ah);
		deletebook.addMouseListener(mh);
		getContentPane().add(deletebook);

		searchuser.setBackground(new Color(50, 50, 195));
		searchuser.setVerticalAlignment(SwingConstants.TOP);
		searchuser.setForeground(new Color(0, 204, 0));
		searchuser.setFont(new Font("Forte", Font.PLAIN, 80));
		searchuser.setBounds(0, 217, 1266, 87);
		searchuser.addActionListener(ah);
		searchuser.addMouseListener(mh);
		getContentPane().add(searchuser);

		searchbook.setBackground(new Color(50, 50, 165));
		searchbook.setForeground(new Color(0, 204, 0));
		searchbook.setVerticalAlignment(SwingConstants.TOP);
		searchbook.setHorizontalTextPosition(SwingConstants.RIGHT);
		searchbook.setFont(new Font("Forte", Font.PLAIN, 80));
		searchbook.setBounds(0, 304, 1266, 87);
		searchbook.addActionListener(ah);
		searchbook.addMouseListener(mh);
		getContentPane().add(searchbook);

		showuserlist.setBackground(new Color(50, 50, 135));
		showuserlist.setForeground(new Color(0, 204, 0));
		showuserlist.setVerticalAlignment(SwingConstants.TOP);
		showuserlist.setHorizontalTextPosition(SwingConstants.CENTER);
		showuserlist.setFont(new Font("Forte", Font.PLAIN, 80));
		showuserlist.setBounds(0, 391, 1266, 87);
		showuserlist.addActionListener(ah);
		showuserlist.addMouseListener(mh);
		getContentPane().add(showuserlist);

		back.setToolTipText("back");
		back.setBackground(new Color(0, 204, 204));
		back.setHorizontalTextPosition(SwingConstants.CENTER);
		back.setVerticalTextPosition(SwingConstants.TOP);
		back.setVerticalAlignment(SwingConstants.TOP);
		back.setIcon(new ImageIcon(adminpage.class.getResource("/Image/back.png")));
		back.setBounds(0, 0, 34, 34);
		back.addActionListener(ah);
		back.addMouseListener(mh);
		getContentPane().add(back);

		setBounds(50, 50, 1280, 720);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class actionhandeler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == deletebook) {
				deletebook.setBounds(334, 131, 932, 87);
				deletebooklbl.setVisible(true);
				bookidtext_d.setVisible(true);
				delete.setVisible(true);
				bookidlbl_d.setVisible(true);
				searchuser.setBounds(0, 217, 1266, 87);
				searchbook.setBounds(0, 304, 1266, 87);
				searchbookbtn.setVisible(false);
				bookidlbl_s.setVisible(false);
				bookidtext_s.setVisible(false);
				searchbooklbl.setVisible(false);
				searchuserlbl.setVisible(false);
				searchuserbtn.setVisible(false);
				srarchusertext.setVisible(false);
				usernamelbl_s.setVisible(false);
				addbook.setBounds(0, 45, 1266, 87);
				bookid_a.setVisible(false);
				bookidtext_a.setVisible(false);
				authorlbl.setVisible(false);
				authortext.setVisible(false);
				bookname.setVisible(false);
				booknametext.setVisible(false);
				yearlbl.setVisible(false);
				yeartext.setVisible(false);
				browse.setVisible(false);
				upload.setVisible(false);

			}
			if (e.getSource() == searchuser) {
				searchuser.setBounds(0, 217, 932, 87);
				searchuserlbl.setVisible(true);
				searchuserbtn.setVisible(true);
				srarchusertext.setVisible(true);
				usernamelbl_s.setVisible(true);
				deletebook.setBounds(0, 131, 1266, 87);
				searchbook.setBounds(0, 304, 1266, 87);
				searchbookbtn.setVisible(false);
				bookidlbl_s.setVisible(false);
				bookidtext_s.setVisible(false);
				searchbooklbl.setVisible(false);
				deletebooklbl.setVisible(false);
				bookidtext_d.setVisible(false);
				delete.setVisible(false);
				bookidlbl_d.setVisible(false);
				addbook.setBounds(0, 45, 1266, 87);
				bookid_a.setVisible(false);
				bookidtext_a.setVisible(false);
				authorlbl.setVisible(false);
				authortext.setVisible(false);
				bookname.setVisible(false);
				booknametext.setVisible(false);
				yearlbl.setVisible(false);
				yeartext.setVisible(false);
				browse.setVisible(false);
				upload.setVisible(false);
			}
			if (e.getSource() == searchbook) {
				searchbook.setBounds(334, 304, 932, 87);
				searchbookbtn.setVisible(true);
				bookidlbl_s.setVisible(true);
				bookidtext_s.setVisible(true);
				searchbooklbl.setVisible(true);
				deletebook.setBounds(0, 131, 1266, 87);
				searchuser.setBounds(0, 217, 1266, 87);
				searchuserlbl.setVisible(false);
				searchuserbtn.setVisible(false);
				srarchusertext.setVisible(false);
				usernamelbl_s.setVisible(false);
				deletebooklbl.setVisible(false);
				bookidtext_d.setVisible(false);
				delete.setVisible(false);
				bookidlbl_d.setVisible(false);
				addbook.setBounds(0, 45, 1266, 87);
				bookid_a.setVisible(false);
				bookidtext_a.setVisible(false);
				authorlbl.setVisible(false);
				authortext.setVisible(false);
				bookname.setVisible(false);
				booknametext.setVisible(false);
				yearlbl.setVisible(false);
				yeartext.setVisible(false);
				browse.setVisible(false);
				upload.setVisible(false);
			}
			if (e.getSource() == back) {
				main.wp.setVisible(true);
				dispose();
			}
			if (e.getSource() == showbooklist) {
				deletebook.setBounds(0, 131, 1266, 87);
				searchuser.setBounds(0, 217, 1266, 87);
				searchbook.setBounds(0, 304, 1266, 87);
				searchbookbtn.setVisible(false);
				bookidlbl_s.setVisible(false);
				bookidtext_s.setVisible(false);
				searchbooklbl.setVisible(false);
				searchuserlbl.setVisible(false);
				searchuserbtn.setVisible(false);
				srarchusertext.setVisible(false);
				usernamelbl_s.setVisible(false);
				deletebooklbl.setVisible(false);
				bookidtext_d.setVisible(false);
				delete.setVisible(false);
				bookidlbl_d.setVisible(false);
				addbook.setBounds(0, 45, 1266, 87);
				bookid_a.setVisible(false);
				bookidtext_a.setVisible(false);
				authorlbl.setVisible(false);
				authortext.setVisible(false);
				bookname.setVisible(false);
				booknametext.setVisible(false);
				yearlbl.setVisible(false);
				yeartext.setVisible(false);
				browse.setVisible(false);
				upload.setVisible(false);
			}
			if (e.getSource() == showuserlist) {
				deletebook.setBounds(0, 131, 1266, 87);
				searchuser.setBounds(0, 217, 1266, 87);
				searchbook.setBounds(0, 304, 1266, 87);
				searchbookbtn.setVisible(false);
				bookidlbl_s.setVisible(false);
				bookidtext_s.setVisible(false);
				searchbooklbl.setVisible(false);
				searchuserlbl.setVisible(false);
				searchuserbtn.setVisible(false);
				srarchusertext.setVisible(false);
				usernamelbl_s.setVisible(false);
				deletebooklbl.setVisible(false);
				bookidtext_d.setVisible(false);
				delete.setVisible(false);
				bookidlbl_d.setVisible(false);
				addbook.setBounds(0, 45, 1266, 87);
				bookid_a.setVisible(false);
				bookidtext_a.setVisible(false);
				authorlbl.setVisible(false);
				authortext.setVisible(false);
				bookname.setVisible(false);
				booknametext.setVisible(false);
				yearlbl.setVisible(false);
				yeartext.setVisible(false);
				browse.setVisible(false);
				upload.setVisible(false);
			}
			if (e.getSource() == addbook) {
				addbook.setBounds(0, 45, 932, 87);
				deletebook.setBounds(0, 131, 1266, 87);
				searchuser.setBounds(0, 217, 1266, 87);
				searchbook.setBounds(0, 304, 1266, 87);
				searchbookbtn.setVisible(false);
				bookidlbl_s.setVisible(false);
				bookidtext_s.setVisible(false);
				searchbooklbl.setVisible(false);
				searchuserlbl.setVisible(false);
				searchuserbtn.setVisible(false);
				srarchusertext.setVisible(false);
				usernamelbl_s.setVisible(false);
				deletebooklbl.setVisible(false);
				bookidtext_d.setVisible(false);
				delete.setVisible(false);
				bookidlbl_d.setVisible(false);

				bookid_a.setVisible(true);
				bookidtext_a.setVisible(true);
				authorlbl.setVisible(true);
				authortext.setVisible(true);
				bookname.setVisible(true);
				booknametext.setVisible(true);
				yearlbl.setVisible(true);
				yeartext.setVisible(true);
				browse.setVisible(true);
				upload.setVisible(true);

			}
			if (e.getSource() == browse) {
				try {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
					chooser.setFileFilter(filter);
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					filepath = f.getAbsolutePath();
					browse.setBackground(new Color(107, 142, 35));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No File Seleced...");
				} finally {
				}
			}
			if (e.getSource() == upload) {
				if (id == null) {
					bookid_a.setForeground(Color.red);
				}
				if (author == null) {
					authorlbl.setForeground(Color.red);
				}
				if (pyear == null) {
					yearlbl.setForeground(Color.red);
				}
				if (name == null) {
					bookname.setForeground(Color.red);
				}
				if (filepath == null) {
					browse.setBackground(Color.red);
				}
				if (id != null && author != null && pyear != null && name != null && filepath != null) {
					try {
						File pdffile = new File(filepath);
						FileInputStream fis = new FileInputStream(pdffile);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						pdfdata = new byte[104857600];
						for (int readNum; (readNum = fis.read(pdfdata)) != -1;) {
							baos.write(pdfdata, 0, readNum);
						}
						pdfdata = baos.toByteArray();
						db.pdfwritter(id, author, name, pyear, pdfdata);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					} finally {
					}
				}
			}
			if (e.getSource() == delete) {
				if (bookid_d == null) {
					deletebooklbl.setText("Insert Book ID first");
					deletebooklbl.setForeground(Color.RED);
					bookidlbl_d.setForeground(Color.red);
				} else {
					db.deletebook(bookid_d);
				}
			}
			if (e.getSource() == searchbookbtn) {
				if (bookid_s != null) {
					searchbooklbl.setForeground(new Color(245, 255, 250));
					searchbooklbl.setText("Enter a Book ID and press search");
					ResultSet rs = db.searchbook(bookid_s);
					try {
						if (rs.next()) {
							bookinfo bi = new bookinfo(rs.getString("book_name"), rs.getString("book_author"),
									rs.getString("published_year"));
							rs.close();
						} else {
							JOptionPane.showMessageDialog(null, "Book not found", "Book searching result",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else {
					searchbooklbl.setText("Enter a book ID first");
					searchbooklbl.setForeground(Color.red);
				}
			}
			if (e.getSource() == searchuserbtn) {
				if (username_s != null) {
					searchuserlbl.setForeground(new Color(245, 255, 250));
					searchuserlbl.setText("Enter an Username and press search");
					ResultSet rs = db.searchuser(username_s);
					try {
						if (rs.next()) {
							userinfo ui = new userinfo(rs.getString("username"), rs.getString("email"), 1);
							rs.close();
						} else {
							JOptionPane.showMessageDialog(null, "User not found", "User searching result",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else {
					searchuserlbl.setText("Enter an Username first");
					searchuserlbl.setForeground(Color.red);
				}
			}
			if (e.getSource() == showuserlist) {
				ResultSet rs = db.showallusers();
				int n = 0;
				try {
					while (rs.next()) {
						n++;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
				}

				String[][] data = new String[n][2];
				int t1 = 0;
				ResultSet rs1 = db.showallusers();
				try {
					if (!rs1.next()) {
						System.out.println("no data");
					}
					while (rs1.next()) {
						data[t1][0] = (rs1.getString("username"));
						data[t1][1] = (rs1.getString("email"));
						t1++;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
				String[] t = { "UserName", "Email" };
				showall sa = new showall(data, t, "user");
			}
			if (e.getSource() == showbooklist) {
				ResultSet rs = db.showallbooks();
				int n = 0;
				try {
					while (rs.next()) {
						n++;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
				String[][] data = new String[n][4];
				int t1 = 0;
				ResultSet rs1 = db.showallbooks();
				try {
					if (!rs1.next()) {
						System.out.println("no data");
					}
					while (rs1.next()) {
						data[t1][0] = (rs1.getString("book_id"));
						data[t1][1] = (rs1.getString("book_name"));
						data[t1][2] = (rs1.getString("book_author"));
						data[t1][3] = (rs1.getString("published_year"));
						t1++;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
				String[] t = { "Book ID", "Book Name", "Author", "Year" };
				showall sb = new showall(data, t, "book");
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
			if (e.getSource() == addbook) {
				addbook.setBackground(new Color(50, 50, 105));
				addbook.setFont(new Font("Algerian", Font.PLAIN, 80));
			}
			if (e.getSource() == deletebook) {
				deletebook.setBackground(new Color(50, 50, 135));
				deletebook.setFont(new Font("Algerian", Font.PLAIN, 80));
			}
			if (e.getSource() == searchuser) {
				searchuser.setBackground(new Color(50, 50, 165));
				searchuser.setFont(new Font("Algerian", Font.PLAIN, 80));
			}
			if (e.getSource() == searchbook) {
				searchbook.setBackground(new Color(50, 50, 195));
				searchbook.setFont(new Font("Algerian", Font.PLAIN, 80));
			}
			if (e.getSource() == showuserlist) {
				showuserlist.setBackground(new Color(50, 50, 225));
				showuserlist.setFont(new Font("Algerian", Font.PLAIN, 80));
			}
			if (e.getSource() == showbooklist) {
				showbooklist.setBackground(new Color(50, 50, 255));
				showbooklist.setFont(new Font("Algerian", Font.PLAIN, 80));
			}
			if (e.getSource() == back) {
				back.setBackground(new Color(0, 204, 0));
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource() == addbook) {
				addbook.setBackground(new Color(50, 50, 255));
				addbook.setFont(new Font("Forte", Font.PLAIN, 80));
			}
			if (e.getSource() == deletebook) {
				deletebook.setBackground(new Color(50, 50, 225));
				deletebook.setFont(new Font("Forte", Font.PLAIN, 80));
			}
			if (e.getSource() == searchuser) {
				searchuser.setBackground(new Color(50, 50, 195));
				searchuser.setFont(new Font("Forte", Font.PLAIN, 80));
			}
			if (e.getSource() == searchbook) {
				searchbook.setBackground(new Color(50, 50, 165));
				searchbook.setFont(new Font("Forte", Font.PLAIN, 80));
			}
			if (e.getSource() == showuserlist) {
				showuserlist.setBackground(new Color(50, 50, 135));
				showuserlist.setFont(new Font("Forte", Font.PLAIN, 80));
			}
			if (e.getSource() == showbooklist) {
				showbooklist.setBackground(new Color(50, 50, 105));
				showbooklist.setFont(new Font("Forte", Font.PLAIN, 80));
			}
			if (e.getSource() == back) {
				back.setBackground(new Color(0, 204, 204));
			}
		}
	}

	private class KeyHandeler implements KeyListener {

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {
			if (e.getSource() == bookidtext_a) {
				id = bookidtext_a.getText();
				bookid_a.setForeground(new Color(240, 255, 255));
				if (id.length() == 0) {
					id = null;
					bookid_a.setForeground(Color.red);
				}
			}
			if (e.getSource() == authortext) {
				author = authortext.getText();
				authorlbl.setForeground(new Color(240, 255, 255));
				if (author.length() == 0) {
					author = null;
					authorlbl.setForeground(Color.red);
				}
			}
			if (e.getSource() == booknametext) {
				name = booknametext.getText();
				bookname.setForeground(new Color(240, 255, 255));
				if (name.length() == 0) {
					name = null;
					bookname.setForeground(Color.red);
				}
			}
			if (e.getSource() == yeartext) {
				pyear = yeartext.getText();
				yearlbl.setForeground(new Color(240, 255, 255));
				if (pyear.length() == 0) {
					pyear = null;
					yearlbl.setForeground(Color.red);
				}
			}
			if (e.getSource() == bookidtext_d) {
				bookid_d = bookidtext_d.getText();
				bookidlbl_d.setForeground(new Color(240, 255, 255));
				if (bookid_d.length() == 0) {
					bookid_d = null;
					bookidlbl_d.setForeground(Color.red);
				}
			}
			if (e.getSource() == bookidtext_s) {
				bookid_s = bookidtext_s.getText();
				bookidlbl_s.setForeground(new Color(245, 255, 250));
				if (bookid_s.length() == 0) {
					bookid_s = null;
					bookidlbl_s.setForeground(Color.red);
				}
			}
			if (e.getSource() == srarchusertext) {
				username_s = srarchusertext.getText();
				usernamelbl_s.setForeground(new Color(245, 255, 250));
				if (username_s.length() == 0) {
					username_s = null;
					usernamelbl_s.setForeground(Color.red);
				}
			}
		}
	}
}
