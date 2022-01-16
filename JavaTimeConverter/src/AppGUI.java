import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class AppGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI window = new AppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Desktop.background"));
		frame.setBounds(100, 100, 739, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(40, 151, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 151, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(408, 151, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(573, 151, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(52, 123, 61, 16);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(418, 123, 61, 16);
		frame.getContentPane().add(lblTo);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnConvert.setBounds(308, 221, 117, 41);
		frame.getContentPane().add(btnConvert);
		
		JLabel lblTimeConverter = new JLabel("Time Zone Converter");
		lblTimeConverter.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTimeConverter.setBounds(288, 66, 168, 16);
		frame.getContentPane().add(lblTimeConverter);
	}
}
