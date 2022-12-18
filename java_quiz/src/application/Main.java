//main for javafx
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application 
{
	
	@Override
	public void start(Stage Stage_1) 
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage_1.setScene(scene);
			Stage_1.show();
			
		} catch(Exception e) 
			  {
				  e.printStackTrace();
			  }
	} 
	
	public static void main(String[] args) 
		{
			launch(args);
		}
}
