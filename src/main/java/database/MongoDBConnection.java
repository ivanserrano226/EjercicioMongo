package database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Alumno;
import model.Profesor;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class MongoDBConnection {
    String connectionString = "mongodb+srv://%s:%s@cluster0.wdwgm.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private CodecProvider pojoCodecProvider;
    private CodecRegistry pojoCodecRegistry;
    private MongoClient mongoClient;

    public MongoDBConnection() {
        pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

//        pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        mongoClient = MongoClients.create(String.format(connectionString, DBScheme.USER, DBScheme.PASSWORD));
    }

    public MongoCollection<Alumno> getAlumnosCollection() {
        MongoDatabase database = mongoClient.getDatabase("centro_estudios").withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Alumno> alumnosCollection = database.getCollection("alumnos", Alumno.class);
        return alumnosCollection;
    }

//    public MongoCollection getProfesoresCollection() {
//        MongoDatabase database = mongoClient.getDatabase("centro_estudios").withCodecRegistry(pojoCodecRegistry);
//        return database.getCollection("profesores", Profesor.class);
//    }
}