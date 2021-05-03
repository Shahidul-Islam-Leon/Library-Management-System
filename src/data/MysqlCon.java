/**
 * 
 */
package data;

import ui.userpage;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author MD MONIRUZZAMAN
 *
 */
public class MysqlCon {
	private Connection con = null;
	private Statement stat = null;
	private ResultSet rs = null;
	private userpage up;

	@SuppressWarnings("finally")
	public boolean useradder(String username, String password, String email) {
		int temp = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();

			rs = stat.executeQuery("select * from user where username='" + username + "'");
			if (!rs.next()) {
				stat.executeUpdate("insert into user VALUES ('" + username + "','" + password + "','" + email + "')");
				JOptionPane.showMessageDialog(null, "Account created");
				temp = 1;
			} else {
				JOptionPane.showMessageDialog(null, "username already taken");

			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		} finally {
			if (temp == 1) {
				return true;
			} else {
				return false;
			}
		}

	}

	public void defaultdb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery(
					"select * from information_schema.tables where table_schema='mydatabase' and table_name='books'");
			if (!rs.next()) {
				stat.executeUpdate(
						"CREATE TABLE books( book_id VARCHAR(255) NOT NULL, book_name VARCHAR(255) NOT NULL, book_author VARCHAR(255) NOT NULL, published_year VARCHAR(255) NOT NULL, pdf LONGBLOB NOT NULL, PRIMARY KEY (book_id))");
			}
			rs = stat.executeQuery(
					"select * from information_schema.tables where table_schema='mydatabase' and table_name='admin'");
			if (!rs.next()) {
				stat.executeUpdate(
						"create table admin(name VARCHAR(255) not null, password VARCHAR(255) not null, email VARCHAR(255), primary key(name))");
			}
			rs = stat.executeQuery("select * from admin where name='admin'");
			if (!rs.next()) {
				stat.executeUpdate("insert into admin values('admin','admin','admin')");
			}
			rs = stat.executeQuery(
					"SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='mydatabase' AND TABLE_NAME='user' ");
			if (!rs.next()) {
				String sql = "CREATE TABLE user(username VARCHAR(255) not NULL,password VARCHAR(255) not NULL,email VARCHAR(255) not NULL, primary key(username))";
				stat.executeUpdate(sql);
			}
			stat.executeUpdate("set GLOBAL max_allowed_packet= 100*1024*1024");
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
		}
	}

	public boolean userloginchecker(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery(
					"select *from user where username='" + username + "' and password='" + password + "'");
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		} finally {
		}
	}

	public boolean adminloginchecker(String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select *from admin where name='" + username + "' and password='" + password + "'");
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		} finally {
		}
	}

	public void pdfwritter(String id, String a, String n, String y, byte[] pdf) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			PreparedStatement pstmt = null;
			stat = con.createStatement();
			rs = stat.executeQuery("select * from books where book_id='" + id + "'");
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Book ID already exist...");
			} else {
				String sql = "insert into books values(?,?,?,?,?)";
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, n);
				pstmt.setString(3, a);
				pstmt.setString(4, y);
				pstmt.setBytes(5, pdf);
				pstmt.executeUpdate();
				pstmt.close();
				JOptionPane.showMessageDialog(null, "Upload successfull", "PDF upload Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public void pdfdownload(String s, String id, String name) {
		s = s + "\\" + name + ".pdf";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select pdf from books where book_id= '" + id + "' ");
			InputStream in = null;
			while (rs.next()) {
				in = rs.getBinaryStream(1);
			}
			int available1 = in.available();
			byte[] bt = new byte[available1];
			in.read(bt);
			FileOutputStream fout = new FileOutputStream(s);
			DataOutputStream dout = new DataOutputStream(fout);
			dout.write(bt, 0, bt.length);
			JOptionPane.showMessageDialog(null, "File saved...");
			fout.close();

			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
		}
	}

	public void deletebook(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select * from books where book_id='" + id + "'");
			if (!rs.next()) {
				rs.close();
				stat.close();
				con.close();
				JOptionPane.showMessageDialog(null, "No book found..");
			} else {
				stat.executeUpdate("delete  from books where book_id='" + id + "'");
				rs.close();
				stat.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Book Deleted...");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		} finally {
		}

	}

	public ResultSet displaybook() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select book_name,book_id,book_author,published_year from books where 1");
			return rs;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		} finally {
		}
		return null;
	}

	public String getuseremail(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select email from user where username='" + name + "'");
			rs.next();
			String t = rs.getString("email");
			rs.close();
			stat.close();
			con.close();
			return t;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
		}
		return null;
	}

	public int deleteuseraccount(String username, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select * from user where username='" + username + "' and password='" + pass + "'");
			if (rs.next()) {
				stat.executeUpdate("delete from user where username='" + username + "'");
				rs.close();
				stat.close();
				con.close();
				return 1;
			} else {
				rs.close();
				stat.close();
				con.close();
				return 0;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return 0;
	}

	public boolean userinfoupdater(String username, String newname, String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select * from user where username='" + newname
					+ "' except select * from user where username='" + username + "'");
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Username Already Exist.. Info can not be updated.");
				rs.close();
				stat.close();
				con.close();
				return false;
			} else {
				if (username == newname) {
					stat.executeUpdate("update user set email='" + email + "' where username='" + username + "'");
				} else {
					stat.executeUpdate("update user set username='" + newname + "' , email='" + email
							+ "' where username='" + username + "'");
				}
				stat.close();
				con.close();
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return false;
	}

	public boolean userpasswordupdater(String username, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			stat.executeUpdate("update user set password='" + pass + "' where username='" + username + "'");
			stat.close();
			con.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return false;
	}

	public ResultSet searchbook(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery(
					"select book_name,book_id,book_author,published_year from books where book_id='" + id + "'");
			return rs;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		} finally {
		}
		return null;

	}

	public ResultSet searchuser(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select username,email from user where username='" + username + "'");
			return rs;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		} finally {
		}
		return null;
	}

	public ResultSet showallusers() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select username,email from user where 1");
			return rs;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		} finally {
		}
		return null;
	}

	public ResultSet showallbooks() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			stat = con.createStatement();
			rs = stat.executeQuery("select book_name,book_id,book_author,published_year from books where 1");
			return rs;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		} finally {
		}
		return null;

	}
}
