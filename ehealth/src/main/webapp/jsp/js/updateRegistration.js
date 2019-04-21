function checkForDOB() {

	if (document.getElementById("qAgeId").value != ""
			&& document.getElementById("qAgeId").value > 0) {
		if (document.getElementById("qAgeId").value < 150) {
			var ageAtRegTime = document.getElementById("qAgeId").value;
			if (ageAtRegTime.indexOf(".") == 1) {
				currentAge = ageAtRegTime.substring(0, ageAtRegTime
						.indexOf("."));
			} else if (ageAtRegTime.indexOf(".") == -1) {
				currentAge = document.getElementById("qAgeId").value;
			}
			document.getElementById('qAgeId').value = currentAge;
			var apoxAge = calculateApproxDobFromAge();
			document.getElementById("qDobId").value = "";
			if (undefined != apoxAge && apoxAge != "")
				document.getElementById("qDobId").value = apoxAge;
		} else {
			alert("Enter valid age ")
			document.getElementById("qAgeId").value = "";
			return false;
		}

	}

	return true;
}






function calculateApproxDobFromAgeYear() {

	// var tempDob= document.getElementById("qYobId").value;
	var age = document.getElementById('qAgeId').value;

	if (age === null || age === '' || 0 === age.length) {
		document.getElementById("qYobId").value = "";
		document.getElementById('qDobId;;').value = "";

		// alert("Enter age ")
	} else {

		var obj = age.split(" ");

		currentDateJ = new Date();

		unit = document.getElementById("qAgeUnitId").value;

		year = 0;
		month = 0;
		day = 0;
		if (unit == 'Years') {
			year = currentDateJ.getFullYear() - age;
			month = currentDateJ.getMonth() + 1;

		} else if (unit == 'Months') {
			if (document.getElementById('qAgeId').value >= 0) {

				if (parseInt(currentDateJ.getMonth() + 1) > age) {
					month = (currentDateJ.getMonth() + 1) - age;

				} else {
					month = age - (currentDateJ.getMonth() + 1);

				}

				if (month >= 0 && month > 12) {
					var tempYear = month / 12;
					var tempmont = month % 12;

					year = year - parseInt(tempYear);
					month = parseInt(tempmont);
				}
				if (month <= 0) {
					month = month + 12
					year--;
				}
				if (month != 0)
					month = (month < 10) ? "0" + month : month

			} else {

				alert("Months is not valid")

				document.getElementById('qAgeId').value = "";
				document.getElementById("qYobId").value = "";
				return false;
			}

		} else if (unit == 'Days') {

			var someDate = new Date();

			someDate.setDate(someDate.getDate() - parseInt(age));
			var dd = someDate.getDate();

			var mm = someDate.getMonth() + 1;
			var yyyy = someDate.getFullYear();

			if (dd.toString().length == 1) {
				dd = "0" + dd;

			}
			if (mm.toString().length == 1) {
				mm = "0" + mm;

			}
			if (yyyy <= 0)
				// year = currentDateJ.getFullYear()+year;
				document.getElementById("qDobId").value = year;
			approxDob = dd + "/" + mm + "/" + yyyy;
			document.getElementById("qDobId").readonly = true;
			document.getElementById("calImageId").readonly = true;
			document.getElementById("nationalDobId").value = 'y';
			document.getElementById("qDobId").value = approxDob;
			return approxDob;
		} else {
		}
		if (year <= 0)
			year = currentDateJ.getFullYear() + year;
		document.getElementById("qDobId").value = year;
		if (month <= 0)
			month = month;
		// month = (((currentDateJ.getMonth()+1)+month)<10)? "01":"01";
		if (day == 0) {
			// day = currentDateJ.getDate(); // commented by amit das on
			// 10-06-2017
			// added by amit das on 10-06-2017
			if (currentDateJ.getDate() > 9) {
				day = currentDateJ.getDate();
			} else {
				day = "0" + currentDateJ.getDate();
			}
			// day = (currentDateJ.getDate()<10)? "01":"01";
		}
		if (unit.localeCompare('Days') == 0) {
			month = (currentDateJ.getMonth() + 1)
			if (currentDateJ.getDate() < age) {
				month--;
			}

		}
		var dayS = "" + day;
		var monthS = "" + month;
		if (dayS.length == 1) {
			if (day < 10) {
				dayS = "0" + day;
			}
		}
		if (monthS.length == 1) {
			if (month < 10) {
				monthS = "0" + month;
			}
		}
		approxDob = dayS + "/" + monthS + "/" + year;
		document.getElementById("qDobId").readonly = true;
		document.getElementById("calImageId").readonly = true;
		document.getElementById("nationalDobId").value = 'y';
		document.getElementById("qDobId").value = approxDob;
		return approxDob;

	}
	// document.getElementById("qAgeId").readonly = true;
	// document.getElementById("qAgeUnitId").readonly = true;

	/*
	 * document.getElementById("qAgeId").disabled=true;
	 * document.getElementById("qAgeUnitId").disabled=true;
	 */

	// return tempDob;

}

function calculateApproxDobFromAge() {
	// var tempDob=
	document.getElementById("qYobId").value = "";
	var tempDob = document.getElementById("qYobId").value;

	if (!tempDob || 0 === tempDob.length) {

		var age = document.getElementById('qAgeId').value;

		var obj = age.split(" ");
		currentDateJ = new Date();

		unit = document.getElementById("qAgeUnitId").value;

		year = 0;
		month = 0;
		day = 0;
		if (unit == 'Years') {
			year = currentDateJ.getFullYear() - age;

		} else if (unit == 'Months') {
			if (document.getElementById('qAgeId').value <= 12) {
				month = (currentDateJ.getMonth() + 1) - age;

				if (month <= 0) {
					month = month + 12
					year--;
				}
				if (month != 0)
					month = (month < 10) ? "0" + month : month

			} else {
				document.getElementById('qAgeId').value = "";

				alert("Months is not valid")

				return "";
			}

		} else if (unit == 'Days') {

			var someDate = new Date();

			someDate.setDate(someDate.getDate() - parseInt(age));
			var dd = someDate.getDate();
			var mm = someDate.getMonth() + 1;
			var yyyy = someDate.getFullYear();

			if (dd.toString().length == 1) {
				dd = "0" + dd;
			}
			if (mm.toString().length == 1) {
				mm = "0" + mm;
			}
			if (yyyy <= 0)
				// year = currentDateJ.getFullYear()+year;
			document.getElementById("qYobId").value=yyyy;
				approxDob = dd + "/" + mm + "/" + yyyy;
			document.getElementById("qDobId").readonly = true;
			document.getElementById("calImageId").readonly = true;
			document.getElementById("nationalDobId").value = 'y';
			document.getElementById("qDobId").value = approxDob;

			return approxDob;
		}

		if (year <= 0)
			year = currentDateJ.getFullYear() + year;
		// document.getElementById("yobId").value=year;
		if (month <= 0)
			month = ((currentDateJ.getMonth() + 1) < 10) ? "0"
					+ (currentDateJ.getMonth() + 1)
					: (currentDateJ.getMonth() + 1);
		// month = (((currentDateJ.getMonth()+1)+month)<10)? "01":"01";
		/*
		 * if(day == 0 ){ day = (currentDateJ.getDate()<10)? "01":"01"; }
		 */
		if (day == 0) {
			// day ="0"+currentDateJ.getDate(); // commented by amit das on
			// 10-06-2017
			// added by amit das on 10-06-2017
			if (currentDateJ.getDate() > 9) {
				day = currentDateJ.getDate();
			} else {
				day = "0" + currentDateJ.getDate();
			}

			// day = (currentDateJ.getDate()<10)? "01":"01";
		}
		if (unit.localeCompare('Days') == 0) {
			month = (currentDateJ.getMonth() + 1)
			if (currentDateJ.getDate() < age) {
				month--;
			}

		}
		approxDob = day + "/" + month + "/" + year;
		// document.getElementById("yobId").value=year;
		document.getElementById("qDobId").readonly = true;
		document.getElementById("calImageId").readonly = true;
		document.getElementById("nationalDobId").value = 'y';
		document.getElementById("qDobId").value = approxDob;

		return approxDob;

	} else {
		document.getElementById("qAgeId").readonly = false;
		document.getElementById("qAgeUnitId").readonly = true;

		/*
		 * document.getElementById("qAgeId").disabled=true;
		 * document.getElementById("qAgeUnitId").disabled=true;
		 */

		return tempDob;
	}

}