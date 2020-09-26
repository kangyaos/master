var bc=$("#provinceId").val();
var bp=$("#cityId").val();
var dd=$("#countyId").val();
function SelCity(obj,e) {
    var ths = obj;
    var dal =/* '<div class="_citys"><span title="关闭" id="cColse" >×</span><ul id="_citysheng" class="_citys0"><li class="citySel">省份</li><li>城市</li><li>区县</li><li>乡镇</li></ul><div id="_citys0" class="_citys1"></div><div style="display:none" id="_citys1" class="_citys1"></div><div style="display:none" id="_citys2" class="_citys1"></div><div style="display:none" id="_citys3" class="_citys1"></div></div>';*/
    	'<div class="_citys"><span title="关闭" id="cColse" >×</span><ul id="_citysheng" class="_citys0"><li class="citySel">省份</li><li>城市</li><li>区县</li></ul><div id="_citys0" class="_citys1"></div><div style="display:none" id="_citys1" class="_citys1"></div><div style="display:none" id="_citys2" class="_citys1"></div></div>';
    Iput.show({ id: ths, event: e, content: dal,width:"470"});
    $("#cColse").click(function () {
        Iput.colse();
    });
    var tb_province = [];
    var a=$("#place1").val();
    
    var b = province;
    for (var i = 0, len = b.length; i < len; i++) {
        tb_province.push('<a data-level="0" data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '">' + b[i]['name'] + '</a>');
    }
    $("#_citys0").append(tb_province.join(""));
    $("#_citys0 a").click(function () {
        var g = getCity($(this).attr("data-id"));
       bc=$(this).data("name");
       $("#_citys1 a").remove();
        $("#_citys1").append(g);
        $("._citys1").hide();
        $("._citys1:eq(1)").show();
        $("#_citys0 a,#_citys1 a").removeClass("AreaS");
        $(this).addClass("AreaS");
        var lev = $(this).data("name");
        ths.value = $(this).data("name");
        $("#provinceId").val($(this).data("id"));
         $("#provinceId").attr("data-id", $(this).data("id"));
       
        $("#_citys1 a").click(function () {
            $("#_citys1 a,#_citys2 a").removeClass("AreaS");
            $(this).addClass("AreaS");
            var lev =  $(this).data("name");
             bp = $(this).data("name");
             $("#cityId").attr("data-id", $(this).data("id"));
             $("#cityId").val($(this).data("id"));
          
          
            ths.value = bc+ $(this).data("name");

            var ar = getArea($(this).attr("data-id"));

            $("#_citys2 a").remove();
            $("#_citys2").append(ar);
            $("._citys1").hide();
            $("._citys1:eq(2)").show();

            $("#_citys2 a").click(function () {
                $("#_citys2 a").removeClass("AreaS");
                $(this).addClass("AreaS");
                dd = $(this).data("name");
                $("#countyId").val($(this).data("id"));
                $("#countyId").attr("data-id", $(this).data("id"));
               
             
                ths.value = bc + bp + $(this).data("name");
                Iput.colse();
                /*
                var ar = getAreas($(this).attr("data-id"));
                
                
                  $("#_citys3 a").remove();
                  $("#_citys3").append(ar);*/
                  $("._citys1").hide();
                
                  $("._citys2").hide();
                
                  $("._citys1:eq(2)").show();
                /*
                $("#_citys3 a").click(function () {
                    $("#_citys3 a").removeClass("AreaS");
                    $(this).addClass("AreaS");
                    $("#townId").val($(this).data("id"));
                   
                   $("#townId").attr("data-id", $(this).data("id"));
                   ths.value = bc + bp +dd+ $(this).data("name");
                    
                    Iput.colse();
                    
                });*/
                
              
                
            });

        });
    });
    $("#_citysheng li").click(function () {
        $("#_citysheng li").removeClass("citySel");
        $(this).addClass("citySel");
        var s = $("#_citysheng li").index(this);
        $("._citys1").hide();
        if(s==1&&null!=$("#cityId").attr("data-id")){
        	console.log("1a");
        	  var g = getCity( $("#provinceId").attr("data-id") );
        	
        	  $("#_citys1").html("");
             $("#_citys1").append(g);
           $("#_citys1 a").click(function () {
                 $("#_citys1 a,#_citys2 a").removeClass("AreaS");
                 $(this).addClass("AreaS");
                  var lev =  $(this).data("name");
                  bp = $(this).data("name");
                  $("#cityId").attr("data-id", $(this).data("id"));
                  $("#cityId").val($(this).data("id"));
               
               
                 ths.value = bc+ $(this).data("name");

                 var ar = getArea($(this).attr("data-id"));

                 $("#_citys2 a").remove();
                 $("#_citys2").append(ar);
                 $("._citys1").hide();
                 $("._citys1:eq(2)").show();

                 $("#_citys2 a").click(function () {
                     $("#_citys2 a").removeClass("AreaS");
                     $(this).addClass("AreaS");
                     dd = $(this).data("name");
                     $("#countyId").val($(this).data("id"));
                     $("#countyId").attr("data-id", $(this).data("id"));
                    
                  
                     ths.value = bc + bp + $(this).data("name");
                    // Iput.colse();
                     
                     var ar = getAreas($(this).attr("data-id"));
                     
                     
                      /*$("#_citys3 a").remove();
                        $("#_citys3").append(ar);*/
                       $("._citys1").hide();
                     
                       $("._citys2").hide();
                     
                       $("._citys1:eq(2)").show();
                     /*
                     $("#_citys3 a").click(function () {
                         $("#_citys3 a").removeClass("AreaS");
                         $(this).addClass("AreaS");
                         $("#townId").val($(this).data("id"));
                        
                        $("#townId").attr("data-id", $(this).data("id"));
                        ths.value = bc + bp +dd+ $(this).data("name");
                         
                         Iput.colse();
                         
                     });*/
                     
                   
                     
                 });

             });
         }else if(s==2&&null!=$("#countyId").attr("data-id")){
        	 console.log("2a");
        	 var g = getArea($("#cityId").attr("data-id"));
        	 $("#_citys2").html("");
             $("#_citys2").append(g);
             $("#_citys2 a").click(function () {
                     $("#_citys2 a").removeClass("AreaS");
                     $(this).addClass("AreaS");
                     dd = $(this).data("name");
                     $("#countyId").val($(this).data("id"));
                     $("#countyId").attr("data-id", $(this).data("id"));
                    
                  
                     ths.value = bc + bp + $(this).data("name");
                     Iput.colse();
                     /*
                     var ar = getAreas($(this).attr("data-id"));
                     
                     
                       $("#_citys3 a").remove();
                       $("#_citys3").append(ar);
                       $("._citys1").hide();
                     
                       $("._citys2").hide();
                     
                       $("._citys1:eq(3)").show();
                     
                     $("#_citys3 a").click(function () {
                         $("#_citys3 a").removeClass("AreaS");
                         $(this).addClass("AreaS");
                         $("#townId").val($(this).data("id"));
                        
                        $("#townId").attr("data-id", $(this).data("id"));
                        ths.value = bc + bp +dd+ $(this).data("name");
                         
                        Iput.colse();
                         
                     });
                     */
                     });

            
        	 
         }else if(s==3&&null!=$("#townId").attr("data-id")){
        	 var g = getAreas($("#countyId").attr("data-id"));
        	 $("#_citys3").html("");
             $("#_citys3").append(g);
             $("#_citys3 a").click(function () {
                         $("#_citys3 a").removeClass("AreaS");
                         $(this).addClass("AreaS");
                         $("#townId").val($(this).data("id"));
                        
                        $("#townId").attr("data-id", $(this).data("id"));
                        ths.value = bc + bp +dd+ $(this).data("name");
                         
                        Iput.colse();
                         
                     });
               }
        $("._citys1:eq(" + s + ")").show();
        
      });
}

function getCity(c) {

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
function getArea(c) {
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

function getAreas(c) {

    var e ;
    var f = [];
    var g = '';
    $.ajax({
		async : false,
		type : "get",
		url : "getcity.json?id=" + c + "&leval=4",
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
    $("#_citysheng li:eq(3)").addClass("citySel");
    return g;
}
	
	
	
	