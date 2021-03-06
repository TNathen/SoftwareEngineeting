import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class addFlight 
{
	public addFlight(String planeID,String flightNum,String sLoc,String eLoc, double bPrice, int planeType, String dTime) throws Exception 
	{		
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
