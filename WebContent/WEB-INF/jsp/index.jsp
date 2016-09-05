<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
</head>
<body>
	成功登录学生信息管理系统
	<button id="btnLoginout">退出登录</button>

	<button id="22">fff</button>
</body>
<script src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">

	$("#btnLoginout").click(function() {
		$.ajax({
			type:"post",
			url:"loginOut.action",
			dataType:"JSON",
			success:function(data){
				alert(data.message)
			}
				
		})
	});

</script>
</html>