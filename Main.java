import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load FXML directly from the resources folder
        File fxmlFile = new File("resources/login.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile.toURI().toURL());

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Quiz");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

