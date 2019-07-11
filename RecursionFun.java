import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Paul Rich
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		} else if (n == k) {
			return 1;
		}
		return (combinations((n - 1), (k - 1)) + combinations((n - 1), k));
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String intString = "";
		double lenN = lengthOfInt(n);

		if (lenN == 0) {
			return "";
		}

		if (((lenN - 1) % 3 == 0) && (lenN - 1 != 0)) {

			double pow = (lenN - 1.0);
			int strip0 = (int) Math.pow(10.0, pow);
			int atIndex = n / strip0;
			n = n % strip0;
			intString += atIndex;
			intString += ",";
			if (lengthOfInt(n) < lenN - 1) {
				intString = insertZeroes(n, intString, lenN);
			}
			return intString + intWithCommas(n);
		} else {

			double pow = (lenN - 1.0);
			int strip0 = (int) Math.pow(10.0, pow);
			int atIndex = n / strip0;
			intString += atIndex;
			if (atIndex == 0) {
				return intString + intWithCommas(n);
			} else {
				n = n % strip0;
				return intString + intWithCommas(n);
			}
		}
	}

	private String insertZeroes(int n, String intString, double lenN) {
		if (lengthOfInt(n) >= lenN - 1) {
			return intString;
		} else {// (lengthOfInt(n) < lenN - 1) {
			intString += 0;
			lenN--;
			return insertZeroes(n, intString, lenN);

		}

	}

	private double lengthOfInt(int n) {
		double len = 0;
		long temp = 1;
		while (temp <= n) {
			temp = temp * 10;
			len++;
		}
		return len;
	}

// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.

		if (x.length == 0) {
			return;
		}

		if (index >= len - 1) {
			return;
		}

		int temp = x[index];
		x[index] = x[len - 1];
		x[len - 1] = temp;
		index++;
		len--;
		reverseArray(x, index, len);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int max = maxOfArray(a, a.length - 1);
		int min = minOfArray(a, a.length - 1);
		return max - min;
	}

	private int minOfArray(int[] a, int length) {
		if (length > 0) {
			return Math.min(a[length], minOfArray(a, length - 1));
		} else {
			return a[0];
		}
	}

	private int maxOfArray(int[] a, int length) {
		if (length > 0) {
			return Math.max(a[length], maxOfArray(a, length - 1));
		} else {
			return a[0];
		}
		// TODO Auto-generated method stub
	}

// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return true;
		}

		if (nums[0] > nums[1]) {
			return false;
		} else {
			int[] recurArray = Arrays.copyOfRange(nums, 1, nums.length);
			return isSorted(recurArray);
		}

	}

// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs.length == 0) {
			return false;
		}

		if (strs[0].equals(search)) {
			return true;
		} else {
			String[] recurArray = Arrays.copyOfRange(strs, 1, strs.length);
			return found(search, recurArray);
		}
	}
}
