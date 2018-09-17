package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World");
		
		Parent root = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
		primaryStage.setScene(new Scene(root));
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
