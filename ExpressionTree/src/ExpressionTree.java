import java.util.Stack;

public class ExpressionTree {

	static class Node {

		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {

		String infix = "(3+2)*4+(2*(3-1))*2";
		String postfix = Postfix.convToPostfix(infix.toCharArray());
		Node root = convToExpTree(postfix.toCharArray());
		System.out.println(infix + " : " + evalExpTree(root));
	}

	public static int evalExpTree(Node root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return root.data - '0';

		int op1 = evalExpTree(root.left);
		int op2 = evalExpTree(root.right);

		switch (root.data) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		default:
			return op1 / op2;
		}
	}

	public static Node convToExpTree(char[] postfix) {

		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < postfix.length; i++) {

			if (postfix[i] >= '0' && postfix[i] <= '9') {
				stack.push(new Node(postfix[i]));
			} else {

				Node op2 = stack.pop();
				Node op1 = stack.pop();
				Node op = new Node(postfix[i]);
				op.left = op1;
				op.right = op2;
				stack.push(op);
			}
		}
		return stack.pop();
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
}

class Postfix {

	public static String convToPostfix(char[] infix) {

		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length; i++) {

			if (infix[i] >= '0' && infix[i] <= '9') {
				sb.append(infix[i]);
			} else {
				switch (infix[i]) {

				case '(':
					stack.push(infix[i]);
					break;

				case ')':
					while (stack.peek() != '(')
						sb.append(stack.pop());
					stack.pop();
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && whoIsPrec(stack.peek(), infix[i]))
						sb.append(stack.pop());
					stack.push(infix[i]);
					break;
				}
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

	public static boolean whoIsPrec(char op1, char op2) {
		if (getOpPrec(op1) >= getOpPrec(op2))
			return true;
		else
			return false;
	}

	public static int getOpPrec(char op) {
		switch (op) {
		case '*':
		case '/':
			return 5;

		case '+':
		case '-':
			return 3;

		default:
			return 1;
		}
	}

}
