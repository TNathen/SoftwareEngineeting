import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class addTicket 
{
	public addTicket(String flightNum,String email,int planeType,int tNum,Double tPrice,String cCard,String address,String datePurchased,char food,int baggageNum,int handicap) throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        stat.executeUpdate("INSERT INTO TICKETS (FLIGHT_NUM,U_EMAIL,PLANE_TYPE,TICKET_NUMBER,TICKET_VALUE,CREDIT_CARD,ADDRESS,DATE_PURCHASED,FOOD,BAGGAGE_NUM,HANDICAP) "
        		+"VALUES (\""+flightNum+"\",\""+email+"\","+planeType+","+tNum+","+tPrice+",\""+cCard+"\",\""+address+"\",\""+datePurchased+"\",\'"+food+"\',"+baggageNum+","+handicap+");"); 	
	}
}
