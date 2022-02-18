package cucumbercourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillAmount {
    private double billAmount;
    private double taxRate;
    private double billCalculated;
}
