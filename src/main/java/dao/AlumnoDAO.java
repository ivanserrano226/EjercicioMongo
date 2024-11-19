package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.MongoDBConnection;
import model.Alumno;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class AlumnoDAO {

    MongoCollection<Alumno> colleccionAlumnos;

    public AlumnoDAO() {
        colleccionAlumnos = new MongoDBConnection().getAlumnosCollection();
    }

    public void insertarAlumnos(Alumno alumno) {
        colleccionAlumnos.insertOne(alumno);
    }

    public ArrayList<Alumno>  getAlumnos() {
        return findAlumnos(null);
    }

    public ArrayList<Alumno> getAlumnos(String email) {
        Bson filtroEmail = Filters.eq("email", email);
        return findAlumnos(filtroEmail);
    }

    private ArrayList<Alumno>  findAlumnos(Bson filtro) {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        FindIterable<Alumno> resultado;

        if(filtro == null) {
            resultado = colleccionAlumnos.find();
        }
        else {
            resultado = colleccionAlumnos.find(filtro);
        }

        MongoCursor<Alumno> cursor = resultado.cursor();
        while(cursor.hasNext()) {
            Alumno alumno = cursor.next();
            alumnos.add(alumno);
        }
        return alumnos;
    }

    public void borrarAlumnosNotaMinima() {
        //Borrar si la nota es superior a 5
        Bson filtrado = Filters.gte("calificaation", 5);
        colleccionAlumnos.deleteMany(filtrado);
    }
}