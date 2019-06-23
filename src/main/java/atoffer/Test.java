package atoffer;

public class Test {
	public void bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = 0; j < nums.length - i - 1; j++) {
				if(nums[j] > nums[j+1]) 
					swap(nums, j, j+1);
			}
		}
	}

	private void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void insertSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int preIndex = i-1;
			int current = nums[i];
			while(preIndex >= 0 && nums[preIndex] > current) {
				nums[preIndex+1] = nums[preIndex]; 
				preIndex--;
			}
			nums[preIndex+1] = current;
		}
	}
	
	public void simpleSort(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			int min = i;
			for(int j = i+1; j < nums.length; j++) {
				if(nums[min] > nums[j])
					min = j;
			}
			swap(nums, i, min);
		}
	}
	
	public void quickSort(int[] nums) {
		quickSortCore(nums, 0, nums.length-1);
	}

	private void quickSortCore(int[] nums, int start, int end) {
		if(start<end) {
			int i = partition(nums, start, end);
			quickSortCore(nums, start, i-1);
			quickSortCore(nums, i+1, end);
		}
	}

	private int partition(int[] nums, int start, int end) {
		int middle = nums[start];
		while(start<end) {
			if(start<end && nums[end]>middle) {
				end--;
			}
			nums[start] = nums[end];
			if(start<end && nums[start]<=middle) {
				start++;
			}
			nums[end] = nums[start];
		}
		nums[start] = middle;
		return start;
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		int[] nums = new int[] {9,4,6,7,2,3,9};
		//test.quickSort(nums);
		//test.bubbleSort(nums);
		test.simpleSort(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
	}
	
}
