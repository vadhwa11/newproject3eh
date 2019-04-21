package jkt.hms.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Visit;

public class QueueManagement {
	
	Map map=null;
	static String departQueueName="";
	static int departmentId;
	static long totalhospitalvisit;
	
	public static long getTotalhospitalvisit() {
		return totalhospitalvisit;
	}


	public static void setTotalhospitalvisit(long totalhospitalvisit) {
		QueueManagement.totalhospitalvisit = totalhospitalvisit;
	}



	static Map<Integer,Object> departQueueMap=new HashMap<Integer,Object>();
	static Map<Integer,Map<Integer,Object>> QueueMap=new HashMap<Integer,Map<Integer,Object>>();

	public static Map<Integer, Map<Integer, Object>> getQueueMap() {
		return QueueMap;
	}






	public static void setQueueMap(Map<Integer, Map<Integer, Object>> queueMap) {
		QueueMap = queueMap;
	}



	static MasDepartment department=new MasDepartment();
	
	/**
	 * @param departmList
	 * @return
	 */
	public synchronized static Map<Integer,Map<Integer,Object>> getDepartmentByHospital(MasDepartment depart,int hospitalId){
		department=depart;
		
		
			departQueueName=department.getDepartmentName();
			departmentId=department.getId();
			
			System.out.println("departQueueName "+departQueueName);
			System.out.println("departmentId "+departmentId);
			
			Comparator<Visit> comparator=new QueueManagComparator();
			
			PriorityBlockingQueue<Visit> departQueueName = new PriorityBlockingQueue<Visit>(100,comparator);
			
			if(null!=departQueueMap && !departQueueMap.isEmpty()){
				if(!departQueueMap.containsKey(departmentId) && !departQueueMap.containsKey(departQueueName)){
					
					departQueueMap.put(departmentId, departQueueName);
					QueueMap.put(hospitalId, departQueueMap);
				}
			}
			else{
				departQueueMap.put(departmentId, departQueueName);
				QueueMap.put(hospitalId, departQueueMap);
			}
			
			
			return QueueMap;
		}
		
		
		
	
	
	
	/** Method for generate Queue 
	 * @param departId
	 * @param priority
	 * @param tokenNumber
	 */
	public synchronized static void generateQueueForDepartment(int hospitalId,int departId,int priority,int tokenNumber,int uhinNo,long totalHospitalVisitNo,Visit visit){
		System.out.println("hospitalId "+hospitalId);
		System.out.println("departId "+departId);
		System.out.println("priority "+priority);
		System.out.println("tokenNumber "+tokenNumber);
		System.out.println("uhinNo "+uhinNo);
		
		Visit visitQueue= new Visit();
		visitQueue=visit;
		
		PatientVisitBean patientBean=new PatientVisitBean(hospitalId,departId,tokenNumber,priority,uhinNo,totalHospitalVisitNo);
		departQueueMap=QueueMap.get(hospitalId);
		
		PriorityBlockingQueue<Visit> departQueueName=(PriorityBlockingQueue<Visit>) departQueueMap.get(departId);
		
		departQueueName.add(visitQueue);
		
		System.out.println("Queuing System"+departQueueName.size());
		/*System.out.println(departQueueName.poll());*/
		
	}
	
	public static Map<Integer, Object> getDepartQueueMap() {
		return departQueueMap;
	}

	public static void setDepartQueueMap(Map<Integer, Object> departQueueMap) {
		QueueManagement.departQueueMap = departQueueMap;
	}


	public static MasDepartment getDepartment() {
		return department;
	}



	public static void setDepartment(MasDepartment department) {
		QueueManagement.department = department;
	}

	


}
