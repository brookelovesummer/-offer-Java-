package Array;

import java.util.PriorityQueue;

public class Question30 {
	
	/**
	 * �ҵ���������С��k����
	 */
	
	private Question29 help = new Question29();
	
	/**
	 * ����1��ʹ��Partition������������Ԫ�ؿɵ�����n��������
	 * ʱ�临�Ӷ�O��n��
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getMinKNum(int[] arr, int k){
		if(arr == null || arr.length < k) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		if(k <= 0)
			return new int[0];
		int[] res = new int[k];
		int start = 0;
		int end = arr.length - 1;
		int index = help.Partition(arr, start, end);
		while(index != k - 1) {
			if(index > k - 1)
				index = help.Partition(arr, start, index - 1);
			else
				index = help.Partition(arr, index + 1, end);
		}
		
		for(int i=0;i<k;i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	/**
	 * ����2��ʹ�ô���ѵķ����洢k��Ԫ��
	 * �����ַ���������n�ܴ���������Ϊk�����n��˵��С������ֻ��Ҫ��С�Ĵ洢�ռ�o(k)��
	 * ����һ�Ļ���Ҫ�洢��������ģ��ռ临�Ӷ�o(n)��
	 * �������飬 ���Ѳ�����ֱ�Ӽ���Ԫ�ؼ���
	 * �������������ڶѸ�����ֱ�ӱ�����һ����
	 * ����С�ڶѸ�����ɾ���Ѹ����ٰ�����������
	 * 
	 * ��������漰���ѵ�ɾ�����ڵ㣬����ڵ�
	 * �ѵò����ɾ������O��logk��,�������鳤��n���ܵ�ʱ�临�ӶȾ���O(nlogk)
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getMinKNum_2(int[] arr, int k) {
		if(arr == null || arr.length < k) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		if(k <= 0)
			return new int[0];
		//PriorityQueueĬ����С���ѣ�������Ҫ���ӱȽ�����Lambda���ʽ����Ϊ�����
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1,o2)->o2-o1);
		for(int i=0;i<arr.length;i++) {
			if(maxheap.size() < k)
				maxheap.add(arr[i]);
			else {
				if(arr[i] < maxheap.peek()) {
					maxheap.poll();
					maxheap.add(arr[i]);
				}
			}
		}
		
		int[] res = new int[k];
		int index = 0;
		while(!maxheap.isEmpty()) {
			res[index++] = maxheap.poll();
		}
		
		return res;
	}

	public static void main(String[] args) {
		Question30 test = new Question30();
		int[] arr = {4,5,5,5,2,7,3,8};
		for(int i:test.getMinKNum_2(arr, 4)) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:test.getMinKNum(arr, 4)) {
			System.out.print(i+" ");
		}
	}
}
