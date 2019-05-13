package atoffer.sort;

public class Bootstrap {

	public static void main(String[] args) {
		Sort sort = new Sort();

		int[] arr = new int[] {5, 3, 8, 3, 9, 1};
		System.out.print("Being merged sorted ,data is:\n");
		sort.mergeSort(arr);
		Bootstrap.print(arr);
		System.out.print("\n");
	}
	
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
}
