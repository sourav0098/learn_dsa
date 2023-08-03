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
	 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
	 * nums[0] + nums[1] == 9, we return [0, 1]
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

	/**
	 * Merge Sorted Array You are given two integer arrays nums1 and nums2, sorted
	 * in non-decreasing order, and two integers m and n, representing the number of
	 * elements in nums1 and nums2 respectively. Merge nums1 and nums2 into a single
	 * array sorted in non-decreasing order. The final sorted array should not be
	 * returned by the function, but instead be stored inside the array nums1. To
	 * accommodate this, nums1 has a length of m + n, where the first m elements
	 * denote the elements that should be merged, and the last n elements are set to
	 * 0 and should be ignored. nums2 has a length of n. Input: nums1 =
	 * [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output: [1,2,2,3,5,6]
	 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6]. The result of
	 * the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
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

	/**
	 * Given an integer array nums, rotate the array to the right by k steps, where
	 * k is non-negative
	 **/
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

		// but k is 200 (bigger than array length) then % will make (200 % 2 = 2)
		k = k % nums.length;
		// reverse whole array
		reverse(0, nums.length - 1, nums);
		// divide the array at k --> first reverse 1st part then 2nd part
		reverse(0, k - 1, nums);
		reverse(k, nums.length - 1, nums);

	}

	/**
	 * Check if Array Is Sorted and Rotated Given an array nums, return true if the
	 * array was originally sorted in non-decreasing order, then rotated some number
	 * of positions (including zero). Otherwise, return false. There may be
	 * duplicates in the original array. Note: An array A rotated by x positions
	 * results in an array B of the same length such that A[i] == B[(i+x) %
	 * A.length], where % is the modulo operation. Input: nums = [3,4,5,1,2] Output:
	 * true Explanation: [1,2,3,4,5] is the original sorted array. You can rotate
	 * the array by x = 3 positions to begin on the the element of value 3:
	 * [3,4,5,1,2].
	 **/

	public boolean check(int[] nums) {
		int greaterCount = 0;
		// if array is sorted and rotated it will only have 1 greater than sign between
		// adjacent elements otherwise it is not sorted
		for (int i = 0; i < nums.length; i++) {
			// check prev element with next element
			// we need to also check last element with 1st element thats why i am using
			// modulus
			if (nums[i] > nums[(i + 1) % (nums.length)]) {
				greaterCount++;
			}
		}
		if (greaterCount > 1) {
			return false;
		} else {
			return true;
		}
	}

//	Best Time to Buy and Sell Stock
//	Input: prices = [7,1,5,3,6,4]
//	Output: 5
//	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

	public int maxProfit(int[] prices) {
		// for this question we will use 2 pointers(p1 and i)
		int p1 = 0;
		int profit = 0;
		// since we cant go back in time we need to make sure that we must buy first
		// then sell
		for (int i = 0; i < prices.length; i++) {
			// check if price at i<p1 then move p1 pointer to i
			if (prices[i] < prices[p1]) {
				p1 = i;
			}

			// to check profit we need to substract (prices[i]-[prices[p1]])
			if (prices[i] - prices[p1] > profit) {
				profit = prices[i] - prices[p1];
			}
		}
		return profit;
	}

//	Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].	
//	Input: nums = [1,2,3,4]
//	Output: [24,12,8,6]
	public int[] productExceptSelf(int[] nums) {
		// we will need 3 arrays for this
		int N = nums.length;

		// to store left product
		int[] leftArray = new int[N];
		// to store right product
		int[] rightArray = new int[N];
		int[] result = new int[N];

		// the first element should be 1 in left array
		leftArray[0] = 1;
		// the last element should be 1 in right array
		rightArray[N - 1] = 1;

		// start from 1 and keep on adding the product in left array
		for (int i = 1; i < N; i++) {
			leftArray[i] = leftArray[i - 1] * nums[i - 1];
		}

		// start from second last and keep on adding the product in right array
		for (int i = N - 2; i >= 0; i--) {
			rightArray[i] = rightArray[i + 1] * nums[i + 1];
		}

		// multiply the left and right array
		for (int i = 0; i < N; i++) {
			result[i] = leftArray[i] * rightArray[i];
		}

		return result;
	}

	// 2nd method (to save Space Complexity)
	public int[] productExceptSelf1(int[] nums) {
		int N = nums.length;

		// use only 1 array(result array)
		int[] result = new int[N];

		// first element should be 1 while left product
		result[0] = 1;

		// do the left product and store in result
		for (int i = 1; i < N; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		// now instead of using 2 more arrays calculate the right product and at the
		// same time multiply it in result array
		// for right product the last element should be 1 should product is 1
		int rightProduct = 1;
		for (int i = N - 1; i >= 0; i--) {
			// multiply rightProduct in result array
			result[i] = result[i] * rightProduct;

			// calculate rightProduct for next index
			rightProduct = rightProduct * nums[i];
		}

		return result;
	}

//	Given an integer array nums, find the subarray with the largest sum, and return its sum.
//	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//	Output: 6
//	Explanation: The subarray [4,-1,2,1] has the largest sum 6
	public int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			// keep on increasing sum on every value
			sum = sum + nums[i];

			// if sum > max, we got a new maximum
			if (sum > max) {
				max = sum;
			}

			// if sum start going in negative, we need to reset sum to 0 and that is new
			// starting point for our subarray
			// since we dont need -ve sum, it will only decrease our total sum
			if (sum < 0) {
				sum = 0;
			}
		}

		// ONLY IF ASKED IN QUESTION THAT WE CAN RETURN EMPTY ARRAY
		// if maximum goes -ve, then we can return empty sub-array, which means return
		// max
		// as 0 instead of some negative value
		// if (max < 0) {
		// return 0;
		// }
		return max;
	}

//	Given an integer array nums, find a subarray that has the largest product, and return the product.
//	Input: nums = [2,3,-2,4]
//	Output: 6
//	Explanation: [2,3] has the largest product 6.
	public int maxProduct(int[] nums) {
		// variables
		int prefix = 1;
		int suffix = 1;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			// if at any time prefix or suffix becomes 0 (multiplication with 0) turn it to 1
			if (prefix == 0)
				prefix = 1;
			if (suffix == 0)
				suffix = 1;

			// multiply with numbers
			prefix = prefix * nums[i];
			suffix = suffix * nums[nums.length - 1 - i];

			// max of result, prefix, suffix
			result = Math.max(result, Math.max(prefix, suffix));
		}
		return result;
	}
	/**
	  	BREAKDOWN
	 
		i = 0
		prefix = 1 * 2 = 2
		suffix = 1 * 4 = 4
		result = max(Integer.MIN_VALUE, max(2, 4)) = 4
		nums = [2, 3, -2, 4]

		i = 1
		prefix = 2 * 3 = 6
		suffix = 4 * (-2) = -8
		result = max(4, max(6, -8)) = 6
		nums = [2, 3, -2, 4]

		i = 2
		prefix = 6 * (-2) = -12
		suffix = (-8) * 3 = -24
		result = max(6, max(-12, -24)) = 6
		nums = [2, 3, -2, 4]

		i = 3
		prefix = -12 * 4 = -48
		suffix = (-24) * 2 = -48
		result = max(6, max(-48, -48)) = 6
		nums = [2, 3, -2, 4]
	**/ 	

//	Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
//	Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//	You must write an algorithm that runs in O(log n) time.
//	Input: nums = [4,5,6,7,0,1,2]
//	Output: 0
	public int findMin(int[] nums) {
        // USING BINARY SEARCH
        int left=0;
        int right=nums.length-1;
        
        while(left<right){
            int mid=(left+right)/2;

            // case1: if nums[mid] is the answer
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }

            // check which is unsorted side because we want to go on that side
            // if left number is smaller than mid number then left side is sorted (move left position to mid+1)
            else if(nums[left]<nums[mid] && nums[mid]>nums[right]){
                left=mid+1;
            }
            // otherwise right is sorted (move right pos to mid-1)
            else{
                right=mid-1;
            }
        }
        return nums[left];
    }
	
	public static void main(String args[]) {

	}
}
