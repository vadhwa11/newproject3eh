<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%-- <%@page	import="jkt.hms.masters.business.OpdAudiologicalExamEntSpeciality"%> --%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
 <% 
 /* OpdAudiologicalExamEntSpeciality opdAudiologicalExamEntSpeciality = new OpdAudiologicalExamEntSpeciality();

List<OpdAudiologicalExamEntSpeciality> opdAudiologicalExamEntSpecialities = null;   */

List<Visit> patientList = new ArrayList<Visit>();
 Map map = new HashMap();
	 	if (request.getAttribute("map") != null) {
	map = (Map)request.getAttribute("map");

	}  

 /* if (map.size()>0) {
		
		 if (map.get("opdAudiologicalExamEntSpeciality") != null)
	       {
			 opdAudiologicalExamEntSpeciality = (OpdAudiologicalExamEntSpeciality) map.get("opdAudiologicalExamEntSpeciality");			
	       }
		} */

/*  String hinNo="", age="";
if (map.get("patientName") != null) {
		pName = (String) map.get("patientName");
	}
	*/
	
 if(map.get("patientList") != null)	{
		patientList=(List)map.get("patientList");
	}  
 
String patientName="", hinNo="", age="";;
Visit visit=null;
if(patientList.size()>0){
 visit=patientList.get(0);
patientName=visit.getHin().getPFirstName();
age=visit.getHin().getAge();
}
	 
%>
</script>

<form method="post" action="" name="audiologicalExaminationTemplateJsp">
<div class="Block">
<input id="audiologFlag" name="audiologFlag" tabindex="1" value="AudiologicalExam" type="hidden"  />
<input type="hidden" name="templateName" value="Audiological Exam"/>
<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<h2>AUDIOLOGICAL EXAMINATION</h2>
<div class="clear"></div>
<div class="paddingTop5"></div>

<input type="hidden" tabindex="1" id="patientHinId" name="phinId" value="" validate="phinId,int,no" />
<label>Case Name</label>
<input type="text" name="patientName" readonly="readonly"  id="patientName" validate="" value="<%=patientName%>" tabindex="1"/>     
<label>Age</label>
<input type="text" name="age" readonly="readonly"  id="age" validate="" value="<%=age%>" tabindex="1"/>

<label>Case No</label>
<input type="text" name="caseNo" id="caseNo" value="" validate="caseNo,string,no"  value=""  maxlength="15" maxlength="20" tabindex="1" /> 

<div class="clear"></div>
<label>Test	No</label> 
<input type="text" name="testNo" id="testNo" value=""  maxlength="20" tabindex="1" />

<label>Tested by</label>
<input type="text" name="testedBy" id="testedBy" validate="" maxlength="20" tabindex="1" /> 

<label>Audiometer</label><input type="text" name="audiometer" id="audiometer" maxlength="100" tabindex="1" />
<div class="clear"></div>

	<table>
		<tr>
			<!-- <th colspan="5">Audiogram</th> -->
			<th colspan="5">Pure Tone Audiogram (Right and Left are the sub headings)</th>
		</tr>
		<!-- @start code added by rajdeo 21-12-2017 -->
		<tr>
			<td></td>
			<td>Right</td>
			<td>
		
			<select name="right_audiogram" id="right_audiogram" onchange="getSelectedAudiogramRight(this.value,'right_dropdown')">
			    <option value="select" >Select</option>
				<option value="Normal" >Normal</option>
				<option value="Conductive HL">Conductive HL</option>
				<option value="Sensori Neural HL">Sensori Neural HL</option>
				<option value="Mixed HL">Mixed HL</option>
			</select>
			<select name="right_dropdown" id="right_dropdown" onchange="getSelectedAudiogramTextBox(this.value,'right_otherText')" style="display: none;">
				<option value="select">Select</option>
				<option value="Mild">Mild</option>
				<option value="Moderate">Moderate</option>
				<option value="Moderately Severe">Moderately Severe</option>
				<option value="Severe">Severe</option>
				<option value="Profound">Profound</option>
				<option value="Total">Total</option>
				<option value="Others">Others</option>						
			</select>	
			
	<input  type="text" id="right_otherText" name="right_otherText" value="" tabindex="1" maxlength="50" style="display:none" />
			</td>
			<td>Left</td>
			<td>
			<select name="left_audiogram" id="left_audiogram" onchange="getSelectedAudiogramLeft(this.value,'left_dropdown')">
			    <option value="select" >Select</option>
				<option value="Normal" >Normal</option>
				<option value="Conductive HL">Conductive HL</option>
				<option value="Sensori Neural HL">Sensori Neural HL</option>
				<option value="Mixed HL">Mixed HL</option>
			</select>
			
			<select name="left_dropdown" id="left_dropdown" onchange="getSelectedAudiogramTextBoxLeft(this.value,'left_otherText')" style="display: none;">
				<option value="select">Select</option>
				<option value="Mild">Mild</option>
				<option value="Moderate">Moderate</option>
				<option value="Moderately Severe">Moderately Severe</option>
				<option value="Severe">Severe</option>
				<option value="Profound">Profound</option>
				<option value="Total">Total</option>
				<option value="Others">Others</option>						
			</select>	
			
	<input  type="text" id="left_otherText" name="left_otherText" value="" tabindex="1" maxlength="50" style="display:none" />
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<th colspan="5">PTA(dB)</th>
		</tr>
		<tr>
			<td></td>
			<td>Right</td>
			<td><input type="text" name="ptaDbRight" id="ptaDbRight" value="" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" /></td>
			<td>Left</td>
			<td><input type="text" name="ptaDbLeft" id="ptaDbLeft" value="" onpaste="return false" onkeypress="javascript:return isNumber(event)"	maxlength="6" tabindex="1" /></td>
		</tr>
	</table>

	<table>
		<tr>
			<th colspan="3">Tympanogram</th>
		</tr>
		<tr>
			<td>Measure</td>
			<td>Right</td>
			<td>Left</td>
		</tr>

		<tr>
			<td>Ear Canal Volume(cc)</td>
			<td><input type="text" name="tympEarCvRight" id="tympEarCvRight" value="" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="128" tabindex="1" /></td>
			<td><input type="text" name="tympEarCvLeft" id="tympEarCvLeft"	value=""  onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>Static Compliance(ml)</td>
			<td><input type="text" name="tympStaticComRht" id="tympStaticComRht" value="" onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" /></td>
			<td><input type="text" name="tympStaticComLft"	id="tympStaticComLft" value=""  onpaste="return false" onkeypress="javascript:return isNumber(event)" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>Middle Ear Presure (daPa)</td>
			<td><input type="text" name="tympMidEarPreRht" id="tympMidEarPreRht" value="" onpaste="return false" onkeypress="javascript:return isNumberWithSign(event)" maxlength="6" tabindex="1" /></td>
			<td><input type="text" name="tympMidEarPreLft"	id="tympMidEarPreLft" value="" onpaste="return false" onkeypress="javascript:return isNumberWithSign(event)" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>Type</td>
			<td><select
			id="" name="tympTypeRht" validate="" tabindex="1"
			class="" onchange="" style="width:148px; margin-left:0px !important;">
			<option value="">Select</option>
			<option value="A">A</option>
			<option value="As">As</option>
			<option value="Ad">Ad</option>
			<option value="B">B</option>
			<option value="C">C</option>
			<option value="Cs">Cs</option>
		</select></td>
			<td><select
			id="" name="tympTypeLft" validate="" tabindex="1"
			class="" onchange="" style="width:148px; margin-left:0px !important;">
			<option value="">Select</option>
			<option value="A">A</option>
			<option value="As">As</option>
			<option value="Ad">Ad</option>
			<option value="B">B</option>
			<option value="C">C</option>
			<option value="Cs">Cs</option>
		</select></td>
		</tr>
		<tr>
			<td>Remarks</td>
			<td colspan="2">
			<textarea id="remarks"  maxlength="256" tabindex="1" value="" name="remarks" ></textarea>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>Audiogram Key</th>
			<th colspan="2"><center>Right</center></th>
			<th colspan="2"><center>Left</center></th>
		</tr>

		<tr>
			<td>AC unmasked</td>
			<td style="width: 88px;"></td>
			<td><input type="checkbox" name="acUnmasRht" id="acUnmasRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td style="width: 88px;"></td>
			<td><input type="checkbox" name="acUnmasLft" id="acUnmasLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>AC unmasked NR</td>
			<td></td>
			<td><input type="checkbox" name="acUnmasNrRht" id="acUnmasNrRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="acUnmasNrLft" id="acUnmasNrLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>BC unmasked</td>
			<td></td>
			<td><input type="checkbox" name="bcUnmasRht" id="bcUnmasRht"
				value="y"  tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="bcUnmasLft" id="bcUnmasLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>BC unmasked NR</td>
			<td></td>
			<td><input type="checkbox" name="bcUnmasNrRht" id="bcUnmasNrRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="bcUnmasNrLft" id="bcUnmasNrLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>AC masked</td>
			<td></td>
			<td><input type="checkbox" name="acMasRht" id="acMasRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="acMasLft" id="acMasLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>AC masked NR</td>
			<td></td>
			<td><input type="checkbox" name="acMasNrRht" id="acMasNrRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="acMasNrLft" id="acMasNrLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>
		
		<tr>
			<td>BC masked</td>
			<td></td>
			<td><input type="checkbox" name="bcMasRht" id="bcMasRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="bcMasLft" id="bcMasLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>

		<tr>
			<td>BC masked NR</td>
			<td></td>
			<td><input type="checkbox" name="bcMasNrRht" id="bcMasNrRht"
				value="y" maxlength="6" tabindex="1" /></td>
			<td></td>
			<td><input type="checkbox" name="bcMasNrLft" id="bcMasNrLft"
				value="y" maxlength="6" tabindex="1" /></td>
		</tr>
		
	</table>
	
<div class="clear"></div>		
<h2>Stapedial Reflex Test</h2>

<div class="clear"></div>
<table>
<tr>
<th> Stimulus</th>
<th colspan="2"><center>Right</center></th>
<th colspan="2"><center>Left</center></th>
 </tr> 
 <tr>
<td>AC unmasked</td>
<td>Ipsi(dB)</td>
<td>Contra(dB)</td>
<td>Ipsi(dB)</td>
<td>Contra(dB)</td>
 </tr> 
<tr>
<td>500Hz</td>
<td><select
			id="" name="srt500hzRhtIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt500hzRhtContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt500hzLftIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt500hzLftContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
 </tr>
 
 <tr>
<td>1KHz</td>
<td> <select
			id="" name="srt1khzRhtIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select> </td>
<td><select
			id="" name="srt1khzRhtContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt1khzLftIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt1khzLftContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
 </tr>

<tr>
<td>2KHz</td>
<td><select
			id="" name="srt2khzRhtIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt2khzRhtContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt2khzLftIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt2khzLftContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
 </tr>
 
 <tr>
<td>4KHz</td>
<td><select
			id="" name="srt4khzRhtIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>

<td><select
			id="" name="srt4khzRhtContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
<td><select
			id="" name="srt4khzLftIpsi" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
			
			<td><select
			id="" name="srt4khzLftContra" validate="" tabindex="1">
			<option value="">Select</option>
			<option value="60">60</option>
			<option value="65">65</option>
			<option value="70">70</option>
			<option value="75">75</option>
			<option value="80">80</option>
			<option value="85">85</option>
			<option value="90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select></td>
 </tr>
 <tr>
<td>Other Tests</td>
<td colspan="4">
<textarea id="srtOtherTests"  maxlength="256" tabindex="1" value="" name="srtOtherTests" style="width:336px; margin-left:0px !important;" ></textarea>
</td>
 </tr> 
</table>

</div>
</form>

<div class="clear"></div>

<script type="text/javascript">

function setAgeForPatient()
{
       alert("setAgeForPatient");
}

	function checkFillField() {

		var uhidNo = document.getElementById('UHIDId').value;

		if (uhidNo == '') {
			alert(" UHID field can not blank  ");
			return false;
		} else {

			return true;
		}

	}
	

	//----Function for age through ajax----------
	function calculateAgeInAjax() {
		dob = document.getElementById('qDobId').value;

		if (dob != "") {
			if (checkDob()) {
				action = "/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="
						+ dob;
				obj = eval('document.updateRegistration')
				obj.action = action;
				var url = action
			}
			var xmlHttp;
			try {
				// Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				// Internet Explorer
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					alert(e)
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("Your browser does not support AJAX!");
						return false;
					}
				}
			}
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {
					var items = xmlHttp.responseXML
							.getElementsByTagName('items')[0];
					for (loop = 0; loop < items.childNodes.length; loop++) {

						var item = items.childNodes[loop];
						var age = item.getElementsByTagName("age")[0];

						var period = item.getElementsByTagName("period")[0];
						var year = item.getElementsByTagName("birthYear")[0];
						document.getElementById("qAgeUnitId").value = year.childNodes[0].nodeValue;
						obj = eval(document.getElementById('qAgeId'));

						if (age.childNodes[0].nodeValue == "0") {
							document.getElementById("qAgeId").value = age.childNodes[0].nodeValue;
						} else {

							document.getElementById("qAgeId").value = age.childNodes[0].nodeValue;

						}
						document.getElementById('qAgeUnitId').style.display = 'inline';
						temp = document.getElementById('qAgeUnitId');
						temp.value = period.childNodes[0].nodeValue
						/* document.getElementById('religionId').focus(); */
					}
				}
			}
			var url = action;
			url = url + '&' + csrfTokenName + '=' + csrfTokenValue; // added by amit das on 07-07-2016

			xmlHttp.open("GET", url, true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);

		}
	}
	
	
	
</script>
<div class="paddingTop40"></div>




