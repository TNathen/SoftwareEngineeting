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
        System.out.print("Enter email: ");
        String email = input.next();
        System.out.print("Enter password: ");
        String pass = input.next();
        System.out.print("Enter first name: ");
        String fName = input.next();
        System.out.print("Enter last name: ");
        String lName = input.next();
        System.out.print("Enter phone: ");
        String phone = input.next();
        System.out.print("Enter date of birth: ");
        String dob = input.next();
		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        
        boolean emailExist = false;
        ResultSet rs1 = stat.executeQuery("select * from USERS;");
        while (rs1.next()) 
        {
        	if (rs1.getString("EMAIL").compareToIgnoreCase(email)==0)
        	{
        		emailExist = true;
        	}
        }
        rs1.close();

        if (emailExist == false)
        {
            ResultSet rs2 = stat.executeQuery("select * from ADMINS;");
            while (rs2.next()) 
            {
            	if (rs2.getString("EMAIL").compareToIgnoreCase(email)==0)
            	{
            		emailExist = true;
            	}
            }
            rs2.close();
        }
        if(emailExist == false)
        {          
        stat.executeUpdate("INSERT INTO USERS (EMAIL,PASS,FIRST_NAME,LAST_NAME,PHONE,DOB,MONEYSPENT) "
        		+"VALUES (\""+email+"\",\""+pass+"\",\""+fName+"\",\""+lName+"\",\""+phone+"\","+dob+",0.0);"); 	
        }
        else
        {
        	//replace with something else
            System.out.println("Email already in the database");
        }

        //Shorter version
        //stat.executeUpdate("insert into USERS values(\""+email+"\",\""+pass+"\",\""+fName+"\",\""+lName+"\",\""+phone+"\","+dob+",0.0);");
        conn.close();
	}
}
