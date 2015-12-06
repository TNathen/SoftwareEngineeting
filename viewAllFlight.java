import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


public class viewAllFlight 
{
	static String AllFlights[][];
	static boolean complete=false;
	public static void main(String[]args) throws Exception
	{

	}

	public static boolean finish()
	{
		return complete;
	}
	public static Vector<Vector<Object>> AllTheFlight()throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        ResultSet rs1 = stat.executeQuery("select * from FLIGHTS;");
        System.out.println("FLIGHTS table");
        int counter=0;
        while (rs1.next()) 
        {
        	counter+=1;
        }
        System.out.println("");
        rs1.close();
        
        
        ResultSet rs = stat.executeQuery("select * from FLIGHTS;");
        System.out.println("FLIGHTS table");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            vector.add(rs.getString("PLANE_ID"));
            vector.add(rs.getString("FLIGHT_NUM"));
            vector.add(rs.getString("START_LOC"));
            vector.add(rs.getString("END_LOC"));
            vector.add(rs.getString("BASE_PRICE"));
            vector.add(rs.getString("PLANE_TYPE")); 
            String x = rs.getString("FLIGHT_TIME");
            
            x = x.substring(0, 4) + "-" + x.substring(4, 6) + "-" + x.substring(6, 11)+":"+x.substring(11, 13);
            vector.add(x);
            data.add(vector);
        }
        rs.close();
        complete=true;
        return data;
	}
	public static Vector<Vector<Object>> AllTheFlight(String queryEnd)throws Exception
	{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:ECHO.db");
        Statement stat = conn.createStatement();
        
        
        ResultSet rs = stat.executeQuery("select * from FLIGHTS "+ queryEnd);
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            vector.add(rs.getString("PLANE_ID"));
            vector.add(rs.getString("FLIGHT_NUM"));
            vector.add(rs.getString("START_LOC"));
            vector.add(rs.getString("END_LOC"));
            vector.add(rs.getString("BASE_PRICE"));
            vector.add(rs.getString("PLANE_TYPE")); 
            
            String x = rs.getString("FLIGHT_TIME");
            
            x = x.substring(0, 4) + "-" + x.substring(4, 6) + "-" + x.substring(6, 11)+":"+x.substring(11, 13);
            vector.add(x);
            data.add(vector);
        }
        rs.close();
        conn.close();
        complete=true;
        return data;
	}
}
