package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
	
	public static void main(String args[]){
		List<Integer> a = null;
		ArrayList a1 = new ArrayList();
		a1.add("abc");
		List<Integer> s2= display(a1);
		Iterator<Integer> itr = s2.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	public static  List display(List<Integer> a){
		a.add(1);
		Iterator itr = a.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		return a;
	}

	

}

