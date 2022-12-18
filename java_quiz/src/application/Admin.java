package application;

public class Admin extends User
{
	private String[] student_names;
	private int[] student_grades;
	
	public Admin(String name, String username, String password, boolean admin, String[] student_names, int[] student_grades) 
	{
		super(name, username, password, admin);
		this.student_names = student_names;
		this.student_grades = student_grades;
	}
	public Admin(boolean admin, String username, String[] student_names, int[] student_grades) 
	{
		super(admin, username);
		this.student_names = student_names;
		this.student_grades = student_grades;
	}
	public String[] get_student_names()
	{
		return this.student_names;
	}
	public int[] get_student_grades()
	{
		return this.student_grades;
	}
	public void set_student_names(String[] names)
	{
		this.student_names = names;
	}
	public void set_student_name(String name)
	{
		this.username = name;
	}
	
}
