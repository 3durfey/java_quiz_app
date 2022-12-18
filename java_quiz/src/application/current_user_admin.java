package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class current_user_admin
{
	//create admin object
	static Admin admin;
	
	static public void set_user_admin(String username)
	{
		String[] names = get_student_names();
		int[] grades = get_student_grades();
		admin = new Admin(true, username, names, grades);
		System.out.println(username);
	}
	//create object using database class 
	public static String[] get_student_names()
	{
	//return statement intilization
	String[] temp = null;
	DataBaseConnection connect = new DataBaseConnection();
	Connection connectDB = connect.getConnection();
	//create query
	String getUsers = "SELECT username FROM quiz_info";
	try {
		Statement statement = connectDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet queryStudents = statement.executeQuery(getUsers);
		//set up for loop to put students in admin object
		queryStudents.last();
		int counter = queryStudents.getRow();
		queryStudents.first();
		temp = new String[counter];
		//set first value to array
		temp[0]  = queryStudents.getString("username");
		//create temp string array to hold students
		//counter to 0
		counter = 1;
		//set rest of values through while loop
		while(queryStudents.next())
		{
			temp[counter] = queryStudents.getString(1);
			counter++;
		}
		} catch (Exception e) 
			{
				e.printStackTrace();
			}
		return temp;
	}	
	
	public static int[] get_student_grades()
	{
	//return statement intilization
	int[] temp = null;
	DataBaseConnection connect = new DataBaseConnection();
	Connection connectDB = connect.getConnection();
	//create query
	String getUsers = "SELECT quiz1_score FROM quiz_info";
	try {
		Statement statement = connectDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet queryStudents = statement.executeQuery(getUsers);
		//set up for loop to put students in admin object
		queryStudents.last();
		int counter = queryStudents.getRow();
		queryStudents.first();
		temp = new int[counter];
		//set first value to array
		temp[0]  = queryStudents.getInt("quiz1_score");
		//create temp string array to hold students
		//counter to 0
		counter = 1;
		//set rest of values through while loop
		while(queryStudents.next())
		{
			temp[counter] = queryStudents.getInt(1);
			counter++;
		}
		} catch (Exception e) 
			{
				e.printStackTrace();
			}
		return temp;
	}	
}	


