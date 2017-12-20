package foo;

import java.util.Date;

public class WrapperDemo {
	static int x;
	Integer man = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(x);
		Integer man = new Integer(5000);
		man = null;
		Runtime r = Runtime.getRuntime();
		System.out.println(r.totalMemory());
		System.out.println(r.freeMemory());
		Date d = null;
		for(int i=0;i<1000000000;i++){
			d = new Date();
			d= null;
		}
		System.out.println(r.freeMemory());
		System.gc();
		System.out.println(r.freeMemory());
	}
	/*static void display(int x){
		System.out.println("Hello sir G");
	}*/
	static void display(long... x){
		System.out.println("Hello sir G Long");
	}
	static void display(Long... x){
		System.out.println("Hello sir G Integer");
	}
	
	protected void finalize(){
		System.out.println("Inside Finalize");
		man = new Integer(10000);
		System.out.println(man);
	}
}
