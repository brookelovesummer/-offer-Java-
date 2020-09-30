package Array;

public class Question40 {
	
	/**
	 * ������ֻ����һ�ε�����
	 * ����һ��������������������������һ�Σ�����������2�Σ�������������һ�ε�����ʱ�临�Ӷ�o(n)���ռ临�Ӷ�o(1)
	 * 
	 * ���㣺
	 * ��ͬ������֮�䣬ż�������һ��Ϊ0��0���κ���������Ǹ�������
	 * ������㽻����   a^b^c = a^c^b
	 */
	
	/**
	 * ������ͬ������֮�䣬��λ�����Ϊ0��������0��ʼ�������ÿ������Ԫ�أ�
	 * ���յõ��Ľ������ֻ����һ�ε�Ԫ�أ�
	 * ������������и�������ֻ��һ��Ԫ�س��������Σ�ʣ�඼����ż���Σ�������ʧЧ��
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
	 * ����˵��������������������һ�Σ�����������ż���θ���ô���أ�����ֱ��������������
	 * ������Ҫ����������һ�ε����ֱ�ŵ������������棬�������ֱܷ�������������⡣
	 * 
	 * ����֪������������ʧЧ��ԭ�����ڣ�������������һ�ε����������ʱ�������������Ԫ��
	 * �õ��Ľ���ȼ�������������һ��Ԫ�ص��������
	 * ���������������ѷ��֣����������㣬�����������ʣ����������£���һλ��1��˵����
	 * �����������ε�����Ӧλ��ͬ����������ص���Խ���������һ�ε����ֿ���
	 * ����{2��2��4��5��5��6}��4(0100),6(1100),���Ľ���϶���1000�����в���ֱ�ӽ����
	 * ��0λ���������������ֱ����������������⡣
	 * 
	 * @return
	 */
	public int[] getTwoNumOnce(int[] arr) {
		if(arr == null || arr.length <= 1) {
			System.out.println("Invalid input!");
			System.exit(1);
		}
		int[] result = new int[2];
		int temp = getNumOnce(arr,0,arr.length-1);//��Ҫ��temp�滻��ֻ��һλΪ1�����
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
	 * �����������ķ�������ǰ�벿�֣�������ķ��������벿��
	 * �����￼�ǵ���������temp��λ���Ƿ��0��
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

	/******************���������۵Ĵ���Ľⷨ***************************/
    public int[] singleNumbers(int[] arr) {
		int[] result = new int[2];
		int temp = 0;
        for(int i:arr){
            temp ^= i;
        }
        temp &= -temp;//����ȷʵ������λ��������뻯��ֱ�������ҵ����ұߵ�1
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
