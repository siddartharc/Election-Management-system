import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AdminLogin {

	private JFrame frame;
	private JTextField textField;
	//private JTextField textField_1;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 866, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(273, 224, 218, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(187, 298, 170, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(187, 380, 170, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(303, 302, 291, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(303, 382, 291, 31);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(333, 478, 170, 38);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			char ch[]=passwordField.getPassword();
			String password=String.valueOf(ch);
			if(name.equals("anindh")&&password.equals("Anindhop")){
				String s[]={};
				AdminSection.main(s);
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(lblNewLabel, AdminLogin.this,"Sorry, username or password error!", 0);
				textField.setText("");passwordField.setText("");
			}
			}
		});
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(557, 440, 117, 38);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Election.main(new String[]{});
				frame.dispose();
			}
		});
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\admin 1.png"));
		lblNewLabel_3.setBounds(254, 10, 218, 204);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
