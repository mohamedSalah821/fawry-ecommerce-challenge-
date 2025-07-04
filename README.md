# Fawry Rise Journey – E-commerce Challenge (Java Console App)

This is a simple Java console application developed as part of the **Fawry Rise Journey Internship Program – Full Stack Track**.

The project simulates a basic e-commerce system, demonstrating object-oriented programming (OOP), product management, cart operations, shipping logic, and checkout handling using clean Java code without external libraries.

---

## 📦 Features

- Define products with:
  - Name, Price, Quantity
  - Some are **expirable** (e.g. Cheese, Biscuits)
  - Some are **shippable** (e.g. TV, Cheese) with weight

- Cart functionality:
  - Add items to cart
  - Prevent adding expired or out-of-stock items

- Checkout process:
  - Calculate subtotal, shipping, total amount
  - Deduct from customer balance
  - Display final receipt

- Shipping Service:
  - Collect all shippable items
  - Display item names and total shipping weight

---

## 💡 Use Cases Covered

✅ Adding multiple product types  
✅ Handling expired or unavailable stock  
✅ Empty cart validation  
✅ Insufficient balance check  
✅ ShippingService logic  
✅ Console output similar to the example in the challenge  

---

## 🧪 Sample Execution

### Java Code Snippet:

```java
cart.add(cheese, 2);
cart.add(biscuits, 1);
checkout(customer, cart);

------------------------------------
** Shipment notice **
2x Cheese 800.0g
1x Biscuits 700.0g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese 200.0
1x Biscuits 150.0
----------------------
Subtotal 350.0
Shipping 30.0
Amount 380.0
Remaining balance: 620.0
------------------------------------
🛠 Technologies Used
Java (Object-Oriented)

No frameworks or external libraries

All code written in a single Main.java file for simplicity


------------------------------------
📁 File Structure
Main.java   // Contains all classes: Product, Cart, Customer, etc.
-----------------------------------

