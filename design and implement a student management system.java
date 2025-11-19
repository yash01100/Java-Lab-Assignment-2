  import java.io.*;
  import java.util.*;
  
  /**
   * ShoppingSystem class for managing online shopping using inheritance, polymorphism, collections, and file handling.
   * Includes menu-driven interface.
   * Student: Yash Raj, Roll No: 2401010008, Program: B.Tech. CSE Core, Faculty: Lucky Verma
   */
  public class ShoppingSystem {
      private Map<Integer, Product> products;
      private ShoppingCart cart;
      private List<Order> orders;
      private int nextOrderId;
      private final String FILE_NAME = "orders.dat";
      
      // Constructor
      public ShoppingSystem() {
          products = new HashMap<>();
          cart = new ShoppingCart();
          orders = new ArrayList<>();
          nextOrderId = 1;
          initializeProducts();
          loadOrders();
      }
      
      // Initialize sample products
      private void initializeProducts() {
          products.put(1, new Electronics(1, "Laptop", 50000));
          products.put(2, new Clothing(2, "T-Shirt", 1000));
          products.put(3, new Electronics(3, "Phone", 20000));
      }
      
      // Add to Cart
      public void addToCart() {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter Product ID: ");
          int id = scanner.nextInt();
          System.out.print("Enter Quantity: ");
          int qty = scanner.nextInt();
          if (qty <= 0) {
              System.out.println("Invalid quantity.");
              return;
          }
          Product p = products.get(id);
          if (p == null) {
              System.out.println("Product not found.");
              return;
          }
          cart.addItem(p, qty);
          System.out.println("Added to cart.");
      }
      
      // View Cart
      public void viewCart() {
          cart.viewCart();
      }
      
      // Remove from Cart
      public void removeFromCart() {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter Product ID to remove: ");
          int id = scanner.nextInt();
          cart.removeItem(id);
          System.out.println("Removed from cart.");
      }
      
      // Checkout
      public void checkout() {
          if (cart.getItems().isEmpty()) {
              System.out.println("Cart is empty.");
              return;
          }
          Order order = new Order(nextOrderId++, cart);
          orders.add(order);
          cart.clearCart();
          System.out.println("Order placed with ID: " + order.getOrderId());
      }
      
      // View Orders
      public void viewOrders() {
          if (orders.isEmpty()) {
              System.out.println("No orders.");
              return;
          }
          for (Order order : orders) {
              order.displayOrder();
              System.out.println("---");
          }
      }
      
      // Save Orders
      public void saveOrders() {
          try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
              oos.writeObject(orders);
              oos.writeInt(nextOrderId);
              System.out.println("Orders saved.");
          } catch (IOException e) {
              System.out.println("Error saving: " + e.getMessage());
          }
      }
      
      // Load Orders
      public void loadOrders() {
          try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
              orders = (List<Order>) ois.readObject();
              nextOrderId = ois.readInt();
              System.out.println("Orders loaded.");
          } catch (IOException | ClassNotFoundException e) {
              System.out.println("No existing orders.");
          }
      }
      
      // Main Menu
      public void mainMenu() {
          Scanner scanner = new Scanner(System.in);
          int choice;
          do {
              System.out.println("\nOnline Shopping Cart System");
              System.out.println("1. Add to Cart");
              System.out.println("2. View Cart");
              System.out.println("3. Remove from Cart");
              System.out.println("4. Checkout");
              System.out.println("5. View Orders");
              System.out.println("6. Save Orders");
              System.out.println("7. Load Orders");
              System.out.println("8. Exit");
              System.out.print("Enter your choice: ");
              choice = scanner.nextInt();
              switch (choice) {
                  case 1: addToCart(); break;
                  case 2: viewCart(); break;
                  case 3: removeFromCart(); break;
                  case 4: checkout(); break;
                  case 5: viewOrders(); break;
                  case 6: saveOrders(); break;
                  case 7: loadOrders(); break;
                  case 8: saveOrders(); System.out.println("Exiting..."); break;
                  default: System.out.println("Invalid choice.");
              }
          } while (choice != 8);
          scanner.close();
      }
      
      // Main Method
      public static void main(String[] args) {
          ShoppingSystem system = new ShoppingSystem();
          system.mainMenu();
      }
  }
  
