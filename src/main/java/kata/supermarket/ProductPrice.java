package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;
import static org.apache.commons.lang3.Validate.notNull;

public class ProductPrice implements ProductValue {
	
	BigDecimal price = new BigDecimal(0.0);
	BigDecimal units = new BigDecimal(0.0);
	
	public ProductPrice(BigDecimal price, BigDecimal units) {
		this.price = notNull(price);
		this.units = notNull(units);
		
	}

	@Override
	public BigDecimal pricePerUnit() {		
		return price;
	}

	@Override
	public BigDecimal units() {		
		return units;
	}

	@Override
	public BigDecimal price() {		
		return units.multiply(price);
	}
		
}
