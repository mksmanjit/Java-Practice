package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaFeatures {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("B");
		list.add("A");
		list.add("D");
		list.add("C");
		System.out.println(list);
		/*Map<String,String> map = list.stream().collect(Collectors.toMap(string -> string,string -> JavaFeatures.getValue()));
		System.out.println(map);*/
		/*Map<String,String> map = new LinkedHashMap<>();
		map.put("A", "A");
		map.put("B", "A");
		map.put("C", "A");
		map.put("D", "A");*/
		Comparator<String> com = (a,b) -> a.compareTo(b);
		Collections.sort(list,com);
		System.out.println(list);
		
		
		
		
		
		/*MathOperation add = (x,y)->x+y;
		MathOperation mul = (int x,int y) -> {return x*y;};
		GreetingService greeting = message -> System.out.println(message);
		operate(10,20,add);
		greeting.sayGreeting("Manjit");*/

	}
	
	interface MathOperation{
		int operation(int a , int b);
	}

	interface GreetingService{
		void sayGreeting(String message);
	}
	
	private static int operate(int a, int b,MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}

	public static String getValue(){
		return "Hello";
	}
	
}




