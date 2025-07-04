import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100.0, 5, 0.4, false);
        Biscuits biscuits = new Biscuits("Biscuits", 150.0, 3, 0.7, false);

        Customer customer = new Customer("Mohamed", 1000.0);

        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);

        System.out.println("\n=== Checkout ===");

        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = 30;
        double total = subtotal + shippingFee;

        if (!customer.pay(total)) {
            System.out.println("Insufficient balance!");
            return;
        }

        ShippingService shippingService = new ShippingService();
        shippingService.ship(cart.getItems());

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getTotalPrice());
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFee);
        System.out.println("Amount " + total);
        System.out.println("Remaining balance: " + customer.getBalance());
    }
}

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract boolean isExpired();

    public boolean isAvailable(int requestedQty) {
        return quantity >= requestedQty;
    }

    public void decreaseQuantity(int qty) {
        this.quantity -= qty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

interface Shippable {
    String getName();
    double getWeight();
}

class Cheese extends Product implements Shippable {
    private double weight;
    private boolean expired;

    public Cheese(String name, double price, int quantity, double weight, boolean expired) {
        super(name, price, quantity);
        this.weight = weight;
        this.expired = expired;
    }

    public boolean isExpired() {
        return expired;
    }

    public double getWeight() {
        return weight;
    }
}

class Biscuits extends Product implements Shippable {
    private double weight;
    private boolean expired;

    public Biscuits(String name, double price, int quantity, double weight, boolean expired) {
        super(name, price, quantity);
        this.weight = weight;
        this.expired = expired;
    }

    public boolean isExpired() {
        return expired;
    }

    public double getWeight() {
        return weight;
    }
}

class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}

class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (product.isAvailable(quantity)) {
            if (product.isExpired()) {
                System.out.println("Cannot add " + product.getName() + ": expired.");
                return;
            }
            items.add(new CartItem(product, quantity));
            product.decreaseQuantity(quantity);
        } else {
            System.out.println("Cannot add " + product.getName() + ": not enough quantity.");
        }
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}

class ShippingService {
    public void ship(List<CartItem> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0.0;
        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product instanceof Shippable) {
                Shippable s = (Shippable) product;
                double itemWeight = s.getWeight() * item.getQuantity();
                System.out.println(item.getQuantity() + "x " + s.getName() + " " + (itemWeight * 1000) + "g");
                totalWeight += itemWeight;
            }
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
