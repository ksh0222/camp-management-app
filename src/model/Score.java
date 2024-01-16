package model;

public class Score {
    private String scoreId;
    private String studentId;
    private Subject subject;
    private int round; // 회차
    private int scoreValue; // 점수

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

    public void setScoreValue(int newScore) {
        this.scoreValue = newScore;
    }

    public String getGrade() {
        if (subject.getSubjectType().equals("MANDATORY")) {
            if (scoreValue >= 95 && scoreValue <= 100) {
                return "A";
            } else if (scoreValue >= 90 && scoreValue <= 94) {
                return "B";
            } else if (scoreValue >= 80 && scoreValue <= 89) {
                return "C";
            } else if (scoreValue >= 70 && scoreValue <= 79) {
                return "D";
            } else if (scoreValue >= 60 && scoreValue <= 69) {
                return "F";
            } else {
                return "N";
            }
        } else if (subject.getSubjectType().equals("CHOICE")) {
            if (scoreValue >= 90 && scoreValue <= 100) {
                return "A";
            } else if (scoreValue >= 80 && scoreValue <= 89) {
                return "B";
            } else if (scoreValue >= 70 && scoreValue <= 79) {
                return "C";
            } else if (scoreValue >= 60 && scoreValue <= 69) {
                return "D";
            } else if (scoreValue >= 50 && scoreValue <= 59) {
                return "F";
            } else {
                return "N";
            }
        } else {
            return "잘못된 명령입니다.";
        }
    }
}