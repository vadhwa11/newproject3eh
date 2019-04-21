package jkt.hms.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import jkt.hms.masters.business.DgSampleCollectionDetails;

public class DiagNoComparator implements Comparator{
	public int compare(Object o1,Object o2){  
		Object[] s1=(Object[])o1;  
		Object[] s2=(Object[])o2;  
		  int no1=Integer.parseInt((String)s1[2]);
		  int no2=Integer.parseInt((String)s2[2]);
		if(no1==no2)  
		return 0;  
		else if(no1>no2)  
		return 1;  
		else  
		return -1;  
		}  
}
