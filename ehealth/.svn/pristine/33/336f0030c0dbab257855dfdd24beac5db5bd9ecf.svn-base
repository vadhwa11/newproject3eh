<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * state.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasCategory"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript" language="javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dat=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dat.length()<2){
			dat="0"+dat;
		}
	%>
		serverdate = '<%=dat+"/"+month+"/"+year%>'
</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		  List<MasSpecialityDeptGroup>  masSpDepGrp = new ArrayList<MasSpecialityDeptGroup>();
	      List<PrqAssetDetails> assetMovable=new ArrayList<PrqAssetDetails>();
	      List<MasItemCategory> masItCategory= new ArrayList<MasItemCategory>();
	      List<MasManufacturer> manufacturers=new ArrayList<MasManufacturer>();
	      List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	      List<MasStoreSection> sectionList=new ArrayList<MasStoreSection>();
		
		
		String userName = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
	    if(map.get("assetMovable") != null){
	    	assetMovable = (List<PrqAssetDetails>)map.get("assetMovable");
	      }
	    if(map.get("masItCategory")!=null){
	    	masItCategory=(List<MasItemCategory>)map.get("masItCategory");
	    } 
	    if(map.get("manufacturers")!=null){
	    	manufacturers=(List<MasManufacturer>)map.get("manufacturers");
	    }
	    if(map.get("itemList")!=null){
	    	itemList=(List<MasStoreItem>)map.get("itemList");
	    } 
	    if(map.get("sectionList")!=null){
	    	sectionList=(List<MasStoreSection>)map.get("sectionList");
	    }
	    
	    
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
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

<div id="searcharea"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<% 
		if(masSpDepGrp.size()>0 || masSpDepGrp.size() > 0)
		 {
			String strForCode = (String)map.get("groupCode");
			String strForCodeDescription = (String)map.get("groupName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
	<%
			}
		 }
	 if(masSpDepGrp.size()==0 && map.get("search") != null)
	  {
	 %>

	<%
     }
	%>
	<script type="text/javascript">
	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"assetSection"],[2,"assetCategory"],[3,"itemId"], [4,"assetName"] ,[5,"assetDescription"],[6,"acquireFrom"] ,[7,"rNo"],[8,"vName"],[9,"vType"],[10,"aData"],[11,"model"],[12,"manufacture"],[13,"outlet"],[14,"address"],[15,"contact"],[16,"email"],[17,"deprication"],[18,"<%= STATUS%>"],[19,"wPeriod"],[20,"effectDate"],[21,"purchesVal"],[22,"tax"],[23,"tValue"],[24,"roadTax"],[25,"validUpTo"],[26,"assetsCode"],[27,"sourceOfVehicle"] ];
	 statusTd = 18;

	</script>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<form name="assestDetails" method="post" action="" enctype="multipart/form-data">	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Asset Details For Movable Fixed Asset</h2>
</div>	
<div class="Block">
	
	<label> Asset Group<span>*</span></label>
	 <select name="assetSection" validate="Asset Section,string,yes" onchange="populateStoreItemCategory(this.value)">
			<option value="">Select</option>
			<%for(MasStoreSection storeSection:sectionList){%>
			<option value="<%=storeSection.getId()%>"><%=storeSection.getSectionName() %></option>
			<%} 
			%>
			</select>
		<label>Asset Category<span>*</span></label> <select
			name="assetCategory" id="assetCategory"
			validate="Asset Category,String,yes" onchange="populateCodeByItemName(this.value)">
			<option value="">Select</option>
			<%-- <% 
   for ( MasItemCategory category: masItCategory){
	 %>
			<option value="<%=category.getId ()%>"><%=category.getItemCategoryName()%></option>
			<%}%> --%>
			</select>
	<label>Item<span>*</span></label>
	 <select name="itemId" id="itemId" validate="Item,String,yes" onchange="populateStoreItemNameByCode(this.value)">
			<option value="">Select</option>
			<%-- <% 
   for ( MasStoreItem masStoreItem: itemList){
	 %>
			<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
			<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getPvmsNo()%></option>
			<%}%>	 --%>	
		</select>
		
		 <label> Asset Name<span>*</span></label> <!--  commented by amit das on 02-09-2016 -->
		 <input type="text"
			name="assetName" id="assetName" value=""
			validate="Acquire From,String,yes" class="textbox_size20"
			tabindex="1" />
			<div class="Clear"></div>		
			 <label>Asset Description</label>
		<textarea name="assetDescription" id="assetDescription" class="textareaMediua"
			validate="Asset Description,string,no" tabindex="1"></textarea>



		<label> Acquire From</label> <input type="text" name="acquireFrom"
			id="acquireFrom" value="" validate="Acquire From,metachar,no"
			class="textbox_size20" tabindex="1" /> <label>Registration NO</label>
		<input type="text" name="rNo" id="rNo"
			validate="Purchaser Name,metachar,no" />
		<div class="Clear"></div>		
			 <label>Asset Code<span>*</span></label>
		<input type="text" name="assetsCode" id="assetsCode"
			validate="Asset Code,string,yes" maxlength="8" />
	

		<label> Vehicle Name</label> <input type="text" name="vName"
			id="vName" value="" class="textbox_size20" tabindex="1" /> <label>Vehicle
			Type </label> <input type="text" name="vType" id="vType" tabindex="1"
			onchange="displaySList('Lease');" /> 
			
		<div class="Clear"></div>
			
			<label>Agreement Date</label> <input
			type="text" name="aData" id="aData" class="date"
			validate="Date of Agreement,date,no" tabindex="1" /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onclick="setdate('<%=date %>',document.assestDetails.aData,event);" />


		<label> Model</label> <input type="text" name="model" id="model"
			tabindex="1" /> <label> Manufacturer</label> <select
			name="manufacture" id="manufacture" tabindex="1">
			<option value="">Select</option>
			<%for(MasManufacturer manufacturer:manufacturers){%>
			<option value="<%=manufacturer.getId() %>"><%=manufacturer.getManufacturerName() %></option>
			<%}%>
		</select>

		<div class="Clear"></div>

		<label> Service Outlet</label> <input type="text" name="outlet"
			id="outlet" tabindex="1" /> <label> Address</label> <input
			type="text" name="address" id="address" tabindex="1" /> <label>Upload
			Document</label> <input type="file" name="" id="fileNameId"
			class="browse" tabindex="1" />


		<div class="clear"></div>

		<label> Contact No.</label> <input type="text" name="contact"
			id="contact" tabindex="1" maxlength="10" validate="Contact No,int,no" value=""/>

		<label> Email</label> <input type="text" name="email" id="email"
			tabindex="1" /> <label> Depreciation %</label> <input type="text"
			name="deprication" id="deprication" tabindex="1" />

		<div class="clear"></div>
		<label> Warranty Period</label> <input type="text" name="wPeriod"
			id="wPeriod" tabindex="1"> <label> Effective From
				Date</label> <input type="text" name="effectDate" id="effectDate"
			tabindex="1" class="date" validate="Date of Completion,date,no" /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date"
			onclick="setdate('<%=date %>',document.assestDetails.effectDate,event);" />
		  <label> Purchase Value</label> <input type="text" name="purchesVal" id="purchesVal" class="date" 
			validate="Purchase Value,float,true" tabindex="1" maxlength="6">
			<label class="valueAuto">Rs.</label>
			
			<div class="clear"></div>
				<label>Tax</label> <input type="text" name="tax" id="itax" class="date"
				tabindex="1" validate="Tax,float,true" maxlength="6" onblur="totAmt(this.value)">
				<label class="valueAuto" >% &nbsp;</label>
				 <label> Road Tax</label> <input
						type="text" name="roadTax" id="iroadTax" tabindex="1" class="date"
						validate="Road tax,float,true" maxlength="6" onblur="totAmt(this.value)"> 
                      <label class="valueAuto" >%&nbsp;</label>
					<label> Total Value</label> <input type="text" name="tValue" class="date"
					id="tValue" tabindex="1" validate="Total Value,float,true"
					maxlength="6">
					<label class="valueAuto">Rs.</label>
						<div class="clear"></div> <label>
								Valid Upto<span>*</span>
						</label> <input type="text" name="validUpTo" id="dop" class="date"
							tabindex=1 validate="Date of Completion,date,no" /> <img
							id="calendar" src="/hms/jsp/images/cal.gif" width="16"
							height="16" border="0" validate="Pick a date"
							onclick="setdate('<%=date %>',document.assestDetails.validUpTo,event);" />
				<label>Source Of Vehicle</label>
				<select name="sourceOfVehicle">
					<option value="0">Select</option>
					<option value="Purchase">Purchase</option>
					<option value="Lease">Lease</option>
					<option value="Donate">Donate</option>
					<option value="Loan">Loan</option>
			</select>								

		<div class="Clear"></div>
							<div id="edited"></div> <input type="button" name="add"
							id="addbutton" value="Add" class="button"
							onClick="submitForm('assestDetails','procurement?method=addMovableAssets&'+csrfTokenName+'='+csrfTokenValue);"
							accesskey="a" tabindex=1 /> <input type="button" name="edit"
							id="editbutton" value="Update" style="display: none;"
							class="button"
							onClick="submitForm('assestDetails','procurement?method=addMovableAssets&'+csrfTokenName+'='+csrfTokenValue);"
							accesskey="u" tabindex=1 /> <input type="hidden" name="Delete"
							id="deletebutton" value="Activate" class="button"
							style="display: none;"
							onClick="submitForm('assestDetails','?method=)" accesskey="d"
							tabindex=1 /> <input type="reset" name="Reset" id="reset"
							value="Reset" class="buttonHighlight" onclick="resetCheck();"
							accesskey="r" /> <input type="hidden" name="<%=STATUS %>"
							value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" />

							<input type="hidden" id="pageNoEdit" name="pageNoEdit"
							value="<%=pageNo%>" /> <!--  -->
							<div class="clear"></div>
							<div class="division"></div>
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
</div>
</form>

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
data_header[2][0] = "Item"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "itemId"

data_header[3] = new Array;
data_header[3][0] = "Asset Name"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "assetName";


data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "assetDescription";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "acquireFrom";



data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "rNo";


data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "";
data_header[7][3] = "vName";



data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "";
data_header[8][3] = "vType";



data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "aData"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "model"
 

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "manufacture"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "outlet "

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "outlet "

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "contact"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "email"

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "deprication>"

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=STATUS %>"

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "wPeriod"

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "effectDate"

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "purchesVal"

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "tax"

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "tValue"

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "roadTax"

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "validUpTo"

data_header[25] = new Array;
data_header[25][0] = "Asset code"
data_header[25][1] = "data";
data_header[25][2] = "25%";
data_header[25][3] = "assetsCode"

data_header[26] = new Array;
data_header[26][0] = "Source Of Vehicle"
data_header[26][1] = "data";
data_header[26][2] = "25%";
data_header[26][3] = "sourceOfVehicle"



data_arr = new Array();

<%
Iterator itr=assetMovable.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             PrqAssetDetails  assetDetails= (PrqAssetDetails)itr.next(); 
             if(assetDetails.getAssetType()!=null){
             if(assetDetails.getAssetType().equalsIgnoreCase("movable")){
             
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
Iterator itrFroCategory=masItCategory.iterator();
while(itrFroCategory.hasNext())
   {
	 
	 try{
		 MasItemCategory  category = (MasItemCategory)itrFroCategory.next(); 
	 if(assetDetails.getAssetCategory().getId().equals(category.getId())){%>
	 data_arr[<%= counter%>][2] = "<%=category.getItemCategoryName().trim()%>"
	<%}else if(assetDetails.getAssetCategory().getId().equals(category.getId())){%>
	 data_arr[<%= counter%>][2] = "<%=category.getItemCategoryName().trim()%>"
		
	<%}
   }catch(Exception e){e.printStackTrace();
   System.out.println("Error"+"----------");
   }}%> --%> /* commented by amit das on 02-09-2016 */


<%-- <%
	if(itemList.size()>0){
		for(MasStoreItem masStoreItem : itemList){
			if(assetDetails.getItem() !=null && assetDetails.getItem().getId()== (masStoreItem.getId())){
		
		%>
			data_arr[<%= counter%>][3] = "<%=masStoreItem.getNomenclature()%>"
		<%}
		}
}%>
 --%> 
 /* commented by amit das on 02-09-2016 */
	<% String effDate=""; 
	String valDate="";
	String agrimentDate="";
	if(assetDetails.getEffectiveFromDate()!=null){
		effDate=HMSUtil.changeDateToddMMyyyy(assetDetails.getEffectiveFromDate());
	} 
	if(assetDetails.getValidUpto()!=null){
		valDate=HMSUtil.changeDateToddMMyyyy(assetDetails.getValidUpto());
	}
	if(assetDetails.getAgreementDate()!=null){
		agrimentDate=HMSUtil.changeDateToddMMyyyy(assetDetails.getAgreementDate());
	}  
	String manufacturerName="";
	if(assetDetails.getManufacturer()!=null){
		manufacturerName=assetDetails.getManufacturer().getManufacturerName();
	}
   %>
   data_arr[<%= counter%>][2] = "<%= assetDetails.getAssetCategory()!=null ? assetDetails.getAssetCategory().getItemCategoryName():""%>"
	   /* added by amit das on 02-09-2016 */
   data_arr[<%= counter%>][3] = "<%= assetDetails.getItem()!=null ? assetDetails.getItem().getNomenclature():""%>"   
	/* added by amit das on 02-09-2016 */
   data_arr[<%= counter%>][4] = "<%= assetDetails.getAssetName()!=null ? assetDetails.getAssetName():""%>"
   data_arr[<%= counter%>][5] = "<%= assetDetails.getAssetDesc()!=null ? assetDetails.getAssetDesc():""%>"
	data_arr[<%= counter%>][6] = "<%= assetDetails.getAcquireFrom()!=null ? assetDetails.getAcquireFrom():""%>"
   data_arr[<%= counter%>][7] = "<%= assetDetails.getRegistrationNo()!=null ? assetDetails.getRegistrationNo():""%>"
	data_arr[<%= counter%>][8] = "<%= assetDetails.getVehicleName()!=null ? assetDetails.getVehicleName():""%>"
	data_arr[<%= counter%>][9] = "<%= assetDetails.getVehicleType()!=null ? assetDetails.getVehicleType():""%>"
	 data_arr[<%= counter%>][10] = "<%= agrimentDate%>" 
	data_arr[<%= counter%>][11] = "<%= assetDetails.getModalNo()!=null ? assetDetails.getModalNo():""%>"
	data_arr[<%= counter%>][12] = "<%= manufacturerName%>"
     data_arr[<%= counter%>][13] = "<%= assetDetails.getServiceOutlet()!=null ? assetDetails.getServiceOutlet():""%>"
     data_arr[<%= counter%>][14] = "<%= assetDetails.getAddress()!=null ? assetDetails.getAddress():""%>"
     data_arr[<%= counter%>][15] = "<%= assetDetails.getContactNo()!=null ? assetDetails.getContactNo():""%>"
     data_arr[<%= counter%>][16] = "<%= assetDetails.getEmail()!=null ? assetDetails.getEmail():""%>"
      data_arr[<%= counter%>][17] = "<%= assetDetails.getDeprecation()!=null ? assetDetails.getDeprecation():""%>" 
    	  <% if(assetDetails.getStatus().equalsIgnoreCase("y")){ %>
  		data_arr[<%= counter%>][18] = "Active"
  		<%}else{%>
  		data_arr[<%= counter%>][18] = "Active"
  		<%} 
  		%>
	   data_arr[<%= counter%>][19] = "<%= assetDetails.getWarrentyPeriod()!=null ? assetDetails.getWarrentyPeriod():""%>" 
	   data_arr[<%= counter%>][20] = "<%=effDate%>"
	   data_arr[<%= counter%>][21] = "<%= assetDetails.getPurchaseValue()!=null ? assetDetails.getPurchaseValue():""%>"
	   data_arr[<%= counter%>][22] = "<%= assetDetails.getTax()!=null ? assetDetails.getTax():""%>"
	   data_arr[<%= counter%>][23] = "<%= assetDetails.getTotalCost()!=null ?  assetDetails.getTotalCost():""%>"
		data_arr[<%= counter%>][24] = "<%= assetDetails.getRoadTax()!=null ? assetDetails.getRoadTax():""%>"
		data_arr[<%= counter%>][25] = "<%=valDate%>" 
		data_arr[<%= counter%>][26] = "<%=assetDetails.getAssetCode()!=null ? assetDetails.getAssetCode():""%>" 
			data_arr[<%= counter%>][27] = "<%=(assetDetails.getSourceOfVehicle() != null && !assetDetails.getSourceOfVehicle().equals("0"))?assetDetails.getSourceOfVehicle():""%>" 
	   
				   
<%
       counter++;
}
             }      }
%>


formName = "assestDetails"

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
	 var puchaseVal=0;
	 var tax=0;
	 var roadTax=0;
	 var totVal=0;
	  if(isNaN(document.getElementById("purchesVal").value))
	  {
	  alert('This is not valid Purchase value');
	  return;
	  }
	  puchaseVal=document.getElementById('purchesVal').value;
	  tax = document.getElementById('itax').value;
	// alert(tax);
	  if(tax != null)
	  {
	  	var taxTotalAmount = (puchaseVal*tax)/100;
		totVal =parseFloat(puchaseVal)+parseFloat(taxTotalAmount);
	  	totVal = parseFloat(totVal);
	  	document.getElementById('tValue').value =totVal;
	  }
	 //alert(totVal);

	  roadTax = document.getElementById('iroadTax').value;
	// alert(roadTax);
	  if(roadTax != null)
	  {
	  	var roadTotalAmount = (totVal*roadTax)/100;
	  	totVal =parseFloat(totVal)+parseFloat(roadTotalAmount);
	  	totVal = parseFloat(totVal);
	  	document.getElementById('tValue').value =totVal;
	  }
	 // alert(totVal);

	 /*  totVal = parseFloat(totVal).toFixed(2);
	  document.getElementById('tValue').value =totVal;
	  alert( document.getElementById('tValue').value); */
	  	 
	  	}
	  
</script>


