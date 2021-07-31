import java.util.ArrayList;


public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Bid> bidList = new ArrayList<Bid>();

		bidList.add(new Bid(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90));
		bidList.add(new Bid(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80));

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all bid
				C206_CaseStudy.viewAllBids(bidList);
			} else if (option == 2) {
				// Add a new bid
				Bid newBid = inputBid(bidList);
				C206_CaseStudy.addNewBid(bidList, newBid);
			} else if (option == 3) {
				// Delete bid
				int BidID = removeBid(bidList);
				C206_CaseStudy.deleteMyBid(bidList, BidID);
			} else if (option == 5) {
				System.out.println("Bye! Hope to see you soon!");
			}
			else {
				System.out.println("INVALID OPTION ENTERED.");
			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. VIEW BID");
		System.out.println("2. ADD BID");
		System.out.println("3. DELETE BID");
		System.out.println("5. QUIT");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//========================================================================= BID METHODS ========================================================================================

	// VIEW
	public static String retrieveAllBid(ArrayList<Bid> bidList) {
		String output = "";

		for (int i = 0; i < bidList.size(); i++) {
			output += String.format("%-10s %-25s %-20s %-20s %.2f\n", bidList.get(i).getBidID(), bidList.get(i).getItemName(), bidList.get(i).getSellerEmail(), bidList.get(i).getBuyerEmail(), bidList.get(i).getBidPrice());
		}
		return output;
	}
	public static void viewAllBids(ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("VIEW ALL BIDS");
		String output = "";
		if (bidList.isEmpty()) {
			output = "You have no existing bids at the moment.";
		}
		else {
			output = String.format("%-10s %-25s %-20s %-20s %-10s\n", "BID ID", "ITEM NAME", "SELLER EMAIL", "BUYER EMAIL", "BID PRICE");
			output += retrieveAllBid(bidList);
		}
		System.out.println(output);
	}

	// ADD
	public static Bid inputBid(ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("ADD BID");
		int bidID = bidList.size() + 1;
		String itemName = Helper.readString("Enter Item Name > ");
		while (itemName.isEmpty()) {
			Bid.emptyFields();
			itemName = Helper.readString("Enter Item Name > ");
		}
		String sellerName = Helper.readString("Enter Seller Name > ");
		while (sellerName.isEmpty()) {
			Bid.emptyFields();
			sellerName = Helper.readString("Enter Seller Name > ");
		}
		String buyerName = Helper.readString("Enter Buyer Name > ");
		while (buyerName.isEmpty()) {
			Bid.emptyFields();
			buyerName = Helper.readString("Enter Buyer Name > ");
		}
		double price = Helper.readDouble("Enter Item Price > ");
		while (price == 0) {
			Bid.emptyFields();
			price = Helper.readDouble("Enter Item Price > ");
		}
		// create object
		Bid newBid = new Bid(bidID, itemName, sellerName, buyerName, price);
		return newBid;
	}
	public static void addNewBid(ArrayList<Bid> bidList, Bid newBid) {
		// add object into arrayList.
		bidList.add(newBid);
		System.out.println("Congratulations! You have successfully bid the item!");
	}

	// DELETE
	public static int removeBid(ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("DELETE MY BID");
		int bidID = Helper.readInt("Enter Bid ID > ");
		return bidID;
	}
	
	public static String deleteMyBid(ArrayList<Bid> bidList, int BidID) {
		boolean found = false;
		String output = "";
		for (int i = 0; i < bidList.size(); i ++) {
			if (BidID == bidList.get(i).getBidID()) {
				int index = i + 1;
				char confirm = Helper.readChar("Are you sure that you want to delete Bid ID " + index + "? (Y/N) > ");
				if (confirm == 'Y' || confirm == 'y') {
					bidList.remove(i);
					output = "You have successfully deleted Bid ID " + index;
					System.out.println(output);
					//bidList.get(i).setDeleted(true);
				}
				else if (confirm == 'N' || confirm == 'n') {
					output = "You have cancelled the delete transaction for Bid ID " + index;
					System.out.println(output);
					//bidList.get(i).setDeleted(false);
				}
				else {
					output = "Please enter valid values.";
					System.out.println(output);
					//bidList.get(i).setDeleted(false);
				}
				found = true;
			}
		}

		if (found != true) {
			output = String.format("Bid ID %d is not found.", BidID);
			System.out.println(output);
		}
		return output;
	}
}
