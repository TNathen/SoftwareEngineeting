import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;


public class passwordReset 
{
	String newPass;
	public passwordReset(String email) throws Exception
	{
		Random r = new Random();
		newPass = getCLetter(r.nextInt(26)+1)+getLLetter(r.nextInt(26)+1)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10);
		
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        stat.executeUpdate("UPDATE USERS SET PASS = '"+newPass+"' WHERE EMAIL = \""+email+"\";");
        conn.close();

	}
	public String getCLetter(int a)
	{
		String letter="";
		switch (a)
		{
		case 1: letter="A";break;
		case 2: letter="B";break;
		case 3: letter="C";break;
		case 4: letter="D";break;
		case 5: letter="E";break;
		case 6: letter="F";break;
		case 7: letter="G";break;
		case 8: letter="H";break;
		case 9: letter="I";break;
		case 10: letter="J";break;
		case 11: letter="K";break;
		case 12: letter="L";break;
		case 13: letter="M";break;
		case 14: letter="N";break;
		case 15: letter="O";break;
		case 16: letter="P";break;
		case 17: letter="Q";break;
		case 18: letter="R";break;
		case 19: letter="S";break;
		case 20: letter="T";break;
		case 21: letter="U";break;
		case 22: letter="V";break;
		case 23: letter="W";break;
		case 24: letter="X";break;
		case 25: letter="Y";break;
		default: letter="Z";break;
		}
		return letter;
	}
	public String getLLetter(int a)
	{
		String letter="";
		switch (a)
		{
		case 1: letter="a";break;
		case 2: letter="b";break;
		case 3: letter="c";break;
		case 4: letter="d";break;
		case 5: letter="e";break;
		case 6: letter="f";break;
		case 7: letter="g";break;
		case 8: letter="h";break;
		case 9: letter="i";break;
		case 10: letter="j";break;
		case 11: letter="k";break;
		case 12: letter="l";break;
		case 13: letter="m";break;
		case 14: letter="n";break;
		case 15: letter="o";break;
		case 16: letter="p";break;
		case 17: letter="q";break;
		case 18: letter="r";break;
		case 19: letter="s";break;
		case 20: letter="t";break;
		case 21: letter="u";break;
		case 22: letter="v";break;
		case 23: letter="w";break;
		case 24: letter="x";break;
		case 25: letter="y";break;
		default: letter="z";break;
		}
		return letter;
	}
	public String getNewPass()
	{
		return newPass;
	}
	
}
