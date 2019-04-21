
var $j = jQuery.noConflict();
/*$j(document).ready(function(){
	
	
	$j('#fromdate-pick').datepicker({ showOn: "button",
		buttonImage: "/erp/jsp/images/calendar.gif",		
		buttonImageOnly: true,
		buttonText: 'Select Date',
		yearRange: '1900:2090',selectWeek:false,closeOnSelect:true,  changeMonth: true, changeYear: true,clickInput:true});
	
	$j('#todate-pick').datepicker({ showOn: "button",
		buttonImage: "/erp/jsp/images/calendar.gif",		
		buttonImageOnly: true,
		buttonText: 'Select Date',
		yearRange: '1900:2090',selectWeek:false,closeOnSelect:true,  changeMonth: true, changeYear: true,clickInput:true});

	$j('body').on("focus",".input_date", function() {
    	
    	 $j(this).datepicker({ showOn: "button",
    			buttonImage: "/erp/jsp/images/calendar.gif",		
    			buttonImageOnly: true,
    			yearRange: '1900:2090',selectWeek:false,closeOnSelect:true,  changeMonth: true, changeYear: true,clickInput:false});    
 				
 		
    }); 
	
	$j('body').on("focus",".calDate", function() {
    	
   	 $j(this).datepicker({ showOn: "button",
   			buttonImage: "/erp/jsp/images/calendar.gif",		
   			buttonImageOnly: true,
   			yearRange: '1900:2090',selectWeek:false,closeOnSelect:true,  changeMonth: true, changeYear: true,clickInput:false});       
		
		
		
   }); 
	
	$j(".calDate").datepicker({ showOn: "button",
		buttonImage: "/erp/jsp/images/calendar.gif",		
		buttonImageOnly: true,
		buttonText: 'Select Date',
		yearRange: '1900:2090',selectWeek:false,closeOnSelect:true,  changeMonth: true, changeYear: true,clickInput:true});
	
});
*/

function removeRow(tableId,extraFunc)
{
	
	var valCheckBox = new Array();
	$j('[id="chk"]:checked').each(function(j)
			{
				
				valCheckBox[j] = $j(this).val();
			});
	//alert(valCheckBox);
	if(valCheckBox == "")
		alert("Please select the rows that you want to delete.");
	
	for(var i=0;i<valCheckBox.length;i++)
		{
		
			$j("#"+tableId+" tr[id='"+valCheckBox[i]+"']").remove();
		}
	var valRowId = new Array();
	$j("#"+tableId+" tr[id!='th']").each(function(j)
			{
				valRowId[j] =$j(this).attr("id");
			});
	$j("#tableRowId").val(valRowId);
	eval(extraFunc); 
}

function checkAll()
{	
	if($j('#chkAll').prop("checked") == "true" || $j('#chkAll').prop("checked") == true || $j('#chkAll').prop("checked") == "checked")
	{
		
		$j('[id="chk"]:checkbox').prop("checked","checked");	
		
	}
	else
	{		
		
		$j('[id="chk"]:checkbox').removeAttr("checked");
	}
	
}

function createPaginating(NumberOfPages)
{
	
	nPageNo = 1 * nPageNo;
	var nextValue = nPageNo + 1;
	var PreValue = nPageNo - 1;
	if(NumberOfPages>0)
		{
		  $j("#resultnavigation").append("<input class=\"previous\" type=\"button\"  value=\"f\" name=\"firstpage\" onclick=\"showResultPage('1')\" >");
		  $j("#resultnavigation").append("<input class=\"singlePrev\" type=\"button\"  value=\"f\" name=\"prevpage\"  onclick=\"showResultPage('"+PreValue+"')\" >");
		  $j("#resultnavigation").append("Page <span id=\"current\">"+nPageNo+"</span> of <span id=\"total\">"+NumberOfPages+"</span>");
		  $j("#resultnavigation").append("<input class=\"singleNext\" type=\"button\"  value=\"f\" name=\"nextpage\"  onclick=\"showResultPage('"+nextValue+"')\">");
		  $j("#resultnavigation").append("<input class=\"next\" type=\"button\"  value=\"f\" name=\"lastpage\" onclick=\"showResultPage("+NumberOfPages+")\">"); 		 
		   
		}
}
function DoEnableDisabledPaging(NumberOfPages)
{
	
	if(nPageNo == 1 && nPageNo >0 )
		{
			$j(".previous").addClass("previousDisable");
			$j(".singlePrev").addClass("singlePrevDisable");
			$j(".previous").attr("disabled","disabled");
			$j(".singlePrev").attr("disabled","disabled");
		}
	
	if(nPageNo == NumberOfPages)
	{		
		$j(".next").addClass("nextDisable");
		$j(".singleNext").addClass("singleNextDisable");
		$j(".next").attr("disabled","disabled");
		$j(".singleNext").attr("disabled","disabled");
	}
		
}

function GetJsonData(tableId,data,url,bClickable,waitingImgId)
{
	
	$j("#"+waitingImgId).show();
	/*.ajaxStart(function(){	
		alert(this);
		$j(this).show();
	})
	.ajaxComplete(function(){	
		$j(this).hide();
		
	});*/
	$j('.SearchStatus').css('color','green');
	$j('.SearchStatus').html(S_Search_Searching);
	$j("#resultnavigation").html("");
			$j.ajax({
				type:"POST",
				url: url,
				data: data,	
				dataType: "json",			
				cache: false,
				success: function(msg)
				{
					$j("#"+waitingImgId).hide();
					var jsonData = msg;		
						
							var totalMatches = jsonData.length;
							var totalRecordsForPagination = 0;
							
							if(totalMatches>0)
								{
									totalRecordsForPagination = jsonData[0].totalRecords;
								}
							var NumberOfPages = Math.ceil(totalRecordsForPagination/10);
							
							createPaginating(NumberOfPages);
							
							DoEnableDisabledPaging(NumberOfPages);	
							
							
							if(NumberOfPages == 1)
								{
									$j("#resultnavigation").html("");
								}
							if(totalRecordsForPagination == 0)
								{									
									$j('.SearchStatus').html(S_Search_NoMatches);
								}
							 if(totalRecordsForPagination == 1)
								{
									$j('.SearchStatus').html(totalRecordsForPagination + " " +S_Search_Single_Match);	
								}	
							 if(totalRecordsForPagination > 1)
								{
									$j('.SearchStatus').html(totalRecordsForPagination + " " +S_Search_Multi_Matches);	
								}	
							  
							  makeTable(jsonData);
							  if(totalRecordsForPagination != 0 && bClickable )
								  {
									  $j("#"+tableId+" tr[id!='0']").hover(
										      function () {										          
										          $j(this).css("background-color", "#EDF4DA");		
										          if(bClickable == true)
										        	  {
										        	  	$j(this).css("cursor","pointer");
										        	  }
										        }, 
										        function () {
										        
										          $j(this).css("background-color", "");
										        }
											)
											.click(
												function(){
													if(bClickable == true)
														{
															executeClickEvent($j(this).attr("id"));
														}
												}
											);
								  }
							 
							
						
					
				},
				error: function(msg)
				{					
					
					alert("An error has occurred while contacting the server");
					$j('.SearchStatus').css('color','red');
					$j('.SearchStatus').html(S_Search_Error);
					$j("#"+waitingImgId).hide();
					
				}
				
				
			});
}

function removeRow_FromDatabase(tableId,ObjectName,headerId,extraFunc)
{
	//alert(headerId);
	var valCheckBox = new Array();
	$j('[id="chk"]:checked').each(function(j)
			{
				
				valCheckBox[j] = $j(this).val();
			});
	//alert(valCheckBox);
	if(valCheckBox == "")
		{
			alert("Please select the rows that you want to delete.");
			return;
		}
	
	if(confirm("Are you sure you want to delete the details?"))
	{		
		DeleteFromDatabase_AddRemoveGrid(tableId,ObjectName,valCheckBox,headerId,extraFunc);	   
		
	}
	else
		{				
			return;
		}
	
	
} 

function DeleteFromDatabase_AddRemoveGrid(tableId,ObjectName,valCheckBox,headerId,extraFunc)
{	
	var data = "valCheckBox="+valCheckBox+"&ObjectName="+ObjectName+"&headerId="+headerId;
	
	//alert(data+tableId+headerId);
	
		
	$j("#imgRemoveDetails").show();
	
	
	$j.ajax({
		type:"GET",
		data: data,
		url:'marketing?method=DeleteFromDatabase_AddRemoveGrid',		
		cache: false,
		success: function(msg)
		{			
			if(msg.indexOf("success~~") != -1)
				{					
					for(var i=0;i<valCheckBox.length;i++)
					{		   
					   
					   $j("#"+tableId+" tr[id='"+valCheckBox[i]+"']").remove();   	
						
					}
					
					eval(extraFunc);
				}
			else
				{
					alert("Not Delete");
				}
			$j("#imgRemoveDetails").hide();
					
		},
		error: function(msg)
		{		
			alert("Some error Occured. Please try again.")
			$j("#imgRemoveDetails").hide();
		}
			
		
	});
}

function checkDuplicateItemInGrid(data, itemId,itemName)
{
 
	var data = ""+data+""; 	
	var arry = new Array();
	arry = data.split(",");
	bDuplicate = false;
	
	var counter = 0;
	
	for(i=0;i<arry.length;i++)
		{	
			var tempValue = $j("#"+itemId+arry[i]).val();
			
		           for(var j=0;j<arry.length;j++)
		        	   {
		        	   if(i != j)
		        		   {		        		       
								if(tempValue == $j("#"+itemId+arry[j]).val())
								{
									if(itemName == undefined)
										{
											alert("You have inserted the duplicate entry.");
										}
									else
										{
											alert("You have inserted the duplicate "+itemName+".");
										}
									
									bDuplicate = "true";									
									return false;									
								}
		        		   }
		        	   }
			
		}
	return true;
	
}