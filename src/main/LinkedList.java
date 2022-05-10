package main;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>, Iterable<T> {
	private Node<T> head, tail;
	private int size;
	
	public LinkedList() {
		// Do nothing
		tail = new Node<>();
		head = new Node<>();
		size = 0;
	}
	
	
	@Override
	public void add(T item) {
		addLast(item);
	}
	public void run() {
		System.out.println("--------test------------");
		Node<T> runner = head;
		if(runner == null) {
			System.out.println(head);
			System.out.println(tail);
		}
		while(runner != null) {
			System.out.println(runner);
			runner = runner.getNext();
		}
		System.out.println(size);
	}
	/**
	 * Clears the linked list and sets the size to zero. 
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
		
	}
	/**
	 * Method checks whether or not the item is found in the linked list.
	 * 
	 * @param item  the item being searched for in linked list
	 * @return true or false if the item was found in the linked list
	 */
	@Override
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		if(size == 0) {
			return false;
		}
		
		Node<T> runner = head;
		while(runner != null) {
			if(runner.data.equals(item)) {
				return true;
			}
			runner = runner.getNext();
		}

		return false;
		
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T remove(Object item) {
		if(size == 0) {
			return null;
		}else if(size == 1 && head.data.equals(item)) {
			clear();
			
		}
		
		Node<T> runner = head;
		while(runner != null) {
			if(runner.getPrev() == null && runner.data.equals(item)) {
				Node<T> nextNode = runner.getNext();
				nextNode.setPrev(null);
				head = head.getNext();
				size --;
				
			}else if( runner.getNext() == null && runner.data.equals(item)) {
				Node<T> prevNode = runner.getPrev();
				prevNode.setNext(null);
				tail = prevNode;
				size --;
				
			}else if(runner.data.equals(item)){
				Node<T> prevNode = runner.getPrev();
				Node<T> nextNode = runner.getNext();
				prevNode.setNext(nextNode);
				nextNode.setPrev(prevNode);
				size--;
			}
			
			
			runner = runner.getNext();
		}

		
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> pointer = new Iterator<T>() {
			private Node<T> point = head;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if(isEmpty()) {
					return false;
				}else {
					if(point.getNext() != null) {
						return true;
					}else {
						return false;
					}
				}
				
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if(isEmpty()) {
					return null;
				}else {
					point = point.getNext();
				}
				return null;
			}

			@Override
			public void remove() {
				if(head.equals(point)) {
					removeFirst();
				}else if(tail.equals(point)) {
					removeLast();
				}else if(!point.equals(null)) {
					Node<T> prevNode = point.getPrev();
					Node<T> nextNode = point.getNext();
					prevNode.setNext(nextNode);
					nextNode.setPrev(prevNode);
					size--;
				}
				
			}
			
		};
		return pointer;
	}

	@Override
	public void add(T item, int index) throws IndexOutOfBoundsException {
		
		try {
			if(0 <= index && index < size ) {
				if(index == 0) {
					addFirst(item);
				}
				else {
					int counter = 0;
					Node<T> runner = head;
					while(runner != null) {
						if(counter == index) {
							Node<T> prevNode = runner.getPrev();
							Node<T> insertNode = new Node<>(prevNode, runner, item);
							prevNode.setNext(insertNode);
							runner.setPrev(runner);
							size++;
							break;
						}
						runner = runner.getNext();
						counter++;
					}//end while loop
				}//end else 
				
			}else {
				throw new IndexOutOfBoundsException();
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Index is invalid");
		}
	}

	@Override
	public T get(int index)throws IndexOutOfBoundsException{
		try {
			if(0 <= index && index < size) {
				int counter = 0;
				Node<T> runner = head;
				while(runner != null) {
					if(counter == index) {
						return runner.data;
					}
					runner = runner.getNext();
					counter++;
				}//end while loop
			}else {
				throw new IndexOutOfBoundsException();
			}
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Index is invalid");
		}
		return null;
	}

	@Override
	public int indexOf(Object item) {
		int counter = 0;
		Node<T> runner = head;
		while(runner != null) {
			if(runner.data.equals(item)) {
				return counter;
			}
			runner = runner.getNext();
			counter ++;
		}//end while loop
		return -1;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException{

		try {
			if(0 <= index && index < size ) {
				if(index == 0) {
					removeFirst();
				}else if(index == size-1) {
					removeLast();
				}
				else {
					int counter = 0;
					Node<T> runner = head;
					while(runner != null) {
						if(counter == index) {
							Node<T> prevNode = runner.getPrev();
							Node<T> nextNode = runner.getNext();
							prevNode.setNext(nextNode);
							nextNode.setPrev(prevNode);
							size--;
							break;
						}
						runner = runner.getNext();
						counter++;
					}//end while loop
				}//end else 
				
			}else {
				throw new IndexOutOfBoundsException();
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Index is invalid");
		}
		return null;
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		try {
			if(isEmpty()) {
				throw new NoSuchElementException();
			}else {
				return head.data;
			}
		}catch(NoSuchElementException e) {
			System.out.println("You can't trick me");
		}
		
		return null;
	
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() throws NoSuchElementException {
		try {
			if(isEmpty()) {
				throw new NoSuchElementException();
			}else {
				return tail.data;
			}
		}catch(NoSuchElementException e) {
			System.out.println("You can't trick me");
		}
		
		return null;
	}
	

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		if(size ==0) {
			Node<T> newNode = new Node<>(null, null, item);
			tail = newNode;
			head = newNode;
			size++;
		}else {
			Node<T> newNode = new Node<>(null, head, item);
			head.setPrev(newNode);
			head = newNode;
			size++;
			
		}
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		if(size == 0) {
			Node<T> newNode = new Node<>(null, null, item);
			tail = newNode;
			head = newNode;
			size++;
		}else {
			Node<T> newNode = new Node<>(tail, null, item);
			tail.setNext(newNode);
			tail = newNode;
			size++;
			
		}
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		
		if(size == 0) {
			return null;
		}else if(size == 1) {
			clear();
		}else {
			head = head.getNext();
			head.setPrev(null);
			size --;
		}
		return null;
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		if(size == 0) {
			return null;
		}else if(size == 1) {
			clear();
		}else {
			tail = tail.getPrev();
			tail.setNext(null);
			size --;
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		LinkedList<String> newList = new LinkedList<>(); 
		
		newList.add("hey");
		newList.add("no");
		newList.add("yikes");
		newList.add("jesus",2);
		newList.indexOf(1);
		
		newList.run();
		
		
	}
	
}