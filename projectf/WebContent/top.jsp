<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:include page="page-header.jsp">
		<jsp:param name="title" value="Menu" />
	</jsp:include>



	<body>
		
		<jsp:include page="page-menu.jsp">
			<jsp:param name="page" value="menu" />
		</jsp:include>


  <div class="container">

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
      <h1>ProjectF</h1>
      <p>ここらへんにタイトルでも画像でもなんでも入れてインパクト狙いでいくんごぉ.
      </p>
      <p>いやっほおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおお</p>
      <p>



        <div class="container">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4>投稿</h4>
            </div>
            <div class="panel-body">
              <form >
                <div class="form-group">
                  <label for="exampleInputEmail1">ユーザ名</label>
                  <input type="text" class="form-control">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">タイトル</label>
                  <input type="text" class="form-control">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">メッセージ</label>
                  <textarea class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-default">投稿</button>
              </form>
            </div>
          </div>

        </p>

      </div>

      <hr>

      
      <indexbox>
      <img src="sironeko.png" alt="" class="img-thumbnail" width="100" height="100"><br>
        <boxauther>Auther : Arai</boxauther>
        <p><boxtitle> Title : あああああああああしろねこぉおおおおおおおおおお<br>
        </boxtitle></p>
      </indexbox>


    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  
    <script src="./../js/ie10-viewport-bug-workaround.js"></script>

   
	</body>
</html>