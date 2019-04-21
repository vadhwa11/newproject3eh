

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<div id="contentspace">
<form name="message" action="" method="post" />
<h2><font id="error"><c:out
	value="${map.messageTOBeVisibleToTheUser}" /></font></h2>

<c:choose>
	<c:when test="${map.error!=null}">
		<input type="button" name="back" value="Back" class="button"
			onclick="submitForm('message','stores?method=showPhysicalStockJsp');" />
	</c:when>
</c:choose>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	
</div>
