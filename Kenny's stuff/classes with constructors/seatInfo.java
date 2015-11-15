import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class seatInfo 
{
	static Double price = 0.0;
	static String description="";
	public seatInfo(String flightNum, int seatNum, boolean discount) throws Exception
	{

		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from FLIGHTS where FLIGHT_NUM = \""+flightNum+"\";");
        price=rs.getDouble("BASE_PRICE");
        int planeType=rs.getInt("PLANE_TYPE");
        
		if (planeType==1)
		{
			if(seatNum>0 && seatNum<9)
			{
				//shove all description into the variable
				description="First Class Seat";
				price*=10;
			}
			else if(seatNum>8 && seatNum<25)
			{
				//shove all description into the variable
				description="Business Class Seat";
				price*=5;
			}
			else
			{
				//shove all description into the variable
				description="Economy Class Seat";

			}
			if(discount==true)
			{
				price*=.5;
			}
		}
		else
		{
			if(seatNum>0 && seatNum<28)
			{
				//shove all description into the variable
				description="First Class Seat";
				price*=10;
			}
			else if(seatNum>27 && seatNum<82)
			{
				//shove all description into the variable
				description="Business Class Seat";
				price*=5;
			}
			else
			{
				//shove all description into the variable
				description="Economy Class Seat";
			}
			if(discount==true)
			{
				price*=.5;
			}
		}
	}
	public static double getPrice()
	{
		return price;
	}
	public static String getSeatInfo()
	{
		return description;
	}
}
