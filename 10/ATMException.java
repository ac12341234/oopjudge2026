public class ATMException extends Exception {

    public enum ExceptionType { BALANCE_NOT_ENOUGH, AMOUNT_INVALID }

    // 儲存例外狀況
    private ExceptionType exceptionCondition;

    public ATMException(ExceptionType e) {
        super("ATM_Exception");
        this.exceptionCondition = e;
    }

    // 根據例外狀況回傳對應訊息
    @Override
    public String getMessage() {
        switch (exceptionCondition) {
            case BALANCE_NOT_ENOUGH:
                return "BALANCE_NOT_ENOUGH";
            case AMOUNT_INVALID:
                return "AMOUNT_INVALID";
            default:
                return "UNKNOWN_EXCEPTION";
        }
    }

    // Getter，如果需要取得例外型別
    public ExceptionTyppe getExceptionType() {
        return exceptionCondition;
    }
}
