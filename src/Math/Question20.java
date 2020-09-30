package Math;

public class Question20 {
	
	/**
	 * ˳ʱ���ӡ����
	 */
	
	public void printMatrixIncircle(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int row = 0, startrow = 0;
		int col = 0, startcol = 0;
		int length1 = matrix.length;
		int length2 = matrix[0].length;
		int endrow = length1 - 1;
		int endcol = length2 - 1;//startrow*2 < length1 && startcol*2 < length2
		while(startrow <= endrow && startcol <= endcol) {
			row = startrow;
			col = startcol;
//			System.out.println("\nrow = "+row+"  "+"col = "+col);

			while(col < endcol) 
				print(matrix[row][col++]);
			while(row < endrow)
				print(matrix[row++][col]);
			while(startrow < endrow && col > startcol)
				print(matrix[row][col--]);
			while(startcol < endcol && row > startrow)
				print(matrix[row--][col]);
			if((startrow == endrow || startcol == endcol) && col == endcol && row == endrow)
				print(matrix[row][col]);
			startrow++;
			startcol++;
			endrow--;
			endcol--;
		}
	}
	
	
	/**
	 * �ݹ�汾
	 * @param matrix
	 * @return
	 */
	
	public void printMatrixcircle1(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int startrow = 0;
		int startcol = 0;
		int endrow = matrix.length - 1;
		int endcol = matrix[0].length - 1;
		printMatrixcircle_recuriesly(matrix, startrow, startcol, endrow, endcol);
	}
	
	public void printMatrixcircle_recuriesly(int[][] matrix,int startrow, int startcol, int endrow, int endcol) {
		if(startrow > endrow || startcol > endcol)
			return;
		
		int row = startrow;
		int col = startcol;

		while(col < endcol) 
			print(matrix[row][col++]);
		while(row < endrow)
			print(matrix[row++][col]);
		while(startrow < endrow && col > startcol)
			print(matrix[row][col--]);
		while(startcol < endcol && row > startrow)
			print(matrix[row--][col]);
		if((startrow == endrow || startcol == endcol) && col == endcol && row == endrow)
			print(matrix[row][col]);
		printMatrixcircle_recuriesly(matrix,startrow+1,startcol+1,endrow-1,endcol-1);
	}

	
	public int[] MatrixIncircle(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return null;

		int pindex = 0;
		int row = 0, startrow = 0;
		int col = 0, startcol = 0;
		int length1 = matrix.length;
		int length2 = matrix[0].length;
		int endrow = length1 - 1;
		int endcol = length2 - 1;//startrow*2 < length1 && startcol*2 < length2
		int[] prints = new int[length1 * length2];
		while(startrow <= endrow && startcol <= endcol) {
			row = startrow;
			col = startcol;

			/**
			 * 2.1 �����ϵ����ϵĹ���
			 * ���������Ҫcol < endrow��ΪʲĪ��ȡ�Ⱥţ���ΪҪ�����ϵ��Ǹ�Ԫ����Ϊ��һ��ѭ����ӡ����ʼ�㡣
			 */
			while(col < endcol) { 
				prints[pindex++] = matrix[row][col++];
			}
			
			/**
			 * 2.2 �����ϵ����µĹ���
			 * ������̲��ͬ2.1��row < endrow
			 */
			while(row < endrow) {
				prints[pindex++] = matrix[row++][col];
			}
			
			/**
			 * 2.3 �����µ����µĹ���
			 * ���������Ҫcol > 0�������費��Ҫ����������������ֻ��һ��Ԫ���أ�
			 * ���ʱ��col�������ߣ�ֻ�е���һ��Ԫ�ش��ڣ�col�������ƣ�������Ҫ����startrow < endrow��
			 * ע�����ﲻ����row���жϣ���Ϊ����ʲô������ߵ���һ����row��һ������endrow��
			 */
			while(startrow < endrow && col > startcol) {
				prints[pindex++] = matrix[row][col--];
			}
			
			/**
			 * 2.4 �����µ����ϵĹ���
			 * ���������Ҫrow > 0 �� startcol < endrcol��ԭ��ͬ2.3
			 */
			while(startcol < endcol && row > startrow) {
				prints[pindex++] = matrix[row--][col];
			}
			if((startrow == endrow || startcol == endcol) 
					&& col == endcol && row == endrow)
				prints[pindex] = matrix[row][col];
			startrow++;
			startcol++;
			endrow--;
			endcol--;
		}
		return prints;
	}
	public void print(int a) {
		System.out.print(a+" ");
	}
	
	
	/**
	 * ֮���δ�ӡ����
	 * @param args
	 */
	public void printMatrixZhi(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return ;
		
		int row = 0;
		int col = 0;
		int length1 = matrix.length;
		int length2 = matrix[0].length;
		while(row < length1 && col < length2) {
			if(col < length2-1)
				print(matrix[row][col++]);
			else
				print(matrix[row++][col]);
//			System.out.println("\nrow = "+row+"  "+"col = "+col);
			while(col > 0 && row < length1-1) {
				print(matrix[row++][col--]);
			} 
//			System.out.println("\nrow = "+row+"  "+"col = "+col);
			if(col == 0)
				print(matrix[row++][col]);
			else
				print(matrix[row][col++]);
			while(col < length2-1 && row > 0) {
				print(matrix[row--][col++]);
			}
			
			if(row == length1 - 1 && col == length2 -1) {
				print(matrix[row++][col++]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Question20 test = new Question20();
//		test.printMatrixcircle1(matrix);
		test.printMatrixZhi(matrix);
		System.out.println();
//		int[] arr = test.MatrixIncircle(matrix);
//		for(int i : arr)
//			System.out.print(i+" ");
	}
}
