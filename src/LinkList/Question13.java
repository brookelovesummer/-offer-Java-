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
	 * ��O(1)��ʱ����ɾ��һ���ڵ�
	 */
	public ListNode deleteNodeO1(ListNode head, ListNode toBedelete) {
		
		if(head == null || toBedelete == null)
			return null;
		
		//��ɾ���ڵ�������β(β�ڵ�)��ɾ���ýڵ�����ҵ���ǰ����������Ҫ����
		//��ɾ���ڵ�������ͷ(ͷ�ڵ�)��ɾ��ͷ�ڵ�ʱ��Ҫʹ��ǰ�ڵ�nextָ��null
		//��ɾ���ڵ��������м䣬ɾ���ڵ���Բ��ú�һ���ڵ㸲��ǰһ���ڵ㣬Ȼ��ɾ����һ���ڵ�ķ���
		
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
		//ɾ��ͷ�ڵ�
//		head = test.deleteNodeO1(head, linklist[0]);
//		test.printlinklist(head);
//		//ɾ��β�ڵ�
//		head = test.deleteNodeO1(head, linklist[9]);
//		test.printlinklist(head);
//		//ɾ���м����ڵ�
//		head = test.deleteNodeO1(head, linklist[3]);
//		test.printlinklist(head);
//		head = test.deleteNodeO1(head, linklist[3]);
//		test.printlinklist(head);
//		head = test.deleteNodeO1(head, linklist[3]);
//		test.printlinklist(head);
		//��ֵУ��
		head = test.deleteNodeO1(null, null);
		test.printlinklist(head);
	}
}