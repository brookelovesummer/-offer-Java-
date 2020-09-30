package Singleton;

public class Question2 {
	
	public static void main(String[] args) {
		singleton1 s11 = singleton1.getInstance();
		singleton1 s12 = singleton1.getInstance();
		System.out.println(s11 == s12);
		
		singleton2 s21 = singleton2.getInstance();
		singleton2 s22 = singleton2.getInstance();
		System.out.println(s21 == s22);
		
		singleton3 s31 = singleton3.getInstance();
		singleton3 s32 = singleton3.getInstance();
		System.out.println(s31 == s32);
		
	}

}

/**
 * 饿汉式单例（优点是需要的时候创建，缺点是多线程运行时不够快）
 * @author brooke
 *
 */
class singleton1{
	
	private static singleton1 instance = null;

	private singleton1() {

	}
	
	public static singleton1 getInstance() {
		synchronized (singleton1.class) {
			if(instance == null)
				instance = new singleton1();
		}
		return instance;
	}
	
}

/**
 * 懒汉式单例(优缺点和饿汉式单例互补)
 * @author brooke
 *
 */
class singleton2{
	
	private static singleton2 instance = new singleton2();
	
	private singleton2() {
		
	}
	
	public static singleton2 getInstance() {
		return instance;
	}
}


/**
 * 这种不知道会怎么样
 * @author brooke
 *
 */
class singleton3{
	
	private singleton3() {
		
	}
	
	public static singleton3 getInstance() {
		return Nested.instance;
	}
	
	private static class Nested{
		private static singleton3 instance = new singleton3();
		
	}
}