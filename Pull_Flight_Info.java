import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pull_Flight_Info {
	String r;
	public Pull_Flight_Info(ArrayList<String> input, String today)
	{
		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();
		
		while(input.size() > 0)
		{
			
			if(input.size() - 2 > 0)
			{
				columnName.add(input.get(0));
				input.remove(0);
				value.add(input.get(0));
				input.remove(0);
			}
			else break;
		}
		
		StringBuilder query = new StringBuilder();
		query.append("select FLIGHT_NUM, START_LOC, END_LOC, PLANE_TYPE, FLIGHT_TIME from FLIGHTS ");
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("hhss");
		Date time = new Date();

		today.concat(" "+dateFormat.format(time).toString());
		query.append(" where CAST(FLIGHT_TIME AS INTEGER) > "+today);

		
		
		while(!columnName.isEmpty())
		{
			query.append(" AND ");
			if(columnName.get(0) == "FLIGHT_TIME")
			{
				query.append("FLIGHT_TIME like \'"+value.get(0)+"%\'");
				columnName.remove(0);
				value.remove(0);
			}else
			{
				query.append(columnName.get(0)+" = \""+value.get(0)+"\"");
				columnName.remove(0);
				value.remove(0);
			}
			
		}
		query.append(" ORDER BY FLIGHT_TIME LIMIT 50;");
		r = query.toString();
	}
	public String get()
	{
		return r;
       
	}
	
}
