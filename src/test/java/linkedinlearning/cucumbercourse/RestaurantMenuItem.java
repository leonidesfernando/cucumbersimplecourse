package linkedinlearning.cucumbercourse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RestaurantMenuItem {
    private String itemName;
    private String description;
    private BigDecimal price;
}
