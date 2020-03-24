import java.util.Comparator;
import java.util.ListIterator;
/**
 * Class to create a sorted, double ended linked list, extends BasicDoubleLinkedList
 * @author Matthew Quander
 *
 * @param <T> Generic type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	/**
	 * Declare Comparator variable
	 */
	private Comparator<T> comparator;
	/**
	 * Constructor to set up Comparator variable
	 * @param comparator
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	/**
	 * Method to add Generic data types in ascending order
	 * @param data Generic data type
	 * @return Reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data){
		Node<T> newNode = new Node<T>(data, null, null);
		Node<T> currentNode = new Node<T>(data, null, null);
		Node<T> nodeBefore;
		Node<T> nodeAfter;
		
		// if the list is empty
		if(size == 0) {
			firstNode =  newNode;
			lastNode = firstNode;
			arrayList.add(newNode.getData());
			arrayList.sort(comparator);
			size++;
			return this;
		} // if only 1 element in the list
		else if(size == 1) {
			currentNode = firstNode;
			if(comparator.compare(newNode.getData(), currentNode.getData()) > 0) {
				arrayList.add(1, newNode.getData());
				arrayList.sort(comparator);
				firstNode.setNext(newNode);
				newNode.setPrevious(firstNode);
				lastNode = newNode;
				size++;
				return this;
			}
			else {
				arrayList.add(0, newNode.getData());
				arrayList.sort(comparator);
				newNode.setNext(firstNode);
				firstNode.setPrevious(newNode);
				firstNode = newNode;
				size++;
				return this;
				
			}
		} // if multiple elements in the list
		else {
			currentNode = firstNode;
			if(comparator.compare(newNode.getData(), currentNode.getData()) <= 0) {
				arrayList.add(0, newNode.getData());
				arrayList.sort(comparator);
				newNode.setNext(firstNode);
				firstNode.setPrevious(newNode);
				firstNode = newNode;
				size++;
				return this;
			}
			
			 	nodeBefore = getNodeBefore(data);
			 	 
			 	//add to middle of list
				if(nodeBefore.getNext() != null){
					nodeAfter = nodeBefore.getNext();
					arrayList.add(arrayList.indexOf(nodeBefore.getData())+1, newNode.getData());
					arrayList.sort(comparator);
					nodeBefore.setNext(newNode);
					newNode.setPrevious(nodeBefore);
					newNode.setNext(nodeAfter);
					nodeAfter.setPrevious(newNode);
					size++;
					return this;
				} //add to the end of the list
				else if(nodeBefore == lastNode) { // nodeAfter.getNext() == null
					lastNode.setNext(newNode);
					newNode.setPrevious(lastNode);
					arrayList.add(newNode.getData());
					arrayList.sort(comparator);
					lastNode = newNode;
					size++;
					return this;
				}
			
		}
				
		return this;
	}
	/**
	 * Private method to get the node before
	 * @param data Generic data type
	 * @return nodeBefore The node before the node to add
	 */
	private Node<T> getNodeBefore(T data){
		Node<T> nodeToAdd = new Node<>(data, null, null);
		Node<T> currentNode = new Node<>();				
		Node<T> nodeBefore = null;						
		currentNode = firstNode; 					
		while(currentNode != null && comparator.compare(nodeToAdd.getData(), currentNode.getData()) > 0) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNext();
		}
		return nodeBefore;
	}
	/**
	 * Unsupported, inherited methods
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		if(data != null)
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		return this;
	}
	
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		if(data != null)
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		return this;
	}
	/**
	 * Inherited iterator method from super class
	 */
	@Override 
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	/**
	 * Inherited method from super class to remove element
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comp){
		
		super.remove(data, comp);
		return this;
	}
}
