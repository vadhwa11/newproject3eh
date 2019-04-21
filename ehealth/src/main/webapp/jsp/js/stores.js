var itemsArray1 = new Array();
var itemsArray = new Array();
var indentArray = new Array();
var brandArray = new Array();
var numLinesAdded = 1;
var empArr = new Array();
var tt;
var arrayOfItems1 = new Array();

// -----------------------------------------------------------------------------------------------------------------
// ------------------------------------Start of Functions Written By
// Vivek------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

function fillItemsInDepot(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var nameItemForFocus = "nameItem";
	var stockInVar = "stockInVar";
	var oldNiv = "oldNiv";
	var n = "nameItem";
	var departmentId = "departmentId";
	var qtyInHandTemp = "qtyInHandTemp";
	var mmfVarTemp = "mmfVarTemp";
	var qtyInHand = "qtyInHand";
	qtyInHand = qtyInHand + rowVal
	mmfVarTemp = mmfVarTemp + rowVal
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal
	oldNiv = oldNiv + rowVal
	qtyInHandTemp = qtyInHandTemp + rowVal
	departmentId = departmentId + rowVal
	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(oldNiv).value = itemsArray1[i][5]
			document.getElementById(idAu).value = itemsArray1[i][7]
			if (itemsArray1[i][3] != "null") {
				document.getElementById(qtyInHand).value = itemsArray1[i][3]
				document.getElementById(qtyInHandTemp).value = itemsArray1[i][3]
			} else {
				document.getElementById(qtyInHand).value = "0"
				document.getElementById(qtyInHandTemp).value = "0"
			}
			if (itemsArray1[i][4] != "null") {
				document.getElementById(mmfVarTemp).value = itemsArray1[i][4]
			} else {
				document.getElementById(mmfVarTemp).value = 0
			}

		}
	}
}

// This function is for filling items in Indent To SOC Grid
function fillItemsInSOC(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var nameItemForFocus = "nameItem";
	var stockInVar = "stockInVar";
	var oldNiv = "oldNiv";
	var n = "nameItem";
	var departmentId = "departmentId";
	var qtyInHandTemp = "qtyInHandTemp";
	var mmfVarTemp = "mmfVarTemp";
	var qtyInHand = "qtyInHand";
	qtyInHand = qtyInHand + rowVal
	mmfVarTemp = mmfVarTemp + rowVal
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal
	oldNiv = oldNiv + rowVal
	qtyInHandTemp = qtyInHandTemp + rowVal
	departmentId = departmentId + rowVal

	document.getElementById('currentRow').value = rowVal
	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray.length; i++) {

		if (itemsArray[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray[i][0]
			document.getElementById(codeItem).value = itemsArray[i][1]
			document.getElementById(idAu).value = itemsArray[i][3]
			if (itemsArray[i][3] == "null") {
				document.getElementById(qtyInHand).value = itemsArray[i][3]
				document.getElementById(qtyInHandTemp).value = itemsArray[i][3]
			} else {
				document.getElementById(qtyInHand).value = "0"
				document.getElementById(qtyInHandTemp).value = "0"
			}

		}
	}
}

// This is to set item issued in hidden field
function setItemIsuued(itemIssued, rowVal) {
	alert("setItemIsuued")
	var testVar = 0
	for (i = 0; i < itemsArray.length; i++) {
		if (itemsArray[i][2] == itemIssued) {
			testVar = testVar + 1;
			document.getElementById('issuedItemId' + rowVal).value = itemsArray[i][0]
			return true;

		}
	}

}

// This is fuction to set Total Qty in Main form
function setTotalQty(noOfRows, rowVal) {
	var totalQty = 0;
	for (i = 1; i < parseInt(noOfRows); i++) {
		if (document.getElementById('issuedQty' + i).value != "") {
			totalQty = totalQty
					+ parseInt(document.getElementById('issuedQty' + i).value)
		} else {
			totalQty = totalQty + parseInt(0)
		}
	}
	var reqQty = 0;
	var pendingQty = parseInt(0);
	if (document.getElementById('pendingQty').value != "") {
		 pendingQty = parseInt(document.getElementById('pendingQty').value);
	}
	
	if (totalQty == 0) {
		alert("Can not issue brands without QUANTITY !");
		return false;
	}else if(isNaN(totalQty)){
		alert("please enter the numaric value");
		return false;
	} 
	else {
		// if(document.getElementById('reqQty')){ by deepali
		if (document.getElementById('reqQty').value != "") { // by Ramdular
			// Silvassa 
			// Hotel
			//reqQty = document.getElementById('reqQty').value;
			reqQty = document.getElementById('pendingQty').value;
			
			
			if (parseInt(totalQty) >  parseInt(reqQty)) {
				alert("Can not issue quantity more than requested quantity.");
				return false;
			} else if (parseInt(totalQty) > parseInt(pendingQty)) {
				alert("Can not issue quantity more than pending quantity.");
				return false;
			}
		}
	}
	
	if (window.opener.document.getElementById('qtyIssued' + rowVal).value != "") {
		window.opener.document.getElementById('qtyIssued' + rowVal).value = parseFloat(window.opener.document
				.getElementById('qtyIssued' + rowVal).value)
				+ parseFloat(totalQty);
		window.opener.document.getElementById('qtyPending' + rowVal).value = parseFloat(window.opener.document
				.getElementById('qtyPending' + rowVal).value)
				- parseFloat(totalQty);
	} else {
		window.opener.document.getElementById('qtyIssued' + rowVal).value = totalQty;
		window.opener.document.getElementById('qtyPending' + rowVal).value = pendingQty;
	}
	return true;
}
function setTotalQtyOt(noOfRows, rowVal) {
	var totalQty = 0
	for (i = 1; i < parseInt(noOfRows); i++) {
		if (document.getElementById('qty1' + i).value != "") {
			// totalQty=totalQty+parseInt(document.getElementById('qty1'+i).value)
			totalQty = totalQty
					+ parseInt(document.getElementById('qty1' + i).value)
		} else {
			totalQty = totalQty + parseInt(0)
		}
	}
	var reqQty = 0;

	if (totalQty == 0) {
		alert("Can not issue brands without QUANTITY !");
		return false
	} else {
		// if(document.getElementById('reqQty')){ by deepali
		if (document.getElementById('reqQty').value != "") { // by Ramdular
			// Silvassa
			// Hotel
			reqQty = document.getElementById('pendingQty').value;
			
			reqQty = document.getElementById('reqQty').value;
			if (parseInt(totalQty) > parseInt(reqQty)) {
				alert("Can not issue quantity more than requested quantity.");
				return false
			}
		}
	}
	if (window.opener.document.getElementById('qtyIssued' + rowVal).value != "") {
		window.opener.document.getElementById('qtyIssued' + rowVal).value = parseFloat(window.opener.document
				.getElementById('qtyIssued' + rowVal).value)
				+ parseFloat(totalQty);
	} else {
		window.opener.document.getElementById('qtyIssued' + rowVal).value = totalQty;
	}

	// batchNoTemp
	// lotNo
	return true;
}

function openDeletePopupForIssueciv() {

	var url = "/hms/hms/stores?method=openDeletePopupForIssueciv";
	newwindow = window.open(url, 'name', "height=500,width=870,status=1");

}
function openDeletePopupForIssueToOtherUnits() {
	var url = "/hms/hms/stores?method=openDeletePopupForIssueToOtherUnits";
	newwindow = window.open(url, 'name', "height=900,width=900,status=1");

}
function openDeletePopupForIssueLoanOut() {

	var url = "/hms/hms/stores?method=openDeletePopupForIssueLoanOut";
	newwindow = window.open(url, 'name', "height=900,width=900,status=1");

}

function openDeletePopupForDepartmentIssueNE() {

	var url = "/hms/hms/nonExp?method=openDeletePopupForIssueLoanOut";
	newwindow = window.open(url, 'name', "height=900,width=900,status=1");

	var url = "/hms/hms/nonExp?method=openDeletePopupForIssueLoanOut";
	newwindow = window.open(url, 'name', "height=900,width=900,status=1");

}
function fillRemarksForIssueCiv(rowVal) {

	if (document.getElementById('remarksTemp' + rowVal).value == '') {
		document.getElementById('remarks' + rowVal).value = "emptyString"
	} else {
		document.getElementById('remarks' + rowVal).value = document
				.getElementById('remarksTemp' + rowVal).value
	}

}

function fillQtyIssuedForIssueCiv(rowVal) {

	if (parseInt(document.getElementById('stockIn' + rowVal).value) < parseInt(document
			.getElementById('issuedQtyTemp' + rowVal).value)) {
		alert("Quantity can not be greater than STOCK ...!")
		document.getElementById('issuedQtyTemp' + rowVal).value = ""
		document.getElementById('issuedQtyTemp' + rowVal).focus();
		return false;
	}
	if (document.getElementById('issuedQtyTemp' + rowVal).value == '') {
		document.getElementById('issuedQty' + rowVal).value = 0
	} else {
		document.getElementById('issuedQty' + rowVal).value = document
				.getElementById('issuedQtyTemp' + rowVal).value
	}
}

function fillIssueCivItems(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var issuedItemId = "issuedItemId";
	var issuedName = "issuedName";
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal
	issuedItemId = issuedItemId + rowVal
	issuedName = issuedName + rowVal

	// document.getElementById('currentRow').value=rowVal
	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		return false;
	}
	for (i = 0; i < itemsArray.length; i++) {
		if (itemsArray[i][2] == nomenclature) {
			document.getElementById(idItem).value = itemsArray[i][0]
			document.getElementById(codeItem).value = itemsArray[i][1]
			document.getElementById(idAu).value = itemsArray[i][3]
			document.getElementById(issuedItemId).value = itemsArray[i][0]
			document.getElementById(issuedName).value = nomenclature
		}
	}
}

function checkDispencerySelected() {
	if (document.getElementById('departmentIdTemp').value == "") {
		alert("Select Dispencery ..!")
		return false;
	} else {
		return true;
	}

}
function validateInteger(strValue) {
	// alert("in validate integer")
	var objRegExp = /^((\+|-)\d)?\d*(\d{2})?$/;
	return objRegExp.test(strValue);
}
function fillValuesForMMF(inc) {
	if (document.getElementById('mmfVarTemp' + inc).value != "") {
		validateInteger(document.getElementById('mmfVarTemp' + inc).value)
		document.getElementById('mmfVar' + inc).value = document
				.getElementById('mmfVarTemp' + inc).value
	}
}

function isYearSelected() {
	if (document.getElementById('mmfForTheYear').value == "0") {
		alert("Select Year ...!")
		return false
	} else {
		return true
	}
}

// This used to fill item value in a row based on Code
function fillItemsInDGFMSHQByCode(itemCode, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var idSection = "idSection";
	var nameSection = "nameSection";
	var stockInVar = "stockInVar";
	var stockInVarTemp = "stockInVarTemp";
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;
	idSection = idSection + rowVal;
	nameSection = nameSection + rowVal;
	stockInVar = stockInVar + rowVal;
	stockInVarTemp = stockInVarTemp + rowVal;
	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][1] == itemCode) {
			alert(itemsArray1[i][0])
			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(nameItem).value = itemsArray1[i][2]
			document.getElementById(idAu).value = itemsArray1[i][3]
			document.getElementById(idSection).value = itemsArray1[i][5]
			document.getElementById(nameSection).value = itemsArray1[i][4]
			document.getElementById(stockInVar).value = itemsArray1[i][6]
			alert(itemsArray1[i][6])
			document.getElementById(stockInVarTemp).value = itemsArray1[i][6]
		}
	}
}

// This is the function to get the details of indent soc tracker
// In this function we are checking the selected Indent no ,Department,Item Name
// Based on the data we are calling AJAX submit method
function checkAndCallAjaxSubmit() {
	var indentId = 0;
	var departmentId = 0;
	var itemId = 0;
	var errorMessage = "";

	if (document.getElementById('indentId').value == 0)
		errorMessage = errorMessage + "Please Select Indent No \n";
	if (document.getElementById('departmentId').value == 0)
		errorMessage = errorMessage + "Please Select Department  \n";
	if (document.getElementById('itemId').value == "")
		errorMessage = errorMessage + "Please Select Item  \n";

	departmentId = document.getElementById('departmentId').value;
	indentId = document.getElementById('indentId').value;
	itemId = document.getElementById('itemId').value;
	if ((indentId != 0) && (departmentId != 0) && (itemId != 0)) {
		submitProtoAjax('indentSocTracker',
				'/hms/hms/stores?method=getIndentSocTrackerDetails&departmentId='
						+ departmentId + '&indentId=' + indentId + '&itemId='
						+ itemId);
	} else {
		alert(errorMessage);
		return false
	}
	if (errorMessage != "") {
		alert(errorMessage);
		return false
	}
}
// This used to fill item value in a row based on Nomenclature
function fillItemsInPOByName(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 10

	if (rowVal == 0) {
		rowVal = 10
	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
}

function fillIndentDetails(indentId, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var qtyReqquested = "qtyReqquested";
	var incVar = "incVar";

	var idItem2 = "idItem";
	var codeItem2 = "codeItem";
	var nameItem2 = "nameItem";
	var idAu2 = "idAu";
	var qtyReqquested2 = "qtyReqquested";
	var incVar2 = "incVar";
	j = 0;

	for (i = 0; i < indentArray.length; i++) {

		if (indentArray[i][0] == indentId) {

			idItem = idItem2 + (rowVal + j);

			codeItem = codeItem2 + (rowVal + j);
			nameItem = nameItem2 + (rowVal + j);
			idAu = idAu2 + (rowVal + j);
			qtyReqquested = qtyReqquested2 + (rowVal + j);

			document.getElementById(idItem).value = indentArray[i][6]
			document.getElementById(codeItem).value = indentArray[i][1]
			document.getElementById(nameItem).value = indentArray[i][2]
			document.getElementById(idAu).value = indentArray[i][3]
			document.getElementById(qtyReqquested).value = indentArray[i][4]
			j++;

		}

		idItem = "idItem";
		codeItem = "codeItem";
		nameItem = "nameItem";
		idAu = "idAu";
		qtyReqquested = "qtyReqquested";
		incVar = "incVar";

		idItem2 = "idItem";
		codeItem2 = "codeItem";
		nameItem2 = "nameItem";
		idAu2 = "idAu";
		qtyReqquested2 = "qtyReqquested";
		incVar2 = "incVar";

		for (i = j; i < 8; i++) {
			idItem = idItem2 + (rowVal + i);
			codeItem = codeItem2 + (rowVal + i);
			nameItem = nameItem2 + (rowVal + i);
			idAu = idAu2 + (rowVal + i);
			document.getElementById(idItem).value = ""
			document.getElementById(codeItem).value = ""
			document.getElementById(nameItem).value = ""
			document.getElementById(idAu).value = ""

		}

	}

}

function setHeaderValuesInWindow() {
	document.getElementById('requestType').value = window.opener.document
			.getElementById('requestType').value;
	document.getElementById('issueType').value = window.opener.document
			.getElementById('issueType').value;
	document.getElementById('docType').value = window.opener.document
			.getElementById('docType').value;
	document.getElementById('issueNo').value = window.opener.document
			.getElementById('issueNo').value;
	document.getElementById('issueDate').value = window.opener.document
			.getElementById('issueDate').value;
	document.getElementById('departmentId').value = window.opener.document
			.getElementById('departmentId').value;
	document.getElementById('departmentIdTemp').value = window.opener.document
			.getElementById('departmentIdTemp').value;
	document.getElementById('departmentIndentId').value = window.opener.document
			.getElementById('departmentIndentId').value;
	document.getElementById('requestNo').value = window.opener.document
			.getElementById('requestNo').value;
	document.getElementById('requestDate').value = window.opener.document
			.getElementById('requestDate').value;
	document.getElementById('requestBy').value = window.opener.document
			.getElementById('requestBy').value;
	document.getElementById('approvedBy').value = window.opener.document
			.getElementById('approvedBy').value;
	document.getElementById('issuedBy').value = window.opener.document
			.getElementById('issuedBy').value;
	document.getElementById('docNo').value = window.opener.document
			.getElementById('docNo').value;

	return true;
}
function setHeaderValuesInWindowManual() {
	document.getElementById('requestType').value = window.opener.document
			.getElementById('requestType').value;
	document.getElementById('issueType').value = window.opener.document
			.getElementById('issueType').value;
	document.getElementById('docType').value = window.opener.document
			.getElementById('docType').value;
	document.getElementById('issueNo').value = window.opener.document
			.getElementById('issueNo').value;
	document.getElementById('issueDate').value = window.opener.document
			.getElementById('issueDate').value;
	document.getElementById('departmentId').value = window.opener.document
			.getElementById('departmentId').value;
	document.getElementById('departmentIdTemp').value = window.opener.document
			.getElementById('departmentIdTemp').value;
	document.getElementById('docNo').value = window.opener.document
			.getElementById('docNo').value;
	document.getElementById('requestNo').value = window.opener.document
			.getElementById('requestNo').value;
	document.getElementById('requestDate').value = window.opener.document
			.getElementById('requestDate').value;
	document.getElementById('requestBy').value = window.opener.document
			.getElementById('requestBy').value;
	document.getElementById('approvedBy').value = window.opener.document
			.getElementById('approvedBy').value;
	document.getElementById('issuedBy').value = window.opener.document
			.getElementById('issuedBy').value;
	return true;
}

function fillItemsInIssueManual(nameValue, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var issuedName = "issuedName";
	issuedName = issuedName + rowVal;
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;

	for (i = 0; i < itemsArray1.length; i++) {
		if (itemsArray1[i][2] == nameValue) {
			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]
			document.getElementById(issuedName).value = itemsArray1[i][2]

		}
	}

}
// This used to fill item value in a row based on Nomenclature
function fillItemsInDGFMSHQByName(nomenclature, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var nameItemForFocus = "nameItem";
	var idSection = "idSection";
	var stockInVar = "stockInVar";
	var n = "nameItem";
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal
	idSection = idSection + rowVal;
	stockInVar = stockInVar + rowVal;

	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
}

function fillItems(idVal, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idSection = "idSection";
	var nameSection = "nameSection";
	var idAu = "idAu";

	idItem = idItem + rowVal;

	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;

	idSection = idSection + rowVal;
	nameSection = nameSection + rowVal;
	idAu = idAu + rowVal;

	document.getElementById('noOfRows').value = rowVal
	for (i = 0; i < itemsArray1.length; i++) {
		if (itemsArray1[i][0] == idVal) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(nameItem).value = itemsArray1[i][2]
			document.getElementById(idAu).value = itemsArray1[i][3]
			document.getElementById(nameSection).value = itemsArray1[i][4]
			document.getElementById(idSection).value = itemsArray1[i][5]
		}
	}

}
function fillItems2(idVal, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idSection = "idSection";
	var nameSection = "nameSection";
	var idAu = "idAu";

	idItem = idItem + rowVal;

	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;

	idSection = idSection + rowVal;
	nameSection = nameSection + rowVal;
	idAu = idAu + rowVal;
	if (document.getElementById('noOfRows').value < rowVal)
		document.getElementById('noOfRows').value = rowVal
	for (i = 0; i < itemsArray1.length; i++) {
		if (itemsArray1[i][0] == idVal) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(nameItem).value = itemsArray1[i][2]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
	openPopup(idVal, 333);
}

function fillValuesForMmf(inc) {
	if (document.getElementById('mmfVarTemp' + inc).value != "")
		document.getElementById('mmfVar' + inc).value = document
				.getElementById('mmfVarTemp' + inc).value
}
function fillValuesForDemand(inc) {
	if (document.getElementById('demandVar' + inc).value != "")
		document.getElementById('demandVarTemp' + inc).value = document
				.getElementById('demandVar' + inc).value
}
function checkForNext() {
	var formName = "";

	if (document.getElementById("modifyBalance") != null) {
		formName = document.getElementById("modifyBalance").value;

	}
	if (document.getElementById('noOfRows').value < 8 && formName == "") {
		alert("All rows are not filled.To continue press Submit ")
		return false;
	} else {
		return true;
	}
}

function checkForSubmit() {

	return true;

}
function openPopupForBrand(issuedItem, qtyRequested, rowVal, issueId, detailId) {

	if ((parseFloat(document.getElementById("qtyIssued" + rowVal).value) > 0 && document
			.getElementById("qtyIssued" + rowVal).value != "")
			&& document.getElementById("barCodeNo" + rowVal).value == "") {
		alert("Already Issued..!")
		return false
	}

	var nomenclature = document.getElementById("nameItem" + rowVal).value
	var pvms = document.getElementById("codeItem" + rowVal).value
	if (document.getElementById("barCodeNo" + rowVal).value == "") {
		if (nomenclature != "" && pvms != "") {

			var issuedItemId = document.getElementById("issuedItemId" + rowVal).value
			var itemId = document.getElementById("idItem" + rowVal).value
			var qtyRequested = document.getElementById("qtyRequested" + rowVal).value

			// var loanOutQty=document.getElementById("loanOutQty"+rowVal).value

			// alert(loanOutQty)
			var issueNo = document.getElementById("issueNo").value
			var url = "/hms/hms/stores?method=openItemBrandWindowJsp&itemId="
					+ itemId + "&qtyRequest=" + qtyRequested + "&rowVal="
					+ rowVal + "&issuedItemId=" + itemId + "&issueId="
					+ issueId + "&detailId=" + detailId + "&issueNo=" + issueNo
					+ "&nomenclature=" + nomenclature + "&pvms=" + pvms
					+ "&flag=withIndent";
			popwindow(url);
		} else {
			alert("Please Enter Item Code Or Item Name to view Stock details")
		}
	} else {
		var issuedItemId = document.getElementById("issuedItemId" + rowVal).value
		var itemId = document.getElementById("idItem" + rowVal).value
		var qtyRequested = document.getElementById("qtyRequested" + rowVal).value
		if (issuedItemId == 0) {
			issuedItemId = itemId;
		}

		if (qtyRequested == "") {
			qtyRequested = 0;

		}
		//var barcodeNo = document.getElementById("barCodeNo" + rowVal).value
		//var batchNo = document.getElementById("batchNo" + rowVal).value
		// var loanOutQty=document.getElementById("loanOutQty"+rowVal).value
		//var issueIdForBarcode = document.getElementById("issueIdForBarcode").value
		// alert(issueIdForBarcode)
		var issueNo = document.getElementById("issueNo").value
		var srNo = document.getElementById("srNo" + rowVal).value
		var qtyIssued = document.getElementById("qtyIssued" + rowVal).value
		var expiryDate = document.getElementById("expiryDate" + rowVal).value
		var requestNo = "";
		if (document.getElementById("requestNo1") != null) {
			requestNo = document.getElementById("requestNo1").value
		}
		var docNo = document.getElementById("reference").value
		if (qtyIssued != "") {
			submitProtoAjaxForAddBarcodeData("issueDispensaryForm",
					"stores?method=addBrandDetailsForBarcode&requestNo="
							+ requestNo + "&docNo=" + docNo + "&expiryDate="
							+ expiryDate + "&qtyIssued=" + qtyIssued + "&srNo="
							+ srNo + "&itemId=" + itemId + "&issuedItemId="
							+ issuedItemId + "&qtyRequested=" + qtyRequested
							+ "&barcodeNo=" + barcodeNo + "&batchNo=" + batchNo
							+ "&issueIdForBarcode=" + issueIdForBarcode + "",
					rowVal);
		} else {
			alert("Pls Fill issue Qty..");
		}

	}
}

function openPopupForBrand(issuedItem, qtyRequested, rowVal, issueId, detailId,
		indentId, reqDate) {

	// if((parseFloat(document.getElementById("qtyRequested"+rowVal).value) ==
	// parseFloat(document.getElementById("qtyIssued"+rowVal).value)) &&
	// document.getElementById("qtyIssued"+rowVal).value != "" &&
	// document.getElementById("barCodeNo"+rowVal).value==""){
	// alert("Already Issued..!")
	// return false
	// }

	var nomenclature = document.getElementById("nameItem" + rowVal).value
	var pvms = document.getElementById("codeItem" + rowVal).value
	if (document.getElementById("barCodeNo" + rowVal).value == "") {
		if (nomenclature != "" && pvms != "") {
			var issuedItemId = document.getElementById("issuedItemId" + rowVal).value
			var itemId = document.getElementById("idItem" + rowVal).value
			var qtyRequested = document.getElementById("qtyRequested" + rowVal).value
			var qtyIssued = document.getElementById("qtyIssued" + rowVal).value;
			var srNo = document.getElementById("srNo" + rowVal).value;
			var issueNo = document.getElementById("issueNo").value;
			var issueId = document.getElementById("issueId").value;
			var indentDtId = document.getElementById("detailId" + rowVal).value;
			var url = "/hms/hms/stores?method=openItemBrandWindowJsp&itemId="
					+ itemId + "&qtyRequest=" + qtyRequested + "&rowVal="
					+ rowVal + "&issuedItemId=" + itemId + "&issueId="
					+ issueId + "&detailId=" + detailId + "&issueNo=" + issueNo
					+ "&nomenclature=" + nomenclature + "&pvms=" + pvms
					+ "&flag=withIndent&qtyIssued=" + qtyIssued + "&srNo="
					+ srNo + "&indentId=" + indentId + "&reqDate=" + reqDate
					+ "&indentDtId=" + indentDtId;
			popwindow(url);
		} else {
			alert("Please Enter Item Code Or Item Name to view Stock details")
		}
	} else {
		var issuedItemId = document.getElementById("issuedItemId" + rowVal).value
		var itemId = document.getElementById("idItem" + rowVal).value
		var qtyRequested = document.getElementById("qtyRequested" + rowVal).value
		if (issuedItemId == 0) {
			issuedItemId = itemId;
		}

		if (qtyRequested == "") {
			qtyRequested = 0;

		}
		var barcodeNo = document.getElementById("barCodeNo" + rowVal).value
		var batchNo = document.getElementById("batchNo" + rowVal).value
		// var loanOutQty=document.getElementById("loanOutQty"+rowVal).value
		var issueIdForBarcode = document.getElementById("issueIdForBarcode").value
		// alert(issueIdForBarcode)
		var issueNo = document.getElementById("issueNo").value
		var srNo = document.getElementById("srNo" + rowVal).value
		var qtyIssued = document.getElementById("qtyIssued" + rowVal).value
		var expiryDate = document.getElementById("expiryDate" + rowVal).value
		var requestNo = "";
		if (document.getElementById("requestNo1") != null) {
			requestNo = document.getElementById("requestNo1").value
		}
		var docNo = document.getElementById("reference").value
		if (qtyIssued != "") {
			submitProtoAjaxForAddBarcodeData("issueDispensaryForm",
					"stores?method=addBrandDetailsForBarcode&requestNo="
							+ requestNo + "&docNo=" + docNo + "&expiryDate="
							+ expiryDate + "&qtyIssued=" + qtyIssued + "&srNo="
							+ srNo + "&itemId=" + itemId + "&issuedItemId="
							+ issuedItemId + "&qtyRequested=" + qtyRequested
							+ "&barcodeNo=" + barcodeNo + "&batchNo=" + batchNo
							+ "&issueIdForBarcode=" + issueIdForBarcode + "",
					rowVal);
		} else {
			alert("Pls Fill issue Qty..");
		}

	}
}

function openPopupForBrandForLoanOut(rowVal) {
	var issueNo = document.getElementById('issueNo').value
	var isssueDate = document.getElementById('isssueDate').value
	var departmentIdTemp = document.getElementById('departmentIdTemp').value
	var patientName = document.getElementById('patientName').value
	var requestBy = document.getElementById('requestBy').value
	var approvedBy = document.getElementById('approvedBy').value
	var issuedBy = document.getElementById('issuedBy').value
	var docNo = document.getElementById('docNo').value
	var issueId = document.getElementById('issueId').value
	var errorMessage = "";

	if (document.getElementById('issueNo').value == "")
		errorMessage = errorMessage + "Please Fill Issue No \n";

	if (document.getElementById('isssueDate').value == "")
		errorMessage = errorMessage + "Please fill  Isssue Date \n";

	if (document.getElementById('departmentIdTemp').value == "")
		errorMessage = errorMessage + "Please Select Department \n";

	if (document.getElementById('requestBy').value == "")
		errorMessage = errorMessage + "Please Select requestBy \n";

	if (document.getElementById('approvedBy').value == "")
		errorMessage = errorMessage + "Please Select approvedBy \n";

	if (document.getElementById('issuedBy').value == "")
		errorMessage = errorMessage + "Please Select issuedBy \n";

	if (document.getElementById('docNo').value == "")
		errorMessage = errorMessage + "Please Fill reference no \n";

	if (errorMessage != "") {
		alert(errorMessage)
		return false
	} else {
		if (document.getElementById("qtyIssued" + rowVal).value > 0) {
			alert("Already Issued..!")
			return false
		}
		var itemId = document.getElementById("idItem" + rowVal).value
		if (itemId == 0) {
			alert("Select Item First..!")
			return false;
		}

		var url = "/hms/hms/stores?method=openItemBrandWindowJspForLoanOut&itemId="
				+ itemId
				+ "&rowVal="
				+ rowVal
				+ "&issueNo="
				+ issueNo
				+ "&isssueDate="
				+ isssueDate
				+ "&departmentIdTemp="
				+ departmentIdTemp
				+ "&patientName="
				+ patientName
				+ "&requestBy="
				+ requestBy
				+ "&approvedBy="
				+ approvedBy
				+ "&issuedBy="
				+ issuedBy
				+ "&docNo="
				+ docNo
				+ "&issueId="
				+ issueId;

		popwindow(url);
	}

}

function openPopupForBrandForOtherUnits(rowVal) {
	var issueNo = document.getElementById('issueNo').value
	var isssueDate = document.getElementById('isssueDate').value
	var departmentIdTemp = document.getElementById('departmentIdTemp').value
	var requestBy = document.getElementById('requestBy').value
	var approvedBy = document.getElementById('approvedBy').value
	var issuedBy = document.getElementById('issuedBy').value
	var docNo = document.getElementById('docNo').value
	var issueId = document.getElementById('issueId').value
	var errorMessage = "";

	if (document.getElementById('issueNo').value == "")
		errorMessage = errorMessage + "Please Fill Issue No \n";

	if (document.getElementById('isssueDate').value == "")
		errorMessage = errorMessage + "Please fill  Isssue Date \n";

	if (document.getElementById('departmentIdTemp').value == "")
		errorMessage = errorMessage + "Please Select Department \n";

	if (document.getElementById('requestBy').value == "")
		errorMessage = errorMessage + "Please Select requestBy \n";

	if (document.getElementById('approvedBy').value == "")
		errorMessage = errorMessage + "Please Select approvedBy \n";

	if (document.getElementById('issuedBy').value == "")
		errorMessage = errorMessage + "Please Select issuedBy \n";

	if (document.getElementById('docNo').value == "")
		errorMessage = errorMessage + "Please Fill reference no \n";

	if (errorMessage != "") {
		alert(errorMessage)
		return false
	} else {
		if (document.getElementById("qtyIssued" + rowVal).value > 0) {
			alert("Already Issued..!")
			return false
		}
		var itemId = document.getElementById("idItem" + rowVal).value
		if (itemId == 0) {
			alert("Select Item First..!")
			return false;
		}

		var url = "/hms/hms/stores?method=openItemBrandWindowJspToOtherUnits&itemId="
				+ itemId
				+ "&rowVal="
				+ rowVal
				+ "&issueNo="
				+ issueNo
				+ "&isssueDate="
				+ isssueDate
				+ "&departmentIdTemp="
				+ departmentIdTemp
				+ "&requestBy="
				+ requestBy
				+ "&approvedBy="
				+ approvedBy
				+ "&issuedBy="
				+ issuedBy
				+ "&docNo="
				+ docNo
				+ "&issueId=" + issueId;

		popwindow(url);
	}

}

function get_valueInModify(rowVal) {
	document.getElementById('currentRow').value = rowVal
	var itemId = document.getElementById("idItem" + rowVal).value
	var detailId = document.getElementById("detailId" + rowVal).value
	var manuId = document.getElementById("manuId" + rowVal).value
	var brandId = document.getElementById("brandId" + rowVal).value
	if (itemId == 0) {
		alert("Plz Select Nomenclature")
		return false
	}
	var url = "/hms/hms/stores?method=getBrandListForSOCModify&itemId="
			+ itemId + "&detailId=" + detailId + "&manuId=" + manuId
			+ "&brandId=" + brandId;
	popwindow(url);

}
function get_value(rowVal) {

	var itemId = document.getElementById("idItem" + rowVal).value
	if (itemId == 0) {
		alert("Plz Selsct Nomenclature")
		return false
	}
	var url = "/hms/hms/stores?method=getBrandListForSOC&itemId=" + itemId;
	popwindow(url);
}

var newwindow;
function popwindow(url) {
	newwindow = window.open(url, 'name', "height=550,width=950,status=1");

}

// =====================For Issue To OTAFU==================
function openPopupForBrandForOTAFU(rowVal) {
	var issueNo = document.getElementById('issueNo').value
	var isssueDate = document.getElementById('isssueDate').value
	var departmentIdTemp = document.getElementById('departmentIdTemp').value
	var requestBy = document.getElementById('requestBy').value
	var approvedBy = document.getElementById('approvedBy').value
	var issuedBy = document.getElementById('issuedBy').value
	var docNo = document.getElementById('docNo').value
	var issueId = document.getElementById('issueId').value
	var errorMessage = "";

	if (document.getElementById('issueNo').value == "")
		errorMessage = errorMessage + "Please Fill Issue No \n";

	if (document.getElementById('isssueDate').value == "")
		errorMessage = errorMessage + "Please fill  Isssue Date \n";

	if (document.getElementById('departmentIdTemp').value == "")
		errorMessage = errorMessage + "Please Select Unit \n";

	if (document.getElementById('requestBy').value == "")
		errorMessage = errorMessage + "Please Select requestBy \n";

	if (document.getElementById('approvedBy').value == "")
		errorMessage = errorMessage + "Please Select approvedBy \n";

	if (document.getElementById('issuedBy').value == "")
		errorMessage = errorMessage + "Please Select issuedBy \n";

	if (document.getElementById('docNo').value == "")
		errorMessage = errorMessage + "Please Fill reference no \n";

	if (errorMessage != "") {
		alert(errorMessage)
		return false
	} else {
		if (document.getElementById("qtyIssued" + rowVal).value > 0) {
			alert("Already Issued..!")
			return false
		}
		var itemId = document.getElementById("idItem" + rowVal).value
		if (itemId == 0) {
			alert("Select Item First..!")
			return false;
		}

		var url = "/hms/hms/stores?method=openItemBrandWindowJspIssueToOTAFU&itemId="
				+ itemId
				+ "&rowVal="
				+ rowVal
				+ "&issueNo="
				+ issueNo
				+ "&isssueDate="
				+ isssueDate
				+ "&departmentIdTemp="
				+ departmentIdTemp
				+ "&requestBy="
				+ requestBy
				+ "&approvedBy="
				+ approvedBy
				+ "&issuedBy="
				+ issuedBy
				+ "&docNo="
				+ docNo
				+ "&issueId=" + issueId;

		popwindow(url);
	}

}

function openDeletePopupForIssueOTAFU() {

	var url = "/hms/hms/stores?method=openDeletePopupForIssueToOTAFU";
	newwindow = window.open(url, 'name', "height=900,width=900,status=1");

}
function calculateTotalForSoc(rowVal) {
	if (document.getElementById('qtyTemp' + rowVal).value != '') {
		var quantity = parseInt(document.getElementById("qtyTemp" + rowVal).value)
		document.getElementById("lastRecpQty" + rowVal).value = parseInt(document
				.getElementById("qtyTemp" + rowVal).value)
	} else {
		var quantity = 0
		document.getElementById("lastRecpQty" + rowVal).value = 0
	}
	if (document.getElementById("unitRate" + rowVal).value != '')
		var unitRate = parseInt(document.getElementById("unitRate" + rowVal).value)
	else
		var unitRate = 0
	document.getElementById("totalCost" + rowVal).value = unitRate * quantity
	document.getElementById("totalCostTemp" + rowVal).value = unitRate
			* quantity

}

// -----------------------------------------------------------------------------------------------------------------
// -------------------------------------End of Functions Written By
// Vivek-------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

// -----------------------------------------------------------------------------------------------------------------
// -------------------------------------Start of Functions Written By DEEPTI
// TEVATIA-------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

// This used to fill item value in a row based on Nomenclature
function fillItemsInPOByName(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 10

	if (rowVal == 0) {
		rowVal = 10
	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
}

function calculateAmount(rowVal) {
	var pageNo = parseInt(document.getElementById('pageNo').value)
	var start = ((pageNo - 1) * 10) + 1;
	var end = ((pageNo - 1) * 10) + 10;
	var quantity = parseFloat(document.getElementById('quantityInVarTemp'
			+ rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'
			+ rowVal).value)
	var ratePerMdq = parseFloat(document.getElementById('ratePerMdq' + rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'
			+ rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp' + rowVal).value)

	var pageTotal = parseFloat(document.getElementById('pageTotal').value)
	var overallTotal = parseFloat(document.getElementById('overallTotal').value)

	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity * ratePerMdq;

	if (!isNaN(quantity) && !isNaN(unitRate) && !isNaN(discount) && !isNaN(tax)) {
		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		amountAfterTax = (amountAfterdiscount) * (tax / 100)
		netAmount = amountAfterdiscount + amountAfterTax;
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(netAmount * 100) / 100
	} else if (!isNaN(quantity) == "" && !isNaN(unitRate) == "") {
		// alert("Please Enter Both Quantity and Unit Rate.");
	} else if (!isNaN(quantity) != "" && !isNaN(unitRate) == "") {
		// alert("Please Enter Unit Rate.");
	} else if (!isNaN(quantity) == "" && !isNaN(unitRate) != "") {
		// alert("Please Enter Quantity.");
	} else if (!isNaN(discount) == "" && !isNaN(tax) == "") {
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(total * 100) / 100
	} else if (!isNaN(discount) == "" || !isNaN(tax) != "") {
		netAmount = total + (total * (tax / 100));
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(netAmount * 100) / 100
	} else if (!isNaN(discount) != "" || !isNaN(tax) == "") {
		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(netAmount * 100) / 100
	}

	var totalAmount = parseFloat(0);
	for (var r = 1; r <= 10; r++) {
		if (document.getElementById('amountVarTemp' + r).value == "") {

		} else {
			var freeItem = document.getElementById('freeItem' + r).value;
			if (freeItem == 'n')
				totalAmount = totalAmount
						+ parseFloat(document.getElementById('amountVarTemp'
								+ r).value)
		}
	}

	if (document.getElementById('totalAmountTemp').value != "") {
		// document.getElementById('total_amount').value =
		// parseFloat(document.getElementById('totalAmountTemp').value)+totalAmount
		document.getElementById('total_amount').value = (overallTotal - pageTotal)
				+ totalAmount
	} else {
		document.getElementById('total_amount').value = totalAmount
	}

	document.getElementById('amountVar' + rowVal).value = document
			.getElementById('amountVarTemp' + rowVal).value;
}

function calculateAmountForAdd(rowVal) {
	var pageNo = parseInt(document.getElementById('pageNo').value)
	var start = ((pageNo - 1) * 10) + 1;
	var end = ((pageNo - 1) * 10) + 10;
	var quantity = parseFloat(document.getElementById('quantityInVarTemp'
			+ rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'
			+ rowVal).value)
	var ratePerMdq = parseFloat(document.getElementById('ratePerMdq' + rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'
			+ rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp' + rowVal).value)
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity * ratePerMdq;

	if (!isNaN(quantity) && !isNaN(ratePerMdq) && !isNaN(discount)
			&& !isNaN(tax)) {
		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		amountAfterTax = (amountAfterdiscount) * (tax / 100)
		netAmount = amountAfterdiscount + amountAfterTax;
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(netAmount * 100) / 100;
	} else if (!isNaN(quantity) == "" && !isNaN(ratePerMdq) == "") {
		// alert("Please Enter Both Quantity and Unit Rate.");
	} else if (!isNaN(quantity) != "" && !isNaN(ratePerMdq) == "") {
		// alert("Please Enter Unit Rate.");
	} else if (!isNaN(quantity) == "" && !isNaN(ratePerMdq) != "") {
		// alert("Please Enter Quantity.");
	} else if (!isNaN(discount) == "" && !isNaN(tax) == "") {
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(total * 100) / 100;
	} else if (!isNaN(discount) == "" || !isNaN(tax) != "") {
		netAmount = total + (total * (tax / 100));
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(netAmount * 100) / 100;
	} else if (!isNaN(discount) != "" || !isNaN(tax) == "") {
		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amountVarTemp' + rowVal).value = Math
				.round(netAmount * 100) / 100;
	}

	var totalAmount = parseFloat(0);
	for (var r = 1; r <= 10; r++) {
		if (document.getElementById('amountVarTemp' + r).value == "") {

		} else {
			var freeItem = document.getElementById('freeItem' + r).value;
			if (freeItem == 'n')
				totalAmount = totalAmount
						+ parseFloat(document.getElementById('amountVarTemp'
								+ r).value)
		}
	}

	if (document.getElementById('totalAmountTemp').value != "") {
		document.getElementById('total_amount').value = parseFloat(document
				.getElementById('totalAmountTemp').value)
				+ totalAmount
	} else {
		document.getElementById('total_amount').value = totalAmount
	}
	document.getElementById('amountVar' + rowVal).value = document
			.getElementById('amountVarTemp' + rowVal).value;
}

function setHeaderValuesForReturnDispensary(rowVal) {
	document.getElementById('itemId').value = window.opener.document
			.getElementById('itemId' + rowVal).value;
	document.getElementById('date').value = window.opener.document
			.getElementById('date').value;
	document.getElementById('time').value = window.opener.document
			.getElementById('time').value;
	document.getElementById('returnNo').value = window.opener.document
			.getElementById('returnNo').value;
	document.getElementById('returnDate').value = window.opener.document
			.getElementById('returnDate').value;
	document.getElementById('referenceNo').value = window.opener.document
			.getElementById('referenceNo').value;
	document.getElementById('fromWard').value = window.opener.document
			.getElementById('fromWard').value;
	document.getElementById('toWard').value = window.opener.document
			.getElementById('toWard').value;

	document.getElementById('receiveBy').value = window.opener.document
			.getElementById('receiveBy').value;
	document.getElementById('returnBy').value = window.opener.document
			.getElementById('returnBy').value;

	document.getElementById('reason').value = window.opener.document
			.getElementById('reason').value;
	document.getElementById('remarks').value = window.opener.document
			.getElementById('remarks').value;

	document.getElementById('storeFyDocumentNoId').value = window.opener.document
			.getElementById('storeFyDocumentNoId').value;
	// document.getElementById('deptId').value=window.opener.document.getElementById('deptId').value
	// ;

	return true;
}

function setHeaderValuesForVendorReturn(rowVal) {
	document.getElementById('returnDate').value = window.opener.document
			.getElementById('returnDate').value;
	document.getElementById('referenceNo').value = window.opener.document
			.getElementById('referenceNo').value;
	document.getElementById('vendorId').value = window.opener.document
			.getElementById('vendorId').value;
	document.getElementById('SONo').value = window.opener.document
			.getElementById('SONo').value;
	document.getElementById('returnBy').value = window.opener.document
			.getElementById('returnBy').value;
	document.getElementById('approvedBy').value = window.opener.document
			.getElementById('approvedBy').value;
	document.getElementById('reason').value = window.opener.document
			.getElementById('reason').value;
	document.getElementById('remarks').value = window.opener.document
			.getElementById('remarks').value;
	document.getElementById('storeGrnReturnMId').value = window.opener.document
			.getElementById('storeGrnReturnMId').value;
	document.getElementById('returnNo').value = window.opener.document
			.getElementById('returnNo').value;
	document.getElementById('itemId').value = window.opener.document
			.getElementById('itemId' + rowVal).value;
	return true;
}

function fillValuesLocal(inc) {
	var quantityInVar = "quantityInVar";
	var taxVar = "taxVar";
	var unitRateVar = "unitRateVar";
	var amountVar = "amountVar";
	var discountVar = "discountVar";

	var quantityInVarTemp = "quantityInVarTemp";
	var taxVarTemp = "taxVarTemp";
	var unitRateVarTemp = "unitRateVarTemp";
	var amountVarTemp = "amountVarTemp";
	var discountVarTemp = "discountVarTemp";

	document.getElementById(quantityInVar + inc).value = document
			.getElementById(quantityInVarTemp + inc).value

	if (document.getElementById(taxVarTemp + inc).value != "") {
		document.getElementById(taxVar + inc).value = document
				.getElementById(taxVarTemp + inc).value
	} else {
		document.getElementById(taxVar + inc).value = 0;
	}

	document.getElementById(unitRateVar + inc).value = document
			.getElementById(unitRateVarTemp + inc).value
	if (document.getElementById(amountVarTemp + inc).value != "") {
		document.getElementById(amountVar + inc).value = document
				.getElementById(amountVarTemp + inc).value
	} else {
		document.getElementById(amountVar + inc).value = 0;
	}
	if (document.getElementById(discountVarTemp + inc).value != "") {
		document.getElementById(discountVar + inc).value = document
				.getElementById(discountVarTemp + inc).value
	} else {
		document.getElementById(discountVar + inc).value = 0;
	}
}

// -----------------------------------------------------------------------------------------------------------------
// -------------------------------------END of Functions Written By DEEPTI
// TEVATIA-------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

// -----------------------------------------------------------------------------------------------------------------
// -------------------------------------Start of Functions Written By
// Mansi-------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

function fillItemsInDepartmentIndent(nomenclature, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var nameItemForFocus = "nameItem";
	var stockInVar = "stockInVar";
	var n = "nameItem";
	var departmentId = "departmentId";
	var qtyInHandTemp = "qtyInHandTemp";
	var mmfVarTemp = "mmfVarTemp";
	var qtyInHand = "qtyInHand";
	qtyInHand = qtyInHand + rowVal
	mmfVarTemp = mmfVarTemp + rowVal
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal
	qtyInHandTemp = qtyInHandTemp + rowVal
	departmentId = departmentId + rowVal
	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][6]
			if (itemsArray1[i][3] != "null") {
				document.getElementById(qtyInHand).value = itemsArray1[i][3]
				document.getElementById(qtyInHandTemp).value = itemsArray1[i][3]
			} else {
				document.getElementById(qtyInHand).value = "0"
				document.getElementById(qtyInHandTemp).value = "0"
			}
			if (itemsArray1[i][4] != "null") {
				document.getElementById(mmfVarTemp).value = itemsArray1[i][4]
			} else {
				document.getElementById(mmfVarTemp).value = 0
			}

		}
	}
}

function fillItemsInOpeningBalance(nomenclature, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var nameItemForFocus = "nameItem";

	var n = "nameItem";

	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal

	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
}

function fillItemsInMmfDepartment(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var nameItemForFocus = "nameItem";
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal
	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
}
function fillValuesRemarks(inc) {

	var remarksVar = "remarksVar";
	var remarksVarTemp = "remarksVarTemp";

	if (document.getElementById(remarksVarTemp + inc).value != "") {
		document.getElementById(remarksVar + inc).value = document
				.getElementById(remarksVarTemp + inc).value
	} else
		document.getElementById(remarksVar + inc).value = "emptyString";

}

function fillItemsInStoreBalance(nomenclature, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var idBrand = "idBrand";
	var nameBrand = "nameBrand";
	var rowValTemp = rowVal
	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;
	idBrand = idBrand + rowVal;
	nameBrand = nameBrand + rowVal;
	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			var itemId = itemsArray1[i][0]
			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]
			document.getElementById(idBrand).value = itemsArray1[i][5]

		}
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	populateBrand(itemId, rowValTemp)

}

function showLastDemandNo(formName) {
	obj = eval('document.' + formName)
	obj.action = "/hms/hms/stores?method=lastDemandNo";
	obj.submit();
}

function showLastDocNo(formName) {
	obj = eval('document.' + formName)
	obj.action = "/hms/hms/stores?method=lastDocNo";
	obj.submit();
}

function fillItemsInMMF(nomenclature, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";

	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal

	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 8

	if (rowVal == 0) {
		rowVal = 8

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]

		}
	}
}

function fillValuesHand(inc) {
	var qtyInHand = "qtyInHand";
	var qtyInHandTemp = "qtyInHandTemp";
	document.getElementById(qtyInHand + inc).value = document
			.getElementById(qtyInHandTemp + inc).value
}

function fillValues(inc) {
	var mmfVar = "mmfVar";
	var mmfVarTemp = "mmfVarTemp";
	document.getElementById(mmfVar + inc).value = document
			.getElementById(mmfVarTemp + inc).value
}
function fillValuesForDemand(inc) {
	if (document.getElementById('demandVar' + inc).value != "")
		document.getElementById('demandVarTemp' + inc).value = document
				.getElementById('demandVar' + inc).value
}

// -----------------------------------------------------------------------------------------------------------------
// -------------------------------------End of Functions Written By
// Mansi-------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

// ===================================================================
// ======================NEW FUNCTIONS BY ABHA ======================
// ===================================================================
// This used to fill item value in a row based on Code
function fillItemsInGrn(nomenclature, rowVal) {
	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var idBrand = "idBrand";
	var nameBrand = "nameBrand";
	var expiry = "expiry";

	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;
	idBrand = idBrand + rowVal;
	nameBrand = nameBrand + rowVal;
	expiry = expiry + rowVal;

	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 10

	if (rowVal == 0) {
		rowVal = 10

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}

	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			var itemId = itemsArray1[i][0]
			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]
			// document.getElementById(idBrand).value=itemsArray1[i][5]
			document.getElementById(expiry).value = itemsArray1[i][6]

		}
	}

	populateBrand(itemId, rowVal)

}

function populateBrand(itemId, rowVal) {

	var idBrand = "idBrand" + rowVal;
	obj = document.getElementById(idBrand);
	obj.length = 1;
	for (i = 0; i < brandArray.length; i++) {

		if (brandArray[i][0] == itemId) {

			obj.length++;
			obj.options[obj.length - 1].value = brandArray[i][1];
			obj.options[obj.length - 1].text = brandArray[i][2];
		}
	}
}

function populateManufacturer(brandId, rowVal) {
	var idManufacturer = "idManufacturer" + rowVal;

	obj = document.getElementById(idManufacturer);
	obj.length = 1;
	for (i = 0; i < manufacturerArray.length; i++) {

		if (manufacturerArray[i][0] == itemId) {

			obj.length++;
			obj.options[obj.length - 1].value = manufacturerArray[i][1];
			obj.options[obj.length - 1].text = manufacturerArray[i][2];
		}
	}
}

function rate(rateandQuan, rowVal) {
	var rate = 0;
	var closingStock = 0;
	var freeQty = document.getElementById('freeQty' + rowVal).value.trim()
	var quantity = parseInt(document.getElementById('quanRecTemp' + rowVal).value)

	if (freeQty != '') {
		rate = (rateandQuan) / (quantity + parseInt(freeQty))
		closingStock = (freeQty + quantity)
		document.getElementById('closingStock').value = closingStock
	}
}

// on change of source of supply list changes

function onChangeSourceOfSupply(sos) {
	document.getElementById("indentCombo").options.length = 0;

	if (sos == "x") {
		document.getElementById("indentCombo").disabled = true;
		// document.getElementById("supplierCombo").disabled = true;
		submitProtoAjaxforGrid('grnGrid',
				'/hms/hms/stores?method=responseGridList');
		return;
	}

	/*
	 * if (sos == "w"||sos == "x") {
	 * document.getElementById("indentCombo").disabled = true; if
	 * (document.getElementById("test").disabled == false)
	 * document.getElementById("test").disabled = true;
	 * submitProtoAjaxforSupplier('grnGrid','/hms/hms/stores?method=responseForList');
	 * submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');
	 * return; }
	 */

	if (sos == "o" || sos == "l") {
		document.getElementById("indentCombo").disabled = true;
		if (document.getElementById("test").disabled == false)
			document.getElementById("test").disabled = true;
		submitProtoAjaxforSupplier('grnGrid',
				'/hms/hms/stores?method=responseForList');
	} else {
		document.getElementById("indentCombo").disabled = false;

		if (document.getElementById("test").disabled == true)
			document.getElementById("test").disabled = false;
	}

	if (sos == "o") {
		submitProtoAjaxforGrid('grnGrid',
				'/hms/hms/stores?method=responseGridList');
	}

	if (sos == "o" || sos == "a" || sos == "p") {
		document.getElementById("invoiceNo").disabled = true;
		document.getElementById("invoiceAmount").disabled = true;
		document.getElementById("invoiceDate").disabled = true;
	} else {
		document.getElementById("invoiceNo").disabled = false;
		document.getElementById("invoiceAmount").disabled = false;
		document.getElementById("invoiceDate").disabled = false;
	}
	if (sos == "i") {
		document.getElementById("indentCombo").disabled = true;
		// submitProtoAjaxforSupplier('grnGrid','/hms/hms/stores?method=responseForList');
		submitProtoAjaxforGrid('grnGrid',
				'/hms/hms/stores?method=responseGridList');
	}
}

function onChangeOfSupply(sos) {
	// document.getElementById("indentCombo").options.length=0;

	if (sos == "KMSCL Issue Note") {
		//submitProtoAjaxforGRN('createGrn','/hms/hms/stores?method=responseForKMSCLIssueNote');

	}
	if (sos == "Purchase From KMSCL") {
		//submitProtoAjaxforGRN('createGrn','/hms/hms/stores?method=responseForPurchaseFormKMSCL');
	}
	if (sos == "Indent From Institute") {
		submitProtoAjaxforGRN('createGrn','/hms/hms/stores?method=responseForIndentWithinInstitue');
		/*
		 * if(document.getElementById("indentCombo").options.length=0){
		 * submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responseForIndentGrid'); }
		 */
	}
	if (sos == "Local Purchase") {
		submitProtoAjaxforGRN('createGrn',
				'/hms/hms/stores?method=responseForLocalPurchase');
	}
	if (sos == "Other") {
		//submitProtoAjaxforGRN('grnGrid','/hms/hms/stores?method=responseForOthers');
	}
}

function disableSourceOfSupply() {
	document.getElementById("sourceCombo").disabled = true;
	document.getElementById("supplierCombo").disabled = true;
}

// check for loan in

function checkloanin() {
	var sos = document.getElementById('sourceCombo').value

	var invoiceAmount = document.getElementById('invoiceAmount').value.trim()
	var grnValue = document.getElementById('grnValue').value.trim()

	if (sos == "l" | sos == "x") {
		if (invoiceAmount != grnValue) {
			if (confirm("Invoice Amount and GRN Valued Is not Equal.Enter Correct Invoice Amount."))
				return false;
			// return true;
		} else {
			return true;
		}

	}
	return true;
}

// This used to fill item value in a row based on Code
function fillItemsInDefectiveDrugs(nomenclature, rowVal) {

	var idItem = "idItem";
	var codeItem = "codeItem";
	var nameItem = "nameItem";
	var idAu = "idAu";
	var idBrand = "idBrand";
	var nameBrand = "nameBrand";
	var expiry = "expiry";
	// var expiryDate ="expiryDate";
	var batchNo = "batchNo";

	idItem = idItem + rowVal;
	codeItem = codeItem + rowVal;
	nameItem = nameItem + rowVal;
	idAu = idAu + rowVal;
	idBrand = idBrand + rowVal;
	nameBrand = nameBrand + rowVal;
	expiry = expiry + rowVal;
	// expiryDate = expiryDate+rowVal;
	batchNo = batchNo + rowVal;

	if (nomenclature == "") {
		alert("Nomenclature Can not be empty")
		document.getElementById(nameItem).focus();
		return false;
	}

	var pageNo = parseInt(document.getElementById('noOfRows').value);
	rowVal = rowVal % 10

	if (rowVal == 0) {
		rowVal = 10

	}
	if (!(parseInt(document.getElementById('noOfRows').value) > parseInt(rowVal))) {
		document.getElementById('noOfRows').value = rowVal
	}
	var itemId = 0;
	for (i = 0; i < itemsArray1.length; i++) {

		if (itemsArray1[i][2] == nomenclature) {

			itemId = itemsArray1[i][0]
			document.getElementById(idItem).value = itemsArray1[i][0]
			document.getElementById(codeItem).value = itemsArray1[i][1]
			document.getElementById(idAu).value = itemsArray1[i][3]
			document.getElementById(idBrand).value = itemsArray1[i][5]
			document.getElementById(expiry).value = itemsArray1[i][6]

			// document.getElementById(expiryDate).value= itemsArray1[i][7]
			// document.getElementById(batchNo).value= itemsArray1[i][7]

		}
	}

	populateBrand(itemId, rowVal)

}
function checkForSubmit() {
	/*
	 * if(document.getElementById('noOfRows').value==0) { alert("There must be
	 * one detail row"); return false; } else { return true; }
	 */
	return true;

}

function fillQuanForDefectiveDrug(rowVal) {
	if (document.getElementById('quanRecTemp' + rowVal).value == '') {
		document.getElementById('quanRec' + rowVal).value = 0
	} else {
		document.getElementById('quanRec' + rowVal).value = document
				.getElementById('quanRecTemp' + rowVal).value
	}
}

function fillAuthyForDefectiveDrug(rowVal) {
	if (document.getElementById('authyDecTemp' + rowVal).value == '') {
		document.getElementById('authyDec' + rowVal).value = 0
	} else {
		document.getElementById('authyDec' + rowVal).value = document
				.getElementById('authyDecTemp' + rowVal).value
	}

}

function fillDisposalForDefectiveDrug(rowVal) {
	if (document.getElementById('disposalTemp' + rowVal).value == '') {
		document.getElementById('disposal' + rowVal).value = 0
	} else {
		document.getElementById('disposal' + rowVal).value = document
				.getElementById('disposalTemp' + rowVal).value
	}

}

function fillExpForDefectiveDrug(rowVal) {
	if (document.getElementById('expiryDateTemp' + rowVal).value == '') {
	} else {
		document.getElementById('expiryDate' + rowVal).value = document
				.getElementById('expiryDateTemp' + rowVal).value
	}

}
// ================= functions for non expandable ==================

function onChangeSrc(sos) {
	document.getElementById("indentCombo").options.length = 0;
	if (sos == "p" || sos == "g" || sos == "m") {
		document.getElementById("indentCombo").disabled = true;

		submitProtoAjaxforSupplier('grnGrid',
				'/hms/hms/neStores?method=responseNeGrn');
		submitProtoAjaxforGrid('grnGrid',
				'/hms/hms/neStores?method=responseGridList');
	} else {
		document.getElementById("indentCombo").disabled = false;
		submitProtoAjaxforSupplier('grnGrid',
				'/hms/hms/neStores?method=responseNeGrn');
	}

}

function fillNatureOfWorkInWorkOrder(rowVal) {

	if (document.getElementById('natOfWrkTemp' + rowVal).value == '') {
		document.getElementById('natOfWrk' + rowVal).value = 0
	} else {
		document.getElementById('natOfWrk' + rowVal).value = document
				.getElementById('natOfWrkTemp' + rowVal).value
	}

}

function fillRemarksInWorkOrder(rowVal) {
	var remarks = "remarks";
	var remarksTemp = "remarksTemp";
	if (document.getElementById('remarksTemp' + rowVal).value == '') {
		document.getElementById('remarks' + rowVal).value = 0
	} else {
		document.getElementById('remarks' + rowVal).value = document
				.getElementById('remarksTemp' + rowVal).value
	}
}

function testForGrn() {
	var errorMessage = "";
	formName = "grnGrid"
	obj = eval('document.' + formName)

	for (i = 1; i < 30; i++) {
		if (document.getElementById('idItem' + i) != null) {
			if (document.getElementById('idItem' + i).value != 0) {
				/*
				 * if (document.getElementById('brandId'+i).value == "") {
				 * errorMessage=errorMessage+ "Please Select Brand Name for Item " +
				 * document.getElementById('nameItem'+i).value + " \n "; }
				 */
			}
		}
	}
	if (errorMessage == "")
		return true;
	else {
		alert(errorMessage);
		return false;
	}
}

// ===========================

function validationForSerial() {
	var errorMessage = "";
	formName = "grnGrid"
	obj = eval('document.' + formName)
	for (i = 1; i < 10; i++) {
		if (document.getElementById('batchNoTemp' + i).value != "") {
			if (document.getElementById('amcStartDate' + i).value == 0)
				errorMessage = errorMessage + "Please Select amcStartDate  \n";

			if (document.getElementById('amcEndDate' + i).value == 0)
				errorMessage = errorMessage + "Please Select amcEndDate  \n";

			if (document.getElementById('installationDate' + i).value == 0)
				errorMessage = errorMessage
						+ "Please Select installationDate  \n";

		}
		if (errorMessage != "") {
			alert(errorMessage)
			return false
		} else {
			return true
		}
	}

}

function enterQuantityForSerial(rowVal) {
	if (document.getElementById('batchNoTemp' + rowVal).value != "") {
		var quantity;
		document.getElementById('quanRecTemp' + rowVal).value = "1"
		document.getElementById('quanRec' + rowVal).value = "1"
		document.getElementById('quanRecTemp' + rowVal).disabled = true;

	} else {
		document.getElementById('quanRecTemp' + rowVal).value = "";
		document.getElementById('quanRecTemp' + rowVal).disabled = false;
	}
}

function checkForSerialNo(value, rowVal) {
	for (i = 1; i < 10; i++) {
		if (document.getElementById('batchNoTemp' + i).value != ""
				&& value != "" && rowVal != i)
			if (value == document.getElementById('batchNoTemp' + i).value) {
				alert("Serial No should be unique ...!")
				document.getElementById('batchNoTemp' + rowVal).value = ""
				return false;
			}
	}

	return true
}

// / amount calculation for loanin

function calculateAmountForLoanIn(rowVal) {
	var quantity = parseFloat(document.getElementById('quanRecTemp' + rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'
			+ rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'
			+ rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp' + rowVal).value)
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity * unitRate;

	if (!isNaN(quantity) && !isNaN(unitRate) && !isNaN(discount) && !isNaN(tax)) {
		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		amountAfterTax = (amountAfterdiscount) * (tax / 100)
		netAmount = amountAfterdiscount + amountAfterTax;
		document.getElementById('amtVarTemp' + rowVal).value = roundVal(
				netAmount, 2)
	} else if (!isNaN(quantity) == "" && !isNaN(unitRate) == "") {
		alert("Please Enter Both Quantity and Unit Rate.");
	} else if (!isNaN(quantity) != "" && !isNaN(unitRate) == "") {
		alert("Please Enter Unit Rate.");
	} else if (!isNaN(quantity) == "" && !isNaN(unitRate) != "") {
		alert("Please Enter Quantity.");
	} else if (!isNaN(discount) == "" && !isNaN(tax) == "") {

		document.getElementById('amtVarTemp' + rowVal).value = total
	} else if (!isNaN(discount) == "" || !isNaN(tax) != "") {
		netAmount = total + (total * (tax / 100));

		document.getElementById('amtVarTemp' + rowVal).value = roundVal(
				netAmount, 2)
	} else if (!isNaN(discount) != "" || !isNaN(tax) == "") {

		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amtVarTemp' + rowVal).value = roundVal(
				netAmount, 2)
	}

	var tempNetValue = 0;
	for (i = 1; i <= 10; i++) {
		if (document.getElementById('amtVarTemp' + i).value.trim() != "") {
			var freeItem = document.getElementById('freeItem' + i).value;
			if (freeItem == 'n')
				tempNetValue = parseFloat(tempNetValue)
						+ parseFloat(document.getElementById('amtVarTemp' + i).value);
			var rateForOne = 0;
			rateForOne = document.getElementById('amtVarTemp' + i).value.trim()
			var quantity = parseFloat(document.getElementById('quanRecTemp'
					+ rowVal).value)
			var freeqty = parseFloat(document
					.getElementById('freeQty' + rowVal).value)
			var costPrice = (rateForOne) / (quantity + freeqty)
			document.getElementById('costPriceTemp' + i).value = roundVal(
					costPrice, 3);
		}
	}

	document.getElementById('grnValue').value = roundVal(tempNetValue, 2);

	fillAmountForGrn(rowVal);
	fillCostPriceForGrn(rowVal);

}

function roundVal(val, dec) {
	var result = Math.round(val * Math.pow(10, dec)) / Math.pow(10, dec);
	return result;
}

function calculateAmountForCrvWhenAdjust(rowVal) {
	var quantity = parseFloat(document.getElementById('quanRecTemp' + rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'
			+ rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'
			+ rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp' + rowVal).value)
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity * unitRate;

	if (!isNaN(quantity) && !isNaN(unitRate) && !isNaN(discount) && !isNaN(tax)) {
		disc = total * (discount / 100);
		amountAfterdiscount = total - disc;
		amountAfterTax = (amountAfterdiscount) * (tax / 100)
		netAmount = amountAfterdiscount + amountAfterTax;
		document.getElementById('amtVarTemp' + rowVal).value = roundVal(
				netAmount, 2)
	} else if (!isNaN(quantity) == "" && !isNaN(unitRate) == "") {
		alert("Please Enter Both Quantity and Unit Rate.");
	} else if (!isNaN(quantity) != "" && !isNaN(unitRate) == "") {
		alert("Please Enter Unit Rate.");
	} else if (!isNaN(quantity) == "" && !isNaN(unitRate) != "") {
		alert("Please Enter Quantity.");
	} else if (!isNaN(discount) == "" && !isNaN(tax) == "") {

		document.getElementById('amtVarTemp' + rowVal).value = total
	} else if (!isNaN(discount) == "" || !isNaN(tax) != "") {
		netAmount = total + (total * (tax / 100));

		document.getElementById('amtVarTemp' + rowVal).value = roundVal(
				netAmount, 2)
	} else if (!isNaN(discount) != "" || !isNaN(tax) == "") {

		disc = total * (discount / 100);

		amountAfterdiscount = total - disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amtVarTemp' + rowVal).value = roundVal(
				netAmount, 2)
	}

	var abc = document.getElementById('grnValue').value

	var total = parseFloat(abc)
			+ parseFloat(document.getElementById('amtVarTemp' + rowVal).value);

	var tempNetValue = 0;

	tempNetValue = parseFloat(tempNetValue)
			+ parseFloat(document.getElementById('amtVarTemp').value);

	document.getElementById('grnValue').value = roundVal(total, 2);

}

// ========================================================================================================
// ======================FUNCTIONS END BY ABHA ======================
// ========================================================================================================

// ========================================================================================================
// ======================AT BANGALORE======================
// ========================================================================================================
function calculationInCRV() {

	for (rowVal = 1; rowVal <= document.getElementById('poListSize').value; rowVal++) {
		if (document.getElementById('idItem' + rowVal)) {
			if (document.getElementById('idItem' + rowVal).value.trim() != 0) {
				var discount = parseFloat(0);
				var tax = parseFloat(0);

				// Calculation of Amount for the Current Row (rowVal)
				// var added by shailesh
				// var
				// grn_qty=isNaN(parseFloat(document.getElementById('grn_qty'+rowVal).value))==true?"0":parseFloat(document.getElementById('grn_qty'+rowVal).value);
				var quantity = isNaN(parseFloat(document
						.getElementById('quanRec' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('quanRec' + rowVal).value);

				/*
				 * if(grn_qty<quantity){ alert("Received Quantity can't be
				 * greater then Actual Po Quantity in Row"+rowVal);
				 * document.getElementById('quanRec'+rowVal).focus(); return
				 * false; }
				 */
				// var id_item=document.getElementById('idItem'+rowVal).value;
				// arrayOfItems1[rowVal]=rowVal+","+id_item+","+quantity+","+grn_qty;
				// alert(arrayOfItems1[rowVal])
				// end of code by shailesh
				var freeQty = isNaN(parseFloat(document
						.getElementById('freeQty' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('freeQty' + rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document
						.getElementById('ratePerMdq' + rowVal).value)) == true ? "0"
						: parseFloat(document.getElementById('ratePerMdq'
								+ rowVal).value);
				// var dispencingPrice =
				// isNaN(parseFloat(document.getElementById('dispencingPrice'+rowVal).value))==true?"0":parseFloat(document.getElementById('dispencingPrice'+rowVal).value);
				// var mrp =
				// isNaN(parseFloat(document.getElementById('mrp'+rowVal).value))==true?"0":parseFloat(document.getElementById('mrp'+rowVal).value);

				var discount = isNaN(parseFloat(document
						.getElementById('discountVar' + rowVal).value)) == true ? "0"
						: parseFloat(document.getElementById('discountVar'
								+ rowVal).value);
				var tax = isNaN(parseFloat(document.getElementById('taxVar'
						+ rowVal).value)) == true ? "0" : parseFloat(document
						.getElementById('taxVar' + rowVal).value);

				var total = parseFloat(0);
				var disc = parseFloat(0);
				var amountAfterdiscount = parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount = parseFloat(0);

				total = parseFloat(quantity) * parseFloat(ratePerMdq);
				disc = total * (discount / 100);
				amountAfterdiscount = total - disc;
				taxAmount = (amountAfterdiscount) * (tax / 100);
				var vatApplicable = document.getElementById("vatApplicable");

				if (vatApplicable.checked) {
					netAmount = amountAfterdiscount;

				} else {
					netAmount = amountAfterdiscount + taxAmount;
				}
				document.getElementById('amtVar' + rowVal).value = roundVal(
						netAmount, 2);
				document.getElementById('taxAmount' + rowVal).value = roundVal(
						taxAmount, 2);
				document.getElementById('discountAmount' + rowVal).value = roundVal(
						disc, 2);

				// Calculating converted Stock as Per Formula & Conversion Login
				var formula = isNaN(parseFloat(document
						.getElementById('formula' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('formula' + rowVal).value);
				var conversionFactor = isNaN(parseFloat(document
						.getElementById('conversionFactor' + rowVal).value)) == true ? "0"
						: parseFloat(document.getElementById('conversionFactor'
								+ rowVal).value);
				// var mdq =
				// isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				// var mdq =
				// isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"1":parseFloat(document.getElementById('mdq'+rowVal).value);
				var mdq = 1;
				/*
				 * mdq=1 code by mukesh no idia about mdq so i put mdq=1 date 15
				 * oct 2010
				 */
				var convertedStock = parseFloat(0);
				quantity = parseFloat(quantity) + parseFloat(freeQty);
				if (formula != 0 && conversionFactor != 0 && mdq != 0) {
					if (formula == 1) {
						convertedStock = (parseFloat(quantity) * parseFloat(mdq))
								/ parseFloat(conversionFactor);
					} else if (formula == 2) {
						convertedStock = parseFloat(quantity);
					}
					document.getElementById('convertedStock' + rowVal).value = parseFloat(convertedStock);
				}
			}
		}
	}
	/*
	 * for(var x=0;x<arrayOfItems1.length;x++) { var
	 * content=arrayOfItems1[x].split(",");
	 * 
	 * for(var z=0;z<arrayOfItems1.length;z++) { if(x!=z) { var
	 * secondContent=arrayOfItems1[z].split(",");
	 * if(parseInt(content[1])==parseInt(secondContent[1])) {
	 * arrayOfItems1[x]=content[0]+","+content[1]+","+(parseFloat(content[2])+parseFloat(secondContent[2]))+","+content[3]; } } } }
	 * for(var y=0;arrayOfItems1.length;y++){ var u=arrayOfItems1[y].split(",");
	 * if(parseFloat(u[2])>parseFloat(u[3])){ alert("items for type at
	 * Row"+u[0]+" cant be greater than Po Qnty."); return false;
	 *  } }
	 *///
	cheakForRecdQty();
	calculateGRNValue();
}

function cheakForRecdQty() {
	var currentRow = currentRow;
	var quantityRecdSum = parseFloat(0);
	var totalQuantity = new Array(10000);
	var sos = "";

	for (rowVal = 1; rowVal <= document.getElementById('poListSize').value; rowVal++) {
		if (document.getElementById('idItem' + rowVal)) {
			if (document.getElementById('idItem' + rowVal).value.trim() != 0) {
				var itemId = parseFloat(document.getElementById('idItem'
						+ rowVal).value);
				var enteredQuantity = isNaN(parseFloat(document
						.getElementById('quanRec' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('quanRec' + rowVal).value);
				var orderedQuantity = 0;
				try {
					orderedQuantity = isNaN(parseFloat(document
							.getElementById('grn_qty' + rowVal).value)) == true ? "0"
							: parseFloat(document.getElementById('grn_qty'
									+ rowVal).value);
				} catch (e) {
					orderedQuantity = 0;
					sos = "grnForWithoutPo";
				}
				if (totalQuantity[itemId] != undefined) {
					totalQuantity[itemId][1] = parseFloat(totalQuantity[itemId][1])
							+ parseFloat(orderedQuantity);
					totalQuantity[itemId][2] = parseFloat(totalQuantity[itemId][2])
							+ parseFloat(enteredQuantity);
					// alert('total ' + totalQuantity[itemId][1]);
					// alert('received ' + totalQuantity[itemId][2]);
				} else {
					totalQuantity[itemId] = new Array(2);
					totalQuantity[itemId][1] = parseFloat(orderedQuantity);
					totalQuantity[itemId][2] = parseFloat(enteredQuantity);
					// alert('total ' + totalQuantity[itemId][1]);
					// alert('received ' + totalQuantity[itemId][2]);
				}
			}
		}
	}

	var errorMsg = "";
	for (rowVal = 1; rowVal <= document.getElementById('poListSize').value; rowVal++) {
		if (document.getElementById('idItem' + rowVal)) {
			if (document.getElementById('idItem' + rowVal).value.trim() != 0) {
				var itemId = parseFloat(document.getElementById('idItem'
						+ rowVal).value);
				var nomenclature = document.getElementById('nameItem' + rowVal).value;
				if (sos != "grnForWithoutPo") {
					if (totalQuantity[itemId][1] < totalQuantity[itemId][2]) {
						if (errorMsg == "")
							errorMsg = 'Received Qty > Ordered Quantity!... Kindly check the following Rows!....\n';
						errorMsg = errorMsg + '\nRow No: ' + rowVal + ' Item: '
								+ nomenclature;
					}
				}
			}
		}
	}

	if (errorMsg == "")
		return true;
	else {
		alert(errorMsg);
		return false;
	}

}

// Calculate Unit Rate in LPO
function calculateUnitRateinLocalSupplyOrder(inc) {
	var mdq = "mdq";
	var ratePerMdq = "ratePerMdq";
	var unitRateVarTemp = "unitRateVarTemp";
	var unitRateVar = "unitRateVar";
	if (!isNaN(document.getElementById(mdq + inc).value)
			&& !isNaN(document.getElementById(ratePerMdq + inc).value)) {
		document.getElementById(unitRateVarTemp + inc).value = parseFloat(document
				.getElementById(ratePerMdq + inc).value)
				/ parseFloat(document.getElementById(mdq + inc).value);
		var result = parseFloat(document.getElementById(unitRateVarTemp + inc).value);
		document.getElementById(unitRateVar + inc).value = roundVal(result, 2);
		calculateAmountForAdd(inc);
	}
}
// Calculate Unit Rate in LoanIn
function calculateUnitRateinLoanIn(inc) {
	var mdq = "mdq";
	var ratePerMdq = "ratePerMdq";
	var unitRateVarTemp = "unitRateVarTemp";
	var unitRateVar = "unitRateVar";
	if (!isNaN(document.getElementById(mdq + inc).value)
			&& !isNaN(document.getElementById(ratePerMdq + inc).value)) {
		document.getElementById(unitRateVarTemp + inc).value = parseFloat(document
				.getElementById(ratePerMdq + inc).value)
				/ parseFloat(document.getElementById(mdq + inc).value);
		document.getElementById(unitRateVar + inc).value = document
				.getElementById(unitRateVarTemp + inc).value;
	}
}

function fillQuantityForLoanIn(rowVal) {
	if (document.getElementById('quanRecTemp' + rowVal).value == '') {

	} else {
		document.getElementById('quanRec' + rowVal).value = document
				.getElementById('quanRecTemp' + rowVal).value
		if (document.getElementById('mdq' + rowVal).value != ''
				&& document.getElementById('ratePerMdq' + rowVal).value != '') {
			calculateUnitRateinLoanIn(rowVal);
			calculateAmountForLoanIn(rowVal);
		}
	}
}

function checkForLocalPurchaseGrid() {
	var pageNo = parseInt(document.getElementById('pageNo').value)
	var start = ((pageNo - 1) * 10) + 1;
	var end = ((pageNo - 1) * 10) + 10;
	for (i = start; i <= end; i++) {
		var pvms = document.getElementById('codeItem' + i).value;

		if (pvms != "") {

			/*
			 * if (document.getElementById('brandId'+i).value=="") { alert('Pl.
			 * Check Brand in Row No:' + i);
			 * document.getElementById('brandId'+i).focus(); return false; }
			 */
			if (document.getElementById('manufacturerId' + i).value == "") {
				alert('Pl. Check Manufacturer in Row No:' + i);
				document.getElementById('manufacturerId' + i).focus();
				return false;
			}

			if (document.getElementById('quantityInVarTemp' + i).value == ""
					|| isNaN(document.getElementById('quantityInVarTemp' + i).value)) {
				alert('Pl. Check Quantity in Row No:' + i);
				document.getElementById('quantityInVarTemp' + i).focus();
				return false;
			}

			if (document.getElementById('dispenseType' + i).value == "") {
				alert('Pl. Select Dispense Type in Row No:' + i);
				document.getElementById('dispenseType' + i).focus();
				return false;
			}
			/*
			 * if (document.getElementById('mdq'+i).value=="" ||
			 * document.getElementById('mdq'+i).value==0 ||
			 * isNaN(document.getElementById('mdq'+i).value)) { alert('Pl. Check
			 * MDQ in Row No:' + i); document.getElementById('mdq'+i).focus();
			 * return false; }
			 * 
			 * if (document.getElementById('ratePerMdq'+i).value=="" ||
			 * document.getElementById('ratePerMdq'+i).value==0 ||
			 * isNaN(document.getElementById('ratePerMdq'+i).value)) {
			 * alert('Pl. Unit Rate in Row No:' + i);
			 * document.getElementById('ratePerMdq'+i).focus(); return false; }
			 * 
			 * if (document.getElementById('amountVarTemp'+i).value=="" ||
			 * document.getElementById('amountVarTemp'+i).value < 0) {
			 * alert('Pl. Check Amount in Row No:' + i); return false; }
			 */
			gridCalculationLocalSupplyOrderEdit(i);
		}
	}
	return true;
}

function checkForLoanInGrid() {
	var pageNo = parseInt(document.getElementById('pageNo').value)
	var start = ((pageNo - 1) * 10) + 1;
	var end = ((pageNo - 1) * 10) + 10;

	for (i = start; i <= end; i++) {
		var pvms = document.getElementById('codeItem' + i).value;

		if (pvms != "") {

			if (document.getElementById('brandId' + i).value == "") {
				alert('Pl. Check Brand in Row No:' + i);
				document.getElementById('brandId' + i).focus();
				return false;
			}

			if (document.getElementById('manufacturerId' + i).value == "") {
				alert('Pl. Check Manufacturer in Row No:' + i);
				document.getElementById('manufacturerId' + i).focus();
				return false;
			}

			if (document.getElementById('quanRec' + i).value == ""
					|| isNaN(document.getElementById('quanRec' + i).value)) {
				alert('Pl. Check Quantity Received in Row No:' + i);
				document.getElementById('quanRecTemp' + i).focus();
				return false;
			}

			if (document.getElementById('dispenseType' + i).value == "") {
				alert('Pl. Select Dispense Type in Row No:' + i);
				document.getElementById('dispenseType' + i).focus();
				return false;
			}
			/*
			 * if (document.getElementById('mdq'+i).value=="" ||
			 * document.getElementById('mdq'+i).value==0 ||
			 * isNaN(document.getElementById('mdq'+i).value)) { alert('Pl. Check
			 * MDQ in Row No:' + i); document.getElementById('mdq'+i).focus();
			 * return false; }
			 */
			if (document.getElementById('ratePerMdq' + i).value == ""
					|| document.getElementById('ratePerMdq' + i).value == 0
					|| isNaN(document.getElementById('ratePerMdq' + i).value)) {
				alert('Pl. Check Rate / MDQ in Row No:' + i);
				document.getElementById('ratePerMdq' + i).focus();
				return false;
			}

			if (document.getElementById('amtVar' + i).value == ""
					|| document.getElementById('amtVar' + i).value == 0
					|| document.getElementById('amtVar' + i).value < 0) {
				alert('Pl. Check Amount in Row No:' + i);
				return false;
			}

			if (document.getElementById('batchNo' + i).value == "") {
				alert('Pl. Check Batch No in Row No:' + i);
				document.getElementById('batchNoTemp' + i).focus();
				return false;
			}

			/*
			 * if (document.getElementById('manufacturingDate'+i).value=="") {
			 * alert('Manufacturing Date in Row No:' + i + ' is Mandatory!..');
			 * document.getElementById('manufacturingDate'+i).focus(); return
			 * false; } else { var strValue =
			 * document.getElementById('manufacturingDate'+i).value;
			 * dateOfJoining = new
			 * Date(strValue.substring(6),(strValue.substring(3,5) - 1)
			 * ,strValue.substring(0,2)); currentDate = new Date(); var month =
			 * currentDate.getMonth() + 1 var day = currentDate.getDate() var
			 * year = currentDate.getFullYear() var seperator = "/" currentDate =
			 * new Date(month + seperator + day + seperator + year);
			 * if(dateOfJoining > currentDate) { alert('Manufacturing Date is
			 * Not Valid in Row No: ' + i ); return false; } }
			 */
			// if (document.getElementById('expiry'+i).value=='y')
			// {
			if (document.getElementById('expiryDate' + i).value == "") {
				alert('Expiry Date in Row No:' + i + ' is Mandatory!..');
				document.getElementById('expiryDate' + i).focus();
				return false;
			}

			var strValue = document.getElementById('expiryDate' + i).value;
			dateOfJoining = new Date(strValue.substring(6), (strValue
					.substring(3, 5) - 1), strValue.substring(0, 2));
			currentDate = new Date();
			var month = currentDate.getMonth() + 1
			var day = currentDate.getDate()
			var year = currentDate.getFullYear()
			var seperator = "/"
			currentDate = new Date(month + seperator + day + seperator + year);
			if (dateOfJoining < currentDate) {
				alert('Expiry Date is Not Valid in Row No: ' + i);
				return false;
			}
			// }

		}
	}
	return true;
}

function checkForCRVGrid() {
	for (i = 1; i <= 30; i++) {
		var pvms = "";
		if (document.getElementById('codeItem' + i) != null) {
			pvms = document.getElementById('codeItem' + i).value;
		}
		if (pvms != "") {

			/*
			 * if (document.getElementById('brandId'+i).value=="") { alert('Pl.
			 * Check Brand in Row No:' + i);
			 * document.getElementById('brandId'+i).focus(); return false; }
			 */
			var storeDept = 0;
			if (document.getElementById('storeDept' + i)) {
				storeDept = document.getElementById('storeDept' + i).value;
			}
			if (document.getElementById('manufacturerId' + i).value == "") {
				alert('Pl. Check Manufacturer in Row No:' + i);
				document.getElementById('manufacturerId' + i).focus();
				return false;
			}

			/*
			 * Code commented By Mukesh Narayan Singh Date 21 Dec 2010
			 * if(storeDept != '25'){ // 25 is for General Stores if
			 * (document.getElementById('manufacturerId'+i).value=="") {
			 * alert('Pl. Check Manufacturer in Row No:' + i);
			 * document.getElementById('manufacturerId'+i).focus(); return
			 * false; } }
			 */
			if (document.getElementById('dispencingPrice' + i).value == "") {
				alert('Pl. Check Dispencing Price  in Row No:' + i);
				document.getElementById('dispencingPrice' + i).focus();
				return false;
			}
			if (document.getElementById('mrp' + i).value == "") {
				alert('Pl. Check MRP in Row No:' + i);
				document.getElementById('mrp' + i).focus();
				return false;
			}
			if (document.getElementById('batchNo' + i).value == "") {
				alert('Pl. Check Batch No/Lot No in Row No:' + i);
				document.getElementById('batchNo' + i).focus();
				return false;
			}

			if (document.getElementById('quanRec' + i).value == ""
					|| isNaN(document.getElementById('quanRec' + i).value)) {
				alert('Pl. Check Quantity Received in Row No:' + i);
				document.getElementById('quanRec' + i).focus();
				return false;
			}

			if (document.getElementById('dispenseType' + i).value == "") {
				alert('Pl. Select Dispense Type in Row No:' + i);
				document.getElementById('dispenseType' + i).focus();
				return false;
			}
			/*
			 * if (document.getElementById('mdq'+i).value=="" ||
			 * document.getElementById('mdq'+i).value==0 ||
			 * isNaN(document.getElementById('mdq'+i).value)) { alert('Pl. Check
			 * MDQ in Row No:' + i); document.getElementById('mdq'+i).focus();
			 * return false; }
			 */
			if (document.getElementById('sourceCombo').value == "a"
					|| document.getElementById('sourceCombo').value == "i") {
				return true;
			} else if (document.getElementById('ratePerMdq' + i).value == ""
					|| isNaN(document.getElementById('ratePerMdq' + i).value)) {
				// else if (document.getElementById('ratePerMdq'+i).value=="" ||
				// document.getElementById('ratePerMdq'+i).value==0 ||
				// isNaN(document.getElementById('ratePerMdq'+i).value))
				alert('Pl. Check Rate / MDQ in Row No:' + i);
				document.getElementById('ratePerMdq' + i).focus();
				return false;
			}

			if (document.getElementById('sourceCombo').value == "a"
					|| document.getElementById('sourceCombo').value == "i") {
				return true;
			}
			// else if (document.getElementById('amtVar'+i).value=="" ||
			// document.getElementById('amtVar'+i).value==0 ||
			// document.getElementById('amtVar'+i).value < 0)
			else if (document.getElementById('amtVar' + i).value == ""
					|| document.getElementById('amtVar' + i).value < 0) {
				alert('Pl. Check Amount in Row No:' + i);
				return false;
			}
			// alert("---------exp--st-->"+document.getElementById('expiryDate'+i).value);
			// if(document.getElementById('expiry'+i).value!='n'){
			// if (document.getElementById('expiryDate'+i).value=="")
			// {
			// alert('Expiry Date Date in Row No:' + i + ' is Mandatory!..');
			// document.getElementById('expiryDate'+i).focus();
			// return false;
			// }}
			/*
			 * Code commented By Mukesh Narayan Singh Date 21 Dec 2010
			 * if(storeDept != '25'){ // 25 is for General Stores if
			 * (document.getElementById('expiryDate'+i).value=="") {
			 * alert('Expiry Date Date in Row No:' + i + ' is Mandatory!..');
			 * document.getElementById('expiryDate'+i).focus(); return false; } }
			 */
			if (parseFloat(document.getElementById('dispencingPrice' + i).value) > parseFloat(document
					.getElementById('mrp' + i).value)) {
				alert('Dispencing price  in Row No:' + i
						+ ' cannot be greater than mrp!..');
				document.getElementById('dispencingPrice' + i).focus();
				return false;
			}
			if (parseFloat(document.getElementById('ratePerMdq' + i).value) > parseFloat(document
					.getElementById('mrp' + i).value)) {
				alert('Mrp  in Row No:' + i
						+ ' cannot be less than unit rate!..');
				document.getElementById('ratePerMdq' + i).focus();
				return false;
			}
			if (parseFloat(document.getElementById('ratePerMdq' + i).value) > parseFloat(document
					.getElementById('dispencingPrice' + i).value)) {
				alert('Dispencing price in Row No:' + i
						+ ' cannot be less than unit rate!..');
				document.getElementById('dispencingPrice' + i).focus();
				return false;
			} else {
				var strValue = document.getElementById('manufacturingDate' + i).value;
				dateOfJoining = new Date(strValue.substring(6), (strValue
						.substring(3, 5) - 1), strValue.substring(0, 2));
				currentDate = new Date();
				var month = currentDate.getMonth() + 1
				var day = currentDate.getDate()
				var year = currentDate.getFullYear()
				var seperator = "/"
				currentDate = new Date(month + seperator + day + seperator
						+ year);

				if (dateOfJoining > currentDate) {
					alert('Manufacturing Date is Not Valid in Row No: ' + i);
					return false;
				}
			}

			// if (document.getElementById('expiry'+i).value=='y')
			// {
			if (document.getElementById('expiryDate' + i).value == "") {
				alert('Expiry Date in Row No:' + i + ' is Mandatory!..');
				document.getElementById('expiryDate' + i).focus();
				return false;
			}

			var strValue = document.getElementById('expiryDate' + i).value;
			dateOfJoining = new Date(strValue.substring(6), (strValue
					.substring(3, 5) - 1), strValue.substring(0, 2));
			currentDate = new Date();
			var month = currentDate.getMonth() + 1
			var day = currentDate.getDate()
			var year = currentDate.getFullYear()
			var seperator = "/"
			currentDate = new Date(month + seperator + day + seperator + year);
			if (dateOfJoining < currentDate) {
				alert('Expiry Date is Not Valid in Row No: ' + i);
				return false;
			}
			// }
		}
	}

	return true;
}

function gridCalculationLocalSupplyOrderAdd(rowVal) {
	var pageNo = parseInt(document.getElementById('pageNo').value)
	var start = ((pageNo - 1) * 10) + 1;
	var end = ((pageNo - 1) * 10) + 10;
	var quantity = 0;
	var mdq = 0;
	var ratePerMdq = 0;
	var unitRate = 0;
	var discount = 0;
	var mrp = 0;
	var tax = 0;
	var discountAmount = 0;
	var taxAmountOnMRP = 0;
	var totalAmount = 0;
	var otherTaxes = 0;
	var grandTotal = 0;
	var totalCarryForward = 0;

	if (!isNaN(document.getElementById('quantityInVarTemp' + rowVal).value))
		quantity = parseFloat(document.getElementById('quantityInVarTemp'
				+ rowVal).value);

	if (!isNaN(document.getElementById('mdq' + rowVal).value))
		mdq = parseFloat(document.getElementById('mdq' + rowVal).value);

	if (!isNaN(document.getElementById('ratePerMdq' + rowVal).value))
		ratePerMdq = parseFloat(document.getElementById('ratePerMdq' + rowVal).value);

	if (!isNaN(document.getElementById('discountVarTemp' + rowVal).value))
		discount = parseFloat(document.getElementById('discountVarTemp'
				+ rowVal).value);

	if (!isNaN(document.getElementById('mrp' + rowVal).value))
		mrp = parseFloat(document.getElementById('mrp' + rowVal).value);

	if (!isNaN(document.getElementById('taxVarTemp' + rowVal).value))
		tax = parseFloat(document.getElementById('taxVarTemp' + rowVal).value);

	if (!isNaN(document.getElementById('otherTaxes' + rowVal).value))
		otherTaxes = parseFloat(document.getElementById('otherTaxes' + rowVal).value);

	if (!isNaN(document.getElementById('totalCarryForward').value))
		totalCarryForward = parseFloat(document
				.getElementById('totalCarryForward').value);

	// Amount Calculation

	if (mdq > 0 && ratePerMdq > 0 && quantity > 0) {
		unitRate = ratePerMdq / mdq;
		totalAmount = quantity * unitRate;

		if (discount > 0) {
			discountAmount = totalAmount * (discount / 100);
			totalAmount = totalAmount - discountAmount;
		}

		if (mrp > 0 && tax > 0) {
			// taxAmountOnMRP = quantity * (mrp / mdq) * (tax / 100);
			// taxAmountOnMRP = quantity * (unitRate) * (tax / 100);
			taxAmountOnMRP = totalAmount * (tax / 100);
			totalAmount = totalAmount + taxAmountOnMRP;
		}

		if (otherTaxes > 0) {
			totalAmount = totalAmount + otherTaxes;
		}

		// Fill Calculated Amount in the Corresponding Row
		document.getElementById('amountVarTemp' + rowVal).value = totalAmount;
		document.getElementById('unitRateVarTemp' + rowVal).value = unitRate;

	} else {
		return;
	}

	// Fill Values to Hidden Fields

	document.getElementById('quantityInVar' + rowVal).value = document
			.getElementById('quantityInVarTemp' + rowVal).value;
	document.getElementById('discountVar' + rowVal).value = document
			.getElementById('discountVarTemp' + rowVal).value;
	document.getElementById('amountVar' + rowVal).value = document
			.getElementById('amountVarTemp' + rowVal).value;
	document.getElementById('unitRateVar' + rowVal).value = document
			.getElementById('unitRateVarTemp' + rowVal).value;
	document.getElementById('taxVar' + rowVal).value = document
			.getElementById('taxVarTemp' + rowVal).value;

	for (var r = start; r <= end; r++) {
		if (isNaN(document.getElementById('amountVarTemp' + r).value)) {

		} else {
			var freeItem = document.getElementById('freeItem' + r).value;
			if (freeItem == 'n')
				grandTotal = grandTotal
						+ parseFloat(document.getElementById('amountVarTemp'
								+ r).value)
		}
	}

	grandTotal = grandTotal + totalCarryForward;

	// Fill Grand Total
	document.getElementById('total_amount').value = grandTotal;

}

function gridCalculationLocalSupplyOrderEdit(rowVal) {
	var pageNo = parseInt(document.getElementById('pageNo').value)
	var start = ((pageNo - 1) * 10) + 1;
	var end = ((pageNo - 1) * 10) + 10;
	var quantity = 0;
	var mdq = 0;
	var ratePerMdq = 0;
	var unitRate = 0;
	var discount = 0;
	var mrp = 0;
	var tax = 0;
	var discountAmount = 0;
	var taxAmountOnMRP = 0;
	var totalAmount = 0;
	var otherTaxes = 0;
	var grandTotal = 0;
	var totalCarryForward = 0;
	var pageTotal = 0;
	var netCalculatedAmount = 0;

	if (!isNaN(document.getElementById('quantityInVarTemp' + rowVal).value)) {
		quantity = parseFloat(document.getElementById('quantityInVarTemp'
				+ rowVal).value);

	}

	if (!isNaN(document.getElementById('mdq' + rowVal).value))
		mdq = parseFloat(document.getElementById('mdq' + rowVal).value);

	if (!isNaN(document.getElementById('unitRateVarTemp' + rowVal).value))
		unitRate = parseFloat(document.getElementById('unitRateVarTemp'
				+ rowVal).value);

	if (!isNaN(document.getElementById('ratePerMdq' + rowVal).value))
		ratePerMdq = parseFloat(document.getElementById('ratePerMdq' + rowVal).value);

	if (!isNaN(document.getElementById('discountVarTemp' + rowVal).value))
		discount = parseFloat(document.getElementById('discountVarTemp'
				+ rowVal).value);

	if (!isNaN(document.getElementById('mrp' + rowVal).value))
		mrp = parseFloat(document.getElementById('mrp' + rowVal).value);

	if (!isNaN(document.getElementById('taxVarTemp' + rowVal).value))
		tax = parseFloat(document.getElementById('taxVarTemp' + rowVal).value);

	if (!isNaN(document.getElementById('otherTaxes' + rowVal).value))
		otherTaxes = parseFloat(document.getElementById('otherTaxes' + rowVal).value);

	if (!isNaN(document.getElementById('totalCarryForward').value))
		totalCarryForward = parseFloat(document
				.getElementById('totalCarryForward').value);

	if (document.getElementById('pageTotal') != null) {
		if (!isNaN(document.getElementById('pageTotal').value))
			pageTotal = parseFloat(document.getElementById('pageTotal').value);
	}
	if (document.getElementById('netCalculatedAmount') != null) {
		if (!isNaN(document.getElementById('netCalculatedAmount').value))
			netCalculatedAmount = parseFloat(document
					.getElementById('netCalculatedAmount').value);
	}

	if (unitRate >= 0 && quantity >= 0) {

		totalAmount = quantity * unitRate;

		if (discount > 0) {
			discountAmount = totalAmount * (discount / 100);
			totalAmount = totalAmount - discountAmount;
		}

		if (mrp > 0 && tax > 0) {
			// taxAmountOnMRP = quantity * (mrp / mdq) * (tax / 100);
			// totalAmount = totalAmount + taxAmountOnMRP;
			taxAmountOnMRP = totalAmount * (tax / 100);
			totalAmount = totalAmount + taxAmountOnMRP;
		}

		if (otherTaxes > 0) {
			totalAmount = totalAmount + otherTaxes;
		}

		// Fill Calculated Amount in the Corresponding Row
		document.getElementById('amountVarTemp' + rowVal).value = totalAmount;

		document.getElementById('unitRateVarTemp' + rowVal).value = unitRate;

	} else {

		return;
	}

	// Fill Values to Hidden Fields

	document.getElementById('quantityInVar' + rowVal).value = document
			.getElementById('quantityInVarTemp' + rowVal).value;
	document.getElementById('discountVar' + rowVal).value = document
			.getElementById('discountVarTemp' + rowVal).value;
	document.getElementById('amountVar' + rowVal).value = document
			.getElementById('amountVarTemp' + rowVal).value;
	document.getElementById('unitRateVar' + rowVal).value = document
			.getElementById('unitRateVarTemp' + rowVal).value;
	document.getElementById('taxVar' + rowVal).value = document
			.getElementById('taxVarTemp' + rowVal).value;

	for (var r = start; r <= end; r++) {
		if (isNaN(document.getElementById('amountVarTemp' + r).value)) {

		} else {
			var freeItem = document.getElementById('freeItem' + r).value;
			if (freeItem == 'n')
				grandTotal = grandTotal
						+ parseFloat(document.getElementById('amountVarTemp'
								+ r).value)
		}
	}

	grandTotal = grandTotal + (totalCarryForward - pageTotal);

	// Fill Grand Total
	document.getElementById('total_amount').value = grandTotal;
}

function testForLoanIn() {
	var errorMessage = "";
	formName = "grnGrid"
	obj = eval('document.' + formName)

	for (i = 1; i <= 10; i++) {
		if (document.getElementById('idItem' + i).value != 0) {
			if (document.getElementById('brandId' + i).value == "") {
				errorMessage = errorMessage
						+ "Please Select Brand Name for Item "
						+ document.getElementById('nameItem' + i).value
						+ " \n ";
			}
		}
	}

	if (errorMessage == "")
		return true;
	else {
		alert(errorMessage);
		return false;
	}
}

function calVatPercentage() {
	if (document.getElementById('vatTax').value == ''
			|| document.getElementById('vatTax').value == '0') {
		var vatPer = document.getElementById('vatTaxPercentage').value;
		var actualGrnVal = document.getElementById('grnValue').value;
		var vatPerValue = (vatPer * actualGrnVal) / 100;
		var finalGrnVal = parseFloat(actualGrnVal) + parseFloat(vatPerValue);

		document.getElementById('grnValue').value = finalGrnVal;
		document.getElementById('vatTax').value = vatPerValue;
	}
}

function calculateGRNValue() {
	// Calculation of Total GRN Value
	var exciseDuty = isNaN(parseFloat(document.getElementById('exciseDuty').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('exciseDuty').value.trim());
	var freightDuty = isNaN(parseFloat(document.getElementById('freightDuty').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('freightDuty').value.trim());
	var octroi = isNaN(parseFloat(document.getElementById('octroi').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('octroi').value.trim());
	var insuranceCharges = isNaN(parseFloat(document
			.getElementById('insuranceCharges').value.trim())) == true ? "0"
			: parseFloat(document.getElementById('insuranceCharges').value
					.trim());
	var otherCharges = isNaN(parseFloat(document.getElementById('otherCharges').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('otherCharges').value.trim());
	var customDuty = isNaN(parseFloat(document.getElementById('customDuty').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('customDuty').value.trim());

	var tempNetValue = parseFloat(0);
	var charge = parseFloat(0);
	var vat = parseFloat(0);
	var temp = 0;
	for (i = 1; i <= document.getElementById('poListSize').value; i++) {
		if (document.getElementById('idItem' + i)) {
			if (document.getElementById('idItem' + i).value.trim() != 0) {
				var freeItem = document.getElementById('freeItem' + i).value;
				if (freeItem == 'n')
					tempNetValue = parseFloat(tempNetValue)
							+ parseFloat(document.getElementById('amtVar' + i).value);
			}
		}
	}
	// Update Cost Price of All Items in the Grid
	// (Duty + VAT) / Total Amt in Grid * Row Amount = Additional Tax
	// Row Amount = Row Amount + Additional Tax
	// Item Cost Price = Row Amount / Converted Stock

	charge = parseFloat(freightDuty) + parseFloat(exciseDuty)
			+ parseFloat(octroi) + parseFloat(insuranceCharges)
			+ parseFloat(otherCharges) + parseFloat(customDuty);
	var vat = isNaN(parseFloat(document.getElementById('vatTax').value)) == true ? "0"
			: parseFloat(document.getElementById('vatTax').value);
	var vatPer = isNaN(parseFloat(document.getElementById('vatTaxPercentage').value)) == true ? "0"
			: parseFloat(document.getElementById('vatTaxPercentage').value);
	var totDiscount = isNaN(parseFloat(document.getElementById('totDiscount').value)) == true ? "0"
			: parseFloat(document.getElementById('totDiscount').value);
	var vatApplicable = document.getElementById('vatApplicable');
	if (vatApplicable.checked == false)
		charge = parseFloat(charge) + parseFloat(vat);

	charge = parseFloat(charge) - parseFloat(totDiscount);
	var rowAmt = parseFloat(0);
	var additionalTax = parseFloat(0);
	var convertedStock = parseFloat(0);
	var costPrice = parseFloat(0);
	// new var for storing previously Updated amount in rows
	var tempRowAmountValues = parseFloat(0);
	for (i = 1; i <= document.getElementById('poListSize').value; i++) {

		if (document.getElementById('idItem' + i)) {
			if (document.getElementById('idItem' + i).value.trim() != 0) {
				rowAmt = isNaN(parseFloat(document.getElementById('amtVar' + i).value)) == true ? 0
						: parseFloat(document.getElementById('amtVar' + i).value);

				if (parseFloat(tempNetValue) > 0 && parseFloat(rowAmt) > 0)
					additionalTax = (parseFloat(charge) / parseFloat(tempNetValue))
							* parseFloat(rowAmt);

				rowAmt = rowAmt + additionalTax;

				tempRowAmountValues = tempRowAmountValues + rowAmt;
				// updated by shailesh
				// document.getElementById('amtVar'+i).value =
				// roundVal(rowAmt,2);
				// updation finish
				convertedStock = isNaN(parseFloat(document
						.getElementById('convertedStock' + i).value)) == true ? "0"
						: parseFloat(document.getElementById('convertedStock'
								+ i).value);
				if (convertedStock > 0)
					costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
				else
					costPrice = parseFloat(0);
				document.getElementById('costPrice' + i).value = roundVal(
						costPrice, 3);
			}
		}
	}

	// Calculate Total Amount
	tempNetValue = parseFloat(0);

	for (i = 1; i <= document.getElementById('poListSize').value; i++) {
		if (document.getElementById('idItem' + i)) {
			if (document.getElementById('idItem' + i).value.trim() != 0) {
				var freeItem = document.getElementById('freeItem' + i).value;
				if (freeItem == 'n')
					tempNetValue = parseFloat(tempNetValue)
							+ parseFloat(document.getElementById('amtVar' + i).value);

			}
		}
	}

	// document.getElementById('grnValue').value=roundVal(tempNetValue,2);
	// updatedby shailesh
	// /*var actualValue=roundVal(tempNetValue,2);
	// var valueAfterRounding=roundNumber(tempNetValue,0);*/

	var actualValue = roundVal(tempRowAmountValues, 2);
	var valueAfterRounding = roundNumber(tempRowAmountValues, 0);

	var roundOffAmount = valueAfterRounding - actualValue;

	if (vatApplicable.checked) {
		var vat = parseFloat(0);
		vat = document.getElementById('vatTax').value;
		var vatgrn = parseFloat(0);
		if (vat == "") {
			vat = parseFloat(0);
		}
		var vatgrn1 = parseFloat(valueAfterRounding) + parseFloat(vat);

		vatgrn = roundVal(vatgrn1, 0);
		roundOffAmount = vatgrn1 - vatgrn;

		document.getElementById('grnValue').value = vatgrn;

	} else {
		document.getElementById('grnValue').value = valueAfterRounding;
	}

	// document.getElementById('grnValue').value=valueAfterRounding
	roundOffAmount = roundVal(roundOffAmount, 3);
	document.getElementById('roundOfValue').value = roundOffAmount;

	document.getElementById('actualGrnValue').value = actualValue;
}

function roundNumber(number, decimal_points) {
	if (!decimal_points)
		return Math.round(number);
	if (number == 0) {
		var decimals = "";
		for (var i = 0; i < decimal_points; i++)
			decimals += "0";
		return "0." + decimals;
	}

	var exponent = Math.pow(10, decimal_points);
	var num = Math.round((number * exponent)).toString();
	return num.slice(0, -1 * decimal_points) + "."
			+ num.slice(-1 * decimal_points)
}

function calculationinLoanIn() {

	for (rowVal = 1; rowVal <= 25; rowVal++) {
		if (document.getElementById('idItem' + rowVal).value.trim() != 0) {
			var discount = parseFloat(0);
			var tax = parseFloat(0);

			// Calculation of Amount for the Current Row (rowVal)

			var quantity = isNaN(parseFloat(document.getElementById('quanRec'
					+ rowVal).value)) == true ? "0" : parseFloat(document
					.getElementById('quanRec' + rowVal).value);
			var freeQty = isNaN(parseFloat(document.getElementById('freeQty'
					+ rowVal).value)) == true ? "0" : parseFloat(document
					.getElementById('freeQty' + rowVal).value);
			var ratePerMdq = isNaN(parseFloat(document
					.getElementById('ratePerMdq' + rowVal).value)) == true ? "0"
					: parseFloat(document.getElementById('ratePerMdq' + rowVal).value);
			var discount = isNaN(parseFloat(document
					.getElementById('discountVar' + rowVal).value)) == true ? "0"
					: parseFloat(document
							.getElementById('discountVar' + rowVal).value);
			var tax = isNaN(parseFloat(document.getElementById('taxVar'
					+ rowVal).value)) == true ? "0" : parseFloat(document
					.getElementById('taxVar' + rowVal).value);

			var total = parseFloat(0);
			var disc = parseFloat(0);
			var amountAfterdiscount = parseFloat(0);
			var taxAmount = parseFloat(0);
			var netAmount = parseFloat(0);

			total = parseFloat(quantity) * parseFloat(ratePerMdq);
			disc = total * (discount / 100);
			amountAfterdiscount = total - disc;
			taxAmount = (amountAfterdiscount) * (tax / 100)
			netAmount = amountAfterdiscount + taxAmount;

			document.getElementById('amtVar' + rowVal).value = roundVal(
					netAmount, 2);
			document.getElementById('taxAmount' + rowVal).value = roundVal(
					taxAmount, 2);
			document.getElementById('discountAmount' + rowVal).value = roundVal(
					disc, 2);

			// Calculating converted Stock as Per Formula & Conversion Login
			var formula = isNaN(parseFloat(document.getElementById('formula'
					+ rowVal).value)) == true ? "0" : parseFloat(document
					.getElementById('formula' + rowVal).value);
			var conversionFactor = isNaN(parseFloat(document
					.getElementById('conversionFactor' + rowVal).value)) == true ? "0"
					: parseFloat(document.getElementById('conversionFactor'
							+ rowVal).value);
			var mdq = isNaN(parseFloat(document.getElementById('mdq' + rowVal).value)) == true ? "0"
					: parseFloat(document.getElementById('mdq' + rowVal).value);
			var convertedStock = parseFloat(0);
			quantity = parseFloat(quantity) + parseFloat(freeQty);
			if (formula != 0 && conversionFactor != 0 && mdq != 0) {
				if (formula == 1) {
					convertedStock = (parseFloat(quantity) * parseFloat(mdq))
							/ parseFloat(conversionFactor);
				} else if (formula == 2) {
					convertedStock = parseFloat(quantity);
				}
				document.getElementById('convertedStock' + rowVal).value = parseFloat(convertedStock);
			}

		}
	}

	var rowAmt = parseFloat(0);
	var convertedStock = parseFloat(0);
	var costPrice = parseFloat(0);

	// Calculate cost price for all items in the Grid
	for (i = 1; i <= 25; i++) {
		if (document.getElementById('idItem' + i).value.trim() != 0) {
			rowAmt = isNaN(parseFloat(document.getElementById('amtVar' + i).value)) == true ? 0
					: parseFloat(document.getElementById('amtVar' + i).value);
			document.getElementById('amtVar' + i).value = roundVal(rowAmt, 2);
			convertedStock = isNaN(parseFloat(document
					.getElementById('convertedStock' + i).value)) == true ? "0"
					: parseFloat(document.getElementById('convertedStock' + i).value);
			if (convertedStock > 0)
				costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
			else
				costPrice = parseFloat(0);
			document.getElementById('costPrice' + i).value = roundVal(
					costPrice, 3);
		}
	}

	// Calculate Total Loan In Amount
	var tempNetValue = parseFloat(0);
	for (i = 1; i <= 25; i++) {
		if (document.getElementById('idItem' + i).value.trim() != 0) {
			var freeItem = document.getElementById('freeItem' + i).value;
			if (freeItem == 'n')
				tempNetValue = parseFloat(tempNetValue)
						+ parseFloat(document.getElementById('amtVar' + i).value);
		}
	}
	document.getElementById('loanInValue').value = roundVal(tempNetValue, 2);
}
function calculationInCRVMod() {

	for (rowVal = 1; rowVal <= document.getElementById('poListSize').value; rowVal++) {
		// alert("::::::"+rowVal);
		if (document.getElementById('idItem' + rowVal) != null) {
			if (document.getElementById('idItem' + rowVal).value.trim() != 0) {
				var discount = parseFloat(0);
				var tax = parseFloat(0);

				// Calculation of Amount for the Current Row (rowVal)

				var quantity = isNaN(parseFloat(document
						.getElementById('quanRec' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('quanRec' + rowVal).value);
				var freeQty = isNaN(parseFloat(document
						.getElementById('freeQty' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('freeQty' + rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document
						.getElementById('ratePerMdq' + rowVal).value)) == true ? "0"
						: parseFloat(document.getElementById('ratePerMdq'
								+ rowVal).value);
				var discount = isNaN(parseFloat(document
						.getElementById('discountVar' + rowVal).value)) == true ? "0"
						: parseFloat(document.getElementById('discountVar'
								+ rowVal).value);
				var tax = isNaN(parseFloat(document.getElementById('taxVar'
						+ rowVal).value)) == true ? "0" : parseFloat(document
						.getElementById('taxVar' + rowVal).value);

				var total = parseFloat(0);
				var disc = parseFloat(0);
				var amountAfterdiscount = parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount = parseFloat(0);

				total = parseFloat(quantity) * parseFloat(ratePerMdq);

				disc = total * (discount / 100);
				amountAfterdiscount = total - disc;
				taxAmount = (amountAfterdiscount) * (tax / 100)
				var vatApplicable = document.getElementById("vatApplicable");
				if (vatApplicable.checked) {
					netAmount = amountAfterdiscount;
				} else {
					netAmount = amountAfterdiscount + taxAmount;
				}

				document.getElementById('amtVar' + rowVal).value = roundVal(
						netAmount, 2);
				document.getElementById('taxAmount' + rowVal).value = roundVal(
						taxAmount, 4);
				// document.getElementById('taxAmount'+rowVal).value=taxAmount;
				document.getElementById('discountAmount' + rowVal).value = roundVal(
						disc, 4);
				// document.getElementById('discountAmount'+rowVal).value=disc;

				// Calculating converted Stock as Per Formula & Conversion Login
				var formula = isNaN(parseFloat(document
						.getElementById('formula' + rowVal).value)) == true ? "0"
						: parseFloat(document
								.getElementById('formula' + rowVal).value);
				var conversionFactor = isNaN(parseFloat(document
						.getElementById('conversionFactor' + rowVal).value)) == true ? "0"
						: parseFloat(document.getElementById('conversionFactor'
								+ rowVal).value);
				var mdq = isNaN(parseFloat(document.getElementById('mdq'
						+ rowVal).value)) == true ? "0" : parseFloat(document
						.getElementById('mdq' + rowVal).value);
				var convertedStock = parseFloat(0);
				quantity = parseFloat(quantity) + parseFloat(freeQty);
				if (formula != 0 && conversionFactor != 0 && mdq != 0) {
					if (formula == 1) {
						convertedStock = (parseFloat(quantity) * parseFloat(mdq))
								/ parseFloat(conversionFactor);
					} else if (formula == 2) {
						convertedStock = parseFloat(quantity);
					}
					document.getElementById('convertedStock' + rowVal).value = parseFloat(convertedStock);
				}

			}
		}
	}

	calculateGRNValueMod();
}
function calculateGRNValueMod() {
	// Calculation of Total GRN Value
	var exciseDuty = isNaN(parseFloat(document.getElementById('exciseDuty').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('exciseDuty').value.trim());
	var freightDuty = isNaN(parseFloat(document.getElementById('freightDuty').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('freightDuty').value.trim());
	var octroi = isNaN(parseFloat(document.getElementById('octroi').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('octroi').value.trim());
	var insuranceCharges = isNaN(parseFloat(document
			.getElementById('insuranceCharges').value.trim())) == true ? "0"
			: parseFloat(document.getElementById('insuranceCharges').value
					.trim());
	var otherCharges = isNaN(parseFloat(document.getElementById('otherCharges').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('otherCharges').value.trim());
	var customDuty = isNaN(parseFloat(document.getElementById('customDuty').value
			.trim())) == true ? "0" : parseFloat(document
			.getElementById('customDuty').value.trim());

	var tempNetValue = parseFloat(0);
	var charge = parseFloat(0);
	var vat = parseFloat(0);
	var temp = 0;

	for (i = 1; i <= document.getElementById('poListSize').value; i++) {
		if (document.getElementById('idItem' + i) != null) {
			if (document.getElementById('idItem' + i).value.trim() != 0) {
				var freeItem = document.getElementById('freeItem' + i).value;
				if (freeItem == 'n')
					tempNetValue = parseFloat(tempNetValue)
							+ parseFloat(document.getElementById('amtVar' + i).value);
			}
		}
	}

	// Update Cost Price of All Items in the Grid
	// (Duty + VAT) / Total Amt in Grid * Row Amount = Additional Tax
	// Row Amount = Row Amount + Additional Tax
	// Item Cost Price = Row Amount / Converted Stock

	charge = parseFloat(freightDuty) + parseFloat(exciseDuty)
			+ parseFloat(octroi) + parseFloat(insuranceCharges)
			+ parseFloat(otherCharges) + parseFloat(customDuty);
	var vat = isNaN(parseFloat(document.getElementById('vatTax').value)) == true ? "0"
			: parseFloat(document.getElementById('vatTax').value);
	var totDiscount = isNaN(parseFloat(document.getElementById('totDiscount').value)) == true ? "0"
			: parseFloat(document.getElementById('totDiscount').value);
	var vatApplicable = document.getElementById('vatApplicable');
	if (vatApplicable.checked == false)
		charge = parseFloat(charge) + parseFloat(vat);
	charge = parseFloat(charge) - parseFloat(totDiscount)

	var rowAmt = parseFloat(0);
	var additionalTax = parseFloat(0);
	var convertedStock = parseFloat(0);
	var costPrice = parseFloat(0);
	var tempRowAmountValues = parseFloat(0);
	for (i = 1; i <= document.getElementById('poListSize').value; i++) {
		if (document.getElementById('idItem' + i) != null) {
			if (document.getElementById('idItem' + i).value.trim() != 0) {
				rowAmt = isNaN(parseFloat(document.getElementById('amtVar' + i).value)) == true ? 0
						: parseFloat(document.getElementById('amtVar' + i).value);

				if (parseFloat(tempNetValue) > 0 && parseFloat(rowAmt) > 0)
					additionalTax = (parseFloat(charge) / parseFloat(tempNetValue))
							* parseFloat(rowAmt);

				rowAmt = rowAmt + additionalTax;
				tempRowAmountValues = tempRowAmountValues + rowAmt;
				// updated by shailesh
				convertedStock = isNaN(parseFloat(document
						.getElementById('convertedStock' + i).value)) == true ? "0"
						: parseFloat(document.getElementById('convertedStock'
								+ i).value);
				if (convertedStock > 0)
					costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
				else
					costPrice = parseFloat(0);
				document.getElementById('costPrice' + i).value = roundVal(
						costPrice, 3);
			}
		}
	}

	// Calculate Total Amount
	tempNetValue = parseFloat(0);

	for (i = 1; i <= document.getElementById('poListSize').value; i++) {
		if (document.getElementById('idItem' + i) != null) {
			if (document.getElementById('idItem' + i).value.trim() != 0) {
				var freeItem = document.getElementById('freeItem' + i).value;
				if (freeItem == 'n')
					tempNetValue = parseFloat(tempNetValue)
							+ parseFloat(document.getElementById('amtVar' + i).value);

			}
		}
	}

	// document.getElementById('grnValue').value=roundVal(tempNetValue,2);

	var actualValue = roundVal(tempRowAmountValues, 2);
	var valueAfterRounding = roundNumber(tempRowAmountValues, 0);

	var roundOffAmount = valueAfterRounding - actualValue;

	if (vatApplicable.checked) {
		var vat = parseFloat(0);
		vat = document.getElementById('vatTax').value;
		var vatgrn = parseFloat(0);
		if (vat == "") {
			vat = parseFloat(0);
		}

		var vatgrn1 = parseFloat(valueAfterRounding) + parseFloat(vat);
		vatgrn = roundVal(vatgrn1, 0);
		roundOffAmount = vatgrn1 - vatgrn;

		document.getElementById('grnValue').value = vatgrn

	} else {
		document.getElementById('grnValue').value = valueAfterRounding
	}

	// document.getElementById('grnValue').value=valueAfterRounding
	roundOffAmount = roundVal(roundOffAmount, 3);
	document.getElementById('roundOfValue').value = roundOffAmount
	document.getElementById('actualGrnValue').value = actualValue
}
function validateGridData() {
	var pageNo = document.getElementById("pageNo").value;
	var fisrtIndex = 1;
	var lastIndex = 8;
	if (pageNo != 1) {
		fisrtIndex = parseInt(8 * (pageNo - 1)) + parseInt(1);
		lastIndex = 8 * pageNo;

	}
	for (var inc = fisrtIndex; inc <= lastIndex; inc++) {
		// var mrp=document.getElementById("mrp"+inc).value;
		// var
		// dispensingPrice=document.getElementById("dispensingPrice"+inc).value;
		var itemName = document.getElementById("nameItem" + inc).value
		var batchNoVarTemp = document.getElementById("batchNoVarTemp" + inc).value
		var manufactureDateVarTemp = document
				.getElementById("manufactureDateVarTemp" + inc).value
		var expDateVarTemp = document.getElementById("expDateVarTemp" + inc).value
		var qtyVarTemp = document.getElementById("qtyVarTemp" + inc).value
		var unitRateVarTemp = document.getElementById("unitRateVarTemp" + inc).value
		var amountVarTemp = document.getElementById("amountVarTemp" + inc).value
		/*
		 * if(mrp==""&&itemName!=""){ alert("pls cheack the mrp in row "+inc);
		 * document.getElementById("mrp"+inc).focus(); return false; }
		 * if(dispensingPrice==""&&itemName!=""){ alert("pls cheack the
		 * dispensingPrice in row "+inc);
		 * document.getElementById("dispensingPrice"+inc).focus(); return false; }
		 */
		if (batchNoVarTemp == "" && itemName != "") {
			alert("pls cheack the batch No in row " + inc);
			document.getElementById("batchNoVarTemp" + inc).focus();
			return false;

		}
		if (manufactureDateVarTemp == "" && itemName != "") {
			alert("pls cheack the Manufature date in row " + inc);
			document.getElementById("manufactureDateVarTemp" + inc).focus();
			return false;

		}
		if (expDateVarTemp == "" && itemName != "") {
			alert("pls cheack the expiry date in row " + inc);
			document.getElementById("expDateVarTemp" + inc).focus();
			return false;

		}
		if (qtyVarTemp == "" && itemName != "") {
			alert("pls cheack the qty. in row " + inc);
			document.getElementById("qtyVarTemp" + inc).focus();
			return false;

		}
		if (unitRateVarTemp == "" && itemName != "") {
			alert("pls cheack the unit rate. in row " + inc);
			document.getElementById("unitRateVarTemp" + inc).focus();
			return false;

		}
		if (amountVarTemp == "" && itemName != "") {
			alert("pls cheack the Amount. in row " + inc);
			document.getElementById("amountVarTemp" + inc).focus();
			return false;

		}
		/*
		 * if(dispensingPrice>mrp&&itemName!=""){ alert("dispensing price cant
		 * be greater than Mrp in row "+inc)
		 * document.getElementById("dispensingPrice"+inc).focus(); return false; }
		 */

	}
	return true;
}

function openPopupForItemIssue(issuedItem, qtyRequested, rowVal, issueId,
		detailId) {
	/*
	 * if((parseFloat(document.getElementById("qtyIssued"+rowVal).value) > 0 &&
	 * document.getElementById("qtyIssued"+rowVal).value != "")&&
	 * document.getElementById("barCodeNo"+rowVal).value==""){ alert("Already
	 * Issued..!") return false }
	 */
	var nomenclature = document.getElementById("itemName" + rowVal).value
	var pvms = document.getElementById("itemCode" + rowVal).value;
	var qtyReq = document.getElementById("qtyRequest" + rowVal).value;
	if (nomenclature != "" && pvms != "" && qtyReq != "") {
		var itemId = document.getElementById("itemId" + rowVal).value;
		var issueId = document.getElementById("issueId").value
		var url = "/hms/hms/stores?method=openItemBrandWindowJsp&itemId="
				+ itemId + "&rowVal=" + rowVal + "&flag=withoutIndent&issueId="
				+ issueId + "&qtyRequest=" + qtyRequested + "&issuedItemId="
				+ itemId;
		popwindow(url);
	} else {

		if (nomenclature == "" && pvms == "")
			alert("Please Enter Item Code Or Item Name to view Stock details");
		else if (qtyReq == "" || qtyReq == "0") {
			alert("Please Enter Requested Qty.")
		}

	}
}

function openPopupForItemIssueForPatient(issuedItem, qtyRequested, rowVal,
		issueId, detailId,csrfToken,csrfValue) {
	if ((parseFloat(document.getElementById("qtyIssued" + rowVal).value) >= parseFloat(document
			.getElementById("qtyRequest" + rowVal).value) && document
			.getElementById("qtyIssued" + rowVal).value != "")) {
		alert("Already Issued..!")
		return false
	}
	var nomenclature = document.getElementById("itemName" + rowVal).value
	// var pvms=document.getElementById("itemCode"+rowVal).value;
	var qtyReq = document.getElementById("qtyRequest" + rowVal).value;
	if (nomenclature != "" && qtyReq != "") {
		var itemId = document.getElementById("itemId" + rowVal).value;
		var issueId = document.getElementById("issueId").value
		var visitId = document.getElementById("visitId" + rowVal).value
		var presId = document.getElementById("presId" + rowVal).value
		var qtyPending = document.getElementById("qtyPending" + rowVal).value
		var totalRow = document.getElementById("hiddenValueCharge").value 
		var url = "/hms/hms/stores?method=openItemBrandWindowForDrugIssueJsp&itemId="
				+ itemId
				+ "&rowVal="
				+ rowVal
				+ "&issueId="
				+ issueId
				+ "&qtyRequest="
				+ qtyReq
				+ "&issuedItemId="
				+ itemId
				+ "&visitId="
				+ visitId
				+ "&presId="
				+ presId
				+ "&itemName="
				+ nomenclature 
				+ "&totalRow="
				+ totalRow 
				+ "&qtyPending=" + qtyPending+"&"+csrfToken+"="+csrfValue;
		popwindow(url);
	} else {
		alert("Not Allow !");
	}
}
function openPopupForItemIssueForPatientNext(formName, qtyRequested, rowVal,
		issueId, detailId) {
	if ((parseFloat(document.getElementById("qtyIssued" + rowVal).value) >= parseFloat(document
			.getElementById("qtyRequest" + rowVal).value) && document
			.getElementById("qtyIssued" + rowVal).value != "")) {
		alert("Already Issued..!")
		return false
	}
	var nomenclature = document.getElementById("itemName" + rowVal).value
	// var pvms=document.getElementById("itemCode"+rowVal).value;
	var qtyReq = document.getElementById("qtyRequest" + rowVal).value;
	if (nomenclature != "" && qtyReq != "") {
		var itemId = document.getElementById("itemId" + rowVal).value;
		var issueId = document.getElementById("issueId").value
		var visitId = document.getElementById("visitId" + rowVal).value
		var presId = document.getElementById("presId" + rowVal).value
		var qtyPending = document.getElementById("qtyPending" + rowVal).value
		var totalRow = document.getElementById("hiddenValueCharge").value 
		var url = "/hms/hms/stores?method=openItemBrandWindowForDrugIssueJsp&itemId="
				+ itemId
				+ "&rowVal="
				+ rowVal
				+ "&issueId="
				+ issueId
				+ "&qtyRequest="
				+ qtyReq
				+ "&issuedItemId="
				+ itemId
				+ "&visitId="
				+ visitId
				+ "&presId="
				+ presId
				+ "&itemName="
				+ nomenclature 
				+ "&totalRow="
				+ totalRow 
				+ "&qtyPending=" + qtyPending; 
		obj=eval('document.'+formName);
		obj.action = url;
	    obj.submit(); 
	} else {
		alert("Not Allow !");
	}
}
function getAllOTCMedicine() { 
		var url = "/hms/hms/opd?method=getItemListForAutoCompleteItemOTC";
		popwindow(url); 
}
// -------Code By Mukesh 11 March 2011
var groupByItemArray = new Array();
function populateGroupByItem(val, formName) {
	obj = eval('document.' + formName + '.itemId');
	obj.length = 1;

	for (i = 0; i < groupByItemArray.length; i++) {
		if (groupByItemArray[i][0] == val) {
			obj.length++;
			obj.options[obj.length - 1].value = groupByItemArray[i][1];
			obj.options[obj.length - 1].text = groupByItemArray[i][2];
		}
	}
}

// -------Code By Mukesh 01 Apr 2011
var batchItemArray = new Array();
function populateItemBatch(val, formName) {
	obj = eval('document.' + formName + '.batchId');
	obj.length = 1;

	for (i = 0; i < batchItemArray.length; i++) {
		if (batchItemArray[i][0] == val) {
			obj.length++;
			obj.options[obj.length - 1].value = batchItemArray[i][1];
			obj.options[obj.length - 1].text = batchItemArray[i][2];
		}
	}
}

var empArr = new Array();

function populateEmp(val, formName) {
	obj = eval('document.' + formName + '.requestBy');
	obj.length = 1;
	for (i = 0; i < empArr.length; i++) {
		if (empArr[i][0] == val) {
			obj.length++;
			obj.options[obj.length - 1].value = empArr[i][1];
			obj.options[obj.length - 1].text = empArr[i][2];
		}
	}
}

/*
 * function calculateIndentQty(inc) { var incrementalPercentage =0; var
 * previousYearConsumption =0; var incrementalqty = 0; var requiredQty = 0; var
 * demandedQty = 0; var additionalQty = 0; var leadTime = 0; var
 * consumptionInleadTime = 0; var pendingIndentQty = 0; var stock = 0; var
 * requiredQty = 0; if
 * (!isNaN(document.getElementById('incrementalPercentageId'+inc).value))
 * incrementalPercentage =
 * parseFloat(document.getElementById('incrementalPercentageId'+inc).value); if
 * (!isNaN(document.getElementById('previousYearConsumptionId'+inc).value))
 * previousYearConsumption =
 * parseFloat(document.getElementById('previousYearConsumptionId'+inc).value);
 * if (!isNaN(document.getElementById('additionalQtyId'+inc).value))
 * additionalQty =
 * parseFloat(document.getElementById('additionalQtyId'+inc).value); if
 * (!isNaN(document.getElementById('leadTimeId'+inc).value)) leadTime =
 * parseFloat(document.getElementById('leadTimeId'+inc).value); if
 * (!isNaN(document.getElementById('pendingIndentQtyId'+inc).value))
 * pendingIndentQtyId =
 * parseFloat(document.getElementById('pendingIndentQtyId'+inc).value); if
 * (!isNaN(document.getElementById('stock'+inc).value)) stock =
 * parseFloat(document.getElementById('stock'+inc).value);
 * 
 * if(!isNaN(previousYearConsumption) != "" && !isNaN(incrementalPercentage)!=
 * ""){ incrementalqty
 * =Math.round(previousYearConsumption*incrementalPercentage)/100;
 * document.getElementById('incrementalQtyId'+inc).value = incrementalqty; }
 * if(!isNaN(incrementalqty) != "" && !isNaN(previousYearConsumption)!= ""){
 * requiredQty =incrementalqty+previousYearConsumption;
 * document.getElementById('requiredQtyId'+inc).value = requiredQty; }
 * if(!isNaN(requiredQty) != "" && !isNaN(additionalQty)!= ""){ demandedQty
 * =requiredQty+additionalQty; document.getElementById('qtyRequest'+inc).value =
 * demandedQty; } if(!isNaN(previousYearConsumption) != "" || !isNaN(leadTime)!=
 * ""){ consumptionInleadTime =Math.round(previousYearConsumption*leadTime/365);
 * document.getElementById('consumptionInLeadTimeId'+inc).value =
 * consumptionInleadTime; } if(!isNaN(pendingIndentQty) != "" ||
 * !isNaN(previousYearConsumption)!= "" && !isNaN(incrementalqty)!= "" &&
 * !isNaN(consumptionInleadTime)!= "" && !isNaN(stock)!= ""){ requiredQty
 * =(previousYearConsumption+incrementalqty+consumptionInleadTime)-(stock+pendingIndentQty);
 * document.getElementById('requiredQtyId'+inc).value = requiredQty; } }
 */
