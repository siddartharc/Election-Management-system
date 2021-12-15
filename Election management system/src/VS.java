import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VS {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VS window = new VS();
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
	public VS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voter Section");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(267, 53, 271, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Voter");
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(150, 146, 166, 39);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVoter.main(new String[]{});
				frame.dispose();
			}
		});
		JButton btnViewVoter = new JButton("View Voter");
		btnViewVoter.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnViewVoter.setBounds(399, 147, 166, 39);
		btnViewVoter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewVoter.main(new String[]{});
			}
		});
		frame.getContentPane().add(btnViewVoter);
		
		JButton btnUpdateVoter = new JButton("Update Voter");
		btnUpdateVoter.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnUpdateVoter.setBounds(278, 232, 166, 39);
		btnUpdateVoter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateVoter.main(new String[]{});
			}
		});
		frame.getContentPane().add(btnUpdateVoter);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 15));
		btnBack.setBounds(496, 303, 75, 31);
		frame.getContentPane().add(btnBack);
		frame.setBounds(100, 100, 736, 449);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.main(new String[]{});
				frame.dispose();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
