package triplePoint.service;

import java.util.List;

import triplePoint.model.EmployeeTO;
import triplePoint.model.TaskTO;

public class ScheduleCarWorkshop implements Runnable{
	private EmployeeTO employeeTO = null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
			List<TaskTO> taskTOList = PriortyScheduler.getPriorityList(getEmployeeTO().getTaskTOList());
			for(TaskTO taskTO : taskTOList){
				System.out.println(getEmployeeTO().getEmpName()+">>"+taskTO.getTaskName()+">>"+taskTO.getTimeTake());
			}
		
	}
	public EmployeeTO getEmployeeTO() {
		return employeeTO;
	}
	public void setEmployeeTO(EmployeeTO employeeTO) {
		this.employeeTO = employeeTO;
	}
	
	
	

}
