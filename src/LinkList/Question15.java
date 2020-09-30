package LinkList;

public class Question15 {
	
	/**
	 * ����ĵ�����k���ڵ�
	 * 
	 * ע����������һ��ע���п�
	 * ���⻹��Ҫע��ڵ��������k��Ӧ����ô��
	 * 
	 * 
	 * ��k���޷������ͣ�c/c++��������Ҫ����k����Ϊ0����Ϊ0-1����һ���ܴ����������ѭ��
	 */
	public ListNode getreverseKnode(ListNode head, int k) {
		
		if(head == null || k <= 0)
			return null;
		
		ListNode pre = head;
		ListNode late = head;
		
		//pre����k-1��
		int i=1;
		for(;i<k && pre != null;i++)
			pre = pre.next;
		//�ж�k�ǲ��Ǵ���n
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
