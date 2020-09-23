var map;
var toolBar;
var points;//轨迹路径
var progress=0;//播放进度
var speed=100;//播放速度(km/h)
var playIndex=0;//用于标识手动进行修改的播放进度(该变量用于设置播放过的轨迹)
var passedPolyline;//播放过的轨迹路径
var isPlaying=false;//是否正在播放

function initialize() {
	map = new AMap.Map("container", {
		view: new AMap.View2D({ //创建地图二维视口
			center: [104.758545, 31.474781], //创建中心点坐标
			zoom: 18, //设置地图缩放级别
			rotation: 0, //设置地图旋转角度
			resizeEnable: true
		}),
		lang: "zh_cn" //设置地图语言类型，默认：中文简体
	}); //创建地图实例


	//加载标尺
	map.plugin(["AMap.Scale"], function() {
		var scale = new AMap.Scale();
		map.addControl(scale);
	});

	//加载鹰眼
	map.plugin(["AMap.OverView"], function() {
		var view = new AMap.OverView({
			visible: true
		});
		view.open(); //初始化的时候就展开鹰眼

		map.addControl(view);
	});
	
	map.plugin(["AMap.ToolBar"], function() {
		toolBar = new AMap.ToolBar();
		map.addControl(toolBar);
	});

	//加载地图类型切换插件
	map.plugin(["AMap.MapType"], function() {
		//地图类型切换
		var mapType = new AMap.MapType({
			defaultType: 0, //默认显示画布地图
			showRoad: true //叠加路网图层
		});
		map.addControl(mapType);
	});
}

//初始化数据
function initData(){
	points=null;
	progress=playIndex=0;
	try{
		passedPolyline.setPath(null);
	}catch(e){}
	isPlaying=false;
}

var pts="[\"104.715902,31.445707\",\"104.717709,31.445734\",\"104.71517,31.44462\",\"104.715416,31.444249\",\"104.715155,31.444896\",\"104.715516,31.445387\",\"104.715536,31.445652\",\"104.715867,31.445734\",\"104.715305,31.444425\",\"104.716036,31.444317\",\"104.716077,31.444833\",\"104.715366,31.444416\",\"104.714703,31.444443\",\"104.714578,31.444871\",\"104.714591,31.445373\",\"104.714568,31.445395\",\"104.714969,31.44441\",\"104.715107,31.444526\",\"104.715563,31.445536\"]";
//加载轨迹路径
function newLoadPath()
{
    map.clearMap(); //每次加载路线时,清除地图上所有覆盖物,防止覆盖物重复
	initData();
    points = jsonConvertToMapLngLat(pts); //把json字符串坐标点转换成高德经纬度坐标    
	map.zoom=18;	
    drawStartAndEndICO(); //绘制起点和终点图标
    //绘制轨迹
    var polyline = new AMap.Polyline({
        map: map,
        path: points,       
        strokeColor: "#3898f9",//线颜色
        strokeOpacity: 1,//线透明度
        strokeWeight: 4,//线宽
        strokeDasharray:[10,5],
        position:true,
        strokeStyle: "solid"//线样式
        
    });
	//车辆运行过的轨迹
	passedPolyline = new AMap.Polyline({
		map: map,
		strokeColor: "#f74948",  //线颜色
		strokeOpacity: 1,     //线透明度
		strokeWeight: 5,      //线宽		
		position:true,
		strokeStyle: "solid"//线样式
	});
    //绘制车辆图标
    marker = new AMap.Marker({
        map: map,
        position: points[0],//基点位置
		icon:"http://webapi.amap.com/images/car.png",
        offset: new AMap.Pixel(-26, -13), //相对于基点的位置
        autoRotation: true//自动旋转角度       
    });
    
//	setMarkerIcon(icon);
    map.setFitView();
	//播放过的轨迹路径设置为红色
	marker.on('moving',function(e){
        passedPolyline.setPath(points.slice(0,playIndex).concat(e.passedPath));
        //map.setFitView();
  	});
  
  	marker.on('moveend',function(){
		progress++;
		window.external.Progress = progress;
		map.panTo(points[progress]);
	});
	map.panTo(points[progress]);
}

//根据后台发送的json坐标字符 转换成高度经纬度对象
function jsonConvertToMapLngLat(json)
{
	map.zoom=18;
    if (json === "[]")
    {
        return;
    }

    //json数组转换一组坐标点
    if (json.indexOf('[') > -1 && json.indexOf(']') > -1 )
    {
        var temparray = eval(json);

        var points = new Array();
        
        for (var i = 0; i < temparray.length; i++)
        {
            var obj = temparray[i];
			if (obj.hasOwnProperty('X') && obj.hasOwnProperty('Y'))
                points[i] = new AMap.LngLat(temparray[i].X, temparray[i].Y);
			else{
				var arr=new Array();
				arr=obj.split(",");
				points[i] = new AMap.LngLat(arr[0],arr[1]); 	
			}
        }
        return points;
    }
    else
    {
        if (json === "{}")
        {
            return;
        }

        // json转单个坐标点
        var pt = eval("(" + json + ")");
		if (pt.hasOwnProperty('X') && pt.hasOwnProperty('Y'))
            var point = new AMap.LngLat(pt.X, pt.Y);
		else{
			var arr=new Array();
			arr=pt.split(",");
			var point = new AMap.LngLat(arr[0], arr[1]);
		}     
        //alert(point);
        return point;
    }
}

//轨迹播放
function moveAlong()
{		
	isPlaying=true;
	playIndex=progress;
	passedPolyline.setPath(null);
	marker.moveAlong(points,speed);
	map.panTo(points[progress]);
	map.setZoom(18);

}

//继续播放
function resumeMove(){
	isPlaying=true;
	marker.resumeMove();
}

//暂停播放
function pauseMove(){
	isPlaying=false;
	marker.pauseMove();
}

//重置
function stopMove(){
	progress=playIndex=index=0;
	var pr=points.slice(playIndex);
	marker.moveAlong(pr,speed);
	marker.stopMove();
	passedPolyline.setPath(null);
	marker.pauseMove();
	map.panTo(points[progress]);
}

//回放速度
function setMoveSpeed(s){	
	s=s.value;
	speed=1000*s;
	var pr=points.slice(progress);//更改后的播放路径
	playIndex=progress;
	passedPolyline.setPath(points.slice(0,playIndex));//将播放过的路径设置为红色
	marker.moveAlong(pr,speed);//设置播放速度

	map.getCenter(marker);
//	if(!isPlaying)
//		pauseMove();
}

function drawStartAndEndICO()
{

    var start_xy = points[0];
    var end_xy = points[points.length - 1];

    //起点、终点图标
    var sicon = new AMap.Icon({
        image: "http://cache.amap.com/lbs/static/jsdemo002.png",
        size: new AMap.Size(44, 44),
        imageOffset: new AMap.Pixel(-334, -180)
    });
    var startmarker = new AMap.Marker({
        icon: sicon, //复杂图标
        visible: true,
        position: start_xy,
        map: map,
        offset: {
            x: -16,
            y: -40
        }
    });

    var eicon = new AMap.Icon({
        image: "http://cache.amap.com/lbs/static/jsdemo002.png",
        size: new AMap.Size(44, 44),
        imageOffset: new AMap.Pixel(-334, -134)
    });

    var endmarker = new AMap.Marker({
        icon: eicon, //复杂图标
        visible: true,
        position: end_xy,
        map: map,
        offset: {
            x: -16,
            y: -40
        }
    });

    map.setFitView();
}
