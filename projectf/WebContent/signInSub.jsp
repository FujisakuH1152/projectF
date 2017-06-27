<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
  <head>
  
  
  	<jsp:include page="page-header.jsp">
		<jsp:param name="title" value="Menu" />
			</jsp:include>

   <title>SignIn</title>

  </head>

  <body>
  
  <jsp:include page="page-menu.jsp">
			<jsp:param name="page" value="menu" />
	</jsp:include>

    <div class="container">
    <eng class="english">
    
    <!-- 

    action = Login.do
    email = email
    password = password
     -->
    
      <form class="form-signin" action="login.do" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
     </eng>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
