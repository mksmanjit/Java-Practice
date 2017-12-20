package collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Map<Emp,Emp> map = new ConcurrentHashMap<>();
		Emp e1 = new Emp();
		e1.setName("A");
		e1.setLast("1");
		Emp e2 = new Emp();
		e2.setName("A");
		e2.setLast("2");
		Emp e3 = new Emp();
		e3.setName("C");
		e3.setLast("3");
		Emp e4 = new Emp();
		e4.setName("D");
		e4.setLast("4");
		Emp e5 = new Emp();
		e5.setName("E");
		e5.setLast("5");
		Emp e6 = new Emp();
		e6.setName("F");
		e6.setLast("6");
		Emp e7 = new Emp();
		e7.setName("G");
		e7.setLast("7");
		Emp e8 = new Emp();
		e8.setName("H");
		e8.setLast("8");
		Emp e9 = new Emp();
		e9.setName("I");
		e9.setLast("9");
		Emp[] empArray = {e1,e2,e3,e4,e5,e5,e7,e8,e9};
		int i =0;
		/*map.put(e1, e1);
		map.put(e2, e2);
		map.put(e3, e3);
		map.put(e4, e4);
		map.put(e5, e5);
		map.put(e6, e6);
		map.put(e7, e7);
		map.put(e8, e8);
		map.put(e9, e9);*/
		ThreadDemo thread1 = new ThreadDemo(map,empArray,i);
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread1);
		Thread t3 = new Thread(thread1);
		Thread t4 = new Thread(thread1);
		Thread t5 = new Thread(thread1);
		Thread t6 = new Thread(thread1);
		Thread t7 = new Thread(thread1);
		Thread t8 = new Thread(thread1);
		Thread t9 = new Thread(thread1);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
		Thread.sleep(1000);
		
		System.out.println(map);
		
	}

}

class ThreadDemo implements Runnable{
	Map<Emp,Emp> map = null;
	Emp[] empArray;
	int i;
	ThreadDemo(Map<Emp,Emp> map, Emp[] empArray, int i){
		this.map = map;
		this.empArray = empArray;
		this.i=i;
	}
	public void run(){
		Emp emp;
		map.put((emp = empArray[i++]), emp);
	}
}

class Emp{
	private String name;
	private String last;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object obj){
		Emp s = (Emp)obj;
		return this.name.equalsIgnoreCase(s.getName());
	}
	
	public int hashCode(){
		return this.name.hashCode();
	}
	public String toString(){
		return this.name+">>"+this.last;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}
}
