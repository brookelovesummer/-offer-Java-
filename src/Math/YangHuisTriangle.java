package Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YangHuisTriangle {
	
	/**
	 * ʵ��һ����������ǵĺ���
	 * @param n
	 */
	public void paintYangHuisTriangle(long rows) {
        long number = 0;
        int spaces = ("" + (long)Math.pow(2, rows)).length() + 1;//ÿ����Ԫ�صļ����һ��
        List<Long> list = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
        	
            for (int col = 1; col <= rows - row; col++)
                System.out.printf("%"+spaces+"s", "");

            for (int col = 0; col <= row; col++) {
            	//��߽���ұ߽�Ϊ1
            	if(col == 0 || col == row) 
            		number = 1;
            	else {
            		if(row >= 2)
            			number = list.get(0)+list.get(1);//��һ�е�����������������֮��
            		if(col == row - 1)
            			list.remove(0);//����ӡ����һ�еĵ����ڶ���Ԫ��ʱ��Ҫɾ������һ��Ԫ��
            		list.remove(0);//ÿ��ֻɾ����һ���һ��Ԫ��
            	}
            	if(row >= 1)
            		list.add(number);//�ڶ��㿪ʼ����Ҫ��¼��һ���ֵ
            	System.out.printf("%-"+(spaces << 1)+"d", number);
            }
            
            System.out.print('\n');
        }
	}
	
    public static void main(String[] args) {
    	System.out.print("��������Ҫ��ӡ��������ǡ���������");
        Scanner input = new Scanner(System.in);
        long rows = input.nextLong();
        input.close();
        YangHuisTriangle test = new YangHuisTriangle();
        test.paintYangHuisTriangle(rows);
    }
}
