
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdMedicineSpecialityTemplate"%>
<%@page import="jkt.hms.masters.business.OpdMedicineCardiovascularSystem"%>
<%@page import="jkt.hms.masters.business.OpdMedicineArterialBloodPressure"%>

<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}


	Map<String,Object> map = new HashMap<String,Object>();

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<div class="Block">
<form method="post" action="" name="medicineTemplate" >


<input id="CLFlag" name="CLFlag" tabindex="1" value="ContactLens" type="hidden"  />
<input type="hidden" name="templateName" value="Contact Lens"/>

<h6>Contact Lens Clinic</h6>
<div class="clear"></div>

<h4 class="h4style">History</h4>
<div class="clear"></div>
<h4>Defective Vision</h4>
<label>Left</label>
 <select class="medium2" name="def_vision_le"><option value="">Select</option><option>Distance</option><option>Near</option></select>
 <input type="text" name="defective_vis_le_dur" placeholder="Duration" value="" class="allownumericwithoutdecimal textSmall" maxlength="5" onkeypress="return isNumber(event)"/>
 <select class="medium2" name="def_dur_type_le"><option value="">Select</option><option>Year</option><option>Month</option><option>Days</option></select>
 
 <div class="clear"></div>
<label>Right</label>
<select class="medium2" name="def_vision_re"><option value="">Select</option><option>Distance</option><option>Near</option></select>
 <input type="text" name="defective_vis_re_dur" placeholder="Duration" class="allownumericwithoutdecimal textSmall" maxlength="5" value="" onkeypress="return isNumber(event)"/>
 <select class="medium2" name="def_dur_type_re"><option value="">Select</option><option>Year</option><option>Month</option><option>Days</option></select>
 
 
 <div class="clear"></div>
 <h4>Present Treatment</h4>
 <label class="auto">Contact Lens <input class="checkboxMargin" id="pt_cont_lens" name="pt_cont_lens" type="checkbox"></label>
					
 <input type="text" name="pt_cont_lens_dur" id="pt_cont_lens_dur" onkeyup="isClickedCB('pt_cont_lens', this.id);" onkeypress="return isNumber(event)" placeholder="Duration" class="allownumericwithoutdecimal textSmall" value="" maxlength="5"/>
 <select class="medium2" name="pt_cont_lens_dur_type" id="pt_cont_lens_dur_type"  onchange="isClickedCB('pt_cont_lens', this.id);"><option value="">Select</option><option>Year</option><option>Month</option><option>Days</option></select>
 <select class="medium2" name="pt_cont_lens_value" onchange="toggleOtherTextbox(this.value,'pt_cont_lens_value_others','10','pt_cont_others')"><option value="" >Select</option><option>RGP</option><option>Soft</option><option>Others</option> </select>
 <span id="pt_cont_others"></span>
  <div class="clear"></div>
 
 <label class="auto" style="width: 97px;">Spectacles<input class="checkboxMargin" id="pt_spectacles" name="pt_spectacles" type="checkbox"></label>
 <input type="text" name="pt_spectacles_dur" id="pt_spectacles_dur" onkeyup="isClickedCB('pt_spectacles', this.id);" onkeypress="return isNumber(event)" placeholder="Duration" class="allownumericwithoutdecimal textSmall" value="" maxlength="5"/>
 <select class="medium2" name="pt_spectacles_dur_type" id="pt_spectacles_dur_type" onchange="isClickedCB('pt_spectacles', this.id);"><option value="">Select</option><option>Year</option><option>Month</option><option>Days</option></select>
 
 <div class="clear"></div>
 <div class="paddingTop5"></div>
 <div class="paddingTop5"></div>
<!--  <h4>Vision (Unaided)</h4> -->
 <table style="width:370px; float:left;" class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0"> 
    <tbody><tr>
      <th align="center"><h4 class="h4style">Vision (Unaided)</h4></th>
      <th align="center" class="thHeading">Right Eye</th>
      <th align="center" class="thHeading">Left Eye</th>
    </tr>
    <tr>
  <tr><td><label class="Tablelabel">Distance</label> </td><td><input type="text" name="vision_unaided_dis_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="vision_unaided_dis_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
  <tr><td><label class="Tablelabel">Near</label> </td><td><input type="text" name="vision_unaided_near_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="vision_unaided_near_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
 </tbody></table>
 
  
 <!-- <h4>Vision With Present Treatment</h4> -->
 <table style="width:390px; float:left;margin-left:60px;" class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0"> 
    <tbody><tr>
      <th align="center"><h4 class="h4style">Vision With Present Treatment</h4></th>
      <th align="center" class="thHeading"> Right Eye</th>
      <th align="center" class="thHeading">Left Eye</th>
    </tr>
    <tr>
 <td><label class="Tablelabel">Distance</label> </td><td><input type="text" name="vision_pt_dis_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="vision_pt_dis_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
  <tr><td><label class="Tablelabel">Near</label> </td><td><input type="text" name="vision_pt_near_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="vision_pt_near_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
 </tbody></table>
<div class="clear"></div>
 <div class="paddingTop5"></div>
 <div class="paddingTop5"></div>
<!--  <h4>Subjective Reflection</h4> -->
 <table style="width:494px; float:left;" class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0"> 
    <tbody><tr>
      <th align="center"><h4 class="h4style">Subjective Refraction</h4></th>
      <th class="thHeading" colspan="3">Right Eye</th>
      <th class="thHeading" colspan="3">Left Eye</th>
    </tr>
    <tr><th></th><th>Sph</th><th>Cyl</th><th>Axis</th><th>Sph</th><th>Cyl</th><th>Axis</th></tr>
    <tr>
     <td><label class="Tablelabel">Distance</label> </td><td><input type="text" name="sph_dis_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="cyl_dis_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="axis_dis_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td>
     <td><input type="text" name="sph_dis_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="cyl_dis_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="axis_dis_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td>
    </tr>
   <tr>
     <td><label class="Tablelabel">Near</label> </td><td><input type="text" name="sph_near_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="cyl_near_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="axis_near_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td>
     <td><input type="text" name="sph_near_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="cyl_near_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="axis_near_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td>
    </tr>
 </tbody></table>
 
 <div class="clear"></div>
 <div class="paddingTop5"></div>
 <div class="paddingTop5"></div>
<!--   <h4>Keratometry</h4> -->
 <table style="width:390px; float:left;" class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0"> 
    <tbody><tr>
      <th align="center"><h4 class="h4style">Keratometry</h4></th>
      <th class="thHeading"> Right Eye</th>
      <th class="thHeading">Left Eye</th>
    </tr>
   <tr><td><label class="Tablelabel">K1</label></td><td><input type="text" name="k1_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="k1_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
   <tr><td><label class="Tablelabel">K2</label></td><td><input type="text" name="k2_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="k2_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
   <tr><td><label class="Tablelabel">R1</label></td><td><input type="text" name="r1_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="r1_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
   <tr><td><label class="Tablelabel">R2</label></td><td><input type="text" name="r2_re"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td><td><input type="text" name="r2_le"  maxlength="5" class="allownumericwithoutdecimal textSmall" value=""/></td></tr>
 </tbody></table>
 <div class="clear"></div>
 <h4></h4>
 <div class="clear"></div>
 <h4>S/L Examination</h4>
 <label>Lid Margin</label><input type="text" name="sl_exam_lid_margin"  maxlength="30" class="allownumericwithoutdecimal" value=""/>
 <label>UTC</label><input type="text" name="sl_exam_utc"  maxlength="30" class="allownumericwithoutdecimal" value=""/><div class="clear"></div>
 <label>TBUT</label><input type="text" name="sl_exam_tbut"  maxlength="30" class="allownumericwithoutdecimal" value=""/>
 <label>Others</label><input type="text" name="sl_exam_others"  maxlength="30" class="allownumericwithoutdecimal" value=""/>
 
  <div class="clear"></div>
 <h4></h4>
  <label>Comments</label><textarea  name="remarks" maxlength="100" style="width: 179px;"></textarea><label>Vision with lens</label><textarea  style="width: 179px;" name="contact_lens_vision" maxlength="100"></textarea><div class="clear"></div>
  <label>Over Refraction</label><textarea  style="width: 179px;" name="over_refraction"maxlength="100"></textarea><label>Others</label><textarea style="width: 179px;" name="others" maxlength="100"></textarea>
  
  <div class="clear"></div>
 <label>Trail-I</label><select name="trail_I_value1"><option value="">Select</option><option>RGP</option><option>Soft</option></select><select name="trail_I_value2"><option value="">Select</option><option>BC</option><option>Power</option><option>TD</option></select> <div class="clear"></div>
 <label>Lens Order</label><select name="lens_order_value1"><option value="">Select</option><option>RGP</option><option>Soft</option></select><select name="lens_order_value2"><option value="">Select</option><option>BC</option><option>Power</option><option>TD</option></select>
 <label class="auto">Contact Lens Solution<input class="checkboxMargin"  name="cl_solution" type="checkbox"></label> <label class="auto">Lens Case <input class="checkboxMargin"  name="lens_case" type="checkbox"></label>
 
 
  <div class="clear"></div>
 <h4></h4>
 
  <div class="clear"></div>
 <h4></h4>
 

</form>
</div>
  

<script>jQuery.noConflict();
jQuery(function($) {
	
	$("#wave").on('change','option',function(){
		 var val =$(this).val();
			//alert(val);
			if(!document.getElementById("multiDropDownValue").value.includes(val)){
			document.getElementById(val.charAt(0)+"wave_lebel").style.display='block';
			document.getElementById(val.charAt(0)+"wave_remarks").style.display='block';	
			}
			else
				{
				document.getElementById(val.charAt(0)+"wave_lebel").style.display='none';
				document.getElementById(val.charAt(0)+"wave_remarks").style.display='none';
				}
	});
	
	 $('#wave').multiSelect();
	    $('#line-wrap-example').multiSelect({
	        positionMenuWithin: $('.position-menu-within')
	    });
	    $('#categories').multiSelect({
	        noneText: 'All categories',
	        presets: [
	            {
	                name: 'All categories',
	                options: []
	            },
	            {
	                name: 'My categories',
	                options: ['a', 'c']
	            }
	        ]
	    });
});
	    </script>
<style>
.w270{width:273px !important;}

.thHeading{background:#ebe7e7 !important; color:#0f75bf !important; font-weight:bold !important; font-size:14px;}
 

</style>



