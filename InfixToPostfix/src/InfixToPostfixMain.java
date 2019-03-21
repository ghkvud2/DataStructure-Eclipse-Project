
public class InfixToPostfixMain {

	public static void main(String[] args) {

		InfixToPostfix conv = new InfixToPostfix();
		String[] strArr = new String[] { "1+2*3", "(1+2)*3", "((1-2)+3)*(5-2)" };

		for (String str : strArr) {
			System.out.println(conv.convToExpression(str));
		}
	}

}
