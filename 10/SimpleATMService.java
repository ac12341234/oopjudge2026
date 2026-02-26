public class Simple_ATM_Service implements ATM_Service {

	/**
	 * 檢查餘額
	 */
    @Override
    public boolean checkBalance(Account account, int money) throws ATM_Exception {
        if (account.getBalance() >= money) {
            return true;
        } else {
            throw new ATM_Exception(ATM_Exception.ExceptionTYPE.BALANCE_NOT_ENOUGH);
        }
    }

    /**
     * 檢查金額是否合法（1000 的倍數）
     */
    @Override
    public boolean isValidAmount(int money) throws ATM_Exception {
        if (money % 1000 == 0) {
            return true;
        } else {
            throw new ATM_Exception(ATM_Exception.ExceptionTYPE.AMOUNT_INVALID);
        }
    }

    /**
     * 錯誤時輸出錯誤訊息與現有餘額
     */
    @Override
    public void withdraw(Account account, int money) {
        int updatedBalance = account.getBalance() - money;
        try {
            // 注意：需先 checkBalance，再 isValidAmount，順序不可變動，否則 Sample Output 會變
            if (checkBalance(account, money) && isValidAmount(money)) {
                account.setBalance(updatedBalance);
                System.out.println("updated balance : " + updatedBalance);
            }
        } catch (ATM_Exception e) {
            System.out.println(e.getMessage());
            System.out.println("updated balance : " + account.getBalance());
        }
    }
}
