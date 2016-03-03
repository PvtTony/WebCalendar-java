<%--
  Created by IntelliJ IDEA.
  User: yuson
  Date: 2016/2/19
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Web Calendar Login</title>
  </head>
  <body>
  <div id="content">
    <form method="post" action="/userlogin">
      <input type="text" name="usr_email" placeholder="Email" autofocus=""/>
      <input type="password" name="usr_pass" placeholder="Password"/>
      <input type="submit" name="usr_submit" value="Login"/>
    </form>
  </div>
  </body>
</html>
