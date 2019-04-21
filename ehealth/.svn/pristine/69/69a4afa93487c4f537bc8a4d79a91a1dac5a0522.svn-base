<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * site.jsp  
 * Purpose of the JSP -  This is for Site.
 * @author  Vishal
 * Create Date: 06th August,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader" %>
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
	ArrayList searchSiteList = (ArrayList)map.get("searchSiteList");
	List<MasBankMaster> masBankMasterList =new ArrayList<MasBankMaster>();
	List<MstrRating> mstrRatingList =new ArrayList<MstrRating>();
	List<MstrTherapeutic> mstrTherapeuticList = new ArrayList<MstrTherapeutic>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>


<%@page import="jkt.hrms.masters.business.MstrSiteDetail"%>
<div class="titleBg"> 
<h2>Site Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Site Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Site Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Site Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchSite')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchSite','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForVendor');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_PI">  --%>
    
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
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
		
		
		if(searchSiteList.size()>0)
		 {	String strForCode = (String)map.get("siteCode");
			String strForCodeDescription = (String)map.get("siteName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showSiteJsp">Show All Records</a>
	<%
			}
		 }
	if(searchSiteList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showSiteJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= SITE_ADDRESS %>"],[4,"<%= SITE_ACC_NO %>"],[5,"<%=SITE_CONTACT_NO%>"],[6,"<%=SITE_FAX_NO%>"],[7,"<%=SITE_EMAIL_ID%>"],[8,"<%=SITE_WEB_SITE%>"],[9,"<%=SITE_PEREVIOUS_ASSOCIATE%>"],[10,"<%=SITE_RATING_ID%>"],[11,"<%=SITE_PAN_NO%>"],[12,"<%=SITE_BANK_ID%>"],
[13,"<%=SITE_BRANCH%>"],[14,"<%=EC_NAME%>"],[15,"<%=EC_CONV_NAME%>"],[16,"<%=EC_CONTACT_NO%>"],[17,"<%= EC_EMAIL_ID%>"], [18,"<%= EC_FAX_NO %>"],[19,"<%= EC_BANK_ID %>"],[20,"<%=EC_BRANCH%>"],[21,"<%= EC_ACC_NO%>"], [22,"<%= EC_PAN_NO %>"],  [23,"<%= COMMENTS %>"] ,[24,"<%= CHANGED_BY%>"], [25,"<%= CHANGED_DATE %>"],[26,"<%= CHANGED_TIME %>"],[27,"<%=STATUS%>"],[28,"thpId"],[29,"thpName"]];
	 statusTd = 27;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="site" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrSiteHeader">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SiteName">
  	<input type="hidden" name="title" value = "Site">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "site">
  	<input type="hidden" name="pojoPropertyCode" value = "SiteCode">
	<div class="division"></div>
	<label><span>*</span>Site Code: </label>
  	<input id="codeId" type="text" name="<%=CODE%>" value="" validate="Site Code,string,yes" MAXLENGTH="15"/ tabindex=1 >
  	<label><span>*</span>Site Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Site Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addPi')" >
  	<label><span>*</span>Address:</label>
  	<input type="text" name="<%= SITE_ADDRESS %>" value="" validate="Site Address,string,yes" MAXLENGTH="100"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label>Account No:</label>
  	<input type="text" name="<%= SITE_ACC_NO %>" value="" validate="Site Account No,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<label><span>*</span>Contact No:</label>
  	<input type="text" name="<%= SITE_CONTACT_NO %>" value="" validate="Site Contact No,string,yes" MAXLENGTH="30"/ tabindex=1)" >
  	<label>Fax No:</label>
  	<input type="text" name="<%= SITE_FAX_NO %>" value="" validate="Site Fax No,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label>Email Id:</label>
  	<input type="text" name="<%= SITE_EMAIL_ID %>" value="" validate="Email Id,string,no" MAXLENGTH="45"/ tabindex=1)" >
   	<label>Web Site:</label>
  	<input type="text" name="<%= SITE_WEB_SITE %>" value="" validate="Web Site,string,no" MAXLENGTH="55"/ tabindex=1)" >
  	<label>Previous Associate:</label>
  	<select name="<%=SITE_PEREVIOUS_ASSOCIATE %>" id="SITE_PEREVIOUS_ASSOCIATE" validate="Associate,string,no">
    	<option value="y">YES</option>
    	<option value="n">No</option>
	</select>
	<div class="clear"></div>
	<label>Rating:</label>
  	<select name="<%=SITE_RATING_ID %>" id="siteRating" validate="Rating,string,no">
    	<option value="0">Select</option>
    	<%
			for(MstrRating mstrRating:mstrRatingList)
			{				
		%>
		<option value="<%= mstrRating.getId() %>"><%=mstrRating.getRatingName() %></option>
		
		<%} %>   
	</select>
  	<label>Pan No:</label>
  	<input type="text" name="<%= SITE_PAN_NO %>" value="" validate="Pan No,string,no" MAXLENGTH="15"/ tabindex=1)" >
	<label>Bank:</label>
	<select name="<%=SITE_BANK_ID%>" id="siteBank" validate="Bank,string,no">
    	<option value="0">Select</option>
    	<%
			for(MasBankMaster masBankMaster:masBankMasterList)
			{				
		%>
		<option value="<%= masBankMaster.getId() %>"><%=masBankMaster.getBankName() %></option>
		
		<%} %>   
		</select>
	<div class="clear"></div>
	<label>Branch:</label>
  	<input type="text" name="<%=SITE_BRANCH %>" value="" validate="Branch,string,no" MAXLENGTH="45"/ tabindex=1)" >
  	<label><span>*</span>Ec Name:</label>
  	<input type="text" name="<%= EC_NAME %>" value="" validate="Ec Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addPi')" >
  	<label>Ec Conv Name:</label>
  	<input type="text" name="<%= EC_CONV_NAME %>" value="" validate="Ec Conv Name,string,no" MAXLENGTH="50"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label><span>*</span>Ec Contact No:</label>
  	<input type="text" name="<%= EC_CONTACT_NO %>" value="" validate="Ec Contact No,string,yes" MAXLENGTH="30"/ tabindex=1)" >
  	<label>EC Email Id:</label>
  	<input type="text" name="<%= EC_EMAIL_ID %>" value="" validate="Ec Email Id,string,no" MAXLENGTH="45"/ tabindex=1)" >
  	<label>Ec Fax No:</label>
  	<input type="text" name="<%= EC_FAX_NO %>" value="" validate="Ec Fax No,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label>Ec Bank:</label>
	<select name="<%=EC_BANK_ID%>" id="siteBank" validate="Bank,Ec string,no">
    	<option value="0">Select</option>
    	<%
			for(MasBankMaster masBankMaster:masBankMasterList)
			{				
		%>
		<option value="<%= masBankMaster.getId() %>"><%=masBankMaster.getBankName() %></option>
		
		<%} %>   
		</select>
	<label>Ec Branch:</label>
  	<input type="text" name="<%=EC_BRANCH %>" value="" validate="Ec Branch,string,no" MAXLENGTH="45"/ tabindex=1)" >
  	<label>Ec Account No:</label>
  	<input type="text" name="<%= EC_ACC_NO %>" value="" validate="Ec Account No,string,no" MAXLENGTH="15"/ tabindex=1)" >
  	<div class="clear"></div>
  	<label>Ec Pan No:</label>
  	<input type="text" name="<%= EC_PAN_NO %>" value="" validate="Ec Pan No,string,no" MAXLENGTH="15"/ tabindex=1)" >
	<label>Comments:</label>
  	<input type="text" name="<%= COMMENTS %>" value="" validate="Commments,string,no" MAXLENGTH="100"/ tabindex=1)" >
	<label><span>*</span>Therapeutic:</label>
	<select name="thpId" id="thpId"  multiple="multiple" size="3" class="list" validate="Therapeutic,string,yes">
	<%for(MstrTherapeutic mstrTherapeutic : mstrTherapeuticList ){%>
		<option value="<%=mstrTherapeutic.getId() %>"><%=mstrTherapeutic.getThpDesc() %></option>
	<%} %>
	</select>
<script>
	document.site.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
 	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('site','projectTrackingMaster?method=addSite');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('site','projectTrackingMaster?method=editSite')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('site','projectTrackingMaster?method=deleteSite&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
	<div class="clear"></div>

	<label>Changed By:</label>   
	<label class="value"><%=userName%></label>
			        
	<label>Changed Date:</label>   
	<label class="value"><%=date%></label>
			 
	<label>Changed Time:</label>   
	<label class="value"><%=time%></label>
			 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
	<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
	
<div class="division"></div>
<div id="edited"></div>

<div class="paddingTop15"></div>			
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Site Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Site Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";
	
data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "0";
data_header[2][3] = "<%= SITE_ADDRESS %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "0";
data_header[3][3] = "<%= SITE_ACC_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Contact No."
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "<%= SITE_CONTACT_NO %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= SITE_FAX_NO %>";

data_header[6] = new Array;
data_header[6][0] = "Email-Id"
data_header[6][1] = "data";
data_header[6][2] = "40%";
data_header[6][3] ="<%= SITE_EMAIL_ID %>";

data_header[7] = new Array;
data_header[7][0] = "Web Site"
data_header[7][1] = "data";
data_header[7][2] = "40%";
data_header[7][3] ="<%= SITE_WEB_SITE %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%= SITE_PEREVIOUS_ASSOCIATE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "0";
data_header[9][3] = "<%= SITE_RATING_ID %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "0";
data_header[10][3] = "<%= SITE_PAN_NO %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "0";
data_header[11][3] = "<%= SITE_BANK_ID %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "0";
data_header[12][3] = "<%= SITE_BRANCH %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "0";
data_header[13][3] = "<%= EC_NAME %>";

data_header[14] = new Array;
data_header[14][0] = "Ec Name"
data_header[14][1] = "hide";
data_header[14][2] = "25%";
data_header[14][3] = "<%= EC_CONV_NAME %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "0";
data_header[15][3] = "<%= EC_CONTACT_NO %>";

data_header[16] = new Array;
data_header[16][0] = "Ec Contact No"
data_header[16][1] = "hide";
data_header[16][2] = "10%";
data_header[16][3] = "<%= EC_EMAIL_ID %>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "0";
data_header[17][3] = "<%= EC_FAX_NO %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "0";
data_header[18][3] = "<%= EC_BANK_ID %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "0";
data_header[19][3] = "<%= EC_BRANCH %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "0";
data_header[20][3] = "<%= EC_ACC_NO %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "0";
data_header[21][3] = "<%= EC_PAN_NO %>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = "0";
data_header[22][3] = "<%= COMMENTS %>";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = "0";
data_header[23][3] = "<%= CHANGED_BY %>";

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "<%= CHANGED_DATE %>"

data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = "15%";
data_header[25][3] = "<%= CHANGED_TIME %>";

data_header[26] = new Array;
data_header[26][0] = "Status"
data_header[26][1] = "data";
data_header[26][2] = "15%";
data_header[26][3] = "<%=STATUS %>";

data_header[27] = new Array;
data_header[27][0] = "Thp"
data_header[27][1] = "hide";
data_header[27][2] = "15%";
data_header[27][3] = "thpId";

data_header[28] = new Array;
data_header[28][0] = "Therap"
data_header[28][1] = "hide";
data_header[28][2] = "15%";
data_header[28][3] = "thpName";


data_arr = new Array();
<%
Iterator itr=searchSiteList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MstrSiteHeader  mstrSiteHeader = (MstrSiteHeader)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0]  = "<%= mstrSiteHeader.getId()%>"
data_arr[<%= counter%>][1]  = "<%= mstrSiteHeader.getSiteCode()%>"
data_arr[<%= counter%>][2]  = "<%= mstrSiteHeader.getSiteName()%>"
data_arr[<%= counter%>][3]  = "'<%= mstrSiteHeader.getSiteAddress() %>'"
data_arr[<%= counter%>][4]  = "<%= mstrSiteHeader.getSiteAccountNo() %>"
data_arr[<%= counter%>][5]  = "<%= mstrSiteHeader.getSiteContactNo() %>"
data_arr[<%= counter%>][6]  = "<%= mstrSiteHeader.getSiteFaxNo()%>"
data_arr[<%= counter%>][7]  = "<%= mstrSiteHeader.getSiteEmailId() %>"
data_arr[<%= counter%>][8]  = "<%= mstrSiteHeader.getSiteWebsite()%>"
data_arr[<%= counter%>][9]  = "<%= mstrSiteHeader.getPereviousAssociate()%>"
<%
if(mstrRatingList.size()>0){
	for(MstrRating msRating:mstrRatingList){
		if(mstrSiteHeader.getRating()!= null){
	
	if(msRating.getId().equals(mstrSiteHeader.getRating().getId())){
%>
data_arr[<%= counter%>][10] = "<%= msRating.getId()%>"

<%}}}}%>
data_arr[<%= counter%>][11] = "<%= mstrSiteHeader.getSitePanNo() %>"

<%
if(masBankMasterList.size()>0){
	for(MasBankMaster masBankMaster:masBankMasterList){
		if(mstrSiteHeader.getBank()!= null){
	
	if(masBankMaster.getId().equals(mstrSiteHeader.getBank().getId())){
%>


data_arr[<%= counter%>][12] = "<%=masBankMaster.getId()%>"
<%}}}}%>
data_arr[<%= counter%>][13] = "<%= mstrSiteHeader.getSiteBranch() %>"
data_arr[<%= counter%>][14] = "<%= mstrSiteHeader.getEcName()%>"
data_arr[<%= counter%>][15] = "<%= mstrSiteHeader.getEcConvrName()%>"
data_arr[<%= counter%>][16] = "<%= mstrSiteHeader.getEcContactNo()%>"
data_arr[<%= counter%>][17] = "<%= mstrSiteHeader.getEcEmailId() %>"
data_arr[<%= counter%>][18] = "<%= mstrSiteHeader.getEcFaxNo() %>"
<%
if(masBankMasterList.size()>0){
	for(MasBankMaster masBankMaster:masBankMasterList){
		if(mstrSiteHeader.getEcBank()!= null){
	
	if(masBankMaster.getId().equals(mstrSiteHeader.getEcBank().getId())){
%>
data_arr[<%= counter%>][19] = "<%= masBankMaster.getId()%>"
<%}}}}%>
data_arr[<%= counter%>][20] = "<%= mstrSiteHeader.getEcBranch()%>"
data_arr[<%= counter%>][21] = "<%= mstrSiteHeader.getEcAcNo() %>"
data_arr[<%= counter%>][22] = "<%= mstrSiteHeader.getEcPanNo()%>"
data_arr[<%= counter%>][23] = "<%= mstrSiteHeader.getComments()%>"
data_arr[<%= counter%>][24] = "<%= mstrSiteHeader.getLastChgBy() %>"
data_arr[<%= counter%>][25] = "<%= mstrSiteHeader.getLastChgDate() %>"
data_arr[<%= counter%>][26] = "<%= mstrSiteHeader.getLastChgTime()%>"

<% if(mstrSiteHeader.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][27] = "Active"
<%}else{%>
data_arr[<%= counter%>][27] = "InActive"
<%}%>
<%
StringBuffer thp_ids = new StringBuffer();
StringBuffer thp_names = new StringBuffer();
Set<MstrSiteDetail> siteDetailSet = new HashSet<MstrSiteDetail>();
if(mstrSiteHeader.getMstrSiteDetails()!= null){
	siteDetailSet = mstrSiteHeader.getMstrSiteDetails();
}
int temp1 =0;
if(mstrTherapeuticList.size()>0){
	for(MstrTherapeutic mstrTherapeutic:mstrTherapeuticList){
		if(siteDetailSet.size()>0){
			for(MstrSiteDetail mstrSiteDetail : siteDetailSet){
				if(mstrSiteDetail.getThp()!= null){
	if(mstrTherapeutic.getId().equals(mstrSiteDetail.getThp().getId())){
		
		 if (thp_ids.toString().length() > 0)
 		  {
			 thp_ids.append(",");
			 thp_ids.append(mstrTherapeutic.getId());
 		  }
 		  else
 		  {
 			 thp_ids.append(mstrTherapeutic.getId());
 		  }
 		  
		 
		 if (thp_names.toString().length() > 0)
 		  {
			 thp_names.append(",");
			 if(temp1 ==7){
 				  temp1=0;
 				 thp_names.append("\\n");
 				thp_names.append(mstrTherapeutic.getThpDesc());
 			  }else{
			 	thp_names.append(mstrTherapeutic.getThpDesc());
 			  }
 		  }
 		  else
 		  {
 			 if(temp1 ==7){
				  temp1=0;
				 thp_names.append("\\n");
				thp_names.append(mstrTherapeutic.getThpDesc());
			  }else{
 				 thp_names.append(mstrTherapeutic.getThpDesc());
			  }
 			 
 		  }
	}
		
	}}}}
	}
%>




data_arr[<%= counter%>][28] = "<%= thp_ids.toString()%>"
data_arr[<%= counter%>][29] = "<%= thp_names.toString()%>"

<%
		     counter++;
}
%>
formName = "site"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  