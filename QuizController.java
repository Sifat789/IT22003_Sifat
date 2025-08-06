import javafx.fxml.FXML;
import javafx.scene.control.*;

public class QuizController {

    @FXML
    private Label questionLabel;
    @FXML
    private RadioButton optionA, optionB, optionC, optionD;
    @FXML
    private Label scoreLabel;

    private Student student;
    private int currentQuestion = 0;
    private ToggleGroup group;

    private String[] questions = {
            "প্রশ্ন ১: মানুষের দেহের সবচেয়ে বড় অঙ্গ কোনটি?",
            "প্রশ্ন ২: উদ্ভিদের কোন অংশে ফটোসিন্থেসিস হয়?"
    };

    private String[][] options = {
            {"মস্তিষ্ক", "হৃদয়", "ত্বক", "যকৃত"},
            {"মূল", "পাতা", "ডাল", "ফুল"}
    };

    private String[] answers = {"ত্বক", "পাতা"};

    public void setStudent(Student student) {
        this.student = student;
        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            optionA.setText(options[currentQuestion][0]);
            optionB.setText(options[currentQuestion][1]);
            optionC.setText(options[currentQuestion][2]);
            optionD.setText(options[currentQuestion][3]);

            group = new ToggleGroup();
            optionA.setToggleGroup(group);
            optionB.setToggleGroup(group);
            optionC.setToggleGroup(group);
            optionD.setToggleGroup(group);
        } else {
            // Quiz finished
            questionLabel.setText("আপনার স্কোর: " + student.getScore() + "/" + questions.length);
            optionA.setVisible(false);
            optionB.setVisible(false);
            optionC.setVisible(false);
            optionD.setVisible(false);
        }
    }

    @FXML
    public void handleNext() {
        if (group.getSelectedToggle() != null) {
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            if (selected.getText().equals(answers[currentQuestion])) {
                student.addScore(1);
            }
            currentQuestion++;
            loadQuestion();
        } else {
            scoreLabel.setText("একটি বিকল্প নির্বাচন করুন।");
        }
    }
}
