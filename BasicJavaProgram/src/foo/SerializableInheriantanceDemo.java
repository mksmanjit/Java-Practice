package foo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableInheriantanceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat c = new Cat(10,"Manjit");
		c.staticValue = 50;
		System.out.println("Before:"+c.getWeight()+">>"+c.getName()+">>"+c.staticValue);
		try{
			FileOutputStream fs = new FileOutputStream("cat.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(c);
			os.close();
		}catch(Exception e){
			e.printStackTrace();;
		}
		
		try{
			FileInputStream fis = new FileInputStream("cat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			c= (Cat)ois.readObject();
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("After:"+c.getWeight()+">>"+c.getName()+">>"+c.staticValue);
	}

}
class Animal{
	int weight = 42;
	public Animal() {
		System.out.println("Animal Constructor");
		// TODO Auto-generated constructor stub
	}
}
class Cat extends Animal implements Serializable{
	static int staticValue = 20;
	static Animal a = new Animal();
	String name;
	Cat(int w,String n){
		System.out.println("Cat Constructor");
		weight = w;
		name = n;
	}
	public int getWeight(){
		return weight;
	}
	public String getName(){
		return name;
	}
}