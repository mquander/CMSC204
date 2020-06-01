/**
 * Class to create a Container object
 * @author Matt Quander
 * @param <T>
 *
 */
public class Container implements ContainerInterface{
	/**
	 * Container fields
	 */
	MyStack<DonationPackage> stack = new MyStack<DonationPackage>();
	private int capacity, size = 0;
	/**
	 * Container constructors
	 * @param capacity
	 */
	public Container(int capacity) {
		this.capacity = capacity;
		stack = new MyStack<DonationPackage>();
	}
	
	public Container() {
		capacity = 5;
		stack = new MyStack<DonationPackage>();
	}
	/**
	 * Method to add donation package to Container
	 * @param dPackage a DonationPackage Object to add to container
	 * Return true if the package is stacked, false if full
	 * @throws ContainerException("The Container is Full") if full
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {

		if(stack.isFull())
			throw new ContainerException("The Container is full");
		else {
			stack.push(dPackage);
			size++;
			return true;
		}
		
	}
	/**
	 * Removes  a DonationPackage from container
	 * @return a DonationPackage from the container
	 * @throws ContainerException("The Container is Empty") if empty
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		DonationPackage temp;
		if(stack.isEmpty())
			throw new ContainerException("The Container is empty");
		else {
			temp = stack.pop();
			size--;
		}
		return temp;
	}
	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * @return an array of the DonationPackages in the stack
	 */
	@Override
	public DonationPackage[] toArrayPackage() {
		
		DonationPackage[] array = new DonationPackage[getSize()]; 
		Object[] temp = new Object[getSize()];
		temp = stack.toArray();
		for(int i = 0; i < stack.size(); i++) {
			array[i] = (DonationPackage)temp[i];
		}
		
		return array;
	}
	/**
	 * Method to return capacity
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Method to return size
	 * @return size
	 */
	public int getSize() {
		return size;
	}
}
