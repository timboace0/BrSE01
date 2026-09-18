package bussiness.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private int studentId;
    private String fullName;
    private LocalDate dob;
    private String email;

    public Student(int studentId, String fullName, LocalDate dob, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
    }

    public Student(String fullName, LocalDate dob, String email) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Họ tên: %s | Ngày sinh: %s | Email: %s%n",
                studentId,
                fullName,
                dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                email
        );
    }
}
