import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddVoter {

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
					AddVoter window = new AddVoter();
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
	public AddVoter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1273, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Voter");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(512, 169, 260, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AADHAR NO: ");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(406, 214, 151, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(635, 207, 277, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(406, 268, 151, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(635, 267, 277, 39);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(406, 328, 151, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(635, 326, 277, 34);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No :");
		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(406, 389, 151, 32);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(635, 389, 277, 35);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Voter");
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
				else if(Aadhar.length()<12) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Aadhar No should have minimum of 12 characters");
            	}
                 else if(Contact.length()<10) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Contact No should have minimum of 10 characters");
            	}
				else{
					int status=VoterDao.save(a);
					JOptionPane.showMessageDialog(null, AddVoter.this,"Voter added successfully!", status);
					textField.setText("");textField_1.setText("");textField_2.setText("");
					textField_3.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(544, 475, 215, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(866, 445, 106, 39);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VS.main(new String[]{});
				frame.dispose();
			}
		});
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\Voter.jpg"));
		lblNewLabel_5.setBounds(477, 10, 226, 162);
		frame.getContentPane().add(lblNewLabel_5);
	}

}
