package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Product> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Product aPintOfMilk() {
        return new Product(new ProductPrice(new BigDecimal(0.49), new BigDecimal(1.0)));
    }

    private static Product aPackOfDigestives() {    	
        return new Product(new ProductPrice(new BigDecimal(1.55), new BigDecimal(1.0)));
    }

    private static Product aKiloOfAmericanSweets() {
        return new Product(new ProductPrice(new BigDecimal("4.99"), new BigDecimal("1.0")));
    }

    private static Product twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().updateProductUnits(new BigDecimal(".25"));
    }

    private static Product aKiloOfPickAndMix() {
        return new Product(new ProductPrice(new BigDecimal("2.99"), new BigDecimal("1.0")));
    }

    private static Product twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().updateProductUnits(new BigDecimal(".2"));
    }
}