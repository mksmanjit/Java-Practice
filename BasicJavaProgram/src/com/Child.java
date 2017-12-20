package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class Parent {
    protected HashSet<Integer> mySet = new HashSet<Integer>();
    public Parent() {
        mySet.add( 10 );
    }

    public Set<Integer> getSet() {
        return mySet;
    }
}

public class Child extends Parent {
    public Child( Integer val ) {
        mySet.add( 10 );
    }

    public HashSet<Integer> getSet() {
        return mySet;
    }

         public static void main( String[] args ) throws Exception {
            /* Parent obj = new Child( 20 );
             System.out.println( obj.getSet() );
             List<Integer> a1 = new ArrayList<Integer>();
             Integer a[] = new Integer[3];
             a[0] = 1;
             a1.add(10);
             a1.add(20);*/
             //varargs(a);
        	 final TreeMap<MyKey, String> myTreeMap = new TreeMap<MyKey, String>();
        	 myTreeMap.put( new MyKey(10, 20), "10-20" );
        	 myTreeMap.put( new MyKey(10, 20), "10-20" );
        	 myTreeMap.put( new MyKey(1, 2), "1-2" );

        	System.out.println(myTreeMap.get( new MyKey(1, 2) ));

    }	
         
    
}

final class  MyKey {
    int x;
    int y;
    public MyKey(int x, int y) {
        this.x = x;
        this.y = y;
    }


}


