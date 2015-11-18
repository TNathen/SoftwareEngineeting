import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login 
{
	static boolean emailInUserDB = false;
	static boolean emailInAdminDB = false;
	static boolean SuccessfulLogin = false;
	static String fName="";
	static String lName="";
	public login(String email, String pass) throws Exception 
	{


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

                    fName = rs1.getString("FIRST_NAME");
                    lName = rs1.getString("LAST_NAME");
                    //replace with redirecting to the user page (send first & last name and email as parameters)
                    SuccessfulLogin = true;
            	}
            	else 
            	{
            		//System.out.println("Incorrect password");
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
                        //replace with redirecting to the admin page
                        SuccessfulLogin = true;
                	}
                	else 
                	{
                		//System.out.println("Incorrect password");
                		//redirect back to login page or clear login page or clear just the password of the login page
                	}
            	}
            }
            rs2.close();
        }
        if(emailInUserDB == false&&emailInAdminDB==false)
        {
    		//System.out.println(email +" does not exist in the database");
    		//goes no where until user puts a new email hit submit on that page
        }
        conn.close();
	}
	public static boolean loginsuccess()
	{
		return SuccessfulLogin;
	}
	public static boolean isUser()
	{
		return emailInUserDB;
	}
	public static boolean isAdmin()
	{
		return emailInUserDB;
	}
	public static String getName()
	{
		return fName+" "+lName;
	}
}
