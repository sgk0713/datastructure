package Calculator;

import java.util.Scanner;//입력을 위한 api importoooo\
import java.text.DecimalFormat;//소수점 표현을 위한 api import

public class Calculator{

	private static String str;
	private static Stack Operator, Number;
	private static int count = 0;
	private static boolean check = false;
   
	public static void main(String[] args){
		DecimalFormat df = new DecimalFormat("0.00");//소수점 2째자리까리 출력하기 위한 인스턴스 생성
		Operator = new Stack();// 연산자용 스택
		Number = new Stack();// 피연사자용 스택

		System.out.println("수식을 입력 하시오. 괄호사용은안됩니다.");
		
		Scanner input = new Scanner(System.in);
		str = "!"+input.nextLine();
		count = str.length()-1;
		input.close();
		System.out.println("\nNumber Stack\t\tOperator Stack\n");
		System.out.print("결과 : " + df.format(Result()));
	}//main END
	
	public static Double Result(){
		while (str != null) {
			char temp = str.charAt(count);
			if((temp=='+'||temp == '-') || (temp == '*' || temp == '/')){
				run(temp);
			}else if(temp == '!'){
				Number.push(Double.valueOf(str.substring(count+1, str.length())));
				Print();
				str = null;
			}else{
				count--;
				check = false;
			}
		}
		while (!Operator.isEmpty()) cal();
		return (Double)Number.top();
	}//Result() END
	
    private static void run(char temp){
		if(check){ 
			Operator.pop();
            Number.push(-(double)Number.pop());
            Operator.push(temp);
            Print();
            str = str.substring(0, count);
            count = str.length()-1;
            check=false;
        }else if(str.substring(0, count).length()==1){
			Number.push(-Double.valueOf(str.substring(count+1, str.length())));
            Print();
            str = null;
        }else{
            Number.push(Double.valueOf(str.substring(count+1, str.length())));
            Print();
            Object top = Operator.top();
            if(top != null && ((char)top == '*' || (char)top == '/')) cal();      
            Operator.push(temp);
            Print();      
            str = str.substring(0, count);
            count = str.length()-1;
            check=true;
         }
	}//run() END
	private static void cal() {   
		double x = (double) Number.pop(), y = (double) Number.pop();
		if(Operator.top().equals('+')){
			Operator.pop();
			Number.push(x + y);
		}else if(Operator.top().equals('-')){
			Operator.pop();
			Number.push(x - y);
		}else if(Operator.top().equals('*')){
			Operator.pop();
			Number.push(x * y);
		}else if(Operator.top().equals('/')){
			Operator.pop();
			Number.push(x / y);
		}
		Print();
	}//cal() END
	
	private static void Print(){
		System.out.print("Number : "+ Number.printStack());
		System.out.print("\t\tOperator : "+ Operator.printStack());
		System.out.println();   
	}//Print() END
}
