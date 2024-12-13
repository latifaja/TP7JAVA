import java.sql.SQLOutput;

public class Talkative implements Runnable {

private   static int n;// si on enleve static chaque thread de 100 fois n

    public Talkative(int n){
        this.n=n;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread "+n+":"+ n);

        }
    }
}
