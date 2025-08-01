# Java Ecommerce Application

This is a simple console-based Ecommerce application implemented in Java. It simulates an online shopping experience where customers can browse product categories, add products to a shopping cart, and place orders with discounted pricing based on the total amount.

## Features

- Customer registration with details like name, age, email, phone number, PIN code, and address.
- Product browsing by categories such as Men's Clothing, Women's Clothing, Electronics, Appliances, Food & Beverages, and more.
- Display product details including Product ID, Name, Price, Availability, and Category.
- Add multiple products with specific quantities to a shopping cart.
- View shopping cart summary with product quantities and total pricing.
- Automatic discounts applied based on total purchase amount:
  - 5% discount for totals over $1500
  - 10% discount for totals over $2500
  - 25% discount for totals over $5000
- Multiple payment options including Cash on Delivery, UPI, and Credit/Debit Card.
- Order confirmation and summary display after successful purchase.

## Technologies Used

- Java SE
- Java Collections Framework (ArrayList, HashSet)
- Console I/O with Scanner class

## How to Run

1. Clone or download this repository.
2. Compile the Java files:
    javac Ecommerce.java
3. Run the application:
    java Ecommerce
4. Follow the on-screen prompts to enter customer details, browse product categories, add items to your cart, and place the order.

## Project Structure

- **Product.java**: Defines the Product class with product details and quantity management.
- **Customer.java**: Defines the Customer class with personal details and address lookup based on PIN code.
- **ShoppingCart.java**: Implements the shopping cart functionality including product addition, display, total price calculation, and discount application.
- **Ecommerce.java**: Main class with user interface logic to integrate customer interaction, product selection, and order processing.

## Future Enhancements

- Implement a graphical user interface (GUI) for better user experience.
- Add persistent storage (database) to manage products and customer data.
- Include user authentication and order history tracking.
- Support more payment gateways and transaction validations.
- Introduce real-time inventory updates reducing availability on purchases.

## License

This project is open-source and available under the MIT License.

---

Thank you for visiting the project! Feel free to contribute or raise issues for improvements.
