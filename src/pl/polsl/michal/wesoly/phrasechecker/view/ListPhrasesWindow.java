package pl.polsl.michal.wesoly.phrasechecker.view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ListPhrasesWindow extends JFrame {

	private static final long serialVersionUID = -2324176276495507062L;
	private JPanel contentPane;
	private JTable table_ListOfPhrases;

	/**
	 * Create the frame.
	 */
	public ListPhrasesWindow(@SuppressWarnings("rawtypes") Vector <Vector>tableData, Vector <String> columnNames) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table_ListOfPhrases = new JTable(tableData, columnNames);
		contentPane.add(table_ListOfPhrases, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(table_ListOfPhrases);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.setSize(300, 150);
	    
		setVisible(true);
	}
}
