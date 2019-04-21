<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<body  />
<script>
	function checkMedFitness(link)
	{
	if(document.message.medFit.checked == true && document.message.docSubmitted.checked == true)
 		{
 		location.href = link ;
 		} 
 	else
 		{
 		alert('Please be ensure whether applicant is medically fit and have submitted all documents');
		}
	}
</script>

<div class="clear"></div>

<form name="message" action="" method="post"  >

<%  
Map<String, Object> map=new HashMap<String, Object>();
		List link = null;
		String linkText = "";
		String linkUrl = "";
		String message1 = "There were no message specified.";
		String message2 = null;
		String recommandFlag = "n";
	    String urlYes = "/intranet/jkt/indext";
	    String urlNo = "/intranet/jkt/indext";
	    map=(Map<String, Object>)request.getAttribute("map");	
	    Integer resumeId = null;
	    Integer statusId = 0;
	    String msgArr[] = null;
	    String linkGenerateOfferLetter = "";
	    String linkGenerateAppointmentLetter = "";
	    if(!map.isEmpty()){
	    	if(map.get("message")!=null)
	    		 msgArr = (String[])map.get("message");
	    	
	    	 if(map.get("resumeId")!=null)
	   		 	resumeId = (Integer)map.get("resumeId");
	    	 
	    	 if(map.get("statusId")!=null)
	    	 	statusId = (Integer)map.get("statusId");
	    	 
	   		if(msgArr!=null && msgArr.length>0)
	   			message1 = msgArr[0];
	   		else if(map.get("message1")!=null)
	   			message1 = (String)map.get("message1");
	   		
	   		if(msgArr!=null && msgArr.length>1)
	   			message2 = msgArr[1];
	   		else if(map.get("message2")!=null)
	   			message2 = (String)map.get("message2");
			
			linkGenerateOfferLetter = "/hms/hrms/resume?method=generateLetter&letterType=offerLetter&"+RequestConstants.RESUMEID +"="+ resumeId;
			linkGenerateAppointmentLetter = "/hms/hrms/resume?method=generateLetter&letterType=appointmentLetter&"+RequestConstants.RESUMEID +"="+ resumeId;
			
		}
	    String AddressOnLeave="";
	    String reason="";
	    Date dateOfBirth=null;
	    Date dateOfJoin=null;
	    String employeeName="";
	    
	    Date jspFromDate=null;
	    Date jspToDate=null;
	    String LeaveTypeName="";
	    
	    if(map!=null && null !=map.get("jspFromDate")){
	    	jspFromDate=(Date)map.get("jspFromDate");
	    }
	    
	    if( map!=null && null !=map.get("jspToDate")){
	    	jspToDate=(Date)map.get("jspToDate");
	    }
	    
	    if( map!=null &&  null !=map.get("LeaveTypeName")){
	    	LeaveTypeName=(String)map.get("LeaveTypeName");
	    }
	    
	    if( map!=null &&  null !=map.get("recommandFlag")){
	    	recommandFlag=(String)map.get("recommandFlag");
	    }
	    
	    
	    if(map!=null &&  null !=map.get("employeeName")){
	    	employeeName=(String)map.get("employeeName");
	    }
 		if( map!=null &&  null !=map.get("dateOfJoin")){
 			dateOfJoin=(Date)map.get("dateOfJoin");
	    }
 		if(map!=null &&  null !=map.get("dateOfBirth")){
 			dateOfBirth=(Date)map.get("dateOfBirth");
 		}
		 if(map!=null &&  null !=map.get("reason")){
		 reason=(String)map.get("reason");
	 	}
		 if(map!=null &&  null !=map.get("AddressOnLeave")){
			 AddressOnLeave=(String)map.get("AddressOnLeave");
		 	}
		
			long suffixDaysNo=0;
			long prefixDaysNo=0;
			int empId=0;
			boolean messagestatus=false;
			
			 if(map!=null &&  null !=map.get("suffixDaysNo")){
				 suffixDaysNo=(Integer)map.get("suffixDaysNo");
			 	}
			 if(map!=null &&  null !=map.get("prefixDaysNo")){
				 prefixDaysNo=(Integer)map.get("prefixDaysNo");
			 	}
			 if(map!=null && null !=map.get("messagestatus")){
				 messagestatus=(Boolean)map.get("messagestatus");
			 	}
			 
			 if(map!=null && null !=map.get("empId")){
				 empId=(Integer)map.get("empId");
			 	}
			 
			 String postheld="";
			  String department="";
			  
			  if(map!=null && null !=map.get("postheld")){
				  postheld=(String)map.get("postheld");
				 	}
				 if(map!=null && null !=map.get("department")){
					 department=(String)map.get("department");
				 	}
	    
	%>
<h4><%=message1%> &nbsp;&nbsp;</h4>
<% if(message2!= null){ %>
<input type="hidden"	name="employeeName" value="<%=employeeName %>"  ></input>
<input type="hidden"	name="reason" value="<%=reason %>"  	></input>
<input type="hidden"	name="dateOfBirth" value="<%=dateOfBirth %>"  	></input>
<input type="hidden"	name="dateOfJoin" value="<%=dateOfJoin %>"  ></input>
<input type="hidden"	name="AddressOnLeave" value="<%=AddressOnLeave %>"  ></input>
<input type="hidden"	name="empId" value="<%=empId %>"  ></input>
<input type="hidden"	name="postheld" value="<%=postheld %>"  ></input>
<input type="hidden"	name="department" value="<%=department %>"  ></input>
 
<input type="hidden"	name="suffixDaysNo" value="<%=suffixDaysNo %>"  ></input>
<input type="hidden"	name="prefixDaysNo" value="<%=prefixDaysNo %>"  ></input>

<input type="hidden"	name="jspFromDate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(jspFromDate)  %>"  ></input>
<input type="hidden"	name="jspToDate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(jspToDate)  %>"  ></input>

<input type="hidden"	name="LeaveTypeName" value="<%=LeaveTypeName %>"  ></input>

<input type="hidden"	name="recommandFlag" value="<%=recommandFlag %>"  ></input>

<!-- <input type="button"	name="Print" value="Print" class="button" onclick="submitForm('message','/hms/hms/leave?method=printLeaveForm');"></input> -->
<%if(!messagestatus){ %>
<input type="button" name="yes" value="Yes" class="button"	
onclick="submitForm('message','/hms/hrms/leave?method=printLeaveForm');" />
<%} %>
<% if(message2!=null && message2.equalsIgnoreCase("message2")) {%>
<input type="button"	name="Back" value="Back" class="button" accesskey="b" onclick="submitFormForButton('message','/hms/hrms/leave?method=showWaitingLeaves')"></input>
<% } else { %>
<input type="button"	name="Back" value="Back" class="button" accesskey="b" onclick="submitFormForButton('message','/hms/hrms/leave?method=showLeaveApplicationJsp')"></input>

<%} } %>
<div class="clear"></div>
<div class="clear"></div>

<%
			if(map.get("link") != null){
				
				link = (List)map.get("link");
				for(int x=0;x<link.size();x++){
					linkText = (String)link.get(x);
					linkUrl = (String)link.get(x+1);
					x++;
				%> <a href="<%=linkUrl%>"><%=linkText%></a>
<div class="clear"></div>
<%
				}
				
				%>
<div class="clear"></div>
<%
			}	
		%> <%if(resumeId != null){%>
<div class="division"></div>

<div class="clear"></div>
<%if(false){%> <a href='<%=linkGenerateOfferLetter%>'>Generate Offer
Letter</a> <%}
				
				if(false){%> <label>Medically Fit</label> <input type="checkbox"
	name="medFit" id="med" />

<div class="clear"></div>

<label>Document Submitted</label> <input type="checkbox"
	name="docSubmitted" id="doc" /> <a
	href="javascript:checkMedFitness('<%=linkGenerateAppointmentLetter%>');">Generate
Appointment Letter</a> <%
				}
				
			}%>
<script type="text/javascript">
function printLeavePdf(){
 	submitForm('message','/hms/hrms/leave?method=printLeaveForm');

}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


