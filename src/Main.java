import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Main extends Thread {

    int nTomb;
    public Random random = new Random();
    public static void main(String[] args) {
        Main tombola1=new Main();
        Main tombola2=new Main();
        tombola1.set(1);
        tombola2.set(2);
        tombola1.start();
        tombola2.start();
    }

    public void run() {
        estrai();
    }

    public void set(int numero){
        nTomb = numero;
    }


    public void estrai(){
        int[] numeriUsciti=new int[90];
        int casuale;
        int contatore = 0;
        while(contatore<90){
            casuale= random.nextInt(90);
            boolean uscito=false;
            for (int i=0; i<contatore; i++){
                if (casuale==numeriUsciti[i]){
                    uscito=true;
                    break;
                }
            }
            if (!uscito){
                System.out.println(casuale +" "+ nTomb);
                numeriUsciti[contatore]=casuale;
                contatore++;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception e) {
                System.out.println(e);
            }
        }

    }


}