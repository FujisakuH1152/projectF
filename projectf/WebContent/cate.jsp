<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<!DOCTYPE html>
<html>
<head>


			<jsp:include page="page-header.jsp">
		<jsp:param name="title" value="ProjectF Top Page" />
			</jsp:include>
			
		 <!-- Custom styles for this template -->
 		 <link href="./css/navbar-fixed-top.css" rel="stylesheet">
 		 
 		 <link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css" rel="stylesheet" />

</head>


	<body>
		
		<jsp:include page="page-menu.jsp">
			<jsp:param name="page" value="menu" />
		</jsp:include>
		
		
		<c:if test="${!empty param.cid}">
	
			<sql:query var="rs" dataSource="ds/projectf">
			SELECT * FROM MAINMESSAGE WHERE categoryid = ${param.cid};
			</sql:query>
		</c:if>
		
		
	<div class="jumbotron">
      <div class="container">
        <h1>Welcome to Fujisaku Samurai Park!!!</h1>
        <p>
        	カテゴリ検索を行った結果を出力しています。<br>
        	<br>
        	
        	該当スレッドがない場合は空欄になります。
        	
       
			</p>
      </div>
    </div>
		


  		
  		<c:forEach var="Cmain" items="${rs.rows}" varStatus="loop">
  			<c:set var="id" value="${Cmain.serialid}" />
  			<div class="panel panel-danger">
  			<div class="panel-heading">
  				<h3 class="panel-title">${Cmain.subject}</h3>
  				${Cmain.pdate}
  				
  				
  			</div>
  			<div class="panel-body">
  				${Cmain.message}
  	
  				<br>
  			</div>

  			<div class="panel-footer"><a href="main?id=${id}">このスレに行く。</a>
  
  			</div>
  		</div>

  		</c:forEach>
  		
  		
  		<div class="container">
  			<h2>スレッド作成</h2>
 			 <div class="panel panel-default">
    			<div class="panel-heading">以下に入力してください。</div>
    			<div class="panel-body">
    			
              <form action="mainmessage.do" method="post">
				
				<div class="form-group">
                <input type="hidden" name="serialid" value=NULL class="form-control">
                </div>
           
                <div class="form-group">
                <label for="exampleInputEmail1">日付</label>
                <input type="date" name="pdate" class="form-control">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputEmail1">タイトル</label>
                  <input type="text" name="subject" class="form-control">
                </div>
                               
                <div class="form-group">
                  <label for="exampleInputEmail1">メッセージ</label>
                  <textarea class="form-control" name="message" maxlength="500" rows="3"></textarea>
                </div>
                
                <div class="form-group">
                  <label for="exampleInputEmail1">Email</label>
                  <input type="email" name="account" class="form-control">
                </div>
                
                <div class="form-group">
                  <label for="exampleInputEmail1">カテゴリ</label>
                  <input type="number" name="category" class="form-control">
                </div>

                <button type="submit" class="btn btn-default">投稿</button>
              </form>
            	</div>  			
    		 </div>
 		</div>
  		
  		
  		
  

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>

    
    
    
    <!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
    <script src="./js/ie10-viewport-bug-workaround.js"></script>

   
	</body>
</html>