/** Way to implement Thread
 * (1) implements Runnable class
 * (2) code thread's process in run() method
 */
public class MyExamRunnable implements Runnable{
    private int mark;

    MyExamRunnable(int m){
        mark = m;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(mark > 55){
            System.out.println("Exam is passed!");
        }
        System.out.println(getClass().getName() + " exits...");
    }

    public static void main(String[] args) {
        (new Thread(new MyExamRunnable(75))).start();
        System.out.println("main exits...");
    }
}

/**
 * Thread constructor takes as an argument a Runnable object.
 * The Runnable interface has only one method that takes no arguments and returns nothing:
 *
 * new Thread( new Runnable() {
 *    public void run() {System.out.println(10);}
 * }).start();
 *
 * The Runnable interface expressed as lambda expression is:
 *
 * () -> System.out.println(10)
 *
 * Therefore, replacing the Runnable (functional) interface with its lambda expression in the Thread constructor gives the solution:
 * new Thread(() -> System.out.println(10)).start();
 */
