package LinkList;

public class Question13 {
	
	public void printlinklist(ListNode head) {
		
		ListNode p = head;
		while(p != null) {
			System.out.print(p.value + " - ");
			p = p.next;
		}
		System.out.println();
	}
	
	/**
	 * 在O(1)的时间内删除一个节点
	 */
	public ListNode deleteNodeO1(ListNode head, ListNode toBedelete) {
		
		if(head == null || toBedelete == null)
			return null;
		
		//待删除节点在链表尾(尾节点)，删除该节点必须找到其前驱，所以需要遍历
		//待删除节点在链表头(头节点)，删除头节点时需要使当前节点next指向null
		//待删除节点在链表中间，删除节点可以采用后一个节点覆盖前一个节点，然后删除后一个节点的方法
		
		if(head == toBedelete) {
			head = head.next;
			toBedelete.next = null;
			//free(toBedelete)
		}else if(toBedelete.next == null) {
			ListNode p = head;
			while(p != null && p.next != toBedelete)
				p = p.next;
			p.next = toBedelete.next;
			toBedelete.next = null;
			//free(toBedelete)
		}else {
			ListNode p = toBedelete.next;
			toBedelete.value = p.value;
			toBedelete.next = p.next;
			p.next = null;
			//free(toBedelete)
		}
		return head;
	}
	

	public static void main(String[] args) {
		Question13 test = new Question13();
		ListNode[] linklist = new ListNode[10];
		
		for(int i=0;i<linklist.length;i++) {
			linklist[i] = new ListNode(i, null);
		}
		for(int i=0;i<linklist.length-1;i++) {
			linklist[i].next = linklist[i+1];
		}
		ListNode head = linklist[0];
//		test.printlinklist(head);
		//删除头节点
//		head = test.deleteNodeO1(head, linklist[0]);
//		test.printlinklist(head);
//		//删除尾节点
//		head = test.deleteNodeO1(head, linklist[9]);
//		test.printlinklist(head);
//		//删除中间俩节点
//		head = test.deleteNodeO1(head, linklist[3]);
//		test.printlinklist(head);
//		head = test.deleteNodeO1(head, linklist[3]);
//		test.printlinklist(head);
//		head = test.deleteNodeO1(head, linklist[3]);
//		test.printlinklist(head);
		//空值校验
		head = test.deleteNodeO1(null, null);
		test.printlinklist(head);
	}
}