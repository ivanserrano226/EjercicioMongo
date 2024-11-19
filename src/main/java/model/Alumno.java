package model;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Alumno implements Serializable {
    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private int calificaation;
    private String higher_grade;
}
