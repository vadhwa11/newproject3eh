
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HospitalUnitDays" %>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>

<script type="text/javascript">

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
	serverdate = '<%=curDate+"/"+month+"/"+year%>';
</script>
<form name="hospUnit" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
	//List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<Object[]> empList = new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	if(map.get("employeeDepartmentList") != null){
		employeeDepartmentList = (List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
	}
	/* if(map.get("empList") != null){
		empList = (List<MasEmployee>)map.get("empList");
	} */
	 if(map.get("empList") != null){
		empList = (List<Object[]>)map.get("empList");
		} 


%>
<div class="titleBg">
<h2>Hospital Unit</h2>
</div>
<div class="Block">
<h4>Hospital Unit Search</h4>
<label>Department <span>*</span></label>
<select id="empDepSearchId"  name="empDepSearchId"  tabindex=1  onblur="submitProtoAjaxWithDivName('hospUnit','/hms/hms/hospital?method=getEmpDepartmentSearch','testDiv');">
	<option value="0">Select</option>
	<%

	if(employeeDepartmentList.size()>0){
		for(MasEmployeeDepartment empDepSearch :employeeDepartmentList){%>
			
		<option value="<%=empDepSearch.getId() %>" ><%=empDepSearch.getEmpDeptName()%></option>
		
	<%}
		}%>
</select>

<div id="testDiv">

<label>Unit Code <span>*</span></label>
<select id="unitCodeId"  name="unitCodeId"  tabindex=1  >
	<option value="0">Select</option>
</select>
<input type="button" name="search" value="Search" class="button"  onclick="if(checkUnitCode()){submitProtoAjaxWithDivName('hospUnit','/hms/hms/hospital?method=showDataFromSearch','nameDiv');}"tabindex=1 /> 

<div class="clear"></div>

<h4>Create Hospital Unit </h4>
<div class="clear"></div>

<label>Deptartment <span>*</span></label>
<select id="empDeptId"  name="empDeptId"  tabindex=1 >
	<option value="0">Select</option>
	<%

	if(employeeDepartmentList.size()>0){
		for(MasEmployeeDepartment empDep :employeeDepartmentList){%>
			
		<option value="<%=empDep.getId() %>" ><%=empDep.getEmpDeptName()%></option>
		
	<%}
		}%>
</select>

<label>Unit Code <span>*</span></label>
<input id="unitCode" type="text"   name="unitCode" value=""   tabindex=1 />
<div class="clear"></div>

<!-- changed by srikanth start -->
			<div>
			<%
			for(HospitalUnitDays day:HospitalUnitDays.values()){
				%>
				
					<label class="medium1" style=" margin-right:20px">
					<input type="checkbox" name="unitradio" id="<%=day.getLabelValue()%>" value="<%=day.getLabelValue()%>" class="checkboxMargin" />
					<%=day.getLabelName()%></label>
			<% }%>
			</div>
			<!-- changed by srikanth end -->

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="cmntable" style="width:890px;float:left;">
<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="empDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Employee Name</th>
		<th scope="col">Designation</th>
		<th scope="col">Head</th>
		
	</tr>

   <%int i = 1;%>
	<tr>
	<td><input type="radio" value="<%=i%>" name="selectedChrage"  class="radioAuto" /></td>
	
	
	<td>
	<select id="empNameId<%=i%>"  name="empNameId<%=i%>"  tabindex=1  onblur="populateRankDesignation(this.value,<%=i%>);">
	<option value="0">Select</option>
	<%

	if(empList.size()>0){
		
		for(Object[] emp :empList){
		%>
			
		<option value="<%=emp[0] %>" ><%=emp[1]%></option>
		
	<%}
		}%>
	</select>
	
	</td>
	<td id="testDiv<%=i%>"> <input  type="text"   id="desigation<%=i%>"   name="desigation<%=i%>" value=""  readonly="readonly"  size="30"/>
	<input type="hidden" value="0" name="huDId<%=i %>" id="huDId<%=i %>" />
	</td>

	<td> <input id="head<%=i%>"   name="head" value="y"  type="checkbox" class="radioCheck"  MAXLENGTH="8" tabindex=1 onclick="validateCheckBoxForHead(this,<%=i%>);"/>
	<input type="hidden" name="hiddenHeadValue<%=i %>" id="hiddenHeadValue<%=i%>" value=""/>
	
	</td>
	</tr>
	</table>
	</div>

<div class="floatRight" style="margin-right:150px;">
	<input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" />
	<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
	<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
	<input type="hidden" value="0" name="huMId" id="huMId" />
</div>
	
<div class="clear"></div>

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('hospUnit','hospital?method=submitHospitalUnit&flag=s','validateHeader');" accesskey="a" tabindex=1 />
 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="" accesskey="u" tabindex=1 />
  <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="" accesskey="d" tabindex=1 />
  <input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
</div>
</div>
  <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>


            <script type="text/javascript">	
            var ee=new Array();
     			<%
     			int k =0;
     			for (Object[] emp : empList) {
     			%>
     			ee[<%=k%>]= new Array();
     			ee[<%=k%>][0] = "<%=emp[0]%>";
     			ee[<%=k%>][1] = "<%=emp[1]%>";	
     			<%k++;}%>

     			
            </script> 
<script type="text/javascript">
function addRow(){
	
 
	  
	  
      var tbl = document.getElementById('empDetails');
      var lastRow = tbl.rows.length;

      var row = tbl.insertRow(lastRow);
      var hdb = document.getElementById('hiddenValueCharge');
      var iteration = parseInt(hdb.value)+1;
      hdb.value = iteration;


	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioAuto';
	e0.value=(iteration);
	cell0.appendChild(e0);

	
	var cellRight11 = row.insertCell(1);
	var e11 = document.createElement('Select');
	e11.name='empNameId'+iteration;
	e11.id='empNameId'+iteration;
	e11.onblur=function(){populateRankDesignation(this.value,iteration);};
	e11.options[0] = new Option('Select', '0');
	
	   for(var i = 0;i<ee.length;i++ ){
		      e11.options[i+1] = new Option(ee[i][1],ee[i][0]);
		      }
	cellRight11.appendChild(e11);

	

	var cell2 = row.insertCell(2);
	cell2.id='testDiv'+iteration;
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='desigation'+(iteration);
	e2.id='desigation'+(iteration);
	e2.readOnly = true;
	e2.size='30';
	e2.value='';
	cell2.appendChild(e2);

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'checkbox';
	e3.className='radioCheck';
	e3.name='head';
	e3.id='head'+(iteration);
	e3.tabIndex='1';
	e3.onclick=function(){validateCheckBoxForHead(this,iteration);};
	cell3.appendChild(e3);
	var e31 = document.createElement('input');
	e31.type = 'hidden';
	e31.name='hiddenHeadValue'+(iteration);
	e31.id='hiddenHeadValue'+(iteration);
	cell3.appendChild(e31);
	
    var cell5 = row.insertCell(4);
 	var e5 = document.createElement('input');
 	e5.type = 'button';
 	e5.name='add';
 	e5.className = 'buttonAdd';
 	e5.tabIndex='1';
 	e5.onclick = function(){
 					addRow();
 	}

	aaaa(iteration);
}



function validateDuplicateEmployee(index)
{
	var count = document.getElementById('hiddenValueCharge').value;
	var empNameId=document.getElementById("empNameId"+index).value;
	for(var i=1;i<=count;i++)
		{
		   if(i!=index && document.getElementById("empNameId"+i)!=null && document.getElementById("empNameId"+i).value!=''&& document.getElementById("empNameId"+i).value!=0)
			   {
			   if(document.getElementById("empNameId"+i).value==empNameId)
			    	{
				   
			    	alert(document.getElementById("empNameId"+i).options[document.getElementById("empNameId"+i).selectedIndex].text +" is duplicate");        				    	
			    	document.getElementById("empNameId"+index).value=0;
			    	return false;
			    	}
			   
			   }
		}
	return true;
}
function validateHeader(){
var errMsg = "";
	var empDeptId = document.getElementById('empDeptId').value;
	var unitCode = document.getElementById('unitCode').value;

	if(empDeptId == 0){
		errMsg += "Department can not be blank.\n";
	}
	
	if(unitCode == ""){
		errMsg += "Unit Code can not be blank.\n";
	}
	var cnt = document.getElementById('hiddenValueCharge').value;
//	for(i=1; i<=cnt; i++){
			
	//	if(document.getElementById('empNameId'+i).value==null){
		//	errMsg += "Employee can not be blank.\n";
		//}
		
//	}

	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}





	function removeRow()
	{
		
	       var tbl = document.getElementById('empDetails');
	        var tblRows  = tbl.getElementsByTagName("tr");

	         if(tblRows.length-2==0){
	                alert("Can not delete all rows")
	                return false;
	    }

	       for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	       {
	               if (document.getElementsByName('selectedChrage')[counter].checked == true)
	               {
	            	   var unit_t_id=tbl.rows[counter+1].children[3].value;
	            	   onDelete(counter+1);
	            	   if(typeof unit_t_id != 'undefined'){
	            		   removeDoctorFromUnit(unit_t_id);
	            	   }
	            	   
	                   tbl.deleteRow(counter+1);
	                 //document.getElementById('hiddenValueCharge').value=(counter);
	                         
	               }
	               
	             
	       }
	      
	 
	}

	function checkUnitCode(){
		var msg ="";	
		var cnt = document.getElementById('unitCodeId').value;
					  						
		  			if(cnt=="0"){
		  				alert("Please Select Unit Code on Search Block");
  					return false;
		  			}
  					
				return true;
		}


	function validateFieldsFrCashVoucher(){
		var msg ="";
	
		var cnt = document.getElementById('hiddenValueCharge').value;
					for(i=0; i<cnt; i++){
  						if(document.getElementById('empNameId'+i)){
		  			if(document.getElementById('empNameId'+i).value =="0"){
  					msg += "Employee can not be blank.\n";
		  			}
  						}
  						if(document.getElementById('headId'+i)){
		  			if(document.getElementById('headId'+i).value == ""){
	 					msg += "Head can not be blank.\n";
		  			}
  				  }
		  			

				}
			//}
			if(msg != ""){
				alert(msg);
				return false;
			}
			return true;
		}

		
		
		
		

		function populateRankDesignation(val,incr){
			
		    	if(val != ""){
				for(i=1;i<incr;i++)
				{
		 			if(incr != 1)
					{
						if(val!=""){
						if(document.getElementById('empNameId'+i).value == val)
						{
							alert("Employee Name already selected...!");
							document.getElementById('empNameId'+incr).value="";
							var e=eval(document.getElementById('empNameId'+incr));
							e.focus();
						}
						}else{
							return false;
						}

					}
			  	}
				
				submitProtoAjaxForLionClass('hospUnit','/hms/hms/hospital?method=getRankDesignation&val='+val+'&counter='+incr,incr);
		   
		  }
		}
		function submitProtoAjaxForLionClass(formName,action,incr){
			errorMsg = "";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName)

		        	new Ajax.Updater('testDiv'+incr,url,
					   {asynchronous:true, evalScripts:true });

		    	 
					return true;
		    	}
		

		
		
		function validateCheckBoxForHead(obj,cnt)
		{
			
			var count = document.getElementById('hiddenValueCharge').value;
			for(var i=0;i<count;i++)
				{
				//alert(obj)
				//alert(obj.checked)
				if(obj.checked){
					document.getElementById('hiddenHeadValue'+(cnt)).value="y";
					 if(document.getElementsByName('head')[i].checked == false)
					 {
						 document.getElementsByName('head')[i].disabled=true;
						 document.getElementById('hiddenHeadValue'+(i+1)).value="n";
					 }
				}else{
					document.getElementById('hiddenHeadValue'+(cnt)).value="n";
					 if(document.getElementsByName('head')[i].checked == false)
					 {
						 document.getElementsByName('head')[i].disabled=false;
						 document.getElementById('hiddenHeadValue'+(i+1)).value="n";
					 }
					
				}	
				
				
				}
			
		}
		

		function aaaa(cnt){
			
			var count = document.getElementById('hiddenValueCharge').value;
			for(var i=0;i<count;i++)
				{
					if(document.getElementsByName('head')[i].checked == true){
						 document.getElementsByName('head')[cnt-1].disabled=true;
						 document.getElementById('hiddenHeadValue'+(cnt)).value="n";
						
					}
				}	
					
				
			}
			
		

		function onDelete(cnt){
			
			var count = document.getElementById('hiddenValueCharge').value;
			if( document.getElementsByName('head')[cnt-1].checked){
				for(var i=0;i<count;i++)
				{
					if(document.getElementsByName('head')[i].checked == false){
						 document.getElementsByName('head')[i].disabled=false;
						 document.getElementById('hiddenHeadValue'+(i+1)).value="y";
						
					}
				}	
			}
					
				
			}
			
	
	function removeDoctorFromUnit(unit_t_id){
		
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange=function() {
			  
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    }
		  };
		  xhttp.open("GET", "/hms/hms/hospital?method=removeDoctorFromUnit&unit_t_id="+unit_t_id, true);
		  xhttp.send();
		
	}
	
		
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
