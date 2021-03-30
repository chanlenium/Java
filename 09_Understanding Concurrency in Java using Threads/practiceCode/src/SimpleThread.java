public class SimpleThread extends Thread{
    public SimpleThread(String name) {
        super(name);
    }

    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println(i + " " + getName());
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("DONE! " + getName());
    }

    public static void main(String[] args) {
        Thread t1 = new SimpleThread("First");  // create 1st thread
        t1.start(); // execute run() method immediately
        Thread t2 = new SimpleThread("Second"); // create 2nd thread
        t2.start();
        System.out.println("DONE ALL!");
        /**
         * Note that you can’t control OS behaviour.
         * Do not rely on thread priority for algorithm correctness.
         */
    }
}
