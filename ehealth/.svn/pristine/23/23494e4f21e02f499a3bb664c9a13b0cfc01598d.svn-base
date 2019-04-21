
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<!-- <script type="text/javascript" language="javascript"> 
	function ismaxlength(obj) {
		var mlength = obj.getAttribute ? parseInt(obj.getAttribute("maxlength"))
				: ""

		if (obj.getAttribute && obj.value.length > mlength)
			obj.value = obj.value.substring(0, mlength)
	}
</script> -->
<%
Map<String,Object> map = new HashMap<String,Object>();
List<MasDistrict> masDistrict=new ArrayList<MasDistrict>();
List<MasItemCategory> masItemCategories=new ArrayList<MasItemCategory>();
List<MasManufacturer> masManufacturers=new ArrayList<MasManufacturer>();
List<MasStoreUnit> masStoreUnits=new ArrayList<MasStoreUnit>();
List<PrqAssetDetails> assetMovable=new ArrayList<PrqAssetDetails>();
List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
List<MasStoreSection> sectionList=new ArrayList<MasStoreSection>();


if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
if(map.get("masDistrict")!=null){
	masDistrict=(List<MasDistrict>)map.get("masDistrict");
}
if(map.get("masItemCategories")!=null){
	masItemCategories=(List<MasItemCategory>)map.get("masItemCategories");
}
if(map.get("manufacturers")!=null){
	masManufacturers=(List<MasManufacturer>)map.get("manufacturers");
}
if(map.get("itemConversions")!=null){
	masStoreUnits=(List<MasStoreUnit>)map.get("itemConversions");
}
if(map.get("assetMovable")!=null){
	assetMovable=(List<PrqAssetDetails>)map.get("assetMovable");
}
if(map.get("itemList")!=null){
	itemList=(List<MasStoreItem>)map.get("itemList");
}
if(map.get("sectionList")!=null){
	sectionList=(List<MasStoreSection>)map.get("sectionList");
}

System.out.println("Size "+masItemCategories.size());

  if(map.get("message") != null){
	 String message = (String)map.get("message");
	 System.out.println(message);
	 
	   %>

	   <h4>
	   	<span><%= message%></span>
	   </h4>
	   <%}
	   	int pageNo = 0;
	   	if(map.get("pageNo") != null){
	   		pageNo = (Integer)map.get("pageNo");
	   	}
	   %>
<% 
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	
} %>




<script type="text/javascript" language="javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<% 
		if(assetMovable.size()>0 || assetMovable.size() > 0)
		 {
			String strForCode = (String)map.get("groupCode");
			String strForCodeDescription = (String)map.get("groupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4>
		<a href="generalMaster?method=showDepartmentGroupParameter">Show
			All Records </a>
	</h4>
	<%
			}
		 }
	 if(assetMovable.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="generalMaster?method=showDepartmentGroupParameter">Show All Records</a>
	</h4>
	<%
     }
	%>
	<script type="text/javascript"><%= STATUS%>

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"assetSection"], [2,"assetCategory"], [3,"assetsName"], [4,"assetCode"], [5,"addressDescription"], [6,"address"],  [7,"district"], [8,"aquireFroms"],[9,"surveyNo"], [10,"landMeasurementh"], [11,"landMeasurementw"],  [12,"uomLandExtentId"], [13,"dateOfPossession"],[14,"dateOfRegistration"], [15,"cost"], [16,"registrationAndOtherCharges"], [17,"totalCost"],[18,"presentBookValue"], [19,"remarks"],[20,"<%= STATUS%>"],[21,"leasePeriod"],[22,"completionDate"],[23,"leasePeriodFreehold"],[24,"itemId"],[25,"depriciation"]];
	 statusTd = 20;

	</script>
</div>

<form name="immuableAssestDetails" method="post" action="" enctype="multipart/form-data">

<div class="titleBg">
<h2>Asset Details For Immovable(Fixed Asset)</h2>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label> Asset Group<span>*</span></label>
	 <select name="assetSection" validate="Asset Section,string,yes" onchange="populateImmovableStoreItemCategory(this.value)">
			<option value="">Select</option>
			<%for(MasStoreSection storeSection:sectionList){%>
			<option value="<%=storeSection.getId()%>"><%=storeSection.getSectionName() %></option>
			<%} 
			%>
			</select>
		<label> Asset Category<span>*</span></label> <select
			name="assetCategory" id="immovableassetCategory" validate="Asset Category,string,yes" 
			onchange="populateImmovableCodeByItemName(this.value)">
			<option value="">Select</option>
			<%-- <%for(MasItemCategory itemCategory:masItemCategories){%>
			<option value="<%=itemCategory.getId()%>"><%=itemCategory.getItemCategoryName() %></option>
			<%} 
			%> --%>
		</select>
		<label>Item<span>*</span></label>
	 <select name="itemId" id="itemId" validate="Item,String,yes" onchange="populateImmovableStoreItemNameByCode(this.value)">
			<option value="">Select</option>
			<%-- <% 
   for ( MasStoreItem masStoreItem: itemList){
	 %>
			<option value="<%=masStoreItem.getId ()%>"><%=masStoreItem.getNomenclature()%></option>
			<%}%> --%>		
		</select>
		
		 <label> Asset Name<span>*</span></label> <!--  commented by amit das on 02-09-2016 -->
		  <input type="text"
			name="assetsName" id="assetsNameId"	validate="Asset Name,string,yes"	 />
		<div id="autoconecpt1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('ItemName1', 'autoconecpt1',
					'maintenance?method=getItemListAutoComplet', {
						minChars : 1,
						parameters : 'code=1'
					});
		</script>
		<label>Asset Code</label>
		<input type="text" name="assetCode" id="assetCode" validate="Asset Code,string,yes"/>		
		
		<label>Asset Description</label>
		<textarea name="addressDescription" id="addressDescription" class="textareaMediua"
			maxlength="100" validate="Asset Description,string,no" tabindex="1"
			onkeyup="return ismaxlength(this)"></textarea>
		<div class="Clear"></div>
		<label>Address</label>
		<textarea rows="5" cols="50" maxlength="200" name="address" id=""address"" class="textareaMediua"></textarea>
		<label>District</label> <select name="district" id="district" onchange=""><option
				value="">Select</option>
			<%for(MasDistrict district:masDistrict){ %>
			<option value="<%=district.getId()%>"><%=district.getDistrictName() %></option>
			<%} %>
		</select> <label> Aquire From</label> <input type="text" name="aquireFrom"
			id="aquireFroms" value="" validate="Purchaser Name,metachar,no"
			class="textbox_size20" MAXLENGTH="32" tabindex="1" />
		<div class="Clear"></div>
		<label> Plot No./Survey No.<span>*</span></label> <input type="text"
			name="surveyNo" id="surveyNo" value="" validate="Survey No.,int,no"
			class="textbox_size20" MAXLENGTH="7" tabindex="1"><label>
				Land Measurement</label> <input type="text" name="landMeasurementh"
			id="landMeasurementh" value="" validate="land Measurement,float,no"
			class="vsmall" MAXLENGTH="7" onblur="getCal();" tabindex="1">
				<label class="valueAuto">X</label> <input type="text"
				name="landMeasurementw" id="landMeasurementw" value=""
				onblur="getCal();" validate="x,float,no" class="vsmall"
				MAXLENGTH="7" tabindex="1"><label> UOM</label> <select
					name="uomLandExtentId" validate="UOM Land Extent,int,yes"
					tabindex="1">
						<option value=" ">Select</option>
						<%for(MasStoreUnit masStoreUnit:masStoreUnits){%>
						<option value="<%=masStoreUnit.getId()%>"><%=masStoreUnit.getUnitName()%></option>
						<%}
				%>

				</select>
					<div class="Clear"></div> <!-- <label>Land Extent<span>*</span></label> <input
			type="text" name="landExtent" id="landExtent" value=""
			validate="Land Extent,float,no" class="textbox_size20" MAXLENGTH="10"
			tabindex="1">  --> <label> Date of Possession<span>*</span></label> <input
					type="text" name="dateOfPossession" id="dateOfPossession" value="" class="date"
					maxlength="30" tabindex=1 /> <img id="calendar"
					src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Date of Possession,date,yes"
					onclick="setdate('<%=currentDate %>',document.immuableAssestDetails.dateOfPossession,event);" /><label>
						Date of Registration<span>*</span>
				</label> <input type="text" name="dateOfRegistration" id="dateOfRegistration" tabindex="1"
					value="" class="date" size="7"
					validate="Date of Registration,date,yes"
					onkeyup="mask(this.value,this,'2,5','/');" maxlength="10"
					onblur="validateExpDate(this,'dor');" /><img id="calendar"
					src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Pick a date"
					onclick="setdate('<%=currentDate %>',document.immuableAssestDetails.dateOfRegistration,event);" />

					<label>Cost<span>*</span></label> <input type="text" name="cost" id="cost"
					value="" validate="Cost,float,yes" size="16" MAXLENGTH="10"
					class="date" tabindex="1"> <label class="valueAuto" onblur="totAmt(this.value)">
							Rs.</label>
						<div class="clear"></div> <label>Reg. and Other Charges<span>*</span>
					</label> <input type="text" name="registrationAndOtherCharges" value=""
						validate="Registration and Other Charges,float,yes" size="16"
						class="date" MAXLENGTH="10" tabindex="1" id="registrationAndOtherChargesId" onblur="totAmt(this.value)"> <label
							class="valueAuto"> Rs.</label> <label>Total Cost<span>*</span></label>
							<input type="text" name="totalCost" value=""
							validate="Total Cost,float,yes" size="16" MAXLENGTH="10"
							class="date" tabindex="1" id="totalCostId" onblur="totAmt(this.value)" readonly="readonly"> <label class="valueAuto">
									Rs.</label>
									<label>Depriciation</label> <input
								type="text" name="depriciation" value=""
								id="depriciationId" class="date" size="16"
								MAXLENGTH="10" tabindex="1" onblur="totAmt(this.value)"><label class="valueAuto" >
									%</label>
									<div class="clear"></div>
									 <label>Present Book Value<span>*</span></label> <input
								type="text" name="presentBookValue" value=""
								validate="Present Book Value,float,yes" class="date" size="16"
								MAXLENGTH="10" tabindex="1" id="presentBookValueId" read> <label class="valueAuto" >
										Rs.</label>
									 <label>Upload Document</label> <input
									type="file" name="" id="fileNameId"
									class="browse" tabindex="1" /> <label>Remarks</label> <textarea
										rows="" cols="" name="remarks" maxlength="100"
										onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"></textarea>
									<div class="clear"></div> <label class="auto">Lease </label> <input
									type="radio" class="radioCheckCol1" name="leasePeriodFreehold"
									id="radio1" value="Lease" tabindex="1"
									onchange="displaySList('Lease');" /> <label class="auto">Free
										hold</label> <input type="radio" class="radioCheckCol1"
									name="leasePeriodFreehold" id="radio2" value="Free hold"
									tabindex="1" onchange="displaySList('FreeHold');" />
									<div id="leaseDiv" style="display: none">
										<label> Lease Period </label> <input type="text"
											name="leasePeriod" id="leasePeriod"
											validate="Lease Period,int,no" tabindex="1" maxlength="4">
											<label>Completion Date</label> <input type="text"
											name="completionDate" value="" class="date" maxlength="30"
											tabindex=1 validate="Date of Completion,date,no" id="completionDate"/> <img id="calendar"
											src="/hms/jsp/images/cal.gif" width="16" height="16"
											border="0" validate="Pick a date"
											onclick="setdate('<%=currentDate %>',document.immuableAssestDetails.completionDate,event);" />
									</div>
									<div class="clear"></div>
								
	


	<div id="edited"></div>
	<div class="Clear"></div>
	<div class="paddingTop5"></div>
	<div id="edited"></div> <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('immuableAssestDetails','procurement?method=addImmuableAssets&'+csrfTokenName+'='+csrfTokenValue);"
							accesskey="a" tabindex=1 /> <input type="button" name="edit"
							id="editbutton" value="Update" style="display: none;"
							class="button"
							onClick="submitForm('immuableAssestDetails','procurement?method=addImmuableAssets&'+csrfTokenName+'='+csrfTokenValue);"
							accesskey="u" tabindex=1 /> <input type="hidden" name="Delete"
							id="deletebutton" value="Activate" class="button"
							style="display: none;"
							onClick="submitForm('immuableAssestDetails','?method=)"
							accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
							id="reset" value="Reset" class="buttonHighlight"
							onclick="resetCheck();" accesskey="r" /> <input type="hidden"
							name="<%=STATUS %>" value="" /> <input type="hidden"
							name="<%= COMMON_ID%>" value="" /> <input type="hidden"
							id="pageNoEdit" name="pageNoEdit" value="<%=pageNo%>" /> <!--  -->
							<div class="clear"></div>							
							<div class="bottom">
								<label> Changed By: </label> <label class="value"><%=userName%></label>
								<label> Changed Date: </label> <label class="value"><%=date%></label>
								<label> Changed Time: </label> <label class="value"><%=time%></label>
								<input type="hidden" name="<%=CHANGED_BY%>"
									value="<%=userName%>" /> <input type="hidden"
									name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
									type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
							</div>

<div class="Clear"></div>
</div>
</form>
<script>
	function getCal() {
		var l = document.getElementById('landMeasurementh').value;
		var x = document.getElementById('landMeasurementw').value;
		var e = 0;
		if (l != "" && x != "") {
			e = l * x;
			document.getElementById('landExtent').value = e;
			document.getElementById('landExtent').readOnly = true;
		} else {
			document.getElementById('landExtent').value = "";
			document.getElementById('landExtent').readOnly = false;
		}
		return true;
	}

	function displaySList(val) {
		if (val != "") {
			if (val == "Lease") {
				document.getElementById('leaseDiv').style.display = 'inline';

			}
			if (document.getElementById('radio1').checked == true) {
				document.getElementById('leaseDiv').style.display = 'inline';

			}
			if (document.getElementById('radio2').checked == true) {
				document.getElementById('leaseDiv').style.display = 'none';
				document.getElementById('leasePeriod').value = '';
				document.getElementById('completionDate').value = '';
			}
			if (val == "FreeHold") {
				document.getElementById('leaseDiv').style.display = 'none';
				document.getElementById('leasePeriod').value = '';
				document.getElementById('completionDate').value = '';
			}
		} else {
			document.getElementById('leaseDiv').style.display = 'none';
			document.getElementById('leasePeriod').value = '';
			document.getElementById('completionDate').value = '';
		}
	}
</script>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Asset Section"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "assetSection"

data_header[1] = new Array;
data_header[1][0] = "Asset Category"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "assetCategory"

data_header[2] = new Array;
data_header[2][0] = "Asset Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "assetName";


data_header[3] = new Array;
data_header[3][0] = "Asset Code"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "assetCode";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "addressDescription";



data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "";
data_header[5][3] = "address";


data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "district";



data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "";
data_header[7][3] = "aquireFroms";



data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "surveyNo"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "landMeasurementh"
 

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "landMeasurementw"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "uomLandExtentId "

	data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "dateOfPossession "

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "dateOfRegistration"

	data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "cost"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "registrationAndOtherCharges"

	data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "totalCost"

	data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "presentBookValue"

	data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "remarks"


data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%= STATUS%>"

	data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "leasePeriod"

	data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "completionDate"


 data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "leasePeriodFreehold"

data_header[23] = new Array;
data_header[23][0] = "Item"
data_header[23][1] = "data";
data_header[23][2] = "25%";
data_header[23][3] = "itemId"

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "depriciation"

data_arr = new Array();

<%
Iterator itr=assetMovable.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             PrqAssetDetails  assetDetails= (PrqAssetDetails)itr.next(); 
             if(assetDetails.getAssetType()!=null){
             if(assetDetails.getAssetType().equalsIgnoreCase("immovable")){
             
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= assetDetails.getId()%>

<%
if(sectionList.size()>0){
	for(MasStoreSection masStoreSection : sectionList){
		if(assetDetails.getItemSection() !=null && assetDetails.getItemSection().getId().equals(masStoreSection.getId())){
	
	%>
		data_arr[<%= counter%>][1] = "<%=masStoreSection.getSectionName()%>"
	<%}
	}
}%>

<%-- <%
Iterator itrFroCategory=masItemCategories.iterator();
while(itrFroCategory.hasNext())
   {
	 
	 try{
		 MasItemCategory  category = (MasItemCategory)itrFroCategory.next(); 
	 if(assetDetails.getAssetCategory().getId().equals(category.getId())){%>
	 data_arr[<%= counter%>][2] = "mirja"
	<%}else if(assetDetails.getAssetCategory().getId().equals(category.getId())){%>
	 data_arr[<%= counter%>][2] = "mirja"
		
	<%}
   }catch(Exception e){
	   e.printStackTrace(); 
   }  }%>  --%> /* commented by amit das on 02-09-2016 */
   
	<%String possDate="";
	String regDate="";
	String comDate="";
	String leasePeriod="";
   if(assetDetails.getPossessionDate()!=null){
	   possDate=HMSUtil.changeDateToddMMyyyy(assetDetails.getPossessionDate());
   }
   if(assetDetails.getRegistrationDate()!=null){
	   regDate= HMSUtil.changeDateToddMMyyyy(assetDetails.getRegistrationDate());
   }
   if(assetDetails.getLeaseCompletionDate()!=null){
	   comDate= HMSUtil.changeDateToddMMyyyy(assetDetails.getLeaseCompletionDate());
   }
   if(assetDetails.getLeasePeriod()!=null){
	   leasePeriod= assetDetails.getLeasePeriod();
   }
  %>
	
  data_arr[<%= counter%>][2] = "<%= assetDetails.getAssetCategory()!=null ? assetDetails.getAssetCategory().getItemCategoryName():""%>"
   data_arr[<%= counter%>][3] = "<%= assetDetails.getAssetName()!=null ? assetDetails.getAssetName():""%>"
	data_arr[<%= counter%>][4] = "<%= assetDetails.getAssetCode()!=null ? assetDetails.getAssetCode():""%>"
   data_arr[<%= counter%>][5] = "<%= assetDetails.getAssetDesc()!=null ? assetDetails.getAssetDesc():""%>"
	data_arr[<%= counter%>][6] = "<%= assetDetails.getAddress()!=null ? assetDetails.getAddress():""%>"
	
		<%
		Iterator itDistrict=masDistrict.iterator();
		while(itDistrict.hasNext())
		   {
			 
			 try{
				 MasDistrict  district = (MasDistrict)itDistrict.next(); 
			 if(assetDetails.getDistrict().getId().equals(district.getId())){%>
			  data_arr[<%= counter%>][7] = "<%= district.getDistrictName().trim()%>"
			<%}else if(assetDetails.getDistrict().getId().equals(district.getId())){%>
			  data_arr[<%= counter%>][7] = "<%= district.getDistrictName().trim()%>"
				
			<%}
		   }catch(Exception e){e.printStackTrace(); 
		   }}
		 %>
   
    data_arr[<%= counter%>][8] = "<%=assetDetails.getAcquireFrom() != null?assetDetails.getAcquireFrom():""%>"
	data_arr[<%= counter%>][9] = "<%= assetDetails.getPlotSurveyNo() != null?assetDetails.getPlotSurveyNo():"" %>"
	 data_arr[<%= counter%>][10] = "<%= assetDetails.getLandMeasurementH() != null?assetDetails.getLandMeasurementH():""%>"
		 data_arr[<%= counter%>][11] = "<%= assetDetails.getLandMeasurementW() != null? assetDetails.getLandMeasurementW():""%>"
	
			 <%
				Iterator itrat=masStoreUnits.iterator();
				while(itrat.hasNext())
				   {
					 
					 try{
						 MasStoreUnit  maUnit = (MasStoreUnit)itrat.next(); 
						 if(assetDetails.getUom()!=null){
						 if(maUnit.getUnitName()!=null){
					 if(assetDetails.getUom().getId().equals(maUnit.getId())){%>
					 data_arr[<%= counter%>][12] = "<%= maUnit.getUnitName()%>"
					<%}else if(assetDetails.getUom().getId().equals(maUnit.getId())){%>
					data_arr[<%= counter%>][12] = "<%= maUnit.getUnitName()%>"
						
					<%}
					 }
						 }
				   }catch(Exception e){e.printStackTrace();
				  
				   }
					 
					 }
				 %>
		 
	 
	 data_arr[<%= counter%>][13] = "<%= possDate != null?possDate:""%>"
	
    
	 data_arr[<%= counter%>][14] = "<%= regDate != null?regDate:""%>"
  
     data_arr[<%= counter%>][15] = "<%= assetDetails.getEstCost()!= null?assetDetails.getEstCost():""%>"
     data_arr[<%= counter%>][16] = "<%= assetDetails.getRegistrationOtherCharges() != null?assetDetails.getRegistrationOtherCharges():""%>"
     data_arr[<%= counter%>][17] = "<%= assetDetails.getTotalCost() != null?assetDetails.getTotalCost():""%>"
      data_arr[<%= counter%>][18] = "<%= assetDetails.getBookValue() != null?assetDetails.getBookValue():""%>" 
	   data_arr[<%= counter%>][19] = "<%= assetDetails.getRemarks()!= null?assetDetails.getRemarks():""%>"
		   <% if(assetDetails.getStatus().equalsIgnoreCase("y")){ %>
	  		data_arr[<%= counter%>][20] = "Active"
	  		<%}else{%>
	  		data_arr[<%= counter%>][20] = "Active"
	  		<%}%>
	  		
	  	  data_arr[<%= counter%>][21] = "<%= leasePeriod!= null?leasePeriod:""%>"
	  		data_arr[<%= counter%>][22] = "<%= comDate != null?comDate:""%>"
	  				<%System.out.println("assetDetails.getLeaseholdFreehold()======"+assetDetails.getLeaseholdFreehold()); %>
	  			 data_arr[<%= counter%>][23] = "<%=assetDetails != null && assetDetails.getLeaseholdFreehold()!= null?assetDetails.getLeaseholdFreehold():""%>"
	  			<%-- 	<%
	  				if(itemList.size()>0){
	  					for(MasStoreItem masStoreItem : itemList){
	  						if(assetDetails.getItem() !=null && assetDetails.getItem().getId()== (masStoreItem.getId())){
	  					
	  					%>
	  						data_arr[<%= counter%>][24] = "<%=masStoreItem.getNomenclature()%>"
	  					<%}
	  					}
	  			}%> --%>  /* commented by amit das on 02-09-2016 */
	  			 data_arr[<%= counter%>][24] = "<%=assetDetails != null && assetDetails.getItem()!= null?assetDetails.getItem().getNomenclature():""%>"
	  			
	  			 data_arr[<%= counter%>][25] = "<%=assetDetails.getDeprecation()!=null ? assetDetails.getDeprecation():""%>"
	  			
	  		<%-- 

	 
	   data_arr[<%= counter%>][20] = "<%= assetDetails.getTax()%>"
	   data_arr[<%= counter%>][21] = "<%= assetDetails.getTotalCost()%>"
		  data_arr[<%= counter%>][22] = "<%= assetDetails.getRoadTax()%>"
			   data_arr[<%= counter%>][23] = "<%= assetDetails.getValidUpto()%>" 
	   
				    --%>
<%
       counter++;
}
             }      }
%>


formName = "immuableAssestDetails"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);
	
//pgNo = '<%=pageNo%>';
//totalPages = Math.ceil(data_arr.length/rowsPerPage);
//goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');	
</script>
<script type="text/javascript">
  function totAmt(){
	 var cost=0;
	 var registrationAndOtherCharges=0;
	 var totalCost=0;
	 var depriciation=0;
	 var presentValue=0;
	  if(isNaN(document.getElementById("cost").value))
	  {
	  alert('This is not valid Cost');
	  return;
	  }
	  cost=document.getElementById('cost').value;
	  if(isNaN(document.getElementById("registrationAndOtherChargesId").value))
		  {
		  alert('Please Enter valid Registration and other Charges');
		  return;
		  }
	  
	  registrationAndOtherCharges=document.getElementById('registrationAndOtherChargesId').value;
	  totalCost = eval(Number(eval(Number(cost))+(eval(Number(registrationAndOtherCharges)))));
	  totalCost = parseFloat(totalCost).toFixed(2);
	   document.getElementById('totalCostId').value = totalCost;
		 if(isNaN(document.getElementById("depriciationId").value))
		  {
		  alert('This is not valid Depriciation');
		  return;
		  } 
		  if(document.getElementById("depriciationId").value!=null && document.getElementById("depriciationId").value!=""){
			  depriciation=parseInt(document.getElementById("depriciationId").value);
		 	}
	    document.getElementById("presentBookValueId").value=totalCost-((totalCost*depriciation)/100);
		presentValue=totalCost-((totalCost*depriciation)/100);
		presentValue = parseFloat(presentValue).toFixed(2);
	    document.getElementById("presentBookValueId").value=presentValue;
  }
</script>





