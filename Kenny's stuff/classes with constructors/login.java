import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login 
{
	public login(String email, String pass) throws Exception 
	{
		boolean emailInUserDB = false;
		boolean emailInAdminDB = false;

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        ResultSet rs1 = stat.executeQuery("select * from USERS;");
        while (rs1.next()) 
        {
        	//remove comment to print username and password of entire USER table
            //System.out.println(rs.getString("EMAIL") + " " + rs.getString("PASS"));
        	if (rs1.getString("EMAIL").compareToIgnoreCase(email)==0)
        	{
        		emailInUserDB = true;
            	if (rs1.getString("PASS").compareToIgnoreCase(pass)==0)
            	{

                    String fName = rs1.getString("FIRST_NAME");
                    String lName = rs1.getString("LAST_NAME");
                    //replace with redirecting to the user page (send first & last name and email as parameters)
                    System.out.println("Successfully logged in(as user)");
                    System.out.println(fName+" "+lName);
            	}
            	else 
            	{
            		System.out.println("Incorrect password");
            		//redirect back to login page or clear login page or clear just the password of the login page
            	}
        	}
        }
        rs1.close();

        if (emailInUserDB == false)
        {
            ResultSet rs2 = stat.executeQuery("select * from ADMINS;");
            while (rs2.next()) 
            {
            	//remove comment to print username and password of entire USER table
                //System.out.println(rs.getString("EMAIL") + " " + rs.getString("PASS"));
            	if (rs2.getString("EMAIL").compareToIgnoreCase(email)==0)
            	{
            		emailInAdminDB = true;
                	if (rs2.getString("PASS").compareToIgnoreCase(pass)==0)
                	{
                        System.out.println("Successfully logged in(as admin)");
                        //replace with redirecting to the user page
                	}
                	else 
                	{
                		System.out.println("Incorrect password");
                		//redirect back to login page or clear login page or clear just the password of the login page
                	}
            	}
            }
            rs2.close();
        }
        if(emailInUserDB == false&&emailInAdminDB==false)
        {
    		System.out.println(email +" does not exist in the database");
    		//goes no where until user puts a new email hit submit on that page
        }
        conn.close();
	}
}
