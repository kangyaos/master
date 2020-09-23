$("document").ready(function(){
 
 $(".mainContect").find("img").css("height","auto");  
 $(".mainContect .con").find("img").css("height","auto");
  
 $(".nav > li").hover(function(){
	$(this).addClass("on");
    $(this).children("div").stop(true,true).slideDown();
 },function(){
    $(this).removeClass("on");
	$(this).children("div").stop(true,true).slideUp();
 })

// dingwei();
//var pgname = document.location.href; 	
//	  pgname=pgname.replace(/\?.*$/,'')
//	  pgname=pgname.replace(/^.*\//,'')
//if(pgname=="index.php"||pgname==null||pgname==""){
//	$(".bann").css("height","446px");
//	$("#focus").css("height","446px");
//	$("#focus ul").css("height","446px");
//	$("#focus ul li").css("height","446px");
//}
  
  $(".newsList ul li:last-child ").css("border-bottom","none")
  $(".newsList ul li:first-child ").css({"font-weight":"bold","line-height":"26px","padding-top":"16px"}).find("p").css("display","block");

  $(".contactnr dl:nth-child(2) dt").css("background","url() left 10px no-repeat");
  $(".contactnr dl:nth-child(3) dt").css("background","url() left 8px no-repeat");
  $(".contactnr dl:nth-child(4) dt").css("background","url() left 8px no-repeat");
  $(".contactnr dl:nth-child(5) dt").css("background","url() left 6px no-repeat");

  $(".proclass li:nth-child(2n)").css({"margin-right":"0px","margin-bottom":"0px"});

  $(".piclist li:nth-child(2n)").css({"margin-right":"0px","margin-bottom":"0px"});
  
//  $('.codepic').hover(function(){$('.code').fadeIn()},function(){$('.code').fadeOut()});
	$('.backup').click(function(){
		$('body,html').animate({scrollTop:0},500)
	});
	$(".backup").hide();
	$(function() {
		$(window).scroll(function(){
			if ($(window).scrollTop()>500){
				$(".backup").fadeIn(1000);
			}else{
				$(".backup").fadeOut(1000);
			}
		});
	});
	
  
  $(".procla_list > ul > li ").hover(function(){
		$(this).find(".child").css("display","block");
		$(this).addClass("open");
	},function(){
		$(this).find(".child").css("display","none");
		$(this).removerClass("open");
	});

  
  $(".procla_list > ul > li:nth-child(5n)").css("margin-right","0");	
  $(".leftnews_list li:last-child").css("border-bottom","none");
  $(".leftcon_list dl:nth-child(2) dt").css("background","url() left 7px no-repeat");
  $(".leftcon_list dl:nth-child(3) dt").css("background","url() left 6px no-repeat");
  $(".leftcon_list dl:nth-child(4) dt").css("background","url() left 6px no-repeat");
  $(".leftcon_list dl:nth-child(5) dt").css("background","url() left 6px no-repeat");
	
	
	
	$(".mainConList dl.pic1:nth-child(3n)").css("margin-right","0");
	$(".pic2:nth-child(2n)").css("padding-right","0");
	
	$(".mainConList>ul>li:nth-child(2n)").css("padding-right","0");
	
	$(".pglist ul li").not(".on").not(".last").not(".next").hover(function(){ $(this).addClass("on");},function(){$(this).removeClass("on");})
	$(".pglist ul li.last").hover(function(){
		  $(this).css({background:"url(images/lastBg2.jpg) 6px center no-repeat #783e12",border:"1px solid #754928"}).find("a").css({color:"#fff"});
	 },function(){
		   $(this).css({background:"url(images/lastBg.jpg) 6px center no-repeat #fae4b2",border:"1px solid #a97744"}).find("a").css({color:"#783e12"});
	 })
	$(".pglist ul li.next").hover(function(){
		  $(this).css({background:"url(images/nextBg2.jpg) 56px center no-repeat #783e12",border:"1px solid #754928"}).find("a").css({color:"#fff"});
	 },function(){
		   $(this).css({background:"url(images/nextBg.jpg) 56px center no-repeat #fae4b2",border:"1px solid #a97744"}).find("a").css({color:"#783e12"});
	 })
	$(".pglist ul li.font").hover(function(){ $(this).css({background:"#f9f3d7",color:"#783e12",border:"none"});})
    
    
    
    if($(".mainContect").find("img").width() > 900) {
		$(".mainContect").find("img").css({"height":"auto","width":"100%"});
	}
});


$("document").ready(function(){
	//case
	var page=1;
	var i=1;
	var box=$('.newsPic ul');
	var n=$('.newsPic li').length;
	var h=$('.newsPic li').width();
	var pagetotal=Math.ceil(n/i);
	$('.picleft').bind('click',upwardsfn);
	$('.picright').bind('click',downfn);	
	function upwardsfn(){
		if(page>1){
			box.animate({ marginLeft : '+='+h }, "slow");
			page--;
			
			$(".picright").find("img").attr('src','http://localhost:8080/mcms/templets/1/company1640//images/picrightC .jpg');	
			if(page<=1){
				$('.picleft').find("img").attr('src','http://localhost:8080/mcms/templets/1/company1640//images/picleftw.jpg');
			}else{
				$('.picleft').find("img").attr('display','http://localhost:8080/mcms/templets/1/company1640//images/picleftC.jpg');	
			}
		}
	}
	function downfn(){
		if(pagetotal>page){
			box.animate({ marginLeft : '-='+h }, "slow");
			page++;
			$(".picleft").find("img").attr('src','http://localhost:8080/mcms/templets/1/company1640//images/picleftC.jpg');	
			if(page>=pagetotal){
				$('.picright').find("img").attr('src','http://localhost:8080/mcms/templets/1/company1640//images/picrightW.jpg');
			}else{
				$('.picright').find("img").attr('src','http://localhost:8080/mcms/templets/1/company1640//images/picrightC .jpg');	
			}
		}
	}

});


//导航定位
function dingwei(){
	var nav = document.getElementById("nav"); 
	var links = nav.getElementsByTagName("li"); 
	var lilen =$("#nav").find("li");
	
	var st2=new Array();
	var str1=new Array();
	var urrenturl = document.location.href; 	
	st2= urrenturl.split("_")
	var last = 0; 
	for (var i=0;i<links.length;i++) 
	{ 
	    linkurl =  lilen[i].getAttribute("rel"); 
		str1 = linkurl.split("/");
		var length2 = str1.length-1;
		str11 = str1[length2].split(".");
		 if(st2[0].indexOf(str11[0])!=-1) 
			{ 
			 last = i; 
			}
	} 
	links[last].className = "menu";
}
function scrolling(a,b,c){
	var speedp=30;
	var tabp=document.getElementById(a);
	var tab1p=document.getElementById(b);
	var tab2p=document.getElementById(c);
	tab2p.innerHTML=tab1p.innerHTML;
	function Marqueep(){
	if(tab2p.offsetWidth-tabp.scrollLeft<=0)
	tabp.scrollLeft-=tab1p.offsetWidth
	else{
	tabp.scrollLeft++;
	}
	}
	var MyMarp=setInterval(Marqueep,speedp);
	tabp.onmouseover=function() {clearInterval(MyMarp)};
	tabp.onmouseout=function() {MyMarp=setInterval(Marqueep,speedp)};
}

