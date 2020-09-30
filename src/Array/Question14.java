package Array;

public class Question14 {
	
	/**
	 * ��arr�������Ƶ�ż��֮ǰ
	 * 
	 * ����ָ�븺����ǰ�沿����û��ż����ż��ָ�븺����������û������
	 * �����ָ���ٻ�û����֮ǰ�ͷֱ�ָ����������ż�����򽻻�
	 * 
	 * ������ֱ�ӱ����ҵ�һ��ż�����Ƶ������Ҫ�ã�ֱ�ӱ����ƶ�O(n2)
	 * @param arr
	 * @return
	 */
	public int[] reOrderArr(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return null;
		
		int begin = 0;
		int end = arr.length - 1;
		while(begin < end) {
			
			while(begin < end && (arr[begin]&1) == 1)
				begin++;
			while(begin < end && (arr[end]&1) == 0)
				end--;
			
			if(begin < end) {
				int t = arr[begin];
				arr[begin] = arr[end];
				arr[end] = t;
			}
		}
		return arr;
	}
	
	/**
	 * ѧϰ��������������У���������  ��  ��ż������������Ϳ��Խ���ż����������������
	 * �������ǿ��Է�����������������ʹ�ú����������������½������� 
	 * @param args
	 */
	public int[] changeArr(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return null;
		
		int begin = 0;
		int end = arr.length - 1;
		while(begin < end) {
			
			while(begin < end && !isEven(arr[begin]))
				begin++;
			while(begin < end && isEven(arr[end]))
				end--;
			
			if(begin < end) {
				int t = arr[begin];
				arr[begin] = arr[end];
				arr[end] = t;
			}
		}
		return arr;
	}
	
	boolean isEven(int num) {
		return (num & 1) == 0;
	}
	
	/**
	 * ����3�ı������Ƶ�ǰ�棬��������棬��ʱ���滻��������Ϊ����ĺ���
	 * @param args
	 */
	public boolean devideby3(int num) {
		return num % 3 == 0;
	}
	
	/**
	 * �����Ƶ�����ǰ�棬�Ǹ����Ƶ�����
	 * @param args
	 */
	public boolean isnegative(int num) {
		return num < 0;
	}
	public static void main(String[] args) {
		Question14 test = new Question14();
//		int[] arr = {1,2,3,4,5,6,7};
//		int[] arr = {6,2, 4, 3, 5, 1, 7};
//		int[] arr = {7 ,1, 5, 3, 4, 2, 6};
		int[] arr = null;
		arr = test.reOrderArr(arr);
		if(arr != null) {
			for(int i:arr) {
				System.out.print(i + "  ");
			}
		}
	}
}
