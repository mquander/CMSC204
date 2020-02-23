/**
 * Class to calculate the sum of an array
 * @author Matt Quander
 *
 */
public class ArraySum {
	/**
	 * Recursive method to calculate sum
	 * @param arr Array of Integers
	 * @param n integer to represent element in array
	 * @return recursive call to method
	 */
	public int sumOfArray(Integer arr[], int n) {
		
		if(n <= 0)
			return n;
		else
			return (sumOfArray(arr, n-1) + arr[n-1]);
	}
}
