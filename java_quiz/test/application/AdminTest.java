package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminTest 
{
	int[] x = new int[]{2, 2, 2};
	String[] y = new String[]{"2", "2", "2"};
	Admin admin = new Admin("name", "username", "password", true, y, x);


	@Test
	void testGet_student_names() 
	{
		String[] names = admin.get_student_names();
		assertEquals(y, names);
	}

	@Test
	void testGet_student_grades() 
	{
		int[] grades = admin.get_student_grades();
		assertEquals(x, grades);
	}

}
