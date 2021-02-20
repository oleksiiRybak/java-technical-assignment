package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;
import static org.apache.commons.lang3.Validate.notNull;

import org.apache.commons.lang3.Validate;

public class Product {
	
	private ProductValue prodDetails;
	String productName;
    
    public Product(String productName, final ProductValue prodDetails) {
    	this.prodDetails = notNull(prodDetails);
        this.productName = notNull(productName);
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
