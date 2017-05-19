package Stack;
public class Stack{
	private Node top;
	private int size=0;
	
	private class Node{
		private String data;
		private Node next;
		Node(String data){
			this.data = data;
		}
	}
	
	//adds element to the top of the stack
	public String push(String data){
		Node NewNode = new Node(data);
		NewNode.next = top;
		top = NewNode;
		size++;
		return "-";
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
	public String top(){
		return top.data;
	}
	
	//returns the number of elements in the stack
	public int size(){
		return size;
	}
	
	//returns a boolean indicating whether the stack is empty
	public boolean isEmpty(){
		return top == null ? true : false;
	}
	
	public String PrintStack(){
		if(size == 0) return"()";
		else{
			int count = size-1;
			String text = top.data;
			Node temp = top;
			while(count != 0){
				temp = temp.next;
				text = temp.data + ", " + text;
				count--;
			}
		return "("+text+")";
		}
	}
	
}