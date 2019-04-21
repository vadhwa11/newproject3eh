package com.jkt.service.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jkt.hms.masters.business.StoreInternalIndentT;

public class IndentServicedaoImpl implements IndentServiceDao {
	 
	 @Autowired
	    private Session session;
	   
	private static final String Institute_Id="123";
	private static final String IndentNo="abc";  

	  @Transactional(value="transactionManager")
	public List<StoreInternalIndentT> getAllItem(String instituteId,
			String indentNo) {
		 
		  //local variables
		  List<StoreInternalIndentT> indentTs=null;
		  
	        if(null != instituteId && instituteId.equalsIgnoreCase(Institute_Id) && null != indentNo && indentNo.equalsIgnoreCase(IndentNo)){
	 
	            // get all items info from database
	        	indentTs = session.createCriteria(StoreInternalIndentT.class).list();
	        	System.out.println("in Dao"+indentTs.size());
	        }
	        return indentTs;
	}
	
	

}