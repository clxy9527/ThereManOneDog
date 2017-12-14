
function changeList(id){
			var x=document.getElementById("listName");
			
			if(id==1){
				x.innerHTML="test";
				
			}
			else if(id==2) {
				x.innerHTML="test2";
				
			}
			else if(id==3){
				x.innerHTML="test3";
			}

			
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
function loadEmployeePage(id)
{
var xmlhttp;
var bu = $(this).attr("id"); 
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("EmployeeList").innerHTML=xmlhttp.responseText;
    MessageTable()
    getChecked();
    }
  }
xmlhttp.open("GET","http://localhost:8080/ThereManOneDog/noticeController/getEmploeeByDepartment.action?dId="+id ,false);
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
	xmlhttp.open("GET","http://localhost:8080/ThereManOneDog/noticeController/addNotice.action" ,false);
	xmlhttp.send();
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
	function MessageFilter(text) {
		document.getElementById("output").innerHTML = text;
	}
	
	function hide(){
		$(":checkbox").toggle();
		$("#delete").toggle();
	}
		
	
    var checkedIds=[];
    function changeIds(){
        var oneches=document.getElementsByName("employeeSelected");
        var num=0;
      for(var i=0;i<oneches.length;i++){
          if(oneches[i].checked==true){
              //避免重复累计id （不含该id时进行累加）
              for(var j=0;j<checkedIds.length;j++){
            	  if(oneches[i].value==checkedIds[j]){
            		  num=1;
            		  break;
            	  }
              }
              if(num==0){
            	  checkedIds.push(oneches[i].value);
            	  
              }
              num=0;
          }
          if(oneches[i].checked==false){
              //取消复选框时 含有该id时将id从全局变量中去除
              for(var j=0;j<checkedIds.length;j++){
            	  if(oneches[i].value==checkedIds[j]){
            		  checkedIds.splice(j, 1);
            	  }
              }
          }
      }
   }

function getChecked(){
      var oneches=document.getElementsByName("employeeSelected");
      for(var i=0;i<oneches.length;i++){
    	  for(var j=0;j<checkedIds.length;j++){
    		  if(oneches[i].value==checkedIds[j]){
                  oneches[i].checked=true;
    		  }
    	  }
          }
      changeIds()
   }	


function createEditor(){
	var url = "http://localhost:8080/ThereManOneDog/kindeditor-4.1.7/kindeditor-min.js";
	$.getScript(url, function() {
		KindEditor.basePath = "http://localhost:8080/ThereManOneDog/kindeditor-4.1.7/";
		Editor=KindEditor.create('textarea[name="nContent"]',{
			afterBlur:function(){this.sync();}
		});
		Editor.sync();
		});
}

function ajaxRequestPageWithTable(url){
		$.ajax({
			type:'GET',
			url:url,
			success:function(data){
				document.getElementById("content").innerHTML=data;
			    MessageTable();
			}
		});
		}

function ajaxRequestPage(url){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("content").innerHTML=data;
		}
	});
	}

function ajaxRequestPageWithEditer(url){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("content").innerHTML=data;
		    createEditor();
		}
	});
}
	
function ajaxRequestPageWithChecked(url){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("EmployeeList").innerHTML=data;
		    getChecked();
		}
	});
}

function ajaxRequestNames(urlhead){
	var url = urlhead + checkedIds;
	$.ajax({
		type:'GET',
		url:url,
		dataType: 'text',  
		success:function(result){
			document.getElementById("employeeLink").value=result;
			document.getElementById("selectEmployees").value = checkedIds;
		}
	});
}
	