import java.util.*;

class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private int productAvailability;
    private int category;
    private int quantity;

    Product(int productId, String productName, double productPrice, int productAvailability, int category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAvailability = productAvailability;
        this.category = category;
        this.quantity = 0;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductAvailability() {
        return productAvailability;
    }

    public int getCategory() {
        return category;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getCategoryName() {
        switch (category) {
            case 1:
                return "Men's Clothing";
            case 2:
                return "Men's Footwear & Accessories";
            case 3:
                return "Women's Clothing";
            case 4:
                return "Women's Footwear & Accessories";
            case 5:
                return "Boy Kid";
            case 6:
                return "Girl Kid";
            case 7:
                return "Appliances";
            case 8:
                return "Electronics";
            case 9:
                return "Food & Beverages";
            default:
                return "No service";
        }
    }

    public void incrementQuantity() {
        this.quantity += 1;
    }
}

class Customer {
    private String name;
    private int age;
    private String emailId;
    private String address;
    private long phoneNumber;
    private long pinCode;
    private String placeName;

    Customer(String name, int age, String emailId, String address, long phoneNumber, long pinCode, String placeName) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        this.placeName = placeName;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getAddress() {
        return this.address;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public long getPinCode() {
        return this.pinCode;
    }

    public String getPlaceName() {
        switch ((int) this.pinCode) {
            case 502329:
                return "Sangareddy";
            case 500085:
                return "Jntu Kukatpally";
            case 500062:
                return "ECIL";
            case 500039:
                return "Boduppal";
            case 500034:
                return "Banjara Hills";
            case 500081:
                return "Madhapur";
            case 500006:
                return "Dhoolpet";
            case 500080:
                return "Gandhinagar";
            default:
                return "No service";
        }
    }
}

class ShoppingCart {
    private List<Product> items;
    private int quantity;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public List<Product> getItems() {
        return items;
    }

    public void addToCart(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.items.add(product);
            this.quantity += 1;
            product.incrementQuantity();
        }
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("| Product ID      | Name                      | Price        |  Quantity        |");
        System.out.println("--------------------------------------------------------------------------------------");

        Set<Integer> addedProductIds = new HashSet<>();
        for (Product product : this.items) {
            int productId = product.getProductId();

            if (!addedProductIds.contains(productId)) {
                System.out.printf("| %-15s | %-25s | $%-11.2f | %-15s |\n",
                        productId,
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getQuantity());

                addedProductIds.add(productId);
            }
        }

        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println("| Total Price of Products:");
        for (Product product : this.items) {
            double totalPriceForProduct = product.getProductPrice() * product.getQuantity();
            System.out.printf("| %-15s | $%-11.2f |\n",
                    product.getProductId(),
                    totalPriceForProduct);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void cartdisplay() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("| Product ID      | Name                      | Price        |  Quantity        |");
        System.out.println("--------------------------------------------------------------------------------------");

        Set<Integer> addedProductIds = new HashSet<>();
        for (Product product : this.items) {
            int productId = product.getProductId();

            if (!addedProductIds.contains(productId)) {
                System.out.printf("| %-15s | %-25s | $%-11.2f | %-15s |\n",
                        productId,
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getQuantity());

                addedProductIds.add(productId);
                System.out.println(
                        "--------------------------------------------------------------------------------------");

            }
        }
    }

    public void processOrder(Customer customer) {
        double total = calculateTotalPrice();
        System.out.println("Order processed for customer " + customer.getName());
        applyDiscounts(total);

    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : this.items) {
            total += product.getProductPrice() * product.getQuantity();
        }
        return total;
    }

    private void applyDiscounts(double total) {
        if (total >= 5000) {
            applyDiscount(0.25);
        } else if (total >= 2500) {
            applyDiscount(0.10);
        } else if (total >= 1500) {
            applyDiscount(0.05);
        }
    }

    private void applyDiscount(double discountPercentage) {
        double total = calculateTotalPrice();
        double discountAmount = total * discountPercentage;
        double discountedTotal = total - discountAmount;

        System.out.println("\nPrice : $" + total);
        System.out.println("Discount : $" + discountAmount);
        System.out.println("\nTotal Amount : $" + discountedTotal);

    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cho = "Yes";
        String prod = "add";
        int category;

        System.out.println("Enter your details ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Email: ");
        String emailId = sc.next();
        System.out.print("Phone Number: ");
        long phoneNumber = sc.nextLong();
        System.out.print("PIN Code: ");
        long pinCode = sc.nextLong();
        sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.println();

        String placeName = new Customer(name, age, emailId, "", phoneNumber, pinCode, "").getPlaceName();
        Customer customer1 = new Customer(name, age, emailId, address, phoneNumber, pinCode, placeName);
        System.out.println("Customer Details: \n" +
                "Name: " + customer1.getName() + "\n" +
                "Age: " + customer1.getAge() + "\n" +
                "Email: " + customer1.getEmailId() + "\n" +
                "Phone Number: " + customer1.getPhoneNumber() + "\n" +
                "PIN Code: " + customer1.getPinCode() + "\n" +
                "Place: " + placeName + "\n" +
                "Address: " + customer1.getAddress());
        System.out.println();

        int[] productIds = new int[0];
        String[] productNames = new String[0];
        double[] productPrices = new double[0];
        int[] availability = new int[0];

        ShoppingCart cart = new ShoppingCart();

        while (cho.equalsIgnoreCase("Yes")) {
            System.out.println(
                    "Availability Categories:\n1. Men's Clothing\n2. Men's Footwear & Accessories\n3. Women's Clothing\n"
                            +
                            "4. Women's Footwear & Accessories\n5. Boy Kid\n6. Girl Kid\n7. Appliances\n8. Electronics\n"
                            +
                            "9. Food & Beverages");
            System.out.print("Enter the category (0 to exit): ");
            category = sc.nextInt();

            if (category != 0 && category >= 1 && category <= 9) {
                switch (category) {
                    case 1:
                        System.out.println("\nMen's Clothing");
                        productIds = new int[] { 101, 102, 103, 104, 105, 106 };
                        productNames = new String[] { "Casual Shirts", "T-Shirts", "Jeans & Trousers",
                                "Ethnic wear",
                                "Shorts",
                                "Formal Wear" };
                        productPrices = new double[] { 499.45, 599.45, 999, 799, 399, 1099 };
                        availability = new int[] { 100, 50, 60, 78, 47, 20 };
                        System.out.println("\n");

                        break;

                    case 2:
                        System.out.println("\nMen's Footwear & Accessories");
                        productIds = new int[] { 201, 202, 203, 204, 205, 206, 207 };
                        productNames = new String[] { "Sports Shoes", "Walking Shoes", "Sneakers", "Sandals",
                                "Formal Shoes",
                                "Casual Shoes", "Smart Watches" };
                        productPrices = new double[] { 599, 499, 1199, 499, 799, 999, 2599 };
                        availability = new int[] { 78, 48, 96, 97, 21, 54, 74 };
                        System.out.println("\n");

                        break;

                    case 3:
                        System.out.println("\nWomen's Clothing");
                        productIds = new int[] { 301, 302, 303, 304, 305, 306 };
                        productNames = new String[] { "Kurtas & Sets", "Sarees", "Lehengas & Gowns", "Dresses",
                                "T-Shirts",
                                "Jeans" };
                        productPrices = new double[] { 899, 2999, 1799, 699, 799, 1099 };
                        availability = new int[] { 45, 74, 86, 32, 12, 47 };
                        System.out.println("\n");

                        break;

                    case 4:
                        System.out.println("\nWomen's Footwear & Accessories");
                        productIds = new int[] { 401, 402, 403, 404, 405 };
                        productNames = new String[] { "Sports Shoes", "Casual Shoes", "Flats Heels",
                                "Jewellery Set",
                                "Watches" };
                        productPrices = new double[] { 599, 499, 2099, 6999, 799 };
                        availability = new int[] { 12, 45, 78, 96, 33 };
                        System.out.println("\n");

                        break;

                    case 5:
                        System.out.println("\nBoy kid");
                        productIds = new int[] { 501, 502, 503, 504, 505 };
                        productNames = new String[] { "T-shirts", "Shorts", "Jeans", "Sweatshirts", "Combo Sets" };
                        productPrices = new double[] { 399, 499, 699, 599, 799 };
                        availability = new int[] { 45, 78, 63, 1, 45 };
                        System.out.println("\n");

                        break;

                    case 6:
                        System.out.println("\nGirl kid");
                        productIds = new int[] { 601, 602, 603, 604, 605 };
                        productNames = new String[] { "T-shirts", "Ethnic Set", "Dresses & Frocks", "Sweatshirts",
                                "Combo Sets" };
                        productPrices = new double[] { 499, 899, 1099, 599, 999 };
                        availability = new int[] { 100, 50, 80, 78, 77 };
                        System.out.println("\n");

                        break;

                    case 7:
                        System.out.println("\nAppliances");
                        productIds = new int[] { 701, 702, 703, 704, 705, 706, 707, 708 };
                        productNames = new String[] { "Washer & Dryer", "Fans", "Refrigerator", "AC", "TV",
                                "Vacuum Cleaner",
                                "Water Purifiers", "Inverters" };
                        productPrices = new double[] { 15999, 3999, 10999, 35999, 45000, 2999, 5999, 12999 };
                        availability = new int[] { 45, 78, 63, 48, 29, 42, 58, 78 };
                        System.out.println("\n");

                        break;

                    case 8:
                        System.out.println("\nElectronics");
                        productIds = new int[] { 801, 802, 803, 804, 805, 806 };
                        productNames = new String[] { "Laptops", "Mobiles", "Headphones", "Tablets", "Printers",
                                "Cameras" };
                        productPrices = new double[] { 16999, 13999, 1999, 30999, 4900, 12999 };
                        availability = new int[] { 72, 12, 63, 47, 63, 1 };
                        System.out.println("\n");

                        break;

                    case 9:
                        System.out.println("\nFood & Beverages");
                        productIds = new int[] { 901, 902, 903 };
                        productNames = new String[] { "Chocolates", "Nuts & Dry Fruits", "Cooking Essentials" };
                        productPrices = new double[] { 200, 1299, 1999 };
                        availability = new int[] { 5, 10, 45 };
                        System.out.println("\n");

                        break;

                    default:
                        break;
                }

                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.printf("| %-15s | %-25s | %-12s | %-15s | %-10s |\n", "Product ID", "Name", "Price",
                        "Availability", "Category");
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");

                for (int i = 0; i < productIds.length; i++) {
                    Product product = new Product(productIds[i], productNames[i], productPrices[i], availability[i],
                            category);
                    System.out.printf("| %-15s | %-25s | $%-11.2f | %-15d | %-10s |\n", product.getProductId(),
                            product.getProductName(), product.getProductPrice(), product.getProductAvailability(),
                            product.getCategoryName());
                }

                System.out.println(
                        "--------------------------------------------------------------------------------------------------");
                System.out.println();

                if (prod.equalsIgnoreCase("add")) {

                    int productId;
                    int quantity;

                    System.out.print("Enter the Product ID to add to cart: ");
                    productId = sc.nextInt();

                    System.out.print("Enter the quantity: ");
                    quantity = sc.nextInt();

                    Product selectedProduct = findProductById(productId, productIds,
                            productNames, productPrices,
                            availability, category);
                    if (selectedProduct != null) {
                        cart.addToCart(selectedProduct, quantity);
                        System.out.println("Product added to cart: " +
                                selectedProduct.getProductName() +
                                " (Quantity: " + quantity + ")");
                        cart.displayCart();
                    } else {
                        System.out.println("Product not found. Please enter a valid Product ID.");
                    }

                    System.out.print("Want to buy more? Enter Yes or No:");
                    cho = sc.next();
                    if (cho.equalsIgnoreCase("No")) {
                        System.out.print("Do you want to order the products (Yes/No) : ");
                        cho = sc.next();
                        if (cho.equalsIgnoreCase("Yes")) {
                            cart.processOrder(customer1);
                            System.out.println("---------------------------------");
                            System.out.println("Customer Details: \n" +
                                    "Name: " + customer1.getName() + "\n" +
                                    "Phone Number: " + customer1.getPhoneNumber() + "\n" +
                                    "Place: " + placeName + "\n" +
                                    "Address: " + customer1.getAddress());
                            System.out.println(
                                    "\nEnter 1 for cash on delivery \n 2 for UPI \n 3 for Net Banking Payment:");
                            System.out.print("Choose Payment mode : ");
                            int pay = sc.nextInt();
                            double id = 0;
                            double card = 0;
                            double ids = 0;
                            switch (pay) {
                                case 1:
                                    System.out.print("Cash on Delivery");
                                    break;
                                case 2:
                                    System.out.print("UPI \n Enter UPI ID : ");
                                    id = sc.nextDouble();
                                    System.out.println("Request is send to UPI app. accept to procude payment!");
                                    System.out.println("Enter Transaction ID : ");
                                    ids = sc.nextDouble();
                                    break;
                                case 3:
                                    System.out.print("Credit / Debit Card\n" +
                                            "Enter Card number : ");
                                    card = sc.nextDouble();

                                    break;
                                case 4:
                            }
                            if (pay == 1) {
                                System.out.println("Cash on Delivery");
                            } else if (pay == 2) {
                                System.out.println("Transaction ID : " + ids);
                            } else {
                                System.out.println("Card number : " + card);
                            }
                            System.out.println("\nYour Order");
                            cart.cartdisplay();
                            double discountedTotal = cart.calculateTotalPrice();
                            System.out.println("Total Amount : Rs." + discountedTotal);
                            System.out.println("Your Order has been placed successfully!");
                            System.out.println("Delivery by 28 Mar, Thursday.");
                            System.out.println("Thank You! Visit Again");
                        } else {
                            System.out.println("Continue your Shopping!");
                        }
                        break;
                    } else if (!cho.equalsIgnoreCase("Yes")) {
                        System.out.println("Invalid input. Please enter Yes or No.");
                        System.out.println("Enter yes or no : ");
                        cho = sc.next();
                    }
                }
            }
        }
    }

    private static Product findProductById(int productId, int[] productIds, String[] productNames,
            double[] productPrices, int[] availability, int category) {
        for (int j = 0; j < productIds.length; j++) {
            if (productIds[j] == productId) {
                return new Product(productIds[j], productNames[j], productPrices[j],
                        availability[j], category);
            }
        }
        return null;
    }
}