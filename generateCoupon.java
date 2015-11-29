import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class generateCoupon 
{
	static boolean makeCoupon=false;
	static String theCode="";
	public generateCoupon(String email) throws Exception
	{
	    Class.forName("org.sqlite.JDBC");
	    Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
	    Statement stat = conn.createStatement();
	    ResultSet rs = stat.executeQuery("select * from USERS where EMAIL = \""+email+"\";");
	    Double moneySpent=rs.getDouble("MONEYSPENT");
	    
	    
	    
	    if(moneySpent>10000)
	    {
			boolean addToDB=false;
			while (addToDB==false)
			{			
				Random r = new Random();
				String code = getLetter(r.nextInt(26)+1)+getLetter(r.nextInt(26)+1)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10)+r.nextInt(10);
			
				//get current date then add one year to it
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
				Date date = new Date();
				String present=(dateFormat.format(date));
				String expirationDate=String.valueOf(Long.parseLong(present)+10000);

		        boolean codeExist = false;
		        ResultSet rs1 = stat.executeQuery("select * from COUPONS;");
		        while (rs1.next()) 
		        {
		        	if (rs1.getString("CODE").compareToIgnoreCase(code)==0)
		        	{
		        		codeExist = true;
		        	}
		        }
		        rs1.close();
		
		        if(codeExist==false)
		        {
		            stat.executeUpdate("INSERT INTO COUPONS (CODE,EMAIL,EXPIRATION_DATE,PERCENT) "
		            		+"VALUES (\""+code+"\",\""+email+"\",\""+expirationDate+"\","+0.10+");"); 	
		            addToDB=true;
		            makeCoupon=true;
		            theCode=code;
		        }
		        moneySpent-=10000;
		        stat.executeUpdate("UPDATE USERS SET MONEYSPENT = '"+moneySpent+"' WHERE EMAIL = \""+email+"\";");
			}
	    }
	    conn.close();
	}
	public static String getLetter(int a)
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
	public static boolean createCoupon()
	{
		return makeCoupon;
	}
	public static String getCode()
	{
		return theCode;
	}
}

