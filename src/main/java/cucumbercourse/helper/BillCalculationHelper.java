package cucumbercourse.helper;


public final class BillCalculationHelper {

    private BillCalculationHelper(){}

    public static double calculateBillCustomer(double initialBillAmount, double taxRate){
        return initialBillAmount + (initialBillAmount*taxRate/100);
    }
}
