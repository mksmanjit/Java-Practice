package foo;

public class SwitchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int i = 10;
		final int j;
		j = 20;
		switch (j) {
		case i:
			System.out.println(i);
			break;
		}
		SwitchDemo s = new SwitchDemo();
		System.out.println(s instanceof Object);
		int[][] a = {{1,2},{3,4}};
		for(int[] b: a){
			System.out.println(b[0]);
		}
	}

	
}

class A1{
	
}