import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class discount 
{
	static boolean needsDiscount=false;
	public discount(String flightNum) throws Exception
	{

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from FLIGHTS where FLIGHT_NUM = \""+flightNum+"\";");   
        
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String present=(dateFormat.format(date));
        if(Long.parseLong(rs.getString("FLIGHT_TIME").substring(0,8))-Long.parseLong(present)==0||Long.parseLong(rs.getString("FLIGHT_TIME").substring(0,8))-Long.parseLong(present)==1)
        {
        	needsDiscount=true;
        }
        rs.close();
        conn.close();
	}
	public static boolean getDiscount()
	{
		return needsDiscount;
	}
}
