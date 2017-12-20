package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File f = new File("abc.txt");
		f.createNewFile();
		try(BufferedReader br = new BufferedReader(new FileReader(f)){
			public void close(){
				System.out.println("Mehtod Closed");
				throw new NullPointerException();
			}
		}){
			throw new ArrayIndexOutOfBoundsException();
		} catch(Exception e){
			Throwable th = new Throwable();
			System.out.println(th.getSuppressed()[0]);
			
		}
		
	}

}
