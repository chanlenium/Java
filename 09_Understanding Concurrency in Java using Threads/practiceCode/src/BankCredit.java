public class BankCredit implements Runnable{
    private int balance;

    //BankCredit constructor

    public BankCredit(int balance) {
        this.balance = balance;
    }

    // Override run() method of Runnable to execute a new thread
    @Override
    public void run() {
        Thread activeThread = Thread.currentThread();   // Get current active thread
        System.out.println("The thread named: " + activeThread.getName() + " is starting.");
        for(int i = 0; i < 3; i++){
            creditAccount(10);
        }
        System.out.println("The thread named: " + activeThread.getName() + " is ending.");
    }

    // Credit account
    public void creditAccount(int i) {
        Thread activeThread = Thread.currentThread();
        System.out.println("Thread named: " + activeThread.getName() + " entering creditAccount().");

        // Here, is the point there could be problems with concurrency, so we can synchronize the following code
        // 2개의 thread가 account에 동시에 접근하면 account balance가 정확하게 계산되지 않음
        // 공유하는 부분만 sysnchronized block으로 묶으면 문제 해결
        // synchronized block을 제외한 나머지 부분은 unsynchronized block이므로 다른 thread가 언제든 접근 가능
        synchronized (this){
            // Move balance to an int and then update from int so its non-atomic
            int temp = balance;
            System.out.println("Thread named: " + activeThread.getName() + " is about to add " + i + " canadian dollars.");
            balance = temp + i;
        }
        System.out.println("Account balance is now: " + balance);
        System.out.println("Thread named: " + activeThread.getName() + " exiting creditAccount().");
    }

    public static void main(String[] args) {
        System.out.println("Main user thread has started.");
        // Create a Runnable object with balance 0
        BankCredit tbc = new BankCredit(0);
        // Create two threads which share the same bank credit
        Thread thread1 = new Thread(tbc, "credit-1");
        Thread thread2 = new Thread(tbc, "credit-2");

        // Power up the threads via the start() method
        thread1.start();
        thread2.start();

        System.out.println("Main user thread has ended.");
  }
}
