package atoffer.util;

public class Util {
	
	public int partition(int[] arr, int start, int end) {
		
		int middle = arr[start];
		while(start<end) {
			
			while(start<end && arr[end]>middle) {
				end--;
			}
			arr[start] = arr[end];
			while(start<end && arr[start]<=middle) {
				start++;
			}
			arr[end] = arr[start];
		}
		arr[start] = middle;
		return start;
		
	}
	
	
}