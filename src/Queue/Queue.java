package Queue;
public class Queue {
	private int size;
	private Node front;
	private Node rear;
	
	private class Node{
		private String data;
		private Node prev;
		Node(String data){
			this.data = data;
		}
	}
	
	//adds element 'data' to the back of queue
	public String enqueue(String data){
		Node NewNode = new Node(data);
		if(front == null) {
			front = NewNode;
			rear = front;
		}else{ 
			rear.prev = NewNode;
			rear = NewNode;
		}
		size++;
		return "-";
	}
	
	//removes and returns the first element from the queue (or null if the queue is empty)
	public Object dequeue(){
		if(isEmpty()) return null;
		Node out = front;
		front = front.prev;
		size--;
		return out.data;
	}
	
	//returns the first element of the queue, without removing it(or null if the queue is empty)
	public String first(){
		return front.data;
	}
	
	//returns the number of elements in the queue
	public int size(){
		return size;
	}
	
	//returns a boolean indicating whether the queue is empty
	public boolean isEmpty(){
		return front == null ? true : false;
	}
	
	public String PrintQueue(){
		if(size == 0) return "()";
		else {
			int count = size-1;
			String text = front.data;
			Node temp = front;
			while(count != 0){
				temp = temp.prev;
				text = text + ", " + temp.data;
				count--;
			}
			return "("+text+")";
			
		}
	}
}