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


	private ArrayList<Bid> bidList;
	private ArrayList<category> CategoryList;
	private ArrayList<User> userList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		bid1 = new Bid(1, "Rose Quartz Crystal", "seller1@mail.com", "buyer1@mail.com", 4.90);
		bid2 = new Bid(2, "MoonStone Bracelet", "seller2@mail.com", "buyer2@mail.com",10.80);
		bidList = new ArrayList<Bid>();
		//=================================================================== @Before ---> USER =========================================================================
		u1 = new User("John Lim", "johnlim@C206.com", "12345", "Buyer");
		u2 = new User("James Tan", "jamestan@C206.com", "67890", "Buyer");
		u3 = new User("Susan Chan", "susanchan@C206.com", "54321", "Seller");
		u4 = new User("Joan Lee", "joanlee@C206.com", "09876", "Admin");
		
		userList = new ArrayList<User>();
		//===============================================================================================================================================================
		CategoryList = new ArrayList<category>();
		cat1 = new category("Sports","Football with the league");
		cat2 = new category("Baking","cakes with shakes");
		

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test 
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
	public void testDeleteUser()
	{
		assertNotNull("Test that the userList is not null", userList);
		
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		
		assertEquals("Test that userList size is 2", 2, userList.size());
		
		assertTrue(userList.get(0).equals(u1));
		C206_CaseStudy.deleteUser(userList, "johnlim@C206.com");
		assertFalse(userList.get(0).equals(u1));
	}
	//=======================================================================================================================================================================
	@Test 
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
	public void testDeleteCategory() {
		
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
		
	}


	@After
	public void tearDown() throws Exception {
		bid1 = null;
		bid2 = null;
		bidList = null;
	}

}
