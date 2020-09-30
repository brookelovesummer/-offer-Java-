package Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YangHuisTriangle {
	
	/**
	 * 实现一个画杨辉三角的函数
	 * @param n
	 */
	public void paintYangHuisTriangle(long rows) {
        long number = 0;
        int spaces = ("" + (long)Math.pow(2, rows)).length() + 1;//每两个元素的间隔的一半
        List<Long> list = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
        	
            for (int col = 1; col <= rows - row; col++)
                System.out.printf("%"+spaces+"s", "");

            for (int col = 0; col <= row; col++) {
            	//左边界和右边界为1
            	if(col == 0 || col == row) 
            		number = 1;
            	else {
            		if(row >= 2)
            			number = list.get(0)+list.get(1);//下一行的数等于它两肩上数之和
            		if(col == row - 1)
            			list.remove(0);//当打印到这一行的倒数第二个元素时，要删除完上一层元素
            		list.remove(0);//每次只删除上一层的一个元素
            	}
            	if(row >= 1)
            		list.add(number);//第二层开始就需要记录上一层的值
            	System.out.printf("%-"+(spaces << 1)+"d", number);
            }
            
            System.out.print('\n');
        }
	}
	
    public static void main(String[] args) {
    	System.out.print("请输入需要打印“杨辉三角”的行数：");
        Scanner input = new Scanner(System.in);
        long rows = input.nextLong();
        input.close();
        YangHuisTriangle test = new YangHuisTriangle();
        test.paintYangHuisTriangle(rows);
    }
}
