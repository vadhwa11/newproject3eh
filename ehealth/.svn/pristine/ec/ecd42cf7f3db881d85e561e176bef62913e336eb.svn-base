<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">


  <title>WEB CAM</title>
  
<script type="text/javascript" src="/hms/jsp/javascript/avatar.js"></script>
<link href="/hms/jsp/css/webcam_style.css" rel="stylesheet" type="text/css" />
</head><body onload="pageLoad();">
<div class="container">
  
    <h2>Face Detection</h2>
  
    <div id="camArea">
      <object id="iembedflash" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="320" height="240">
	      <param name="movie" value="camcanvas.swf">
	      <param name="quality" value="high">
	      <param name="allowScriptAccess" value="always">
	      <embed allowscriptaccess="always" id="embedflash" src="/hms/jsp/css/camcanvas.swf" quality="high" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" mayscript="true" width="320" height="240">
      </object> <br>
      <button onclick="captureToCanvasBackground();">Capture</button>
    </div>
    
    <div id="canvasArea" style="display: none;">      
      <canvas style="width: 320px; height: 240px;" id="canvas" width="320" height="240"></canvas> <br>
      <img src="/hms/jsp/css/loader.gif" alt="loading...">
    </div>
</div>

<form method="post" action="salvar.php" id="frmImagem">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <input name="imagem" id="hdImagem" type="hidden">
</form>

</body></html>