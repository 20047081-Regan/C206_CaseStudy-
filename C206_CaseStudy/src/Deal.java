public class Deal {
	private int id;
	private String name;
	private String sellerEmail;
	private String buyerEmail;
	private double price;
	private String closing;

	public Deal (int id, String name, String sellerEmail, String buyerEmail, double price, String closing) 
	{
		this.id = id;
		this.name = name;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.price = price;
		this.closing = closing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getClosing() {
		return closing;
	}

	public void setClosing(String closing) {
		this.closing = closing;
	}

	public static String emptyFields() {
		// TODO Auto-generated method stub
		String errorMessage = "Please fill up all fields";
		return errorMessage;
	}

}
