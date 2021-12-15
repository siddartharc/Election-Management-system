import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ViewCandidate extends JFrame {
    static ViewCandidate frame;
    public ViewCandidate() {
        
        List<Candidate> list=CandidateDao.view();
        int size=list.size();

        String data[][]=new String[size][5];
        int row=0;
        for(Candidate a:list){
            data[row][0]=a.getId();
            data[row][1]=a.getName();
            data[row][3]=a.getPartyname();
            data[row][2]=a.getContactno();
            row++;
        }
        String columnNames[]={"Candidate_ID","Name","PartyName","Contact No"};

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
                    frame = new ViewCandidate();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}