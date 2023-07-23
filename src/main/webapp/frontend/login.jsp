<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="content-language" content="pt-BR">
  <meta name="author" content="Felipe Batista da Silva">
  <meta http-equiv="Content-Type" content="text-html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>login</title>
</head>
<body>

    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h2>Please login:</h2>
        <form>
            <div class="content">
               <span>Username</span>
               <input type="text" placeholder="username" size="10">
            </div>
            <div class="content">
               <span>Password</span>
                <input type="text" placeholder="password" size="10">
            </div>
            <input type="submit" value="login">
        </form>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
</html>