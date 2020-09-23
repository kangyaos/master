//公共对象
var common = common || {};

//ajax封装
common.call = function (url, data, type, successCallback, errorCallback, jsonData) {
    //默认参数
    var defaults = {
        type: 'get',
        dataType: 'json',
        // jsonp: 'callback',
        async: true,
        cache: false,
        // xhrFields: {
        //     withCredentials: true
        // },
        // crossDomain: true,
        title: 'defaultTitle',
        timeout: 20000,
        error: function () { },
        success: function () { }
    };

    //传入参数
    var options = {
        url: url,
        type: type,
        data: data,
        //async: async,
        error: errorCallback,
        success: successCallback
    };
    //与传入参数合并
    var settings = $.extend({}, defaults, options);
    //判断是否是jsonp
    if (settings.dataType.toLowerCase() == "jsonp") {
        if (settings.url.indexOf('?') >= 0)
            settings.url = settings.url + "&callback=?";
        else
            settings.url = settings.url + "?callback=?";
    }
    if (settings.url.indexOf('?') >= 0)
        settings.url = settings.url + "&bust=" + (new Date()).getTime();
    else
        settings.url = settings.url + "?bust=" + (new Date()).getTime();

    //var request = $.ajax(options);
    if (jsonData != undefined && jsonData != '' && jsonData.Success != undefined) {
        if (typeof settings.success === "function") {
            settings.success(jsonData);
        }
        return;
    }

    //开始执行ajax
    $.ajax({
        type: settings.type,
        dataType: settings.dataType,
        async: settings.async,
        // jsonp: settings.jsonp,
        cache: settings.cache,
        // xhrFields: settings.xhrFields,
        // crossDomain: settings.crossDomain,
        url: settings.url,
        data: settings.data,
        timeout: 60000,

        success: function (resp) { //成功
            if (typeof settings.success === "function") {
                settings.success(resp);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { //失败
            // bootbox.alert('error:'+textStatus+errorThrown);
            if (typeof settings.error === "function") settings.error(XMLHttpRequest, textStatus, errorThrown);
        }
    });
};




function reinitIframe(iframeId, minHeight) {
    var browserVersion = window.navigator.userAgent.toUpperCase();
    var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
    var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
    var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
    var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
    var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
    var isIE9More = (! -[1, ] == false);
    try {
        var iframe = document.getElementById(iframeId);
        var bHeight = 0;
        if (isChrome == false && isSafari == false)
            bHeight = iframe.contentWindow.document.body.scrollHeight;

        var dHeight = 0;
        if (isFireFox == true)
            dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
        else if (isIE == false && isOpera == false)
            dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
        else if (isIE == true && isIE9More) {//ie9+
            var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
            if (heightDeviation == 0) {
                bHeight += 3;
            } else if (heightDeviation != 3) {
                eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                bHeight += 3;
            }
        }
        else//ie[6-8]、OPERA
            bHeight += 3;

        var height = Math.max(bHeight, dHeight);
        if (height < minHeight) height = minHeight;
        iframe.style.height = height + "px";
    } catch (ex) { }
}
//iframe自适应子页面高度
common.iframeAutoHeight = function (iframeId, minHeight) {
    eval("window.IE9MoreRealHeight" + iframeId + "=0");
    window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
}


//检测IE6、IE7、IE8、IE9浏览器
common.checkIE8 = function () {
    if (navigator.appName == "Microsoft Internet Explorer") {
        var ieVer = navigator.appVersion.split(";")[1].replace(/[ ]/g, "");
        if (ieVer == "MSIE6.0" || ieVer == "MSIE7.0" || ieVer == "MSIE8.0" || ieVer == "MSIE9.0") {
            return true;
        }
    }
    else {
        return false;
    }
}

//检测IE6、IE7浏览器
common.checkIE6 = function () {
    if (navigator.appName == "Microsoft Internet Explorer") {
        var ieVer = navigator.appVersion.split(";")[1].replace(/[ ]/g, "");
        if (ieVer == "MSIE6.0" || ieVer == "MSIE7.0") {
            return true;
        }
    }
    else {
        return false;
    }
}

//页面统计开始
//common.call('/StudentCenter/Share/LoadPage', '', 'get', function (data) {
//    console.log(data);
//}, errorlog, '');

function errorlog() {

}

//window.onbeforeunload = function (e)//绑定刷新等事件
//{
//    var message = '确定离开'//设定提示消息
//    if ('Netscape' == navigator.appName) return e.preventDefault(), message//针对Netscape内核的提示方式,阻止默认动作 後返回提示消息即可
//    window.event.returnValue = message//针对IE等的提示方式
//}

