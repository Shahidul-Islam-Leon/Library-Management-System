package ui;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class showall extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	public showall(String[][] data, String[] header, String selector) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminpage.class.getResource("/Image/icon.png")));
		getContentPane().setBackground(new Color(0, 0, 153));
		getContentPane().setLayout(null);

		if (selector == "user") {
			setTitle("OB Library- All Users");
		}
		if (selector == "book") {
			setTitle("OB Library- All Books");
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Agency FB", Font.PLAIN, 20));
		scrollPane.setBackground(new Color(0, 0, 153));
		scrollPane.setBounds(10, 10, 651, 628);
		getContentPane().add(scrollPane);

		table = new JTable(data, header);
		table.setSelectionBackground(new Color(0, 0, 153));
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setFont(new Font("Agency FB", Font.PLAIN, 20));
		table.setRowHeight(30);
		table.setForeground(new Color(240, 255, 255));
		table.setBackground(new Color(0, 0, 153));
		scrollPane.setViewportView(table);

		setBounds(50, 50, 685, 685);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
