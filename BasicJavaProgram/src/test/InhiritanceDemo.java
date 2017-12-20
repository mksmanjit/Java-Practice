package test;

public class InhiritanceDemo {
	Integer i = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 d = new Demo1();
		Integer i = new Integer(5);
		d.display(5);
	}

}

class Demo1 {
	public void display(int a){
		System.out.println("Demo1");
	}
	public void go(){
		System.out.println("go");
	}
	public void display(Integer a){
		System.out.println("Demo2>>Integer");
	}
}

class Demo2 extends Demo1 {
	public void display(Integer a){
		super.go();
		System.out.println("Demo2");
	}
}
class Demo3 extends Demo2{
	public void display(String s){
		System.out.println("Demo3");
	}
}
