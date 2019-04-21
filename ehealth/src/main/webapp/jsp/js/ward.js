function populateLsgByDistrictId(districtId) {
	obj = document.getElementById("lsgId");
	obj.length = 1;

	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {

			var chargeCodes = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {

				var item = chargeCodes.childNodes[loop];
				var id = item.getElementsByTagName("id")[0];
				var name = item.getElementsByTagName("name")[0];

				obj.length++;
				obj.options[obj.length - 1].value = id.childNodes[0].nodeValue;
				obj.options[obj.length - 1].text = (name.childNodes[0].nodeValue).trim();

			}
		}
	}

	xmlHttp.open("GET",
			"/hms/hms/generalMaster?method=populateLsgByDistrictId&districtId="
					+ districtId, true);

	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

function populateWardByLsgId(lsgId) {

	obj = document.getElementById("wardId");
	obj.length = 1;

	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {

			var chargeCodes = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {

				var item = chargeCodes.childNodes[loop];
				var id = item.getElementsByTagName("id")[0];
				var name = item.getElementsByTagName("name")[0];

				obj.length++;
				obj.options[obj.length - 1].value = id.childNodes[0].nodeValue;
				obj.options[obj.length - 1].text = name.childNodes[0].nodeValue;

			}
		}
	}

	xmlHttp.open("GET",
			"/hms/hms/generalMaster?method=populateWardByLsgId&lsgId=" + lsgId,
			true);

	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}