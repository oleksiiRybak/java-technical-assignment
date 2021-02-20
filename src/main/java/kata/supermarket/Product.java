package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;
import static org.apache.commons.lang3.Validate.notNull;

import org.apache.commons.lang3.Validate;

public class Product {
	
	private ProductValue prodDetails;
    
    public Product(final ProductValue prodDetails) {
    	notNull(prodDetails);  	
        this.prodDetails = prodDetails;
    }

    BigDecimal price() {
        return prodDetails.price();
    }
    
    public Product updateProductUnits(BigDecimal units) {
    	ProductValue updatedProdDetails = new ProductPrice(prodDetails.pricePerUnit(), units);
    	prodDetails = updatedProdDetails;
    	return this;
    }

        
}
