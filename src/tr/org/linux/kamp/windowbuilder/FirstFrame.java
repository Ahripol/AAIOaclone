package tr.org.linux.kamp.windowbuilder;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import tr.org.linux.kamp.aaio.logic.GameLogic;
/**
 * Used window builder to make our clone a proper Desktop app.
 * @author ahripol
 *
 */

public class FirstFrame extends JFrame {

	private FirstPanel contentPane;
	private JTextField txtusername;
	private JPasswordField passwordField;
	private ButtonGroup buttonGroup;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FirstFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 350);
		contentPane = new FirstPanel();
		setTitle("Java 2017 AAIO");

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][][][][][][][][][][][][][][][][][][][][][]",
				"[][][][][][][][][][][][][][][][][][][][][][][][][][][]"));

		JLabel lblAaioAn = new JLabel("AAIO - an Agario clone");
		contentPane.add(lblAaioAn, "cell 1 3");

		JLabel lblUsername = new JLabel("Username:");
		contentPane.add(lblUsername, "cell 0 7,alignx trailing");

		txtusername = new JTextField();
		txtusername.setText("@username");
		contentPane.add(txtusername, "cell 1 7,growx");
		txtusername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		contentPane.add(lblPassword, "cell 0 8,alignx trailing");

		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 1 8,growx");

		JLabel lblSelectColor = new JLabel("Select Color:");
		contentPane.add(lblSelectColor, "cell 0 9,alignx trailing");

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("BLUE");
		comboBox.addItem("BLACK");
		comboBox.addItem("CYAN");
		comboBox.addItem("ligthGray");
		comboBox.addItem("MAGENTA");
		comboBox.addItem("PINK");
		comboBox.addItem("ORANGE");
		contentPane.add(comboBox, "cell 1 9,growx");

		JLabel lblDiffuculty = new JLabel("Diffuculty:");
		contentPane.add(lblDiffuculty, "cell 0 13,alignx trailing");

		JRadioButton rdbtnEasyPeasy = new JRadioButton("Easy Peasy");
		contentPane.add(rdbtnEasyPeasy, "flowx,cell 1 13");

		JRadioButton rdbtnStandart = new JRadioButton("Standart");
		contentPane.add(rdbtnStandart, "cell 1 13");

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hard\n");
		contentPane.add(rdbtnNewRadioButton, "cell 1 13");
		JRadioButton rdbtnNightmare = new JRadioButton("Nightmare");
		contentPane.add(rdbtnNightmare, "cell 1 13");
		rdbtnEasyPeasy.setSelected(true);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnStandart);
		buttonGroup.add(rdbtnEasyPeasy);
		buttonGroup.add(rdbtnNightmare);
		buttonGroup.add(rdbtnNewRadioButton);

		JButton btnStart = new JButton("Start");
		contentPane.add(btnStart, "flowx,cell 1 14");
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtusername.getText();
				Color selectedColor = Color.white;
				switch (comboBox.getSelectedItem().toString()) {
				case "BLUE":
					selectedColor = Color.blue;
					break;
				case "BLACK":
					selectedColor = Color.BLACK;
					break;
				case "CYAN":
					selectedColor = Color.CYAN;
					break;
				case "lightGray":
					selectedColor = Color.LIGHT_GRAY;
					break;
				case "MAGENTA":
					selectedColor = Color.MAGENTA;
					break;
				case "PINK":
					selectedColor = Color.PINK;
					break;
				case "ORANGE":
					selectedColor = Color.ORANGE;
					break;
				default:
					break;
				}

				Diffuculty diff = Diffuculty.EASYPEASY;
				if (rdbtnEasyPeasy.isSelected()) {
					diff = Diffuculty.EASYPEASY;
				} else if (rdbtnStandart.isSelected()) {
					diff = Diffuculty.STANDART;
				} else if (rdbtnNightmare.isSelected()) {
					diff = Diffuculty.NIGHTMARE;
				} else if (rdbtnNewRadioButton.isSelected()) {
					diff = Diffuculty.HARD;
				} else {
				}
				GameLogic gameLogic = new GameLogic(txtusername.getText(), selectedColor, diff);
				gameLogic.startApplication();

			}
		});

		JButton btnAbout = new JButton("About");
		contentPane.add(btnAbout, "cell 1 14");

		btnAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JLabel lblAboutInfo = new JLabel();
				JLabel lblAboutInfo2 = new JLabel();
				JLabel lblAboutInfo3 = new JLabel();

				contentPane.add(lblAboutInfo, "cell 1 16,alignx trailing");
				contentPane.add(lblAboutInfo2, "cell 1 20,alignx trailing");
				contentPane.add(lblAboutInfo3, "cell 1 24,alignx trailing");
				lblAboutInfo.setText("was made in LYK'17 Java Summer Camp ");
				lblAboutInfo2.setText(" by Ahripol a.k.a. Venus, Bilge, Günsu.");
				lblAboutInfo3.setText(" we are free");
				// OptionPane.showInputDialog(this, "we are free");

			}
		});

	}

}
