//connect to javafx and handle events


package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller_Login
{
	//close when cancel button clicked
	@FXML
	private Button login_button;
	@FXML
	private TextField username_field;
	@FXML 
	private PasswordField password_field;
	@FXML
	private Label input_warning;
	@FXML
	private Text welcome_user;
	@FXML
	private Button create_account;
	
	int admin;
	
	
	//action to login button
	public void loginButtonOnAction(ActionEvent e) 
	{
		if (username_field.getText().isBlank() == false & password_field.getText().isBlank() == false) 
		{
			validate_login();
		} 
		else
		{
			input_warning.setText("Please enter username and password.");
		}
	}
	//action to login button
	
	//close window on cancel button action 
	public void cancelButtonOnAction(ActionEvent e) 
	{
		Stage stage = (Stage) login_button.getScene().getWindow();
		stage.close();
	}
	//close window on cancel button action 
	public void createAccountButtonOnAction(ActionEvent e) throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("create_account.fxml"));
        Parent root = loader.load();
        login_button.getScene().setRoot(root);
	}
	//validate login information or print error 
	public void validate_login()
	{
		//create object using database class 
		DataBaseConnection connectNow = new DataBaseConnection();
		Connection connectDB = connectNow.getConnection();
		//verify using input 
		String verifyLogin = "SELECT count(1) FROM login_info WHERE username = '" + username_field.getText() + "' AND password = '" + password_field.getText() + "'";
		String getAdmin = "SELECT admin FROM login_info WHERE username = '" + username_field.getText() + "' AND password = '" + password_field.getText() + "'";
		//determine which message to send based on if it is in the database
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryUser = statement.executeQuery(verifyLogin);
			
			Statement statement2 = connectDB.createStatement();
			ResultSet queryAdmin = statement2.executeQuery(getAdmin);
			while(queryUser.next())
			{
				if (queryUser.getInt(1) == 1)
				{
					while(queryAdmin.next())
					{
						admin = queryAdmin.getInt(1);
					}
					if(admin == 1)
					{
						current_user_admin.set_user_admin(username_field.getText());
						switchToAdminMain();
					}
					else
					{
						current_user_student.set_user_student(username_field.getText());
						switchToStudentMain();
					}
				}
				else
				{
					input_warning.setText("Invalid login. Please try again");
				}
			}
			
			} catch (Exception e) 
				{
					e.printStackTrace();
				}
		
	}
	//switch to main menu upon successful login

		@FXML
		void switchToStudentMain() throws IOException 
		{	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("student_main.fxml"));
	        Parent root = loader.load();
	        login_button.getScene().setRoot(root);
	        Controller_student_main main = loader.getController();
	        main.set_users_name(username_field.getText());
		}
		@FXML
		void switchToAdminMain() throws IOException 
		{		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_main.fxml"));
	        Parent root = loader.load();
	        login_button.getScene().setRoot(root);
	        controller_admin_main main = loader.getController();
	        main.set_users_name(username_field.getText());
		}
}
