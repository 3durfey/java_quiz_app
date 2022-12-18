package application;

import javafx.beans.property.SimpleStringProperty;

public class Person 
{
	private SimpleStringProperty name;
	private SimpleStringProperty grade;
	
	Person(String name, String grade)
	{
		this.name = new SimpleStringProperty(name);
		this.grade = new SimpleStringProperty(grade);
	}
	public SimpleStringProperty nameProperty()
	{
		return this.name;
	}
	public SimpleStringProperty gradeProperty()
	{
		return this.grade;
	}
}
