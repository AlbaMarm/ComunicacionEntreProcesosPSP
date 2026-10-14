import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tuberia {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();

        //String comando="NOTEPAD";
        String[] comando1 = {"CMD", "/C", "Tasklist"};
        String[] comando2 = {"CMD", "/C", "findstr"};

        try
        {
            ProcessBuilder pb = new ProcessBuilder(comando1);
            //tub.inheritIO();
            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            ProcessBuilder pb2 = new ProcessBuilder(comando2);
            // TODO: Hacer que la salida del segundo sea el pid buscado desde del tasklist del primer proceso



        }
        catch (IOException | SecurityException e)
        {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
        catch (NullPointerException | IllegalArgumentException e)
        {
            System.out.println("ERROR: El comando especificado como parámetro es nulo o vacío.");
        }

    }
}