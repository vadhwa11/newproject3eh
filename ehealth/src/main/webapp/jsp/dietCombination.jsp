<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemGeneric.jsp  
 * Purpose of the JSP -  This is forDietDietType.
 * @author Dipali
 * Create Date: 26th March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@ page import="jkt.hms.masters.business.MasMenuType"%>
<%@ page import="jkt.hms.masters.business.MasDietItems"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDietCombination"%>
<%@ page import="jkt.hms.masters.business.MasDietType"%>
<%@ page import="jkt.hms.masters.business.MasDiet"%>


<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchDietDietTypeList = (ArrayList)map.get("searchDietDietTypeList");
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasDiet> dietListGrid = new ArrayList<MasDiet>();
	List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
	List<MasDietItems> dietItemList = new ArrayList<MasDietItems>();
	List<MasDietItems> dietItemListGrid = new ArrayList<MasDietItems>();
	List<MasMenuType> masMenuTypes = new ArrayList<MasMenuType>();
	List<MasMenuType> masMenuTypesGrid=new ArrayList<MasMenuType>();
	
	masMenuTypes=(ArrayList)map.get("masMenuTypes");
	dietListGrid=(ArrayList)map.get("dietListGrid");
	dietItemList=(ArrayList)map.get("dietItemList");
	dietItemListGrid=(ArrayList)map.get("dietItemListGrid");
	dietTypeList = (ArrayList)map.get("dietTypeList");
	dietList = (ArrayList)map.get("dietList");
	masMenuTypesGrid=(ArrayList)map.get("masMenuTypesGrid");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
 %>
 <div class="titleBg">
<h2>Diet Combination</h2>
</div>
<div class="Block">
<div id="searcharea">
<div class="clear"></div>
<div id="searchbar">
<div class="clear"></div>
<form name="search" method="post" action="">
<label >Diet</label> 
<input type="text" id="searchField" 	name="<%=SEARCH_NAME%>" value="" validate="Diet Diet Type,string,no"	MAXLENGTH="8"	onkeypress="return submitenter(this,event,'canteen?method=searchDietCombination')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','canteen?method=searchDietCombination','checkSearch')"	tabindex=1 />
 <%--- Report Button   --%> <input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
 <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_diet_diet_type"> 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div class="clear"></div>
<div id="searchtable" tabindex=2></div>
<div class="clear"></div>
<% 
  if(searchDietDietTypeList.size()>0)
   {
   String strForCode = (String)map.get("dietName");
   if(strForCode!= null && strForCode!= "" )
   {
 %> 
 <div class="clear"></div>
<h4><a href="canteen?method=showDietCombinationJsp">Show All Records</a> </h4><%
		
		
		  }
	   }
	 if(searchDietDietTypeList.size()==0 && map.get("search") != null)
	  {
	 %><div class="clear"></div> 
	 <a href="canteen?method=showDietCombinationJsp">Show All
Records</a> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= DIET_ID%>"],[2,"<%= DIET_ITEMS %>"],[3,"<%= DIET_COMBINATION_NAME %>"],[4,"<%= CHANGED_BY %>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%= STATUS%>"],[8,"<%= MENU_TYPE%>"],[9,"<%= "items"%>"], [10,"<%= "dquat"%>"] ];
  statusTd =7;
 </script></div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<form name="dietDietType" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="MasDietCombination"><input
	type="hidden" name="title" value="DietCombination"><input
	type="hidden" name="<%=JSP_NAME %>" value="dietCombination">

<div class="Block">
<div id=contentoperation><label >Diet<span>*</span> </label> 
<select name="<%=DIET_ID %>"	validate="Diet,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(dietList != null){ 	
          			for (Iterator iter = dietList.iterator(); iter.hasNext();) {
          				MasDiet masDiet = (MasDiet) iter.next();
          %>
	<option value="<%=masDiet.getId() %>"><%=masDiet.getDietName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<%--  <label ><font id="error">*</font>Diet
Type: </label> <select name="<%=DIET_TYPE_ID %>" validate="Diet Type,string,no"
	tabindex=1>
	<option value="">Select</option>
	<%
          		if(dietTypeList != null){ 	
          			for (Iterator iter = dietTypeList.iterator(); iter.hasNext();) {
          				MasDietType masDietType = (MasDietType) iter.next();
          %>
	<option value="<%=masDietType.getId() %>"><%=masDietType.getDietTypeName() %></option>
	<%		
         			}
         		 } 
         %>
</select> --%>

 <label > Diet Combination Name <span>*</span> </label>
 <input type="text" name="<%= DIET_COMBINATION_NAME%>"	value="" validate="Diet Combination Name,string,yes"	class="textbox_size20" MAXLENGTH="30" tabindex=1 />
	
	 <label>Menu</label>
	<select name="<%= MENU_TYPE %>"
	validate="Menu,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(masMenuTypes != null){ 	
          			for (Iterator iter = masMenuTypes.iterator(); iter.hasNext();) {
          				MasMenuType masType = (MasMenuType) iter.next();
          %>
	<option value="<%=masType.getId() %>"><%=masType.getMenuName().trim()%></option>
	<%		
         			}
         		 } 
         %>
</select>
	<div class="clear"></div>	
	 <label>Diet Item</label>
	<select name="items"  	validate="Diet Item,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(dietItemList != null){ 	
          			for (Iterator iter = dietItemList.iterator(); iter.hasNext();) {
          				MasDietItems masDietItems = (MasDietItems) iter.next();
          %>
	<option value="<%=masDietItems.getId() %>"><%=masDietItems.getDietItemsName().trim() %></option>
	<%		
         			}
         		 } 
         %>
</select>

<label>Diet quantity</label>
<input type="text" name="dquat" validate="Diet quantity,float,yes" />	

    <input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" 	/>
	 <input type="hidden" name="<%= CHANGED_DATE %>" value="<%=date%>" />
	 <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

</div>
<div class="clear"></div>

<div id="edited"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('dietDietType','canteen?method=addDietCombination');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('dietDietType','canteen?method=editDietCombination')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('dietDietType','canteen?method=deleteDietCombination&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
</div>	
</form>
</div>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Diet"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%= DIET_ID%>"

 data_header[1] = new Array;
data_header[1][0] = "Diet Type"
data_header[1][1] = "hide";
data_header[1][2] = "10%";
data_header[1][3] = "<%= DIET_TYPE_ID %>"; 

data_header[2] = new Array;
data_header[2][0] = "Diet Combination Name"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=DIET_COMBINATION_NAME %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "<%=STATUS %>"

data_header[7] = new Array;
data_header[7][0] = "Menu"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%= MENU_TYPE%>"

data_header[8] = new Array;
data_header[8][0] = "Item"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%= "items"%>"

data_header[9] = new Array;
data_header[9][0] = "Quantity"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "<%= "dquat"%>"




data_arr = new Array();
<%
Iterator itr=searchDietDietTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasDietCombination  masDietDietType = (MasDietCombination)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDietDietType.getId()%>
<%
Iterator itrDietList=dietListGrid.iterator();
while(itrDietList.hasNext())
      {
       MasDiet  masDietGrid = (MasDiet)itrDietList.next(); 
	 if(masDietDietType.getDiet().getId().equals(masDietGrid.getId()) && masDietGrid.getStatus().equalsIgnoreCase("y")){%>
		data_arr[<%= counter%>][1] = "<%=masDietGrid.getDietName()%>"
	<%}else if(masDietDietType.getDiet().getId().equals(masDietGrid.getId()) && masDietGrid.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masDietGrid.getDietName()%>";
	<%}
}%>
<%-- <%
Iterator itrDietTypeList=dietTypeList.iterator();
while(itrDietTypeList.hasNext())
      {
       MasDietType  masDietTypeGrid = (MasDietType)itrDietTypeList.next(); 
       if(masDietDietType!=null){
	 if(masDietDietType.getDietType().getId().equals(masDietTypeGrid.getId()) && masDietTypeGrid.getStatus().equalsIgnoreCase("y")){%>
		data_arr[<%= counter%>][2] = "<%=masDietTypeGrid.getDietTypeName()%>"
	<%}else if(masDietDietType.getDietType().getId().equals(masDietTypeGrid.getId()) && masDietTypeGrid.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masDietTypeGrid.getDietTypeName()%>";
	<%}
       }
}%> --%>

data_arr[<%= counter%>][3] = "<%= masDietDietType.getDietCombinationName() %>"
data_arr[<%= counter%>][4] = "<%= masDietDietType.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masDietDietType.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masDietDietType.getLastChgTime() %>"
<% if(masDietDietType.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
if(masMenuTypes!=null){

Iterator itrDList=masMenuTypesGrid.iterator();
while(itrDList.hasNext())
      {
	
       MasMenuType  masmenuTypeGrid = (MasMenuType)itrDList.next(); 
     if(masDietDietType.getMenu()!=null && masmenuTypeGrid.getId()!=null) {
	 if(masDietDietType.getMenu().getId().equals(masmenuTypeGrid.getId()) && masmenuTypeGrid.getStatus().equalsIgnoreCase("y")){%>
		data_arr[<%= counter%>][8] = "<%=masmenuTypeGrid.getMenuName()%>"
	<%

		}else if(masDietDietType.getMenu().getId().equals(masmenuTypeGrid.getId()) && masmenuTypeGrid.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masmenuTypeGrid.getMenuName()%>";
	<%}
     }
}
}
%>

<%
Iterator itrDL=dietItemListGrid.iterator();
while(itrDL.hasNext())
      {
       MasDietItems  masItems = (MasDietItems)itrDL.next(); 
	 if(masDietDietType.getDietItems().getId().equals(masItems.getId()) && masItems.getStatus().equalsIgnoreCase("y")){%>
		data_arr[<%= counter%>][9] = "<%=masItems.getDietItemsName()%>"
	<%}else if(masDietDietType.getDietItems().getId().equals(masItems.getId()) && masItems.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masItems.getDietItemsName()%>";
	<%}
}
%>


data_arr[<%= counter%>][10] = "<%= masDietDietType.getDietQuantity()%>"


<%
       counter++;
}
%>
 
formName = "dietDietType"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>


