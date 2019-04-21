<%@page import="jkt.hms.masters.business.StoreSlowMovingDrugs"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
Map<String,Object> newmap = new HashMap<String,Object>();
List<StoreSlowMovingDrugs> storeSlowMovingDrugList = new ArrayList<StoreSlowMovingDrugs>();
int pvmsCount = 0;
int totalCount = 0;
if(request.getAttribute("map") != null)
{
	newmap=(Map<String, Object>)request.getAttribute("map");
	
	if(newmap.get("storeSlowMovingDrugList")!=null){
		storeSlowMovingDrugList = (List<StoreSlowMovingDrugs>) newmap.get("storeSlowMovingDrugList");
	}
	
	System.out.println("storeSlowMovingDrugList===in jsp==="+storeSlowMovingDrugList.size());
}
double count = 0.1;
	if(storeSlowMovingDrugList.size()>0){
		for(StoreSlowMovingDrugs storeSlowMovingDrugs : storeSlowMovingDrugList){
%>
<script type="text/javascript">
	var opts = 
	{
		lines: 12, // The number of lines to draw
		angle: 0.1, // The length of each line
		lineWidth: 0.3, // The line thickness
		pointer: 
		{
	 		length: 0.75, // The radius of the inner circle
	 		strokeWidth: 0.035, // The rotation offset
	 		color: '#000000' // Fill color
		}
	};
	var target = document.getElementById('canvas1');
	gauge = new Gauge(target);
	gauge.setOptions(opts);
	gauge.maxValue = <%=storeSlowMovingDrugs.getItemName()%>;
	if(!getInternetExplorerVersion())
		gauge.animationSpeed = 1;
	gauge.setTextField(document.getElementById('canvasText'));
	gauge.set(<%=count<=totalCount?count:totalCount%>);
	document.getElementById("canvas1").style.boxShadow="2px 2px 2px 1px "+gauge.getColorForValue(<%=count%>,true);
	document.getElementById('canvasMin').innerHTML = gauge.minValue;
	document.getElementById('canvasMax').innerHTML = gauge.maxValue;

	//var textWidth = (document.getElementById("canvas1").offsetWidth/2)-(document.getElementById("canvasText").offsetWidth*11.5);
	//document.getElementById("canvasText").style.left = textWidth+"px";
	var textWidth = (document.getElementById("canvas1").offsetWidth/2)-(document.getElementById("canvasLabel").offsetWidth);
	document.getElementById("canvasLabel").style.left = textWidth+"px";
</script>
<%}} %>
<canvas id="canvas1" height="200" width="330"></canvas>
<div class="Clear"></div>
<span id="canvasMin"></span>
<span id="canvasMax"></span>
<label id="canvasLabel">NA Critical</label>
<label id="canvasText"></label>
