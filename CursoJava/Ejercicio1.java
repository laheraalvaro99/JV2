package CursoJava;


import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ejercicio1 {


    public static void main(String[] args) throws IOException {
        ArrayList <Persona> lista = new ArrayList<Persona>();

        try{
            File fic = new File("C:\\Users\\alvaro.martinez\\IdeaProjects\\Test\\src\\CursoJava\\fichero1.txt");
            BufferedReader fichero = new BufferedReader(new FileReader(fic));

            String linea;
            while((linea = fichero.readLine())!=null){
                lista.add(textoAPersona(linea));
            }

            ArrayList lista2 = (ArrayList) lista.stream()
                    .filter(persona -> (Integer.parseInt(persona.getEdad()) < 25))
                    .filter(persona -> (Integer.parseInt(persona.getEdad()) != 0))
                    .collect(Collectors.toList());

            int count = 1;
            for (int i = 0 ; i<lista2.size();i++){
                System.out.println("Línea "+ count + "." + lista2.get(i));
                count++;
            }
            fichero.close();
        }
        catch (FileNotFoundException fn ){
            System.out.println("No se encuentra el fichero");}
        catch (IOException io) {
            System.out.println("Error de E/S ");}
    }

    public static Persona textoAPersona(String cadena) {
        Persona p = new Persona();

        String[] tokens = cadena.split(":");

        if (tokens[0].equals("")) {
            p.setNombre("Desconocida");
        } else {
            p.setNombre(tokens[0]);
        }

        if (tokens[1].equals("")) {
            p.setPoblacion("Desconocida");
        } else {
            p.setPoblacion(tokens[1]);
        }

        if (!(tokens.length < 3)){
            if (tokens[2].equals("")) {
                p.setEdad("0");
            } else {
                p.setEdad(tokens[2]);
            }
        }else {
            p.setEdad("0");
        }
        return p;
    }
    }


