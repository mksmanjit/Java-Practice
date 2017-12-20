package foo;

import java.util.HashSet;
import java.util.Set;

class Parent {
    protected HashSet<Integer> mySet = new HashSet<Integer>();
    public Parent() {
        mySet.add( 10 );
    }

    public Set<Integer> getSet() {
        return mySet;
    }
}

class Child extends Parent {
    public Child( Integer val ) {
        mySet.add( 10 );
    }

    public HashSet<Integer> getSet() {
        return mySet;
    }

         public static void main( String[] args ) throws Exception {
             Parent obj = new Child( 20 );
             System.out.println( obj.getSet() );
    }	
}

