import java.util.ArrayList;
import java.util.regex.Pattern;

public class C206_CaseStudy {

	public static void main(String[] args){

		//------------------------------------------------------------------USER--------------------------------------------------------------------------------------
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("John Lim", "johnlim@C206.com", "12345abc", "Buyer"));
		userList.add(new User("James Tan", "jamestan@C206.com", "12345abc", "Buyer"));
		userList.add(new User("Susan Chan", "susanchan@C206.com", "12345abc", "Seller"));
		userList.add(new User("Admin", "admin@C206.com", "admin123", "Admin"));
		//----------------------------------------------------------------CATEGORIES----------------------------------------------------------------------------------
		ArrayList<category> CategoryList = new ArrayList<category>();
		CategoryList.add(new category("Sports");
		CategoryList.add(new category("Cooking");
		//-------------------------------------------------------------------BID--------------------------------------------------------------------------------------
		//=========================================================== BUYER BID ===========================================================
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		bidList.add(new Bid(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90));
		bidList.add(new Bid(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80));
		
		//=========================================================== SELLER BID ==========================================================
		ArrayList<Bid> sbidList = new ArrayList<Bid>();
		sbidList.add(new Bid(1, "Socks", "seller1@mail.com", "buyer1@mail.com", 5.10, "NIL"));
		sbidList.add(new Bid(2, "Cup", "seller1@mail.com", "buyer2@mail.com", 2.30, "NIL"));
				 
		//=========================================================== USER BID ================================================================
		ArrayList<UserBid> sellerList = new ArrayList<UserBid>();
		ArrayList<UserBid> buyerList = new ArrayList<UserBid>();
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
						LoginMenu();
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
						    			User newUser = inputUser(userList);
						    			addUser(userList, newUser);
						    		}
						    		else if (userChoice == 3) // delete
						    		{
						    			CaseStudy_CAOS.setHeader("DELETE USER");
						    			viewAllUsers(userList);
						    			String email = Helper.readString("Enter a user email > ");
						    			deleteUser(userList, email);
						    			validUser = false;
						    			LoginMenu();
						    			break;
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
									
									viewAllcategories(CategoryList);
						    			deleteCategory(CategoryList);



								}
								else if (categoryChoice == 4)
						    		{
						    			viewAllcategories(CategoryList);
						    			String name = Helper.readString("Enter existing category name > ");
						    			String UpName = Helper.readString("Enter new category name > ");
						    			
						    			
						    			if(name.isEmpty())
						    			{
						    				System.out.println("Please type in existing category name");
						    			}
						    			else if(name.equals(UpName))
						    			{
						    				System.out.println("There is already a similar category name you are updating");
						    			}
						    			else
						    			{
						    				char CatUpdate = Helper.readChar("Are you sure you want to update this category name (Y/N) > ");
						    				if(CatUpdate == 'Y' || CatUpdate == 'y')
											{
												String output = updateCategory(CategoryList,UpName,name);
								    			System.out.println(output);
												
											}
											else if(CatUpdate== 'N' || CatUpdate == 'n')
											{
												System.out.println("You have cancelled the updation of category ( " + name + " )");
												
											}
											else
											{
												System.out.println("Invalid confirmation choice");
											}
						    				
						    			}
						    					
						    				
						    		}
								else if(categoryChoice == 5)
						    		{
						    			viewAllcategories(CategoryList);
						    			String name = Helper.readString("Enter existing category name > ");
						    			
						    			ArrayList<category> filtered = searchCategory(CategoryList,name);
						    			
						    			for(int i = 0; i < filtered.size();i++)
						    			{
						    				if(!filtered.get(i).getName().isEmpty())
						    				{
						    					System.out.println(filtered.get(i).getName());
						    					
						    					
						    				}
						    			}
						    			if(filtered.isEmpty())
						    			{
						    				System.out.println("No category found after searching with partial/full name");
						    			}
						    				
						    				
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
									boolean wantLogIn = true; // to ensure the option button all is link keep looping to be able to display the login menu.
		loginMenu();
		int option = Helper.readInt("LOGIN / REGISTER > ");

		while (wantLogIn == true) {
			if (option == 1) {
				String uName = Helper.readString("Enter username > ");
				String uPassword = Helper.readString("Enter password > ");

				// TO CHECK the log in details.
				boolean isSeller = C206_CaseStudy.doSellerLogin(uName, uPassword, sellerList);
				boolean isBuyer = C206_CaseStudy.doBuyerLogin(uName, uPassword, buyerList);

				// IF LOG IN DETAILS IS FALSE, enter again.
				if (isSeller == false && isBuyer == false) {
					System.out.println("Either your username or password was incorrect. Please try again!");
					loginMenu();
					option = Helper.readInt("LOGIN / REGISTER > ");
				}


				// IF LOG IN SUCCESSFULLY.
				while (isBuyer == true) {
					//			int option = 0;
					//
					//			while (option != OPTION_QUIT) {

					C206_CaseStudy.buyerMenu();
					int choice = Helper.readInt("Enter an option > ");

					if (choice == 1) {
						// View all bid
						C206_CaseStudy.viewAllBids(bidList);
					} else if (choice == 2) {
						// Add a new bid
						Bid newBid = inputBid(bidList);
						C206_CaseStudy.addNewBid(bidList, newBid);
					} else if (choice == 3) {
						// Delete bid
						C206_CaseStudy.deleteMyBid(bidList);
					} else if (choice == 4) {
						// Update bid
						C206_CaseStudy.updateMyBid(bidList);
					}
					else if (choice == 5) {
						C206_CaseStudy.searchBids(bidList);
					}
					else if (choice == 6) {
						System.out.println("Bye! Hope to see you soon!");
						isBuyer = false;
						wantLogIn = false;
					}
					else {
						System.out.println("INVALID OPTION ENTERED.");
					}
				}
				
				while (isSeller == true) {
					C206_CaseStudy.sellerMenu();
					int choice = Helper.readInt("Enter an option > ");
					if (choice == 1) {
						// view all current bid, those that is cancel will have a cancelled status beside.
						C206_CaseStudy.viewAllSellerBids(sbidList);
					}
					else if (choice == 2) {
						// cancel bid
						C206_CaseStudy.updateCancelBid(sbidList);
					}
					else if (choice == 3) {
						// quit
						System.out.println("Bye! Hope to see you soon!");
						isSeller = false;
						wantLogIn = false;
					}
					else {
						System.out.println("INVALID OPTION ENTERED.");
					}
				}

			}
			else if (option == 2) {
				String username = Helper.readString("USERNAME > ");
				String password = Helper.readString("PASSWORD > ");

				// password validation
				String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
				boolean matched = Pattern.matches(pattern, password);
				while (matched != true) {
					System.out.println("Password must be in minimum eight characters, at least one letter and one number");
					password = Helper.readString("PASSWORD > ");
					matched = Pattern.matches(pattern, password);
				}

				String role = Helper.readString("SELLER / BUYER > ");
				if (role.equalsIgnoreCase("seller")) {
					UserBid seller = new UserBid(username, password);
					sellerList.add(seller);
					System.out.println("Account registered succesfully!");
					loginMenu();
					option = Helper.readInt("LOGIN / REGISTER > ");
				}
				else if (role.equalsIgnoreCase("buyer")) {
					UserBid buyer = new UserBid(username, password);
					buyerList.add(buyer);
					System.out.println("Account registered succesfully!");
					loginMenu();
					option = Helper.readInt("LOGIN / REGISTER > ");
				}
				else {
					System.out.println("Invalid user role.");
					loginMenu();
					option = Helper.readInt("LOGIN / REGISTER > ");
				}
			}
			else {
				System.out.println("INVALID OPTION.");
			}
		}
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
					LoginMenu();
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
	public static void sellerMenu() {
		C206_CaseStudy.setHeader("WELCOME SELLER, to Campus Online Auction Shop (COAS)");
		System.out.println("1. VIEW ALL BUYER'S BIDS");
		System.out.println("2. CANCEL BIDS");
		System.out.println("3. QUIT");
		Helper.line(80, "-");
	}
	
	public static void buyerMenu() {
		C206_CaseStudy.setHeader("WELCOME BUYER, to Campus Online Auction Shop (COAS)");
		System.out.println("1. VIEW BID");
		System.out.println("2. ADD BID");
		System.out.println("3. DELETE BID");
		System.out.println("4. UPDATE BID");
		System.out.println("5. SEARCH BID");
		System.out.println("6. QUIT");
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
		System.out.println("3. Delete a User(based on email)");
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
	public static boolean notExist(ArrayList<User> userList, String name)
	{
		boolean exist = false;
		for(int e = 0; e < userList.size(); e++)
		{
			if(userList.get(e).getName().equalsIgnoreCase(name))
			{
				exist = false;
				break;
			}
			else
			{
				exist = true;
			}
		}
		return exist;
	}
	//========================================================================= ADD USER ====================================================================================
	public static User inputUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("ADD USER");

		String name = Helper.readString("Enter Name > ");
		while (name.isEmpty() || notExist(userList, name) == false) 
		{
			User.empty();
			System.out.println("Name already exists! \nPlease choose another name.");
			name = Helper.readString("Enter Name > ");
		}
		
		String email = Helper.readString("Enter Email > ");
		while (email.isEmpty() || User.isValidEmail(email) == false) 
		{
			User.empty();
			System.out.println("Email must contain '@' and '.com'!");
			email = Helper.readString("Enter Email > ");
		}
		String password = Helper.readString("Enter Password > ");
		while (password.isEmpty() || User.isAlphaNumeric(password) == false) 
		{
			User.empty();
			System.out.println("Password must be alpha-numeric and \ncontain at least 8 characters.");
			password = Helper.readString("Enter Password > ");
		}

		String role = Helper.readString("Enter Role > ");
		while (role.isEmpty() || User.isValidRole(role) == false) 
		{
			User.empty();
			System.out.println("Role can only be \nAdmin / Seller / Buyer");
			role = Helper.readString("Enter Role > ");
		}
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
	public static String deleteUser(ArrayList<User> userList, String email) {
		boolean exists = false;
		String output = "";
		for (int i = 0; i < userList.size(); i ++) 
		{
			if (userList.get(i).getEmail().equalsIgnoreCase(email)) 
			{
				String confirm = Helper.readString("Confirm Delete User: " + email + "? (Yes/No) > ");
				if (confirm.equalsIgnoreCase("Yes")) 
				{
					userList.remove(i);
					output = "You have successfully deleted User: " + email;
					System.out.println(output);
				}
				else if (confirm.equalsIgnoreCase("No")) 
				{
					output = "You have cancelled deletion of User: " + email;
					System.out.println(output);
				}
				else 
				{
					output = "Please enter a valid email";
					System.out.println(output);
				}
				exists = true;
			}
		}

		if (exists != true) 
		{
			output = "Email " + email + " does not exist!";
			System.out.println(output);
		}
		return output;
	}
	
	public static void doDeleteUser(ArrayList<User> userList, String email)
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
		
	    category newCat = new category(Name);

		return newCat;
	}
	public static void AddCategory(ArrayList<category> CategoryList , category newCat) 
	{
		boolean addchecker = false;
		
		if(newCat.getName().isEmpty())
		{
			System.out.println("Please enter all fields that are required");
		}
		else
		{
			for(int i = 0; i < CategoryList.size();i++)
			{
				if(CategoryList.get(i).getName().equalsIgnoreCase(newCat.getName()))
				{
					addchecker = true; // if there is duplicate name
					System.out.println("Existing name found");
					break;
				}
			}
			if(addchecker == false) // if there isnt any duplicate name
			{
				
				CategoryList.add(newCat);
				System.out.println("Category Name ( " + newCat.getName() + " ) is added."); // success message
								
				
			}
			
			
		}
		
		
	}
	
	public static void viewAllcategories(ArrayList<category> CategoryList) {
		
		String output = String.format("%-10s \n", "CATEGORY NAME");
		
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
				output += String.format("%-10s \n", CategoryList.get(i).getName());
			}
			else
			{
				System.out.println("There are no categories in the list");
			}
		}
		return output;
		
	}
	public static void removeCategory(ArrayList<category> CategoryList,String name) // the function for remove
	{	
		for(int i = 0 ; i < CategoryList.size();i++)
		{
			if(CategoryList.get(i).getName().equals(name))
			{
				CategoryList.remove(i);
				System.out.println("Category (" + name + ") has been deleted !");
				
			}
		}
		
	}
	public static String deleteCategory(ArrayList<category> CategoryList)
	{
		boolean isExist = false;
		String output = "";
		
		String name = Helper.readString("Enter category name > ");
		
		for(int i = 0; i < CategoryList.size();i++)
		{
			if(CategoryList.get(i).getName().equals(name))
			{
				char CatDelete = Helper.readChar("Are you sure that you want to delete this category  (Y/N) > ");
				
				if(CatDelete == 'Y' || CatDelete == 'y')
				{
					removeCategory(CategoryList,name); // calling the function
					
				}
				else if(CatDelete == 'N' || CatDelete == 'n')
				{
					output += "You have cancelled the deletion of category ( " + name + " )";
					System.out.println(output);
				}
				isExist = true;
			}
		}
		if(isExist != true)
		{
			output = "Category ( " + name + ")  is not found";
			System.out.println(output);
		}
		return name;
	}
        public static String updateCategory(ArrayList<category> CategoryList, String UpName,String name)
	{
		String output = "";
		if(UpName.isEmpty())
		{
			output = "Please fill in the empty update name field";
		}
		else
		{
			for(int i = 0 ; i < CategoryList.size();i++)
			{
				if(CategoryList.get(i).getName().equalsIgnoreCase(name))
				{
					CategoryList.get(i).setName(UpName);
					output = "Successfully updated category name";
					break;
					
				}
			}
		}
		return output;
	}
	public static ArrayList<category> searchCategory(ArrayList<category> CategoryList, String name) // returning arraylist
	{
		ArrayList<category> filteredSearch = new ArrayList<category>();
		
		if(name.isEmpty())
		{
			System.out.println("Please fill in all the fields");
		}
		else
		{
			for(int i = 0 ; i < CategoryList.size();i++)
			{
			  if(CategoryList.get(i).getName().toUpperCase().contains(name.toUpperCase()))
			  {
				  filteredSearch.add(CategoryList.get(i));
				  System.out.println("Category filtered by partial/full name ( " + name + " )");
			  }
			  
			}
		}
		return filteredSearch;
		
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
	//=========================================================== VIEW =============================================================
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

	//=========================================================== ADD =============================================================
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

	//=========================================================== DELETE ===========================================================
	public static int deleteMyBid(ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("DELETE MY BID");
		String output = "";
		boolean found = false;
		int bidID = Helper.readInt("Enter Bid ID > ");
		
		for (int i = 0; i < bidList.size(); i ++) {
			if (bidID == bidList.get(i).getBidID()) {
				char confirm = Helper.readChar("Are you sure that you want to delete Bid ID " + bidID + "? (Y/N) > ");
				if (confirm == 'Y' || confirm == 'y') {
					removeBid(bidList, bidID);
					//bidList.get(i).setDeleted(true);
				}
				else if (confirm == 'N' || confirm == 'n') {
					output = "You have cancelled the delete transaction for Bid ID " + bidID;
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
			output = String.format("Bid ID %d is not found.", bidID);
			System.out.println(output);
		}
		return bidID;
	}
	
	public static void removeBid(ArrayList<Bid> bidList, int bidID) {
		int index = bidID - 1;
		bidList.remove(index);
		String output = "You have successfully deleted Bid ID " + bidID;
		System.out.println(output);
	}
	
	//=========================================================== UPDATE ===========================================================
	public static int updateMyBid (ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("UPDATE MY BID");
		int bidID = Helper.readInt("Enter Bid ID > ");
		boolean found = false;
		String output = "";
		
		for (int i = 0; i < bidList.size(); i ++) {
			if (bidID == bidList.get(i).getBidID()) {
				String itemName = bidList.get(i).getItemName();
				String sellerEmail = bidList.get(i).getSellerEmail();
				String buyerEmail = bidList.get(i).getBuyerEmail();
				double price = bidList.get(i).getBidPrice();
				output = "Item name > " + itemName + "\nSeller email > " + sellerEmail + "\nBuyer email > " + buyerEmail + "\nCURRENT bid price: " + price;
				System.out.println(output);

				char confirm = Helper.readChar("Are you sure that you want to update Bid ID " + bidID + "? (Y/N) > ");
				if (confirm == 'y' || confirm == 'Y') {
					double newPrice = Helper.readDouble("Enter NEW bid Price > ");
					while (newPrice == 0) {
						output = "Please enter a valid bid price.";
						System.out.println(output);
						newPrice = Helper.readDouble("Enter NEW bid Price > ");
					}
					if (newPrice <= price) {
						output = "Buyer cannot set price lower than or equal to the current bid price.";
						System.out.println(output);
					}
					else {
						updateBid(bidList, bidID, newPrice);
					}
				}
				else if (confirm == 'N' || confirm == 'n') {
					output = "You have cancelled the update transaction for Bid ID " + bidID;
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
			output = String.format("Bid ID %d is not found.", bidID);
			System.out.println(output);
		}

		return bidID;
	}
	
	public static void updateBid(ArrayList<Bid> bidList, int bidID, double newPrice) {
		int index = bidID - 1;
		bidList.get(index).setBidPrice(newPrice);
		String output = "You have successfully updated Bid ID " + bidID;
		System.out.println(output);
	}

	//=========================================================== SEARCH ===========================================================
	public static String searchAllBid(ArrayList<Bid> bidList) {
		String output = "";
		boolean found = false;
		searchMenu();
		int option = Helper.readInt("Enter > ");
		if (option == 1) {
			String itemName = Helper.readString("Enter Item Name: ");
			while (itemName == "") {
				System.out.println("Please do not submit empty fields.");
				itemName = Helper.readString("Enter Item Name: ");
			}
			for (int i = 0; i < bidList.size(); i++) {
				String itemN = itemName.toLowerCase();
				String stored = bidList.get(i).getItemName().toLowerCase();
				if (stored.contains(itemN)) {
					output += String.format("%-10s %-25s %-20s %-20s %.2f\n", bidList.get(i).getBidID(), bidList.get(i).getItemName(), bidList.get(i).getSellerEmail(), bidList.get(i).getBuyerEmail(), bidList.get(i).getBidPrice());
					found = true;
				}
			}
		}
		else if (option == 2) {
			String sellerE = Helper.readString("Enter Seller Email: ");
			while (sellerE == "") {
				System.out.println("Please do not submit empty fields.");
				sellerE = Helper.readString("Enter Item Name: ");
			}
			for (int i = 0; i < bidList.size(); i++) {
				String sellerMail = sellerE.toLowerCase();
				String stored = bidList.get(i).getSellerEmail().toLowerCase();
				if (stored.contains(sellerMail)) {
					output += String.format("%-10s %-25s %-20s %-20s %.2f\n", bidList.get(i).getBidID(), bidList.get(i).getItemName(), bidList.get(i).getSellerEmail(), bidList.get(i).getBuyerEmail(), bidList.get(i).getBidPrice());
					found = true;
				}
			}
		}
		else {
			output = "Invalid option entered.";
		}
		if (found == false) {
			output = "No result found.";
		}
		return output;
	}

	public static void searchBids(ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("SEARCH MY BIDS");
		String output = "";
		if (bidList.isEmpty()) {
			output = "You have no existing bids at the moment.";
		}
		else {
			output = String.format("%-10s %-25s %-20s %-20s %-10s\n", "BID ID", "ITEM NAME", "SELLER EMAIL", "BUYER EMAIL", "BID PRICE");
			output += searchAllBid(bidList);
		}
		System.out.println(output);
	}

	public static void searchMenu() {
		System.out.println("DO YOU WANT TO SEARCH BY...");
		System.out.println("1. ITEM NAME");
		System.out.println("2. SELLER EMAIL");
	}
	
	// ********************************************************** SELLER ************************************************************
	
	//=========================================================== VIEW ===========================================================
	public static String retrieveAllSellerBid(ArrayList<Bid> sbidList) {
		String output = "";

		for (int i = 0; i < sbidList.size(); i++) {
			output += String.format("%-10s %-25s %-20s %-20s %-20.2f %s\n", sbidList.get(i).getBidID(), sbidList.get(i).getItemName(), sbidList.get(i).getSellerEmail(), sbidList.get(i).getBuyerEmail(), sbidList.get(i).getBidPrice(), sbidList.get(i).getStatus());
		}
		return output;
	}
	public static void viewAllSellerBids(ArrayList<Bid> sbidList) {
		C206_CaseStudy.setHeader("VIEW ALL BUYER'S BIDS");
		String output = "";
		if (sbidList.isEmpty()) {
			output = "You have no existing bids at the moment.";
		}
		else {
			output = String.format("%-10s %-25s %-20s %-20s %-20s %s\n", "BID ID", "ITEM NAME", "SELLER EMAIL", "BUYER EMAIL", "BID PRICE", "STATUS");
			output += retrieveAllSellerBid(sbidList);
		}
		System.out.println(output);
	}
	

	//======================================================== UPDATE CANCEL ===========================================================
	public static int updateCancelBid (ArrayList<Bid> sbidList) {
		C206_CaseStudy.setHeader("UPDATE MY BID");
		int bidID = Helper.readInt("Enter Bid ID > ");
		boolean found = false;
		String output = "";
		for (int i = 0; i < sbidList.size(); i ++) {
			if (bidID == sbidList.get(i).getBidID()) {
				String itemName = sbidList.get(i).getItemName();
				String sellerEmail = sbidList.get(i).getSellerEmail();
				String buyerEmail = sbidList.get(i).getBuyerEmail();
				double price = sbidList.get(i).getBidPrice();
				output = "Item name > " + itemName + "\nSeller email > " + sellerEmail + "\nBuyer email > " + buyerEmail + "\nCURRENT bid price: " + price;
				System.out.println(output);

				char confirm = Helper.readChar("Are you sure that you want to cancel Bid ID " + bidID + "? (Y/N) > ");
				if (confirm == 'y' || confirm == 'Y') {
					cancelBid(sbidList, bidID);
				}
				else if (confirm == 'N' || confirm == 'n') {
					output = "You have cancelled the cancel transaction for Bid ID " + bidID;
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
			output = String.format("Bid ID %d is not found.", bidID);
			System.out.println(output);
		}

		return bidID;
	}
	
	public static void cancelBid(ArrayList<Bid> sbidList, int bidID) {
		int index = bidID - 1;
		sbidList.get(index).setStatus("CANCELLED");
		System.out.println("You have successfully cancelled Bid ID " + bidID);
	}

	//=========================================================== SELLER LOGIN ===========================================================
	public static boolean doSellerLogin(String uName, String uPassword, ArrayList<UserBid> sellerList)  {
		boolean valid = false;
		for (int i = 0; i < sellerList.size(); i ++) {
			if (uName.equalsIgnoreCase(sellerList.get(i).getName()) && uPassword.equalsIgnoreCase(sellerList.get(i).getPassword())) {
				valid = true;
			}
			else {
				valid = false;
			}
		}
		return valid;
	}

	//=========================================================== BUYER LOGIN ===========================================================
	public static boolean doBuyerLogin(String uName, String uPassword, ArrayList<UserBid> buyerList) {
		boolean valid = false;
		for (int i = 0; i < buyerList.size(); i ++) {
			if (uName.equalsIgnoreCase(buyerList.get(i).getName()) && uPassword.equalsIgnoreCase(buyerList.get(i).getPassword())) {
				valid = true;
			}
			else {
				valid = false;
			}
		}
		return valid;
	}

	//=========================================================== LOGIN MENU ===========================================================
	public static void loginMenu() {
		Helper.line(30, "-");
		System.out.println("WELCOME");
		Helper.line(30, "-");
		System.out.println("1. LOGIN");
		System.out.println("2. REGISTER");
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


