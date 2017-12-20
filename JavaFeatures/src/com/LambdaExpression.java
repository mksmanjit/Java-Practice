package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaExpression {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("A");
		list.add("D");
		list.add("E");
		Function f = new Function<String,String>(){
			public String apply(String s){
				if(s.equalsIgnoreCase("A"))
				return "ABC";
				return "XYZ";
				
			}
		};
		System.out.println(list.parallelStream().map(f).findFirst().get());
		System.out.println(list.parallelStream().filter(l->l.equalsIgnoreCase("A")).count());
		Map<Emp,String> x=list.parallelStream().filter(l->l.equalsIgnoreCase("A")).collect(Collectors.toMap(LambdaExpression::getName, l->l));
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println(numbers.parallelStream().max((a,b)->a.compareTo(b)).orElse(0));
		System.out.println(numbers.parallelStream().sorted().collect(Collectors.toList()));
		System.out.println(x);
		
		
	}
	
	public static Emp getName(String s){
		Emp emp = new Emp();
		emp.setName("X");
		if( s.equalsIgnoreCase("A")){
			emp.setName(s);
			return emp;
		}
		return emp;
	}

}

class Emp{
	
	private String name;

	public String toString(){
		return this.name;
	}
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
}
