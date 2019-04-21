<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
 <script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
 <script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
 <script type="text/javascript">
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}
	</script>
<script type="text/javascript" language="javascript">
	<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: true, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		}
	})
</script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
 <%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map map = new HashMap();
 		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
 		}
 		List patientDataList = new ArrayList();
		if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
		}

		List<MasStoreBrand> storeBrandList = new ArrayList<MasStoreBrand>();
		if(map.get("storeBrandList")!=null)
		{
		 storeBrandList = (List)map.get("storeBrandList");
		}
		List<InpatientPrescriptionDetails> inPatientPrescriptionDetailList = new ArrayList<InpatientPrescriptionDetails>();
		if(map.get("inPatientPrescriptionDetailList")!=null)
		{
			inPatientPrescriptionDetailList = (List)map.get("inPatientPrescriptionDetailList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		Map<String,Object> mapForDS= new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");

		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		int deptId=0;
		if(map.get("deptId") != null){
			deptId = (Integer)map.get("deptId");
			}
		List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
		if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
		}
 		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		}

		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
  		if (map.get("inPatientDetailList") != null){
			inPatientDetailList = (List) map.get("inPatientDetailList");
  		}
  		
			Inpatient inpatient = null;
  		Patient patient = null;
  		String initDiagnosis = "";
	 	String date = "";
  		String time = "";
  	 	int inpatientId = 0;
  		String admissionNumber = "";
  		String ptName = "";
  		String doa = "";
  		String dod = "";
  		String age = "";
  		String sex = "";
  		int departmentId = 0;
  		int hinId = 0;
  		String hinNo = "";
  	 	String category_name = "";
		String fPtName = "";
		String mPtName = "";
		String lPtName = "";
	if(inPatientDetailList.size()>0){
  	 	inpatient = (Inpatient) inPatientDetailList.get(0);
			patient = (Patient) inpatient.getHin();

	 		hinNo = patient.getHinNo();
	 			initDiagnosis = inpatient.getInitDiagnosis();
	 			if (inpatient.getHin().getPFirstName() != null) {
					fPtName = inpatient.getHin().getPFirstName();
				}
				if (inpatient.getHin().getPMiddleName() != null) {
					mPtName = inpatient.getHin().getPMiddleName();
				} else {
					mPtName = "";
				}
				if (inpatient.getHin().getPLastName() != null) {
					lPtName = inpatient.getHin().getPLastName();
				}
				ptName = fPtName + " " + mPtName + " " + lPtName;
  				admissionNumber = inpatient.getAdNo();

	 			age = inpatient.getAge();
	  			sex = inpatient.getHin().getSex()
						.getAdministrativeSexName();
 	 			hinId = inpatient.getHin().getId().intValue();
	 			hinNo = inpatient.getHin().getHinNo();
	 			departmentId = inpatient.getDepartment().getId().intValue();
	 			inpatientId = inpatient.getId().intValue();
			if(inpatient.getDateOfAddmission()!=null)
			{
				doa =HMSUtil.convertDateToStringTypeDateOnly(inpatient.getDateOfAddmission());
			}
			if(inpatient.getTimeOfAddmission()!=null)
			{
				time = inpatient.getTimeOfAddmission().toString();
			}

	%>
<h4><span></span></h4>
<div class="titleBg">
<h2>Inpatient Prescription</h2>
</div>
<form name="prescriptionForm" action="" method="post">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block"><label>Patient Name</label> <label
	class="value"><%=ptName.length() > 2 ? ptName : "-"%></label> <label><%=prop.getProperty("com.jkt.hms.registration_no") %>
	</label><label class="value"><%=hinNo%></label> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <label
	class="value"><%=inpatient.getAdNo()%></label>
<div class="clear"></div>
<label>Age</label> <label class="value"><%=age.length() > 0 ? age : "-"%></label>
<label>Sex</label> <label class="value"><%=sex.length() > 0 ? sex : "-"%></label>
<label>Date of Admission </label> <label class="value"><%=doa.length() > 0 ? doa : "-"%></label>
<label>Admission Time</label> <label class="value"><%=time.length() > 0 ? time : "-"%></label>
<label>Init Diagnosis</label> <%
 	if (initDiagnosis != null)
 %> <label class="valueAuto"><%=initDiagnosis%></label>
<div class="clear"></div>
</div>
<div class="clear"></div>

<script type="text/javascript">
		   var icdArray=new Array();
 		   var brandArray=new Array();
 </script> <%
				if(map.get("message") != null){
				   String message = (String)map.get("message");
				   out.println(message);
				  }
 		    %>
<input type="button" class="buttonDel" tabindex="3" value=""	onclick="removeRow();" align="right" />
<input type="button" class="buttonAdd" tabindex="4" onclick=" addRow();" value="" align="right" />
<input name="Prevoius2" type="button" tabindex="2" value="Prev Prescription"	onclick="openPopupForPatientPrescription('<%=inpatient.getId()%>','<%=inpatient.getHin().getId()%>','<%=inpatient.getAdNo()%>')"	class="buttonBig" align="right"/>
<input	name="treatmentTemplate" type="button"	value="TREATMENT ASSISTS" tabindex="1" onclick="showTreatment()" class="buttonBig" />

<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="grid">
	<tr>
		<th scope="col">Item Name</th>
		<!--  <th scope="col">Brand Name</th>
		<th scope="col">Manufacturer</th>-->
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
	</tr>
	<%
		int incr = 1;
	%>
	<tr>
		<td id="nomenclatureDiv<%=incr%>">
		<input type="text" value="" tabindex="5"
			id="nomenclature<%=incr%>" size="50" name="nomenclature<%=incr%>"
			onblur="populatebrand(this.value,'<%=incr%>');" />

		<div id="ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','ipd?method=getItemListForAutoCompleteItemIpd',{parameters:'requiredField=nomenclature1&counter=<%=incr%>'});
				</script>
				<%
				MasStoreBrand  storeBrand = new MasStoreBrand();
 		             for (int i = 0; i <storeBrandList.size(); i++) {
				       	 storeBrand = (MasStoreBrand) storeBrandList.get(i);
 		             }
	     			 %> 
		<input type="hidden" id="brandId<%=incr%>" name="brandId<%=incr%>" value="<%=storeBrand.getId()%>"></input>				
				</td>
		<!--  <td id="testDiv<incr%>">
		<select name="brandId<incr%>" id="brandId<incr%>" tabindex="6"  onchange="populateManufacturer(this.value,'<incr%>');" >
		<option value="0">Select</option>-->
		<%
			     // for(MasStoreBrand masbrand : storeBrandList){
			     //  int id = masbrand.getId();
			    //   String brandName = masbrand.getBrandName();
	    %>
	    <!--  <option value="<id%>"><brandName%></option>-->
			<%//} %>
		  <!--</select>-->
		<%
				//MasStoreBrand  storeBrand = new MasStoreBrand();
 		           //  for (int i = 0; i <storeBrandList.size(); i++) {
				   //     	 storeBrand = (MasStoreBrand) storeBrandList.get(i);
	     			 %>   <!--<script>

	     			brandArray[<i%>]= new Array();
	     			brandArray[<i%>][0] = "<storeBrand.getId()%>";
	     			brandArray[<i%>][1] = "<storeBrand.getBrandName()%>";
	            </script>--> <% //}%>

		<!--</td>
		<td id="manufacturereDiv<incr%>">
		<input type="text" id="manufacturer<incr%>"
			name="manufacturer<incr%>"  size="10" maxlength="6" readonly="readonly"
			 />
		  </td>-->
		<td><input type="text" name="dosage<%=incr%>" tabindex="7" id="dosage<%=incr%>" size="10  maxlength="45" onblur="fillValue(this.value,<%=incr%>);" /></td>
		<td><select name="frequency<%=incr%>" id="frequency<%=incr%>" tabindex="8" onblur="fillValue(this.value,<%=incr%>);" >
			<option value="0">Select</option>
			<%
			      for(MasFrequency masFrequency : frequencyList){
			       int id = masFrequency.getId();
			       String name = masFrequency.getFrequencyName();
	          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
		    		MasFrequency  masFrequency = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency = (MasFrequency) frequencyList.get(i);
	     			 %> <script>

		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
	            </script> <% }%>
		</td>
		<td><input type="text" name="noOfDays<%=incr%>"
			id="noOfDays<%=incr%>"
			onblur="fillValue(this.value,<%=incr%>);"
			size="3" maxlength="3" validate="No Of Days,num,no" tabindex="9"/></td>
		<td><input type="text" name="total1" id="total1"
			readonly="readonly" size="5" validate="Total,num,no" />

			<input type="hidden" name="pvmsNo<%=incr%>" id="pvmsNo<%=incr%>" size="10" value=""/>
		<input type="hidden" name="<%=ITEM_ID %><%=incr%>"
			id="itemId<%=incr%>" value="" /></td>
	</tr>

</table>
<input type="hidden" name="hdb" value="1" id="hdb" />
<div class="clear"></div>
<div class="bottom">

<input id="inpatientId" name="inpatientId" type="hidden" value="<%=inpatient.getId()%>" />
<input name="hinId" type="hidden" value="<%=inpatient.getHin().getId()%>" />
<input name="hinNo" type="hidden" value="<%=inpatient.getHin().getHinNo()%>" />
<input	name="deptId" type="hidden" value="<%=deptId%>" />
<input type="hidden" name="lastChgBy"
	value="<%=userName%>" /> <input type="hidden" name="lastChgDate"
	value="<%=currentDate%>" /> <input type="hidden" name="lastChgTime"
	value="<%=currentTime%>" /> <label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=currentTime%></label>
<div class="clear"></div>
</div>
<input type="button" name="sss" align="right" class="button" value="Submit"
 onclick="if(validateFieldValues()){submitForm('prescriptionForm','ipd?method=submitPrescriptionDetails');}" />
<%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<script type="text/javascript">

function validateFieldValues(){

	    var tbl = document.getElementById('grid');
		  var lastRow = parseInt(tbl.rows.length);
		  for(var i=1;i<lastRow;i++){
		  var nomenclature="";
		  if(document.getElementById("nomenclature"+i)!=null){
			  nomenclature= document.getElementById("nomenclature"+i).value ;
		  }
		  if(nomenclature!=""){

				if(document.getElementById("brandId"+i).value=="0"){
					 alert("Please Select The Brand Name "+i)
					 return false;
				  }
				  if(document.getElementById("dosage"+i).value==""){
				  alert("Please fill dosage in row "+i)
				  return false;
				  }
				  if(document.getElementById("frequency"+i).value=="0"){
				  alert("Please select frequency in row "+i)
				  return false;
				  }
				  if(document.getElementById("noOfDays"+i).value==""){
				  alert("Please fill noOfDays in row "+i)
				  return false;
				  }
		     }
		  }
		  return true;
	}
</script>

<script type="text/javascript">
function addRow(){

  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
  var iteration = lastRow;
  var row = tbl.insertRow(lastRow);
  var hdb = document.getElementById('hdb');
  iteration = parseInt(hdb.value)+1;
  hdb.value=iteration;


  var cellRight0 = row.insertCell(0);
  cellRight0.id='nomenclatureDiv'+iteration;
  var e0 = document.createElement('input');
  e0.type = 'text';
  e0.onblur=function(){

  						populatebrand(this.value, iteration);
  						checkItem(iteration);
                      };
  e0.name = 'nomenclature' + iteration;
  e0.id = 'nomenclature' + iteration;
  e0.size = '50';
  var newdiv = document.createElement('div');
  newdiv.setAttribute('id', 'ac2updates'+iteration);
  newdiv.style.display = 'none';
  newdiv.className = "autocomplete";
  cellRight0.appendChild(newdiv);
  cellRight0.appendChild(e0);

  new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'ipd?method=getItemListForAutoCompleteItemIpd',{parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
  var cellRight1 = row.insertCell(1);
  //cellRight1.id="testDiv"+iteration;
  //var e1 = document.createElement('Select');
  var e1 = document.createElement('input');
  e1.type = 'hidden';
  e1.name='brandId'+iteration;
  e1.id='brandId'+iteration;
  cellRight1.appendChild(e1);
		  
  //var cellRight2 = row.insertCell(2);
  //cellRight2.id='manufacturereDiv'+iteration;
  var e2 = document.createElement('input');
  e2.type = 'hidden';
  e2.size='10';
  e2.name='manufactureId'+iteration;
  e2.id='manufactureId'+iteration
  cellRight1.appendChild(e2);

  
  
 // var cellRight3 = row.insertCell(3);
  var e3 = document.createElement('input');
  e3.name='dosage'+iteration;
  e3.id='dosage'+iteration;
  e3.classname='smalllabel'
  e3.size='10'
	e3.onblur=function()
  {
	  fillValue(this.value,iteration);
    };
  cellRight1.appendChild(e3);


  var cellRight2 = row.insertCell(2);
  var e4 = document.createElement('Select');
  e4.name='frequency'+iteration;
  e4.id='frequency'+iteration;
  e4.classname='smalllabel'
  e4.options[0] = new Option('Select', '0');
   for(var i = 0;i<icdArray.length;i++ ){
      e4.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
      }
   e4.onblur=function()
      {
		  fillValue(this.value,iteration);
      };
  cellRight2.appendChild(e4);


  var cellRight3 = row.insertCell(3);
  var e5 = document.createElement('input');
  e5.type = 'text';
  e5.name='noOfDays'+iteration;
  e5.id='noOfDays'+iteration;
  e5.size='3'
  e5.onblur=function()
  {
	  fillValue(this.value,iteration);
  };
 cellRight3.appendChild(e5);


 var cellRight4 = row.insertCell(4);
 var e6 = document.createElement('input');
 e6.type = 'text';
 e6.name='total'+iteration;
 e6.id='total'+iteration;
 e6.size='5'
 cellRight4.appendChild(e6);

 var cellRight5 = row.insertCell(5);
 var e7 = document.createElement('input');
 e7.type = 'hidden';
 e7.name='pvmsNo'+iteration;
 e7.id='pvmsNo'+iteration
 cellRight5.appendChild(e7);
}

function removeRow()
{
  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('hdb');
  if (lastRow > 2){
   tbl.deleteRow(lastRow - 1);
   hdb.value=hdb.value-1
   }else{
alert("Can Not Delete All Rows !!")
	   }
}
function  fillValue(value,inc){
	     var freq=document.getElementById('frequency'+inc).value
	     var noOfDays=document.getElementById('noOfDays'+inc).value
		var nomenclature = document.getElementById("nomenclature"+inc).value
		var groupName   = nomenclature.split('.')
		var dosage=document.getElementById('dosage'+inc).value
		if(freq=='15'){
			 document.getElementById('total'+inc).value=1;
			}else
		 if(freq=='14'){
		    // alert("in if");
	    	 document.getElementById('total'+inc).value=noOfDays;
		     }
		     else if(groupName[0].toUpperCase()=='DROP' || groupName[0].toUpperCase()=='SYP' ||groupName[0].toUpperCase()=='OINT')
		{
			  document.getElementById('total'+inc).value='1';
		 }else{
			  document.getElementById('total'+inc).value=freq*dosage*noOfDays
		  }

}
function populateManufacturer(val,count){

    var counter1=document.getElementById('hdb').value
	if(val !="0"){
 		for(i=1;i<=counter1;i++)
		{
				if(count != i){
				if(document.getElementById('brandId'+i).value == val)
				{
					alert("Brand Name already selected...!");
					document.getElementById('brandId'+count).value="";
					document.getElementById('nomenclature'+count).value="";
					document.getElementById('manufacturer'+count).value="";
					var e=eval(document.getElementById('brandId'+count));
					e.focus();
					return false;
				}
				}

	  	}
		submitProtoAjaxForManufacturerClass('prescriptionForm','/hms/hms/opd?method=getItemBrandManufacturerName&brandId='+val+'&counter='+count,count);
		submitProtoAjaxForNomenClature('prescriptionForm','/hms/hms/opd?method=getNomenclature&brandId='+val+'&counter='+count,count);
}
}



function calculateTotalDispensingPrice(){
	var cnt = document.getElementById('hdb').value;
	var totalDispPrice = 0;
	for(var i=1;i<=cnt;i++){
		if(document.getElementById("dispensingPrice"+i) != null){
		if(document.getElementById("dispensingPrice"+i).value !="")
			totalDispPrice = parseFloat(totalDispPrice) + (parseFloat(document.getElementById("dispensingPrice"+i).value)*parseFloat(parseFloat(document.getElementById("total"+i).value)) );
		}
	}
	document.getElementById("totalDispPrice").value = totalDispPrice;
}


function calculateTotalRate(){
	var cntRate = document.getElementById('hiddenValue').value;
	var totalRate = 0;
	for(var i=1;i<=cntRate;i++){
		if(document.getElementById("rate"+i) != null){
		if(document.getElementById("rate"+i).value !="")
			totalRate = parseFloat(totalRate) + (parseFloat(document.getElementById("rate"+i).value));
		}
	}
	document.getElementById("totalRate").value = totalRate;
}

function populatebrand(val,incr){
		var pvmsNo;
		if(val !=""){
			var index1 = val.lastIndexOf("[");
			var index2 = val.lastIndexOf("]");
			index1++;
			pvmsNo = val.substring(index1,index2);

		document.getElementById('pvmsNo'+incr).value=pvmsNo;
		//alert("pvmsNo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+pvmsNo);
		//alert("jjjj");
		<%if(inPatientPrescriptionDetailList.size()>0 ){
			
			for(InpatientPrescriptionDetails inpDePrescriptionDetails:inPatientPrescriptionDetailList){
			%>
			//alert("jjjj");
			var nameintable=<%=inpDePrescriptionDetails.getItem().getPvmsNo()%>;
			
			//alert("nameintable"+nameintable);
			if(nameintable==pvmsNo){
				alert("Same Medicine has been Prescribed already!!");
				document.getElementById('nomenclature'+incr).value="";
				document.getElementById('pvmsNo'+incr).value="";
				var e=eval(document.getElementById('nomenclature'+incr));
				e.focus();
				}
			<%}}%>
		if(pvmsNo != ""){
		for(i=1;i<incr;i++)
		{

			if(incr != 1)
			{
				if(val!=""){
				if(document.getElementById('nomenclature'+i).value == val)
				{
					alert("Item Name already selected...!");
					document.getElementById('nomenclature'+incr).value="";
					document.getElementById('pvmsNo'+incr).value="";
					var e=eval(document.getElementById('nomenclature'+incr));
					e.focus();
				}
				}else{
					return false;
				}
				
			}
	  	}

		submitProtoAjaxForLionClass('prescriptionForm','/hms/hms/opd?method=getItemBrandName&pvmsNo='+pvmsNo+"&counter="+incr,incr);
	}
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

function submitProtoAjaxForManufacturerClass(formName,action,counter1){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;

    	   	 var url=action+"&"+getNameAndData(formName)
			new Ajax.Updater('manufacturereDiv'+counter1,url,
			   {asynchronous:true, evalScripts:true });
    	   	return true;
    	}

function submitProtoAjaxForNomenClature(formName,action,counter1){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;

    	   	 var url=action+"&"+getNameAndData(formName)
			new Ajax.Updater('nomenclatureDiv'+counter1,url,
			   {asynchronous:true, evalScripts:true });
    	   	return true;
    	}

function openPopupForPatientPrescription(inpatientId,hinId,ipdNo){
	if(ipdNo >1){
	var nomenclature1="";
	if(document.getElementById("nomenclature1")!=null){
	nomenclature1=document.getElementById("nomenclature1").value;
		}
	var url="/hms/hms/ipd?method=showInPatientPreviousPrescription&nomenclature1="+nomenclature1+"&inpatientId="+inpatientId+"&hinId="+hinId+"&ipdNo="+ipdNo;
   newwindow=window.open(url,'name',"height=500,width=1000,status=1,scrollable='yes'");
   }else{
     alert("This Is Patient's first Visit.")
   }
}
function showTreatment()
{
		   	var url="/hms/hms/opd?method=showTreatmentPopUp";
		    newwindow=window.open(url,'treatment',"left=2,top=100,height=700,width=1010,status=1,scrollbars=yes,resizable=0");
		  
}


function addRowNewWin(){

	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;


	  var cellRight0 = row.insertCell(0);
	  cellRight0.id='nomenclatureDiv'+iteration;
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.onblur=function(){

	  						//populatebrand(this.value, iteration);
	  						//checkItem(iteration);
	                     // };
	  e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.size = '50';
	  e0.value='12';
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight0.appendChild(newdiv);
	  cellRight0.appendChild(e0);

	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'ipd?method=getItemListForAutoCompleteItemIpd',{parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight1 = row.insertCell(1);
	  //cellRight1.id="testDiv"+iteration;
	  //var e1 = document.createElement('Select');
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='brandId'+iteration;
	  e1.id='brandId'+iteration;
	  e1.value='12';
	  cellRight1.appendChild(e1);
			  
	  //var cellRight2 = row.insertCell(2);
	  //cellRight2.id='manufacturereDiv'+iteration;
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.size='10';
	  e2.name='manufactureId'+iteration;
	  e2.id='manufactureId'+iteration
	  e2.value='12';
	  cellRight1.appendChild(e2);

	  
	  
	 // var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.name='dosage'+iteration;
	  e3.id='dosage'+iteration;
	  e3.classname='smalllabel'
	  e3.size='10'
		e3.value='12';
		e3.onblur=function()
	  {
		  fillValue(this.value,iteration);
	    };
	  cellRight1.appendChild(e3);


	  var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('Select');
	  e4.name='frequency'+iteration;
	  e4.id='frequency'+iteration;
	  e4.classname='smalllabel'
	  e4.options[0] = new Option('Select', '0');
	   for(var i = 0;i<icdArray.length;i++ ){
	      e4.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	   e4.onblur=function()
	      {
			  fillValue(this.value,iteration);
	      };
	  cellRight2.appendChild(e4);


	  var cellRight3 = row.insertCell(3);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='noOfDays'+iteration;
	  e5.id='noOfDays'+iteration;
	  e5.size='3'
		  e5.value='12';
	  e5.onblur=function()
	  {
		  fillValue(this.value,iteration);
	  };
	 cellRight3.appendChild(e5);


	 var cellRight4 = row.insertCell(4);
	 var e6 = document.createElement('input');
	 e6.type = 'text';
	 e6.name='total'+iteration;
	 e6.id='total'+iteration;
	 e6.size='5'
		 e6.value='12';
	 cellRight4.appendChild(e6);

	 var cellRight5 = row.insertCell(5);
	 var e7 = document.createElement('input');
	 e7.type = 'hidden';
	 e7.name='pvmsNo'+iteration;
	 e7.id='pvmsNo'+iteration
	e7.value='12';
	 cellRight5.appendChild(e7);
	 
	}
</script>
<%
frequencyList=null;
inPatientDetailList=null;
inPatientPrescriptionDetailList=null;
patientDataList=null;
storeBrandList=null;


%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>