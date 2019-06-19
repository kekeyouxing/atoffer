package atoffer.sort;

public class Sort {
	
	public void bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length-1; i++) {
			for(int j=0; j < nums.length-i-1; j++) {
				if(nums[j] > nums[j + 1]) 
					swap(nums, j, j + 1);
			}
		}
	}
	
	public void insertSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int preIndex = i-1;
			int current = nums[i];
			while(preIndex >= 0 && nums[preIndex] > current) {
				nums[preIndex + 1] = nums[preIndex];
				preIndex--;
			}
			nums[preIndex + 1] = current;
		}
	}
	
	public int[] simpleSort(int[] nums) {
		int min;
		for(int i=0; i<nums.length-1; i++) {
			min = i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[min] > nums[j]) {
					min = j;
				}
			}
			swap(nums, min, i);
		}
		return nums;
	}
	
	public void quickSort(int[] nums) {
		quickSortCore(nums, 0, nums.length-1);
	}
	
	public void quickSortCore(int[] nums, int start, int end) {
		
		int i = partition(nums, start, end);
		quickSortCore(nums, start, i-1);
		quickSortCore(nums, i+1, end);
		
	}
	
	public void mergeSort(int[] nums) {
		if(nums == null) {
			throw new NullPointerException("mergeSort's numbers is null");
		}
		int[] temp = new int[nums.length];
		mergeSortCore(nums,temp, 0, nums.length-1);
	}
	
	public void mergeSortCore(int[] nums, int[] temp, int start, int end) {
		
		if(start<end) {
			int middle = (start+end)/2;
			mergeSortCore(nums, temp, start, middle);
			mergeSortCore(nums, temp, middle+1, end);
			merge(nums, temp, start, end, middle);
		}
		
	}

	private void merge(int[] nums, int[] temp, int start, int end, int middle) {
		int i = start;
		int j = middle+1;
		int k = 0;
		while(i<=middle && j<=end) {
			
			if(nums[i]<nums[j]) {
				temp[k++] = nums[i++];
			}else {
				temp[k++] = nums[j++];
			}
			
		}
		
		while(i<=middle) {
			temp[k++] = nums[i++];
		}
		while(j<=end) {
			temp[k++] = nums[j++];
		}
		
		System.arraycopy(temp, 0, nums, start, k);
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
	
	private void swap(int[] nums, int start, int end){
		
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
		
	}
}
