<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for Grade.
 * @author  Mansi
 * Create Date: 17th April,2015
 * Revision Date:      
 * Revision By:  
 * @version 1.9;
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.HrMasSanctionedPostOrder"%>

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
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

List<MasCadre> masCadreList = new ArrayList<MasCadre>();
List<HrMasSanctionedPostOrder> sanctionedPostOrderList = new ArrayList<HrMasSanctionedPostOrder>();
/* ArrayList sanctionPostOrder = (ArrayList)map.get("sanctionPostOrder"); */

if(map.get("CadreList") != null){
	masCadreList=(List<MasCadre> ) map.get("CadreList");	
}

if(map.get("sanctionedPostOrderList") != null){
	sanctionedPostOrderList=(List<HrMasSanctionedPostOrder> ) map.get("sanctionedPostOrderList");	
}

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }

%>
<script type="text/javascript">
function check(){
var SDate = document.grade.<%="orderDateId"%>.value;
var EDate = document.grade.<%= END_DATE %>.value;

if (SDate == '' || EDate == '') {
alert("Plesae enter both....");
return false;
}
var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
if(startDate > endDate)
{
alert("Please ensure that the End Date is greater than or equal to the Start Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<div class="titleBg">
<h2>Sanction Post Order Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Order No</label>
<input type="text" id="searchField" name="<%= CODE%>"	value="" validate="Order No,string,no" MAXLENGTH="10" tabindex=1	onkeypress="return submitenter(this,event,'personnel?method=searchUnit')" />

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchOrderNo','checkSearch')"	tabindex=1 />
 <%--- Report Button   --%>
<!-- <input type="button"	name="Report" value="Generate Report Based on Search" class="button"	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"	accesskey="g" tabindex=1 />  -->

<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_Grade">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>
</div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<%// System.out.println(">>>>>>>>>"+sanctionedPostOrderList.size());
		if(sanctionedPostOrderList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("gradeCode");
			//System.out.println(">>>>>>>>>"+strForAddressDescription);
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%>
	<a href="generalMaster?method=showSanctionPostOrderJsp">Show All Records</a> 
	<%
			}
		 }
	 if(sanctionedPostOrderList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="generalMaster?method=showSanctionPostOrderJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"orderDateId"], [3,"cadre"],  [4,"noPost"],  [5,"remarks"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"type"],[10,"<%=STATUS%>"] ];
	 statusTd = 10;
	</script></div>

<form name="grade" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input	type="hidden" name="<%= POJO_NAME %>" value="HrMasSanctionedPostOrder">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="OrderNo">
<input	type="hidden" name="title" value="HrMasSanctionedPostOrder">
<input	type="hidden" name="<%=JSP_NAME %>" value="sanctionPostOrder">
<input	type="hidden" name="pojoPropertyCode" value="OrderNo">
<div class="paddingTop5"></div>
<div class="clear"></div>

<div class="Block">
<label>Order No<span>*</span></label>

<input	type="text" name="<%= CODE %>" value=""	validate="Order No,string,yes" class="textbox_size20" MAXLENGTH="30"	 tabindex=1> 
<script>
		document.grade.<%=CODE%>.focus();
</script>

<label> Order Date<span>*</span></label> 
<input	type="text" id="orderDateId" name="orderDateId" value=""	class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Order Date,date,yes"/>
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('',document.grade.<%="orderDateId"%>,event)" />

 <label>Cadre<span>*</span> </label> 
<select id="cadre"	name="cadre" validate="Cadre ,string,yes" tabindex=1>
	<option value="">Select</option>
	 <% 
		for (MasCadre  mcl : masCadreList)
		{
	%>
	<option value="<%=mcl.getId()%>"><%=mcl.getCadreName()%></option>
	<%
		}
	%> 
</select> 
<div class="clear"></div> 
<!-- <label><span>*</span>No of Posts</label> 
<input type="text"	name="noPost" value="" validate="No of Posts,num,no"	class="textbox_size20" MAXLENGTH="50"  tabindex=1> -->

<label>Type <span>*</span></label> 
<select id="type"	name="type" validate="Type ,string,no" tabindex=1>

	<option value="">Select</option>
	<option value="Go">GO</option>
	<option value="Office Order">Office Order</option>	 
</select> 
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('grade','generalMaster?method=addSanctionPostOrder');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('grade','generalMaster?method=editSanctionPostOrder')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('grade','generalMaster?method=deleteSanctionPostOrder&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('grade','generalMaster?method=showSanctionPostOrderJsp')" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> <input type="hidden"	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By</label> 
<label	class="value"><%=userName%></label>
 
<label>Changed Date</label> 
<label	class="value"><%=date%></label> 

<label>Changed Time</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Order No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Order Date"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "orderDateId";

data_header[2] = new Array;
data_header[2][0] = "Cadre"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "cadre"


	data_header[3] = new Array;
	data_header[3][0] = "No of post"
	data_header[3][1] = "hide";
	data_header[3][2] = 0;
	data_header[3][3] = "noPost"
	
	data_header[4] = new Array;
	data_header[4][0] = "Remarks"
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "remarks"
			
data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Type"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "type";


data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=sanctionedPostOrderList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasSanctionedPostOrder  hmspo = (HrMasSanctionedPostOrder)itr.next(); 
%>

 data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hmspo.getId()%>;
data_arr[<%= counter%>][1]="<%=hmspo.getOrderNo()%>";
data_arr[<%= counter%>][2]="<%= hmspo.getOrderDate()!=null ? HMSUtil.convertDateToStringWithoutTime(hmspo.getOrderDate()) :" "%>";


<%
Iterator itrmasCadreList=masCadreList.iterator();
 while(itrmasCadreList.hasNext())
    {
     MasCadre  masCadre = (MasCadre)itrmasCadreList.next(); 
    
	 if( hmspo.getCadre()!=null &&  hmspo.getCadre().getId().equals(masCadre.getId()) && masCadre.getStatus().equalsIgnoreCase("Y")){
	
	 %>
		data_arr[<%= counter%>][3] = "<%=masCadre.getCadreName() %>";
	<%}else if( hmspo.getCadre()!=null  &&  hmspo.getCadre().getId().equals(masCadre.getId()) && masCadre.getStatus().equalsIgnoreCase("n")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masCadre.getCadreName() %>";
		
	<%}
}%>

data_arr[<%= counter%>][4]="<%=hmspo.getNoOfPosts()%>";
data_arr[<%= counter%>][5]="<%=hmspo.getDescription()%>";


data_arr[<%= counter%>][6] = "<%= hmspo.getLastChgBy()!=null?(hmspo.getLastChgBy().getId()!=null?hmspo.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hmspo.getLastChgDate()) %>";
data_arr[<%= counter%>][8] = "<%= hmspo.getLastChgTime() %>";
	data_arr[<%= counter%>][9] = "<%=hmspo.getType() !=null ?   hmspo.getType() :" " %>"
<% if(hmspo.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][10] = "Active";
<%}else{%>
data_arr[<%= counter%>][10] = "InActive";
<%}%>
<%
		     counter++;
}
%>
 
formName = "grade"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
