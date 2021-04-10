public class SharedAccount {
	public static void main(String[] args) {
		int numberOfResources = 3;
		Account account = new Account();//The shared account containing a shared value
		DepositMoney depositResource = new DepositMoney(account, numberOfResources);
		WithdrawMoney withdrawResource = new WithdrawMoney(account, numberOfResources);
		depositResource.start();
		withdrawResource.start();
	}
}