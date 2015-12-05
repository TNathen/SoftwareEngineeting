import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class editUser 
{
	public editUser(String email,String pass, String fName, String lName, String phone, String dob, String sQuestion, String sAnswer) throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        

        stat.executeUpdate("UPDATE USERS SET PASS = '"+pass+"' WHERE EMAIL = \""+email+"\";");
        stat.executeUpdate("UPDATE USERS SET FIRST_NAME = '"+fName+"' WHERE EMAIL = \""+email+"\";");
        stat.executeUpdate("UPDATE USERS SET LAST_NAME = '"+lName+"' WHERE EMAIL = \""+email+"\";");
        stat.executeUpdate("UPDATE USERS SET PHONE = '"+phone+"' WHERE EMAIL = \""+email+"\";");
        stat.executeUpdate("UPDATE USERS SET DOB = '"+dob+"' WHERE EMAIL = \""+email+"\";");
        stat.executeUpdate("UPDATE USERS SET SECURITY_QUESTION = '"+sQuestion+"' WHERE EMAIL = \""+email+"\";");
        stat.executeUpdate("UPDATE USERS SET ANSWER = '"+sAnswer+"' WHERE EMAIL = \""+email+"\";");

        conn.close();
	}
}
