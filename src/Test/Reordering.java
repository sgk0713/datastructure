package Test;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
public class Reordering {

	public static void main(String[] args) {
		/*Deque<Integer> D = new LinkedList<Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		
		int[] num = {8,7,6,5,4,3,2,1};
		for(int i : num) D.addFirst(i);
		
		System.out.println("Elements of D : "+D);
		D.addLast(D.removeFirst());
		D.addLast(D.removeFirst());
		D.addLast(D.removeFirst());
		Q.add(D.removeFirst());
		D.addLast(D.removeFirst());
		D.addLast(Q.remove());
		D.addLast(D.removeFirst());
		D.addLast(D.removeFirst());
		D.addLast(D.removeFirst());
		System.out.println("Elements of D : "+D);
	}*/
		String str="13531";
		String str2="13531";
		System.out.println(str);
		System.out.println(StringToInt(str));
		if(str.equals(StringToInt(str))){
			System.out.println("same");
		}else System.out.println("no");
	}
		
	 static int StringToInt(String s){
		 int i;
			
			if(s.length() == 1){
				i = (int)(s.charAt(0)-48);
				return i;
			}else{
				i = (int) ((s.charAt(0)-48)*Math.pow(10, s.length()-1));
				s = s.substring(1, s.length());
				return i + StringToInt(s);
			}
			/*
		int a[]="13531";
		
	}
	
	public int stringToInt(int a[], int i) {
		int n=a.length;
		if (i == 1)
				return a[n-1] - '0';
		return stringToInt(a ,i-1)*10+a[n-i]-'0';
	 }*/
}
}

