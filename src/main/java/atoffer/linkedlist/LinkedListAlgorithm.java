package atoffer.linkedlist;

public class LinkedListAlgorithm {

	public LinkedNode findFirstCommonNode(LinkedNode pHead1, LinkedNode pHead2) {
		
		LinkedNode cur1 = pHead1.next;
		LinkedNode cur2 = pHead2.next;
		while(cur1 != cur2) {
			
			if(cur1 != null) {
				cur1 = cur1.next;
			}else {
				cur1 = pHead2.next;
			}
			
			if(cur2 != null){
				cur2 = cur2.next;
			}else {
				cur2 = pHead1.next;
			}
			
		}
		return cur1;
	}
}
