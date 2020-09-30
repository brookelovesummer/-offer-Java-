package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question28 {
	
	   
    /**
     * 递归实现
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
     * 当strs数组交换过一次后，应该再次基础上继续换下一个位置，比如考虑abcd，换了a和b（bacd），
     * 这时候应该继续递归bacd即交换a和c意思就是当考虑前一个不变的情况下后一个位置的情况
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
    
    
    /**********************以下是n个字符的组合问题*********************************/

    public void Combination(String s){
    	if(s == null || s.length() == 0)
    		return;
    	List<String> list = new ArrayList<>();//这里list是记录每次组合的，不是代表整个组合
    	for(int m=1;m<=s.length();m++)    	
    		Combination_recursely(s, 0, m, list);
    }
    
    /**
     * list表示的是组合，也就是说每次m==0的时候，list中装的字符串结合起来才是这次组合的一种
     * 所以每次递归，先将当前字符视为组合的一部分，计算完它作为组合的一部分后，再计算它不是组合的时候
     * 这时就需要删除这个元素在list中
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
    	list.add(s.charAt(begin)+"");//先将当前字符认为是组合的一部分
    	Combination_recursely(s, begin+1, m-1, list);//当前字符作为组合的一部分
    	list.remove(list.size()-1);//将该字符移除组合
    	Combination_recursely(s, begin+1, m, list);//当前字符不作为组合的一部分
    }
    
    
    /*************************测试一下用字符串记录组合，然后用set统计组合***********************************/
    public Set<String> Combination1(String s){
    	if(s == null || s.length() == 0)
    		return null;
    	Set<String> set = new HashSet<>();
    	for(int m=1;m<=s.length();m++)    	
    		Combination_recursely1(s, 0, m,"" , set);
    	return set;
    }
    
    /**
     * 这里增加了一个help字符串用于记录组合，help其实就是原来每次记录的set装的字符串的结合
     * 然后set就只需要负责记录整个组合即可
     * 所以每次递归，先将当前字符视为组合的一部分，计算完它作为组合的一部分后，再计算它不是组合的时候
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
    	help2 += s.charAt(begin);//先将当前字符认为是组合的一部分
    	Combination_recursely1(s, begin+1, m-1,help2, set);//当前字符作为组合的一部分
    	help2 = help2.substring(0, help2.length()-1);//将该字符移除组合
    	Combination_recursely1(s, begin+1, m, help2, set);//当前字符不作为组合的一部分
    }
    
    
    /**
     * 排列注重次序，组合注重个数
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
