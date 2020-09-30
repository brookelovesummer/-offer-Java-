package String;

public class Question4 {
	
	/**
	 * ��"we are happy"����ַ����滻�ո�Ϊ%20
	 * 
	 * �ո�-%20�����ǣ�% + 16���Ƶ�ASCII��
	 */
	
	public String getcharHex(char ch) {
		return "%"+Integer.toHexString(ch);
	}
	
	/**
	 * �滻�����ַ�Ϊ��Ӧ��ASCII��16����ģʽ
	 * @param s
	 * @return
	 */
	public String replaceBlank2Ascii(String s,char ch) {
		
		//��סÿ��д����ǰ�ȿ����п�
		if(s == null || s.length() == 0)
			return null;
		
		char[] spacehex = getcharHex(ch).toCharArray();
		char[] carr = s.toCharArray();
		int numch = 0;
		for(int i=0;i<carr.length;i++) {
			if(carr[i] == ch)
				numch++;
		}
		char[] newcarr = new char[carr.length+numch*2];
		int old = carr.length-1;
		int new1 = newcarr.length-1;
		while(old >= 0) {
			if(carr[old] == ch) {
				newcarr[new1--] = spacehex[2];
				newcarr[new1--] = spacehex[1];
				newcarr[new1--] = spacehex[0];
			}else {
				newcarr[new1--] = carr[old]; 
			}
			old--;
		}
		
		return new String(newcarr);
	}
	
	
	/**
	 * �ҳ��ַ����е������ַ����������滻Ϊ��Ӧ��hex��ʽ
	 * @param args
	 */
	public String replacespcific2hex(String s) {
		if(s==null||s.length()==0)
			return null;
			
		char[] carr = s.toCharArray();
		int numch = 0;
		for(int i=0;i<carr.length;i++) {
			if(!Character.isLetterOrDigit(carr[i]))
				numch++;
		}
		char[] newcarr = new char[carr.length+numch*2];
		int old = carr.length-1;
		int new1 = newcarr.length-1;
		while(old >= 0) {
			if(!Character.isLetterOrDigit(carr[old])) {
				char[] spacehex = getcharHex(carr[old]).toCharArray();
				newcarr[new1--] = spacehex[2];
				newcarr[new1--] = spacehex[1];
				newcarr[new1--] = spacehex[0];
			}else {
				newcarr[new1--] = carr[old]; 
			}
			old--;
		}
		return new String(newcarr);
	}
	
	
	public int[] mergeArray(int[] arr1, int[] arr2) {
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
//		System.out.println(new Question4().getcharHex('#'));
		Question4 test = new Question4();
		String s = "we are@happy&boys  ";
		System.out.println(test.replacespcific2hex(s));
		System.out.println(Integer.toHexString(16));
//		try {
//			System.out.println(s.replaceAll(" ", test.getcharHex(' ')));
//		}catch (NullPointerException e){
//			System.out.println(s);
//		}
	}

}
