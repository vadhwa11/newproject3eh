
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

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
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
	
	String userName = "";
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}

	int deptId=0;
	int inPatientId = 0;
	
	if(session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (map.get("invResultList") != null){
		resultList =(List)map.get("invResultList");
	}
	Set<PatientInvestigationDetails> patientInvestigationdetails=null;
	PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
	/*List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
	if(map.get("patientInvestigationHeader")!=null){

		patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
		patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
	}*/
	List<PatientInvestigationDetails> patientInvestigationList = new ArrayList<PatientInvestigationDetails>();
	if(map.get("patientInvestigationList")!=null){
		patientInvestigationList = (List<PatientInvestigationDetails>)map.get("patientInvestigationList");
	}
	
	if(map.get("dgResultEntryDetailList")!=null){
		dgResultEntryDetailList = (List<DgResultEntryDetail>)map.get("dgResultEntryDetailList");
	}
	
	
	
 String template="";
	int resultid=0;
	int inc=1;

	if(patientInvestigationList!=null && patientInvestigationList.size()>0){
		   HashMap first = new HashMap();
		   HashMap second = new HashMap();
		   HashMap third = new HashMap();
		   HashMap fourth = new HashMap();
		   int inc1=1; 
	%>	  
	
 <table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>
			<th>&nbsp;</th>
			<th>Investigation</th>
			<th>Result</th>
			
			<th>Discharge Summary</th>
			<th>Prescribed By</th>
			
		</tr>
	</thead>
	 
		<%	int k=0; 
		for(PatientInvestigationDetails patientInvestigation : patientInvestigationList)
		//for(PatientInvestigationDetails patientInvestigation : patientInvestigationList)
			    {
			    	int cnt=0;
			    	String investigationName="";
			    	//investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
			    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName();
			    	first.put(investigationName,patientInvestigation.getChargeCode().getId());
			    	third.put(investigationName,patientInvestigation.getId());
			    	fourth.put(investigationName,patientInvestigation.getInvestigationHeader().getPrescribedByNurse() != null?patientInvestigation.getInvestigationHeader().getPrescribedByNurse():"");

			    	String val="";
			    	String val1="";
			    	String val2="";
			    	int investigationId=0;
			      	if(resultList.size()>0 && inc1<=resultList.size())
			    	{
			    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
			    	
			    	/**
			    	* For getting ordered sub investigations
			    	* Added by Ritu 
			    	*/
			    	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
			    	Set<DgResultEntryDetail> subSet1 = new LinkedHashSet<DgResultEntryDetail>();
						//System.out.println("dgEH==="+dgEH.getDgResultEntryDetails());
					for(DgResultEntryDetail dgResultEntryDetail : dgEH.getDgResultEntryDetails()){
						linkedHashSet.add(dgResultEntryDetail);
					}
					subSet1.addAll(linkedHashSet);
			    	
			    //	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
			    	for(DgResultEntryDetail dgre:subSet1)
			    	{  
			    		if(dgre.getSubInvestigation()!=null)
				    		val1=dgre.getSubInvestigation().getSubInvestigationName();
				    	if(!dgre.getResultType().equalsIgnoreCase("t"))
			    		{
				      	    ++cnt;
				    		if(dgre.getResult()!=null)
				    			val2=dgre.getResult();
				    
				    		if(cnt==1){
				    	    	val=" "+val1+":"+val2;
				    	    }else{
				    	    	val=" "+val+","+val1+":"+val2;
				    	    }
				    		 

			    		}
				    //System.out.println(dgre.getResultType()+"<-dgre.getResultType()-dgOrderdt val-ma jsp--"+val);
			    	investigationId=dgre.getInvestigation().getId();
			    		if(dgre.getResultType().equalsIgnoreCase("s"))
			    		{
			    		    	val=val.substring(2);
			    				resultid=0;
				
			    		}
			    		if(dgre.getResultType().equalsIgnoreCase("m"))
			    		{
			    			val=val.substring(1);
			    			resultid=0;
		    	
			    		}
			    		if(dgre.getResultType().equalsIgnoreCase("t"))
			    		{
			    			resultid=dgre.getResultEntry().getId();
			    			template="template"+"/"+resultid;
			    			val=template;
		    	
			    		} 
			    	
			    	
			    	}

			    	}
			    	if(investigationId!=0&&!second.containsKey(investigationId))
			    	second.put(investigationId,val);
			    	
			    	
			    	++inc1;
			    	//
			    }

				    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
	            String key = (String) i.next();



			    %>
		<tr>

		<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
			<td><input type="checkbox" name="ds<%=inc %>" id="ds<%=inc %>" value="y" /></td>
			<%-- <td><input type="checkbox" name="ds" id="ds<%=i%>" value="<%=i%>" /></td> --%>
			<td><input type="text" value="<%=key%>" readonly="readonly"
				readonly="readonly" tabindex="2" id="chargeCodeName33<%=inc %>"
				 name="chargeCodeName33<%=inc %>" size="45" />
	</td>
	<%

	if(second.get(first.get(key))!=null)
		{
		
		String st=(String)second.get(first.get(key));
		String[] mySplitResult = st.split("/");
		if(!mySplitResult[0].equalsIgnoreCase("template"))
		{
		%>
		
		<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
	</td>
	<td>&nbsp;</td>
	<%if(fourth.get(key).equals("y")){ %>
	<td>Nurse</td>
	<%}else{ %>
	<td>Doctor</td>
	<%} %>

	<% }else{

	%>
	<td>
		<input name="resultIdTemplate<%=inc %>"	id="resultIdTemplate<%=inc %>" type="hidden"	value="<%=mySplitResult[1]%>"/>
		<input type="hidden" value="" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
		<!-- <input	type="Button" class="Button" value="Result"	onclick="openTemplateScreen(<%=inc %>);"  /> -->
		</td>
		<td>&nbsp;</td>
<%if(fourth.get(key).equals("y")){ %>
	<td>Nurse</td>
	<%}else{ %>
	<td>Doctor</td>
	<%} %>
	<%}%>
	
	
	<%}else{%>
	<td>Result Not Entered</td>
	<td>&nbsp;</td>
	<%if(fourth.get(key).equals("y")){ %>
	<td>Nurse</td>
	<%}else{ %>
	<td>Doctor</td>
	<%} %>
	
	<%} %>
	
		</tr>

		<% inc++;
			    }

	%>

	</table>
	<%
	} %>
	<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
<div class="clear"></div>
<input type="button" name="ok" value="Ok" onclick="setValuesInParent();" class="button"/>

 
 <%-- <%
 if(resultList.size()>0)
 {%>
 <table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">


	<thead>
		<tr>
		<th>select</th>
		<th>Investigation</th>			
		</tr>
	</thead>
 <%
 int i=0;
 for(DgResultEntryDetail dgre:dgResultEntryDetailList )
	{
	 %>
	 <tr>
	 	<td><input type="checkbox" name="select" id="select<%=i%>" value="<%=i%>" /></td>
	    <td><%=dgre.getInvestigation().getInvestigationName() %><input type="hidden" name="invname<%=i %>" id="invname<%=i %>" value="<%=dgre.getInvestigation().getInvestigationName() %>" /></td>
	 </tr>
	 <%
	}
 %>
 </table>
 <div class="clear"></div>
<input type="button" name="ok" value="Ok" onclick="W();" class="button"/>
 <%
 }
 else
 {
	 %>
	 <h4>No data found</h4>
	 <%
 }
 %> --%>
<!-- <!-- <script>
function setValuesInParent(){  
	var selectedCheckBox=document.getElementsByName('select');
	var invResultStr = ''; 
	alert(""+selectedCheckBox.length)
	for(var i=0;i<selectedCheckBox.length;i++)
		{
		if(selectedCheckBox[i].checked)
			{
			if(invResultStr!=''){
				invResultStr += ",\n";
			}
			alert(document.getElementById('chargeCodeName33'+selectedCheckBox[i].value).value);
			invResultStr += document.getElementById('chargeCodeName33'+selectedCheckBox[i].value).value;
			}
		}
	alert("invResultStr>"+invResultStr);
	window.opener.document.getElementById(window.name).value = invResultStr;
	window.close();
}

</script> --> 


<script>
function setValuesInParent(){
	var count = document.getElementById('hiddenValue').value;
	//alert(count);
	var treatment = ''; 
	for(var i = 1;i<=count;i++){
		//alert("in loop");
		if(document.getElementById('ds'+i) && document.getElementById('ds'+i).checked){
			//alert("in if"+document.getElementById('chargeCodeName33'+i).value)
			if(treatment!=''){
				treatment += ",\n";
			}
			//alert(""+document.getElementById('chargeCodeName33'+i).value);
			treatment +=(document.getElementById('chargeCodeName33'+i).value);
			

		}
	}
	//alert(treatment)
	window.opener.document.getElementById(window.name).value = treatment;
	window.close();
}

</script>
	