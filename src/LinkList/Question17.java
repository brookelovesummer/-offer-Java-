package LinkList;

public class Question17 {
	
	/**
	 * 合并两个排序链表(非递归版)
	 */
	
	public ListNode mergelinklists(ListNode head1, ListNode head2) {
		if(head1 == null || head2 == null)
			return head1 == null ? head2 : head1;
		
		ListNode head = new ListNode(-1,null);
		ListNode temp = head;
		while(head1 != null && head2 != null) {
			if(head1.value < head2.value) {
				temp.next = head1;
				head1 = head1.next;
			}else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		if(head1 != null)
			temp.next = head1;
		if(head2 != null)
			temp.next = head2;
		return head.next;
	}
	
	/**
	 * 合并两个有序链表（递归版）
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode mergelinklistrecurisely(ListNode head1,ListNode head2) {
		if(head1 == null || head2 == null) 
			return head1 == null ? head2 : head1;
		
		ListNode head = null;
		if(head1.value < head2.value) {
			head = head1;
			head.next = mergelinklistrecurisely(head1.next, head2);
		}else {
			head = head2;
			head.next = mergelinklistrecurisely(head1, head2.next);
		}
		return head;
	}
	
	public static void main(String[] args) {
		Question17 test = new Question17();
		int[] arr1 = {};
		int[] arr2 = {9};
		ListNode head1 = new Question5().CreateLinklist(arr1);
		ListNode head2 = new Question5().CreateLinklist(arr2);
//		ListNode head = test.mergelinklistrecurisely(head1, head2);
		ListNode head = test.mergelinklists(head1, head2);
		new Question13().printlinklist(head);
		
	}
}
