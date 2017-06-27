<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Project F</a>
    </div>

    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Top</a></li>
        <li><a href="#about">Sign Up</a></li>
        <li><a href="#contact">Sign In</a></li>

        <li class="dropdown">
          <a href=" " class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Category <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href=" ">Animal</a></li>
            <li><a href=" ">Adult</a></li>
            <li><a href=" ">Game</a></li>
            <li><a href=" ">Complaints</a></li>
            <li role="separator" class="divider"></li>
            <li class="dropdown-header">Nav header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <ul class="nav navbar-nav navbar-right">

    <form>
      <input name="serch">
      <input type="submit" value="カテゴリ検索">

    </form> 
  </ul>
</nav>