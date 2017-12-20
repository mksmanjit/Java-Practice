package triplePoint.service;

import java.util.List;

import triplePoint.model.EmployeeTO;

public class SchedulerImpl implements Scheduler {

	@Override
	public void startScheduleJob(List<EmployeeTO> employeeTOList) {
		ScheduleCarWorkshop scheduleCarWorkshop = new ScheduleCarWorkshop();
		//scheduleCarWorkshop.setEmployeeTOList(employeeTOList);
		Thread t1 = new Thread(scheduleCarWorkshop);
		t1.start();
	}

	
}
