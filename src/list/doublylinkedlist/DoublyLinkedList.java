package list.doublylinkedlist;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node{
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object input){
			this.data = input;
			this.next = null;
			this.prev = null;
		}
	}
	
	public void addFirst(Object input){
		Node newNode = new Node(input);
		newNode.next = head;
		if(head != null){
			head.prev = head;
		}
	}
	
}
