package atoffer.sort;

import atoffer.util.Util;

public class Sort {
	
	Util util = new Util();
	
	public int[] bubbleSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1;j++) {
				
				if(arr[j] > arr[j+1]) {
					util.swap(arr, j, j+1);
				}
				
			}
		}
		return arr;
		
	}
	
	public int[] insertSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			int preIndex = i-1;
			int current = arr[i];
			while(preIndex>=0 && arr[preIndex] > current) {
				arr[preIndex+1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex+1] = current;
		}
		return arr;
		
	}
	
	public int[] simpleSort(int[] arr) {
		
		int min;
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			util.swap(arr, min, i);
		}
		return arr;
		
	}
	
	public void quickSort(int[] arr) {
		quickSortCore(arr, 0, arr.length-1);
	}
	
	public void quickSortCore(int[] arr, int start, int end) {
		
		int i = util.partition(arr, start, end);
		quickSortCore(arr, start, i-1);
		quickSortCore(arr, i+1, end);
		
	}
	
	public void mergeSort(int[] arr) {
		if(arr == null) {
			throw new NullPointerException("mergeSort's numbers is null");
		}
		int[] temp = new int[arr.length];
		mergeSortCore(arr,temp, 0, arr.length-1);
	}
	
	public void mergeSortCore(int[] arr, int[] temp, int start, int end) {
		
		if(start<end) {
			int middle = (start+end)/2;
			mergeSortCore(arr, temp, start, middle);
			mergeSortCore(arr, temp, middle+1, end);
			merge(arr, temp, start, end, middle);
		}
		
	}

	private void merge(int[] arr, int[] temp, int start, int end, int middle) {
		int i = start;
		int j = middle+1;
		int k = 0;
		while(i<=middle && j<=end) {
			
			if(arr[i]<arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
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
	
}
