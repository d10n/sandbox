import java.util.Arrays;

public class PassByReference {
	public static void main(String[] args) {
		int[] hello = {36};
		System.out.println("Initialized array:");
		System.out.println(Arrays.toString(hello));

		System.out.println("Running passReference");
		passReference(hello);
		System.out.println("Back in main. Array's value:");
		System.out.println(Arrays.toString(hello));

		int goodbye = 2345;
		System.out.println("Initialized variable:");
		System.out.println(goodbye);

		System.out.println("Running passValue");
		passValue(goodbye);
		System.out.println("Back in main. Variable's value:");
		System.out.println(goodbye);
	}

	public static void passReference(int[] array) {
		System.out.println("Inside passReference");
		for(int i = 0; i < array.length; i++)
			array[i] *= 4;
		System.out.println(Arrays.toString(array));
		System.out.println("Leaving passReference");
	}

	public static void passValue(int value) {
		System.out.println("Inside passValue");
		value *= 4;
		System.out.println(value);
		System.out.println("Leaving passValue");
	}
}
