import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class viewAllFlight 
{
	static String AllFlights[][];
	public static void main(String[]args) throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        ResultSet rs1 = stat.executeQuery("select * from FLIGHTS;");
        System.out.println("FLIGHTS table");
        int counter=0;
        while (rs1.next()) 
        {
        	counter+=1;
        }
        System.out.println("");
        rs1.close();
        
        String AllFlights[][]=new String[counter][7];
        
        ResultSet rs = stat.executeQuery("select * from FLIGHTS;");
        System.out.println("FLIGHTS table");
        int index=0;
        while (rs.next()) 
        {
        	AllFlights[index][0]=rs.getString("PLANE_ID");
        	AllFlights[index][1]=rs.getString("FLIGHT_NUM");
        	AllFlights[index][2]=rs.getString("START_LOC");
        	AllFlights[index][3]=rs.getString("END_LOC");
        	AllFlights[index][4]=rs.getString("BASE_PRICE");
        	AllFlights[index][5]=rs.getString("PLANE_TYPE"); 
        	AllFlights[index][6]=rs.getString("FLIGHT_TIME");
            index++;
        }
        System.out.print(AllFlights[0][0]+" "+ AllFlights[0][1]+" "+AllFlights[0][2]+" "+AllFlights[0][3]+" "+AllFlights[0][4]+" "+AllFlights[0][5]+" "+AllFlights[0][6]);
        System.out.println("");
        rs.close();
	}
	public static String[][] AllTheFlights()
	{
	    
		return AllFlights;
	}
}
