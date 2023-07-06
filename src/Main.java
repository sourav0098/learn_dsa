import java.util.Arrays;

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

	public int binaryToDecimal(int binary) {
		int i = 0;
		int result = 0;

		while (binary != 0) {
			// Since it already a binary number so to get last digit find modulus of 10
			int lastBit = binary % 10;
			if (lastBit == 1) {
				result = result + (int) Math.pow(2, i);
			}

			// Update binary divide by 10 to remove last digit
			binary = binary / 10;
			i++;
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

	// Reverse Integer
	public int reverseInteger(int x) {
		int result = 0;
		while (x != 0) {
			int lastDigit = x % 10;

			// Here we want to check if multiplication of result by 10 will overflow the
			// value outside of int range so we check result*10<MIN_VALUE but since
			// multiplication will cause to overflow the value so we move 10 under MIN_VALUE
			// (MIN_VALUE/10) since it is same thing
			if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
				return 0;
			}
			result = result * 10 + lastDigit;
			x = x / 10;
		}
		return result;
	}

	// Check if number is power of two
	public boolean isPowerOfTwo(int num) {
		// Negative number then return false
		if (num < 0) {
			return false;
		}
		while (num != 0) {
			int lastBit = num & 1;
			num = num >> 1;

			// if lastbit is 1 and still number is not zero then it means it is not power of
			// 2 because on binary scale a number which is power of 2 will only have one '1'
			// bit
			if (lastBit == 1 && num != 0) {
				return false;
			}
		}
		return true;
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

	// The complement of an integer is the integer you get when you flip all the 0's
	// to 1's and all the 1's to 0's in its binary representation.
	// For example, The integer 5 is "101" in binary and its complement is "010"
	// which is the integer 2.
	// Given an integer n, return its complement.

	// Approach: If we simply do ~n (not of n) we will not get desired result as 5=>
	// 0000.....101 and ~5 will do 1111...010 and we will get a large -ve number so
	// we need to mask the bits to reach to answer
	public int bitwiseComplement(int n) {

		// if number is 0 then compliment will be 1
		if (n == 0) {
			return 1;
		}

		int num = n; // take copy of n for building the mask
		int mask = 0;

		while (num != 0) {
			// to make mask left shift the number and do OR operation since doing a OR
			// operation will convert 0 to 1
			// eg: 5-> 000...0101 ==> mask -> 000...0111
			mask = mask << 1 | 1;

			// to make number zero
			num = num >> 1;
		}

		// ~5 --> 1111....1010
		// mask --> 0000....0111

		// AND op. --> 0000....0010 --> compliment of 5

		return (~n) & mask;

	}

	// check if prime number
	public boolean isPrime(int n) {

		if (n == 2) {
			return true;
		}

		if (n % 2 == 0) {
			return false;
		}

		for (int i = 3; i <= n / 2; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// Given an integer n, return the number of prime numbers that are strictly less
	// than n

	// SIEVE OF ERATOSTHENES
	// It is a method to find the prime numbers and composite numbers among a group
	// of numbers.
	// 1. Write all the numbers
	// 2. Ignore 0, 1 (make them false)
	// 3. Assume all numbers are prime
	// 4. Take count = 0

	// 5. Go to first number(n1) --> count ++
	// 6. Cancel out all the numbers divisible by that number(n1)
	// 7. Continue the same till last number

	public int countPrime(int n) {
		boolean primes[] = new boolean[n + 1];

		// make all the number true
		Arrays.fill(primes, true);

		// mark 0 and 1 as false
		primes[0] = false;
		primes[1] = false;

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (primes[i]) {
				count++;
				// make j=2*i since multiple of any number of will atleast start from 2*i ==>
				// eg: 5*2 = 10
				// jump by j+i to find multiples
				for (int j = 2 * i; j < n; j = j + i) {
					primes[j] = false;
				}
			}
		}
		return count;
	}

	// Factorial of a number using recursion
	public int factorail(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorail(n - 1);
	}

	public static void main(String[] args) {
		Main obj1 = new Main();
		System.out.println(obj1.decimalToBinary(10));
		System.out.println(obj1.decimalToBinaryUsingBitWise(10));
		System.out.println(obj1.binaryToDecimal(1000));
		System.out.println(obj1.oddOrEven(11));
		System.out.println(obj1.countOneBits(7));
		System.out.println(obj1.reverseInteger(2147483645));
		System.out.println(obj1.isPrime(23));
		System.out.println(obj1.factorail(1));
	}
}