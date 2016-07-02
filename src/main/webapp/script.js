function getXmlHttp(){
  var xmlhttp;
  try {
    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
  } catch (e) {
    try {
      xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } catch (E) {
      xmlhttp = false;
    }
  }
  if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
    xmlhttp = new XMLHttpRequest();
  }
  return xmlhttp;
}

function mode()
  {
            try{var req = getXmlHttp();
            req.open('POST', '/AeroProject/servletUse/', true);
            req.onreadystatechange = function() {
                  if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                       $('#display').load('mode.html');
                    } else alert( req.status + ': ' + req.statusText );
                  };
            var a = document.getElementById("someid").value;
            req.send(a);

            return true;}catch(exception){alert("Damn")}
  }