<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * pi.jsp  
 * Purpose of the JSP -  This is for PI.
 * @author  Vishal
 * Create Date: 03th August,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrPiHeader" %>
<%@page import="jkt.hrms.masters.business.MstrRating" %>
<%@page import="jkt.hms.masters.business.MasBankMaster" %>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic" %>



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchPiList = (ArrayList)map.get("searchPiList");
	List<MasBankMaster> masBankMasterList =new ArrayList<MasBankMaster>();
	List<MstrRating> mstrRatingList =new ArrayList<MstrRating>();
	List<MstrTherapeutic> mstrTherapeuticList = new ArrayList<MstrTherapeutic>();
	List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>

<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hrms.masters.business.MstrPiDetail"%>
<%@page import="jkt.hrms.masters.business.MstrSiteDetail"%>
<div class="titleBg"> 
<h2>PI Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>PI Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>PI Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Vendor Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchPi')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchPi','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForVendor');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_PI">  --%>
    
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
		if(map.get("mstrTherapeuticList")!=null){
			mstrTherapeuticList=(List<MstrTherapeutic>)map.get("mstrTherapeuticList");
		}
		if(map.get("mstrSiteHeaderList")!=null){
			mstrSiteHeaderList=(List<MstrSiteHeader>)map.get("mstrSiteHeaderList");
		}
		
		if(searchPiList.size()>0)
		 {	String strForCode = (String)map.get("piCode");
			String strForCodeDescription = (String)map.get("piName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showPiJsp">Show All Records</a>
	<%
			}
		 }
	if(searchPiList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showPiJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= PI_ADDRESS %>"],[4,"<%= PI_CONTACT_NO %>"],[5,"<%=PI_MOBILE_NO%>"],[6,"<%=PI_EMAIL_ID%>"],[7,"<%=PI_FAX_NO%>"],[8,"<%=PI_MED_REG_NO%>"],[9,"<%=PI_PAN_NO%>"],[10,"<%=PI_BANK%>"],[11,"<%=PI_BRANCH%>"],[12,"<%=PI_PEREVIOUS_ASSOCIATE%>"],
[13,"<%=PI_ACC_NO%>"],[14,"<%=PI_RATING%>"],[15,"<%=PI_COMMENTS%>"],[16,"<%=PI_DESIGNATION%>"],[17,"<%= CHANGED_BY%>"], [18,"<%= CHANGED_DATE %>"],[19,"<%= CHANGED_TIME %>"],[20,"<%=STATUS%>"],[21,"thpId"],[22,"thpName"],[23,"siteId"],[24,"siteName"]];
	 statusTd = 20;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="pi" method="post" action="">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrPiHeader">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PiName">
  	<input type="hidden" name="title" value = "Pi">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "pi">
  	<input type="hidden" name="pojoPropertyCode" value = "PiCode">
	<div class="division"></div>
	<label><span>*</span>PI Code: </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Pi Code,string,yes" MAXLENGTH="15"/ tabindex=1 >
  	<label><span>*</span>PI Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Pi Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addPi')" >
  	<label><span>*</span>Address:</label>
  	<input type="text" name="<%= PI_ADDRESS %>" value="" validate="Pi Address,string,yes" MAXLENGTH="100"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label><span>*</span>Contact No:</label>
  	<input type="text" name="<%= PI_CONTACT_NO %>" value="" validate="Pi Contact No,string,yes" MAXLENGTH="30"/ tabindex=1)" >
  	<label><span>*</span>Mobile No:</label>
  	<input type="text" name="<%= PI_MOBILE_NO %>" value="" validate="Pi Mobile No,string,yes" MAXLENGTH="30"/ tabindex=1)" >
  	<label>Email Id:</label>
  	<input type="text" name="<%= PI_EMAIL_ID %>" value="" validate="Email Id,string,no" MAXLENGTH="45"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label>Fax No:</label>
  	<input type="text" name="<%= PI_FAX_NO %>" value="" validate="Pi Fax No,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label>Medical Reg. no:</label>
  	<input type="text" name="<%= PI_MED_REG_NO %>" value="" validate="PI Medical Registration no.,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label>Pan No:</label>
  	<input type="text" name="<%= PI_PAN_NO %>" value="" validate="Pan No,string,no" MAXLENGTH="15"/ tabindex=1)" >
	<div class="clear"></div>
	<label>Bank:</label>
	<select name="<%=PI_BANK%>" id="piBank" validate="Bank,string,no">
    	<option value="0">Select</option>
    	<%
			for(MasBankMaster masBankMaster:masBankMasterList)
			{				
		%>
		<option value="<%= masBankMaster.getId() %>"><%=masBankMaster.getBankName() %></option>
		
		<%} %>   
		</select>
	
  	<label>Branch:</label>
  	<input type="text" name="<%=PI_BRANCH %>" value="" validate="Branch,string,no" MAXLENGTH="45"/ tabindex=1)" >
  	<label>Previous Associate:</label>
  	<select name="<%=PI_PEREVIOUS_ASSOCIATE %>" id="PI_PEREVIOUS_ASSOCIATE" validate="Associate,string,no">
    	<option value="">Select</option>
    	<option value="y">YES</option>
    	<option value="n">No</option>
	</select>
  	<div class="clear"></div>
  	<label>Account No.:</label>
  	<input type="text" name="<%= PI_ACC_NO %>" value="" validate="Account No.,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label>Rating:</label>
  	<select name="<%=PI_RATING %>" id="piRating" validate="Rating,string,no">
    	<option value="0">Select</option>
    	<%
			for(MstrRating mstrRating:mstrRatingList)
			{				
		%>
		<option value="<%= mstrRating.getId() %>"><%=mstrRating.getRatingName() %></option>
		
		<%} %>   
	</select>
	<label>Comments:</label>
  	<input type="text" name="<%= PI_COMMENTS %>" value="" validate="Commments,string,no" MAXLENGTH="50"/ tabindex=1)" >
	<div class="clear"></div>
	<label>Designation:</label>
  	<input type="text" name="<%= PI_DESIGNATION %>" value="" validate="Designation,string,no" MAXLENGTH="50"/ tabindex=1)" >
	<label>Therapeutic:</label>
	<select name="thpId" id="thpId"  multiple="multiple" size="3" class="list">
	<%for(MstrTherapeutic mstrTherapeutic : mstrTherapeuticList ){%>
		<option value="<%=mstrTherapeutic.getId() %>"><%=mstrTherapeutic.getThpDesc() %></option>
	<%} %>
	</select>
	<label>Site:</label>
	<select name="siteId" id="siteId"  multiple="multiple" size="3" class="list">
	<%for(MstrSiteHeader mstrSiteHeader : mstrSiteHeaderList ){%>
		<option value="<%=mstrSiteHeader.getId() %>"><%=mstrSiteHeader.getSiteName() %></option>
	<%} %>
	</select>
<script>
	document.pi.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>

<div class="division"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('pi','projectTrackingMaster?method=addPi');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('pi','projectTrackingMaster?method=editPi')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('pi','projectTrackingMaster?method=deletePi&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
<div class="clear"></div>
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
	
</div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>		
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "PI Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "PI Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";
	
data_header[2] = new Array;
data_header[2][0] = "Address"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= PI_ADDRESS %>";

data_header[3] = new Array;
data_header[3][0] = "Contact"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%= PI_CONTACT_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Mobile No"
data_header[4][1] = "data";
data_header[4][2] = "30%";
data_header[4][3] = "<%= PI_MOBILE_NO %>";

data_header[5] = new Array;
data_header[5][0] = "Email-Id"
data_header[5][1] = "data";
data_header[5][2] = "40%";
data_header[5][3] ="<%= PI_EMAIL_ID %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%= PI_FAX_NO %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "0";
data_header[7][3] = "<%= PI_MED_REG_NO %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%= PI_PAN_NO %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "0";
data_header[9][3] = "<%= PI_BANK %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "0";
data_header[10][3] = "<%= PI_BRANCH %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "0";
data_header[11][3] = "<%= PI_PEREVIOUS_ASSOCIATE %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "0";
data_header[12][3] = "<%= PI_ACC_NO %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "0";
data_header[13][3] = "<%= PI_RATING %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "0";
data_header[14][3] = "<%= PI_COMMENTS %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "0";
data_header[15][3] = "<%= PI_DESIGNATION %>";

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

data_header[20] = new Array;
data_header[20][0] = "THp"
data_header[20][1] = "hide";
data_header[20][2] = "15%";
data_header[20][3] = "thpId";

data_header[21] = new Array;
data_header[21][0] = "ThP Name"
data_header[21][1] = "hide";
data_header[21][2] = "15%";
data_header[21][3] = "thpName";

data_header[22] = new Array;
data_header[22][0] = "Site Id"
data_header[22][1] = "hide";
data_header[22][2] = "15%";
data_header[22][3] = "siteId";

data_header[23] = new Array;
data_header[23][0] = "Site Name"
data_header[23][1] = "hide";
data_header[23][2] = "15%";
data_header[23][3] = "siteName";

data_arr = new Array();
<%
Iterator itr=searchPiList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MstrPiHeader  mstrPiHeader = (MstrPiHeader)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();

data_arr[<%= counter%>][0]  = "<%= mstrPiHeader.getId()%>"
<%if(mstrPiHeader.getPiCode()!= null){%>
data_arr[<%= counter%>][1]  = "<%= mstrPiHeader.getPiCode()%>"
<%}else{%>
data_arr[<%= counter%>][1]  = ""
<%}%>
<%if(mstrPiHeader.getPiName()!= null){%>
data_arr[<%= counter%>][2]  = "<%= mstrPiHeader.getPiName()%>"
<%}else{%>
data_arr[<%= counter%>][2]  = ""
<%}%>
<%if(mstrPiHeader.getPiAddress()!= null){%>
data_arr[<%= counter%>][3]  = "<%= mstrPiHeader.getPiAddress() %>"
<%}else{%>
data_arr[<%= counter%>][3]  = ""
<%}%>
<%if(mstrPiHeader.getPiContactNo()!= null){%>
data_arr[<%= counter%>][4]  = "<%= mstrPiHeader.getPiContactNo()%>"
<%}else{%>
data_arr[<%= counter%>][4]  = ""
<%}%>
<%if(mstrPiHeader.getPiMobileNo()!= null){%>
data_arr[<%= counter%>][5]  = "<%= mstrPiHeader.getPiMobileNo()%>"
<%}else{%>
data_arr[<%= counter%>][5]  = ""
<%}%>
<%if(mstrPiHeader.getPiEmailId()!= null){%>
data_arr[<%= counter%>][6]  = "<%= mstrPiHeader.getPiEmailId()%>"
<%}else{%>
data_arr[<%= counter%>][6]  = ""
<%}%>
<%if(mstrPiHeader.getPiFaxNo()!= null){%>
data_arr[<%= counter%>][7]  = "<%= mstrPiHeader.getPiFaxNo() %>"
<%}else{%>
data_arr[<%= counter%>][7]  = ""
<%}%>
<%if(mstrPiHeader.getPiMedRegNo()!= null){%>
data_arr[<%= counter%>][8]  = "<%= mstrPiHeader.getPiMedRegNo()%>"
<%}else{%>
data_arr[<%= counter%>][8]  = ""
<%}%>
<%if(mstrPiHeader.getPiPanNo()!= null){%>
data_arr[<%= counter%>][9]  = "<%= mstrPiHeader.getPiPanNo()%>"
<%}else{%>
data_arr[<%= counter%>][9]  = ""
<%}%>
<%if(masBankMasterList.size()>0){
	for(MasBankMaster masBankMaster :masBankMasterList){
		if(mstrPiHeader.getBank()!= null){
		if(masBankMaster.getId().equals(mstrPiHeader.getBank().getId())){%>
data_arr[<%= counter%>][10] = "<%= masBankMaster.getId()%>"
<%}}}}%>
<%if(mstrPiHeader.getPiBranch()!= null){%>
data_arr[<%= counter%>][11] = "<%= mstrPiHeader.getPiBranch() %>"
<%}else{%>
data_arr[<%= counter%>][11]  = ""
<%}%>
<%if(mstrPiHeader.getPiPreviousAssociation()!= null){%>
data_arr[<%= counter%>][12] = "<%= mstrPiHeader.getPiPreviousAssociation()%>"
<%}else{%>
data_arr[<%= counter%>][12]  = ""
<%}%>
<%if(mstrPiHeader.getPiAccNo()!= null){%>
data_arr[<%= counter%>][13] = "<%= mstrPiHeader.getPiAccNo() %>"
<%}else{%>
data_arr[<%= counter%>][13]  = ""
<%}%>

<%if(mstrRatingList.size()>0){
	for(MstrRating mstrRating :mstrRatingList){
		if(mstrPiHeader.getRating()!= null){
		if(mstrRating.getId().equals(mstrPiHeader.getRating().getId())){%>
data_arr[<%= counter%>][14] = "<%= mstrRating.getId()%>"
<%}}}}%>
<%if(mstrPiHeader.getComments()!= null){%>
data_arr[<%= counter%>][15] = "<%= mstrPiHeader.getComments()%>"
<%}else{%>
data_arr[<%= counter%>][15]  = ""
<%}%>
<%if(mstrPiHeader.getDesignation()!= null){%>
data_arr[<%= counter%>][16] = "<%= mstrPiHeader.getDesignation()%>"
<%}else{%>
data_arr[<%= counter%>][16]  = ""
<%}%>
<%if(mstrPiHeader.getLastChgBy()!= null){%>
data_arr[<%= counter%>][17] = "<%= mstrPiHeader.getLastChgBy() %>"
<%}else{%>
data_arr[<%= counter%>][17]  = ""
<%}%>
<%if(mstrPiHeader.getLastChgDate()!= null){%>
data_arr[<%= counter%>][18] = "<%= mstrPiHeader.getLastChgDate() %>"
<%}else{%>
data_arr[<%= counter%>][18]  = ""
<%}%>
<%if(mstrPiHeader.getLastChgTime()!= null){%>
data_arr[<%= counter%>][19] = "<%= mstrPiHeader.getLastChgTime()%>"
<%}else{%>
data_arr[<%= counter%>][19]  = ""
<%}%>

<% if(mstrPiHeader.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][20] = "Active"
<%}else{%>
data_arr[<%= counter%>][20] = "InActive"
<%}%>
<%
StringBuffer thp_ids = new StringBuffer();
StringBuffer thp_names = new StringBuffer();
Set<MstrPiDetail> piDetailSet = new HashSet<MstrPiDetail>();
if(mstrPiHeader.getMstrPiDetails()!= null){
	piDetailSet =mstrPiHeader.getMstrPiDetails();
}
int temp1 =0;
if(mstrTherapeuticList.size()>0){
	for(MstrTherapeutic mstrTherapeutic1:mstrTherapeuticList){
		if(piDetailSet.size()>0){
			for(MstrPiDetail mstrPiDetail: piDetailSet){
				if(mstrPiDetail.getThp() != null){
	if(mstrTherapeutic1.getId().equals(mstrPiDetail.getThp().getId())){
		
		 if (thp_ids.toString().length() > 0)
 		  {
			 thp_ids.append(",");
			 thp_ids.append(mstrTherapeutic1.getId());
 		  }
 		  else
 		  {
 			 thp_ids.append(mstrTherapeutic1.getId());
 		  }
 		  
		 
		 if (thp_names.toString().length() > 0)
 		  {
			 thp_names.append(",");
			 if(temp1 ==7){
 				  temp1=0;
 				 thp_names.append("\\n");
 				thp_names.append(mstrTherapeutic1.getThpDesc());
 			  }else{
			 	thp_names.append(mstrTherapeutic1.getThpDesc());
 			  }
 		  }
 		  else
 		  {
 			 if(temp1 ==7){
				  temp1=0;
				 thp_names.append("\\n");
				thp_names.append(mstrTherapeutic1.getThpDesc());
			  }else{
 				 thp_names.append(mstrTherapeutic1.getThpDesc());
			  }
 			 
 		  }
	}
	}}}}
	}
%>
data_arr[<%= counter%>][21] = "<%= thp_ids.toString()%>"
data_arr[<%= counter%>][22] = "<%= thp_names.toString()%>"
<%
StringBuffer site_ids = new StringBuffer();
StringBuffer sit_names = new StringBuffer();
int temp2 = 0;
Set<MstrPiDetail> piDetailSet1= new HashSet<MstrPiDetail>();
if(mstrPiHeader.getMstrPiDetails()!= null){
	piDetailSet1 = mstrPiHeader.getMstrPiDetails();
}
Set<MstrSiteDetail> siteDetailSet = new HashSet<MstrSiteDetail>();
if(mstrSiteHeaderList.size()>0){
	for(MstrSiteHeader mstrSiteHeader:mstrSiteHeaderList){
		if(piDetailSet.size()>0){
			for(MstrPiDetail mstrPiDetail: piDetailSet){
				if(mstrPiDetail.getSiteHeader()!= null){
	if(mstrSiteHeader.getId().equals(mstrPiDetail.getSiteHeader().getId())){
		
		 if (site_ids.toString().length() > 0)
 		  {
			 site_ids.append(",");
			 site_ids.append(mstrSiteHeader.getId());
 		  }
 		  else
 		  {
 			 site_ids.append(mstrSiteHeader.getId());
 		  }
 		  
		 
		 if (sit_names.toString().length() > 0)
 		  {
			 sit_names.append(",");
			 if(temp2 ==7){
				 temp2=0;
 				 sit_names.append("\\n");
 				sit_names.append(mstrSiteHeader.getSiteName());
 			  }else{
 				 sit_names.append(mstrSiteHeader.getSiteName());
 			  }
 		  }
 		  else
 		  {
 			 if(temp2 ==7){
 				temp2=0;
				  sit_names.append("\\n");
				  sit_names.append(mstrSiteHeader.getSiteName());
			  }else{
				  sit_names.append(mstrSiteHeader.getSiteName());
			  }
 			 
 		  }
		
	}}}}}}
	
%>
data_arr[<%= counter%>][23] = "<%= site_ids.toString()%>"
data_arr[<%= counter%>][24] = "<%= sit_names.toString()%>"







<%
		     counter++;
}
%>
formName = "pi"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  