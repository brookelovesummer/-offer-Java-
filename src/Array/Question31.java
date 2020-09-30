package Array;

public class Question31 {
	
	/**
	 * 连续子数组最大的和
	 * 
	 * 总结：子数组的和都可以转化为前缀和的差来做
	 */
	
	/**
	 * 以数组[1，-2，3，10，-4，7，2，-5]为例
	 * 不难发现， 初始化一个计数变量sum，
	 * 加上第一个元素1，sum=1,加上第二个元素-2，sum=-1<0，这时候我们不难发现
	 * 以第三个元素开始得子数组肯定比包含前两个元素的子数组和要大，因为sum+3=2 < 3
	 * 所以这个时候需要从第三个元素开始算子数组和，
	 * 以此类推（当发现当前元素加入到之前的子数组的和还比自己小 的时候，应该从当前元素开始重新计算）
	 * @param arr
	 * @return
	 */
	public int getMaxofSubArr(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Invaild input!");
			System.exit(1);
		}
		
		int maxsum = arr[0];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			if(sum <= 0)
				sum = arr[i];
			else
				sum += arr[i];
			
			if(sum > maxsum)
				maxsum = sum;
		}
		return maxsum;
	}

	/**
	 * 转换为前缀和数组两两之差
	 * @param arr
	 * @return
	 */
	public int getMaxofSubArr_hzh(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Invaild input!");
			System.exit(1);
		}
		if(arr.length == 1)
			return arr[0];
		int sum = 0;
		int maxsum = 0;
		int minsum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			if(maxsum < sum)
				maxsum = sum;
			if(minsum > sum)
				minsum = sum;
		}
		return maxsum - minsum;
	}
	
	public int getMaxofSubArrdp(int[] arr){
		if(arr == null || arr.length == 0) {
			System.out.println("Invaild input!");
			System.exit(1);
		}
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int max = dp[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = dp[i-1] > 0 ? dp[i-1]+arr[i] : arr[i];
			if(dp[i] > max)
				max = dp[i];
		}
		return max;
	}
	
	/*************************以下是求数组中最大子数组绝对值的和********************************/
	/**
	 * 子数组绝对值的和最大值
	 * 
	 * 方法：将子数组绝对值的和最值转化为其前缀和数组两两之差的最值
	 * b[0] = 0
	 * b[1] = b[0] + arr[0]
	 * b[i+1] = b[i] + arr[i];
	 * arr[i]+arr[i+1]+...+arr[i+k] = b[i+k+1] - b[i]
	 * 从i-k的子数组的和的绝对值等于前缀和数组的对应两项之差
	 * @param arr
	 * @return
	 */
	public int getAbsofSubArr(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Invaild input!");
			System.exit(1);
		}
		
		int sum = 0;
		int maxsum = sum;
		int minsum = sum;
		int res = 0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			if(maxsum < sum)
				maxsum = sum;
			if(minsum > sum)
				minsum = sum;
			if(abs(maxsum) > res)
				res = abs(maxsum);
		}
		res = maxsum * minsum < 0 ? abs(maxsum - minsum) : res;
		return res;
		
	}
		
	private int abs(int num) {
		return num < 0 ? -num : num;
	}
	
	
	/*************************求环形数组连续子数组和的最大值***********************************/
	/**
	 * 变种二：求环形数组连续子数组和的最大值
	 * 环形数组相比于非环形数组，它多了一些可能的情况，
	 * 即非环形数组中前面一小部分和后面一小部分组成的连续子数组，而我们用原来的方法，是无法计算这种情况的。
	 * 对于环形数组a[n]，我们用sum(i, j)表示从下标i到j - 1的连续子数组和，
	 * 则对于连续子数组和的最大值为sum(0, i) + sum(j, n)的情况（其中i < j），
	 * 由于数组a的总和是固定值，我们可以将问题进行转换，用原来的方法来求该连续子数组和的最小值sum(i, j)，
	 * 然后拿总和减去这个最小值，就能得到这种情况的最大值。这样我们分别用原来的方法，
	 * 分别计算一次连续子数组和的最大值max和最小值min，以及数组所有元素之和total，
	 * 这样环形数组连续子数组和的最大值就为max和total - min中的较大者。这种方法的时间复杂度依然为O(n)。
	 */
	
	
	
	
	/**************以下是构造循环的方法来测试代码*************************/
	/**
	 * 子数组和的最大值
	 * @param arr
	 * @return
	 */
	public int getMaxofnum(int[] arr) {
		int res = arr[0];
		int sum = 0;
		for(int m = 1;m<=arr.length;m++) {
			sum = getMaxofnum(arr,m);
			if(sum > res)
				res = sum;
		}
		return res;
	}
	
	/**
	 * 给定长度的子数组和的最大值
	 * @param arr
	 * @param m
	 * @return
	 */
	private int getMaxofnum(int[] arr, int m) {
		int sum = 0;
		for(int i=0;i<m;i++)
			sum += arr[i];
		int res = sum;
		for(int i=1;i<=arr.length-m;i++) {
			sum = sum - arr[i-1] + arr[i+m-1];
			if(sum > res)
				res = sum;
		}
		return res;
	}
	
	/**
	 * 子数组和绝对值的最大值
	 * @param arr
	 * @return
	 */
	public int getMaxofabsnum(int[] arr) {
		int res = arr[0];
		int sum = 0;
		for(int m = 1;m<=arr.length;m++) {
			sum = getMaxofabsnum(arr,m);
			if(sum > res) {
				res = sum;
			}
		}
		return res;
	}
	
	/**
	 * 给定长度的子数组和绝对值的最大值
	 * @param arr
	 * @param m
	 * @return
	 */
	private int getMaxofabsnum(int[] arr, int m) {
		int sum = 0;
		for(int i=0;i<m;i++)
			sum += arr[i];
		int res = abs(sum);
		for(int i=1;i<=arr.length-m;i++) {
			sum = sum - arr[i-1] + arr[i+m-1];
			if(abs(sum) > res)
				res = abs(sum);
		}
		return res;
	}

	/**
	 * 产生长度和值均随机的数组,且都在size范围内
	 * @param size
	 * @return
	 */
	public int[] randomarr(int size) {
		size = (int)((size+1)*(Math.random())+1);
		int[] a = new int[size];
		int i;
		for (i=0; i<size; i++) {
			a[i] = (int)((size+1)*(Math.random()));		
		}
		return a; 
	}
	
	public static void main(String[] args) {
		Question31 test = new Question31();

		for(int i=0;i<100000;i++) {
			int[] arr = test.randomarr(100);
			int a = test.getMaxofabsnum(arr);//笨但正确的方法
			int b = test.getAbsofSubArr(arr);//待校验的方法
			if(a != b) {
				System.out.println("error!" + "i = " + i);
				for(int o : arr)
					System.out.print(o+" ");
				System.out.println();
				System.out.println("a = "+ a + " , b = " +b );
				System.exit(1);
			}
		}
		System.out.println("Nice!");
//		int[] arr = {-1,1,-3,5};
//		System.out.println(test.getAbsofSubArr(arr));
	}
}
