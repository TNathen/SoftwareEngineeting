import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class deleteFlight 
{
    boolean flightNumExist=false;
    boolean ticketBought=false;
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
        
        ResultSet rs1 = stat.executeQuery("select * from TICKETS;");
        while (rs1.next()) 
        {
        	if (rs1.getString("FLIGHT_NUM").compareToIgnoreCase(flightNum)==0)
        	{
        		ticketBought=true;
        	}
        }
        rs1.close();	
        
        if (flightNumExist == true && ticketBought==false)
        {
            stat.executeUpdate("DELETE from FLIGHTS WHERE FLIGHT_NUM = \""+flightNum+"\";");
        }
        conn.close();

	}
	public boolean complete()
	{
		if(flightNumExist == true && ticketBought==false)
		{
			return flightNumExist;
		}
		else
		{
			return false;
		}
	}
	public boolean foundFlight()
	{
		return flightNumExist;
	}
	public boolean TicketsForFlight()
	{
		return ticketBought;
	}
}
