import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class addUser 
{
	public addUser(String email,String pass, String fName, String lName, String phone, String dob) throws Exception 
	{		
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
