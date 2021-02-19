package kata.supermarket;

import java.math.BigDecimal;

public interface ProductValue {
    BigDecimal pricePerUnit();  
    BigDecimal price(); 
    BigDecimal units();
    
    
}
