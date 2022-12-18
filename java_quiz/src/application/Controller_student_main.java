package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_student_main implements Initializable
{
	@FXML
	private Button quiz_button;
	@FXML
	private Text welcome_user;
	@FXML
	private Button back;
	@FXML
	private Text best_score;
	
	public void quiz1ButtonOnAction(ActionEvent e)
	{
		try {
				switchToQuiz1();
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
	}
	@FXML
	void switchToQuiz1() throws IOException 
	{		
		Parent root = FXMLLoader.load(getClass().getResource("quiz_template.fxml"));
		Stage stage = (Stage)quiz_button.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void set_users_name(String name)
	{
		welcome_user.setText("Welcome " + name);
	}
	public void backButtonOnAction(ActionEvent e) throws IOException
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
	        Parent root = loader.load();
	        back.getScene().setRoot(root);
			
		} catch (IOException e1) 

		{
			e1.printStackTrace();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		best_score.setText(current_user_student.student.get_score());
		welcome_user.setText("Welcome " + current_user_student.student.get_username());
		
	}
	public void update_score()
	{
		current_user_student.student.set_grade();
		best_score.setText(current_user_student.student.get_score()+"/5");
	}
	
	
	
}
