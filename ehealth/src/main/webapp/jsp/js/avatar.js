var gCtx = null;
var gCanvas = null;

var imageData = null;
var imageDataBuffer = null;
var ii=0;
var jj=0;
var c=0;

var background = false;

function pageLoad() { 
	initCanvas(320,240);
}

function initCanvas(ww,hh) {
	gCanvas = document.getElementById("canvas");
	var w = ww;
	var h = hh;
	gCanvas.style.width = w + "px";
	gCanvas.style.height = h + "px";
	gCanvas.width = w;
	gCanvas.height = h;
	gCtx = gCanvas.getContext("2d");
	gCtx.clearRect(0, 0, w, h);
	imageData = gCtx.getImageData(0, 0, 320, 240);
	imageDataBuffer = gCtx.getImageData(0, 0, 320, 240);
}

function passLine(stringPixels) {
	
	var coll = stringPixels.split("-");

	for(var i=0;i<320;i++) { 
		var intVal = parseInt(coll[i]);
		r = (intVal >> 16) & 0xff;
		g = (intVal >> 8) & 0xff;
		b = (intVal ) & 0xff;
		if(background) { 
			imageDataBuffer.data[c+0]=r;
			imageDataBuffer.data[c+1]=g;
			imageDataBuffer.data[c+2]=b;
			imageDataBuffer.data[c+3]=255;
		}
		c+=4;
	} 

	if(c>=320*240*4) {
		c=0;
		gCtx.putImageData(imageDataBuffer, 0,0);
	} 
} 

function captureToCanvasBackground() {
	background = true;
	alert("document.getElementById(embedflash)--"+document.getElementById("embedflash"));
	flash = document.getElementById("embedflash");
	flash.ccCapture();
	document.getElementById("camArea").style.display="none";
	document.getElementById("canvasArea").style.display="block";
	salvarAvatar();
}

function salvarAvatar() {
	document.getElementById("hdImagem").value = document.getElementById("canvas").toDataURL();
	document.getElementById("frmImagem").submit();
}