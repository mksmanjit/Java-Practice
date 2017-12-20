package carworkshop.model;

import java.util.List;

import carworkshop.taskstrategy.TaskPriority;

public class Employee {
	/**
	 * Holds the name of the employee.
	 */
	private String empName;
	/**
	 * Holds the designation of employee.
	 */
	private String empDesignation;
	/**
	 * Holds the task to be done by employee.
	 */
	private List<Task> taskList;
	
	public Employee(String empName, String empDesignation) {
		super();
		this.empName = empName;
		this.empDesignation = empDesignation;
	}
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
	/**
	 * @return the empDesignation
	 */
	public String getEmpDesignation() {
		return empDesignation;
	}
	/**
	 * @param empDesignation the empDesignation to set
	 */
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	/**
	 * @return the taskList
	 */
	public List<Task> getTaskList() {
		return taskList;
	}
	/**
	 * @param taskList the taskList to set
	 */
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

}
