package StackandQueue;
import java.util.Stack;

public class Question21 {
	
	public static void main(String[] args) {
		MinStack<myNode> test = new MinStack<>();
		int[] arr = {3,4,5,2,1};
		for(int i : arr) {
			myNode node = new myNode(i);
			test.push(node);
			System.out.print(test.min()+" ");
		}
		test.pop();
		test.pop();
		System.out.print(test.min()+" ");
		test.pop();
		System.out.print(test.min()+" ");

	}

}

class myNode implements Comparable<myNode>{
	int value;

	public myNode(int value) {
		super();
		this.value = value;
	}

	@Override
	public int compareTo(myNode o) {
		return this.value - o.value;
	}

	@Override
	public String toString() {
		return "myNode [value=" + value + "]";
	}	
}

/**
 * 实现包含min()的栈，min(),pop(),push()都是o(1)
 * @author brooke
 *
 */
class MinStack<E extends Comparable<E>>{
	
	private Stack<E> data;
	private Stack<E> help;
	
	public MinStack() {
		this.data = new Stack<>();
		this.help = new Stack<>();
	}
	
	public E min() {
		if(data.isEmpty() && help.isEmpty())
			try {
				throw new Exception("Stack is empty!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return help.peek();
	}
	
	public E pop() {
		if(data.isEmpty() && help.isEmpty())
			try {
				throw new Exception("Stack is empty!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		help.pop();
		return data.pop();
	}
	
	
	
	public void push(E a) {
		data.push(a);
		if(help.isEmpty() || (a.compareTo(help.peek()) < 0))
			help.push(a);
		else
			help.push(help.peek());
	}
}