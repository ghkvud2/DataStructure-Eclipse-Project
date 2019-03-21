import java.util.Stack;

public class InfixToPostfix {

	// ����ǥ������� ǥ��� exp�� ����ǥ������� ��ȯ�ϴ� �޼ҵ�
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

	// �������� �켱������ ��ȯ�ϴ� �޼ҵ�
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

	// op1�� �켱������ ������ true, ������ false�� ��ȯ
	public boolean isProceed(char op1, char op2) {

		int op1Prec = getOpPrec(op1);
		int op2Prec = getOpPrec(op2);

		if (op1Prec >= op2Prec)
			return true;
		else
			return false;

	}

}
