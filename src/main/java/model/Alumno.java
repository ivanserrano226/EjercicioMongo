package model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Alumno{

    private ObjectId id;
    @BsonProperty("name")
    private String name;
    @BsonProperty("gender")
    private String gender;
    @BsonProperty("age")
    private int age;
    @BsonProperty("rating")
    private double rating;
    @BsonProperty("calificaation")
    private int calificaation;
    @BsonProperty("email")
    private String email;
    @BsonProperty("phone")
    private String phone;
    @BsonProperty("higher_grade")
    private String higher_grade;
    @BsonProperty("FCTs")
    private boolean fcts;

    public Alumno() {
    }

    public Alumno(String name, String gender, int age, double rating, int calificaation, String email, String phone, String higher_grade, boolean fcts) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.rating = rating;
        this.calificaation = calificaation;
        this.email = email;
        this.phone = phone;
        this.higher_grade = higher_grade;
        this.fcts = fcts;
    }

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
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

    public double getCalificaation() {
        return calificaation;
    }

    public void setCalificaation(int calificaation) {
        this.calificaation = calificaation;
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

    public String getHigher_grade() {
        return higher_grade;
    }

    public void setHigher_grade(String higher_grade) {
        this.higher_grade = higher_grade;
    }

    public boolean isFcts() {
        return fcts;
    }

    public void setFcts(boolean fcts) {
        this.fcts = fcts;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", calificaation=" + calificaation +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", higher_grade='" + higher_grade + '\'' +
                ", fcts=" + fcts +
                '}';
    }
}
