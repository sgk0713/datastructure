package Queue;
public class main {
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println("Method\t    Return Value\tfirst <- Q <- last");
		System.out.println("enqueue(5)\t" + q.enqueue("5") + "\t\t" + q.PrintQueue());//enqueue(5)	-	  (5)
		System.out.println("enqueue(3)\t" + q.enqueue("3") + "\t\t" + q.PrintQueue());//enqueue(3)	-	  (5,3)
		System.out.println("size()\t\t"   + q.size()       + "\t\t" + q.PrintQueue());//size()		2	  (5,3)
		System.out.println("dequeue()\t"  + q.dequeue()    + "\t\t" + q.PrintQueue());//dequeue()	5	  (3)
		System.out.println("isEmpty()\t"  + q.isEmpty()    + "\t\t" + q.PrintQueue());//isEmpty()	false (3)
		System.out.println("dequeue()\t"  + q.dequeue()    + "\t\t" + q.PrintQueue());//dequeue()	3	  ()
		System.out.println("isEmpty()\t"  + q.isEmpty()    + "\t\t" + q.PrintQueue());//isEmpty()	true  ()
		System.out.println("dequeue()\t"  + q.dequeue()    + "\t\t" + q.PrintQueue());//dequeue()	null  ()
		System.out.println("enqueue(7)\t" + q.enqueue("7") + "\t\t" + q.PrintQueue());//enqueue(7)	-	  (7)
		System.out.println("enqueue(9)\t" + q.enqueue("9") + "\t\t" + q.PrintQueue());//enqueue(9)	-	  (7,9)
		System.out.println("first()\t\t"  + q.first()      + "\t\t" + q.PrintQueue());//first()		7	  (7,9)
		System.out.println("enqueue(4)\t" + q.enqueue("4") + "\t\t" + q.PrintQueue());//enqueue(4)	-	  (7,9,4)
	}
}
