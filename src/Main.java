
// Bit operators are faster than decimal operations
// AND &
// OR |
// NOT ~
// XOR ^
public class Main {
	// decimal to binary
	public String decimalToBinary(int num) {
		String result = "";
		while (num > 0) {
			int rem = num % 2;
			num = num / 2;
			result = rem + result;
		}
		return result;
	}

	// More Efficient Less Time Complexity
	public String decimalToBinaryUsingBitWise(int num) {
		String result = "";
		while (num != 0) {
			int lastBit = num & 1;
			num = num >> 1;
			result = lastBit + result;
		}

		return result;
	}

	// FIND ODD OR EVEN (Use bitwise operator)
	// If u convert any decimal number to bits u will find that even no. always end
	// with 0 and odd number with 1 so we can use this concept to find odd or even
	// number

	public String oddOrEven(int num) {
		if ((num & 1) == 0) {
			return "even";
		} else {
			return "odd";
		}
	}

	// count number of 1 bits in an integer
	public int countOneBits(int n) {
		// since java does not have unsigned int so we need to consider signed integer
		// case as well so use a for loop till 32 (int = 4 bytes = 32 bit)
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int lastBit = n & 1;
			if (lastBit == 1) {
				result++;
			}
			n = n >> 1;
		}

		return result;
	}

	// Given an integer n, return an array ans of length n + 1 such that for each i
	// (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i
	public int[] countBits(int n) {
		int[] result = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			// Based on the observation that the number of 1's in the binary representation
			// of a number is equal to the number of 1's in its halved number plus 1 if the
			// number is odd
			result[i] = result[i / 2] + (i % 2);
		}
		return result;

	}

	public static void main(String[] args) {
		Main obj1 = new Main();
		System.out.println(obj1.decimalToBinary(10));
		System.out.println(obj1.decimalToBinaryUsingBitWise(10));
		System.out.println(obj1.oddOrEven(11));
		System.out.println(obj1.countOneBits(7));
	}

}
