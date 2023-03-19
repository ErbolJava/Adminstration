package Basics;

import Basics.Gender;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private Gender gender;
    private List<Lesson> lessons = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", lesson=" + lessons +
                '}';
    }
    public List<Lesson> getLesson() {
        return lessons;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lessons = lesson;
    }

    public Student(String firstName, String lastName, String emailAddress, String password, Gender gender, List<Lesson> lesson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.gender = gender;
        this.lessons = lesson;
    }



    public Student() {

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

    public String getEmailAddress() {

        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
