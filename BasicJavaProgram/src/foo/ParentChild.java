package foo;

public class ParentChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T1.display1();
	}

}

class H1 {
	public static void display1(){
		System.out.println("Static display 1");
	}
	public void display(){
		System.out.println("A");
	}
}

class T1 extends H1{
	public void display(){
		System.out.println("B");
	}
}
