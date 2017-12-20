package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPuzzle {
	public static void main(String args[]) {
		List<String> circus1 = new ArrayList<String>();
		circus1.add("Monkey");
		circus1.add("Elephant");

		List<String> zoo1 = new ArrayList<String>(circus1);
		zoo1.add("Lion");
		System.out.println("zoo1 size: " + zoo1.size());

		String[] circus2 = { "Monkey", "Elephant" };

		/*List<String> zoo2 = Arrays.asList(circus2);
		zoo2.add("Tiger");
		System.out.println("zoo2 size: " + zoo2.size());*/
		
		double d = 0.1d;
		for (int i = 0; i < 8; i++) {
    		d = d + 0.1d;
		}
		System.out.println(d);
	}

}
