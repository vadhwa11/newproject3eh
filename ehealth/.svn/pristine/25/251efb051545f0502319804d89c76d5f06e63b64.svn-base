<%@page import="jkt.hms.util.UsgDetails"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardTrimester"%>
<%@page import="jkt.hms.masters.business.OpdAntcardMenstrualHistry"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/csrfToken.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/prototypeq.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

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
	});
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0');
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets');

animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=0,persist=0,hide=0');
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0');
animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0');

animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0');

animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0');
animatedcollapse.addDiv('ftDiv1', 'fade=0,speed=400,group=pets,persist=0,hide=0');
animatedcollapse.addDiv('ftDiv2', 'fade=0,speed=400,group=pets,persist=0,hide=0');
animatedcollapse.addDiv('ftDiv3', 'fade=0,speed=400,group=pets,persist=0,hide=0');
animatedcollapse.addDiv('ftDiv4', 'fade=0,speed=400,group=pets,persist=0,hide=0');
animatedcollapse.init();

</script>
<script type="text/javascript">
var icdArray=new Array();
</script>
<script type="text/javascript">
function yearValid(){
var d = new Date();
var yearNow=d.getFullYear()-1;
var year = document.getElementById('yearTxt').value ;
var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
	if(!(objRegExp.test(year)))
	{
		alert("Year should be a number");
		document.getElementById('yearTxt').value ="";
		document.getElementById('yearTxt').focus();
	}
	else
	{
		if(year<=yearNow)
		{
			alert("Please Not before year from  current year");
			document.getElementById('yearTxt').value ="";
			document.getElementById('yearTxt').focus();
			return false;
		}
		else
		{
			return true;
		}
	}
}
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
	
	
function addMonths()
{
var lmp = document.getElementById('lmpId').value ;
if(lmp!="")
{
	var v = new Date(lmp.substring(6),(lmp.substring(3,5) - 1) ,lmp.substring(0,2));

      
       v.setMonth(v.getMonth() + 10);
       v.setDate(v.getDate() + 7);
      var curr_date = v.getDate();
      
      var curr_month = v.getMonth();
      
      var curr_year = v.getFullYear();
      
      var mth;
      var dt;
      if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = "0"+curr_month
       		}
       		else
       		{
       			mth = curr_month
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('eddId').value=myDate;
	}
	else
	{
	  document.getElementById('eddId').value="";
	}
}
function setFocusLmp()
{
	  document.antenatalCard.<%=LMP%>.focus();
}
function eddF()
{	
	var edd = document.getElementById('eddId').value ;
	if(edd=="")
	{
	  alert("Please Enter LMP")
	  return false;
	}
	else
	{
	return true;
	}
}	



function checkDate(){
// 	var vDate = new Date() ;
// 	var exist = document.getElementById('existAnt').value ;
// 	  if(exist<1){
		  
//     var dobDate1 = document.getElementById('lmpId').value ;
// 	var dobDate2 = document.getElementById('date2Id').value ;
// 	var dobDate3 = document.getElementById('date3Id').value ;
// 	var dobDate4 = document.getElementById('date4Id').value ;
// 	var dobDate5 = document.getElementById('date5Id').value ;
	
// 	var d1 = new Date(dobDate1.substring(6),(dobDate1.substring(3,5) - 1) ,dobDate1.substring(0,2));
// 	var d2 = new Date(dobDate2.substring(6),(dobDate2.substring(3,5) - 1) ,dobDate2.substring(0,2));
// 	var d3 = new Date(dobDate3.substring(6),(dobDate3.substring(3,5) - 1) ,dobDate3.substring(0,2));
// 	var d4 = new Date(dobDate4.substring(6),(dobDate4.substring(3,5) - 1) ,dobDate4.substring(0,2));
// 	var d5 = new Date(dobDate5.substring(6),(dobDate5.substring(3,5) - 1) ,dobDate5.substring(0,2));
// 	if(dobDate1 != ""){
// 		if(vDate < d1)
// 		{
// 			alert("Please enter valid date of Date Of Lmp.");
// 			document.getElementById('lmpId').value = "";
// 			document.getElementById('eddId').value = "";
// 			return false;
// 		}
// 		else
// 		{
// 			return true;
// 		}
// 	}
// 		if(dobDate2 != ""){
// 	if(vDate > d2)
// 		{
// 			alert("Please enter valid date of examination.");
// 			document.getElementById('date2Id').value = "";
// 			return false;
// 		}
// 		else
// 		{
// 			return true;
// 		}
// 	}
// 		if(dobDate3 != ""){
// 		if(vDate > d3)
// 		{
// 			alert("Please enter valid Date of 1st Dose on.");
// 			document.getElementById('date3Id').value = "";
// 			return false;
// 		}
// 		else
// 		{
// 			return true;
// 		}
// 	}
// 			if(dobDate4 != ""){
// 		if(vDate > d4)
// 		{
// 			alert("Please enter valid Date of 2nd Dose on.");
// 			document.getElementById('date4Id').value = "";
// 			return false;
// 		}
// 		else
// 		{
// 			return true;
// 		}
// 				if(vDate > d5)
// 		{
// 			alert("Please enter valid Date of Next Visit.");
// 			document.getElementById('date5Id').value = "";
// 			return false;
// 		}
// 		else
// 		{
// 			return true;
// 		}
// 	}
// 	//govind add
// 	return true;
// 	  }else{
// 		  return true;
// 	  }
return true;
}
</script>


<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		 List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		 List<UsgDetails> usgDetailList= new ArrayList<UsgDetails>();
		 int exist=0,antCardId=0;
		 //govind code 5-8
String menarche="13";		 
String Cycle="",day="",lmp="",edd="",gravida="",para="",abortion="",live="",ectopic="",obstCompl="",medicalDisor="";
String respSystem="",cvs="",ftAdvise="",ftDate="";
String d2Medical="",d2Surgical="",d2Gynalog="",d2MultpPreg="", d2FoetAbnor="",d2MedclHist="",d2DietarHabit="";
String  d2Smok="",d2Build="",d2Nutri="",d2Height="";
String  d2Weight="",d2Breast="",d2Nipple="",d2Heart="",d2Lungs="",d4HigRisk="",d4SeconDose="",d4FirstDose="",d4WillTub="";
//added by govind 25-8-2016
String AnemiaYes="",dmYes="",heartDisYes="",hypertenPreYes="",helpYes="",didSheReceivYes="",eclampsiaYes="",anyPrevAbdomSurgYes="",cerclageYes="";
String heartDis="",mildNameMedicn="",mildDetctTreat="",severNameMedicn="",severDetctTreat="",didSheReceiv="",eclampsia="",anyPrevAbdomSurg="",cerclage="",other="";
String pregConfrm="";
// added by amit das on 08-08-2016
String tetanusOneDoseDate = null;
String tetanusTwoDoseDate = null;


		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		 if (map.get("sexList") != null)
	       {
	               sexList = (List<MasAdministrativeSex>) map.get("sexList");
	       }
		 if (map.get("exist") != null)
	       {
	               exist = (Integer)map.get("exist");
	       }
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String dateC = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}

		 List patientDataList = new ArrayList();
		
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}	

	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
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
	 String patientDob="";
	 
	 if(visit.getHin().getDateOfBirth()!= null){
		 patientDob=HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth());
		}
	 
	 List opdAntenatalCardList= new ArrayList();
		if(map.get("opdAntenatalCardList") != null){
			opdAntenatalCardList=(List)map.get("opdAntenatalCardList");
		}
//govind code 
OpdAntenatalCard op=null,op1;
 List<OpdAntenatalCard> opdAntenatalCardList1= new ArrayList<OpdAntenatalCard>();
		if(map.get("opdAntenatalCardList1") != null){
			opdAntenatalCardList1=(List<OpdAntenatalCard>)map.get("opdAntenatalCardList1");
		}
		if(map.get("usgDetailList") != null){
			usgDetailList=(List<UsgDetails>)map.get("usgDetailList");
		}
		
		System.out.println("jsp usgdetails lit "+usgDetailList.size());
	
		 if(opdAntenatalCardList1.size()>0){
			 
			 op=opdAntenatalCardList1.get(opdAntenatalCardList1.size()-1); 
				op1=opdAntenatalCardList1.get(0);
				antCardId=op.getId();
				
		 for(OpdAntenatalCard opd:opdAntenatalCardList1){
				if(!opd.getMenarche().equals("")){
			 menarche=opd.getMenarche().toString();
				}
				if(!opd.getCycle().equals("")){
			 Cycle=opd.getCycle();
				}
			 
				if(!opd.getLmp().equals("")){
			 String lmpDate[]=opd.getLmp().toString().split("-");
			 lmp=lmpDate[2]+"/"+lmpDate[1]+"/"+lmpDate[0];
				}
			 
				if(!opd.getEdd().equals("")){
			 String eddDate[]=opd.getEdd().toString().split("-");
			 edd=eddDate[2]+"/"+eddDate[1]+"/"+eddDate[0];
				}
				if(!opd.getGravida().equals("")){
			 gravida=opd.getGravida().toString();
				}
				if(!opd.getPara().equals("")){
			 para=opd.getPara().toString();
				}
				if(!opd.getAbortions().equals("")){
			 abortion=opd.getAbortions().toString();
				}
				if(!opd.getLive().equals("")){
			 live=opd.getLive().toString();
				}
				if(!opd.getEctopic().equals("")){
			 ectopic=opd.getEctopic().toString();
				}
				if(!opd.getDays().equals("")){
			 day=opd.getDays().toString();
				}
			 if(!opd.getObsterComplcatn().equals("")){
		     obstCompl=opd.getObsterComplcatn();
			 }
			 
			 if(!opd.getMedicalDisord().equals("")){
			 medicalDisor=opd.getMedicalDisord();
			 }
		
			 System.out.println("test 2");
			 if(!opd.getMedical().equals("")){
			  d2Medical=opd.getMedical();
			 }
			 if(!opd.getSurgical().equals("")){
			  d2Surgical=opd.getSurgical();
			 }
			 if(!opd.getGynecological().equals("")){
			  d2Gynalog=opd.getGynecological();
			 }
			 if(!opd.getMultiplePregnancy().equals("")){
			   d2MultpPreg=opd.getMultiplePregnancy();
			 }
			 if(!opd.getMultiplePregnancy().equals("")){
			   d2FoetAbnor=opd.getFoetalAbnormality();
			 }
			   if(!opd.getMedicalHistory().equals("")){
			   d2MedclHist=opd.getMedicalHistory();
			   }
			   if(!opd.getDietaryHabit().equals("")){
			   d2DietarHabit=opd.getDietaryHabit();
			   }
			   if(!opd.getSmoking().equals("")){
			   d2Smok=opd.getSmoking();
			   }
			   if(!opd.getBuild().equals("")){
			   d2Build=opd.getBuild();
			   }
			   if(!opd.getNutrition().equals("")){
			   d2Nutri=opd.getNutrition();
			   }
			   if(!opd.getHeight().equals("")){
			   d2Height=opd.getHeight();
			   }
			   if(!opd.getWeight().equals("")){
			   d2Weight=opd.getWeight();
			   }
			   if(!opd.getBreast().equals("")){
			   d2Breast=opd.getBreast();
			   }
			   if(!opd.getNipple().equals("")){
			   d2Nipple=opd.getNipple();
			   }
			   if(!opd.getHeart().equals("")){
			   d2Heart=opd.getHeart();
			   }
			   if(!opd.getLungs().equals("")){
			   d2Lungs=opd.getLungs();
			   }
			   if(opd.getHighRiskFactors()!=null){
			   d4HigRisk=opd.getHighRiskFactors().toString();
				  }
			   if(opd.getTetanusOnestDoseDate()!=null){
			   String fisDoseDate[]=opd.getTetanusOnestDoseDate().toString().split("-");
			   d4FirstDose=fisDoseDate[2]+"/"+fisDoseDate[1]+"/"+fisDoseDate[0];
			   }
			   if(opd.getTetanusTwondDoseDate()!=null){
			   String secDoseDate[]=opd.getTetanusTwondDoseDate().toString().split("-");			   
			   d4SeconDose=secDoseDate[2]+"/"+secDoseDate[1]+"/"+secDoseDate[0];
			   }
			   if(opd.getWillingForTubectomy()!=null){
			  d4WillTub=opd.getWillingForTubectomy();
			   }
			  
			   //added by 25-8-2016
			   if(opd.getHeartDis()!=null){
				   heartDis=opd.getHeartDis();
			   }
			   if(opd.getMildNameMedcn()!=null ){
				   mildNameMedicn=opd.getMildNameMedcn();
				   }
			   if(opd.getMildDeductTreat()!=null){
				   mildDetctTreat=opd.getMildDeductTreat();
				   }
			   if(opd.getSeverNameMedcn()!=null){
				   severNameMedicn=opd.getSeverNameMedcn();
				   }
			   if(opd.getSeverDeductTreat()!=null){
				   severDetctTreat=opd.getSeverDeductTreat();
				   }
			   if(opd.getDidsheReceiv()!=null){
				   didSheReceiv=opd.getDidsheReceiv();
				   }
				if(opd.getEclampsia()!=null){
					eclampsia=opd.getEclampsia();
					   }
			  if(opd.getAnyprevAbdomsurg()!=null){
				  anyPrevAbdomSurg=opd.getAnyprevAbdomsurg();
					   }
				   if(opd.getCerclage()!=null){
					   cerclage=opd.getCerclage();
					   }
				   if(opd.getOther()!=null){
					   other=opd.getOther();
					   }
				 //added by govind 26-8-2016
				   if(opd.getAnemiaYn()!=null){
					   AnemiaYes=opd.getAnemiaYn();
				   }
				   if(opd.getDmYn()!=null){
					   dmYes=opd.getDmYn();
					   }
				   if(opd.getHeartdisYn()!=null){
					   heartDisYes=opd.getHeartdisYn();
					   }
				   if(opd.getHypertenPreYn()!=null){
					   hypertenPreYes=opd.getHypertenPreYn();
					   }
				
				   if(opd.getHelpYn()!=null){
					   helpYes=opd.getHelpYn();
					   }
				   if(opd.getDidsheReceiveYn()!=null){
					   didSheReceivYes=opd.getDidsheReceiveYn();
					   }
					if(opd.getEclampsiaYn()!=null){
						eclampsiaYes=opd.getEclampsiaYn();
						   }
				  if(opd.getAnyprevAbdomsurYn()!=null){
					  anyPrevAbdomSurgYes=opd.getAnyprevAbdomsurYn();
						   }
					   if(opd.getCerclagesYn()!=null){
						   cerclageYes=opd.getCerclagesYn();
						 }
					   
					   if(opd.getPregnConfrm()!=null){
						   pregConfrm=opd.getPregnConfrm();
						 }
			}
		 }
		 System.out.println("antcard "+antCardId);
		 
		//govind code 5-8
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim1= new ArrayList<OpdAntenatalCardTrimester>();
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim2= new ArrayList<OpdAntenatalCardTrimester>();
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim3= new ArrayList<OpdAntenatalCardTrimester>();
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim4= new ArrayList<OpdAntenatalCardTrimester>();
		
		List<OpdAntcardMenstrualHistry> menstrHistList=new ArrayList<OpdAntcardMenstrualHistry>();
		
			if(map.get("opdAntenatalCardTrim1") != null){
				opdAntenatalCardTrim1=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim1");
			}
			if(map.get("opdAntenatalCardTrim2") != null){
				opdAntenatalCardTrim2=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim2");
			}
			if(map.get("opdAntenatalCardTrim3") != null){
				opdAntenatalCardTrim3=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim3");
			}
			if(map.get("opdAntenatalCardTrim4") != null){
				opdAntenatalCardTrim4=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim4");
			}
			
			if(map.get("menstrHistList") != null){
				menstrHistList=(List<OpdAntcardMenstrualHistry>)map.get("menstrHistList");
			}
			//govind code 5-8 end
		System.out.println("opdAntenatalCardList size "+opdAntenatalCardList1.size());
			
		// added by amit das on 08-08-2016
		if(map.get("tetanusOneDoseDate")!=null)
			tetanusOneDoseDate = (String)map.get("tetanusOneDoseDate");
		

		if(map.get("tetanusTwoDoseDate")!=null)
			tetanusTwoDoseDate = (String)map.get("tetanusTwoDoseDate");
			
%>
<script type="text/javascript">
//added by govind 26-8-2016
window.onload= callRunRadioCheck;

function callRunRadioCheck(){
	callPregConfirm();
	setWeight();
	runRadioCheck('<%=AnemiaYes%>','<%=dmYes%>','<%=heartDisYes%>',
	          '<%=hypertenPreYes%>','<%=helpYes%>','<%=didSheReceivYes%>',
	        '<%=eclampsiaYes%>','<%=anyPrevAbdomSurgYes%>','<%=cerclageYes%>');
}

<%
int corse =0;
for (MasAdministrativeSex hmc : sexList) {
%>
var pregConfrm1='<%=pregConfrm%>';
var patDOB='<%=patientDob%>';
icdArray[<%=corse%>] = new Array();
icdArray[<%=corse%>][0] = <%=hmc.getId()%>;
icdArray[<%=corse%>][1] = '<%=hmc.getAdministrativeSexName()%>';	
<%corse++;}%>

function get_valueForEdit(n)
{
 var url="/hms/hms/opd?method=showAntenatalCardEditJsp&aId="+n+"&visitId=<%=visit.getId() %>";
   popwindow(url);
  
 }  
function get_valueForGravidagramHTN(visitId)
{
 var url="/hms/hms/opd?method=showGravidagramHTNJsp&visitId=<%=visit.getId() %>";
   popwindowGravidagram(url);
  
 } 
function get_valueForGravidagramGestationalDiabitiesOne(visitId)
{
   var url="/hms/hms/opd?method=showGravidagramGestationalDiabitiesOneJsp&visitId=<%=visit.getId() %>";
   var lmp = document.getElementById('lmpId').value ;
   if(lmp!="")
   {
   	var edd = document.getElementById('eddId').value ;
   }
   else
   {
   
   	document.getElementById('lmpId').value ="";
   	document.getElementById('eddId').value ="";
   }
   popwindowGravidagram(url);
 } 

function get_valueForGravidagramGestationalDiabitiesTwo(visitId)
{
   var url="/hms/hms/opd?method=showGravidagramGestationalDiabitiesTwoJsp&visitId=<%=visit.getId() %>";
   popwindowGravidagram(url);
} 

var newwindow;
function popwindow(url)
{

	 newwindow=window.open(url,'name',"height=450,overflow=auto, width=1170, 'scrollbars=no'");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 //window.close();
}
function popwindowGravidagram(url)
{

	
 newwindow=window.open(url,'name',"height=450,overflow=auto, width=1170, 'scrollbars=no'");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 //window.close();
}		
</script>
<script type="text/javascript">
function blankSpace()
{
	var result=false;
// 	var exist = document.getElementById('existAnt').value ;

// 	  if(exist<1){
var b1 = document.getElementById('b1').value ;
var b2 = document.getElementById('b2').value ;
var b3= document.getElementById('b3').value ;
var b4 = document.getElementById('b4').value ;
var b5= document.getElementById('b5').value ;
var b6 = document.getElementById('b6').value ;
var b7 = document.getElementById('b7').value ;
var b8 = document.getElementById('b8').value ;
// //var b9 = document.getElementById('b9').value ;
// //var b10 = document.getElementById('b10').value ;
// //var b11 = document.getElementById('b11').value ;
// //var b12 = document.getElementById('b12').value ;
// //var b13 = document.getElementById('b13').value ;
// //var b14 = document.getElementById('b14').value ;
// //var b15 = document.getElementById('b15').value ;
// var b16 = document.getElementById('b16').value ;
// var b17 = document.getElementById('b17').value ;
// var b18 = document.getElementById('b18').value ;
// var b19= document.getElementById('b19').value ;
// var b20 = document.getElementById('b20').value ;
// var b21= document.getElementById('b21').value ;
// var b22 = document.getElementById('b22').value ;
// var b23 = document.getElementById('b23').value ;
// var b24 = document.getElementById('b24').value ;
// var b25 = document.getElementById('b25').value ;
// var b26 = document.getElementById('b26').value ;
// var b27 = document.getElementById('b27').value ;
// var b28 = document.getElementById('b28').value ;
// var b29 = document.getElementById('b29').value ;
// var b30 = document.getElementById('b30').value ;
// var b31 = document.getElementById('b31').value ;
// var b32 = document.getElementById('b32').value ;
// var b33 = document.getElementById('b33').value ;
// var b34 = document.getElementById('b34').value ;
// var b35 = document.getElementById('b35').value ;
// var b36= document.getElementById('b36').value ;
// var b37 = document.getElementById('b37').value ;
// var b38= document.getElementById('b38').value ;
// var b39 = document.getElementById('b39').value ;
// var b40 = document.getElementById('b40').value ;
// var b41 = document.getElementById('b41').value ;
// var b42 = document.getElementById('b42').value ;
// var b43 = document.getElementById('b43').value ;
// var b44 = document.getElementById('b44').value ;
// var b45 = document.getElementById('b45').value ;
// var b46 = document.getElementById('b46').value ;
// var b47 = document.getElementById('b47').value ;
// var b48 = document.getElementById('b48').value ;
// var b49 = document.getElementById('b49').value ;
// var b50 = document.getElementById('b50').value ;
// var b51 = document.getElementById('b51').value ;
// var b52 = document.getElementById('b52').value ;
// var b53 = document.getElementById('b53').value ;
// var b54 = document.getElementById('b54').value ;
// var b55 = document.getElementById('b55').value ;
// var b56 = document.getElementById('b56').value ;
// //var yearTxt = document.getElementById('yearTxt').value ;
// //var dobDate1 = document.getElementById('date2Id').value ;
// var dobDate2 = document.getElementById('date3Id').value ;
// var dobDate3 = document.getElementById('date4Id').value ;
// var dobDate4 = document.getElementById('date5Id').value ;
// var lmp = document.getElementById('lmpId').value ;
// var edd = document.getElementById('eddId').value ;

	if((b1=="")&&(b2=="")&&(b3=="")&&(b4==0)&&(b5==0)&&(b6==0)&&(b7==0)&&(b8==0))//&&(yearTxt=="")&&(b9=="")&&(b10=="")&&(b11=="")&&(b12=="")&&(b13=="")&&(b14=="")&&(b15=="")&&(b16=="")&&(dobDate1=="")&&(dobDate2=="")&&(dobDate3=="")&&(dobDate4=="")&&(lmp=="")&&(edd=="")&&(b17=="")&&(b18=="")&&(b19=="")&&(b20=="")&&(b21=="")&&(b22=="")&&(b23=="")&&(b24=="")&&(b25=="")&&(b26=="")&&(b27=="")&&(b28=="")&&(b29=="")&&(b30=="")&&(b31=="")&&(b32=="")&&(b33=="")&&(b34=="")&&(b35=="")&&(b36=="")&&(b37=="")&&(b38=="")&&(b39=="")&&(b40=="")&&(b41=="")&&(b42=="")&&(b43=="")&&(b44=="")&&(b45=="")&&(b46=="")&&(b47=="")&&(b48=="")&&(b49=="")&&(b50=="")&&(b51=="")&&(b52=="")&&(b53=="")&&(b54=="")&&(b55=="")&&(b56==""))
	{
		alert("Please give some fields.");
		$("#SomeField").val(0);
		result= false;
	}
	else
	{
		$("#SomeField").val(1);
		result= true;
	}
	
return result;
}
</script>
<!--main content placeholder starts here-->
<div class="OpdOphthamology-maindiv" onload="callFunction();">
	<form name="antenatalCard" action="" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="hidden"
			name="<%=DEPARTMENT_ID %>"
			value="<%=visit.getDepartment().getId() %>" />
		<%if(visit.getDepartment()!= null){ %>
		<input id="inputDate" name="inputDate" type="hidden"
			value="<%=dateC%>" />
			<input id="inputTime" name="inputTime" type="hidden"
			value="<%=time%>" />
		<div class="titleBg">
			<h2>Antenatal Card</h2>
		</div>
		<div class="clear"></div>
		<%} %>
		<!--Block One Starts-->
		<h4>Patient Details</h4>
		<div class="clear"></div>
		<div class="Block">
			<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
			<%if(visit.getHin().getHinNo()!= null){ %>
			<label class="value"><%=visit.getHin().getHinNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label>Patient Name. </label>
			<%if(patientName!= null){ %>
			<label class="value"><%=patientName %> </label>
			<%}else{ %>
			<label class="value">- </label>
			<%} %>
			<label>Age</label>
			<%if(visit.getHin().getAge()!= null){ %>
			<label class="value"><%=visit.getHin().getAge() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<div class="clear"></div>
			<label>Date of Birth</label>
			<%if(patientDob != null){ %>
			<label class="value"><%=patientDob %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label>Visit Date </label>
			<%if(visitDateInString != null){ %>
			<label class="value"><%=visitDateInString %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
			<%if(visit.getVisitNo()!= null){ %>
			<label class="value"><%=visit.getVisitNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>			
			<div class="clear"></div>
			<label>Token No. </label>
			<%if(visit.getTokenNo()!= null){ %>
			<label class="value"><%=visit.getTokenNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label>Prev. Diag </label>
			<%if(visit.getDiagnosis()!= null){ %>
			<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label>ECHS No. </label>
			<%if(visit.getHin().getEchsNo()!= null){ %>
			<label class="value"><%=visit.getHin().getEchsNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>			
			<div class="clear"></div>
			<label>Phone Number</label>
			<% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
			<label class="value"><%=visit.getHin().getPhoneNumber() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label>Mobile Number</label>
			<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
			<label class="value"><%=visit.getHin().getMobileNumber() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<div class="clear"></div>
		</div>
		<!--Block one Ends-->

		<div class="clear"></div>
		<!-- govind code 20-8-2016 -->
		<div class="Block">
			<h4>Maternal Antenatal Problems</h4>
			<div class="clear"></div>
			<label>Anemia</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="AnemiaYes" id="AnemiaYes"
				type="radio" value="Y"
				onchange="selectYesNo('AnemiaYes','AnemiaNo','','')"> Yes
			</label><label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="AnemiaYes" id="AnemiaNo"
				type="radio" value="N"
				onchange="selectYesNo('AnemiaNo','AnemiaYes','','')"> No
			</label> <label>DM</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="dmYes" id="dmYes" type="radio"
				value="Y" onchange="selectYesNo('dmYes','dmNo','','')"> Yes
			</label><label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="dmYes" id="dmNo" type="radio"
				value="N" onchange="selectYesNo('dmNo','dmYes','','')"> No
			</label> <label>Heart Diseases</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="heartDisYes" id="heartDisYes"
				onchange="selectYesNo('heartDisYes','heartDisNo','heartDis','Heart Diseases')"
				type="radio" value="Y"> Yes
			</label><label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="heartDisYes" id="heartDisNo"
				onchange="selectYesNo('heartDisNo','heartDisYes','heartDis','Heart Diseases')"
				type="radio" value="N"> No
			</label> <input type="text" name="heartDis" id="heartDis"
				value="<%=heartDis%>" />
			<div class="clear"></div>
			<label>Hypertension/Pre ecl</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="hypertenPreYes"
				id="hypertenPreYes"
				onchange="selectYesNo('hypertenPreYes','hypertenPreNo','hyperBloc','Hypertension/Pre ecl')"
				type="radio" value="Y"> Yes
			</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="hypertenPreYes"
				id="hypertenPreNo"
				onchange="selectYesNo('hypertenPreNo','hypertenPreYes','hyperBloc','Hypertension/Pre ecl')"
				type="radio" value="N"> No
			</label>
			<div class="Block" id="hyperBloc">
				<label>Mild</label> <label>Name of medicine</label><input
					type="text" name="mildNameMedicn" id="mildNameMedicn"
					value="<%=mildNameMedicn%>" /> <label class="labelBig">Detection
					to treatment interval</label> <input type="text" name="mildDetctTreat"
					id="mildDetctTreat" value="<%=mildDetctTreat%>" />
				<div class="clear"></div>
				<label>Severe</label> <label>Name of medicine</label><input
					type="text" name="severNameMedicn" id="severNameMedicn"
					value="<%=severNameMedicn%>" /> <label class="labelBig">Detection
					to treatment interval</label><input type="text" name="severDetctTreat"
					id="severDetctTreat" value="<%=severDetctTreat%>" />
			</div>
			<div class="clear"></div>
			<label>HELLP</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="helpYes" id="helpYes"
				type="radio" onchange="selectYesNo('helpYes','helpNo','','')"
				value="Y"> Yes
			</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="helpYes" id="helpNo"
				type="radio" onchange="selectYesNo('helpNo','helpYes','','')"
				value="N"> No
			</label> <label class="labelBig">Did she receive blood products/ICU/
				Induction</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="didSheReceivYes"
				id="didSheReceivYes" type="radio"
				onchange="selectYesNo('didSheReceivYes','didSheReceivNo','didSheReceiv','Did she receive blood products/ICU/Induction')"
				value="Y"> Yes
			</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="didSheReceivYes"
				id="didSheReceivNo" type="radio"
				onchange="selectYesNo('didSheReceivNo','didSheReceivYes','didSheReceiv','Did she receive blood products/ICU/Induction')"
				value="N"> No
			</label> <input type="text" name="didSheReceiv" id="didSheReceiv"
				value="<%=didSheReceiv%>" />
			<div class="clear"></div>
			<label>Eclampsia</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="eclampsiaYes" id="eclampsiaYes"
				type="radio"
				onchange="selectYesNo('eclampsiaYes','eclampsiaNo','eclampsia','Eclampsia')"
				value="Y"> Yes
			</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="eclampsiaYes" id="eclampsiaNo"
				type="radio"
				onchange="selectYesNo('eclampsiaNo','eclampsiaYes','eclampsia','Eclampsia')"
				value="N"> No
			</label> <input type="text" name="eclampsia" id="eclampsia"
				value="<%=eclampsia%>" /> <label class="labelBig">Any
				Previous Abdominal Surgery</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="anyPrevAbdomSurgYes"
				id="anyPrevAbdomSurgYes" type="radio"
				onchange="selectYesNo('anyPrevAbdomSurgYes','anyPrevAbdomSurgNo','anyPrevAbdomSurg','Any Previous Abdominal Surgery')"
				value="Y"> Yes
			</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="anyPrevAbdomSurgYes"
				id="anyPrevAbdomSurgNo" type="radio"
				onchange="selectYesNo('anyPrevAbdomSurgNo','anyPrevAbdomSurgYes','anyPrevAbdomSurg','Any Previous Abdominal Surgery')"
				value="N"> No
			</label> <input type="text" name="anyPrevAbdomSurg" id="anyPrevAbdomSurg"
				value="<%=anyPrevAbdomSurg%>" />
			<div class="clear"></div>
			<label>Cerclage</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="cerclageYes" id="cerclageYes"
				type="radio"
				onchange="selectYesNo('cerclageYes','cerclageNo','cerclage','Cerclage')"
				value="Y"> Yes
			</label> <label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="cerclageYes" id="cerclageNo"
				type="radio"
				onchange="selectYesNo('cerclageNo','cerclageYes','cerclage','Cerclage')"
				value="N"> No
			</label> <input type="text" name="cerclage" id="cerclage"
				value="<%=cerclage%>" /> <label>Others</label><input type="text"
				name="other" id="other" value="<%=other%>" />
		</div>
		<div class="clear"></div>
		<!-- govind code 20-8-2016 -->

		<!--Block two Start-->
		<a href="javascript:changeClass('title1','t1')"><h5 id='t1'>Previous
				Pregnancy Details</h5></a>
		<div class="clear"></div>
		<div class="Block" id="title1">
			<div class="clear"></div>


			<div class="paddingTop15"></div>
			<div class="tableHolderAuto">
				<h4>Previous Pegnancy</h4>
				<div class="clear"></div>
				<div class="floatRight" style="width: 300px;">
					<input type="button" class="buttonDel" value=""
						onclick="removeRow1('opdAntTable');" /> <input type="button"
						class="buttonAdd" onclick="addRowAntTable();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab"
						style="width: 1150px; height: 200px; overflow: scroll;">
						<div id="divTemplet2">
							<table border="0" cellspacing="0" cellpadding="0"
								id="opdAntTable">
								<tr>
									<th rowspan="2" scope="col"
										style="border-right-color: #000000;">Srl No.</th>
									<th colspan="3" scope="col"
										style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Mother</th>
									<th colspan="3" scope="col"
										style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Baby</th>
									<th colspan="3" scope="col"
										style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Complications</th>

								</tr>
								<tr>
									<th scope="col">Year</th>
									<th scope="col">Age</th>
									<th scope="col" style="border-right-color: #000000;">Pregnancy
										Outcome</th>

									<th scope="col">Delivery Outcome</th>
									<th scope="col">Gender</th>
									<th scope="col" style="border-right-color: #000000;">Birth
										Weight</th>

									<th scope="col">Antenatal</th>
									<th scope="col">Intra Partum</th>
									<th scope="col" style="border-right-color: #000000;">Post
										Partum</th>
								</tr>
								<%
									int opcount = 0;
								int inc = 0;
								int row = 1;
									if (opdAntenatalCardList1.size() > 0) {
										for (OpdAntenatalCard opd : opdAntenatalCardList1) {

											if (!opd.getPregnancyOutcome().equals("")
													&& opd.getPregnancyOutcome() != null
													&& !opd.getSex().equals("") && opd.getSex() != null
													&& !opd.getDelvrOutcm().equals("")
													&& opd.getYear() != null
													&& !opd.getYear().equals("")
													&& opd.getComplications() != null
													&& !opd.getComplications().equals("")) {
												opcount = opcount + 1;
								%>

								<tr>
									<td scope="col" align="center"><%=opcount%></td>
									<td><input type="text" size=3 value="<%=opd.getYear()%>"
										readonly="readonly" maxlength="4" /></td>
									<td scope="col"><input type="text" size=3
										readonly="readonly" maxlength="2" value="<%=opd.getAge()%>" /></td>

									<td scope="col"><select>
											<%
												String outcome = "Select";
															if (!opd.getPregnancyOutcome().equals("")
																	&& opd.getPregnancyOutcome() != null) {
																if (Integer.parseInt(opd.getPregnancyOutcome()) == 1) {
																	outcome = "FTND";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 2) {
																	outcome = "Vacuum";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 3) {
																	outcome = "Forceps";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 4) {
																	outcome = "LSCS";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 5) {
																	outcome = "Abortion";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 6) {
																	outcome = "Ectopic";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 7) {
																	outcome = "Vesicular Mole";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 8) {
																	outcome = "Others";
																} else if (Integer.parseInt(opd
																		.getPregnancyOutcome()) == 0) {
																	outcome = "";
																}
															}
											%>
											<option value="<%=opd.getPregnancyOutcome()%>"><%=outcome%></option>
									</select></td>

									<td><select>
											<%
												String delOutcome = "Select";
															if (opd.getDelvrOutcm() == 1) {
																delOutcome = "Live";
															} else if (opd.getDelvrOutcm() == 2) {
																delOutcome = "Still Birth";
															} else if (opd.getDelvrOutcm() == 3) {
																delOutcome = "IUD";
															} else if (opd.getDelvrOutcm() == 4) {
																delOutcome = "NND";
															} else if (opd.getDelvrOutcm() == 0) {
																outcome = "";
															}
											%>
											<option value="<%=opd.getDelvrOutcm()%>"><%=delOutcome%></option>

									</select></td>

									<td><select>
											<%
												for (MasAdministrativeSex masAdministrativeSex : sexList) {
																if (!opd.getSex().equals("")
																		&& opd.getSex() != null) {
																	if (masAdministrativeSex.getId().equals(
																			Integer.parseInt(opd.getSex()))) {
											%>
											<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex
											.getAdministrativeSexName()%></option>
											<%
												}
																} else {

																}
															}
											%>
									</select></td>

									<td>
										<div id="element1" style="float: left;">
											<input type="text" value="<%=opd.getBirthWeight()%>" size=5
												maxlength="2" readonly="readonly" />
										</div>
										<div id="element2" style="padding-left: 20px; float: left;">
											<label>/gm</label>
										</div>
									</td>

									<td><textarea readonly="readonly" maxlength="300"><%=opd.getComplications()%></textarea></td>
									<td><textarea readonly="readonly" maxlength="300"><%=opd.getBreastFeeding()%></textarea></td>
									<td><textarea readonly="readonly" maxlength="300"><%=opd.getGeneralHealth()%></textarea></td>
								</tr>
								<%
								row = row+1;
									}
										}
									
									}
								%>
								<%
									int opdincr = 0, opdlen = 1;
									int opdinxRow = 1;
									int opdinxCol = 0;
									// 								if(exist==1){
									// 									opdlen=0;

									// 								}
									for (; opdincr < opdlen; opdincr++, opdinxRow++) {
								%>
								<tr>
									<td scope="col"><input type="checkbox"
										tabindex="<%=opdinxRow%><%=opdinxCol + 1%>" class="radioCheck"
										id="itemRadioAnt<%=opdincr%>" name="itemRadioAnt<%=opdincr%>"
										onchange="checkPrescriptionCheck(<%=opdincr%>)" /></td>

									<td scope="col"><input name="<%=YEAR%><%=opdincr%>" 
										id="<%=YEAR%><%=opdincr%>" type="text" size=3 maxlength="4" validate="Year,num,no"
										tabindex="<%=opdinxRow%><%=opdinxCol + 2%>" oninput="callAge('<%=YEAR%><%=opdincr%>','<%=AGE_UNIT%><%=opdincr%>');"/></td>

									<td scope="col"><input id="<%=AGE_UNIT%><%=opdincr%>"
										name="<%=AGE_UNIT%><%=opdincr%>" type="text" size=3 validate="Age,num,no"
										tabindex="<%=opdinxRow%><%=opdinxCol + 3%>" maxlength="2" /></td>

									<td scope="col"><select
										name="<%=PREGNANCY_OUTCOME%><%=opdincr%>"
										id="<%=PREGNANCY_OUTCOME%><%=opdincr%>"
										tabindex="<%=opdinxRow%><%=opdinxCol + 4%>">
											<option value="0">select</option>
											<option value="1">FTND</option>
											<option value="2">Vacuum</option>
											<option value="3">Forceps</option>
											<option value="4">LSCS</option>
											<option value="5">Abortion</option>
											<option value="6">Ectopic</option>
											<option value="7">Vesicular Mole</option>
											<option value="8">Others</option>
									</select></td>

									<td scope="col"><select id="deliveryOutcome<%=opdincr%>"
										name="deliveryOutcome<%=opdincr%>"
										tabindex="<%=opdinxRow%><%=opdinxCol + 5%>">
											<option value="0">select</option>
											<option value="1">Live</option>
											<option value="2">Still Birth</option>
											<option value="3">IUD</option>
											<option value="4">NND</option>
									</select></td>

									<td scope="col"><select name="<%=SEX%><%=opdincr%>"
										id="<%=SEX%><%=opdincr%>"
										tabindex="<%=opdinxRow%><%=opdinxCol + 6%>">
											<option value="0">Select</option>
											<%
												for (MasAdministrativeSex masAdministrativeSex : sexList) {
											%>
											<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
											<%
												}
											%>
									</select></td>

									<td scope="col"><input id="<%=BIRTH_WEIGHT%><%=opdincr%>"
										name="<%=BIRTH_WEIGHT%><%=opdincr%>" type="text" size=5
										maxlength="4" tabindex="<%=opdinxRow%><%=opdinxCol + 7%>" /><label
										class="smallAuto autoSpace">/gm</label></td>

									<td scope="col"><textarea
											id="<%=COMPLICATIONS%><%=opdincr%>"
											name="<%=COMPLICATIONS%><%=opdincr%>" maxlength="300"
											tabindex="<%=opdinxRow%><%=opdinxCol + 8%>"></textarea></td>
									<td scope="col"><textarea
											id="<%=BREAST_FEEDING%><%=opdincr%>"
											name="<%=BREAST_FEEDING%><%=opdincr%>" maxlength="300"
											tabindex="<%=opdinxRow%><%=opdinxCol + 9%>"></textarea></td>
									<td scope="col"><textarea
											id="<%=GENERAL_HEALTH%><%=opdincr%>"
											name="<%=GENERAL_HEALTH%><%=opdincr%>" maxlength="300"
											tabindex="<%=opdinxRow%><%=opdinxCol + 10%>"></textarea></td>
								</tr>
								<%
									}
								%>
							</table>
							<input type="hidden" name="opdhdb" value="<%=opdincr - 1%>"
								id="opdhdb" /> <input type="hidden" name="opdhdbTabIndex"
								id="opdhdbTabIndex" value="<%=opdinxRow - 1%>" />
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="division"></div>
			<div class="clear"></div>
			<div class="floatLeft" style="width: 500px;">
				<table width="40%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th scope="col">OBSTETRIC COMPLICATIONS</th>
						<th scope="col">MEDICAL DISORDERS</th>
					</tr>
					<tr>
						<td><textarea class="opdMainTextArea" name="obsterCompl"
								id="obsterCompl" maxlength="300"><%=obstCompl %></textarea></td>
						<td><textarea class="opdMainTextArea" name="medicalDisord"
								id="medicalDisord" maxlength="300"><%=medicalDisor %></textarea></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>
		<a href="javascript:changeClass('title2','t2')">
			<h5 id='t2'>Case History</h5>
		</a>
		<div class="clear"></div>
		<div class="Block" id="title2">
			<div class="clear"></div>
			<div class="division"></div>
			<h4>Menstrual History</h4>
			<div class="clear"></div>
			<label>Menarche</label> <input id="b1" name="<%=MENARCHE %>"
				validate="Menraeche Code,num,yes" type="text" maxlength="3"
				value="<%=menarche%>" /> <label>Cycle</label><label class="small">(Reg/Irreg)</label>
			<select name="<%=CYCLE %>" id="b2" validate="Cycle,string,yes">
				<%if(!Cycle.equals("")){			%>
				<option value="<%=Cycle%>"><%=Cycle%></option>
				<%}else{ %>
				<option value="">Select</option>
				<option value="Regular">Regular</option>
				<option value="Irregular">Irregular</option>
				<option value="Absent">Absent</option>
				<%} %>
			</select> <input id="b3" name="<%=DAYS %>" type="text" class="date"
				validate="Days,num,yes" value="<%=day%>" maxlength="15" /> <label
				class="small">Days</label>
			<div class="clear"></div>
			<label>LMP</label> <input type="text" class="date" id="lmpId"
				validate="LMP,date,yes" value="<%=lmp%>" name="<%=LMP %>"
				readonly="readonly" MAXLENGTH="30" onfocus="addMonths();"
				onblur="checkDate();" /> <img src="/hms/jsp/images/cal.gif"
				width="16" height="16" border="0" validate="Pick a date"
				onClick="setdate('',document.antenatalCard.<%=LMP%>,event),setFocusLmp();"
				 /> 
				<label>Pregnancy Confirmed</label> <label class="smallCheck"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input type="checkbox" id="pregConfrm" name="pregConfrm" onchange="callPregConfirm();" value="Y"/></label>
				<div id="eddDiv">
				  <label>EDD (LMP+9M+7D)</label> <input
				value="<%=edd%>" type="text" id="eddId" name="<%=EDD %>"
				class="readOnly" readonly="readonly" onblur="eddF();" />
				</div>
             <div class="clear"></div>
             <!-- added by govind 30-8-2016 -->
			<div class="floatRight" style="width: 300px;">
				<input type="button" class="buttonDel" value=""
					onclick="removeRow1('opdMensHistTable');" /> <input type="button"
					class="buttonAdd" onclick="addRowMensHistTable();" value="" />
			</div>
			<div class="clear"></div>
			<div class="">
				<div class="tableForTab"
					style="width: 1150px; height: 200px; overflow: scroll;">
					<div id="divTemplet2">
						<table border="0" cellspacing="0" cellpadding="0" id="opdMensHistTable">
							<tr>
								<th rowspan="2" scope="col" style="border-right-color: #000000;">Srl
									No.</th>
									<th rowspan="2" scope="col" style="border-right-color: #000000;">Date</th>
									<th rowspan="2" scope="col" style="border-right-color: #000000;">Time</th>
								<th colspan="5" scope="col"
									style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Menses</th>
								<th colspan="5" scope="col"
									style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Menstrual Flow</th>
							</tr>
							<tr>
								<th scope="col">PL Score</th>
								<th scope="col">LMP</th>
								<th scope="col">PMP</th>
								<th scope="col">Regularity Of Cycles</th>
								<th scope="col" style="border-right-color: #000000;">Cycle Duration</th>

								<th scope="col">Frequency</th>
								<th scope="col">Duration</th>
								<th scope="col">Volume</th>
								<th scope="col">Charectiristics</th>
								<th scope="col" style="border-right-color: #000000;">Associated Complaints</th>
							</tr>
							
									<%
					   								
							if(menstrHistList.size()>0){
								int count=0;	
										for(OpdAntcardMenstrualHistry menH:menstrHistList){
										count=count+1;
										%>

							<tr>
								<td scope="col"><%=count%></td>

								<td scope="col"><input type="text" class="dateTextSmall"
									value="<%=menH.getMenstHistDate()%>" readonly="readonly">
									<img src="/hms/jsp/images/cal.gif" width="16" height="16"
									border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.mhDate,event);" /></td>

								<td scope="col"><input class="opdTextBoxTSmall" type="text"
									value="<%=menH.getMenstHistTime()%>" maxlength="5"
									readonly="readonly" /></td>

								<td scope="col"><input type="text"
									value="<%=menH.getMenstHistPl()%>" readonly="readonly" /></td>

								<td scope="col"><input type="text"
									value="<%=menH.getLmpDate()%>" class="dateTextSmall"
									readonly="readonly"> <img src="/hms/jsp/images/cal.gif"
									width="16" height="16" border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.lmpDate,event);" /></td>

								<td scope="col"><input type="text"
									value="<%=menH.getPmpDate()%>" class="dateTextSmall"
									readonly="readonly"> <img src="/hms/jsp/images/cal.gif"
									width="16" height="16" border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.pmpDate,event);" /></td>

								<td scope="col"><select>
										<%
											String outcome = "Select";
													if (!menH.getRegulrCycle().equals("")
															&& menH.getRegulrCycle() != null) {
														if (menH.getRegulrCycle() == 1) {
															outcome = "Irregular";
														} else if (menH.getRegulrCycle() == 2) {
															outcome = "Regular";
														} else if (menH.getRegulrCycle() == 3) {
															outcome = "Absent";
														}
													}
										%>
										<option value="<%=outcome%>"><%=outcome%></option>
								</select></td>

								<td scope="col"><input type="text"
									value="<%=menH.getCycleDuration()%>" readonly="readonly" /></td>

								<td scope="col"><select>
										<%
											String frequen = "Select";
													if (!menH.getFrequency().equals("")
															&& menH.getFrequency() != null) {
														if (menH.getFrequency() == 1) {
															frequen = "Frequent";
														} else if (menH.getFrequency() == 2) {
															frequen = "Normal";
														} else if (menH.getFrequency() == 3) {
															frequen = "Infrequent";
														}
													}
										%>
										<option value="<%=frequen%>"><%=frequen%></option>
								</select></td>

								<td scope="col"><input type="text"
									value="<%=menH.getDuration()%>" readonly="readonly" /></td>

								<td scope="col"><select>
										<%
											String volume = "Select";
													if (!menH.getVolume().equals("")
															&& menH.getVolume() != null) {
														if (menH.getVolume() == 1) {
															volume = "Normal";
														} else if (menH.getVolume() == 2) {
															volume = "Scanty";
														} else if (menH.getVolume() == 3) {
															volume = "Moderate";
														} else if (menH.getVolume() == 4) {
															volume = "Heavy";
														}
													}
										%>
										<option value="<%=volume%>"><%=volume%></option>
								</select></td>

								<td scope="col"><input type="text"
									value="<%=menH.getCharStict()%>" readonly="readonly" /></td>

								<td scope="col"><input type="text"
									value="<%=menH.getAssocCompl()%>" readonly="readonly" /></td>

							</tr>

							<%
								}
								}
							%>
								
							<%
																int incrMH = 0, lenMH = 1;
																int inxRowMH = 1;
																int inxColMH = 0;
																for (; incrMH < lenMH; incrMH++, inxRowMH++) {
															%>
							<tr>
								<td scope="col"><input type="checkbox"
									tabindex="<%=inxRowMH%><%=inxColMH + 1%>" class="radioCheck"
									id="itemRadioMH<%=incrMH%>" name="itemRadioMH<%=incrMH%>"
									onchange="checkPrescriptionCheck(<%=incrMH%>)" /></td>
									
								<td scope="col"><input type="text" id="mhDate<%=incrMH%>"
									name="mhDate<%=incrMH%>"  value="<%=dateC %>"
									tabindex="<%=inxRowMH%><%=inxColMH + 2%>" class="dateTextSmall"
									readonly="readonly"> <img src="/hms/jsp/images/cal.gif"
									width="16" height="16" border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.mhDate<%=incrMH%>,event);" /></td>
									
									<td scope="col"><input class="opdTextBoxTSmall" 
									tabindex="<%=inxRowMH%><%=inxColMH + 3%>" type="text" value="<%=time %>"
									name="mhTime<%=incrMH%>" id="mhTime<%=incrMH%>" 
									maxlength="5" /></td>
									
								<td scope="col"><input 
									tabindex="<%=inxRowMH%><%=inxColMH + 4%>" type="text"
									name="plScore<%=incrMH%>" id="plScore<%=incrMH%>" validate="PL Score,num,no"
									 /></td>
									
								<td scope="col"><input type="text" id="lmpDate<%=incrMH%>"
									name="lmpDate<%=incrMH%>"
									tabindex="<%=inxRowMH%><%=inxColMH + 5%>" class="dateTextSmall"
									readonly="readonly"> <img src="/hms/jsp/images/cal.gif"
									width="16" height="16" border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.lmpDate<%=incrMH%>,event);" /></td>
									
								<td scope="col"><input type="text" id="pmpDate<%=incrMH%>"
									name="pmpDate<%=incrMH%>"
									tabindex="<%=inxRowMH%><%=inxColMH + 6%>" class="dateTextSmall"
									readonly="readonly"> <img src="/hms/jsp/images/cal.gif"
									width="16" height="16" border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.pmpDate<%=incrMH%>,event);" /></td>

								<td scope="col"><select
									name="regulartyCycle<%=incrMH%>"
									id="regulartyCycle<%=incrMH%>"
									tabindex="<%=inxRowMH%><%=inxColMH + 7%>">
										<option value="0">select</option>
										<option value="1">Irregular</option>
										<option value="2">Regular</option>
										<option value="3">Absent</option>
								</select></td>

								<td scope="col"><input 
									tabindex="<%=inxRowMH%><%=inxColMH + 8%>" type="text"
									name="cycleDuration<%=incrMH%>" id="cycleDuration<%=incrMH%>" 
									 /></td>
									 
									 <td scope="col"><select
									name="frequency<%=incrMH%>"
									id="frequency<%=incrMH%>"
									tabindex="<%=inxRowMH%><%=inxColMH + 9%>">
										<option value="0">select</option>
										<option value="1">Frequent</option>
										<option value="2">Normal</option>
										<option value="3">Infrequent</option>
								</select></td>
								
								<td scope="col"><input 
									tabindex="<%=inxRowMH%><%=inxColMH + 10%>" type="text"
									name="duration<%=incrMH%>" id="duration<%=incrMH%>"
									/></td>
									  
									  <td scope="col"><select
									name="volume<%=incrMH%>"
									id="volume<%=incrMH%>"
									tabindex="<%=inxRowMH%><%=inxColMH + 11%>">
										<option value="0">select</option>
										<option value="1">Normal</option>
										<option value="2">Scanty</option>
										<option value="3">Moderate</option>
										<option value="4">Heavy</option>
								</select></td>
								
								<td scope="col"><input 
									tabindex="<%=inxRowMH%><%=inxColMH + 12%>" type="text"
									name="characterstic<%=incrMH%>" id="characterstic<%=incrMH%>" 
									/></td>
									 
									 <td scope="col"><input 
									tabindex="<%=inxRowMH%><%=inxColMH + 13%>" type="text"
									name="assoctComplain<%=incrMH%>" id="assoctComplain<%=incrMH%>" 
									 /></td>

							</tr>
									<%	
							}
					%>
						</table>
						<input type="hidden" name="hdbMH" value="<%=incrMH - 1%>"
								id="hdbMH" /> <input type="hidden" name="hdbTabIndexMH"
								id="hdbTabIndexMH" value="<%=inxRowMH - 1%>" />
					</div>
				</div>
			</div>
			<!-- added by govind 30-8-2016 end-->
             
			<div class="clear"></div>
			<h4>Obstetric History</h4>
			<div class="clear"></div>
			<label>Gravida </label> <select name="<%=GRAVIDA %>" value="1"
				class="date" id="b4" validate="GRAVIDA,num,no"
				onchange="gravidaAbortionTwo();">
				<%if(!gravida.equals("")){			%>
				<option value="<%=gravida%>"><%=gravida%></option>
				<%}else{ %>
				<option value="0">select</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<%} %>
			</select> <label>Para</label> <select name="<%=PARA %>" class="date" id="b5"
				onchange="gravidaAbortionTwo();">
				<%if(!para.equals("")){			%>
				<option value="<%=para%>"><%=para%></option>
				<%}else{ %>
				<option value="0">select</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<%} %>
			</select> <label>Abortion</label> <select name="<%=ABORTIONS %>" class="date"
				id="b6" validate="Abortion,num,no" onchange="gravidaAbortionTwo();">
				<%if(!abortion.equals("")){			%>
				<option value="<%=abortion%>"><%=abortion%></option>
				<%}else{ %>
				<option value="0">select</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<%}%>
			</select>
			<div class="clear"></div>
			<label>Live</label> <select name="<%=LIVE %>" class="date" id="b7"
				onchange="gravidaAbortionTwo();">
				<%if(!live.equals("")){			%>
				<option value="<%=live%>"><%=live%></option>
				<%}else{ %>
				<option value="0">select</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<%}%>
			</select> <label>Ectopic</label> <select name="<%=ECTOPIC %>" class="date"
				id="b8" validate="Ectopic,num,no">
				<%if(!ectopic.equals("")){			%>
				<option value="<%=ectopic%>"><%=ectopic%></option>
				<%}else{ %>
				<option value="0">select</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<%}%>
			</select>
			<div class="clear"></div>
			<h4>Past History</h4>
			<div class="clear"></div>

			<label>Medical </label>
			<textarea class="opdMainTextArea" id="b16" name="<%=MEDICAL %>"
				tabindex="0" maxlength="300" validate="Medical Code,string,no"><%=d2Medical %></textarea>
			<label>Surgical</label>
			<textarea class="opdMainTextArea" id="b17" name="<%=SURGICAL %>"
				maxlength="300" tabindex="1" validate="Surgical Code,string,no"><%=d2Surgical %></textarea>
			<label>Gynaecological</label>
			<textarea class="opdMainTextArea" id="b18" name="<%=GYNECOLOGICAL %>"
				maxlength="300" tabindex="2"
				validate="Gynaecological Code,string,no"><%=d2Gynalog %> </textarea>
			<div class="clear"></div>

			<h4>Family History</h4>
			<div class="clear"></div>
			<label>Multiple Pregnancy </label>
			<textarea class="opdMainTextArea" id="b20"
				name="<%=MULTIPLE_PREGNANCY %>" maxlength="300"
				validate="Multiple Pregnancy,string,no"><%=d2MultpPreg %></textarea>
			<label>Foetal Abnormality</label>
			<textarea class="opdMainTextArea" id="b21"
				name="<%=FOETAL_ABNORMALITY %>" maxlength="300"
				validate="Foetal Abnormality,string,no"><%=d2FoetAbnor %></textarea>

			<label>Medical History </label> <select id="b19"
				name="<%=MEDICAL_HISTORY %>" size="10" multiple="multiple"
				class="list">
				<%if(!d2MedclHist.equals("")){			%>
				<option value="<%=d2MedclHist%>"><%=d2MedclHist%></option>
				<%}else{ %>
				<option value="Diabetes">Diabetes</option>
				<option value="Hypertension">Hypertension</option>
				<option value="TB">TB</option>
				<%}%>
			</select>
			<div class="clear"></div>
			<h4>Personal History</h4>
			<div class="clear"></div>
			<label> Dietary Habit </label> <select id="b22"
				name="<%=DIETARY_HABIT %>">
				<%if(!d2DietarHabit.equals("")){			%>
				<option value="<%=d2DietarHabit%>"><%=d2DietarHabit%></option>
				<%}else{ %>
				<option value="">select</option>
				<option value="veg">Veg</option>
				<option value="nonveg">Non-Veg</option>
				<%} %>
			</select> <label>Smoking</label> <select id="b23" name="<%=SMOKING %>"
				class="date">
				<%if(!d2Smok.equals("")){			%>
				<option value="<%=d2Smok%>"><%=d2Smok%></option>
				<%}else{ %>
				<option value="">select</option>
				<option value="yes">Yes</option>
				<option value="no">No</option>
				<%}%>
			</select>
			<div class="clear"></div>
			<h4>General Examination</h4>
			<div class="clear"></div>
			<label>Build</label> <input id="b24" name="<%=BUILD %>" type="text"
				value="<%=d2Build %>" maxlength="10" validate="Build,string,no" />
			<label>Nutrition</label> <input id="b25" name="<%=NUTRITION %>"
				type="text" maxlength="10" value="<%=d2Nutri %>"
				validate="Nutrition,string,no" /> <label>Height</label> <input
				value="<%=d2Height %>" id="b26" name="<%=HEIGHT %>" type="text"
				maxlength="10" validate="Height,string,no" />

			<div class="clear"></div>

			<label>Weight</label> <input id="b27" name="<%=WEIGHT %>" type="text"
				value="<%=d2Weight %>" maxlength="6" validate="Weight,string,no" />
			<label>Breast</label> <input id="b28" name="<%=BREAST %>" type="text"
				maxlength="5" value="<%=d2Breast %>" validate="Breast,string,no" />
			<label>Nipple</label> <input id="b29" name="<%=NIPPLE %>" type="text"
				maxlength="5" value="<%=d2Nipple %>" validate="Nipple,string,no" />

			<div class="clear"></div>
			<label>Heart</label> <input id="b30" name="<%=HEART %>" type="text"
				value="<%=d2Heart %>" maxlength="5" validate="Heart,string,no" /> <label>Lungs</label>
			<input value="<%=d2Lungs %>" id="b31" name="<%=LUNGS %>" type="text"
				maxlength="5" validate="LUNGS,string,no" />
			<div class="clear"></div>
		</div>

		<div class="division"></div>
		<div class="clear"></div>
		<%-- 
		<!--  
		<a href="javascript:changeClass('title3','t3')">
			<h5 id='t3'>Details III</h5>
		</a>
		<div class="clear"></div>
		<div class="Block" id="title3">
			<div class="clear"></div>

			<h4>Blood Group</h4>
			<div class="clear"></div>
			<label>Wife</label> <select id="b32" name="<%=BLOOD_GROUP_WIFE %>"
				class="year">
				<option value="">select</option>
				<option value="O+">O+</option>
				<option value="O-">O-</option>
			</select> <label>Husband</label> <select id="b33"
				name="<%=BLOOD_GROUP_HUSBAND %>" class="year">
				<option value="">select</option>
				<option value="A-">A-</option>
				<option value="O-">O-</option>
			</select>
			<div class="clear"></div>
			<label>STS</label> <input id="b34" name="<%=STS %>" type="text"
				size=9 class="Auto" maxlength="10" validate="STS,string,no" /> <label>Hbsag</label>
			<input id="b35" name="<%=HBSAG %>" type="text" size=9 class="Auto"
				maxlength="10" validate="Hbsag,string,no" /> <label>HIV</label> <input
				id="b36" name="<%=HIV %>" type="text" size=9 class="Auto"
				maxlength="10" validate="HIV,string,no" /> <label>GCT</label> <input
				id="b37" type="text" name="<%=GCT %>" class="small" maxlength="10"
				validate="GCT,string,no" /> <label class="small">mg%</label>
			<div class="clear"></div>
			<label>Date</label> <input type="text" class="date" id="date2Id"
				name="<%=EXAMINATION_DATE %>" readonly="readonly" MAXLENGTH="30"
				onblur="checkDate();" /> <img src="/hms/jsp/images/cal.gif"
				width="16" height="16" border="0" validate="Pick a date"
				onClick="setdate('',document.antenatalCard.<%=EXAMINATION_DATE%>,event)"
				onblur="checkDate();" />


			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<div class="tableHolderAuto">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th scope="col">OGTT</th>
						<th scope="col">Fasting</th>
						<th scope="col">1 Hr</th>
						<th scope="col">2 Hr</th>
						<th scope="col">3 Hr</th>
					</tr>

					<tr>
						<td><input id="b38" name="<%=OGTT %>" type="text"
							maxlength="10" validate="OGTT,string,no" /></td>
						<td><input id="b39" name="<%=FASTING %>" type="text"
							maxlength="10" validate="Fasting,string,no" /></td>
						<td><input id="b40" name="<%=ONE_HR %>" type="text"
							maxlength="10" validate="1 Hr,string,no" /></td>
						<td><input id="b41" name="<%=TWO_HR%>" type="text"
							maxlength="10" validate="2 Hr,string,no" /></td>
						<td><input id="b42" name="<%=THREE_HR %>" type="text"
							maxlength="10" validate="3 Hr,string,no" /></td>
					</tr>
				</table>

			</div>
		</div>
		<div class="division"></div>-->--%>
		<div class="clear"></div>
		<a href="javascript:changeClass('title4','t4')">
			<h5 id='t4'>TT Details</h5>
		</a>
		<div class="clear"></div>
		<div class="Block" id="title4">
			<div class="clear"></div>

			<label>High Risk Factors</label> <input id="b43"
				value="<%=d4HigRisk %>" name="<%=HIGH_RISK_FACTORS %>" type="text"
				class="large" maxlength="30" validate="High Risk Factors,string,no" />
			<div class="clear"></div>
			<h4>Immunisation: Tetanus</h4>
			<div class="clear"></div>

			<!-- added by amit das on 08-08-2016 -->
			<% if(tetanusOneDoseDate!=null && tetanusTwoDoseDate!=null) {%>
			<div class="floatLeft" style="width: 500px;">
				<table width="40%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th scope="col">TT1 Date</th>
						<th scope="col">TT2 Date</th>
					</tr>
					<tr
						onclick="changeTTDate('<%=tetanusOneDoseDate%>','<%=tetanusTwoDoseDate%>')">
						<td><label><%=tetanusOneDoseDate%></label></td>
						<td><label><%=tetanusTwoDoseDate%></label></td>
					</tr>
				</table>
			</div>
			<% } %>
			<!-- ended by amit das on 08-08-2016 -->

			<div class="clear"></div>
			<label>1st Dose on</label> <input type="text" class="date"
				id="date3Id" name="<%=TETANUS_ONE_DOSE_DATE %>" readonly="readonly"
				value="<%=d4FirstDose %>" MAXLENGTH="30" onblur="checkDate();" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onClick="setdate('',document.antenatalCard.<%=TETANUS_ONE_DOSE_DATE%>,event)"
				/> <label>2nd Dose on</label> <input
				type="text" class="date" id="date4Id" value="<%=d4SeconDose %>"
				name="<%=TETANUS_TWO_DOSE_DATE %>" readonly="readonly"
				MAXLENGTH="30" onblur="checkDate();" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onClick="setdate('',document.antenatalCard.<%=TETANUS_TWO_DOSE_DATE%>,event)"
				 />

			<div class="clear"></div>
			<label>Willing for Tubectomy</label> <select id="b44"
				name="<%=WILLING_FOR_TUBECTOMY %>" class="year">
				<%if(!d4WillTub.equals("")){			%>
				<option value="<%=d4WillTub%>"><%=d4WillTub%></option>
				<%}else{ %>
				<option value="">select</option>
				<option value="yes">Yes</option>
				<option value="no">No</option>
				<%}%>
			</select>
			<div class="clear"></div>
		</div>
		<%-- 
<!-- 
		<div class="division"></div>
		<div class="clear"></div>
		<a href="javascript:changeClass('title5','t5')">
			<h5 id='t5'>Periodic Antenatal Record</h5>
		</a>
		<div class="clear"></div>
		<div class="Block" id="title5">
			<div class="clear"></div>
			<h4>Previous View</h4>
			<div class="clear"></div>
			<div class="cmntable">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<th scope="col">Edit</th>
						<th scope="col">Date</th>
						<th scope="col">Weight (kg)</th>
						<th scope="col">AnyComplaint</th>
						<th scope="col">Pallor</th>
						<th scope="col">Oedema</th>
						<th scope="col">BP</th>
						<th scope="col">Uterine Size<br /> Weeks/Cms
						</th>
						<th scope="col">Presentation &amp; Position</th>
						<th scope="col">Enagement</th>
						<th scope="col">FHS/FM</th>
						<th scope="col">Urine</th>
						<th scope="col">Hb% gms</th>
						<th scope="col">Next Visit on</th>
						<th scope="col">Advice</th>
					</tr>
					<%
	
  	if(opdAntenatalCardList.size() > 0){
	
	
	Iterator iterator=opdAntenatalCardList.iterator();
	while(iterator.hasNext())
    {           
 	 Object[] pair = (Object[]) iterator.next();
 	 OpdAntenatalCard opdAntenatalCard = (OpdAntenatalCard) pair[0];
 	 
 	
   
%>
					<tr>
						<td><input type="button" name="<%=ANTENATAL_CARD_ID %>"
							value="<%=opdAntenatalCard.getId() %>"
							onclick="get_valueForEdit(<%=opdAntenatalCard.getId() %>);"></td>
						<td><input
							value="<%=HMSUtil.changeDateToddMMyyyy(opdAntenatalCard.getLastChgDate()) %>"
							type="text" size=5 maxlength="5" class="readOnly"
							readonly="readonly" /></td>
						<td><input name="<%=WEIGHT_ANTENATAL_EDIT %>"
							value="<%=opdAntenatalCard.getWeight() %>" type="text" size=5
							maxlength="5" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=ANY_COMPLIANT_EDIT %>"
							value="<%=opdAntenatalCard.getAnyCompliant() %>" type="text"
							maxlength="25" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=PARLLOR_EDIT %>"
							value="<%=opdAntenatalCard.getParllor() %>" type="text" size=10
							maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=OEDEMA_EDIT %>"
							value="<%=opdAntenatalCard.getOedema() %>" type="text" size=10
							maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=BP_EDIT %>"
							value="<%=opdAntenatalCard.getBp() %>" type="text" size=2
							maxlength="6" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=UTERINE_SIZE_EDIT %>"
							value="<%=opdAntenatalCard.getUterineSize() %>" type="text"
							size=10 maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=PRESENTATION_POSITION_EDIT %>"
							value="<%=opdAntenatalCard.getPresentationPosition() %>"
							type="text" size=10 maxlength="15" class="readOnly"
							readonly="readonly" /></td>
						<td><input name="<%=ENGAGEMENT_EDIT %>"
							value="<%=opdAntenatalCard.getEngagement() %>" type="text"
							size=10 maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input id="f1" name="<%=FHS_FM_EDIT %>"
							value="<%=opdAntenatalCard.getFhsFm() %>" type="text" size=10
							maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input id="f2" name="<%=URINE_EDIT %>"
							value="<%=opdAntenatalCard.getUrine() %>" type="text" size=10
							maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input id="f3" name="<%=HB_GMS_EDIT %>"
							value="<%=opdAntenatalCard.getHbGms() %>" type="text" size=10
							maxlength="15" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=NEXT_VISIT_ON_EDIT %>"
							value="<%=HMSUtil.changeDateToddMMyyyy(opdAntenatalCard.getNextVisitOn()) %>"
							size="10" class="readOnly" readonly="readonly" /></td>
						<td><input name="<%=ADVICE_EDIT %>"
							value="<%=opdAntenatalCard.getAdvice() %>" type="text" size=10
							maxlength="15" class="readOnly" readonly="readonly" /></td>
					</tr>



					<%}}else{%>

					<tr>
						<td><input value="-" type="text" size=5 maxlength="5"
							class="readOnly" readonly="readonly" /></td>
						<td><input value="-" type="text" size=5 maxlength="5"
							class="readOnly" readonly="readonly" /></td>
						<td><input value="-" type="text" size=5 maxlength="5"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" maxlength="25"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=2 maxlength="6"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
						<td><input value="-" size="10" readonly="readonly" /></td>
						<td><input value="-" type="text" size=10 maxlength="15"
							readonly="readonly" class="readOnly" /></td>
					</tr>

					<%} %>
				</table>

			</div>
			<div class="clear"></div>
			<input name="" type="button" class="button" value="Print" />

			<div class="clear"></div>
			<h4>Present Records</h4>
			<div class="clear"></div>
			<div class="cmntable">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>

						<th scope="col">Weight (kg)</th>
						<th scope="col">Any Complaint</th>
						<th scope="col">Pallor</th>
						<th scope="col">Oedema</th>
						<th scope="col">BP</th>
						<th scope="col">Uterine Size<br /> Weeks/Cms
						</th>
						<th scope="col">Presentation &amp; Position</th>
						<th scope="col">Enagement</th>
						<th scope="col">FHS/FM</th>
						<th scope="col">Urine</th>
						<th scope="col">Hb% gms</th>
						<th scope="col">Next Visit on</th>
						<th scope="col">Advice</th>
					</tr>
					<tr>

						<td><input id="b45" name="<%=WEIGHT_ANTENATAL %>" type="text"
							size=5 maxlength="5" validate="Weight(kg) Code,string,no" /></td>
						<td><input id="b46" name="<%=ANY_COMPLIANT %>" type="text"
							maxlength="25" validate="Any Complaint Code,string,no" /></td>
						<td><input id="b47" name="<%=PARLLOR%>" type="text" size=10
							maxlength="15" validate="Pallor Code,string,no" /></td>
						<td><input id="b48" name="<%=OEDEMA%>" type="text" size=10
							maxlength="15" validate="Oedema Code,string,no" /></td>
						<td><input id="b49" name="<%=BP %>" type="text" size=2
							maxlength="6" validate="BP,string,no" /></td>
						<td><input id="b50" name="<%=UTERINE_SIZE %>" type="text"
							size=10 maxlength="15" validate="Uterine Size,string,no" /></td>
						<td><input id="b51" name="<%=PRESENTATION_POSITION %>"
							type="text" size=10 maxlength="15"
							validate="Presentation & Position,string,no" /></td>
						<td><input id="b52" name="<%=ENGAGEMENT %>" type="text"
							size=10 maxlength="15" validate="Enagement,string,no" /></td>
						<td><input id="b53" name="<%=FHS_FM %>" type="text" size=10
							maxlength="15" validate="FHS/FM,string,no" /></td>
						<td><input id="b54" name="<%=URINE %>" type="text" size=10
							maxlength="15" validate="Urine,string,no" /></td>
						<td><input id="b55" name="<%=HB_GMS %>" type="text" size=10
							maxlength="15" validate="Hb% gms,string,no" /></td>
						<td><input type="text" class="date" id="date5Id"
							name="<%=NEXT_VISIT_ON %>" readonly="readonly" MAXLENGTH="30"
							onblur="checkDate();" /> <img src="/hms/jsp/images/cal.gif"
							width="16" height="16" border="0" validate="Pick a date"
							onClick="setdate('',document.antenatalCard.<%=NEXT_VISIT_ON%>,event)"
							onblur="checkDate();" /></td>

						<td><input id="b56" name="<%=ADVICE %>" type="text" size=10
							maxlength="15" validate="Advice,string,no" /></td>
					</tr>
				</table>

			</div>
			<div class="clear"></div>
		</div>
-->--%>
		<!-- govind code start -->
		<div class="division"></div>
		<div class="clear"></div>
		<a href="javascript:changeClass('title6','t6')">
			<h5 id='t6'>USG</h5>
		</a>
		<div class="clear"></div>
		<div class="Block" id="title6" style="margin-left: 50px">
			<div class="floatRight" style="width: 300px;">
				<input type="button" class="buttonDel" value=""
					onclick="removeRow1('usgTable');" /> <input type="button"
					class="buttonAdd" onclick="addUSGRow();" value="" />
			</div>
			<div class="clear"></div>
			<div class="">
				<div class="tableForTab"
					style="width: 1000px; height: 200px; overflow: scroll;">
					<div id="divTemplet1">

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="usgTable">
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">Date</th>
								<th scope="col">USG Details</th>
							</tr>
							<%					   								
							if(usgDetailList.size()>0){
								for(UsgDetails usg:usgDetailList){
													%>
							<tr>
								<td></td>
								<td><input type="text" value="<%=usg.getUsgDate() %>"
									class="dateTextSmall" readonly="readonly"> <img
									src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
									validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.usgDate,event);" /></td>
								<td><textarea class="opdMainTextArea" maxlength="300"><%=usg.getUsgDetail() %></textarea>
							</tr>
							<%}
								} %>
							<%
							int usgincr = 0, lenUsg = 1;
							int usginxRow = 1;
							int usginxCol = 0;
							for (; usgincr < lenUsg; usgincr++, usginxRow++) {
						%>
							<tr>
								<td><input type="checkbox"
									tabindex="<%=usginxRow%><%=usginxCol + 1%>" class="radioCheck"
									id="usgitemRadio<%=usgincr%>" name="usgitemRadio<%=usgincr%>"
									onchange="checkPrescriptionCheck(<%=usgincr%>)" /></td>
								<td><input type="text" id="usgDate<%=usgincr%>"
									name="usgDate<%=usgincr%>"
									tabindex="<%=usginxRow%><%=usginxCol + 2%>"
									class="dateTextSmall" readonly="readonly"> <img
									src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
									validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.usgDate<%=usgincr%>,event);" /></td>
								<td><textarea class="opdMainTextArea"
										name="usgFld<%=usgincr%>" id="usgFld<%=usgincr%>"
										maxlength="300" tabindex="<%=usginxRow%><%=usginxCol + 3%>"></textarea>
							</tr>
							<%
							}
						%>
						</table>
						<input type="hidden" name="usghdb" value="<%=usgincr - 1%>"
							id="usghdb" /> <input type="hidden" name="usghdbTabIndex"
							id="usghdbTabIndex" value="<%=usginxRow - 1%>" />
					</div>
				</div>
			</div>
		</div>
		<div class="division"></div>
		<div class="clear"></div>
		<a href="javascript:changeClass('title7','t7')">
			<h5 id='t7'>CLINICAL EXAMINATION CHART</h5>
		</a>
		<div class="clear"></div>
		<div class="Block" id="title7" style="margin-left: 50px;">
			<div class="clear"></div>
			<a href="javascript:showHideTrim('ftDiv1','ftH5')">
				<h5 id="ftH5">FIRST TRIMESTER</h5>
			</a>
			<!-- <h4 id='t9'>FIRST TRIMESTER</h4> -->
			<div class="clear"></div>
			<div class="Block" id="ftDiv1">
				<div class="clear"></div>
				<div class="floatRight" style="width: 300px;">
					<input type="button" class="buttonDel" value=""
						onclick="removeRow1('ftTable');" /> <input type="button"
						class="buttonAdd" onclick="addRow1();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab"
						style="width: 1000px; height: 200px; overflow: scroll;">
						<div id="divTemplet1">

							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="ftTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">GA</th>
									<th scope="col">BP</th>
									<th scope="col">P/A</th>
									<th scope="col">P/V</th>
									<th scope="col">Weight</th>
								</tr>
								<%
					   								
							if(opdAntenatalCardTrim1.size()>0){
								int count=0;
								
								for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim1){
									count=count+1;
									 //govind code 20-8-2016
									 if(trim.getTrimesterType()==1){
									 if(trim.getCvs()!=null){
										 cvs=trim.getCvs();
									 }			 
									 if(trim.getRespSystem()!=null){
										respSystem=trim.getRespSystem();
									 }
									 if(trim.getFtAdvice()!=null){
										 ftAdvise=trim.getFtAdvice();
									 }	
									 if(trim.getAntFtdae()!=null ){
										 String ftDateAr[]=trim.getAntFtdae().toString().split("-");
										 ftDate=ftDateAr[2]+"/"+ftDateAr[1]+"/"+ftDateAr[0];
									 }		 
									 }
									 //govind code 20-8-2016
								%>


								<!-- govind code 5-8 -->
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><input type="text"
										value="<%=trim.getTrimesDate()%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										value="<%=trim.getGaWeeks()%>" type="text" size="10"
										placeholder="Weeks" maxlength="45" readonly="readonly" /> <input
										class="opdTextBoxTSmall" value="<%=trim.getGaDays()%>"
										type="text" size="10" placeholder="Days" maxlength="45"
										readonly="readonly" /></td>
									<td scope="col"><input value="<%=trim.getBpSystolics()%>"
										placeholder="Systolic" type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall"
										readonly="readonly" /> <label class="smallAuto autoSpace">/</label>
										<input value="<%=trim.getBpDiastolics()%>"
										placeholder="Diastolic" type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall"
										readonly="readonly" /><label class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea maxlength="300"
											readonly="readonly"><%=trim.getPaTrimes()%></textarea></td>
									<td scope="col"><textarea maxlength="300"
											readonly="readonly"><%=trim.getPvTrimes()%></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										value="<%=trim.getWeight()%>" type="text" size="10"
										maxlength="45" readonly="readonly" /></td>
								</tr>
								<!-- govind code 5-8 end-->
								<%	}
								
							}
								int incr = 0,len=1;
								int inxRow = 1;
								int inxCol = 0;
							for(;incr< len;incr++,inxRow++){
					%>
								<tr>
									<td scope="col"><input type="checkbox"
										tabindex="<%=inxRow%><%=inxCol + 1%>" class="radioCheck"
										id="itemRadio<%=incr%>" name="itemRadio<%=incr%>"
										onchange="checkPrescriptionCheck(<%=incr%>)" /></td>
									<td scope="col"><input type="text" id="ftdate<%=incr%>" 
										name="ftdate<%=incr%>" tabindex="<%=inxRow%><%=inxCol + 2%>"
										class="dateTextSmall" readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.ftdate<%=incr%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow%><%=inxCol + 3%>" type="text"
										name="ftGA1<%=incr%>" id="ftGA1<%=incr%>" size="10" validate="Weeks,num,no"
										placeholder="Weeks" maxlength="45" /> <input
										class="opdTextBoxTSmall" tabindex="<%=inxRow%><%=inxCol + 4%>" validate="Days,num,no"
										type="text" name="ftGA2<%=incr%>" id="ftGA2<%=incr%>"
										size="10" placeholder="Days" maxlength="45" /></td>
									<td scope="col"><input name="ftsystolic<%=incr%>" validate="Systolic,num,no"
										id="ftsystolic<%=incr%>" placeholder="Systolic"
										tabindex="<%=inxRow%><%=inxCol + 5%>" type="text"
										maxlength="3" class="allownumericwithoutdecimal textSmall" />
										<label class="smallAuto autoSpace">/</label> <input
										name="ftdiastolic<%=incr%>" id="ftdiastolic<%=incr%>" validate="Diastolic,num,no"
										tabindex="<%=inxRow%><%=inxCol + 6%>" placeholder="Diastolic"
										type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea
											tabindex="<%=inxRow%><%=inxCol + 7%>" name="ftPA<%=incr%>"
											id="ftPA<%=incr%>" maxlength="300"></textarea></td>
									<td scope="col"><textarea class="opdTextBoxTSmall"
											tabindex="<%=inxRow%><%=inxCol + 8%>" name="ftPV<%=incr%>"
											id="ftPV<%=incr%>" maxlength="300"></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall" validate="Weight,num,no"
										tabindex="<%=inxRow%><%=inxCol + 9%>" type="text"
										name="ftWeight<%=incr%>" id="ftWeight<%=incr%>" size="10"
										maxlength="45" /></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" />
							<input type="hidden" name="hdbTabIndex" id="hdbTabIndex"
								value="<%=inxRow-1%>" />
						</div>
					</div>
					<div class="clear"></div>
					<div class="floatLeft" style="width: 500px; margin-left: 20px;">
						<table width="40%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th scope="col">CVS</th>
								<th scope="col">RESP SYSTEM</th>
							</tr>
							<tr>
								<td><textarea class="opdMainTextArea" name="ftCVS"
										id="ftCVS" maxlength="300"><%=cvs %></textarea></td>
								<td><textarea class="opdMainTextArea" name="ftRespSys"
										id="ftRespSys" maxlength="300"><%=respSystem %></textarea></td>
							</tr>
						</table>
						<div class="clear"></div>
						<div class="clear"></div>
						<table width="40%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th scope="col">DATE</th>
								<th scope="col">ADVISE</th>
							</tr>
							<tr>
								<td><input name="ftSubDate" type="text" id="ftSubDate"
									value="<%=ftDate %>" class="dateTextSmall" readonly="readonly" />
									<img src="/hms/jsp/images/cal.gif" width="16" height="16"
									border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.antenatalCard.ftSubDate,event);" />
								</td>
								<td><textarea class="opdMainTextArea" name="ftAdvise"
										id="ftAdvise" maxlength="300"><%=ftAdvise %></textarea></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- second trimester -->
			<div class="clear"></div>
			<div class="division"></div>
			<a href="javascript:showHideTrim('ftDiv2','stH5')">
				<h5 id="stH5">SECOND TRIMESTER</h5>
			</a>
			<!-- <h4 id='t9'>SECOND TRIMESTER</h4>     -->
			<div class="clear"></div>
			<div class="Block" id="ftDiv2">
				<div class="clear"></div>
				<div class="floatRight" style="width: 300px;">
					<input type="button" class="buttonDel" value=""
						onclick="removeRow1('stTable');" /> <input type="button"
						class="buttonAdd" onclick="addRow2();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab"
						style="width: 1000px; height: 200px; overflow: scroll;">
						<div id="divTemplet1">

							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="stTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">GA</th>
									<th scope="col">BP</th>
									<th scope="col">P/A</th>
									<th scope="col">Weight</th>
									<th scope="col">Urine Albumin</th>
								</tr>
								<%
					   int incr1 = 0,len1=1;
						int inxRow1 = 1;
						int inxCol1 = 0;
						if(opdAntenatalCardTrim2.size()>0){
							int count=0;
							for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim2){
								count=count+1;
							%>
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><input type="text"
										value="<%=trim.getTrimesDate()%>"
										tabindex="<%=inxRow1%><%=inxCol1 + 2%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.stdate<%=incr1%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 3%>" type="text" size="10"
										value="<%=trim.getGaWeeks()%>" placeholder="Weeks" 
										maxlength="45" /> <input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 4%>" type="text" size="10"
										value="<%=trim.getGaDays()%>" placeholder="Days" 
										maxlength="45" /></td>
									<td scope="col"><input placeholder="Systolic" 
										tabindex="<%=inxRow1%><%=inxCol1 + 5%>" type="text"
										maxlength="3" value="<%=trim.getBpSystolics()%>"
										class="allownumericwithoutdecimal textSmall" /> <label
										class="smallAuto autoSpace">/</label> <input
										tabindex="<%=inxRow1%><%=inxCol1 + 6%>"
										value="<%=trim.getBpDiastolics()%>" placeholder="Diastolic" 
										type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea maxlength="300"
											readonly="readonly"><%=trim.getPaTrimes()%></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall" 
										tabindex="<%=inxRow1%><%=inxCol1 + 8%>" type="text"
										value="<%=trim.getWeight()%>" size="10" maxlength="45" /></td>
									<td scope="col">
										<%String urinAlbumin="";
							if(trim.getUrinAlbumin()!=null){
								urinAlbumin=trim.getUrinAlbumin();
							}
							%> <input class="opdTextBoxTSmall" 
										tabindex="<%=inxRow1%><%=inxCol1 + 9%>" type="text"
										value="<%=urinAlbumin%>" size="10" maxlength="45" />
									</td>
								</tr>
								<%
							}
						}
						for(;incr1< len;incr1++,inxRow1++){
					%>
								<tr>
									<td scope="col"><input type="checkbox"
										tabindex="<%=inxRow1%><%=inxCol1 + 1%>" class="radioCheck"
										id="itemRadio1<%=incr1%>" name="itemRadio1<%=incr1%>"
										onchange="checkPrescriptionCheck(<%=incr1%>)" /></td>
									<td scope="col"><input type="text" id="stdate<%=incr1%>"
										name="stdate<%=incr1%>"
										tabindex="<%=inxRow1%><%=inxCol1 + 2%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.stdate<%=incr1%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 3%>" type="text"  validate="Weeks,num,no"
										name="stGA1<%=incr1%>" id="stGA1<%=incr1%>" size="10"
										placeholder="Weeks" maxlength="45" /> <input
										class="opdTextBoxTSmall" validate="Days,num,no"
										tabindex="<%=inxRow1%><%=inxCol1 + 4%>" type="text"
										name="stGA2<%=incr1%>" id="stGA2<%=incr1%>" size="10"
										placeholder="Days" maxlength="45" /></td>
									<td scope="col"><input name="stsystolic<%=incr1%>" 
										id="stsystolic<%=incr1%>" placeholder="Systolic" validate="Systolic,num,no"
										tabindex="<%=inxRow1%><%=inxCol1 + 5%>" type="text"
										maxlength="3" class="allownumericwithoutdecimal textSmall" />
										<label class="smallAuto autoSpace">/</label> <input
										name="stdiastolic<%=incr1%>" id="stdiastolic<%=incr1%>"
										tabindex="<%=inxRow1%><%=inxCol1 + 6%>"
										placeholder="Diastolic" type="text" maxlength="3" validate="Diastolic,num,no"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea class="opdTextBoxTSmall"
											tabindex="<%=inxRow1%><%=inxCol1 + 7%>" name="stPA<%=incr1%>"
											id="stPA<%=incr1%>" maxlength="300"></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 8%>" type="text"
										name="stWeight<%=incr1%>" id="stWeight<%=incr1%>" size="10" validate="Weight,num,no"
										maxlength="45" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 9%>" type="text"
										name="stUrinAl<%=incr1%>" id="stUrinAl<%=incr1%>" size="10" validate="Urine Albumin,num,no"
										maxlength="45" /></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="hdb1" value="<%=incr1-1 %>" id="hdb1" />
							<input type="hidden" name="hdbTabIndex1" id="hdbTabIndex1"
								value="<%=inxRow1-1%>" />
						</div>
					</div>
				</div>
			</div>
			<!-- third trimester -->
			<div class="clear"></div>
			<div class="division"></div>

			<a href="javascript:showHideTrim('ftDiv3','ttH5')">
				<h5 id="ttH5">THIRD TRIMESTER</h5>
			</a>
			<!-- <h4 id='t9'>THIRD TRIMESTER</h4> -->
			<div class="clear"></div>
			<div class="Block" id="ftDiv3">
				<div class="clear"></div>
				<div class="floatRight" style="width: 300px;">
					<input type="button" class="buttonDel" value=""
						onclick="removeRow1('ttTable');" /> <input type="button"
						class="buttonAdd" onclick="addRow3();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab"
						style="width: 1000px; height: 200px; overflow: scroll;">
						<div id="divTemplet1">

							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="ttTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">GA</th>
									<th scope="col">BP</th>
									<th scope="col">P/A</th>
									<th scope="col">Weight</th>
									<th scope="col">Urine Albumin</th>
								</tr>
								<%
					   int incr2 = 0,len2=1;
						int inxRow2 = 1;
						int inxCol2 = 0;
						if(opdAntenatalCardTrim3.size()>0){
							int count=0;
							for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim3){
							count=count+1;
							%>
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><input type="text"
										value="<%=trim.getTrimesDate()%>"
										tabindex="<%=inxRow1%><%=inxCol1 + 2%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.stdate<%=incr1%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 3%>" type="text" size="10"
										value="<%=trim.getGaWeeks()%>" placeholder="Weeks"
										maxlength="45" /> <input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 4%>" type="text" size="10"
										value="<%=trim.getGaDays()%>" placeholder="Days"
										maxlength="45" /></td>
									<td scope="col"><input placeholder="Systolic"
										tabindex="<%=inxRow1%><%=inxCol1 + 5%>" type="text"
										maxlength="3" value="<%=trim.getBpSystolics()%>"
										class="allownumericwithoutdecimal textSmall" /> <label
										class="smallAuto autoSpace">/</label> <input
										tabindex="<%=inxRow1%><%=inxCol1 + 6%>"
										value="<%=trim.getBpDiastolics()%>" placeholder="Diastolic"
										type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea maxlength="300"
											readonly="readonly"><%=trim.getPaTrimes()%></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 8%>" type="text"
										value="<%=trim.getWeight()%>" size="10" maxlength="45" /></td>
									<td scope="col">
										<%String urinAlbumin="";
							if(trim.getUrinAlbumin()!=null){
								urinAlbumin=trim.getUrinAlbumin();
							}
							%> <input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 9%>" type="text"
										value="<%=urinAlbumin%>" size="10" maxlength="45" />
									</td>
								</tr>
								<%
							}
						}
						for(;incr2< len;incr2++,inxRow2++){
					%>
								<tr>
									<td scope="col"><input type="checkbox"
										tabindex="<%=inxRow2%><%=inxCol2 + 1%>" class="radioCheck"
										id="itemRadio2<%=incr2%>" name="itemRadio2<%=incr2%>"
										onchange="checkPrescriptionCheck(<%=incr2%>)" /></td>
									<td scope="col"><input type="text" id="ttdate<%=incr2%>"
										name="ttdate<%=incr2%>"
										tabindex="<%=inxRow2%><%=inxCol2 + 2%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.ttdate<%=incr2%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow2%><%=inxCol2 + 3%>" type="text" validate="Weeks,num,no"
										name="ttGA1<%=incr2%>" id="ttGA1<%=incr2%>" size="10"
										placeholder="Weeks" maxlength="45" /> <input
										class="opdTextBoxTSmall"
										tabindex="<%=inxRow2%><%=inxCol2 + 4%>" type="text" validate="Days,num,no"
										name="ttGA2<%=incr2%>" id="ttGA2<%=incr2%>" size="10"
										placeholder="Days" maxlength="45" /></td>
									<td scope="col"><input name="ttsystolic<%=incr2%>"
										id="ttsystolic<%=incr2%>" placeholder="Systolic" validate="Systolic,num,no"
										tabindex="<%=inxRow2%><%=inxCol2 + 5%>" type="text"
										maxlength="3" class="allownumericwithoutdecimal textSmall" />
										<label class="smallAuto autoSpace">/</label> <input
										name="ttdiastolic<%=incr2%>" id="ttdiastolic<%=incr2%>"
										tabindex="<%=inxRow2%><%=inxCol2 + 6%>"
										placeholder="Diastolic" type="text" maxlength="3" validate="Diastolic,num,no"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea class="opdTextBoxTSmall"
											tabindex="<%=inxRow2%><%=inxCol2 + 7%>" name="ttPA<%=incr2%>"
											id="ttPA<%=incr2%>" maxlength="45"></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow2%><%=inxCol2 + 8%>" type="text" validate="Weight,num,no"
										name="ttWeight<%=incr2%>" id="ttWeight<%=incr2%>" size="10"
										maxlength="45" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow2%><%=inxCol2 + 9%>" type="text"
										name="ttUrinAl<%=incr2%>" id="ttUrinAl<%=incr2%>" size="10" validate="Urine Albumin,num,no"
										maxlength="45" /></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="hdb2" value="<%=incr2-1 %>" id="hdb2" />
							<input type="hidden" name="hdbTabIndex2" id="hdbTabIndex2"
								value="<%=inxRow2-1%>" />
						</div>
					</div>
				</div>
			</div>
			<!-- Fourth Trimester -->
			<a href="javascript:showHideTrim('ftDiv4','f4tH5')">
				<h5 id="f4tH5">FOURTH TRIMESTER</h5>
			</a>
			<!-- <h4 id='t10'>FOURTH TRIMESTER</h4> -->
			<div class="clear"></div>
			<div class="Block" id="ftDiv4">
				<div class="clear"></div>
				<div class="floatRight" style="width: 300px;">
					<input type="button" class="buttonDel" value=""
						onclick="removeRow1('f4tTable');" /> <input type="button"
						class="buttonAdd" onclick="addRow4();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab"
						style="width: 1000px; height: 200px; overflow: scroll;">
						<div id="divTemplet1">

							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="f4tTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">GA</th>
									<th scope="col">BP</th>
									<th scope="col">P/A</th>
									<th scope="col">Weight</th>
									<th scope="col">Urine Albumin</th>
								</tr>
								<%
					   int incr3 = 0,len3=1;
						int inxRow3 = 1;
						int inxCol3 = 0;
						if(opdAntenatalCardTrim4.size()>0){
							int count=0;
							for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim4){
								count=count+1;
							%>
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><input type="text"
										value="<%=trim.getTrimesDate()%>"
										tabindex="<%=inxRow1%><%=inxCol1 + 2%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.stdate<%=incr1%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 3%>" type="text" size="10"
										value="<%=trim.getGaWeeks()%>" placeholder="Weeks"
										maxlength="45" /> <input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 4%>" type="text" size="10"
										value="<%=trim.getGaDays()%>" placeholder="Days"
										maxlength="45" /></td>
									<td scope="col"><input placeholder="Systolic"
										tabindex="<%=inxRow1%><%=inxCol1 + 5%>" type="text"
										maxlength="3" value="<%=trim.getBpSystolics()%>"
										class="allownumericwithoutdecimal textSmall" /> <label
										class="smallAuto autoSpace">/</label> <input
										tabindex="<%=inxRow1%><%=inxCol1 + 6%>"
										value="<%=trim.getBpDiastolics()%>" placeholder="Diastolic"
										type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea maxlength="300"
											readonly="readonly"><%=trim.getPaTrimes()%></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 8%>" type="text"
										value="<%=trim.getWeight()%>" size="10" maxlength="45" /></td>
									<td scope="col">
										<%String urinAlbumin="";
							if(trim.getUrinAlbumin()!=null){
								urinAlbumin=trim.getUrinAlbumin();
							}%> <input class="opdTextBoxTSmall"
										tabindex="<%=inxRow1%><%=inxCol1 + 9%>" type="text"
										value="<%=urinAlbumin%>" size="10" maxlength="45" />
									</td>
								</tr>
								<%
							}
						}
						for(;incr3< len;incr3++,inxRow3++){
					%>
								<tr>
									<td scope="col"><input type="checkbox"
										tabindex="<%=inxRow3%><%=inxCol3 + 1%>" class="radioCheck"
										id="itemRadio3<%=incr3%>" name="itemRadio3<%=incr3%>"
										onchange="checkPrescriptionCheck(<%=incr3%>)" /></td>
									<td scope="col"><input type="text" id="f4tdate<%=incr3%>"
										name="f4tdate<%=incr3%>"
										tabindex="<%=inxRow3%><%=inxCol3 + 2%>" class="dateTextSmall"
										readonly="readonly"> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.antenatalCard.f4tdate<%=incr3%>,event);" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow3%><%=inxCol3 + 3%>" type="text" validate="Weeks,num,no"
										name="f4tGA1<%=incr3%>" id="f4tGA1<%=incr3%>" size="10"
										placeholder="Weeks" maxlength="45" /> <input
										class="opdTextBoxTSmall" validate="Days,num,no"
										tabindex="<%=inxRow3%><%=inxCol3 + 4%>" type="text"
										name="f4tGA2<%=incr3%>" id="f4tGA2<%=incr3%>" size="10"
										placeholder="Days" maxlength="45" /></td>
									<td scope="col"><input name="f4tsystolic<%=incr3%>"
										id="f4tsystolic<%=incr3%>" placeholder="Systolic" validate="Systolic,num,no"
										tabindex="<%=inxRow3%><%=inxCol3 + 5%>" type="text"
										maxlength="3" class="allownumericwithoutdecimal textSmall" />
										<label class="smallAuto autoSpace">/</label> <input
										name="f4tdiastolic<%=incr3%>" id="f4tdiastolic<%=incr3%>"
										tabindex="<%=inxRow3%><%=inxCol3 + 6%>"
										placeholder="Diastolic" type="text" maxlength="3" validate="Diastolic,num,no"
										class="allownumericwithoutdecimal textSmall" /><label
										class="smallAuto autoSpace">mm&nbsp;Hg</label></td>
									<td scope="col"><textarea class="opdTextBoxTSmall"
											tabindex="<%=inxRow3%><%=inxCol3 + 7%>"
											name="f4tPA<%=incr3%>" id="f4tPA<%=incr3%>" maxlength="300"></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow3%><%=inxCol3 + 8%>" type="text"
										name="f4tWeight<%=incr3%>" id="f4tWeight<%=incr3%>" size="10" validate="Weight,num,no"
										maxlength="45" /></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										tabindex="<%=inxRow3%><%=inxCol3 + 9%>" type="text"
										name="f4tUrinAl<%=incr3%>" id="f4tUrinAl<%=incr3%>" size="10" validate="Weight,num,no"
										maxlength="45" /></td>
								</tr>

								<%} %>
							</table>
							<input type="hidden" name="hdb3" value="<%=incr3-1 %>" id="hdb3" />
							<input type="hidden" name="hdbTabIndex3" id="hdbTabIndex3"
								value="<%=inxRow3-1%>" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- govind end -->

		<div class="division"></div>


		<%--<input name="" type="button" class="buttonBig" value="Gravidagram HTN"
	onclick="get_valueForGravidagramHTN(<%=visit.getId()%>);" /> <input
	name="" type="button" class="buttonBig" value="Gravidagram GDM1"
	onclick="get_valueForGravidagramGestationalDiabitiesOne(<%=visit.getId()%>);" />
<input name="" type="button" class="buttonBig" value="Gravidagram GDM2"
	onclick="get_valueForGravidagramGestationalDiabitiesTwo(<%=visit.getId()%>);" />--%>
		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>
		<!-- govind code -->
		<input id="existAnt" name="existAnte" type="hidden" value="<%=exist%>" />
		<input id="antCardId" name="antCardId" type="hidden"
			value="<%=antCardId%>" /> <input id="usgCount" name="usgCount"
			type="hidden" value="0" /> <input id="ftCount" name="ftCount"
			type="hidden" value="0" /> <input id="stCount" name="stCount"
			type="hidden" value="0" /> <input id="ttCount" name="ttCount"
			type="hidden" value="0" /> <input id="f4tCount" name="f4tCount"
			type="hidden" value="0" /> <input id="AntCount" name="AntCount"
			type="hidden" value="0" /> <input id="SomeField" name="SomeField"
			type="hidden" value="0" />
		<!-- govind code -->
		<input type="button" class="button" value="Submit"
			onclick="if(antenValid() && usgValid() && ftTrimValid() && stTrimValid() && ttTrimValid() && f4tTrimValid()){submitForm('antenatalCard','opd?method=addAntenatalCard','checkDate','blankSpace');}"
			align="right" /> <input type="hidden" class="button" value="View"
			onclick="submitForm('antenatalCard','opd?method=viewAntenatalCard&flag=prev&viewScreen=no');" />
		<input type="button" name="Back" value="Cancel" class="button"
			onclick="setValue();" />

		<!-- 	<input type="button"  value="Check" class="button"
			onclick="blankSpace();antenValid();ftTrimValid();stTrimValid();ttTrimValid();f4tTrimValid();" />   -->
		<script type="text/javascript">
function setValue(){
	window.close();
}
</script>
		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>


		<div class="bottom">
			<label>Changed By</label> <label class="value"><%=userName %></label>

			<label>Changed Date</label> <label class="value"><%=dateC%></label> <label>Changed
				Time</label> <label class="value"><%=time%></label>
		</div>
		<div class="clear"></div>
		<div class="paddingTop40"></div>

		<input type="hidden" name="<%=HIN_ID %>"
			value="<%=visit.getHin().getId() %>"> <input type="hidden"
			name="<%=VISIT_ID %>" value="<%=visit.getId() %>"><input
			type="hidden" name="<%=VISIT_NUMBER %>"
			value="<%=visit.getVisitNo() %>"><input type="hidden"
			name="currentVisitId" value="<%=visit.getId() %>">
		<!--Main Div Ends-->
	</form>
</div>

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}

function showHideTrim(div1,id){
	var str=document.getElementById(id).getAttribute('class');
	if(str=="minus"){
	document.getElementById(id).setAttribute('class','plus');
	}else if(str==null){
		document.getElementById(id).setAttribute('class','minus');
	}else{
		document.getElementById(id).setAttribute('class','minus');
	}
	
$("#"+div1).animate({
	height: 'toggle'
});
}

// added by amit das on 08-08-2016
function changeTTDate(tt1Date, tt2Date){
	document.getElementById("date3Id").value = tt1Date;
	document.getElementById("date4Id").value = tt2Date;
}


</script>
<script type="text/javascript" src="/hms/jsp/js/antenatal.js"></script>