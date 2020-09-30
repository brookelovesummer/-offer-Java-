package Math;

public class Question32 {
	
	/**
	 * 1-n中，1出现的次数
	 * 分别统计每一位上1出现的个数
	 * a.当某一位上的数字大于1，说明这一位上1的个数就是这一位的高位部分可能的情况[0-高位部分]
	 * b.当某一位上的数字等于1，说明这一位上1的 个数就是这一位的高位部分可能的情况[0-高位部分-1]+[0-低位部分]
	 * c.当某一位上的数字小于1，说明这一位上1的个数就是这一位的高位部分可能的情况[0-高位部分-1]
	 * @return
	 */
	public int getNumofOne(int n) {
		if(n <= 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		int res = 0;
		int base = 1;
		int a = 0;//每次取得个位上得数
		int b = 0;//保存已经运算得部分，因为若未运算出现小于等于1得话需要用到
		
		while(n != 0) {
			a = n % 10;
			n /= 10;
			if(a > 1) {//a.当前值大于1,说明这一位上1出现的次数就是[0-高位部分]
				res += (n+1) * base;
			}else if(a == 1) {//b.当前值等于1，说明这一位上1出现的次数就是[0-高位部分-1]+[0-低位部分]
				res += n * base + b+1; 
			}else{//c.当前值小于1，说明这一位上1出现的次数就是[0-高位部分-1]
				res += n * base;
			}
			
			b += a*base;
			base *= 10;
		}
		return res;
	}

	/**
	 * 1-n中，k出现的次数 1<=k<=9
	 * @param n
	 * @param k
	 * @return
	 */
	public int getNumofK(int n, int k) {
		if(n <= 0 || k > n || k > 9 || k < 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		
		int res = 0;
		int base = 1;
		int a = 0;//每次取得个位上得数
		int b = 0;//保存已经运算得部分，因为若未运算出现小于等于k得话需要用到
		
		while(n != 0) {
			a = n % 10;
			n /= 10;
			if(a > k) {//a.当前值大于k,说明这一位上1出现的次数就是[0-高位部分]
				res += (n+1) * base;
			}else if(a == k) {//b.当前值等于k，说明这一位上1出现的次数就是[0-高位部分-1]+[0-低位部分]
				res += n * base + b+1; 
			}else{//c.当前值小于k，说明这一位上1出现的次数就是[0-高位部分-1]
				res += n * base;
			}
			
			b += a*base;
			base *= 10;
		}
		return res;
	}
	
	/********循环方法测试代码***/
	public int getNumofK_test(int n, int k) {
		if(n <= 0 || k > n || k > 9 || k < 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		int res = 0;
		for(int i=1;i<=n;i++) {
			int a = i;
			while(a != 0) {
				if(a % 10 == k)
					res++;
				a /= 10;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Question32 test = new Question32();
		for(int i=0;i<1000;i++) {
			int n = (int)(Math.random() * 100000) + 10;
			for(int k=1;k<10;k++) {
				int a = test.getNumofK(n, k);
				int b = test.getNumofK_test(n, k);
				if(a != b) {
					System.out.println("error!n = "+n+", a="+a+" ,b= "+b);
					return ;
				}
			}
		}
		System.out.println("Nice!");
	}
}
