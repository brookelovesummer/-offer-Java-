package LinkList;

public class Question37 {
	
	/**
	 * 两个链表的第一个公共节点
	 */
	
	public ListNode getFirstCommomNode(ListNode L1, ListNode L2) {
		if(L1 == null || L2 == null) {
			return null;
		}
		int length1 = L1.getlength(L1);
		int length2 = L2.getlength(L2);
		int num = Math.abs(length1-length2);
		if(length1 > length2) {
			while(num-- > 0) {
				L1 = L1.next;
			}
		}else {
			while(num-- > 0) {
				L2 = L2.next;
			}
		}
		while(L1 != null && L2 != null && L1 != L2) {
			L1 = L1.next;
			L2 = L2.next;
		}
		return L1;
	}
	
	

}
