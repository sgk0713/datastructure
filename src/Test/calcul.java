package Test;

import java.util.Scanner;

public class calcul {

	public static void main(String[] args) {
		Stack operand = new Stack();
		Stack operator = new Stack();
		System.out.println("수식을 입력하세요");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		int cnt = 0;
		String num[] = str.split("[+-/*]");
		int i = 0;
		while(cnt != str.length()+1){
			operand.push(num[i]);
			i++;
			if(((str.charAt(cnt) == '+' )||(str.charAt(cnt) == '-'))||((str.charAt(cnt) == '*')||(str.charAt(cnt) == '/'))){
				operator.push(str.charAt(cnt));
				
			}
			cnt--;
		}
		
		int i = -1;

		while(true)

		{

			i++;

			try

			{

			System.out.print(aa[i]+" ");

			}

			catch(Exception e){break;}
		}
	}
}
