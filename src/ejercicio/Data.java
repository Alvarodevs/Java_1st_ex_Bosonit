package ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Data {

    public static void main(String[] arg) {

        try {
            FileReader input = new FileReader("ejercicio.txt");
            BufferedReader Br= new BufferedReader(input);

            List<Persona> personas = new ArrayList<>();

            String linea="";
            String nombre;
            String poblacion;
            int edad;

            while (linea!= null) {

                linea=Br.readLine();

                if (linea != null){

                    String personData[] = linea.split(":");

                    try {
                        nombre = personData[0];
                        poblacion = personData[1];
                        edad = Integer.parseInt(personData[2]);

                        Optional <String> optNombre= Optional.ofNullable(nombre);
                        Optional <String> optPoblacion = Optional.ofNullable(poblacion);
                        Optional <Integer> optEdad = Optional.ofNullable(edad);


                        if (optPoblacion.get() == "")
                            poblacion = "Desconocida";

                        if (optNombre.isPresent() && optPoblacion.isPresent() && optEdad.isPresent()){
                            Persona persona = new Persona(nombre, poblacion, edad);
                            personas.add(persona);
                        }

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(e);
                    }
                }
            }

            personas.stream()
               .filter(persona -> persona.getEdad() < 25)
               .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
