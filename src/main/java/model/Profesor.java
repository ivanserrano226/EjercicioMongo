package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
    private String name;
    private String gender;
    private int age;
    private double rating;
    private String email;
    private String phone;
    private ArrayList<String> subjects;
    private String title;

    public Profesor() {
    }

    public Profesor(String name, String gender, int age, double rating, String email, String phone, ArrayList<String> subjects, String title) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.rating = rating;
        this.email = email;
        this.phone = phone;
        this.subjects = subjects;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", subjects=" + subjects +
                ", title='" + title + '\'' +
                '}';
    }
}
