package triplePoint.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import triplePoint.model.EmployeeTO;
import triplePoint.model.TaskTO;
import triplePoint.service.ScheduleCarWorkshop;

public class SchedulerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskTO t1 = new TaskTO("Car-Wash",100,2);
		TaskTO t2 = new TaskTO("Car-Repair", 1000, 5);
		TaskTO t3 = new TaskTO("Car-Paint", 1100, 4);
		List<TaskTO> l1 = new ArrayList<TaskTO>();  
        l1.add(t1);  
        l1.add(t2);  
        l1.add(t3);  
		
        
        List<TaskTO> l2 = new ArrayList<TaskTO>();  
        l2.add(t2);
        
        List<TaskTO> l3 = new ArrayList<TaskTO>();  
        l3.add(t2);
        l3.add(t3);
        
		 EmployeeTO e1 = new EmployeeTO("Joe", "Trainee");  
		 EmployeeTO e2 = new EmployeeTO("Smith", "Expert");  
		 EmployeeTO e3 = new EmployeeTO("Walker", "Employee");
		 
		 e1.setTaskTOList(l1);
		 e2.setTaskTOList(l2);
		 e3.setTaskTOList(l3);
		ScheduleCarWorkshop s1 = new ScheduleCarWorkshop();
		s1.setEmployeeTO(e1);
		
		ScheduleCarWorkshop s2 = new ScheduleCarWorkshop();
		s2.setEmployeeTO(e2);
		
		ScheduleCarWorkshop s3 = new ScheduleCarWorkshop();
		s3.setEmployeeTO(e3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(s1);
		executorService.submit(s2);
		executorService.submit(s3);
		
		while (!executorService.isTerminated()) {  
            executorService.shutdown();  
       } 
		
	}

}
