package com.example.retrofit.Model;

/**
 * Created by chirag.chaudhari on 12/15/2016.
 */

public class StudentModel {
    //Variables that are in our json
    private int StudentId;
    private String StudentName;
    private String StudentMarks;

    //Getters and setters
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int bookId) {
        this.StudentId = StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String name) {
        this.StudentName = StudentName;
    }

    public String getStudentMarks() {
        return StudentMarks;
    }

    public void setStudentMarks(String price) {
        this.StudentMarks = StudentMarks;
    }

}
