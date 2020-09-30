package String;

public class ExternalQuestion1 {
	
	/**
	 * �жϸ�����8��Ԫ�ص����飬�ܲ��ܷ�����һ���������8�������ϣ�ʹ��������Ե� ���4����������
	 * 
	 * ���⣺������8������ȫ���У�����һ������������
	 * a1+a2+a3+a4 == a5+a6+a7+a8 && 
	 * a1+a3+a5+a7 == a2+a4+a6+a8 && 
	 * a1+a2+a5+a6 == a3+a4+a7+s8
	 * @param peeks
	 * @return
	 */
	
	private boolean flag = false;
	
	public boolean SumofPeekEqual(int[] peeks) {
		if(peeks.length != 8) {
			System.out.println("����Ԫ����ĿС��8");
			System.exit(1);
		}
		permutationofPeeks(peeks, 0);
		return flag;
	}
	
	private void permutationofPeeks(int[] peeks, int begin) {
		
    	if(begin == peeks.length-1) {
			if(PeekEqual(peeks)) {
				flag = true;
				printarr(peeks);//��ӡ������������������
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
