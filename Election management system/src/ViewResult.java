

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ViewResult extends JFrame {
	static ViewResult frame;
	public ViewResult() {
		//Code to view data in JTable
		List<result> list=CastVoteDao.view();
		int size=list.size();
		
		String data[][]=new String[size][5];
		int row=0;
		for(result a:list){
			data[row][0]=a.getId();
			data[row][1]=a.getPartyname();
			data[row][2]=a.getcount();
			row++;
		}
		String columnNames[]={"Candidate_ID","PartyName","count"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		add(sp);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewResult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
