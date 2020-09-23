/**
 * 
 */
var clientW = document.documentElement.clientWidth;
$(document).ready(function() {
	var autoSize = clientW/6.4;
	$("html").css("font-size",autoSize+"px");
	
    $(".prizeBtn").click(function() {
    	$("#prizeWindow").show();
    });
    $(".ruleWindowCloseBtn").click(function() {
    	$("#prizeWindow").hide();
    });
    $(".prize_item").each(function() {
    	var expire = $(this).find(".prize-expire").html();
		if (expire == '兑奖') {
			$(this).click(function() {
				var id = $(this).attr("id").replace(/item/, "");
				var name = $(this).find(".prize_name").html();
				var validity = $(this).find(".prize_date").html();
				var strdate = validity.split("~")[1];
				openModal({
					id : id,
					name : name,
					validity : strdate
				});
			});
		}
	});
    
    var btncls = $("#btn-attend").attr("class");
    if(btncls == undefined){
    	attendClick();
    }
    //中奖记录按钮是否显示
    if($(".prize_item").length==0){
    	$(".prizeBtn").hide();
    }
});

var attendClick = function(){
	$("#btn-attend").click(function() {
    	$.ajax({
			url : "signin",
			type : "post",
			async : false,
			success : function(data) {
				console.log("sucess");
				//签到成功
				if(data && data.days){
					$("#days").html(data.days);
					$("#btn-attend").addClass("disable");
					$("#btn-attend").unbind();
					$("#prize-today").hide();
					//获得奖励
					if (data.id) {
						openModal(data);
					}
				}
			},
			error : function(err) {
				console.log("error");
			}
		});
    });
};

var openModal = function(item){
	var modalhtml = '<section class="modal-new modal">\
		<div class="inner">\
		<button class="close"></button>\
		<header class="win-title"></header>\
		<div class="paper"></div>\
		<section class="win-container">\
			<div class="win-content">\
				<div class="promotion clearfix">\
					<div class="pull-left promotion-img">\
						<img src="./assets/image/timg.png" alt="">\
					</div>\
					<div class="pull-left text-name">\
						<div class="promotion-name">'+item.name+'</div>\
						<div class="validity">有效期: '+item.validity+'</div>\
					</div>\
				</div>\
				<div class="color-white text-center"></div>\
			</div>\
			<a class="get-btn" id="get-btn">兑奖</a>\
		</section>\
		</div>\
		</section>';
	$("body").append(modalhtml);
	//已达成
	if($("#tadk"+item.id+" .specialImg").length==0){
		$("#tadk"+item.id).append('<img src="./assets/image/success-icon.png" alt="" class="specialImg">');
	}
	//中奖记录
	$(".prizeBtn").show();
	var prizehtml = '<div class="prize_item " id="item'+item.id+'">\
		<img class="prize_img" src="./assets/image/timg.png">\
		<div class="prize_name ">'+item.name+'</div>\
		<div class="prize_date ">有效期：<br>'+item.awardtime+' ~ '+item.validity+'</div>\
		<button class="prize-expire">兑奖</button>	</div>';
	if($("#item"+item.id).length==0){
		$("#prize_list").append(prizehtml);
		$("#item"+item.id).click(function() {
			openModal({
				id : item.id,
				name : item.name,
				validity : item.validity
			});
		});
	}
	$(".close").click(function() {
    	$(".modal").remove();
    });
	$(".get-btn").click(function() {
		cashAward(item.id);
	});
};

var cashAward = function(id){
	$.ajax({
		url : "signin",
		data : {taskId:id},
		async : false,
		success : function(data) {
			if(data){
				openSucess(id);
			}
		},
		error : function(err) {
			console.log("error");
		}
	});
};

var openSucess = function(id){
	var modalhtml = '<section class="modal-new modal">\
		<div class="inner">\
		<button class="close"></button>\
		<div class="paper"></div>\
		<section class="win-container" style="width: 5rem;">\
		<img src="assets/image/tt.png" width="100%">\
		</section></div></section>';
	$(".modal").remove();
	$("body").append(modalhtml);
	$(".close").click(function() {
    	$(".modal").remove();
    	$("#item"+id).unbind();
    	$("#item"+id).find(".prize-expire").html("已兑奖");
    });
};
