package Math;

public class Question12 {

	/**
	 * 这个函数用于计算字符串形式下模拟整数加法,k只能是个位数
	 * @param num
	 * @param k
	 * @return
	 */
	public String Incresment(String num,int k) {
		
		StringBuilder sb = new StringBuilder(num);
		int index = num.length()-1;
		while(k != 0 && index >= 0) {
			char ch = sb.charAt(index);
			if(ch + k > '9') {
				ch = (char) (ch + k - 10);
				k = 1;
			}else {
				ch = (char) (ch + k);
				k = 0;
			}
			sb.setCharAt(index--, ch);
		}
		if(k != 0)
			sb.insert(0, '1');
		return sb.toString();
	}
	
		
	public void print1toMaxofNdigits(int n) {
		if(n <= 0)
			return;
		
		String res = Incresment("0", 1);
		while(res.length() <= n) {
			System.out.print(res + "  ");
			res = Incresment(res, 1);
		}	
	}
	
	/*******************考虑数字的全排就是我们要的答案，可以采用递归实现全排************************/
	public void print1toMaxofNdigits1(int n){
		
		if(n <= 0)
			return;
		
		char[] numbers = new char[n];
		printDigitsRecursively(numbers,0);
	}
	
	/**
	 * 递归实现全排
	 * @param numbers
	 * @param index
	 */
	private void printDigitsRecursively(char[] numbers, int index) {
		
		if(index == numbers.length) {
			print(numbers);
			return;
		}
		
		for(int i=0;i<10;i++) {
			numbers[index] = (char) (i + '0');
			printDigitsRecursively(numbers,index+1);
		}
	}

	/**
	 * 不打印非零数字前面的零
	 * @param numbers
	 */
	private void print(char[] numbers) {
		boolean flag = true;
		for(int i=0;i<numbers.length;i++) {
			if(flag && numbers[i] != '0')
				flag = false;
			if(!flag) {
				System.out.print(numbers[i]);
			}
		}
		System.out.print("  ");
	}
	
	/*********相关题目-两个整数的加法********/
	public String IntegerAdd(String num1, String num2) {
		
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int index = index1 > index2 ? index1 : index2;
		int increase = 0;//默认没有进位
		StringBuilder sb1 = new StringBuilder(num1);
		StringBuilder sb2 = new StringBuilder(num2);
		StringBuilder sb = new StringBuilder(num1.length() > num2.length()? num1:num2);
		char ch1,ch2,ch;
		while(index1 >= 0 && index2 >= 0) {
			ch1 = sb1.charAt(index1--);
			ch2 = sb2.charAt(index2--);
			if(ch1 + ch2 + increase -'0' > '9') {
				ch = (char)(ch1 + ch2 +increase - 10 - '0');
				increase = 1;
			}else {
				ch = (char)(ch1 + ch2 +increase - '0');
				increase = 0;
			}
			sb.setCharAt(index--, ch);
		}
		while(increase == 1 && index >= 0) {
			ch1 = sb.charAt(index);
			if(ch1 + increase > '9') {
				ch = (char)(ch1 + increase - 10);
				increase = 1;
			}else {
				ch = (char)(ch1 + increase);
				increase = 0;
			}
			sb.setCharAt(index--, ch);
		}
		if(increase == 1)
			sb.insert(0, '1');
		return sb.toString();
	}

	public String IntegerAdd_charr(String num1, String num2) {
		
		char[] nums1 = num1.toCharArray();
		char[] nums2 = num2.toCharArray();
		
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int index = index1 > index2 ? index1 : index2;
		char[] nums = index1 > index2 ? num1.toCharArray() : num2.toCharArray();
		int increase = 0;//默认没有进位
		char ch1,ch2,ch;
		while(index1 >= 0 && index2 >= 0) {
			ch1 = nums1[index1--];
			ch2 = nums2[index2--];
			if(ch1 + ch2 + increase -'0' > '9') {
				ch = (char)(ch1 + ch2 +increase - 10 - '0');
				increase = 1;
			}else {
				ch = (char)(ch1 + ch2 +increase - '0');
				increase = 0;
			}
			nums[index--] = ch;
		}
		while(increase == 1 && index >= 0) {
			ch1 = nums[index];
			if(ch1 + increase > '9') {
				ch = (char)(ch1 + increase - 10);
				increase = 1;
			}else {
				ch = (char)(ch1 + increase);
				increase = 0;
			}
			nums[index--] = ch;
		}
		String res = new String(nums);
		if(increase == 1)
			res = '1' + res;
		return res;
	}

	public static void main(String[] args) {
//		new Question12().print1toMaxofNdigits(3);
		Question12 test = new Question12();
//		test.print1toMaxofNdigits1(2);
		System.out.println(test.IntegerAdd_charr("123456", "65432"));
		System.out.println(test.IntegerAdd("123456", "65432"));
	}
}
