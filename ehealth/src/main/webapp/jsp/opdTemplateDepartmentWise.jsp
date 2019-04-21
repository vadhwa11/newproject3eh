<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>

<%--For AutoComplete Through Ajax--%>

<script type="text/javascript" src="/hms/jsp/js/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script type="text/javascript">
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- 
Include the WYSIWYG javascript files
-->
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>


<script type="text/javascript">
function blankSpace()
{
var b1 = document.getElementById('upload').value ;
var b2 = document.getElementById('abc').value ;
var b3= document.getElementById('b3').value ;
if((b1=="")&&(b2=="")&&(b3==""))
{
alert("Please give some fields.");
	return false;
}
else
{
	return true;
}
}
function uploadFileData()
{
fName=document.getElementById("upload").value;

var extension =fName.substring(fName.length-4);

if(fName!=""){
	if(extension != '.txt' && extension != '.TXT' && extension !='.rtf' && extension!='.htm' && extension!='.html' && extension != '.doc' && extension != '.DOC')
	{	
		alert("Uploaded Document can only be in .txt ,.htm,.html,.doc or  .TXT format\n");
		return false;
	}
	else
	{
		submitForm('opdTemplateDepartmentWise','opd?method=getFileName');
		return true;
	} 
 }
}
function callback(http_request) {
if (http_request.readyState == 4 || http_request.readyState=="complete") {
alert('http_request.responseText'+http_request.responseText);
alert(document.getElementById("abc").value)
document.getElementById('abc').value=http_request.responseText;
}
}
</script>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
		Map<String, Object> map = new HashMap<String, Object>();

		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			session.setAttribute("map",map);
		}
		
	
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		int orderhdId = 0;
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}

	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	 
	
	 if(map.get("orderhdId") != null)
	 {
	 orderhdId=(Integer)map.get("orderhdId");

	 }
	 
	%>
<!--main content placeholder starts here-->

<form name="opdTemplateDepartmentWise" action="" method="post"
	enctype="multipart/form-data">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />



<%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Opd Template Department Wise</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->


<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label>Patient Name </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label class="medium">Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label class="medium">Visit
Date </label> <%if(visitDateInString != null){ %> <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>

<div class="clear"></div>

<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %> <label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>


<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<!--Block two Start--> <label class="noWidth">Upload Text Here</label>
<input	type="file" id="upload" name="<%=UPLOAD_FILENAME%>" class="browse"	size="50" onblur="return uploadFileData()" />
<div class="clear"></div>
<!--Rich text editor-->
<div id="rtf">

<table border="0" cellpadding="2" cellspacing="0" width="100%">
	<tr>
		<td><textarea id="abc" name="test2" value=""
			class="tableTextareaEditor">
  <% if(map.get("content")!=null){ %>
    <%=map.get("content").toString() %>
    
   
  <%
   } %>
  </textarea></td>
	</tr>
</table>
</div>
<div class="clear"></div>
<label class="auto">Remarks</label> <textarea id="b3"
	name="<%=REMARKS %>" cols="0" rows="0" maxlength="40"></textarea>



<!--Rich text editor ends-->

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('opdTemplateDepartmentWise','opd?method=addOpdTemplateDepartmentWise&'+csrfTokenName+'='+csrfTokenValue,'blankSpace');"
	align="right" /> <input type="button" class="button" value="View"
	onclick="submitForm('opdTemplateDepartmentWise','opd?method=viewOpdTemplateDepartmentWise&flag=prev&viewScreen=no&'+csrfTokenName+'='+csrfTokenValue);" />
<input name="Back" type="button" alt="Back" value="Back" class="button"
	onclick="submitForm('opdTemplateDepartmentWise','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>&'+csrfTokenName+'='+csrfTokenValue);"
	align="right" />

<div class="clear"></div>

<div class="division"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName %>"><input
	type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"><input
	type="hidden" name="visitId" value="<%=visit.getId() %>"><input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"><input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>"></div>
</form>

<div class="clear"></div>
<div class="paddingTop40"></div>
