package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
	
    private final List<Product> items;
    Discount discount;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(final Product item) {
        this.items.add(item);
    }

    List<Product> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Product> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Product::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of
         *  the discount calculations.
         *  It is not likely to be the best place to do those calculations.
         *  Think about how Basket could interact with something
         *  which provides that functionality.
         */
        private BigDecimal discounts() {
        	Discount discount = new DiscountGenerator(items, new DiscountZero());
        	return discount.calculateDiscount();
        }
                
        private BigDecimal calculate() {
        	BigDecimal discounts = discounts();
            return subtotal().subtract(discounts);
        }
    }
}
