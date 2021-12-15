import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CastVoteDao {
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/Election","postgres","dayanamic");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int Vote(Cast a){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into Cast_vote(id,aadhar) values(?,?)");
			ps.setString(1,a.getId());
			ps.setString(2,a.getAadhar());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<result> view(){
		List<result> list=new ArrayList<>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select candidate.id,candidate.contactno,count(cast_vote.id) from cast_vote inner join candidate on cast_vote.id=candidate.id group by candidate.id order by count(cast_vote.id) DESC;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				result a=new result();
				a.setId(rs.getString(1));
				a.setPartyname(rs.getString(2));
				a.setcount(rs.getString(3));
				list.add(a);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
}