<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp
 * Purpose of the JSP -  This is for Department details
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:
 * Revision By:
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasLioncSubClass"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
	List<MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
	List<MasLioncSubClass> lioncSubClassList = new ArrayList<MasLioncSubClass>();
	List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
	mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
	lioncSubClassList = (ArrayList)map.get("masLioncSubClassList");
	subChargecodeList = (ArrayList)map.get("subChargecodeList");

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		  <h4><span><%=message %></span></h4>
		 <%} %>
<div class="clear"></div>
<div class="titleBg">
<h2>LionC Class Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
	<label>LionC Class</label>
 	 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="LionC Class,alphanumeric,yes"
	MAXLENGTH="12" tabindex=1 />
	<input type="button" name="search" value="Search" class="button"onclick="submitForm('search','investigation?method=searchLionSubClass')"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


</div>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
		if(lioncSubClassList.size()>0 )
		 {

	%> <h4><a href="investigation?method=showLioncSubClassJsp">Show All
Records</a></h4> <%
			}

	if(lioncSubClassList.size()==0 )
	  {
    %><h4> <a href="investigation?method=showLioncSubClassJsp">Show
All Records</a></h4> <%
           }
         %> <script type="text/javascript">

	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= MAIN_CHARGECODE_ID%>"], [2,"<%= SUB_CHARGECODE_ID %>"], [3,"<%= LIONC_CLASS_NAME %>"],[4,"<%=STATUS%>"] ];
	 statusTd = 4;
	</script></div>

<form name="lionSubClassName" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasDepartment"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DepartmentName"><input
	type="hidden" name="title" value="Department"><input
	type="hidden" name="<%=JSP_NAME %>" value="department"><input
	type="hidden" name="pojoPropertyCode" value="DepartmentCode">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>

	</script>
	<input type="hidden" name="<%=COMMON_ID%>" value=""/>
	 <label><span>*</span> Main Charge Code</label>
	 <select id="<%=MAIN_CHARGECODE_ID %>" name="<%= MAIN_CHARGECODE_ID %>" validate="Main Charge Code,string,yes" tabindex=1 onChange="populateSubChargeCode(this.value,'lionSubClassName')">
	<option value="">Select</option>
	<%
		for (MasMainChargecode  masMainChargecode : mainChargecodeList){
	  %>
	<option value="<%=masMainChargecode.getId ()%>"><%=masMainChargecode.getMainChargecodeName()%></option>

	<%}%>

</select>


<script type="text/javascript">
         		 subChargeArray1 = new Array();
				<%
				int count = 0;
				for (Iterator iter = mainChargecodeList.iterator(); iter.hasNext();)
				{
				MasMainChargecode mainChargecode = (MasMainChargecode) iter.next();
				for (Iterator iterSubChargecode = subChargecodeList.iterator(); iterSubChargecode.hasNext();)
				{
					MasSubChargecode subChargecode = (MasSubChargecode) iterSubChargecode.next();
					if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=mainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=subChargecode.getId()%>;
									subChargeArray1[<%=count%>][2] = "<%=subChargecode.getSubChargecodeName()%>";

								<%
								count++;
						}
					}
				}
			%>
			</script>

<label><span>*</span> Sub Charge Code</label> <select
	name="<%= SUB_CHARGECODE_ID %>" validate="Sub Charge Code,string,yes" tabindex=1>

	<option value="">Select</option>
	<%
				if(subChargecodeList.size() >0){
				for (MasSubChargecode subChargecode : subChargecodeList){

				%>
	<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>


	<%}}%>
</select>
<div class="clear"></div>
	<label><span>*</span> LionC Class</label>
	 <input type="text" id="subChargeCode" name="<%= LIONC_CLASS_NAME %>" validate="Lionc Class,string,yes" tabindex=1>
	<div id="ac2update" class="autocomplete" style="display:none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('subChargeCode','ac2update','investigation?method=getClassForLionC',{parameters:'requiredField=subChargeCode' });
			</script>

<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="if(checkLionClass()){submitForm('lionSubClassName','investigation?method=addLionClass');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button" style="display: none;"
	onClick="submitForm('lionSubClassName','investigation?method=editLionClass')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('lionSubClassName','investigation?method=deleteLionClass&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Main Charge Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= MAIN_CHARGECODE_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Sub Charge Code"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SUB_CHARGECODE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "LionC Class Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=LIONC_CLASS_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=lioncSubClassList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {

             MasLioncSubClass  masLioncSubClass = (MasLioncSubClass)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masLioncSubClass.getId()%>

<%
		Iterator itrGridDepartmentTypeList=mainChargecodeList.iterator();
		 while(itrGridDepartmentTypeList.hasNext())
            {try{
             MasMainChargecode  departmentTypeGrid = (MasMainChargecode)itrGridDepartmentTypeList.next();
			 if(masLioncSubClass.getMainChargeCode().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][1] = "<%=departmentTypeGrid.getMainChargecodeName()%>"
			<%}else if(masLioncSubClass.getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=departmentTypeGrid.getMainChargecodeCode()%>";

			<%}
            }catch(Exception e){e.printStackTrace();}}%>


<%
		Iterator itrGridSubChargeCodeList=subChargecodeList.iterator();
		 while(itrGridSubChargeCodeList.hasNext())
            {try{
             MasSubChargecode subChargeCodeGrid = (MasSubChargecode)itrGridSubChargeCodeList.next();
			 if(masLioncSubClass.getSubChargeCode().getId().equals(subChargeCodeGrid.getId()) && subChargeCodeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][2] = "<%=subChargeCodeGrid.getSubChargecodeName()%>"
			<%}else if(masLioncSubClass.getId().equals(subChargeCodeGrid.getId()) && subChargeCodeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=subChargeCodeGrid.getSubChargecodeName()%>";

			<%}
            }catch(Exception e){e.printStackTrace();}}%>




data_arr[<%= counter%>][3] = "<%= masLioncSubClass.getLionCClass()%>"

<% if(masLioncSubClass.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][4] = "Active"
<%}else{%>
data_arr[<%= counter%>][4] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "lionSubClassName"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');

function checkLionClass()
{

var lionId=document.getElementById('lionNo');

if(lionId==null)
{
alert("Select LionC Class");
return false;
}
else
{
return true;
}

}
</script>
