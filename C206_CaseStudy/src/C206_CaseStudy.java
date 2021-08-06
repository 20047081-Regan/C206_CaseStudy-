import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args){
		
		//------------------------------------------------------------------USER--------------------------------------------------------------------------------------
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("John Lim", "johnlim@C206.com", "12345", "Buyer"));
		userList.add(new User("James Tan", "jamestan@C206.com", "67890", "Buyer"));
		userList.add(new User("Susan Chan", "susanchan@C206.com", "54321", "Seller"));
		userList.add(new User("Joan Lee", "joanlee@C206.com", "09876", "Admin"));
		//----------------------------------------------------------------CATEGORIES----------------------------------------------------------------------------------
		ArrayList<category> CategoryList = new ArrayList<category>();
		CategoryList.add(new category("Sports","Football Singapore"));
		CategoryList.add(new category("Cooking","Gordan Ramsey"));
		//-------------------------------------------------------------------BID--------------------------------------------------------------------------------------
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		bidList.add(new Bid(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90));
		bidList.add(new Bid(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80));
		//-------------------------------------------------------------------DEAL-------------------------------------------------------------------------------------
		ArrayList<Deal> dealList = new ArrayList<Deal>();
		dealList.add(new Deal(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90, "01/01/2021"));
		dealList.add(new Deal(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80, "02/02/2021"));
		//-------------------------------------------------------------------ITEM--------------------------------------------------------------------------------------
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("Sony Laptop", "Sony Inspiron13", 100, "2021-08-03", "2021-08-04", 1));
		itemList.add(new Item("Dell Laptop", "Dell Inspiron14", 150, "2021-08-05", "2021-08-06", 1));
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		while(true)
		{ 
			LoginMenu();
			int loginOption = 0;
			
			int loginInvalid = 3;
			
			while (loginOption != loginInvalid)
			{
				loginOption = Helper.readInt("Enter an login option > ");
				
				if(loginOption == 1)
				{
					String uName = Helper.readString("Enter username > ");
					String uPassword = Helper.readString("Enter password > ");
					
					boolean validUser = C206_CaseStudy.dologin(userList,uName, uPassword);
					
					if(validUser == false)
					{
						System.out.println("Either your name or password was incorrect. Please try again!");
					}
					while(validUser)
					{
						
						 int option = 0;
						
						 
					
						    int OPTION_QUIT = 6;
							while(option != OPTION_QUIT){
						    	
						    	mainmenu();
						    	option = Helper.readInt("Enter your option > ");
				                 ///////////////////ELIZABETH/////////////////////////////////////
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
						    			viewAllUsers(userList);
						    			String email = Helper.readString("Enter a user email > ");
						    			deleteUser(userList, email);	
						    		}
						    		
						    	}
						    	/////////////////// ZANE /////////////////////////////////////
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
				                ///////////////////YIN MINN/////////////////////////////////////
						    	else if (option == 3)
						    	{
						    		itemMenu();
						    		int itemChoice = Helper.readInt("Enter an option > ");
						    		
						    		if(itemChoice == 1)
						    		{
						    			Helper.line(30,  "-");
						    	        System.out.println("ITEM LIST");
						    	        Helper.line(30,  "-");
						    	          
						    	        viewAllItems(itemList);
						    			
						    		}
						    		else if(itemChoice == 2)
						    		{
						    			Helper.line(30,  "-");
						    	        System.out.println("ADD ITEM");
						    	        Helper.line(30,  "-");
						    	          
						    	        Item newItem = inputItem();
						    	         addItem(itemList, newItem);
						    			
						    		}
						    		else if(itemChoice == 3)
						    		{
						    			Helper.line(30,  "-");
						    	        System.out.println("DELETE ITEM");
						    	        Helper.line(30,  "-");
						    	          
						    	        viewAllItems(itemList);
						    	        String name = Helper.readString("Enter an item name: ");
						    	        deleteItem(itemList, name);
						    			
						    		}
						    	}
						    	 ///////////////////REGAN/////////////////////////////////////
						    	else if (option == 4)
						    	{
						    		bidMenu();
						    		int bidChoice = Helper.readInt("Enter an option > ");
						    		
						    		if(bidChoice == 1)
						    		{

						    	        C206_CaseStudy.viewAllBids(bidList);
								

						    		}
						    		else if(bidChoice == 2)
						    		{

						    		 Bid newBid = inputBid(bidList);
						    		 C206_CaseStudy.addNewBid(bidList, newBid);

						    		}
						    		else if(bidChoice == 3)
						    		{
						                 viewAllBids(bidList);
						    		 int BidID = removeBid(bidList);
						    		 C206_CaseStudy.deleteMyBid(bidList, BidID);
						    			
								
						    		}
						    	}
						    	 ///////////////////SHAO CHUN/////////////////////////////////////
						    	else if (option == 5)
						    	{
						    		dealMenu();
						    		int dealChoice = Helper.readInt("Enter an option > ");
						    		
						    		if(dealChoice== 1)
						    		{
						    			// View all bid
									viewAllDeals(dealList);
						    			
						    		}
						    		else if(dealChoice == 2)
						    		{
						    			// Add a new bid
								       Deal newDeal = inputDeal(dealList);
								       addNewDeal(dealList, newDeal);
						    			
						    		}
						    		else if(dealChoice == 3)
						    		{
						    			// Delete bid
						    			viewAllDeals(dealList);
									int dealID = removeDeal(dealList);
									deleteDeal(dealList, dealID);
						    			
						    		}
						    		
						    	}
						    	else if (option == OPTION_QUIT)
						    	{
						    		System.out.println("Goodbye");
						    		validUser = false;
						    		LoginMenu();
						   
						    		
						    	}
						    	else
						    	{
						    		System.out.println("Invalid option");
						    		
						    	}
							}
							
					}
					
				}
				else if(loginOption == 2)
				{
					User newUser = inputUser();
	    			addUser(userList, newUser);
			        
				}
				else if(loginOption == loginInvalid)
				{
				   System.out.println("Goodbye");
				   
				  
				}
				else
				{
				   System.out.println("Invalid option");
				}
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
	public static void adminMenu()
	{

	      Helper.line(30, "-");
	      System.out.println("Campus Online Auction App -ADMIN");
	      Helper.line(30, "-");

	      System.out.println("1. View all students");
	      System.out.println("2. Add new student");
	      System.out.println("3. Delete student");
	      System.out.println("4. Log out");

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
		System.out.println("3. Quit");
		
	}
	public static void setHeader(String header)
	{
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static boolean dologin(ArrayList<User> UserList, String uName, String uPassword) 
	{
		boolean isLogin = false;
		
		for(int i = 0 ; i < UserList.size();i++)
		{
			if(UserList.get(i).getName().equalsIgnoreCase(uName) && UserList.get(i).getPassword().equalsIgnoreCase(uPassword))
			{
				isLogin = true;
				break;
			}
			
		}
		return isLogin;	

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
	public static void deleteUser(ArrayList<User> userList, String email)
	  {
	    boolean isDeleted = false;
	    
	    if(email.isEmpty())
	    {
	      System.out.println("Field is empty");
	    }
	    else 
	    {
	      for(int i = 0; i < userList.size(); i++)
	      {
	        if(userList.get(i).getEmail().equalsIgnoreCase(email))
	        {
	          System.out.println("User (" + email + ") has been deleted !");
	          userList.remove(i);
	          isDeleted = true;
	          break;
	        }
	          
	      }
	      
	    }
	    if(isDeleted == false)
	    {
	      System.out.println("There is no such user email.");
	    }
	  }
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ZANE TAN (CATEGORY)
	// input category function
	public static category inputCategory() 
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
	// retrieve categories
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
	// delete category
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
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //YIN MINN (ITEM)
	//Input item
	public static Item inputItem() {    
	    String name = Helper.readString("Enter an item name: ");
	    String description = Helper.readString("Enter description: ");
	    Integer minimumBidPrice = Helper.readInt("Enter minimum bid price: ");
	    String auctionStartDate = Helper.readString("Enter auction start date(yyyy/mm/dd): ");
	    String auctionEndDate = Helper.readString("Enter auction end date(yyyy/mm/dd): ");
	    Integer bidIncrement = Helper.readInt("Enter bid increment: ");
	    
	    Item newItem = new Item(name, description, minimumBidPrice, auctionStartDate, auctionEndDate, bidIncrement);
	    return newItem;
	  }
	  
	  //Add item
	  public static void addItem(ArrayList<Item> itemList, Item newItem) {
	  
	    itemList.add(newItem);
	    System.out.println("Item added.");
	  }
	//View items
	  public static void viewAllItems(ArrayList<Item> itemList) 
	  {
	    
	    String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "NAME", "DESCRIPTION", "MINIMUM BID PRICE", "AUCTION START DATE", "AUCTION END DATE", "BID INCREMENT");
	    output += retrieveAllItems(itemList);
	    System.out.println(output);
	  }
	  
	  
	  public static String retrieveAllItems(ArrayList<Item> itemList) {
	       
	    String output = "";
	    
	    for(int i = 0; i < itemList.size(); i++)
	    {
	      output += String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", itemList.get(i).getName(), itemList.get(i).getDescription(), itemList.get(i).getMinimumBidPrice(), itemList.get(i).getAuctionStartDate(), itemList.get(i).getAuctionEndDate(), itemList.get(i).getBidIncrement());
	    }
	    return output;
	    
	  }
	  
	  //Delete item
	  public static void deleteItem(ArrayList<Item> itemList, String name) {
	    
	    boolean isDeleted = false;
	    
	    if(name.isEmpty()) {
	      System.out.println("Field is empty");
	    }
	    else {
	      for (int i = 0; i < itemList.size(); i++) {
	        if (itemList.get(i).getName().equalsIgnoreCase(name)) {
	          
	          System.out.println(name + " has been deleted!");
	          itemList.remove(i);
	          isDeleted = true;
	          break;
	        }
	      }
	    }
	    if (isDeleted == false) {
	      
	      System.out.println("The item name does not exist.");
	    }
	  }
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // REGAN (BIDDING)
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
		// check seller email validation.
		String pattern = "^(.+)@(.+)$";
		boolean matched = Pattern.matches(pattern, sellerEmail);
		while (matched != true) {
			System.out.println("Invalid email entered.");
			sellerEmail = Helper.readString("Enter Seller Email > ");
			matched = Pattern.matches(pattern, sellerEmail);
		}
		String buyerEmail = Helper.readString("Enter Buyer Email > ");
		while (buyerEmail.isEmpty()) {
			Bid.emptyFields();
			buyerEmail = Helper.readString("Enter Buyer Email > ");
		}
		// check buyer email validation.
		matched = Pattern.matches(pattern, buyerEmail);
		while (matched != true) {
			System.out.println("Invalid email entered.");
			buyerEmail = Helper.readString("Enter Buyer Email > ");
			matched = Pattern.matches(pattern, buyerEmail);
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
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// SHAOCHUN (DEAL)
		public static String retrieveAllDeal(ArrayList<Deal> dealList) {
			String output = "";

			for (int i = 0; i < dealList.size(); i++) {
				output += String.format("%-10s %-25s %-20s %-20s %-20.2f %s\n", dealList.get(i).getId(), dealList.get(i).getName(), dealList.get(i).getSellerEmail(), dealList.get(i).getBuyerEmail(), dealList.get(i).getPrice(), dealList.get(i).getClosing());
			}
			return output;
		}
		public static void viewAllDeals(ArrayList<Deal> dealList) {
			C206_CaseStudy.setHeader("VIEW ALL DEALS");
			String output = "";
			if (dealList.isEmpty()) {
				output = "You have no existing deals at the moment.";
			}
			else {
				output = String.format("%-10s %-25s %-20s %-20s %-20s %s\n", "DEAL ID", "ITEM NAME", "SELLER EMAIL", "BUYER EMAIL", "TRANSACTION PRICE", "CLOSING DATE");
				output += retrieveAllDeal(dealList);
			}
			System.out.println(output);
		}

		// ADD
		public static Deal inputDeal(ArrayList<Deal> dealList) {
			C206_CaseStudy.setHeader("ADD DEAL");
			int dealID = dealList.size() + 1;
			String itemName = Helper.readString("Enter Item Name > ");
			while (itemName.isEmpty()) {
				Deal.emptyFields();
				itemName = Helper.readString("Enter Item Name > ");
			}
			String sellerEmail = Helper.readString("Enter Seller Email > ");
			while (sellerEmail.isEmpty()) {
				Deal.emptyFields();
				sellerEmail = Helper.readString("Enter Seller Email > ");
			}
			String buyerEmail = Helper.readString("Enter Buyer Email > ");
			while (buyerEmail.isEmpty()) {
				Deal.emptyFields();
				buyerEmail = Helper.readString("Enter Buyer Email > ");
			}
			double price = Helper.readDouble("Enter Item Price > ");
			while (price == 0) {
				Deal.emptyFields();
				price = Helper.readDouble("Enter Item Price > ");
			}
			String closing = Helper.readString("Enter Closing Date > ");
			while (closing.isEmpty()) {
				Deal.emptyFields();
				closing = Helper.readString("Enter Buyer Email > ");
			}
			// create object
			Deal newDeal = new Deal(dealID, itemName, sellerEmail, buyerEmail, price, closing);
			return newDeal;
		}
		public static void addNewDeal(ArrayList<Deal> dealList, Deal newDeal) {
			// add object into arrayList.
			dealList.add(newDeal);
			System.out.println("Congratulations! You have successfully add deal!");
		}

		// DELETE
		public static int removeDeal(ArrayList<Deal> dealList) {
			C206_CaseStudy.setHeader("DELETE DEAL");
			int dealID = Helper.readInt("Enter DEAL ID > ");
			return dealID;
		}

		public static String deleteDeal(ArrayList<Deal> dealList, int dealID)
		{
			boolean found = false;
			String output = "";
			for (int i = 0; i < dealList.size(); i ++) {
				if (dealID == dealList.get(i).getId()) {
					int index = i + 1;
					char confirm = Helper.readChar("Are you sure that you want to delete Deal ID " + index + "? (Y/N) > ");
					if (confirm == 'Y' || confirm == 'y') {
						dealList.remove(i);
						output = "You have successfully deleted Deal ID " + index;
						System.out.println(output);
					}
					else if (confirm == 'N' || confirm == 'n') {
						output = "You have cancelled the delete transaction for Deal ID " + index;
						System.out.println(output);
					}
					else {
						output = "Please enter valid values.";
						System.out.println(output);
					}
					found = true;
				}
			}

			if (found != true) {
				output = String.format("Deal ID %d is not found.", dealID);
				System.out.println(output);
			}
			return output;
	   }
		
		
		

		
		

}


