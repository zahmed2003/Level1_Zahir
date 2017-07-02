
public class Computer {
	int length;
	int width;
	String developer;

	public Computer(int length, int width, String developer) {
		this.developer = developer;
		this.length = length;
		this.width = width;
	}

	public void shutDown() {
		System.out.println("Shutting down");
	}

	public void increaseWidth(int size) {
		this.width = this.width + size;
		System.out.println(this.width);
	}

	public static void main(String[] args) {

	}
}
