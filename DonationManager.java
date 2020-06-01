/**
 * Class to manage operations of adding package to stack, adding volunteer to line, adding
 * recipient to line, and donating package
 * @author Matt Quander
 *
 */
public class DonationManager implements DonationManageInterface{
	/**
	 * Class fields 
	 */
	private VolunteerLine volLine;//= new VolunteerLine();
	private RecipientLine recLine = new RecipientLine();
	private Container cont = new Container();
	private Volunteer reQueueVol;
	private Recipient recip;
	private DonationPackage dP;
	
	public DonationManager() {
		volLine= new VolunteerLine();
		recLine = new RecipientLine();
		cont = new Container();
	}
	/**Method to stack a new  package in to container
	 * @param dPackage Donation package stacked in to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 * */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		
		if(cont.loadContainer(dPackage)) {
			return true;
		}
		else{
			throw new ContainerException("Container is full");
		}
	}
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		
		
		if(volLine.addNewVolunteer(v))
			return true;

		else
			throw new VolunteerException("Volunteer Line is full"); 
	}
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		if(recLine.addNewRecipient(r)) {
			return true;

		}else {
			throw new RecipientException("Recipient Line is full");
		}
	}
	/**
	 * Donates package from container by the volunteer  to the 
	 * recipients. Package removed from the container, volunteer dequeued
	 * and recipient will be dequeued.
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		int returnValue = 0;
		if(volLine.volunteerLineEmpty()) {
			returnValue =  1;
			throw new VolunteerException("The Volunteer line is empty");
		}

		else if(recLine.recipientLineEmpty()) {
			returnValue = 2;
			throw new RecipientException("Recipient line is empty");	
		} 
		else if(cont.getSize() == 0) {
			returnValue = 3;
			throw new ContainerException("The Container is empty");
		}
		
		dP = cont.removePackageFromContainer();
		recip = recLine.recipientTurn();
		reQueueVol = volLine.volunteerTurn();
		volLine.addNewVolunteer(reQueueVol);
			
		return returnValue;
	}
	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		DonationPackage[] dpArray = new DonationPackage[cont.toArrayPackage().length];
		for(int i = 0; i < cont.toArrayPackage().length; i++)
			dpArray[i] = cont.toArrayPackage()[i];
		
		return dpArray;
	}
	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		Volunteer[] volArray = new Volunteer[volLine.toArrayVolunteer().length];
		for(int i = 0; i < volLine.toArrayVolunteer().length; i++) {
			volArray[i] = volLine.toArrayVolunteer()[i];
		}
		
		return volArray;
	}
	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		Recipient[] recArray = new Recipient[recLine.toArrayRecipient().length];
		for(int i = 0; i < recArray.length; i++)
			recArray[i] = recLine.toArrayRecipient()[i];
		
		return recArray;
	}
	/**
	 * Returns string representation of donation simulation
	 */
	public String toString() {
		return reQueueVol.toString() + " donated " + dP.toString() + " to " + recip.toString();
	}

}
