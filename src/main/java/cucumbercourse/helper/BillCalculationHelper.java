package cucumbercourse.helper;


import java.math.BigDecimal;
import java.math.RoundingMode;

public final class BillCalculationHelper {

    private BillCalculationHelper(){}

    public static BigDecimal calculateBillCustomer(BigDecimal initialBillAmount, BigDecimal taxRate){
        return initialBillAmount.add(initialBillAmount.multiply(taxRate)
                        .divide(new BigDecimal(100),  RoundingMode.HALF_UP))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
