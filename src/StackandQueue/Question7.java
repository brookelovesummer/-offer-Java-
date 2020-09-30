package StackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question7 {
	
	
	public static void main(String[] args) {
		myQueue test = new myQueue();
		for(int i=0;i<5;i++)
			test.appendTail(i);
		for(int i=0;i<6;i++)
			System.out.print(test.deleteHead()+" ");
	}
}

class myQueue{
	
	private Stack<Integer> stack;
	private Stack<Integer> help;
	

	public myQueue() {
		stack = new Stack<>();
		help = new Stack<>();
	}
	
	public void appendTail(int a) {
		//»Î∂”
		stack.add(a);
	}
	
	public int deleteHead() {
		if(help.isEmpty())
			dao();
		if(help.isEmpty()) {
			return -1;
		}
			return help.pop();
	}
	public void dao() {
		while(!stack.isEmpty()) {
			help.add(stack.pop());
		}
	}
}

class myStack{
	
	private Queue<Integer> queue = null;
	private Queue<Integer> help = null;
	
	public myStack() {
		queue = new LinkedList<>();
		help = new LinkedList<>();
	}
	
	public void Push(int data) {
		queue.add(data);
	}
	
	public int Pop() {
		while(queue.size() > 1) {
			help.add(queue.poll());
		}
		swap();
		return help.poll();
	}
	
	private void swap() {
		Queue<Integer> t = queue;
		queue = help;
		help = t;
	}

	public int peek() {
		while(queue.size() > 1) {
			help.add(queue.poll());
		}
		return queue.peek();
	}
}
