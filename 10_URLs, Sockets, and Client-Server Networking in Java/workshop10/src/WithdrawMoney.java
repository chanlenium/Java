/** Definition of a Thread class WithdrawMoney */
class WithdrawMoney extends Thread {
    private Account withdrawHold;
    private int numberOfResources;

    public WithdrawMoney(Account account, int numberOfResources) {
        super("Withdrawer");
        this.withdrawHold = account;
        this.numberOfResources = numberOfResources;
    }

    public void run() {
        int val;
        do {
            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );	// sleep for a random interval
            } catch(InterruptedException e) {
                System.err.println(e.toString());
            }
            val = withdrawHold.getSharedAccount(withdrawHold);
        } while (val != numberOfResources);
    }
}
