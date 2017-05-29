package calculator;

import java.util.Scanner;

public class Calculator {
	// 숫자
	Stack<Double> operand;
	// 연산자
	Stack<Character> operator;
	// 입력 스트링
	String inputStr;
	
	// 생성자
	public Calculator() {
		operand = new Stack<Double>();
		operator = new Stack<Character>();
	}
	
	// 입력받는 함수
	public void input() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("수식을 입력해 주세요 : ");
		inputStr = s.nextLine();
	}
	
	// Calculator의 main함수 같은거
	public void run() {
		// 입력받고
		input();
		
		// 현재 보고 있는 문자가 숫자일 경우 :		flag = 1
		// 현재 보고 있는 문자가 연산자라면 :		flag = 2
		// 둘다 아니라면 : 					flag = 0
		int flag = 0;
		// 이 값은 1 또는 -1이 됨(음수인지 양수인지 곱해주는 값)
		int minusFactor = 1;
		// 입력받은 스트링에서 숫자들만 뽑을 때 쓰는 임시 변수
		double tmpNum = 0;
		for (int i = 0; i < inputStr.length(); i++) {
			// chr = i번째 문자
			char chr = inputStr.charAt(i);
			// 만약 숫자라면
			if ('0' <= chr && chr <= '9') {
				// 임시 변수 갱신
				tmpNum *= 10;
				tmpNum += chr - '0';
				flag = 1;
			} else {
				// 숫자가 아닐경우
				if (flag == 1) {
					// 방금까지 숫자인 경우 operand에 push
					operand.push(tmpNum * minusFactor);
					// 나머지 초기화
					tmpNum = 0;
					flag = 0;
					minusFactor = 1;
				}
				if (isOperator(chr)) {
					// 현재 보고 있는 문자가 -부호 라면
					if ((i == 0 || flag == 2) && chr == '-') {
						minusFactor = -1;
						flag = 0;
					} else {
						// - 부호가 아니라 operator라면
						// 1) operator stack이 하나라도 있고
						// 2) 현재 연산자의 우선순위보다 stack의 top의 우선순위가 더 높다면 미리 계산해야 하므로
						while (!operator.isEmpty() &&
								priority(chr) <= priority(operator.top())) {
							// 계산
							operate();
						}
						// 여기까지 왔다면 stack이 비어있거나 현재 stack의 top에 있는 우선순위는 
						// 현재 연산자의 우선순위보다 작을 것이므로 맨 위에 push
						operator.push(chr);
						// 현재 입력 받은 녀석은 연산자이므로 바꿔줌
						flag = 2;
					}
				} else if (chr == '(') {
					// ( 일경우 무조건 push
					operator.push('(');
				} else if (chr == ')') {
					// ) 일경우
					// ( 가 나올때 까지 전부 계산해줘야 하므로 계산
					while (operator.top() != '(') {
						operate();
					}
					// top이 ) 일경우 이므로 pop
					operator.pop();
				}
			}
		}
		// 마지막 입력은 숫자일 것이므로 push
		operand.push(tmpNum * minusFactor);
		
		// operator가 비어있지 않을때까지 계속 계산
		while (!operator.isEmpty()) {
			operate();
		}
		
		// 마지막 값 출력
		System.out.println(" = " + operand.pop());
	}
	
	// 계산함수
	// operand의 2개를 빼고, operator의 1개를 빼서
	// 그 두개끼리 계산
	private void operate() {
		double numA = operand.pop();
		double numB = operand.pop();
		char oper = operator.pop();
		if (oper == '+') {
			operand.push(numA + numB);
		} else if (oper == '-') {
			operand.push(numB - numA);
		} else if (oper == '*') {
			operand.push(numA * numB);
		} else {
			operand.push(numB / numA);
		}
	}
	
	// 우선순위를 정해주는 함수
	private int priority(char chr) {
		if (chr == '(' || chr == ')') return 0;
		if (chr == '+' || chr == '-') return 1;
		if (chr == '*' || chr == '/') return 2;
		return -1;
	}
	
	// 연산자인지 아닌지를 알려주는 함수
	private boolean isOperator(char chr) {
		return chr == '+' || chr == '-' || chr == '*' || chr == '/';
	}
}
