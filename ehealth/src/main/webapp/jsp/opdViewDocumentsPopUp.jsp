<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registeredPatients.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

<!--main content placeholder starts here-->


<form name="viewDocumentsPopUp" method="post"	enctype="multipart/form-data">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="titleBg">
<h2>UPLOADED DOCUMENTS</h2>
</div>
<div class="clear"></div>

<%

				URL myURL=application.getResource("/WEB-INF/commonFile.properties");
				InputStream in = myURL.openStream();
				Properties prop = new Properties();
				prop.load(in);
			 	Box box=HMSUtil.getBox(request);
			 	
			 	
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	List<UploadDocuments>patientList=new ArrayList<UploadDocuments>();
				List<UploadDocuments>inpatientList=new ArrayList<UploadDocuments>();
			 	boolean noRecordFound=false;
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 		
			 	List<Patient> registeredPatientList = new ArrayList<Patient>();
			 	int counter=0;
			 	if(map.get("patientList")!=null)
				{
					patientList=(List<UploadDocuments>)map.get("patientList");	
				}
				if(map.get("inpatientList")!=null)
				{
					inpatientList=(List<UploadDocuments>)map.get("inpatientList");	
				}
			 	
				
				
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					noRecordFound=true;
					%>

<h4><span><%=message %></span></h4>

<%    
					   
					  }		 	
			 %>

<div class="clear"></div>
<input type="hidden" name="flag" value="view" id="flag" />
<div class="Block">
<%if(patientList!=null && patientList.size()>0){ 
%>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input name="hinNo" type="text"	value="<%=patientList.get(0).getHin().getHinNo()%>" class="readOnly"	readonly="readonly" />
<input name="hin" type="hidden"	value="<%=patientList.get(0).getHin().getId()%>" />
<label>Name</label>
<%if(patientList.get(0).getPatientName()!=null){ %>
<input	name="patientName" type="text"	value="<%=patientList.get(0).getPatientName()%>" class="readOnly"	readonly="readonly" /> <%}else{%>
<input name="patientName" type="text"	value="" class="readOnly" readonly="readonly" />
<%}%>
<label>Age</label>
<%if(patientList.get(0).getAge()!=null){ %>
<input name="age" type="text"	value="<%=patientList.get(0).getAge() %>" class="readOnly"	readonly="readonly" />
<%}else{%>
<input name="age" type="text" value=""	class="readOnly" readonly="readonly" />
<%} %>
<div class="clear"></div>
<label>Sex </label> <%if(patientList.get(0).getSex()!=null){ %>
<input	name="sex" type="text" value="<%=patientList.get(0).getSex() %>"	class="readOnly" readonly="readonly" />
<%}else { %>
<input name="sex"	type="text" value="" class="readOnly" readonly="readonly" />
<%} %>
<label>Address</label> <%if(patientList.get(0).getAddress()!=null){ %>
<input name="address"	type="text" value="<%=patientList.get(0).getAddress() %>"	class="readOnly" readonly="readonly" />
<%}else{ %>
<input	name="address" type="text" value="" class="readOnly"	readonly="readonly" />
<%} %>
<div class="clear"></div>
</div>

<!--Block Three Starts-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th>S.No.</th>
		<th>Upload Date</th>
		<th>File Name</th>
		<th>Document</th>
		<th>Description</th>
	</tr>
	<%} %>
	<%if(inpatientList!=null && inpatientList.size()>0){ 
		for(int i=0;i<inpatientList.size();i++){
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatientList.get(i).getUploadDate())%></td>
		<td><a
			href="opd?method=viewPatientDocuments&filename=<%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>&csrfTokenName=csrfTokenValue"><%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>
		</a></td>
		<td>/</td>
		<%if(inpatientList.get(i).getDescription()!=null){ %>
		<td><%=inpatientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}
	%>
	<%if(patientList!=null && patientList.size()>0){ 
		for(int i=0;i<patientList.size();i++){
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(patientList.get(i).getUploadDate())%></td>
		<td><a
			href="opd?method=viewPatientDocuments&filename=<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>&csrfTokenName=csrfTokenValue">
		<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>
		</a></td>
		<td>/</td>
		<%if(patientList.get(i).getDescription()!=null){ %>
		<td><%=patientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%	}
		}
	%>
</table>
<div class="clear"></div>

<div class="division"></div>

<input name="" type="button" class="button" value="Back"
	onClick="history.back();" /> <!--Bottom labels ends--></form>
<div class="clear"></div>

<div class="division"></div>
<!--main content placeholder ends here-->