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
	VolunteerLine volLine= new VolunteerLine();
	RecipientLine recLine = new RecipientLine();
	Container cont = new Container();
	Volunteer vol;
	Recipient recip;
	DonationPackage dP;
	
	public DonationManager() {
		
	}
	/**Method to stack a new  package in to container
	 * @param dPackage Donation package stacked in to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 * */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		
		try {
			cont.loadContainer(dPackage);
		}
		catch(ContainerException e) {
			e.getMessage();
		}
		return true;
	}
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		
		try {
			volLine.addNewVolunteer(v);

		}catch(VolunteerException e) {
			e.getMessage();
		}
		return true;
	}
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		try {
			recLine.addNewRecipient(r);

		}catch(RecipientException e) {
			e.getMessage();
		}
		return true;
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
		
		if(volLine.volunteerLineEmpty())
			throw new VolunteerException("The Volunteer line is empty");
		else
			volLine.volunteerTurn();
		
		
		if(recLine.recipientLineEmpty())
			throw new RecipientException("Recipient line is empty");
		else
			recLine.recipientTurn();
		
		
		if(cont.getSize() == 0)
			throw new ContainerException("The Container is empty");
		else
			cont.removePackageFromContainer();
		
		return 0;
	}
	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		DonationPackage[] dpArray = new DonationPackage[cont.getCapacity()];
		dpArray = cont.toArrayPackage();
		
		return dpArray;
	}
	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		Volunteer[] volArray = new Volunteer[volLine.getCapacity()];
		volArray = volLine.toArrayVolunteer();
		
		return volArray;
	}
	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		Recipient[] recArray = new Recipient[recLine.getCapacity()];
		recArray = recLine.toArrayRecipient();
		
		return recArray;
	}
	/**
	 * Returns string representation of donation simulation
	 */
	public String toString() {
		return vol.getName() + "donated a " + dP.getDescription() + " to " + recip.getName();
	}

}
