import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class deleteFlight 
{
    boolean flightNumExist=false;
	public deleteFlight(String flightNum) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        ResultSet rs = stat.executeQuery("select * from FLIGHTS;");
        while (rs.next()) 
        {
        	if (rs.getString("FLIGHT_NUM").compareToIgnoreCase(flightNum)==0)
        	{
        		flightNumExist = true;
        	}
        }
        rs.close();	
        if (flightNumExist == true)
        {
            stat.executeUpdate("DELETE from FLIGHTS WHERE FLIGHT_NUM = \""+flightNum+"\";");
        }
        conn.close();

	}
	public boolean complete()
	{
		return flightNumExist;
	}
}
