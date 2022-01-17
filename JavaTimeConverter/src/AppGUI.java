import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AppGUI {

	private JFrame frame;
	private JTextField hourLeft;
	private JTextField minuteLeft;
	private JTextField hourRight;
	private JTextField minuteRight;

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
		
		
		//https://timezonedb.com/time-zones
		String[] countryName = {"America/argentina/Buenos_Aires","Australia/Sydney","America/Toronto","Asia/Shanghai","Africa/Cairo","Europe/Rome"
						,"India/Maldives"};
		int[] offSets = {-3,10,-4,8,2,2,2,5};
				
		hourLeft = new JTextField();
		hourLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charRead = e.getKeyChar();
				if (!Character.isDigit(charRead)) {
					e.consume();
				}
			}
		});
		hourLeft.setBounds(40, 151, 130, 26);
		frame.getContentPane().add(hourLeft);
		hourLeft.setColumns(10);
		
		minuteLeft = new JTextField();
		minuteLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charRead = e.getKeyChar();
				if (!Character.isDigit(charRead)) {
					e.consume();
				}
			}
		});
		minuteLeft.setBounds(210, 151, 130, 26);
		frame.getContentPane().add(minuteLeft);
		minuteLeft.setColumns(10);
		
		hourRight = new JTextField();
		hourRight.setBounds(408, 151, 130, 26);
		frame.getContentPane().add(hourRight);
		hourRight.setColumns(10);
		
		minuteRight = new JTextField();
		minuteRight.setBounds(573, 151, 130, 26);
		frame.getContentPane().add(minuteRight);
		minuteRight.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(52, 123, 61, 16);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(418, 123, 61, 16);
		frame.getContentPane().add(lblTo);
		
		JComboBox comboBoxLeft = new JComboBox(countryName);
		comboBoxLeft.setBounds(61, 196, 228, 26);
		frame.getContentPane().add(comboBoxLeft);
		
		JComboBox comboBoxRight = new JComboBox(countryName);
		comboBoxRight.setBounds(437, 196, 234, 26);
		frame.getContentPane().add(comboBoxRight);
		
		JLabel notification = new JLabel("");
		notification.setBounds(488, 133, 117, 16);
		frame.getContentPane().add(notification);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int hours = Integer.parseInt(hourLeft.getText());
					int mins = Integer.parseInt(minuteLeft.getText());

					String selection1 = (String)comboBoxLeft.getSelectedItem();
					String selection2 = (String)comboBoxRight.getSelectedItem();

					int positions1 = Arrays.asList(countryName).indexOf(selection1);
					int positions2 = Arrays.asList(countryName).indexOf(selection2);

					int timeDiff = offSets[positions2] - offSets[positions1]; 

					if((timeDiff + hours) < 0) {
						notification.setText("One day before");
						hours += 24;
					}
					else if ((timeDiff + hours) >= 24){
						notification.setText("One day ahead");

					}
					else {
						notification.setText("Same day");
					}

					hourRight.setText(Integer.toString((hours + timeDiff)%24));
					minuteRight.setText(Integer.toString(mins));
				}
				
				catch(Exception e) {
					JOptionPane.showMessageDialog(frame," Invalid Input!");
				}
			}
				
			 
		});
		
		
		btnConvert.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnConvert.setBounds(305, 263, 117, 41);
		frame.getContentPane().add(btnConvert);
		
		JLabel lblTimeConverter = new JLabel("Time Zone Converter");
		lblTimeConverter.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTimeConverter.setBounds(288, 66, 168, 16);
		frame.getContentPane().add(lblTimeConverter);
		
		
		
		
		
		
		
	}
}
