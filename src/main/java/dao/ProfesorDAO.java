package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import database.MongoDBConnection;
import model.Profesor;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class ProfesorDAO {

    MongoCollection<Profesor> colleccionProfesores;

    public ProfesorDAO() {
        colleccionProfesores = new MongoDBConnection().getProfesoresCollection();
    }

    public void insertarProfesores(Profesor profesor) {
        colleccionProfesores.insertOne(profesor);
    }

    public ArrayList<Profesor>  getProfesores() {
        return findProfesores(null);
    }

    public ArrayList<Profesor> getProfesores(int edadMin, int edadMax) {
        Bson filtroEdad = Filters.and(Filters.gte("age", edadMin), Filters.lte("age", edadMax));
        return findProfesores(filtroEdad);
    }

    public void actualizarProfesor(String email, int rating) {
        Bson filtroEmail = Filters.eq("email", email);
        Bson actualizacion = Updates.set("calificaation", rating);
        colleccionProfesores.findOneAndUpdate(filtroEmail, actualizacion);
    }

    private ArrayList<Profesor>  findProfesores(Bson filtro) {

        ArrayList<Profesor> profesores = new ArrayList<>();

        FindIterable<Profesor> resultado;

        if(filtro == null) {
            resultado = colleccionProfesores.find();
        }
        else {
            resultado = colleccionProfesores.find(filtro);
        }

        MongoCursor<Profesor> cursor = resultado.cursor();
        while(cursor.hasNext()) {
            Profesor profesor = cursor.next();
            profesores.add(profesor);
        }
        return profesores;
    }
}