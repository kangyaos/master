var imgFlag = false; //---鼠标放在图片上标记
var divFlag = false; //---鼠标放在删除层上标记

function showDeleteDiv(resourceCode){
    imgFlag = true;
    $("#"+resourceCode+"DIV").css("display","block");
};

function hideDeleteDiv(resourceCode){
    if(!imgFlag){
        $("#"+resourceCode+"DIV").css("display","none");   
    }
};

function imgOnmouseout(){
    imgFlag=false;
};

function divOnmouseover(resourceCode){
    divFlag = true;
    showDeleteDiv(resourceCode);
};

function divOnmouseout(resourceCode){
    divFlag = false;
    if(imgFlag){
        showDeleteDiv(resourceCode);
    }else{
        hideDeleteDiv(resourceCode);
    }
};