package main;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
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
		// TODO Auto-generated method stub
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
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		size = 0;
		run();
	}

	@Override
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		// TODO method stub
		return null;
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		// TODO method stub
		return null;
	}
	
	public void addEmpty(T item) {
		Node<T> newNode = new Node<>(null, null, item);
		tail = newNode;
		head = newNode;
		size++;
		run();
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		// TODO method stub
		if(size ==0) {
			addEmpty(item);
		}else {
			Node<T> newNode = new Node<>(null, head, item);
			head.setPrev(newNode);
			head = newNode;
			size++;
			run();
		}
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		// TODO method stub
		if(size == 0) {
			addEmpty(item);
		}else {
			Node<T> newNode = new Node<>(tail, null, item);
			tail.setNext(newNode);
			tail = newNode;
			size++;
			run();
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
		// TODO method stub
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
		// TODO method stub
		return null;
	}
	
	public static void main(String[] args) {
		LinkedList<String> newList = new LinkedList<>(); 
		
		newList.add("hey");
		newList.add("hi");
		newList.add("what");
		newList.clear();
	}
	
}