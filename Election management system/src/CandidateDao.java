import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CandidateDao {
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/Election","postgres","dayanamic");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Candidate a){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into Candidate(id,name,Party_Name,contactno) values(?,?,?,?)");
			ps.setString(1,a.getId());
			ps.setString(2,a.getName());
			ps.setString(3,a.getPartyname());
			ps.setString(4,a.getContactno());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<Candidate> view(){
		List<Candidate> list=new ArrayList<>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from Candidate");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Candidate a=new Candidate();
				a.setId(rs.getString(1));
				a.setName(rs.getString(2));
				a.setPartyname(rs.getString(3));
				a.setContactno(rs.getString(4));
				list.add(a);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
		public static int Update(Candidate a){
			int status = 0;
			try{
				Connection con=getCon();
				PreparedStatement ps=con.prepareStatement("Update Candidate SET name= ?,Party_Name= ?,contactno= ? where id = ? ;");
				ps.setString(4,a.getId());
				ps.setString(1,a.getName());
				ps.setString(3,a.getPartyname());
				ps.setString(2,a.getContactno());
				return ps.executeUpdate();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int del(Candidate a){
			int status=0;
			try{
				Connection con=getCon();
				PreparedStatement ps=con.prepareStatement("delete from Candidate where id = ? ");
				ps.setString(1,a.getId());
				return status=ps.executeUpdate();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
}