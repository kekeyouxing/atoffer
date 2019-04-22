package atoffer.linkedlist;

public class CycleLinkedList {
	
	private LinkedNode nodeEncounter = null;
	
	private LinkedNode pHead = null;
	
	public CycleLinkedList(LinkedNode pHead) {
		this.pHead = pHead;
	}
	/**
	 * @param pHead
	 * @return node of encounter
	 */
	public boolean hasCycle() {
		
		if(pHead == null || pHead.next == null || pHead.next.next == null)
			return false;
		
		LinkedNode slow = pHead.next;
		LinkedNode fast = pHead.next.next;
		
		while(fast != slow) {
			
			if(fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
			
		}
		nodeEncounter = slow;
		return true;
	}
	
	public LinkedNode detectCycle(){
		
		if(!hasCycle()) {
			return null;
		}
			
		LinkedNode p = nodeEncounter;
		LinkedNode q = pHead.next;
		
		while(p != q) {
			p = p.next;
			q = q.next;
		}
		return p;
		
	}
}
