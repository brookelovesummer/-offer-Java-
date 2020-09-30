package Math;

import java.util.ArrayList;
import java.util.List;

public class Question41 {
	
	/**
	 * 和为s的两个数字以及和为s的连续正数序列
	 * 
	 * 排序数组-双指针
	 * 普通数组-哈希表
	 */
	
	public int[] twoSum(int[] arr, int target) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		int L = 0;
		int R = arr.length - 1;
		while(L < R) {
			if(arr[L] + arr[R] < target) {
				L++;
			}else if(arr[L] + arr[R] > target) {
				R--;
			}else {
				return new int[] {arr[L],arr[R]};
			}
		}
		return null;
	}
	
	/**
	 * 和为n的连续正数序列
	 * @param n
	 * @return
	 */
	public List<List<Integer>> getSequeceofNum(int n){
		if(n <= 0)
			return null;
		
		List<List<Integer>> res = new ArrayList<>();
		int small = 1;
		int big = 2;
		int sum = 3;
		int end = (1+n)>>1;
		while(small <= end) {
			if(sum < n) {
				big++;
				sum += big;
			}else if(sum > n) {
				sum -= small;
				small++;
			}else {
				List<Integer> list = new ArrayList<>();
				for(int i=small;i<=big;i++) {
					list.add(i);
				}
				res.add(list);
				sum -= small;
				small++;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Question41 test = new Question41();
		int[] arr = {1,3,5,6,8};
		arr = test.twoSum(arr, 21);
		if(arr != null)
			System.out.println("("+arr[0]+","+arr[1]+")");
		
		for(List<Integer> list : test.getSequeceofNum(15)) {
			for(int num : list) {
				System.out.print(num + " ");
			}
			System.out.println("\n");
		}
	}

}
