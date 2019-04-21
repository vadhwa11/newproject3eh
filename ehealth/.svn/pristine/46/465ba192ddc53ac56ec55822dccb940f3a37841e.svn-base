
<%@page import="jkt.hms.masters.business.OpdAntenatalCardTrimester"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%@page import="java.util.Iterator"%>


<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

int counter = 0;
int trimesterNo=0;
String val =null;
String  fieldId = null;
String  fieldText = null;
Map<Integer, OpdAntenatalCardTrimester> trimesterMap = null;
if(map.get("fieldId")!=null){
	fieldId = (String)map.get("fieldId");
}
if(map.get("trimesterNo")!=null){
	val = (String)map.get("val");
}
if(map.get("fieldText")!=null){
	fieldText = (String)map.get("fieldText");
}
System.out.println("fsdg"+map.get("counter"));
if(map.get("counter")!=null && !map.get("counter").toString().isEmpty()){
	counter = Integer.parseInt(map.get("counter").toString());
}
 if(map.get("trimesterNo")!=null){
	trimesterNo =  Integer.parseInt(map.get("trimesterNo").toString());
} 

%>
<script type="text/javascript">
function saveTextValue(fieldId)
{
	window.opener.document.getElementById(fieldId).value=document.getElementById("textVal").value;
	displayTrimesterExaminationSummery(<%=counter%>,<%=trimesterNo%>);
}
function displayTrimesterExaminationSummery(hbdTri,trimesterNo)
{
	 var divId="";
	  var trimType;
	  var displayString="";
	  var ftGeneralExaminationTrim="";
	  var ftSystemicExam="";
	  var ftPA = "";
	  var ftPV ="";
	  if(trimesterNo==1){
		  trimType="ft";
		  divId ="Trimester1Summery";
	  }
	  else if(trimesterNo==2){
		  trimType="st";
		  divId ="Trimester2Summery";
	  }
	  else if(trimesterNo==3){
		  trimType="tt";
		  divId ="Trimester3Summery";
	  }
	  var j=0;
	  
	  for(var i=0;i<=hbdTri;i++){
		  if(window.opener.document.getElementById(trimType+"GeneralExaminationTrim"+i)!=null)
			  {
			  
			 ftGeneralExaminationTrim = window.opener.document.getElementById(trimType+"GeneralExaminationTrim"+i).value
			 ftSystemicExam = window.opener.document.getElementById(trimType+"SystemicExam"+i).value;
			 ftPA = window.opener.document.getElementById(trimType+"PA"+i).value;
			 if(window.opener.document.getElementById(trimType+"PV"+i)!=null)
			 ftPV = window.opener.document.getElementById(trimType+"PV"+i).value;
			
			 if(ftGeneralExaminationTrim!="" ||ftSystemicExam!="" ||ftPA!="" ||ftPV!="" ){
			j++;
			 
			//displayString =displayString + displayString!=""?"<hr>":""+  j +") ";
			if(displayString=="")
			displayString = displayString+ j +") ";
			else
				displayString = displayString+"<hr>"+ j +") ";	
			 
			 
			if(ftGeneralExaminationTrim!="")
				displayString = displayString+"General Examination: "+ftGeneralExaminationTrim+" ";
			if(ftSystemicExam!="")
				displayString = displayString+"Systemic Examination: "+ftSystemicExam+" ";
			if(ftPA!="")
				displayString = displayString+"PA: "+ftPA+" ";
			if(ftPV!="")
				displayString = displayString+"PV: "+ftPV+" ";
			 }
			
			}
	  }
	
	  window.opener.document.getElementById(divId).innerHTML =displayString;
	  window.close();
	  }

</script>

<label><%=fieldText%></label> <textarea maxlength="100px" name="textVal" id="textVal" style="width: 289px; height: 65px;"><%=val%></textarea>
			
			<div class="clear"></div>		
		<input type="button" value="Submit" class="buttonAuto" onclick="saveTextValue('<%=fieldId%>');"/>		


<style>
.normaltextLabel
{
background:none;box-shadow:none;margin-left: 1px;margin-bottom:0px;
font-weight: normal;
width: auto;

}

.normalLabel
{
width: auto;background:none;box-shadow:none;margin-left: 1px;margin-bottom:0px;
margin-right: -2px;
margin-left: -1px;
font-weight: normal;

}
</style>