package atoffer.linkedlist;

public class Bootstrap {
	
	public static void main(String[] args) {
		
		LinkedListAlgorithm lla = new LinkedListAlgorithm();
		
		
		LinkedList link = new LinkedList();
		int [] arr = new int[] {1,2,3,4,2,5,7};
		
		System.out.println("after creating LinkedList, LinkedList is:");
		LinkedNode pHead = link.createLinkedList(arr);
		lla.printList(pHead);
		
		System.out.println("\nafter reversing LinkedList, LinkedList is:");
		pHead = lla.reverseList(pHead);
		lla.printList(pHead);
	}
	
}
