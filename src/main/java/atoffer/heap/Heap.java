package atoffer.heap;

/**
 * @author Ke
 *
 */
public class Heap {
	
	public void createHeap() {
		
	}
	
	/**
	 * @param arr
	 * @param i
	 * @param length
	 */
	public void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];
		for(int k=2*i+1; k<length;k=2*k+1) {
			if(k+1<length&&arr[k]<arr[k+1]) {
				k++;
			}
			if(temp<arr[k]) {
				arr[i]=arr[k];
				i=k;
			}else {
				break;
			}
		}
		arr[i] = temp;
	}
}
