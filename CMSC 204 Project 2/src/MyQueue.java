/**
 * Class create queue
 * @author 
 *
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T>{
	/**
	 * Class fields
	 */
	
	private Node firstNode, lastNode;
	private final int MAX_CAPACITY = 5;
	private int size;
	/**
	 * Constructors to initialize queue
	 * @param MAX_CAPACITY
	 */
	
	public MyQueue(int MAX_CAPACITY) {
		
		size = 0;
	}
	public MyQueue() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	/**
	 * Private inner class Node
	 * @author 
	 *
	 */
		private class Node {
			/**
			 * Inner class fields
			 */
			private T data;
			private Node next;
			/**
			 * Inner class constructor to initalize nodes
			 * @param data node's data
			 * @param next reference to next node
			 */
			public Node(T data, Node next) {
				this.data = data;
				this.next = next;
			}
			/**
			 * Method to return node's data
			 * @return
			 */
			public T getData() {
				return data;
			}
			/**
			 * Method to set node's data
			 * @param data
			 */
			public void setData(T data) {
				this.data = data;
			}
			/**
			 * Method to return next node
			 * @return next
			 */
			public Node getNext() {
				return next;
			}
			/**
			 * Method to set next node
			 * @param next reference for next node
			 */
			public void setNext(Node next) {
				this.next = next;
			}
		}
		/**
		 * Method to check if queue is empty
		 */
	@Override
	public boolean isEmpty() {
		
		return firstNode == null && lastNode == null;
	}
	/**
	 * Method to check if queue is full
	 */
	@Override
	public boolean isFull() {
		boolean returnValue;
		
		if(size() >= getMAX_CAPACITY())
			returnValue = true;
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Method to remove front node
	 */
	@Override
	public T dequeue() {
		T front = null;
		if(isEmpty()) {
			firstNode = null;
			lastNode = null;
			System.out.println("Queue is empty");
		}
			
		else {
			front = firstNode.getData();
			firstNode.setData(null);
			firstNode = firstNode.getNext();
			size--;
		}
		if(firstNode == null)
			lastNode = null;
		
		return front;
	}
	/**
	 * Method to get queue size
	 */
	@Override
	public int size() {
		
		return size;
	}
	/**
	 * Method to add a node to queue
	 * @return true if added, false if not
	 */
	@Override
	public boolean enqueue(T e) {
		boolean returnValue;
		
		if(size() < getMAX_CAPACITY()) {
			Node newNode = new Node(e, null);
			
			if(isEmpty())
				firstNode = newNode;
			else
				lastNode.setNext(newNode);
			lastNode = newNode;
			size++;
			returnValue = true;
		}
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Method to add queue elements to an array
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		
		T[] array = (T[]) new Object[getMAX_CAPACITY()];
		Node currentNode = firstNode;
		
		int i = 0;
		while((currentNode != null) && (i < size())) {
			
			array[i] = currentNode.getData();
			currentNode = currentNode.getNext();
			i++;
		}
		return  array;
	}
	/**
	 * Method to get MAX_CAPACITY
	 * @return MAX_CAPACITY
	 */
	public int getMAX_CAPACITY() {
		return MAX_CAPACITY;
	}

}
