import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class viewDatabase {

	public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();

		//addTicket thisTicket=new addTicket("3542733937","u@ser.mail",5,5,20.0,"6011906589454570","123 baker","A",0,"Y");

        
        ResultSet rs1 = stat.executeQuery("select * from ADMINS;");
        System.out.println("ADMINS table");
        while (rs1.next()) 
        {
            System.out.println(rs1.getString("EMAIL") + " " + rs1.getString("PASS"));
        }
        System.out.println("");
        rs1.close();
        
        ResultSet rs2 = stat.executeQuery("select * from USERS;");
        System.out.println("USERS table");
        while (rs2.next()) 
        {
        	System.out.println(rs2.getString("EMAIL") + " " + rs2.getString("PASS") + " " +
        rs2.getString("FIRST_NAME") + " " + rs2.getString("LAST_NAME") + " " + rs2.getString("PHONE") + " " + 
        rs2.getString("DOB") + " " + rs2.getDouble("MONEYSPENT")+ " " + rs2.getString("SECURITY_QUESTION")+ " " + rs2.getString("ANSWER"));
        }
        System.out.println("");
        rs2.close();
        
        ResultSet rs3 = stat.executeQuery("select * from FLIGHTS;");
        System.out.println("FLIGHTS table");
        while (rs3.next()) 
        {
            System.out.println(rs3.getString("PLANE_ID") + " " + rs3.getString("FLIGHT_NUM") + " " + 
        rs3.getString("START_LOC") + " " + rs3.getString("END_LOC") + " " + rs3.getDouble("BASE_PRICE") + " " + 
        rs3.getInt("PLANE_TYPE") + " " + rs3.getString("FLIGHT_TIME"));
        }
        System.out.println("");
        rs3.close();
           
        
        ResultSet rs4 = stat.executeQuery("select * from TICKETS;");
        System.out.println("TICKETS table");
        while (rs4.next()) 
        {
            System.out.println(rs4.getString("FLIGHT_NUM") + " " + rs4.getString("U_EMAIL") + " " + 
        rs4.getInt("PLANE_TYPE") + " " + rs4.getString("TICKET_NUMBER") + " " + 
        rs4.getDouble("TICKET_VALUE") + " " + rs4.getString("CREDIT_CARD") + " " + rs4.getString("ADDRESS") + " " + 
        rs4.getString("DATE_PURCHASED") +" "+rs4.getString("FOOD")+" "+rs4.getString("BAGGAGE_NUM")+" "+rs4.getString("HANDICAP"));
        }
        System.out.println("");
        rs4.close();
                
        ResultSet rs5 = stat.executeQuery("select * from COUPONS;");
        System.out.println("COUPONS table");
        while (rs5.next()) 
        {
            System.out.println(rs5.getString("CODE") + " " + rs5.getString("EMAIL") + " " + 
        rs5.getInt("EXPIRATION_DATE") + " " + rs5.getDouble("PERCENT"));
        }
        System.out.println("");
        rs4.close();
        conn.close();
	}

}
