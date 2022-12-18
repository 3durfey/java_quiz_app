package application;

public class User 
{
	protected String name;
	protected String username;
	protected String password;
	protected boolean admin;
	
	public User(String name, String username, String password, boolean admin)
	{
		this.name = name; 
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	public User(boolean admin, String username) 
	{
		this.admin = admin;
		this.username = username;
	}
	public void set_username(String u)
	{
		this.username = u;
	}
	public void set_password(String p)
	{
		this.password = p;
	}
	public String get_username()
	{
		return this.username;
	}
	public String get_password()
	{
		return this.password;
	}
	public String get_name()
	{
		return this.name;
	}
	public boolean get_admin()
	{
		return this.admin;
	}
}
