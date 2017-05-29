package midTermTest;

public class run {

	public static void main(String[] args) {
		// Queue_T<Integer> q = new Queue_T<>();
		// System.out.println("size : "+q.size());
		// System.out.println("isEmpty : "+q.isEmpty());
		// q.Enqueue(1);
		// System.out.println("isEmpty : "+q.isEmpty());
		// q.Enqueue(2);
		// q.Enqueue(3);
		// q.Enqueue(4);
		// q.Enqueue(5);
		// q.Enqueue(6);
		// System.out.println("size : "+q.size());
		// System.out.println(q.printQueue());

		// Stack_T<Integer> s = new Stack_T<>();
		// System.out.println("top() : " + s.top());
		// System.out.println("isEmpty() : " + s.isEmpty());
		// s.push(1);
		// System.out.println("isEmpty() : " + s.isEmpty());
		// s.push(2);
		// s.push(3);
		// System.out.println("top() : "+s.top());
		// s.push(4);
		// System.out.println("size : "+ s.size());
		// System.out.println("pop : "+s.pop());
		// System.out.println("size : "+ s.size());
		// System.out.println(s.printStack());

		BST_T bst = new BST_T();
		bst.put(50, "50");
		bst.put(20, "20");
		bst.put(70, "70");
		bst.put(10, "10");
		bst.put(30, "30");
		bst.put(25, "25");
		bst.put(21, "21");
		bst.put(27, "27");
		bst.put(60, "60");
		bst.put(90, "90");
		bst.put(100, "100");
		bst.inOrder(bst.root);
		System.out.println("remove : " + bst.remove(70));
		System.out.println("remove : " + bst.remove(25));
		System.out.println("remove : " + bst.remove(30));
//		System.out.println("remove : " + bst.remove(50));
//		System.out.println("remove : " + bst.remove(10));
//		System.out.println("remove : " + bst.remove(20));
//		System.out.println("remove : " + bst.remove(21));
//		System.out.println("remove : " + bst.remove(27));
//		System.out.println("remove : " + bst.remove(60));
//		System.out.println("remove : " + bst.remove(90));
//		System.out.println("remove : " + bst.remove(100));
		bst.inOrder(bst.root);

	}

}
