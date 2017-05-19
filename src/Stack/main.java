package Stack;
public class main {
	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println("Method\t\tReturn Value\tStack Contents");
		System.out.println("push(5)\t\t" + stack.push("5") + "\t\t" + stack.PrintStack());
		System.out.println("push(3)\t\t" + stack.push("3") + "\t\t" + stack.PrintStack());
		System.out.println("size()\t\t"  + stack.size()    + "\t\t" + stack.PrintStack());
		System.out.println("pop()\t\t"   + stack.pop()     + "\t\t" + stack.PrintStack());
		System.out.println("isEmpty()\t" + stack.isEmpty() + "\t\t" + stack.PrintStack());
		System.out.println("pop()\t\t"   + stack.pop()     + "\t\t" + stack.PrintStack());
		System.out.println("isEmpty()\t" + stack.isEmpty() + "\t\t" + stack.PrintStack());
		System.out.println("pop()\t\t"   + stack.pop()     + "\t\t" + stack.PrintStack());
		System.out.println("push(7)\t\t" + stack.push("7") + "\t\t" + stack.PrintStack());
		System.out.println("push(9)\t\t" + stack.push("9") + "\t\t" + stack.PrintStack());
		System.out.println("top()\t\t"   + stack.top()     + "\t\t" + stack.PrintStack());
		System.out.println("push(4)\t\t" + stack.push("4") + "\t\t" + stack.PrintStack());
		System.out.println("size()\t\t"  + stack.size()    + "\t\t" + stack.PrintStack());
		System.out.println("pop()\t\t"   + stack.pop()     + "\t\t" + stack.PrintStack());
		System.out.println("push(6)\t\t" + stack.push("6") + "\t\t" + stack.PrintStack());
		System.out.println("push(8)\t\t" + stack.push("8") + "\t\t" + stack.PrintStack());
		System.out.println("pop()\t\t"   + stack.pop()     + "\t\t" + stack.PrintStack());
	}
}