package atoffer;

public class Test {
	
	public int moreThanHalfNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int middle = nums.length/2;
		int start = 0, end = nums.length-1;
		int index = partition(nums, start, end);
		while(index!=middle) {
			if(index>middle) {
				end = index-1;
				index = partition(nums, start, end);
			}else {
				start = start+1;
				index = partition(nums, start, end);
			}
		}
		int result = nums[middle];
		if(isMoreThanHalf(nums, result)) {
			return result;
		}
		return -1;
	}

	private boolean isMoreThanHalf(int[] nums, int result) {
		int count = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == result) {
				count++;
			}
		}
		return count>nums.length/2;
		
	}

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
				index = partition(nums, start, end);
			}else {
				start = index+1;
				index = partition(nums, start, end);
			}
		}
		
		return nums[resultIndex];
	}
	
	public int partition(int[] nums, int start, int end) {
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
	
	public int maxSubArray(int[] arr) {
		int curMax = 0;
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(curMax<=0) {
				curMax = arr[i];
			}else {
				curMax = curMax + arr[i];
			}
			if(curMax<max) {
				max = curMax;
			}
		}
		return max;
	}

	public boolean isContinue(int[] nums) {
		int zeroCount = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0) {
				zeroCount++;
			}
		}
		for(int i = zeroCount; i<nums.length; i++) {
			int pre = nums[i];
			int next = nums[i+1];
			if(pre == next) {
				return false;
			}
			int gap = next-pre-1;
			zeroCount = zeroCount-gap;
		}
		if(zeroCount>=0) {
			return true;
		}
		return false;
	}
	
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] result = new int[nums.length];
		
		left[0] = 1;
		for(int i = 1; i<nums.length; i++) {
			left[i] = nums[i-1] * left[i-1];
		}
		right[nums.length-1] = 1;
		for(int i = nums.length-2; i >= 0; i++) {
			right[i] = nums[i+1] * right[i+1];
		}
		for(int i=0; i<nums.length; i++) {
			result[i] = left[i] * right[i];
		}
		return result;
	}
	public static void main(String[] args) {
		Test util = new Test();
	}
	
}
