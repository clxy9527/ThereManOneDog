function loadTablePage()
{
var xmlhttp;
var bu = $(this).attr("id"); 
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    MessageTable()
    }
  }
xmlhttp.open("GET","message.jsp" ,false);
xmlhttp.send();
}

function loadTaskRelease()
{
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    MessageTable()
    }
  }
xmlhttp.open("GET","TaskRelease.jsp" ,false);
xmlhttp.send();
}
function loadEmployeePage()
{
var xmlhttp;
var bu = $(this).attr("id"); 
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("employee").innerHTML=xmlhttp.responseText;
    MessageTable()
    }
  }
xmlhttp.open("GET","EmployeeList.jsp" ,false);
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
	
	function loadTeamTablePage()
	{
	var xmlhttp;
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("content").innerHTML=xmlhttp.responseText;
	    tableFunction();
	    }
	  }
	xmlhttp.open("GET","TeamTable.jsp" ,false);
	xmlhttp.send();
	}
	
	function loadDepartment()
	{
	var xmlhttp;
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("content").innerHTML=xmlhttp.responseText;
	    tableFunction();
	    }
	  }
	xmlhttp.open("GET","Department.jsp" ,false);
	xmlhttp.send();
	}
	
	function loadStaff()
	{
	var xmlhttp;
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("content").innerHTML=xmlhttp.responseText;
	    tableFunction();
	    }
	  }
	xmlhttp.open("GET","Staff.jsp" ,false);
	xmlhttp.send();
	}
	function loadMange()
	{
	var xmlhttp;
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("content").innerHTML=xmlhttp.responseText;
	    tableFunction();
	    }
	  }
	xmlhttp.open("GET","MangeDepartment.jsp" ,false);
	xmlhttp.send();
	}
	function tableFunction(){
		
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
		 
	}
	
	function MessageTable(){
		
		$('.table-message').dataTable();
		$('.dataTables_paginate').addClass("btn-group datatable-pagination");
		$('.dataTables_paginate > a').wrapInner('<span />');
		$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
		$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
	 
}
	
		$('#item1').click(function (){
			alert("13");
		})
		$("#item2").click(function (){
			$("#outitem").text = $("#item2").text;
		})
		$("#item3").click(function (){
			$("#outitem").text = $("#item3").text;
		})
	
	function hide(){
		$(":checkbox").toggle();
		$("#delete").toggle();
	}