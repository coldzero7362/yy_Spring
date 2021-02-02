<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무야호</title>
</head>
<body>
	<form method="post">
		<div>
			<p>아이디 : </p>
			<input type="text" name="userid" required="required"/>
		</div>
		<div>
			<p>비밀번호 : </p>
			<input type="text" name="password" required="required"/>
		</div>
		<div>
			<p>회원이름 : </p>
			<input type="text" name="username" required="required"/>
		</div>
		<div>
			<input type="submit" value="전송"/>
		</div>
	</form>
</body>
</html>