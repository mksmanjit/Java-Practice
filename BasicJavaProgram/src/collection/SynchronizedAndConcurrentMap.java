package collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedAndConcurrentMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = Collections.synchronizedMap(new ConcurrentHashMap<String,String>());
		map.put("Rome", "Rome");
		map.put("Apple", "Apple");
		map.put("Mango", "Mango");
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		Iterator<String> itr1 = map.keySet().iterator();
		while(itr1.hasNext()){
			System.out.println("Remove>>"+map.remove("Rome"));
			System.out.println(itr1.next());
		}
		/*Map<String,String> map = new Hashtable();
		map.put("Rome", "Rome");
		map.put("Apple", "Apple");
		map.put("Mango", "Mango");
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()){
			System.out.println("Remove>>"+map.remove("Rome"));
			System.out.println(itr.next());
		}*/
	}

}


