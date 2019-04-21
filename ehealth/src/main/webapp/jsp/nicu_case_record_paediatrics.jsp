
<%@page import="jkt.hms.masters.business.OpdNicuCaseRecord"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<form method="post" action="" >
<%
Map<String,Object> map=new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
   }
int hinId = 0;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
System.out.println("hinId==="+hinId);

		
				List<OpdNicuCaseRecord> opdNicuCaseRecordList = new ArrayList<OpdNicuCaseRecord>();
				
				if(map.get("opdNicuCaseRecordList")!= null){
					opdNicuCaseRecordList = (List)map.get("opdNicuCaseRecordList");
				}
				System.out.println("opdNicuCaseRecordList...."+opdNicuCaseRecordList.size());
				if(opdNicuCaseRecordList.size()>0){
					for(OpdNicuCaseRecord opdNicuCaseRecord :opdNicuCaseRecordList){


%>

<div class="titleBg">
<h2>New Ballard Score</h2>
</div>
<div class="Block">
<input id="nicuFlag" name="nicuFlag" tabindex="1" value="NicuCaseRecord" type="hidden"  />
<input type="hidden" name="templateName" value="Nicu CaseRecord"/>


<div class="clear"></div>
<h4>Neuromuscular Maturity</h4>
<div class="clear"></div>
<input name="button4" type="button" align="right" class="buttonBig"	value="Weight Percentiles" onClick="submitForm('opdMain','opd?method=printWeightPercentiles&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="Height Percentiles" onClick="submitForm('opdMain','opd?method=printHeightPercentiles&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="Head Circumference Percentiles" onClick="submitForm('opdMain','opd?method=printHeadCircumferencePercentiles&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="BMI Chart" onClick="submitForm('opdMain','opd?method=printBMIChart&hinId=<%=hinId %>');"  />
<div class="clear"></div>
<div class="tableForNumbers">
<table border="0"  cellpadding="0" cellspacing="0"	id="grid" style="background:#fff;">
<tr>
<th></th>
<th>-1</th>
<th>0</th>
<th>1</th>
<th>2</th>
<th>3</th>
<th>4</th>
<th>5</th>
</tr>

<tr>
<th>Posture</th>
<td></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-0.jpg"  />
<%if(opdNicuCaseRecord.getPosture()!=null && !opdNicuCaseRecord.getPosture().equals("")){ %>
<input type="checkbox" name="posture" value="p0"  checked="checked" />
<%}else{ %>
<input  type="checkbox" name="posture" value="p0"  />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-1.jpg"  />
<%if(opdNicuCaseRecord.getPosture1()!=null  && !opdNicuCaseRecord.getPosture1().equals("")){ %>
<input  type="checkbox" name="posture1" value="p1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="posture1" value="p1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-2.jpg"  />
<%if(opdNicuCaseRecord.getPosture2()!=null  && !opdNicuCaseRecord.getPosture2().equals("")){ %>
<input  type="checkbox" name="posture2" value="p2" checked="checked"/>

<%}else{ %>
<input  type="checkbox" name="posture2" value="p2" />
<%} %>
</td>
<td>

<img style="width:50px; height:50px;" src="../jsp/images/p-3.jpg"  />
<%if(opdNicuCaseRecord.getPosture3()!=null  && !opdNicuCaseRecord.getPosture3().equals("")){ %>
<input  type="checkbox" name="posture3" value="p3" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="posture3" value="p3" />
<%} %>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-4.jpg"  />
<%if(opdNicuCaseRecord.getPosture4()!=null  && !opdNicuCaseRecord.getPosture4().equals("")){ %>
<input  type="checkbox" name="posture4" value="p4" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="posture4" value="p4" />
<%} %>
</td>
<td></td>
</tr>

<tr>
<th>Square Window (Wrist)</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw--1.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow()!=null  && !opdNicuCaseRecord.getSquareWindow().equals("")){ %>
<input  type="checkbox" name="squareWindow" value="s-1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="squareWindow" value="s-1" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-0.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow0()!=null  && !opdNicuCaseRecord.getSquareWindow0().equals("")){ %>
<input  type="checkbox" name="squareWindow0" value="s0"checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="squareWindow0" value="s0" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-1.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow1()!=null  && !opdNicuCaseRecord.getSquareWindow1().equals("")){ %>
<input  type="checkbox" name="squareWindow1" value="s1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="squareWindow1" value="s1" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-2.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow2()!=null  && !opdNicuCaseRecord.getSquareWindow2().equals("")){ %>
<input  type="checkbox" name="squareWindow2" value="s2" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="squareWindow2" value="s2" />
<%} %>
</td>



<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-3.jpg"  />

<%if(opdNicuCaseRecord.getSquareWindow3()!=null  && !opdNicuCaseRecord.getSquareWindow3().equals("")){ %>
<input  type="checkbox" name="squareWindow3" value="s3" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="squareWindow3" value="s3" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-4.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow4()!=null  && !opdNicuCaseRecord.getSquareWindow4().equals("")){ %>
<input  type="checkbox" name="squareWindow4" value="s4" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="squareWindow4" value="s4" />
<%} %>
</td>
<td></td>
</tr>
<tr>
<th>Arm Recoil</th>
<td>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-0.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil()!=null  && !opdNicuCaseRecord.getArmRecoil().equals("")){ %>
<input  type="checkbox" name="armRecoil" value="a0" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="armRecoil" value="a0" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-1.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil1()!=null  && !opdNicuCaseRecord.getArmRecoil1().equals("")){ %>
<input  type="checkbox" name="armRecoil1" value="a1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="armRecoil1" value="a1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-2.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil2()!=null  && !opdNicuCaseRecord.getArmRecoil2().equals("")){ %>
<input  type="checkbox" name="armRecoil2" value="a2" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="armRecoil2" value="a2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-3.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil3()!=null  && !opdNicuCaseRecord.getArmRecoil3().equals("")){ %>
<input  type="checkbox" name="armRecoil3" value="a3" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="armRecoil3" value="a3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-4.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil4()!=null  && !opdNicuCaseRecord.getArmRecoil4().equals("")){ %>
<input  type="checkbox" name="armRecoil4" value="a4" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="armRecoil4" value="a4" />
<%} %>
</td>
<td></td>
</tr>
<tr>
<th>Popliteal Angel</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa--1.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && !opdNicuCaseRecord.getPoplitcalAngle().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle" value="pa-1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle" value="pa-1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-0.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle0()!=null  && !opdNicuCaseRecord.getPoplitcalAngle0().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle0" value="pa0" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle0" value="pa0" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-1.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle1()!=null  && !opdNicuCaseRecord.getPoplitcalAngle1().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle1" value="pa1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle1" value="pa1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-2.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle2()!=null  && !opdNicuCaseRecord.getPoplitcalAngle2().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle2" value="pa2" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle2" value="pa2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-3.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle3()!=null  && !opdNicuCaseRecord.getPoplitcalAngle3().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle3" value="pa3" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle3" value="pa3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-4.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle4()!=null  && !opdNicuCaseRecord.getPoplitcalAngle4().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle4" value="pa4" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle4" value="pa4" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-5.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle5()!=null  && !opdNicuCaseRecord.getPoplitcalAngle5().equals("")){ %>
<input  type="checkbox" name="poplitcalAngle5" value="pa5" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="poplitcalAngle5" value="pa5" />
<%} %>
</td>
</tr>
<tr>
<th>Scarf Sign</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss--1.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && !opdNicuCaseRecord.getScarfSign().equals("")){ %>
<input  type="checkbox" name="scarfSign" value="ss-1" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="scarfSign" value="ss-1" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-0.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign0()!=null  && !opdNicuCaseRecord.getScarfSign0().equals("")){ %>
<input  type="checkbox" name="scarfSign0" value="ss0" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="scarfSign0" value="ss0" />
<%} %>
</td>


<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-1.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign1()!=null  && !opdNicuCaseRecord.getScarfSign1().equals("")){ %>
<input  type="checkbox" name="scarfSign1" value="ss1" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="scarfSign1" value="ss1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-2.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign2()!=null  && !opdNicuCaseRecord.getScarfSign2().equals("")){ %>
<input  type="checkbox" name="scarfSign2" value="ss2" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="scarfSign2" value="ss2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-3.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign3()!=null  && !opdNicuCaseRecord.getScarfSign3().equals("")){ %>
<input  type="checkbox" name="scarfSign3" value="ss3" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="scarfSign3" value="ss3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-4.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign4()!=null  && !opdNicuCaseRecord.getScarfSign4().equals("")){ %>
<input  type="checkbox" name="scarfSign4" value="ss4" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="scarfSign4" value="ss4" />
<%} %>
</td>

<td></td>
</tr>
<tr>
<th>Heel to Ear</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he--1.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && !opdNicuCaseRecord.getHeelToEar().equals("")){ %>
<input  type="checkbox" name="heelToEar" value="h-1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="heelToEar" value="h-1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-0.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar0()!=null  && !opdNicuCaseRecord.getHeelToEar0().equals("")){ %>
<input  type="checkbox" name="heelToEar0" value="h0" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="heelToEar0" value="h0" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-1.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar1()!=null  && !opdNicuCaseRecord.getHeelToEar1().equals("")){ %>
<input  type="checkbox" name="heelToEar1" value="h1" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="heelToEar1" value="h1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-2.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar2()!=null  && !opdNicuCaseRecord.getHeelToEar2().equals("")){ %>
<input  type="checkbox" name="heelToEar2" value="h2" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="heelToEar2" value="h2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-3.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar3()!=null  && !opdNicuCaseRecord.getHeelToEar3().equals("")){ %>
<input  type="checkbox" name="heelToEar3" value="h3" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="heelToEar3" value="h3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-4.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar4()!=null  && !opdNicuCaseRecord.getHeelToEar4().equals("")){ %>
<input  type="checkbox" name="heelToEar4" value="h4" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="heelToEar4" value="h4" />
<%} %>
</td>
<td></td>
</tr>
 
</table>

<h2 class="h2Text">Physical Maturity</h2>

<table width="100%" border="0" cellspacing="0" cellpadding="3" id="grid" style="background:#fff;" class="table">
<tr>
<th>Skin</th>

<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && !opdNicuCaseRecord.getSkin().equals("")){ %>
<input  type="checkbox" name="skin" value="Sticky friable transperent" checked="checked"/>
<%}else{%>
<input  type="checkbox" name="skin" value="Sticky friable transperent" />
<%} %>
Sticky friable transperent
</td>

<td>
<%if(opdNicuCaseRecord.getSkinGenatiousRed()!=null  && !opdNicuCaseRecord.getSkinGenatiousRed().equals("")){ %>
<input  type="checkbox" name="skingenatiousRed" value="gelatious red translucent"  checked="checked"/>
<%}else{%>
<input  type="checkbox" name="skingenatiousRed" value="gelatious red translucent" />
<%} %>
gelatious red translucent
</td>


<td>
<%if(opdNicuCaseRecord.getSkinSmoothPink()!=null  && !opdNicuCaseRecord.getSkinSmoothPink().equals("")){ %>
<input  type="checkbox" name="skinSmoothPink" value="smooth pink visible veins" checked="checked"/>

<%}else{ %>
<input  type="checkbox" name="skinSmoothPink" value="smooth pink visible veins" />
<%} %>
smooth pink visible veins</td>


<td>
<%if(opdNicuCaseRecord.getSkinPeeling()!=null  && !opdNicuCaseRecord.getSkinPeeling().equals("")){ %>
<input  type="checkbox" name="skinPeeling" value="superficial peeling  &/or rash few veins" checked="checked"/>
<%}else{%>
<input  type="checkbox" name="skinPeeling" value="superficial peeling  &/or rash few veins" />
<%} %>
superficial peeling  &/or rash few veins</td>
<td>
<%if(opdNicuCaseRecord.getSkinCracking()!=null  && !opdNicuCaseRecord.getSkinCracking().equals("")){ %>
<input  type="checkbox" name="skinCracking" value="cracking pale areas rare veins" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="skinCracking" value="cracking pale areas rare veins" />
<%} %>
cracking pale areas rare veins

</td>
<td>
<%if(opdNicuCaseRecord.getSkinParchment()!=null  && !opdNicuCaseRecord.getSkinParchment().equals("")){ %>
<input  type="checkbox" name="skinParchment" value="parchment deep cracking , no vevessels" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="skinParchment" value="parchment deep cracking , no vevessels" />
<%} %>
parchment deep cracking , no vevessels</td>


<td>
<%if(opdNicuCaseRecord.getSkinLeathery()!=null  && !opdNicuCaseRecord.getSkinLeathery().equals("")){ %>
<input  type="checkbox" name="skinLeathery" value="leathery cracked wrinkeled" checked="checked" />
<%}else{ %>
<input  type="checkbox" name="skinLeathery" value="leathery cracked wrinkeled" />
<%} %>
leathery cracked wrinkeled</td>
</tr>
<tr>
<th>Lanugo</th>
<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && !opdNicuCaseRecord.getLanuge().equals("")){ %>
<input  type="checkbox" name="lanuge" value="Lanuge" checked="checked" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="lanuge" value="Lanuge" />
<%} %>
none
</td>
<td>
<%if(opdNicuCaseRecord.getLanugeSpars()!=null  && !opdNicuCaseRecord.getLanugeSpars().equals("")){ %>
<input  type="checkbox" name="lanugeSparse" value="Sparse" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="lanugeSparse" value="Sparse" />
<%} %>
Sparse </td>
<td>
<%if(opdNicuCaseRecord.getLanugeAbundant()!=null  && !opdNicuCaseRecord.getLanugeAbundant().equals("")){ %>
<input  type="checkbox" name="lanugeAbundant" value="Abundant" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="lanugeAbundant" value="Abundant" />
<%} %>
Abundant </td>
<td>
<%if(opdNicuCaseRecord.getLanugeThinning()!=null  && !opdNicuCaseRecord.getLanugeThinning().equals("")){ %>
<input  type="checkbox" name="lanugethinning" value="thinning" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="lanugethinning" value="thinning" />
<%} %>
thinning </td>

<td>
<%if(opdNicuCaseRecord.getLanugeBaldareas()!=null  && !opdNicuCaseRecord.getLanugeBaldareas().equals("")){ %>
<input  type="checkbox" name="lanugeBaldAreas" value="bald areas" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="lanugeBaldAreas" value="bald areas" />
<%} %>
bald areas</td>
<td>
<%if(opdNicuCaseRecord.getLanugeMostly()!=null  && !opdNicuCaseRecord.getLanugeMostly().equals("")){ %>
<input  type="checkbox" name="lanugeMostly" value="mostly bald" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="lanugeMostly" value="mostly bald" />
<%} %>
mostly bald</td>
<td></td>
</tr>

<tr>
<th>Planter Surface</th>	
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && !opdNicuCaseRecord.getPlanterSurface().equals("")){ %>
<input  type="checkbox" name="planterSurface" value="heel-toe 40-50 mm 1 < 40 mm 2"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="planterSurface" value="heel-toe 40-50 mm 1 < 40 mm 2"  />
<%} %>
heel-toe 40-50 mm 1 < 40 mm 2
</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurfaceCrease()!=null  && !opdNicuCaseRecord.getPlanterSurfaceCrease().equals("")){ %>
<input  type="checkbox" name="planterSurfaceCrease" value=">50 mm no crease" checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="planterSurfaceCrease" value=">50 mm no crease" />
<%} %> 
>50 mm no crease</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurfaceFaint()!=null  && !opdNicuCaseRecord.getPlanterSurfaceFaint().equals("")){ %>
<input  type="checkbox" name="planterSurfaceFaint" value="faint red mark"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="planterSurfaceFaint" value="faint red mark" />
<%} %>
faint red mark</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurfaceAnterior()!=null  && !opdNicuCaseRecord.getPlanterSurfaceAnterior().equals("")){ %>
<input  type="checkbox" name="planterSurfaceAnterior" value="anterior transverse crease only"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="planterSurfaceAnterior" value="anterior transverse crease only"  />
<%} %>
anterior transverse crease only</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurfaceCreasesAnt()!=null  && !opdNicuCaseRecord.getPlanterSurfaceCreasesAnt().equals("")){ %>
<input  type="checkbox" name="planterSurfaceCreasesAnt" value="creases ant 2/3"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="planterSurfaceCreasesAnt" value="creases ant 2/3" />
<%} %>
creases ant 2/3</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurfaceEntireSole()!=null  && !opdNicuCaseRecord.getPlanterSurfaceEntireSole().equals("")){ %>
<input  type="checkbox" name="planterSurfaceEntireSole" value="creases over entire sole"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="planterSurfaceEntireSole" value="creases over entire sole" />
<%} %>
creases over entire sole</td>
<td></td>
</tr>
<tr>
<th>Breast</th>
<td>
<%if(opdNicuCaseRecord.getBreast()!=null  && !opdNicuCaseRecord.getBreast().equals("")){ %>
<input  type="checkbox" name="breast" value="imper ceptible"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="breast" value="imper ceptible"/>
<%} %>
imper ceptible 
</td>
<td>
<%if(opdNicuCaseRecord.getBreastPerceptible()!=null  && !opdNicuCaseRecord.getBreastPerceptible().equals("")){ %>
<input  type="checkbox" name="breastPerceptible" value="barely perceptible" checked="checked"/>

<%}else{ %>
<input  type="checkbox" name="breastPerceptible" value="barely perceptible" />
<%} %>

barely perceptible</td>


<td>
<%if(opdNicuCaseRecord.getBreastArcola()!=null  && !opdNicuCaseRecord.getBreastArcola().equals("")){ %>
<input  type="checkbox" name="breastArcola" value="flat arcola  no bud"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="breastArcola" value="flat arcola  no bud" />
<%} %>
flat arcola  no bud</td>
<td>



<%if(opdNicuCaseRecord.getBreastStippled()!=null  && !opdNicuCaseRecord.getBreastStippled().equals("")){ %>
<input  type="checkbox" name="breastStippled" value="stippled areola 1-2mm bud"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="breastStippled" value="stippled areola 1-2mm bud" />
<%} %>
stippled areola 1-2mm bud</td>




<td>
<%if(opdNicuCaseRecord.getBreastRaised()!=null  && !opdNicuCaseRecord.getBreastRaised().equals("")){ %>
<input  type="checkbox" name="breastRaised" value="raised areola 3-4mm bud"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="breastRaised" value="raised areola 3-4mm bud"/>
<%} %>
raised areola 3-4mm bud</td>
<td>
<%if(opdNicuCaseRecord.getBreastAreola()!=null  && !opdNicuCaseRecord.getBreastAreola().equals("")){ %>
<input  type="checkbox" name="breastAreola" value="full areola 5-10mm bud"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="breastAreola" value="full areola 5-10mm bud"  />
<%} %>
full areola 5-10mm bud</td>
<td></td>
</tr>
<tr>
<th>Eye/Ear</th>
<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && !opdNicuCaseRecord.getEyeEar().equals("")){ %>
<input  type="checkbox" name="eyeEar" value="Lids fused loosely-1 tightly-2 "  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="eyeEar" value="Lids fused loosely-1 tightly-2 "/>
<%} %>
Lids fused loosely-1 tightly-2 
</td>
<td>
<%if(opdNicuCaseRecord.getEyeEarPinna()!=null  && !opdNicuCaseRecord.getEyeEarPinna().equals("")){ %>
<input  type="checkbox" name="eyeEarPinna" value="Lids open pinna flat stays folded"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="eyeEarPinna" value="Lids open pinna flat stays folded"  />
<%} %>
Lids open pinna flat stays folded</td>
<td>
<%if(opdNicuCaseRecord.getEyeEarCurvedPinna()!=null  && !opdNicuCaseRecord.getEyeEarCurvedPinna().equals("")){ %>
<input  type="checkbox" name="eyeEarCurvedPinna" value="sl. curved pinna soft slow recoil"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="eyeEarCurvedPinna" value="sl. curved pinna soft slow recoil"/>
<%} %>
sl. curved pinna soft slow recoil </td>

<td>
<%if(opdNicuCaseRecord.getEyeEarSoftBudready()!=null  && !opdNicuCaseRecord.getEyeEarSoftBudready().equals("")){ %>
<input  type="checkbox" name="eyeEarSoftBudready" value="well curved pinna , soft budready recoil"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="eyeEarSoftBudready" value="well curved pinna , soft budready recoil" />
<%} %>
well curved pinna , soft budready recoil</td>


<td>
<%if(opdNicuCaseRecord.getEyeEarInstandRecoil()!=null  && !opdNicuCaseRecord.getEyeEarInstandRecoil().equals("")){ %>
<input  type="checkbox" name="eyeEarInstandRecoil" value="formed and firm instant recoil"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="eyeEarInstandRecoil" value="formed and firm instant recoil" />
<%} %>
formed and firm instant recoil</td>


<td>
<%if(opdNicuCaseRecord.getEyeEarStiff()!=null  && !opdNicuCaseRecord.getEyeEarStiff().equals("")){ %>
<input  type="checkbox" name="eyeEarStiff" value="thick cartilage ear stiff"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="eyeEarStiff" value="thick cartilage ear stiff" />
<%} %>

thick cartilage ear stiff</td>
<td></td>
</tr>
<tr>
<th>Genilals Male</th>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && !opdNicuCaseRecord.getGenilalsMale().equals("")){ %>
<input  type="checkbox" name="genilalsMale" value="Scrotum flat smooth"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsMale" value="Scrotum flat smooth" />
<%} %>
Scrotum flat smooth 
</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMaleScrotumEmpty()!=null  && !opdNicuCaseRecord.getGenilalsMaleScrotumEmpty().equals("")){ %>
<input  type="checkbox" name="genilalsMaleScrotumEmpty" value="Scrotum empty faint rugae"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsMaleScrotumEmpty" value="Scrotum empty faint rugae" />
<%} %>
Scrotum empty faint rugae</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMaleUppperCanal()!=null  && !opdNicuCaseRecord.getGenilalsMaleUppperCanal().equals("")){ %>
<input  type="checkbox" name="genilalsMaleUpperCanal" value="testes in upper canal rare rugae"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsMaleUpperCanal" value="testes in upper canal rare rugae" />
<%} %>
testes in upper canal rare rugae </td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMaleFewRugae()!=null  && !opdNicuCaseRecord.getGenilalsMaleFewRugae().equals("")){ %>
<input  type="checkbox" name="genilalsMaleFewRugae" value="testes descending few rugae"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsMaleFewRugae" value="testes descending few rugae" />
<%} %>
testes descending few rugae</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMaleGoodRugae()!=null  && !opdNicuCaseRecord.getGenilalsMaleGoodRugae().equals("")){ %>
<input  type="checkbox" name="genilalsMaleGoodRugae" value="testes down good rugae"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsMaleGoodRugae" value="testes down good rugae" />
<%} %>
testes down good rugae</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMaleDeepRugae()!=null  && !opdNicuCaseRecord.getGenilalsMaleDeepRugae().equals("")){ %>
<input  type="checkbox" name="genilalsMaleDeepRugae" value="testes pendulous deep rugae"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsMaleDeepRugae" value="testes pendulous deep rugae" />
<%} %>
testes pendulous deep rugae</td>
<td></td>
</tr>
<tr>
<th>Genilals Female</th>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && !opdNicuCaseRecord.getGenilalsFemale().equals("")){ %>
<input  type="checkbox" name="genilalsFemale" value="Clitoris Prominant labia flat"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsFemale" value="Clitoris Prominant labia flat" />
<%} %>
Clitoris Prominant labia flat

</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemaleLabiaMinora()!=null  && !opdNicuCaseRecord.getGenilalsFemaleLabiaMinora().equals("")){ %>
<input  type="checkbox" name="genilalsFemaleLabiaMinora" value="Prominant Clitoris small labia minora"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsFemaleLabiaMinora" value="Prominant Clitoris small labia minora" />
<%} %>
Prominant Clitoris small labia minora</td>

<td>
<%if(opdNicuCaseRecord.getGenilalsFemaleEnlargingMinora()!=null  && !opdNicuCaseRecord.getGenilalsFemaleEnlargingMinora().equals("")){ %>
<input   type="checkbox" name="genilalsFemaleEnlargingMinora" value="Prominant Clitoris enlarging minora"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsFemaleEnlargingMinora" value="Prominant Clitoris enlarging minora" />
<%} %>
Prominant Clitoris enlarging minora</td>

<td>
<%if(opdNicuCaseRecord.getGenilalsFemaleEquallyProminant()!=null  && !opdNicuCaseRecord.getGenilalsFemaleEquallyProminant().equals("")){ %>
<input  type="checkbox" name="genilalsFemaleEquallyProminant" value="majora  & minora equally prominant"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsFemaleEquallyProminant" value="majora  & minora equally prominant"  />
<%} %>
majora  & minora equally prominant</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemaleMinoraSmall()!=null  && !opdNicuCaseRecord.getGenilalsFemaleMinoraSmall().equals("")){ %>
<input  type="checkbox" name="genilalsFemaleMinoraSmall" value="majora large minora small"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsFemaleMinoraSmall" value="majora large minora small"  />
<%} %>
majora large minora small </td>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemaleClitoris()!=null  && !opdNicuCaseRecord.getGenilalsFemaleClitoris().equals("")){ %>
<input  type="checkbox" name="genilalsFemaleClitoris" value="majora cover clitoris & minora"  checked="checked"/>
<%}else{ %>
<input  type="checkbox" name="genilalsFemaleClitoris" value="majora cover clitoris & minora" />
<%} %>
majora cover clitoris & minora	</td>
<td></td>
</tr>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<br/>
<div class="clear"></div>

<label>Weight</label>
<input type="text" class="textYellow" id="weightNicu" name="weightNicu" maxlength="5" class="allownumericwithoutdecimal" value="<%=opdNicuCaseRecord.getOpdPatientDetails().getWeight() %>"	 validate="Weight,float,no" /><label class="smallAuto">Kg. &nbsp;</label>
<label>Height</label>
<input type="text" class="textYellow" maxlength="3" name="heightNicu" class="allownumericwithoutdecimal"  id="heightNicu" value="<%=opdNicuCaseRecord.getOpdPatientDetails().getHeight()%>" validate="Height,int,no" /><label class="smallAuto">Cms.</label>
<div class="clear"></div>
<label>Head Circumference</label>
<input type="text" class="textYellow" name="headCircumferenceNicu" maxlength="5" class="allownumericwithoutdecimal"  value="<%=opdNicuCaseRecord.getOpdPatientDetails().getHeadCircumference()%>" id="headCircumferenceNicu" validate="Head Circumference,float,no" /><label class="smallAuto">Cms.</label>
<label>Weeks</label>
<select name="week" id="week" >
<option value="0">Select</option>
<%
for(int x=24 ;x<=43;++x)
{
	%>
	<option value="<%=x%>"><%=x%></option>
	<%
}
%>
</select>


<script>
<%
if(!opdNicuCaseRecord.getWeek().equals("0")){
%>
document.getElementById('week').value = '<%=opdNicuCaseRecord.getWeek()%>';

<%}%>
</script>
<%}}else{ %>



<div class="titleBg">
<h2>New Ballard Score</h2>
</div>
<div class="Block">
<input id="nicuFlag" name="nicuFlag" tabindex="1" value="NicuCaseRecord" type="hidden"  />
<input type="hidden" name="templateName" value="Nicu CaseRecord"/>
<div class="clear"></div>
<h4>Neuromuscular Maturity</h4>
<div class="clear"></div>
<input name="button4" type="button" align="right" class="buttonBig"	value="Weight Percentiles" onClick="submitForm('opdMain','opd?method=printWeightPercentiles&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="Height Percentiles" onClick="submitForm('opdMain','opd?method=printHeightPercentiles&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="Head Circumference Percentiles" onClick="submitForm('opdMain','opd?method=printHeadCircumferencePercentiles&hinId=<%=hinId %>');"  />
<input name="button4" type="button" align="right" class="buttonBig"	value="BMI Chart" onClick="submitForm('opdMain','opd?method=printBMIChart&hinId=<%=hinId %>');"  />
<div class="clear"></div>
<div class="tableForNumbers">
<table border="0"  cellpadding="0" cellspacing="0"	id="grid" style="background:#fff;">
<tr>
<th></th>
<th>-1</th>
<th>0</th>
<th>1</th>
<th>2</th>
<th>3</th>
<th>4</th>
<th>5</th>
<!-- <th>Total</th> -->
</tr>

<tr>
<th>Posture</th>
<td></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-0.jpg"  />
<input  type="radio" name="posture" id="posture1"  class="radiobutMargin" tabindex="1" value="0" onclick="displayTotalScoreNicu(this.value);calculateScore(0,1);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-1.jpg"  />
<input type="radio" name="posture" id="posture2"  class="radiobutMargin" tabindex="1" value="1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,1);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-2.jpg"  />
<input type="radio" name="posture" id="posture3"  class="radiobutMargin" tabindex="1" value="2" onclick="displayTotalScoreNicu(this.value);calculateScore(2,1);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-3.jpg"  />
<input type="radio" name="posture" id="posture4"  class="radiobutMargin" tabindex="1" value="3" onclick="displayTotalScoreNicu(this.value);calculateScore(3,1);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-4.jpg"  />
<input type="radio" name="posture" id="posture6"  class="radiobutMargin" tabindex="1" value="4" onclick="displayTotalScoreNicu(this.value);calculateScore(4,1);"/></td>
<td></td>
<!-- <td><input type="text"  name="TotalScore" id="TotalScore" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>

<tr>
<th>Square Window (Wrist)</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw--1.jpg"  />
<input type="radio" name="squareWindow" class="radiobutMargin" id="squareWindow1" value="-1" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,2);"/>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-0.jpg"  />
<input type="radio" name="squareWindow" class="radiobutMargin" id="squareWindow2" value="0" onclick="displayTotalScoreNicu(this.value);calculateScore(0,2);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-1.jpg"  />
<input type="radio" name="squareWindow" class="radiobutMargin" id="squareWindow3" value="1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,2);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-2.jpg"  />
<input type="radio" name="squareWindow" class="radiobutMargin" id="squareWindow4" value="2" onclick="displayTotalScoreNicu(this.value);calculateScore(2,2);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-3.jpg"  />
<input type="radio" name="squareWindow" class="radiobutMargin" id="squareWindow5" value="3"  onclick="displayTotalScoreNicu(this.value);calculateScore(3,2);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-4.jpg"  />
<input type="radio" name="squareWindow" class="radiobutMargin" id="squareWindow6"  value="4" onclick="displayTotalScoreNicu(this.value);calculateScore(4,2);"/></td>
<td></td>
<!-- <td><input type="text"  name="TotalScore" id="TotalScore2" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Arm Recoil</th>
<td>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-0.jpg"  />
<input type="radio" name="armRecoil" id="armRecoil1"  value="0" onclick="displayTotalScoreNicu(this.value);calculateScore(0,3);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-1.jpg"  />
<input type="radio" name="armRecoil" id="armRecoil2"  value="1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,3);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-2.jpg"  />
<input type="radio" name="armRecoil" id="armRecoil3"  value="2" onclick="displayTotalScoreNicu(this.value);calculateScore(2,3);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-3.jpg"  />
<input type="radio" name="armRecoil" id="armRecoil4"  value="3" onclick="displayTotalScoreNicu(this.value);calculateScore(3,3);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-4.jpg"  />
<input type="radio" name="armRecoil" id="armRecoil5"  value="4" onclick="displayTotalScoreNicu(this.value);calculateScore(4,3);" /></td>
<td></td>
<!-- <td><input type="text"  name="TotalScore" id="TotalScore3" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Popliteal Angel</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa--1.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle1"  value="-1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,4);"/>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-0.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle2"  value="0" onclick="displayTotalScoreNicu(this.value);calculateScore(0,4);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-1.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle3"  value="1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,4);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-2.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle4"  value="2" onclick="displayTotalScoreNicu(this.value);calculateScore(2,4);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-3.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle5"  value="3" onclick="displayTotalScoreNicu(this.value);calculateScore(3,4);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-4.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle6"  value="4" onclick="displayTotalScoreNicu(this.value);calculateScore(4,4);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-5.jpg"  />
<input type="radio" name="poplitcalAngle" id="poplitcalAngle7"  value="5" onclick="displayTotalScoreNicu(this.value);calculateScore(5,4);"/></td>
<!-- <td><input type="text"  name="TotalScore4" id="TotalScore4" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Scarf Sign</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss--1.jpg"  />
<input type="radio" name="scarfSign"  id="scarfSign1" value="-1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,5);" />

</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-0.jpg"  />
<input type="radio" name="scarfSign"  id="scarfSign2" value="0" onclick="displayTotalScoreNicu(this.value);calculateScore(0,5);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-1.jpg"  />
<input type="radio" name="scarfSign"  id="scarfSign3" value="1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,5);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-2.jpg"  />
<input type="radio" name="scarfSign" id="scarfSign4"  value="2" onclick="displayTotalScoreNicu(this.value);calculateScore(2,5);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-3.jpg"  />
<input type="radio" name="scarfSign"  id="scarfSign5" value="3" onclick="displayTotalScoreNicu(this.value);calculateScore(3,5);"/></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-4.jpg"  />
<input type="radio" name="scarfSign"  id="scarfSign6" value="4" onclick="displayTotalScoreNicu(this.value);calculateScore(4,5);" /></td>
<td></td>
<!-- <td><input type="text"  name="TotalScore5" id="TotalScore5" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Heel to Ear</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he--1.jpg"  />
<input type="radio" name="heelToEar" id="heelToEar1"  value="-1" onclick="displayTotalScoreNicu(this.value);calculateScore(4,6);" />

</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-0.jpg"  />
<input type="radio" name="heelToEar" id="heelToEar2"  value="0" onclick="displayTotalScoreNicu(this.value);calculateScore(0,6);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-1.jpg"  />
<input type="radio" name="heelToEar"  id="heelToEar3" value="1" onclick="displayTotalScoreNicu(this.value);calculateScore(1,6);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-2.jpg"  />
<input type="radio" name="heelToEar"  id="heelToEar4" value="2" onclick="displayTotalScoreNicu(this.value);calculateScore(2,6);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-3.jpg"  />
<input type="radio" name="heelToEar" id="heelToEar5"  value="3" onclick="displayTotalScoreNicu(this.value);calculateScore(3,6);" /></td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-4.jpg"  />
<input type="radio" name="heelToEar" id="heelToEar6" value="4" onclick="displayTotalScoreNicu(this.value);calculateScore(4,6);" /></td>
<td></td>
<!-- <td><input type="text"  name="TotalScore6" id="TotalScore6" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th colspan="8">Total Source
<input  type="text" value="" id="totalSource" name="totalSource" readonly="readonly" />
</th>
</tr>

<tr><td colspan="8"> <h4>Physical Maturity</h4>
</td>
</tr>
<tr>
<th>Skin</th>

<td>
<input type="radio" name="skin" id="skin1" value="Sticky friable transperent" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,7);" />
<div class="clear"></div>
Sticky friable transperent
</td>

<td>
<input type="radio" name="skin" id="skin2" value="gelatious red translucent" onclick="displayTotalScoreNicu(this.value);calculateScore(0,7);" />
<div class="clear"></div>
genatious red translucent</td>
<td>
<input type="radio" name="skin" id="skin3" value="smooth pink visible veins" onclick="displayTotalScoreNicu(this.value);calculateScore(1,7);" />
<div class="clear"></div>
smooth pink visible veins</td>
<td>
<input type="radio" name="skin" id="skin4" value="superficial peeling  / rash few veins" onclick="displayTotalScoreNicu(this.value);calculateScore(2,7);" />
<div class="clear"></div>
superficial peeling  / rash few veins</td>
<td>
<input type="radio" name="skin" id="skin5" value="cracking pale areas rare veins" onclick="displayTotalScoreNicu(this.value);calculateScore(3,7);" />
<div class="clear"></div>
cracking pale areas rare veins</td>
<td>
<input type="radio" name="skin" id="skin6" value="parchment deep cracking , no vessels" onclick="displayTotalScoreNicu(this.value);calculateScore(4,7);" />
<div class="clear"></div>
parchment deep cracking , no vessels</td>
<td>
<input type="radio" name="skin" id="skin7" value="leathery cracked wrinkied" onclick="displayTotalScoreNicu(this.value);calculateScore(5,7);" />
<div class="clear"></div>
leathery cracked wrinkied</td>
<!-- <td><input type="text"  name="TotalScore7" id="TotalScore7" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Lanugo</th>
<td>
<input type="radio" name="lanuge" id="lanuge1" value="Lanugo" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,8);" />
none
</td>
<td>
<input type="radio" name="lanuge" id="lanuge2" value="Sparse" onclick="displayTotalScoreNicu(this.value);calculateScore(0,8);"/>
Sparse </td>
<td>
<input type="radio" name="lanuge" id="lanuge3" value="Abundant" onclick="displayTotalScoreNicu(this.value);calculateScore(1,8);" />
Abundant </td>
<td>
<input type="radio" name="lanuge" id="lanuge4" value="thinning" onclick="displayTotalScoreNicu(this.value);calculateScore(2,8);" />
thinning </td>
<td>
<input type="radio" name="lanuge" id="lanuge5" value="bald areas" onclick="displayTotalScoreNicu(this.value);calculateScore(3,8);" />
bald areas</td>
<td>
<input type="radio" name="lanuge" id="lanuge6" value="mostly bald" onclick="displayTotalScoreNicu(this.value);calculateScore(4,8);" />
mostly bald</td>
<td></td>
<!-- <td><input type="text"  name="TotalScore8" id="TotalScore8" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>

<tr>
<th>Planter Surface</th>	
<td>

<input type="radio" name="planterSurface" id="planterSurface1" value="heel-toe 40-50 mm 1 < 40 mm 2" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,9);" />
<div class="clear"></div>
heel-toe 40-50 mm 1 < 40 mm 2
</td>
<td>
<input type="radio" name="planterSurface" id="planterSurface2" value=">50 mm no crease" onclick="displayTotalScoreNicu(this.value);calculateScore(0,9);"/> 
<div class="clear"></div>
>50 mm no crease</td>
<td>
<input type="radio" name="planterSurface" id="planterSurface3" value="faint red mark" onclick="displayTotalScoreNicu(this.value);calculateScore(1,9);" />
<div class="clear"></div>
faint red mark</td>
<td>
<input type="radio" name="planterSurface" id="planterSurface4" value="anterior transverse crease only" onclick="displayTotalScoreNicu(this.value);calculateScore(2,9);" />
<div class="clear"></div>
anterior transverse crease only</td>
<td>
<input type="radio" name="planterSurface" id="planterSurface5" value="creases ant 2/3" onclick="displayTotalScoreNicu(this.value);calculateScore(3,9);" />
<div class="clear"></div>
creases ant 2/3</td>
<td>
<input type="radio" name="planterSurface"  id="planterSurface6" value="creases over entire sole" onclick="displayTotalScoreNicu(this.value);calculateScore(4,9);" />
<div class="clear"></div>
creases over entire sole</td>
<td></td>
<!-- <td><input type="text"  name="TotalScore9" id="TotalScore9" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Breast</th>
<td>
<input type="radio" name="breastName" id="breast1" value="imperceptible" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,10);" />
<div class="clear"></div>
imperceptible 
</td>
<td>
<input type="radio" name="breastName" id="breast2" value="barely perceptible" onclick="displayTotalScoreNicu(this.value);calculateScore(0,10);" />
<div class="clear"></div>
barely perceptible</td>
<td>
<input type="radio" name="breastName" id="breast3" value="flat areola  no bud" onclick="displayTotalScoreNicu(this.value);calculateScore(1,10);" />
<div class="clear"></div>
flat areola  no bud</td>
<td>
<input type="radio" name="breastName" id="breast4" value="stippled areola 1-2mm bud" onclick="displayTotalScoreNicu(this.value);calculateScore(2,10);"/>
<div class="clear"></div>
stippled areola 1-2mm bud</td>
<td>
<input type="radio" name="breastName" id="breast5" value="raised areola 3-4mm bud" onclick="displayTotalScoreNicu(this.value);calculateScore(3,10);" />
<div class="clear"></div>
raised areola 3-4mm bud</td>
<td>
<input type="radio" name="breastName" id="breast6"  value="full areola 5-10mm bud" onclick="displayTotalScoreNicu(this.value);calculateScore(4,10);" />
<div class="clear"></div>
full areola 5-10mm bud</td>
<td></td>
<!-- <td><input type="text"  name="TotalScore10" id="TotalScore10" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Eye/Ear</th>
<td>
<input type="radio" name="eyeEar"  id="eyeEar1" value="Lids fused loosely-1 tightly-2" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,11);" />
<div class="clear"></div>
Lids fused loosely-1 tightly-2 
</td>
<td>
<input type="radio" name="eyeEar"  id="eyeEar2" value="Lids open pinna flat stays folded" onclick="displayTotalScoreNicu(this.value);calculateScore(0,11);" />
<div class="clear"></div>
Lids open pinna flat stays folded</td>
<td>
<input type="radio" name="eyeEar"  id="eyeEar3" value="sl. curved pinna soft slow recoil" onclick="displayTotalScoreNicu(this.value);calculateScore(1,11);" />
<div class="clear"></div>
sl. curved pinna soft slow recoil </td>
<td>
<input type="radio" name="eyeEar"  id="eyeEar4" value="well curved pinna , soft budready recoil" onclick="displayTotalScoreNicu(this.value);calculateScore(2,11);" />
<div class="clear"></div>
well curved pinna , soft budready recoil</td>
<td>
<input type="radio" name="eyeEar"  id="eyeEar5" value="formed and firm instant recoil" onclick="displayTotalScoreNicu(this.value);calculateScore(3,11);"/>
<div class="clear"></div>
formed and firm instant recoil</td>
<td>
<input type="radio" name="eyeEar"  id="eyeEar6"  id="eyeEar" value="thick cartilage ear stiff" onclick="displayTotalScoreNicu(this.value);calculateScore(4,11);" />
<div class="clear"></div>
thick cartilage ear stiff</td>
<td></td>
<!-- <td><input type="text"  name="TotalScore11" id="TotalScore11" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Genilals Male</th>
<td>
<input type="radio" name="genilalsMale" id="genilalsMale1" value="Scrotum flat smooth" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,12);" />
<div class="clear"></div>
Scrotum flat smooth 
</td>
<td>
<input type="radio" name="genilalsMale" id="genilalsMale2" value="Scrotum empty faint rugae" onclick="displayTotalScoreNicu(this.value);calculateScore(0,12);"/>
<div class="clear"></div>
Scrotum empty faint rugae</td>
<td>
<input type="radio" name="genilalsMale" id="genilalsMale3" value="testes in upper canal rare rugae" onclick="displayTotalScoreNicu(this.value);calculateScore(1,12);" />
<div class="clear"></div>
testes in upper canal rare rugae </td>
<td>
<input type="radio" name="genilalsMale" id="genilalsMale4" value="testes descending few rugae" onclick="displayTotalScoreNicu(this.value);calculateScore(2,12);" />
<div class="clear"></div>
testes descending few rugae</td>
<td>
<input type="radio" name="genilalsMale" id="genilalsMale5" value="testes down good rugae" onclick="displayTotalScoreNicu(this.value);calculateScore(3,12);" />
<div class="clear"></div>
testes down good rugae</td>
<td>
<input type="radio" name="genilalsMale" id="genilalsMale6" value="testes pendulous deep rugae" onclick="displayTotalScoreNicu(this.value);calculateScore(4,12);"/>
<div class="clear"></div>
testes pendulous deep rugae</td>
<td></td>
<!-- <td><input type="text"  name="TotalScore12" id="TotalScore12" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th>Genilals Female</th>
<td>
<input type="radio" name="genilalsFemale" id="genilalsFemale1" value="Clitoris Prominant labia flat" onclick="displayTotalScoreNicu(this.value);calculateScore(-1,13);" />
<div class="clear"></div>
Clitoris Prominant labia flat
</td>
<td>
<input type="radio" name="genilalsFemale" id="genilalsFemale2" value="Prominant Clitoris small labia minora" onclick="displayTotalScoreNicu(this.value);calculateScore(0,13);" />
<div class="clear"></div>
Prominant Clitoris small labia minora</td>

<td>
<input type="radio" name="genilalsFemale" id="genilalsFemale3" value="Prominant Clitoris enlarging minora" onclick="displayTotalScoreNicu(this.value);calculateScore(1,13);" />
<div class="clear"></div>
Prominant Clitoris enlarging minora</td>

<td>
<input type="radio" name="genilalsFemale" id="genilalsFemale4" value="majora  & minora equally prominant" onclick="displayTotalScoreNicu(this.value);calculateScore(2,13);" />
<div class="clear"></div>
majora  & minora equally prominant</td>
<td>
<input type="radio" name="genilalsFemale" id="genilalsFemale5" value="majora large minora small" onclick="displayTotalScoreNicu(this.value);calculateScore(3,13);" />
<div class="clear"></div>
majora large minora small </td>
<td>
<input type="radio" name="genilalsFemale" id="genilalsFemale6" value="majora cover clitoris & minora" onclick="displayTotalScoreNicu(this.value);calculateScore(4,13);" />
<div class="clear"></div>
majora cover clitoris & minora	</td>
<td></td>
<!-- <td><input type="text"  name="TotalScore13" id="TotalScore13" onkeypress="javascript:return isNumber(event)" size="3" value="0" tabindex="1" ></td> -->
</tr>
<tr>
<th colspan="8">Total Source <input  type="text" value="" id="totalSources" name="totalSources" readonly="readonly" />
</th>
</tr>
</table>



</div>


<div class="clear"></div>

<label>Grand Total Source</label>
<input  type="text" value="" id="grandtotalSources" name="grandtotalSources" readonly="readonly" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<label>Weight</label>
<input type="text" class="textYellow" id="weightNicu" name="weightNicu" maxlength="5" class="allownumericwithoutdecimal" value=""	onkeypress="javascript:return isNumberDecimal(event)"   validate="Weight,float,no" /><label class="smallAuto">Kg. &nbsp;</label>
<label>Height</label>
<input type="text" class="textYellow" maxlength="5" name="heightNicu" class="allownumericwithoutdecimal" onkeypress="javascript:return isNumberDecimal(event)"   id="heightNicu" value="" validate="Height,float,no" /><label class="smallAuto">Cms.</label>
<div class="clear"></div>
<label>Head Circumference</label>
<input type="text" class="textYellow" name="headCircumferenceNicu" maxlength="5" class="allownumericwithoutdecimal" value="" id="headCircumferenceNicu" onkeypress="javascript:return isNumberDecimal(event)"  validate="Head Circumference,float,no" /><label class="smallAuto">Cms.</label>
<label>Week</label>
<select name="week" >
<option value="0">Select</option>
<%
for(int x=24 ;x<=43;++x)
{
	%>
	<option value="<%=x%>"><%=x%></option>
	<%
}
%>
</select>
</div>
<%} %>


</form>
