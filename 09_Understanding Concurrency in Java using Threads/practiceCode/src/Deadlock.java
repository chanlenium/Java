import static java.lang.Thread.sleep;

public class Deadlock {
    public static void main(String[] args) {
        final Object r1 = "r1";
        final Object r2 = "r2";

        /**
         * Thread1 and Thread2 execute r1 and r2, respectively
         * When thread1 ends its r1 task, it tries to execute r2.
         * But if thread2 does not end r2, thread1 must remain in task r1 block
         * when thread2 ends its r2 task, it tries to execute r1.
         * But since thread1 is still in task r1 block, thread2 must remain in task r2 block
         * => As a result, all threads are in stuck!! (Liveness problem or Deadlock problem)
         */

        Thread t1 = new Thread(() ->
        {
            System.out.println("Thread 1: ready");
            synchronized (r1){
                System.out.println("Thread 1: locked resource 1");
                synchronized (r2){
                    System.out.println("Thread 1: locked resource 2");
                    try {
                        sleep((long)50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println("Thread 1: done");
        });

        Thread t2 = new Thread(() ->
        {
            System.out.println("Thread 2: ready");
            synchronized (r2){
                System.out.println("Thread 2: locked resource 2");
                synchronized (r1){
                    System.out.println("Thread 2: locked resource 1");
                    try {
                        sleep((long)50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println("Thread 2: done");
        });

        t1.start();
        t2.start();
    }
}
