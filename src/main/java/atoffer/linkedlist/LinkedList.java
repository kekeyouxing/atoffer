package atoffer.linkedlist;


/**
 * @author Ke
 * 包含头结点的链表
 */ 
public class LinkedList {

	protected LinkedNode pHead = null;
	
	
	public LinkedNode createLinkedList(int[] arr) {
		pHead = new LinkedNode(-1);
		LinkedNode cur = pHead;
		for(int i=0; i<arr.length; i++) {
			cur.next = new LinkedNode(arr[i]);
			cur = cur.next;
		}
		return pHead;
	}
	
	public void add(int val) {
		LinkedNode x = pHead.next;
		
		while(x != null)
			x = x.next;
		
		x = new LinkedNode(val);
	}
	
	public void remove(int val) {
		LinkedNode x = pHead;
		while(x != null && x.next != null) {
			if(x.next.val == val) {
				x.next = x.next.next;
			}else {
				x = x.next;
			}
			
		}
	}
	
	public boolean containsOf(int val) {
		LinkedNode x = pHead.next;
		
		while(x != null ) {
			
			if(x.val == val) {
				return true;
			}
			x = x.next;
			
		}
		return false;
	}
	
	public boolean isEmpty() {
		return pHead.next == null;
	}
	
}
