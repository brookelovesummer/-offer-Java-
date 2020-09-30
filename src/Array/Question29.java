package Array;

public class Question29 {
	
	/**
	 * ���ݿ��ŵ�˼�룬Partition�����ǽ������start-end����
	 * �������ѡ��������ڸ������ұߣ�С�ڸ����������ڸ��������
	 * ����С����size
	 * ��С����size��ͬʱҲ��ѡ��������������������������
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public int Partition(int[] arr, int start, int end) {
		if(arr == null || arr.length <= 0 || start < 0 || end >= arr.length) {
			System.out.println("invalid input!");
			System.exit(1);
		}
		
		int index =(int) Math.random()*(end - start) + start;
		int small = start - 1;
		swap(arr,index,end);
		for(int i=start;i<end;i++) {
			if(arr[i] < arr[end]) {
				small++;
				if(small != i)
					swap(arr,i,small);
			}
		}
		small++;
		swap(arr,small,end);
		return small;
	}
	
	public int[] QuickSort(int[] arr) {
		if(arr == null || arr.length <= 0)
			return null;
		QuickSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public void QuickSort(int[] arr, int start, int end) {
		if(start == end)
			return;
		int index = Partition(arr, start, end);
		if(index > start)
			QuickSort(arr, start, index-1);
		if(index < end)
			QuickSort(arr, index+1, end);
	}
	
	
	private void swap(int[] arr, int index, int end) {
		int temp = arr[index];
		arr[index] = arr[end];
		arr[end] = temp;
	}
	
//	private static void printarr(int[] arr) {
//		for(int i:arr)
//			System.out.print(i+" ");
//		System.out.println();
//	}
	
	/***********************������������29���������--������Ԫ�س���һ�������*************************************/
	
	/**
	 * ����1��ʹ��Partition���������ַ�����ı�����Ԫ��
	 * 
	 * ����һ������֣�������󣬸�Ԫ�ؿ϶���������м�λ��
	 * ����ʹ��Partition��������ȡ������������ֻҪ�õ�����Ϊn/2����ӦԪ�ؼ�Ϊ����
	 * @param arr
	 * @return
	 */
	public int getMorethanHalf(int[] arr) {
		if(arr == null || arr.length <= 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		
		int midium = arr.length >> 1;
		int start = 0;
		int end = arr.length - 1;
		int index = Partition(arr, start, end);//indexָ��������������
		while(index != midium) {
			if(index > midium)
				index = Partition(arr, start, index-1);
			else
				index = Partition(arr, index+1, end);
		}
		int result = arr[index];
		//ע��result�������Ҫ��֤�����������Ҳû����n/2
		int count = 0;
		for(int i:arr) {
			if(i == result)
				count++;
		}
		if(count <= midium) {
			System.out.println("There is no number meet condition in arr!");
			System.exit(2);
		}
		return  result;
	}
	
	
	/**
	 * ����2�����ı�Ԫ�ص����˳���ǰ���£��ҵ���Ԫ��
	 * 
	 * ˼·����Ϊ��Ԫ�س��ִ�������n/2��˵����Ԫ�صĴ�����ʣ��Ԫ�س���֮�ͻ�Ҫ��
	 * һ��������¼Ԫ�أ�һ������������¼Ԫ�س��ֵĴ���
	 * �����Ǳ�������һ������ʱ���������ֺ����ǵ�ǰ��¼��������ͬ�������������1��
	 * �������ֺ����ǵ�ǰ��¼�����ֲ�ͬ�������������1��
	 * ����������Ϊ0��������Ҫ���¼�¼��Ԫ�أ����Ѽ���������1��
	 * �����������Ǳ����꣬��¼��������ľ��������д��ڴ�������n/2��Ԫ��
	 * @param arr
	 * @return
	 */
	public int getMorethanHalf_2(int[] arr) {
		if(arr == null || arr.length <= 0) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		
		int result = 0;
		int times = 0;
		for(int i=0;i<arr.length;i++) {
			if(times == 0) {
				result = arr[i];
				times++;
			}else if(arr[i] == result)
				times++;
			else
				times--;
		}
		
		//����Ϊ��������Ƿ����Ҫ��
		int count = 0;
		for(int i:arr) {
			if(i == result)
				count++;
		}
		if(count <= arr.length >> 1) {
			System.out.println("There is no number meet condition in arr!");
			System.exit(2);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Question29 test = new Question29();
		int[] arr = {1,2,3,2,2,2,5,4,2};
		System.out.println(test.getMorethanHalf(arr));
		System.out.println(test.getMorethanHalf_2(arr));
	}
}
