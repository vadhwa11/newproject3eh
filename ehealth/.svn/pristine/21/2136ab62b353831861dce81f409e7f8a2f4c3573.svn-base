<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAssessories"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String euipmentName="";
	String modelName="";
	String make="";
	String warrantyDetail="";
	String techSpecification="";
	String contactNo="";
	String serialNo=""; 
	String userName = "";
	
	
	if(request.getAttribute("map")!=null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	//List<HesEquipmentMaster> searchEquipmentList = new ArrayList<HesEquipmentMaster>();
	
     //List<HesEquipmentAssessories> assessoryList = new ArrayList<HesEquipmentAssessories>();
	//List<Object> searchEquipmentList = new ArrayList<Object>();
	List<Object> assessoryList = new ArrayList<Object>();
			
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		if(map.get("assessoryList")!=null){
			assessoryList=(List)map.get("assessoryList");
		}
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>
<form name="searchEquipment" method="post">

<div class="titleBg">
<h2>Equipment Entry Master</h2>
</div>
<%--------------- Start of Tool Panel ---------------------------%>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<%--------------- End of Tool Panel ---------------------------%>

<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel using text box equipment no master ---------------------------%>

<label><span>*</span> Entry No</label>
	<td><input id="entryIdTemp" type="text" tabindex="1" size="45" value="" name="entryIdTemp" );"/>
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('entryIdTemp','ac2update','/hms/hms/hes?method=getEntryListForEquipment',{parameters: 'requiredField=entryIdTemp&searchEntryNo=<%=entryNo%>'});
			</script>
				</td>
<input type="image" name="button" class="button"	onClick="submitForm('searchEquipment','/hms/hms/hes?method=searchEquipmentEntry');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%-------------------- End of Search Panel ---------------------------%>


<form name="modifyMasterForm" method="post">
<!-- <input	type="button" name="Validate" value="" class="button"	onClick="submitForm('searchEquipment','hes?method=searchEquipmentEntry');"> -->

<div class="clear"></div>	
     <div class="Block">
     <label> Entry No: </label> 
     <%
     if(assessoryList.size()>0){
    	 
     HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
     for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			hesEquipmentMaster=(HesEquipmentMaster)object[1];
     }
    // for (HesEquipmentMaster hesEquipmentMaster: searchEquipmentList){ %>

     <input type="text"
	name="<%=entryNo %>"
	value="<%=hesEquipmentMaster.getEntryNo()%>" id="entryNo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	<label> Serial No: </label> <input type="text"
	name="<%=serialNo %>"
	value="<%=hesEquipmentMaster.getSerialNo()%>" id="SerialNo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	<label> Equipment Name: </label> 
	<input type="text"
	name="<%=euipmentName %>"
	value="<%=hesEquipmentMaster.getEquipmentName() %>" id=EquipmentName readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	<div class="clear"></div>
	
	<label> Model Name: </label> <input type="text"
	name="<%=modelName %>"
	value="<%=hesEquipmentMaster.getModelName()%>" id="ModelName" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/ >
	
	<label> Make: </label> <input type="text"
	name="<%=make %>"
	value="<%=hesEquipmentMaster.getMake()%>" id="Make" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	
	<label> Contact Number Of Sales/Service Persons: </label> <input type="text"
	name="<%=contactNo %>"
	value="<%=hesEquipmentMaster.getContactNoSalesService()%>" id="ContactNoSalesService" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  >
	<div class ="clear"></div>
	
	<label>Warranty Details: </label> <textarea 
	name="<%=warrantyDetail %>"
	id="WarrantyDetails" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"> <%=hesEquipmentMaster.getWarrantyDetails()%></textarea>
	
    <label>Technical Specification: </label> <textarea  id="TechnicalSpecifications" rows="8"
	name="<%=techSpecification %>"
     readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"> <%=hesEquipmentMaster.getTechnicalSpecifications()%></textarea>
	<div class ="clear"></div>
	<h4>Assessory Equipment Details</h4>
	<div class="division"></div>
	<%} %>
	<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails">
	
	<tr>
		<th scope="col">Assessory Name</th>
		<th scope="col">Model No.</th>
		<th scope="col">Serial No.</th>
		<th scope="col">Quantity</th>
		<th scope="col">Remarks</th>
		
	</tr>
	
		    <%
		    if(assessoryList.size()>0){
		    	
		    
		    for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				HesEquipmentAssessories hesEquipmentAssr=(HesEquipmentAssessories)object[0];
			//}

		    //for (HesEquipmentAssessories hesEquipmentAssr: assessoryListMaster){
		    %>
		    <tr>

   <td> 
    
   <input type="text"
	name="assryName"
	value="<%=hesEquipmentAssr.getAssessoryName()%>" id="assryName" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  ></td> 
	
	<td><input type="text"
	name="modNo"
	value="<%=hesEquipmentAssr.getModelNo()%>" id="modNo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  ></td> 
	
	<td> <input type="text"
	name="serialNo"
	value="<%=hesEquipmentAssr.getSerialNo()%>" id="serialNo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  ></td> 
	
	 <td> <input type="text"
	name="qunatity"
	value="<%=hesEquipmentAssr.getQuantity()%>" id="qunatity" readonly="readonly" class="textbox_size20"
	MAXLENGTH="10"/  > </td>
	
	 <td><textarea
	name="cremarks"
	id="cremarks" readonly="readonly" 
	MAXLENGTH="10" ><%=hesEquipmentAssr.getRemarks()%></textarea></td>
	<%}
		    }%>
				
</tr>
</table>
</div>

	</div>
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<!--Block one Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="sss" align="right" class="button" value="Modify"
 onclick="submitForm('modifyMasterForm','/hms/hms/hes?method=showEquipmentMasterModify');" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!--Bottom labels starts-->

<div class="bottom">
<input type="hidden" name="lastChgBy" value="<%=userName%>" />
<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
<label>Changed By</label> <label class="value"><%=userName%> </label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label> 
<label>Changed Time</label> <label class="value"><%=currentTime%></label>
<div class="clear"></div>


<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script><input type="hidden" name="rows" id="rr" value="1" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
	