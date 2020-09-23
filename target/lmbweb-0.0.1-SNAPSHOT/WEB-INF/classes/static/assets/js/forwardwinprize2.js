document.onkeydown = function() {
	if(event.ctrlKey == true && event.keyCode == 83) {
		event.preventDefault();
	}
};
$(function (){
		if(appname=="kmb"){ $(".a-btn").hide();}
	    $(".a-btn").click(function(){
	       $('#myModal').modal('hide');
		    if(isapp==1&&userPhone==""){
		    	openKmbApp();
		    }else{
		    	  openApp();
		    }
		    return false;
	    
        
	    }); 
	    $(".btn_div").click(function(){
	    	 var ua = window.navigator.userAgent.toLowerCase();
	  	   
	    	if(isapp==1&&userPhone!=""){
	    	 $("body").scrollTop(0);
	    	  document.documentElement.scrollTop=0;
	    	  document.body.addEventListener('touchmove', function (e) {
	              e.preventDefault(); }, { passive: false }); 
	    		  $("#zhezhao1").show();  
	    	 
	  	      
	  		}else{
	  		  $('#myModal').modal('show');
	  		}
	    })
	    
	});  

	function openKmbApp(){
		var ua = window.navigator.userAgent.toLowerCase();
		if (/iphone|ipad|ipod/.test(ua)) {
			document.location = "js://openKmbApp";
		} else if (/android/.test(ua)) {
			javascript:js2Android.openKmbApp();
		}
	}
	function openApp(type){
	   var ua = window.navigator.userAgent.toLowerCase();
	      $ (".prompt").html((type!=null?"注册成功,":"")+"跳转中，请稍等...").show().delay(2000).fadeOut();
	        if (navigator.userAgent.match(/(iPhone|iPod|iPad);?/i)) {
	               window.location = "com.sxhalo.kmbao://Login?recommend="+userPhone;
	            var loadDateTime = new Date();
	            window.setTimeout(function() {
	                var timeOutDateTime = new Date();
	                if (timeOutDateTime - loadDateTime < 5000) {
	                    window.location = "https://itunes.apple.com/cn/app/id1244051559";
	                } else {
	                    window.close();
	                }
	            },3000);
	        }else if (navigator.userAgent.match(/android/i)) {
	            try {
	                window.location = "myapp://kmbapp/open?page=Login&recommend="+userPhone;
	                setTimeout(function(){
	                    window.location = "https://sj.qq.com/myapp/detail.htm?apkName=com.kmbao"; 
	                },3000);
	            } catch(e) {}
	        }
	    } 
	var code=null;
	var res=null;

$("#user_getcode").click(function(){
	var username=document.getElementById("username").value;
	if(username==""||!checkTel(username)){
    	$("#loginTips").html("请输入正确的电话号码!").fadeIn();
  	}else {
  	   $("#user_getcode").attr('disabled',true);
	   $.ajax({
	      url: "sendSMS.do",
	      data: { phonenum: username },
	      success: function (smscode) {
	    	console.log(smscode);
	        leftSeconds = 60; 
	        msgSendToTip();
	       code = smscode;
	        $("#loginTips").fadeOut();
	      },error: function (err) {
	        $("#user_getcode").attr('disabled',false);
	      }
	    }); 
  	   
  	}
});
function msgSendToTip() {
	$("#user_getcode").attr('disabled', true);
	$("#zhuce_btn").attr('disabled', false);
	timeIntervalId = setInterval(function() {
		if (leftSeconds <= 1) {
			$('#user_getcode').removeClass('countdown');
			$('#user_getcode').css({
				"cursor" : "pointer"
			});
			$("#user_getcode").html("获取验证码");
			clearInterval(timeIntervalId);
			$("#user_getcode").attr('disabled', false);
			leftSeconds = 60;
			head = 2;
			return;
		}
		leftSeconds--;
		console.log(leftSeconds);
		$('#user_getcode').addClass('countdown');
		$('#user_getcode').css({
			"cursor" : "auto",
		});
		head = 1;
		$("#user_getcode").html((leftSeconds<10?"0"+leftSeconds:leftSeconds) + "秒后重发");
	}, 1000);
}

function checkTel(tel) {
  var mobile = /^1[3|5|7|8]\d{9}$/, phone = /^0\d{2,3}-?\d{7,8}$/;
  return mobile.test(tel) || phone.test(tel);
}

function adduser() {
	var username = $("#username").val();
	var sms = $("#sms").val();
	if(username==""&&sms==""){
		if(isapp==1&&userPhone==""&&appname!='kmb'){
			openKmbApp();
		}else{
			openApp(1);	
		}
	}else{
		if(checkTel(username)&&sms!=""){
			$("#zhuce_btn").attr('disabled', true);
			$.ajax({
			 	url:"checkSMS.do",
			 	data:{phonenum:username,code:sms},
			 	success:function(data){
			 	console.log(data);
			 		if(data){
			 			register();
					}else{
						$("#zhuce_btn").attr('disabled', false);
						$("#loginTips").html("亲，您验证码输入有误,请重新输入!").fadeIn();	
					}
			 	},
			 	error:function(err){
			 		 $("#zhuce_btn").attr('disabled', false);
			 		 $("#loginTips").html("获取验证码失败，请稍后再试!").fadeIn();	
			 	}
			});
		}else{
			if(username==""){
				$("#loginTips").html("请输入电话号码!").fadeIn();	
			}else if(!checkTel(username)){
				$("#loginTips").html("请输入正确的电话号码!").fadeIn();	
			}else{
				$("#loginTips").html("请输入验证码!").fadeIn();	
				
			}
		}
	}

}
function register() {
	$.ajax({
		url : "register.do",
		type : "POST",
		data : $("#addform").serialize(),
		success : function(result) {
			if (result) {
				$('#myModal').modal('hide');
				if(isapp==1&&userPhone==""&&appname!='kmb'){
					openKmbApp();
				}else{
					openApp(1);	
				}
			}else{
				 $("#loginTips").html("注册失败，请稍后再试!").fadeIn();	
				 $("#zhuce_btn").attr('disabled', false);
				
			
			}
		},error: function (err) {
			 $("#loginTips").html("注册失败，请稍后再试!").fadeIn();	
			 $("#zhuce_btn").attr('disabled', false);
	      }
	});
}