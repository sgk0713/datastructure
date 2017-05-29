package Test;

public class Stack<E>{
		
		private class Node<E>{
			E data;
			Node<E> next;
			Node(E data){
				this.data = data;
				this.next = null;
			}
		}
		
		private Node<E> top;
		private int size = 0;
		
		
		public void push(E data){
			Node<E> newNode = new Node<E>(data);
			newNode.next = top;
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
			return size == 0 ? true:false;
		}
		
		public E top(){
			return top == null ? null : top.data;
		}
		
		public int size(){
			return size;
		}
		
		public String printStack(){
			if(isEmpty()) return "()";
			else{
				int cnt = size;
				Node<E> temp = top;
				String text = (String) temp.data;
				while(cnt!=1){
					temp = temp.next;
					text = text + ", "  + temp.data; 
					cnt--;
				}
			return "(" +text+")";
			}
		}
		
		public static void main(String[] args){
			Stack<String> s = new Stack<String>();
			s.push("1");
			s.push("2");
			s.push("3");
			s.push("4");
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
