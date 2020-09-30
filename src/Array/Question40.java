package Array;

public class Question40 {
	
	/**
	 * 数组中只出现一次的数字
	 * 现有一个数组满足条件有两个数出现一次，其他数出现2次，求着两个出现一次的数，时间复杂度o(n)，空间复杂度o(1)
	 * 
	 * 考点：
	 * 相同的数字之间，偶数次异或一定为0，0与任何数异或还是那个数本身
	 * 异或满足交换律   a^b^c = a^c^b
	 */
	
	/**
	 * 根据相同的数字之间，按位异或结果为0，可以用0开始依次异或每个数组元素，
	 * 最终得到的结果就是只出现一次的元素，
	 * 不过这个方法有个条件（只有一个元素出现奇数次，剩余都出现偶数次），否则失效！
	 * @param arr
	 * @return
	 */
	public int getNumOnce(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		return getNumOnce(arr,0,arr.length-1);
	}
	
	private int getNumOnce(int[] arr, int start, int end) {
		int a = 0;
		for(int i=start;i<=end;i++) {
			a ^= arr[i];
		}
		return a;
	}
	/**
	 * 假如说数组里面有两个数出现一次，其他数出现偶数次该怎么办呢，不能直接利用上述方法
	 * 我们需要将两个出现一次的数分别放到两个数组里面，这样就能分别用上述方法求解。
	 * 
	 * 我们知道，上述方法失效的原因在于，若有两个出现一次的数，则这个时候依次异或数组元素
	 * 得到的结果等价于这两个出现一次元素的异或结果，
	 * 分析这个结果，不难发现，这个结果非零，根据异或的性质，（二进制下）哪一位是1，说明了
	 * 两个出现依次的数对应位不同，根据这个特点可以将两个出现一次的数分开。
	 * 比如{2，2，4，5，5，6}，4(0100),6(1100),最后的结果肯定是1000，所有查找直接结果的
	 * 非0位，区分两个数，分别放在两个数组中求解。
	 * 
	 * @return
	 */
	public int[] getTwoNumOnce(int[] arr) {
		if(arr == null || arr.length <= 1) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		int[] result = new int[2];
		int temp = getNumOnce(arr,0,arr.length-1);//需要将temp替换成只有一位为1的情况
		int a = 0;
		while((temp & 1) == 0) {
			temp >>= 1;
			a++;
		}
		temp = 1 << a;
		int lsize = Partition(arr, temp);
		result[0] = getNumOnce(arr, 0, lsize);
		result[1] = getNumOnce(arr, lsize+1, arr.length-1);
//		for(int i=0;i<arr.length;i++) {
//			if((arr[i] & temp) == 0)
//				result[0] ^= arr[i];
//			else
//				result[1] ^= arr[i];
//		}
		
		return result;
	}
	

	/**
	 * 将满足条件的放在数组前半部分，不满足的放在数组后半部分
	 * （这里考虑的条件是与temp按位与是否非0）
	 * @param arr
	 * @param temp
	 * @return
	 */
	public int Partition(int[] arr, int temp) {
		int lsize = -1;
		for(int i=0;i<arr.length;i++) {
			if((arr[i] & temp) == 0) {
				lsize++;
				if(lsize != i)
					swap(arr,i,lsize);
			}
		}
		return lsize;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/******************以下是力扣的大神的解法***************************/
    public int[] singleNumbers(int[] arr) {
		int[] result = new int[2];
		int temp = 0;
        for(int i:arr){
            temp ^= i;
        }
        temp &= -temp;//这招确实厉害，位运算出神入化，直接这样找到最右边的1
        for(int i : arr){
            if((i & temp) == 0)
                result[1] ^= i;
            else
                result[0] ^= i;
        }
        return result;
    }
	
	public static void main(String[] args) {
//		int[] arr = {4,3,4,6};
//		int[] res = new Question40().getTwoNumOnce(arr);
//		System.out.println("["+res[0]+","+res[1]+"]");
		
		System.out.println(~-2 == 4);
	}
}
