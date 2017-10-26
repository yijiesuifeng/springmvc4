<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		Welcome to Spring MVC world
	</pre>

	<div class="upload">
		<form action="upload" enctype="multipart/form-data" method="post">
			<input type="file" name="file"/><br/>
			<input type="submit" value="上传">
		</form>
	</div>

	<a href="http://localhost:8202/springmvc4/sse">基于SSE的服务器端推送，每5s推送一次数据，详细查看SseController</a><br>
	<a href="http://localhost:8202/springmvc4/async">基于servlet3.0+异步方法的服务器端推送，每3s推送一次数据，详细查看AysncController+PushService</a>
</body>
</html>