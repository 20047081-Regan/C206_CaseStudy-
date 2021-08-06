import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Bid bid1;
	private Bid bid2;
	private category cat1;
	private category cat2;
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private Deal deal1;
	private Deal deal2;
	private Item item1;
	private Item item2;
	

	private ArrayList<Bid> bidList;
	private ArrayList<category> CategoryList;
	private ArrayList<User> userList;
	private ArrayList<Deal> dealList;
	private ArrayList<Item> itemList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		//==============================================================BID============================================================
		bidList = new ArrayList<Bid>();
		bid1 = new Bid(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90);
		bid2 = new Bid(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com",10.80);
		//==============================================================USER===========================================================
		userList = new ArrayList<User>();
		u1 = new User("John Lim", "johnlim@C206.com", "12345", "Buyer");
		u2 = new User("James Tan", "jamestan@C206.com", "67890", "Buyer");
		u3 = new User("Susan Chan", "susanchan@C206.com", "54321", "Seller");
		u4 = new User("Joan Lee", "joanlee@C206.com", "09876", "Admin");
		//=============================================================CATEGORY========================================================
		CategoryList = new ArrayList<category>();
		cat1 = new category("Sports","Football with the league");
		cat2 = new category("Baking","cakes with shakes");
		//===============================================================DEAL==========================================================
		dealList = new ArrayList<Deal>();
		deal1 = new Deal(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90, "01/01/2021");
		deal2 = new Deal(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80, "02/02/2021");
		//===============================================================ITEM==========================================================
		itemList = new ArrayList<Item>();
	    item1 = new Item("Sony Laptop", "Sony Inspiron13", 100, "2021-08-03", "2021-08-04", 1);
	    item2 = new Item("Dell Laptop", "Dell Inspiron14", 150, "2021-08-05", "2021-08-06", 1);

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}
	@Test 
	// REGAN LEE
	public void testAddBid() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid bid arraylist to add to", bidList);

		// Given an empty bid list, after add one item, the size of the list is 1.
		C206_CaseStudy.addNewBid(bidList, bid1);		
		assertEquals("Test if that bid arraylist size is 1?", 1, bidList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that bid is added same as 1st item of the list?", bid1, bidList.get(0));

		// Test that the field submitted is not null.
		assertNotNull(bid1.getBidPrice());
		assertNotNull(bid1.getBuyerEmail());
		assertNotNull(bid1.getItemName());
		assertNotNull(bid1.getSellerEmail());

		// Test that an error message will be displayed after submitting if there are empty fields.
		// Test that a successful message will be displayed after submitting, if there are no empty fields.
	}

	@Test
	public void testRetrieveAllBid() {
		// Test if Item list is not null, so can be displayed
		assertNotNull("Test if there is valid bid arraylist to be displayed", bidList);

		// Test if the list of bids retrieved from the list is empty
		String allBids = C206_CaseStudy.retrieveAllBid(bidList);
		String testOutput = "";
		assertEquals(testOutput, allBids);
		//		String notFound = "You have no existing bids at the moment.";
		//		assertSame(notFound,C206_CaseStudy.viewAllBids(bidList));
		//		assertTrue(displayError());

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addNewBid(bidList, bid1);
		C206_CaseStudy.addNewBid(bidList, bid2);
		assertEquals("Test if that bid arraylist size is 2?", 2, bidList.size());

		// Test if the expected output string same as the list of bid retrieved from the bidList.
		String allBid = C206_CaseStudy.retrieveAllBid(bidList);
		testOutput = String.format("%-10s %-25s %-20s %-20s %.2f\n", 1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90);
		testOutput += String.format("%-10s %-25s %-20s %-20s %.2f\n",2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80);
		assertEquals(testOutput, allBid);
	}


	@Test
	public void testDeleteBid() {
		// Test that the list is not null so that there is something for us to delete
		assertNotNull("Test that the list is not null so that there is something for us to delete", bidList);

		// Test that after deleting 1 item, the size of the array is 0.
		C206_CaseStudy.deleteMyBid(bidList, bid1.getBidID());
		assertEquals(0, bidList.size());

		// Test that a successful message will be displayed after deleting successfully.
		// Test that the bid will be removed from the bid list.
	}
	
	//------------------------------------------------------------------------- A.Elizabeth 20020036 ------------------------------------------------------------------------
	//============================================================================ @Test ---> USER ==========================================================================
	@Test
	public void testAddUser()
	{
		// userList is not null, so that can add a new user
		assertNotNull("Test if there is a valid userList arrayList to add to", userList);
		
		// Given an empty list, after adding 1 user, is the size of the list 1?
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Test if User arrayList size is 1?", 1, userList.size());
		
		// Is the user just added the same as the first user of the list?
		assertSame("Test if user added is the same as 1st user of the list?", u1, userList.get(0));
		
		// Add more users and test if the size of userList is 5?
		C206_CaseStudy.addUser(userList, u2);
		C206_CaseStudy.addUser(userList, u3);
		C206_CaseStudy.addUser(userList, u4);
		assertEquals("Test if User arrayList size is 4.", 4, userList.size());
		
		
	}
	
	@Test
	public void testRetrieveAllUsers()
	{
		// Test if the userList is not null but empty, so that new user can be added.
		assertNotNull("Test if there is valid User arrayList to add to", userList);
		
		// Test if the list of users retrieved from the CaseStudy is empty
		String allUsers = C206_CaseStudy.retrieveAllUsers(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUsers", testOutput, allUsers);
		
		// Given an empty list, after adding 4 items, test if the size of the list is 4
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		C206_CaseStudy.addUser(userList, u3);
		C206_CaseStudy.addUser(userList, u4);
		assertEquals("Test if that User arrayList size is 4?", 4, userList.size());
		
		// Test if the expected out put string is same as the list of users retrieved from the CaseStudy
		allUsers = C206_CaseStudy.retrieveAllUsers(userList);
		
		testOutput = String.format("%-10s %-20s %-10s\n", "John Lim", "johnlim@C206.com", "Buyer");
		testOutput += String.format("%-10s %-20s %-10s\n", "James Tan", "jamestan@C206.com", "Buyer");
		testOutput += String.format("%-10s %-20s %-10s\n", "Susan Chan", "susanchan@C206.com", "Seller");
		testOutput += String.format("%-10s %-20s %-10s\n", "Joan Lee", "joanlee@C206.com", "Admin");

		assertEquals("Check ViewAllUsers", testOutput, allUsers);	 
	}
	
	@Test
	  public void testDoDeleteUser()
	  {
	    assertNotNull("Test that the userList is not null", userList);
	    
	    C206_CaseStudy.addUser(userList, u1);
	    C206_CaseStudy.addUser(userList, u2);
	    
	    assertEquals("Test that userList size is 2", 2, userList.size());
	    
	    assertTrue(userList.get(0).equals(u1));
	    C206_CaseStudy.deleteUser(userList, "johnlim@C206.com");
	    assertFalse(userList.get(0).equals(u1));
	  }
	//@Test
	// ZANE TAN
	public void testAddCategory() {
		
		//check if category list is not null but empty and can be added to 
		assertNotNull("Check if there is a valid Category arraylist to add to ", CategoryList);
		
		// Given an empty list, after adding 1 new category, is the size of the list 1?
		C206_CaseStudy.AddCategory(CategoryList, cat1);
		assertEquals("Test if category arrayList size is 1?", 1, CategoryList.size());
		
		// check if the object matches the added object index in the arraylist
		assertSame("Check that category 1 is added", cat1, CategoryList.get(0));
		
	    
	    //test that fields are not null for name and item
	    assertNotNull(cat1.getName());
	    assertNotNull(cat1.getItem());
	    
	    // Given an empty list, after adding 1 more  new category, is the size of the list 2?
	    C206_CaseStudy.AddCategory(CategoryList, cat2);
		assertEquals("Test if category arraylist size is 2", 2, CategoryList.size());
		assertSame("Test that Category 2 is added", cat2, CategoryList.get(1));
		
		// test that error message is submitted if empty fields is submitted
		// Test that a successful message will be displayed after adding category successfully.
	}
		
	@Test
	public void testRetrieveAllCategory() 
	{
		// Test if categorylist is not null but empty -boundary
		assertNotNull("Test if there is valid category arraylist to retrieve item", CategoryList);
				
		//test if the list of category retrieved from the case study file is empty - boundary
		String allCategories= C206_CaseStudy.retrieveAllCategory(CategoryList);
		String testOutput = "";
		assertEquals("Check that category arraylist ", testOutput, allCategories);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
	    C206_CaseStudy.AddCategory(CategoryList, cat1);
	    C206_CaseStudy.AddCategory(CategoryList, cat2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, CategoryList.size());
				
		//test if the expected output string same as the list of category retrieved from the case study file
		allCategories = C206_CaseStudy.retrieveAllCategory(CategoryList);
		testOutput = String.format("%-10s %-20s \n","Sports","Football with the league");
		testOutput += String.format("%-10s %-20s \n","Baking","cakes with shakes");
		
		// check if the objects aded inside are similar to the objects in test output
		assertEquals("Check the objects inside the category list", testOutput, allCategories);
		
	}

	@Test
	public void testDeleteCategory() 
	{
		
		// check that there is a list of 
        assertNotNull("Test that the CategoryList is not null and there are things to delete", CategoryList);
        
		C206_CaseStudy.AddCategory(CategoryList, cat1);
		C206_CaseStudy.AddCategory(CategoryList, cat2);
		
		// test that list size is 2 after adding - normal
		assertEquals("Test that CategoryList size is 2", 2, CategoryList.size());
		
		//test that fields are not null  for name and type
	    assertNotNull(cat1.getName());
	    assertNotNull(cat1.getItem());
	  
	    // before deletion , check if its index 0 is indeed cat 1
	    assertTrue(CategoryList.get(0).equals(cat1));
	    // delete the cat1
		C206_CaseStudy.deleteCategory(CategoryList,cat1.getName());
		// after deletion , check cat 1 has been deleted
		assertFalse(CategoryList.get(0).equals(cat1));
		
		// check after deleting cat 1 , arraylist will have only cat 2 left inside
		assertEquals("Test that CategoryList size is 1", 1, CategoryList.size());
		// success message after  deleting cat 1 , arraylist will have only cat 2 left inside
		
	}
	@Test 
	// YIN MINN
	  public void testAddItem()
	{
	    // Item list is not null, so that can add a new item
	    assertNotNull("Test if there is valid item arraylist to add to", itemList);

	    // Given an empty item list, after add one item, the size of the list is 1.
	    C206_CaseStudy.addItem(itemList, item1);    
	    assertEquals("Test if that item arraylist size is 1?", 1, itemList.size());

	    // The item just added is as same as the first item of the list
	    assertSame("Test that  is added same as 1st item of the list?", item1, itemList.get(0));
	    
	    // Test that the field submitted is not null.
	    assertNotNull(item1.getName());
	    assertNotNull(item1.getDescription());
	    assertNotNull(item1.getMinimumBidPrice());
	    assertNotNull(item1.getAuctionStartDate());
	    assertNotNull(item1.getAuctionEndDate());
	    assertNotNull(item1.getBidIncrement());
	    
	    // Given an empty item list, after add one item, the size of the list is 1.
	    C206_CaseStudy.addItem(itemList, item2);    
	    assertEquals("Test if that item arraylist size is 2?", 2, itemList.size());
	    // The item just added is as same as the second item of the list
	    assertSame("Test that  is added same as 1st item of the list?", item2, itemList.get(1));    
	        
	    // Test that an error message will be displayed after submitting if there are empty fields.
	    // Test that a successful message will be displayed after submitting, if there are no empty fields.
	}
	@Test
	public void testRetrieveAllItems()
	{
	    // Test if Item list is not null, so can be displayed
	    assertNotNull("Test if there is valid item arraylist to be displayed", itemList);

	    // Test if the list of items retrieved from the list is empty
	    String allItems = C206_CaseStudy.retrieveAllItems(itemList);
	    String testOutput = "";
	    assertEquals(testOutput, allItems);
	    
	    // Given an empty list, after adding 2 items, test if the size of the list is 2
	    C206_CaseStudy.addItem(itemList, item1);
	    C206_CaseStudy.addItem(itemList, item2);
	    assertEquals("Test if that item arraylist size is 2?", 2, itemList.size());

	    // Test if the expected output string same as the list of items retrieved from the itemList.
	    allItems = C206_CaseStudy.retrieveAllItems(itemList);
	    testOutput = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Sony Laptop", "Sony Inspiron13", 100, "2021-08-03", "2021-08-04", 1);
	    testOutput += String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Dell Laptop", "Dell Inspiron14", 150, "2021-08-05", "2021-08-06", 1);
	    
	    //Check if the item added is same as the items in testOutput
	    assertEquals(testOutput, allItems);
	}
	@Test
	// SHAO CHUN 
	public void testDeleteItem() 
	{
	    // Test that the list is not null so that there is something for us to delete
	    assertNotNull("Test that the list is not null so that there is something for us to delete", itemList);
	    
	    C206_CaseStudy.addItem(itemList, item1);
	    C206_CaseStudy.addItem(itemList, item2);
	      
	    //test that list size is 2 after adding
	    assertEquals("Test that itemList size is 2",2, itemList.size());
	    
	    //Test that fields are not null for name
	    assertNotNull(item1.getName());
	    
	    //before deletion, check if the index O is item 0 is indeed item 1
	    assertTrue(itemList.get(0).equals(item1));
	    
	    //delete item1
	    C206_CaseStudy.deleteItem(itemList, item1.getName());
	    
	    //after deletion , check item1 has been deleted
	    assertFalse(itemList.get(0).equals(item1));
	    
	    assertEquals("Test that itemList size is 1", 1, itemList.size());
	    // Test that a successful message will be displayed after deleting successfully.
	    // Test that the list will be removed from the item list.
	}
	@Test
	public void testViewDeal()
	{
	   assertNotNull("Test if the deal list is not empty", dealList);
	
	   String allDeal = C206_CaseStudy.retrieveAllDeal(dealList);
	   String Output = "";
	   assertEquals("Check that ViewAllDeals", Output, allDeal);
	
	   C206_CaseStudy.addNewDeal(dealList, deal1);
	   C206_CaseStudy.addNewDeal(dealList, deal2);
	   assertEquals("Test if that deal arraylist size is 2?", 2, dealList.size());
	
	   String alldeal = C206_CaseStudy.retrieveAllDeal(dealList);
	   Output = String.format("%-10s %-25s %-20s %-20s %-20.2f %s\n", 1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90, "01/01/2021");
	   Output += String.format("%-10s %-25s %-20s %-20s %-20.2f %s\n",2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com", 10.80, "02/02/2021");
	   assertEquals(Output, alldeal);
	}
	@Test
	public void testAddDeal() 
	{

	  assertNotNull("Test if there is valid deal arraylist to add to", dealList);

	  C206_CaseStudy.addNewDeal(dealList, deal1);
	  assertEquals("Test if that deal arraylist size is 1?", 1, dealList.size());

	  assertSame("Test that deal is added same as 1st item of the list?", deal1, dealList.get(0));

	  assertNotNull(deal1.getPrice());
	  assertNotNull(deal1.getBuyerEmail());
	  assertNotNull(deal1.getName());
	  assertNotNull(deal1.getSellerEmail());

	}
	@Test
	public void testDeleteDeal() {
	assertNotNull("Test that the list is not null so that there is something for us to delete", dealList);

	 C206_CaseStudy.deleteDeal(dealList, deal1.getId());
	assertEquals(0, dealList.size());
	}
	


	@After
	public void tearDown() throws Exception {
		bid1 = null;
		bid2 = null;
		bidList = null;
	}

}
