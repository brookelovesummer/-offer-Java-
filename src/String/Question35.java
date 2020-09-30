package String;

import java.util.HashMap;
import java.util.Map;

public class Question35 {
	
	/**
	 * 字符串中第一次只出现一次的字符
	 * 
	 * 先用一个数组统计每个字符出现的次数，然后再遍历一次字符串，找到第一次只出现一次的字符
	 */
	
	public char firstUniqChar(String s) {
		
		char[] charr = new char[256];//统计每个字符出现的次数
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

	
	/*************************下面考虑拓展问题：若考虑汉字字符该怎么办****************************/
	
	
	/**
	 * 这种情况下，要注意整体的字符数目不再是256，
	 * 因为这时候是2个字节编码，16位了，当然还可以采用数组存字符的方法，但是这用时间效率会很低
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
	 * 从字符串s1中删除s2中出现过的字符
	 * @param s1
	 * @param s2
	 * @return
	 */
	public String deleteAnotherString(String s1, String s2) {
		
		boolean[] flags = new boolean[256];//统计每个字符出现的次数
		for(int i=0;i<s2.length();i++) {
			flags[s2.charAt(i)] = true;
		}
		StringBuilder sb = new StringBuilder(s1);
		for(int i=0;i<sb.length();i++) {
			if(flags[sb.charAt(i)])
				sb.deleteCharAt(i--);
			//注意i需要减一，因为删除该字符后，整个字符串长度会减1，那么原来字符串的字符索引相应也会减一
		}
		return sb.toString();
	}
	
	/**
	 * 删除s中重复出现的字符
	 * @param s
	 * @return
	 */
	public String deleteRepeatCh(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		boolean[] flags = new boolean[256];//统计每个字符出现的次数
		for(int i=0;i<sb.length();i++) {
			if(flags[sb.charAt(i)])//字符出现过就删除，否则就将标志位设为true
				sb.deleteCharAt(i--);
			else
				flags[sb.charAt(i)] = true;
		}
		return sb.toString();
	}
	
	/**
	 * 比较s1和s2是否是变位词（变位词指的是字母的不同排列，两字符串出现的字符相同，并且次数也相同）
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
