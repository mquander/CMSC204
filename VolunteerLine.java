/**
 * Class to create volunteer line
 * @author Matt Quander
 *
 */
public class VolunteerLine implements VolunteerLineInterface{
	/**
	 * Class fields
	 */
	MyQueue<Volunteer> queue = new MyQueue<Volunteer>();
	private int capacity;
	private int size = 0;
	/**
	 * Constructors to initialize volunteer line
	 * @param capacity
	 */
	public VolunteerLine(int capacity){
		this.capacity = capacity;
	}
	
	public VolunteerLine() {
		capacity = 5;
	}
	/**
	 * Method to add new volunteer to queue
	 * @return true if added, false if not
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {

		if(queue.isFull()) {
			throw new VolunteerException("Volunteer queue is full");
			
		}
		else if(!queue.isFull()){
			queue.enqueue(v);
			size++;
			return true;
		}
		return false;
	}
	/**
	 * Method to remove volunteer object from queue
	 * @return volunteer object removed
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		Volunteer temp;
		if(queue.isEmpty()) {
			throw new VolunteerException("Volunteer queue is empty");
		}
		else {
			temp = queue.dequeue();
		}
		size--;
		return temp;
	}
	/**
	 * Method to check if volunteer queue is empty
	 * @return true if empty, false if not
	 */
	@Override
	public boolean volunteerLineEmpty() {
		
		return queue.isEmpty();
	}
	/**
	 * Method to return array of queue elements
	 * @return volArr 
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		Volunteer volArr[] = new Volunteer[queue.getMAX_CAPACITY()];
		Object tempArr[] = new Object[queue.getMAX_CAPACITY()];
		tempArr = queue.toArray();
		
		for(int i = 0; i < queue.size(); i++) {
			
			volArr[i] = (Volunteer)tempArr[i];
		}

		return volArr;
	}
	/**
	 * Method to return capacity
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Method to return size of queue
	 * @return
	 */
	public int getSize() {
		return size;
	}

}
