<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * opdTemplateInvestigation.jsp  
	 * Purpose of the JSP -  This is for All OpdTemplateInvestigation Master.
	 * @author  Mansi
	 * Create Date: 25 June,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5
	--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />

<script type="text/javascript">
	templateArray = new Array();
	function populateTemplate(val,formName){
		obj = eval('document.'+formName+'.templateId');
		obj.length = 1;
		for(i=0;i<templateArray.length;i++){
			if(templateArray[i][0]==val){
				obj.length++;
				obj.options[obj.length-1].value=templateArray[i][1];
				obj.options[obj.length-1].text=templateArray[i][2];			
			}
		}
	}
	
	function check()
	{
		var r = document.getElementById('deptId').value;
		if(r=="0")
		{
			alert("Please select Department Name")
			return false;
		}
		else
		{
			return true;
		}
	}
	
	</script> <%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList = (List<MasDepartment>)map.get("departmentList");
	
	List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
	opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
	
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} 	
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	%> <script type="text/javascript">
			<%
				int counter1 = 0;
				for (MasDepartment masDepartment : departmentList)
				{
					for (OpdTemplate opdTemplate : opdTemplateList) 
					{
						if(opdTemplate.getDepartment() != null){
							if(masDepartment.getId().equals(opdTemplate.getDepartment().getId() )){
									%>
										templateArray[<%=counter1%>] = new Array();
										templateArray[<%=counter1%>][0]=<%=masDepartment.getId()%>;
										templateArray[<%=counter1%>][1] = <%=opdTemplate.getId()%>;									
										templateArray[<%=counter1%>][2] = "<%=opdTemplate.getTemplateName()%>";
	
									<%
									counter1++;
							}
						}
					}
				}
				
			%>
	
		</script>
<div class="titleBg">
<h2>Opd Template Investigation</h2>
</div>
<div class="Block">
<form name="opdTemplateInvestigation" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label><span>*</span> Department Name</label> 
<select id="deptId" name="<%= DEPARTMENT_ID %>" id="depId" validate="Department Name,string,yes" tabindex=1 onchange="populateTemplate(this.value,'opdTemplateInvestigation');">
<option value="0">Select</option>
<%
	  	for (MasDepartment masDepartment : departmentList) {
	    %>
<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<% 	}  %>
</select> <script type="text/javascript">
//	document.getElementById('deptId').value = '<%=deptId%>';
</script> 
<label><span>*</span> Template Group  </label> 
<select id="templateId" name="<%=TEMPLATE_ID%>" validate="Template Group,string,yes" onchange="submitProtoAjax('opdTemplateInvestigation','/hms/hms/opdMaster?method=getInvestigationTemplateGroup');" onmousedown="check();">
<option value="0">Select</option>
</select></form>
<div class="clear"></div>
</div>
<div id="testDiv"></div>
</div>
<script type="text/javascript">
	function checkForChargeCodeCode(val){
		 var counter=document.getElementById('counter').value
		 if(counter>0)
		  {
		 for(var i=0;i<=counter; i++)
		 {
		 	 var chargeCodeFromDS=data_arr[i][4]
		 	if(val != "")
			{
				var index1 = val.lastIndexOf("[");
			    var indexForChargeCodeName=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var chargeCodeCode = val.substring(index1,index2);
			    var indexForChargeCodeName=indexForChargeCodeName--;
			    var chargeCodeName=val.substring(0,indexForChargeCodeName);
			   
		 	}
		 	if(chargeCodeCode =="")
			{
				return;
			}
			
			if(chargeCodeName==chargeCodeFromDS)
			{
				alert("Test Description already selected...!")
	     		document.getElementById('chargeCodeName').value=""
	     		document.getElementById('chargeCodeCode').value=""
	     		document.getElementById('clinical').value=""
	     		document.getElementById('qty').value=""
	     		return false;
			}
			ajaxFunctionForAutoCompleteChargeCodeCode('OPDInves','opdMaster?method=fillChargeCodeInGrid&chargeCodeCode='+chargeCodeCode);	
		
		}
		}else{
			if(val != "")
			{
				var index1 = val.lastIndexOf("[");
			    var indexForChargeCodeName=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var chargeCodeCode = val.substring(index1,index2);
			    var indexForChargeCodeName=indexForChargeCodeName--;
			    var chargeCodeName=val.substring(0,indexForChargeCodeName);
			   
		 	}
		 	if(chargeCodeCode =="")
			{
				return;
			}
			ajaxFunctionForAutoCompleteChargeCodeCode('OPDInves','opdMaster?method=fillChargeCodeInGrid&chargeCodeCode='+chargeCodeCode);
			
		}
			
	 }
	 
		function showPage()
		{	
		 obj = eval('document.'+formName)
 		 obj.action = "/hms/hms/opdMaster?method=showOpdTemplateInvestigationJsp";
  		 obj.submit();
		}
		
	function checkTestCode()
	{
		var r = document.getElementById('chargeCodeName').value;
		if(r=="")
		{
			alert("Please Enter Test Description")
			return false;
		}
		else
		{
			return true;
		}
}
       
</script>