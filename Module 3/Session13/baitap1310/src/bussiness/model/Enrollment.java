package bussiness.model;

import java.math.BigDecimal;

public class Enrollment {
    private int studentId;
    private int courseId;
    private BigDecimal grade;

    public Enrollment() {
    }

    public Enrollment(int studentId, int courseId, BigDecimal grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format(
                "Enrollment{studentId=%d, courseId=%d, grade=%s}",
                studentId, courseId, grade
        );
    }
}