import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class viewTickets 
{

	public static void main(String[]args) throws Exception
	{

	}

	public static String[][] makeArray(String email)throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
		
        ResultSet rs1 = stat.executeQuery("select * from TICKETS where U_EMAIL = \""+email+"\" ;");
        int counter=0;
        while (rs1.next()) 
        {
        	counter++;
        }
        rs1.close();
        ResultSet rs2 = stat.executeQuery("select * from TICKETS where U_EMAIL = \""+email+"\" ;");
        String Tickets[][]=new String[counter][11];
        int counter2=0;
        while (rs2.next()) 
        {
            Tickets[counter2][0]=rs2.getString("FLIGHT_NUM");
            Tickets[counter2][1]=rs2.getString("PLANE_TYPE");
            Tickets[counter2][2]=rs2.getString("TICKET_NUMBER");
            Tickets[counter2][3]="$"+rs2.getString("TICKET_VALUE");
            Tickets[counter2][4]=rs2.getString("CREDIT_CARD");
            Tickets[counter2][5]=rs2.getString("ADDRESS");
            
            String x=rs2.getString("DATE_PURCHASED");
            x = x.substring(0, 4) + "-" + x.substring(4, 6) + "-" + x.substring(6, 8);
            Tickets[counter2][6]=x;
            
            if(rs2.getString("HANDICAP").compareTo("0")==0)
            {
                Tickets[counter2][7]="N";
            }
            else
            {
                Tickets[counter2][7]="Y";
            }

            counter2++;
        }
        rs2.close();


        
        for(int a=0;a<counter;a++)
        {
            ResultSet rs3 = stat.executeQuery("select * from FLIGHTS where FLIGHT_NUM = \""+Tickets[a][0]+"\" ;");
            while (rs3.next())
            {
                Tickets[a][8]=rs3.getString("START_LOC");
                Tickets[a][9]=rs3.getString("END_LOC");
                
                String y=rs3.getString("FLIGHT_TIME");
                y = y.substring(0, 4) + "-" + y.substring(4, 6) + "-" + y.substring(6, 8);                
                Tickets[a][10]=y;
            }
            rs3.close();
        }
        

        conn.close();
        return Tickets;
	}
}

