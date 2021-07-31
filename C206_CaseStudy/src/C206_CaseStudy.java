import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args){
		
	// array list of items depending on your class 
		
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
    			
    		}
    		else if (userChoice == 2) // add
    		{
    			
    		}
    		else if (userChoice == 3) // delete
    		{
    			
    		}
    		
    	}
    	else if (option == 2)
    	{
    		categoryMenu();
    		int categoryChoice = Helper.readInt("Enter an option > ");
    		
    		if(categoryChoice == 1)
    		{
    			
    		}
    		else if (categoryChoice == 2)
    		{
    			
    		}
    		else if (categoryChoice == 3)
    		{
    			
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
    			
    		}
    		else if(bidChoice == 2)
    		{
    			
    		}
    		else if(bidChoice == 3)
    		{
    			
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
}


