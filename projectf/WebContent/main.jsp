<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="page-header.jsp">
		<jsp:param name="title" value="Message Page" />
			</jsp:include>
			
		 <!-- Custom styles for this template -->
 		 <link href="./css/navbar-fixed-top.css" rel="stylesheet">


  </head>
  <body>
  
  	<jsp:include page="page-menu.jsp">
			<jsp:param name="page" value="menu" />
		</jsp:include>


  		<sql:query var="mainlist" dataSource="ds/projectf">
  			SELECT * FROM MAINMESSAGE;
  		</sql:query>
  		
  		<c:forEach var="main" items="${mainlist.rows}">
  			<div class="panel panel-danger">
  			<div class="panel-heading">
  				<h3 class="panel-title">${main.subject}</h3>
  				
  				<h4>${main.pdate}</h4>
  				
  			</div>
  			<div class="panel-body">
  				${main.message}
  				<br>
  			</div>
  		</div>

  		</c:forEach>
  		
  		


  </body>


   <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>

    
    
    
    <!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
    <script src="./js/ie10-viewport-bug-workaround.js"></script>

   
  </html>