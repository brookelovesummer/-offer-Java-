package Array;

public class Question38 {
	
	/**
	 * 数字在排序数组中出现的次数
	 */
	
	/**
	 * 二分查找方法实现
	 * 注意二分查找只能查找一个元素，所以需要两次，找到始末点位置
	 * @param arr
	 * @param k
	 * @return
	 */
	public int getNumofKinArr(int[] arr, int k) {
		
        if(arr.length == 0)
            return 0;
        if(arr.length == 1){
            return arr[0] == k ? 1 : 0;
        }
		
		int start = 0;
		int end = arr.length;
		int mid = (start + end) >> 1;
		
		int res_start = 0;
		int res_end = -1;

		while(start < end - 1) {
			if(arr[mid] > k || (mid > 0 && arr[mid-1] == k)) {
				end = mid;
				mid = (start + end)>>1;
			}else if(arr[mid] < k) {
				start = mid;
				mid = (start + end)>>1;
			}else{
				res_start = mid;
				break;
			}
		}

		start = 0;
		end = arr.length;
		while(start < end - 1) {
			if(arr[mid] > k) {
				end = mid;
				mid = (start + end)>>1;
			}else if(arr[mid] < k || (mid < arr.length-1 && arr[mid+1] == k)) {
				start = mid;
				mid = (start + end)>>1;
			}else{
				res_end = mid;
				break;
			}
		}		
		return res_end - res_start + 1;
	}
	
	public static void main(String[] args) {
		Question38 test = new Question38();
		int[] arr = {3,3,3,3,3,3,3};
		for(int i=0;i<=6;i++)
			System.out.println(test.getNumofKinArr(arr, i));
	}

}
