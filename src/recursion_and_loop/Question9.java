package recursion_and_loop;

public class Question9 {
	
	public long getFibonacci(int n) throws Exception {
		if(n < 0)
			throw new Exception("invaild input!");
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		
		return getFibonacci(n-1) + getFibonacci(n-2);
	}
	
	public long getFibonacci1(int n) throws Exception {
		
		if(n < 0)
			throw new Exception("invaild input!");
		
		long[] resoure = {0,1};
		long res = 0;
		if(n < 2)
			return resoure[n];
		
		for(int i=2;i<=n;i++) {
			res = resoure[0] + resoure[1];
			resoure[0] = resoure[1];
			resoure[1] = res;
		}
		return res;
	}
	

	public static void main(String[] args) throws Exception {
		System.out.println(new Question9().getFibonacci(40));
		System.out.println(new Question9().getFibonacci1(40));
	}
}
