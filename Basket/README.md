Task Description

Your company has been commissioned to develop software for a large online store, JavaMarkt. One of the core functionalities will be a shopping cart system that can handle various promotions, discounts, and special offers, such as:

    If the total order value exceeds 300 PLN, the customer receives a 5% discount on the purchased items.
    If the customer buys 2 products, the 3rd cheapest product is free.
    If the order value exceeds 200 PLN, the customer receives a free company mug.
    A one-time 30% discount coupon for a selected product.
    And many other promotions that are not yet defined at this stage of implementation.

Items in the cart should be sorted in descending order by price, and then by alphabetical order of product names.

Your task is to implement the logic, operating on Product objects, which should allow:

    Finding the cheapest/most expensive product in a given collection of products.
    Finding the n cheapest/most expensive products in a given collection of products.
    Sorting the collection of products by price and by name.
    Calculating the total price of all specified products.
    Displaying information about all products in a given collection of products in the console.
    Applying the aforementioned types of promotions to a given collection of products.

Product Class Specification

    Class fields:
        Product code (code) - String
        Product name (name) - String
        Product price (price) – double
        Product price after discount (discountPrice) - double

In this task, use an array of products as the collection on which you will operate.
Notes

The project should also include appropriate unit tests for the implemented functionality.