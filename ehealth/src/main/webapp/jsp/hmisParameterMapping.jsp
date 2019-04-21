<%@page import="jkt.hms.masters.business.MasPhReportsParameters"%>
<%@page import="jkt.hms.masters.business.HmisParameterMapping"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasHmisParameters"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>

<script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	
	function getHimsParameterMappingList(){
		submitProtoAjaxWithDivName('hmisParameterMapping','pubHealth?method=getItemListForHmisMapping','itemList');
	}
</script>

<%
Map map = new HashMap();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

utilMap = (Map)HMSUtil.getCurrentDateAndTime(); 

String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
int inc = 0;
String hmisParameterId = null;

List<MasPhReportsParameters> hmisParametersList = new ArrayList<MasPhReportsParameters>();
if(map.get("hmisParametersList") != null){
	hmisParametersList=(List<MasPhReportsParameters> ) map.get("hmisParametersList");	
}

if(map.get("hmisParameterId") != null){
	hmisParameterId=(String)map.get("hmisParameterId");	
}



if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
}
%>

<div class="titleBg">
<h2>HMIS Parameter Mapping</h2>
</div>
<form name="hmisParameterMapping" method="post">
<div class="Block">
	<h4>HMIS</h4>
		<div id="pageNavPosition"></div>
		<div class="clear"></div>
		<label><span>*</span> HMIS Paramater</label> <select
			validate="hmisParameter,string,no" name="hmisParameterId"
			id="hmisParameterId" onchange="getHimsParameterMappingList();">
			<option value="0">Select</option>
			<% for(MasPhReportsParameters hmisParameter : hmisParametersList) {%>
			<% if((hmisParameterId!=null && !hmisParameterId.trim().equals("")) && (hmisParameter.getHmisId().equalsIgnoreCase(hmisParameterId))) {%>
				<option value="<%=hmisParameter.getHmisId()%>" selected="selected"><%=hmisParameter.getHmisParameter()%></option>	
			<% } else {%>
			<option value="<%=hmisParameter.getId()%>"><%=hmisParameter.getHmisParameter()%></option>
			<% } 
			} %>
		</select> <label>Category</label> <select
			validate="hmisParameterCategory,string,no"
			name="hmisParameterCategory" id="hmisParameterCategory" >
			<option value="0">Select</option>
			<option value="medicine">Medicine</option>
			<option value="investigation">Investigation</option>
			<option value="procedure">Procedure</option>
		</select>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>

		<label class="auto">Medicine/Investigation Name</label> <input type="text" value=""
			tabindex="1" id="itemName" size="40" name="itemName" />

		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter(
					'itemName',
					'ac2update',
					'pubHealth?method=getItemListForAutoCompleteForHmisParameterMapping',
					{
						minChars : 3,
						callback : function(element, entry) {
							return entry
									+ '&hmisParameterCategory='
									+ document
											.getElementById('hmisParameterCategory').value;
						},
						parameters : 'requiredField=itemName'
					});
		</script>

<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForItem();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForItem();">
</div>
		
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemGrid">
	<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Item Name</th>
		<th scope="col">Category</th>
	</tr>
	<tbody id="itemList">
	
	</tbody>
</table>
		
	</div>
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div id="responseDiv" style="display: none;">
</div>


<script type="text/javascript">
	getHimsParameterMappingList();
	
	function addRowForItem(){
		var itemNameAndId = document.getElementById("itemName").value;
		var itemId =	itemNameAndId.substring(itemNameAndId.indexOf('[')+1, itemNameAndId.indexOf(']'));
		var itemName =	itemNameAndId.substring(0, itemNameAndId.indexOf('['));
		var hmisParameterId = document.getElementById("hmisParameterId").value;
		var itemCategory = document.getElementById("hmisParameterCategory").value;
		if(itemCategory!=="0" && hmisParameterId!="0" && itemId!='' && itemName!=''){
			submitProtoAjaxWithDivName('hmisParameterMapping','pubHealth?method=addHmisParameterMapping&itemId='+itemId+'&itemName='+itemName+'&itemCategory='+itemCategory+'&hmisParameterId='+hmisParameterId,'responseDiv');
			/* var result = document.getElementById("responseDiv").innerHTML;
			if(result=='success')
				location.reload();
			else
				alert("Please try again !") */
			//location.reload();
			var url = window.location.href;
		    if (url.indexOf("hmisParameterId=") >= 0){
		    	url =	url.substring(0, url.indexOf("hmisParameterId="));
		    }
		    
			window.location.href = url + "&hmisParameterId="+hmisParameterId;
		} else if(itemId=='' || itemName==''){ 
			alert("Choose Valid Medicine/Investigation !");
		} else {
			alert("Please choose HIMS Parameter and Category !");
		}
	}
	
	function removeRowForItem(){
		var itemCount = document.getElementById("itemCount").value;
		var hmisParameterId = document.getElementById("hmisParameterId").value;
		var checkFlag = false;
		var toBeDeletedIds = '';
		for(var i=1; i <=itemCount; i++){
			if(document.getElementById("itemCheck"+i).checked){
				checkFlag = true;
				toBeDeletedIds = toBeDeletedIds+ document.getElementById("itemCheck"+i).value+',';
			}
		}
		
		if(!checkFlag){
			alert("Select at least one item to delete !");
		} else {
			submitProtoAjaxWithDivName('hmisParameterMapping','pubHealth?method=deleteHmisParameterMapping&hmisParameterMappingIds='+toBeDeletedIds,'responseDiv');
			/* var result = document.getElementById("responseDiv").innerHTML;
				if(result=='success')
					location.reload();
				else
					alert("Please try again !") */
			//location.reload();
			var url = window.location.href;
		    if (url.indexOf("hmisParameterId=") >= 0){
		    	url =	url.substring(0, url.indexOf("hmisParameterId="));
		    }
		    
			window.location.href = url + "&hmisParameterId="+hmisParameterId;
		}
	}
</script>