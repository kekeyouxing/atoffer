package atoffer.linkedlist;

public class Bootstrap {
	
	public static void main(String[] args) {
		
		LinkedList link = new LinkedList();
		int [] arr = new int[] {1,2,3,4,2,5,7};
		
		System.out.println("after creating LinkedList, LinkedList is:");
		LinkedNode pHead = link.createLinkedList(arr);
		link.printList();
		
//		LinkedListUtil listUtil = new LinkedListUtil(link);
//		
//		System.out.println("\nafter reversing LinkedList, LinkedList is:");
//		listUtil.reverseList(pHead);
//		link.printList();
		
	}
	
}
