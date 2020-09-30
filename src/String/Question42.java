package String;

public class Question42 {
	
	/**
	 * ��ת����˳��
	 * 
	 * ���ʴ���ת�������ڲ���ĸ˳�򲻱䣬�����ŵ���ĸ����
	 * I am a student.   -->  student. a am I
	 */

	/**
	 * ��ת�����ַ�
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
	 * ��ת�ַ������[i:j]Ƭ��
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
	 * �ȷ�תÿ���ַ���Ȼ���ٶ�ÿ�����ʷ�ת�����ַ����޷�������֮��Ķ���ո�
	 * @param word
	 * @return
	 */
	public String reverseSentence(String word) {
		if(word == null || word.length() == 0)
			return word;
		
		//�����ַ����еĿո�
		char[] charr = word.toCharArray();
		int start = 0, end = charr.length-1;
		while(charr[start] == ' ') start++;//ȥ�����׵Ŀո�
		while(charr[end] == ' ') end--;//ȥ����β�Ŀո�		
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
	
	/************************��������Դ����м京�п��ַ��ķ���**********************************/

	/**
	 * ����StringBuilder�洢�ǿ��ַ����ո�ֱ������
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
	
	
	/*********************����Ϊ�����ַ���****************************/
	/**
	 * �����ַ�������ǰn���ַ���ת���ַ���β��
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
