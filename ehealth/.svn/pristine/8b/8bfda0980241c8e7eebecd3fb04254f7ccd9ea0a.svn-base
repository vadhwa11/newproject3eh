<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_resumePayElement.jsp  
 * Purpose of the JSP -  This is for candidate pay elements.
 * @author  Rajat  
 * Create Date: 22th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*"%>
<%@ page import="java.text.*"%>
<%@ page import="jkt.hrms.masters.business.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="jkt.hms.util.*"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.Resumepersonaldetails"%>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	
	
</script>
<%	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}

	Map<String,Object> mapEmployee = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null){
	mapEmployee = (Map<String,Object>) request.getAttribute("map");
	}
	Resumepersonaldetails resume = new Resumepersonaldetails(); 
	if(mapEmployee.get("resume") != null){
		resume = (Resumepersonaldetails)mapEmployee.get("resume");
	}
	String message="";
	if(mapEmployee.get("message") != null){
		message = (String)mapEmployee.get("message");
	}
	
	List<HrMasPayElement> payElementsList = new ArrayList();
	if(mapEmployee.get("payElementsList") != null){
		payElementsList = (List)mapEmployee.get("payElementsList");
	}
	session.setAttribute("searchResumePayElementsList",null);
%>

<div class="titleBg">
<h2>Assign Pay Elements</h2>
</div>
<h4><%=message%></h4>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><label>Candidate
Name</label> <label class="value"><%=resume.getFirstName() + " " + resume.getLastName() %></label>

<label>Designation Offered</label> <label class="value"><%=resume.getResumeStatus().getDesignation().getRankName() %></label>
<div class="clear"></div>
<label>CTC (in Rs.)</label> <input type="text" name="<%=CTC%>"
	value="<%=new Integer(resume.getResumeStatus().getCtc()) %>"
	validate="CTC,int,yes" class="readOnly" readonly /> <label>Basic
(in Rs.)</label> <input type="text" name=""
	value="<%=new Float(new Integer(resume.getResumeStatus().getCtc())* .35).intValue() %>"
	class="readOnly" readonly />

<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>

<div class="Block">
<form name="payelements" method="post">
<table class="verySmall" cellpadding="0" cellspacing="0">
	<th>Pay Elements</th>
	<th>Basic Mutiplier</th>
	<th><input type="checkbox" name="allIds" onClick="checkAll()"
		class="radioCheck" /></th>
	<%
 	int counter = 0;
 	
 	for(HrMasPayElement payElement : payElementsList) {
 		String id = "";
 		id = "id" + counter;
 		Float basicMultuplier = 0f;
 		
 		if(payElement.getBasicDependent().equals("y"))
 		{
 			basicMultuplier = payElement.getBasicMultiplier();
 			
 		}
 	%>
	<tr id="<%=counter%>">
		<td><%=payElement.getPayElementDesc() %></td>
		<td><%= basicMultuplier%></td>
		<td><input type="checkbox" name=<%=id %> class="radioCheck"
			onClick="unCheck(this)" /></td>
	</tr>
	<%
 	counter++;
 	} %>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>

<input type="button" name="assign" value="Assign" class="button"
	onclick="alertAndSubmit()" tabindex=1 /> <input type="button"
	name="back" value="Back" class="button"
	onclick="location.href='resume?method=showCTCAnnexureJsp&resumeid=<%=resume.getId() %>'"
	tabindex=1 />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
</div>

<script>
 function checkAll()
{
var no = <%=payElementsList.size()%>;

for(i=0;i<no;i++)
{
var obj = "document.payelements." + "id" +i;
obj=eval(obj);
if(obj.disabled==true)
{
}
else
{
if(document.payelements.allIds.checked==true)
{
obj.checked=true;
}
else
{
obj.checked=false;
}
}
}
}



function unCheck(obj)
{
if(obj.checked==false)
{
document.payelements.allIds.checked=false;
}
}

function chkCheckBoxesForAuthorization()
	{
		
		inps = document.getElementsByTagName('input');
		flag=false;
		for(i=0;i<inps.length;i++)
		{
 			if(inps[i].type == 'checkbox')
  			{
				if(inps[i].checked)
				{
       	            flag=true;
	 			     break;
				}
			}
		}
		if(!flag)
		{
			alert("Please select atleast one request.");
			return false;
		}
		return true;
	}


</script>

<script>
function alertAndSubmit()
{
val = chkCheckBoxesForAuthorization();
if(val==true){
 x = confirm('Are you sure to assign selected Pay Elements to the candidate');
if(x == true){

document.payelements.action = 'resume?method=assignPayElements&<%=RequestConstants.RESUMEID%>=<%=resume.getId() %>';
document.payelements.submit();
}
else
{
return false;
}

}
}
</script>
