import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class checkCoupon 
{
    static boolean codeExist = false;
    static boolean codeAndEmailMatch = false;

	public checkCoupon(String code, String email) throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs1 = stat.executeQuery("select * from COUPONS;");
        while (rs1.next()) 
        {
        	if (rs1.getString("CODE").compareToIgnoreCase(code)==0)
        	{
        		codeExist = true;
            	if (rs1.getString("EMAIL").compareToIgnoreCase(email)==0)
            	{
            		codeAndEmailMatch = true;
            	}
        	}
        }
        rs1.close();
        conn.close();
	}
	public static boolean perfectMatch()
	{
		return codeAndEmailMatch;
	}
	public static boolean codeMatch()
	{
		return codeExist;
	}
}
