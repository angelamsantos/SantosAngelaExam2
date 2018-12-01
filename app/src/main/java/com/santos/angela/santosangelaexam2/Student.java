package com.santos.angela.santosangelaexam2;

public class Student {

    //Long id;
    String fname, lname;
    Long exam1, exam2, average;

    public Student(String fname, String lname, Long average) {
        this.fname = fname;
        this.lname = lname;
//        this.exam1 = exam1;
//        this.exam2 = exam2;
        this.average = average;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

//    public Long getExam1() {
//        return exam1;
//    }
//
//    public Long getExam2() {
//        return exam2;
//    }

    public Long getAverage() {
        return average;
    }
}
