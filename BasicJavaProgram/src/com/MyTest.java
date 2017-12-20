package com;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    public static void main( String[] args ) throws Exception {
        final List<String> myList1 = new ArrayList<String>();
        final List<String> myList2 = new ArrayList<String>(); 

        Thread threadA = new Thread("A") 
        { 
            public void run() 
            {
                myList1.add( "Thread A - 1" );
                synchronized(myList2) 
                { 
                    myList2.add( "Thread A - 2" );  
                } 
            } 
        }; 
            
        Thread threadB = new Thread("B") 
        {
            public void run() 
            {
                myList2.add( "Thread B - 1" );  
                synchronized(myList1) 
                {
                    myList1.add( "Thread B - 2" ); 
                } 
            } 
        }; 
        
        threadA.start();
        threadB.start();
        
        threadA.join();
        threadB.join();
        myList1.addAll( myList2 );
        
  System.out.println(myList1);    
    }
 
}

