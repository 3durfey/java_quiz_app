package application;

public class Quiz 
{
	private int num_questions;
	private String[] answers;
	private String[] questions;
	private int num_correct;
	
	public Quiz(int num_questions, String[] answers, String[] questions, int num_correct)
	{
		this.num_questions = num_questions;
		this.answers = answers;
		this.questions = questions;
		this.num_correct = num_correct;
	}
	public int get_num_questions()
	{
		return this.num_questions;
	}
	public String[] get_answers()
	{
		return this.answers;
	}
	public String[] get_questions()
	{
		return this.questions;
	}
	public int get_num_correct()
	{
		return this.num_correct;
	}
	public void set_num_correct()
	{
		num_correct += 1;
	}
	public void reset_correct()
	{
		num_correct = 0;
	}
}
