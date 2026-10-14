import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Escritor {
    public static void main(String[] args) {
        try {
            //leemos datos que llegan por lector
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader bf=new BufferedReader(isr);

            String linea;
            linea = bf.readLine();
            int num = Integer.parseInt(linea);

            //mostramos 10 siguientes números al recibido
            for(int i = num + 1; i <= num + 10; i++){
                System.out.println(i);
            }
            bf.close();
        } catch (IOException e) {
            System.out.println("ERROR: Error de E/S.");
        } catch (NumberFormatException e){
            System.out.println("Número incorrecto.");
        }
    }
}
