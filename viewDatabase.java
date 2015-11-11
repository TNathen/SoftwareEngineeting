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
        
        
        
        
        ResultSet rs1 = stat.executeQuery("select * from ADMINS;");
        System.out.println("ADMINS table");
        while (rs1.next()) 
        {
            System.out.println(rs1.getString("USERNAME") + " " + rs1.getString("PASS")+ " " + rs1.getString("EMAIL"));
        }
        System.out.println("");
        rs1.close();
        
        ResultSet rs2 = stat.executeQuery("select * from USERS;");
        System.out.println("USERS table");
        while (rs2.next()) 
        {
            System.out.println(rs2.getString("USERNAME") + " " + rs2.getString("PASS") + " " + rs2.getString("EMAIL") + " " + rs2.getString("PHONE") + " " + rs2.getDouble("MONEYSPENT"));
        }
        System.out.println("");
        rs2.close();
        
        ResultSet rs3 = stat.executeQuery("select * from FLIGHTS;");
        System.out.println("FLIGHTS table");
        while (rs3.next()) 
        {
            System.out.println(rs3.getString("PLANE_ID") + " " + rs3.getString("FLIGHT_NUM") + " " + rs3.getString("START_LOC") + " " + rs3.getString("END_LOC") + " " + rs3.getString("PLANE_TYPE"));
        }
        System.out.println("");
        rs3.close();
           
        conn.close();
	}

}
