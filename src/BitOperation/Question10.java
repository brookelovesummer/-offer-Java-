package BitOperation;

public class Question10 {
	
	/**
	 * ��������1�ĸ���--���������������0����ô���أ�
	 */
	
	/**
	 * ����֪��һ������1��λ��֮����1����ʾ����������һλ��ż�������Կ��Բ���1�������һλ
	 * Ȼ����������һλ���������ܳ�������һ����1�ĸ���
	 * @param n
	 * @return
	 */
	public int getNumofOne(int n) {
		
		int count = 0;
		while(n != 0) {
			if((n & 1) == 1)
				count++;
			n >>= 1;
		}
		return count;
	}
	
	
	/**
	 * ��������ķ�����Ҫ���ƣ��������������Ʋ��㣬����Խ������Ӱ�죬���Ǹ������ƻᲹ1����ʱ����
	 * ������������ѭ��
	 * 
	 * �Ľ����ɲ���1���Ƶķ�ʽ���ֱ�Ը���������ÿһλ,ע�����������32λ��int���͵�λ����������Ϊ0
	 */
	public int getNumofOne2(int n) {
		
		int count = 0;
		int flag = 1;
		while(flag != 0) {
			if((flag & n) != 0)
				count++;
			flag <<= 1;
		}
		return count;
	}
	
	/**
	 * ������������ÿ��������Ҫѭ��32�Σ������ܲ��ܰ�ѭ�����������������м���1��ѭ��������
	 * 
	 * ����˵����һ�������һλ����1����0��
	 * 
	 * ������˵���һλ��1�������һλ��1���������1��ֻ�����һλ��1��Ϊ0��ǰ�涼û�䣬
	 * ��ô��������1֮�������λ�룬�õ��Ľ�����ǽ�����������ұߵ�һ��1��Ϊ0
	 * 
	 * ��˵���һλ��0��ʱ����ô��������������ұߵ�һ��1����ô�������1��ʱ�򣬾��ǽ������1���ڵ�
	 * λ�Լ���ߵ�0ȫ����ת������10100����1���10011������������λ�룬�����10000��
	 * ���ǽ�10100���ұߵ�һ��1���0
	 * 
	 * ���ϣ�һ����������1��λ�룬������ǽ����ұߵ�һ��1��Ϊ0��ͨ������������ǿ���д����
	 * @param args
	 */
	
	public int getNumofOne3(int n) {
		int count = 0;
		int m = n-1;
		while(n != 0) {
			count++;
			n = m & n;
			m = n - 1;
		}
		return count;
	}
	
	/**
	 * 2������һ���ص㣬���������������1��λ����0��������������ж�һ�����ǲ���2����
	 * @param args
	 */
	public boolean is2power(int n) {
		if((n & (n-1)) == 0)
			return true;
		return false;
	}
	
	/**
	 * ������Ҫ�ı�m�Ķ������еĶ���λ���ܵõ�n
	 * 
	 * ˼·��Ҫ�ҵ�m��n�Ķ�������Щλ��ͬ�����԰�λ�����ͬΪ�㣬����Ϊһ����Ȼ��ͳ������1�ĸ���
	 * @param m
	 * @param n
	 * @return
	 */
	public int m2n(int m, int n) {
		return getNumofOne3(m^n);
	}

	/**
	 * ͳ��2������0�ĸ�����ָ�����������0�ĸ���
	 * 
	 * ���һλΪ0����1����
	 * @param args
	 */

	public static void main(String[] args) {
		Question10 test = new Question10();
		System.out.println(test.getNumofOne(0));
		System.out.println(test.getNumofOne3(0));
		System.out.println(test.getNumofOne2(0));
	}
}
