/************************************************************************************************************
 DuanJunjun XmlHttp
 ************************************************************************************************************/
var GlobalXmlHttpObj
var GlobalXmlHttpCallFun
function XmlHttp()
{
    this.XmlHttpObj;
    this.Init();
}
XmlHttp.prototype = {
    Init: function () {
        if (window.XMLHttpRequest) {
            this.XmlHttpObj = new XMLHttpRequest();
        }
        if (!this.XmlHttpObj && window.ActiveXObject) {
            try {
                this.XmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP")
            } catch (e) {
                try {
                    this.XmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP.5.0")
                }
                catch (e) {
                    try {
                        this.XmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP.4.0")
                    }
                    catch (e) {
                        try {
                            this.XmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP")
                        }
                        catch (e) {

                        }
                    }
                }
            }
        }
        GlobalXmlHttpObj = this.XmlHttpObj;
    }
    ,
    DownloadString: function (url) {
        this.XmlHttpObj.onreadystatechange = function () { };
        this.XmlHttpObj.open("GET", url, false);
        this.XmlHttpObj.send(null);
        if (this.XmlHttpObj.readyState == 4 && this.XmlHttpObj.status == 200) {
            return this.XmlHttpObj.responseText;
        }
        return "";
    }
    ,
    AsyncDownloadString: function (url, callFun) {
        this.XmlHttpObj.open("GET", url, false);
        GlobalXmlHttpCallFun = callFun;
        this.XmlHttpObj.onreadystatechange = this.CallXhFuncation;
        this.XmlHttpObj.send(null);

    }
    ,
    CallXhFuncation: function () {
        if (GlobalXmlHttpObj.readyState == 4) {
            if (GlobalXmlHttpObj.status == 200) {
                var text = GlobalXmlHttpObj.responseText;
                GlobalXmlHttpCallFun(text);
            }
        }
    }
}