package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Basket {
	
    private final List<Product> items;
    Discount discount;
    // Here I included a simple boolean (for brevity) to differentiate what type of discount we are working with.
    //In a more complex real-life scenario this might be an enum-type or a String type or any other pre-defined value 
    // from a collection or a set of values
    boolean discountZero = false;

    public Basket(boolean discountZero) {
        this.items = new ArrayList<>();        
        this.discountZero = discountZero;
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
        private BigDecimal discounts(Supplier<DiscountType> discountType) {
        	Discount discount = new DiscountPercentGenerator(items, discountType);
        	return discount.calculateDiscount();
        }
                
        private BigDecimal calculate() {
        	// this if-condition could be replaced with stragety or factory pattern here 
        	// in case here are more if-else clauses
        	if(discountZero) {
        		return subtotal().subtract(discounts(() -> new DiscountZero()));
        	} else {
        		return subtotal().subtract(discounts(() -> new DiscountFifty()));
        	}
        }
        
    }
}
