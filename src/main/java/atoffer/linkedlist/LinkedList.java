package atoffer.linkedlist;

/**
 * @author Ke
 * 包含头结点的链表
 */ 
public class LinkedList {

	protected LinkedNode head;

	protected LinkedNode tail;

	public LinkedList(){
		head = new LinkedNode(-1);
		tail = head;
	}
	public LinkedNode create(int[] c){
		if (c == null || c.length == 0){
			return head;
		}
		LinkedNode current = head;
		for (int i = 0; i < c.length; i++) {
			current.next = new LinkedNode(c[i]);
			current = current.next;
		}
		tail = current;
		return head;
	}

	public void add(int val) {
		tail.next = new LinkedNode(val);
		tail = tail.next;
	}
	
	public void remove(int val) {
		LinkedNode x = head;
		while(x != null && x.next != null) {
			if(x.next.val == val) {
				x.next = x.next.next;
			}else {
				x = x.next;
			}
		}
	}

	public void removeDuplicate(){
		if(isEmpty()){
			return;
		}
		LinkedNode i = head;
		LinkedNode j = i.next;
		while (j != null){
			if (j.next != null && j.val == j.next.val) {
				while (j.next != null && j.val == j.next.val){
					j = j.next;
				}
				i.next = j.next;
			}else {
				i = i.next;
			}
			if (j.next == null){
				tail = j;
			}
			j = j.next;
		}
	}

	public boolean containsOf(int val) {
		LinkedNode x = head.next;
		while(x != null ) {
			if(x.val == val) {
				return true;
			}
			x = x.next;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return head.next == null;
	}

	/**
	 * 链表中是否有环
	 * 如果没环返回null
	 * 如果有环返回entry
	 */
	public LinkedNode findEntryInCircle(){
		if (isEmpty()){
			return null;
		}
		LinkedNode slow = head.next;
		LinkedNode fast = head.next;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		if (fast == null || fast.next == null){
			return null;
		}
		LinkedNode entry = head.next;
		while (entry!=slow){
			entry = entry.next;
			slow = slow.next;
		}
		return entry;
	}

	public LinkedNode reverseList(){
		if (isEmpty()){
			return head;
		}
		LinkedNode prev = null;
		LinkedNode next;
		LinkedNode head = this.head.next;
		tail = head;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		head = new LinkedNode(-1);
		head.next = prev;
		this.head = head;
		return head;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedNode x = head.next;
		while(x != null) {
			sb.append(x.val);
			if(x.next != null) {
				sb.append("->");
			}
			x = x.next;
		}
		return sb.toString();
	}
}
