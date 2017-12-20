package foo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	static int  size = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new LinkedHashMap<String,String>(){
			protected boolean removeEldestEntry(Map.Entry<String,String> eldest){
				return size() > size;
			}
		};
		map.put("A", "Manjit");
		map.put("B", "Manjit");
		map.put("C", "Manjit");
		System.out.println(map+">>"+map.get("A"));
	}

}
