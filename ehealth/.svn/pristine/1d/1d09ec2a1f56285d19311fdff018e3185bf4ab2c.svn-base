
<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="../jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	/* List<PhMasLocality> phMasLocalityList= new ArrayList<PhMasLocality>();
	if(map.get("phMasLocalityList") != null){
		phMasLocalityList = (List)map.get("phMasLocalityList");
		
	} */
	
/* 	List<LocationParameterMapping> phMasLocalityList= new ArrayList<LocationParameterMapping>();
	if(map.get("phMasLocalityList") != null){
		phMasLocalityList = (List)map.get("phMasLocalityList");
		
	} */
	List<Object[]> phMasLocalityList = new ArrayList<Object[]>();
	if(map.get("phMasLocalityList") !=null){
		phMasLocalityList=(List<Object[]>)map.get("phMasLocalityList");
	}
	List<MasPostCode> postCodeList= new ArrayList<MasPostCode>();
	if(map.get("postCodeList") != null){
		postCodeList = (List)map.get("postCodeList");
		
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>
<h4><span><%=message %></span></h4>
<%} %>
<form name="schoolRegistration" method="post" action="">
<div class="titleBg">
<h2>School Anganwadi</h2> 
</div>
<div class="Block">
<label class="autoSpace"> School 
<%-- <input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="School" class="radioCheckCol2" onclick="schoolTypeList();submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameList&schoolTypeVal=1002','schoolDiv');" />  --%>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="School" class="radioCheckCol2" onclick="schoolTypeList();" /> 
</label>

<label class="autoSpace">Anganwadi 
<%-- <input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="Anganwadi" class="radioCheckCol2" onclick="schoolTypeList();submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameAnganvadi&schoolTypeVal=1001','anganwadiDiv');" /> --%>
<input type="radio"	id="<%=SCHOOL_TYPE%>"  name="<%=SCHOOL_TYPE %>" value="Anganwadi" class="radioCheckCol2" onclick="schoolTypeList();" />
</label>
<!-- <div class="clear"></div><div class="clear"></div><div class="clear"></div> -->
<div id="schoolDiv" style="display: none;">

<label><span>*</span>Locality /Place</label>
<select	onblur="submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameList&schoolTypeVal=1002&localityId='+this.value,'testDivs');"
		onchange="submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameList&schoolTypeVal=1002&localityId='+this.value,'testDivs');">
<%	if(phMasLocalityList.size() !=0){%>	
			
				<option value="0">Select</option>
				 <%
				 for (Object[]  l : phMasLocalityList) {
				 
					 if(l[0]!=null){
				  %>
				  <option value="<%=l[0]%>"><%=l[1]%></option>
				  <%}
				  	 	}
				   %>
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
	 <div id="testDivs">
	</div>
	
	</div>
	
<div id="anganwadiDiv" style="display: none;">

	<label><span>*</span>Locality /Place</label>
<select	onblur="submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameAnganvadi&schoolTypeVal=1001&localityId='+this.value,'testDivss');"
		onchange="submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameAnganvadi&schoolTypeVal=1001&localityId='+this.value,'testDivss');">
<%	if(phMasLocalityList.size() !=0){%>
	
			
		<option value="0">Select</option>
				 <%
				 for (Object[]  l : phMasLocalityList) {
				 
					 if(l[0]!=null){
				  %>
				  <option value="<%=l[0]%>"><%=l[1]%></option>
				  <%}
				  	 	}
				   %>
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
	 <div id="testDivss">
	</div>
	
	</div>

</div>
<div class="clear"></div>

<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script language="Javascript">
function schoolTypeList()
{

		var schoolType = document.schoolRegistration.<%=SCHOOL_TYPE%>.value;
		if(schoolType == "Anganwadi"){
			document.getElementById('anganwadiDiv').style.display = "inline";
			document.getElementById('schoolDiv').style.display = "none";
			document.getElementById('testDivs').innerHTML = "";
			
		}
		else if(schoolType == "School"){
			document.getElementById('schoolDiv').style.display = "inline";
			document.getElementById('anganwadiDiv').style.display = "none";
			document.getElementById('testDivss').innerHTML = "";
		}
		else
		{
			document.getElementById('schoolDiv').style.display = "none";
			document.getElementById('anganwadiDiv').style.display = "none";
		}
		
}

</script>

<script type="text/javascript">
function addRow(){
       var tbl = document.getElementById('voucherDetails');
       var lastRow = tbl.rows.length;

       var row = tbl.insertRow(lastRow);
       var hdb = document.getElementById('hiddenValueCharge');
       var iteration = parseInt(hdb.value)+1;
       hdb.value = iteration;


       var cell0 = row.insertCell(0);
       var e0 = document.createElement('input');
       e0.type = 'radio';
       e0.name='selectedChrage';
       e0.className='radioCheck';
       e0.value=(iteration);
       cell0.appendChild(e0);

      

      	var cell3 = row.insertCell(1);
    	var e3 = document.createElement('Select');
    	e3.name='class'+(iteration);
    	e3.id='class'+(iteration);
    	e3.options[0] = new Option('Select','');
    	e3.tabIndex='1';
    	for(var jj = 1;jj<=12;jj++){
    		e3.options[jj] = new Option(jj,jj);
    	}
    	cell3.appendChild(e3);
    	
   		var cell44 = row.insertCell(2);
		var e44 = document.createElement('input');
		e44.name='section'+(iteration);
		e44.id='section'+(iteration);
		e44.className='auto';
		e44.size='10';
		e44.onblur = function(){
	  		populateClassSection(iteration);
		};	
		cell44.appendChild(e44);

     var cell5 = row.insertCell(3);
 	var e5 = document.createElement('input');
 	e5.type = 'button';
 	e5.name='add';
 	e5.className = 'buttonAdd';
 	e5.tabIndex='1';
 	e5.onclick = function(){
 					addRow();
 	}

 	cell5.appendChild(e5);


}


function removeRow()
{
       var tbl = document.getElementById('voucherDetails');
        var tblRows  = tbl.getElementsByTagName("tr");

         if(tblRows.length-2==0){
                alert("Can not delete all rows")
                return false;
    }

       for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
       {
               if (document.getElementsByName('selectedChrage')[counter].checked == true)
               {
                         tbl.deleteRow(counter+1);
                         //document.getElementById('hiddenValueCharge').value=(counter);
               }
               
             
       }
       
 
}



</script>
<script type="text/javascript">
function addRowA(){
       var tbl = document.getElementById('voucherDetails');
       var lastRow = tbl.rows.length;

       var row = tbl.insertRow(lastRow);
       var hdb = document.getElementById('hiddenValueCharge');
       var iteration = parseInt(hdb.value)+1;
       hdb.value = iteration;


       var cell0 = row.insertCell(0);
       var e0 = document.createElement('input');
       e0.type = 'radio';
       e0.name='selectedChrage';
       e0.className='radioCheck';
       e0.value=(iteration);
       cell0.appendChild(e0);

      

      	var cell3 = row.insertCell(1);
    	var e3 = document.createElement('select');
    	e3.name='class'+(iteration);
    	e3.id='class'+(iteration);
  
    	e3.options[0] = new Option('Select','');
    	  	e3.options[1] = new Option('LKG','LKG');
    		e3.options[2] = new Option('UKG','UKG');
    		e3.options[3] = new Option('Other','Other');
    	
    	
    	cell3.appendChild(e3);
    	
   		var cell44 = row.insertCell(2);
		var e44 = document.createElement('input');
		e44.name='section'+(iteration);
		e44.id='section'+(iteration);
		cell44.appendChild(e44);
	  	e44.onblur = function(){
	  		populateClassDivison(iteration);
		};
		e44.className='auto';
		e44.size='10';
	   
	

     var cell5 = row.insertCell(3);
 	var e5 = document.createElement('input');
 	e5.type = 'button';
 	e5.name='add';
 	e5.className = 'buttonAdd';
 	e5.tabIndex='1';
 	e5.onclick = function(){
 		addRowA();
 	}

 	cell5.appendChild(e5);


}

function populateClassDivison(inc)
{
	var cla=document.getElementById('class'+inc).value;
	var sec=document.getElementById('section'+inc).value;
	for(i=1;i<inc;i++)
	{
		
		var clas=document.getElementById('class'+i).value;
		var secs=document.getElementById('section'+i).value;
		if(inc != 1)
		{
			if(clas == cla && secs.toLowerCase() == sec.toLowerCase())
			{
				alert("Class & Divison already selected...!")
				document.getElementById('section'+inc).value="";
				return false;
			}
		}
  	}
  	
}
function populateClassSection(inc)
{
	var cla=document.getElementById('class'+inc).value;
	var sec=document.getElementById('section'+inc).value;
	for(i=1;i<inc;i++)
	{
		var clas=document.getElementById('class'+i).value;
		var secs=document.getElementById('section'+i).value;
		if(inc != 1)
		{
			if(clas == cla && secs.toLowerCase()  == sec.toLowerCase())
			{
				alert("Class & Section already selected...!")
				document.getElementById('section'+inc).value="";
				return false;
			}
		}
  	}
  	
}


sectionArray = new Array();
function populatePincode(val,formName){
	obj = eval('document.'+formName+'.pincode');
	obj.length = 1;
	for(i=0;i<pincodeArray.length;i++){
		if(pincodeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=pincodeArray[i][1];
			obj.options[obj.length-1].text=pincodeArray[i][2];
		}
	}
}
</script>
