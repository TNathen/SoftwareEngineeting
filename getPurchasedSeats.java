import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class getPurchasedSeats 
{
	static int TicketNums[];
	public getPurchasedSeats(String flightNum) throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        

        
        //get total amount of tickets to create size of array
        ResultSet rs = stat.executeQuery("select * from TICKETS where FLIGHT_NUM = \""+flightNum+"\";");
        int totalTickets=0;	
        while (rs.next()) 
        {
        	totalTickets++;
        }
        rs.close();

        
        //save each seat number into the array
        ResultSet rs2 = stat.executeQuery("select * from TICKETS where FLIGHT_NUM = \""+flightNum+"\";");
        TicketNums=new int[totalTickets];
        int arrayIndex=0;	
        while (rs2.next()) 
        {
        	TicketNums[arrayIndex]=rs2.getInt("TICKET_NUMBER");
        	arrayIndex++;
        }
        rs2.close();
        conn.close();
	}
	public static int[] allPurchasedSeats()
	{
		return TicketNums;
	}
}
