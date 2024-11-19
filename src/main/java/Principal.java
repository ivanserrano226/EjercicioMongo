import java.util.ArrayList;
import java.util.Scanner;

import dao.AlumnoDAO;
import dao.ProfesorDAO;
import model.Alumno;
import model.Profesor;

public class Principal {
    private static AlumnoDAO alumnoDAO;
    private static ProfesorDAO profesorDAO;
    private static Scanner scanner;
    public static void main(String[] args) {

        alumnoDAO = new AlumnoDAO();
        profesorDAO = new ProfesorDAO();

        int opcion = 0;
        scanner = new Scanner(System.in);
        do {
            System.out.print("""
                            
                            1- Insertar un profesor.
                            2- Insertar un alumno.
                            3- Mostrar todos los datos.
                            4- Mostrar profesores.
                            5- Mostrar alumnos.
                            6- Buscar alumno.
                            7- Buscar profesor.
                            8- Actualizar profesor.
                            9- Dar de baja alumnos.
                            10- Salir
                            
                            """
            );
            try {
                System.out.print("Introduce una de las opciones de arriba: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch(opcion) {
                    case 1:
                        insertarProfesor();
                        break;
                    case 2:
                        insertarAlumno();
                        break;
                    case 3:
                        mostrarDatos();
                        break;
                    case 4:
                        mostrarProfesores();
                        break;
                    case 5:
                        mostrarAlumnos();
                        break;
                    case 6:
                        buscarAlumno();
                        break;
                    case 7:
                        buscarProfesor();
                        break;
                    case 8:
                        actualizarProfesor();
                        break;
                    case 9:
                        darBajaAlumnos();
                        break;
                    case 10:
                        System.out.println("Gracias por usar el programa.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ha habido un error. Inténtalo de nuevo.");
                e.printStackTrace();
                scanner.nextLine();
            }
        }
        while(opcion != 10);
    }

    private static void insertarProfesor() {
        System.out.print("Introduce el nombre del nuevo profesor: ");
        String nombre = scanner.next();
        System.out.print("Introduce el género del nuevo profesor: ");
        String genero = scanner.next();
        System.out.print("Introduce la edad del nuevo profesor: ");
        int edad = scanner.nextInt();
        System.out.print("Introduce el rating del nuevo profesor: ");
        double rating = scanner.nextDouble();
        System.out.print("Introduce el email del nuevo profesor: ");
        String email = scanner.next();
        System.out.print("Introduce el telefono del nuevo profesor: ");
        String phone = scanner.next();
        System.out.print("Introduce 2 asignaturas para el profesor nuevo. Asignatura 1: ");
        String subject1 = scanner.next();
        System.out.print("Introduce 2 asignaturas para el profesor nuevo. Asignatura 2: ");
        String subject2 = scanner.next();
        ArrayList<String> subjects = new ArrayList<String>();
        subjects.add(subject1);
        subjects.add(subject2);
        System.out.print("Introduce el título del nuevo profesor: ");
        String titulo = scanner.next();

        //Profesor nuevoProfesor = new Profesor(nombre, genero, edad, rating, email, phone, subjects, titulo);
        //profesorDAO.insertarProfesores(nuevoProfesor);

    }

    private static void insertarAlumno() {
        System.out.print("Introduce el nombre del nuevo alumno: ");
        String nombre = scanner.next();
        System.out.print("Introduce el género del nuevo alumno: ");
        String genero = scanner.next();
        System.out.print("Introduce la edad del nuevo alumno: ");
        int edad = scanner.nextInt();
        System.out.print("Introduce el rating del nuevo alumno: ");
        double rating = scanner.nextDouble();
        System.out.print("Introduce la calificación del nuevo alumno: ");
        int calificacion = scanner.nextInt();
        System.out.print("Introduce el email del nuevo alumno: ");
        String email = scanner.next();
        System.out.print("Introduce el telefono del nuevo alumno: ");
        String phone = scanner.next();
        System.out.print("Introduce el grado superior del nuevo alumno: ");
        String higher_grade = scanner.next();
        System.out.print("Introduce si el nuevo alumno puede o no realizar las FCTs (True o False): ");
        boolean fcts = scanner.nextBoolean();

        Alumno nuevoAlumno = new Alumno(nombre, genero, edad, rating, calificacion, email, phone, higher_grade, fcts);
        alumnoDAO.insertarAlumnos(nuevoAlumno);
    }

    private static void mostrarDatos() {
        System.out.println("Alumnos: ");
        ArrayList<Alumno> todos = alumnoDAO.getAlumnos();
        for(Alumno alumno: todos) {
            System.out.println(alumno);
        }
        System.out.println("Profesores: ");
    }

    private static void mostrarProfesores() {
        ArrayList<Alumno> todos = alumnoDAO.getAlumnos();
        for(Alumno alumno: todos) {
            System.out.println(alumno);
        }
    }

    private static void mostrarAlumnos() {
        ArrayList<Alumno> todos = alumnoDAO.getAlumnos();
//        for(Alumno alumno: todos) {
//            System.out.println(alumno);
//        }
    }

    private static void buscarAlumno() {
        //buscar por email
        System.out.print("Introduce el email del alumno: ");
        String email = scanner.next();
        Alumno alumno = alumnoDAO.getAlumnos(email).getFirst();
        if(alumno == null) {
            System.out.println("No se ha encontrado ningún alumno con ese email");
        }
        else {
            System.out.println(alumno);
        }

    }

    private static void buscarProfesor() {
        //buscar por rango min y max de edad
        System.out.print("Introduce la edad mínima del profesor: ");
        int edadMin = scanner.nextInt();
        System.out.print("Introduce la edad máxima del profesor: ");
        int edadMax = scanner.nextInt();
    }

    private static void actualizarProfesor() {
        //lo buscamos por email y le ponemos una nueva calificacion
        System.out.print("Introduce el email del profesor que quieres modificar: ");
        String email = scanner.next();
        System.out.print("Introduce la nueva calificacion: ");
        int calification = scanner.nextInt();
    }

    private static void darBajaAlumnos() {
        System.out.println("Se darán de baja los alumnos con nota superior a 5.");
        alumnoDAO.borrarAlumnosNotaMinima();
    }

}