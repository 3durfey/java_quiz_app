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

public class controller_admin_main implements Initializable
{
	@FXML
	private Button answer_key;
	@FXML
	private Button grades;
	@FXML
	private Text welcome_user;
	@FXML
	private Button back;
	@FXML
	private Text best_score;
	
	
	public void answer_keyButtonOnAction(ActionEvent e) throws IOException
	{	
		try {		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("answer_key.fxml"));
	        Parent root = loader.load();
	        grades.getScene().setRoot(root);
	        Controller_answer_key quiz = loader.getController();
	        quiz.set_current_quiz(quiz1.quiz1);
			
		} catch (IOException e1) 

		{
			e1.printStackTrace();
		}
	}
	
	public void answer_gradesButtonOnAction(ActionEvent e) throws IOException
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("grades.fxml"));
	        Parent root = loader.load();
	        grades.getScene().setRoot(root);
	        Controller_grades controller_grades = loader.getController();
	        controller_grades.update();
			
		} catch (IOException e1) 

		{
			e1.printStackTrace();
		}
	}

	public void backButtonOnAction(ActionEvent e) throws IOException
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
	        Parent root = loader.load();
	        grades.getScene().setRoot(root);
			
		} catch (IOException e1) 

		{
			e1.printStackTrace();
		}
	}
	
	public void set_users_name(String name)
	{
		welcome_user.setText("Welcome " + current_user_admin.admin.get_username());
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		welcome_user.setText("Welcome " + current_user_admin.admin.get_username());
	}

}
