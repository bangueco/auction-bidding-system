package classes;

import java.util.ArrayList;

public class Item {
  private String itemName;
  private String itemQuantity;
  private String price;
  private String itemStatus;
  private String sellerName;
  private String highestBidder;

  public Item(String itemName, String quantity, String price, String status, String sellerName, String highestBidder) {
    this.itemName = itemName;
    this.itemQuantity = quantity;
    this.price = price;
    this.itemStatus = status;
    this.sellerName = sellerName;
    this.highestBidder = highestBidder;
  }

  public String getInfo(ArrayList<Item> items) {
    return "\n-------------------------" + "\n\tItem No. " + this.getCurrentIndex(items) + "\n-------------------------"
        + "\nItem Name: "
        + this.itemName
        + "\nQuantity: " + this.itemQuantity
        + "\nPrice: " + this.price + "\nStatus: " + this.itemStatus
        + "\nSeller Name: " + this.sellerName + "\nHighest Bidder: " + this.highestBidder
        + "\n-------------------------\n\n\n";
  }

  public String getPrice() {
    return this.price;
  }

  public void setPrice(String bid) {
    this.price = bid;
  }

  public String getSellerName() {
    return this.sellerName;
  }

  public void setHighestBidder(String bidder) {
    this.highestBidder = bidder;
  }

  private int getCurrentIndex(ArrayList<Item> items) {
    return items.indexOf(this);
  }
}