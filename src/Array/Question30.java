package Array;

import java.util.PriorityQueue;

public class Question30 {
	
	/**
	 * 找到数组中最小的k个数
	 */
	
	private Question29 help = new Question29();
	
	/**
	 * 方法1：使用Partition函数，适用于元素可调，且n不大的情况
	 * 时间复杂度O（n）
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
	 * 方法2：使用大根堆的方法存储k个元素
	 * （这种方法适用于n很大的情况，因为k相对于n来说很小，所以只需要很小的存储空间o(k)，
	 * 方法一的话需要存储整个数组的，空间复杂度o(n)）
	 * 遍历数组， 当堆不满，直接加入元素即可
	 * 堆满后：若数大于堆根，则直接遍历下一个数
	 * 若数小于堆根，则删除堆根，再把这个数加入堆
	 * 
	 * 这个过程涉及到堆的删除根节点，插入节点
	 * 堆得插入和删除都是O（logk）,整个数组长度n，总的时间复杂度就是O(nlogk)
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
		//PriorityQueue默认是小根堆，所以需要增加比较器（Lambda表达式）变为大根堆
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
