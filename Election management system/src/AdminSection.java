import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSection {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminSection() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 29));
		frame.setBounds(100, 100, 1261, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setBounds(515, 193, 222, 48);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Candidate Section");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(215, 193, 267, 48);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CS.main(new String[]{});
				frame.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Voter Section");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(778, 193, 261, 48);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VS.main(new String[]{});
				frame.dispose();
			}
		});
		JButton btnNewButton_2 = new JButton("Result");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewResult.main(new String[]{});
			}
		});
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(491, 251, 280, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LogOut");
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_3.setBounds(491, 326, 280, 48);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Election.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\anind\\Downloads\\java images\\java images\\admin.png"));
		lblNewLabel_1.setBounds(505, 21, 222, 165);
		frame.getContentPane().add(lblNewLabel_1);
	}
}