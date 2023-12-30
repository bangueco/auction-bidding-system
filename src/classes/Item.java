package classes;

import java.util.ArrayList;

public class Item {
  private ArrayList<String> auctionBidHistory = new ArrayList<String>();
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

    addAuctionHistory(sellerName);
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

  public String getHighestBidderName() {
    return this.highestBidder;
  }

  public void setHighestBidder(String bidder) {
    this.highestBidder = bidder;
  }

  private int getCurrentIndex(ArrayList<Item> items) {
    return items.indexOf(this);
  }

  private void addAuctionHistory(String user) {
    String history = user + " has auctioned " + itemName;
    auctionBidHistory.add(history);
  }

  public void addBiddingHistory(String user) {
    String history = "User " + user + " has bid " + this.price + " to this item";
    auctionBidHistory.add(history);
  }

  public void declareBidderWinner() {
    String history = "The winner of the bid is " + highestBidder + " with " + this.price;
    auctionBidHistory.add(history);
  }

  public void getItemHistory() {
    System.out.println("\n======================================");
    System.out.println("\tBidding History");
    System.out.println("======================================");
    for (int x = 0; x < auctionBidHistory.size(); x++) {
      System.out.println(auctionBidHistory.get(x));
    }
    System.out.println("======================================\n");
  }

  public void markAsSold() {
    this.itemStatus = "not available";
  }
}
