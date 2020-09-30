package String;

public class Question42 {
	
	/**
	 * 翻转单词顺序
	 * 
	 * 单词次序翻转，单词内部字母顺序不变，标点符号当字母处理
	 * I am a student.   -->  student. a am I
	 */

	/**
	 * 翻转所有字符
	 * @param word
	 * @return
	 */
	public String reverseWords(String word) {
		if(word == null || word.length() == 0)
			return word;
		
		char[] charr = word.toCharArray();
		reverseCharr(charr, 0, charr.length-1);
		return new String(charr);
	}
	
	/**
	 * 翻转字符数组的[i:j]片段
	 * @param charr
	 * @param i
	 * @param j
	 */
	private void reverseCharr(char[] charr, int i, int j) {
		for(;i<j;i++,j--) {
			char temp = charr[i];
			charr[i] = charr[j];
			charr[j] = temp;
		}
	}
	
	/**
	 * 先翻转每个字符，然后再对每个单词翻转（这种方法无法处理单词之间的多个空格）
	 * @param word
	 * @return
	 */
	public String reverseSentence(String word) {
		if(word == null || word.length() == 0)
			return word;
		
		//处理字符串中的空格
		char[] charr = word.toCharArray();
		int start = 0, end = charr.length-1;
		while(charr[start] == ' ') start++;//去除句首的空格
		while(charr[end] == ' ') end--;//去除句尾的空格		
		reverseCharr(charr,start,end);
		
		int pstart = start;
		int pend = start+1;
		while(pend <= end) {
			if(charr[pend - 1] == ' ' && charr[pend] != ' ') {
				pstart = pend;
			}else if(charr[pend - 1] != ' ' && charr[pend] == ' '){
				reverseCharr(charr, pstart, pend-1);
			}
			pend++;
		}
		reverseCharr(charr, pstart, pend-1);
		return new String(charr).substring(start, end+1);
	}
	
	/************************下面是针对处理中间含有空字符的方法**********************************/

	/**
	 * 利用StringBuilder存储非空字符，空格直接跳过
	 * @param word
	 * @return
	 */
	public String reverseSentence_hzh(String word) {
		if(word == null || word.length() == 0)
			return word;
		
		StringBuilder sb = new StringBuilder();
		word = " " + word; 
		int i = word.length() - 1;;
		int j = i;
		boolean flag = true;
		for(;i >= 0 && j >= 0;) {
			if(word.charAt(i) == ' ') {
				i--;
				continue;
			}
			if(flag) {
				j = i;
				flag = !flag;
			}
			if(word.charAt(j) != ' ')
				j--;
			else {
				sb.append(word.substring(j+1, i+1)+" ");
				i = j;
				flag = !flag;
			}			
		}
		return sb.toString().trim();
	}
	
	
	/*********************以下为左旋字符串****************************/
	/**
	 * 左旋字符串，将前n个字符翻转到字符串尾部
	 * @param s
	 * @param n
	 * @return
	 */
    public String reverseLeftWords(String s, int n) {
    	String str = s.substring(0, n);
    	s = s.substring(n);
    	return s + str;
    }
	
	
	public static void main(String[] args) {
		Question42 test = new Question42();
		System.out.println(test.reverseSentence_hzh(" I am a student."));
	}

}
