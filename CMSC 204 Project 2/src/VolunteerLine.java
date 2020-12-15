/**
 * Class to create volunteer line
 * @author 
 *
 */
public class VolunteerLine implements VolunteerLineInterface{
	/**
	 * Class fields
	 */
	MyQueue<Volunteer> queue;

	private int capacity;
	private int size = 0;
	/**
	 * Constructors to initialize volunteer line
	 * @param capacity
	 */
	public VolunteerLine(int capacity){
		queue = new MyQueue<Volunteer>();
		this.capacity = capacity;
	}
	
	public VolunteerLine() {
		queue = new MyQueue<Volunteer>();
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
		else {
			queue.enqueue(v);
			size++;
			return true;
		}
		
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
			size--;	
		}
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
		
		Volunteer volArr[] = new Volunteer[getSize()];
		
		Object tempArr[] = new Object[getSize()];
		tempArr = queue.toArray();
		
		for(int i = 0; i < queue.size(); i++) {
			
			volArr[i] = (Volunteer) tempArr[i];
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
