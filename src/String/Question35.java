package String;

import java.util.HashMap;
import java.util.Map;

public class Question35 {
	
	/**
	 * �ַ����е�һ��ֻ����һ�ε��ַ�
	 * 
	 * ����һ������ͳ��ÿ���ַ����ֵĴ�����Ȼ���ٱ���һ���ַ������ҵ���һ��ֻ����һ�ε��ַ�
	 */
	
	public char firstUniqChar(String s) {
		
		char[] charr = new char[256];//ͳ��ÿ���ַ����ֵĴ���
		int length = s.length();
        int i=0;
		for(;i<length;i++) {
			charr[s.charAt(i)]++;
		}
		for(i=0;i<length;i++) {
			if(charr[s.charAt(i)] == 1)
				return s.charAt(i);
		}
		return ' ';
	}

	
	/*************************���濼����չ���⣺�����Ǻ����ַ�����ô��****************************/
	
	
	/**
	 * ��������£�Ҫע��������ַ���Ŀ������256��
	 * ��Ϊ��ʱ����2���ֽڱ��룬16λ�ˣ���Ȼ�����Բ���������ַ��ķ�������������ʱ��Ч�ʻ�ܵ�
	 */
	public char firstUniqueCharacter(String s) {
		
		Map<Character,Integer> map = new HashMap<>();
		char[] charr = s.toCharArray();
		for(char ch:charr)
			map.put(ch, map.getOrDefault(ch, 0)+1);
		for(char ch:charr)
			if(map.get(ch) == 1)
				return ch;
		return ' ';
	}
	
	
	/**
	 * ���ַ���s1��ɾ��s2�г��ֹ����ַ�
	 * @param s1
	 * @param s2
	 * @return
	 */
	public String deleteAnotherString(String s1, String s2) {
		
		boolean[] flags = new boolean[256];//ͳ��ÿ���ַ����ֵĴ���
		for(int i=0;i<s2.length();i++) {
			flags[s2.charAt(i)] = true;
		}
		StringBuilder sb = new StringBuilder(s1);
		for(int i=0;i<sb.length();i++) {
			if(flags[sb.charAt(i)])
				sb.deleteCharAt(i--);
			//ע��i��Ҫ��һ����Ϊɾ�����ַ��������ַ������Ȼ��1����ôԭ���ַ������ַ�������ӦҲ���һ
		}
		return sb.toString();
	}
	
	/**
	 * ɾ��s���ظ����ֵ��ַ�
	 * @param s
	 * @return
	 */
	public String deleteRepeatCh(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		boolean[] flags = new boolean[256];//ͳ��ÿ���ַ����ֵĴ���
		for(int i=0;i<sb.length();i++) {
			if(flags[sb.charAt(i)])//�ַ����ֹ���ɾ��������ͽ���־λ��Ϊtrue
				sb.deleteCharAt(i--);
			else
				flags[sb.charAt(i)] = true;
		}
		return sb.toString();
	}
	
	/**
	 * �Ƚ�s1��s2�Ƿ��Ǳ�λ�ʣ���λ��ָ������ĸ�Ĳ�ͬ���У����ַ������ֵ��ַ���ͬ�����Ҵ���Ҳ��ͬ��
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isChangelocationString(String s1 , String s2) {
		if(s1.length() != s2.length())
			return false;
		int[] counts = new int[256];
		for(int i=0;i<s1.length();i++) {
			counts[s1.charAt(i)]++;
			counts[s2.charAt(i)]--;
		}
		for(int i=0;i<counts.length;i++) {
			if(counts[i] != 0)
				return false;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		Question35 test = new Question35();
		System.out.println(test.isChangelocationString("add", "adc"));
	}
}
