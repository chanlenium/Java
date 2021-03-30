/** Way to implement Thread
 * (1) inherit Thread class
 * (2) code thread's process in run() method
 */
public class MyExamThread extends Thread{
    private int mark;

    MyExamThread(int m){
        mark = m;
    }

    public void run(){  // executed once .start() is called
        try {
            // execute Thread after 5000 ms
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(mark > 55){
            System.out.println("Exam is passed!");
        }
        System.out.println(getClass().getName() + " exits...");
    }

    public static void main(String args[]){
        (new MyExamThread(75)).start();
        System.out.println("main exits...");
    }
}
