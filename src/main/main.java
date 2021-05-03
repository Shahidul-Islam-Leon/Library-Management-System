/**
 * This class calls all other classes and determine various actions.
 */
package main;

import javax.swing.JOptionPane;

import ui.WelcomePage;
import ui.adminpage;
import ui.userpage;
import data.MysqlCon;

/**
 * This part of project is written by MD MONIRUZZAMAN(17-34645-2).
 * 
 * @author MD MONIRUZZAMAN
 *
 */
public class main {
	public static WelcomePage wp;
	private static MysqlCon db = new MysqlCon();
	public static userpage up;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		db.defaultdb();
		wp = new WelcomePage();

	}

	public boolean userDataWritter(String username, String pass, String email) {
		if(db.useradder(username, pass, email)) {
			return true;
		}
		else return false;
	}

	public void userlogin(String username, String password) {
		
		if (db.userloginchecker(username, password)) {
			wp.setVisible(false);
			 up=new userpage(username);
		} else {
			JOptionPane.showMessageDialog(null, "Login failed.. incorrect username or password", "login message",
					JOptionPane.ERROR_MESSAGE, null);
		}
	}

	public void adminlogin(String username, String password) {
		if (db.adminloginchecker(username, password)) {
			wp.setVisible(false);
			adminpage ap = new adminpage(username);
		} else {
			JOptionPane.showMessageDialog(null, "Login failed.. incorrect username or password", "login message",
					JOptionPane.ERROR_MESSAGE, null);
		}
	}

}
