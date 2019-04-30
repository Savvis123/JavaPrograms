import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("df");
		Connection con=DriverManager.getConnection("ddsfd","fsdfs","adfa");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("");
		
		while(res.next())
		{
			String s=res.getString(1);
			System.out.println(res.getString(1));
		}

	}

}
