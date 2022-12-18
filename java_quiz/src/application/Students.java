package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Students extends User
{
	private int[] top_score;
	private int score;
	
	public Students(boolean admin, String username) 
	{
		super(admin, username);
		set_grade(username);
	}
	public void set_grade(String username)
	{
		DataBaseConnection connect = new DataBaseConnection();
		Connection connectDB = connect.getConnection();
		//create query
		String getGrade = "SELECT quiz1_score FROM quiz_info WHERE username = '" + username + "'";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryStudents = statement.executeQuery(getGrade);
	
			while(queryStudents.next())
			{
				this.score = queryStudents.getInt(1);
			}
			} catch (Exception e) 
				{
					e.printStackTrace();
				}
			
	}
	public void set_grade()
	{
		DataBaseConnection connect = new DataBaseConnection();
		Connection connectDB = connect.getConnection();
		//create query
		String getGrade = "SELECT quiz1_score FROM quiz_info WHERE username = '" + this.username + "'";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryStudents = statement.executeQuery(getGrade);
	
			while(queryStudents.next())
			{
				this.score = queryStudents.getInt(1);
			}
			} catch (Exception e) 
				{
					e.printStackTrace();
				}
			
	}
	public String get_score()
	{
		return String.valueOf(this.score);
	}

}
