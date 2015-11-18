import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class deleteFlight 
{
	public deleteFlight(String flightNum) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("DELETE from FLIGHTS where FLIGHT_NUM=\""+flightNum+"\";");
	}
}
