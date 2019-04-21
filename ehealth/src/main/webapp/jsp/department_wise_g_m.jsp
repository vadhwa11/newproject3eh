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

<%@page import="jkt.hms.masters.business.SpDeptGroupT"%>
<%@page import="jkt.hms.masters.business.SpDeptGroupM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.SpGroupParameterT"%>
<%@page import="jkt.hms.masters.business.SpGroupParameterM"%>
<%@page import="jkt.hms.masters.business.MasSpecialityParameter"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<SpDeptGroupM>  deptGroupMs = new ArrayList<SpDeptGroupM>();
		List<SpDeptGroupT> deptGroupTs=new ArrayList<SpDeptGroupT>();
		
		List<MasSpecialityParameter> masSpParaList = new ArrayList<MasSpecialityParameter>();
		List<MasDepartment> masDpList = new ArrayList<MasDepartment>();
		List<MasSpecialityGroup> masSpGrpList = new ArrayList<MasSpecialityGroup>();
		
		Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT=new HashMap<Integer, List<SpDeptGroupT>>();
			
		
		
		
		String userName = "";
		
		map.put("masSpParaList", masSpParaList);
		map.put("masSpGrpList", masSpGrpList);
		map.put("masDpList", masDpList);
		
		map.put("deptGroupMs", deptGroupMs);
		map.put("deptGroupTs", deptGroupTs);
		
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masSpGrpList") != null){
			masSpGrpList = (ArrayList)map.get("masSpGrpList");
		}
			
	    if(map.get("masSpParaList") != null){
	    	masSpParaList = (ArrayList)map.get("masSpParaList");
	      }
	    if(map.get("masDpList") != null){
	    	masDpList = (ArrayList)map.get("masDpList");
	      }
	    
	    if(map.get("deptGroupMs")!=null){
	    	deptGroupMs=(List<SpDeptGroupM>)map.get("deptGroupMs");
	    } 
	    
	    if(map.get("deptGroupTs")!=null){
	    	deptGroupTs=(List<SpDeptGroupT>)map.get("deptGroupTs");
	    } 
	    
	    if(map.get("mapForSpDepGroupPaT")!=null){
	    	mapForSpDepGroupPaT=(Map<Integer, List<SpDeptGroupT>>)map.get("mapForSpDepGroupPaT");
	    } 
	    
	    System.out.println("deptGroupTs.size() in jsp"+deptGroupTs.size());
	    System.out.println("mapForSpDepGroupPaT.size() in jsp"+mapForSpDepGroupPaT.size());
	    
	    
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
	<h2>Department Wise Group Parameter Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">
			
			
					
         <label> Department </label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Department ,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=showDepartWiseGrpMaster')" />
					
<input type="button" name="search" value="Search" class="button" id="searchField"	onclick="submitForm('search','generalMaster?method=showDepartWiseGrpMaster','checkSearch')"		tabindex=1 />
				<%--- Report Button   --%>
							
				
			
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
			
			
		</div>
	</div>
	<div class="clear"></div>
</div>


<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<% 
		if(deptGroupMs.size()>0 || deptGroupMs.size() > 0)
		 {
			String strForCode = (String)map.get("groupCode");
			String strForCodeDescription = (String)map.get("groupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4>
		<a href="generalMaster?method=showDepartWiseGrpMaster">Show All Records </a>
	</h4>
	<%
			}
		 }
	 if(deptGroupMs.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="generalMaster?method=showDepartWiseGrpMaster">Show All Records</a>
	</h4>
	<%
     }
	%>
	<script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= STATUS%>"],  [4,"paraMastr"] ];
	 statusTd = 3;

	</script>
</div>

<form name="state" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
	<input type="hidden" name="<%= POJO_NAME %>" value="SpDeptGroupM">
		<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Department">
			<input type="hidden" name="<%=POJO_PROPERTY_CODE %>"
			value="SpGroup"> <input type="hidden" name="title"
				value="Group"> <input type="hidden" name="<%=JSP_NAME %>"
					value="SpDepartParameter"> <input type="hidden" name="pojoPropertyCode"
						value="SpGroup">

							<div class="paddingTop15"></div>
							<div class="clear"></div>
							<div class="Block">
							
<label><span>*</span>Department</label> <select name="dpartName" validate="Group,string,yes" tabindex=1>
			<option value="">Select</option>
            <% 
				for ( MasDepartment masDepartment: masDpList){
				%>
	        <option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
            
		</select>
							
							
							
	<label><span>*</span> Group </label> <select name="grpName" validate="Group,string,yes" tabindex=1>
			<option value="">Select</option>
            <% 
				for ( MasSpecialityGroup masGruplist : masSpGrpList){
				%>
	        <option value="<%=masGruplist.getId ()%>"><%=masGruplist.getSpGroupName()%></option>
	<%}%>
            
		</select>    
		
			<div class="clear"></div>
			
	 <label><span>*</span>Parameter</label> <select name="paraMeterVales" multiple size="3"  validate="Parameter,string,yes" tabindex=1 class="list">
	   <option value="">Select</option>
            <% 
				for ( MasSpecialityParameter paraaraList : masSpParaList){
				%>
       	<option value="<%=paraaraList.getId()%>"><%=paraaraList.getSpParameterName()%></option>
	<%}%>
            
		</select>    
		<script>
								
			<%-- document.state.<%=CODE%>.focus(); --%>
			</script>


								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<div class="division"></div>
							<div class="clear"></div>
							<div id="edited"></div>
							
							 <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('state','generalMaster?method=addDepartmentGrPara');"accesskey="a" tabindex=1 />
							
							 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;"
							class="button"	onClick="submitForm('state','generalMaster?method=editGroupToDatabase')"
							accesskey="u" tabindex=1 /> 
							
							
							<input type="button" name="Delete"id="deletebutton" value="Activate" class="button"
							style="display: none;" onClick="submitForm('state','generalMaster?method=deleteDepartWiseGrpMaster&flag='+this.value)"
							accesskey="d" tabindex=1 />
							
							 <input type="reset" name="Reset"id="reset" value="Reset" class="buttonHighlight"
							onclick="resetCheck();" accesskey="r" />
							
							 <input type="hidden"name="<%=STATUS %>" value="" /> <input type="hidden"
							name="<%= COMMON_ID%>" value="" /> 
							
							<!-- Added By Ritu for edit page-->
							
							<input type="hidden" id="pageNoEdit" name="pageNoEdit"
							value="<%=pageNo%>" /> <!--  -->
							<div class="clear"></div>
							<div class="division"></div>
							<div class="clear"></div>
							<div class="bottom">
								<label> Changed By: </label> <label class="value"><%=userName%></label>
								<label> Changed Date: </label> <label class="value"><%=date%></label>
								<label> Changed Time: </label> <label class="value"><%=time%></label>
								<input type="hidden" name="<%=CHANGED_BY%>"
									value="<%=userName%>" /> <input type="hidden"
									name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
									type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
							</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Department"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Group"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Parameter"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "name";


 data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= STATUS%>";
	<%--
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
 --%>


data_arr = new Array();


<%
Iterator itr=deptGroupMs.iterator();
System.out.println("====="+deptGroupTs.size());
          int  counter=0;
//           while(itr.hasNext())
//            {
//              SpGroupParameterM  mas = (SpGroupParameterM)itr.next(); 
		int chekDup=0;
		  for(SpDeptGroupT spDepGroupT :deptGroupTs){
		if(chekDup!=spDepGroupT.getDeptGroupM().getId()){		
	
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = '<%= spDepGroupT.getDeptGroupM().getId()%>'
data_arr[<%= counter%>][1] = '<%=spDepGroupT.getDeptGroupM().getDepartment().getDepartmentName()%>'
data_arr[<%= counter%>][2] = '<%=spDepGroupT.getDeptGroupM().getSpGroup().getSpGroupName()%>'

 <%
String name =""; 
	List<SpDeptGroupT> check=mapForSpDepGroupPaT.get(spDepGroupT.getDeptGroupM().getId()); 
	boolean b=false;
	for(SpDeptGroupT t:check){
		if(b){
			name=name.concat(",");
			b=false;
		}  
		name=name.concat(t.getSpParameter().getSpParameterName());
		b=true;
	}
	chekDup=spDepGroupT.getDeptGroupM().getId();
%> 

data_arr[<%= counter%>][3] = '<%= name%>' 

	<% if(spDepGroupT.getDeptGroupM().getStatus().equalsIgnoreCase("y")){ %>
	data_arr[<%= counter%>][4] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][4] = "InActive"
	<%}%>

	<%--
data_arr[<%= counter%>][4] = '<%="Active"%>'





	 <% if(mas.){ %>
	data_arr[<%= counter%>][3] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][3] = "InActive"
	<%}%>
data_arr[<%= counter%>][4] = "<%= mas.getLastChgBy()%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(mas.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= mas.getLastChgTime() %>" --%>

<%
counter++;
			}}
%>


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
formName = "state"

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
</script>
