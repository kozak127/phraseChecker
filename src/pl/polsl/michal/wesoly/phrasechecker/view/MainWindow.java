package pl.polsl.michal.wesoly.phrasechecker.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -1639384015460408675L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainWindow(ActionListener listener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
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
						FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblPhraseChecker = new JLabel("Phrase Checker version 1.3");
		contentPane.add(lblPhraseChecker, "8, 2, center, default");

		JButton btnStartCheckNative = new JButton(
				"Start Check: Native to Foreign");
		btnStartCheckNative.addActionListener(listener);
		btnStartCheckNative.setActionCommand("checkNative");
		contentPane.add(btnStartCheckNative, "8, 6, center, default");

		JButton btnStartCheckForeign = new JButton(
				"Start Check: Foreign to Native");
		btnStartCheckForeign.addActionListener(listener);
		btnStartCheckForeign.setActionCommand("checkForeign");
		contentPane.add(btnStartCheckForeign, "8, 8");

		JButton btnAddOrRemove = new JButton("Add or remove Phrase");
		btnAddOrRemove.addActionListener(listener);
		btnAddOrRemove.setActionCommand("manipulate");
		contentPane.add(btnAddOrRemove, "8, 12");

		JButton btnListPhrases = new JButton("List Phrases");
		btnListPhrases.addActionListener(listener);
		btnListPhrases.setActionCommand("list");
		contentPane.add(btnListPhrases, "8, 14");
		
		JButton btnLoadPhrases = new JButton("Load Phrases from File");
		btnLoadPhrases.addActionListener(listener);
		btnLoadPhrases.setActionCommand("load");
		contentPane.add(btnLoadPhrases, "8, 18");
		
		JButton btnSavePhrases = new JButton("Save Phrases to File");
		btnSavePhrases.addActionListener(listener);
		btnSavePhrases.setActionCommand("save");
		contentPane.add(btnSavePhrases, "8, 20");

		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(listener);
		btnSettings.setActionCommand("settings");
		contentPane.add(btnSettings, "8, 24");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(listener);
		btnExit.setActionCommand("exit");
		contentPane.add(btnExit, "8, 26");
		setVisible(true);
	}
}
