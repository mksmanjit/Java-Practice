package foo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Dog d = null;
		Collar c = new Collar(12);
		Dog d= new Dog(c,5);
		System.out.println(d.staticString);
		d.staticString="ManjitKumar";
		System.out.println("befor: collar size is "+ d.getCollar().getCollarSize());
		try{
			FileOutputStream fs = new FileOutputStream("testSer2.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			FileInputStream fis = new FileInputStream("testSer2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog) ois.readObject();
			System.out.println(d.staticString);
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: collar size is " + d.getCollar().getCollarSize());
	}

}

class Dog implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 2L;
	private  Collar theCollar;
	private static int dogSize;
	static String staticString="Manjit";
	public Dog(Collar collar,int size){
		theCollar = collar;
		dogSize = size;
	}
	
	public Collar getCollar(){
		return theCollar;
	}

}

class Collar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer collarSize;

	public Collar(int size) {
		collarSize = size;
	}

	public int getCollarSize() {
		return collarSize;
	}
}
