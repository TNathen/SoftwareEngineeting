import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class viewCoupon 
{
	public static void main(String[] args) throws Exception
	{

	}
	public static String[][] makeArray(String email)throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
		
        ResultSet rs1 = stat.executeQuery("select * from COUPONS where EMAIL = \""+email+"\" ;");
        int counter=0;
        while (rs1.next()) 
        {
        	counter++;
        }
        
        ResultSet rs2 = stat.executeQuery("select * from COUPONS where EMAIL = \""+email+"\" ;");
        String Tickets[][]=new String[counter][3];
        int counter2=0;
        while (rs2.next()) 
        {
            Tickets[counter2][0]=rs2.getString("CODE");          
            String x=rs2.getString("EXPIRATION_DATE");
            x = x.substring(0, 4) + "-" + x.substring(4, 6) + "-" + x.substring(6, 8);
            Tickets[counter2][1]=x;
            
            Tickets[counter2][2]=(rs2.getDouble("PERCENT")*100)+"%";
            counter2++;
        }
        conn.close();
        return Tickets;
	}
}
