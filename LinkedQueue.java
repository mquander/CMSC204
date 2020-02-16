
public class LinkedQueue<T> implements QueueInterface<T> {

	private Node firstNode, lastNode;
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
		private class Node {
			private T data;
			private Node next;
		
			public Node(T data, Node next) {
				this.data = data;
				this.next = next;
			}

			public T getData() {
				return data;
			}

			public void setData(T data) {
				this.data = data;
			}

			public Node getNext() {
				return next;
			}

			public void setNext(Node next) {
				this.next = next;
			}
		
	}

	@Override
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNext(newNode);
		lastNode = newNode;
	}

	@Override
	public T dequeue() {
		
		try {
			if(isEmpty()) 
			throw new EmptyQueueException();
		}catch(EmptyQueueException e) {
			e.getMessage();
		}
		
		T front= getFront();
		firstNode.setData(null);
		firstNode = firstNode.getNext();
		
		if(firstNode == null)
			lastNode = null;
		return front;
	}

	@Override
	public T getFront() {
		
		try {
			if(isEmpty())
				throw new EmptyQueueException();
		} catch (EmptyQueueException e) {
				
			e.getMessage();
		}
		
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null && lastNode == null);
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}
	}
}
