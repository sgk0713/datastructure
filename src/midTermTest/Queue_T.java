package midTermTest;

public class Queue_T<E> {
	
	private Node<E> front;
	private Node<E> rear;
	private int size=0;
	
	private class Node<E>{
		E data;
		Node<E> next;
		Node(E data){
			this.data = data;
		}
	}
	
	public void Enqueue(E data){
		Node<E> newNode = new Node<E>(data);
		if(size==0) front = newNode;
		else rear.next = newNode;
		rear = newNode;
		size++;
	}
	
	public E dequeue(){
		Node<E> old = front;
		front = front.next;
		size--;
		return old.data; 
	}
	
	public boolean isEmpty(){
		return size==0 ? true :false;
	}
	
	public int size(){
		return size;
	}
	
	public E front(){
		return (E)front.data;
	}
	
	public String printQueue(){
		if(!isEmpty()){
			String txt = String.valueOf(front.data);
			Node<E> temp = front.next;
			while(temp!=null){
				txt += ", "+ String.valueOf(temp.data);
				temp = temp.next;
			}
			return "("+txt+")";
		}
		else return null;
	}
	
	
}
