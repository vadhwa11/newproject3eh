<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Create Date: 11th Feb,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrInstitutionalSanctionedPost"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

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
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	List<MasDistrict> masDistrictList=new ArrayList<MasDistrict>();
	List<MasEmployeeDepartment> deptpartmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasCadre> cadreList =new ArrayList<MasCadre>();
	List<MasRank> designationList = new ArrayList<MasRank>();
	  
	 
	if(map.get("institutionList") !=null){
		institutionList =(List) map.get("institutionList");
	}
	if(map.get("mhospitalTypetList") !=null){
		mhospitalTypetList  =(List) map.get("mhospitalTypetList");
	}
	  
	if(map.get("masDistrictList")!=null){
		masDistrictList=(List) map.get("masDistrictList");
	}
	if(map.get("deptpartmentList") !=null){
		deptpartmentList =(List) map.get("deptpartmentList");
	}
	if(map.get("cadreList") !=null){
		cadreList =(List) map.get("cadreList");
	}
	if(map.get("designationList") !=null){
		designationList =(List) map.get("designationList");
	}
	
	if(map.get("hrInstitutionalSanctionedPosts") !=null){
		hrInstitutionalSanctionedPost =(List<HrInstitutionalSanctionedPost>) map.get("hrInstitutionalSanctionedPosts");
	}
	 
	  List<Object[]> list = new ArrayList<Object[]>();
	      if(map.get("list") != null){
	   	 list = (List<Object[]>)map.get("list");
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
	String massage="";
	if (map.get("massage") != null) {
		massage = (String) map.get("massage");
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
<span><%=massage %></span> 
<h2>Vacancy Position </h2>
</div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div> 
 
<script type="text/javascript">
formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"institute"], [2,"department "], [3,"designation"], [4,"cadre"], [5,"spp"],[6,"stp"], [7,"ssp"], [8,"ipp"], [9,"itp"],[10,"isp"], [11,"vpp"],[12,"vtp"], [13,"vsp"] [14,"<%= CHANGED_BY%>"], [15,"<%= CHANGED_DATE %>"],[16,"<%= CHANGED_TIME %>"],[17,"<%=STATUS%>"] ];
	 statusTd = 14;
	</script></div>  
 
<div class="Block">
<div id="testDiv">
<form name=search method="post" action="">
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<label>District </label> 
<select id="district"	name="district" validate="District ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasDistrict  md : masDistrictList){%>
		<%if(md.getDistrictName()!=null){ %>
	<option value="<%=md.getId()%>"><%=md.getDistrictName()%></option>
	<%} %> 
	<%} %>
	</select>
	 
	 <label>Institution Type </label> 
<select id="instituteType"	name="instituteType" validate="Institute type ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasHospitalType  mht : mhospitalTypetList)
		{
	%>
	<option value="<%=mht.getId()%>"><%=mht.getHospitalTypeName()%></option>
	<%
		}
	%> 
	</select>
	 
	<label>Institution</label> <select name="institute" id="institute" validate="Institute,string,no" tabindex=1 onChange="populateDept('temp')">
	<option value="">Select</option>
	  <%
		for (MasHospital masHospital: institutionList) {
	%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>

	<%
		}
	%>  
</select> 
	<div class="clear"></div>
 <label>Department</label> <select name="department" id="department" validate="Department,string,no">
	<option value="">Select</option>
	  <%
		for (MasEmployeeDepartment masDepartment: deptpartmentList) {
	%>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getEmpDeptName()%></option>

	<%
		}
	%>  
</select> 

<label>Cadre </label> 
<select id="cadre"	name="cadre" validate="Cadre ,string,no" tabindex=1 onChange="populateDesignation(this.value,'designation')">
	<option value="">Select</option>
	 <% 
		for (MasCadre  mcl : cadreList)
		{
	%>
	<option value="<%=mcl.getId()%>"><%=mcl.getCadreName()%></option>
	<%
		}
	%> 
	</select>
 	
<label>Designation</label> <select name="designation" id="designation" validate="Designation,string,no">
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
</select>
  
<!--  <input name="search" type="button" class="button"	value="Search" onclick="submitProtoAjaxWithDivName('search','/hms/hrms/training?method=searchVacancyPositionJsp','testDiv');"/>	 -->
<input name="search" type="button" class="button"	value="Search" onclick="submitForm('search','/hms/hrms/training?method=showVacancyPositionJsp');"/>
</form>
</div> 
</div>
 <div class="clear"></div>
<!-- <h4>Add Session</h4> -->
<input name="" value="" id="temp" type="hidden" /> 
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
<form name="submit" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
<%if(hrInstitutionalSanctionedPost.size()>0){ %>
<table width="100%" colspan="0" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0" class="cmntable">
		<tr>
			<th width="13%"></th>
			<th width="13%"></th>
			<th width="13%"></th>
			<th width="10%"  colspan="3">Sanction Post</th>
			<th width="10%"  colspan="3">In Position Post</th>
			<th width="10%"  colspan="3">Vacant Post</th>			
		</tr>
		<tr>
			<th width="13%">Institution</th>
			<th width="13%">Department</th>
			<th width="13%">Designation</th>
			<th width="10%">PP</th>
			<th width="10%">TP</th>
			<th width="10%">SP </th>
			<th width="10%">PP</th>
			<th width="10%">TP</th>
			<th width="10%">SP </th>
			<th width="10%">PP</th>
			<th width="10%">TP</th>
			<th width="10%">SP </th>			
		</tr>	
		 <%int i = 1;
		
		%>
		<%for(HrInstitutionalSanctionedPost pd : hrInstitutionalSanctionedPost){ %>
		
		<tr>
			 
		<input type="hidden" value="<%=pd.getId()%>"  name="postId<%=i %>"	tabindex=1  id="postId<%=i  %>"  size="32"/>
		
			<td>
			<%if(pd.getInstitution()!=null){ %>
			<input type="text" name="institute<%=i %>" readonly="readonly" value="<%= pd.getInstitution().getHospitalName()%> " tabindex=1  id="institute<%=i %>" size="28"  maxlength="32"/>
			<input type="hidden" value="<%= pd.getInstitution().getId()%> " name="instituteId<%=i %>"/>
			 <%}else{%>
      	       <input type="text" name="institute<%=i %>" readonly="readonly" value="" tabindex=1  id="institute<%=i %>" size="28"  maxlength="32"/>
			
                <%} %>
			</td>
			<td>
			<%if(pd.getDepartment()!=null){ %>
			<input type="text" name="dept<%=i %>" readonly="readonly" value="<%= pd.getDepartment().getEmpDeptName()%> " tabindex=1  id="dept<%=i %>" size="28"  maxlength="32"/>
			<input type="hidden" value="<%= pd.getDepartment().getId()%> " name="deptId<%=i %>"/>
			 <%}else{%>
      	       <input type="text" name="dept<%=i %>" value="" readonly="readonly"  tabindex=1  id="dept<%=i %>" size="28"  maxlength="32"/>
			
                <%} %>
			</td>
			<td>
			<%if(pd.getRank()!=null){ %>
			<input type="text" name="desig<%=i %>" readonly="readonly" value=" <%=pd.getRank().getRankName()%> " tabindex=1  id="desig<%=i %>" size="28"  maxlength="32"/>
	           <input type="hidden" value="<%= pd.getRank().getId()%> " name="desgID<%=i %>"/>
			 <%}else{%>
      	        <input type="text" name="desig<%=i %>" value="" tabindex=1  id="desig<%=i %>" size="28"  maxlength="32"/>
                <%} %>
			</td>
			<td>
			<%if(pd.getPermanentPost()!=null){ %>
			<input type="text" name="spp<%=i %>" readonly="readonly" value=" <%= pd.getPermanentPost()!=null?pd.getPermanentPost():"0"%> " tabindex=1  id="spp<%=i %>" size="3"  maxlength="3"/>
			 
			 <%}else{%>
      	      	<input type="text" name="spp<%=i %>" readonly="readonly" value="0" tabindex=1  id="spp<%=i %>" size="3"  maxlength="3"/>
                <%} %>
			</td>
			<td>
			<%if(pd.getTemporaryPost()!=null){ %>
			<input type="text" name="stp<%=i %>" readonly="readonly" value=" <%= pd.getTemporaryPost()!=null?pd.getTemporaryPost():"0"%> " tabindex=1  id="stp<%=i %>" size="3"  maxlength="3"/>
			 
			 <%}else{%>
      	     <input type="text" name="stp<%=i %>" readonly="readonly" value="0" tabindex=1  id="stp<%=i %>" size="3"  maxlength="3"/>
                <%} %>
			</td>
			<td>
			<%if(pd.getSupernumeraryPost()!=null){ %>
			<input type="text" name="ssp<%=i %>" readonly="readonly" value="<%= pd.getSupernumeraryPost()!=null?pd.getSupernumeraryPost():"0"%> " tabindex=1  id="ssp<%=i %>" size="3"  maxlength="3"/>
			 
			 <%}else{%>
      	     	<input type="text" name="ssp<%=i %>" readonly="readonly" value="0" tabindex=1  id="ssp<%=i %>" size="3"  maxlength="3"/>
			</td>
                <%} %>
			</td>
			<td>
			<input type="text" name="ipp<%=i%>" value=""	tabindex=1  id="ipp<%=i%>"  size="3" maxlength="3" onblur="calVacantPost()" />
			</td>
			<td>
			<input type="text" name="itp<%=i%>" value=""	tabindex=1  id="itp<%=i%>"  size="3" maxlength="3" onblur="calVacantPost()" />
			</td>
			<td>
			<input type="text" name="isp<%=i%>" value=""	tabindex=1  id="isp<%=i%>"  size="3" maxlength="3"  onblur="calVacantPost()"/>
			</td>
			<td>
			<input type="text" name="vpp<%=i%>" value=""	tabindex=1  id="vpp<%=i%>"  size="3" maxlength="3" />
			</td>
			<td>
			<input type="text" name="vtp<%=i%>" value=""	tabindex=1  id="vtp<%=i%>"  size="3" maxlength="3" />
			</td>
			<td>
			<input type="text" name="vsp<%=i%>" value=""	tabindex=1  id="vsp<%=i%>"  size="3" maxlength="3" />
			</td>
		</tr> 
		<%
		i++;
		} %>
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

 <input name="Submit" type="button" class="button"	value="Save" onclick="submitForm('submit','training?method=saveVacancyPosition');" />
<%}else{ %>
	No Records Available.
<%} %>

<div id="edited"></div>  
<div class="clear"></div>

 
<input type="hidden" name="<%=STATUS %>" value="y" />
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
  data_arr[<%= counter%>][2] = "<%=hisp.getDepartment()!= null ?  hisp.getDepartment().getEmpDeptName():" "%>";
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
calVacantPost();
</script>

<script type="text/javascript">

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}

  function populateInst(id)
  {
	var hosType=document.getElementById("instituteType").value; 
	var dist=document.getElementById("district").value;
	//alert(hosType+" -- "+dist)
	var sel = document.getElementById("institute");
	removeAllOptions(sel);
	if(hosType!="0" && dist==0){
		//alert(hosType+" hosType not zero dist- "+dist)
	var size = <%=institutionList.size()%>  
	optionRepMan = new Option("Select" , "0","true");
	sel.options.add(optionRepMan);
		 	<%
			for(MasHospital mid:institutionList){%>
				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equalsIgnoreCase("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
			<%}
			%>
				}
				<%}%>
		}
	
	if(dist!="0" && hosType =="0"){
		//alert(hosType+" not zero dist- "+dist)
		var size = <%=institutionList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);

		<%
				for(MasHospital mid:institutionList){%>
				<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
				
			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=institutionList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
				<%
				for(MasHospital mid:institutionList){%>
				<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
			}
}

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;
   return true;
}
 
function populateDesignation(cadre,id){	
		var sel = document.getElementById(id);
		removeAllOptions(sel);
		if(cadre !="0"){
				<% 
				for(MasRank mr:designationList){%>
				<%if(mr.getCadre()!=null){%>
				 if(<%=mr.getCadre().getId() %> == cadre){ <% 
							if(mr.getStatus().equalsIgnoreCase("y")){
						%>
					optionRepMan = new Option("<%=mr.getRankName()%>" , "<%=mr.getId()%>","true");				
					sel.options.add(optionRepMan);
					<%}%>
					}
				 <%}%>
					<%}%>
					optionRepMan = new Option("<%="Select"%>" , "0","true");				
					sel.options.add(optionRepMan);
		}
}

<%-- function populateDept(id){	
	var sel = document.getElementById(id);
	removeAllOptions(sel);
	if(institute !="0"){
			<% 
			for(MasEmployeeDepartment mr:deptpartmentList){%>
			<%if(mr.getEmpDeptName()!=null){%>
			 if(<%=mr.getEmpDeptName()%> == institute){ <% 
						if(mr.getStatus().equalsIgnoreCase("y")){
					%>
				optionRepMan = new Option("<%=mr.getEmpDeptName()%>" , "<%=mr.getId()%>","true");				
				sel.options.add(optionRepMan);
				<%}%>
				}
			 <%}%>
				<%}%>
				optionRepMan = new Option("<%="Select"%>" , "0","true");				
				sel.options.add(optionRepMan);
	}
} --%>

</script>
  