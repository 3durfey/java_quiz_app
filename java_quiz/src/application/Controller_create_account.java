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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller_create_account 
{
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private TextField admin_password;
	@FXML
	private Text input_warning;
	@FXML
	private Button enter;
	@FXML
	private Button back;
	
	public void enterButtonOnAction(ActionEvent e)
	{
		if (username.getText().isBlank() == false & password.getText().isBlank() == false) 
		{
			String usernameString = username.getText();
			String passwordString = password.getText();
			String admin = admin_password.getText();
			
			try {
				//create object using database class 
				DataBaseConnection connectNow = new DataBaseConnection();
				Connection connectDB = connectNow.getConnection();
				
				String checkLogin = "SELECT count(1) FROM login_info WHERE username = '" + username.getText() + "'";

				Statement statement = connectDB.createStatement();
				ResultSet queryUser = statement.executeQuery(checkLogin);
				
				while(queryUser.next())
				{
					if (queryUser.getInt(1) == 1)
					{
						input_warning.setText("User already exists. Please try again");

					}
					else
					{
						add_user(usernameString, passwordString, admin);

					}
				}
				
				} catch (Exception e1) 
					{
						e1.printStackTrace();
					}
		} 
		else
		{
			input_warning.setText("Please enter username and password.");
		}
	
		
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
	
	public void add_user(String u, String p, String a) throws SQLException 
	{

		//admin variable
		int admin = 0;
		//variable to compare for admin 
		String admin_a = "a";
		String main = "student_main.fxml";
		
		if(admin_a.equals(a))
		{
			admin = 1;
			main = "admin_main.fxml";
			current_user_admin.set_user_admin(u);
		}
		else
		{
			current_user_student.set_user_student(u);
			try {
				DataBaseConnection connect = new DataBaseConnection();
				Connection connectDB = connect.getConnection();
				String user = "INSERT INTO quiz_info(username, quiz1_score) VALUES (?, ?)";
				PreparedStatement statement = connectDB.prepareStatement(user);
				
				statement.setString(1, u);
				statement.setInt(2, 0);
				statement.executeUpdate();
				
				change_scene(main);

				} catch (Exception e) 
					{
						e.printStackTrace();
					}
		}
		//create query
		try {
			DataBaseConnection connect = new DataBaseConnection();
			Connection connectDB = connect.getConnection();
			String user = "INSERT INTO login_info(username, password, admin) VALUES (?, ?, ?)";
			PreparedStatement statement = connectDB.prepareStatement(user);
			
			statement.setString(1, u);
			statement.setString(2, p);
			statement.setInt(3, admin);
			statement.executeUpdate();
			change_scene(main);

			} catch (Exception e) 
				{
					e.printStackTrace();
				}
	
		
	}
	public void change_scene(String s) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
	    Parent root = loader.load();
	    enter.getScene().setRoot(root);
	}

}
