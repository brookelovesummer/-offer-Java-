package StackandQueue;

import java.util.Stack;

public class Question22 {
	
	/**
	 * 栈的压入弹出序列
	 * 
	 * 一个辅助栈，根据poparr的数字我们压入pusharr，直到满足poparr的弹出条件，
	 * 如果pusharr元素压完，仍然不满足poparr的弹出条件，则返回false
	 * 
	 * 注意，如果是正确的poparr的子数组，那么结果也应该为true
	 */
	
	
	/**
	 * 若下一个弹出的数字恰好是栈顶数字，则直接弹出。
	 * 若不是栈顶数字，则将压栈序列中还没有压入的元素入栈，直到把下一个弹出的元素压入栈。
	 * 若所有的元素都已入栈，仍没有找到下一个要弹出的数字，则该序列不可能是一个弹出序列。
	 * @param pusharr
	 * @param poparr
	 * @return
	 * @throws Exception
	 */
	public boolean IsPopOrder(int[] pusharr, int[] poparr)throws Exception {
		
		if(pusharr == null || poparr == null)
			throw new Exception("Invalid input sequence!");
		
		int pushindex = 0;
		int popindex = 0;
		Stack<Integer> stack = new Stack<>();
		while(popindex < poparr.length) {
			int num = poparr[popindex++];
			if(stack.isEmpty()) {
				stack.push(pusharr[pushindex++]);
			}
			if(stack.peek() == num)
				stack.pop();
			else {
				if(pushindex >= pusharr.length)
					return false;
				while(pushindex < pusharr.length && pusharr[pushindex] != num) {
					stack.push(pusharr[pushindex++]);
				}
				pushindex++;

			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Question22 test = new Question22();
		int[] pusharr = {1,2,3,4,5};
//		int[] poparr = {4,5,3,2};
		int[] poparr = {4,3,5,1};
		System.out.println(test.IsPopOrder(pusharr, poparr));
	}

}
