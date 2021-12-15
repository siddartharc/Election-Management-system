import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CastVote {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CastVote window = new CastVote();
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
	public CastVote() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1198, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vote For A Better India");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(482, 194, 345, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Candidate ID :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(470, 260, 141, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Aadhar :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(470, 322, 141, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Vote");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String aadhar=textField_1.getText();
				Cast a=new Cast(id,aadhar);
				int status= CastVoteDao.Vote(a);
				
				if(status>0){
					JOptionPane.showMessageDialog(frame, CastVote.this,"Vote added successfully!", 0);
					textField.setText("");textField_1.setText("");
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(frame, CastVote.this,"Sorry, Unable to add Vote!", 0);
				}
			}
		});
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(505, 440, 239, 58);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(633, 262, 182, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(633, 324, 182, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\sid\\java\\vote.jpg"));
		lblNewLabel_3.setBounds(494, 10, 231, 168);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(818, 390, 123, 39);
		frame.getContentPane().add(btnNewButton_1);
		JButton btnBack = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.main(new String[]{});
				frame.dispose();
			}
		});
	}

}
