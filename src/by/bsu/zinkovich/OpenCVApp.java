package by.bsu.zinkovich;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class OpenCVApp extends Application
{
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("opencv.fxml"));
			BorderPane root = loader.load();
			Scene scene = new Scene(root, 700, 700);
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Image Editor");
			this.primaryStage.setScene(scene);
			this.primaryStage.show();

            OpenCVController controller = loader.getController();
			controller.setStage(this.primaryStage);
			controller.init();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		// load the native OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		launch(args);
	}
}
