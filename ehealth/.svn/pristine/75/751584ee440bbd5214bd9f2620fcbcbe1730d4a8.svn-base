<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasIdCard"%>

<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<title>Donor Registration</title>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script type="text/javascript"
	src="/hms/jsp/js/jquery-1.4.2.js"></script>

<script type="text/javascript">
function myFunction() {
    document.getElementById("assessmentButtonId").disabled = false;
    document.getElementById("physicalExamButtonId").disabled = false;
}
</script>
<script type="text/javascript">

    $(document).ready(function(){

        $('input[type="radio"]').click(function(){
        	
        	if($(this).attr("value")=="aadhaarID"){
        		
        		
        		$('.qrscan').attr('checked', false);
        		$('.ekyc').attr('checked', false);
        		 $(".ekycQrScanblock").show();
                $(".Block2").show();
                $(".Block1").show();
                $(".uidDivBlock").show();
                $(".Block2").hide();
                $(".Block1").hide();
                $(".idcardshow").hide();
                $(".idcardshow").hide();
            }
            if($(this).attr("value")=="ScanQRCode"){
                $(".Block2").show();
                $(".Block1").hide();
            }

            if($(this).attr("value")=="eKyc"){
                $(".Block1").show();
                $(".Block2").hide();
            }
            if($(this).attr("value")=="otherID"){
            	  $(".idcardshow").show();
                $(".Block1").hide();
                $(".Block2").hide();
                $(".ekycQrScanblock").hide();
                $(".uidDivBlock").hide();
               
                if($(this).attr('ScanQRCode') == 'true'){
 		            $(this).attr('checked', false)
 		        }
 				if($(this).attr('eKyc') == 'true'){
 		            $(this).attr('checked', false)
 		        }
                
            }
 			if($(this).attr("value")=="NoID"){
 				
 				/* if($(this).attr('ScanQRCode') == 'true'){
 		            $(this).attr('checked', false)
 		        }
 				if($(this).attr('eKyc') == 'true'){
 		            $(this).attr('checked', false)
 		        } */
 				 $(".idcardshow").hide();
 				$(".uidDivBlock").hide();
                $(".Block1").hide();
                $(".Block2").hide();
                $(".ekycQrScanblock").hide();
                $(".idcardshow").hide();
            }
        });
    });

</script>

<%
String errorMsg = "";
String donorName=" ";
String uid=" ";
String fatherName=" ";
int gender=0;
String dateOfBirth="";
String mobNo="";
int occupation=0;
String orgnization="";
String organization="";
String telephone="";
String lane="";
String landMark="";
String email="";
String genderName="";
String age="";
String housoNo="";
String pincode="";
int state=0;
long district=0;
long taluk=0;
int lsg=0;
int village=0;
long postoffice=0;
int identityId=0;
String IdCardNo="";
String donorRegNo="";
String donoruniqueNo="";
String uhidNo="";
String relativeName="";


//errorMsg = "BloodBagNo. ";
int donationhdId = 0;
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
 	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
 	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
 	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
 	List<MasState> stateList = new ArrayList<MasState>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasTaluk> talukList = new ArrayList<MasTaluk>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasPostCode> postcodeList = new ArrayList<MasPostCode>();
	List<MasVillage> villageList = new ArrayList<MasVillage>();
	List<MasLsg> lsgList=new ArrayList<MasLsg>();
	List<MasIdCard> idList = new ArrayList<MasIdCard>();
	
	List<BloodDonationEntryHeader> donationList=new ArrayList<BloodDonationEntryHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	int bloodGroupId=0;
	boolean donorStatus=false;
	String rhFactor="";
	if(null !=map.get("donorStatus")){
		donorStatus=(Boolean)map.get("donorStatus");
	}
	
	if(map.get("donationList")!=null){
		donationList=(ArrayList)map.get("donationList");
		
		for(BloodDonationEntryHeader donor:donationList){
			donorName=donor.getDonerName();
			if(null !=donor.getMobNo() && !donor.getMobNo().equals(""))
			mobNo=donor.getMobNo();
			
			if(null !=donor.getSex())
			gender=donor.getSex().getId();
			
			uid=donor.getUhidNo();
			/* occupation=donor.getOccupation().getId(); */
			if(null !=donor.getDateOfBirth())
			dateOfBirth=HMSUtil.convertDateToStringTypeDateOnly(donor.getDateOfBirth())  ;
			
			
			//System.out.print("@@@@@###  mobNo "+mobNo);
			uid=donor.getUhidNo();
			fatherName=donor.getFatherName();
			if(null !=donor.getOrganization())
			 orgnization=donor.getOrganization();
			telephone=donor.getTelNo();
			
		landMark=donor.getLandMark();
		
		if(null !=donor.getEmail())
		 email=donor.getEmail();
		 age=donor.getAge();
		 housoNo=donor.getHouseAptNo();
		 if(null !=donor.getPinCode())
		 pincode=donor.getPinCode();
		 
		 if(null !=donor.getState())
		 state=donor.getState().getId();
		 
		 if(null !=donor.getDistrict())
		  district=donor.getDistrict().getId();
		 
		 if(null !=donor.getSubDistrict())
		 taluk=donor.getSubDistrict();
		 
		 if(null !=donor.getPostOffice())
		  postoffice=donor.getPostOffice().getId();
		 
		 if(null !=donor.getIdentityCard())
		 identityId=donor.getIdentityCard().getId();
		  IdCardNo=donor.getIdentityCardNo();
		  donorRegNo=donor.getDonationNo();
		  donoruniqueNo=""+donor.getId();
		  if(null !=donor.getBloodGroup())
		  bloodGroupId=donor.getBloodGroup().getId();
		  
		  if(null !=donor.getOccupation())
			  occupation=donor.getOccupation().getId();
		/*  lsg=donor.getl; */
		/*  village=donor.get; */
			
		  rhFactor=donor.getRhFactor();
		if(rhFactor !=null && !rhFactor.equals("")){
			rhFactor=rhFactor;
		}
		if(null !=donor.getUhidNo() && !donor.getUhidNo().equals("") ){
			uhidNo=donor.getUhidNo() ;
		}
		if(null !=donor.getHin() && null !=donor.getHin().getFatherMotherName())
		relativeName=donor.getHin().getFatherMotherName();
		}
		
	}
	if(map.get("villageList") != null){
		villageList= (ArrayList) map.get("villageList");
		}
	if(map.get("lsgList") != null){
		lsgList= (ArrayList) map.get("lsgList");
		}
		if(map.get("idList") != null){
			idList= (ArrayList) map.get("idList");
			}
	if(map.get("occupationList") != null){
	occupationList= (ArrayList) map.get("occupationList");
	}
	if(map.get("postcodeList") != null){
		postcodeList= (ArrayList) map.get("postcodeList");
		}
	if(map.get("districtList") != null){
		districtList= (ArrayList) map.get("districtList");
		}
	if(map.get("talukList") != null){
		talukList= (ArrayList) map.get("talukList");
		}
	if(map.get("donationhdId") != null){
		donationhdId=(Integer)map.get("donationhdId");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (ArrayList)map.get("bloodGroupList");
	}
	if(map.get("employeeList") != null){
	    employeeList =(ArrayList) map.get("employeeList");
	}
	if(map.get("sexList") != null){
		sexList= (ArrayList) map.get("sexList");
	}
	if(map.get("stateList") != null){
		stateList= (ArrayList) map.get("stateList");
	}
	
	
	String donoruhid = "";
	if(map.get("donoruhid")!=null){
		donoruhid = (String)map.get("donoruhid");
	}
	
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
		}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1];
	String message ="";
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4>
	<span><%=message %></span>
</h4>
<%} %>
<%

		String donationSeqNo="";
		if(map.get("donationSeqNo") != null){
			donationSeqNo = (String)map.get("donationSeqNo");
		}
%>
<div class="Block">
<%if(!donorStatus) {%>
<div class="titleBag">
<h2>Search</h2>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<form name="bloodsearch" method="post">
	
		<label>UHID</label> 
		
		<input type="text" tabindex="1" id="hinNo1"
			name="<%=HIN_NO %>" maxlength="25" value=""
			onkeypress="return searchKeyPress(event);" /> 
				
			
			<label>Name</label> <input
			type="text" id="pFirstNameId" name="<%=P_FULL_NAME %>" value=""
			tabindex="1" title=" Name of the Patient" validate="" MAXLENGTH="15"
			onkeypress="return searchKeyPress(event);" /> <label>LSG
			Name </label> <select name="<%=LSG_NAME %>" id="lsgNameId" tabindex="1"
			validate="LSG Name,metachar,no">
			<option value="0">Select</option>
		</select>
		<div class="clear"></div>
		<label>Ward</label> <input type="text" name="<%=WARD %>" value=""
			maxlength="32" tabindex="1" id="wardId" onblur="" /> <label>Locality</label><select
			name="<%=LOCALITY %>" id="locality" tabindex="1">
			<option value="0">Select</option>
		</select> <label>House No.</label> <input type="text" name="<%=HOUSE_NO %>"
			value="" maxlength="32" tabindex="1" id="houseId" onblur="" />
		<div class="clear"></div>
		<label>DOB</label> <input type="text" id="dobId" name="dob"
			tabindex="1" value="" class="date" readonly="readonly" MAXLENGTH="30" validate="DOB,date,no"/>

		<div id="dobcalId">
			<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0"
				onclick="setdate('<%=currentDate %>',document.search.dob,event)"
				validate="currentDate,date,no" tabindex="1" />
		</div>

		<input type="hidden" tabindex="1" name="dobIdTemp" id="dobIdTemp"
			value="" /> <label>Age From</label><select id="fromAge" name="fromAge" validate="Age,date,no"
			tabindex="1">
			<option value="">select</option>
			<%for (int i=0;i<150;i++){%>

			<option value="<%=i%>"><%=i%></option>
			<%}%>
		</select> <label>To</label> <select id="toAge" name="toAge" tabindex="1" validate="To Date,date,no">
			<option value="">select</option>
			<%for (int i=1;i<150;i++){%>
<option value="<%=i%>"><%=i%></option>
			<%}%>
		</select>
		<div class="clear"></div>
		<label>Mobile No</label> <input type="text" tabindex="1" name="mobno" id="mobno"
			maxlength="10" value="" onkeypress="return searchKeyPress(event);" />

		<label>Land Line No.</label> <input type="text" tabindex="1"
			name="llno1" class="" /> <label>Ration
			Card No.</label><input type="text" tabindex="1" style="margin-right: 10px;"
			name="rationCardno" />
		<div class="clear"></div>

		<input type="button" tabindex="1" id="btnSearchvisit" value="Search"
			class="button"
			onclick="submitForm('bloodsearch','/hms/hms/bloodBank?method=showSearchPatientRecordsForVisitJsp')" />
		<input type="reset" tabindex="1" name="Reset" value="Cancel"
			class="button"
			onclick="submitProtoAjax('search','registration?method=getPatientName')"
			accesskey="r" /> 	
	<div class="clearMargin"></div>
	<div class="division"></div>

	<%} %>
	
	<%List<Patient> searchDataList=new ArrayList<Patient>();
String pname="";
String pgender="";
String patientage="";
String pstatus="";

int currentPage=0;
int noOfPages=0;

String shinNo = "";
String sfullName ="";
String smobNo="";
String sdateOfBirth="";

String houseNo="";
String streetName="";
String District="";

String fullName="";

String address="";

/* Map<String, Object> getDataMap = new HashMap<String, Object>(); */

Map<Integer,Object> addressmap=new HashMap<Integer,Object>();
List<PatientAddress> searchAddressList = new ArrayList<PatientAddress>();
if(null!=map.get("addressmap")){
	addressmap=(Map<Integer,Object>)map.get("addressmap");
}

if(null !=map.get("currentPage")){
currentPage=(Integer)map.get("currentPage");
shinNo=(String)map.get("shinNo");
sfullName=(String)map.get("fullName");

smobNo=(String)map.get("smobNo");
noOfPages=(Integer)map.get("noOfPages");
sdateOfBirth=""+(Date)map.get("sdateOfBirth");
}
	if(null !=map.get("searchDataList")){
		searchDataList=(List<Patient>)map.get("searchDataList");
	
	if(null !=searchDataList && searchDataList.size()>0){%>

	<table class="tableTrhighlights">
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
			<th>UHID Print Status</th>
		</tr>
		<%for(Patient patient:searchDataList){
			
			if(patient.getPFirstName()!=null)
			pname=patient.getPFirstName();
			if(null !=patient.getSex()){
			pgender=patient.getSex().getAdministrativeSexName();
			}
			if(null!=patient.getAge())
			patientage=String.valueOf(patient.getAge());
			pstatus=patient.getStatus()!=null?patient.getStatus():"N";
			
			if(null!=addressmap.get(patient.getId())){
				if(null != searchAddressList){
					searchAddressList.clear();
				}
			searchAddressList=(List<PatientAddress>)addressmap.get(patient.getId());
			if(null!=searchAddressList && searchAddressList.size()>0){
				
				 houseNo="";
				 streetName="";
				 District="";
				// taluk="";
				for(PatientAddress paddress:searchAddressList){
					if(null!=paddress.getHouseNo())
					houseNo=paddress.getHouseNo();
					if(null!=paddress.getStreetRoad())
					streetName=paddress.getStreetRoad();
					if(paddress.getDistrict()!=null){
						District=paddress.getDistrict().getDistrictName();
					}
					if(paddress.getTaluk()!=null){
					//	taluk=paddress.getTaluk().getTalukName();
					}
					address=houseNo+"   "+streetName+"  "+taluk+"  "+District;
				}
				
			}
			}%>
		<tr onclick="populateDonorRegistrationFrom('<%=patient.getHinNo()%>');HighLightTR(this)" style="cursor: pointer;">


			<td><%=patient.getHinNo()%></td>
			<td><%=pname%></td>
			<td><%=pgender%></td>
			<td><%=patientage%></td>
			<td><%=address %></td>
			<td><%=pstatus%></td>
		</tr>
		<%}%>
		
		
		
		<%-- <script type="text/javascript">
<%
if(null != pUhid && !pUhid.equals("")){

%>
ajaxFunctionForPopulatePatientInfoForVisit('patientVisitSearch','<%=pUhid%>');

<%}%>

</script>
 --%>
	</table>
	
	
	<%if(currentPage !=1){%>

	<a
		href="/hms/hms/bloodBank?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPage-1%>&hinNo=<%=shinNo%>&fn=<%=sfullName%>&moNo=<%=smobNo%>&bitD=<%=sdateOfBirth%>">Previous</a>


	<%}

if(noOfPages>=1){
	// for(int i=1;i<=noOfPages;i++){
		//if(currentPage==i){%>
	<%-- <%=i%>
	<%}else{%>
 --%>

	<a
		href="/hms/hms/bloodBank?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPage%>&hinNo=<%=shinNo%>&fn=<%=sfullName%>&moNo=<%=smobNo%>&bitD=<%=sdateOfBirth%>"><%=currentPage%></a>
	<%
	/* }
	} */
}
if(currentPage <noOfPages){%>

	<a
		href="/hms/hms/bloodBank?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPage+1%>&hinNo=<%=shinNo%>&fn=<%=sfullName%>&moNo=<%=smobNo%>&bitD=<%=sdateOfBirth%>">Next</a>
	</td>



	<%}%>
	<div class="Block">
	<input type="text" id="inPage" maxlength="4" style="width:30px;"/>
	<input type="button" value="Go" onclick="searchParticularPage()"/><label> No of Pages :  <%=noOfPages%></label>
   </div>
	<%}
	
	else{%>
	<!-- <h4>No Record Found</h4> -->
	<font size="4" color="red">No Record Found </font>
	<%}}%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>	
<form name="bloodDonationEntry" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="titleBg">
<h2>Donor Registration</h2>
</div>
<input type="hidden" name="registerNum" value="<%=donoruhid%>" validate="registerNum,metachar,no"/>
<input type="hidden" name="donorSerialNum" value="<%=donoruniqueNo%>" validate="donorSerialNum,metachar,no"/>
<div class="Block">

<label>Autologous Donor</label> <input type="radio" class="inputRadiobutton"
			name="<%=DONER_TYPE %>" value="autologus" tabindex=1 validate="donerType,metachar,no"/> <label>Allogenic
			Donor</label> <input type="radio" class="inputRadiobutton" name="<%=DONER_TYPE %>"
			checked="checked" value="allogenic" tabindex=1 validate="donerType,metachar,no"/>

<div id="qrscan" style="position:relative;">
<div class="clear"></div>
		<label>Aadhaar </label> <input type="radio" class="inputRadiobutton"
			value="aadhaarID" onclick="" checked="checked" name="idtype"
			align="right" tabindex=1 validate="idtype,metachar,no"/> 
			<label>Other ID</label> <input
			type="radio" value="otherID" onclick=""
			name="idtype" align="right" tabindex=1 validate="idtype,metachar,no" style="margin-right:10px;"/> 
			
			<label>No ID </label> <input
			type="radio" value="NoID" onclick="" name="idtype"
			align="right" tabindex=1 validate="idtype,metachar,no" style="margin-right:10px;" />

<div class="flsDiv290">
		<jsp:include page="testImageUpload.jsp">
			<jsp:param value="" name="" />
		</jsp:include>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
		<div class="ekycQrScanblock" id="showAadharDiv">
		<div class="clear"></div>
		<label>QR SCAN</label> <input type="radio" class="inputRadiobutton"
				value="ScanQRCode" onclick="" name="selectid" align="right"
				tabindex=1 validate="QR SCAN,metachar,no"/> 
				<label>eKYC</label> <input type="radio"
				class="inputRadiobutton" value="eKyc" name="selectid" onclick=""
				align="right" tabindex=1 validate="eKYC,metachar,no"/>
		</div>
		<div class="clear"></div>	
		
		<div class="Block1" id="ekycId" style="display: none">
			<label>Aadhaar Number</label> <input type="text" MAXLENGTH="20"
				name="" value="" tabindex=1 validate="Aadhar Number,metachar,no"/> <input type="button"
				class="buttonBig" value="BIOMTRIC SCAN" onclick="" checked="checked"
				align="right" tabindex=1 />
			<input type="button" class="button" value="SEARCH" onclick=""
				align="right" tabindex=1 />
		</div>
		<div class="Block2" id="qrscanId" style="display: none">
			<input type="button" class="button" value="QR SCAN"
				onclick="submitForm('bloodDonationEntry','bloodBank?method=submitBloodDonationEntry')"
				align="right" tabindex=1 />
		</div>

		<div class="clear"></div>
		<div class="idcardshow" style="display: none">
			<label>Identity card<span>*</span></label> <select
				id="identityCardType" name=<%=Identity_Card %> tabindex="1" validate="identityCard,metachar,no">

				
				<%
				if(identityId>0){
				if(null!=idList){
				for(MasIdCard mlc:idList){
					if(identityId==mlc.getId()){%>

				<option value="<%=mlc.getId()%>"><%=mlc.getIdCardName()%></option>
<% break;}}}		
				}
				else{
					if(null!=idList){
						for(MasIdCard mlc:idList){
						%>
						<option value="<%=mlc.getId()%>"><%=mlc.getIdCardName()%></option>
		<% 
		
							}
						}		}
				%>
			</select>	
		
			 <label>ID No </label> <input id="idNo" name="<%=ID_NO %>"
				type="text" value="<%=IdCardNo %>" title="Blood Donation No." tabindex=1 validate="metachar,idNo,no"/>
		</div>
		<div class="clear"></div>
		<% if(null !=donationList && donationList.size()>0){ %>
		<div class="uidDivBlock">
			<label>UHID <span>*</span></label> 
			<input  name="<%=UID%>" type="text" id="dUhidId" readonly="readonly"
				value="<%=uhidNo%>" maxlength="23" tabindex=1 validate="UHID,String,no"/>
				<%-- <input id="uidNo" name="<%=UID%>" type="text"
				value="<%=uid %>" onblur="ajaxFunctionForDonor('bloodDonationEntry,this.value');"
				maxlength="15" tabindex=1 /> --%>
		</div>
		
 <label>Name<span>*</span></label> <input id="donorName" type="text" name="<%=DONOR_NAME%>" readonly="readonly"
 validate="Donor Name,string,yes" value="<%=donorName %>" MAXLENGTH="30" tabindex=1 validate="donorName,metachar,yes"/>

<input id="hinId" name="<%=HIN_ID %>" type="hidden" value="" tabindex=1 validate="hinId,int,no"/> 
<input id="uId" name="<%=UID%>" type="hidden" value=""	tabindex=1 validate="uId,metachar,no"/> 
<div class="clear"></div>			
			<label>Father/Husband's Name</label> <input
			type="text" id="relationNameId" validate="Father's/Husband's Name,string,no" 
			name="<%=FATHER_NAME%>" value="<%=relativeName%>" readonly="readonly"
			 MAXLENGTH="30" tabindex=1 validate="fatherName,String,no"/> 			
			<label>Gender<span>*</span></label> 
			<select id="genderId" name="<%=SEX_ID %>" validate="sexId,metachar,yes" tabindex="1" disabled="disabled">			
            <option value="">Select</option>
			<%if(sexList != null){ 
				for (MasAdministrativeSex administrativeSex:sexList) {
				         if(gender>0 && administrativeSex.getId()==gender){
				         	genderName=administrativeSex.getAdministrativeSexName();%>
				         	<option value="<%=gender %>" selected="selected"><%=genderName %></option>
				         	<% }else{%>
				        <option value="<%=administrativeSex.getId() %>" ><%=administrativeSex.getAdministrativeSexName() %></option> 
				       <% }}}%>   
		</select> 
<div class="clear"></div>		
		<label>Date Of Birth<span>*</span></label> 
		<%-- <input type="text" id="dobId"
					name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""
					   onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
					   onchange="calculateAgeInAjax()"
					   MAXLENGTH="10"  validate="DOB,string,yes" class="date"
						 /> --%>
		
		
		<input type="text" id="BirthDateId" name="<%=DATE_OF_BIRTH%>"
			value="<%=dateOfBirth%>" MAXLENGTH="10" readonly="readonly"			
			onkeyup="mask(this.value,this,'2,5','/');" 
			 onblur="calculateAgeInAjax()"
			tabindex="1" validate="dateOfBirth,date,yes"/> 
			
			<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			 onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=DATE_OF_BIRTH%>,event)" /> --%>


		<%--  <label><span>*</span> Donor Name</label> <input
	id="donorName" type="text" name="<%= DONOR_NAME%>" value=""
	validate="Donor Name,string,yes" MAXLENGTH="20" tabindex=1 />
 --%>

		<label>Age</label> 
		<input class="dateTextSmall" id="ageId" readonly="readonly"
		name="<%=AGE %>" id="ageId" type="text" validate="Age,metachar,yes" value="<%=age %>" tabindex="1"/>
			
			 <label class="auto">Year</label>
			
			<%-- <select id="year"
			name=<%=YEAR %> tabindex="1">
			<option value="0">Year</option>
			<option value="2015"><%=2015 %></option>

		</select> --%>

		<div class="clear"></div>
		<label>Mobile No<span>*</span></label> 
		<input type="text"  name="<%=MOBILE_NO %>" id="mobileNoId" onblur="IsMobileNumber(this.value)"
			 validate="Mobile No.,metachar,yes" value="<%=mobNo %>" 
			 maxlength="10"
			tabindex="1" />
			
			<%-- <input id="mobNo" name="<%=MOBILE_NO %>"
			type="text" validate="Mobile No.,phone,no" value="<%=mobNo %>"
			onblur="ajaxFunctionForDonor(bloodDonationEntry);" maxlength="15"
			value="" tabindex="1" /> --%>


		<%-- <label>Husband's Name</label> <input type="text"
	name="<%= HUSBAND_NAME%>" value="" validate="Husband's Name,string,no"
	MAXLENGTH="20" tabindex=1 />  --%>

		<label> Occupation</label> <select id="occupationId" disabled="disabled"
			name=<%=OCCUPATION_ID %> tabindex=1 validate="Occupation,metachar,no">
			<option value="0">Select</option>

			<%if(occupationList != null){ 	
				     for (Iterator iter = occupationList.iterator(); iter.hasNext();) {
				       MasOccupation masOccupation = (MasOccupation) iter.next();
				       if(occupation==masOccupation.getId()){
				        %>
				<option value="<%=masOccupation.getId() %>"  selected="selected"><%=masOccupation.getOccupationName() %></option>
				    <%}else{%>
				    <option value="<%=masOccupation.getId() %>" ><%=masOccupation.getOccupationName() %></option>
				   <% }
				       
				     }}  %>
				    
		</select>
		
<div class="clear"></div>		
<label>Organization</label>
		<input type="text" value="<%=orgnization %>" name="<%=ORGANIZATION%>" id="organization" disabled="disabled"
			onkeyup="chkLength(this,30);" tabindex="1" validate="Organization,metachar,no"/>		

		<label>Telphone No
		</label>  <input id="teleNo"
			name="<%=TELE_NO %>" type="text" maxlength="10" readonly="readonly"
			 tabindex="1" value="<%=telephone %>" validate="Telephone No,metachar,no"/>

		<label>House/Apt/Bldg No. </label> <input id="houseNo" readonly="readonly"
			name="<%=House_NO%>" type="text" value="<%=housoNo%>" maxlength="15" value=""
			tabindex="1" validate="houseNo,metachar,no"/>
		<div class="clear"></div>	
		<label>Street/Road/Lane </label> <input id="streetNo" readonly="readonly"
			name="<%=Street_NO %>" type="text"  maxlength="15" value="<%=lane %>"
			tabindex="1" validate="streetNo,metachar,no"/> 				
			
			<label>Land Mark </label> <input id="landmark" readonly="readonly"
			name="<%=Land_Mark %>" type="text" maxlength="15" value="<%=landMark %>"
			tabindex="1" validate="landmark,metachar,no"/> 
			
			<label> State</label> 
			<select id="stateId" name=<%=STATE_ID %> tabindex="1" disabled="disabled"
			validate="stateId,metachar,no" onchange="Javascript: populateDistrictByStateId(this.value);"  >
			<%if(stateList != null){ 	
				     for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				        MasState masState = (MasState) iter.next();
				         				
				         	if(state == 0 && masState.getStateName().equalsIgnoreCase("Kerala")){ %>
					<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
							<%}else if (state>0 && state== masState.getId() ){%>
							<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
				         
				         		<% }
							else{%>
									<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
							<%}
				        			}
				        		 }  %>
		</select>
		<div class="clear"></div>	
		<label> District</label> 
		<select id="districtId" name="<%=DISTRICT_NAME%>" tabindex="1" validate="District,metachar,no" disabled="disabled"
		 onChange="Javascript: donorDistrictByDistrictId(this.value);donorPincodeByDistrict(this.value);">
			<option value="">Select</option>

			 <%if(districtList != null){ 	
				      for (Iterator iter = districtList.iterator(); iter.hasNext();) {
				         MasDistrict masdistrict = (MasDistrict) iter.next();
				         if(district>0 && masdistrict.getId()==district){%>
				       <option value="<%=masdistrict.getId() %>" selected="selected"><%=masdistrict.getDistrictName() %></option>
				        	 
				        <%}else{
				         
				         %>
				         
			<option value="<%=masdistrict.getId() %>"><%=masdistrict.getDistrictName() %></option>
				         			<%}}} %> 
				       
		</select>		
		
		 <label>Taluk</label> <select id="subdistrictId" disabled="disabled"
			name="<%=Sub_District_NAME%>" tabindex="1" validate="Taluk,metachar,no">
			<option value="0">Select</option>

			 <%
				         		if(talukList != null){ 	
				         			for (Iterator iter = talukList.iterator(); iter.hasNext();) {
				         				MasTaluk masTaluk = (MasTaluk) iter.next();
				         				if(taluk>0 && taluk==masTaluk.getId()){
				         					
				         %>
			<option value="<%=masTaluk.getId() %>"  selected="selected"><%=masTaluk.getTalukName() %></option>
			<%		
				        			}
				         				else{%>
			<option value="<%=masTaluk.getId() %>"  ><%=masTaluk.getTalukName() %></option>	
				         				<%}
				         			}
				        		 } 
				        %> 
		</select>
		
		
		 <label>LSG Name</label> 
		
		<select id="lsgTypeId" name="<%=Lsg_Type %>" tabindex="1" disabled="disabled" validate="lsgType,metachar,no"> 
			
			<option value="0">Select</option>
		<% 	if(null!=lsgList){
		for(MasLsg mlg:lsgList){
		
		%>
			<option value="<%=mlg.getId() %>"><%=mlg.getLsgTypeName() %></option>
			<%}} %>
		</select> 
		<div class="clear"></div>	
		
	
	 <label>Post Office</label> <select id="postOfficeId" disabled="disabled"
			name="<%=Post_Office_Name %>"  validate="postOfficeName,metachar,no" tabindex="1" onchange="donorpopulatePinCode(this.value);">
			<option value="">Select</option>
			<% if(postcodeList != null){ 	
				        for (MasPostCode maspostcode:postcodeList) {
				        if(postoffice>0 && postoffice==maspostcode.getId()){
				        %>
	<option value="<%=maspostcode.getId() %>" selected="selected"><%=maspostcode.getPostCodeName()%></option>
				        	<%}else{%>
	<option value="<%=maspostcode.getId() %>" ><%=maspostcode.getPostCodeName()%></option>
				        		<%}}}%>
			
	        
		</select>
		<label>Pincode</label> <input id="pincodeId" name="<%=Pincode %>" type="text" value="<%=pincode %>" readonly="readonly"
			maxlength="15"  tabindex="1" validate="pincode,int,no"/>
		
		 <label>Email </label>
		 <input id="emailId" name="<%= EMAIL %>"
			type="text"  maxlength="30" value="<%=email%>"  readonly="readonly" tabindex="1" validate="email,string,no"/> 
			
<div class="clear"></div>	
		

		<label> Blood Group</label> <select id="bloodGroupId" disabled="disabled"
			name=<%=BLOOD_GROUP_NAME %> tabindex="1" validate="bloodGroupName,string,no" >
			<option value="" >Select</option>

			<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         				
				         				if(bloodGroupId>0 && bloodGroupId==bloodGroup.getId()){
				         %>
			<option value="<%=bloodGroup.getId() %>" selected="selected"><%=bloodGroup.getBloodGroupName()%></option>
			<%		} 
				         				else{%>
		<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>	
				         				<%}
				         				
				         			} }%>
		</select> 
		
<%-- <label> Rh Factor</label>
		<input type="text" name="RhFactor" value=" <%=rhFactor %>" id="patientRhId" style="width: 75px;font-weight: bold;"  readonly="readonly" /> --%>
		 <label> Rh Factor</label> <select id="rhbloodGroupId" disabled="disabled"
			name="RhFactor" tabindex="1"  >
			<option value="0">Select</option>
			<option value="-">-ve</option>
			<option value="+">+ve</option>
		</select> 
		<%}else{%>
		
		<div class="uidDivBlock">
			<label>UHID <span>*</span></label> 
			<input  name="<%=UID%>" type="text" id="dUhidId" readonly="readonly"
				value="<%=uhidNo%>" maxlength="23" tabindex=1 validate="UHID,String,no"/>
				<%-- <input id="uidNo" name="<%=UID%>" type="text"
				value="<%=uid %>" onblur="ajaxFunctionForDonor('bloodDonationEntry,this.value');"
				maxlength="15" tabindex=1 /> --%>
		</div>
		
 <label>Name<span>*</span></label> <input id="donorName" type="text" name="<%=DONOR_NAME%>" 
 validate="Donor Name,string,yes" value="<%=donorName %>" MAXLENGTH="30" tabindex=1 validate="donorName,metachar,yes"/>

<input id="hinId" name="<%=HIN_ID %>" type="hidden" value="" tabindex=1 validate="hinId,int,no"/> 
<input id="uId" name="<%=UID%>" type="hidden" value=""	tabindex=1 validate="uId,metachar,no"/> 
<div class="clear"></div>			
			<label>Father/Husband's Name</label> <input
			type="text" id="relationNameId" validate="Father's/Husband's Name,string,no" name="<%=FATHER_NAME%>" value="<%=relativeName%>"
			 MAXLENGTH="30" tabindex=1 validate="fatherName,String,no"/> 
			
			<label>Gender<span>*</span></label> 
			<select id="genderId" name="<%=SEX_ID %>" validate="sexId,metachar,yes" tabindex="1">
			
<option value="">Select</option>
			<%if(sexList != null){ 
				for (MasAdministrativeSex administrativeSex:sexList) {
				         if(gender>0 && administrativeSex.getId()==gender){
				         	genderName=administrativeSex.getAdministrativeSexName();%>
				         	<option value="<%=gender %>" selected="selected"><%=genderName %></option>
				         	<% }else{%>
				        <option value="<%=administrativeSex.getId() %>" ><%=administrativeSex.getAdministrativeSexName() %></option> 
				       <% }}}%>   
		</select> 
		
<div class="clear"></div>		
		<label>Date Of Birth<span>*</span></label> 
		<%-- <input type="text" id="dobId"
					name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""
					   onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
					   onchange="calculateAgeInAjax()"
					   MAXLENGTH="10"  validate="DOB,string,yes" class="date"
						 /> --%>
		
		
		<input type="text" class="date" 
			id="BirthDateId" name="<%=DATE_OF_BIRTH%>"
			value="<%=dateOfBirth%>" MAXLENGTH="10" 
			
			onkeyup="mask(this.value,this,'2,5','/');" 
			 onblur="calculateAgeInAjax()"
			tabindex="1" validate="dateOfBirth,date,yes"/> 
			
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			 onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=DATE_OF_BIRTH%>,event)" />


		<%--  <label><span>*</span> Donor Name</label> <input
	id="donorName" type="text" name="<%= DONOR_NAME%>" value=""
	validate="Donor Name,string,yes" MAXLENGTH="20" tabindex=1 />
 --%>

		<label>Age</label> 
		<input class="dateTextSmall" id="ageId" name="<%=AGE %>" id="ageId" type="text" validate="Age,metachar,yes" value="<%=age %>" tabindex="1"/>
			
			 <label class="auto">Year</label>
			
			<%-- <select id="year"
			name=<%=YEAR %> tabindex="1">
			<option value="0">Year</option>
			<option value="2015"><%=2015 %></option>

		</select> --%>

		<div class="clear"></div>
		<label>Mobile No<span>*</span></label> 
		<input  name="<%=MOBILE_NO %>" id="mobileNoId" onblur="IsMobileNumber(this.value)"
			type="text" validate="Mobile No.,metachar,yes" value="<%=mobNo %>"
			 maxlength="10"
			tabindex="1" />
			
			<%-- <input id="mobNo" name="<%=MOBILE_NO %>"
			type="text" validate="Mobile No.,phone,no" value="<%=mobNo %>"
			onblur="ajaxFunctionForDonor(bloodDonationEntry);" maxlength="15"
			value="" tabindex="1" /> --%>
 

		<%-- <label>Husband's Name</label> <input type="text"
	name="<%= HUSBAND_NAME%>" value="" validate="Husband's Name,string,no"
	MAXLENGTH="20" tabindex=1 />  --%>

		<label> Occupation</label> <select id="occupationId"
			name=<%=OCCUPATION_ID %> tabindex=1 validate="Occupation,metachar,no">
			<option value="0">Select</option>

			<%if(occupationList != null){ 	
				     for (Iterator iter = occupationList.iterator(); iter.hasNext();) {
				       MasOccupation masOccupation = (MasOccupation) iter.next();
				       if(occupation==masOccupation.getId()){
				        %>
				<option value="<%=masOccupation.getId() %>"  selected="selected"><%=masOccupation.getOccupationName() %></option>
				    <%}else{%>
				    <option value="<%=masOccupation.getId() %>" ><%=masOccupation.getOccupationName() %></option>
				   <% }
				       
				     }}  %>
				    
		</select>
		<div class="clear"></div>
		<label>Organization</label>
		<input type="text" value="<%=orgnization %>" name="<%=ORGANIZATION%>" id="organization"
			onkeyup="chkLength(this,30);" tabindex="1" validate="Organization,metachar,no"/>

		<label>Telphone No</label>  <input id="teleNo"
			name="<%=TELE_NO %>" type="text" maxlength="10" tabindex="1" value="<%=telephone %>" validate="Telephone No,metachar,no"/>


		<label>House/Apt/Bldg No. </label> <input id="houseNo"
			name="<%=House_NO%>" type="text" value="<%=housoNo%>" maxlength="15" value=""
			tabindex="1" validate="houseNo,metachar,no"/>
		
<div class="clear"></div>
		<label>Street/Road/Lane </label> <input id="streetNo"
			name="<%=Street_NO %>" type="text"  maxlength="15" value="<%=lane %>"
			tabindex="1" validate="streetNo,metachar,no"/> 
					
			<label>Land Mark </label> <input id="landmark"
			name="<%=Land_Mark %>" type="text" maxlength="15" value="<%=landMark %>"
			tabindex="1" validate="landmark,metachar,no"/> 
			
			<label> State</label> 
			<select id="stateId" name=<%=STATE_ID %> tabindex="1" validate="stateId,metachar,no" onchange="Javascript: populateDistrictByStateId(this.value);"  >
			<%if(stateList != null){ 	
				     for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				        MasState masState = (MasState) iter.next();
				         				
				         	if(state == 0 && masState.getStateName().equalsIgnoreCase("Kerala")){ %>
					<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
							<%}else if (state>0 && state== masState.getId() ){%>
							<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
				         
				         		<% }
							else{%>
									<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
							<%}
				        			}
				        		 }  %>
		</select>
		<div class="clear"></div>
		<label> District</label> 
		<select id="districtId" name="<%=DISTRICT_NAME%>" tabindex="1" validate="District,metachar,no"
		 onChange="Javascript: donorDistrictByDistrictId(this.value);donorPincodeByDistrict(this.value);">
			<option value="">Select</option>

			 <%if(districtList != null){ 	
				      for (Iterator iter = districtList.iterator(); iter.hasNext();) {
				         MasDistrict masdistrict = (MasDistrict) iter.next();
				         if(district>0 && masdistrict.getId()==district){%>
				       <option value="<%=masdistrict.getId() %>" selected="selected"><%=masdistrict.getDistrictName() %></option>
				        	 
				        <%}else{
				         
				         %>
				         
			<option value="<%=masdistrict.getId() %>"><%=masdistrict.getDistrictName() %></option>
				         			<%}}} %> 
				       
		</select>
				
		 <label>Taluk</label> <select id="subdistrictId"
			name="<%=Sub_District_NAME%>" tabindex="1" validate="Taluk,metachar,no">
			<option value="0">Select</option>

			 <%
				         		if(talukList != null){ 	
				         			for (Iterator iter = talukList.iterator(); iter.hasNext();) {
				         				MasTaluk masTaluk = (MasTaluk) iter.next();
				         				if(taluk>0 && taluk==masTaluk.getId()){
				         					
				         %>
			<option value="<%=masTaluk.getId() %>"  selected="selected"><%=masTaluk.getTalukName() %></option>
			<%		
				        			}
				         				else{%>
			<option value="<%=masTaluk.getId() %>"  ><%=masTaluk.getTalukName() %></option>	
				         				<%}
				         			}
				        		 } 
				        %> 
		</select>		
		
		 <label>LSG Name</label> 
		
		<select id="lsgTypeId" name="<%=Lsg_Type %>" tabindex="1" validate="lsgType,metachar,no">
			
			<option value="0">Select</option>
		<% 	if(null!=lsgList){
		for(MasLsg mlg:lsgList){
		
		%>
			<option value="<%=mlg.getId() %>"><%=mlg.getLsgTypeName() %></option>
			<%}} %>
		</select> 
		<div class="clear"></div>		
	
		 <label>Post Office</label> <select id="postOfficeId" 
			name="<%=Post_Office_Name %>"  validate="postOfficeName,metachar,no" tabindex="1" onchange="donorpopulatePinCode(this.value);">
			<option value="">Select</option>
			<% if(postcodeList != null){ 	
				        for (MasPostCode maspostcode:postcodeList) {
				        if(postoffice>0 && postoffice==maspostcode.getId()){
				        %>
	<option value="<%=maspostcode.getId() %>" selected="selected"><%=maspostcode.getPostCodeName()%></option>
				        	<%}else{%>
	<option value="<%=maspostcode.getId() %>" ><%=maspostcode.getPostCodeName()%></option>
				        		<%}}}%>
			
	        
		</select>
		<label>Pincode</label> <input id="pincodeId" name="<%=Pincode %>" type="text" value="<%=pincode %>"
			maxlength="15"  tabindex="1" validate="pincode,int,no"/>		
		 
		 <label>Email </label>
		 <input id="emailId" name="<%= EMAIL %>"
			type="text"  maxlength="30" value="<%=email%>" tabindex="1" validate="email,string,no"/>		

<div class="clear"></div>
		<label>Blood Group</label> <select id="bloodGroupId"
			name=<%=BLOOD_GROUP_NAME %> tabindex="1" validate="bloodGroupName,string,no" >
			<option value="" >Select</option>

			<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         				
				         				if(bloodGroupId>0 && bloodGroupId==bloodGroup.getId()){
				         %>
			<option value="<%=bloodGroup.getId() %>" selected="selected"><%=bloodGroup.getBloodGroupName()%></option>
			<%		} 
				         				else{%>
		<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>	
				         				<%}
				         				
				         			} }%>
		</select> 
	
<%-- <label> Rh Factor</label>
		<input type="text" name="RhFactor" value=" <%=rhFactor %>" id="patientRhId" style="width: 75px;font-weight: bold;"  readonly="readonly" /> --%>
		 <label>Rh Factor</label> <select id="rhbloodGroupId"
			name="RhFactor" tabindex="1"  >
			<option value="0">Select</option>
			<option value="-">-ve</option>
			<option value="+">+ve</option>
		</select> 
	<%} %>	
		<div class="clear"></div>

<%if(!donorStatus) {%>
<div id="addDonor">
		<input type="button" class="button" value="Submit" 
			onclick="submitForm('bloodDonationEntry','/hms/hms/bloodBank?method=submitBloodDonationEntry')"
			align="right" tabindex=1 /> 
			<input type="reset"
			class="buttonHighlight" name="Reset" id="reset" value="Reset"
			onclick="resetClicked('bloodDonationEntry')" accesskey="r"
			tabindex=1 /></div>
			<%} %>
			<%if(donorStatus) {%>
			<div id="DonorAssestment">
			 <input type="button" class="button" name="Reset"
			id="assessmentButtonId" value="Assessment"
			onclick="submitForm('bloodDonationEntry','/hms/hms/bloodBank?method=showDonorAssessmentJsp')" accesskey="r"
			tabindex=1 /> </div>
			<%} %>
			<div id="DonorAssestment" style="display: none">
			 <input type="button" class="button" name="Reset"
			id="assessmentButtonId" value="Assessment"
			onclick="submitForm('bloodDonationEntry','/hms/hms/bloodBank?method=showDonorAssessmentJsp')" accesskey="r"
			tabindex=1 /> </div>
			<!-- <input type="button" class="buttonBig2" name="Reset"
			id="physicalExamButtonId" value="Physical Examination"
			onclick="resetClicked('bloodDonationEntry','bloodBank?method=showPhysicalExaminationJsp')"
			accesskey="r" tabindex=1 />  -->
			
</div>
</div>

	<script type="text/javascript">
	/* function selectRhValue(){
		var rhvalue=document.getElementById("patientRhId");
		if(rhvalue !=""){
		document.getElementById("rhbloodGroupId").value=rhvalue;
		}
		
	} */
function preDonated(formName){
if(document.getElementById('preDonate').value =="n"){
document.getElementById('noOfTimes').disabled=true;
document.getElementById('lastDateId').disabled=true;
document.getElementById('lastMealTime').disabled=true;
}else{
document.getElementById('noOfTimes').disabled=false;
document.getElementById('lastDateId').disabled=false;
document.getElementById('lastMealTime').disabled=false;
}
}

</script>

	<!-- <div class="paddingTop40"></div> -->
</form>

<div class="clear"></div>

<!-- <div class="Block">
	<input type="button" class="buttonBig" value="Print Registration Slip"
	onclick="if(checkFilledRow()){submitForm('bloodDonationEntry','bloodBank?method=submitBloodDonationEntry');}"
	align="right" tabindex=1 /> 
</div>-->
<!--Bottom labels starts-->
<div class="bottom">
	<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
		Date</label> <label class="value"><%=currentDate%></label> <label>Changed
		Time</label> <label class="value"><%=time%></label> <input type="hidden"
		name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
		name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<div class="clear"></div>


	<!--Bottom labels starts-->
	<!--main content placeholder ends here-->
</div>

<script type="text/javascript">

function searchParticularPage(){
	var curPage=document.getElementById("inPage").value;
	var fname=document.getElementById("pFirstNameId").value;
	var hinNo1=document.getElementById("hinNo1").value;
	var dobId=document.getElementById("dobId").value;
	var fromAge=document.getElementById("fromAge").value;
	var toAge=document.getElementById("toAge").value; 
	var mobno=document.getElementById("mobno").value;
	//alert("page "+curPage);
	if(isNaN(curPage)){
		curPage=1;
	}
	if(hinNo1==''){
		hinNo1='null';
	}
	if(dobId==''){
		dobId='null';
	}
	if(fromAge==''){
		fromAge=0;
	}
	if(toAge==''){
		toAge=0;
	}
	if(mobno==''){
		mobno='null';
	}
	submitForm('bloodsearch','/hms/hms/bloodBank?method=showSearchPatientRecordsForVisitJsp&page='+curPage+'&hinNo='+hinNo1+'&fn='+fname+'&moNo='+mobno+'&bitD='+dobId);
	//submitForm('search','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page='+curPage+'&hinNo='+hinNo1+'&fn='+fname+'&moNo='+mobno+'&bitD='+dobId+'&toAge='+toAge+'&fromAge='+fromAge+'&visitSearch=serch');
	//submitForm('search','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page='+curPage+'&hinNo='+null+'&fn='++'&moNo='++'&bitD='++'&toAge='++'&fromAge='++'&visitSearch=serch');
	
}


function IsMobileNumber(vall) {
	
    var mob = /^[1-9]{1}[0-9]{9}$/;
    var txtMobile = document.getElementById('mobileNoId');
    if(vall !=""){
    if (mob.test(txtMobile.value) == false) {
        alert("Please enter valid mobile number.");
        document.getElementById('mobileNoId').value="";
        txtMobile.focus();
        return false;
    }
    }
    return true;
}
/* function clearMobileTextField() {
    // Clear forms here
    document.getElementById("mobileNoId").value = "";
}
window.onload = clearMobileTextField; */
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
	/*	if(componentId =="")
		{
	  	 document.getElementById('quantity'+inc).value="";
	     return;
		}
		*/
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentName('bloodDonationEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('quantity'+inc).value = "";
		}
}



		
	function checkBloodBagNoForExisting(bagNoObj, rowCount) 
	{
  	 	var xmlHttp;
     		try {
    			// Firefox, Opera 8.0+, Safari
   	 			xmlHttp=new XMLHttpRequest();
	  		}catch (e){
    		// Internet Explorer
    			try{
     	 			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    			}catch (e){
    				alert(e)
     	 			try{
        				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
     	 			}catch (e){
        				alert("Your browser does not support AJAX!");
        				return false;
      				}
     			}
   			}
    	xmlHttp.onreadystatechange=function()
    	{
     	 	if(xmlHttp.readyState==4){
      		var items =xmlHttp.responseXML.getElementsByTagName('radioIdFlags')[0];
       			for (loop = 0; loop < items.childNodes.length; loop++) 
      			{
	   		    	var item = items.childNodes[loop];
	    	    	var flagValue  = item.getElementsByTagName("flagValue")[0];
	    	    	var checkResult = flagValue.childNodes[0].nodeValue;
	    	    	if(checkResult == 'Duplicate'){
	    	    		
	    	    			alert('Blood Bag No'+ bagNoObj.value + ' already exist.');
	    	    		
	    	    		
	    	    		document.getElementById('bloodBagId'+rowCount).focus();
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='duplicateBloodBagNo';
	    	    		return false;
	    	    	}else{
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='correctBloodBagNo';
						return true;	    	    	
	    	    	}
      			}
    		}
  		}
  		bagNo = bagNoObj.value;
  		// alert(bagNoObj.value);
  		// alert(rowCount);
  		 //return false;
  		var url="/hms/hms/bloodBank?method=checkForExistingBloodBagNo&bagIdToCheck="+bagNo+"&sampleCollectionIdToCheck="+sampleCollectionIdToCheck;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    	xmlHttp.open("GET",url,true);
    	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(null);
  		
	}
	

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('bloodBagId'+i)){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(document.getElementById('componentName'+i).value == ""){
	  				msg += "Component Name can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
function checkForBloodBagNo1(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('bloodBagId'+i).value==val)
		{
			alert("Blood bag already selected...!")
			document.getElementById('bloodBagId'+inc).value=""
			var e=eval(document.getElementById('bloodBagId'+inc)); 
			e.focus();
			return false;
		} }  }
		
		}
}
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
</script>
<script type="text/javascript" language="javascript">
function validateFromToDate(){

	var nowDate=new Date();

	obj1 = eval(document.bloodIssueRegister.fromDate)
	obj2 = eval(document.bloodIssueRegister.toDate)

	if(obj1.value != "" && obj2.value != "")
	{

	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
						return false;
				}
			}

		else
			{
			alert("From Date should not be greater than Current date\n");
			return false;
			}

	}
	return true;
}
</script>
 <script type="text/javascript">
        $category = $('#pcategory');

        $category.change (
            function() {
                $.ajax({
                    type: "GET",
                    url: "GetProductName",
                    data: {category: $category.attr("selectedIndex") },
                    success: function(data){
                        $("#state").html(data)
                    }
                });
            }
        );
    </script>
    <script type="text/javascript">


function calculateAge() {
 
    var lre = /^\s*/;
    var datemsg = "";
    
    var inputDate = document.bloodDonationEntry.<%=DATE_OF_BIRTH%>.value;
    
    
    var split = inputDate.split('/');

    var dd = split[0];
    var mm = split[1];
    var yy = split[2];
     getAge(dd,mm,yy);
    
}
 
function getAge(dd,mm,yy) {
	
    var today = new Date();
    
    var nowyear = today.getFullYear();
    var nowmonth = today.getMonth();
    var nowday = today.getDate();
    
    var birthyear = yy;
    var birthmonth = mm;
    var birthday = dd;
   
    var age = nowyear - birthyear;
    var age_month = nowmonth - birthmonth;
    var age_day = nowday - birthday;
    
    if(age_month < 0 || (age_month == 0 && age_day <0)) {
            age = parseInt(age) -1;
          
        }
    if (age>-1){
    	  document.bloodDonationEntry.<%=AGE %>.value=age;
    	
    }
    else{
    	alert("Enter valid date");
    }
    
    
}
</script> 
<script type="text/javascript">
function calculateAgeInAjax() {

 dob=document.getElementById('BirthDateId').value; 

	if(dob != ""){
		if(checkDonorDob()){
		action="/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="+dob;
		obj = eval('document.bloodDonationEntry')
		       obj.action = action;
	    	   	 var url=action
	 }
var xmlHttp;
try {
  // Firefox, Opera 8.0+, Safari
  xmlHttp=new XMLHttpRequest();
}catch (e){
  // Internet Explorer
  try{
    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }catch (e){
  	alert(e)
    try{
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }catch (e){
      alert("Your browser does not support AJAX!");
      return false;
    }
   }
 }
  xmlHttp.onreadystatechange=function()
  {
    if(xmlHttp.readyState==4){
    	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
    	for (loop = 0; loop < items.childNodes.length; loop++) {
    		
	   	    var item = items.childNodes[loop];
	        var age  = item.getElementsByTagName("age")[0];
	        
	      //  var period  = item.getElementsByTagName("period")[0];
	        var year= item.getElementsByTagName("birthYear")[0];
	       // document.getElementById("yobId").value=year.childNodes[0].nodeValue;
	      // obj=eval(document.getElementById('ageId'));
	       
	       if(age.childNodes[0].nodeValue == "0"){
	      document.getElementById("ageId").value=age.childNodes[0].nodeValue;
	       }else{

		   document.getElementById("ageId").value=age.childNodes[0].nodeValue;
		  
		   		  }
		  // 	document.getElementById('ageUnitId').style.display = 'inline';
		  //  temp =document.getElementById('ageUnitId');
		 //  temp.value=period.childNodes[0].nodeValue
		   document.getElementById("ageId").readOnly = true;
		  // document.getElementById("ageUnitId").readOnly = true;
		   
    	}
    }
  }
  var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

  xmlHttp.open("GET",url,true);
  xmlHttp.setRequestHeader("Content-Type", "text/xml");
  xmlHttp.send(null);

  }
}

</script>

<script type="text/javascript">
<%
System.out.println("donoruhid--"+donoruhid);
if(!donoruhid.equals("")){
%>
ajaxFunctionForDonor('bloodDonationEntry','<%=donoruhid%>');

<%}%>
		history.forward();
</script>

<style>
.flsDiv290{width:290px; height:auto; float:right; position:absolute; right:0px; top:10px; text-align:center;}
</style>