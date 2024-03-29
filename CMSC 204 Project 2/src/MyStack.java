/**
 * Class to create a stack
 * @author
 *
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T> {
	/**
	 * Fields to create stack
	 */
	private Node topNode, bottomNode;
	private final int MAX_CAPACITY = 5;
	private int size;
	/**
	 * Constructor for MyStack
	 * @param MAX_CAPACITY
	 */
	public MyStack(int MAX_CAPACITY) {
		topNode = null;
		bottomNode = null;
		size = 0;
	}
	/**
	 * Constructor for MyStack
	 */
	public MyStack() {
		topNode = null;
		bottomNode = null;
		size = 0;
	}
	/**
	 * Private inner class Node
	 * @author
	 *
	 */
	private class Node {
		/**
		 * Node fields
		 */
		private T data;
		private Node next;
		/**
		 * Node constructor
		 * @param data Node data T
		 * @param next the reference to the next Node
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
		 * @return
		 */
		public Node getNext() {
			return next;
		}
		/**
		 * Method to set next node
		 * @param next
		 */
		public void setNext(Node next) {
			this.next = next;
		}

	}
	/**
	 * Method to check if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		
		return topNode == null && bottomNode == null;
	}
	/**
	 * Method to check if stack is full
	 */
	@Override
	public boolean isFull() {
		boolean returnValue;
		
		if(size() == MAX_CAPACITY)
			returnValue = true;
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Method to remove and return top node
	 */
	@Override
	public T pop() {
		T top;
		if(isEmpty()) {
			top = null;
			topNode = null;
			bottomNode = null;
			System.out.println("Stack is empty");
		}
			
		else {
			top = topNode.getData();
			topNode.setData(null);
			topNode = topNode.getNext();
			size--;
		}
		
		return top;
	}
	/**
	 * Method to return size of the stack
	 */
	@Override
	public int size() {
		
		return size;
	}
	/**
	 * Method to add to the top of stack
	 */
	@Override
	public boolean push(T e) {
		boolean returnValue;
		
		if(isEmpty()) {
			Node newNode = new Node(e, null);
			topNode = newNode;
			size++;
			returnValue = true;
		}
		else if(!isFull()) {
			Node newNode = new Node(e, topNode);
			topNode = newNode;
			size++;
			returnValue = true;
		}
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Method to return array of stack elements
	 */
	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		Node currentNode = topNode;
		
		int i = size - 1;
		while((currentNode != null) && (i >= 0)) {
			
			array[i] = currentNode.getData();
			
			currentNode = currentNode.getNext();
			i--;
		}		
		return array;
	}
	/**
	 * Method to return MAX_CAPACITY
	 * @return MAX_CAPACITY
	 */
	public int getMAX_CAPACITY() {
		return MAX_CAPACITY;
	}

}
