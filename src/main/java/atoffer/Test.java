package atoffer;

public class Test {
	private int moreThanHalfNum(int[] nums) {
		int start = 0, end = nums.length-1;
		int middle = (start+end)/2;
		int index  = partition(nums, start, end);
		while(index!=middle) {
			if(index<middle) {
				start = index+1;
			}else {
				end = index-1;
			}
			index = partition(nums, start, end);
		}
		return nums[index];
	}
	
	private int partition(int[] nums, int start, int end) {
		int middle = nums[start];
		while(start!=end) {
			while(start<end && nums[end] > middle) {
				end--;
			}
			nums[start] = nums[end];
			while(start<end && nums[start] <= middle) {
				start++;
			}
			nums[end] = nums[start];
		}
		nums[start] = middle;
		return start;
	}
	
	private int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length-1;
		int index = partition(nums, start, end);
		while(index != k-1) {
			if(index<k-1) {
				start = start+1;
			}else {
				end = index-1;
			}
			index = partition(nums, start, end);
		}
		return nums[index];
	}
	
	public int maxSubArray(int[] nums) {
		int curSum = 0;
		int max = nums[0];
		for(int i=0; i<nums.length; i++) {
			if(curSum<=0) {
				curSum = nums[i];
			}else {
				curSum = curSum + nums[i];
			}
			if(curSum>max) {
				max = curSum;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		//test.moreThanHalfNum(new int[]{2,2,2,4,3,5,2,2,2,6});
		test.findKthLargest(new int[]{2,2,2,4,3,5,2,2,2,6}, 7);
	}
}
