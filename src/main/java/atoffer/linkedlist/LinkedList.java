package atoffer.linkedlist;


/**
 * @author Ke
 *包含头结点的链表
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
		
		LinkedNode pre = pHead;
		
		while(pre.next !=null)
			pre = pre.next;
		
		LinkedNode node = new LinkedNode(val);
		pre.next = node;
		
	}
	
	public void remove(int val) {
		
		LinkedNode pre = pHead;
		while(pre != null && pre.next != null) {
			if(pre.next.val == val) {
				pre.next = pre.next.next;
			}else {
				pre = pre.next;
			}
			
		}
		
	}
	
	public boolean containsOf(int val) {
		
		LinkedNode pre = pHead.next;
		
		while(pre != null ) {
			
			if(pre.val == val) {
				return true;
			}
			pre = pre.next;
			
		}
		return false;
		
	}
	
	public void printList() {
		
		LinkedNode first = pHead.next;
		while(first != null) {
			System.out.print(first.val+"->");
			first = first.next;
		}
	}
	
	public boolean isEmpty() {
		
		return pHead.next == null;
		
	}
	
}
