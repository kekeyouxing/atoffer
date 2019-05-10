package atoffer;


public class Test {
	
	public int moreThanHalfNum(int[] arr){

		int start = 0, end = arr.length-1;
		int index = partition(arr, start, end);
		int middle = arr.length/2;
		while(index!=middle){
			
			if(index>middle){
				index = partition(arr, start, index-1);
			}else{
				index = partition(arr, index+1, end);
			}
		}
		
		return arr[middle];
		
	}

	public int partition(int[] arr, int start, int end){
		if(arr == null || arr.length == 0){
			return -1;
		}
		int middle = arr[start];
		while(start<end){
			while(start<end && arr[end]>middle){
				end--;
			}
			arr[start] = arr[end];
			while(start<end && arr[start]<=middle){
				start++;
			}
			arr[end] = arr[start];
		}
		arr[start] = middle;
		return start;
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		int[] arr = new int[] {8,2,5,2,2,2,9,2,2,2};
		//test.partition(arr, 0, arr.length-1);
		test.moreThanHalfNum(arr);
	}
}
