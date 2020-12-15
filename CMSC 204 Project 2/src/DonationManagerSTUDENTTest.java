
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author 
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {
		try {
			manager.managerLoadContainer(new DonationPackage("Water",18));
			manager.managerLoadContainer(new DonationPackage("Computer",7));
			manager.managerLoadContainer(new DonationPackage("Textbooks",13));

			 
			 
		} catch (ContainerException e) {
			System.out.println("Should not throw exception ");
		}		 
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("Kwesi"));
			manager.managerQueueVolunteer(new  Volunteer("Kofi"));
			manager.managerQueueVolunteer(new  Volunteer("Kwabena"));
			
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("MC"));
			manager.managerQueueVolunteer(new  Volunteer("UMD"));
			manager.managerQueueVolunteer(new  Volunteer("UMES"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + "here");
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		Volunteer v;
	    Recipient r;
	    DonationPackage dP1,dP2;
	    
	    v = new Volunteer("Amaquandoh"); 
		r =  new Recipient("Loyal College");
		
		dP1 =  new DonationPackage("paper",10);
		dP2 =  new DonationPackage("pencils",20);
		
		try {
			manager.managerLoadContainer(dP1);
			manager.managerLoadContainer(dP2);
			
			assertEquals(manager.donatePackage(), 1);  //Can not donate package, There are no volunteers in the queue
			
			manager.managerQueueVolunteer(v);    //add a volunteer
			assertEquals(manager.donatePackage(), 2);  // Still Can not donate package,There are no recipients in the queue
			
			manager.managerQueueRecipient(r);   //Add a recipient
			assertEquals(manager.donatePackage(), 0);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			
			assertEquals(manager.donatePackage(), 2); //There is no recipient in the queue
			
		} catch (VolunteerException | ContainerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	} 

}
