package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.
// Input: nums = [4,1,2,1,2]
// Output: 4

	/**
	 * Using Bit Manipulation -
	 * 
	 * As we know XOR operation with 0 gives the same number eg, for decimal no. 2=>
	 * 2 XOR 0 = 2 in binary, 010 XOR 000 = 010
	 * 
	 * Also we know that , XOR operation with same number gives 0 eg, 2 XOR 2 = 0 in
	 * binary, 010 XOR 010 = 000
	 * 
	 * XOR is associative (like sum) i.e, (2 XOR 3) XOR 4 = 2 XOR (3 XOR 4), So the
	 * order doesn't matter in performing XOR operation. eg, 2^3^4^6 = 3^2^6^4 =
	 * 4^2^6^3 ......
	 * 
	 * So, using these three properties of XOR , we will solve the question.
	 **/
	public int singleNumber(int[] nums) {
		int ans = 0; // since XOR with 0 returns same number
		for (int num : nums) {
			// XOR with same number will make 0 and XOR with 0 will give same number so we
			// can find that single number
			ans = ans ^ num;
		}
		return ans;
	}

	/**
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * Input: nums = [2,7,11,15], target = 9
	 * Output: [0,1] 
	 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
	 **/
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			// calculate targetNumber which we want to find along with num[i] to make the
			// target
			int targetNumber = target - nums[i];
			if (map.containsKey(targetNumber)) {
				// found solution
				return new int[] { map.get(targetNumber), i };
			} else {
				// add the number (number,index) in map
				map.put(nums[i], i);
			}
		}

		// nothing found
		return new int[] { -1, -1 };
	}

	/**
	 * Given an array nums with n objects colored red, white, or blue, sort them
	 * in-place so that objects of the same color are adjacent, with the colors in
	 * the order red, white, and blue. We will use the integers 0, 1, and 2 to
	 * represent the color red, white, and blue, respectively.
	 * 
	 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
	 **/

	public void sortColors(int[] nums) {
//		Maintain three pointers low at 0, high at end and i at 0 to iterate through array
//		Iterate i & whenever there is 0 put that to extreme left by swapping it with low and increment low and i.
//		Whenever there is 1 just let it be there and increment i.
//		whenever there is 2 put that to extreme right by swapping nums[i] with nums[high].

		int low = 0;
		int high = nums.length - 1;
		int i = 0;

		while (i <= high) {

			if (nums[i] == 1) {
				// IGNORE since we only want to move 0 to start and 2 to end and 1 will
				// automatically come in middle
				i++;
			} else if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[low];
				nums[low] = temp;
				low++;
				i++;
			} else {
				int temp = nums[i];
				nums[i] = nums[high];
				nums[high] = temp;
				high--;
			}

		}
	}

	/**
	 * Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must be unique and you may return
	 * the result in any order.
	 * 
	 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Explanation: [4,9]
	 * is also accepted.
	 **/
	public int[] intersection(int[] nums1, int[] nums2) {
		// Use hashset since hashset will remove duplicates
		Set<Integer> set1 = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}

		Set<Integer> set2 = new HashSet<>();
		for (int j = 0; j < nums2.length; j++) {
			// if set 1 contains the number which is in array2 then add in result Set since
			// both the
			// arrays should have the number
			if (set1.contains(nums2[j])) {
				set2.add(nums2[j]);
			}
		}

		int res[] = new int[set2.size()];
		int index = 0;
		for (int nums : set2) {
			res[index] = nums;
			index++;
		}
		return res;
	}

/**	Merge Sorted Array
	You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
	Merge nums1 and nums2 into a single array sorted in non-decreasing order.
	The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
	Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	Output: [1,2,2,3,5,6]
	Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
	The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
**/
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1; // p1 at end of nums1 not including empty space
		int j = n - 1; // p2 at end of nums2
		int k = nums1.length - 1; // end of nums1 (index)

		while (j >= 0) {
			// Check if both arrays have remaining elements and compare them
			if (i >= 0 && nums1[i] > nums2[j]) {
				// If the element in nums1 is larger, place it at the end of nums1 (k), and move
				// the pointers accordingly
				nums1[k] = nums1[i];
				k--;
				i--;
			} else {
				// If the element in nums2 is larger or nums1 is exhausted, place the element
				// from nums2 at the end of nums1 (k), and move the pointers accordingly
				nums1[k] = nums2[j];
				k--;
				j--;
			}
		}
	}

//	Move Zeros
	public void moveZeroes(int[] nums) {
		int p1 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[p1];
				nums[p1] = temp;
				p1++;
			}
		}
	}

	// Reverse array
	public void reverse(int start, int end, int[] arr) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

/**	Given an integer array nums, rotate the array to the right by k steps, where k is non-negative **/
	public void rotate(int[] nums, int k) {

		// TWO METHODS TO DO THIS
		// 1)% approach --> have to create new array S.C ==> O(n)

		// int n = nums.length;
		// int [] res = new int[n];
		// for(int i = 0; i < n; i++){
		// res[(i+k)%n] = nums[i];
		// }
		// for(int i = 0; i<n; i++){
		// nums[i] = res[i];
		// }

		// 2) reverse approach --> S.C ==> O(1)
		// We need to use modulus to make k within array length lets say array size is 2
		// but k is 200 then % will make (200 % 2 = 2)
		k = k % nums.length;
		// reverse whole array
		reverse(0, nums.length - 1, nums);
		// divide the array at k --> first reverse 1st part then 2nd part
		reverse(0, k - 1, nums);
		reverse(k, nums.length - 1, nums);

	}

	/**
	 * Check if Array Is Sorted and Rotated
	 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
	 * There may be duplicates in the original array.
	 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
	 * Input: nums = [3,4,5,1,2]
	 * Output: true
	 * Explanation: [1,2,3,4,5] is the original sorted array.
	 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
	 **/
	
	public boolean check(int[] nums) {
		int greaterCount=0;
		// if array is sorted and rotated it will only have 1 greater than sign between adjacent elements otherwise it is not sorted		
        for(int i=0;i<nums.length;i++) {
        	// check prev element with next element 
        	// we need to also check last element with 1st element thats why i am using modulus
        	if(nums[i]>nums[(i+1)%(nums.length)]) {
        		greaterCount++;
        	}
        }
        if(greaterCount>1) {
        	return false;
        }else {
        	return true;
        }
    }
	
	public static void main(String args[]) {

	}
}
