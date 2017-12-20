package foo;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display();
	}
	public static int display(){
		try{
			System.out.println("Manjit Kumar");
			System.exit(10);
			return display1();
			
		}
		finally{
			System.out.println("Finally");
		}
	}

	public static int display1(){
		System.out.println("Display1");
		return 1;

	}
	
	protected void finalize(){
		System.out.println("Inside Finalize");
	}
}
