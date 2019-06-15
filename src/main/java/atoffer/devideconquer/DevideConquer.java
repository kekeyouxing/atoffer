package atoffer.devideconquer;

/**
 * @author Ke
 *分治算法
 */
public class DevideConquer {
	
	private int inversePairsCount = 0;
	
	public int inversePairs(int[] nums) {
		
		if(nums == null) {
			throw new NullPointerException("inversePairs's numbers is null");
		}
		int[] temp = new int[nums.length]; 
		inversePairsCore(nums, temp, 0, nums.length-1);
		return inversePairsCount;
	}

	private void inversePairsCore(int[] nums, int[] temp, int start, int end) {
		
		if(start<end) {
			
			int middle = (start+end)/2;
			inversePairsCore(nums, temp, start, middle);
			inversePairsCore(nums, temp, middle+1, end);
			inverseCount(nums, temp, start, end, middle);
			
		}
		
	}

	private void inverseCount(int[] nums, int[] temp, int start, int end, int middle) {
		
		int i = start;
		int j = middle+1;
		int k = 0;
		while(i<=middle && j<=end) {
			
			if(nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			}else {
				temp[k++] = nums[j++];
				inversePairsCount += middle-start+1;
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
	
	public static void main(String[] args) {
		DevideConquer dc = new DevideConquer();
		int[] arr = new int[] {6, 5, 4, 3, 2, 1};
		System.out.println(dc.inversePairs(arr));
	}
}
