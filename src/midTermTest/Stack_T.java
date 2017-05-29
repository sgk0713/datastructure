package midTermTest;

public class Stack_T<E>{
	
	private class Node<E>{
		Node<E> next=null;
		E data;
		Node(E data){
			this.data = data;
		}
	}
	
	private Node<E> top;
	private int size = 0;
	
	public void push(E data){
		Node<E> newNode = new Node<E>(data);
		if(size != 0) newNode.next = top;
		top = newNode;
		size++;
	}
	
	public E pop(){
		if(isEmpty()) return null;
		Node<E> temp = top;
		top = top.next;
		size--;
		return temp.data;
	}
	
	public boolean isEmpty(){
		return size==0 ? true : false;
	}
	
	public int size(){
		return size;
	}
	
	public E top(){
		return size == 0 ? null:top.data;
	}
	
	public String printStack(){
		if(!isEmpty()){
			String txt = String.valueOf(top.data);
			Node<E> temp = top;
			while(temp.next != null){
				temp = temp.next;
				txt += ", " + String.valueOf(temp.data);
			}
			return "("+txt+")";
		}
		else return null;
	}
	
}
