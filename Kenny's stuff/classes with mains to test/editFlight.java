import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class editFlight 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		//the primary key
        System.out.print("Enter flight number: ");
        String flightNum = input.next();
		
        System.out.print("Enter new plane id: ");
        input.nextLine();
        String planeID = input.nextLine();
        System.out.println("Enter new start location: ");
        String sLoc = input.nextLine();
        System.out.println("Enter new end location: ");
        String eLoc = input.nextLine();
        System.out.println("Enter new base price: ");
        double bPrice = input.nextDouble();
        System.out.print("Enter new plane type: ");
        int planeType = input.nextInt();
        System.out.println("Enter new date and time (format: YYYYMMDD HH:MM:SS): ");
        input.nextLine();
        String dTime = input.nextLine();
        
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
       
        ResultSet rs = stat.executeQuery("select * from FLIGHTS;");
        boolean flightNumExist = false;
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

        stat.executeUpdate("UPDATE FLIGHTS SET PLANE_ID = '"+planeID+"' WHERE FLIGHT_NUM = "+flightNum+";");
        stat.executeUpdate("UPDATE FLIGHTS SET START_LOC ='"+sLoc+"' WHERE FLIGHT_NUM = "+flightNum+";");
        stat.executeUpdate("UPDATE FLIGHTS SET END_LOC ='"+eLoc+"' WHERE FLIGHT_NUM = "+flightNum+";");
        stat.executeUpdate("UPDATE FLIGHTS SET PLANE_TYPE = '"+planeType+"' WHERE FLIGHT_NUM =  "+flightNum+";");
        stat.executeUpdate("UPDATE FLIGHTS SET FLIGHT_TIME ='"+dTime+"' WHERE FLIGHT_NUM = "+flightNum+";");
        stat.executeUpdate("UPDATE FLIGHTS SET BASE_PRICE ='"+bPrice+"' WHERE FLIGHT_NUM = "+flightNum+";");
        }
        else
        {
            System.out.println("Flight Number does not exist");
        }

	}

}
