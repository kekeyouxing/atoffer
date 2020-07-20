package atoffer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class VectorAlgorithm {
	
	public int moreThanHalfNum(int[] arr) {
		
		if(arr == null||arr.length==0) {
			return -1;
		}
		int middle = arr.length/2;
		int start = 0, end = arr.length-1;
		int index = partition(arr, start, end);
		while(middle!=index) {
			if(index>middle) {
				end = index-1;
			}else {
				start = index+1;
			}
			index = partition(arr, start, end);
		}
		
		int result = arr[index];
		if(checkMoreThanHalf(arr, result)) {
			return result;
		}
		return -1;
		
	}

	private boolean checkMoreThanHalf(int[] arr, int result) {
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == result) {
				count++;
			}
		}
		return count > arr.length/2;
		
	}
	
	/**
	 * <p>
	 * Find the kth largest element in an unsorted array. 
	 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
	 * <p>
	 * Example:
	 * <blockquote>
	 * <pre>
	 * Input: [3,2,1,5,6,4] and k = 2
	 * Output: 5
	 * </pre>
	 * </blockquote>
	 * @param nums integer array nums
	 * @param k Note that it is the kth largest element in the sorted order, not the kth distinct element.
	 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array">kth-largest-element-in-an-array</a>
	 */
	public int findKthLargest(int[] nums, int k) {
		if(k<=0 || k > nums.length) {
			return 0;
		}
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int resultIndex = nums.length-k;
		int start = 0, end = nums.length-1;
		int index = partition(nums, start, end);
		while(index!=resultIndex) {
			if(index > resultIndex) {
				end = index-1;
			}else {
				start = index+1;
			}
			index = partition(nums, start, end);
		}
		
		return nums[resultIndex];
	}
	
	private int partition(int[] nums, int start, int end) {
		int middle = nums[start];
		
		while(start<end) {
			if(start<end && nums[end]>middle) {
				end--;
			}
			nums[start] = nums[end];
			if(start<end && nums[start] <= middle) {
				start++;
			}
			nums[end] = nums[start];
		}
		nums[start] = middle;
		return start;
	}

	/**
	 * <p>
	 * Given an array of integers nums sorted in ascending order, 
	 * find the starting and ending position of a given target value.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * If the target is not found in the array, return [-1, -1].
	 * <p>
	 * Example:
	 * <blockquote>
	 * <pre>
	 * Input: nums = [5,7,7,8,8,10], target = 8
	 * Output: [3,4]
	 * </pre>
	 * </blockquote>
	 * @param nums Given an array of integers nums sorted in ascending order.
	 * @param tartget target number
	 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">
	 * find-first-and-last-position-of-element-in-sorted-array
	 * </a>
	 */
	public int[] searchRange(int[] nums, int tartget) {
		int first = getFirstK(nums, tartget);
		int last = getLastK(nums, tartget);
		return new int[] {first, last};
	}
	
	private int getFirstK(int[] nums, int k) {
		int start = 0, end = nums.length-1;
		int middle = (start+end)/2;
		while(start <= end) {
			if(nums[middle] < k) {
				start = middle+1;
			}else if(nums[middle] > k) {
				end = middle-1;
			}
			else if(middle-1 >= 0 && nums[middle-1] == k) {
				end = middle-1;
			}else {
				return middle;
			}
			middle = (start+end)/2;
		}
		return -1;
	}
	
	private int getLastK(int[] nums, int k) {
		int start = 0, end = nums.length-1;
		int middle = (start+end)/2;
		while(start<=end) {
			if(nums[middle] < k) {
				start = middle + 1;
			}else if(nums[middle] > k) {
				end = middle - 1;
			}else if(middle+1<nums.length && nums[middle+1] == k) {
				start = middle+1;
			}else {
				return middle;
			}
			middle = (start+end)/2;
		}
		return -1;
	}
	
    /**
     * <p>
     * Given an array of integers that is already sorted in ascending order, 
     * find two numbers such that they add up to a specific target number.
     * <p>
     * Examples:
     * <blockquote><pre>
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     * </pre></blockquote>
     * @param numbers an array of integers that is already sorted in ascending order.
     * @param target two numbers such that they add up to a specific target number.
     * @return indices of the two numbers such that they add up to the target.
     * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">two-sum</a>
     */
    public int[] twoSum(int[] numbers, int target) {
    	if(numbers == null||numbers.length == 0) {
    		return new int[] {-1, -1};
    	}
    	int index1 = 0;
    	int index2 = numbers.length-1;
    	while(index1 < index2) {
    		int sum = numbers[index1]+numbers[index2];
    		if(sum == target) {
    			return new int[] {index1+1, index2+1};
    		}
    		if(sum>target) {
    			index2--;
    		}
    		if(sum<target) {
    			index1++;
    		}
    		
    	}
		return new int[] {-1, -1};
    }
    
    /**
     * <p>
     * Given an array nums, 
     * there is a sliding window of size k which is moving from the very left of the array to the very right. 
     * You can only see the k numbers in the window. 
     * Each time the sliding window moves right by one position. Return the max sliding window.
     * <p>
     * <blockquote>
     * <pre>
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
	 * Output: [3,3,5,5,6,7] 
	 * Explanation: 

	 * Window position                Max
	 * ---------------               -----
	 * [1  3  -1] -3  5  3  6  7       3
	 *  1 [3  -1  -3] 5  3  6  7       3
	 *  1  3 [-1  -3  5] 3  6  7       5
	 *  1  3  -1 [-3  5  3] 6  7       5
	 *  1  3  -1  -3 [5  3  6] 7       6
	 *  1  3  -1  -3  5 [3  6  7]      7
     * </pre>
     * </blockquote>
     * @param nums Given an array nums
     * @param k the size of the window
     * @return
     * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">sliding-window-maximum</a>
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
    		return new int[0];
    	}
    	if(k > nums.length || k <= 1) {
    		return nums;
    	}
    	
    	int[] result =new int[nums.length-k+1];
    	LinkedList<Integer> indexDeque = new LinkedList<Integer>();
    	for(int i=0; i<k-1; i++) {
    		while(!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
    			indexDeque.removeLast();
    		}
    		indexDeque.add(i);
    	}
    	int j=0;
    	for(int i=k-1; i<nums.length; i++) {
    		while(!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
    			indexDeque.removeLast();
    		}
    		indexDeque.add(i);
    		if(i-indexDeque.getFirst()+1 > k) {
    			indexDeque.removeFirst();
    		}
    		result[j++] = nums[indexDeque.getFirst()];
    	}
    	
        return result;
    }
    
    /**
     * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length == 0) {
    		return false;
    	}
    	Arrays.sort(numbers);
    	int zeroCount = 0;
    	for(int i = 0; i<numbers.length; i++) {
    		if(numbers[i] == 0) {
    			zeroCount++;
    		}
    	}
    	for(int i = zeroCount; i<numbers.length-1; i++) {
    		int pre = numbers[i];
    		int next = numbers[i+1];
    		if(pre == next) {
    			return false;
    		}
    		int gap = next - pre-1;
    		zeroCount = zeroCount-gap;
    	}
    	if(zeroCount>=0) {
    		return true;
    	}
		return false;
    }
    
    /**
     * <p>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction 
     * (i.e., buy one and sell one share of the stock), 
     * design an algorithm to find the maximum profit.
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * <blockquote>
     * <pre>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * </pre>
     * </blockquote>
     * @param prices 
     * @return maximum profit
     * 
     * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">best-time-to-buy-and-sell-stock</a>
     */
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length < 2) {
    		return 0;
    	}
    	int minPrice = prices[0];
    	int result = 0;
    	for(int i = 1; i<prices.length; i++) {
    		int maxProfit = prices[i] - minPrice;
    		if(maxProfit>result) {
    			result = maxProfit;
    		}
    		if(prices[i] < minPrice) {
    			minPrice = prices[i];
    		}
    	}
		return result;
    }
    
	
	/**
	 * <p>
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. 
	 * You may complete as many transactions as you like 
	 * (i.e., buy one and sell one share of the stock multiple times).
	 * Note: You may not engage in multiple transactions at the same time 
	 * (i.e., you must sell the stock before you buy again).
	 * <p>
	 * Example: 
	 * <blockquote>
	 * <pre>
	 * Input: [7,1,5,3,6,4]
	 * Output: 7
	 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	 * </pre>
	 * </blockquote>
	 * @param prices 
	 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">
	 * best-time-to-buy-and-sell-stock-ii
	 * </a>
	 */
	public int maxProfit2(int[] prices) {
		if(prices == null || prices.length<2) {
			return 0;
		}
		int result = 0;
		for(int i=0; i < prices.length-1; i++) {
			int profit = prices[i+1]-prices[i];
			if(profit > 0) {
				result += profit;
			}
		}
		return result;
	}
    /**
     * <p>
     * 
     * Given an array nums of n integers where n > 1,  
     * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * Example:
     * <blockquote>
     * <pre>
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * </pre>
     * </blockquote>
     * @param nums
     * @return
     * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">product-of-array-except-self</a>
     */
    public int[] productExceptSelf(int[] nums) {
    	if(nums == null ||nums.length == 0) {
    		return new int[0];
    	}
    	int[] result = new int[nums.length];
    	int[] left = new int[nums.length];
    	int[] right = new int[nums.length];
    	left[0] = 1;
    	right[nums.length-1] = 1;
    	for(int i = 1; i < nums.length; i++) {
    		left[i] = left[i-1]*nums[i-1];
    	}
    	for(int i = nums.length-2; i>=0; i--) {
    		right[i] = right[i+1]*nums[i+1];
    	}
    	for(int i = 0; i < nums.length; i++) {
    		result[i] = left[i] * right[i];
    	}
		return result;
    }
    
    /**
     * <p>
     * Given a matrix of m x n elements (m rows, n columns), 
     * return all elements of the matrix in spiral order.
     * <p>
     * Example:
     * <blockquote>
     * <pre>
     * Input:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * </pre>
     * </blockquote>
     * @param matrix
     * @see <a href="https://leetcode.com/problems/spiral-matrix">spiral-matrix</a>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0) {
			return result;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		while(rows > start * 2 && cols > start * 2) {
			circleValue(matrix, start, rows, cols, result);
			start++;
		}
		return result;
    }

	private void circleValue(int[][] matrix, int start, int rows, int cols, List<Integer> result) {
		int endX = rows-start-1;
		int endY = cols-start-1;
		for(int i = start; i <= endY; i++) {
			result.add(matrix[start][i]);
		}
		if(endX>start) {
			for(int i = start+1; i <= endX; i++) {
				result.add(matrix[i][endY]);
			}
		}
		if(endY > start && endX > start) {
			for(int i = endY-1; i>=start; i--) {
				result.add(matrix[endX][i]);
			}
		}
		if(start < endX && endY>start) {
			for(int i=endX-1; i>start; i--) {
				result.add(matrix[i][start]);
			}
		}
	}
}
