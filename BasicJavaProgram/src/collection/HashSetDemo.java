package collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HashSetDemo {
public static final Object PRESENT = new Object(); 
	public static void main(String[] args) {
		Object obj1 = PRESENT;
		Runtime r = Runtime.getRuntime();
		System.out.println(r.freeMemory());
		List<Object> obj = new ArrayList<>();
		obj.add(PRESENT);
		System.out.println(r.freeMemory());
		obj.add(PRESENT);
		System.out.println(r.freeMemory());
		obj.add(PRESENT);
		System.out.println(r.freeMemory());
		obj.add(PRESENT);
		System.out.println(r.freeMemory());
		obj.add(PRESENT);
		System.out.println(r.freeMemory());
		for(int i=0;i<10000;i++)
		obj.add(new Object());
		System.out.println(r.freeMemory());
		
		
	}

}
