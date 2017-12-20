package doc;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comp comp = new Comp();
		Set<A> a = new TreeSet<A>(comp);
		a.add(new A("manjit"));
		a.add(new A("manjit1"));
		a.add(new A("manjit"));
		System.out.println(a);

	}

}

class A{
	private String s = null;
	A(String s){
		this.setS(s);
	}
	public String toString(){
		return s;
	}
	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}
}

class Comp implements Comparator<A>{
	public int compare(A a1,A a2){
		if(a1.getS().compareTo(a2.getS()) > 0){
			return 1;
		}else if(a1.getS().compareTo(a2.getS()) < 0){
			return -1;
		} 
			return 0;
	}
}
