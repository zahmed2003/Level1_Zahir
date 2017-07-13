
public class MethodPractice {

	public static void main(String[] args) {

	}

	public void printname(String name) {
		System.out.println(name);
	}

	public void numberOfNames(String name, int numberOfNames) {
		for (int i = numberOfNames; i >= 0; i--) {
			System.out.print(name);
		}
	}

	public void stringPrint(String string) {
		System.out.println(string);
	}

	public void subtraction(int firstInt, int subtractedFromFirstInt) {
		int answer = firstInt - subtractedFromFirstInt;
	}

	public void integerToString(int Int) {
		String string = Integer.toString(Int);
	}

}
