public class Bid {
	private int bidID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double bidPrice;
	private String status;
	
	public Bid(int bidID, String itemName, String sellerEmail, String buyerEmail, double bidPrice) {
		this.bidID = bidID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
	}
	
	public Bid(int bidID, String itemName, String sellerEmail, String buyerEmail, double bidPrice, String status) {
		this.bidID = bidID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBidID(int bidID) {
		this.bidID = bidID;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public void setBidPrice(double bidPrice) {
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
