<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasHospitalType"%>
<%@ page import="jkt.hms.masters.business.Users"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<meta charset="utf-8"/>
<%
 	Map<String,Object> map = new HashMap<String,Object>();
 	if(request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	List<MasHospital> masHospList = new ArrayList<MasHospital>();
	if(map.get("masHospList")!=null){
		masHospList = (List<MasHospital>)map.get("masHospList");
	}
	Long imei=0l;String sim="0";String mac="0"; String utid ="0";
	String instCode="";String instName="";int hospTypeId=0;
	String distName ="";String hospType="";int distId=0;
	String tabStatus="";
	if(masHospList.size()>0){
		if(masHospList.get(0).getImeiNo()!=null){
			imei = masHospList.get(0).getImeiNo();
		}if(masHospList.get(0).getSimNo()!=null){
			sim	= masHospList.get(0).getSimNo();	
		}if(masHospList.get(0).getMac()!=null){
			mac = masHospList.get(0).getMac();
		}if( masHospList.get(0).getUtid()!=null){
			utid = masHospList.get(0).getUtid();
		}if(masHospList.get(0).getDistrict().getDistrictName()!=null){
			distName = masHospList.get(0).getDistrict().getDistrictName();
		}if(masHospList.get(0).getHospitalCode()!=null){
			instCode = masHospList.get(0).getHospitalCode();
		}if( masHospList.get(0).getHospitalName()!=null){
			instName = masHospList.get(0).getHospitalName();	
		}
		if(masHospList.get(0).getDistrict().getId()!=null){
			distId = masHospList.get(0).getDistrict().getId();
		}if( masHospList.get(0).getHospitalType().getHospitalTypeName()!=null){
			hospType = masHospList.get(0).getHospitalType().getHospitalTypeName();
		}if(masHospList.get(0).getHospitalType().getId()!=null){
			hospTypeId = masHospList.get(0).getHospitalType().getId();
		}
		tabStatus = masHospList.get(0).getTabletStatus();
	}

%>

<div id="testDiv">
<div class="Block">
<script>

</script> 																											

<label>District Name </label> 
<input type="text" value="<%=distName %>" id ="districtNameId" name="<%=DISTRICT_NAME %>" validate="District Name,string,yes" maxlength="60" tabindex=1/>
<input type="hidden" value="<%=distId%>" name="<%=DISTRICT_ID%>"/>
<script>

</script>
<label>Institute Type </label> 
<input type="text" value="<%=hospType %>" id ="instituteTypeId" name="<%=INSTITUTE_TYPES %>" validate="Institute Type,string,yes" maxlength="60" tabindex=1/>
<input type="hidden" name="<%= INSTITUTE_TYPES_ID%>" value="<%=hospTypeId%>">
<label>Institute Code </label> 
<input type="text" value="<%=instCode %>" id="instituteCode" name="<%=INSTITUTE_CODE %>" validate="Institute Code,string,yes" onblur="getHospitalName()" maxlength="60" tabindex=1/>

<label>Institute Name </label> 
<input type="text" value="<%= instName%>" id ="instituteNameId" name="<%=INSTITUTE_NAME%>" validate="Institute Name,string,yes" maxlength="60" tabindex=1/>

<label>UTID </label> 
<input type="text"  id="utidId" name="<%=UTID %>" value="<%=utid %>" validate="UTID,string,yes" maxlength="60" tabindex=1/>

<label>MAC </label> 
<input type="text"   id="macId" name="<%=MAC %>" value="<%=mac %>" validate="MAC,string,yes" maxlength="60" tabindex=1/>

<label>IMEI  </label> 
<input type="text" id="imeiId"  name="<%=IMEI %>" value="<%=imei%>" validate="IMEI,string,yes" maxlength="60" tabindex=1/>

<label>SIM  </label> 
<input type="text" id="simId"  name="<%=SIM %>" value="<%=sim %>" validate="SIM,string,yes" maxlength="60" tabindex=1/>
</div>

 <input type="button" name="edit"	id="editbutton" value="Update"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails&update=update');"	accesskey="u" tabindex=1 />
 <%-- <%= if(tabStatus !=null && "".equals(tabStatus) && tabStatus.equals("A")){> --%>
 <!-- <input type="button" name="Delete"	id="deletebutton" value="InActivate"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails&flag='+this.value);"	accesskey="d" tabindex=1 /> -->
 <%-- <%}else if(tabStatus !=null && "".equals(tabStatus) && tabStatus.equals("I")){ %> --%>
 <input type="button" name="Delete"	id="deletebutton" value="InActivate"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails&flag='+this.value);"	accesskey="a" tabindex=1 />
 <%-- <%} %> --%>
 <input type="hidden" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails');"	accesskey="a" tabindex=1 />
 <input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitForm('tabletAssetAdd','pubHealth?method=tabAssetsMaster');" accesskey="r" /> 

<input type="hidden" id="hositalStatus" name="hositalStatus" value="0"/> 

</div>
<div class="clear"></div>
<div id="edited"></div>
 
