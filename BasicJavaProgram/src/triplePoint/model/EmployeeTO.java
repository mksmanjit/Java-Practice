package triplePoint.model;

import java.util.List;

public class EmployeeTO {
	private String empName;
	private String empDesig;
	private List<TaskTO> taskTOList = null;
	
	
	public EmployeeTO(String empName, String empDesig) {
		super();
		this.empName = empName;
		this.empDesig = empDesig;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesig() {
		return empDesig;
	}
	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}
	public List<TaskTO> getTaskTOList() {
		return taskTOList;
	}
	public void setTaskTOList(List<TaskTO> taskTOList) {
		this.taskTOList = taskTOList;
	}

}
