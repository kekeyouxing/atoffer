package atoffer.sort;

public class Bootstrap {

	public static void main(String[] args) {
		Sort sort = new Sort();
		//bubble sort
		System.out.print("initial data is:\n");
		int[] bubbleInit = new int[] {5, 3, 8, 3, 9, 8};
		sort.print(bubbleInit);
		System.out.print("\n");
		
		System.out.print("Being bubble sorted ,data is:\n");
		int[] bubbleSort = sort.bubbleSort(bubbleInit);
		sort.print(bubbleSort);
		System.out.print("\n");
		
		//insertSort
		System.out.print("initial data is:\n");
		int[] insertInit = new int[] {5, 3, 8, 3, 9, 8};
		sort.print(insertInit);
		System.out.print("\n");
		
		System.out.print("Being insert sorted ,data is:\n");
		int[] insertSort = sort.insertSort(bubbleInit);
		sort.print(insertSort);
		System.out.print("\n");
		
		//simpleSort
		System.out.print("initial data is:\n");
		int[] simpleInit = new int[] {5, 3, 8, 3, 9, 8};
		sort.print(simpleInit);
		System.out.print("\n");
		
		System.out.print("Being simplely sorted ,data is:\n");
		int[] simpleSort = sort.simpleSort(simpleInit);
		sort.print(simpleSort);
		System.out.print("\n");
	}
	
	
	
}
