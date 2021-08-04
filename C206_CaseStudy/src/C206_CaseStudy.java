import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args){
		
	// array list of items depending on your class 
		//---------------------------------------------------------------- USER -----------------------------------------------------------------------------------------
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("John Lim", "johnlim@C206.com", "12345", "Buyer"));
		userList.add(new User("James Tan", "jamestan@C206.com", "67890", "Buyer"));
		userList.add(new User("Susan Chan", "susanchan@C206.com", "54321", "Seller"));
		userList.add(new User("Joan Lee", "joanlee@C206.com", "09876", "Admin"));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------
		// category dummy data
		ArrayList<category> CategoryList = new ArrayList<category>();
		CategoryList.add(new category("Sports","Football Singapore"));
		CategoryList.add(new category("Cooking","Gordan Ramsey"));
		//----------------------------------------------------------------------------------------------------------------------------------------------------------
		
		// BID
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		bidList.add(new Bid(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90));
		bidList.add(new Bid(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80));
		
    // template
    int option = 0;
    
    int OPTION_QUIT = 6;
	while(option != OPTION_QUIT){
    	
    	mainmenu();
    	option = Helper.readInt("Enter your option > ");
    	
    	if(option == 1) // part 1
    	{
    		userMenu();
    		int userChoice = Helper.readInt("Enter an option > ");
    		if (userChoice == 1) // view
    		{
    			viewAllUsers(userList);
    		}
    		else if (userChoice == 2) // add
    		{
    			User newUser = inputUser();
    			addUser(userList, newUser);
    		}
    		else if (userChoice == 3) // delete
    		{
    			C206_CaseStudy.setHeader("DELETE USER");
    			C206_CaseStudy.deleteUser(userList);
    		}
    		
    	}
    	else if (option == 2)
    	{
    		categoryMenu();
    		int categoryChoice = Helper.readInt("Enter an option > ");
    		
    		if(categoryChoice == 1)
    		{
    			Helper.line(30, "-");
    			System.out.println("CATEGORY LIST");
    			Helper.line(30, "-");
    			
    			viewAllcategories(CategoryList);
    		
    			
    		}
    		else if (categoryChoice == 2)
    		{
    			Helper.line(30, "-");
    			System.out.println("ADD CATEGORY");
    			Helper.line(30, "-");
    			
    			category newCat = inputCategory();// store inside object 
    			
    			AddCategory(CategoryList, newCat);
    			

    			
    		}
    		else if (categoryChoice == 3)
    		{
    			Helper.line(30, "-");
    			System.out.println("DELETE CATEGORY");
    			Helper.line(30, "-");
    			
    			viewAllcategories(CategoryList);
    			
    			String name = Helper.readString("Enter a category name > ");
    			
    			deleteCategory(CategoryList,name);
    			

    			
    		}
    	}
    	else if (option == 3)
    	{
    		itemMenu();
    		int itemChoice = Helper.readInt("Enter an option > ");
    		
    		if(itemChoice == 1)
    		{
    			
    		}
    		else if(itemChoice == 2)
    		{
    			
    		}
    		else if(itemChoice == 3)
    		{
    			
    		}
    	}
    	else if (option == 4)
    	{
    		bidMenu();
    		int bidChoice = Helper.readInt("Enter an option > ");
    		
    		if(bidChoice == 1)
    		{
    		// View all bid
		C206_CaseStudy.viewAllBids(bidList);
    		}
    		else if(bidChoice == 2)
    		{
    		// Add a new bid
		Bid newBid = inputBid(bidList);
		C206_CaseStudy.addNewBid(bidList, newBid);
    		}
    		else if(bidChoice == 3)
    		{
    		// Delete bid
		int BidID = removeBid(bidList);
		C206_CaseStudy.deleteMyBid(bidList, BidID);
    		}
    	}
    	else if (option == 5)
    	{
    		dealMenu();
    		int dealChoice = Helper.readInt("Enter an option > ");
    		
    		if(dealChoice== 1)
    		{
    			
    		}
    		else if(dealChoice == 2)
    		{
    			
    		}
    		else if(dealChoice == 3)
    		{
    			
    		}
    	}
    	else if ( option == OPTION_QUIT)
    	{
    		System.out.println("Goodbye");
    	}
    	else
    	{
    		System.out.println("Invalid option");
    		
    	}
    	
    }
		
				
	}
	
	// program layouts
	public static void mainmenu()
	{	
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. User functions");
		System.out.println("2. Category functions");
		System.out.println("3. Item functions");
		System.out.println("4. Bidding functions");
		System.out.println("5. Dealing functions");
		System.out.println("6. Quit App");
		Helper.line(80, "-");
	}
	public static void categoryMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all categories");
		System.out.println("2. Add an category ");
		System.out.println("3. Delete an category");
		Helper.line(80, "-");
		
	}
	public static void itemMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all items");
		System.out.println("2. Add an item");
		System.out.println("3. Delete an item");
		Helper.line(80, "-");
		
	}
	public static void bidMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all bids");
		System.out.println("2. Add a bid (based on id)");
		System.out.println("3. Delete a bid (based on id)");
		Helper.line(80, "-");
	}
	public static void dealMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all deals");
		System.out.println("2. Add a deal(based on id)");
		System.out.println("3. Delete a deal(based on id)");
		Helper.line(80, "-");
		
	}
	public static void userMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. View all users");
		System.out.println("2. Add a user");
		System.out.println("3. Delete a deal(based on email)");
		Helper.line(80, "-");
		
	}
	public static void LoginMenu()
	{
		C206_CaseStudy.setHeader("Campus Online Auction App");
		System.out.println("1. Login");
		System.out.println("2. Register"); 	
	}
	public static void setHeader(String header)
	{
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//------------------------------------------------------------------- A. Elizabeth 20020036 -----------------------------------------------------------------------------
	//======================================================================= USER OPTIONS ==================================================================================
	//========================================================================= ADD USER ====================================================================================
	public static User inputUser()
	{
		String name = Helper.readString("Enter Name >> ");
		String email = Helper.readString("Enter Email >> ");
		String password = Helper.readString("Enter Password >> ");
		String role = Helper.readString("Enter Role >> ");

		User newUser = new User(name, email, password, role);
		return newUser;
	}
	public static void addUser(ArrayList<User> userList, User newUser)
	{
		userList.add(newUser);
		System.out.println("User added.");
	}
	//====================================================================== VIEW ALL USERS =================================================================================
	public static String retrieveAllUsers(ArrayList<User> userList)
	{
		String output = "";
		
		for(int e = 0; e < userList.size(); e++)
		{
			output += String.format("%-10s %-20s %-10s\n", userList.get(e).getName(), userList.get(e).getEmail(), userList.get(e).getRole());
		}
		return output;
	}
	
	public static void viewAllUsers(ArrayList<User> userList)
	{
		C206_CaseStudy.setHeader("==================== USERS LIST ====================");
		String output = String.format("%-10s %-20s %-10s\n", "NAME", "EMAIL", "ROLE");
		output += retrieveAllUsers(userList);
		System.out.println(output);
	}
	//======================================================================= DELETE USER ===================================================================================
	public static void deleteUser(ArrayList<User> userList)
	{
		C206_CaseStudy.viewAllUsers(userList);
		String email = Helper.readString("Enter User Email > ");
		Boolean isDeleted = doDeleteUser(userList, email);
		
		if(isDeleted == false)
		{
			System.out.println("Invalid user email");
		}
		else
		{
			System.out.println("User " + email + "deleted!");
		}
	}
	
	public static boolean doDeleteUser(ArrayList<User> userList, String email)
	{
		boolean isDeleted = false;
		deleteUser(userList, email);
		return isDeleted;
	}
	
	public static String deleteUser(ArrayList<User> userList, String email) 
	{
		boolean isDeleted = false;
		String output = "";
		for (int e = 0; e < userList.size(); e++) 
		{
			if (email == userList.get(e).getEmail())
			{
				String confirm = Helper.readString("Confirm delete user " + email + "? (Yes/No) >> ");
				if (confirm.equalsIgnoreCase("Yes")) 
				{
					userList.remove(e);
					output = "You have successfully deleted user " + email;
					System.out.println(output);
					isDeleted = true;
				}
				else if (confirm.equalsIgnoreCase("No")){
					output = "You have cancelled the deletion of user " + email;
					System.out.println(output);
					isDeleted = false;
				}				
			}
			else 
			{
				output = "Please enter valid email.";
				System.out.println(output);
				isDeleted = false;
			}
		}

		if (isDeleted != true) {
			output = "Deletion of user " + email + " failed.";
			System.out.println(output);
		}
		return output;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ZANE TAN (CATEGORY)
	public static category inputCategory() // input category function
	{
		
		String Name = Helper.readString("Enter Name of category (no numbers or special characters) >> ");
		String Item = Helper.readString("Enter Item Name(no numbers or special characters) >> ");
		
	    category newCat = new category(Name,Item);

		return newCat;
	}
	public static void AddCategory(ArrayList<category> CategoryList , category newCat) 
	{
	
		if(newCat.getName().isEmpty() || newCat.getItem().isEmpty())
		{
			System.out.println("Please enter all fields that are required");
		}
		else
		{
			CategoryList.add(newCat);
			System.out.println("Category Name ( " + newCat.getName() + " ) is added.");
			System.out.println("Category Item ( " + newCat.getItem() + " ) is added.");	
		}
		
	}
	public static void viewAllcategories(ArrayList<category> CategoryList) {
		
		String output = String.format("%-10s %-20s \n", "NAME", "ITEM NAME");
		
		output += retrieveAllCategory(CategoryList);
		
		System.out.println(output);
	}
	
	public static String retrieveAllCategory(ArrayList<category> CategoryList) {
		String output = "";
		
		for(int i = 0; i < CategoryList.size();i++)
		{
			if(CategoryList.size() != 0)
			{
				output += String.format("%-10s %-20s \n", CategoryList.get(i).getName(),
						CategoryList.get(i).getItem());
			}
			else
			{
				System.out.println("There are no categories in the list");
			}
		}
		return output;
		
	}
	public static void deleteCategory(ArrayList<category> CategoryList, String name)
	{
		boolean isDeleted = false;
		
		if(name.isEmpty())
		{
			System.out.println("field is empty");
		}
		else 
		{
			for(int i = 0; i < CategoryList.size(); i++)
			{
				if(CategoryList.get(i).getName().equalsIgnoreCase(name))
				{
					System.out.println("Category (" + name + ") has been deleted !");
					CategoryList.remove(i);
					isDeleted = true;
					break;
				}
					
			}
			
		}
		if(isDeleted == false)
		{
			System.out.println("There is no such category name");
		}
	}
	
	// ========================================================================= BID REGAN =====================================================================
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
		String sellerEmail = Helper.readString("Enter Seller Email > ");
		while (sellerEmail.isEmpty()) {
			Bid.emptyFields();
			sellerEmail = Helper.readString("Enter Seller Email > ");
		}
		String buyerEmail = Helper.readString("Enter Buyer Email > ");
		while (buyerEmail.isEmpty()) {
			Bid.emptyFields();
			buyerEmail = Helper.readString("Enter Buyer Email > ");
		}
		double price = Helper.readDouble("Enter Item Price > ");
		while (price == 0) {
			Bid.emptyFields();
			price = Helper.readDouble("Enter Item Price > ");
		}
		// create object
		Bid newBid = new Bid(bidID, itemName, sellerEmail, buyerEmail, price);
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


