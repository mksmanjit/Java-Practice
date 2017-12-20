package com;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class MethodReference {

	MethodReference(String s){
		System.out.println(s+"Inside Cons");
	}
	MethodReference(){
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Rock");
		list.add("Jock");
		list.add("Mock");
		list.forEach(MethodReference::new);
		list.forEach(new MethodReference()::print);
		newPrint(list);
		
	}
	public void print(String s){
		System.out.print(s);
	}
	public static void newPrint(List<String> list){
		Consumer<? super String> con = new MethodReference()::print;
		con.accept(list.get(0)+">>dfd");
		
	}

}
