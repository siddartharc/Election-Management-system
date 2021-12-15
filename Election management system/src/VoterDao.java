import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoterDao {
	public static Connection getCon(){
		Connection con = null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/Election","postgres","dayanamic");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static boolean validate(String Aadhar,String Password){
		boolean status=false;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from Voter where Aadhar=? and Password=?");
			ps.setString(1,Aadhar);
			ps.setString(2,Password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		
		return status;
	}
	public static int save(Voter a){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into Voter(Aadhar,Name,Password,Contact) values(?,?,?,?)");
			ps.setString(1,a.getId());
			ps.setString(2,a.getName());
			ps.setString(3,a.getPassword());
			ps.setString(4,a.getContact());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<Voter> view(){
		List<Voter> list=new ArrayList<>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from Voter");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Voter a=new Voter();
				a.setId(rs.getString(1));
				a.setName(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setContactno(rs.getString(4));
				list.add(a);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static int Update(Voter a){
		int status = 0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("Update Voter SET name= ?,Password= ?,contact= ? where aadhar = ? ;");
			ps.setString(4,a.getId());
			ps.setString(1,a.getName());
			ps.setString(2,a.getPassword());
			ps.setString(3,a.getContact());
			return ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int del(Voter a){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("delete from Voter where aadhar = ? ");
			ps.setString(1,a.getId());
			return status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}