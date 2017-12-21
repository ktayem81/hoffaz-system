/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.hoffaz;

/**
 *
 * @author eng_ayman
 */
public class Student_Enrollment {
   private int student_Id;
private int classroom_Id;
private int grade;

    public Student_Enrollment() {
    }

    public Student_Enrollment(int student_Id, int classroom_Id, int grade) {
        this.student_Id = student_Id;
        this.classroom_Id = classroom_Id;
        this.grade = grade;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public int getClassroom_Id() {
        return classroom_Id;
    }

    public void setClassroom_Id(int classroom_Id) {
        this.classroom_Id = classroom_Id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
