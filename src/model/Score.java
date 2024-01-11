package model;

public class Score {
    private String scoreId;
    private String studentId;
    private Subject subject;
    private int round;
    private int scoreValue;

    public Score(String scoreId, String studentId, Subject subject, int round, int scoreValue) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subject = subject;
        this.round = round;
        this.scoreValue = scoreValue;
    }

    public Score(String seq) {
        this.scoreId = seq;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getRound() {
        return round;
    }

    public int getScoreValue() {
        return scoreValue;
    }
}
