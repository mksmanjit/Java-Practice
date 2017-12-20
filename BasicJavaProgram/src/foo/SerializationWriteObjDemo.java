package foo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationWriteObjDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollarNew c = new CollarNew(3);
		DogNew d = new DogNew(c,5);
		DogNew d2 = null;
		CollarNew c1 = new CollarNew(30);
		DogNew d1 = new DogNew(c1,50);
		System.out.println("before: collar size is "+ d.getCollar().getCollarSize()+">>"+d.getDogSize());
		System.out.println("before: collar size is "+ d1.getCollar().getCollarSize()+">>"+d1.getDogSize());
		try{
			FileOutputStream fs = new FileOutputStream("testSer1.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.writeObject(d1);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			FileInputStream fis = new FileInputStream("testSer1.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			DogNew dog1 = null;
			while((dog1=(DogNew)ois.readObject()) != null){
				System.out.println("asdfadsafter: collar size is " + dog1.getCollar().getCollarSize()+">>"+dog1.getDogSize());
			}
			/*d = (DogNew) ois.readObject();
			d2 = (DogNew)ois.readObject();*/
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("after: collar size is " + d.getCollar().getCollarSize()+">>"+d.getDogSize());
		if (d2 != null) {
			System.out.println("after: collar size is "
					+ d2.getCollar().getCollarSize() + ">>" + d2.getDogSize());
		}
	}

}

class DogNew implements Serializable{
	private  CollarNew theCollar;
	private int dogSize;
	
	public DogNew(CollarNew collar,int size){
		theCollar = collar;
		dogSize = size;
	}
	
	public CollarNew getCollar(){
		return theCollar;
	}
	public int getDogSize(){
		return dogSize;
	}
	
	/*private void writeObject(ObjectOutputStream os){
		try{
			os.defaultWriteObject();
			os.writeInt(this.getDogSize());
			os.writeObject(theCollar);
			//os.writeInt(theCollar.getCollarSize());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream is){
		try{
			is.defaultReadObject();
			this.dogSize = is.readInt();
			theCollar = (CollarNew) is.readObject();
			//theCollar = new CollarNew(is.readInt());
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}

class CollarNew implements Serializable{
	private Integer collarSize;

	public CollarNew(int size) {
		collarSize = size;
	}

	public int getCollarSize() {
		return collarSize;
	}
}

