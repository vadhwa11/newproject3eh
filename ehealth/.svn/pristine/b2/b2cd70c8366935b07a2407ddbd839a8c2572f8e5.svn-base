<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Calendar"%>
    <%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Collection</title>
<div class="titleBg">
<h2>Blood Sample Collection</h2>
</div>


<script type="text/javascript" src="/hms/jsp/js/jquery.js"></script>

<style type="text/css">
.desc{
	display: none;
	}

</style>
<script type="text/javascript">

    $(document).ready(function(){

        $('input[type="radio"]').click(function(){

            if($(this).attr("value")=="Y"){
            	$(".Blockdiv2").hide();
            	 $(".Blockdiv1").show();
           
            }

            if($(this).attr("value")=="N"){
            	 $(".Blockdiv1").hide();
            	 $(".Blockdiv2").show();
            	
            }

        });

    });

</script>
</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
BloodSampleCollection bloodSampleCollection=null;

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

if(map.get("searchBloodComponentList") != null)
{
	searchBloodComponentList=(List<BloodMasComponent>)map.get("searchBloodComponentList");
}
if(map.get("bloodSampleCollection")!=null){
	bloodSampleCollection=(BloodSampleCollection)map.get("bloodSampleCollection");
}
Users users=(Users)session.getAttribute("users");
%>

<script>
<%

               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }

       %>

               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<form name="bloodSampleCollection" action="" method="post">
<div class="Block">   
	<label>Bag Number<span>*</span></label> 
	<label class="value">${requestScope.map.bloodSampleCollection.bagNumber}</label> 
	<input type="hidden" name="bagNumber" value="${requestScope.map.bloodSampleCollection.bagNumber}"/>
	<label>Tube Number<span>*</span></label> 
	<label class="value">${requestScope.map.bloodSampleCollection.tubeNumber}</label>
	<label>Type of Bag<span>*</span></label> 
	<label class="value">${requestScope.map.bagType}</label> 
	<div class="clear"></div> 
	<label>Batch Number<span>*</span></label> 
	<label class="value">${requestScope.map.batchNo}</label>
	
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div> 
	<div class="clear"></div> 
	<h4>Blood Collection Details</h4>
	<div class="clear"></div>
	<div class="clear"></div>
	
	<div class="clear"></div>
	<label>Process Completed</label>
	<%if("y".equalsIgnoreCase(bloodSampleCollection.getAcceptedRejected())){%>
	<label class="value">Yes</label> 
	
	<div>	
	<%if(bloodSampleCollection.getSampleExpiryDate()!=null){%> 
	<label >Component Expiry Date</label> 
	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(bloodSampleCollection.getSampleExpiryDate()) %></label> 
	<%}if(bloodSampleCollection.getBagExpiryDate()!=null){%>
	<label >Blood Bag Expiry Date<span>*</span></label> 
	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(bloodSampleCollection.getBagExpiryDate()) %></label> 
	<%} %> 	  
	</div>
	<%}else{%>
		<label class="value">No</label>
		<div class="clear"></div>
		<div>
		<label class="autoSize">Reason For Process Incomplete</label> 
		 <textarea rows="10" cols="100" readonly="readonly">
		 ${requestScope.map.bloodSampleCollection.reasonForProcessIncomplete}
		</textarea>
		</div> 
	<%}%> 
	<div class="clear"></div> 
	<label>Blood Collection Remarks</label> 
	 <textarea rows="10" cols="100" readonly="readonly" class="textareaMediua">
	 ${requestScope.map.bloodSampleCollection.remarks}
	</textarea> 
	 <div class="clear"></div>
	 <h4>Sample Collection</h4>
	 <%
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

	 %>
	<div class="clear"></div> 
	<label >Date</label> 
	<label class="value"><%=currentDate%></label> 
 
	<label>Time</label> 
	<label class="value"><%=time%></label>
	
	 <label>Collected By</label> 
	<label class="value"><%=users.getEmployee().getFirstName()%></label>
	
	<div class="clear"></div> 
	<label class="heightAuto">Blood Sample Collection Remarks</label> 
	 <textarea rows="10" cols="100" name="sampleRemarks" class="textareaMediua">
	 
	</textarea> 
	<input type="hidden" value="${requestScope.map.bloodSampleCollection.id}" name="sampleId">
	<input type="hidden" value="<%=users.getId()%>" name="userId">
	<div class="clear"></div>
	 <!-- <input type="button" class="button"  value="Submit" align="right" 
		onclick="submitForm('bloodSampleCollection','/hms/hms/bloodBank?method=submitSampleOfBlood')" />  -->
		
		<input type="button" class="button"  value="Submit" align="right" 
		onclick="submitForm('bloodSampleCollection','/hms/hms/bloodBank?method=showbloodBagCrossCheckDetailJsp')" /> 
	 </div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>

<script type="text/javascript">
function SecondOpinion() {
	var height=350;
	var width=700;
	var csrf=csrfTokenName+'='+csrfTokenValue;
	var visitId=document.getElementById("visitId").value;
	var hinId=document.getElementById("hinId").value;
	var hinNo=document.getElementById("hinNo").value;

	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	window.open("/hms/hms/bloodBank?method=showbloodBagCrossCheckJsp&visitId="+visitId+"&hinNo="+hinId+"&uhidNo="+hinNo+"&"+csrf,"Second Opinion","scrollbars=no, status = no, height = "+height+", width =" +width+",top="+top+", left="+left )
}
	function showHide(op){
		if(op==1)
		{document.getElementById("reasonDiv").style.display="none";}	
		else if(op==2)
		{document.getElementById("reasonDiv").style.display="block";}
	}
	
	function setQuantity(id){
		
		var quantity=document.getElementById("id"+id).value;
		var lifeSpan=document.getElementById("expiryid"+id).value;
		
		document.getElementById("compquantityID").value=quantity;
			
		var newdate=new Date();
		var newtimems=newdate.getTime()+(lifeSpan*24*60*60*1000);
		newdate.setTime(newtimems);
					
		var dd = newdate.getDate();
		var mm = newdate.getMonth() + 1; 
		var yyyy = newdate.getFullYear();
		var dateString = "0"+dd + "/" +"0"+ mm + "/" + yyyy;
		document.getElementById("ExpiryDateId").value=dateString;
			
	}
	
	
	 function isNumber(evt) {
	        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
	        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57)){
	        	alert("Eneter only numeric value");
	            return false;
	        }

	        return true;
	    } 
	 
	 
	 function chechBagValidity(value){ 
		
		 if(value !="")
			{
		  			 var date  = value.substring(0,2);
		  			
		   			var month = value.substring(3,5);
		   			var year  = value.substring(6,10);

		   			var myDate= new Date(year,month-1,date);
		   		
					 var today = new Date();

			 if (myDate<today)
		  	 {
		  	 alert("Please Enter Valid Date ");
		  	 document.getElementById('bagExpiryDate').value="";
		  	 }
			 else{
				 
				 var value1= document.getElementById('ExpiryDateId').value;
				 
					 var date  = value1.substring(0,2);
			   		var month = value1.substring(3,5);
			   		var year  = value1.substring(6,10);
			   		var componentDate= new Date(year,month-1,date);
			   	 if (myDate<componentDate)
			  	 {
			   		 if(confirm("Bag Expiry date is less than  component date !"+"\n \n Do you want to continue ! ")){
			   			 
			   		 }
			   		 else{
			   			 document.getElementById('bagExpiryDate').value=""; 
			   		 }
			  	 
			  	 }
			 }
		 }
		 else{
			 alert(" Enter Bag Expiry Date "); 
		 }
	 }
</script>