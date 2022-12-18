package application;

public class current_user_student 
{
	static Students student;
	static public void set_user_student(String username)
	{
		 student = new Students(false, username);
	}
}
