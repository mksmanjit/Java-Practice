package foo;

public class InitialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s = new Super();
	}

}

class Super{
	static{
		System.out.println("Class A Static Block");
	}
	{System.out.println("Class A init Block");}
}
class Child1 extends Super{
	static{
		System.out.println("Class B Static Block");
	}
	{System.out.println("Class B init Block");}
}
