
public class OperatorFun {
	public static void main(String[]args) {
		int a = 5;
		int b = 12;

		int c = a+++b;
		int d = a++ + ++b;
		int e = a+++b++-c--+--d+d++;
		System.out.println(c);
		System.out.println(d);
		System.out.println(a++ + ++b);
		System.out.println(e);
		System.out.println(10/3);


	}
}
