
public class PostCalMain {

	public static void main(String[] args) {
		String[] strArr = new String[] { "1+2*3", "(1+2)*3", "((1-2)+3)*(5-2)" };
		for (String str : strArr) {
			System.out.print(str + " : ");
			System.out.println(PostCalculator.calPostfix(InfixToPostfix.convToExpression(str)));
		}
	}
}
