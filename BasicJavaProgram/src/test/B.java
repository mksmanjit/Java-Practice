package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class B extends Testing {
	A a = new A();
	static int i =20;
	B(){
		System.out.println("B");
	}
	static{
		System.out.println(i);
	}
	public static void main(String args[]){
		//B b;
		
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		boolean b =false;
		while(b = m.find()){
			System.out.print(m.start()+">>"+m.group()+"??");
		}
	}
}

class Testing{
	static{
		System.out.println("Testing");
	}
}
