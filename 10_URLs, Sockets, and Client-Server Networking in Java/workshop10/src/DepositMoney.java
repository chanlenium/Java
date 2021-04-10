/** Definition of a Thread class DepositMoney */
class DepositMoney extends Thread {
    private Account depositHold;
    private int numberOfResources;

    public DepositMoney(Account account, int numberOfResources) {
        super("Depositor");
        this.depositHold = account;
        this.numberOfResources = numberOfResources;
    }

    public void run() {
        for (int count = 1; count <= numberOfResources; count++) {
            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );	// sleep for a random interval
            } catch(InterruptedException e) {
                System.err.println(e.toString());
            }
            depositHold.setSharedAccount(depositHold, count);
        }
    }
}
