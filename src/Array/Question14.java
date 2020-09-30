package Array;

public class Question14 {
	
	/**
	 * 将arr中奇数移到偶数之前
	 * 
	 * 奇数指针负责检查前面部分有没有偶数，偶数指针负责检验后面有没有奇数
	 * 如果俩指针再还没遇到之前就分别指向了奇数和偶数，则交换
	 * 
	 * 这样比直接遍历找到一个偶数就移到最后面要好！直接遍历移动O(n2)
	 * @param arr
	 * @return
	 */
	public int[] reOrderArr(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return null;
		
		int begin = 0;
		int end = arr.length - 1;
		while(begin < end) {
			
			while(begin < end && (arr[begin]&1) == 1)
				begin++;
			while(begin < end && (arr[end]&1) == 0)
				end--;
			
			if(begin < end) {
				int t = arr[begin];
				arr[begin] = arr[end];
				arr[end] = t;
			}
		}
		return arr;
	}
	
	/**
	 * 学习解耦，将上述方法中，交换数组  与  奇偶条件解耦，这样就可以将奇偶条件换成其他条件
	 * 这样就是可以方便的添加其他条件，使得函数满足其他条件下交换数组 
	 * @param args
	 */
	public int[] changeArr(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return null;
		
		int begin = 0;
		int end = arr.length - 1;
		while(begin < end) {
			
			while(begin < end && !isEven(arr[begin]))
				begin++;
			while(begin < end && isEven(arr[end]))
				end--;
			
			if(begin < end) {
				int t = arr[begin];
				arr[begin] = arr[end];
				arr[end] = t;
			}
		}
		return arr;
	}
	
	boolean isEven(int num) {
		return (num & 1) == 0;
	}
	
	/**
	 * 满足3的倍数的移到前面，不满足后面，这时可替换条件函数为下面的函数
	 * @param args
	 */
	public boolean devideby3(int num) {
		return num % 3 == 0;
	}
	
	/**
	 * 负数移到数组前面，非负数移到后面
	 * @param args
	 */
	public boolean isnegative(int num) {
		return num < 0;
	}
	public static void main(String[] args) {
		Question14 test = new Question14();
//		int[] arr = {1,2,3,4,5,6,7};
//		int[] arr = {6,2, 4, 3, 5, 1, 7};
//		int[] arr = {7 ,1, 5, 3, 4, 2, 6};
		int[] arr = null;
		arr = test.reOrderArr(arr);
		if(arr != null) {
			for(int i:arr) {
				System.out.print(i + "  ");
			}
		}
	}
}
