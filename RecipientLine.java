/**
 * Class to create recipient line
 * @author Matt Quander
 *
 */
public class RecipientLine implements RecipientLineInterface{
	/**
	 * Class fields
	 */
	MyQueue<Recipient> queue; // = new MyQueue<Recipient>();
		
	private int capacity;
	private int size = 0;
	/**
	 * Constructors to initialize object and set capacity
	 * @param capacity
	 */
	public RecipientLine(int capacity) {
		queue = new MyQueue<Recipient>();
		this.capacity = capacity;
		
	}
	
	public RecipientLine() {
		queue = new MyQueue<Recipient>();
		capacity = 5;
		
	}
	/**
	 * Method to add recipient to queue
	 * @return true if added, false if not
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if(queue.isFull()) {
			throw new RecipientException("Recipient queue is full");
			
		}
		else {
			queue.enqueue(rc);
			size++;
			return true;
		}
	}
	/**
	 * Method to remove recipient from queue
	 * @return recipient removed from queue
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		Recipient temp;
				
		if(queue.isEmpty()) {
			throw new RecipientException("Recipient queue is empty");
		}
		else {
			temp = queue.dequeue();
			size--;
			return temp;
		}
	}
	/**
	 * Method to check if line is empty
	 * @return true if empty, false if not
	 */
	@Override
	public boolean recipientLineEmpty() {
		
		return queue.isEmpty();
	}
	/**
	 * Method to return array of recipient queue
	 * @return array of recipients
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		
		Object[] tempArr = new Object[queue.size()];
		tempArr =  queue.toArray();
		
		Recipient recArr[] = new Recipient[getSize()];
		for(int i = 0; i < queue.size(); i++) {
			
			recArr[i] = (Recipient) tempArr[i];
		}
		
		return recArr;
	}
	/**
	 * Method to return capacity
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Method to get the size of recipient queue
	 * @return size
	 */
	public int getSize() {
		return size;
	}
}
