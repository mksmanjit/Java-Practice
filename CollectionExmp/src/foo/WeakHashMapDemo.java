package foo;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		Map weakHashMap = new WeakHashMap();
		Map hashMap = new HashMap();
		String keyHashMap = new String("keyHashMap");
		String keyWeakHashMap = new String("keyWeakHashMap");
		Integer t =10;
		hashMap.put(keyHashMap, "Ankita");
		hashMap.put(t, "Ankita1");
		weakHashMap.put(keyWeakHashMap, "Atul");
		System.gc();
		System.out.println("Before: hash map value:"
				+ hashMap.get("keyHashMap") + " and weak hash map value:"
				+ weakHashMap.get("keyWeakHashMap")+">>"+weakHashMap.get(10));

		keyHashMap = null;
		keyWeakHashMap = null;
		t=null;

		System.gc();

		System.out.println("After: hash map value:" + hashMap.get("keyHashMap")
				+ " and weak hash map value:"
				+ weakHashMap.get("keyWeakHashMap")+">>"+weakHashMap.get(10));
	}

}
