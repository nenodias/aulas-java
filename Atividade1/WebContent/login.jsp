<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form method="POST" action="login">
		<fieldset>
			<legend>Login</legend>
			<label for="login">Login:</label><input type="text" name="login" id="login" placeholder="Login" /><br />
			<label for="senha">Senha:</label><input type="password" name="senha" id="senha" placeholder="Senha" /><br />
			<button type="submit">Efetuar Login</button>
		</fieldset>
	</form>
</body>
</html>