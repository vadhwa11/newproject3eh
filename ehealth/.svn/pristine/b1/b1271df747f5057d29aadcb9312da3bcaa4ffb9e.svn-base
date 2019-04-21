<%@page import="jkt.hms.util.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>

<script type="text/javascript">
function go(dir) { 
    var text = self.location.href;
    var pos = text.indexOf('js');
    var num = text.substring(pos+2,pos+5) - 0 + dir;
    num = (num < 10) ? "00" + num : ( (num < 100) ? "0" + num : num);
    window.location.href = text.substring(0,pos+2) +
                           num +
                           text.substring(pos+5,text.length);
}
</script>

</script>
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
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();

	
	List patientList = new ArrayList();
	
	if(map.get("patientList") != null){
	patientList=(List)map.get("patientList");
	}				
	
	List patientList2 = new ArrayList();
	if(map.get("patientList2") != null){
		patientList2=(List)map.get("patientList2");
	}
	
	List patientList3 = new ArrayList();
	if(map.get("patientList3") != null){
		patientList3=(List)map.get("patientList3");
	}
	
	int deptId=0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
		}
	int userId=0;
	if (session.getAttribute("userId") != null) {
		userId = (Integer) session.getAttribute("userId");
		}
	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	int min;
	int max;
	 if(map.get("min")!=null){
		 min=Integer.parseInt((String)map.get("min"));
	 }
	 else
	 	min=0;
	 
	 if(map.get("max")!=null)
		 max=Integer.parseInt((String)map.get("max"));
	 else 
	 	max=9;
	session.setAttribute("min", min+"");
	session.setAttribute("max", max+"");
	 String  message = "";
	if(map.get("message") != null){
		  message = (String)map.get("message");
	}
	List<DgOrderdt> dtList=new ArrayList<DgOrderdt>();
	if(map.get("dtList") != null){
		dtList=(List)map.get("dtList");
	}
	
		   
	%>
<%
	
	
	Map<String, Object> detailsMap = new HashMap<String, Object>();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	 date = (String) utilMap.get("currentDate");
	%>
<div class="titleBg">
	<h2>Doctor's Module-OP</h2>
</div>
<!-- <div id="container">
		<div class="breadcrumb">
		<span class="formHeadingLeft"></span>
			<div class="formHeading">
				Doctor's Module-OP
			</div>
		
		<span class="formHeadingRight"></span>
		</div> -->
<!--breadcrumb closed-->
<form name="opdPatientList" method="post" action="">
	<div class="clear"></div>
	<%--<div class="search">
		 	<label>Consulting Doc.</label>
				<select	id ="consultingDoc" name="consultingDoc">
					<option value="0">All</option>
						<%
 							int  empId=0;
							String empName="";
							for(int i=0;i<patientList2.size();i++)
						  	{
								Visit visit=(Visit)patientList2.get(i);
							 	empId = (Integer)visit.getDoctor().getId();
								empName = visit.getDoctor().getFirstName();
								if(visit.getDoctor().getMiddleName()!=null)
								{
									empName =empName+" "+visit.getDoctor().getMiddleName();
								}
								if(visit.getDoctor().getLastName()!=null)
								{
									empName =empName+" "+visit.getDoctor().getLastName();
								}
				%>
								<option value="<%=empId%>"><%=empName%></option>
				<%
					  		}
				%>
				</select> 
		<input type="button" name="Go" value="Go" onclick="submitForm('opdPatientList','opd4b?method=showWaitingPatientListJsp&filter=true')" class="commonButtonSmall"/>
		
		
		<</div>	--%>
	<!--search closed-->
	<div class="clear"></div>
	<h4>
		<span><%=message %></span>
	</h4>



	<div class="clear"></div>
	
		<%-- <div class="clear"></div>


		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate%>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="16" />

		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" />
		<%if("IP".equalsIgnoreCase(patientType)){ %>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input
			id="adId" type="text" name="<%=AD_NO %>" value="" MAXLENGTH="50" />
		<%}else{%>
		<label><%=prop.getProperty("com.jkt.hms.token_num")%></label> <input
			type="text" name="<%=VISIT_NUMBER %>" value="" MAXLENGTH="3" />
		<%}%>
		<label>Doctor Name</label> <input type="text" name="<%=DOCTOR_NAME %>"
			value="" MAXLENGTH="15" />
		<div class="clear"></div>
		<input type="hidden" name="patientType" value="<%=patientType%>" /> 
		<div class="clear"></div>
		<input type="button" value="Search" class="button"	onclick="submitForm('patientSearch','/hms/hms/lab?method=searchPatient','check()');"	accesskey="a" />
		<input type="button" name="openButton" value="Open Token Display"	class="buttonAuto" onclick="openTokenDisplay()"/>
		<input type="button"	value="Close Token Display" class="buttonAuto" onclick="#"	accesskey="a" onclick="closeTokenDisplay()" />
		<div class="clear"></div> --%>
	
	<fieldset>
	<div class="Block">
		<div class="clear"></div>
		<input type="hidden" name="goSearch" id="goSearch" value="a" /> <label
			restrict>From Date</label> <input type="text" class="date"
			id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.opdPatientList.<%=FROM_DATE%>,event)" />

		<label class="restrict">To Date</label> <input type="text"
			class="date" id="toDateId" name="<%=TO_DATE %>"
			value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.opdPatientList.<%=TO_DATE%>,event)" />
		<label class="restrict">HIN</label> <input type="text" name="hin"
			id="hin" value="" tabindex="1" />
		<div class="clear"></div>
		<div class="btPanel">
			<input type="button" name="search" value="Search"
				onclick="submitForm('opdPatientList','lab?method=showPacsListJsp','checkTargetForNo');"
				class="commonButton" tabindex="1" /> <input type="button"
				name="search" value="Back" onclick="history.back();"
				class="commonButton" tabindex="1" />
		</div> 
	</div>
	</fieldset>
	<div class="clear"></div>
	<%if(dtList.size()>0)
		{ System.out.println("--------------------------");%>


	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="fullLength">
		<tr>
			<!-- <th scope="col" class="brdrLeft">Token No.</th> -->
			<!--	<th scope="col">Visit No.</th>-->
			<th scope="col">HIN</th>
			<th scope="col">Patient Name</th>
			<th scope="col">Age</th>
			<th scope="col">Gender</th>
			<th scope="col">Modality</th>
			<th scope="col">Consulting Doc.</th>
			<th scope="col">Order Date</th>
			<!--<th scope="col">Reg. Time</th>
    				-->
    		<th scope="col" class="brdrRight">Report</th>
			<th scope="col" class="brdrRight">Call Patient</th>
		</tr>
		<tbody id="tableData">
			<%
	 				int  counter=0;
  				
  				  String color="";
  				  String status1="";
  				
					String klass = "even";
					try
					{
						//Iterator iterator=patientList.iterator();
						for(DgOrderdt dodt:dtList)
						{    
							String docName="";
							
						//	System.out.println("--hh--"+visit.getVisitStatus());
						/*if( visit.getDisToken()!=null && visit.getDisToken().equals("y"))
						{
							color="#4EE2EC";
							status1="On Call";
						}else{
							if(visit.getVisitStatus().equalsIgnoreCase("w") )
							{
								color="#4EE2EC";
								status1="waiting";
							}else
							{
								color="#FF0080";
								status1="Seen";
							}
						}*/
							
								Patient patientHin=(Patient)dodt.getOrderhd().getHin();
								String patientName="";
								//String docName=patientHin.getDoctor().getFirstName().toUpperCase();
								if(patientHin.getPFirstName()!= null)
								{
									patientName=patientHin.getPFirstName();
								}
								if(patientHin.getPMiddleName()!= null)
								{
									patientName=patientName+" "+patientHin.getPMiddleName();
								}
								if(patientHin.getPLastName()!= null)
								{
									patientName=patientName+" "+patientHin.getPLastName();
								}
								if(dodt.getOrderhd().getPrescribedBy().getEmployeeName()  !=null){
									docName= docName +" "+dodt.getOrderhd().getPrescribedBy().getEmployeeName().toUpperCase();
								}
								//System.out.println("docName"+docName);
								MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
								//String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
								String id = "";
								id = "id" + counter;
								counter++;
								if(counter%2==0)
								{
									klass = "even"; 
								}
								else
								{
									klass= "odd";
								}  
				%>
			<tr class=<%=klass%> id="<%=counter%>">
				<%--	<td  bgcolor="<%=color %>" class="brdrLeft">
									<input name="<%=RequestConstants.TOKEN_NO%>" type="hidden" value="<%=dod.get)%>"><%=visit.getTokenNo()%>
								</td> 
				    			<td bgcolor="<%=color %>">
				    				<input name="<%=RequestConstants.VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>"><%=visit.getVisitNo()%>
				    				<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
				    				<input name="visitNumber" type="hidden" value="<%=visit.getVisitNo()%>" />
				    			</td>--%>
				<td bgcolor="<%=color %>"><input
					name="<%=RequestConstants.HIN_NO%>" type="hidden"
					value="<%=dodt.getOrderhd().getHin().getHinNo()%>"><%=dodt.getOrderhd().getHin().getHinNo()%>
						<input name="hinId" type="hidden"
						value="<%=dodt.getOrderhd().getHin().getId()%>" /> <input
						name="accId" type="hidden" value="<%=dodt.getId()%>" /></td>
				<td bgcolor="<%=color %>"><input
					name="<%=RequestConstants.PATIENT_NAME%>" type="hidden"
					value="<%=patientName%>"><%=patientName%></td>
				<td bgcolor="<%=color %>"><input
					name="<%=RequestConstants.AGE%>" type="hidden"
					value="<%=patientHin.getAge()%>"><%=patientHin.getAge()%></td>
				<% if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){ %>
				<td bgcolor="<%=color %>"><input
					name="<%=RequestConstants.SEX%>" type="hidden"
					value="<%=masAdministrativeSex.getAdministrativeSexName()%>"><%=masAdministrativeSex.getAdministrativeSexName()%></td>
				<%}
				   				else
								{%>
				<td bgcolor="<%=color %>"><input
					name="<%=RequestConstants.SEX%>" type="hidden" value="">-</td>
				<%}	%>

				<%--
				    			<td bgcolor="<%=color %>" class="brdrRight">
				    			<input name="status" type="hidden" value="<%=status1%>"><%=status1%>
				    			<input name="calledPat" id="calledPat<%=counter %>" type="hidden" value=""></input>
				    			
				    			</td> --%>
				<td bgcolor="<%=color %>" class="brdrRight"><input
					name="modality" type="hidden" value="<%=docName%>"><%=dodt.getChargeCode().getChargeCodeName()%></td>
				<td bgcolor="<%=color %>" class="brdrRight"><input
					name="consultingDoc" type="hidden" value="<%=docName%>"><%=docName%>

						<input name="codeEmp" type="hidden"
						value="<%=dodt.getOrderhd().getPrescribedBy().getPEN()%>"></td>
				<td bgcolor="<%=color %>" class="brdrRight"><input
					name="regTime" type="hidden"
					value="<%=dodt.getOrderhd().getOrderDate()%>"><%=HMSUtil.changeDateToddMMyyyy(dodt.getOrderhd().getOrderDate())%></td>
				<%if(dodt.getPacsMessage()!=null){%>
					<td bgcolor="<%=color %>" class="brdrRight"><%=dodt.getPacsMessage()%></td>	
				<%}else{%>
				<td bgcolor="<%=color %>" class="brdrRight"></td>	
				<%} %>
				<td bgcolor="<%=color %>" class="brdrRight"><input
					name="Call Patient" tabindex="1" class="button" type="button"
					value="View"
					onclick="submitForm('opdPatientList','lab?method=showPacsViewServer&accId=<%=dodt.getId() %>&codeEmp=<%=dodt.getOrderhd().getPrescribedBy().getPEN()%>','checkTargetForYes')"></td>


			</tr>
			<%
							
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();	
					}
					%>
		
	</table>

	<!--table closed-->
	<div class="clear"></div>
	<div id="pageNavPosition"></div>
	<script>
				  	var pager = new Pager4b('tableData',5); 
					pager.init(); 
					pager.showPageNav('pager', 'pageNavPosition'); 
					pager.showPage(1);
				</script>
	<input type="hidden" name="counter" id="counter" value="<%=counter %>" />
	<input type="hidden" name="startC" id="startC" value="0" />
	<%}
		else
		{ %>
	<label class="value">No record Patient .</label>
	<%}%>
	<input type="hidden" name="userId" id="userId" value="<%=userId %>" />
	<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
	<input type="hidden" name="deptName" id="deptName"
		value="<%=deptName %>" />
	<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<!--container closed-->

<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	
	
		function openTokenDisplay()
	{
	 var url="/hms/hms/doctorModule/opd4b?method=showPopupTokenJsp";
		newwindow=window.open(url,'opentoken','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=0");
		 
//	 newwindow=window.open(url,'name','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=0");
	}
	function closeTokenDisplay(){

		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}

	}

	function goSearch1()
	{
		
		if(document.getElementById('goSearch') != null && document.getElementById('goSearch') !='')
		{
			document.getElementById('goSearch').value='b';
		}
		
	}
	function checkCall(val)
	{
		var disToken=document.getElementById('calledPat'+val).value
		

		if(disToken == 'y' )
		{
			alert("Patient Already Call by Doctor");
			return false
		}else
		{
			return true;
		}		
		
		
	}
	function openLabReport(){

		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}

	}
	function ajaxCall1(){

        var url = 'www.google.com';

        // jquery code snippet
        var ajaxRequest; 

        try{
            ajaxRequest = new XMLHttpRequest();
        } catch (e){
            try{
                ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try{
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e){
                    alert("Please update your browser biatch!");
                    return false;
                }
            }
        }
        // Create a function that will receive data sent from the server
        ajaxRequest.onreadystatechange = function(){
            alert(ajaxRequest.readyState);
            if(ajaxRequest.readyState == 1){
                var ajaxDisplay = document.getElementById('ajaxDiv');
                ajaxDisplay.innerHTML = ajaxRequest.responseText;
            }
            else {
                alert("failed");
            }
        }
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
        ajaxRequest.open("POST", url, true);
                    // param is the JSON data.
        ajaxRequest.send();
    }


	function ajaxCall11() {
		  // Add the iframe with a unique name
		  var iframe = document.createElement("iframe");
		  var uniqueString = "CHANGE_THIS_TO_SOME_UNIQUE_STRING";
		  document.body.appendChild(iframe);
		  iframe.style.display = "none";
		  iframe.contentWindow.name = uniqueString;

		  // construct a form with hidden inputs, targeting the iframe
		  var form = document.createElement("form");
		  form.target = uniqueString;
		  form.action = "http://localhost:8090/hms/doctorModule/";
		  form.method = "POST";

		  // repeat for each parameter
		  var input = document.createElement("input");
		  input.type = "hidden";
		  input.name = "INSERT_YOUR_PARAMETER_NAME_HERE";
		  input.value = "INSERT_YOUR_PARAMETER_VALUE_HERE";
		  form.appendChild(input);

		  document.body.appendChild(form);
		  form.submit();
		  alert("----")
		}
	function ajax(  ) {
	var url = 'www.google.com'
		var settings = ''
	    var ajax = new window.XMLHttpRequest(),
	        data = settings.type == 'GET' ? '' : settings.data;
	    url = settings.type == 'GET' ? url + ( settings.data ? '?' + settings.data : '' ) : url;
	    
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    ajax.onreadystatechange = function () {

	        if ( ajax.readyState == 4 ) { //response ready

	            if ( ajax.status == 200 ) { //success
	                if ( settings.success ) settings.success( ajax.responseText, ajax.statusText );
	            } else {
	                if ( settings.error ) settings.error( ajax, ajax.status, ajax.statusText );
	            };

	        };

	    };

	    ajax.open( settings.type, url );
	    ajax.send( data );

	};

	function pacs()
	{
		alert("ajax");
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://www.gogle.com/");

	// Request parameters and other properties.
	List<NameValuePair> params = new ArrayList<NameValuePair>(2);
	params.add(new BasicNameValuePair("param-1", "12345"));
	params.add(new BasicNameValuePair("param-2", "Hello!"));
	httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

	//Execute and get the response.
	HttpResponse response = httpclient.execute(httppost);
	HttpEntity entity = response.getEntity();

	if (entity != null) {
	    InputStream instream = entity.getContent();
	    try {
	        // do something useful
	    } finally {
	        instream.close();
	    }
	}
	}
	<%dtList.clear();%>
</script>