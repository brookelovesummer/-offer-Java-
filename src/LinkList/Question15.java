package LinkList;

public class Question15 {
	
	/**
	 * 链表的倒数第k个节点
	 * 
	 * 注意对链表的题一定注意判空
	 * 本题还需要注意节点个数少于k个应该怎么办
	 * 
	 * 
	 * 若k是无符号整型（c/c++），还需要考虑k不能为0，因为0-1会是一个很大的正数，死循环
	 */
	public ListNode getreverseKnode(ListNode head, int k) {
		
		if(head == null || k <= 0)
			return null;
		
		ListNode pre = head;
		ListNode late = head;
		
		//pre先走k-1步
		int i=1;
		for(;i<k && pre != null;i++)
			pre = pre.next;
		//判断k是不是大于n
		if(i < k - 1)
			return null;
		
		while(pre.next != null) {
			pre = pre.next;
			late = late.next;
		}
				
		return late;
	}
	

	public static void main(String[] args) {
		Question15 test = new Question15();
		int[] arr = {1,2,3,4,5,6};
		int k = 2;
		ListNode head =new Question5().CreateLinklist(arr);
		ListNode knode = test.getreverseKnode(head, k);
		if(knode != null)
			System.out.println(knode.value);
	}
}
