package dersler.hafta04.ders014;

public class AccountManager {

	private static final int MAX_DEPOSIT_LIMIT = 10_000;
	private static final int MAX_WITHDRAWAL_LIMIT = 5_000;

	public void paraYatir(Account account, int miktar) {
		if (miktar <= MAX_DEPOSIT_LIMIT && miktar > 0) {
			account.setMoney(account.getMoney() + miktar);
			System.out.println("Para yatırma işlemi başarılı yatırılan miktar: " + miktar + ", Hesaptaki para: "
					+ account.getMoney());
		}
	}

	public void paraCek(Account account, int miktar) {
		if (miktar <= MAX_WITHDRAWAL_LIMIT && miktar > 0) {
			if (account.getMoney() <= miktar) {
				account.setMoney(account.getMoney() + miktar);
				System.out.println("Para çekme işlemi başarılı çekilen miktar: " + miktar + ", Hesaptaki para: "
						+ account.getMoney());
			} else {
				System.out.println("Bakiye yetersiz");
			}

		}
	}

	

}
