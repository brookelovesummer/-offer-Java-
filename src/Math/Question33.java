package Math;

import java.util.Arrays;

public class Question33 {
	
	/**
	 * 由输入的元素排列成最小的数
	 * 输入是整数类型，组合成数后很可能溢出
	 * 所以需要使用字符串来处理大数问题
	 * 先将arr转化为字符串数组，然后对字符串数组进行排序，直接将排序后的字符串数组拼接起来就好
	 * 
	 * 排序方式：mn>nm，则m > n
	 * @param arr
	 * @return
	 */
	public String minPermutation(int[] arr) {
		
		String[] nums = new String[arr.length];
		for(int i=0;i<arr.length;i++) {
			nums[i] = arr[i]+"";
		}
		Arrays.sort(nums,(a,b)->comparetor(a, b));
		StringBuilder res = new StringBuilder();
		for(String num:nums)
			res.append(num);
		return res.toString();
		
	}
	
	private int comparetor(String a, String b) {
		String s1 = a+b;
		String s2 = b+a;
			
		return s1.compareTo(s2);
	}
	
	
	/***********************以下是自己开发的算法*******************************/
	public int minPermutation_hzh() {
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,32,321};
		Question33 test = new Question33();
		System.out.println(test.minPermutation(arr));
	}

}
