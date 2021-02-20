package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface Discount {
	public BigDecimal calculateDiscount();

}
