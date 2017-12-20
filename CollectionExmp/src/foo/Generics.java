package foo;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	
	public static void main(String args[]){
		Integer[] a = new Integer[4];
		List l = new ArrayList();
		l.add(10);
		l.add(4.4f);
		System.out.println(l);
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(10);
		l1.add(4);
		System.out.println(l1);
		Generics generics = new Generics();
		//generics.add(a);
		Demo<Integer,String> d = new Demo<Integer,String>();
		List<Demo<Integer,String>> demoList = new ArrayList<Demo<Integer,String>>();
		demoList.add(d);
		int rollNo =10;
		String name = "manjit";
		d.setName(name);
		d.setRollNo(rollNo);
		d.getRollArray();
		System.out.println(d.getRollNo()+">>"+d.getName());
		generics.add(demoList);
		Demo<Long,String> d1 = new Demo<Long,String>();
		/*float rollNo1 =10.2f;
		int name1 = 50;
		d.setName(name1);
		d.setRollNo(rollNo1);
		System.out.println(d.getRollNo()+">>"+d.getName());*/
		MethodGenerics methodGenerics = new MethodGenerics(d);
		methodGenerics.display(d);
	}
	
	void add(Object[] a){
		a[0] = new Long(1);
	}
	void add(List<? super Demo<Integer,String>> list){
		
		list.add(new Demo());
	}
	
	void add1(List<? extends Demo<Integer,String>> list){
		System.out.println(list);
	}
	

}

class Demo<T,X> {
	T rollNo;
	T[] rollArray ;
	X name;
	public Demo(T a , X b){
		this.rollNo = a;
		this.name = b;
	}
	public Demo(){
		
	}
	public T getRollNo(){
		return rollNo;
	}
	
	public void setRollNo(T rollNo){
		this.rollNo = rollNo;
	}
	
	public X getName(){
		return name;
	}
	
	public void setName(X name){
		this.name = name;
	}
	
	public T[] getRollArray(){
		System.out.println(rollArray);
		return rollArray;
	}
}

class MethodGenerics {
	public <T> void display(T a){
		System.out.println(a);
	}
	public <T> MethodGenerics(T a){
		System.out.println("Constructor"+ a);
	}
}
