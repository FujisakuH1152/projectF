<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
  <head>
   <jsp:include page="page-header.jsp">
		<jsp:param name="title" value="SignUp" />
	</jsp:include>
	
	    <link rel="icon" href="./favicon.ico">
		<link href="./css/signup.css" rel="stylesheet">
    <eng class="english">

    </eng>

   
  </head>

  <body>
  
  
  <jsp:include page="page-menu.jsp">
			<jsp:param name="page" value="menu" />
	</jsp:include>

    <div class="container">
    <eng class="english">
    
    <!-- 
    action = signUp.do
    email = email
    password = password
    text = userName
     -->
      <form class="form-signup" action="signUp.do" method="post">
        <h2 class="form-signup-heading">Please write your account data</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <label for="inputText" class="sr-only">UserName</label>
        <input type="text" name="username" id="inputText" class="form-control" placeholder="UserName" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
      </form>
     </eng>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
