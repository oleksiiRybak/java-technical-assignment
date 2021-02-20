package kata.supermarket;

import java.math.BigDecimal;

public class DiscountZero implements DiscountType {
	
	public BigDecimal amount() {
		return BigDecimal.ZERO;
	}
	
}
