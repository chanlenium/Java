/** Definition of a Account */
class Account {
    private int balance = 0;
    private String currency;
    private boolean depositable = true;  // condition variable

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    /** synchronized method for setting the resource:
     The code in the get method loops until the Depositor has deposited a new value.
     Each time through the loop, the get method calls the wait method;
     The wait method relinquishes the lock held by the Withdrawer on the Account
     (thereby allowing the Depositor to get the lock and update the Account)
     and then waits for notification from the Withdrawer.*/
    public synchronized void setSharedAccount(Account account, int val) {
        //Consider commenting the following while loop to see that the Depositor
        //could deposit the next value without waiting for the previous to be withdrawn!
        while (!depositable) {  // not the Depositor's turn
            try {
                System.out.println("Waiting for Withdrawer...");
                wait();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        if(val == 1){
            account.setCurrency(String.valueOf(currencyUnit.values()[val-1]));
        }else{
            account.setCurrency(String.valueOf(currencyUnit.values()[val-1]) + "s");
        }
        account.setBalance(val);
        System.err.println( Thread.currentThread().getName() +
                " saves " + account.getBalance() + " " + account.getCurrency() + " into the shared account");

        depositable = false;
        notify();  // tell a waiting thread to become ready
    }

    /** synchronized method for getting the resource:
     When the Depositor puts some money in the Account,
     it notifies the Withdrawer by calling notifyAll.
     The Withdrawer then comes out of the wait state, the loop exits,
     and the get method returns the value in the Account.
     The set method works in a similar fashion, waiting for the Withdrawer thread to withdrwa
     the current value in the Account before allowing the Depositor to deposit new value.*/
    public synchronized int getSharedAccount(Account account) {
        //Consider commenting the following while loop to see that the Withdrawer
        //could withdraw the current values several times without waiting for the next to be deposited!
        while (depositable) {   // not the consumer's turn
            try {
                System.out.println("Waiting for Depositor...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        depositable = true;
        System.err.println( Thread.currentThread().getName() +
                " withdraws money " + account.getBalance() + " " + account.getCurrency() + " from the shared account\n");
        notify();  // tell a waiting thread to become ready
        return account.getBalance();
    }
}
