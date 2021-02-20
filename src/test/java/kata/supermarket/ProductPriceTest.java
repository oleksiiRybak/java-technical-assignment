package kata.supermarket;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductPriceTest {
	
	ProductPrice productPrice;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testProductPriceMultipliedByZero() {
		BigDecimal expectedZeroResult = new BigDecimal(0.0);
		productPrice = new ProductPrice(new BigDecimal(1.0), new BigDecimal(0.0));
		assertEquals(expectedZeroResult, productPrice.price());
	}
	
	@Test
	void testProductPrice() {
		BigDecimal expectedZeroResult = new BigDecimal(0.25);
		productPrice = new ProductPrice(new BigDecimal(.5), new BigDecimal(.5));
		assertEquals(expectedZeroResult, productPrice.price());
	}
	
	@Test
    void expectEarlyNullPointerExceptionFromProductCreation() {
    	Assertions.assertThrows(NullPointerException.class, () -> {    		
    		productPrice = new ProductPrice(null, new BigDecimal(.5));
    	  });
    }

}
