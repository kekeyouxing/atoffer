package atoffer.linkedlist;

import java.awt.List;

public class LinkedListUtil {
	
	private LinkedList linkedList = null;
	
	public LinkedListUtil(LinkedList linkedList) {
		
		this.linkedList = linkedList;
		
	}
	
	/** 
	 * merge two linkedList
	 * @param pHead1 HEAD NODE of the first linkedList
	 * @param pHead2 HEAD NODE of the second linkedList
	 * @return head of the merged LinkedList
	 */
	public LinkedNode merge(LinkedNode pHead1, LinkedNode pHead2) {
		
		if(pHead1 == null) {
			return pHead2;
		}
		
		if(pHead2 == null) {
			return pHead1;
		}
		
		LinkedNode pHead = new LinkedNode(-1);
		LinkedNode res = pHead;
		LinkedNode cur1 = pHead1.next;
		LinkedNode cur2 = pHead2.next;
		while(cur1 != null && cur2 != null) {
			if(cur1.val <= cur2.val ) {
				res.next = cur1;
				cur1= cur1.next;
			}else {
				res.next = cur2;
				cur2 = cur2.next;
			}
			res = res.next;
		}
		if(cur1 == null) {
			res.next = cur2;
		}
		if(cur2 == null) {
			res.next = cur1;
		}
		return pHead;
	}
	
	/**
	 * reverse list
	 * @param pHead HEAD NODE of the linkedList
	 * @return HEAD NODE of the linkedList
	 */
	public LinkedNode reverseList(LinkedNode pHead) {
		LinkedNode pre = pHead.next;
		LinkedNode cur = pHead.next.next;
		//set the first node's next is null,first node changes to last node
		pre.next = null;
		
		while(cur != null) {
			LinkedNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		cur = new LinkedNode(-1);
		cur.next = pre;
		
		linkedList.pHead = cur;
		return cur;
		
	}
	
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
