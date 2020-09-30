package String;

public class ExternalQuestion1 {
	
	/**
	 * 判断给定的8个元素的数组，能不能放置在一个正方体的8个顶点上，使得三组相对的 面的4个顶点和相等
	 * 
	 * 解题：考虑这8个数的全排列，若有一个排列能满足
	 * a1+a2+a3+a4 == a5+a6+a7+a8 && 
	 * a1+a3+a5+a7 == a2+a4+a6+a8 && 
	 * a1+a2+a5+a6 == a3+a4+a7+s8
	 * @param peeks
	 * @return
	 */
	
	private boolean flag = false;
	
	public boolean SumofPeekEqual(int[] peeks) {
		if(peeks.length != 8) {
			System.out.println("数组元素数目小于8");
			System.exit(1);
		}
		permutationofPeeks(peeks, 0);
		return flag;
	}
	
	private void permutationofPeeks(int[] peeks, int begin) {
		
    	if(begin == peeks.length-1) {
			if(PeekEqual(peeks)) {
				flag = true;
				printarr(peeks);//打印满足条件的数组排列
			}
    		return;
    	}
    	
		for(int i=begin;i<peeks.length;i++) {
			swap(peeks,i,begin);
			permutationofPeeks(peeks, begin+1);
			swap(peeks,i,begin);
		}
	}
	
    private void swap(int[] strs, int i, int j) {
    	int temp = strs[i];
    	strs[i] = strs[j];
    	strs[j] = temp;
    }

	private boolean PeekEqual(int[] arr) {
		return arr[0]+arr[1]+arr[2]+arr[3] == arr[4]+arr[5]+arr[6]+arr[7]
		&& arr[0]+arr[2]+arr[4]+arr[6] == arr[1]+arr[3]+arr[5]+arr[7]
		&& arr[0]+arr[1]+arr[4]+arr[5] == arr[2]+arr[3]+arr[6]+arr[7];
	}
	
	private void printarr(int[] arr) {
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] peeks = {1,1,1,1,1,1,1,1};
		System.out.println(new ExternalQuestion1().SumofPeekEqual(peeks));
	}
}
