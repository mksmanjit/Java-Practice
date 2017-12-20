package dataPartioning;

import java.io.BufferedReader;
import java.io.IOException;

public class Partition {
	
	public static void main(String[] args){
		System.out.println("Menu: ");
		System.out.println("1. Add rows");
		System.out.println("2. Partition");

		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));

		
		try {
			int option = Integer.parseInt((r.readLine()));
			switch(option){
			case 1: System.out.println("adding rows...");
					break;
			case 2: System.out.println("\nChoose Partionting Type:");
					System.out.println("1. Attribute");
					System.out.println("2. Range");
					System.out.println("3. Round Robin");
					option = Integer.parseInt(r.readLine());
					switch(option){
					case 1: System.out.println("partitioning according to attribute");
							break;
					case 2:System.out.println("partitioning according to attribute");
							break;
					case 3: System.out.println("partitioning according to attribute");
							break;
					default: System.out.println("wrong Option!!");				
					}
					break;
			default: System.out.println("wrong Option!!");				

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
