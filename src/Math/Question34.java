package Math;

public class Question34 {
	
	
	/**
	 * 求第n个丑数（丑数是因子只包含2，3，5的数字）
	 * 1是第一个丑数 
	 * 
	 */
	
	/**
	 * n是要求的第n个丑数
	 * 理解：丑数其实可以看作是2，3，5分别对[1,2,3,4,5,6,7,8,9,10,...]的乘积
	 * 然后对这三个数组合并去重，所以可以使用3个指针，分别合并这三个有序数组
	 * 注意去重，当都满足条件的时候应该都移动，这样能避免重复
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
