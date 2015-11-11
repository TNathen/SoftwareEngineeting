import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class addUser 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = input.next();
        System.out.print("Enter password: ");
        String pass = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
        System.out.print("Enter phone: ");
        int phone = input.nextInt();
		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("INSERT INTO USERS (USERNAME,PASS,EMAIL,PHONE,MONEYSPENT) "
        		+"VALUES (\""+name+"\",\""+pass+"\",\""+email+"\","+phone+",0.0);");
        
        
        //Shorter version
        //stat.executeUpdate("insert into USERS values(\""+name+"\",\""+pass+"\",\""+email+"\","+phone+",0.0);");
        conn.close();
	}
}
