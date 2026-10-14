import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class Lector {
    public static void main(String[] args) {
        System.out.print("Introduce un número: ");
        int num = Entrada.entero();

        try {
            //Ruta para encontrar escritor + comando para ej. desde otro proceso
            String classpath = System.getProperty("java.class.path");
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Escritor");
            Process p = pb.start();

            //escritor para enviar datos
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(p.getOutputStream())
            );

            String linea;
            bw.write(String.valueOf(num));
            bw.newLine();
            bw.flush();
            bw.close();

            //lector para recoger la salida de escritor y mostramos por pantalla
            BufferedReader br =new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }

            p.waitFor();


        } catch (IOException e) {
            System.out.println("ERROR: Error de E/S en: " + e.getMessage());
        } catch (InterruptedException e){
            System.out.println("El proceso fue interrumpido mientras esperaba: " + e.getMessage());
        }
    }
}
