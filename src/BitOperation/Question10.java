package BitOperation;

public class Question10 {
	
	/**
	 * 二进制中1的个数--二进制中有意义的0该怎么求呢？
	 */
	
	/**
	 * 我们知道一个数与1按位与之后是1，表示这个数的最后一位是偶数，所以可以采用1检验最后一位
	 * 然后将整数右移一位，这样就能持续检验一个数1的个数
	 * @param n
	 * @return
	 */
	public int getNumofOne(int n) {
		
		int count = 0;
		while(n != 0) {
			if((n & 1) == 1)
				count++;
			n >>= 1;
		}
		return count;
	}
	
	
	/**
	 * 由于上面的方法需要右移，对于正数，右移补零，不会对结果产生影响，但是负数右移会补1，此时上述
	 * 方法将陷入死循环
	 * 
	 * 改进：可采用1左移的方式，分别对给定整数的每一位,注意左移最多移32位（int类型的位数），超过为0
	 */
	public int getNumofOne2(int n) {
		
		int count = 0;
		int flag = 1;
		while(flag != 0) {
			if((flag & n) != 0)
				count++;
			flag <<= 1;
		}
		return count;
	}
	
	/**
	 * 上述方法对于每个数都需要循环32次，我们能不能把循环次数降到整数中有几个1就循环几次呢
	 * 
	 * 首先说明：一个数最后一位不是1就是0。
	 * 
	 * 我们先说最后一位是1：若最后一位是1，则该数减1，只是最后一位由1变为0，前面都没变，
	 * 那么这个数与减1之后的数按位与，得到的结果就是将这个数的最右边的一个1变为0
	 * 
	 * 再说最后一位是0的时候，那么我们找这个数最右边的一个1，那么这个数减1的时候，就是将含这个1所在的
	 * 位以及后边的0全部反转，比如10100，减1变成10011，这两个数按位与，结果是10000，
	 * 就是将10100最右边的一个1变成0
	 * 
	 * 综上，一个数与它减1按位与，结果就是将最右边的一个1变为0，通过这个理论我们可以写代码
	 * @param args
	 */
	
	public int getNumofOne3(int n) {
		int count = 0;
		int m = n-1;
		while(n != 0) {
			count++;
			n = m & n;
			m = n - 1;
		}
		return count;
	}
	
	/**
	 * 2的幂有一个特点，就是这个数与它减1按位与是0，这个可以用于判断一个数是不是2的幂
	 * @param args
	 */
	public boolean is2power(int n) {
		if((n & (n-1)) == 0)
			return true;
		return false;
	}
	
	/**
	 * 计算需要改变m的二进制中的多少位才能得到n
	 * 
	 * 思路：要找到m和n的二进制哪些位不同，可以按位异或（相同为零，相异为一），然后统计异或后1的个数
	 * @param m
	 * @param n
	 * @return
	 */
	public int m2n(int m, int n) {
		return getNumofOne3(m^n);
	}

	/**
	 * 统计2进制中0的个数，指的是有意义的0的个数
	 * 
	 * 最后一位为0，加1就是
	 * @param args
	 */

	public static void main(String[] args) {
		Question10 test = new Question10();
		System.out.println(test.getNumofOne(0));
		System.out.println(test.getNumofOne3(0));
		System.out.println(test.getNumofOne2(0));
	}
}
