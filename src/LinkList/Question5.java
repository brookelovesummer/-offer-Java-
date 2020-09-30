package LinkList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question5 {
	
	public void PrintReverseWithStack(ListNode head) {
		
		if(head == null) {
			System.out.println("There is nothing to print!");
			return ;	
		}
		
		Stack<Integer> stack = new Stack<>();
		ListNode p = head;
		while(p != null) {
			stack.add(p.value);
			p = p.next;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " -> ");
		}
	}
	
	public void PrintReverseWithRecursion(ListNode head) {
		
		if(head == null) 
			return ;	
		
		PrintReverseWithRecursion(head.next);
		System.out.print(head.value + " -> ");
	}
	
	public ListNode CreateLinklist(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return null;
		
		ListNode head = new ListNode(arr[0], null);
		ListNode r = head;
		for(int i=1;i<arr.length;i++) {
			ListNode p = new ListNode(arr[i], null);
			r.next = p;
			r = p;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		
//		int[] nums = {1,2,3,4,5,6};
		int[] nums = {1};
		Question5 test = new Question5();
		ListNode head = test.CreateLinklist(nums);
		test.PrintReverseWithStack(head);
		System.out.println();
		test.PrintReverseWithRecursion(head);
		List<Integer> list = new ArrayList<>();
		list.sort((o1,o2)->o1-o2);
	}
	

}

class ListNode{
	
	int value;
	ListNode next;
	
	
	
	public ListNode(int value) {
		this.value = value;
	}



	public ListNode(int value, ListNode next) {
		super();
		this.value = value;
		this.next = next;
	}

	public int getlength(ListNode L) {
		
		ListNode p = L;
		int res = 0;
		while(p != null) {
			res++;
			p = p.next;
		}
		return res;
	}


	@Override
	public String toString() {
		return "ListNode [value=" + value + ", next=" + next + "]";
	}
}