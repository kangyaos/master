// JavaScript Document
$(function(){
	
	if(window.screen.width <=600 && window.screen.width >350){
		//首页
		$(".gh-p1").attr("style","display:none");
		$(".gh_more").attr("style","display:none");
		$("#gh_duce").attr("style","width:100%;margin-top: 8px;");
		$(".news-text").attr("style","margin-bottom: 25px;");
		$(".gh-p3").attr("style","display:none");
		$(".dian").attr("style","display:none");
		$(".i_m").find("img").attr("style","height: 30px;width: 45%;margin: 0px;");
		$("#gh_3,#gh_4,#gh_2").attr("style","display:none");
		$("#gh_record").attr("style","display:none");
		$(".time").attr("style","color: #a5a5a5;line-height: 10px;font-size:12px;");
		$(".i_m12").attr("style","display:none");
		$(".i_m112").attr("style","display:none");
		$(".gh_tab").attr("style","border: 1px solid rgb(232, 232, 232)");
		//信息部
		$("#tishi").attr("style","padding: 10px;text-align: center;display: block;");
		//加入我们		
		$(".sed").find("span").attr("style","font-size: 14px;line-height: 25px;");
		$(".col-sm-4").find("#box12").attr("style","display:none");
		//新闻列表
		$(".gh_img2").attr("src","./assets/web/images/img/nav41.png");	
	}
	if(window.screen.width <=350){
		//首页
		$(".gh-p1").attr("style","display:none");
		$(".gh_more").attr("style","display:none");
		$("#gh_duce").attr("style","width:100%;margin-top: 8px;");
		$(".news-text").attr("style","margin-bottom: 25px;");
		$(".gh-p3").attr("style","display:none");
		$(".dian").attr("style","display:none");
		$(".i_m").find("img").attr("style","height: 30px;width: 45%;margin: 0px;");
		$("#gh_3,#gh_4,#gh_2").attr("style","display:none");
		$("#gh_record").attr("style","display:none");
		$(".time").attr("style","display:none");
		$(".i_m12").attr("style","display:none");
		$(".i_m112").attr("style","display:none");
		$(".gh_tab").attr("style","border: 1px solid rgb(232, 232, 232)");
		//加入我们		
		$(".sed").find("span").attr("style","font-size: 14px;line-height: 25px;");
		$(".col-sm-4").find("#box12").attr("style","display:none");
		//新闻列表		
		$(".gh_img2").attr("src","./assets/web/images/img/nav41.png");
		//$(".how-right1").find("span").replaceWith("")
	}
})