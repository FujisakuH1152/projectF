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
		
		
		
		<c:if test="${!empty param.id}">
	
			<sql:query var="rs" dataSource="ds/projectf">
			SELECT * FROM MAINMESSAGE WHERE serialid = ${param.id};
			</sql:query>
		</c:if>
		${param.id}
		<c:set var="Mmessage" value="${rs.rows[0]}" />
  		<!-- 親スレッドの出力 -->
  			<div class="panel panel-danger">
  			<div class="panel-heading">
  				<h3 class="panel-title">${Mmessage["subject"]}</h3>
  				
  				<h4>${Mmessage["pdate"]}</h4>
  				
  			</div>
  			<div class="panel-body">
  				${Mmessage["message"]}
  				<br>
  			</div>
  		</div>
  		
  				
		<c:if test="${!empty param.id}">
	
  		<sql:query var="sublist" dataSource="ds/projectf">
  			SELECT * FROM SUBMESSAGE WHERE mainserialid = ${param.id};
  		</sql:query>
  		
		</c:if>
  		
  		
  		
  		<!-- 子スレッドの出力 -->
  		<div class="panel-group">
    		<div class="panel panel-default">
      		<div class="panel-heading">心優しい皆様の反応</div>
      		<div class="panel-body">
  		
  		<c:forEach var="sub" items="${sublist.rows}">
  			<div class="panel panel-info">
  			<div class="panel-heading">
  				<h3 class="panel-title">${sub.subject}</h3>
  				
  				<h4>${sub.pdate}</h4>
  				
  			</div>
  			<div class="panel-body">
  				${sub.message}
  				<br>
  			</div>
  		</div>

  		</c:forEach>
  			</div>
   		 </div>
  		</div>
  		
  		
  		<div class="container">
  			<h2>返信フォーム</h2>
 			 <div class="panel panel-default">
    			<div class="panel-heading">以下に入力してください。</div>
    			<div class="panel-body">
    			
              <form action="submessage.do" method="post">
                
                <div class="form-group">
                <input type="hidden" name="serialid" value=NULL class="form-control">
                </div>
                
                <div class="form-group">
                <label for="exampleInputEmail1">スレッドNo.${param.id}</label>
                <input type="hidden" name="mainmessage" value=${param.id} class="form-control">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputEmail1">メッセージ</label>
                  <textarea class="form-control" name="message" maxlength="500" rows="3"></textarea>
                </div>
           
                <div class="form-group">
                <label for="exampleInputEmail1">日付</label>
                <input type="date" name="pdate" class="form-control">
                </div>
                
                <button type="submit" class="btn btn-default">投稿</button>
              </form>
            	</div>  			
    		 </div>
 		</div>
  		
  		


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