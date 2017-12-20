package foo;

public class OverridingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ASuper a =new BChild();
		BChild b = new BChild();
		ASuper a1=null;
		a1.display();
		System.out.println(a.i+">>"+b.i);
	}

}

class ASuper{
	int i=10;
	public static void display(){
		System.out.println("Demo");
	}
	
	static class staticClass{
		public void innerClassMethod(){
		}
	}
}
class BChild extends ASuper{
	int i = 20;
}
