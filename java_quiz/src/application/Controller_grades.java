package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class Controller_grades implements Initializable
{
	@FXML
	private Button back;
	@FXML
	private Text name;
	@FXML
	private TableView<Person> table;
	@FXML
	private TableColumn<Person, SimpleStringProperty> gradeColumn;
	@FXML
	private TableColumn<Person, SimpleStringProperty> namesColumn;

	
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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		namesColumn.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("name"));
		gradeColumn.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("grade"));
		
		table.setItems(create_student_list());
	}
	
	public void update()
	{
		namesColumn.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("name"));
		gradeColumn.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("grade"));
		
		String[] names = current_user_admin.admin.get_student_names();
		int[] grades = current_user_admin.admin.get_student_grades();
		ObservableList<Person> users = FXCollections.observableArrayList();

		for(int x = 0; x < names.length; x++)
		{
			users.add(new Person("test", "test"));
		}
	}
	
	public ObservableList<Person> create_student_list()
	{
		String[] names = current_user_admin.admin.get_student_names();
		int[] grades = current_user_admin.admin.get_student_grades();
		ObservableList<Person> users = FXCollections.observableArrayList();

		for(int x = 0; x < names.length; x++)
		{
			users.add(new Person(names[x], String.valueOf(grades[x] + "/5")));
		}
		return users;
	}
}
