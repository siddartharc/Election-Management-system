import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class UpdateVoter {

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
					UpdateVoter window = new UpdateVoter();
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
	public UpdateVoter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Voter");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(411, 180, 222, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aadhar :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(329, 245, 177, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(329, 293, 177, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(329, 341, 177, 38);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No :");
		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(329, 382, 177, 38);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(471, 250, 214, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(471, 293, 214, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(471, 341, 214, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(471, 389, 214, 30);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Update Voter");
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(317, 471, 189, 38);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Aadhar=textField.getText();
				String Name=textField_1.getText();
				String Password=textField_2.getText();
				String Contact=textField_3.getText();
				Voter a=new Voter(Aadhar,Name,Password,Contact);
				if(Aadhar.length() == 0 || Name.length() == 0  || Password.length() == 0 
            			|| Contact.length() == 0 ) {
                	
                    JOptionPane.showMessageDialog(btnNewButton,"Fill in all the Details");
                }
                 else if(Contact.length()<10) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Contact No should have minimum of 10 characters");
            	}
				else{
					int status= VoterDao.Update(a);
					JOptionPane.showMessageDialog(frame, UpdateVoter.this,"Voter updated successfully!", status);
					textField.setText("");textField_1.setText("");textField_2.setText("");
					textField_3.setText("");
				}
			}
		});
		JButton btnNewButton_1 = new JButton("Delete Voter");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(538, 471, 189, 38);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Aadhar=textField.getText();
				String Name=textField_1.getText();
				String Password=textField_2.getText();
				String Contact=textField_3.getText();
				Voter a=new Voter(Aadhar,Name,Password,Contact);
				int status= VoterDao.del(a);
				if(status>0){
					JOptionPane.showMessageDialog(frame, UpdateVoter.this,"Voter deleted successfully!", status);
					textField.setText("");textField_1.setText("");textField_2.setText("");
					textField_3.setText("");
				}else{
					JOptionPane.showMessageDialog(frame, UpdateVoter.this,"Sorry, Unable to delete Voter!", status);
				}
			}
		});
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(769, 422, 138, 43);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VS.main(new String[]{});
				frame.dispose();
			}
		});
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\Voter 1.png"));
		lblNewLabel_5.setBounds(387, 10, 189, 181);
		frame.getContentPane().add(lblNewLabel_5);
		frame.setBounds(100, 100, 1193, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
