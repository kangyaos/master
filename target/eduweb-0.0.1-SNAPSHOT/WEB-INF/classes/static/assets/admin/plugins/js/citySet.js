




$(function (){	
	$("#city").click(function (e) {	
	 	SelCity(this,e);
	 });
	
	$("#citys").click(function (e) {
		
	 	SelCity(this,e);
	 	
	 });	
})


function SelCity(obj,e) {
    var ths = obj;
    var dal = '<div class="_citys"><span title="关闭" id="cColse" >×</span><ul id="_citysheng" class="_citys0"><li class="citySel">省份</li><li>城市</li><li>区县</li></ul><div id="_citys0" class="_citys1"></div><div style="display:none" id="_citys1" class="_citys1"></div><div style="display:none" id="_citys2" class="_citys1"></div></div>';
    Iput.show({ id: ths, event: e, content: dal,width:"470"});
    $("#cColse").click(function () {
        Iput.colse();
    });
    var tb_province = [];
    var b = province;
    for (var i = 0, len = b.length; i < len; i++) {
        tb_province.push('<a data-level="0" data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '">' + b[i]['name'] + '</a>');
    }
    $("#_citys0").append(tb_province.join(""));
    $("#_citys0 a").click(function () {
        var g = getCity($(this));
        $("#_citys1 a").remove();
        $("#_citys1").append(g);
        $("._citys1").hide();
        $("._citys1:eq(1)").show();
        $("#_citys0 a,#_citys1 a,#_citys2 a").removeClass("AreaS");
        $(this).addClass("AreaS");
        var lev = $(this).data("name");
        ths.value = $(this).data("name");
        if (document.getElementById("hcity") == null) {
            var hcitys = $('<input>', {
                type: 'hidden',
                name: "hcity",
                "data-id": $(this).data("id"),
                id: "hcity",
                val: lev
            });
            $(ths).after(hcitys);
        }
        else {
            $("#hcity").val(lev);
            $("#hcity").attr("data-id", $(this).data("id"));
        }
        $("#_citys1 a").click(function () {
        	 $("#_citys1 a,#_citys2 a").removeClass("AreaS");
            $(this).addClass("AreaS");
            var lev =  $(this).data("name");
            if (document.getElementById("hproper") == null) {
                var hcitys = $('<input>', {
                    type: 'hidden',
                    name: "hproper",
                    "data-id": $(this).data("id"),
                    id: "hproper",
                    val: lev
                });
                $(ths).after(hcitys);
            }
            else {
                $("#hproper").attr("data-id", $(this).data("id"));
                $("#hproper").val(lev);
            }
           var bc = $("#hcity").val();
            ths.value = bc+ "-" + $(this).data("name");

            var ar = getArea($(this));

            $("#_citys2 a").remove();
            $("#_citys2").append(ar);
            $("._citys1").hide();
            $("._citys1:eq(2)").show();

            $("#_citys2 a").click(function () {
                $("#_citys2 a").removeClass("AreaS");
                $(this).addClass("AreaS");
                var lev = $(this).data("name");
                if (document.getElementById("harea") == null) {
                    var hcitys = $('<input>', {
                        type: 'hidden',
                        name: "harea",
                        "data-id": $(this).data("id"),
                        id: "harea",
                        val: lev
                    });
                    $(ths).after(hcitys);
                }
                else {
                    $("#harea").val(lev);
                    $("#harea").attr("data-id", $(this).data("id"));
                }
                var bc = $("#hcity").val();
                var bp = $("#hproper").val();
                ths.value = bc + "-" + bp + "-" + $(this).data('name');
               // Iput.colse();
                
               // var ar = getAreas($(this));
                
                
              //    $("#_citys3 a").remove();
              //    $("#_citys3").append(ar);
                //  $("._citys1").hide();
                
                //  $("._citys2").hide();
                
            //      $("._citys1:eq(3)").show();
//                
//                $("#_citys3 a").click(function () {
//                    $("#_citys3 a").removeClass("AreaS");
//                    $(this).addClass("AreaS");
//                    var lev = $(this).data("name");
//                    if (document.getElementById("harea") == null) {
//                        var hcitys = $('<input>', {
//                            type: 'hidden',
//                            name: "harea",
//                            "data-id": $(this).data("id"),
//                            id: "hareas",
//                            val: lev
//                        });
//                        $(ths).after(hcitys);
//                    }
//                    else {
//                        $("#hareas").val(lev);
//                        $("#hareas").attr("data-id", $(this).data("id"));
//                    }
//                    var bc = $("#hcity").val();
//                    var bp = $("#hproper").val();
//                    var dd= $("#harea").val();
//                    
//                    ths.value = bc + "-" + bp + "-" +dd+"-"+ $(this).data("name");
//                    
                    Iput.colse();
                    
                    
                    ths.focus();
                    
                //});
                
              
                
            });

        });
    });
    $("#_citysheng li").click(function () {
        $("#_citysheng li").removeClass("citySel");
        $(this).addClass("citySel");
        var s = $("#_citysheng li").index(this);
        $("._citys1").hide();
        if(s==1&&null!=$("#hcity").attr("data-id")){
        	  var g = getCity($("#hcity"));
        	  $("#_citys1").html("");
             $("#_citys1").append(g);
             $("#_citys1 a").click(function () {
            	 $("#_citys1 a,#_citys2 a").removeClass("AreaS");
                 $(this).addClass("AreaS");
                 var lev =  $(this).data("name");
                 if (document.getElementById("hproper") == null) {
                     var hcitys = $('<input>', {
                         type: 'hidden',
                         name: "hproper",
                         "data-id": $(this).data("id"),
                         id: "hproper",
                         val: lev
                     });
                     $(ths).after(hcitys);
                 }
                 else {
                     $("#hproper").attr("data-id", $(this).data("id"));
                     $("#hproper").val(lev);
                 }
                var bc = $("#hcity").val();
                 ths.value = bc+ "-" + $(this).data("name");

                 var ar = getArea($(this));

                 $("#_citys2 a").remove();
                 $("#_citys2").append(ar);
                 $("._citys1").hide();
                 $("._citys1:eq(2)").show();
          
             $("#_citys2 a").click(function () {
            	 $("#_citys2 a").removeClass("AreaS");
                 $(this).addClass("AreaS");
                 var lev = $(this).data("name");
                 if (document.getElementById("harea") == null) {
                     var hcitys = $('<input>', {
                         type: 'hidden',
                         name: "harea",
                         "data-id": $(this).data("id"),
                         id: "harea",
                         val: lev
                     });
                     $(ths).after(hcitys);
                 }
                 else {
                     $("#harea").val(lev);
                     $("#harea").attr("data-id", $(this).data("id"));
                 }
                 var bc = $("#hcity").val();
                 var bp = $("#hproper").val();
                 ths.value = bc + "-" + bp + "-" + $(this).data('name');
                 Iput.colse();
                  ths.focus();
             });
             })
         }else if(s==2&&null!=$("#hproper").attr("data-id")){
        	 var g = getArea($("#hproper"));
        	 $("#_citys2").html("");
             $("#_citys2").append(g);
             $("#_citys2 a").click(function () {
            	 $("#_citys2 a").removeClass("AreaS");
                 $(this).addClass("AreaS");
                 var lev = $(this).data("name");
                 if (document.getElementById("harea") == null) {
                     var hcitys = $('<input>', {
                         type: 'hidden',
                         name: "harea",
                         "data-id": $(this).data("id"),
                         id: "harea",
                         val: lev
                     });
                     $(ths).after(hcitys);
                 }
                 else {
                     $("#harea").val(lev);
                     $("#harea").attr("data-id", $(this).data("id"));
                 }
                 var bc = $("#hcity").val();
                 var bp = $("#hproper").val();
                 ths.value = bc + "-" + bp + "-" + $(this).data('name');
                 Iput.colse();
                 
                 
                 ths.focus();
             });
        	 
         }
        $("._citys1:eq(" + s + ")").show();
        
      });
}

function getCity(obj) {
	
	var c = obj.attr("data-id");
	var e;
	var f = [];
	var g = '';
	$.ajax({
		async : false,
		type : "get",
		url : "getcity.json?id=" + c + "&leval=2",
		dataType : "json",
		success : function(date) {
			e = JSON.parse(date);
			for (var i = 0, clen = e.length; i < clen; i++) {
				g += '<a data-level="1" data-id="' + e[i]['id']
						+ '" data-name="' + e[i]['name'] + '" title="'
						+ e[i]['name'] + '">' + e[i]['name'] + '</a>'
			}
		},
	});
	$("#_citysheng li").removeClass("citySel");
	$("#_citysheng li:eq(1)").addClass("citySel");
	return g;

}
function getArea(obj) {
	var c = obj.attr("data-id");
	var e;
	var f = [];
	var g = '';
	$.ajax({
		async : false,
		type : "get",
		url : "getcity.json?id=" + c + "&leval=3",
		dataType : "json",
		success : function(date) {
			e = JSON.parse(date);
			for (var i = 0, clen = e.length; i < clen; i++) {
				g += '<a data-level="1" data-id="' + e[i]['id']
						+ '" data-name="' + e[i]['name'] + '" title="'
						+ e[i]['name'] + '">' + e[i]['name'] + '</a>'
			}
		}
	});
	$("#_citysheng li").removeClass("citySel");
	$("#_citysheng li:eq(2)").addClass("citySel");
	return g;
}

