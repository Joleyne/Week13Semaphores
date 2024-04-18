import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {


        Task a = new Task();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        t1.start();
        t2.start();
        t3.start();


        //Semaphore sem = new Semaphore(1,true);
        //sem.acquire();
        //System.out.println("Number of permits: "+sem.availablePermits());
        //System.out.println(sem.isFair());
        //sem.release();
        //System.out.println("Number of permits: "+sem.availablePermits());
    }
}


class Task implements Runnable{
    Semaphore sem = new Semaphore(1);

    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.println("Run by: " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println("Running thread: " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
            sem.release();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}