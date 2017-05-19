package Test;

public class Stack{
		
		private class Node{
			Object data;
			Node next;
			Node(Object data){
				this.data = data;
				this.next = null;
			}
		}
		
		private Node top;
		private int size = 0;
		public void push(Object data){
			Node newNode = new Node(data);
			newNode.next = top;
			top = newNode;
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
		
		public Object printStack(){
			if(isEmpty()) return "()";
			else{
				int cnt = size;
				Node temp = top;
				Object text = temp.data;
				while(cnt!=1){
					temp = temp.next;
					text = text + ", "  + temp.data; 
					cnt--;
				}
			return "(" +text+")";
			}
		}
		
		public static void main(String[] args){
			Stack s = new Stack();
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			System.out.println(s.printStack());
			System.out.println("size : "+s.size());
			System.out.println("top : "+s.top());
			System.out.println("pop : "+s.pop());
			System.out.println("isEmpty? : " + s.isEmpty());
			
			System.out.println(s.printStack());
			System.out.println("size : "+s.size());
			System.out.println("top : "+s.top());
			System.out.println("pop : "+s.pop());
			System.out.println("isEmpty? : " + s.isEmpty());

			System.out.println(s.printStack());
			System.out.println("size : "+s.size());
			System.out.println("top : "+s.top());
			System.out.println("pop : "+s.pop());
			System.out.println("isEmpty? : " + s.isEmpty());

			System.out.println(s.printStack());
			System.out.println("size : "+s.size());
			System.out.println("top : "+s.top());
			System.out.println("pop : "+s.pop());
			System.out.println("isEmpty? : " + s.isEmpty());
			
			System.out.println(s.printStack());
			System.out.println("size : "+s.size());
			System.out.println("top : "+s.top());
			System.out.println("pop : "+s.pop());
			System.out.println("isEmpty? : " + s.isEmpty());
			
			
						
		}
}
