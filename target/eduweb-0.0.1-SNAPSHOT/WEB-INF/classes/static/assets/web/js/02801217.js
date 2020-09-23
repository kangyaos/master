$(function(){
	imgLazyloadLib();
	//代码创建一个遮罩层，用于做加载动画
	//setScroll();
	setEventListen();
})
$(window).load(function(){
	diyAutoHeight();
	imgLazyloadLib();
});
$(window).resize(function(){
	if(window.resizeTimeout)window.clearTimeout(window.resizeTimeout);
	window.resizeTimeout=setTimeout(function(){
		diyAutoHeight();
	},350);
});
function imgLazyloadLib(obj){
	if(obj){
		obj.lazyload({event:'scroll mouseover',effect: "fadeIn",threshold:0,failure_limit:80,skip_invisible:false,load:function(){
			var father=$(this).parents('.view').first();
			if(father.length>0){
				setTimeout(function(){diyAutoHeight(father);},500);
			}else{
				father=$(this).parents('.layout').first();
				if(father.length>0){
					setTimeout(function(){diyAutoHeight(father);},500);
				}
			}
		}});
	}else{
		$("img").lazyload({event:'scroll mouseover',effect: "fadeIn",threshold:0,failure_limit:80,skip_invisible:false,load:function(){
			var father=$(this).parents('.view').first();
			if(father.length>0){
				setTimeout(function(){diyAutoHeight(father);},500);
			}else{
				father=$(this).parents('.layout').first();
				if(father.length>0){
					setTimeout(function(){diyAutoHeight(father);},500);
				}
			}
		}});
	}
}
var scrollTime=300;
function setEventListen(){
	$(".ev_c_scrollTop").click(function(){
		//滚动到顶部
		//$("html").getNiceScroll().resize();
		//$("html").getNiceScroll(0).doScrollTop(0);
		$("html,body").stop().animate({scrollTop:"0px"},window.scrollTime);
	});
	$(".ev_c_scrollView").click(function(){
		//鼠标点击：滚动到模块位置
		var settings=settingsLib($(this));
		var viewid=settings.getSetting('eventSet.scrollView');
		if($("#"+viewid).length>0){
			//$("html").getNiceScroll().resize();
			//$("html").getNiceScroll(0).doScrollTop($("#"+viewid).offset().top);
			$("html,body").stop().animate({scrollTop:$("#"+viewid).offset().top+"px"},window.scrollTime);
		}
	});
	$(".ev_c_showView").click(function(){
		//鼠标点击：显示模块
		showEventView($(this));
	});
	$(".ev_c_hidView").click(function(){
		//鼠标点击：隐藏模块
		hidEventView($(this));
	});
	$(".ev_c_tabView").click(function(){
		//鼠标点击：显示与隐藏模块
		showHidEventView($(this));
	});
	$(".ev_m_tabView").hover(function(){
		//鼠标点击：显示与隐藏模块
		showHidEventView($(this));
	});
	$(".view").click(function(){
		$(this).children(".view_contents").addClass("diyCurTab");
		var settings=settingsLib($(this));
		var unitViewSet=settings.getSetting('unitViewSet');
		if(unitViewSet&&unitViewSet.length>0){
			for(key in unitViewSet){
				$("#"+unitViewSet[key]).children(".view_contents").removeClass("diyCurTab");
			}
		}
	});
}
function showHidEventView(obj){
	var settings=settingsLib(obj);
	var showViews=settings.getSetting('eventSet.showViews');
	var hidViews=settings.getSetting('eventSet.hidViews');
	if(!showViews)showViews=new Array();
	if(!hidViews)hidViews=new Array();
	var doubleKey=new Array();
	//获取重复值
	if(showViews.length>0){
		for(s_key in showViews){
			if(hidViews.length>0){
				for(h_key in hidViews){
					if(showViews[s_key]==hidViews[h_key]){
						doubleKey.push(showViews[s_key]);
					}
				}
			}
		}
	}
	//隐藏
	if(hidViews.length>0){
		for(key in hidViews){
			if($.inArray(hidViews[key],doubleKey)<0){
				$("#"+hidViews[key]).css({"display":"none"});
				diyAutoHeight($("#"+hidViews[key]));
			}
		}
	}
	//显示
	if(showViews.length>0){
		for(key in showViews){
			if($.inArray(showViews[key],doubleKey)<0){
				$("#"+showViews[key]).css({"display":"block"});
				diyAutoHeight($("#"+showViews[key]));
			}
		}
	}
	//双向显示
	if(doubleKey.length>0){
		for(key in doubleKey){
			if($("#"+doubleKey[key]).length>0){
				if($("#"+doubleKey[key]).is(":hidden")){
					$("#"+doubleKey[key]).css({"display":"block"});
					diyAutoHeight($("#"+doubleKey[key]));
				}else{
					$("#"+doubleKey[key]).css({"display":"none"});
					diyAutoHeight($("#"+doubleKey[key]));
				}
			}
		}
	}
}
function showEventView(obj){
	var settings=settingsLib(obj);
	var showViews=settings.getSetting('eventSet.showViews');
	if(!showViews)showViews=new Array();
	if(showViews.length>0){
		for(key in showViews){
			$("#"+showViews[key]).css({"display":"block"});
			diyAutoHeight($("#"+showViews[key]));
		}
	}
}
function hidEventView(obj){
	var settings=settingsLib(obj);
	var hidViews=settings.getSetting('eventSet.hidViews');
	if(!hidViews)hidViews=new Array();
	if(hidViews.length>0){
		for(key in hidViews){
			$("#"+hidViews[key]).css({"display":"none"});
			diyAutoHeight($("#"+hidViews[key]));
		}
	}
}
function getPageScrollTop(){
	var scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
	return scrollTop;
}
function getNowPage(){
	var width=$(window).width();
	var max_width=window.DIY_PAGE_SIZE;
	max_width=parseFloat(max_width);
	if(isNaN(max_width))max_width=1200;
	if(width>=max_width){
		return 'pc';
	}else if(width>=640){
		return 'pad';
	}else{
		return 'mobile';
	}
}
$(window).scroll(function(){
    var scrollTop=getPageScrollTop();
    var nowPage=getNowPage();
    if($(".scrollToTop_"+nowPage).length>0){
    	$(".scrollToTop_"+nowPage).each(function(){
    		var old_top=$(this).attr("old_top_"+nowPage);
    		var old_left=$(this).attr("old_left_"+nowPage);
    		var old_width=$(this).attr("old_width_"+nowPage);
    		if(!old_top||old_top==""){
    			old_top=$(this).offset().top;
    			$(this).attr("old_top_"+nowPage,old_top);
    		}
    		if(!old_left||old_left==""){
    			old_left=$(this).offset().left;
    			$(this).attr("old_left_"+nowPage,old_left);
    		}
    		if(!old_width||old_width==""){
    			old_width=$(this).width();
    			$(this).attr("old_width_"+nowPage,old_width);
    		}
    		old_top=parseFloat(old_top);
    		old_left=parseFloat(old_left);
    		old_width=parseFloat(old_width);
    		if(scrollTop>=old_top){
    			$(this).css({"position":"fixed","z-index":9999999,"top":"0px","width":old_width+"px","left":old_left+"px"});
    			$(this).parents(".view").css({"z-index":9999999});
    			//$(this).parents(".view").children(".view_contents").css({"overflow":"visible"});
    			$(this).parents(".layout").css({"z-index":9999999});
    			//$(this).parents(".layout").children(".view_contents").css({"overflow":"visible"});
    			// 通过设置边距，清除悬浮对下一个元素的影响
                        if ($(this).hasClass('layout')) {
                            $(this).next().css('margin-top', (Number($(this).css('margin-top').replace('px', '')) + $(this).height()) + 'px');
                        }
    		}else{
    			$(this).css({"position":"","z-index":"","top":"","width":"","left":""});
    			$(this).parents(".view").css({"z-index":""});
    			//$(this).parents(".view").children(".view_contents").css({"overflow":""});
    			$(this).parents(".layout").css({"z-index":""});
    			//$(this).parents(".layout").children(".view_contents").css({"overflow":""});
    			$(this).attr("old_top_"+nowPage,null);
    			$(this).attr("old_left_"+nowPage,null);
    			$(this).attr("old_width_"+nowPage,null);
    			// 通过设置边距，清除悬浮对下一个元素的影响
                        if ($(this).hasClass('layout')) {
                            $(this).next().css('margin-top', '');
                        }
    		}
    	});
    }
});
function diyAutoHeight(obj){
	if(obj&&obj.length>0){
		//针对选项卡做特殊处理
		if(obj.children(".view_contents").children("form").length>0){
			if(obj.children(".view_contents").children("form").children(".view").length>0){
				obj.children(".view_contents").children("form").children(".view").each(function(){
					if($(this).is(":visible")){
						diyAutoHeightDo($(this));
						return false;
					}
				});
			}else{
				diyAutoHeightDo(obj);
			}
		}else if(obj.children(".view_contents").children(".niceTab").find(".niceTabShow").length>0){
			if(obj.children(".view_contents").children(".niceTab").find(".niceTabShow").children(".view").length>0){
				obj.children(".view_contents").children(".niceTab").find(".niceTabShow").children(".view").each(function(){
					if($(this).is(":visible")){
						diyAutoHeightDo($(this));
						return false;
					}
				});
			}else{
				diyAutoHeightDo(obj);
			}
		}else{
			diyAutoHeightDo(obj);
		}
	}else{
		setTimeout(function(){
			$(".view").each(function(){
				if(!$(this).hasClass("includeBlock")){
					diyAutoHeightDo($(this));
				}
			});
		},500);
	}
}
function diyAutoHeightFatherDo(father,obj){
	var settings=settingsLib(father);
	var autoHeight=settings.getSetting('autoHeight');
	if(autoHeight&&autoHeight=="true"){
		//开启了允许自动高度
		var minHeight=obj.offset().top+obj.height()-father.offset().top;
		if(obj.siblings(".view").length>0){
			obj.siblings(".view").each(function(){
				if($(this).is(":visible")){
					var tempHeight=$(this).offset().top+$(this).height()-father.offset().top;
					if(tempHeight>minHeight){
						minHeight=tempHeight;
					}
				}
			});
		}
		//2019-5-20  选项卡添加选项高度计算
		var kind=settings.getSetting('kind');
		var name=settings.getSetting('name');
		var data=settings.getSetting('data');
		if (kind=="选项卡" && name=="tab") {
			var tab_nav_obj = father.children().children().children().eq(0);
			var tab_nav_height = tab_nav_obj.css('height');
			if ( tab_nav_height != undefined && tab_nav_height != undefined && data.showtype == "bottom") {
				minHeight = parseFloat(tab_nav_height) + Number(minHeight);
			}
		}
		father.css({"height":minHeight+"px"});
		diyAutoHeightDo(father);
	}
}
function diyAutoHeightDo(obj){
	if(obj.is(":visible")){
		var father=obj.parents(".view").first();
		if(father.length<=0)father=obj.parents(".layout").first();
		if(father.length>0){
			var settings=settingsLib(father);
			var autoHeight=settings.getSetting('autoHeight');
			if(autoHeight&&autoHeight=="true"){
				if(father.offset().top+father.height()<obj.offset().top+obj.height()){
					father.css({"height":(obj.offset().top+obj.height()-father.offset().top)+"px"});
					diyAutoHeightDo(father);
				}else{
					diyAutoHeightFatherDo(father,obj);
				}
			}
		}
	}
}
function setScroll(){
	if(typeof($("html").niceScroll)=="function"){
		$("html").niceScroll({zindex:99999,cursoropacitymax:0.8,cursoropacitymin:0.3,horizrailenabled:false,mousescrollstep:60,smoothscroll:true});	
	}else{
		setTimeout(setScroll,500);
	}
}
var settingsLib=function(view){
	var main={
		view:null,
		setup:function(obj){
			if(window.viewsSettings&&window.viewsSettings[obj.attr("id")]){
				this.init(window.viewsSettings[obj.attr("id")]);
				this.view=obj;
			}else{
				this.init({});
			}
		},
		init:function(obj){
			if(typeof(obj)=='object'){
				this.settings=obj;
			}else if(obj!="" && typeof obj == 'string'){
				eval('if(typeof('+obj+')=="object"){this.settings='+obj+';}else{this.settings={};}');
			}else{
				this.settings={};
			}
		},
		setSetting:function(k,v){
			if(!this.settings){
				this.settings={};	
			}
			var keyArray=k.split(".");
      		var val='this.settings';
			for (key in keyArray){
				if(keyArray[key]&&keyArray[key]!=''){
					if(eval(val+'["'+keyArray[key]+'"]')){
						val=val+'["'+keyArray[key]+'"]';
					}else{
						eval(val+'["'+keyArray[key]+'"]={}');
						val=val+'["'+keyArray[key]+'"]';
					}
				}
			}
			if(v==null){
				eval("delete "+val);		
			}else{
				eval(val+"=v");
			}
		},
		getSetting:function(key){
			if(!this.settings){
				this.settings={};	
			}
			if(key){
				var keyArray=key.split(".");
				var val='this.settings';
				for (key in keyArray){
					if(keyArray[key]&&keyArray[key]!=''){
						if(eval(val+'["'+keyArray[key]+'"]')){
							val=val+'["'+keyArray[key]+'"]';
							continue;
						}else{
							val=null;
							break;
						}
					}
				}
				return eval(val);
			}else{
				return this.settings;	
			}
		},
		saveSettings:function(obj){
			if(typeof(obj)=="object"&&this.settings&&obj.hasClass("view")){
				window.viewsSettings[obj.attr("id")]=this.settings;
			}else if(this.view&&typeof(this.view)=="object"&&this.settings&&this.view.hasClass("view")){
				window.viewsSettings[this.view.attr("id")]=this.settings;
			}
		}
	};
	if(view){
		main.view=view;
		main.setup(view);	
	}
	return main;
}

function GetUrlPara(){
	var url = document.location.toString();
	var arrUrl = url.split("?");
	var paras='';
	if(arrUrl.length>1){
		var para = arrUrl[1];
		var arrUrl2=para.split("&");
		arrUrl2.forEach(function(e){
			if(e.indexOf("mod=")>=0||e.indexOf("act=")>=0||e.indexOf("#")>=0){
				 return;  
			}else{
				paras+=e+"&";
			}
		})
	}
	return paras;
}
//RequestURL for signle
function RequestURL_old(viewid, sys_url, moreParams){
	var serverUrl = '//'+DIY_JS_SERVER+'/sysTools.php?mod=viewsConn&rtype=json&idweb='+DIY_WEBSITE_ID+'&'+sys_url;
	var settings = settingsLib($("#"+viewid));
	var params = "";
	if(settings && settings.getSetting("data")){
		$.each(settings.getSetting("data"), function(key, val){
			if($.isArray(val)){
				$.each(val, function(key2, val2){
					params += "&"+key+"[]="+val2;
				});
			}else{
				params += "&"+key+"="+val;
			}
		});
		if(params) serverUrl += params;
	}
	var params2 = GetUrlPara();
	if(params2) serverUrl += "&" + params2;
	if(moreParams) serverUrl += "&" + moreParams;
	var scriptString = "<scr"+"ipt type='text/javascript' src="+serverUrl+"></scr"+"ipt>";
	//$.ajaxSettings.async = false; 
	$.ajax({
	  dataType: 'jsonp',
	  crossDomain: true, 
	  url: serverUrl,
	  xhrFields:{withCredentials:true},
	  success: function(result){
		if(result.error) alert(result.error);
		else{
			if(typeof(history.replaceState) != 'undefined'){
				var obj={};
				var hstate=JSON.stringify(history.state);
				if(hstate!='null'&& hstate!=null){
					eval('var hjson = ' + hstate);
					obj=hjson;
				}
				var key="moreParams"+viewid;
				obj[key]=moreParams;
				//var strparam=viewid+":"+moreParams;
				//history.replaceState({("moreParams"+viewid):moreParams},"","");
				history.replaceState(obj,"","");
			}
			$("#"+viewid).children(".view_contents").html(result.html);
			$("#"+viewid).children(".view_contents").show();
			setTimeout(function(){
				diyAutoHeight($("#"+viewid));
			},500);
		}
	}});
	setTimeout(function(){commDefault_isFT();},500);
	function commDefault_isFT(){
		var based_Obj= document.getElementById("based");
		var currentlang_Obj= document.getElementById("currentlang");//当前语言
		$(function(){
			if (based_Obj){
				var JF_cn="ft"+self.location.hostname.toString().replace(/\./g,"");
				switch( Request('chlang') ){
					case "cn-tw":
						BodyIsFt= getCookie(JF_cn)=="1"? 0 : 1;
						delCookie(JF_cn);
						SetCookie(JF_cn, BodyIsFt, 7);
						break; 
					case "cn":
					case "en": 
						BodyIsFt= 0; 
						delCookie(JF_cn);
						SetCookie(JF_cn, 0, 7);
						currentlang_Obj.innerHTML = "简体中文";
						break;
					case "tw": 
						BodyIsFt= 1; 
						delCookie(JF_cn);
						SetCookie(JF_cn, 1, 7);
						currentlang_Obj.innerHTML = "繁體中文"; //因为是繁体 你写简体也会被转化成繁体  所以这儿只能写繁体 2015-1-16
						break;
					default: 
						if (typeof Default_isFT!='undefined' && Default_isFT){ //如果默认繁体
							if(getCookie(JF_cn)==null){
								BodyIsFt= 1;
								SetCookie(JF_cn, 1, 7);
								break;
							}
						}
						BodyIsFt= parseInt(getCookie(JF_cn));
				}	
				if(BodyIsFt===1){
					StranBody();
					document.title = StranText(document.title);
				}else{
					StranBodyce();
					document.title = StranTextce(document.title);
				}
			}else{
				var JF_cn="ft"+self.location.hostname.toString().replace(/\./g,"");
				if(Default_isFT){
					BodyIsFt= 1; 
					delCookie(JF_cn);
					SetCookie(JF_cn, 1, 7);
					StranBody();
					document.title = StranText(document.title);
				}else{
					BodyIsFt= 0; 
					delCookie(JF_cn);
					SetCookie(JF_cn, 0, 7);
					/*StranBodyce();
					document.title = StranTextce(document.title);*/
				}
			}
			
		});
	}
	/*
	$.getJSON(serverUrl, function(result){
		if(result.error) alert(result.error);
		else{
			$("#"+viewid).children(".view_contents").html(result.html);
			$("#"+viewid).show();
			setTimeout(function(){
				diyAutoHeight($("#"+viewid));
			},500);
		}
	});*/
	//$("#"+viewid).append(scriptString);
}
function RequestURL(viewid, sys_url, moreParams){ 
	if(checkLoad==1){
		RequestURL_old(viewid, sys_url, moreParams);
		return;
	}
	//这是原本的URL
	var serverUrl = '/sysTools.php?&mod=viewsConn&rtype=json&idweb='+DIY_WEBSITE_ID+'&'+sys_url;
	var settings = settingsLib($("#"+viewid));
	var params = "";
	if(settings && settings.getSetting("data")){
		$.each(settings.getSetting("data"), function(key, val){
			if($.isArray(val)){
				$.each(val, function(key2, val2){
					params += "&"+key+"[]="+val2;
				});
			}else{
				params += "&"+key+"="+val;
			}
		});
		if(params) serverUrl += params;
	}
	var params2 = GetUrlPara();
	if(params2) serverUrl += "&" + params2;
	if(moreParams) serverUrl += "&" + moreParams;
	batchArr.push(serverUrl);

}
function sendBatch(sendurl){
	if(!sendurl) return;
	//10次分割
	var newArr = [];
	newArr = sliceArray(sendurl,10);
	//对url进行组装
	var serverUrl = '//'+DIY_JS_SERVER+'/sysTools.php?mod=viewsConn&act=batch&idweb='+DIY_WEBSITE_ID+'&';
	for(var i in newArr){
		var data = {};
		data.postUrl = newArr[i];
		//获取数据 xhrFields解决传输cookie问题
		$.ajax({
		  type: "post",
		  cache: false,
		  dataType: "json", 
		  async:true,
	      data:data ,
		  url: serverUrl,
		  xhrFields: {
            withCredentials: true
          },
          crossDomain: true,
		  success: function(result){
		  	//var result = eval("("+result+")");
			if(result.error) {
				alert(result.error);
				//详情的判断
				if (result.data.pageType == 1){
                    setTimeout(function (){window.history.back()},2000)
				}
			} else{
				for(var i in result){//i就是viewid
					$("#"+i).children(".view_contents").html(result[i]['html']);
					$("#"+i).children(".view_contents").show();
					setTimeout(function(){
						diyAutoHeight($("#"+i));
					},500);	
				}
			}
		}});
	}
	setTimeout(function(){commDefault_isFT();},500);
	checkLoad = 1;
}

/*
 * 将一个数组分成几个同等长度的数组
 * array[分割的原数组]
 * size[每个子数组的长度]
 */
 function sliceArray(array, size) {
    var result = [];
    for (var x = 0; x < Math.ceil(array.length / size); x++) {
        var start = x * size;
        var end = start + size;
        result.push(array.slice(start, end));
    }
    return result;
}
//导航公共监听函数
function setDhListen(style,obj,params){
	var father=$(obj).parents(".dh").first();
	if(father.length>0){
		switch(style){
			case 'style_01':
				father.find(".miniMenu").toggleClass("Mslide");
	            if($("body").css("position")=="relative"){
	                $("body").css({"position":"fixed","width":"100%"});
	            }else{
	                $("body").css({"position":"relative","width":"100%"});
	            }
				break;
			case 'style_02':
				if(params=="open"){
					father.find(".Style_02_miniMenu .menuMain").css("display","block");
				}else{
					father.find(".Style_02_miniMenu .menuMain").css("display","none");
				}
				break;
			case 'style_03':
				if(params=="mobi_more"){
					$(obj).parent().siblings(".mobi_menuUl02").toggle();
				}else if(params=="m_icoFont"){
					$(obj).parents(".mobi_main").hide();
				}else if(params=="mobi_top"){
					$(obj).siblings(".mobi_main").show();
				}
				break;
			case 'style_04':
				var width = $(window).width();
                var newW = width+18;
                father.find(".newWidth").css("width",newW);
                father.find(".miniMenu").toggleClass("Mslide");
                if($("body").css("position")=="relative"){
                    $("body").css({"position":"fixed","width":"100%"});
                }else{
                    $("body").css({"position":"relative","width":"100%"});
                }
				break;
			case 'type05':
						father.find(".mobileCon").show();
						father.find(".mobileCon").animate({left:'0'},600,function(){
							father.find(".mobileIcon").hide();
						})
						if($("body").css("position")=="relative"){
								$("body").css({"position":"fixed","width":"100%"});
						}else{
								$("body").css({"position":"relative","width":"100%"});
						}
				break;
			case 'type06':
						father.find(".mobileCon").animate({left:'-100%'},600,function(){
							father.find(".mobileCon").hide();
							father.find(".mobileIcon").show();
						});
						if($("body").css("position")=="relative"){
								$("body").css({"position":"fixed","width":"100%"});
						}else{
								$("body").css({"position":"relative","width":"100%"});
						}
				break;
		}
	}
}
//-------------选项卡-----------------------------------------------
//鼠标左右拖拽事件
function setScroll_Choice(tabId){
	if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) return;
	if(typeof($(".tab_nav .tab_scroll", $("#"+tabId)).niceScroll)=="function"){
		$(".tab_nav .tab_scroll", $("#"+tabId)).niceScroll({zIndex:99999,cursoropacitymax:0,cursoropacitymin:0,horizrailenabled:true,autohidemode:true,touchbehavior:true});
	}else{
		setTimeout(setScroll_Choice,500);
	}
}

/*鼠标悬浮效果*/
function setHover_Choice(tabId){
	$(".tab_nav .tab_li", $("#"+tabId)).unbind('hover');
	$(".tab_nav .tab_li", $("#"+tabId)).hover(function(){
		var index = $(this).index();
		$(this).addClass("tabCurItem").siblings().removeClass("tabCurItem");
		$(".tab_box .tab_div", $("#"+tabId)).eq(index).addClass("niceTabShow").siblings().removeClass("niceTabShow");
		diyAutoHeight($("#"+tabId.substr(4)));
	});
}
/*鼠标点击效果*/
function setClick_Choice(tabId){
	$(".tab_nav .tab_li", $("#"+tabId)).unbind('click');
	$(".tab_nav .tab_li", $("#"+tabId)).click(function(){
		var index = $(this).index();
		$(this).addClass("tabCurItem").siblings().removeClass("tabCurItem");
		$(".tab_box .tab_div", $("#"+tabId)).eq(index).addClass("niceTabShow").siblings().removeClass("niceTabShow");
		diyAutoHeight($("#"+tabId.substr(4)));
	});
}
/*自动播放*/
function setAnimat_int(tabId,time){
	if(!time)time=5;
	time=time*1000;
	var viewid=tabId.substr(4);

	if(!window.tabConfigAnimat)window.tabConfigAnimat={};
	//初始化
	window.tabConfigAnimat[viewid]=setTimeout(doAnimat,time);

	$("#"+viewid).mousemove(function(){
		if(window.tabConfigAnimat[viewid])window.clearTimeout(window.tabConfigAnimat[viewid]);
	});
	$("#"+viewid).mouseover(function(){
		if(window.tabConfigAnimat[viewid])window.clearTimeout(window.tabConfigAnimat[viewid]);
	});
	$("#"+viewid).mouseout(function(){
		window.tabConfigAnimat[viewid]=setTimeout(doAnimat,time);
	});

	function doAnimat(){
		if(window.tabConfigAnimat[viewid])window.clearTimeout(window.tabConfigAnimat[viewid]);
		var index=$(".tab_nav .tabCurItem", $("#"+tabId)).index();
		index=index+1;
		if(index>=$(".tab_nav .tab_li", $("#"+tabId)).length){
			index=0;
		}
		$(".tab_nav .tab_li", $("#"+tabId)).eq(index).addClass("tabCurItem").siblings().removeClass("tabCurItem");
		$(".tab_box .tab_div", $("#"+tabId)).eq(index).addClass("niceTabShow").siblings().removeClass("niceTabShow");
		diyAutoHeight($("#"+tabId.substr(4)));
		window.tabConfigAnimat[viewid]=setTimeout(doAnimat,time);
	}
}
//获取鼠标拖拽区域的总宽度
function tab_style03_init(tabId){
	var total=0;
	var obj=$(".tab_li", $("#"+tabId));
	$(".tab_li", $("#"+tabId)).each(function(){
		total+=$(this).width();
	});
	$(".tab_ul_top", $("#"+tabId)).css("width",total+"px");
	$(".tab_ul_bottom", $("#"+tabId)).css("width",total+"px");

	//向左滚动图标事件
	$(".tab_left_arrow", $("#"+tabId)).unbind('click');
	$(".tab_left_arrow", $("#"+tabId)).click(function(){
		var index = $(".tab_nav .tabCurItem", $("#"+tabId)).index();
		index = index-1;
		$(".tab_nav .tab_li", $("#"+tabId)).eq(index).addClass("tabCurItem").siblings().removeClass("tabCurItem");
		$(".tab_box .tab_div", $("#"+tabId)).eq(index).addClass("niceTabShow").siblings().removeClass("niceTabShow");
        diyAutoHeight($("#"+tabId.substr(4)));
	});

	//向右滚动图标事件
	$(".tab_right_arrow", $("#"+tabId)).unbind('click');
	$(".tab_right_arrow", $("#"+tabId)).click(function(){
		var index = $(".tab_nav .tabCurItem", $("#"+tabId)).index();
		var len = $(".tab_nav .tab_li").length;
		index = index+1;
		if(index >= len){
			index = 0;
		}
		$(".tab_nav .tab_li", $("#"+tabId)).eq(index).addClass("tabCurItem").siblings().removeClass("tabCurItem");
		$(".tab_box .tab_div", $("#"+tabId)).eq(index).addClass("niceTabShow").siblings().removeClass("niceTabShow");
        diyAutoHeight($("#"+tabId.substr(4)));
	});
	setScroll_Choice(tabId);
}
function StranBody(fobj){
	var obj= fobj ? fobj.childNodes : document.body.childNodes;
	for(var i=0;i<obj.length;i++){
		var OO=obj.item(i);
		if("||BR|HR|TEXTAREA|".indexOf("|"+OO.tagName+"|")>0||OO==based_Obj)continue;
		if(OO.title!=""&&OO.title!=null)OO.title=StranText(OO.title);
		if(OO.alt!=""&&OO.alt!=null)OO.alt=StranText(OO.alt);
		if(OO.tagName=="INPUT"&&OO.value!=""&&OO.type!="text"&&OO.type!="hidden")OO.value=StranText(OO.value);
		if(OO.nodeType==3){OO.data=StranText(OO.data)}
		else StranBody(OO)
	}
	
	try{
		var based_Obj2= document.getElementById("based2");
		if(!based_Obj2) { //简繁
			based_Obj.innerHTML = BodyIsFt==1? "简体中文":"繁体中文";
		}else{ //简繁英
			based_Obj.innerHTML = "繁体中文";
			based_Obj2.innerHTML = "简体中文";
		}
	}catch(e){}
}
function StranBodyce(fobj){
	var obj= fobj ? fobj.childNodes : document.body.childNodes;
	for(var i=0;i<obj.length;i++){
		var OO=obj.item(i);
		if("||BR|HR|TEXTAREA|".indexOf("|"+OO.tagName+"|")>0||OO==based_Obj)continue;
		if(OO.title!=""&&OO.title!=null)OO.title=StranTextce(OO.title);
		if(OO.alt!=""&&OO.alt!=null)OO.alt=StranTextce(OO.alt);
		if(OO.tagName=="INPUT"&&OO.value!=""&&OO.type!="text"&&OO.type!="hidden")OO.value=StranTextce(OO.value);
		if(OO.nodeType==3){OO.data=StranTextce(OO.data)}
		else StranBodyce(OO)
	}
	try{
		var based_Obj2= document.getElementById("based2");
		if(!based_Obj2) { //简繁
			based_Obj.innerHTML = BodyIsFt==1? "简体中文":"繁体中文";
		}else{ //简繁英
			based_Obj.innerHTML = "繁体中文";
			based_Obj2.innerHTML = "简体中文";
		}
	}catch(e){}
}
function StranText(txt){
	if(txt==""||txt==null)return "";
	return Traditionalized(txt);
}
function StranTextce(txt){
	if(txt==""||txt==null)return "";
	return Traditionalizedce(txt);
}
function JTPYStr(){
	return '皑蔼碍爱翱袄奥坝罢摆败颁办绊帮绑镑谤剥饱宝报鲍辈贝钡狈备惫绷笔毕毙闭边编贬变辩辫鳖瘪濒滨宾摈饼拨钵铂驳卜补参蚕残惭惨灿苍舱仓沧厕侧册测层诧搀掺蝉馋谗缠铲产阐颤场尝长偿肠厂畅钞车彻尘陈衬撑称惩诚骋痴迟驰耻齿炽冲虫宠畴踌筹绸丑橱厨锄雏础储触处传疮闯创锤纯绰辞词赐聪葱囱从丛凑窜错达带贷担单郸掸胆惮诞弹当挡党荡档捣岛祷导盗灯邓敌涤递缔点垫电淀钓调迭谍叠钉顶锭订东动栋冻斗犊独读赌镀锻断缎兑队对吨顿钝夺鹅额讹恶饿儿尔饵贰发罚阀珐矾钒烦范贩饭访纺飞废费纷坟奋愤粪丰枫锋风疯冯缝讽凤肤辐抚辅赋复负讣妇缚该钙盖干赶秆赣冈刚钢纲岗皋镐搁鸽阁铬个给龚宫巩贡钩沟构购够蛊顾剐关观馆惯贯广规硅归龟闺轨诡柜贵刽辊滚锅国过骇韩汉阂鹤贺横轰鸿红后壶护沪户哗华画划话怀坏欢环还缓换唤痪焕涣黄谎挥辉毁贿秽会烩汇讳诲绘荤浑伙获货祸击机积饥讥鸡绩缉极辑级挤几蓟剂济计记际继纪夹荚颊贾钾价驾歼监坚笺间艰缄茧检碱硷拣捡简俭减荐槛鉴践贱见键舰剑饯渐溅涧浆蒋桨奖讲酱胶浇骄娇搅铰矫侥脚饺缴绞轿较秸阶节茎惊经颈静镜径痉竞净纠厩旧驹举据锯惧剧鹃绢杰洁结诫届紧锦仅谨进晋烬尽劲荆觉决诀绝钧军骏开凯颗壳课垦恳抠库裤夸块侩宽矿旷况亏岿窥馈溃扩阔蜡腊莱来赖蓝栏拦篮阑兰澜谰揽览懒缆烂滥捞劳涝乐镭垒类泪篱离里鲤礼丽厉励砾历沥隶俩联莲连镰怜涟帘敛脸链恋炼练粮凉两辆谅疗辽镣猎临邻鳞凛赁龄铃凌灵岭领馏刘龙聋咙笼垄拢陇楼娄搂篓芦卢颅庐炉掳卤虏鲁赂禄录陆驴吕铝侣屡缕虑滤绿峦挛孪滦乱抡轮伦仑沦纶论萝罗逻锣箩骡骆络妈玛码蚂马骂吗买麦卖迈脉瞒馒蛮满谩猫锚铆贸么霉没镁门闷们锰梦谜弥觅绵缅庙灭悯闽鸣铭谬谋亩钠纳难挠脑恼闹馁腻撵捻酿鸟聂啮镊镍柠狞宁拧泞钮纽脓浓农疟诺欧鸥殴呕沤盘庞国爱赔喷鹏骗飘频贫苹凭评泼颇扑铺朴谱脐齐骑岂启气弃讫牵扦钎铅迁签谦钱钳潜浅谴堑枪呛墙蔷强抢锹桥乔侨翘窍窃钦亲轻氢倾顷请庆琼穷趋区躯驱龋颧权劝却鹊让饶扰绕热韧认纫荣绒软锐闰润洒萨鳃赛伞丧骚扫涩杀纱筛晒闪陕赡缮伤赏烧绍赊摄慑设绅审婶肾渗声绳胜圣师狮湿诗尸时蚀实识驶势释饰视试寿兽枢输书赎属术树竖数帅双谁税顺说硕烁丝饲耸怂颂讼诵擞苏诉肃虽绥岁孙损笋缩琐锁獭挞抬摊贪瘫滩坛谭谈叹汤烫涛绦腾誊锑题体屉条贴铁厅听烃铜统头图涂团颓蜕脱鸵驮驼椭洼袜弯湾顽万网韦违围为潍维苇伟伪纬谓卫温闻纹稳问瓮挝蜗涡窝呜钨乌诬无芜吴坞雾务误锡牺袭习铣戏细虾辖峡侠狭厦锨鲜纤咸贤衔闲显险现献县馅羡宪线厢镶乡详响项萧销晓啸蝎协挟携胁谐写泻谢锌衅兴汹锈绣虚嘘须许绪续轩悬选癣绚学勋询寻驯训讯逊压鸦鸭哑亚讶阉烟盐严颜阎艳厌砚彦谚验鸯杨扬疡阳痒养样瑶摇尧遥窑谣药爷页业叶医铱颐遗仪彝蚁艺亿忆义诣议谊译异绎荫阴银饮樱婴鹰应缨莹萤营荧蝇颖哟拥佣痈踊咏涌优忧邮铀犹游诱舆鱼渔娱与屿语吁御狱誉预驭鸳渊辕园员圆缘远愿约跃钥岳粤悦阅云郧匀陨运蕴酝晕韵杂灾载攒暂赞赃脏凿枣灶责择则泽贼赠扎札轧铡闸诈斋债毡盏斩辗崭栈战绽张涨帐账胀赵蛰辙锗这贞针侦诊镇阵挣睁狰帧郑证织职执纸挚掷帜质钟终种肿众诌轴皱昼骤猪诸诛烛瞩嘱贮铸筑驻专砖转赚桩庄装妆壮状锥赘坠缀谆浊兹资渍踪综总纵邹诅组钻致钟么为只凶准启板里雳余链泄标适态于';
}
function FTPYStr(){
	return '皚藹礙愛翺襖奧壩罷擺敗頒辦絆幫綁鎊謗剝飽寶報鮑輩貝鋇狽備憊繃筆畢斃閉邊編貶變辯辮鼈癟瀕濱賓擯餅撥缽鉑駁蔔補參蠶殘慚慘燦蒼艙倉滄廁側冊測層詫攙摻蟬饞讒纏鏟産闡顫場嘗長償腸廠暢鈔車徹塵陳襯撐稱懲誠騁癡遲馳恥齒熾沖蟲寵疇躊籌綢醜櫥廚鋤雛礎儲觸處傳瘡闖創錘純綽辭詞賜聰蔥囪從叢湊竄錯達帶貸擔單鄲撣膽憚誕彈當擋黨蕩檔搗島禱導盜燈鄧敵滌遞締點墊電澱釣調叠諜疊釘頂錠訂東動棟凍鬥犢獨讀賭鍍鍛斷緞兌隊對噸頓鈍奪鵝額訛惡餓兒爾餌貳發罰閥琺礬釩煩範販飯訪紡飛廢費紛墳奮憤糞豐楓鋒風瘋馮縫諷鳳膚輻撫輔賦複負訃婦縛該鈣蓋幹趕稈贛岡剛鋼綱崗臯鎬擱鴿閣鉻個給龔宮鞏貢鈎溝構購夠蠱顧剮關觀館慣貫廣規矽歸龜閨軌詭櫃貴劊輥滾鍋國過駭韓漢閡鶴賀橫轟鴻紅後壺護滬戶嘩華畫劃話懷壞歡環還緩換喚瘓煥渙黃謊揮輝毀賄穢會燴彙諱誨繪葷渾夥獲貨禍擊機積饑譏雞績緝極輯級擠幾薊劑濟計記際繼紀夾莢頰賈鉀價駕殲監堅箋間艱緘繭檢堿鹼揀撿簡儉減薦檻鑒踐賤見鍵艦劍餞漸濺澗漿蔣槳獎講醬膠澆驕嬌攪鉸矯僥腳餃繳絞轎較稭階節莖驚經頸靜鏡徑痙競淨糾廄舊駒舉據鋸懼劇鵑絹傑潔結誡屆緊錦僅謹進晉燼盡勁荊覺決訣絕鈞軍駿開凱顆殼課墾懇摳庫褲誇塊儈寬礦曠況虧巋窺饋潰擴闊蠟臘萊來賴藍欄攔籃闌蘭瀾讕攬覽懶纜爛濫撈勞澇樂鐳壘類淚籬離裏鯉禮麗厲勵礫曆瀝隸倆聯蓮連鐮憐漣簾斂臉鏈戀煉練糧涼兩輛諒療遼鐐獵臨鄰鱗凜賃齡鈴淩靈嶺領餾劉龍聾嚨籠壟攏隴樓婁摟簍蘆盧顱廬爐擄鹵虜魯賂祿錄陸驢呂鋁侶屢縷慮濾綠巒攣孿灤亂掄輪倫侖淪綸論蘿羅邏鑼籮騾駱絡媽瑪碼螞馬罵嗎買麥賣邁脈瞞饅蠻滿謾貓錨鉚貿麽黴沒鎂門悶們錳夢謎彌覓綿緬廟滅憫閩鳴銘謬謀畝鈉納難撓腦惱鬧餒膩攆撚釀鳥聶齧鑷鎳檸獰甯擰濘鈕紐膿濃農瘧諾歐鷗毆嘔漚盤龐國愛賠噴鵬騙飄頻貧蘋憑評潑頗撲鋪樸譜臍齊騎豈啓氣棄訖牽扡釺鉛遷簽謙錢鉗潛淺譴塹槍嗆牆薔強搶鍬橋喬僑翹竅竊欽親輕氫傾頃請慶瓊窮趨區軀驅齲顴權勸卻鵲讓饒擾繞熱韌認紉榮絨軟銳閏潤灑薩鰓賽傘喪騷掃澀殺紗篩曬閃陝贍繕傷賞燒紹賒攝懾設紳審嬸腎滲聲繩勝聖師獅濕詩屍時蝕實識駛勢釋飾視試壽獸樞輸書贖屬術樹豎數帥雙誰稅順說碩爍絲飼聳慫頌訟誦擻蘇訴肅雖綏歲孫損筍縮瑣鎖獺撻擡攤貪癱灘壇譚談歎湯燙濤縧騰謄銻題體屜條貼鐵廳聽烴銅統頭圖塗團頹蛻脫鴕馱駝橢窪襪彎灣頑萬網韋違圍爲濰維葦偉僞緯謂衛溫聞紋穩問甕撾蝸渦窩嗚鎢烏誣無蕪吳塢霧務誤錫犧襲習銑戲細蝦轄峽俠狹廈鍁鮮纖鹹賢銜閑顯險現獻縣餡羨憲線廂鑲鄉詳響項蕭銷曉嘯蠍協挾攜脅諧寫瀉謝鋅釁興洶鏽繡虛噓須許緒續軒懸選癬絢學勳詢尋馴訓訊遜壓鴉鴨啞亞訝閹煙鹽嚴顔閻豔厭硯彥諺驗鴦楊揚瘍陽癢養樣瑤搖堯遙窯謠藥爺頁業葉醫銥頤遺儀彜蟻藝億憶義詣議誼譯異繹蔭陰銀飲櫻嬰鷹應纓瑩螢營熒蠅穎喲擁傭癰踴詠湧優憂郵鈾猶遊誘輿魚漁娛與嶼語籲禦獄譽預馭鴛淵轅園員圓緣遠願約躍鑰嶽粵悅閱雲鄖勻隕運蘊醞暈韻雜災載攢暫贊贓髒鑿棗竈責擇則澤賊贈紮劄軋鍘閘詐齋債氈盞斬輾嶄棧戰綻張漲帳賬脹趙蟄轍鍺這貞針偵診鎮陣掙睜猙幀鄭證織職執紙摯擲幟質鍾終種腫衆謅軸皺晝驟豬諸誅燭矚囑貯鑄築駐專磚轉賺樁莊裝妝壯狀錐贅墜綴諄濁茲資漬蹤綜總縱鄒詛組鑽緻鐘麼為隻兇準啟闆裡靂餘鍊洩標適態於';
}
function Traditionalized(cc){
	var str='',ss=JTPYStr(),tt=FTPYStr();
	for(var i=0;i<cc.length;i++){
		if(cc.charCodeAt(i)>10000&&ss.indexOf(cc.charAt(i))!=-1)str+=tt.charAt(ss.indexOf(cc.charAt(i)));
  		else str+=cc.charAt(i);
	}
	return str;
}

function Traditionalizedce(cc){
	var str='',tt=JTPYStr(),ss=FTPYStr();
	for(var i=0;i<cc.length;i++){
		if(cc.charCodeAt(i)>10000&&ss.indexOf(cc.charAt(i))!=-1)str+=tt.charAt(ss.indexOf(cc.charAt(i)));
  		else str+=cc.charAt(i);
	}
	return str;
}

function _RequestParamsStr(){
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf('?');
	var strRight = strHref.substr(intPos+1);
	return strRight;
}

function Request(strName){
	var arrTmp = _RequestParamsStr().split("&");
	for(var i=0,len=arrTmp.length; i<len; i++){ 
		var arrTemp = arrTmp[i].split("=");
		if(arrTemp[0].toUpperCase() == strName.toUpperCase()){
		if(arrTemp[1].indexOf("#")!=-1) arrTemp[1] = arrTemp[1].substr(0, arrTemp[1].indexOf("#"));
			return arrTemp[1]; 
		}
	}
	return "";
}

function SetCookie(name,value,hours){
	var hourstay = 30*24*60*60*1000; //此 cookie 将被默认保存 30 天
	if(checkNum(hours)){
		hourstay = hours;
	}
    var exp  = new Date();
    exp.setTime(exp.getTime() + hourstay*60*60*1000);
    document.cookie = name + "="+ escape(value) + ";expires=" + exp.toGMTString();
}
function getCookie(name){     
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return unescape(arr[2]); return null;
}
function delCookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
function checkNum(nubmer){
    var re = /^[0-9]+.?[0-9]*$/;   //判断字符串是否为数字     //判断正整数 /^[1-9]+[0-9]*]*$/  
    if (re.test(nubmer))return true;
	return false;
}
function goBackHistory(num){
	if(typeof(num) == 'undefined'){
		num = 0;
	}
	if(num == '0'){
		if(history.go(-1)){
			location.href = history.go(-1);
		}
	}else{
		arr = location.href.split('/')
		arr[arr.length-1] = "index.html"
		arr = arr.join('/') 
		location.href = arr
	}
}

//简体转繁体
function commDefault_isFT(){
		var based_Obj= document.getElementById("based");
		var currentlang_Obj= document.getElementById("currentlang");//当前语言
		$(function(){
			if (based_Obj){
				var JF_cn="ft"+self.location.hostname.toString().replace(/\./g,"");
				switch( Request('chlang') ){
					case "cn-tw":
						BodyIsFt= getCookie(JF_cn)=="1"? 0 : 1;
						delCookie(JF_cn);
						SetCookie(JF_cn, BodyIsFt, 7);
						break; 
					case "cn":
					case "en": 
						BodyIsFt= 0; 
						delCookie(JF_cn);
						SetCookie(JF_cn, 0, 7);
						currentlang_Obj.innerHTML = "简体中文";
						break;
					case "tw": 
						BodyIsFt= 1; 
						delCookie(JF_cn);
						SetCookie(JF_cn, 1, 7);
						currentlang_Obj.innerHTML = "繁體中文"; //因为是繁体 你写简体也会被转化成繁体  所以这儿只能写繁体 2015-1-16
						break;
					default: 
						if (typeof Default_isFT!='undefined' && Default_isFT){ //如果默认繁体
							if(getCookie(JF_cn)==null){
								BodyIsFt= 1;
								SetCookie(JF_cn, 1, 7);
								break;
							}
						}
						BodyIsFt= parseInt(getCookie(JF_cn));
				}	
				if(BodyIsFt===1){
					StranBody();
					document.title = StranText(document.title);
				}else{
					StranBodyce();
					document.title = StranTextce(document.title);
				}
			}else{
				var JF_cn="ft"+self.location.hostname.toString().replace(/\./g,"");
				if(Default_isFT){
					BodyIsFt= 1; 
					delCookie(JF_cn);
					SetCookie(JF_cn, 1, 7);
					StranBody();
					document.title = StranText(document.title);
				}else{
					BodyIsFt= 0; 
					delCookie(JF_cn);
					SetCookie(JF_cn, 0, 7);
					/*StranBodyce();
					document.title = StranTextce(document.title);*/
				}
			}
			
		});
	}

DIY_PAGE_SIZE='1200';


$(document).ready(function(){
	/*
	**当前模块对象：$("#text_style_01_1575602059365")
	**效果仅在发布预览下才生效
	*/
	
})
var viewsSettings={"comm_layout_header":{"diyShowName":"\u5171\u4eab\u5934\u90e8","css":{"pc":{"height":"110px","z-index":"99999"},"content":{"overflow":"visible","max-width":"1200px"},"mobile":{"height":"60px"},"pad":{"height":"90px"},"customCss":{"pc":{"modelArea":{"background-position":"50% 100% !important","background-size":"auto","background-attachment":"fixed","background":" url(https:\/\/cdn.yun.sooce.cn\/2\/72265\/png\/1578661683769ab6ada74c536e598.png?version=0)","background-repeat":"repeat-x!important"}},"pad":{"modelArea":{"background-position":"50% 100% !important"}}}},"settingsBox":{"showTitle":"\u5171\u4eab\u5934\u90e8\u8bbe\u7f6e","setList":{"\u6837\u5f0f":{"isDefault":"true","mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}}},"eventSet":{"scrollView":"none","type":"none"},"setFixedScroll":{"mobile":"1","pc":"1","pad":"1"},"autoHeight":"false"},"image_logo_1575606105555":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"imageLogoConfig","setupFunc":"logoSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"LOGO\u5c5e\u6027\u8bbe\u7f6e"},"style":"logo","styleKind":"LOGO","styleHelpId":1252,"viewCtrl":"logo","css":{"pc":{"width":"30%","height":"53px","position":"absolute","top":"23px","left":"0%"},"pad":{"left":"2%","top":"20px","height":"48px","width":"20%"},"mobile":{"width":"50%","height":"40px","top":"5px","left":"2%"}},"data":{"logoType":1,"logoStyle":"2","logoBlank":"_self"},"name":"image","kind":"\u56fe\u7247\u6a21\u5757","showname":"\u9ed8\u8ba4","diyShowName":"LOGO","eventSet":{"scrollView":"none","type":"none"},"params":{"filelist":"","urllist":"","propagelist":"","newspagelist":"","proidlist":"","groupVallist":"","newsidlist":"","groupNVallist":""},"fenxiaoEdit":"true"},"dh_style_28_1578629663716":{"settingsBox":{"setList":{"\u5e38\u89c4":{"isDefault":"true","mod":"viewSettingsB","act":"dhConfig","setupFunc":"dhSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u5bfc\u822a\u83dc\u5355\u5c5e\u6027\u8bbe\u7f6e"},"styleHelpId":1257,"style":"style_28","diyShowName":"\u4e09\u7ea7\u5bfc\u822a-\u98ce\u683c28","styleShowName":"\u4e09\u7ea7\u5bfc\u822a-\u98ce\u683c28","styleKind":"\u5bfc\u822a\u83dc\u5355","viewCtrl":"default","css":{"pc":{"width":"70%","z-index":"9999","position":"absolute","top":"25px","left":"30%","display":"block"},"pad":{"z-index":"999","display":"block","height":"36px","left":"28%","top":"23px"},"mobile":{"z-index":"999","display":"block","height":"36px","width":"44px","left":"calc(100% - 50px)","top":"0px"},"content":{"overflow":"visible"},"customCss":{"pc":{"@mainMenuSet":{"font-size":"16px","font-weight":"normal","color":"#333333"},"@mainMenuSet:hover":{"color":"#ff6766","font-weight":"bold","font-family":"Microsoft YaHei"},"%hot>a":{"color":"#ff6766","font-weight":"bold","font-family":"Microsoft YaHei"},"@mainMenuSet:active":{"color":"#9ebf28"},"@subMenuSet:hover":{"color":"#308301","border-style":"solid","border-width":"2px","border-color":"#9ebf28","border-top":"none !important","border-right":"none !important","border-bottom":"none !important"},"@subCurSet":{"color":"#308301","border-style":"solid","border-width":"2px","border-color":"#9ebf28","border-top":"none !important","border-right":"none !important","border-bottom":"none !important"},"@subMenuSet:active":{"color":"#9ebf28","border-bottom":"none !important","border-width":"2px","border-color":"#9ebf28","border-style":"solid"},"@thrMenuSet:active":{"color":"#9ebf28"},"@thrMenuSet:hover":{"color":"#9ebf28"},"@thrCurSet":{"color":"#9ebf28 !important","background":"#f7f7f7 !important"},"%hot#@aview":{"color":"#ff6766","font-family":"Microsoft YaHei"},"@dhAreaSet":{"font-family":"Microsoft YaHei"}},"pad":{"@mainMenuSet":{"font-size":"15px"},"@mainMenuSet:hover":{"font-size":"15px"},"%hot>a":{"font-size":"15px"}},"mobile":{"@icoMenuSet":{"color":"#ff6766","text-align":"center","border-top":"none !important","border-right":"none !important","border-bottom":"none !important","border-left":"none !important"},"@subMenuSet":{"font-family":"SimSun","font-size":"14px","border-top":"none !important","border-right":"none !important","border-bottom":"none !important","border-left":"none !important"},"@thrMenuSet":{"font-family":"SimSun"},"@mainMenuSet":{"font-family":"SimSun","color":"#ffffff","border-top":"none !important","border-bottom":"none !important","border-right":"none !important","border-left":"none !important"},"@mainMenuSet:hover":{"font-weight":"normal"},"%hot>a":{"font-weight":"normal"}}}},"lock":{"height":"true"},"data":{"childMenuType":"1","dhOpen":"on","subtitlename":"","logoposition":"0","logoopen":"","logoright":"","logoleft":"","contentWidth":"","showpc":[2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221],"showmobile":[2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221,2801213,2801217,2801223,2801225,2801219,2801215,2801221],"subWidth":"","iconopen":"","newWinOpen":""},"name":"dh","kind":"\u5bfc\u822a\u83dc\u5355","showname":"\u5bfc\u822a\u83dc\u5355","eventSet":{"scrollView":"none","type":"none"},"moveEdit":[],"viewLock":{"mobile":{"position":"false"}},"setFixed":"2","styleColor":"\u5ae9\u7eff\u8272","themeColor":"#308301"},"layout_1589415599471":{"css":{"pc":{"height":"230px","display":"block"},"content":{"overflow":"visible"},"pad":{"display":"block","height":"170px"},"mobile":{"display":"block","height":"90px"},"customCss":{"pc":{"modelArea":{"background":"#56509f"}}}},"diyShowName":"\u533a\u57df\u5e03\u5c40","name":"layout","style":"autoLayout","settingsBox":{"showTitle":"\u533a\u57df\u5e03\u5c40\u8bbe\u7f6e","setList":{"\u6837\u5f0f":{"isDefault":"true","mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}}},"eventSet":{"scrollView":"none","type":"none"},"viewLock":{"pc":[]},"autoHeight":"false"},"image_style_01_1589415599473":{"settingsBox":{"setList":{"\u5e38\u89c4":{"isDefault":"true","mod":"viewSettingsHcl","act":"imageConfig","setupFunc":"imageSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u56fe\u7247\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u56fe\u7247-\u5355\u5f20","styleShowName":"\u5355\u5f20\u56fe\u7247","styleKind":"\u5355\u5f20\u56fe\u7247","styleHelpId":1254,"viewCtrl":"default","css":{"pc":{"width":"100%","height":"240px","position":"absolute","top":"-10px","left":"0%"},"pad":{"height":"180px"},"mobile":{"width":"100%","height":"100px","top":"-10px","left":"0%"},"content":{"overflow":"visible"}},"doubleClickFunc":"imageViewSelect","mouseMenu":[{"name":"\u9009\u62e9\u56fe\u7247","func":"imageViewSelect()","ico":"fa-file-image-o"}],"sizeCallbackFunc":"setImgCen","imgUrl":"\/images\/matLibrary\/webImg\/image01_default.jpg","name":"image","kind":"\u56fe\u7247\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"data":{"imgUrl":"https:\/\/cdn.yun.sooce.cn\/2\/125373\/png\/1589370832696d5cb83384e54fcee.png?version=0","imgStyle":{"pc":"2","pad":null,"mobile":null}},"params":{"filelist":"","urllist":"","propagelist":"","newspagelist":"","proidlist":"","groupVallist":"","newsidlist":"","groupNVallist":""}},"text_style_01_1589415599488":{"settingsBox":{"setList":{"\u5e38\u89c4":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"50%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","left":"25%","top":"80px"},"pad":{"width":"50%","top":"50px"},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"25px","left":"2%"},"customCss":{"pc":{"@view_contents":{"font-size":"28px","line-height":"50px","text-align":"center","color":"#ffffff","font-weight":"normal","font-family":"Microsoft YaHei"}},"mobile":{"@view_contents":{"font-size":"18px","line-height":"26px","text-align":"center"}},"pad":{"@view_contents":{"font-size":"24px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"params":{"animate":"fadeInUp","duration":"1","delay":"0.25","iteration":"1","offset":"0"},"data":{"newblank":0,"showtarget":"1","bossType":"1","groupNVal":null,"newspage":null,"newsid":null,"showat":null,"selectVal":2801215},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"layout_1579343524364":{"css":{"pc":{"height":"97px"},"content":{"overflow":"visible","max-width":"1200px"},"customCss":{"pc":{"modelArea":{"background":"#ffffff"},"modelArea:active":{"background":"#ffffff"}}},"pad":{"height":"66px"},"mobile":{"height":"80px"}},"diyShowName":"\u533a\u57df\u5e03\u5c40","name":"layout","style":"autoLayout","settingsBox":{"showTitle":"\u533a\u57df\u5e03\u5c40\u8bbe\u7f6e","setList":{"\u6837\u5f0f":{"isDefault":"true","mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}}},"eventSet":{"scrollView":"none","type":"none"}},"prodKind_style_05_1589429032816":{"settingsBox":{"setList":{"\u5e38\u89c4":{"isDefault":"true","mod":"viewSettingsHcl","act":"prodKindConfig","setupFunc":"prodKindSetup,SettingtabChange"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u4ea7\u54c1\u7c7b\u522b\u5c5e\u6027\u8bbe\u7f6e"},"styleHelpId":1270,"style":"style_05","diyShowName":"\u4ea7\u54c1\u7c7b\u522b-\u98ce\u683c5","styleShowName":"\u98ce\u683c5","styleKind":"AAA","viewCtrl":"prodKind","css":{"pc":{"width":"98%","position":"absolute","top":"40px","left":"1%"},"pad":{"top":"20px","z-index":1},"mobile":{"width":"96%","top":"0px","left":"2%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@oneSet":{"font-size":"16px","border-width":"1px","border-style":"solid","border-color":"#dddddd","margin-left":"10px","margin-right":"10px","border-radius":"5px","padding-top":"10px","padding-bottom":"10px","font-family":"Microsoft YaHei","text-align":"center"},"@oneBgSet:hover":{"border-width":"0px","border-style":"solid","border-color":"#ff6766","background":"transparent"},"@oneSet:hover":{"background":"#ff6766","color":"#ffffff","font-weight":"bold","border-width":"1px","border-style":"solid","border-color":"#ff6766"},"%currentSet":{"background":"#ff6766","color":"#ffffff","font-weight":"bold","border-width":"1px","border-style":"solid","border-color":"#ff6766"},"@curgSet":{"background":"#ff6766","color":"#ffffff","font-weight":"bold","border-width":"1px","border-style":"solid","border-color":"#ff6766"},"%oneHot":{"background":"#ff6766","color":"#ffffff","font-weight":"bold","border-width":"1px","border-style":"solid","border-color":"#ff6766"},"@oneBgSet":{"margin-left":"150px","margin-right":"200px","padding-left":"100px","padding-right":"100px"}},"pad":{"@oneSet":{"font-size":"14px","padding-top":"5px","padding-bottom":"5px"},"@oneBgSet":{"padding-left":"0px","padding-right":"30px"}},"mobile":{"@oneSet":{"padding-top":"5px","padding-bottom":"5px","font-size":"12px","margin-top":"10px","margin-left":"5px","margin-right":"5px","padding-left":"10px","padding-right":"10px"},"@oneBgSet":{"padding-left":"0px","padding-right":"0px","margin-left":"0px","margin-right":"0px"}}}},"lock":{"height":"true"},"name":"prodKind","kind":"\u4ea7\u54c1\u6a21\u5757","showname":"\u4ea7\u54c1\u5206\u7c7b","eventSet":{"scrollView":"none","type":"none"},"data":{"showat":2801217}},"layout_1578470160105":{"css":{"pc":{"height":"865px"},"content":{"overflow":"visible","max-width":"1200px"},"pad":{"height":"705px"},"mobile":{"height":"682px"}},"diyShowName":"\u533a\u57df\u5e03\u5c40","name":"layout","style":"autoLayout","settingsBox":{"showTitle":"\u533a\u57df\u5e03\u5c40\u8bbe\u7f6e","setList":{"\u6837\u5f0f":{"isDefault":"true","mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}}},"eventSet":{"scrollView":"none","type":"none"},"autoHeight":"true","data":{"showat":null}},"productList_style_03_1589418876654":{"settingsBox":{"setList":{"\u5e38\u89c4":{"isDefault":"true","mod":"viewSettingsHcl","act":"prodListConfig","setupFunc":"prodListSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u4ea7\u54c1\u5217\u8868\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_03","diyShowName":"\u4ea7\u54c1\u5217\u8868-\u98ce\u683c3","styleShowName":"\u98ce\u683c3","styleKind":"AAA","styleHelpId":1269,"viewCtrl":"default","css":{"pc":{"width":"100%","position":"absolute","top":"30px","left":"0%"},"pad":{"top":"20px","width":"98%","left":"1%"},"mobile":{"width":"96%","top":"10px","left":"2%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@modSet":{"padding-bottom":"40px","background":" url(https:\/\/cdn.yun.sooce.cn\/2\/125373\/png\/1589274138024db0720e5e57746ec.png?version=0)","background-position":"50% 100% !important","background-size":"auto"},"@imgSet":{"height":"260px"},"%pagecurSet":{"background":"#ff6766"},"@btnaSet":{"background":"#4c4c4c"},"@priceSet":{"color":"#4c4c4c"},"@vipSet":{"color":"#4c4c4c"},"@zhekouSet":{"color":"#4c4c4c"},"@unitSet":{"color":"#4c4c4c"},"@page_btn#@pageSet:hovert":{"background":"#4c4c4c"},"@page_btn#@pageSet:hover":{"background":"#ff6766"},"@titleSet":{"line-height":"40px","height":"40px","font-size":"17px","font-weight":"bold","text-align":"center"},"@sortSet":{"text-align":"right","padding-top":"0px","padding-left":"0px"},"@modSet:hover":{"color":"#ff6766"},"@modSet:hover#@imgSet":{"opacity":"0.8"},"@modSet:hover#@titleSet":{"color":"#ff6766"}},"themeColor":"#4c4c4c","pad":{"@imgSet":{"height":"200px"},"@titleSet":{"font-size":"15px"},"@modSet":{"padding-bottom":"30px"}},"mobile":{"@titleSet":{"font-size":"14px","line-height":"24px","height":"24px"},"@imgSet":{"height":"120px","background":"#ffffff"},"@modSet":{"padding-bottom":"30px"}}}},"lock":{"height":"true"},"prodhnum":"4","prodhnumpad":"3","prodhnummobile":"2","prodznum":"1","picscale":"4:3","prodtitle":"true","prodpic":"true","prodpage":"false","prodprice":"true","prodstock":"true","prodviprice":"false","prodbutton":"true","arr_ProdShow":{"pic":"\u56fe\u7247","title":"\u6807\u9898","page":"\u5206\u9875","price":"\u4ef7\u683c","stock":"\u6309\u94ae","viprice":"\u4f1a\u5458\u4ef7"},"data":{"pshow":["pic","title","page"],"prodhnum":"3","prodhnumpad":"3","prodhnummobile":"2","prodznum":"2","picscale":"4:3","prodPicScale":"2:3","newpshow":{"pc":["pic","title","page"]},"prodnum":"6","prodhnumpc":"3","prodznumpc":"2","btnshowat":"2","btnName":"\u4e86\u89e3\u8be6\u60c5","showat":2801229,"prodTitleNum":{"pc":"16","pad":"16","mobile":"12"},"page_style":"2","sortButton":"0","showtarget":"_blank"},"name":"productList","kind":"\u4ea7\u54c1\u6a21\u5757","showname":"\u4ea7\u54c1\u5217\u8868","eventSet":{"scrollView":"none","type":"none"}},"layout_1578471201719":{"css":{"pc":{"height":"40px"},"content":{"overflow":"visible","max-width":"1200px"},"mobile":{"height":"10px"},"pad":{"height":"20px"}},"needfix":1,"diyShowName":"\u533a\u57df\u5e03\u5c40","name":"layout","style":"autoLayout","settingsBox":{"showTitle":"\u533a\u57df\u5e03\u5c40\u8bbe\u7f6e","setList":{"\u6837\u5f0f":{"isDefault":"true","mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}}},"eventSet":{"scrollView":"none","type":"none"},"data":{"showat":null}},"comm_layout_footer":{"diyShowName":"\u5171\u4eab\u5e95\u90e8","css":{"pc":{"height":"520px","z-index":1000},"content":{"overflow":"visible","max-width":"1200px"},"customCss":{"pc":{"modelArea":{"background-repeat":"repeat-x!important","background-size":"auto 100%","background-position":"50% 50% !important","background":"#333333"}},"pad":{"modelArea":{"background-size":"auto 100%"}}},"pad":{"height":"440px"},"mobile":{"height":"120px","z-index":9999}},"settingsBox":{"showTitle":"\u5171\u4eab\u5e95\u90e8\u8bbe\u7f6e","setList":{"\u6837\u5f0f":{"isDefault":"true","mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}}},"eventSet":{"scrollView":"none","type":"none"},"autoHeight":"false"},"text_style_01_1575602059365":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"80%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"450px","left":"10%","z-index":2},"pad":{"top":"380px","left":"10%","z-index":1,"width":"80%"},"mobile":{"width":"80%","font-size":"12px","color":"#333","line-height":"1.6","top":"20px","left":"10%","display":"block","height":"100px"},"customCss":{"pc":{"@view_contents":{"color":"#999999","line-height":"22px","text-align":"center","font-size":"14px"}},"mobile":{"@view_contents":{"font-size":"12px","line-height":"18px","text-align":"center","height":"18px"}},"pad":{"@view_contents":{"font-size":"13px"}}},"content":{"overflow":"visible"}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"div_a_includeBlock_1578303272572":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"initSettingElementEvent"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u5bb9\u5668\u6a21\u5757\u5c5e\u6027\u8bbe\u7f6e"},"style":"a_includeBlock","styleShowName":"\u81ea\u7531\u5bb9\u5668","styleKind":"\u81ea\u7531\u5bb9\u5668","styleHelpId":1249,"viewCtrl":"includeBlock","isInclude":"5","allowIncludeSelf":"1","css":{"pc":{"width":"28%","height":"352px","position":"absolute","top":"60px","left":"0%"},"pad":{"top":"30px","left":"1%","height":"340px"},"mobile":{"width":"100%","height":"44px","top":"494px","left":"0%","display":"none"}},"name":"div","kind":"\u6392\u7248\u5e03\u5c40","showname":"\u9ed8\u8ba4","diyShowName":"\u81ea\u7531\u5bb9\u5668-\u81ea\u7531\u5bb9\u5668","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}}},"text_style_01_1578303148727":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"120px","left":"0%","z-index":4},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"238px","left":"2%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"32px","line-height":"38px","color":"#ff6766"}},"pad":{"@view_contents":{"font-size":"30px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"text_style_01_1579311980238":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"0px","left":"0%","z-index":2},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"0%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"24px","line-height":"38px","color":"#e5e5e5"}},"pad":{"@view_contents":{"font-size":"22px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"text_style_01_1579312014094":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"40px","left":"0%","z-index":4},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"0%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"14px","line-height":"38px","color":"#e5e5e5"}},"pad":{"@view_contents":{"font-size":"13px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"div_blank_new05_1579312181013":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6c34\u5e73\u7ebf\u6a21\u5757\u5c5e\u6027\u8bbe\u7f6e","\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"textSetup"}},"style":"blank_new05","styleKind":"\u6c34\u5e73\u7ebf\u6a21\u5757","styleHelpId":1248,"viewCtrl":"blank02","css":{"pc":{"width":"100%","position":"absolute","left":"0%","top":"75px","z-index":3},"pad":{"left":"0%","width":"100%"},"mobile":{"width":"100px","top":"0px","left":"33.4983498349835%"},"customCss":{"pc":{"modelArea":{"box-sizing":"border-box"},"@roundcs":{"border-color":"#999999"}},"pad":{"modelArea":{"box-sizing":"border-box"}},"mobile":{"modelArea":{"box-sizing":"border-box"}}}},"lock":{"height":"true"},"name":"div","kind":"\u6392\u7248\u5e03\u5c40","showname":"\u9ed8\u8ba4","needfix":1,"diyShowName":"\u6c34\u5e73\u7ebf\u6a21\u5757","eventSet":{"scrollView":"none","type":"none"}},"text_style_01_1579312229265":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"180px","left":"0%","z-index":4},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"0%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"24px","line-height":"38px","color":"#e5e5e5"}},"pad":{"@view_contents":{"font-size":"22px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"text_style_01_1579312287432":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"220px","left":"0%","z-index":1},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"0%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"14px","line-height":"38px","color":"#e5e5e5"}},"pad":{"@view_contents":{"font-size":"13px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"div_blank_new05_1579312334751":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6c34\u5e73\u7ebf\u6a21\u5757\u5c5e\u6027\u8bbe\u7f6e","\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"textSetup"}},"style":"blank_new05","styleKind":"\u6c34\u5e73\u7ebf\u6a21\u5757","styleHelpId":1248,"viewCtrl":"blank02","css":{"pc":{"width":"100%","position":"absolute","left":"0%","top":"255px","z-index":3},"pad":{"width":"33.003300330033%"},"mobile":{"width":"33.003300330033%","top":"0px","left":"0%"},"customCss":{"pc":{"modelArea":{"box-sizing":"border-box"},"@roundcs":{"border-color":"#999999"}},"pad":{"modelArea":{"box-sizing":"border-box"}},"mobile":{"modelArea":{"box-sizing":"border-box"}}}},"lock":{"height":"true"},"name":"div","kind":"\u6392\u7248\u5e03\u5c40","showname":"\u9ed8\u8ba4","needfix":1,"diyShowName":"\u6c34\u5e73\u7ebf\u6a21\u5757","eventSet":{"scrollView":"none","type":"none"}},"button_style_04_1579312368696":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"buttonConfigNew","setupFunc":"btnSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6309\u94ae\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_04","diyShowName":"\u6309\u94ae\u98ce\u683c4","styleShowName":"\u98ce\u683c4","styleShowImg":"\/sysTools\/Model\/viewsRes\/showImg\/button_04.png","styleShowClass":"two","styleKind":"\u6587\u5b57\u6309\u94ae","viewCtrl":"button","css":{"pc":{"width":"33%","left":"0%","top":"290px","position":"absolute","z-index":2},"pad":{"width":"33%"},"mobile":{"display":"block","top":"0px","width":"100%","left":"0%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@btnaSet":{"background":"transparent","color":"#ff6766","border-radius":"initial","border-width":"1px","border-style":"solid","border-color":"#ff6766","font-family":"Microsoft YaHei","height":"32px"},"@btnaSet:hover":{"background":"#ff6766","color":"#ffffff"}},"mobile":{"@btnaSet":{"font-size":"12px","font-family":"Microsoft YaHei","border-width":"0px","border-radius":"40px","height":"36px"}}}},"lock":{"height":"true"},"data":{"linkType":"1","linkTypeForm":"11","buttonVal":"\u8054\u7cfb\u6211\u4eec","btnType":"defaultButton","selectVal":2801221,"showat":null},"name":"button","kind":"\u6309\u94ae\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"pc":[],"mobile":{"position":"false"}},"params":{"animate":"fadeInDown","duration":"2","delay":"0.25","iteration":"1","offset":"0"}},"div_a_includeBlock_1578303924489":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"initSettingElementEvent"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u5bb9\u5668\u6a21\u5757\u5c5e\u6027\u8bbe\u7f6e"},"style":"a_includeBlock","styleShowName":"\u81ea\u7531\u5bb9\u5668","styleKind":"\u81ea\u7531\u5bb9\u5668","styleHelpId":1249,"viewCtrl":"includeBlock","isInclude":"5","allowIncludeSelf":"1","css":{"pc":{"width":"20%","height":"173px","position":"absolute","top":"60px","left":"80%","z-index":9999},"pad":{"top":"30px","left":"75%","width":"24%"},"mobile":{"width":"100%","height":"512px","top":"787px","left":"0%","display":"none"}},"name":"div","kind":"\u6392\u7248\u5e03\u5c40","showname":"\u9ed8\u8ba4","diyShowName":"\u81ea\u7531\u5bb9\u5668-\u81ea\u7531\u5bb9\u5668","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}}},"image_style_11_1578303970642":{"settingsBox":{"setList":{"\u5e38\u89c4":{"isDefault":"true","mod":"viewSettingsHcl","act":"photoConfig","setupFunc":"imageSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u56fe\u7247\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_11","diyShowName":"\u56fe\u7247\u2014\u76f8\u518c","styleShowName":"\u98ce\u683c11","styleKind":"\u56fe\u7247\u7ec4","styleHelpId":1255,"viewCtrl":"photo","css":{"pc":{"width":"92%","position":"absolute","left":"3.997395833333333%","top":"10px","z-index":2},"pad":[],"mobile":{"height":"157px","top":"24px","left":"34.873487348734876%","width":"30.25302530253025%"},"content":{"overflow":"visible"}},"lock":{"height":"true"},"doubleClickFunc":"photoGroupSelect","mouseMenu":[{"name":"\u9009\u62e9\u56fe\u7247","func":"photoGroupSelect()","ico":"fa-file-image-o"}],"sizeCallbackFunc":"setImgCen","prodhnumpc":4,"prodhnumpad":4,"params":{"filelist":"https:\/\/cdn.yun.sooce.cn\/2\/125373\/jpg\/1589362452520a4a4d417a87aa8da.jpg?version=1589362459,https:\/\/cdn.yun.sooce.cn\/2\/125373\/jpg\/15893624525149e6d8a3cb93d5a83.jpg?version=1589362458,https:\/\/cdn.yun.sooce.cn\/2\/125373\/jpg\/15893624525064ee11cc513f7b50f.jpg?version=1589362457,https:\/\/cdn.yun.sooce.cn\/2\/125373\/jpg\/15893624525132aeafb21448a0d69.jpg?version=1589362457,https:\/\/cdn.yun.sooce.cn\/2\/125373\/jpg\/15893624525106208640027668d0a.jpg?version=1589362456,https:\/\/cdn.yun.sooce.cn\/2\/125373\/jpg\/15893624525112bd2f3b2240f8298.jpg?version=1589362456,","titlelist":",,,,,,","subtitlelist":",,,,,,","textlist":",,,,,,","btnNamelist":",,,,,,","urllist":",,,,,,","selectlist":",,,,,,","groupNVallist":",,,,,,","newspagelist":",,,,,,","newsidlist":",,,,,,","groupVallist":",,,,,,","propagelist":",,,,,,","proidlist":",,,,,,","btnTimelist":",,,,,,","bgimglist":",,,,,,"},"name":"image","kind":"\u56fe\u7247\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"data":{"newPicScale":"2:3","prodhnumpc":"2","hangnumpc":"2","prodhnum":"2","prodnum":"4","prodznumpc":"5","farpc":"5","prodznum":"5","enlargeImg":"1","prodhnumpad":"2","hangnumpad":"2"},"viewLock":{"mobile":{"position":"false"}},"setFixed":"2","needfix":1,"moveEdit":[]},"text_default_1579499908478":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u81ea\u5b9a\u4e49\u89c6\u56fe\u5c5e\u6027\u8bbe\u7f6e"},"style":"default","styleShowName":"HTML\u6a21\u5757","styleKind":"HTML","styleHelpId":1296,"styleSort":1,"viewCtrl":"html","css":{"pc":{"width":"100%","height":"40px","position":"absolute","top":"0px","left":"0%","z-index":1},"pad":[],"mobile":{"width":"100%","height":"300px","top":"181px","left":"0%"}},"doubleClickFunc":"diyViewSelect","mouseMenu":[{"name":"HTML\u4ee3\u7801\u7f16\u8f91","func":"diyViewSelect()","ico":"fa-code"}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","needfix":1,"diyShowName":"HTML-HTML\u6a21\u5757","eventSet":{"scrollView":"none","type":"none"},"moveEdit":[]},"div_a_includeBlock_1578304240250":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"blankDivConfig","setupFunc":"initSettingElementEvent"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u5bb9\u5668\u6a21\u5757\u5c5e\u6027\u8bbe\u7f6e"},"style":"a_includeBlock","styleShowName":"\u81ea\u7531\u5bb9\u5668","styleKind":"\u81ea\u7531\u5bb9\u5668","styleHelpId":1249,"viewCtrl":"includeBlock","isInclude":"5","allowIncludeSelf":"1","css":{"pc":{"width":"20%","height":"160px","position":"absolute","top":"250px","left":"80%"},"pad":{"top":"200px","left":"75%","width":"24%","height":"170px"},"mobile":{"width":"100%","height":"235px","top":"1235px","left":"0%","display":"none"}},"name":"div","kind":"\u6392\u7248\u5e03\u5c40","showname":"\u9ed8\u8ba4","diyShowName":"\u81ea\u7531\u5bb9\u5668-\u81ea\u7531\u5bb9\u5668","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}}},"text_style_01_1578304240487":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"50%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"105px","left":"0%","z-index":2},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"2%","display":"none"},"customCss":{"pc":{"@view_contents":{"font-size":"12px","line-height":"28px","color":"#ffffff","font-weight":"normal","text-align":"center"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"needfix":1,"moveEdit":[],"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"image_style_01_1578304752776":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"imageConfig","setupFunc":"imageSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u56fe\u7247\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u56fe\u7247-\u5355\u5f20","styleShowName":"\u5355\u5f20\u56fe\u7247","styleKind":"\u5355\u5f20\u56fe\u7247","styleHelpId":1254,"viewCtrl":"default","css":{"pc":{"width":"50%","height":"100px","position":"absolute","left":"0%","top":"0px"},"pad":{"left":"0%","width":"50%"},"mobile":[],"content":{"overflow":"visible"}},"doubleClickFunc":"imageViewSelect","mouseMenu":[{"name":"\u9009\u62e9\u56fe\u7247","func":"imageViewSelect()","ico":"fa-file-image-o"}],"sizeCallbackFunc":"setImgCen","imgUrl":"\/images\/matLibrary\/webImg\/image01_default.jpg","name":"image","kind":"\u56fe\u7247\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"data":{"imgUrl":"https:\/\/cdn.yun.sooce.cn\/2\/125373\/png\/15893625075085159bc7bb0dc342b.png?version=0","imgStyle":{"pc":"3","pad":"3","mobile":null}},"viewLock":{"mobile":{"position":"false"}},"params":{"filelist":"","urllist":"","propagelist":"","newspagelist":"","proidlist":"","groupVallist":"","newsidlist":"","groupNVallist":""}},"image_style_01_1578304855901":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"imageConfig","setupFunc":"imageSetup"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u56fe\u7247\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u56fe\u7247-\u5355\u5f20","styleShowName":"\u5355\u5f20\u56fe\u7247","styleKind":"\u5355\u5f20\u56fe\u7247","styleHelpId":1254,"viewCtrl":"default","css":{"pc":{"width":"50%","height":"100px","position":"absolute","left":"50%","top":"0px"},"pad":[],"mobile":[],"content":{"overflow":"visible"}},"doubleClickFunc":"imageViewSelect","mouseMenu":[{"name":"\u9009\u62e9\u56fe\u7247","func":"imageViewSelect()","ico":"fa-file-image-o"}],"sizeCallbackFunc":"setImgCen","imgUrl":"\/images\/matLibrary\/webImg\/image01_default.jpg","name":"image","kind":"\u56fe\u7247\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"data":{"imgUrl":"https:\/\/cdn.yun.sooce.cn\/2\/125373\/png\/15893625075085159bc7bb0dc342b.png?version=1589362510","imgStyle":{"pc":"3","pad":"3","mobile":null}},"moveEdit":[],"viewLock":{"mobile":{"position":"false"}},"params":{"filelist":"","urllist":"","propagelist":"","newspagelist":"","proidlist":"","groupVallist":"","newsidlist":"","groupNVallist":""}},"text_style_01_1578304868358":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"50%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"105px","left":"50%","z-index":2},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"0%","display":"none"},"customCss":{"pc":{"@view_contents":{"font-size":"12px","line-height":"28px","color":"#ffffff","font-weight":"normal","text-align":"center"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"needfix":1,"moveEdit":[],"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true"},"qqol_style_01_1575620923404":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"qqOnLineConfig","setupFunc":"qqOnLineSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"QQ\u5728\u7ebf\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"QQ\u5728\u7ebf-\u98ce\u683c1","styleShowName":"\u98ce\u683c1","styleKind":"AAA","styleHelpId":1284,"viewCtrl":"default","css":{"pc":{"width":"17.497348886532343%","position":"absolute","top":"7px","left":"41.25132555673383%"},"pad":{"top":"7px","left":"77.00324761399789%","width":"17.497348886532343%"},"mobile":{"width":"96%","top":"0px","left":"2%","display":"none"},"content":{"overflow":"visible"}},"lock":{"height":"true"},"name":"qqol","kind":"\u5176\u5b83\u5de5\u5177","showname":"QQ\u5728\u7ebf","data":{"qqolList":["{\"item-type\":\"qq\",\"item-name\":\"QQ\",\"qq\":\"1370224171\",\"qq-icon\":\"51\",\"qq-text\":\"\u5ba2\u670d\u4e00\"}","{\"item-type\":\"qq\",\"item-name\":\"QQ\",\"qq\":\"1370224171\",\"qq-icon\":\"51\",\"qq-text\":\"\u5ba2\u670d\u4e8c\"}","{\"item-type\":\"separator\",\"item-name\":\"\u5206\u9694\u7ebf\",\"separator-height\":\"2\",\"separator-color\":\"#a0a0a0\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u5de5\u4f5c\u65f6\u95f4\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u5468\u4e00\u81f3\u5468\u65e5 \uff1a8:00-18:00\"}","{\"item-type\":\"separator\",\"item-name\":\"\u5206\u9694\u7ebf\",\"separator-height\":\"2\",\"separator-color\":\"#a0a0a0\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u8054\u7cfb\u65b9\u5f0f\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u7535\u8bdd1\uff1a13573245870\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u7535\u8bdd2\uff1a 13573245870\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u5fae\u4fe1\uff1a 13573245870\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"QQ\uff1a1370224171\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"QQ\uff1a1370224171\"}","{\"item-type\":\"txt\",\"item-name\":\"\u6587\u5b57\",\"txt-text\":\"\u90ae\u7bb1\uff1a1370224171@qq.com\"}"],"width":"200","border_width":"3","color_base":"#ff6766","hide":"on","qrcode_img":""},"eventSet":{"scrollView":"none","type":"none"},"needfix":1,"moveEdit":[],"viewLock":{"mobile":{"position":"false"}}},"button_style_04_1578627329765":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"buttonConfigNew","setupFunc":"btnSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6309\u94ae\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_04","diyShowName":"\u6309\u94ae\u98ce\u683c4","styleShowName":"\u98ce\u683c4","styleShowImg":"\/sysTools\/Model\/viewsRes\/showImg\/button_04.png","styleShowClass":"two","styleKind":"\u6587\u5b57\u6309\u94ae","viewCtrl":"button","css":{"pc":{"width":"10%","left":"90%","top":"441px","position":"absolute"},"pad":{"left":"88%","top":"370px"},"mobile":{"width":"96%","left":"2%","top":"60px","z-index":3},"content":{"overflow":"visible"},"customCss":{"pc":{"@btnaSet":{"background":"transparent","color":"#ffffff","border-radius":"initial","font-family":"Microsoft YaHei","font-size":"14px"},"@btnaSet:hover":{"background":"transparent","color":"#6aa84f","font-size":"14px","font-family":"Microsoft YaHei"}},"mobile":{"@btnaSet":{"border-radius":"40px","height":"30px","text-shadow":"transparent 0px 0px 0px","font-size":"12px"},"@btnaSet:hover":{"font-size":"12px"}}}},"lock":{"height":"true"},"data":{"linkType":"6","linkTypeForm":"11","buttonVal":"\u8fd4\u56de\u9876\u90e8","btnType":"defaultButton","selectVal":2801221},"name":"button","kind":"\u6309\u94ae\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"pc":[],"mobile":{"position":"false"}},"params":{"duration":"2","delay":"0.25","iteration":"1","offset":"0"},"moveEdit":[]},"customForm_form_1579313077263":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"formConfig","setupFunc":"formSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u8868\u5355\u5c5e\u6027\u8bbe\u7f6e"},"style":"form","diyShowName":"\u8868\u5355-\u57fa\u7840\u8868\u5355","styleKind":"AAA","isInclude":"1","viewCtrl":"form","editType":{"html":"false","css":"true","js":"true"},"css":{"pc":{"width":"34%","height":"350px","position":"absolute","top":"60px","left":"38%"},"pad":{"top":"30px","left":"36%","height":"340px"},"mobile":{"width":"100%","height":"438px","top":"0px","left":"0%","display":"none"}},"name":"customForm","kind":"\u8868\u5355\u6a21\u5757","showname":"\u81ea\u5b9a\u4e49","eventSet":{"scrollView":"none","type":"none"}},"text_style_01_1579313117572":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"0px","left":"0%","z-index":1},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"0px","left":"2%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"24px","line-height":"38px","color":"#e5e5e5"}},"pad":{"@view_contents":{"font-size":"22px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true","parentSet":{"viewCtrl":"form"}},"text_style_01_1579313134788":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textConfig","setupFunc":"textSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6587\u5b57\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_01","diyShowName":"\u6587\u672c\u6a21\u5757","styleKind":"\u6587\u672c\u6a21\u5757","styleSort":"99","viewCtrl":"default","css":{"pc":{"width":"100%","font-size":"16px","color":"#333","line-height":"1.8","font-family":"Microsoft YaHei","position":"absolute","top":"40px","left":"0%","z-index":4},"pad":{"z-index":3},"mobile":{"width":"96%","font-size":"12px","color":"#333","line-height":"1.6","top":"48px","left":"2%","display":"block"},"customCss":{"pc":{"@view_contents":{"font-size":"14px","line-height":"38px","color":"#e5e5e5"}},"pad":{"@view_contents":{"font-size":"13px"}}}},"lock":{"height":"true"},"showEditTip":"\u53cc\u51fb\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","doubleClickFunc":"editTextView","mouseMenu":[{"name":"\u7f16\u8f91\u6587\u5b57\u5185\u5bb9","func":"editTextView()","ico":""}],"name":"text","kind":"\u6587\u5b57\u6a21\u5757","showname":"\u9ed8\u8ba4","eventSet":{"scrollView":"none","type":"none"},"viewLock":{"mobile":{"position":"false"}},"fenxiaoEdit":"true","parentSet":{"viewCtrl":"form"}},"customForm_style_input_01_1579313171983":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"inputConfig","setupFunc":"initSettingElementEvent"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u8f93\u5165\u6846\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_input_01","diyShowName":"\u8868\u5355-\u8f93\u5165\u6846 ","styleShowName":"\u98ce\u683c1","styleKind":"AAA","viewCtrl":"input","css":{"pc":{"width":"100%","position":"absolute","left":"0%","top":"85px","z-index":2},"pad":{"left":"0%","width":"100%"},"mobile":{"width":"96%","top":"96px","left":"2%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@inputSet":{"font-size":"14px","background":"transparent","color":"#ffffff","line-height":"40px","height":"40px","padding-top":"10px","padding-bottom":"10px","border-radius":"2px","padding-left":"10px","padding-right":"10px"}}}},"lock":{"height":"true"},"name":"customForm","kind":"\u8868\u5355\u6a21\u5757","showname":"\u81ea\u5b9a\u4e49","eventSet":{"scrollView":"none","type":"none"},"parentSet":{"viewCtrl":"form"}},"customForm_style_input_01_1579313485060":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"inputConfig","setupFunc":"initSettingElementEvent"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u8f93\u5165\u6846\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_input_01","diyShowName":"\u8868\u5355-\u8f93\u5165\u6846 ","styleShowName":"\u98ce\u683c1","styleKind":"AAA","viewCtrl":"input","css":{"pc":{"width":"100%","position":"absolute","left":"0%","top":"145px","z-index":2},"pad":{"width":"100%"},"mobile":{"width":"96%","top":"146px","left":"2%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@inputSet":{"font-size":"14px","background":"transparent","color":"#ffffff","line-height":"40px","height":"40px","padding-top":"10px","padding-bottom":"10px","border-radius":"2px","padding-left":"10px","padding-right":"10px"}}}},"lock":{"height":"true"},"name":"customForm","kind":"\u8868\u5355\u6a21\u5757","showname":"\u81ea\u5b9a\u4e49","eventSet":{"scrollView":"none","type":"none"},"data":{"inputTips":"\u8bf7\u8f93\u5165\u60a8\u7684\u624b\u673a\u53f7","inputPattern":"mobile"},"parentSet":{"viewCtrl":"form"}},"customForm_style_textarea_01_1579313579008":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"textareaConfig","setupFunc":"initSettingElementEvent"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u591a\u884c\u6587\u672c\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_textarea_01","diyShowName":"\u8868\u5355-\u591a\u884c\u6587\u672c","styleShowName":"\u98ce\u683c1","styleKind":"AAA","viewCtrl":"textarea","css":{"pc":{"width":"100%","height":"62px","position":"absolute","left":"0%","top":"205px"},"pad":{"left":"0%","width":"100%"},"mobile":{"width":"96%","height":"200px","top":"196px","left":"2%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@inputSet":{"background":"transparent","font-size":"14px","color":"#ffffff","height":"60px","line-height":"24px","border-radius":"2px"}}}},"name":"customForm","kind":"\u8868\u5355\u6a21\u5757","showname":"\u81ea\u5b9a\u4e49","eventSet":{"scrollView":"none","type":"none"},"parentSet":{"viewCtrl":"form"}},"customForm_style_button_01_1579313750950":{"settingsBox":{"setList":{"\u5c5e\u6027":{"isDefault":"true","mod":"viewSettingsHcl","act":"buttonConfig","setupFunc":"btnSetup"},"\u98ce\u683c":{"mod":"viewSettingsOne","act":"ShowStyle"},"\u52a8\u753b":{"mod":"viewSettings","act":"anime","setupFunc":"setBoxAnime"},"\u6837\u5f0f":{"mod":"viewSettingsCustom","act":"CustomConfig","setupFunc":"SettingtabChange,SettingCustomListen"},"\u5168\u5c40":{"mod":"viewSettings","act":"main","setupFunc":"setBoxMain"}},"showTitle":"\u6309\u94ae\u5c5e\u6027\u8bbe\u7f6e"},"style":"style_button_01","diyShowName":"\u8868\u5355-\u6309\u94ae","styleShowName":"\u98ce\u683c1","styleKind":"AAA","viewCtrl":"button","css":{"pc":{"width":"35%","position":"absolute","left":"0%","top":"288px"},"pad":{"left":"0%","width":"30%"},"mobile":{"width":"96%","top":"406px","left":"2%"},"content":{"overflow":"visible"},"customCss":{"pc":{"@btnaSet":{"border-color":"#ff6766","background":"#ff6766","color":"#ffffff","border-radius":"2px"}}}},"lock":{"height":"true"},"data":{"linkType":1,"linkTypeForm":11,"buttonVal":"\u7acb\u5373\u63d0\u4ea4","btnType":"submit"},"name":"customForm","kind":"\u8868\u5355\u6a21\u5757","showname":"\u81ea\u5b9a\u4e49","eventSet":{"scrollView":"none","type":"none"},"parentSet":{"viewCtrl":"form"}}}