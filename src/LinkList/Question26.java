package LinkList;

import java.util.HashMap;

public class Question26 {
	
	/**
	 * ���ù�ϣ��洢��ǰ�ڵ�͸��ƽڵ�Ķ�Ӧ��ϵ(����������֤����)
	 * @param head
	 * @return
	 */
	public RandomListNode copyrlink(RandomListNode head) {
		
		if(head == null)
			return null;
		
		RandomListNode p = head;
		HashMap<RandomListNode, RandomListNode> map =new HashMap<RandomListNode,RandomListNode>();
		while(p != null) {
			RandomListNode rl = new RandomListNode(p.value);
			map.put(p, rl);
			p = (RandomListNode)p.next;
		}
		p = head;
		RandomListNode copy = map.get(p);
		RandomListNode q = copy;
		while(p != null) {
			q.next = map.get(p.next);
			q.rand = map.get(p.rand);
			q = (RandomListNode)q.next;
			p = (RandomListNode)p.next;
		}
		return copy;
	}
	
	/**
	 * �����ƵĽڵ���ڽڵ�֮��Ȼ���������������(����������֤����)
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomLinklist(RandomListNode head) {
		if(head == null)
			return null;
		
		RandomListNode r = head;
		while(r != null) {
			RandomListNode p = new RandomListNode(r.value);
			p.next = r.next;
			r.next = p;
			r =(RandomListNode)p.next;
		}
		r = head;
		RandomListNode p = null;
		while(r != null && r.next != null) {
            p = (RandomListNode)r.next;
            if(r.rand != null)
			    p.rand = r.rand.next;
            else
                p.rand = null;
			r =(RandomListNode)r.next.next;
		}
		//������������
		r = head;
		p = (RandomListNode)r.next;
		RandomListNode copyhead = p;
		while(p != null && p.next != null) {
			r.next = r.next.next;
            r = (RandomListNode)r.next;
			p.next = p.next.next;
            p = (RandomListNode)p.next;
		}
        r.next = null;
        p.next = null;
		return copyhead;
	}
	
	public static void main(String[] args) {
		
	}
}



class RandomListNode extends ListNode{

	public ListNode rand;
	public RandomListNode(int value) {
		super(value);
		this.next = null;
		this.rand = null;
	}
	
}
