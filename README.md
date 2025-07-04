# Fawry Rise Journey – E-commerce Challenge (Java Console App)

This is a Java console application developed as part of the **Fawry Rise Journey Internship Program – Full Stack Track**. The project simulates a simple e-commerce system using Object-Oriented Programming (OOP), including product management, cart operations, shipping service, and checkout logic. Products are defined with *name*, *price*, and *quantity*. Some products may be **expirable** (like Cheese, Biscuits), while others may not (like TV and Mobile). Some are **shippable** (like Cheese and TV) and provide a weight, while others (like scratch cards) are not shippable. The system allows adding items to a cart with a quantity not exceeding available stock and prevents adding expired or out-of-stock items. Upon checkout, the application calculates the subtotal, adds a fixed shipping fee, checks customer balance, and prints the full receipt. If applicable, all shippable items are collected and passed to a ShippingService which prints their names and total weight. Edge cases like empty carts and insufficient balance are handled. A sample execution includes: `cart.add(cheese, 2); cart.add(biscuits, 1); checkout(customer, cart);` which produces the following output:  
**Shipment notice**  
2x Cheese 800.0g  
1x Biscuits 700.0g  
Total package weight 1.1kg  

**Checkout receipt**  
2x Cheese 200.0  
1x Biscuits 150.0  
----------------------  
Subtotal 350.0  
Shipping 30.0  
Amount 380.0  
Remaining balance: 620.0  

All code is written in a single file `Main.java` using pure Java without any frameworks or external libraries.  
Submitted by **Mohamed Salah Sabry Mohamed** for the **Fawry Rise Journey 2025 – Full Stack Track**.
