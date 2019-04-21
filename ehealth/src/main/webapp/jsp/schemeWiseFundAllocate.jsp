
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.FaSchemeWiseFundAllocate"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
	
	List<FaSchemeWiseFundAllocate> faSchemeWiseFundAllocateList = new ArrayList<FaSchemeWiseFundAllocate>();
	
	if(map.get("masSchemeList")!=null){
		masSchemeList = (List<MasScheme>)map.get("masSchemeList");
	}
	
List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
	
	if(map.get("financialYearList")!=null){
		financialYearList = (List<MasStoreFinancial>)map.get("financialYearList");
	}
	
	
	if(map.get("faSchemeWiseFundAllocateList")!=null){
		faSchemeWiseFundAllocateList = (List<FaSchemeWiseFundAllocate>)map.get("faSchemeWiseFundAllocateList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int userId =0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
	%>
	
<h4><%=message %></h4>
		<%  }
 %>
 

<div class="titleBg">
<h2>Scheme Wise Fund Allocate</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">

<label>Scheme </label> 
<select name="schemeIds" id="<%=SEARCH_FIELD%>" validate="Scheme,string,no">
<option value="0">Select</option>
<%
	if(masSchemeList.size()>0){
		for(MasScheme masScheme : masSchemeList){
	%>
	<option value="<%=masScheme.getId() %>"><%=masScheme.getSchemeName() %></option>
		<%}
	}
%>
</select>
<div class="clear"></div>
 <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','account?method=searchSchemeWiseFundAllocate')" tabindex=1 /> 
</div>	
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>
</div><div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div><div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="clear"></div>
<% 
	if(map.get("search") != null)
	  {
	 %> <h4><a href="account?method=showSchemeWiseFundAllocateJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
	j
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"schemeId"], [2,"sanctionedAmount"], [3,"financialYear"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"],[8,"letterNo"] ];
	 statusTd = 7;
	</script></div>
	<div class="clear"></div>
<form name="depotUnit" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
<label>Scheme <span>*</span> </label> 
<select name="schemeId" id="schemeId" validate="Scheme,string,yes">
<option value="0">Select</option>
<%
	if(masSchemeList.size()>0){
		for(MasScheme masScheme : masSchemeList){
	%>
	<option value="<%=masScheme.getId() %>"><%=masScheme.getSchemeName() %></option>
		<%}
	}
%>
</select>
  
<label>Sanctioned Amount <span>*</span> </label> 
<input type="text" name="sanctionedAmount" validate="Sanctioned Amount,decimal,yes">

<label>Financial Year <span>*</span> </label> 
<select name="financialYear" id="financialYear" validate="Scheme,string,yes">
<option value="0">Select</option>
<%
	if(financialYearList.size()>0){
		for(MasStoreFinancial masStoreFinancial : financialYearList){
	%>
	<option value="<%=masStoreFinancial.getId() %>"><%=masStoreFinancial.getFinancialYear() %></option>
		<%}
	}
%>
</select>

<label>Letter No.  </label> 
<input type="text" name="letterNo" validate="Letter No.,string,no">

 <script>
				document.depotUnit.schemeId.focus();
			</script> <br />
<div class="clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('depotUnit','account?method=addSchemeWiseFundAllocate');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none"	onClick="submitForm('depotUnit','account?method=updateSchemeWiseFundAllocate')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none"	onClick="submitForm('depotUnit','account?method=deleteSchemeWiseFundAllocate&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('depotUnit','account?method=showSchemeWiseFundAllocateJsp')" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName %></label>

<label>Changed Date:</label>
<label class="value"><%=date %></label>

<label>Changed Time:</label>
<label class="value"><%=time %></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div id="edited"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Scheme"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "schemeId"

data_header[1] = new Array;
data_header[1][0] = "Sanctioned Amount"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "sanctionedAmount";


data_header[2] = new Array;
data_header[2][0] = "Financial Year"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "financialYear"


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_header[7] = new Array;
data_header[7][0] = "Letter No"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "letterNo";


data_arr = new Array();

<%
          int  counter=0;
         for(FaSchemeWiseFundAllocate faSchemeWiseFundAllocate :faSchemeWiseFundAllocateList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= faSchemeWiseFundAllocate.getId()%>"
	<%
	for(MasScheme s : masSchemeList){
		 if(faSchemeWiseFundAllocate.getScheme().getId().equals(s.getId()) && s.getStatus().equals("Y")){ 
			 %>
			data_arr[<%= counter%>][1] = "<%=s.getSchemeName()%>"
		<%}else if(faSchemeWiseFundAllocate.getScheme().getId().equals(s.getId()) && s.getStatus().equals("N")){%>
			data_arr[<%= counter%>][1] = "<span>*</span>Parent InActivated--<%=s.getSchemeName()%>";
			
		<%}
}%>

data_arr[<%= counter%>][2] = "<%= faSchemeWiseFundAllocate.getSanctionedAmt() %>"
	
		<%
		for(MasStoreFinancial f : financialYearList){
			 if(faSchemeWiseFundAllocate.getFYear().getId().equals(f.getId()) && f.getStatus().equals("y")){ 
				 %>
				data_arr[<%= counter%>][3] = "<%=f.getFinancialYear()%>"
			<%}else if(faSchemeWiseFundAllocate.getFYear().getId().equals(f.getId()) && f.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<span>*</span>Parent InActivated--<%=f.getFinancialYear()%>";
				
			<%}
	}%>
data_arr[<%= counter%>][4] = "<%= faSchemeWiseFundAllocate.getLastChgBy()!=null?(faSchemeWiseFundAllocate.getLastChgBy().getId()!=null?faSchemeWiseFundAllocate.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(faSchemeWiseFundAllocate.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= faSchemeWiseFundAllocate.getLastChgTime() %>"

<% if(faSchemeWiseFundAllocate.getStatus().equals("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>

<%if(faSchemeWiseFundAllocate.getLetterNo() != null && !faSchemeWiseFundAllocate.getLetterNo().equals("")){%>
data_arr[<%= counter%>][8] = "<%=faSchemeWiseFundAllocate.getLetterNo()%>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>

<%
		     counter++;
}
%>
formName = "depotUnit"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
