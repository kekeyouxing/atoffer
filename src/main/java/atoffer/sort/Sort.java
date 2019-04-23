package atoffer.sort;

public class Sort {

	public int[] bubbleSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1;j++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
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
		
		int min, temp;
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
		
	}
	
	public void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
