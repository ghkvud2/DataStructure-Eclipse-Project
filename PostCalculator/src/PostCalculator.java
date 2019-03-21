import java.util.Stack;

public class PostCalculator {

	public static int calPostfix(String input) {

		Stack<Integer> stack = new Stack<>();
		int len = input.length();

		for (int i = 0; i < len; i++) {

			char op = input.charAt(i);

			if (op >= '1' && op <= '9') {
				stack.push(op - '0');
			} else {

				int op2 = stack.pop();
				int op1 = stack.pop();

				switch (op) {

				case '+':
					stack.push(op1 + op2);
					break;
				case '-':
					stack.push(op1 - op2);
					break;
				case '*':
					stack.push(op1 * op2);
					break;
				case '/':
					stack.push(op1 / op2);
					break;
				}
			}
		}
		return stack.pop();
	}
}
