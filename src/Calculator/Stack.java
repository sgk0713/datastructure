package Calculator;
public class Stack{
	
	public static void main(String[] args){
		Stack s = new Stack();
		s.push("1");
		s.push("2");
		s.push("2");
		s.push("2");
		s.push("2");
		s.push("2");
		System.out.println("Stack list : " + s.printStack());
		System.out.println("size : "+s.size());
		System.out.println("top() : " + s.top());
		System.out.println("isEmpty() : " + s.isEmpty());
		System.out.println("pop() : " + s.pop());
		System.out.println();
		System.out.println("Stack list : " + s.printStack());
		System.out.println("size : "+s.size());
		System.out.println("top() : " + s.top());
		System.out.println("isEmpty() : " + s.isEmpty());
		System.out.println("pop() : " + s.pop());
		System.out.println();
		System.out.println("Stack list : " + s.printStack());
		System.out.println("size : "+s.size());
		System.out.println("top() : " + s.top());
		System.out.println("isEmpty() : " + s.isEmpty());
		System.out.println("pop() : " + s.pop());
		System.out.println();
	}
	
	private int size = 0;
	private Node top;
	
	
	private class Node{
		Node next;
		String data;
		Node(String data){
			this.data = data;
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0 ? true : false;
	}
	
	public void push(String data){
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	public String top(){
		return size == 0 ? null : top.data;
	}
	
	public String pop(){
		if(isEmpty()) return null;
		Node temp = top;
		top = top.next;
		size--;
		return temp.data;
	}
	
	public String printStack(){
		if(isEmpty()) return "()";
		else{
			Node temp = top;
			String text = temp.data;
			temp = temp.next;
			while(temp!= null){
				text += ", "+temp.data;
				temp = temp.next;
			}
			return "("+text+")";
		}
	}
	
}