package String;

public class ExternalQuestion2 {
	
	private int result = 0;
	
	/**
	 * 国际象棋的棋盘共有8X8个格子，现需要在棋盘上摆放8个皇后（可以看作是涂黑某一个方格），使得
	 * 这8个皇后满足以下条件：
	 * 1.任意两个皇后在不同行
	 * 2.任意两个皇后在不同列
	 * 3.任意两个皇后不在同一对角线（指的是小方格的对角线）
	 * 
	 * 解法：根据第一个条件，说明8个皇后每个皇后占一行，
	 * 所以我们用一个数组ColofQueen[i]来表示第i行的皇后所在列数，ColofQueen数组用1-8初始化
	 * 然后找这个数组的全排列，看哪些满足第三个条件
	 * 
	 * 注意第三个条件怎么表示？
	 * 行索引之差的绝对值等于列索引之差的绝对值--两点在同一条对角线上
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
