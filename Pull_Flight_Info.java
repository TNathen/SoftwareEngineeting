import java.util.ArrayList;

public class Pull_Flight_Info {
	String r;
	public Pull_Flight_Info(ArrayList<String> input)
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
		query.append("select FLIGHT_NUM, START_LOC, END_LOC, FLIGHT_TIME from FLIGHTS ");
		if(!columnName.isEmpty())query.append(" where "); 
		while(!columnName.isEmpty())
		{
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
			if(!columnName.isEmpty()) query.append(" AND ");
		}
		query.append(" ORDER BY FLIGHT_TIME LIMIT 50;");
		r = query.toString();
	}
	public String get()
	{
		return r;
       
	}
	
}
