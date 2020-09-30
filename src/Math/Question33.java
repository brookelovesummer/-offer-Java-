package Math;

import java.util.Arrays;

public class Question33 {
	
	/**
	 * �������Ԫ�����г���С����
	 * �������������ͣ���ϳ�����ܿ������
	 * ������Ҫʹ���ַ����������������
	 * �Ƚ�arrת��Ϊ�ַ������飬Ȼ����ַ��������������ֱ�ӽ��������ַ�������ƴ�������ͺ�
	 * 
	 * ����ʽ��mn>nm����m > n
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
	
	
	/***********************�������Լ��������㷨*******************************/
	public int minPermutation_hzh() {
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,32,321};
		Question33 test = new Question33();
		System.out.println(test.minPermutation(arr));
	}

}
