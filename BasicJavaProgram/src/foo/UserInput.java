package foo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UserInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in);
		//String val = bf.readLine();
		//System.out.println(val);
		
		File f = new File("myfile.txt");
		PrintWriter p = new PrintWriter(f);
		p.println("Manjit Kumar");
		p.println("Sanju Singh");
		p.flush();
		p.close();
	}

}
