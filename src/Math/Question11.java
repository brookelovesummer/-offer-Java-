package Math;

public class Question11 {
	
	/**
	 * ϸ�ھ����ɰ� 
	 * 
	 * ��һ�����������ݣ���Ҫ���Ǹ�ָ�����ݵ��������ָ������Ҫ�����Ϊ��
	 * ������Ҫ�жϵ��������������ڵ���Ϊ0ʱ��Ҫ��ָ������Ϊ0
	 * @param base
	 * @param exponent
	 * @return
	 * @throws Exception 
	 */
	public double power(double base, int exponent) throws Exception {
		
		double result = 0;
		//�ȿ����������������Ϊ0��ָ��Ϊ0 
		if(Math.abs(base) < 1e-6 && exponent <= 0)
			throw new Exception("�����η���ָ������������");
		
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
