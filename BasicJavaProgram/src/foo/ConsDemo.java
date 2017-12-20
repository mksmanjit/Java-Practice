package foo;

class A{
	int j = 20;
	A(int m){
		System.out.println(m);
	}
	static{System.out.println("A Static Block");}
	{System.out.println("A Init Block");}
}
class B extends A{
	int i =10;
	static final int k = 29;
	B(){
		super(k);
		System.out.println(i);
	}
	static{System.out.println("B Static Block");}
	{System.out.println("B Init Block");}
}
public class ConsDemo {

	public static void main(String args[]){
		B b= new B();
	}
}
