import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

public class LoginController {

    @FXML
    private TextField studentIdField;
    @FXML
    private Label messageLabel;

    @FXML
    public void handleLogin() {
        String studentId = studentIdField.getText().trim();

        if (studentId.isEmpty()) {
            messageLabel.setText("স্টুডেন্ট আইডি অবশ্যই দিতে হবে।");
            return;
        }

        if (!studentId.equals("it22003")) {
            messageLabel.setText("অনুমোদিত স্টুডেন্ট আইডি নয়।");
            return;
        }

        try {
            File fxmlFile = new File("resources/quiz.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlFile.toURI().toURL());
            Stage stage = (Stage) studentIdField.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));

            QuizController controller = loader.getController();
            controller.setStudent(new Student(studentId));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
