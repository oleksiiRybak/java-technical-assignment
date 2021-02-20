package kata.supermarket;

import java.math.BigDecimal;

public class DiscountFifty implements DiscountType {

	@Override
	public BigDecimal amount() {		
		return new BigDecimal(0.5);
	}

}
