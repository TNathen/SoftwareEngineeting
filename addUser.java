import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class addUser 
{
    boolean emailExist = false;
	public addUser(String email,String pass, String fName, String lName, String phone, String dob, String sQuestion, String sAnswer) throws Exception 
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
        System.out.println(emailExist);
        if(emailExist == false)
        {          
        stat.executeUpdate("INSERT INTO USERS (EMAIL,PASS,FIRST_NAME,LAST_NAME,PHONE,DOB,MONEYSPENT,SECURITY_QUESTION,ANSWER) "
        		+"VALUES (\""+email+"\",\""+pass+"\",\""+fName+"\",\""+lName+"\",\""+phone+"\",\""+dob+"\",0.0,\""+sQuestion+"\",\""+sAnswer+"\");"); 	
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
	public boolean isSuccessful()
	{
		if (emailExist==false)
		{
			return true;
		}
		else return false;
	}
}
