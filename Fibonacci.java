/**
 * Class to compute Fibonacci numbers
 * @author Matt Quander
 *
 */
public class Fibonacci {
	/**
	 * Variables used in computing and storing Fibonacci numbers
	 */
	int result;
	int arr[] = new int[10];
	/**
	 * Recursive method to calculate Fibonacci number
	 * @param n Integer number 
	 * @param arr Array to store calculated numbers
	 * @return result the Fibonacci number
	 */
	public int fib(int n, int arr[]) {
		if(arr[n] != 0)
			return arr[n];
		if(n == 1 || n == 2)
			return 1;
		else
			result = fib(n - 1, arr) + fib(n - 2, arr);
		arr[n] = result;
		return result;
	}
	/**
	 * Method to call recursive method
	 * @param n Integer number
	 * @return call to recursive method
	 */
	public int fib(int n) {
		return fib(n, arr);
	}
}
