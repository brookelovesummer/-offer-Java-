package Math;

public class Permutation_and_Combunation {

	/**
	 * �����������ע���������͵����
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
     * ������������ע���������͵����
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
     * ����ȫ���У�ע���������͵����
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
