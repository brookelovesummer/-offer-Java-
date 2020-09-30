package Math;

public class Permutation_and_Combunation {

	/**
	 * 计算组合数，注意整形类型的溢出
	 * @param m
	 * @param n
	 * @return
	 */
    public int Combination(int m, int n) {
    	
        int num = n - m;
        long res1 = 1;
        long res2 = 1;
        while(m != 0)
            res1 *= m--;
        while(n != num)
            res2 *= n--;
    	return (int)(res2 / res1);
    }
    
    /**
     * 计算排列数，注意整形类型的溢出
     * @param m
     * @param n
     * @return
     */
    public int Permutation(int m, int n) {
    	
        int num = n - m;
        long res = 1;
        while(n != num)
            res *= n--;
    	return (int)res;
    }
    
    /**
     * 计算全排列，注意整形类型的溢出
     * @param n
     * @return
     */
    public int Permutation(int n) {
    	
        long res = 1;
        while(n != 0)
            res *= n--;
    	return (int)res;
    }
    
    
    public static void main(String[] args) {
		Permutation_and_Combunation test = new Permutation_and_Combunation();
    	System.out.println(test.Permutation(1));
	}
}
