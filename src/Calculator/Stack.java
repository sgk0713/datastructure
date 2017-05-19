package Calculator;
public class Stack{
/*	private Node top;
	private int size=0;
	
	private class Node{
		private Object data;
		private Node next;
		Node(Object data){
			this.data = data;
		}
	}
	
	//adds element to the top of the stack
	public void push(Object data){
		Node NewNode = new Node(data);
		NewNode.next = top;
		top = NewNode;
		size++;
	}
	
	//removes and returns the top element from the stack(or null if the stack is empty)
	public Object pop(){
	     if(isEmpty()) return null;
	     Node pop = top;
	     top = top.next;
	     size--;
	     return pop.data;
	}
	
	//returns the element of the stack, without removing it(or null if the stack is empty)
	public Object top(){
		return top == null ? null : top.data; 
	}
	
	//returns the number of elements in the stack
	public int size(){
		return size;
	}
	
	//returns a boolean indicating whether the stack is empty
	public boolean isEmpty(){
		return size == 0 ? true : false;
	}
	
	public String PrintStack(){
		if(size == 0) return"()";
		else{
			int count = size-1;
			Object text = top.data;
			Node temp = top;
			while(count != 0){
				temp = temp.next;
				text = temp.data + ", " + text;
				count--;
			}
		return "("+text+")";
		}
	}*/
	
	private Node top = null;
	private int size = 0;
	private class Node{
		Object data;
		Node next;
		Node(Object data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(Object data){
		Node newNode = new Node(data);
		top.next = newNode;
		newNode = top;
		size++;
	}
	public Object pop(){
		if(isEmpty()) return null;
		Node temp = top;
		top = top.next;
		size--;
		return temp.data;
	}
	
	public boolean isEmpty(){
		return size == 0 ? true:false;
	}
	
	public Object top(){
		return top == null ? null : top.data;
	}
	
	public int size(){
		return size;
	}
	
	public String printStack(){
		if(isEmpty()) return "()";
		else{
			int cnt = size;
			Node temp = top;
			Object text = top.data;
			while(cnt!=0){
				temp = temp.next;
				text = temp.data + ", " + text; 
				cnt--;
			}
		return "(" +text+")";
		}
	}
	
	public static void main(String[] args){
		Stack s = new Stack();
		s.push(1);
	}
}