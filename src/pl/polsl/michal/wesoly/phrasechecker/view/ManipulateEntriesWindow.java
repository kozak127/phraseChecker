package pl.polsl.michal.wesoly.phrasechecker.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ManipulateEntriesWindow extends JFrame {

	private static final long serialVersionUID = -6600532910086363533L;
	private JPanel contentPane;
	private JTextField textField_NativeMeaning;
	private JTextField textField_ForeignMeaning;

	/**
	 * Create the frame.
	 */
	public ManipulateEntriesWindow(ActionListener listener) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblSelectPhrase = new JLabel("Select Phrase");
		contentPane.add(lblSelectPhrase, "2, 2, center, default");

		JLabel lblNativeMeaning = new JLabel("Native Meaning");
		contentPane.add(lblNativeMeaning, "2, 6, center, default");

		textField_NativeMeaning = new JTextField();
		contentPane.add(textField_NativeMeaning, "4, 6, fill, default");
		textField_NativeMeaning.setColumns(10);

		JLabel lblForeignMeaning = new JLabel("Foreign Meaning");
		contentPane.add(lblForeignMeaning, "2, 8, center, default");

		textField_ForeignMeaning = new JTextField();
		contentPane.add(textField_ForeignMeaning, "4, 8, fill, default");
		textField_ForeignMeaning.setColumns(10);

		JButton btnAddPhrase = new JButton("Add Phrase");
		btnAddPhrase.addActionListener(listener);
		btnAddPhrase.setActionCommand("add");
		contentPane.add(btnAddPhrase, "2, 14");

		JButton btnRemovePhrase = new JButton("Remove Phrase");
		btnRemovePhrase.addActionListener(listener);
		btnRemovePhrase.setActionCommand("remove");
		contentPane.add(btnRemovePhrase, "2, 16");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(listener);
		btnCancel.setActionCommand("cancel");
		contentPane.add(btnCancel, "2, 18");
		setVisible(true);
	}

	public String getPhraseNativeMeaning() {
		return textField_NativeMeaning.getText();
	}

	public String getPhraseForeignMeaning() {
		return textField_ForeignMeaning.getText();
	}

}
