package BeCarefulAboutWait;

public class Customer {
    private int amount = 10000;

    public synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");
        // Note that you should always invoke wait() inside a loop
        // that continuously checks for the condition being waited on
        while(this.amount < amount){
            System.out.println("Less balance; waiting for deposit...");
            try {
                // make the current thread to wait until another thread invokes the notify()/notifyAll() for this object
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        if(this.amount < amount){
//            System.out.println("Less balance; waiting for deposit...");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        this.amount -= amount;
        System.out.printf("withdraw completed... Amount remained is %d\n", this.amount);
    }

    public synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed...");
        notify();
    }
}
