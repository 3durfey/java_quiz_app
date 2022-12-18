package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuizTest 
{


	String[] answers = {"50", "70", "20", "60", "40"};
	String[] questions = {"10 * 25", "10 * 7", "10 * 2 ", "20*3", "10 * 4"};		
	Quiz quiz1 = new Quiz(5, answers, questions, 0);


	@Test
	void testGet_num_questions() 
	{
		int result = quiz1.get_num_questions();
        assertEquals(5, result);
	}

	@Test
	void testGet_answers() {
		String[] answers = quiz1.get_answers();
        assertEquals(answers, this.answers);
	}

	@Test
	void testGet_questions() {
		String[] questions = quiz1.get_questions();
        assertEquals(questions, this.questions);
	}

	@Test
	void testGet_num_correct() {
		int c = quiz1.get_num_correct();
        assertEquals(0, c);
	}

	@Test
	void testSet_num_correct() {
		quiz1.set_num_correct();
		assertEquals(1, quiz1.get_num_correct());
	}

	@Test
	void testReset_correct() {
		quiz1.reset_correct();
		assertEquals(0, quiz1.get_num_correct());
	}

}
