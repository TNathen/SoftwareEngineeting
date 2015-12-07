import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class addAdmin 
{
	boolean emailExist = false;
	public addAdmin(String email,String pass) throws Exception 
	{	
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        ResultSet rs1 = stat.executeQuery("select * from USERS;");
        while (rs1.next()) 
        {
        	if (rs1.getString("EMAIL").compareToIgnoreCase(email)==0)
        	{
        		emailExist = true;
        	}
        }
        rs1.close();
        System.out.println(emailExist);
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
        stat.executeUpdate("INSERT INTO ADMINS (EMAIL,PASS) "
        		+"VALUES (\""+email+"\",\""+pass+"\");"); 	
        }
        else
        {
        	//replace with something else
            System.out.println("Email already in the database");
        }
        
	}
	
	public boolean isSuccessful()
	{
		if (emailExist==false)
		{
			return true;
		}
		else return false;
	}
}
