
public class TestClass<T> extends MyQueue<T>{
	
	
	
	public static void main(String[] args) {
		/*MyQueue<String> queueTest = new MyQueue<>();
		//queueTest.enqueue("Jim");
		queueTest.enqueue("Andu");
		queueTest.enqueue("Eric");
		queueTest.enqueue("Do");
		queueTest.enqueue("Ken");
		//queueTest.enqueue("Mo");*/
		
		/*Object[] array = new Object[queueTest.size()];
		//array = queueTest.toArray();
		String[] strArr = new String[queueTest.size()];
		for(int i = 0; i < queueTest.size(); i++) {
			strArr[i] = (String)array[i];
			System.out.println(strArr[i]);
		}*/
		/*VolunteerLine volLine2 = new VolunteerLine();
		//volLine2.addNewVolunteer(new Volunteer("Will"));
		volLine2.addNewVolunteer(new Volunteer("Matt"));
		volLine2.addNewVolunteer(new Volunteer("Devin"));
		volLine2.addNewVolunteer(new Volunteer("Kofi"));
		volLine2.addNewVolunteer(new Volunteer("Kojo"));
		
		System.out.println(volLine2.toArrayVolunteer()[0]);
		volLine2.volunteerTurn();
		volLine2.addNewVolunteer(new Volunteer("Kwesi"));
		System.out.println(volLine2.toArrayVolunteer()[0]);
		volLine2.volunteerTurn();
		System.out.println(volLine2.toArrayVolunteer()[0]);
		volLine2.volunteerTurn();
		System.out.println(volLine2.toArrayVolunteer()[0].toString());
		volLine2.volunteerTurn();
		
		System.out.println(volLine2.toArrayVolunteer()[0].toString());
		volLine2.volunteerTurn();
		
		System.out.println(volLine2.toArrayVolunteer()[0].toString());*/
		RecipientLine recLine2 = new RecipientLine();
		recLine2.addNewRecipient(new Recipient("Joan"));
		DonationManager donMan = new DonationManager();
		donMan.managerLoadContainer(new DonationPackage("water", 2.0));
		donMan.managerLoadContainer(new DonationPackage("pens", 2.0));
		donMan.managerLoadContainer(new DonationPackage("paper", 2.0));
		donMan.managerLoadContainer(new DonationPackage("books", 2.0));
		donMan.managerLoadContainer(new DonationPackage("food", 2.0));
		
		
		donMan.managerQueueRecipient(new Recipient("Joan"));
		donMan.managerQueueRecipient(new Recipient("Jack"));
		donMan.managerQueueRecipient(new Recipient("Peter"));
		donMan.managerQueueRecipient(new Recipient("Amina"));
		donMan.managerQueueRecipient(new Recipient("Rick"));
		
		
		donMan.managerQueueVolunteer(new Volunteer("Will"));
		donMan.managerQueueVolunteer(new Volunteer("Matt"));
		donMan.managerQueueVolunteer(new Volunteer("Devin"));
		donMan.managerQueueVolunteer(new Volunteer("Kofi"));
		donMan.managerQueueVolunteer(new Volunteer("Kojo"));

		
		Object[] t = donMan.managerArrayPackage();

		/**donMan.donatePackage();
		System.out.println(donMan.toString());
		donMan.donatePackage();
		System.out.println(donMan.toString());
		donMan.donatePackage();
		System.out.println(donMan.toString());
		donMan.donatePackage();
		System.out.println(donMan.toString());
		donMan.donatePackage();
		System.out.println(donMan.toString());*/
		
		
		
	 
	
	}
	

}
