package atoffer.devideconquer;

/**
 * @author Ke
 *分治算法
 */
public class DevideConquer {
	
	private int inversePairsCount = 0;
	
	public int inversePairs(int[] arr) {
		
		if(arr == null) {
			throw new NullPointerException("inversePairs's numbers is null");
		}
		int[] temp = new int[arr.length]; 
		inversePairsCore(arr, temp, 0, arr.length-1);
		return inversePairsCount;
	}

	private void inversePairsCore(int[] arr, int[] temp, int start, int end) {
		
		if(start<end) {
			
			int middle = (start+end)/2;
			inversePairsCore(arr, temp, start, middle);
			inversePairsCore(arr, temp, middle+1, end);
			inverseCount(arr, temp, start, end, middle);
			
		}
		
	}

	private void inverseCount(int[] arr, int[] temp, int start, int end, int middle) {
		
		int i = start;
		int j = middle+1;
		int k = 0;
		while(i<=middle && j<=end) {
			
			if(arr[i]<=arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
				inversePairsCount += middle-start+1;
			}
			
		}
		
		while(i<=middle) {
			temp[k++] = arr[i++];
		}
		while(j<=end) {
			temp[k++] = arr[j++];
		}
		System.arraycopy(temp, 0, arr, start, k);
		
	}
	
	public static void main(String[] args) {
		DevideConquer dc = new DevideConquer();
		int[] arr = new int[] {6, 5, 4, 3, 2, 1};
		System.out.println(dc.inversePairs(arr));
	}
}
