<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * state.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupT"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasSpecialtyGroupParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>


<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>


<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<MasSpecialtyTemplate> templateList=new ArrayList<MasSpecialtyTemplate>();
		List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
		
		String userName = "";
		String  departName= "";
		
				
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		
		
		
		 if(map.get("deptName") != null){
			 departName = (String)map.get("deptName");
			} 
	   
	   
	    if(map.get("templateList")!=null){
	    	templateList=(List<MasSpecialtyTemplate>)map.get("templateList");
	    } 

		 if(map.get("masForGorupParameter") != null){
			 
			 masForGorupParameter = (List<MasSpecialityDeptGroup>)map.get("masForGorupParameter");
			} 
	 System.out.println("size"+masForGorupParameter.size());
	    
	    
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
		   %>

<h4>
	<span><%=message %></span>
</h4>
<%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
	<h2>Department wise Specialty</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">			
		</div>
	</div>
	<div class="clear"></div>
</div>
<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<form name="speciality" method="post" action="" enctype="">
							<div class="Block">

								<label><span>*</span>Department</label> 
                                  <input  type="text" name="departName" name="departName" value="<%=departName%>" tabindex=1/> 
								
								
								<label><span>*</span>Template</label> <select name="tempLate"
									id="tempLate" onchange="display(this.value);" tabindex=2>
									<option value="">Select</option>
									<% 
				                 for ( MasSpecialtyTemplate masTampList : templateList){
				                     %>
									<option value="<%=masTampList.getId()%>"><%=masTampList.getTemplateName()%></option>
									<%}%>
								</select>
								<div class="clear"></div>			
								
								<div id="divName">								
								<table>
								<tr>
								<th>Group Name</th>
								<th><label class="value"></label></th>
								</tr>								
								</table>								
								</div>								
								</div>								
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								</form>
							<script>

								function display(obj){
									 submitProtoAjaxWithDivName('speciality','/hms/hms/generalMaster?method=showGroupAndParameterValues&tempLate='+obj,'divName');
										 
									
								}
								var newwindow;
								function popwindow(url)
								{
								 newwindow=window.open(url,'name','height=500,width=800,status=1');
								 if (window.focus) 
								 {
								 newwindow.focus()
								 }
								newwindow.createPopup();
								 }
								
								function getFamilyHistoryTemplate(value)
								{
									
								var url='/hms/hms/generalMaster?method=showPopUpForValues&departmentId='+value+'' ;
								 popwindow(url);
								} 
</script>	
								

	<%-- 							<script>
	var masSpGrpList=new Array();
	 <% 
	 int x=0;
	 for (MasSpecialtyGroupParameter masGruplist : masSpGrpList){
		%>
		masSpGrpList[<%=x%>]=new Array();
		masSpGrpList[<%=x%>][0]='<%=masGruplist.getSpGroup().getId()%>';
		masSpGrpList[<%=x%>][1]='<%=masGruplist.getSpParameter().getId()%>';
		masSpGrpList[<%=x%>][2]='<%=masGruplist.getSpParameter().getSpParameterName()%>';
		
		
		<%
	x++;	
	 }%>
	 
	 function onGroupChange(val){
		 var obj=document.getElementById('parameter');
		 obj.options.length=0;
		 var j=0;
		 for(var i=0;i<masSpGrpList.length;i++)
			 {
			 if(val==masSpGrpList[i][0])
				 {
				 obj.options[j] = new Option(masSpGrpList[i][2], masSpGrpList[i][1]);
				 j++;
				 }
			 }
	 }
	 
	function fun(val){
		document.getElementById("view").style.display="none";
		if(val=="LOV"){
			document.getElementById("view").style.display="";
		}
	}
	function fun2(val){
		document.getElementById("view2").style.display="none";
		if(val=="Yes"){
			document.getElementById("view2").style.display="";
		}
	}
	
	
	function add1(){
		var table=document.getElementById("safetyPM"); 
		var tableLength=table.rows.length;
		var iteration=tableLength;
		var row=table.insertRow(tableLength);
		var cell2 = row.insertCell(0);
		 var e2 = document.createElement('input');
		  e2.type = 'checkbox';
		  e2.name='Item';
		  e2.id='Item'+iteration;
		  cell2.appendChild(e2);
		  var e2 = document.createElement('input');
		  e2.type = 'hidden';
		  e2.name='ItemId';
		  e2.id='ItemId'+iteration;
		  cell2.appendChild(e2);
		  
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.name='values';
		 
		  e2.id='values'+iteration;
		  cell2.appendChild(e2);
		  
		  
		 	 
	}
	function removeRow(){
		var table=document.getElementById("safetyPM"); 
		var tableLength=table.rows.length;
		var item=document.getElementsByName("Item");
		var itemLength=0;
		for(var i=0;i<item.length;i++){
			if(item[i].checked==true){
				itemLength=itemLength+1;
			}
		}
		if((itemLength+2)<=tableLength){
			for(var i=0;i<item.length;i++){
				if(item[i].checked==true){
					table.deleteRow(i+1);
				}
		}
		}else{
			alert("You Con't Delete!");
		}
	}
	
	function openPopupWindow()
	  {
	  	var id = document.getElementById('safetyP').value;
//	  	var mode = document.getElementById('mode').value;
	  	var url="/hms/hms/generalMaster?method=imageBowserJSP&RequestId="+id;
	   	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	  }
	
	
	function submitRecords(){

		var fname = document.getElementById('fileNameId').value;
		var ind1 = fname.lastIndexOf("\\");
		if(fname!="")
		{
		var filename = fname.substring(ind1+1);
		if(filename.lastIndexOf(".jpg")==-1){
		alert("File Type is InCorrect choose Another");
		document.getElementById('fileNameId').value="";
		}else{
		document.shareHolderLedger.method="post";
		submitForm('shareHolderLedger','/erp/erp/legal?method=saveShareHolderLedger&filename='+filename);
		}
		}else{
			document.shareHolderLedger.method="post";
			submitForm('shareHolderLedger','/erp/erp/legal?method=saveShareHolderLedger');
			}
		
		
	}
	
	 function isNumberKey(evt)
     {
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
               	
         return false;
        
        	
        return true;
     }
	
	
	</script>
								<script>
								
	 document.state.<%=CODE%>.focus();
			</script>


								<div class="clear"></div>
							</div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div id="edited"></div>
	<input type="button" name="add" id="addbutton" value="Add"
		class="button"
		onClick="submitForm('state','generalMaster?method=addDepartmentGroupParameter');"
		accesskey="a" tabindex=1 /> <input type="button" name="edit"
		id="editbutton" value="Update" style="display: none;" class="button"
		onClick="submitForm('state','generalMaster?method=editDepartmentGroupParameter')"
		accesskey="u" tabindex=1 /> <input type="button" name="Delete"
		id="deletebutton" value="Activate" class="button"
		style="display: none;"
		onClick="submitForm('state','generalMaster?method=deleteDepartmentGroupParameter&flag='+this.value)"
		accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
		id="reset" value="Reset" class="buttonHighlight"
		onclick="resetCheck();" accesskey="r" /> <input type="hidden"
		name="<%=STATUS %>" value="" /> <input type="hidden"
		name="<%= COMMON_ID%>" value="" /> <input type="hidden"
		id="pageNoEdit" name="pageNoEdit" value="<%=pageNo%>" />
	<!--  -->
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="bottom">
		<label> Changed By: </label> <label class="value"><%=userName%></label>
		<label> Changed Date: </label> <label class="value"><%=date%></label>
		<label> Changed Time: </label> <label class="value"><%=time%></label>
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
</form>
<script type="text/javascript">
data_header = new Array();



data_header[0] = new Array;
data_header[0][0] = "Department"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "dpartName"

data_header[1] = new Array;
data_header[1][0] = "Group"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "grpName";

data_header[2] = new Array;
data_header[2][0] = "Value Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= VALUE_TYPE %>";


data_header[3] = new Array;
data_header[3][0] = "Image  Required"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= IMG_REQ %>";



data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>";


	
data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"



data_arr = new Array();


<%
Iterator itr=masSpDepGrp.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityDeptGroup  masSpParameter = (MasSpecialityDeptGroup)itr.next(); 
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSpParameter.getId()%>

<%
Iterator itrGridDepartmentTypeList=masDpGridList.iterator();
while(itrGridDepartmentTypeList.hasNext())
   {
	 
	 try{
		 MasDepartment  departmentTypeGrid = (MasDepartment)itrGridDepartmentTypeList.next(); 
	 if(masSpParameter.getDepartment().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("y")){%>
	 data_arr[<%= counter%>][1] = "<%=masSpParameter.getDepartment().getDepartmentName()%>"
	<%}else if(masSpParameter.getDepartment().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("n")){%>
	 data_arr[<%= counter%>][1] = "<%=masSpParameter.getDepartment().getDepartmentName()%>"
		
	<%}
   }catch(Exception e){e.printStackTrace();}}
   System.out.println("Error in department");
   
   %>

   
   <%
   Iterator itrForGrid=masSpGrpList.iterator();
   while(itrForGrid.hasNext())
      {
   	 
   	 try{
   		MasSpecialtyGroupParameter masSpecialGp = (MasSpecialtyGroupParameter)itrForGrid.next(); 
   	 if( masSpParameter.getSpGroup().getSpGroup().getId().equals(masSpecialGp.getSpGroup().getId()) && masSpecialGp.getStatus().equalsIgnoreCase("y")){%>
   	data_arr[<%= counter%>][2] = "<%= masSpParameter.getSpGroup().getSpGroup().getSpGroupName()%>"
   	<%}else if(masSpParameter.getSpGroup().getSpGroup().getId().equals(masSpecialGp.getId()) && masSpecialGp.getStatus().equalsIgnoreCase("n")){%>
   	data_arr[<%= counter%>][2] = "<%= masSpParameter.getSpGroup().getSpGroup().getSpGroupName()%>"
   		
   	<%}
      }catch(Exception e){e.printStackTrace();}}
   System.out.println("Error in Group");   
   
      %>
   


<%
Iterator itrGridDepartmentTypeList=gridDepartmentTypeList.iterator();
 while(itrGridDepartmentTypeList.hasNext())
    {
	 
	 try{
     MasDepartmentType  departmentTypeGrid = (MasDepartmentType)itrGridDepartmentTypeList.next(); 
   
	 if(masDepartment.getDepartmentType().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("y")){%>
		data_arr[<%= counter%>][3] = "<%=departmentTypeGrid.getDepartmentTypeName()%>"
	<%}else if(masDepartment.getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentTypeGrid.getDepartmentTypeName()%>";
		
	<%}
    }catch(Exception e){e.printStackTrace();}}%>




data_arr[<%= counter%>][1] = "<%=masSpParameter.getDepartment().getDepartmentName()%>" 


data_arr[<%= counter%>][2] = "<%= masSpParameter.getSpGroup().getSpGroup().getSpGroupName()%>"



data_arr[<%= counter%>][3] = "<%= masSpParameter.getValueType()%>"
data_arr[<%= counter%>][4] = "<%= masSpParameter.getImageReq()%>"

	<% if(masSpParameter.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][5] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][5] = "InActive"
	<%}%>
data_arr[<%= counter%>][6] = "<%= masSpParameter.getLastChgBy()%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masSpParameter.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masSpParameter.getLastChgTime() %>"

<%
       counter++;
}
%> --%>


<%-- 
<%
Iterator itr=masGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasSpecialityGroup  masGroup = (MasSpecialityGroup)itr.next(); 
%>


data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masGroup .getId()%>
data_arr[<%= counter%>][1] = "<%=masGroup .getSpGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masGroup .getSpGroupName()%>"
<%
		Iterator itrGridGroupList=gridGroupList.iterator();
		 while(itrGridGroupList.hasNext())
            {
			 MasSpecialityGroup  masGroupItr = (MasSpecialityGroup)itrGridGroupList.next(); 
            
			 if(masGroupItr.getSpGroupName().getId().equals(masGroupItr.getId()) && masGroupItr.getStatus().equalsIgnoreCase("y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masGroupItr.getSpGroupName()%>"
			<%}else if(masGroupItr.getSpGroupName().getId().equals(masGroupList.getId()) && masGroupList.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masGroupList.getSpGroupName()%>";
				
			<%}
}%>

data_arr[<%= counter%>][4] = "<%= masGroupList.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masGroupList.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masGroupList.getLastChgTime() %>
	"
<% if(masGroupList.getStatus().equalsIgnoreCase("y")){ %>
	data_arr[
<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 --%>
<%-- formName = "speciality"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);
	
//pgNo = '<%=pageNo%>';
//totalPages = Math.ceil(data_arr.length/rowsPerPage);
//goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script> --%>


