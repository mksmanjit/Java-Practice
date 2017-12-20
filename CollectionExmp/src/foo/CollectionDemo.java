package foo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Set<String> s = new LinkedHashSet<String>();
		System.out.println(s.add("A"));
		System.out.println(s.add("B"));
		System.out.println(s.add("C"));
		//System.out.println(s.remove("B"));
		Iterator<String> itr = s.iterator();
		System.out.println();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		//Queue q = new PriorityQueue<CollectionDemo>();
		//q.add(null);
		//q.add(new CollectionDemo());
		/*Set treeSet = new TreeSet();
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(1);
		treeSet.add(4);*/
		
		//treeSet.add(new CollectionDemo());
		/*Map<String,String> s = new LinkedHashMap<String,String>();
		System.out.println(s.put("A","A"));
		System.out.println(s.put("B","A"));
		System.out.println(s.put("C","A"));
		//System.out.println(s.remove("B"));
		System.out.println(s.values());
		Iterator<String> itr = s.keySet().iterator();
		System.out.println();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		/*int n = 17 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);*/
		A a = new A();
	}
	

}
class A{
	A(){System.out.println("A");}
	B b = new B();
}

class B{
	B(){System.out.println("B");}
	A a = new A();
}