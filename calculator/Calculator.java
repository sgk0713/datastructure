package calculator;

import java.util.Scanner;

public class Calculator {
	// ����
	Stack<Double> operand;
	// ������
	Stack<Character> operator;
	// �Է� ��Ʈ��
	String inputStr;
	
	// ������
	public Calculator() {
		operand = new Stack<Double>();
		operator = new Stack<Character>();
	}
	
	// �Է¹޴� �Լ�
	public void input() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("������ �Է��� �ּ��� : ");
		inputStr = s.nextLine();
	}
	
	// Calculator�� main�Լ� ������
	public void run() {
		// �Է¹ް�
		input();
		
		// ���� ���� �ִ� ���ڰ� ������ ��� :		flag = 1
		// ���� ���� �ִ� ���ڰ� �����ڶ�� :		flag = 2
		// �Ѵ� �ƴ϶�� : 					flag = 0
		int flag = 0;
		// �� ���� 1 �Ǵ� -1�� ��(�������� ������� �����ִ� ��)
		int minusFactor = 1;
		// �Է¹��� ��Ʈ������ ���ڵ鸸 ���� �� ���� �ӽ� ����
		double tmpNum = 0;
		for (int i = 0; i < inputStr.length(); i++) {
			// chr = i��° ����
			char chr = inputStr.charAt(i);
			// ���� ���ڶ��
			if ('0' <= chr && chr <= '9') {
				// �ӽ� ���� ����
				tmpNum *= 10;
				tmpNum += chr - '0';
				flag = 1;
			} else {
				// ���ڰ� �ƴҰ��
				if (flag == 1) {
					// ��ݱ��� ������ ��� operand�� push
					operand.push(tmpNum * minusFactor);
					// ������ �ʱ�ȭ
					tmpNum = 0;
					flag = 0;
					minusFactor = 1;
				}
				if (isOperator(chr)) {
					// ���� ���� �ִ� ���ڰ� -��ȣ ���
					if ((i == 0 || flag == 2) && chr == '-') {
						minusFactor = -1;
						flag = 0;
					} else {
						// - ��ȣ�� �ƴ϶� operator���
						// 1) operator stack�� �ϳ��� �ְ�
						// 2) ���� �������� �켱�������� stack�� top�� �켱������ �� ���ٸ� �̸� ����ؾ� �ϹǷ�
						while (!operator.isEmpty() &&
								priority(chr) <= priority(operator.top())) {
							// ���
							operate();
						}
						// ������� �Դٸ� stack�� ����ְų� ���� stack�� top�� �ִ� �켱������ 
						// ���� �������� �켱�������� ���� ���̹Ƿ� �� ���� push
						operator.push(chr);
						// ���� �Է� ���� �༮�� �������̹Ƿ� �ٲ���
						flag = 2;
					}
				} else if (chr == '(') {
					// ( �ϰ�� ������ push
					operator.push('(');
				} else if (chr == ')') {
					// ) �ϰ��
					// ( �� ���ö� ���� ���� �������� �ϹǷ� ���
					while (operator.top() != '(') {
						operate();
					}
					// top�� ) �ϰ�� �̹Ƿ� pop
					operator.pop();
				}
			}
		}
		// ������ �Է��� ������ ���̹Ƿ� push
		operand.push(tmpNum * minusFactor);
		
		// operator�� ������� ���������� ��� ���
		while (!operator.isEmpty()) {
			operate();
		}
		
		// ������ �� ���
		System.out.println(" = " + operand.pop());
	}
	
	// ����Լ�
	// operand�� 2���� ����, operator�� 1���� ����
	// �� �ΰ����� ���
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
	
	// �켱������ �����ִ� �Լ�
	private int priority(char chr) {
		if (chr == '(' || chr == ')') return 0;
		if (chr == '+' || chr == '-') return 1;
		if (chr == '*' || chr == '/') return 2;
		return -1;
	}
	
	// ���������� �ƴ����� �˷��ִ� �Լ�
	private boolean isOperator(char chr) {
		return chr == '+' || chr == '-' || chr == '*' || chr == '/';
	}
}
