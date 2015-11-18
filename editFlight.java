import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class editFlight 
{
    static boolean flightNumExist = false;
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
        System.out.println("");
        rs.close();
        
        if (flightNumExist == true)
        {
        stat.executeUpdate("UPDATE FLIGHTS SET PLANE_ID = '"+planeID+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET START_LOC ='"+sLoc+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET END_LOC ='"+eLoc+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET PLANE_TYPE = '"+planeType+"' WHERE FLIGHT_NUM =  \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET FLIGHT_TIME ='"+dTime+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        stat.executeUpdate("UPDATE FLIGHTS SET BASE_PRICE ='"+bPrice+"' WHERE FLIGHT_NUM = \""+flightNum+"\";");
        }
        else
        {
            System.out.println("Flight Number does not exist");
            //stays on that page
        }

	}
	public static boolean FlightNumExist()
	{
		return flightNumExist ;

	}

}
