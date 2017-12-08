function loadTablePage()
{
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","table.jsp" ,false);
xmlhttp.send();
}
  function loadReleasePage()
{
	var xmlhttp;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("content").innerHTML=xmlhttp.responseText;
	    createEditor();
	    }
	  }
	xmlhttp.open("GET","release.jsp" ,false);
	xmlhttp.send();
	}
	  
    function createEditor(){
		$.getScript('./kindeditor-4.1.7/kindeditor-min.js', function() {
			KindEditor.basePath = './kindeditor-4.1.7/';
			Editor=KindEditor.create('textarea[name="content"]',{
				afterBlur:function(){this.sync();}
			});
			Editor.sync();
			});
    }