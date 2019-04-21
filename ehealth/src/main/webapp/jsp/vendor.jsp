<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * vendor.jsp  
 * Purpose of the JSP -  This is for Vendor Details.
 * @author  Vishal
 * Create Date: 30th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrVendor" %>
<%@page import="jkt.hrms.masters.business.MstrRating" %>
<%@page import="jkt.hms.masters.business.MasBankMaster" %>



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchVendorList = (ArrayList)map.get("searchVendorList");
	List<MasBankMaster> masBankMasterList =new ArrayList<MasBankMaster>();
	List<VendorServiceType>  vendorServiceTypeList = new ArrayList<VendorServiceType>();
	List<MstrRating> mstrRatingList =new ArrayList<MstrRating>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
   }
	if(map.get("vendorServiceTypeList")!=null){
		vendorServiceTypeList=(List<VendorServiceType>)map.get("vendorServiceTypeList");
		}
%>

<%@page import="jkt.hrms.masters.business.VendorServiceType"%>
<div class="titleBg"> 
<h2>Vendor Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Vendor Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Vendor Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Vendor Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchVendor')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchVendor','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForVendor');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_TaskType">  --%>
    
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

	<%  if(map.get("masBankMasterList")!=null){
		masBankMasterList=(List<MasBankMaster>)map.get("masBankMasterList");
		}
		if(map.get("mstrRatingList")!=null){
			mstrRatingList=(List<MstrRating>)map.get("mstrRatingList");
		}
		if(searchVendorList.size()>0)
		 {	String strForCode = (String)map.get("vendorCode");
			String strForCodeDescription = (String)map.get("vendorName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showVendorJsp">Show All Records</a>
	<%
			}
		 }
	if(searchVendorList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showVendorJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= VENDOR_ADDRESS %>"],[4,"<%= VENDOR_CONTACT_NO %>"],[5,"<%=VENDOR_FAX_NO%>"],[6,"<%=VENDOR_EMAIL_ID%>"],[7,"<%=VENDOR_WEB_SITE%>"],[8,"<%=VENDOR_CUST_SERV_NO%>"],[9,"<%=VENDOR_SERVICE%>"],[10,"<%=VENDOR_PAN_NO%>"],[11,"<%=VENDOR_BANK%>"],[12,"<%=VENDOR_BRANCH%>"],
[13,"<%=VENDOR_ACC_NO%>"],[14,"<%=PEREVIOUS_ASSOCIATE%>"],[15,"<%=VENDOR_RATING%>"],[16,"<%=COMMENTS%>"],[17,"<%= CHANGED_BY%>"], [18,"<%= CHANGED_DATE %>"],[19,"<%= CHANGED_TIME %>"],[20,"<%=STATUS%>"]];
	 statusTd = 20;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="vendor" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrVendor">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VendorName">
  	<input type="hidden" name="title" value = "Vendor">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "vendor">
  	<input type="hidden" name="pojoPropertyCode" value = "VendorCode">
	<div class="division"></div>
	<label><span>*</span>Vendor Code: </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Vendor Code,string,yes" MAXLENGTH="15"/ tabindex=1 >
  	<label><span>*</span>Vendor Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Vendor Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addVendor')" >
  	<label><span>*</span>Address:</label>
  	<input type="text" name="<%= VENDOR_ADDRESS %>" value="" validate="Vendor Address,string,yes" MAXLENGTH="100"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label><span>*</span>Contact No:</label>
  	<input type="text" name="<%=VENDOR_CONTACT_NO %>" value="" validate="Vendor Contact No,string,yes" MAXLENGTH="30"/ tabindex=1)" >
  	<label>Vendor Fax No:</label>
  	<input type="text" name="<%=VENDOR_FAX_NO %>" value="" validate="Vendor Fax No,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label>Email Id:</label>
  	<input type="text" name="<%=VENDOR_EMAIL_ID %>" value="" validate="Email Id,string,no" MAXLENGTH="45"/ tabindex=1)" >
	<div class="clear"></div>
	<label>Web Site:</label>
  	<input type="text" name="<%= VENDOR_WEB_SITE %>" value="" validate="Web Site,string,no" MAXLENGTH="35"/ tabindex=1)" >
  	<label>Customer Service no:</label>
  	<input type="text" name="<%= VENDOR_CUST_SERV_NO %>" value="" validate="Customer Service no.,string,no" MAXLENGTH="30"/ tabindex=1)" >
  	<label><span>*</span>Vendor Service:</label>
  	<select name="<%=VENDOR_SERVICE%>"  validate="Vendor,string,Yes">
    	<option value="">Select</option>
    	<%
			for(VendorServiceType vendorServiceType:vendorServiceTypeList)
			{				
		%>
		<option value="<%= vendorServiceType.getId() %>"><%=vendorServiceType.getVendorServiceName() %></option>
		
		<%} %>   
		</select>
	<div class="clear"></div>
	<label>Pan No:</label>
  	<input type="text" name="<%= VENDOR_PAN_NO %>" value="" validate="Pan No,string,no" MAXLENGTH="15"/ tabindex=1)" >
	<label>Bank:</label>
	<select name="<%=VENDOR_BANK%>" id="bank" validate="Bank,string,no">
    	<option value="0">Select</option>
    	<%
			for(MasBankMaster masBankMaster:masBankMasterList)
			{				
		%>
		<option value="<%= masBankMaster.getId() %>"><%=masBankMaster.getBankName() %></option>
		
		<%} %>   
		</select>
	
  	<label>Branch:</label>
  	<input type="text" name="<%= VENDOR_BRANCH %>" value="" validate="Branch,string,no" MAXLENGTH="45"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label>Account No.:</label>
  	<input type="text" name="<%= VENDOR_ACC_NO %>" value="" validate="Account No.,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label>Previous Associate:</label>
  	<input type="text" name="<%= PEREVIOUS_ASSOCIATE %>" value="" validate="Previous Associate,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label>Rating:</label>
  	<select name="<%=VENDOR_RATING %>" id="vendorRating" validate="Rating,string,no">
    	<option value="0">Select</option>
    	<%
			for(MstrRating mstrRating:mstrRatingList)
			{				
		%>
		<option value="<%= mstrRating.getId() %>"><%=mstrRating.getRatingName() %></option>
		
		<%} %>   
	</select>
	<div class="clear"></div>
	<label>Comments:</label>
  	<input type="text" name="<%= COMMENTS %>" value="" validate="Commments,string,no" MAXLENGTH="80"/ tabindex=1)" >
	
	
<script>
	document.vendor.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>

<div class="division"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('vendor','projectTrackingMaster?method=addVendor');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('vendor','projectTrackingMaster?method=editVendor')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('vendor','projectTrackingMaster?method=deleteVendor&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
	
	<div class="clear"></div>
<div class="division"></div>
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
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Vendor Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Vendor Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";
	
data_header[2] = new Array;
data_header[2][0] = "Vendor Address"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= VENDOR_ADDRESS %>";

data_header[3] = new Array;
data_header[3][0] = "Vendor Contact"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%= VENDOR_CONTACT_NO %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%= VENDOR_FAX_NO %>";

data_header[5] = new Array;
data_header[5][0] = "Vendor Email-Id"
data_header[5][1] = "data";
data_header[5][2] = "40%";
data_header[5][3] ="<%= VENDOR_EMAIL_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Vendor Web Site"
data_header[6][1] = "data";
data_header[6][2] = "30%";
data_header[6][3] = "<%= VENDOR_WEB_SITE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "0";
data_header[7][3] = "<%= VENDOR_CUST_SERV_NO %>";

data_header[8] = new Array;
data_header[8][0] = "Vendor Service"
data_header[8][1] = "data";
data_header[8][2] = "30%";
data_header[8][3] = "<%= VENDOR_SERVICE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "0";
data_header[9][3] = "<%= VENDOR_PAN_NO %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "0";
data_header[10][3] = "<%= VENDOR_BANK %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "0";
data_header[11][3] = "<%= VENDOR_BRANCH %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "0";
data_header[12][3] = "<%= VENDOR_ACC_NO %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "0";
data_header[13][3] = "<%= PEREVIOUS_ASSOCIATE %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "0";
data_header[14][3] = "<%= VENDOR_RATING %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "0";
data_header[15][3] = "<%= COMMENTS %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%= CHANGED_BY %>"

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "15%";
data_header[17][3] = "<%= CHANGED_DATE %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%= CHANGED_TIME %>"

data_header[19] = new Array;
data_header[19][0] = "Status"
data_header[19][1] = "data";
data_header[19][2] = "15%";
data_header[19][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchVendorList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrVendor  mstrVendor = (MstrVendor)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= mstrVendor.getId()%>"
data_arr[<%= counter%>][1] = "<%= mstrVendor.getVendorCode()%>"
data_arr[<%= counter%>][2] = "<%= mstrVendor.getVendorName()%>"
data_arr[<%= counter%>][3] = "<%= mstrVendor.getVendorAddress() %>"
data_arr[<%= counter%>][4] = "<%= mstrVendor.getVendorContactNo() %>"
<%if(mstrVendor.getVendorFaxNo()!= null){%>
data_arr[<%= counter%>][5] = "<%= mstrVendor.getVendorFaxNo() %>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<%if( mstrVendor.getVendorEmailId()!= null){%>
data_arr[<%= counter%>][6] = "<%= mstrVendor.getVendorEmailId()%>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
<%if( mstrVendor.getVendorWebSite()!= null){%>
data_arr[<%= counter%>][7] = "<%= mstrVendor.getVendorWebSite()%>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}%>
<%if( mstrVendor.getVendorCustServNo()!= null){%>
data_arr[<%= counter%>][8] = "<%= mstrVendor.getVendorCustServNo()%>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>
<%
if(vendorServiceTypeList.size()>0){
for(VendorServiceType vendorServiceType :vendorServiceTypeList){	
if(mstrVendor.getVendorService()!= null){
	if(mstrVendor.getVendorService().getId().equals(vendorServiceType.getId())){

%>
data_arr[<%= counter%>][9] = "<%=vendorServiceType.getVendorServiceName()%>"
<%}}}}%>

<%if( mstrVendor.getVendorPanNo()!= null){%>
data_arr[<%= counter%>][10] = "<%= mstrVendor.getVendorPanNo()%>"
<%}else{%>
data_arr[<%= counter%>][10] = ""
<%}%>
<%
if(masBankMasterList.size()>0){
	for(MasBankMaster masBankMaster:masBankMasterList){
		if(mstrVendor.getBank()!= null){
	
	if(masBankMaster.getId().equals(mstrVendor.getBank().getId())){
%>

data_arr[<%= counter%>][11] = "<%=masBankMaster.getBankName()%>";
<%
		}
	}		}
}
%>
<%if(mstrVendor.getVendorBranch()!= null){%>
data_arr[<%= counter%>][12] = "<%= mstrVendor.getVendorBranch() %>"
<%}else{%>
data_arr[<%= counter%>][12] = ""
<%}%>
data_arr[<%= counter%>][13] = "<%= mstrVendor.getVendorAccNo() %>"
<%if(mstrVendor.getPereviousAssociate()!= null){%>
data_arr[<%= counter%>][14] = "<%= mstrVendor.getPereviousAssociate()%>"
<%}else{%>
data_arr[<%= counter%>][14] = ""
<%}%>

<%
if(mstrRatingList.size()>0){
	for(MstrRating mstrRating:mstrRatingList){
	if(mstrVendor.getRating()!= null){
	if(mstrRating.getId().equals(mstrVendor.getRating().getId())){
%>

data_arr[<%= counter%>][15] = "<%=mstrRating.getRatingName()%>";
<%
		}
	}	}
}
%>
<%if(mstrVendor.getComments()!= null){%>
data_arr[<%= counter%>][16] = "<%= mstrVendor.getComments()%>"
<%}else{%>
data_arr[<%= counter%>][16] = ""
<%}%>
<%if( mstrVendor.getLastChgBy()!= null){%>
data_arr[<%= counter%>][17] = "<%= mstrVendor.getLastChgBy() %>"
<%}else{%>
data_arr[<%= counter%>][17] = ""
<%}%>
<%if( mstrVendor.getLastChgDate() != null){%>
data_arr[<%= counter%>][18] = "<%= mstrVendor.getLastChgDate() %>"
<%}else{%>
data_arr[<%= counter%>][18] = ""
<%}%>
<%if(mstrVendor.getLastChgTime()!= null){%>
data_arr[<%= counter%>][19] = "<%= mstrVendor.getLastChgTime()%>"
<%}else{%>
data_arr[<%= counter%>][19] = ""
<%}%>
<% if(mstrVendor.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][20] = "Active"
<%}else{%>
data_arr[<%= counter%>][20] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "vendor"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  