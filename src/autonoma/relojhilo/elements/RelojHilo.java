package autonoma.relojhilo.elements;

/**
 *
 * @author Kamii
 */
public class RelojHilo implements Runnable{
    private int segundos;
    private int minutos;
    private int hora;
    private boolean corriendo = true;
    
    
    @Override
    public void run() {
        while(corriendo){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                
            }
            segundos++;
            if(segundos == 60){
                segundos = 0;
                minutos++;
            }
            if(minutos == 60){
                minutos = 0;
                hora++;
            }
            System.out.println("Hora: " + hora + " Minutos: " + minutos + " Segundos: " +segundos); 
        }
          
    }
    
    public void stop(){
        this.corriendo = false;
    }

    public static void main(String[] args) {
        RelojHilo reloj = new RelojHilo();
        Thread hilo = new Thread(reloj);
        hilo.start();
    }
}
