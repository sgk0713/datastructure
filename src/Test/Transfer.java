package Test;
import java.util.Stack;
public class Transfer {

   public static void main(String[] args) {
      
      Stack<Integer> S = new Stack<Integer>();
      Stack<Integer> T = new Stack<Integer>();
      
      int[] num = {1,2,3,4,5,6,7,8,9};
      for(int i : num) S.push(i);
      
      
      System.out.println("Stack S : "+S);
      Trans(S, T);
      System.out.println(". . . TRANSFERRING \"Stack S\" to \"Stack T\" . . .");
      System.out.println("Stack T : "+T);
   }
   
   public static void Trans(Stack<Integer> a, Stack<Integer> b){//���� a�� ���Ҹ� pop�ؼ� ���� b�� �ű�� �޼ҵ�
 	  while(!a.empty())
 		  b.push(a.pop());
   }
}