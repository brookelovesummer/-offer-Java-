package Math;

public class Question34 {
	
	
	/**
	 * ���n������������������ֻ����2��3��5�����֣�
	 * 1�ǵ�һ������ 
	 * 
	 */
	
	/**
	 * n��Ҫ��ĵ�n������
	 * ��⣺������ʵ���Կ�����2��3��5�ֱ��[1,2,3,4,5,6,7,8,9,10,...]�ĳ˻�
	 * Ȼ�������������ϲ�ȥ�أ����Կ���ʹ��3��ָ�룬�ֱ�ϲ���������������
	 * ע��ȥ�أ���������������ʱ��Ӧ�ö��ƶ��������ܱ����ظ�
	 * @param n
	 * @return
	 */
	public int getUglyNum(int n) {
		
		if(n <= 0) {
			System.out.println("invalid input!");
			System.exit(1);
		}
		
		int[] arr = new int[n];
		arr[0] = 1;
		int a = 0, b = 0,c = 0;
		int aa = 0,bb = 0, cc = 0;
		for(int i=1;i<n;i++) {
			aa = arr[a] * 2;
			bb = arr[b] * 3;
			cc = arr[c] * 5;
			
			if(aa <= bb && aa <= cc) {
				arr[i] = aa;
				a++;
			}
			if(bb <= aa && bb <= cc) {
				arr[i] = bb;
				b++;
			}
			if(cc <= bb && cc <= aa) {
				arr[i] = cc;
				c++;
			}
		}
		return arr[n-1];			
	}
}
