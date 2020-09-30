package String;

public class ExternalQuestion2 {
	
	private int result = 0;
	
	/**
	 * ������������̹���8X8�����ӣ�����Ҫ�������ϰڷ�8���ʺ󣨿��Կ�����Ϳ��ĳһ�����񣩣�ʹ��
	 * ��8���ʺ���������������
	 * 1.���������ʺ��ڲ�ͬ��
	 * 2.���������ʺ��ڲ�ͬ��
	 * 3.���������ʺ���ͬһ�Խ��ߣ�ָ����С����ĶԽ��ߣ�
	 * 
	 * �ⷨ�����ݵ�һ��������˵��8���ʺ�ÿ���ʺ�ռһ�У�
	 * ����������һ������ColofQueen[i]����ʾ��i�еĻʺ�����������ColofQueen������1-8��ʼ��
	 * Ȼ������������ȫ���У�����Щ�������������
	 * 
	 * ע�������������ô��ʾ��
	 * ������֮��ľ���ֵ����������֮��ľ���ֵ--������ͬһ���Խ�����
	 * |i-j| == |ColofQueen[i]-ColofQueen[j]|
	 * @return
	 */
	public int ArrangeQueen(int n) {
		int[] ColofQueen = new int[n];
		for(int i=0;i<n;i++)
			ColofQueen[i] = i+1;
		getArrange(ColofQueen,0);
		return result;
	}
	
	public void getArrange(int[] ColofQueen, int begin) {
		if(begin == ColofQueen.length) {
			if(isMeetCondition(ColofQueen)) {
				result++;
				printarr(ColofQueen);
			}
			return;
		}
		
		for(int i=begin;i<ColofQueen.length;i++) {
			swap(ColofQueen,i,begin);
			getArrange(ColofQueen, begin+1);
			swap(ColofQueen,i,begin);
		}
	}
	
    private void swap(int[] strs, int i, int j) {
    	int temp = strs[i];
    	strs[i] = strs[j];
    	strs[j] = temp;
    }
    
	private void printarr(int[] arr) {
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
	
	private boolean isMeetCondition(int[] ColofQueen) {
		
		for(int i=0;i<ColofQueen.length;i++)
			for(int j=i+1;j<ColofQueen.length;j++) {
				if(Math.abs(i-j) == Math.abs(ColofQueen[i]-ColofQueen[j]))
					return false;
			}
		return true;
	}

	public static void main(String[] args) {
		ExternalQuestion2 test = new ExternalQuestion2();
		System.out.println(test.ArrangeQueen(8));
//		int[] arr = {3,6,2,7,1,4,8,5};
//		System.out.println(test.isMeetCondition(arr));
	}
}
