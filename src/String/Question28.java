package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question28 {
	
	   
    /**
     * �ݹ�ʵ��
     * @param s
     * @return
     */
    public String[] permutation_recursion(String s) {

    	if(s == null || s.length() == 0)
    		return null;
    	
    	Set<String> set = new HashSet<>();
    	char[] strs = s.toCharArray();
    	permutation_recursion(strs,0,set);
    	String[] res = new String[set.size()];
    	return set.toArray(res);
    }
    
    /**
     * ��strs���齻����һ�κ�Ӧ���ٴλ����ϼ�������һ��λ�ã����翼��abcd������a��b��bacd����
     * ��ʱ��Ӧ�ü����ݹ�bacd������a��c��˼���ǵ�����ǰһ�����������º�һ��λ�õ����
     * @param strs
     * @param begin
     * @param set
     */
    public void permutation_recursion(char[] strs, int begin, Set<String> set) {
    	
    	if(begin == strs.length-1) {
    		set.add(new String(strs));
    		return;
    	}
    	
		for(int i=begin;i<strs.length;i++) {
			swap(strs,i,begin);
			permutation_recursion(strs,begin+1,set);
			swap(strs,i,begin);
		}
    }
    
    private void swap(char[] strs, int i, int j) {
    	char temp = strs[i];
    	strs[i] = strs[j];
    	strs[j] = temp;
    }
    
    
    /**********************������n���ַ����������*********************************/

    public void Combination(String s){
    	if(s == null || s.length() == 0)
    		return;
    	List<String> list = new ArrayList<>();//����list�Ǽ�¼ÿ����ϵģ����Ǵ����������
    	for(int m=1;m<=s.length();m++)    	
    		Combination_recursely(s, 0, m, list);
    }
    
    /**
     * list��ʾ������ϣ�Ҳ����˵ÿ��m==0��ʱ��list��װ���ַ�������������������ϵ�һ��
     * ����ÿ�εݹ飬�Ƚ���ǰ�ַ���Ϊ��ϵ�һ���֣�����������Ϊ��ϵ�һ���ֺ��ټ�����������ϵ�ʱ��
     * ��ʱ����Ҫɾ�����Ԫ����list��
     * @param s
     * @param begin
     * @param m
     * @param list
     */
    public void Combination_recursely(String s, int begin, int m, List<String> list){
    
    	if(m==0) {
    		for(String s1:list)
    			System.out.print(s1+" ");
    		System.out.println();
    		return;
    	}
    	if(begin == s.length())
    		return;
    	list.add(s.charAt(begin)+"");//�Ƚ���ǰ�ַ���Ϊ����ϵ�һ����
    	Combination_recursely(s, begin+1, m-1, list);//��ǰ�ַ���Ϊ��ϵ�һ����
    	list.remove(list.size()-1);//�����ַ��Ƴ����
    	Combination_recursely(s, begin+1, m, list);//��ǰ�ַ�����Ϊ��ϵ�һ����
    }
    
    
    /*************************����һ�����ַ�����¼��ϣ�Ȼ����setͳ�����***********************************/
    public Set<String> Combination1(String s){
    	if(s == null || s.length() == 0)
    		return null;
    	Set<String> set = new HashSet<>();
    	for(int m=1;m<=s.length();m++)    	
    		Combination_recursely1(s, 0, m,"" , set);
    	return set;
    }
    
    /**
     * ����������һ��help�ַ������ڼ�¼��ϣ�help��ʵ����ԭ��ÿ�μ�¼��setװ���ַ����Ľ��
     * Ȼ��set��ֻ��Ҫ�����¼������ϼ���
     * ����ÿ�εݹ飬�Ƚ���ǰ�ַ���Ϊ��ϵ�һ���֣�����������Ϊ��ϵ�һ���ֺ��ټ�����������ϵ�ʱ��
     * @param s
     * @param begin
     * @param m
     * @param set
     */
    public void Combination_recursely1(String s, int begin, int m, String help2, Set<String> set){
    
    	if(m==0) {
    		set.add(help2);
    		return;
    	}
    	if(begin == s.length())
    		return;
    	help2 += s.charAt(begin);//�Ƚ���ǰ�ַ���Ϊ����ϵ�һ����
    	Combination_recursely1(s, begin+1, m-1,help2, set);//��ǰ�ַ���Ϊ��ϵ�һ����
    	help2 = help2.substring(0, help2.length()-1);//�����ַ��Ƴ����
    	Combination_recursely1(s, begin+1, m, help2, set);//��ǰ�ַ�����Ϊ��ϵ�һ����
    }
    
    
    /**
     * ����ע�ش������ע�ظ���
     * @param args
     */
    public static void main(String[] args) {
		Question28 test = new Question28();
//		String[] res = test.permutation_recursion("abc");
//		for(String s:res)
//			System.out.print(s+"  ");
		for(String s :test.Combination1("abc")) {
			System.out.print(s + "   ");
		}
	}
}
