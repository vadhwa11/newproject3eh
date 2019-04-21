<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.DgUom"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<style>

#message{
	color: #05BE24;
	width: 100%;
	FONT-SIZE: 11px;
	font-weight:bold;
}
</style>
<script type="text/javascript" language="javascript">


 <%
   Calendar calendar=Calendar.getInstance();
   String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
  String date=String.valueOf(calendar.get(Calendar.DATE));
  int year=calendar.get(calendar.YEAR);
  if(month.length()<2){
   month="0"+month;
  }
  if(date.length()<2){
   date="0"+date;
  }
 %>
  serverdate = '<%=date+"/"+month+"/"+year%>'
 </script>
<%
    Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
	List<PatientMainLabInfo> patientInfo = new ArrayList<PatientMainLabInfo>();
	if(map.get("patientInfo") != null)
	{
		patientInfo = (List<PatientMainLabInfo>)map.get("patientInfo");
		

	}
	System.out.println("patientInfo--"+patientInfo.size());
	List<DgSampleCollectionDetails> dgSampleCollection = new ArrayList<DgSampleCollectionDetails>();
	if(map.get("dgSampleCollection") != null)
	{
		dgSampleCollection = (List<DgSampleCollectionDetails>)map.get("dgSampleCollection");
		
	}
	String sample_date="";
	if(map.get("sample_date") != null)
	{
		sample_date = (String)map.get("sample_date");
		
	}
	String machineName="";
	if(map.get("machineName") != null)
	{
		machineName =  (String) map.get("machineName");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	String message=null;
	if(map.get("message") != null)
	{
		message=(String)map.get("message");
		
	}
	 Map<String, Object> utilMap = new HashMap<String, Object>();
     utilMap = (Map) HMSUtil.getCurrentDateAndTime();
     String currentDate = (String) utilMap.get("currentDate");
     String time = (String) utilMap.get("currentTime");
    
	%>
<script type="text/javascript">
function checkExistingDiagNo(obj)
{
	var row=document.getElementById("totalRow").value;
	//alert("row "+row);
    for(var i=0;i<row;i++)
    {
       if(i!=obj)
        {
         if(document.getElementById("diagnosisNo"+i).value==document.getElementById("diagnosisNo"+obj).value)
    	 {
    		document.getElementById("diagnosisNo"+obj).value="";
    		document.getElementById("serviceNo"+obj).value="";
    		document.getElementById("rank"+obj).value="";
    		document.getElementById("name"+obj).value="";
        	alert("Please Select Another Diagnostic No.");
           return false;
           break;
          }
        }
       }
    return true;
}
function checkBlankRecord()
{
	var row=document.getElementById("totalRow").value;
	//alert("row "+row);
	var status;
    for(var i=0;i<row;i++)
    {
       	if(document.getElementById("diagnosisNo"+i).value=="")
       	{
       	 status=false;
       	}
        else
       	{
           status=true
           break;
       	}
    }

        if(status==false)
	    {
		   alert("Please Select Diagnostic No.");
           return false;
	    }
	 return true;
}
</script>
<div id="contentHolder">
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>

<h4>Analyzer Sample No. Mapped to Diagnostic No. </h4>

<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<%if(patientInfo.size()<1){ %>

<h4>No Records Founds..</h4>
<%}else{ %>

<form name="sampleForm" method="post" action="">
<div class="Clear"></div>
<div class="grid">
<table width="100%"  id="chargeDetails" cellpadding="0"	cellspacing="0">

	<tr>
		<th>Sample No. </th>
		<th>Time</th>
		<th>Diagnostic No.</th>
		<th>UHID</th>
		<th>Patient Name</th>
		<th>Department</th>
	</tr>
	<%
	int inc = 0;
	for (PatientMainLabInfo patientLab : patientInfo)
	{

	%>
    <tr>
    <input type="hidden" name="patientLabId" value="<%=patientLab.getId() %>" id="patientLabId" />
    <input type="hidden" name="<%=SAMPLE_NO%>" value="<%=patientLab.getSampleNo() %>" id="sampleNo" />
    <td ><%=patientLab.getSampleNo() %>
	 </td>
	 <td ><%=patientLab.getTime() %></td>

<!--<td><select id="diagnosisNo%=//inc%>" name="%=//DIAGNOSIS_NO%>" validate="diagnosisNo,string,no"  tabindex=1
onchange="if(checkExistingDiagNo(%=//inc%>)){ajaxFunctionForDiagnosisNo(sampleForm,%=//inc %>);}">
			<option value="">Select</option>
		 --> 	<%

		 //	Iterator itr=dgSampleCollection.iterator();
		 	// while(itr.hasNext())
		 	 //{

		 		//String diagNo=(String)itr.next();
		 		
		 			
    %>
		<!--	 <option value="//=//diagNo%>" >=//diagNo%></option>
		 -->	<%
				

		//	}
       		%>
	<!--	</select>
     </td>
    -->
     <td>
     <input id="diagnosisNo<%=inc%>" name="<%=DIAGNOSIS_NO%>" validate="diagnosisNo,string,no"  tabindex=1
onchange="if(checkExistingDiagNo(<%=inc%>)){ajaxFunctionForDiagnosisNo(sampleForm,<%=inc %>);}"/>
     </td>
     <td>
		<input type="text" name="<%=SERVICE_NO %>" id="serviceNo<%=inc%>" value="" readonly="readonly"/></td>
		<td><input type="text" name="<%=RANK%>" value="" id="rank<%=inc%>" readonly="readonly"/>
		</td>
       <td><input type="text" name="<%=PATIENT_NAME%>" value="" id="name<%=inc%>" readonly="readonly"/>
		</td>
		    </tr>
		    <%
		      inc++;
              	}
		    %>
		     <input type="hidden" name="sample_date" value="<%=sample_date %>" id="sample_date"/>
		 <input type="hidden" name="<%=TOTAL_ROW_VAL%>" value="<%=inc %>" id="totalRow"/>
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
        <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
        <input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
        <input type="hidden" name="machineName"  value="<%=machineName%>" />
      	</table>
    </div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
	<input type="button" name="add"
	id="addbutton" value="Add" class="button"
	onClick="if(checkBlankRecord()){submitForm('sampleForm','lab?method=addDiagnosisNo')}"
	accesskey="u" tabindex=1 />
	<input type="reset" name="Reset" id="reset" value="Reset" class="button" accesskey="r"
	onclick="resetCheck();" tabindex=1 />
	<input type="button" name="Cancel" id="cancel" value="Cancel" class="button" accesskey="r"
	 onClick="submitForm('sampleForm','lab?method=showLabMapDisgNoJsp')" tabindex=1 />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<div class="paddingTop80"></div>
<div class="Clear"></div>

     

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
   <% } %>
    </div>
