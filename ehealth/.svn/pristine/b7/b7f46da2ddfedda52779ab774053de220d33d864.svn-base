

<%@ page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.OpdEntExaminationSpeciality"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="/hms/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
    <script type="text/javascript" src="/hms/jsp/js/djaodjin-annotate.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
	        List<OpdEntExaminationSpeciality>entExaminationList = new ArrayList<OpdEntExaminationSpeciality>();
	    	List<OpdEntExaminationSpeciality>entImagesList = new ArrayList<OpdEntExaminationSpeciality>();	
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				if(map.get("entExaminationList") != null){
					entExaminationList = (List)map.get("entExaminationList");
				}
				
				if(map.get("entImagesList") != null){
					entImagesList = (List)map.get("entImagesList");
				}
				int hinId = 0;
				if(map.get("hinId") != null){
					hinId = (Integer)map.get("hinId");
				}
				
				Date visitDate = null;
				if(entImagesList.size()>0){
					visitDate = (Date)entImagesList.get(0).getVisit().getVisitDate();
				}
				
		%>
				
	

<form name="viewENTImages" method="post" action="" >
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<div class="titleBg">
<h2 class="h4Tab">View Images</h2>
</div>
<div class="Block">
<label>Visit Date</label>
<select name="visitDate" id="visitDate" validate="" onchange="displayDateWiseImages(this.value);">
<option value="">Select</option>
<%if(entExaminationList.size()>0){
	for(OpdEntExaminationSpeciality entExaminationSpeciality :entExaminationList){
		if(entExaminationSpeciality.getVisit().getVisitDate().equals(visitDate)){
	%>
	<option value="<%=entExaminationSpeciality.getVisit().getId()%>" selected="selected"><%=HMSUtil.convertDateToStringWithoutTime(entExaminationSpeciality.getVisit().getVisitDate()) %></option>
<%}else{ %>
	<option value="<%=entExaminationSpeciality.getVisit().getId()%>"><%=HMSUtil.convertDateToStringWithoutTime(entExaminationSpeciality.getVisit().getVisitDate()) %></option>

<%} }}%>
</select>
<div class="clear"></div>
<%if(entImagesList.size()>0){ 
	String imageName = "";
	String imgSrc ="";
	String imagextension = "png";
	String fileSeparator = System.getProperty("file.separator");
	String imageNameStr = entImagesList.size()>0 && entImagesList.get(0).getImageName() !=null?entImagesList.get(0).getImageName() :"";
	
	if(!imageNameStr.equals("")){
	String[] imageList = imageNameStr.split(",");
	
	for(int j = 0; j < imageList.length; j++)
	{
    	  //imgSrc = getServletContext().getRealPath("/specialityImage")+fileSeparator+imageList[j]+"."+imagextension;
    	  imgSrc = request.getContextPath()+fileSeparator+"specialityImage"+fileSeparator+imageList[j]+"."+imagextension;
    	    //System.out.println(imageList[j]);
    	  //imgSrc = request.getContextPath()+fileSeparator+"\\specialityImage\\"+"ENT_3338312_01";
    	  
		
	
         %>
          <div class="ann"  data-src="<%= imgSrc%>" style="position: relative;" id="image1"  ></div>
   
<%}} %>

<%} %>

<input type="hidden" name="hinId" id="hinId"  value="<%=hinId%>"/>

<div class="clear"></div>
</div>
<script type="text/javascript">
function displayDateWiseImages(visitId){
	var hinId = document.getElementById('hinId').value
	submitForm('viewENTImages','/hms/hms/opd?method=displayDateWiseENTImages&visitId=' + visitId + '&hinId=' + hinId  + '&' + csrfTokenName + '='+ csrfTokenValue);
	
}

jQuery.noConflict();
//setTimeout(function(){
jQuery(document).ready(function($) {
	   var annotatable = $('.ann');
		    for (var i = 0; i < annotatable.length; i++) {
		        $(annotatable[i]).annotate({
		            color: 'black',
		            images: [annotatable[i].getAttribute('data-src')],
		        	id : i
		        });
		    }
	});
//} , 1000);
 
 
 </script>
 


		</form>
		
		<style type="text/css">
    .annotate-container>[id^=baseLayer] {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 0;
        background: grey;
    }

    .annotate-container>[id^=drawingLayer] {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 1;
        background: transparent;
    }
   
   .ann {float:left; margin:5px 50px 15px 0px;}
   
    </style>
