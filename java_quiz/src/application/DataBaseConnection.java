//connect to database for accounts

package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection 
{
	
	public Connection databaseLink;
	
	public Connection getConnection() 
	{
		String databaseUser = "admin";
		String databasePassword = "password";
		String url = "jdbc:mysql://quiz-database.cfokuicgfyow.us-east-2.rds.amazonaws.com:3306/quiz_database";
;

		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
			
		} catch (Exception e) 
			{
				e.printStackTrace();
			}	
		return databaseLink;
	}
}
