package Array;

public class Question29 {
	
	/**
	 * 根据快排的思想，Partition函数是将数组的start-end部分
	 * 大于随机选择的数放在该数的右边，小于该数的数放在该数的左边
	 * 返回小区的size
	 * （小区的size）同时也是选择的这个数字在整体排序后的索引
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public int Partition(int[] arr, int start, int end) {
		if(arr == null || arr.length <= 0 || start < 0 || end >= arr.length) {
			System.out.println("invalid input!");
			System.exit(1);
		}
		
		int index =(int) Math.random()*(end - start) + start;
		int small = start - 1;
		swap(arr,index,end);
		for(int i=start;i<end;i++) {
			if(arr[i] < arr[end]) {
				small++;
				if(small != i)
					swap(arr,i,small);
			}
		}
		small++;
		swap(arr,small,end);
		return small;
	}
	
	public int[] QuickSort(int[] arr) {
		if(arr == null || arr.length <= 0)
			return null;
		QuickSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public void QuickSort(int[] arr, int start, int end) {
		if(start == end)
			return;
		int index = Partition(arr, start, end);
		if(index > start)
			QuickSort(arr, start, index-1);
		if(index < end)
			QuickSort(arr, index+1, end);
	}
	
	
	private void swap(int[] arr, int index, int end) {
		int temp = arr[index];
		arr[index] = arr[end];
		arr[end] = temp;
	}
	
//	private static void printarr(int[] arr) {
//		for(int i:arr)
//			System.out.print(i+" ");
//		System.out.println();
//	}
	
	/***********************以下是面试题29的相关内容--数组中元素超过一半的数字*************************************/
	
	/**
	 * 方法1：使用Partition函数，这种方法会改变数组元素
	 * 
	 * 超过一半的数字，排完序后，该元素肯定是数组的中间位置
	 * 我们使用Partition函数，获取排序后的索引，只要得到索引为n/2，对应元素即为所求
	 * @param arr
	 * @return
	 */
	public int getMorethanHalf(int[] arr) {
		if(arr == null || arr.length <= 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		
		int midium = arr.length >> 1;
		int start = 0;
		int end = arr.length - 1;
		int index = Partition(arr, start, end);//index指的是排序后的索引
		while(index != midium) {
			if(index > midium)
				index = Partition(arr, start, index-1);
			else
				index = Partition(arr, index+1, end);
		}
		int result = arr[index];
		//注意result这个数需要验证，如果最大的数也没超过n/2
		int count = 0;
		for(int i:arr) {
			if(i == result)
				count++;
		}
		if(count <= midium) {
			System.out.println("There is no number meet condition in arr!");
			System.exit(2);
		}
		return  result;
	}
	
	
	/**
	 * 方法2：不改变元素的相对顺序的前提下，找到该元素
	 * 
	 * 思路：因为该元素出现次数超过n/2，说明该元素的次数比剩余元素出现之和还要多
	 * 一个变量记录元素，一个计数变量记录元素出现的次数
	 * 当我们遍历到下一个数字时，若该数字和我们当前记录的数字相同，则计数变量加1；
	 * 若该数字和我们当前记录的数字不同，则计数变量减1；
	 * 若计数变量为0，我们需要更新记录的元素，并把计数变量置1。
	 * 这样，当我们遍历完，记录变量保存的就是数组中存在次数超过n/2的元素
	 * @param arr
	 * @return
	 */
	public int getMorethanHalf_2(int[] arr) {
		if(arr == null || arr.length <= 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		
		int result = 0;
		int times = 0;
		for(int i=0;i<arr.length;i++) {
			if(times == 0) {
				result = arr[i];
				times++;
			}else if(arr[i] == result)
				times++;
			else
				times--;
		}
		
		//以下为检验该数是否符合要求
		int count = 0;
		for(int i:arr) {
			if(i == result)
				count++;
		}
		if(count <= arr.length >> 1) {
			System.out.println("There is no number meet condition in arr!");
			System.exit(2);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Question29 test = new Question29();
		int[] arr = {1,2,3,2,2,2,5,4,2};
		System.out.println(test.getMorethanHalf(arr));
		System.out.println(test.getMorethanHalf_2(arr));
	}
}
