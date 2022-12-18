package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest 
{

	User user = new User("ben", "ben", "1", true);
	

	@Test
	void testGet_username() 
	{
		String username = user.get_username();
		assertEquals("ben", username);
	}

	@Test
	void testGet_password() 
	{
		String password = user.get_password();
		assertEquals("1", password);
	}

	@Test
	void testGet_name() 
	{
		String name = user.get_name();
		assertEquals("ben", name);
	}

	@Test
	void testGet_admin() 
	{
		boolean admin = user.get_admin();
		assertEquals(true, admin);
	}

}
