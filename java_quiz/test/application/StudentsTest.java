package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentsTest 
{
	int[] x = new int[]{2, 2, 2};
	Students student = new Students(true, "username");


	@Test
	void testGet_scores() 
	{
		int result = Integer.valueOf(student.get_score());
        assertEquals(x, result);
	}

}
