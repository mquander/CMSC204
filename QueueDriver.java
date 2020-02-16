
public class QueueDriver {

	public static void main(String[] args) {
		WaitLine obj = new WaitLine();

		obj.simulate(12, .7, 3);

		obj.displayResults();
	}

}
