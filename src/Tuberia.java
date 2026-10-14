import java.io.*;

public class Tuberia {
    public static void main(String[] args) {

        //String comando="NOTEPAD";
        String[] comando1 = {"CMD", "/C", "Tasklist"};
        String[] comando2 = {"CMD", "/C", "findstr", "chrome.exe"};

        try
        {
            ProcessBuilder pb = new ProcessBuilder(comando1);
            //tub.inheritIO();
            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            ProcessBuilder pb2 = new ProcessBuilder(comando2);
            Process proceso2 = pb2.start();

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(proceso2.getOutputStream())
            );

            String linea;
            while((linea = br.readLine()) != null){
                    bw.write(linea);
                    bw.newLine();
            }

            bw.flush();
            bw.close();

            BufferedReader br2 =new BufferedReader(
                    new InputStreamReader(proceso2.getInputStream())
            );

            while((linea = br2.readLine()) != null){
                System.out.println(linea);
            }

            proceso2.waitFor();
            System.out.println("Finalizada la ejecución :)");

        }
        catch (IOException e) {
            System.out.println("Error de E/S al ejecutar los procesos: " + e.getMessage());
        }
        catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido mientras esperaba: " + e.getMessage());
        }
        catch (SecurityException e) {
            System.out.println("No tienes permisos para crear subprocesos: " + e.getMessage());
        }
        catch (NullPointerException | IllegalArgumentException e)
        {
            System.out.println("ERROR: El comando especificado como parámetro es nulo o vacío.");
        }

    }
}