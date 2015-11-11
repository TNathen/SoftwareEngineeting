import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class userLogin 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = input.next();
        System.out.print("Enterpassword: ");
        String pass = input.next();
		boolean usernameExist = false;
		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from USERS;");
        while (rs.next()) 
        {
        	//remove comment to print username and password of entire USER table
            //System.out.println(rs.getString("USERNAME") + " " + rs.getString("PASS"));
        	if (rs.getString("USERNAME").compareToIgnoreCase(name)==0)
        	{
        		usernameExist = true;
            	if (rs.getString("PASS").compareToIgnoreCase(pass)==0)
            	{
                    System.out.println("Successfully logged in");
                    //replace with redirecting to the user page
            	}
            	else 
            	{
            		System.out.println("Incorrect password");
            		//redirect back to login page or clear login page or clear just the password of the login page
            	}
        	}
        }
        if (usernameExist==false)
        {
    		System.out.println(name +" does not exist in the user database");
        }
        rs.close();
        conn.close();
	}

}
