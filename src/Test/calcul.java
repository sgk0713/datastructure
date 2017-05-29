package Test;

import java.util.Scanner;

public class calcul {

	public static void main(String[] args) {
		Stack<Double> operand = new Stack<Double>();
		Stack<Character> operator = new Stack<Character>();
		System.out.println("수식을 입력하세요");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		int j=0;
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i)=='-'){
				if(i==0) continue;
				else if(str.charAt(i-1)=='*'||str.charAt(i-1)=='/'||str.charAt(i-1)=='+'||str.charAt(i-1)=='-') continue;
			}
			if(str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)=='+'||str.charAt(i)=='-'){
				operand.push(Double.valueOf(str.substring(j, i)));
				if(!operator.isEmpty()){
					if(operator.top()=='*'||operator.top()=='/'){
						double temp1 = Double.valueOf(operand.pop());
						double temp2 = Double.valueOf(operand.pop());
						if(operator.top()=='*') operand.push(Double.valueOf(temp2 * temp1));
						else if(operator.top()=='/') operand.push(Double.valueOf(temp2 / temp1));
						operator.pop();
					}
				}
				if(!operator.isEmpty()){
					if((str.charAt(i)=='+'||str.charAt(i)=='-')){
						if(operator.top()=='+'||operator.top()=='-'){
							double temp1 = Double.valueOf(operand.pop());
							double temp2 = Double.valueOf(operand.pop());							
							if(operator.top()=='+') operand.push(Double.valueOf(temp2 + temp1));
							else if(operator.top()=='-') operand.push(Double.valueOf(temp2 - temp1));
							operator.pop();
						}
					}
				}
				operator.push(str.charAt(i));
				j = i+1;
			}else if(i==str.length()-1) operand.push(Double.valueOf(str.substring(j)));
		}
		while(!operator.isEmpty()){
			double temp1 = Double.valueOf(operand.pop());
			double temp2 = Double.valueOf(operand.pop());
			if(operator.top()=='+') operand.push(Double.valueOf(temp2 + temp1));
			else if(operator.top()=='-') operand.push(Double.valueOf(temp2 - temp1));
			else if(operator.top()=='*') operand.push(Double.valueOf(temp2 * temp1));
			else if(operator.top()=='/') operand.push(Double.valueOf(temp2 / temp1));
			operator.pop();
		}
		System.out.println(operand.pop());
	}
}
