<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="jkt.hms.masters.business.OtMasChargeDetails"%>
<%@ page import="jkt.hms.masters.business.MasOt"%>
<%@ page import="jkt.hms.masters.business.MasChargeType"%>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
ArrayList searchOtMasChangeDetailsList = (ArrayList)map.get("searchOtMasChangeDetailsList");
List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();
masChargeCodeList = (List<MasChargeCode>)map.get("masChargeCodeList");
List<MasOt> otList = new ArrayList<MasOt>();
List<MasChargeType> chargeTypeList = new ArrayList<MasChargeType>();
if(map.get("chargeTypeList")!=null)
{
	chargeTypeList = (List<MasChargeType>)map.get("chargeTypeList");

}
otList = (List<MasOt>)map.get("otList");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%}
int otMasChargeDetailsId=0;
if(map.get("otMasChargeDetailsId") != null){
	    otMasChargeDetailsId = (Integer)map.get("otMasChargeDetailsId");

	  }
%>
<div class="titleBg">
<h2>OT Charge Details Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label> Charge Code Name </label>
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Days,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'otMaster?method=searchOtMasChargeDetails')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','otMaster?method=searchOtMasChargeDetails','checkSearch')" tabindex=1 />
<%--- Report Button  --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="OT_MAS_CHARGE_DETAILS">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%
  if(searchOtMasChangeDetailsList.size()>0)
   {
   String strForGroupName = (String)map.get("chargeCodeName");
    if(strForGroupName!= null && strForGroupName!= "" )
   {
 %> <h4><a href="otMaster?method=showOtMasChargeDetailsJsp">Show All Records</a></h4> <%

		  }
	   }
	 if(searchOtMasChangeDetailsList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="otMaster?method=showOtMasChargeDetailsJsp">Show All Records</a></h4> <%
    }
	%>
<script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CHARGE_CODE_NAME%>"], [2,"<%= TYPE_OF_REG %>"],[3,"<%= TIME%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=CHARGE_ID%>"],[8,"otName"],[9,"<%=STATUS%>"] ];
  statusTd =9;

 </script></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="otMasChargeDetails" method="post" action="">
<div class="Block">
<label><span>*</span> Charge Code Name </label>
<input type="text" id="chargeCodeName" name="chargeCodeName" validate="Charge Code Name.,String,yes" onblur="fillChargeCode(this.value);" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">new Ajax.Autocompleter('chargeCodeName','ac2update','opd?method=getChargeCodeListForAutoComplete1',{parameters:'requiredField=chargeCodeName'});
</script>
<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>" id="chargeCodeId" />
<input type="hidden" name="<%=CHARGE_ID%>" value=""/>
<label><span>*</span> Type </label>
<select name="<%=TYPE_OF_REG%>" validate="Type,string,yes" tabindex=1>
<option value="0">Select</option>

<%for(MasChargeType masChargeType:chargeTypeList){ %>
<option value="<%=masChargeType.getId() %>"><%=masChargeType.getChargeTypeName()%></option>

<%} %>
</select>

<label class="auto"><span>*</span> Approx Duration(HH:MM)</label>
<input type="text" tabindex=1 id="approxDuration" name="<%=TIME%>" value="" class="textbox_date" validate="Approx Duration,string,yes" MAXLENGTH="5"  onkeyup="mask(this.value,this,'2',':');"  />
<div class="clear"></div>
<label><span>*</span> OT Name</label>
<select name="otName" id="otName" validate="Ot Name,string,yes">
<option value="">Select</option>

<%for(MasOt masOt:otList){ %>
<option value="<%=masOt.getId() %>"><%=masOt.getOtName().trim()%></option>

<%} %>
</select>

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('otMasChargeDetails','otMaster?method=addOtMasChargeDetails');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('otMasChargeDetails','otMaster?method=editOtMasChargeDetails')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button"	onClick="submitForm('otMasChargeDetails','otMaster?method=deleteOtMasChargeDetails&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName%></label>
<label>Changed Date:</label>
<label	class="value"><%=date%></label>
<label>Changed Time:</label>
<label	class="value"><%=time%></label>
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />

 </div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
</script><input type="hidden" name="rows" id="rr" value="1" />
<!--Bottom labels ends--> <!--main content placeholder ends here-->
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Charge Code Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CHARGE_CODE_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Type"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= TYPE_OF_REG %>";


data_header[2] = new Array;
data_header[2][0] = " Approx Time"
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "<%= TIME%>"


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHARGE_ID %>";

data_header[7] = new Array;
data_header[7][0] = "OT Name"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "otName";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchOtMasChangeDetailsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  OtMasChargeDetails  masChargeDetails = (OtMasChargeDetails)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masChargeDetails.getId()%>

<%
		Iterator itroTList=masChargeCodeList.iterator();
		while(itroTList.hasNext())
      	{
			MasChargeCode  masChargeCode = (MasChargeCode)itroTList.next();
	 		if(masChargeDetails.getChargeCode()!=null && masChargeDetails.getChargeCode().getId().equals(masChargeCode.getId()) && masChargeCode.getStatus().equalsIgnoreCase("y"))
	 		{
		 		int  chargeCodeId=masChargeCode.getId();
	 %>
				data_arr[<%= counter%>][1] = "<%=masChargeCode.getChargeCodeName()%>[<%=chargeCodeId%>]"
	<%		}
	 		else if(masChargeDetails.getChargeCode()!=null &&  masChargeDetails.getChargeCode().getId().equals(masChargeCode.getId()) && masChargeCode.getStatus().equalsIgnoreCase("n"))
	 		{
	 %>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masChargeCode.getChargeCodeName()%>"
	<%
			}
		}
%>
<%
Iterator itroTList2=chargeTypeList.iterator();
while(itroTList2.hasNext())
	{
	MasChargeType  masChargeType = (MasChargeType)itroTList2.next();
		if(masChargeDetails.getChargeType()!=null && masChargeDetails.getChargeType().getId().equals(masChargeType.getId()) && masChargeType.getChargeTypeStatus().equals("o"))
		{
%>
		data_arr[<%= counter%>][2] = "<%=masChargeType.getChargeTypeName()%>"
<%		}
		else if(masChargeDetails.getChargeType()!=null && masChargeDetails.getChargeType().getId().equals(masChargeType.getId()) && masChargeType.getChargeTypeStatus().equals("n"))
		{
%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masChargeType.getChargeTypeName()%>"
<%
	}
}
%>
data_arr[<%= counter%>][3] = "<%= masChargeDetails.getApproxDuration()%>"
	data_arr[<%= counter%>][4] = "<%= masChargeDetails.getLastChgBy()!=null?(masChargeDetails.getLastChgBy().getId()!=null?masChargeDetails.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masChargeDetails.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masChargeDetails.getLastChgTime() %>"
		data_arr[<%= counter%>][7] = "<%= masChargeDetails.getChargeCode()!=null?(masChargeDetails.getChargeCode().getId()!=null?masChargeDetails.getChargeCode().getId():"0" ):"0"%>"
		<%
		Iterator itroTList1=otList.iterator();
		while(itroTList1.hasNext())
      	{
			MasOt  masOt = (MasOt)itroTList1.next();
	 		if(masChargeDetails.getOt().getId().equals(masOt.getId()) && masOt.getStatus().equals("y"))
	 		{
	 %>
				data_arr[<%= counter%>][8] = "<%=masOt.getOtName().trim()%>"
	<%		}
	 		else if(masChargeDetails.getOt().getId().equals(masOt.getId()) && masOt.getStatus().equals("n"))
	 		{
	 %>
				data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masOt.getOtName()%>"
	<%
			}
		}
%>

<% if(masChargeDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>

formName = "otMasChargeDetails"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');


</script> <script>

 function fillChargeCode(val) {

	  	  	var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    if(id ==""){
			  return;
			}else{
			obj =document.getElementById('chargeCodeId');
			obj.value = id;

			}

	  }
function convertTime(field) {
  pattern = /^(24):(00)|([01][0-9]|2[0-3]):([0-5][0-9])$/;
  if(pattern.test(field)==false)
  {
  alert("Please enter valid format HH:MM ");
  field.focus();
  }
 }
</script>
