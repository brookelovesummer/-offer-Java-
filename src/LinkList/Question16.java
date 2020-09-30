package LinkList;

public class Question16 {
	
	/**
	 * 反转链表（非递归版）
	 */
	public ListNode reverseLinklist(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode former = null;
		ListNode current = head;
		ListNode later = current.next;
		while(later != null) {
			current.next = former;
			former = current;
			current = later;
			later = later.next;
		}
		current.next = former;
		return current;
	}
	
	public ListNode reverselinklistrecurisely(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		else {
			ListNode p = reverselinklistrecurisely(head.next);
			head.next.next = head;
			head.next = null;
			return p;
		}
	}

	public static void main(String[] args) {
		Question16 test = new Question16();
		int[] arr = {1,2,3,4,5,6,7};
		ListNode head = new Question5().CreateLinklist(arr);

		head = test.reverseLinklist(head);
		new Question13().printlinklist(head);
		head = test.reverselinklistrecurisely(head);
		new Question13().printlinklist(head);
	}
}
