package autonoma.relojhilo.elements;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kamii
 */
public class RelojHilo implements Runnable {
    private boolean corriendo = true;

    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        while (corriendo) {
            LocalTime ahora = LocalTime.now();
            System.out.println("Hora: " + ahora.format(formatter));
            try {
                Thread.sleep(1000);  // Espera un segundo
            } catch (InterruptedException e) {
                // puedes manejar la interrupción aquí si quieres
            }
        }
    }

    public void stop() {
        this.corriendo = false;
    }

    public static void main(String[] args) {
        RelojHilo reloj = new RelojHilo();
        Thread hilo = new Thread(reloj);
        hilo.start();
    }
}
