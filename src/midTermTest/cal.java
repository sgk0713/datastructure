package midTermTest;

import java.util.Scanner;

public class cal{
	public static void main(String[] args){
	Stack_T<Character> operator = new Stack_T<>();
	Stack_T<Double> operand = new Stack_T<>();
	Scanner scan = new Scanner(System.in);
	String str  = scan.nextLine();
	scan.close();
	
	int j= 0;
	
	for(int i = 0; i<str.length(); i++){
		if(str.charAt(i)=='-'){
			if(i==0) continue;
			else if(str.charAt(i-1)=='*'||str.charAt(i-1)=='/'||str.charAt(i-1)=='+'||str.charAt(i-1)=='-') continue;
		}
		
		if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
			operand.push(Double.valueOf(str.substring(j, i)));
			if(!operator.isEmpty()){
				if(operator.top()=='*'||operator.top()=='/'){
					double temp1 = operand.pop();
					double temp2 = operand.pop();
					if(operator.top()=='*') operand.push(temp2*temp1);
					if(operator.top()=='/') operand.push(temp2/temp1);
					operator.pop();
				}
			}
			if(!operator.isEmpty()){
				if(str.charAt(i)=='+'||str.charAt(i)=='-'){
					if(operator.top()=='+'||operator.top()=='-'){
						double temp1 = operand.pop();
						double temp2 = operand.pop();
						if(operator.top()=='+') operand.push(temp2+temp1);
						if(operator.top()=='-') operand.push(temp2-temp1);
						operator.pop();
					}
				}
			}
			operator.push(str.charAt(i));
			
			j = i+1;
		}
		
		if(i==str.length()-1) operand.push(Double.valueOf(str.substring(j)));
	
	}
	
	while(!operator.isEmpty()){
		double temp1 = operand.pop();
		double temp2 = operand.pop();
		if(operator.top()=='*') operand.push(temp2*temp1);
		if(operator.top()=='/') operand.push(temp2/temp1);
		if(operator.top()=='+') operand.push(temp2+temp1);
		if(operator.top()=='-') operand.push(temp2-temp1);
		operator.pop();
	}
	
	System.out.println("="+ operand.printStack());
	}
}
