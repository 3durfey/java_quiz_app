package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_result 
{
	@FXML
	private Text result;
	@FXML
	private Button tryAgain;
	@FXML
	private Button returnToMain;
	
	public void show_result(String s)
	{
		result.setText(s + "/5");
		int high_score = get_high_score();
		System.out.println(high_score + " " + s);
		if(high_score < Integer.valueOf(s))
		{
			try {
				update_high_score(Integer.valueOf(s));
			
				} catch (SQLException e) 
					{
						e.printStackTrace();
					}
		}
	}

	public void try_again(ActionEvent e) throws IOException
	{
		quiz1.quiz1.reset_correct();
		Parent root = FXMLLoader.load(getClass().getResource("quiz_template.fxml"));
		Stage stage = (Stage)tryAgain.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void returnToMain(ActionEvent e) throws IOException
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("student_main.fxml"));
	        Parent root = loader.load();
			Stage stage = (Stage)tryAgain.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	        Controller_student_main controller_student_main = loader.getController();
	        controller_student_main.update_score();
			
		} catch (IOException e1) 

		{
			e1.printStackTrace();
		}
	}

	public int get_high_score()
	{
		//return statement intilization
		int high_score = 0;
		DataBaseConnection connect = new DataBaseConnection();
		Connection connectDB = connect.getConnection();
		//create query
		try {
			String score = "SELECT quiz1_score FROM quiz_info WHERE username =?";
			PreparedStatement statement = connectDB.prepareStatement(score);
			statement.setString(1, current_user_student.student.get_username());
			ResultSet queryStudents = statement.executeQuery();

			//set rest of values through while loop
			while(queryStudents.next())
			{
				high_score = queryStudents.getInt(1);
			}
			} catch (Exception e) 
				{
					e.printStackTrace();
				}
			return high_score;
	}
	public void update_high_score(int high_score) throws SQLException 
	{


		//create query
		try {
			DataBaseConnection connect = new DataBaseConnection();
			Connection connectDB = connect.getConnection();
			String score = "UPDATE quiz_info SET quiz1_score =? WHERE username =?";
			PreparedStatement statement = connectDB.prepareStatement(score);
			statement.setInt(1, high_score);
			statement.setString(2, current_user_student.student.get_username());
			statement.executeUpdate();
			System.out.println(statement);


			} catch (Exception e) 
				{
					e.printStackTrace();
				}
		
	}
		

}
