import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CS {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CS window = new CS();
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
	public CS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Candidate Section");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(513, 190, 306, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Candidate");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddCandidate.main(new String[]{});
					frame.dispose();
				}
			});
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(378, 258, 202, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Candidate");
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCandidate.main(new String[]{});
			}
		});
		btnNewButton_1.setBounds(700, 258, 193, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Candidate");
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(378, 343, 202, 42);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCandidate.main(new String[]{});
			}
		});
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_3.setBounds(700, 343, 193, 42);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\candidate.jpg"));
		lblNewLabel_1.setBounds(537, 10, 193, 176);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 1206, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
