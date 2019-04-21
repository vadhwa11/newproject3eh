<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Dipali
 * Create Date: 21 Nov,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String url1="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	
	int sampleCollectionHeaderId = 0,orderId=0;
	if (map.get("newSampleId") != null) {
		sampleCollectionHeaderId = (Integer)map.get("newSampleId");
	}
	if (map.get("orderId") != null) {
		orderId = (Integer)map.get("orderId");
	}
	//added by govind 03-05-2017
		int modalityId=0,pendSampleId=0,pendOrderid=0;
		if (map.get("modalityId") != null) {
			modalityId = (Integer) map.get("modalityId");
		}
		if (map.get("pendSampleId") != null) {
			pendSampleId = (Integer) map.get("pendSampleId");
		}
		if (map.get("pendOrderid") != null) {
			pendOrderid = (Integer) map.get("pendOrderid");
		}
		int pendButShow=0;
		if(modalityId>0 && pendSampleId>0 && pendOrderid>0){
			pendButShow=1;
		}
			//added by govind 03-05-2017 end
			
		//added by govind 12-07-2017	
		Integer pendHeaderId=0,pendSubChargeId=0;
		if(map.get("pendHeaderId")!=null){
			pendHeaderId=(Integer)map.get("pendHeaderId");
		}
		if(map.get("pendSubChargeId")!=null){
			pendSubChargeId=(Integer)map.get("pendSubChargeId");
		}
		Integer nextHeaderId=0,nextSubChargeId=0;
		 
		 if(map.get("nextHeaderId")!=null){
			 nextHeaderId=(Integer)map.get("nextHeaderId");
			}
			if(map.get("nextSubChargeId")!=null){
				nextSubChargeId=(Integer)map.get("nextSubChargeId");
			}
	/*System.out.println("jsp nextHeaderId "+nextHeaderId+" nextSubChargeId "+nextSubChargeId);
	System.out.println("jsp pendHeaderId "+pendHeaderId+" pendSubChargeId "+pendSubChargeId);
	System.out.println("submit jsp sampleCollectionHeaderId "+sampleCollectionHeaderId);*/
	//added by govind 12-07-2017 end
%>
<form name="message" method="post">
<input type="hidden" name="modalityId" value="<%=modalityId%>"/>
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="sampleCollectionHeaderId" value="<%=sampleCollectionHeaderId %>" /> 
<input type="hidden" name="orderIdP" value="<%=orderId %>" /> 
<input type="hidden" name="pendSampleId" value="<%=pendSampleId %>" /> 
<input type="hidden" name="pendOrderid" value="<%=pendOrderid %>" /> 
<input type="button" class="button" value="Back"	onClick="submitForm('message','<%=url%>');" /> 
<!-- added & commented by govind 12-07-2017 -->
<%--<input type="button"	class="button" name="next" value="NextPatient"	onclick="submitForm('message','/hms/hms/lab?method=nextForSampleValidation&pendVar=N');" /> --%>
<%if(nextHeaderId>0 && nextSubChargeId>0){%>
<input type="button"	class="button" name="next" value="NextPatient"	onclick="submitForm('message','/hms/hms/lab?method=searchPatientForValidation&orderId=<%=nextHeaderId%>,<%=nextSubChargeId%>&modalityId=0');" />
<%} %> 
<%--<%if(pendButShow==1){%>
<input type="button" class="button" name="pendValid" value="PendingValidation"	onclick="submitForm('message','/hms/hms/lab?method=nextForSampleValidation&pendVar=Y');" />
<%} %> --%>
<%if(pendSubChargeId>0){%>
<input type="button" class="button" name="pendValid" value="PendingValidation"	onclick="submitForm('message','/hms/hms/lab?method=searchPatientForValidation&orderId=<%=pendHeaderId%>,<%=pendSubChargeId%>&modalityId=0');" />
<%} %> 
<!-- added & commented by govind 12-07-2017 -->
<input type="button" class="buttonBig2" value="Pending Result Entry"	onClick="submitForm('message','<%=url1%>');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>