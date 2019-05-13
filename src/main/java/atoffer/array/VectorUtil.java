package atoffer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import atoffer.util.Util;

public class VectorUtil {

	private Vector<Integer> vector;
	
	private Util util = new Util();
	
	public VectorUtil() {
		
	}
	
	public VectorUtil(Vector<Integer> vector) {
		
		this.vector = vector;
		
	}
	
	public int moreThanHalfNum(int[] arr) {
		
		if(arr == null||arr.length==0) {
			return -1;
		}
		int middle = arr.length/2;
		int start = 0, end = arr.length-1;
		int index = util.partition(arr, start, end);
		while(middle!=index) {
			
			if(index>middle) {
				index = util.partition(arr, start, index-1);
			}else {
				index = util.partition(arr, index+1, end);
			}
			
		}
		
		int result = arr[index];
		if(checkMoreThanHalf(arr, result)) {
			return result;
		}
		return -1;
		
	}
	
	private boolean checkMoreThanHalf(int[] arr, int result) {
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == result) {
				count++;
			}
		}
		return count > arr.length/2;
		
	}
	
	ArrayList<Integer> result = new ArrayList<Integer>();
	public ArrayList<Integer> GetLeastNumbers(int[] arr, int k) {
		
		if(arr == null||arr.length==0) {
			return null;
		}
		
		int start = 0, end = arr.length-1;
		int index = util.partition(arr, start, end);
		while(index!=k-1) {
			if(index>k-1) {
				index = util.partition(arr, start, index-1);
			}else {
				index = util.partition(arr, index+1, end);
			}
		}
		
		for(int i=0;i<k;i++) {
			result.add(arr[i]);
		}
		return result;
		
	}
	
	public int findGreatestSumOfSubArray(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int curSum = 0;
		int maxSum = arr[0];
		for(int i=0;i<arr.length;i++) {
			
			if(curSum<=0) {
				curSum = arr[i];
			}else {
				curSum = curSum+arr[i];
			}
			if(curSum>maxSum) {
				maxSum = curSum;
			}
			
		}
		return maxSum;
		
	}
	
	public int getNumberOfK(int[] arr, int k) {
		
		if(arr == null) {
			throw new NullPointerException("getNumberOfK's numbers is null");
		}
		int first = getFirstK(arr, k);
		int last = getLastK(arr, k);
		if(last==-1 || last==-1) {
			return 0;
		}
		return last-first+1;
	}

	public int getFirstK(int[] arr, int k) {
		
		int start = 0, end = arr.length-1;
		int middle = (start+end)/2;
		while(start<=end) {
			
			if(arr[middle]<k) {
				start = middle+1;
			}else if(arr[middle]>k) {
				end = middle-1;
			}else if((middle-1>0) && arr[middle-1] !=k ) {
				end = middle-1;
			}else {
				return middle;
			}
			
			middle = (start+end)/2;
			
		}
		return -1;
		
	}
	
	public int getLastK(int[] arr, int k) {
		int start = 0, end = arr.length-1;
		int middle = (start+end)/2;
		while(start<end) {
			
			if(arr[middle]<k) {
				start = middle+1;
			}else if(arr[middle]>k) {
				end = middle-1;
			}else if((middle+1)<=end && arr[middle+1]!=k) {
				start = middle+1;
			}else {
				return middle;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		VectorUtil vectorUtil = new VectorUtil();
		int[] arr = new int[] {1,-2,3,10,-4,7,2,-5};
		vectorUtil.GetLeastNumbers(arr, 4);
		vectorUtil.findGreatestSumOfSubArray(arr);
	}
}
