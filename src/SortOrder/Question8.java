package SortOrder;

public class Question8 {
	
	/**
	 * ����0��Ԫ���Ƶ�ĩβ�����������arr�ǵ�������ģ�
	 * ֻҪ�ƶ��˷����Ԫ�أ�arr�ĵ�һ��Ԫ�ض������ڵ������һ��Ԫ��
	 */
	
	/**
	 * ������ת�������Сֵ����תָ���ǽ��������������ǰ������Ԫ���Ƶ�����ĩβ
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
			//������Ԫ�ض���ȣ���ʱָ���޷��ƶ����˷�ʧЧ����Ҫ����
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
