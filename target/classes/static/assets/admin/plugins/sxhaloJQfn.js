/**
 * jQuery扩展
 */
$.fn.setselectval = function(pid, tval) {
    var that = $(this);
	var selected = (tval==undefined?that.val():tval);
	if(pid=='') return;
	$.ajax({
		type : "post",
		url : "GetAllSelect.json",
		data : {'pid' : pid},
		success : function(list) {
			that.empty();
			if(pid==0)
				that.append("<option value=''>部门</option>");
			if(pid==1)
				that.append("<option value=''>角色</option>");
			if(pid==2)
				that.append("<option value=''>栏目</option>");
			if(pid==3)
				that.append("<option value=''></option>");
			for (var i = 0; i < list.length; i++) {
	        	var node = list[i];
	        	if(selected == node.id){
	        		that.append("<option value="+node.id+" selected='selected'>"+node.text+"</option>");
	        	}else{
	        		that.append("<option value="+node.id+">"+node.text+"</option>");
	        	}
	        }
		}
	});
};
(function($) {
	$.fn.treeSelect = function(name,root) {
		var Offset = function Offset(e) {
			// 取标签的绝对位置
			var t = e.offsetTop;
			var l = e.offsetLeft;
			var w = e.offsetWidth;
			var h = e.offsetHeight;
			while (e = e.offsetParent) {
				t += e.offsetTop;
				l += e.offsetLeft;
			}
			return {
				top : t,
				left : l,
				width : w,
				height : h
			};
		};

		//取得obj标签的位置。obj:页面上被替代的标签 id；url：jsTree 获得json后台
		var $Obj = $(this);
		var oid = $(this).attr("id");
		var offset_text = Offset($Obj.get(0)); // 取得text所在的位置
		$Obj.css("display", "none");// 隐藏原来的标签
		var $iDiv = $("<div id='selectof" + oid + "'></div>");// 模拟一个div替代test
		$iDiv.css("width", offset_text.width + "px");
		$iDiv.css("height", offset_text.height + "px");
		$iDiv.css("z-index", "2");
		$iDiv.css("fontSize", "14px");
		$iDiv.css("border", "1px solid #e5e5e5");
		$iDiv.css("lineHeight", offset_text.height + "px");
		$iDiv.css("textIndent", "10px");//缩进
		$iDiv.css("background","url(assets/global/plugins/select2/select2.png) "+(offset_text.width-20)+"px top no-repeat");
		
		if ($Obj.val() == "" || $Obj.val() == null) {
			$iDiv.text("请选择");
		} else {
			$iDiv.text($("#"+oid+" option:selected").text());
		}
		$Obj.before($iDiv);// 将DIV添加到text所在的父元素内
        console.log($iDiv)
		$iDiv.click(function(e) {
			e.stopPropagation(); //该方法将停止事件的传播,阻止它被分派到其他 Document节点
			var offset_div = Offset($iDiv.get(0));// 取得text元素的新位置
			if ($("#selectchild" + oid).length == 1) {
				// 判断是否创建过弹出层div
				if (($("#selectchild" + oid + ":hidden").length == 1)) {
					$("#selectchild" + oid).css("top",	offset_div.top + offset_div.height	+ "px");
					$("#selectchild" + oid).css("left",	offset_div.left + "px");
					// 打开
					$("#selectchild" + oid).css("display", "block");
				} else {
					// 隐藏
					$("#selectchild" + oid).css("display", "none");
				}
			} else {
				// 初始一个div放在上一个div下边，当options的替身。
				var $cDiv = $("<div id='selectchild" + oid + "'></div>");
				$cDiv.css("position", "absolute");
				$cDiv.css("top", offset_div.top + offset_div.height + "px");
				$cDiv.css("left", offset_div.left + "px");
				$cDiv.css("width", offset_div.width + "px");
				$cDiv.css("z-index", "3");
				$cDiv.css("background", "#f7f7f7");
				$cDiv.css("border", "1px solid #e5e5e5");
				
				// 生成jsTree
				$treeDiv = $("<div></div>");
				var createdata = function(pid){
					var data = new Array();
					$("#"+oid+" option").each(function(){
						if($(this).data(name)==pid){
							var node = new Object();
							node.id = $(this).val();
							node.text = $(this).text();
							node.children = createdata($(this).val());
							node.state = { 'opened' : true};
							data.push(node);
						}
					});
					//console.log(data);
					return data;
				};
	
				$treeDiv.on("changed.jstree",function(e, data) {
					if (data.selected.length) {
						$iDiv.text(data.instance.get_node(data.selected[0]).text);
						$Obj.val(data.instance.get_node(data.selected[0]).id);
						$cDiv.css("display","none");
					}
				}).jstree({
					'core' : {
						'data' : createdata(root)
					}
				});
	
				$cDiv.click(function(e) {
					e.stopPropagation();
				});
				
				$cDiv.append($treeDiv);
				$("body").append($cDiv);
			}
		});
		//点击除自己外区域关闭下拉
		$(document).click(function() {
			if ($("#selectchild" + oid).css("display") === "block") {
				$("#selectchild" + oid).css("display", "none");
			}
	    });
	};
	$.fn.setyearselect = function() {
		var that = $(this);
		that.empty();		
		var nowyear = new Date().getFullYear();
		for (var i = nowyear-5; i <= nowyear; i++) {
        	if(nowyear == i){
        		that.append("<option value="+i+" selected='selected'>"+i+"</option>");
        	}else{
        		that.append("<option value="+i+">"+i+"</option>");
        	}
        }
	};
	$.fn.setmonthselect = function() {
		var that = $(this);
		that.empty();		
		var nowmonth = new Date().getMonth()+1;
		for (var i = 1; i <= 12; i++) {
        	if(nowmonth == i){
        		that.append("<option value="+i+" selected='selected'>"+i+"月</option>");
        	}else{
        		that.append("<option value="+i+">"+i+"月</option>");
        	}
        }
	};
	$.fn.setweekselect = function(nowwk,maxwk) {
		var that = $(this);
		that.empty();		
		for (var i = 1; i <= maxwk; i++) {
        	if(nowwk == i){
        		that.append("<option value="+i+" selected='selected'>"+i+"周</option>");
        	}else{
        		that.append("<option value="+i+">"+i+"周</option>");
        	}
        }
	};
})(jQuery);

//按指定格式格式化日期
Date.prototype.format = function(format) {
    var o =
    {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};
Date.prototype.addDays = function (d) {
    this.setDate(this.getDate() + d);
};
Date.prototype.addWeeks = function (w) {
    this.addDays(w * 7);
};
Date.prototype.addMonths = function (m) {
    var d = this.getDate();
    this.setMonth(this.getMonth() + m);
    if (this.getDate() < d)
        this.setDate(0);
};
Date.prototype.addYears = function (y) {
    var m = this.getMonth();
    this.setFullYear(this.getFullYear() + y);
    if (m < this.getMonth()) {
        this.setDate(0);
    }
};
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function initprovince(){
	var that=$("#province");
	$.ajax({
		type : "post",
		url : "getProvinces.do",
		success : function(list) {
			that.empty();
			that.append("<option value=''></option>");
			for (var i = 0; i < list.length; i++) {
	        	var node = list[i];
	        	that.append("<option value="+node.regionCode+">"+node.regionName+"</option>");
	         }
		}
	});
  }
function change(value){
	var that=$("#city");
	if(value!=""){
		$.ajax({
			type : "post",
			url : "getCities.do",
			data : {'province' : value},
			success : function(list) {
				that.empty();
				that.append("<option value=''></option>");
				for (var i = 0; i < list.length; i++) {
		        	var node = list[i];
		        	that.append("<option value="+node.regionCode+">"+node.regionName+"</option>");
		         }
			}
		});
	}else{
		that.empty();
		that.append("<option value=''></option>");
	}
}
function changecity(value){
	var that=$("#county");
	if(value!=""){
	 $.ajax({
			type : "post",
			url : "getCounties.do",
			data : {'city' : value},
			success : function(list) {
				that.empty();
				that.append("<option value=''></option>");
				for (var i = 0; i < list.length; i++) {
		        	var node = list[i];
		                   that.append("<option value="+node.regionCode+">"+node.regionName+"</option>");
		         }
			}
		});
	}else{
		that.empty();
		that.append("<option value=''></option>");
	}
}