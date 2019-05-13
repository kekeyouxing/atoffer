package atoffer;

import atoffer.dynamic.Dynamic;

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

	public int jumpFloor(int n) {
		if(n == 0 || n == 1 || n == 2) 
			return n;
		
		int[] dp = new int[n+1];
		dp[0] = 0; dp[1] = 1; dp[2] = 2;
		for(int i =3 ; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public int numDecodings(String s) {
		
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		int[] val = string2Array(s);
		int[] dp = new int[val.length+1];
		dp[0] =1; dp[1] = (val[0] == 0 ? 0 : 1);
		for(int i=2; i<val.length; i++) {
			
			if(val[i-1] != 0) {
				dp[i] = dp[i] + dp[i-1];
			}
			if(val[i-2] != 0 && val[i-2] * 10 + val[i-1] <= 26) {
				dp[i] = dp[i] + dp[i-2];
			}
			
		}
		return dp[val.length];
		
	}
	
	private int[] string2Array(String s) {
		
		int[] val = new int[s.length()]; 
		for(int i=0; i<val.length; i++) {
			val[i] = Integer.parseInt(s.substring(i, i+1));
		}
		return null;
		
	}

	public static void main(String[] args) {
		Test test = new Test();
		int[] arr = new int[] {8,2,5,2,2,2,9,2,2,2};
	}
	
}
