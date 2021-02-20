package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class DiscountGenerator implements Discount {
	
	DiscountType discountType;
	List<Product> items;
	
	public DiscountGenerator(List<Product> items, DiscountType discountType) {
		Objects.nonNull(items);
		this.discountType = discountType;
		this.items = items;
	}

	@Override
	public BigDecimal calculateDiscount() {
		return items.stream().map(p -> p.price().multiply(discountType.amount()))
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO)
        .setScale(2, RoundingMode.HALF_UP);
	}
 	

}
