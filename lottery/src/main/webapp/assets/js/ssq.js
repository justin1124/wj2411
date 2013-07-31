$(function(){
	// 提交计算
	$('#ssqCountForm').form({
	    url:'calculate.html',  
	    success:function(item){
	    	var d = eval('('+item+')');
	    	var data = d.data;
	    	if(data == null){
	    		$("#result").html("<a style='color:red'>查询结果为空!</a>");
	    		$("#submit").linkbutton('enable');
	    		return;
	    	}
	    	var length = data.length;
	    	var temp = "";
	    	if(d.result > 0){
	    		$.messager.alert('成功','计算完成,共有['+length+']个结果,请检查文件!','info');
	    		for(var i = 0;i < length;++i){
	    			var number = data[i];
	    			var t = "";
	    			for(var j = number.length - 1;j >= 0 ;--j){
	    				t += number[j] < 10 ? "0"+number[j] : number[j];
	    				if(j > 0)
							t += " ";
	    			}
	    			temp += "<a>"+t+"</a><br>";
	    		}
	    		$("#result").html(temp);
	    		$("#submit").linkbutton('enable');
	    	}else{
	    		$.messager.alert('失败','计算失败!','error');
	    		$("#submit").linkbutton('enable');
	    	}
	    },
	    error : function(){
    		$.messager.alert('失败','请求超时,请检查网络!','error');
    		$("#submit").linkbutton('enable');
	    }
	});
});

// 查询遗漏和值
function searchOmitSum(){
	$("#searchOmit").linkbutton('disable');
	var num = $("#num").val();
	if(num == ""){
		$.messager.alert('提示','请填写查询期数!','info');
		$("#searchOmit").linkbutton('enable');
		return false;
	}
	$.ajax({
		type: "POST",
		data: "num="+num,
		url: "searchOmitSum.do",
		success: function(msg){
			$("#serachOmitResult").text("查询结果："+msg.result.join(","));
			$("#searchOmit").linkbutton('enable');
		},
		error: function(){
			$.messager.alert('失败','请求超时,请检查网络!','error');
			$("#searchOmit").linkbutton('enable');
		}
	});
}

// 新增号码
function addNum(){
	
	var issue = $.trim($("#issue").val());
	var red = $.trim($("#red").val());
	var blue = $.trim($("#blue").val());
	
	red.replace(" ",",");
	
	$.ajax({
		type: "POST",
		data: "issue="+issue+"&red="+red.replaceAll(" ",",")+"&blue="+blue,
		url: "addNum.do",
		success: function(msg){
			if(msg.result == 1){
				alert("添加成功")
			}else{
				alert("失败")
			}
		},
		error: function(){
			alert("error");
		}
	});
}

String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
}

