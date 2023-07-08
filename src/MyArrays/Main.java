package MyArrays;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * ARRAYS
	 * 
	 * Store similar type of data Contiguous blocks of memory Static in size
	 * 
	 * Time Complexity 1. Insertion --> we can use arr[i] = 4 so it does not depend
	 * on input side -> O(1) 2. Lookup a) Lookup by value -> TC may be O(n) since we
	 * need to iterate through whole array to find that specific value b) Lookup by
	 * index -> TC = O(1) 3. Deletion -> TC = O(n) because we delete value from lets
	 * say index 1 we need to shift the rest of the elements to left
	 **/

	/**
	 * 
	 * Why array index start from 0? Lets take a array: int [] arr=new int[5];
	 * 
	 * now we know int ==> 4 bytes
	 * 
	 * By starting the index at 0, the memory address of any element can be easily
	 * calculated using simple arithmetic
	 * 
	 * arr corresponds to first memory address
	 * 
	 * arr[0] --> 1000 arr[1] --> 1004 arr[2] --> 1008 ....
	 * 
	 * From here we can easily calculate the memory address using the index,
	 * arr[0]==> arr +(0 * size) = 1000+0*4 = 1000 arr[5]==> arr +(5 * size) =
	 * 1000+5*4 = 1020
	 */

	public static void main(String[] args) {
		int[] arr = new int[4];

		//	Dynamic Arrays
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
	}
}
