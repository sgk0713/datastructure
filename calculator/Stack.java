package calculator;

public class Stack<E> {
	Node<E> top;
	
	private class Node<E> {
		private Node<E> next;
		private E data;
		
		public Node(E data) {
			next = null;
			this.data = data;
		}
		
		public E getData() {
			return data;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	public Stack() {
		top = null;
	}
	
	public void push(E data) {
		Node<E> newNode = new Node<E>(data);
		if (isEmpty()) {
			top = newNode;
			return;
		}
		newNode.setNext(top);
		top = newNode;
	}
	
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		Node<E> popNode = top;
		top = top.getNext();
		return popNode.getData();
	}
	
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return top.getData();
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
