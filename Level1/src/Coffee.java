
public class Coffee {
	int temperature;

	public static void main(String[] args) {
		Coffee coffee = new Coffee(79);
		coffee.brew();
	}

	public Coffee(int temperature) {
		this.temperature = temperature;
	}

	public void brew() {
		temperature = 110;
		System.out.println("The coffee is ready at " + temperature + " degrees.");
	}

}
