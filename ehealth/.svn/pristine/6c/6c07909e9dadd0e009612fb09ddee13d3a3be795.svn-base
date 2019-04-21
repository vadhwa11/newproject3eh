<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.HrVacancyPost"%>
<%@page import="jkt.hms.masters.business.HrInstitutionalSanctionedPost"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

 
<script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script>
 
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
 
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<HrInstitutionalSanctionedPost> hrInstitutionalSanctionedPost = new ArrayList<HrInstitutionalSanctionedPost>();
	List<MasHospital> institutionList = new ArrayList<MasHospital>();
	List<MasEmployeeDepartment> deptpartmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasCadre> cadreList =new ArrayList<MasCadre>();
	List<MasRank> designationList = new ArrayList<MasRank>();
    List<HrVacancyPost> vaclist=new ArrayList<HrVacancyPost>();	
	 
	if(map.get("institutionList") !=null){
		institutionList =(List) map.get("institutionList");
	}
	if(map.get("deptpartmentList") !=null){
		deptpartmentList =(List) map.get("deptpartmentList");
	}
	
	if(map.get("hrInstitutionalSanctio") !=null){
		hrInstitutionalSanctionedPost =(List<HrInstitutionalSanctionedPost>) map.get("hrInstitutionalSanctionedPost");
		
	}
	if(map.get("vaclist") !=null){
		vaclist =(List<HrVacancyPost>) map.get("vaclist");
	}
	 
	if(map.get("cadreList") !=null){
		cadreList =(List)map.get("cadreList");
	}
	
	 
	if (map.get("designationList") != null) {
		designationList = (List<MasRank>) map.get("designationList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
	int hospitalId= (Integer)session.getAttribute("hospitalId");
%>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		
	</script> 
  
<div class="titleBg">
<title>Vacancy Position</title>
<h2>Vacancy Position </h2>
</div>
<div class="clear"></div> 
<div class="clear"></div>
  <div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div> 
 
<script type="text/javascript">
formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"institute"], [2,"department "], [3,"designation"], [4,"cadre"], [5,"spp"],[6,"stp"], [7,"ssp"], [8,"ipp"], [9,"itp"],[10,"isp"], [11,"vpp"],[12,"vtp"], [13,"vsp"] [14,"<%= CHANGED_BY%>"], [15,"<%= CHANGED_DATE %>"],[16,"<%= CHANGED_TIME %>"],[17,"<%=STATUS%>"] ];
	 statusTd = 14;
	</script></div>  

<div class="clear"></div>
 
<div class="Block">
<form name=search method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	 
	<label>Institution</label> <select name="institute" validate="Institute,string,no">
	<option value="">Select</option>
	<%
		for (MasHospital masHospital: institutionList) {
	%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<%
		}
	%>
</select> 
	 
<label><span>*</span>Department</label> <select name="department" validate="Department,string,yes">
	<option value="">Select</option>
	<%
		for (MasEmployeeDepartment masDepartment: deptpartmentList) {
	%>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getEmpDeptName()%></option>

	<%
		}
	%>
</select> 
 	
<label><span>*</span>Designation</label> <select name="designation" validate="Department,string,yes">
	<option value="">Select</option>
	<%
		for (MasRank masRank: designationList) {
	%>

	<option value="<%=masRank.getId ()%>"><%=masRank.getRankName()%></option>

	<%
		}
	%>
</select>
 <div class="clear"></div>
  
<label><span>*</span>Cadre</label> <select name="cadre" validate="Department,string,no">
	<option value="">Select</option>
	<%
		for (MasCadre masCadre: cadreList) {
	%>
 	<option value="<%=masCadre.getId ()%>"><%=masCadre.getCadreName()%></option>
 	<%
		}
	%>
</select>
 <div id="testDiv">
  </div>
 </form>
 
<input name="search" type="button" class="button"	value="Search" onclick="submitProtoAjaxWithDivName('('search','training??method=searchVacancyPositionJsp','testDiv');"" />
 
 <div class="clear"></div>
 <!-- <h4>Add Session</h4> -->
<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
<div id="testDiv">	
<form name="submit" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table width="100%" colspan="0" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0" class="cmntable">
 
		<tr>
			<th width="13%"></th>
			<th width="13%"></th>
			<th width="13%"></th>
			<th width="10%"  colspan="3">Vacant Post</th>
			
		</tr>

		<tr>
			<th width="13%">Institution</th>
			<th width="13%">Department</th>
			<th width="13%">Designation</th>
			<th width="10%">PP</th>
			<th width="10%">TP</th>
			<th width="10%">SP </th>
			
		</tr>
	
		 <%
		if(vaclist.size()>0){
		%>
		<%for(HrVacancyPost pd : vaclist){ %>
		
		<tr>
 			<td>
			<%if(pd.getHospital()!=null){ %>
			<input type="text" name="institute" value=" <%= pd.getHospital().getHospitalName()%> " tabindex=1  id="institute" size="28"  maxlength="32"/>
 			 <%}else{%>
      	       <input type="text" name="institute" value="" tabindex=1  id="institute" size="28"  maxlength="32"/>
                 <%} %>
			</td>
			<td>
			<%if(pd.getSanctionedPost().getDepartment().getDepartmentName()!=null){ %>
			<input type="text" name="dept" value=" <%= pd.getSanctionedPost().getDepartment().getDepartmentName()%> " tabindex=1  id="dept" size="28"  maxlength="32"/>
			 <%}else{%>
      	       <input type="text" name="dept" value="" tabindex=1  id="dept" size="28"  maxlength="32"/>
                 <%} %>
			</td>
			<td>
			<%if(pd.getSanctionedPost().getRank().getRankName()!=null){ %>
			<input type="text" name="desig" value=" <%= pd.getSanctionedPost().getRank().getRankName()%> " tabindex=1  id="desig" size="28"  maxlength="32"/>
			 <%}else{%>
      	        <input type="text" name="desig" value="" tabindex=1  id="desig" size="28"  maxlength="32"/>
                <%} %>
			</td>
			<td>
			<%if(pd.getVpermanentPost()!=null){ %>
			<input type="text" name="spp" value=" <%= pd.getVpermanentPost()%> " tabindex=1  id="spp" size="3"  maxlength="3"/>
 			 <%}else{%>
      	      	<input type="text" name="spp" value="" tabindex=1  id="spp" size="3"  maxlength="3"/>
                <%} %>
			</td>
			<td>
			<%if(pd.getVtemporaryPost()!=null){ %>
			<input type="text" name="stp" value=" <%=pd.getVtemporaryPost()%> " tabindex=1  id="stp" size="3"  maxlength="3"/>
 			 <%}else{%>
      	     <input type="text" name="stp" value=" " tabindex=1  id="stp" size="3"  maxlength="3"/>
                <%} %>
			</td>
			<td>
			<%if(pd.getVsupernumeraryPost()!=null){ %>
			<input type="text" name="ssp" value=" <%= pd.getVsupernumeraryPost()%> " tabindex=1  id="ssp" size="3"  maxlength="3"/>
 			 <%}else{%>
      	     	<input type="text" name="ssp" value=" " tabindex=1  id="ssp" size="3"  maxlength="3"/>
			</td>
                <%} %>
			</td>
 		</tr> 
		<%
 		} %>
		<% }else{%>
	<h2>No Record Found</h2>	
 		<%}%>
 <input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
 </table>
  <div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
  <label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
     Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="division"></div>
 </form>
</div>
 <input name="back" type="button" class="button"	value="Back" onclick="submitForm('submit','/hms/hrms/training?method=showVacancyPositionJsp');"/>
  
<div class="division"></div>
<div id="edited"></div>  
<div class="clear"></div>
<div class="division"></div>
 
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%=COMMON_ID%>" value="" />
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Institution"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "institute";

data_header[1] = new Array;
data_header[1][0] = "Department"
data_header[1][1] = "data";
data_header[1][2] = "25% ";
data_header[1][3] = " department";

data_header[2] = new Array;
data_header[2][0] = "Designation"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "designation";

data_header[3] = new Array;
data_header[3][0] = "Cadre"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "cadre";

/* data_header[10] = new Array;
data_header[10][0] = "Vacant Perma Post "
data_header[10][1] = "hide";
data_header[10][2] = "";
data_header[10][3] = "ipp";

data_header[11] = new Array;
data_header[11][0] = "Vacant Temp Post"
data_header[11][1] = "hide";
data_header[11][2] = "";
data_header[11][3] = "itp";

data_header[6] = new Array;
data_header[6][0] = "Vacant Super Post"
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "isp"; */
<%-- 
data_header[7] = new Array;
data_header[7][0] = "Class Size"
data_header[7][1] = "hide";
data_header[7][2] = "";
data_header[7][3] = "<%= CLASS_SIZE%>";

data_header[8] = new Array;
data_header[8][0] = "Address"
data_header[8][1] = "hide";
data_header[8][2] = "";
data_header[8][3] = "<%=TRAINING_ADDRESS %>";


data_header[9] = new Array;
data_header[9][0] = "Remarks"
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%= REMARKS%>";
 --%>
data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=CHANGED_BY %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_DATE %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "";
data_header[12][3] = "<%=CHANGED_TIME %>";

data_header[13] = new Array;
data_header[13][0] = "Status"
data_header[13][1] = "hide";
data_header[13][2] = "";
data_header[13][3] = "<%=STATUS %>";


//VKS
  data_arr = new Array();
  <%
  Iterator itr=hrInstitutionalSanctionedPost.iterator();
            int  counter=0;
            while(itr.hasNext())
             {
         	  HrInstitutionalSanctionedPost  hisp = (HrInstitutionalSanctionedPost)itr.next(); 
  %>

  data_arr[<%= counter%>] = new Array();
  data_arr[<%= counter%>][0] = <%= hisp.getId()%>
  data_arr[<%= counter%>][1] = "<%=hisp.getInstitution()!= null ? hisp.getInstitution().getHospitalName():" "%>";
  data_arr[<%= counter%>][2] = "<%=hisp.getDepartment()!= null ?  hisp.getDepartment().getDepartmentName():" "%>";
  data_arr[<%= counter%>][3] = "<%=hisp.getRank()!= null ? hisp.getRank().getRankName():" "%>";
  data_arr[<%= counter%>][4] = "<%=hisp.getCadre()!= null ? hisp.getCadre().getCadreName():" "%>";
  data_arr[<%= counter%>][5] = "<%=hisp.getPermanentPost()!= null ? hisp.getPermanentPost():" "%>";
  data_arr[<%= counter%>][6] = "<%=hisp.getTemporaryPost()!= null ? hisp.getTemporaryPost():" "%>";
  data_arr[<%= counter%>][7] = "<%=hisp.getSupernumeraryPost()!= null ? hisp.getSupernumeraryPost():" "%>";
 
  data_arr[<%= counter%>][14] = "<%= hisp.getLastChgBy()!=null?(hisp.getLastChgBy().getId()!=null?hisp.getLastChgBy().getId():"0" ):"0"%>";
  data_arr[<%= counter%>][15] = "<%= HMSUtil.convertDateToStringWithoutTime(hisp.getLastChgDate()) %>";
  data_arr[<%= counter%>][16] = "<%= hisp.getLastChgTime() %>";
 
  <% if(hisp.getStatus().equalsIgnoreCase("y")){ %>
  data_arr[<%= counter%>][17] = "Active" 
  <%}else{%>
  data_arr[<%= counter%>][17] = "InActive" 
  <%}%>
<%		     counter++;
}
%>
</script>

<script>
function calVacantPost(){ 
  var count=document.getElementById("hiddenValueCharge").value;
 // alert(count);
 var i=1;
  for(i;i<count;i++){
	//alert("vk"); 
	var cspp=document.getElementById("spp"+i).value;
	var cipp=document.getElementById("ipp"+i ).value;
	var cvpp= cspp-cipp ;
	//alert(i); 
	document.getElementById("vpp"+i).value=cvpp;
	//
	var cstp=document.getElementById("stp"+i).value;
	var citp=document.getElementById("itp"+i).value;
	var cvtp=cstp-citp;
	//alert(cvtp);
	document.getElementById("vtp"+i).value=cvtp;
	//
	var cssp=document.getElementById("ssp"+i).value;
	var cisp=document.getElementById("isp"+i).value;
	var cvsp= cssp-cisp ;
	//alert(cvsp);
	document.getElementById("vsp"+i).value=cvsp;
  }
}
</script>
  