package Math;

public class Question11 {
	
	/**
	 * 细节决定成败 
	 * 
	 * 求一个浮点数的幂，需要考虑负指数次幂的情况，负指数次幂要求底数为正
	 * 所以需要判断底数的正负，对于底数为0时，要求指数不能为0
	 * @param base
	 * @param exponent
	 * @return
	 * @throws Exception 
	 */
	public double power(double base, int exponent) throws Exception {
		
		double result = 0;
		//先考虑特殊情况，底数为0，指数为0 
		if(Math.abs(base) < 1e-6 && exponent <= 0)
			throw new Exception("零的零次方或负指数次幂无意义");
		
		if(exponent < 0)
			result = 1 / getpower1(base,-exponent);
		else
			result = getpower1(base,exponent);
		return result;
	}

	private double getpower(double base, int exponent) {
		double result = 1;
		for(int i=1;i<=exponent;i++) {
			result *= base;
		}
		return result;
	}

	private double getpower1(double base, int exponent) {
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		
		if((exponent & 1) == 1)
			return getpower1(base, (exponent-1)>>1) * getpower1(base, (exponent-1)>>1)*base;
		else
			return getpower1(base, exponent>>1)*getpower1(base, exponent>>1);
	}
	
	public static void main(String[] args) throws Exception {
		Question11 test = new Question11();
		System.out.println(test.power(0.00001,-2));
	}
}
