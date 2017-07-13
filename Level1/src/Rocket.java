
public class Rocket {
	int fuel;
	String name;

	public Rocket(int fuel, String name) {
		System.out.println("Constructing Rocket");
		this.fuel = fuel;
		this.name = name;
	}

	public static void main(String[] args) {

	}

	public void launch() {
		for (int i = fuel; i >= 0; i--) {
			if (i > 0) {
				System.out.println(i);
			} else if (i == 0) {
				System.out.println(i);
				System.out.println("Out of fuel");
			}
		}
	}
}
