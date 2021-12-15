import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class UpdateCandidate {

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
					UpdateCandidate window = new UpdateCandidate();
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
	public UpdateCandidate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Candidate");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(412, 187, 306, 35);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Update Candidate");
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(341, 427, 202, 42);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String partyName=textField_2.getText();
				String contactno=textField_3.getText();
				Candidate a=new Candidate(id,name,partyName,contactno);
				int status= CandidateDao.Update(a);
				if(status>0){
					JOptionPane.showMessageDialog(frame, UpdateCandidate.this,"Candidate updated successfully!", 0);
					textField.setText("");textField_1.setText("");textField_2.setText("");
					textField_3.setText("");
				}else{
					JOptionPane.showMessageDialog(frame, UpdateCandidate.this,"Sorry, Unable to update Candidate!", 0);
				}
			}
		});
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CS.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_3.setBounds(509, 499, 128, 42);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\candidate.jpg"));
		lblNewLabel_1.setBounds(432, 10, 193, 176);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Candidate Id :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(325, 232, 178, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(541, 238, 189, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(537, 282, 193, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(537, 322, 193, 28);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(537, 364, 193, 28);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name :");
		lblNewLabel_2_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_1.setBounds(325, 277, 178, 35);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Contact :");
		lblNewLabel_2_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_2.setBounds(325, 316, 178, 35);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Party Name :");
		lblNewLabel_2_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_3.setBounds(325, 358, 178, 35);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JButton btnNewButton = new JButton("Delete Candidate");
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(598, 427, 202, 42);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 1206, 605);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String partyName=textField_2.getText();
				String contactno=textField_3.getText();
				Candidate a=new Candidate(id,name,partyName,contactno);
				int status= CandidateDao.del(a);
				if(status>0){
					JOptionPane.showMessageDialog(frame, UpdateCandidate.this,"Candidate deleted successfully!", 0);
					textField.setText("");textField_1.setText("");textField_2.setText("");
					textField_3.setText("");
				}else{
					JOptionPane.showMessageDialog(frame, UpdateCandidate.this,"Sorry, Unable to delete Candidate!", 0);
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
