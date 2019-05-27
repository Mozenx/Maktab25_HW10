package ir.maktab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true, name = "teacher_code")
    private long teacherCode;

    @Column(name = "salary")
    private double salary;

    @Column(name = "birthday")
    private LocalDate birthday;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, long teacherCode, double salary, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(long teacherCode) {
        this.teacherCode = teacherCode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}
