package SortOrder;

public class Question8 {
	
	/**
	 * 若将0个元素移到末尾，这种情况下arr是递增排序的，
	 * 只要移动了非零个元素，arr的第一个元素都将大于等于最后一个元素
	 */
	
	/**
	 * 返回旋转数组的最小值，旋转指的是将递增排序数组的前面若干元素移到数组末尾
	 * @param arr
	 * @return
	 * @throws Exception 
	 */
	public int getMin(int[] arr) throws Exception {
		if(arr == null || arr.length == 0)
			throw new Exception("Invaild input!");
		int lindex = 0;
		int rindex = arr.length - 1;
		int midindex = (lindex + rindex)/2; 
		if(arr[lindex] < arr[rindex])
			return arr[lindex];
		while(lindex != rindex - 1) {
			//若三个元素都相等，此时指针无法移动，此法失效，需要遍历
			if(arr[midindex] == arr[lindex] && arr[midindex] == arr[rindex])
				return Mininorder(arr);
			
			if(arr[midindex] >= arr[lindex])
				lindex = midindex;
			else if(arr[midindex] <= arr[rindex])
				rindex = midindex;
			midindex = (lindex + rindex)/2; 
		}
		
		return arr[rindex];
	}
	
	private int Mininorder(int[] arr) {
		int min = arr[0];
		for(int i : arr) {
			if(min > i)
				min = i;
		}
		return min;
	}

	public static void main(String[] args) throws Exception {
		Question8 test = new Question8();
		int[] arr = {1,0,1,1,1};
		System.out.println(test.getMin(arr));
//		System.out.println("2 & 7 = " + (2 & 7));
	}

}
