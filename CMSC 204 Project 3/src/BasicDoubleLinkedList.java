import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Class to create a generic double ended linked list
 * @author 
 *
 * @param <T> Generic type
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	/**
	 * Declare the data fields
	 */
	int size;
	Node<T> firstNode, lastNode, previousNode;
	ArrayList<T> arrayList;// = new ArrayList<T>();
	IteratorForLinkedList iterator;
	/**
	 * Constructor to initialize the data fields
	 */
	public BasicDoubleLinkedList() {
		size = 0;
		firstNode = null;
		lastNode = null;
		previousNode = null;
		arrayList = new ArrayList<T>();
	}
	/**
	 * Method to create an IteratorForLinkedList instance
	 */
	@Override
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		
		iterator = new IteratorForLinkedList();
		return iterator;
	}
	/**
	 * Method to return the first node in the DLL
	 * @return temp A copy of the first node's data
	 */
	public T getFirst() {
		T temp;
		if(firstNode != null)
			temp = firstNode.getData();
		else
			temp = null;
		return temp;
	}
	/**
	 * Method to return the last node in the DLL
	 * @return temp A copy of the last node's data
	 */
	public T getLast() {
		T temp;
		if(lastNode != null)
			temp = lastNode.getData();
		else
			temp = null;
		return temp;
	}
	/**
	 * Method to add an element to the end of the DLL
	 * @param data Generic type of data
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node<T> newNode = new Node<T>(data, null, null);
		if(getSize() == 0) {
			firstNode = newNode;
			
		}
		else if(getSize() > 0) {
			lastNode.setNext(newNode);
			newNode.setPrevious(lastNode); 
		}
		lastNode = newNode;
		arrayList.add(newNode.getData());
		size++;
		return this;
	}
	/**
	 * Method to add an element to the front of the DLL
	 * @param data Generic type of data
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node<T> newNode = new Node<T>(data, null, null);
		if(getSize() == 0) {
			
			lastNode = newNode;
		}
		else if(getSize() > 0) {
			firstNode.setPrevious(newNode);
			newNode.setNext(firstNode);
		}
		
		firstNode = newNode;
		arrayList.add(0, newNode.getData());
		size++;
		return this;
	}
	public int getSize() {
		return size;
	}
	/**
	 * Method to remove an element from the DLL
	 * @param targetData Generic type data
	 * @param comparator Comparator variable to compare objects
	 * @return reference to the current object
	 */
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		BasicDoubleLinkedList<T> returnValue = null;
		
		Node<T> currentNode = new Node<T>();
		currentNode = firstNode;
		Node<T> toRemove = null;
		if(firstNode != null && comparator.compare(firstNode.getData(), targetData) == 0) {
			arrayList.remove(firstNode.getData());
			firstNode.setData(null);
			firstNode = firstNode.getNext();
			size--;
			returnValue = this;
		}
		else if(lastNode.getPrevious() != null && comparator.compare(lastNode.getData(), targetData) == 0){
			arrayList.remove(lastNode.getData());
			//lastNode.setData(null);
			lastNode = lastNode.getPrevious();
			lastNode.setNext(null);
			size--;
			returnValue = this;
		}	
		else {
			toRemove = currentNode.getNext();
			while(toRemove != null) {
				if(comparator.compare(toRemove.getData(), targetData) == 0) {
					arrayList.remove(toRemove.getData());
					currentNode.setNext(toRemove.getNext());
					toRemove.getNext().setPrevious(currentNode);
					toRemove.setData(null);
					size--;
					returnValue = this;
				}
			toRemove = toRemove.getNext();
			currentNode = currentNode.getNext();
			}
		}
		
		return returnValue;
	}
	/**
	 * Method to delete and retrieve the first element
	 * @return temp - copy of first element's data
	 */
	public T retrieveFirstElement() {
		T temp;
		if(firstNode != null) {
			temp = firstNode.getData();
			arrayList.remove(firstNode.getData());
			firstNode.setData(null);
			firstNode.setPrevious(null);
			firstNode = firstNode.getNext();
			size--;
		}
		else
			temp = null;

		return temp;
	}
	/**
	 * Method to delete and retrieve the last element
	 * @return temp - copy of last element's data
	 */
	public T retrieveLastElement() {
		T temp;
		if(lastNode != null && getSize() > 0) {
			temp = lastNode.getData();
			arrayList.remove(lastNode.getData());
			lastNode.setData(null);
			if(size > 1) {
				lastNode = lastNode.getPrevious();
				lastNode.setNext(null);
			}
			size--;
		}
		else
			temp = null;
		
		return temp;
	}
	/**
	 * Method to return an ArrayList of the elements
	 * @return arrayList
	 */
	public ArrayList<T> toArrayList(){
		
		return arrayList;
	}
//****************************************************
		/**
		 * Inner Node class
		 * @author
		 *
		 * @param <T> generic type
		 */
		@SuppressWarnings("hiding")
		public class Node<T>{
			/**
			 * Declare data fields
			 */
			protected T data;
			protected Node<T> next, previous;
			/**
			 * Constructor to set field vales
			 * @param data Generic type data
			 * @param next Reference to next element
			 * @param previous Reference to previous element
			 */
			public Node(T data, Node<T> next, Node<T> previous) {
				this.setData(data);
				this.setNext(next);
				this.setPrevious(previous);
			}
			/**
			 * Default constructor
			 */
			public Node() {
				// TODO Auto-generated constructor stub
			}
			/**
			 * Getter and setter methods for data, next, and previous
			 * @return T data, Node next, Node previous
			 */
			public T getData() {
				return data;
			}

			public void setData(T data) {
				this.data = data;
			}

			public Node<T> getNext() {
				return next;
			}

			public void setNext(Node<T> next) {
				this.next = next;
			}

			public Node<T> getPrevious() {
				return previous;
			}

			public void setPrevious(Node<T> previous) {
				this.previous = previous;
			}
		}
		
//********************************************************************* 
		
		/**
		 * Inner class for an iterator, implements ListIterator interface
		 * @author 
		 *
		 */
		public class IteratorForLinkedList implements ListIterator<T>{
			/**
			 * Declare data fields
			 */
			protected Node<T> nextNode, previousNode;
			protected boolean wasNextCalled;
			protected int counter;
			/**
			 * Constructor to set data fields
			 */
			public IteratorForLinkedList() {
				nextNode = firstNode;
				previousNode = null;
				wasNextCalled = false;
				counter = 0;
			}
			/**
			 * Method to check if there are more elements to iterate forward
			 */
			@Override
			public boolean hasNext() {
				
				return nextNode != null;
			}
			/**
			 * Method to check if there are more elements to iterate backwards
			 */
			@Override
			public boolean hasPrevious() {
			
				return counter >= 1;
			}
			/**
			 * Method to iterate forward
			 */
			@Override
			public T next() {
			T result;
			if(hasNext()) {
				wasNextCalled = true;
				result = nextNode.getData();
				previousNode = nextNode;
				nextNode = nextNode.getNext();
				counter++;
			}
			else 
				throw new NoSuchElementException("Illegal call to next()");
			return result;
			}
			/**
			 * Method to iterate backwards
			 */
			@Override
			public T previous() {
			T result;
			if(hasPrevious()) {
				result = previousNode.getData();
				nextNode = previousNode;
				previousNode = previousNode.getPrevious();	
				counter--;
			}
			else
				throw new NoSuchElementException("Illegal call to previous()");
			return result;
			/**
			 * Unsupported methods inherited from ListIterator interface
			 */
			}
			@Override
			public void add(T arg0) throws UnsupportedOperationException{
				throw new UnsupportedOperationException("previous() not supported in iterator");
			
			}
			@Override
			public int nextIndex() throws UnsupportedOperationException{
				throw new UnsupportedOperationException("nextIndex() not supported in iterator");
			}

			
			@Override
			public int previousIndex() throws UnsupportedOperationException{
				throw new UnsupportedOperationException("previousIndex() not supported in iterator");
			}

			@Override
			public void remove() throws UnsupportedOperationException{
				throw new UnsupportedOperationException("remove() not supported in iterator");
			
			}

			@Override
			public void set(T arg0) throws UnsupportedOperationException {
				throw new UnsupportedOperationException("set() not supported in iterator");
			
			}
			
		}
		//**********************************

}
