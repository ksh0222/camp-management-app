package model;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private List<Subject> selectedmandatoryList;
    private List<Subject> selectedchoiceList;
    public void setStudentId(String seq){
        this.studentId = seq;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setSelectedmandatoryList(List<Subject> subjects){
        this.selectedmandatoryList = subjects;
    }
    public void setSelectedchoiceList(List<Subject> subjects){
        this.selectedchoiceList = subjects;
    }
    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public List<Subject> getSelectedmandatoryList(){
        return selectedmandatoryList;
    }
    public List<Subject> getSelectedchoiceList(){
        return selectedchoiceList;
    }

}