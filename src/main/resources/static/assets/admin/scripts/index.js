
function getTypeValue(typeId,dictId,dicts){
  var dicts=eval('('+dicts+')');
  var title="";
  if(dicts!=""){
	  var types;
	  for(var i=0;i<types.length;i++){
		  if(dictId==types[i].id.dictCode&&typeId==types[i].typeId){
		 	title=types[i].dictValue;
		  }
	  } 
	  
  }

	 return title;
}