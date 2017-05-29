package Queue;
public class Queue {
	
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("1");
		System.out.println("queue list : " + q.printQueue());
		System.out.println("size : "+q.size());
		System.out.println("first() : " + q.first());
		System.out.println("isEmpty() : " + q.isEmpty());
		System.out.println("dequeue() : " + q.dequeue());
		System.out.println();
		System.out.println("queue list : " + q.printQueue());
		System.out.println("size : "+q.size());
		System.out.println("first() : " + q.first());
		System.out.println("isEmpty() : " + q.isEmpty());
		System.out.println("dequeue() : " + q.dequeue());
		System.out.println();
		System.out.println("queue list : " + q.printQueue());
		System.out.println("size : "+q.size());
		System.out.println("first() : " + q.first());
		System.out.println("isEmpty() : " + q.isEmpty());
		System.out.println("dequeue() : " + q.dequeue());
		System.out.println();
		System.out.println("queue list : " + q.printQueue());
		System.out.println("size : "+q.size());
		System.out.println("first() : " + q.first());
		System.out.println("isEmpty() : " + q.isEmpty());
		System.out.println("dequeue() : " + q.dequeue());
		System.out.println();
		System.out.println("queue list : " + q.printQueue());
		System.out.println("size : "+q.size());
		System.out.println("first() : " + q.first());
		System.out.println("isEmpty() : " + q.isEmpty());
		System.out.println("dequeue() : " + q.dequeue());
		System.out.println();
	}
	
	
	private Node front;
	private Node rear=front;
	private int size = 0;
	
	private class Node{
		String data;
		Node next;
		Node(String data){
			this.data = data;
		}
	}
	
	public void enqueue(String data){
		Node newNode = new Node(data);
		if(front == null){
			front = newNode;
			rear = front;
		}else{
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public String dequeue(){
		if(isEmpty()){
			return null;
		}else{
			Node temp = front;
			front = front.next;
			size--;
			return temp.data;			
		}
		
	}
	
	
	public boolean isEmpty(){
		return size == 0 ? true : false;
	}
	
	public String first(){
		return size == 0 ? null : front.data;
	}
	
	public int size(){
		return size;
	}
	
	public String printQueue(){
		if(size()==0) return "()";
		else{
			Node temp = front;
			String text = temp.data;
			temp = temp.next;
			while(temp != null){
				text += ", " +temp.data;
				temp = temp.next;
			}
			return "(" + text +")";
		}
	}
	
	
	/*
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
	}*/
}