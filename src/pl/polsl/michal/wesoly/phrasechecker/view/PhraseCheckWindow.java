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

public class PhraseCheckWindow extends JFrame {

	private static final long serialVersionUID = -1259982166073173533L;
	private JPanel contentPane;
	private JTextField textField_toTranslate;
	private JTextField textField_Translated;

	/**
	 * Create the frame.
	 */
	public PhraseCheckWindow(ActionListener listener) {
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

		JLabel lblTranslate = new JLabel("Translate:");
		contentPane.add(lblTranslate, "4, 2");

		textField_toTranslate = new JTextField();
		textField_toTranslate.setEditable(false);
		contentPane.add(textField_toTranslate, "4, 8, fill, default");
		textField_toTranslate.setColumns(10);

		textField_Translated = new JTextField();
		contentPane.add(textField_Translated, "4, 10, fill, default");
		textField_Translated.setColumns(10);

		JButton btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(listener);
		btnTranslate.setActionCommand("translate");
		contentPane.add(btnTranslate, "4, 16");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(listener);
		btnCancel.setActionCommand("cancel");
		contentPane.add(btnCancel, "4, 18");
		setVisible(true);
	}

	public void setPhraseToCheck(String text) {
		textField_toTranslate.setText(text);
	}

	public String getUserTranslation() {
		return textField_Translated.getText();
	}
}
