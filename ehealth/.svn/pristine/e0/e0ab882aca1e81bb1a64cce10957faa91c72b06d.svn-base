package jkt.hms.util;

import java.util.Comparator;

import jkt.hms.masters.business.base.BaseMasScheme;

public class ComaparatorForScheme  implements Comparator<BaseMasScheme> {

    public int compare(BaseMasScheme obj1, BaseMasScheme obj2) {
    	if(obj1.getPriority()!=null && obj2.getPriority()!=null)
    		return obj1.getPriority().compareTo(obj2.getPriority());
    	else
    		return obj1.getId().compareTo(obj2.getId());
    }
}  
