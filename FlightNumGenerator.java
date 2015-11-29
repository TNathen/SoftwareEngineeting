import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
public class FlightNumGenerator 
{
	static String theFlightNum;
	public FlightNumGenerator() throws Exception
	{
		Random r=new Random();
		
	    Class.forName("org.sqlite.JDBC");
	    Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
	    Statement stat = conn.createStatement();
		
        boolean getNum = false;
        
        while(getNum==false)
        {
    		String flightNum="";
    		for(int a=0;a<10;a++)
    		{
    			flightNum+=r.nextInt(10);
    		}
    		System.out.println(flightNum);
        	
        	boolean NumExist=false;
            ResultSet rs1 = stat.executeQuery("select * from FLIGHTS;");
            while (rs1.next()) 
            {
            	if (rs1.getString("FLIGHT_NUM").compareToIgnoreCase(flightNum)==0)
            	{
            		NumExist = true;
            	}
            }
            rs1.close();
            
            if(NumExist == false)
            {
            	getNum = true;
            	saveNum(flightNum);            	
            }
        }
        conn.close();    
	}
	public String getFlightNum()
	{
		return theFlightNum;
	}
	public static void saveNum(String fNum)
	{
		theFlightNum=fNum;
	}
}
