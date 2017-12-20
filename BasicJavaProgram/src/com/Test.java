package com;

import java.util.HashMap;
import java.util.Map;

class ClassA {

    private int fieldX;
    private int fieldY;
    private Map<String, String> keyValues;
    public ClassA( int fieldX, int fieldY, Map<String, String> keyValues ) {
        super();
        this.fieldX = fieldX;
        this.fieldY = fieldY;
        this.keyValues = keyValues;
    }

    @Override
    public String toString() {
        return "ClassA [fieldX=" + fieldX + ", fieldY=" + fieldY + ", keyValues=" + keyValues + "]";
    }

}

class ClassB implements Cloneable {

    private ClassA classA;
    public ClassB( ClassA classA ) {
        super();
        this.classA = classA;
    }

    @Override
    public String toString() {
        return "ClassB [classA=" + classA + "]";
    }

    @Override
    protected ClassB clone() throws CloneNotSupportedException {
        return (ClassB) super.clone();
    }

} 

class Test {
	public static void main( String[] args ) throws Exception {
        /*Map<String, String> keyValues = new HashMap<String, String>();
        keyValues.put( "X", "20" );
        keyValues.put( "Y", "30" );

        ClassB classB = new ClassB( new ClassA( 20, 30, keyValues ) );
        ClassB cloneClassB = classB.clone();

     System.out.println( cloneClassB );*/
		
		/*Map<String,String> myList = new ConcurrentHashMap<String,String>();
        myList.put( "Pune","Pune" );
        myList.put( "Vizag","Vizag" );
        myList.put( "Hyderabad","Hyderabad" );
        Iterator itr = myList.keySet().iterator();
        String a[] = new String[3];
        a[0] = "Manjit";
        a[1] = "Sanju";
        a[2] = "Sonu";
        String b[] = a;
        System.out.println(a[0]+">>"+b[0]);
        b[0]="Call";
        System.out.println(a[0]+">>"+b[0]);*/
        /*for ( ; itr.hasNext(); ) {
            String myObject = (String) itr.next();
            System.out.println( myObject );*/
            //if ( "Hyderabad".equals( myObject ) ) {
               // myList.remove( myObject ); 
//can throw ConcurrentModificationException in single as
                //well as multi-thread access situations.
           // }
       // }
		Map<Object,Object> map =new HashMap<Object,Object>();
		map.put("abc", "def");
		String s="abc";
		System.out.println(map.get(s));
		StringClass c = new StringClass("manjit");
		map.put(c, "XYZ");
		StringClass c1 = new StringClass("manjit");
		System.out.println(map.get(c1));
		
    }
}

class StringClass{
	
	String s="manjit";
	
	StringClass(String s){
		//this.s=s;
	}
	
	public boolean equals(Object a){
		StringClass a1 = (StringClass)a;
		if(this.s==a1.s){
			return true;
		}else
			return false;
	}
}

