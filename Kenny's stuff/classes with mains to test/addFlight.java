import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class addFlight 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter plane id: ");
        String planeID = input.next();
        System.out.print("Enter flight number: ");
        String flightNum = input.next();
        System.out.println("Enter start location: ");
        input.nextLine();
        String sLoc = input.nextLine();
        System.out.println("Enter end location: ");
        String eLoc = input.nextLine();
        System.out.println("Enter base price: ");
        double bPrice = input.nextDouble();
        System.out.print("Enter plane type: ");
        int planeType = input.nextInt();
        System.out.println("Enter date and time (format: YYYYMMDD HH:MM:SS): ");
        input.nextLine();
        String dTime = input.nextLine();
		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
       
        boolean flightNumExist = false;
        ResultSet rs1 = stat.executeQuery("select * from USERS;");
        while (rs1.next()) 
        {
        	if (rs1.getString("Flight_NUM").compareToIgnoreCase(flightNum)==0)
        	{
        		flightNumExist = true;
        	}
        }
        rs1.close();

        if(flightNumExist==false)
        {
            stat.executeUpdate("INSERT INTO FLIGHTS (PLANE_ID,FLIGHT_NUM,START_LOC,END_LOC,BASE_PRICE,PLANE_TYPE,FLIGHT_TIME) "
            		+"VALUES (\""+planeID+"\",\""+flightNum+"\",\""+sLoc+"\",\""+eLoc+"\","+bPrice+",\""+planeType+"\",'"+dTime+"');"); 	

            //Shorter version
            //stat.executeUpdate("insert into USERS values(\""+email+"\",\""+pass+"\",\""+fName+"\",\""+lName+"\",\""+phone+"\","+dob+",0.0);");

        }
        else
        {
            System.out.println("Flight number already exist in the database");
        }
         conn.close();
	}

}
