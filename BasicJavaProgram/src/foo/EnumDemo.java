package foo;

enum CoffeSize {
	BIG(10,"B"), HIGH(20,"H"), OVERWHELLIMNG(30,"O"){
		public String getLid(){
			return "OV";
		}
	};

	CoffeSize(int size,String lid) {
		this.size = size;
		this.lid = lid;
	}

	int size;

	public int getSize() {
		return size;
	}
	
	String lid;
	public String getLid(){
		return lid;
	}
	
}
public class EnumDemo {
	CoffeSize cofee;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumDemo demo = new EnumDemo();
		demo.enumDemo();
	}
	public void enumDemo(){
		cofee = CoffeSize.OVERWHELLIMNG;
		System.out.println(cofee.getSize()+">>"+cofee.getLid());
	}

}
