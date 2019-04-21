<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ph Survey Chart </title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	// Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {
	

		
		// Create the data table.	
		var data = google.visualization.arrayToDataTable([
													['Country', 'Area(square km)'],
													<c:forEach items="${responseMap}" var="entry">
														[ '${entry.key}', ${entry.value} ],
													</c:forEach>
												]);
	
		// Set chart options
		var options = {
			'title' : 'PH Survey Details',
			is3D : true,
			pieSliceText: 'label',
			tooltip :  {showColorCode: true},
			'width' : 900,
			'height' : 500
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<div style="width: 600px;">
		<div id="chart_div"></div>
	</div>
</body>
</html>