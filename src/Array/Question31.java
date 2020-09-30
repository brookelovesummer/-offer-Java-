package Array;

public class Question31 {
	
	/**
	 * �������������ĺ�
	 * 
	 * �ܽ᣺������ĺͶ�����ת��Ϊǰ׺�͵Ĳ�����
	 */
	
	/**
	 * ������[1��-2��3��10��-4��7��2��-5]Ϊ��
	 * ���ѷ��֣� ��ʼ��һ����������sum��
	 * ���ϵ�һ��Ԫ��1��sum=1,���ϵڶ���Ԫ��-2��sum=-1<0����ʱ�����ǲ��ѷ���
	 * �Ե�����Ԫ�ؿ�ʼ��������϶��Ȱ���ǰ����Ԫ�ص��������Ҫ����Ϊsum+3=2 < 3
	 * �������ʱ����Ҫ�ӵ�����Ԫ�ؿ�ʼ��������ͣ�
	 * �Դ����ƣ������ֵ�ǰԪ�ؼ��뵽֮ǰ��������ĺͻ����Լ�С ��ʱ��Ӧ�ôӵ�ǰԪ�ؿ�ʼ���¼��㣩
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
	 * ת��Ϊǰ׺����������֮��
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
	
	/*************************��������������������������ֵ�ĺ�********************************/
	/**
	 * ���������ֵ�ĺ����ֵ
	 * 
	 * �����������������ֵ�ĺ���ֵת��Ϊ��ǰ׺����������֮�����ֵ
	 * b[0] = 0
	 * b[1] = b[0] + arr[0]
	 * b[i+1] = b[i] + arr[i];
	 * arr[i]+arr[i+1]+...+arr[i+k] = b[i+k+1] - b[i]
	 * ��i-k��������ĺ͵ľ���ֵ����ǰ׺������Ķ�Ӧ����֮��
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
	
	
	/*************************������������������͵����ֵ***********************************/
	/**
	 * ���ֶ���������������������͵����ֵ
	 * ������������ڷǻ������飬������һЩ���ܵ������
	 * ���ǻ���������ǰ��һС���ֺͺ���һС������ɵ����������飬��������ԭ���ķ��������޷�������������ġ�
	 * ���ڻ�������a[n]��������sum(i, j)��ʾ���±�i��j - 1������������ͣ�
	 * ���������������͵����ֵΪsum(0, i) + sum(j, n)�����������i < j����
	 * ��������a���ܺ��ǹ̶�ֵ�����ǿ��Խ��������ת������ԭ���ķ������������������͵���Сֵsum(i, j)��
	 * Ȼ�����ܺͼ�ȥ�����Сֵ�����ܵõ�������������ֵ���������Ƿֱ���ԭ���ķ�����
	 * �ֱ����һ������������͵����ֵmax����Сֵmin���Լ���������Ԫ��֮��total��
	 * ����������������������͵����ֵ��Ϊmax��total - min�еĽϴ��ߡ����ַ�����ʱ�临�Ӷ���ȻΪO(n)��
	 */
	
	
	
	
	/**************�����ǹ���ѭ���ķ��������Դ���*************************/
	/**
	 * ������͵����ֵ
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
	 * �������ȵ�������͵����ֵ
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
	 * ������;���ֵ�����ֵ
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
	 * �������ȵ�������;���ֵ�����ֵ
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
	 * �������Ⱥ�ֵ�����������,�Ҷ���size��Χ��
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
			int a = test.getMaxofabsnum(arr);//������ȷ�ķ���
			int b = test.getAbsofSubArr(arr);//��У��ķ���
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
