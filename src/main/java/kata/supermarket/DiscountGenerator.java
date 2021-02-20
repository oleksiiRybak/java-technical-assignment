package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class DiscountGenerator implements Discount {
	
	Supplier<DiscountType> discountType;
	List<Product> items;
	
	public DiscountGenerator(List<Product> items, Supplier<DiscountType> discountType) {
		Objects.nonNull(items);
		this.discountType = discountType;
		this.items = items;
	}

	@Override
	public BigDecimal calculateDiscount() {
		return items.stream().map(p -> p.price().multiply(discountType.get().amount()))
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO)
        .setScale(2, RoundingMode.HALF_UP);
	}
 	

}
