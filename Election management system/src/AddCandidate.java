import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AddCandidate {

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
					AddCandidate window = new AddCandidate();
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
	public AddCandidate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 1180, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\images.png"));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(406, 34, 219, 155);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Candidate ID :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(215, 238, 176, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(428, 245, 269, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(215, 296, 128, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(428, 298, 269, 34);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Party Name :");
		lblNewLabel_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(218, 356, 138, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(428, 354, 269, 33);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contact :");
		lblNewLabel_4.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(215, 412, 128, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(428, 414, 268, 33);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Candidate");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(458, 471, 207, 53);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String contactno=textField_3.getText();
				String partyName=textField_2.getText();    	
				Candidate a=new Candidate(id,name,partyName,contactno);
				if(id.length() == 0 || name.length() == 0  || partyName.length() == 0 
            			|| contactno.length() == 0 ) {
                	
                    JOptionPane.showMessageDialog(btnNewButton,"Fill in all the Details");
                }
				else if(id.length()<4) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Candidate ID should have minimum of 4 characters");
            	}
                 else if(contactno.length()<10) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Contact No should have minimum of 10 characters");
            	}
				else{
					int status= CandidateDao.save(a);
					JOptionPane.showMessageDialog(null, AddCandidate.this,"Candidate added successfully!", status, null);
					textField.setText("");textField_1.setText("");textField_2.setText("");
					textField_3.setText("");
				}
				 }		
		});
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(822, 428, 128, 43);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CS.main(new String[]{});
				frame.dispose();
			}
		});
		JLabel lblNewLabel_5 = new JLabel("Add Candidate");
		lblNewLabel_5.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(446, 188, 155, 43);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
