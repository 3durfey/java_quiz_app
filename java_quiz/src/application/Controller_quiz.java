package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_quiz 
{
	
	//correct answer buttons
	@FXML
	private RadioButton correct_1;
	@FXML
	private RadioButton correct_2;
	@FXML
	private RadioButton correct_3;
	@FXML
	private RadioButton correct_4;
	@FXML
	private RadioButton correct_5;
	@FXML
	private Button quiz_button;


	
	
	public void submitButtonOnAction(ActionEvent e)
	{
		if (correct_1.isSelected())
		{
			quiz1.quiz1.set_num_correct();
		}
		if (correct_2.isSelected())
		{
			quiz1.quiz1.set_num_correct();
		}
		if (correct_3.isSelected())
		{
			quiz1.quiz1.set_num_correct();
		}
		if (correct_4.isSelected())
		{
			quiz1.quiz1.set_num_correct();
		}
		if (correct_5.isSelected())
		{
			quiz1.quiz1.set_num_correct();
		}
		try {
				switchToResult();
			} catch (IOException e1) 
	
		{
			e1.printStackTrace();
		}
		
	}
	void switchToResult() throws IOException 
	{	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("quiz_result.fxml"));
        Parent root = loader.load();
        quiz_button.getScene().setRoot(root);
        Controller_result result = loader.getController();
        result.show_result(Integer.toString(quiz1.quiz1.get_num_correct()));
	}
}
