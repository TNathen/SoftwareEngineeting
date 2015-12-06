import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class removeCoupon 
{
	public removeCoupon(String code) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("DELETE from COUPONS where CODE=\""+code+"\";");
        conn.close();
	}

}
