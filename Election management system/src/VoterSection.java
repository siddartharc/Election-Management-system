import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class VoterSection {
	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterSection window = new VoterSection();
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
	public VoterSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1197, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1163, 188);
		frame.getContentPane().add(scrollPane);
		JButton btnNewButton = new JButton("View Candidates");
		btnNewButton.setBackground(new Color(153, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Candidate> list=CandidateDao.view();
				int size=list.size();
				
				String data[][]=new String[size][5];
				int row=0;
				for(Candidate a:list){
					data[row][0]=a.getId();
					data[row][1]=a.getName();
					data[row][2]=a.getPartyname();
					data[row][3]=a.getContactno();
					row++;
				}
				String columnNames[]={"Candidate_ID","Name","Contact No","PartyName"};
				table = new JTable(data,columnNames);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(36, 243, 207, 35);
		frame.getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Vote");
		btnNewButton_1.setBackground(new Color(102, 204, 255));
		btnNewButton_1.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(453, 456, 189, 35);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String aadhar=textField_1.getText();
				Cast a=new Cast(id,aadhar);
				if(id.length() == 0 || aadhar.length() == 0) {
                	
                    JOptionPane.showMessageDialog(btnNewButton,"Fill in all the Details");
                }
				else if(id.length()<4) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Candidate ID should have minimum of 4 characters");
            	}
                 else if(aadhar.length()<12) {
            		
                    JOptionPane.showMessageDialog(btnNewButton,"Aadhar No should have minimum of 12 characters");
            	}
				else{
					int status= CastVoteDao.Vote(a);
					JOptionPane.showMessageDialog(frame, VoterSection.this,"Vote added successfully!", 0);
					textField.setText("");textField_1.setText("");
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Candidate ID :");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(267, 326, 170, 29);
		frame.getContentPane().add(lblNewLabel);
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(459, 326, 170, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAadhar = new JLabel("Aadhar Number :");
		lblAadhar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblAadhar.setBounds(267, 381, 170, 29);
		frame.getContentPane().add(lblAadhar);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(459, 387, 170, 26);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 51));
		btnNewButton_2.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBounds(680, 432, 85, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Election.main(new String[]{});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_2);
	}
}
