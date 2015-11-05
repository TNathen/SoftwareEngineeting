import java.io.*;
import java.util.Scanner;
//there is only one admin in the database which is 
//username: admin1
//password: asdf
public class adminLogin 
{
    public static void main(String [] args) 
    {
    	//repeats until successfully logged in
    	boolean repeat = true;
    	while(repeat==true)
    	{
	        String fileName = "ECHO.sql";
	        String line = null;
	        Scanner input = new Scanner(System.in);
	        
			System.out.print("Enter username : ");
			String username = input.next();
			System.out.print("Enter password : ");
			String password = input.next();
	
	        try 
	        {
	            FileReader fileReader = new FileReader(fileName);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            boolean usernameExist=false;
	            while((line = bufferedReader.readLine()) != null) 
	            {
	            	//line has more than 25 character
	            	if(line.length()>25)
	            	{
	            		//check if the first 25 matches the phrase
	            		if(line.substring(0,25).compareTo("insert into ADMINS values")==0)
	            		{
	            			//saves character number of the " marks (there are 6 in total)
	            			int [] quotesNum= new int [6];
	            			int counter = 0;
	            			//finds the " and saves it into the array
	            			for(int a=25; a<line.length()-1;a++)
	            			{
	            				if(line.substring(a,a+1).compareTo("\"")==0)
	            				{
	            				quotesNum[counter]=a;
	            				counter++;
	            				}
	            			}
	            			//if matching username
	            			if (username.compareToIgnoreCase(line.substring(quotesNum[0]+1,quotesNum[1]))==0)
	            			{
	            				usernameExist=true;
	            				//if matching password
	                			if (password.compareTo(line.substring(quotesNum[2]+1,quotesNum[3]))==0)
	                			{
	                			System.out.println("Successfully logged in"); //replace with admin page gui when completed
	                		    repeat = false;
	                			}
	                			//if password is now matching
	                			else
	                			{
	                				System.out.println("Incorrect password\nPlease try again");
	                			}
	            			}
	            		}
	            	}
	            }
	            bufferedReader.close();         
	            if (usernameExist==false)
	            {
					System.out.println(username+" does not exist in the admin database");
	            }
	        }
	        catch(FileNotFoundException ex) 
	        {
	            System.out.println("Unable to open file '" + fileName + "'");                
	        }
	        catch(IOException ex)
	        {
	            System.out.println("Error reading file '" + fileName + "'");                  
	        }
    	}
    }
}