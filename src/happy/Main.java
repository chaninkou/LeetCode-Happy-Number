package happy;

public class Main {
	public static void main(String[] args) {
		int n = 19;
		
		System.out.println("Input: " + n);
		
		CheckHappyNumberFunction solution = new CheckHappyNumberFunction();
		
		System.out.println("Solution: " + solution.isHappy(n));
	}
}
