
<%@page import="jkt.hms.masters.business.MasOpdFrequency"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>


<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	 Map<Integer,String> deptIdMap=new HashMap<Integer,String>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasInstituteDepartment>instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
	List<MasDepartmentType>departmentTypeList = new ArrayList<MasDepartmentType>();
	List<MasDepartment>deptList = new ArrayList<MasDepartment>();
	List<MasOpdFrequency> frequencyList = new ArrayList<MasOpdFrequency>();
	if(map.get("instituteDepartmentList") != null){
		instituteDepartmentList = (List)map.get("instituteDepartmentList");
	}
	if(map.get("departmentList") != null){
		departmentList = (List)map.get("departmentList");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List)map.get("frequencyList");
	}
	if(map.get("deptList") != null){
		deptList = (List)map.get("deptList");
	}
	if(map.get("departmentTypeList") != null){
		departmentTypeList = (List)map.get("departmentTypeList");
	}
	String hospitalName = "";
	int hospitalId = 0;
	if(map.get("hospitalName") != null){
		hospitalName = (String)map.get("hospitalName");
	}
	if(map.get("hospitalId") != null){
		hospitalId = (Integer)map.get("hospitalId");
	}
	
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %>
<form name="instituteWiseServiceCenterDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Institute Wise Service Centre Details</h2>
</div>

<div class="clear"></div>
<div class="Block">
<label>Service Centre Category</label>
<Select name="serviceCenterCategory" id="serviceCenterCategory" validate = "Service Center Ctaegory,string,no">
<option value="">Select</option>
<%if(departmentTypeList.size()>0){
	for(MasDepartmentType departmentType :departmentTypeList){
	%>
	<option value="<%=departmentType.getId()%>"><%=departmentType.getDepartmentTypeName() %></option>
<%}} %>

</Select>
<input type="button" name="Search" type="search" value="Search"	onClick="submitForm('instituteWiseServiceCenterDetails','systemRelatedMaster?method=searchInstituteWiseCenterDetails');" class="button" />
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Institute Name<span>*</span></label>
 <input type="text" name="instituteName" value="<%=hospitalName != null?hospitalName:"" %>"  MAXLENGTH="8" validate = "Institute Name,string,yes"  /> 
  <input type="hidden" name="instituteId" value="<%=hospitalId != 0?hospitalId:"" %>"  MAXLENGTH="8"  /> 

<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
<div id="pageNavPosition"></div>
<div class="cmntable">
<table id="instituteGrid">
	<tr>
	
	<th>Service Centre</th>
	<th>Room No</th>
	<th>Longitude</th>
	<th>Latitude </th>
	<th>Local Name </th>
	<th>Frequency </th>
	<th>Opd From Time </th>
	<th>Opd To Time </th>
	<th>Average No. Of Patients</th>
	
	</tr>
	<tbody id="tableData">
	<%
	int i = 1;int dCount=0;
	if(instituteDepartmentList.size()>0){
		for(MasInstituteDepartment instituteDepartment : instituteDepartmentList){
      
      		//added by govind 25-07-2017
			Map<Integer,Boolean> frequencyMap=new HashMap<Integer,Boolean>();
			if(instituteDepartment.getFrequency()!=null && !instituteDepartment.getFrequency().equalsIgnoreCase("")){
			String[] fre=instituteDepartment.getFrequency().split(",");
			//System.out.println("govind Length "+fre.length);
			for(int j=0;j<fre.length;j++){
				frequencyMap.put(Integer.parseInt(fre[j]), true);
			}
			}
			//added by govind 25-07-2017 end
	%>
		<%if(departmentList.size()>0) {
		for(MasDepartment masDepartment :departmentList){
			//System.out.println("aaaa-"+instituteDepartment.getDepartment().getId());
			//System.out.println("bbbb-"+masDepartment.getId());
			//System.out.println("condition-"+(instituteDepartment.getDepartment().getId()==masDepartment.getId()));
			if(instituteDepartment.getDepartment().getId()==masDepartment.getId()){
				dCount++;
	%>
	<%break;}}} %>
	<%if(dCount>0){
	%>
	<tr>	
	<td>
	<input style="width:150px;" name="serviceCenter<%=i %>" id="serviceCenterId" value="<%=instituteDepartment.getDepartment().getDepartmentName() %>"/>	
	<input type="hidden" name="instituteDepartmentId<%=i %>" id="instituteDepartmentId" value="<%=instituteDepartment.getId() %>" /></td>
	<td><input class="medium" name="roomNo<%=i %>" id="roomNoId" value="<%=instituteDepartment.getRoomNo()!= null?instituteDepartment.getRoomNo():""%>"/></td>
	<td><input class="medium" name="longitude<%=i %>" id="longitudeId" value="<%=instituteDepartment.getLongitude()!= null?instituteDepartment.getLongitude():""%>"/></td>
	<td><input class="medium" name="latitude<%=i %>" id="latitudeId" value="<%=instituteDepartment.getLatitude()!= null?instituteDepartment.getLatitude():""%>"/></td>
	<td><input style="width:110px;" name="localName<%=i %>" id="localNameId" value="<%=instituteDepartment.getAlternativeName()!= null?instituteDepartment.getAlternativeName():""%>"/></td>
	
	<td><select name="frequencyId<%=i %>" multiple="multiple" class="multiTd">
	<option value="0">Select</option>
	<!-- added by govind 25-07-2017 -->
		<%if(frequencyMap.size()>0){
			if(frequencyList.size()>0){
		for(MasOpdFrequency opdFrequency : frequencyList){	
			if(frequencyMap.get(opdFrequency.getId())!=null && frequencyMap.get(opdFrequency.getId())){
		%>
		<option value="<%=opdFrequency.getId()%>" selected="selected"><%=opdFrequency.getFrequencyName() %></option>
		<%}else{%>
		<option value="<%=opdFrequency.getId()%>" ><%=opdFrequency.getFrequencyName() %></option>
	 <%}}}}else{
	if(frequencyList.size()>0){
	 for(MasOpdFrequency opdFrequency : frequencyList){	%>
	 <option value="<%=opdFrequency.getId()%>" ><%=opdFrequency.getFrequencyName() %></option>
	 <%}}}%>
		
	<%--<%if(frequencyList.size()>0){
		for(MasOpdFrequency opdFrequency : frequencyList){
			if( instituteDepartment.getOpdFrequency() != null && instituteDepartment.getOpdFrequency().getId().equals(opdFrequency.getId())){
		%>
		<option value="<%=opdFrequency.getId()%>" selected="selected"><%=opdFrequency.getFrequencyName() %></option>
	<%}else{ %>
	<option value="<%=opdFrequency.getId()%>" ><%=opdFrequency.getFrequencyName() %></option>
	<%}}} %> --%>
	
	<!-- added by govind 25-07-2017 end -->
	</select></td>
	<td><input class="medium" type="text" name="opdTime<%=i %>" id="opdTime" value="<%=instituteDepartment.getOpeningTime()!= null?instituteDepartment.getOpeningTime():"" %>" maxlength="5" validate="Opd From Time,string,no" onKeyUp="mask(this.value,this,'2',':');"	/> </td>
	<td><input class="medium" type="text" name="closingTime<%=i %>" id="closingTime" value="<%=instituteDepartment.getClosingTime()!= null?instituteDepartment.getClosingTime():"" %>" maxlength="5" validate="Opd To Time,string,no" onKeyUp="mask(this.value,this,'2',':');"	/> </td>
	<td><input type="text" name="avgNoOfPatients<%=i %>" id="avgNoOfPatients" value="<%=instituteDepartment.getAvgNoOfPatients()!= null?instituteDepartment.getAvgNoOfPatients():"" %>" maxlength="5" validate="Average No Of Patients,int,no"	/> </td>
	</tr>
	<%}dCount=0;%>
	<%i++;}} %>
	
	</tbody>
</table>
</div>

</div>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i-1 %>" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<div id="testDiv"></div>
<script type="text/javascript">
var instituteArray =new Array();
var frequencyArray =new Array();
</script>
<%  int j=0;
int instituteDepartmentId =0;
//added by govind 04-08-2017
int instDept=0;
for(MasInstituteDepartment masDepartment:instituteDepartmentList){
	
	if(deptIdMap.get(masDepartment.getDepartment().getId())!=null){
	}else{//added by govind 04-08-2017
	//for(MasInstituteDepartment instituteDepartment : instituteDepartmentList){
		//instituteDepartmentId = instituteDepartment.getDepartment().getId();

//System.out.println("instituteDepartmentId=="+instituteDepartmentId);
	//if(masDepartment.getId() != instituteDepartmentId){
%>
<script>
instituteArray[<%=j%>]= new Array();
instituteArray[<%=j%>][0] = "<%=masDepartment.getDepartment().getId()%>";
instituteArray[<%=j%>][1] = "<%=masDepartment.getDepartment().getDepartmentName()%>";

		</script>
<%j++;}deptIdMap.put(masDepartment.getDepartment().getId(), "Y");} %>

<%  int k=0;

for(MasOpdFrequency masOpdFrequency:frequencyList){
	
%>
<script>
frequencyArray[<%=k%>]= new Array();
frequencyArray[<%=k%>][0] = "<%=masOpdFrequency.getId()%>";
frequencyArray[<%=k%>][1] = "<%=masOpdFrequency.getFrequencyName()%>";

		</script>
<%k++;} %>

<input type="button" name="Submit" type="submit" value="Submit"	onClick="submitForm('instituteWiseServiceCenterDetails','systemRelatedMaster?method=submitInstituteWiseCenterDetails');" class="button" />
<!-- <input type="button" name="Next/Update" type="submit" value="View"	onClick="submitForm('enquiryBroadcastdashBoard','stores?method=viewBroadCastStatusData');" class="button" />
 --><script type="text/javascript">
var pager = new Pager('tableData',10);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);


function validateRows(){
	var count = document.getElementById('hdb').value;
	for(var i=1;i<count;i++){
		if(document.getElementById('srNo'+i).checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}

function removeRow()
{
	var tbl = document.getElementById('indentDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	     
  	for(i=0;i<document.getElementsByName('srno').length;i++)
	{
		
  		if (document.getElementsByName('srno')[i].checked == true)
		{
		  	tbl.deleteRow(i+1);
		}
	}
}

function addRow(){
	  var tbl = document.getElementById('instituteGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('select');
	  e0.name='serviceCenter'+iteration;
	  e0.id='serviceCenterId';
	  e0.style.width = "154px";
	  e0.setAttribute('validate', 'Service Center,string,yes');
	  e0.options[0] = new Option('Select', '0');
	  for(var k = 0;k<instituteArray.length;k++){
			e0.options[k+1] = new Option(instituteArray[k][1],instituteArray[k][0]);
		}
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='roomNo'+iteration;
	  e1.id='roomNoId';
	  e1.className="medium";
	  e1.size = '28'
	 cellRight2.appendChild(e1);

	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'longitude'+ iteration;
	  e2.id = 'longitudeId';
	  e2.className="medium";
	  e2.size = '28'
	  cellRight3.appendChild(e2);

	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='latitude'+iteration;
	  e3.id='latitudeId';
	  e3.className="medium";
	  e3.size = '28'
	 cellRight4.appendChild(e3);
	  
	  var cellRight5 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='localName'+iteration;
	  e4.id='localNameId';
	  e4.style.width = "110px";
	  e4.size = '28'
	  cellRight5.appendChild(e4);
	 	 
	  var cellRight6 = row.insertCell(5);
	  var e5 = document.createElement('select');
	  e5.name='frequencyId'+iteration;
	  e5.id='frequencyId'
	  e5.setAttribute('multiple', 'multiple');
	  e5.className='multiTd';
	  e5.options[0] = new Option('Select', '0');
	  for(var k = 0;k<frequencyArray.length;k++){
			e5.options[k+1] = new Option(frequencyArray[k][1],frequencyArray[k][0]);
		}
	  //e4.onchange=function(){getExpiryDateByAjax(this.value,iteration);};
	  cellRight6.appendChild(e5);
	  
	  var cellRight7 = row.insertCell(6);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name='opdTime'+iteration;
	  e6.id='opdTime';
	  e6.className="medium";
	  e6.size = '22';
	  e6.onkeyup = function(){mask(this.value,this,'2',':');}
	  e6.maxLength ='5';
	  cellRight7.appendChild(e6);
	  
	  var cellRight8 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='closingTime'+iteration;
	  e7.id='closingTime';
	  e7.className="medium";
	  e7.size = '22';
	  e7.onkeyup = function(){mask(this.value,this,'2',':');}
	  e7.maxLength ='5';
	  cellRight8.appendChild(e7);
	  
	  var cellRight9 = row.insertCell(8);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='avgNoOfPatients10'+iteration;
	  e8.id='avgNoOfPatients';
	 // e8.onkeyup = function(){mask(this.value,this,'2',':');}
	  e8.maxLength ='5';
	  cellRight9.appendChild(e8);
	  
}

</script>

</form>


