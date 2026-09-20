package bussiness.model;

import java.math.BigDecimal;

public class Grade {
    private int courseId;
    private BigDecimal grade;

    public Grade() {
    }

    public Grade(int courseId, BigDecimal grade) {
        this.courseId = courseId;
        this.grade = grade;
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
        return "Grade{" +
                "courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}