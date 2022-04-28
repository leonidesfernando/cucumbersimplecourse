package cucumbercourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillAmount {
    private BigDecimal billAmount;
    private BigDecimal taxRate;
    private BigDecimal billCalculated;
}
