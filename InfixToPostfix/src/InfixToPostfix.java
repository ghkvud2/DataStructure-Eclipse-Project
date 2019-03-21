import java.util.Stack;

public class InfixToPostfix {

	// 중위표기법으로 표기된 exp를 후위표기법으로 변환하는 메소드
	public String convToExpression(String exp) {

		Stack<Character> stack = new Stack<>();
		int len = exp.length();
		String postFix = "";

		for (int i = 0; i < len; i++) {

			char ch = exp.charAt(i);
			if (ch >= '1' && ch <= '9') {

				postFix += ch;

			} else {

				switch (ch) {

				case '(':
					stack.push(ch);
					break;

				case ')':
					while (true) {
						char pop = stack.pop();
						if (pop == '(')
							break;
						postFix += pop;
					}
					break;

				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && isProceed(stack.peek(), ch))
						postFix += stack.pop();
					stack.push(ch);
					break;
				}

			}
		}

		while (!stack.isEmpty())
			postFix += stack.pop();

		return postFix;

	}

	// 연산자의 우선순위를 반환하는 메소드
	public int getOpPrec(char op) {

		switch (op) {
		case '*':
		case '/':
			return 5;

		case '+':
		case '-':
			return 3;

		case '(':
			return 1;
		}
		return -1;
	}

	// op1의 우선순위가 높으면 true, 낮으면 false를 반환
	public boolean isProceed(char op1, char op2) {

		int op1Prec = getOpPrec(op1);
		int op2Prec = getOpPrec(op2);

		if (op1Prec >= op2Prec)
			return true;
		else
			return false;

	}

}
