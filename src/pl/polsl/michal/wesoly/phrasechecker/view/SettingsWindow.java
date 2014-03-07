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

public class SettingsWindow extends JFrame {

	private static final long serialVersionUID = -6600532910086363533L;
	private JPanel contentPane;
	private JTextField textField_PhrasesInSingleSession;

	/**
	 * Create the frame.
	 */
	public SettingsWindow(ActionListener listener) {
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

		JLabel lblSettingsTitle = new JLabel("Settings");
		contentPane.add(lblSettingsTitle, "2, 2, center, default");

		JLabel lblPhrasesInSession = new JLabel("Phrases in session");
		contentPane.add(lblPhrasesInSession, "2, 6, center, default");

		textField_PhrasesInSingleSession = new JTextField();
		contentPane.add(textField_PhrasesInSingleSession, "4, 6, fill, default");
		textField_PhrasesInSingleSession.setColumns(10);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(listener);
		btnDone.setActionCommand("done");
		contentPane.add(btnDone, "2, 16");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(listener);
		btnCancel.setActionCommand("cancel");
		contentPane.add(btnCancel, "2, 18");
		setVisible(true);
	}

	public String getPhrasesNumberInSingleSession() {
		return textField_PhrasesInSingleSession.getText();
	}
	
	public void setPhrasesNumberInSingleSessionTextField(String phrasesCountDefinedMax) {
		textField_PhrasesInSingleSession.setText(phrasesCountDefinedMax);
	}
}
