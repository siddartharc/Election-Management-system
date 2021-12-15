import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VoterLogin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterLogin window = new VoterLogin();
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
	public VoterLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 847, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voter Login");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(311, 190, 196, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aadhar No :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(191, 244, 180, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2= new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(191, 314, 180, 44);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(327, 244, 264, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(327, 319, 264, 39);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(350, 423, 138, 44);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			boolean status=VoterDao.validate(name, password);
			if(status){
				VoterSection.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showInputDialog(frame, VoterLogin.this,"Sorry, username or password error!",0, null, null, "Login error!");
			}
			}
		});
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(566, 380, 113, 39);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Election.main(new String[]{});
				frame.dispose();
			}
		});
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\Voter 1.png"));
		lblNewLabel_21.setBounds(301, 10, 187, 183);
		frame.getContentPane().add(lblNewLabel_21);
	}
}
