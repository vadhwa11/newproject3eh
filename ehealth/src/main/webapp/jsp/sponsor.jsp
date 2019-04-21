<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Sponsor.jsp  
 * Purpose of the JSP -  This is for Sponsor Details.
 * @author  Vishal
 * Create Date: 10th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrSponsor" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchSponsorList = (ArrayList)map.get("searchSponsorList");
	List<MstrSponsortype> sponsorTypeList =new ArrayList<MstrSponsortype>();
	List<MstrTherapeutic> therapetuicList =new ArrayList<MstrTherapeutic>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>

<%@page import="jkt.hrms.masters.business.MstrSponsortype"%>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<div class="titleBg"> 
<h2>Sponsor Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Sponsor Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Sponsor Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Spons0r Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchSponsor')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchSponsor','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_SponserType">  --%>
 

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
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(map.get("sponsorTypeList")!=null){
			sponsorTypeList=(List<MstrSponsortype>)map.get("sponsorTypeList");
		}
		if(map.get("therapetuicList")!=null){
			therapetuicList=(List<MstrTherapeutic>)map.get("therapetuicList");
						
		}
		  
		if(searchSponsorList.size()>0)
		 {	String strForCode = (String)map.get("sponsorCode");
			String strForCodeDescription = (String)map.get("sponsorName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showSponsorJsp">Show All Records</a>
	<%
			}
		 }
	if(searchSponsorList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showSponsorJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= SPONSOR_GROUP %>"],[4,"<%= SPONSOR_TYPE_ID %>"],[5,"<%= SPONSOR_ACCOUNT_NO %>"],[6,"<%= SPONSOR_CNT_NO %>"],[7,"<%= SPONSOR_EMAIL_ID %>"],[8,"<%= SPONSOR_WEBSITE %>"],[9,"<%= SPONSOR_FAX_NO %>"],[10,"<%= SPONSOR_ADDRESS %>"],[11,"<%= SPONSOR_COMMENTS %>"],[12,"<%= SPONSOR_ANN_REV %>"], 
			[13,"<%= SPONSOR_OTHGRPCOM %>"],[14,"<%= SPONSOR_TOT_NO_EMP %>"],[15,"<%= SPONSOR_THP_ID %>"],[16,"<%= SPONSOR_OTHONGOINGPRJ %>"],[17,"<%= SPONSOR_ANNTURNOVER %>"],[18,"<%= CHANGED_BY%>"], [19,"<%= CHANGED_DATE %>"],[20,"<%= CHANGED_TIME %>"],[21,"<%=STATUS%>"]];
			
	 statusTd = 21;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="sponsor" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrSponsor">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SponsorName">
  	<input type="hidden" name="title" value = "Sponsor">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "sponsor">
  	<input type="hidden" name="pojoPropertyCode" value = "SponsorCode">
<div class="division"></div>
	<label><span>*</span>Sponsor Code:</label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Sponsor Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Sponsor Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Sponsor Name,string,yes" MAXLENGTH="100"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addSponsor')" >
  	<label>Sponsor Group:</label>
  	<input type="text" name="<%= SPONSOR_GROUP %>" value="" validate="Sponsor Group,string,no" MAXLENGTH="100"/ tabindex=1 >
  	<div class="clear"></div>
  	<label>Sponsor Type.:</label>
  	<select name="<%= SPONSOR_TYPE_ID %>" id="<%= SPONSOR_TYPE_ID %>" validate="Sponsor Type,string,no">
    	<option value="">Select</option>
    	<%
			for(MstrSponsortype mstrSponsortype:sponsorTypeList)
			{				
		%>
		<option value="<%= mstrSponsortype.getId() %>"><%=mstrSponsortype.getSponserTypeName() %></option>
		
		<%} %>   
	</select>
  	<label>Account No.:</label>
  	<input type="text" name="<%= SPONSOR_ACCOUNT_NO %>" value="" validate="Sponsor Account No,string,no" MAXLENGTH="45"/ tabindex=1 >
	<label>CNT No.:</label>
  	<input type="text" name="<%= SPONSOR_CNT_NO %>" value="" validate="Sponsor CNT No,string,no" MAXLENGTH="45"/ tabindex=1 >
	<div class="clear"></div>
	<label>Email Id:</label>
  	<input type="text" name="<%= SPONSOR_EMAIL_ID %>" value="" validate="Sponsor Email Id No,string,no" MAXLENGTH="45"/ tabindex=1 >
	<label>Web Site:</label>
  	<input type="text" name="<%= SPONSOR_WEBSITE %>" value="" validate="Sponsor Wen Site,string,no" MAXLENGTH="45"/ tabindex=1 >
	<label>Fax No.:</label>
  	<input type="text" name="<%= SPONSOR_FAX_NO %>" value="" validate="Sponsor Fax No.,string,no" MAXLENGTH="15"/ tabindex=1 >
	<div class="clear"></div>
	<label>Address:</label>
  	<input type="text" name="<%= SPONSOR_ADDRESS %>" value="" validate="Sponsor Address,string,no" MAXLENGTH="100"/ tabindex=1 >
	<label>Comments:</label>
  	<input type="text" name="<%= SPONSOR_COMMENTS %>" value="" validate="Sponsor Comments,string,no" MAXLENGTH="150"/ tabindex=1 >
	<label>Annual Revenue:</label>
  	<input type="text" name="<%= SPONSOR_ANN_REV %>" value="" validate="Annual Revenue,string,no" MAXLENGTH="50"/ tabindex=1 >
	<div class="clear"></div>
	<label>Other Group Co.:</label>
  	<input type="text" name="<%= SPONSOR_OTHGRPCOM %>" value="" validate="Other Group Co.,string,no" MAXLENGTH="100"/ tabindex=1 >
	<label>No. of Employee:</label>
  	<input type="text" name="<%= SPONSOR_TOT_NO_EMP %>" value="" validate="No. of Employee,integer,no" MAXLENGTH="11"/ tabindex=1 >
	
	<label>Therapeutic Areas:</label>
  		<select name="<%= SPONSOR_THP_ID %>" id="<%= SPONSOR_THP_ID %>" class="list" 
  			multiple="multiple" validate="Therapeutic Type,string,no">
    	<option value="">Select</option>
    	<%for(MstrTherapeutic mstrTherapeutic:therapetuicList) {%>
			<option value="<%= mstrTherapeutic.getId() %>"><%=mstrTherapeutic.getThpDesc() %></option>
		<%} %>   
		</select>
  	
	<div class="clear"></div>
	<label>Other On Going Project:</label>
  	<input type="text" name="<%= SPONSOR_OTHONGOINGPRJ %>" value="" validate="Other On going Project.,string,no" MAXLENGTH="100"/ tabindex=1 >
	<label>Annual Turnover:</label>
  	<input type="text" name="<%= SPONSOR_ANNTURNOVER %>" value="" validate="Annual Turnover,string,no" MAXLENGTH="45"/ tabindex=1 >

<script>
	document.sponsor.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>

<div class="division"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('sponsor','projectTrackingMaster?method=addSponsor');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;"  onClick="submitForm('sponsor','projectTrackingMaster?method=editSponsor')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('sponsor','projectTrackingMaster?method=deleteSponsor&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
	
	<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
			
	<label>Changed By:</label>   
	<label class="value"><%=userName%></label>
			        
	<label>Changed Date:</label>   
	<label class="value"><%=date%></label>
			 
	<label>Changed Time:</label>   
	<label class="value"><%=time%></label>
			 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
	<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	</div>
			
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sponsor Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Sponsor Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= SPONSOR_GROUP %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= SPONSOR_TYPE_ID %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= SPONSOR_ACCOUNT_NO %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= SPONSOR_CNT_NO %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= SPONSOR_EMAIL_ID %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= SPONSOR_WEBSITE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= SPONSOR_FAX_NO %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= SPONSOR_ADDRESS %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= SPONSOR_COMMENTS %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%= SPONSOR_ANN_REV %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%= SPONSOR_OTHGRPCOM %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= SPONSOR_TOT_NO_EMP %>"

data_header[14] = new Array;
data_header[14][0] = "Thp"
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= SPONSOR_THP_ID %>"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%= SPONSOR_OTHONGOINGPRJ %>"

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%= SPONSOR_ANNTURNOVER %>"

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%= CHANGED_BY %>"

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%= CHANGED_DATE %>"


data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "15%";
data_header[19][3] = "<%= CHANGED_TIME %>";

data_header[20] = new Array;
data_header[20][0] = "Status"
data_header[20][1] = "data";
data_header[20][2] = "15%";
data_header[20][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchSponsorList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrSponsor  mstrSponsor = (MstrSponsor)itr.next();
        	  
%>

data_arr[<%= counter%>]     = new Array();
data_arr[<%= counter%>][0]  =  <%=mstrSponsor.getId()%>
data_arr[<%= counter%>][1]  = "<%=mstrSponsor.getSponsorCode()%>"
data_arr[<%= counter%>][2]  = "<%=mstrSponsor.getSponsorName()%>"

<%if(mstrSponsor.getSponsorGroup() != null){%>
	data_arr[<%= counter%>][3]  = "<%=mstrSponsor.getSponsorGroup()%>"
<%}else{%>
	data_arr[<%= counter%>][3]  = ""
<%}%>
<%
		
             if(sponsorTypeList.size()>0){
            	 for(MstrSponsortype sponsorTypeGrid :sponsorTypeList){
             		if(mstrSponsor.getSponserType() != null){
			 if(mstrSponsor.getSponserType().getId().equals(sponsorTypeGrid.getId()) && sponsorTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=sponsorTypeGrid.getSponserTypeName()%>"
			<%}else if(mstrSponsor.getId().equals(sponsorTypeGrid.getId()) && sponsorTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=sponsorTypeGrid.getSponserTypeName()%>";
				
			<%}}else{%>
			data_arr[<%= counter%>][4]  = ""
			<%}}}%>


<% if(mstrSponsor.getSponsorAccountno() != null){ %>
	data_arr[<%= counter%>][5]  = "<%=mstrSponsor.getSponsorAccountno()%>"
<% }else { %>
	data_arr[<%= counter%>][5]  = ""
<% } %>

<% if(mstrSponsor.getSponsorCntNo() != null){ %>
	data_arr[<%= counter%>][6]  = "<%=mstrSponsor.getSponsorCntNo()%>"
<% }else { %>
	data_arr[<%= counter%>][6]  = ""
<% } %>

<% if(mstrSponsor.getSponsorEmailId() != null){ %>
	data_arr[<%= counter%>][7]  = "<%=mstrSponsor.getSponsorEmailId()%>"
<% }else { %>
	data_arr[<%= counter%>][7]  = ""
<% } %>
<% if(mstrSponsor.getSponsorWebsite() != null){ %>
data_arr[<%= counter%>][8]  = "<%=mstrSponsor.getSponsorWebsite()%>"
<% }else { %>
	data_arr[<%= counter%>][8]  = ""
<% } %>
<% if(mstrSponsor.getSponsorFaxNo() != null){ %>
data_arr[<%= counter%>][9]  = "<%=mstrSponsor.getSponsorFaxNo()%>"
<% }else { %>
	data_arr[<%= counter%>][9]  = ""
<% } %>

<% if(mstrSponsor.getSponsorAddress() != null){ %>
data_arr[<%= counter%>][10] = "<%=mstrSponsor.getSponsorAddress()%>"
<% }else { %>
	data_arr[<%= counter%>][10]  = ""
<% } %>
<% if(mstrSponsor.getSponsorComments() != null){ %>
data_arr[<%= counter%>][11] = "<%=mstrSponsor.getSponsorComments()%>"
<% }else { %>
	data_arr[<%= counter%>][11]  = ""
<% } %>
<% if(mstrSponsor.getSponsorAnnRev() != null){ %>
data_arr[<%= counter%>][12] = "<%=mstrSponsor.getSponsorAnnRev()%>"
<% }else { %>
	data_arr[<%= counter%>][12]  = ""
<% } %>
<% if(mstrSponsor.getSponsorOthgrpcom() != null){ %>
data_arr[<%= counter%>][13] = "<%=mstrSponsor.getSponsorOthgrpcom()%>"
<% }else { %>
	data_arr[<%= counter%>][13]  = ""
<% } %>

<% if(mstrSponsor.getSponsorTotNoEmp() != null){ %>
data_arr[<%= counter%>][14] = "<%=mstrSponsor.getSponsorTotNoEmp()%>"
<% }else { %>
	data_arr[<%= counter%>][14]  = ""
<% } %>
<%
Set<MstrTherapeutic> thpSet = mstrSponsor.getThp();
StringBuffer thpIds = new StringBuffer();

for (MstrTherapeutic mstrTherapeutic : thpSet) {
	if (thpIds.toString().length() > 0) {
		thpIds.append(",");
		thpIds.append(mstrTherapeutic.getId());	
	}else{
		thpIds.append(mstrTherapeutic.getId());	
	}
}
%>
data_arr[<%= counter%>][15] = "<%=thpIds.toString()%>"

<% if(mstrSponsor.getSponsorOthongoingprj() != null){ %>
data_arr[<%= counter%>][16] = "<%=mstrSponsor.getSponsorOthongoingprj()%>"
<% }else { %>
	data_arr[<%= counter%>][16]  = ""
<% } %>
<% if(mstrSponsor.getSponsorAnntrunover() != null){ %>
data_arr[<%= counter%>][17] = "<%=mstrSponsor.getSponsorAnntrunover()%>"
<% }else { %>
	data_arr[<%= counter%>][17]  = ""
<% } %>
<% if(mstrSponsor.getLastChgBy() != null){ %>
data_arr[<%= counter%>][18] = "<%= mstrSponsor.getLastChgBy() %>"
<% }else { %>
	data_arr[<%= counter%>][18]  = ""
<% } %>
<% if(mstrSponsor.getLastChgDate() != null){ %>
data_arr[<%= counter%>][19] = "<%= mstrSponsor.getLastChgDate() %>"
<% }else { %>
	data_arr[<%= counter%>][19]  = ""
<% } %>
<% if(mstrSponsor.getLastChgTime() != null){ %>
data_arr[<%= counter%>][20] = "<%= mstrSponsor.getLastChgTime()%>"
<% }else { %>
	data_arr[<%= counter%>][20]  = ""
<% } %>

<% if(mstrSponsor.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][21] = "Active"
<%}else{%>
data_arr[<%= counter%>][21] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "sponsor"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  