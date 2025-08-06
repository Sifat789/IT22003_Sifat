public class Student {
    private String studentId;
    private int score;

    public Student(String studentId) {
        this.studentId = studentId;
        this.score = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int value) {
        score += value;
    }
}
