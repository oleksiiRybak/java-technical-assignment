package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductPrice implements ProductValue {
	
	BigDecimal price = new BigDecimal(0.0);
	BigDecimal units = new BigDecimal(0.0);
	
	public ProductPrice(BigDecimal price, BigDecimal units) {
		Objects.nonNull(price);
		Objects.nonNull(units);	
		
		this.price = price;
		this.units = units;		
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
