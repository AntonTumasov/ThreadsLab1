package herzen;


class Egg extends Thread{
    @Override
    public void run(){
        for (int i=0; i<=100; i++){

            try{
                Egg.sleep(10);
            } catch (InterruptedException e) {}

            System.out.println("Egg was first!");
        }
    }

}

class Human implements Runnable {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            System.out.println("ЧЕЛОВЕК ТОЖЕ ТУТ!");

        }
    }
}

public class App 
{
    public static void main( String[] args ) throws InterruptedException

    {
        Egg newEgg = new Egg();
        Human human = new Human();
        Thread newThread = new Thread(human);
        newThread.start();
        System.out.println("Arguing is started!");
        newEgg.start();
        for (int i=0; i<=100; i++){
            System.out.println("Chicken was first");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e){}
        }
        if(newEgg.isAlive() && newThread.isAlive()){
            try{
                newEgg.join();
                newThread.join();
            }catch (InterruptedException e){}

            System.out.println("RESULT: EGG WINS!");
        }
        else {
            System.out.println("RESULT: CHICKEN WINS!");
        }
        System.out.println("Arguing is ended");

    }
}
