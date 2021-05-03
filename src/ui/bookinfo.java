package ui;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class bookinfo extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

bookinfo(String name,String author,String year) {

	super("OB Book-Info");
	setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Image/icon.png")));
	getContentPane().setBackground(new Color(0, 0, 153));
	setBounds(400, 100, 721, 198);
	getContentPane().setLayout(null);
	
	JLabel bnamelbl = new JLabel("Name :");
	bnamelbl.setForeground(new Color(240, 255, 255));
	bnamelbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
	bnamelbl.setBounds(10, 20, 56, 28);
	getContentPane().add(bnamelbl);
	
	JLabel bname = new JLabel(name);
	bname.setForeground(new Color(240, 255, 255));
	bname.setFont(new Font("Agency FB", Font.PLAIN, 20));
	bname.setBounds(138, 20, 559, 28);
	getContentPane().add(bname);
	
	JLabel authorlbl = new JLabel("Author :");
	authorlbl.setForeground(new Color(240, 255, 255));
	authorlbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
	authorlbl.setBounds(10, 66, 56, 28);
	getContentPane().add(authorlbl);
	
	JLabel authornamelbl = new JLabel(author);
	authornamelbl.setForeground(new Color(240, 255, 255));
	authornamelbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
	authornamelbl.setBounds(138, 66, 559, 25);
	getContentPane().add(authornamelbl);
	
	JLabel publishedinlbl = new JLabel("Published In :");
	publishedinlbl.setForeground(new Color(240, 255, 255));
	publishedinlbl.setFont(new Font("Agency FB", Font.PLAIN, 20));
	publishedinlbl.setBounds(10, 111, 86, 29);
	getContentPane().add(publishedinlbl);
	
	JLabel lblNewLabel = new JLabel(year);
	lblNewLabel.setForeground(new Color(240, 255, 255));
	lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
	lblNewLabel.setBounds(138, 111, 466, 29);
	getContentPane().add(lblNewLabel);

	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}
}
