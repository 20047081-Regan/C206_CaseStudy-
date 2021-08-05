public class Item {
	private String name;
	private String description;
	private Integer minimumBidPrice;
	private String auctionStartDate;
	private String auctionEndDate;
	private Integer bidIncrement;

	public Item(String name, String description, Integer minimumBidPrice, String auctionStartDate, String auctionEndDate,
	Integer bidIncrement) {
	super();
	this.name = name;
	this.description = description;
	this.minimumBidPrice = minimumBidPrice;
	this.auctionStartDate = auctionStartDate;
	this.auctionEndDate = auctionEndDate;
	this.bidIncrement = bidIncrement;
	}



	public String getName() {
	return name;
	}



	public void setName(String name) {
	this.name = name;
	}



	public String getDescription() {
	return description;
	}



	public void setDescription(String description) {
	this.description = description;
	}



	public Integer getMinimumBidPrice() {
	return minimumBidPrice;
	}



	public void setMinimumBidPrice(Integer minimumBidPrice) {
	this.minimumBidPrice = minimumBidPrice;
	}



	public String getAuctionStartDate() {
	return auctionStartDate;
	}



	public void setAuctionStartDate(String auctionStartDate) {
	this.auctionStartDate = auctionStartDate;
	}



	public String getAuctionEndDate() {
	return auctionEndDate;
	}



	public void setAuctionEndDate(String auctionEndDate) {
	this.auctionEndDate = auctionEndDate;
	}



	public Integer getBidIncrement() {
	return bidIncrement;
	}



	public void setBidIncrement(Integer bidIncrement) {
	this.bidIncrement = bidIncrement;
	}




	



}

