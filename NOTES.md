# Notes

Dear invisible code assessor, 
I hope you are doing well. Below are a few notes which I hope will help you to understand my approach and the way of thinking about this problem.

First of all, all code that I changed compiles correctly. If it doesn't on your end please add commons-lang3 library manually as a jar file.
This is the library that I used to ensure some simple object validation and in general, it is a good library that helps to maintain code integrity.

As you probably noticed I removed Item-related classes. The reason for that is that the relation between Product and Item (in my opinion) didn't reflect the Product and price/units correctly as a whole, it was difficult to understand. The relations between objects were quite weird. 
I refactored it to make it more concise and reflect it better with regards to domain design, now it has much cleaner boundaries. 

I added Discount objects, actually one object implementation (percentage discount) but there might be other types of discounts: 3 for $1, buy-two-get-one-free etc.
Also, I introduced DiscountType to help to work with different types of discounts as they might have different rules etc and it is better to achieve it 
if we encapsulate those different types in different objects.

In Basket class, I included the discountZero flag to differentiate between different discount but in a real application it might be achieved by any sort of String types, 
checkbox-strings, enum-objects etc.

In ProductPrice class I chose units to be decimals to give it more flexibility in case if we start working with the values that require to be 1.5 etc.
Of course, this all depends on the domain model and concept but for this project, I just assumed that I needed such flexibility for units.

I've not added many comments in the code as I don't consider it is a good practice as the code should be self-explanatory.
Also, I added a few tests to cover the basic scenarios.

Overall, the project is not prod-ready yet but I believe you can see in which direction it goes and I hope you like it.

Thanks, 
Oleksii



