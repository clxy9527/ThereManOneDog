
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
//获取带分页列表
function ajaxRequestPageWithTable(url){
		$.ajax({
			type:'GET',
			url:url,
			success:function(data){
				document.getElementById("content").innerHTML=data;
				MessageTable();
			    buttonShow();
			    multiModal();
			    setModalsAndBackdropsOrder();
			}
		});
		}
//获取不带分页列表
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
//二级连查 
function ajaxRequestPageadd(obj){
	{  
		   var id = obj;  
		  var html = "<option value=\"0\" selected=\"selected\">职位选择 </option>";   
		      
		   $("#position").empty();  
		   $("#position").append(html);  
		   $.ajax({  
		       type: "get",    
		       url: "/ThereManOneDog/positionController/queryposition.action",    
		       data: "dId="+id,  
		       async: false,  
		      success: function(data){  
		    	
		       var jsonList=eval("("+data+")");  
		         var len = jsonList.length;  
		   // alert(jsonList);  
		         for(var i=0;i<len;i++){    
		        var e = jsonList[i];    
		        $("#position").append("<option name="+e.pId+"   value="+e.pId+">"+e.pName+"</option>");    
		        }    
		        },   
		      
		});    
		} 
}

function ajaxRequestPageWithTablebystaff(url,text){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("content").innerHTML=data;
			 document.getElementById("all").innerHTML = text;
		    MessageTable();
		   
		}
	});
	}

function ajaxRequestPageWithTableHide(url){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("content").innerHTML=data;
		    MessageTable();
		    hide();
		}
	});
	}


function MessageFilterManger(url,text) {
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("content").innerHTML=data;
		    MessageTable();
			document.getElementById("output").innerHTML = text;
		}
	});
}
	
function MessageFilterRead(url,text) {
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("content").innerHTML=data;
		    MessageTable();
			document.getElementById("output").innerHTML = text;
		}
	});
}//团队
//团队管理ajax
function buttonShow(){


	$("#addMemberButoon").toggle();		
	$("#deleteMemberButton").toggle();
	$("#deleteTeam").toggle();
	
}
//选择团队
function TeamMangement(url,text){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			
			document.getElementById("content").innerHTML=data;
			document.getElementById("listName").innerHTML=text;
		    MessageTable();
		 
		    multiModal();
		    setModalsAndBackdropsOrder();
		    
		   
		}
	});
	}
//发布任务
function loadTaskRelease()
{
var xmlhttp;
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    MessageTable();
    }
  }
xmlhttp.open("GET","TaskRelease.jsp" ,false);
xmlhttp.send();
}
//团队管理
function teamTable(url,text){
		$.ajax({
			type:'GET',
			url:url,
			success:function(data){
				document.getElementById("content").innerHTML=data;
				document.getElementById("listName").innerHTML=text;
			    MessageTable();
			    buttonShow();
			    multiModal();
			    setModalsAndBackdropsOrder();
			   
			}
		});
		}
function multiModal(){
	 // 通过该方法来为每次弹出的模态框设置最新的zIndex值，从而使最新的modal显示在最前面
    $(document).on('show.bs.modal', '.modal', function (event) {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        // setTimeout(function() {
        //     $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        // }, 0);
    });

}
function setModalsAndBackdropsOrder() {  
    var modalZIndex = 1040;
    $('.modal.in').each(function(index) {
        var $modal = $(this);
        modalZIndex++;
        $modal.css('zIndex', modalZIndex);
        $modal.next('.modal-backdrop.in').addClass('hidden').css('zIndex', modalZIndex - 1);
    });
    $('.modal.in:visible:last').focus().next('.modal-backdrop.in').removeClass('hidden');
}
function ajaxRequestTeamPageWithChecked(url){
	$.ajax({
		type:'GET',
		url:url,
		success:function(data){
			document.getElementById("EmployeeList").innerHTML=data;
			getTeamChecked();
		}
	});
}
var checkedIds=[];
function teamchangeIds(){
    var oneches=document.getElementsByName("employeeSelected");
    var num=0;
  for(var i=0;i<oneches.length;i++){
      if(oneches[i].checked==true){
          //避免重复累计id （不含该id时进行累加）
          for(var j=0;j<teamcheckedIds.length;j++){
        	  if(oneches[i].value==teamcheckedIds[j]){
        		  num=1;
        		  break;
        	  }
          }
          if(num==0){
        	  teamcheckedIds.push(oneches[i].value);
        	  
          }
          num=0;
      }
      if(oneches[i].checked==false){
          //取消复选框时 含有该id时将id从全局变量中去除
          for(var j=0;j<teamcheckedIds.length;j++){
        	  if(oneches[i].value==teamcheckedIds[j]){
        		  teamcheckedIds.splice(j, 1);
        	  }
          }
      }
  }
}
function getTeamChecked(){
    var oneches=document.getElementsByName("employeeSelected");
    for(var i=0;i<oneches.length;i++){
  	  for(var j=0;j<teamcheckedIds.length;j++){
  		  if(oneches[i].value==teamcheckedIds[j]){
                oneches[i].checked=true;
  		  }
  	  }
        }
    teamchangeIds();
 }
function ajaxAddTeamMember(urlhead){
	var url = urlhead + checkedIds;
	$.ajax({
		type:'GET',
		url:url,
		dataType: 'text',
		success:function(data){
			checkedIds= null;
		}
		
	});
}
function ajaxdeleteTeamMember(urlhead){
	var url = urlhead + checkedIds;
	$.ajax({
		type:'GET',
		url:url,
		dataType: 'text',
		success:function(data){
			checkedIds= null;
		}
		
	});
}
function ajaxDeleteTeam(url){

	$.ajax({
		type:'GET',
		url:url,
		dataType:'text',
		success:function(data){
			
		}
		
	});
}