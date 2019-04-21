
<%@page import="jkt.hms.masters.business.OpdNicuCaseRecord"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>





<%
				Map<String, Object> map = new HashMap<String, Object>();
				if(request.getAttribute("map")!=null)
				{
					map=(Map<String, Object>)request.getAttribute("map");
				}
				List<OpdNicuCaseRecord> opdNicuCaseRecordList = new ArrayList<OpdNicuCaseRecord>();
				
				if(map.get("opdNicuCaseRecordList")!= null){
					opdNicuCaseRecordList = (List)map.get("opdNicuCaseRecordList");
				}
				System.out.println("opdNicuCaseRecordList...."+opdNicuCaseRecordList.size());
				if(opdNicuCaseRecordList.size()>0){
					for(OpdNicuCaseRecord opdNicuCaseRecord :opdNicuCaseRecordList){


%>


<center><h1 class="h1Text"><%=opdNicuCaseRecord.getOpdPatientDetails().getHospital().getHospitalName()%></h1>
<h2 class="h2Text">Nicu Case Record</h2></center>
<br/>
<table width="800" border="0" cellspacing="0" cellpadding="3" >
  <tbody>
    <tr>
      <td><label class="fontBold">UHID : </label></td>
      <td><label><%=opdNicuCaseRecord.getHin().getHinNo() %> </label></td>
      <td><label class="fontBold">Patient Name :</label></td>
      <td><label><%=opdNicuCaseRecord.getHin().getPFirstName()%><%=opdNicuCaseRecord.getHin().getPMiddleName()!=null?opdNicuCaseRecord.getHin().getPMiddleName():"" %> </label></td>
      <td><label class="fontBold">DOB :</label></td>
      <td><label><%=HMSUtil.changeDateToddMMyyyy(opdNicuCaseRecord.getHin().getDateOfBirth()) %> </label></td>
    </tr>
    <tr>
      <td><label class="fontBold">Visit Date : </label></td>
      <td><label><%=HMSUtil.changeDateToddMMyyyy(opdNicuCaseRecord.getOpdPatientDetails().getVisit().getVisitDate()) %> </label></td>
      <td><label class="fontBold">Sex :</label></td>
      <td><label><%=opdNicuCaseRecord.getHin().getSex().getAdministrativeSexName() %> </label></td>
      <td><label class="fontBold">Age :</label></td>
      <td><label><%=opdNicuCaseRecord.getHin().getAge() %> </label></td>
    </tr>     
    <tr>
      <td><label class="fontBold">Address :</label></td>
      <td colspan="5"><label><%=opdNicuCaseRecord.getHin().getPatientAddress()!=null?opdNicuCaseRecord.getHin().getPatientAddress():"" %> </label></td>
      
    </tr> 
    <!-- <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr> -->
  </tbody>
</table>

<hr/>

<input id="nicuFlag" name="nicuFlag" tabindex="1" value="NicuCaseRecord" type="hidden"  />
<input type="hidden" name="templateName" value="Nicu CaseRecord"/>


<%-- <div class="clear"></div>

<label>UHID : </label>
<label><%=opdNicuCaseRecord.getHin().getHinNo() %> </label>


<label>Patient Name :</label>
<label><%=opdNicuCaseRecord.getHin().getPFirstName()%><%=opdNicuCaseRecord.getHin().getPMiddleName()!=null?opdNicuCaseRecord.getHin().getPMiddleName():"" %> </label>

<label>DOB :</label>
<label><%=opdNicuCaseRecord.getHin().getDateOfBirth() %> </label>
<div class="clear"></div>

<label>Visit Date : </label>
<label><%=opdNicuCaseRecord.getOpdPatientDetails().getVisit().getVisitDate() %> </label>

<label>Sex :</label>
<label><%=opdNicuCaseRecord.getHin().getSex().getAdministrativeSexName() %> </label>
<label>Age :</label>
<label><%=opdNicuCaseRecord.getHin().getAge() %> </label>
<div class="clear"></div>
<label>Address :</label>
<label><%=opdNicuCaseRecord.getHin().getPatientAddress()!=null?opdNicuCaseRecord.getHin().getPatientAddress():"" %> </label> --%>

<h2 class="h2Text">Neuromuscular Maturity</h2>
<div class="clear"></div>
<div class="tableForNumbers">
<table width="100%" border="0" cellspacing="0" cellpadding="3" id="grid" style="background:#fff;" class="table">
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
<%if(opdNicuCaseRecord.getPosture()!=null && opdNicuCaseRecord.getPosture().equals("0")){ %>
<input type="checkbox" name="posture" value="p0"  checked="checked" disabled="disabled"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="posture" value="p0"  />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-1.jpg"  />
<%if(opdNicuCaseRecord.getPosture()!=null  && opdNicuCaseRecord.getPosture().equals("1")){ %>
<input disabled="disabled" type="checkbox" name="posture1" value="p1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="posture1" value="p1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-2.jpg"  />
<%if(opdNicuCaseRecord.getPosture()!=null  && opdNicuCaseRecord.getPosture().equals("2")){ %>
<input disabled="disabled" type="checkbox" name="posture2" value="p2" checked="checked"/>

<%}else{ %>
<input disabled="disabled" type="checkbox" name="posture2" value="p2" />
<%} %>
</td>
<td>

<img style="width:50px; height:50px;" src="../jsp/images/p-3.jpg"  />
<%if(opdNicuCaseRecord.getPosture()!=null  && opdNicuCaseRecord.getPosture().equals("3")){ %>
<input disabled="disabled" type="checkbox" name="posture3" value="p3" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="posture3" value="p3" />
<%} %>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/p-4.jpg"  />
<%if(opdNicuCaseRecord.getPosture()!=null  && opdNicuCaseRecord.getPosture().equals("4")){ %>
<input disabled="disabled" type="checkbox" name="posture4" value="p4" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="posture4" value="p4" />
<%} %>
</td>
<td></td>
</tr>

<tr>
<th>Square Window (Wrist)</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw--1.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow()!=null  && opdNicuCaseRecord.getSquareWindow().equals("-1")){ %>
<input disabled="disabled" type="checkbox" name="squareWindow" value="s-1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="squareWindow" value="s-1" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-0.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow()!=null  && opdNicuCaseRecord.getSquareWindow().equals("0")){ %>
<input disabled="disabled" type="checkbox" name="squareWindow0" value="s0" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="squareWindow0" value="s0" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-1.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow()!=null  && opdNicuCaseRecord.getSquareWindow().equals("1")){ %>
<input disabled="disabled" type="checkbox" name="squareWindow1" value="s1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="squareWindow1" value="s1" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-2.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow()!=null  && opdNicuCaseRecord.getSquareWindow().equals("2")){ %>
<input disabled="disabled" type="checkbox" name="squareWindow2" value="s2" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="squareWindow2" value="s2" />
<%} %>
</td>



<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-3.jpg"  />

<%if(opdNicuCaseRecord.getSquareWindow()!=null  && opdNicuCaseRecord.getSquareWindow().equals("3")){ %>
<input disabled="disabled" type="checkbox" name="squareWindow3" value="s3" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="squareWindow3" value="s3" />
<%} %>
</td>

<td>
<img style="width:50px; height:50px;" src="../jsp/images/sw-4.jpg"  />
<%if(opdNicuCaseRecord.getSquareWindow()!=null  && opdNicuCaseRecord.getSquareWindow().equals("4")){ %>
<input disabled="disabled" type="checkbox" name="squareWindow4" value="s4" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="squareWindow4" value="s4" />
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
<%if(opdNicuCaseRecord.getArmRecoil()!=null  && opdNicuCaseRecord.getArmRecoil().equals("0")){ %>
<input disabled="disabled" type="checkbox" name="armRecoil" value="a0" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="armRecoil" value="a0" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-1.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil()!=null  && opdNicuCaseRecord.getArmRecoil().equals("1")){ %>
<input disabled="disabled" type="checkbox" name="armRecoil1" value="a1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="armRecoil1" value="a1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-2.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil()!=null  && opdNicuCaseRecord.getArmRecoil().equals("2")){ %>
<input disabled="disabled" type="checkbox" name="armRecoil2" value="a2" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="armRecoil2" value="a2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-3.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil()!=null  && opdNicuCaseRecord.getArmRecoil().equals("3")){ %>
<input disabled="disabled" type="checkbox" name="armRecoil3" value="a3" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="armRecoil3" value="a3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ar-4.jpg"  />
<%if(opdNicuCaseRecord.getArmRecoil()!=null  && opdNicuCaseRecord.getArmRecoil().equals("4")){ %>
<input disabled="disabled" type="checkbox" name="armRecoil4" value="a4" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="armRecoil4" value="a4" />
<%} %>
</td>
<td></td>
</tr>
<tr>
<th>Popliteal Angel</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa--1.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("-1")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle" value="pa-1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle" value="pa-1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-0.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("0")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle0" value="pa0" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle0" value="pa0" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-1.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("1")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle1" value="pa1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle1" value="pa1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-2.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("2")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle2" value="pa2" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle2" value="pa2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-3.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("3")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle3" value="pa3" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle3" value="pa3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-4.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("4")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle4" value="pa4" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle4" value="pa4" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/pa-5.jpg"  />
<%if(opdNicuCaseRecord.getPoplitcalAngle()!=null  && opdNicuCaseRecord.getPoplitcalAngle().equals("5")){ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle5" value="pa5" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="poplitcalAngle5" value="pa5" />
<%} %>
</td>
</tr>
<tr>
<th>Scarf Sign</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss--1.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && opdNicuCaseRecord.getScarfSign().equals("-1")){ %>
<input disabled="disabled" type="checkbox" name="scarfSign" value="ss-1" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="scarfSign" value="ss-1" />
<%} %>
</td>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-0.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && opdNicuCaseRecord.getScarfSign().equals("0")){ %>
<input disabled="disabled" type="checkbox" name="scarfSign0" value="ss0" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="scarfSign0" value="ss0" />
<%} %>
</td>


<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-1.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && opdNicuCaseRecord.getScarfSign().equals("1")){ %>
<input disabled="disabled" type="checkbox" name="scarfSign1" value="ss1" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="scarfSign1" value="ss1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-2.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && opdNicuCaseRecord.getScarfSign().equals("2")){ %>
<input disabled="disabled" type="checkbox" name="scarfSign2" value="ss2" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="scarfSign2" value="ss2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-3.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && opdNicuCaseRecord.getScarfSign().equals("3")){ %>
<input disabled="disabled" type="checkbox" name="scarfSign3" value="ss3" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="scarfSign3" value="ss3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/ss-4.jpg"  />
<%if(opdNicuCaseRecord.getScarfSign()!=null  && opdNicuCaseRecord.getScarfSign().equals("4")){ %>
<input disabled="disabled" type="checkbox" name="scarfSign4" value="ss4" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="scarfSign4" value="ss4" />
<%} %>
</td>

<td></td>
</tr>
<tr>
<th>Heel to Ear</th>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he--1.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && opdNicuCaseRecord.getHeelToEar().equals("-1")){ %>
<input disabled="disabled" type="checkbox" name="heelToEar" value="h-1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="heelToEar" value="h-1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-0.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && opdNicuCaseRecord.getHeelToEar().equals("0")){ %>
<input disabled="disabled" type="checkbox" name="heelToEar0" value="h0" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="heelToEar0" value="h0" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-1.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && opdNicuCaseRecord.getHeelToEar().equals("1")){ %>
<input disabled="disabled" type="checkbox" name="heelToEar1" value="h1" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="heelToEar1" value="h1" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-2.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && opdNicuCaseRecord.getHeelToEar().equals("2")){ %>
<input disabled="disabled" type="checkbox" name="heelToEar2" value="h2" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="heelToEar2" value="h2" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-3.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && opdNicuCaseRecord.getHeelToEar().equals("3")){ %>
<input disabled="disabled" type="checkbox" name="heelToEar3" value="h3" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="heelToEar3" value="h3" />
<%} %>
</td>
<td>
<img style="width:50px; height:50px;" src="../jsp/images/he-4.jpg"  />
<%if(opdNicuCaseRecord.getHeelToEar()!=null  && opdNicuCaseRecord.getHeelToEar().equals("4")){ %>
<input disabled="disabled" type="checkbox" name="heelToEar4" value="h4" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="heelToEar4" value="h4" />
<%} %>
</td>
<td></td>
</tr>
</table>
<label>Total Source</label>
<%if(opdNicuCaseRecord.getTotalSourceOne()!=null  && !opdNicuCaseRecord.getTotalSourceOne().equals("")){ %>
<input  type="text" value="<%=opdNicuCaseRecord.getTotalSourceOne()%>" id="totalSource" name="totalSource" readonly="readonly" />
<%}else{ %>
<input  type="text" value="" id="totalSource" name="totalSource" readonly="readonly" />
<%} %>
<h2 class="h2Text">Physical Maturity</h2>

<table width="100%" border="0" cellspacing="0" cellpadding="3" id="grid" style="background:#fff;" class="table">
<tr>
<th>Skin</th>

<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("Sticky friable transperent")){ %>
<input disabled="disabled" type="checkbox" name="skin" value="Sticky friable transperent" checked="checked"/>
<%}else{%>
<input disabled="disabled" type="checkbox" name="skin" value="Sticky friable transperent" />
<%} %>
Sticky friable transperent
</td>

<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("gelatious red translucent")){ %>
<input disabled="disabled" type="checkbox" name="skingenatiousRed" value="gelatious red translucent"  checked="checked"/>
<%}else{%>
<input disabled="disabled" type="checkbox" name="skingenatiousRed" value="gelatious red translucent" />
<%} %>
gelatious red translucent
</td>


<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("smooth pink visible veins")){ %>
<input disabled="disabled" type="checkbox" name="skinSmoothPink" value="smooth pink visible veins" checked="checked"/>

<%}else{ %>
<input disabled="disabled" type="checkbox" name="skinSmoothPink" value="smooth pink visible veins" />
<%} %>
smooth pink visible veins</td>


<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("superficial peeling  &/or rash few veins")){ %>
<input disabled="disabled" type="checkbox" name="skinPeeling" value="superficial peeling  &/or rash few veins" checked="checked"/>
<%}else{%>
<input disabled="disabled" type="checkbox" name="skinPeeling" value="superficial peeling  &/or rash few veins" />
<%} %>
superficial peeling  &/or rash few veins</td>
<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("cracking pale areas rare veins")){ %>
<input disabled="disabled" type="checkbox" name="skinCracking" value="cracking pale areas rare veins" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="skinCracking" value="cracking pale areas rare veins" />
<%} %>
cracking pale areas rare veins

</td>
<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("parchment deep cracking , no vevessels")){ %>
<input disabled="disabled" type="checkbox" name="skinParchment" value="parchment deep cracking , no vevessels" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="skinParchment" value="parchment deep cracking , no vevessels" />
<%} %>
parchment deep cracking , no vevessels</td>


<td>
<%if(opdNicuCaseRecord.getSkin()!=null  && opdNicuCaseRecord.getSkin().equals("leathery cracked wrinkeled")){ %>
<input disabled="disabled" type="checkbox" name="skinLeathery" value="leathery cracked wrinkeled" checked="checked" />
<%}else{ %>
<input disabled="disabled" type="checkbox" name="skinLeathery" value="leathery cracked wrinkeled" />
<%} %>
leathery cracked wrinkeled</td>
</tr>
<tr>
<th>Lanugo</th>
<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && opdNicuCaseRecord.getLanuge().equals("Lanuge")){ %>
<input disabled="disabled" type="checkbox" name="lanuge" value="Lanuge" checked="checked" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="lanuge" value="Lanuge" />
<%} %>
none
</td>
<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && opdNicuCaseRecord.getLanuge().equals("Sparse")){ %>
<input disabled="disabled" type="checkbox" name="lanugeSparse" value="Sparse" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="lanugeSparse" value="Sparse" />
<%} %>
Sparse </td>
<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && opdNicuCaseRecord.getLanuge().equals("Abundant")){ %>
<input disabled="disabled" type="checkbox" name="lanugeAbundant" value="Abundant" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="lanugeAbundant" value="Abundant" />
<%} %>
Abundant </td>
<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && opdNicuCaseRecord.getLanuge().equals("thinning")){ %>
<input disabled="disabled" type="checkbox" name="lanugethinning" value="thinning" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="lanugethinning" value="thinning" />
<%} %>
thinning </td>

<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && opdNicuCaseRecord.getLanuge().equals("bald areas")){ %>
<input disabled="disabled" type="checkbox" name="lanugeBaldAreas" value="bald areas" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="lanugeBaldAreas" value="bald areas" />
<%} %>
bald areas</td>
<td>
<%if(opdNicuCaseRecord.getLanuge()!=null  && opdNicuCaseRecord.getLanuge().equals("mostly bald")){ %>
<input disabled="disabled" type="checkbox" name="lanugeMostly" value="mostly bald" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="lanugeMostly" value="mostly bald" />
<%} %>
mostly bald</td>
<td></td>
</tr>

<tr>
<th>Planter Surface</th>	
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && opdNicuCaseRecord.getPlanterSurface().equals("heel-toe 40-50 mm 1 < 40 mm 2")){ %>
<input disabled="disabled" type="checkbox" name="planterSurface" value="heel-toe 40-50 mm 1 < 40 mm 2"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="planterSurface" value="heel-toe 40-50 mm 1 < 40 mm 2"  />
<%} %>
heel-toe 40-50 mm 1 < 40 mm 2
</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && opdNicuCaseRecord.getPlanterSurface().equals(">50 mm no crease")){ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceCrease" value=">50 mm no crease" checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceCrease" value=">50 mm no crease" />
<%} %> 
>50 mm no crease</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && opdNicuCaseRecord.getPlanterSurface().equals("faint red mark")){ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceFaint" value="faint red mark"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceFaint" value="faint red mark" />
<%} %>
faint red mark</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && opdNicuCaseRecord.getPlanterSurface().equals("anterior transverse crease only")){ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceAnterior" value="anterior transverse crease only"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceAnterior" value="anterior transverse crease only"  />
<%} %>
anterior transverse crease only</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && opdNicuCaseRecord.getPlanterSurface().equals("creases ant 2/3")){ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceCreasesAnt" value="creases ant 2/3"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceCreasesAnt" value="creases ant 2/3" />
<%} %>
creases ant 2/3</td>
<td>
<%if(opdNicuCaseRecord.getPlanterSurface()!=null  && opdNicuCaseRecord.getPlanterSurface().equals("creases over entire sole")){ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceEntireSole" value="creases over entire sole"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="planterSurfaceEntireSole" value="creases over entire sole" />
<%} %>
creases over entire sole</td>
<td></td>
</tr>
<tr>
<th>Breast</th>
<td>
<%if(opdNicuCaseRecord.getBreast()!=null  && opdNicuCaseRecord.getBreast().equals("imper ceptible")){ %>
<input disabled="disabled" type="checkbox" name="breast" value="imper ceptible"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="breast" value="imper ceptible"/>
<%} %>
imper ceptible 
</td>
<td>
<%if(opdNicuCaseRecord.getBreast()!=null  && opdNicuCaseRecord.getBreast().equals("barely perceptible")){ %>
<input disabled="disabled" type="checkbox" name="breastPerceptible" value="barely perceptible" checked="checked"/>

<%}else{ %>
<input disabled="disabled" type="checkbox" name="breastPerceptible" value="barely perceptible" />
<%} %>

barely perceptible</td>


<td>
<%if(opdNicuCaseRecord.getBreast()!=null  && opdNicuCaseRecord.getBreast().equals("flat arcola  no bud")){ %>
<input disabled="disabled" type="checkbox" name="breastArcola" value="flat arcola  no bud"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="breastArcola" value="flat arcola  no bud" />
<%} %>
flat arcola  no bud</td>
<td>



<%if(opdNicuCaseRecord.getBreast()!=null  && opdNicuCaseRecord.getBreast().equals("stippled areola 1-2mm bud")){ %>
<input disabled="disabled" type="checkbox" name="breastStippled" value="stippled areola 1-2mm bud"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="breastStippled" value="stippled areola 1-2mm bud" />
<%} %>
stippled areola 1-2mm bud</td>




<td>
<%if(opdNicuCaseRecord.getBreast()!=null  && opdNicuCaseRecord.getBreast().equals("raised areola 3-4mm bud")){ %>
<input disabled="disabled" type="checkbox" name="breastRaised" value="raised areola 3-4mm bud"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="breastRaised" value="raised areola 3-4mm bud"/>
<%} %>
raised areola 3-4mm bud</td>
<td>
<%if(opdNicuCaseRecord.getBreast()!=null  && opdNicuCaseRecord.getBreast().equals("full areola 5-10mm bud")){ %>
<input disabled="disabled" type="checkbox" name="breastAreola" value="full areola 5-10mm bud"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="breastAreola" value="full areola 5-10mm bud"  />
<%} %>
full areola 5-10mm bud</td>
<td></td>
</tr>
<tr>
<th>Eye/Ear</th>
<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && opdNicuCaseRecord.getEyeEar().equals("Lids fused loosely-1 tightly-2")){ %>
<input disabled="disabled" type="checkbox" name="eyeEar" value="Lids fused loosely-1 tightly-2 "  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="eyeEar" value="Lids fused loosely-1 tightly-2 "/>
<%} %>
Lids fused loosely-1 tightly-2 
</td>
<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && opdNicuCaseRecord.getEyeEar().equals("Lids open pinna flat stays folded")){ %>
<input disabled="disabled" type="checkbox" name="eyeEarPinna" value="Lids open pinna flat stays folded"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="eyeEarPinna" value="Lids open pinna flat stays folded"  />
<%} %>
Lids open pinna flat stays folded</td>
<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && opdNicuCaseRecord.getEyeEar().equals("sl. curved pinna soft slow recoil")){ %>
<input disabled="disabled" type="checkbox" name="eyeEarCurvedPinna" value="sl. curved pinna soft slow recoil"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="eyeEarCurvedPinna" value="sl. curved pinna soft slow recoil"/>
<%} %>
sl. curved pinna soft slow recoil </td>

<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && opdNicuCaseRecord.getEyeEar().equals("well curved pinna , soft budready recoil")){ %>
<input disabled="disabled" type="checkbox" name="eyeEarSoftBudready" value="well curved pinna , soft budready recoil"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="eyeEarSoftBudready" value="well curved pinna , soft budready recoil" />
<%} %>
well curved pinna , soft budready recoil</td>


<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && opdNicuCaseRecord.getEyeEar().equals("formed and firm instant recoil")){ %>
<input disabled="disabled" type="checkbox" name="eyeEarInstandRecoil" value="formed and firm instant recoil"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="eyeEarInstandRecoil" value="formed and firm instant recoil" />
<%} %>
formed and firm instant recoil</td>


<td>
<%if(opdNicuCaseRecord.getEyeEar()!=null  && opdNicuCaseRecord.getEyeEar().equals("thick cartilage ear stiff")){ %>
<input disabled="disabled" type="checkbox" name="eyeEarStiff" value="thick cartilage ear stiff"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="eyeEarStiff" value="thick cartilage ear stiff" />
<%} %>

thick cartilage ear stiff</td>
<td></td>
</tr>
<tr>
<th>Genilals Male</th>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && opdNicuCaseRecord.getGenilalsMale().equals("Scrotum flat smooth")){ %>
<input disabled="disabled" type="checkbox" name="genilalsMale" value="Scrotum flat smooth"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsMale" value="Scrotum flat smooth" />
<%} %>
Scrotum flat smooth 
</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && opdNicuCaseRecord.getGenilalsMale().equals("Scrotum empty faint rugae")){ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleScrotumEmpty" value="Scrotum empty faint rugae"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleScrotumEmpty" value="Scrotum empty faint rugae" />
<%} %>
Scrotum empty faint rugae</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && opdNicuCaseRecord.getGenilalsMale().equals("testes in upper canal rare rugae")){ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleUpperCanal" value="testes in upper canal rare rugae"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleUpperCanal" value="testes in upper canal rare rugae" />
<%} %>
testes in upper canal rare rugae </td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && opdNicuCaseRecord.getGenilalsMale().equals("testes descending few rugae")){ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleFewRugae" value="testes descending few rugae"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleFewRugae" value="testes descending few rugae" />
<%} %>
testes descending few rugae</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && opdNicuCaseRecord.getGenilalsMale().equals("testes down good rugae")){ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleGoodRugae" value="testes down good rugae"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleGoodRugae" value="testes down good rugae" />
<%} %>
testes down good rugae</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsMale()!=null  && opdNicuCaseRecord.getGenilalsMale().equals("testes pendulous deep rugae")){ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleDeepRugae" value="testes pendulous deep rugae"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsMaleDeepRugae" value="testes pendulous deep rugae" />
<%} %>
testes pendulous deep rugae</td>
<td></td>
</tr>
<tr>
<th>Genilals Female</th>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && opdNicuCaseRecord.getGenilalsFemale().equals("Clitoris Prominant labia flat")){ %>
<input disabled="disabled" type="checkbox" name="genilalsFemale" value="Clitoris Prominant labia flat"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsFemale" value="Clitoris Prominant labia flat" />
<%} %>
Clitoris Prominant labia flat

</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && opdNicuCaseRecord.getGenilalsFemale().equals("Prominant Clitoris small labia minora")){ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleLabiaMinora" value="Prominant Clitoris small labia minora"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleLabiaMinora" value="Prominant Clitoris small labia minora" />
<%} %>
Prominant Clitoris small labia minora</td>

<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && opdNicuCaseRecord.getGenilalsFemale().equals("Prominant Clitoris enlarging minora")){ %>
<input disabled="disabled" disabled="disabled" type="checkbox" name="genilalsFemaleEnlargingMinora" value="Prominant Clitoris enlarging minora"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleEnlargingMinora" value="Prominant Clitoris enlarging minora" />
<%} %>
Prominant Clitoris enlarging minora</td>

<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && opdNicuCaseRecord.getGenilalsFemale().equals("majora  & minora equally prominant")){ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleEquallyProminant" value="majora  & minora equally prominant"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleEquallyProminant" value="majora  & minora equally prominant"  />
<%} %>
majora  & minora equally prominant</td>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && opdNicuCaseRecord.getGenilalsFemale().equals("majora large minora small")){ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleMinoraSmall" value="majora large minora small"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleMinoraSmall" value="majora large minora small"  />
<%} %>
majora large minora small </td>
<td>
<%if(opdNicuCaseRecord.getGenilalsFemale()!=null  && opdNicuCaseRecord.getGenilalsFemale().equals("majora cover clitoris & minora")){ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleClitoris" value="majora cover clitoris & minora"  checked="checked"/>
<%}else{ %>
<input disabled="disabled" type="checkbox" name="genilalsFemaleClitoris" value="majora cover clitoris & minora" />
<%} %>
majora cover clitoris & minora	</td>
<td></td>
</tr>
</table>
</div>
<label>Total Source</label>
<%if(opdNicuCaseRecord.getTotalSourceTwo()!=null  && !opdNicuCaseRecord.getTotalSourceTwo().equals("")){ %>
<input  type="text" value="<%=opdNicuCaseRecord.getTotalSourceTwo()%>" id="totalSources" name="totalSources" readonly="readonly" />
<%}else{ %>
<input  type="text" value="" id="totalSources" name="totalSources" readonly="readonly" />
<%} %>


<div class="clear"></div>

<label>Grand Total Source</label>
<%if(opdNicuCaseRecord.getGrandTotalSource()!=null  && !opdNicuCaseRecord.getGrandTotalSource().equals("")){ %>
<input  type="text" value="<%=opdNicuCaseRecord.getGrandTotalSource()%>" id="grandtotalSources" name="grandtotalSources" readonly="readonly" />
<%}else{ %>
<input  type="text" value="" id="grandtotalSources" name="grandtotalSources" readonly="readonly" />
<%} %>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<br/>

<table width="810" border="0" cellspacing="0" cellpadding="3" align="center" > 
  <tbody>
    <tr>
      <td align="right"><label class="fontBold">Weight : </label></td>
      <td align="left"><label><%=opdNicuCaseRecord.getOpdPatientDetails().getWeight() %>&nbsp; <span class="subText">Kg.</span> </label></td>
      <td align="right"><label class="fontBold">Height :</label></td>
      <td align="left"><label><%=opdNicuCaseRecord.getOpdPatientDetails().getHeight()%>   <span class="subText">Cms.</span> </label></td>
      <td align="right"><label class="fontBold">Head Circumference  :</label></td>
      <td align="left"><label><%= opdNicuCaseRecord.getHeadcircumference()%> </label><span class="subText">Cms.</span> </label></td>
      <td align="right"><label class="fontBold">Weeks  : </label></td>
      <td colspan="5" align="left"><label> <%=opdNicuCaseRecord.getWeek()%> </label></td>
      
    </tr>     


  </tbody>
</table>

<%}} %>

<style>
.fontBold {font-weight:bold;}
.subText{font-size:11px;}
table th {text-align:left;}
.h2Text {font-size:20px; margin:7px 0px;}
.h1Text {font-size:22px; margin:7px 0px;}

.table {border:solid 1px #ccc;}
.table th {border:solid 1px #ccc;}
.table td {border:solid 1px #ccc;}


</style>
