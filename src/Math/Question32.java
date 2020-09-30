package Math;

public class Question32 {
	
	/**
	 * 1-n�У�1���ֵĴ���
	 * �ֱ�ͳ��ÿһλ��1���ֵĸ���
	 * a.��ĳһλ�ϵ����ִ���1��˵����һλ��1�ĸ���������һλ�ĸ�λ���ֿ��ܵ����[0-��λ����]
	 * b.��ĳһλ�ϵ����ֵ���1��˵����һλ��1�� ����������һλ�ĸ�λ���ֿ��ܵ����[0-��λ����-1]+[0-��λ����]
	 * c.��ĳһλ�ϵ�����С��1��˵����һλ��1�ĸ���������һλ�ĸ�λ���ֿ��ܵ����[0-��λ����-1]
	 * @return
	 */
	public int getNumofOne(int n) {
		if(n <= 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		int res = 0;
		int base = 1;
		int a = 0;//ÿ��ȡ�ø�λ�ϵ���
		int b = 0;//�����Ѿ�����ò��֣���Ϊ��δ�������С�ڵ���1�û���Ҫ�õ�
		
		while(n != 0) {
			a = n % 10;
			n /= 10;
			if(a > 1) {//a.��ǰֵ����1,˵����һλ��1���ֵĴ�������[0-��λ����]
				res += (n+1) * base;
			}else if(a == 1) {//b.��ǰֵ����1��˵����һλ��1���ֵĴ�������[0-��λ����-1]+[0-��λ����]
				res += n * base + b+1; 
			}else{//c.��ǰֵС��1��˵����һλ��1���ֵĴ�������[0-��λ����-1]
				res += n * base;
			}
			
			b += a*base;
			base *= 10;
		}
		return res;
	}

	/**
	 * 1-n�У�k���ֵĴ��� 1<=k<=9
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
		int a = 0;//ÿ��ȡ�ø�λ�ϵ���
		int b = 0;//�����Ѿ�����ò��֣���Ϊ��δ�������С�ڵ���k�û���Ҫ�õ�
		
		while(n != 0) {
			a = n % 10;
			n /= 10;
			if(a > k) {//a.��ǰֵ����k,˵����һλ��1���ֵĴ�������[0-��λ����]
				res += (n+1) * base;
			}else if(a == k) {//b.��ǰֵ����k��˵����һλ��1���ֵĴ�������[0-��λ����-1]+[0-��λ����]
				res += n * base + b+1; 
			}else{//c.��ǰֵС��k��˵����һλ��1���ֵĴ�������[0-��λ����-1]
				res += n * base;
			}
			
			b += a*base;
			base *= 10;
		}
		return res;
	}
	
	/********ѭ���������Դ���***/
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
