package com;

public class ParentChildDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B a = new B();
		a.display();
	}

}

class A{
	int master=20;
	public void display(){
		System.out.println("Super display");
		display1();
	}
	private void display1(){
		System.out.println("Super display1");
		display2();
	}
	
	public void display2(){
		System.out.println("Super display2");
	}
}

class B extends A{
	int master=10;
	public void display(){
		System.out.println("Child display>>"+master);
		super.display();
	}
	private void display1(){
		System.out.println("Child display1");
	}
	public void display2(){
		System.out.println("Child display2");
	}
}
