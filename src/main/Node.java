package main;



public class Node<T> {
	private Node<T> next, prev;
	T data;
	
	public Node() {
		this.setPrev(null);
		this.setNext(null);
		this.data = null;
	}
	
	public Node( Node<T> prev,Node<T> next, T data) {
		this.data = data;
		this.setNext(next);
		this.setPrev(prev);
	}

	
	/**
	 * @return the prev
	 */
	public Node<T> getPrev() {
		return this.prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return this.next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	

	public String toString() {
		int returnNext = System.identityHashCode(next);
		int returnPrev = System.identityHashCode(prev);
		return " Prev: " +returnPrev+
				"Next: " + returnNext +
				" Data: " +this.data + "     ";
	}
	
	
	
}
