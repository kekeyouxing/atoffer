package atoffer.linkedlist;

public class Bootstrap {

	public static void main(String[] args) {

		LinkedListAlgorithm lla = new LinkedListAlgorithm();

		LinkedList linkA = new LinkedList();
		int[] c = new int[]{2, 2, 6, 7, 10};
		System.out.print("Create LinkedList-A: ");
		linkA.create(c);
		System.out.println(linkA);

		int val = 9;
		System.out.print("Add " + val + " LinkedList-A: ");
		linkA.add(val);
		System.out.println(linkA);

//		val = 2;
//		System.out.print("Remove " + val + ", LinkedList-A: ");
//		linkA.remove(val);
//		System.out.println(linkA);

		System.out.print("Reverse LinkedList-A: ");
		linkA.reverseList();
		System.out.println(linkA);

		System.out.print("Remove duplicate LinkedList-A: ");
		linkA.removeDuplicate();
		System.out.println(linkA);
	}

}
