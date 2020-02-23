public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3;
		myArray[index++] = 5;
		myArray[index++] = 2;
		myArray[index++] = 6;
		
		int sum = arraySum.sumOfArray(myArray, 4);

		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = arraySum.sumOfArray(myArray, 6);
		System.out.println(sum);
		
		// Create Fibonacci object
		Fibonacci obj = new Fibonacci();
		// Print the output of a call to the fib method
		System.out.print(obj.fib(7));
	}

}