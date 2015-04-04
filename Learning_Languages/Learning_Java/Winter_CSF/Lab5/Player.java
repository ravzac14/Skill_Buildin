public class Player {
	int number = 0;
	

	public void guess() {
		number = (int) (Math.random() * 101);
		System.out.println("I'm guessing " + number);
	}
}
