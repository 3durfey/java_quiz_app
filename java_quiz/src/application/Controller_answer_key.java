package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller_answer_key 
{
	@FXML
	private Button back;
	@FXML
	private Text question1;
	@FXML
	private Text question2;
	@FXML
	private Text question3;
	@FXML
	private Text question4;
	@FXML
	private Text question5;
	@FXML
	private Text answer1;
	@FXML
	private Text answer2;
	@FXML
	private Text answer3;
	@FXML
	private Text answer4;
	@FXML
	private Text answer5;
	

	
	
	

	public void set_current_quiz(Quiz quiz)
	{
		String[] questions = quiz.get_questions();
		String[] answers = quiz.get_answers();
		
		question1.setText("    " + questions[0]);
		question2.setText("    " + questions[1]);
		question3.setText("    " + questions[2]);
		question4.setText("    " + questions[3]);
		question5.setText("    " + questions[4]);
		
		answer1.setText("    " + answers[0]);
		answer2.setText("    " + answers[1]);
		answer3.setText("    " + answers[2]);
		answer4.setText("    " + answers[3]);
		answer5.setText("    " + answers[4]);
		
	}
	public void backButtonOnAction(ActionEvent e) throws IOException
	{	
		try {		
				FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_main.fxml"));
		        Parent root = loader.load();
		        back.getScene().setRoot(root);
		        controller_admin_main main = loader.getController();
		        main.set_users_name(current_user_admin.admin.get_username());
				
			} catch (IOException e1) 

			{
				e1.printStackTrace();
			}
	}
	
	

}
