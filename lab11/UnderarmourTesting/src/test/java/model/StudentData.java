package model;

import java.util.Objects;

public class StudentData {
    private String studentFirstName;
    private String studentLastName;
    private String registeredAsosEmailAddress;
    private String studentEmailAddress;

    public StudentData(String firstName, String lastName, String registeredAsosEmailAddress, String studentEmailAddress) {
        this.studentFirstName = firstName;
        this.studentLastName = lastName;
        this.registeredAsosEmailAddress = registeredAsosEmailAddress;
        this.studentEmailAddress = studentEmailAddress;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getRegisteredAsosEmailAddress() {
        return registeredAsosEmailAddress;
    }

    public void setRegisteredAsosEmailAddress(String registeredAsosEmailAddress) {
        this.registeredAsosEmailAddress = registeredAsosEmailAddress;
    }

    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }


    @Override
    public String toString() {
        return "User Data{" +
                "student first name='" + studentFirstName + '\'' +
                ", student last name='" + studentLastName + '\'' +
                ", registered asos email address='" + registeredAsosEmailAddress + '\'' +
                ", student email address='" + studentEmailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentData)) return false;
        StudentData user = (StudentData) o;
        return Objects.equals(getStudentFirstName(), user.getStudentFirstName()) &&
                Objects.equals(getStudentLastName(), user.getStudentLastName()) &&
                Objects.equals(getRegisteredAsosEmailAddress(), user.getRegisteredAsosEmailAddress()) &&
                Objects.equals(getStudentEmailAddress(), user.getStudentEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentFirstName(), getStudentLastName(), getRegisteredAsosEmailAddress(), getStudentEmailAddress());
    }
}

