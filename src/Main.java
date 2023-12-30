import java.util.*;
import classes.User;
import classes.Item;

public class Main {

  // This is where to store the current user of a session
  static String currentUser = "";

  // ArrayList that stores object of items and users
  static ArrayList<Item> items = new ArrayList<Item>();
  static ArrayList<User> users = new ArrayList<User>();

  class Auth {
    // Logging in user
    public static void login() {
      Scanner input = new Scanner(System.in);
      boolean isLoggedIn = false;
      while (isLoggedIn == false) {
        System.out.println("Login to start bidding/auctioning today!");
        System.out.print("Username: ");
        String usernameLogin = input.next();
        System.out.print("Password: ");
        String passwordLogin = input.next();

        // Login validation

        for (User user : users) {

          if (usernameLogin.equals(user.getUsername()) &&
              passwordLogin.equals(user.getPassword())) {
            isLoggedIn = true;
            break;
          }
        }

        if (isLoggedIn) {
          System.out.println("Login success!");
          currentUser = usernameLogin;
          Menu.auctionBiddingMenu();
          break;
        } else {
          System.out.println("Invalid credentials");
          continue;
        }
      }
      input.close();
    }

    // Registering user
    public static void register() {
      Scanner input = new Scanner(System.in);
      System.out.println("Register to start bidding/auctioning today!");
      System.out.print("Username: ");
      String usernameRegister = input.next();
      System.out.print("Password: ");
      String passwordRegister = input.next();
      users.add(new User(usernameRegister, passwordRegister));
      System.out.println("\nRegistered successfully! Login now to start bidding/auctioning today!");

      Menu.auctionBiddingAuthMenu();
      input.close();
    }
  }

  class Menu {
    // Start Menu where the users will navigate through the system
    static void startMenu() {
      Scanner input = new Scanner(System.in);

      int choice = 0;
      while (choice != 1 || choice != 2 || choice != 3) {
        System.out.println("======================================");
        System.out.println("=======AUCTION-BIDDING-SYSTEM=========");
        System.out.println("========BY JUSTINE IVAN GUECO=========");
        System.out.println("======================================");
        System.out.println("1. Start Bidding");
        System.out.println("2. Show Items Being Auctioned");
        System.out.println("3. Exit");
        System.out.println("======================================");
        System.out.print("Choice: ");
        choice = input.nextInt();

        if (choice == 1 || choice == 2 || choice == 3) {
          break;
        }
      }

      if (choice == 1) {
        auctionBiddingAuthMenu();
      } else if (choice == 2) {
        itemsMenu();
        int itemsMenuInput = 0;

        while (itemsMenuInput != 1 || itemsMenuInput != 2) {
          System.out.println("1. To go start bidding");
          System.out.println("2. To go back to main menu");
          System.out.print("Choice: ");
          itemsMenuInput = input.nextInt();

          if (itemsMenuInput == 1) {
            auctionBiddingAuthMenu();
            break;
          } else if (itemsMenuInput == 2) {
            startMenu();
            break;
          } else {
            System.out.println("\n");
            System.err.println("Invalid input!");
            continue;
          }
        }
      } else {
        System.exit(0);
      }

      input.close();
    }

    // User authentication menu for auction and bidding system
    static void auctionBiddingAuthMenu() {
      Scanner input = new Scanner(System.in);

      int choice = 0;
      while (choice != 1 || choice != 2 || choice != 3) {
        System.out.println("======================================");
        System.out.println("=======AUCTION-BIDDING-SYSTEM=========");
        System.out.println("========BY JUSTINE IVAN GUECO=========");
        System.out.println("======================================");
        System.out.println("Note: you need to be registered/login inorder to auction or bid items");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Back to menu");
        System.out.println("4. Exit");
        System.out.println("======================================");
        System.out.print("Choice: ");
        choice = input.nextInt();

        if (choice == 1) {
          Auth.login();
          break;
        } else if (choice == 2) {
          Auth.register();
          break;
        } else if (choice == 3) {
          Menu.startMenu();
          break;
        } else if (choice == 4) {
          System.exit(0);
        } else {
          System.out.println("Invalid input");
        }
      }

      input.close();
    }

    // Menu that will show list of items that is being auction or has been auctioned
    static void itemsMenu() {
      System.out.println("======================================");
      System.out.println("==============ITEMS MENU==============");
      System.out.println("======================================");
      for (Item item : items) {
        System.out.print(item.getInfo(items));
      }
    }

    // Menu for auction bidding menu where you can also see items and manage items
    static void auctionBiddingMenu() {
      Scanner input = new Scanner(System.in);
      int choice = 0;
      while (choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5) {
        System.out.println("======================================");
        System.out.println("=======AUCTION-BIDDING-SYSTEM=========");
        System.out.println("========BY JUSTINE IVAN GUECO=========");
        System.out.println("======================================");
        System.out.println("1. Auction item");
        System.out.println("2. Bid item");
        System.out.println("3. Display items being auctioned");
        System.out.println("4. Manage your auctioned items");
        System.out.println("5. Logout");
        System.out.println("======================================");
        System.out.print("Choice: ");
        choice = input.nextInt();

        if (choice == 1) {
          auctionMenu();
          break;
        } else if (choice == 2) {
          biddingMenu();
          break;
        } else if (choice == 3) {
          itemsMenu();
          int itemsMenuInput = 0;

          while (itemsMenuInput != 1 || itemsMenuInput != 2) {
            System.out.println("1. To go back");
            System.out.println("2. To logout");
            System.out.print("Choice: ");
            itemsMenuInput = input.nextInt();

            if (itemsMenuInput == 1) {
              auctionBiddingMenu();
              break;
            } else if (itemsMenuInput == 2) {
              currentUser = "";
              startMenu();
              break;
            } else {
              System.out.println("\n");
              System.err.println("Invalid input!");
              continue;
            }
          }
          break;
        } else if (choice == 4) {
          int select;
          for (Item item : items) {
            if (item.getSellerName().equals(currentUser)) {
              System.out.println(item.getInfo(items));
            }
          }

          System.out.print("Select item to manage: ");
          select = input.nextInt();
          System.out.println(" ");
          manageAuctionedItems(select);

          // Forbid user from managing others item
          if (!items.get(select).getSellerName().equals(currentUser)) {
            System.out.println("\nItem not found!\n");
            auctionBiddingMenu();
          }
          break;
        } else {
          currentUser = "";
          startMenu();
          break;
        }
      }

      input.close();
    }

    // Menu for auctioning items
    static void auctionMenu() {
      Scanner input = new Scanner(System.in);
      System.out.println("======================================");
      System.out.println("=======AUCTION-BIDDING-SYSTEM=========");
      System.out.println("========BY JUSTINE IVAN GUECO=========");
      System.out.println("======================================");
      System.out.print("Item Name: ");
      String itemName = input.next();
      System.out.print("Quantity: ");
      String itemQuantity = input.next();
      System.out.print("Price: ");
      String itemPrice = input.next();

      items.add(new Item(itemName, itemQuantity, itemPrice, "available", currentUser, "none"));
      System.out.println("Items auctioned successfully!");
      auctionBiddingMenu();
      input.close();
    }

    // Menu for bidding items
    static void biddingMenu() {
      Scanner input = new Scanner(System.in);
      int select;

      itemsMenu();
      System.out.print("Select item to bid: ");
      select = input.nextInt();
      // Deny user from bidding on his/her own item
      if (items.get(select).getSellerName().equals(currentUser)) {
        System.out.println("\nYou can't bid on your own item!");
        biddingMenu();
      }

      System.out.println("\n======================================");
      System.out.println("=============BIDDING MODE=============");
      System.out.println("======================================");
      System.out.println("\nYou selected item no. " + items.indexOf(items.get(select)));
      System.out.println(items.get(select).getInfo(items));
      System.out.print("Place a bid: ");
      int bidAmount = input.nextInt();

      if (bidAmount <= Integer.parseInt(items.get(select).getPrice())) {
        System.out.println("Your bid must be greater than the current price listed!");
        biddingMenu();
      } else {
        items.get(select).setPrice(String.valueOf(bidAmount));
        items.get(select).setHighestBidder(currentUser);
        items.get(select).addBiddingHistory(currentUser);
        System.out.println("Bid placed successfully!");
        auctionBiddingMenu();
      }
      input.close();
    }

    static void manageAuctionedItems(int itemID) {
      Scanner input = new Scanner(System.in);
      int choice;
      items.get(itemID).getInfo(items);

      System.out.println("1. Mark as sold");
      System.out.println("2. Remove item");
      System.out.println("3. See item history");
      System.out.println("4. Go back");
      System.out.println(" ");
      System.out.print("Choice: ");
      choice = input.nextInt();

      if (choice == 1) {
        items.get(itemID).markAsSold();
        System.out.println("Item has been marked as sold!");
        System.out.println("The winner of the bid is " + items.get(itemID).getHighestBidderName());
      } else if (choice == 2) {
        items.remove(itemID);
        System.out.println("Removed item successfully!");
      } else if (choice == 3) {
        System.out.println("\n");
        items.get(itemID).getItemHistory();
      } else {
        auctionBiddingMenu();
      }

      input.close();
    }

  }

  public static void main(String[] args) {
    // Add default users
    users.add(new User("ban", "test"));
    users.add(new User("kibo", "nigga"));

    // Add default items
    items.add(new Item("buko juice", "20", "500", "available", "ban", "none"));
    items.add(new Item("buko juicx", "200", "1500", "available", "kibo", "none"));
    Menu.startMenu();
  }
}
