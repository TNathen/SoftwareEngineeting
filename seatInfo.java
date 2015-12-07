import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class seatInfo 
{
	static Double price = 0.0;
	static String description="";
	static String seatType="";
	public seatInfo(String flightNum, int seatNum, boolean discount) throws Exception
	{

		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from FLIGHTS where FLIGHT_NUM = \""+flightNum+"\";");
        price=rs.getDouble("BASE_PRICE");
        if(discount==true)
        {
        	price*=.5;
        }
        int planeType=rs.getInt("PLANE_TYPE");
        rs.close();
        conn.close();
		if (planeType==1)
		{
			if(seatNum>0 && seatNum<7)
			{
				//shove all description into the variable
				description="<html>Handicap Seat<br>Customer must show handicap ID to the flight attendent to sit at the handicap seat<br>We provide wheelchair services as well<br>It comes with the same benefits as business class<br>$"+price+"</html>";
				seatType="Handicap Seat";
			}
			else if(seatNum>6 && seatNum<19)
			{
				//shove all description into the variable
				price*=5;
				description="<html>First Class Seat<br>It comes with a full course meal<br>It also comes with more comfortable chairs<br>$"+price+"</html>";
				seatType="First Class Seat";

			}
			else if(seatNum>18 && seatNum<34)
			{
				//shove all description into the variable
				price*=3;
				description="<html>Business Seat<br>It comes with a meal of your choice<br>It has some extra leg room<br>$"+price+"</html>";
				seatType="Business Class Seat";

			}
			else
			{
				//shove all description into the variable
				description="<html>Economy Class Seat<br>It comes with free complementary peanuts and water<br>$"+price+"</html>";
				seatType="Economy Class Seat";

			}
			if(discount==true)
			{
				price*=.5;
			}
		}
		else if (planeType==2)
		{
			if(seatNum>0 && seatNum<7)
			{
				//shove all description into the variable
				description="<html>Handicap Seat<br>Customer must show handicap ID to the flight attendent to sit at the handicap seat<br>We provide wheelchair services as well<br>It comes with the same benefits as business class<br>$"+price+"</html>";
				seatType="Handicap Seat";
			}
			else if(seatNum>6 && seatNum<19)
			{
				//shove all description into the variable
				price*=5;
				description="<html>First Class Seat<br>It comes with a full course meal<br>It also comes with more comfortable chairs<br>$"+price+"</html>";
				seatType="First Class Seat";

			}
			else if(seatNum>18 && seatNum<37)
			{
				//shove all description into the variable
				price*=3;
				description="<html>Business Seat<br>It comes with a meal of your choice<br>It has some extra leg room<br>$"+price+"</html>";
				seatType="Business Class Seat";

			}
			else
			{
				//shove all description into the variable
				description="<html>Economy Class Seat<br>It comes with free complementary peanuts and water<br>$"+price+"</html>";
				seatType="Economy Class Seat";

			}
			if(discount==true)
			{
				price*=.5;
			}
		}
		else if (planeType==3)
		{
			if(seatNum>0 && seatNum<8)
			{
				//shove all description into the variable
				description="<html>Handicap Seat<br>Customer must show handicap ID to the flight attendent to sit at the handicap seat<br>We provide wheelchair services as well<br>It comes with the same benefits as business class<br>$"+price+"</html>";
				seatType="Handicap Seat";
			}
			else if(seatNum>7 && seatNum<22)
			{
				//shove all description into the variable
				price*=5;
				description="<html>First Class Seat<br>It comes with a full course meal<br>It also comes with more comfortable chairs<br>$"+price+"</html>";
				seatType="First Class Seat";

			}
			else if(seatNum>21 && seatNum<43)
			{
				//shove all description into the variable
				price*=3;
				description="<html>Business Seat<br>It comes with a meal of your choice<br>It has some extra leg room<br>$"+price+"</html>";
				seatType="Business Class Seat";

			}
			else
			{
				//shove all description into the variable
				description="<html>Economy Class Seat<br>It comes with free complementary peanuts and water<br>$"+price+"</html>";
				seatType="Economy Class Seat";

			}
			if(discount==true)
			{
				price*=.5;
			}
		}
		else if (planeType==4)
		{
			if(seatNum>0 && seatNum<10)
			{
				//shove all description into the variable
				description="<html>Handicap Seat<br>Customer must show handicap ID to the flight attendent to sit at the handicap seat<br>We provide wheelchair services as well<br>It comes with the same benefits as business class<br>$"+price+"</html>";
				seatType="Handicap Seat";
			}
			else if(seatNum>9 && seatNum<28)
			{
				//shove all description into the variable
				price*=5;
				description="<html>First Class Seat<br>It comes with a full course meal<br>It also comes with more comfortable chairs<br>$"+price+"</html>";
				seatType="First Class Seat";

			}
			else if(seatNum>27 && seatNum<55)
			{
				//shove all description into the variable
				price*=3;
				description="<html>Business Seat<br>It comes with a meal of your choice<br>It has some extra leg room<br>$"+price+"</html>";
				seatType="Business Class Seat";

			}
			else
			{
				//shove all description into the variable
				description="<html>Economy Class Seat<br>It comes with free complementary peanuts and water<br>$"+price+"</html>";
				seatType="Economy Class Seat";

			}
			if(discount==true)
			{
				price*=.5;
			}
		}
		else
		{
			if(seatNum>0 && seatNum<6)
			{
				//shove all description into the variable
				description="<html>Handicap Seat<br>Customer must show handicap ID to the flight attendent to sit at the handicap seat<br>We provide wheelchair services as well<br>It comes with the same benefits as business class<br>$"+price+"</html>";
				seatType="Handicap Seat";

			}
			else if(seatNum>5 && seatNum<16)
			{
				//shove all description into the variable
				price*=5;
				description="<html>First Class Seat<br>It comes with a full course meal<br>It also comes with more comfortable chairs<br>$"+price+"</html>";
				seatType="First Class Seat Seat";

			}
			else if(seatNum>15 && seatNum<31)
			{
				//shove all description into the variable
				price*=3;
				description="<html>Business Seat<br>It comes with a meal of your choice<br>It has some extra leg room<br>$"+price+"</html>";
				seatType="Business Class Seat";

			}
			else
			{
				//shove all description into the variable
				description="<html>Economy Class Seat<br>It comes with free complementary peanuts and water<br>$"+price+"</html>";
				seatType="Economy Class Seat";

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
	public static String getInfo()
	{
		return description;
	}
	public static String getType()
	{
		return seatType;
	}
}
