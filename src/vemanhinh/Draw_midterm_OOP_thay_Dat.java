package vemanhinh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Draw_midterm_OOP_thay_Dat extends Application {

    public static final String CURRENCY = "$";
    @Override
    public void start(Stage primaryStage) throws IOException{
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("market.fxml"));
            primaryStage.setTitle("Fruits Marker");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
