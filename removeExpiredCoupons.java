import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class removeExpiredCoupons 
{
	public removeExpiredCoupons() throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String present=(dateFormat.format(date));
		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from COUPONS;");
        System.out.println("COUPONS table");
        while (rs.next()) 
        {
        	if(rs.getLong("EXPIRATION_DATE")<Long.parseLong(present))
        	{
        		removeCoupon Expired = new removeCoupon(rs.getString("CODE"));
        	}
        }
        System.out.println("");
        rs.close();	
        conn.close();
	}
}
