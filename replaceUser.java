import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class replaceUser 
{
    boolean emailExist = false;
	public replaceUser(String newEmail, String email,String pass, String fName, String lName, String phone, String dob, String sQuestion, String sAnswer) throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        Double money=0.0;
        ResultSet rs = stat.executeQuery("select * from USERS WHERE EMAIL = \""+email+"\";");
        while (rs.next()) 
        {
        	money=rs.getDouble("MONEYSPENT");
        }
        rs.close();
        
        ResultSet rs1 = stat.executeQuery("select * from USERS;");
        while (rs1.next()) 
        {
        	if (rs1.getString("EMAIL").compareToIgnoreCase(newEmail)==0)
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
            	if (rs2.getString("EMAIL").compareToIgnoreCase(newEmail)==0)
            	{
            		emailExist = true;
            	}
            }
            rs2.close();
        }
        if(emailExist == false)
        {          
        stat.executeUpdate("INSERT INTO USERS (EMAIL,PASS,FIRST_NAME,LAST_NAME,PHONE,DOB,MONEYSPENT,SECURITY_QUESTION,ANSWER) "
        		+"VALUES (\""+newEmail+"\",\""+pass+"\",\""+fName+"\",\""+lName+"\",\""+phone+"\",\""+dob+"\","+money+",\""+sQuestion+"\",\""+sAnswer+"\");"); 	
        

            stat.executeUpdate("UPDATE TICKETS SET U_EMAIL = '"+newEmail+"' WHERE U_EMAIL = \""+email+"\";");
            stat.executeUpdate("UPDATE COUPONS SET EMAIL = '"+newEmail+"' WHERE EMAIL = \""+email+"\";");

        
        stat.executeUpdate("DELETE from USERS WHERE EMAIL = \""+email+"\";");

        }
        else
        {
        	//replace with something else
            System.out.println("Email already in the database");
        }
        conn.close();
	}
	public boolean isSuccessful()
	{
		if (emailExist==false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
