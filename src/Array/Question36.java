package Array;

public class Question36 {
	
	/**
	 * 统计数组中的逆序对数目
	 */
	
	/**
	 * 归并排序
	 * @param arr
	 * @return
	 */
	public void mergeSort(int[] arr, int start, int end) {
		if(start == end) {
			return ;
		}
		int mid = (start + end) >> 1;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid + 1,end);
		mergearr(arr,start,mid,end);
	}

	private void mergearr(int[] arr, int start, int mid, int end) {
		int[] help = new int[end - start + 1];
		int p = start;
		int q = mid + 1;
		int index = 0;
		while(p <= mid && q <= end) {
			help[index++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
		}
		while(p <= mid) {
			help[index++] = arr[p++];
		}
		while(q <= end) {
			help[index++] = arr[q++];
		}
		for(int i=0;i<help.length;i++) {
			arr[start+i] = help[i];
		}		
	}
	
	/***********以下是基于归并排序的思想求解数组的逆序对数目问题****************/
	public int getInversePairs(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
//		int[] copy = arr.clone();
		return InversePairs(arr,0,arr.length-1);
	}
	
	private int InversePairs(int[] arr, int start, int end) {
		if(start == end) 
			return 0;
		
		int mid = (start + end) >> 1;
		int left = InversePairs(arr, start, mid);
		int right = InversePairs(arr, mid+1, end);
		
		int count = 0;
		int[] help = new int[end - start + 1];
		int index = end - start;
		int p = mid;
		int q = end;
		
		while(p >= start && q >= mid + 1) {//5,7,4,6
			if(arr[p] > arr[q]) {
				printInversepairs(arr,p,q,mid+1);
				count += q - mid;//注意这里是右边所有小于arr[p]的数，所以应该要用q - mid
				help[index--] = arr[p--];
			}else
				help[index--] = arr[q--];
		}
		while(p >= start)
			help[index--] = arr[p--];
		while(q >= mid+1)
			help[index--] = arr[q--];
		
		for(int i=0;i<help.length;i++)
			arr[start + i] = help[i];

		return  left + right  + count;
	}

	/**
	 * 打印所有逆序对
	 * @param arr
	 * @param p
	 * @param q
	 * @param end
	 */
	private void printInversepairs(int[] arr, int p, int q, int end) {
		while(q >= end) {
			System.out.println("(" + arr[p] + "," + arr[q--] + ")");
		}
	}

	public static void main(String[] args) {
		Question36 test = new Question36();
		int[] arr = {7,5,6,4};
		int num = test.getInversePairs(arr);
		for(int i:arr)
			System.out.print(i+ " ");
		System.out.println("\nnum = " + num);
	}
}