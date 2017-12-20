package equal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualDemo {

	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<>();
		Emp emp = new Emp();
		emp.setEmpName("Manjit");
		Emp emp1 = new ChildEmp();
		emp1.setEmpName("Manjit");
		if(emp.equals(emp1)){
			System.out.println("equal");
		}
		empList.add(null);
		empList.add(null);
		//empList.add(null);
		//empList.add(null);
		//Collections.sort(empList);
		System.out.println(empList);

	}

}


class Emp implements Comparable<Emp>{
	private String empName;

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public boolean equals(Object obj){
		
		if(obj==null){
			return false;
		}
		
		if(!(obj instanceof Emp)){
			return false;
		}
		if(obj.getClass() == this.getClass()){
			System.out.println("class not equal");
			return false;
		}
		if(obj==this){
			return true;
		}
		Emp emp = (Emp)obj;
		return this.empName.equals(emp.getEmpName());
	}

	@Override
	public int compareTo(Emp o) {
		return this.empName.compareTo(o.getEmpName());
	}
}

class ChildEmp extends Emp{
	
}