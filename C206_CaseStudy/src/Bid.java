public class Bid {
	private int bidID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double bidPrice;
	
	public Bid(int bidID, String itemName, String sellerEmail, String buyerEmail, double bidPrice) {
		this.bidID = bidID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
	}
	
	public int getBidID() {
		return bidID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public static String emptyFields() {
		String errorMessage = "Please fill up all fields";
		return errorMessage;
	}
	
}