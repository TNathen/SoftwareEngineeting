import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class editFlight 
{
    boolean flightNumExist = false;
	boolean ticketBought=false;
	boolean ticketProblem=false;

	public editFlight (String flightNum, String planeID, String sLoc,String eLoc, double bPrice, int planeType, String dTime) throws Exception 
	{
		//the primary key is flight num
        
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
       
        ResultSet rs = stat.executeQuery("select * from FLIGHTS;");
        while (rs.next()) 
        {
            if(rs.getString("FLIGHT_NUM").compareTo(flightNum)==0)
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
        stat.executeUpdate("UPDATE FLIGHTS SET PLANE_ID = '"+planeID+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET START_LOC ='"+sLoc+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET END_LOC ='"+eLoc+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET PLANE_TYPE = '"+planeType+"' WHERE FLIGHT_NUM =  \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET FLIGHT_TIME ='"+dTime+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET BASE_PRICE ='"+bPrice+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        }
        else if (flightNumExist==true)
        {
            ResultSet rs2 = stat.executeQuery("select * from FLIGHTS where FLIGHT_NUM = \""+flightNum+"\";");
            int oldplanetype=0;
            while (rs2.next()) 
            {
            		oldplanetype=rs2.getInt("PLANE_TYPE");
            }
            rs2.close();
            if(planeType==oldplanetype)
            {
                stat.executeUpdate("UPDATE FLIGHTS SET PLANE_ID = '"+planeID+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
                stat.executeUpdate("UPDATE FLIGHTS SET START_LOC ='"+sLoc+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
                stat.executeUpdate("UPDATE FLIGHTS SET END_LOC ='"+eLoc+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
                stat.executeUpdate("UPDATE FLIGHTS SET FLIGHT_TIME ='"+dTime+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
                stat.executeUpdate("UPDATE FLIGHTS SET BASE_PRICE ='"+bPrice+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");	
            }
            else
            {
                System.out.println("Cannot change plane type whant people already bought tickets");
                ticketProblem=true;
            }
        }
        else
        {
            System.out.println("Flight Number does not exist");
            //stays on that page
        }
        conn.close();

	}
	public boolean FlightNumExist()
	{
		return flightNumExist ;
	}
	public boolean Ticketproblem()
	{
		return ticketProblem ;
	}

}
