package StackandQueue;

import java.util.Stack;

public class Question22 {
	
	/**
	 * ջ��ѹ�뵯������
	 * 
	 * һ������ջ������poparr����������ѹ��pusharr��ֱ������poparr�ĵ���������
	 * ���pusharrԪ��ѹ�꣬��Ȼ������poparr�ĵ����������򷵻�false
	 * 
	 * ע�⣬�������ȷ��poparr�������飬��ô���ҲӦ��Ϊtrue
	 */
	
	
	/**
	 * ����һ������������ǡ����ջ�����֣���ֱ�ӵ�����
	 * ������ջ�����֣���ѹջ�����л�û��ѹ���Ԫ����ջ��ֱ������һ��������Ԫ��ѹ��ջ��
	 * �����е�Ԫ�ض�����ջ����û���ҵ���һ��Ҫ���������֣�������в�������һ���������С�
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
