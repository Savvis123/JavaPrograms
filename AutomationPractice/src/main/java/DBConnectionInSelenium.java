import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnectionInSelenium {
	
	static String db_Url="jdbc:oracle:thin:@lxmdtsdx04-vip.test.intranet:1521/ENS_DEP2";
	static String Username="qasel";
	static String password="qaseldep2";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=DriverManager.getConnection(db_Url,Username,password);
		
		Statement st=conn.createStatement();
		
	    ResultSet result=	st.executeQuery("Select * from emp");
	    
	
	while(result.next())
	{
		String dbvalue =result.getString(1);
	}
		

	}

}
