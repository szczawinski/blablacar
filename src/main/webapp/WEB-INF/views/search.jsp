<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Znajdź wspólny przejazd | BlaBlaCar.pl</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/blablacar.css' />">
</head>
<body>
<div class="page">
    <header class="site-header">
        <div class="container clearfix no-border">
            <a href="/blablacar" class="logo">BlaBlaCar</a>
        </div>
    </header>
    <div class="container">
        <div class="trip-search-form search-form search-container">
            <h2>
                Znajdź przejazd na trasie:
            </h2>


            <form:form id="search-form" class="form-inline" method="post" modelAttribute="formBean">
                <form:input path="departure" type="text" id="search_from_name" data-autocomplete="name" name="fn"
                            title="Z"
                            placeholder="Z"
                            class="search-from place-autocomplete" autocomplete="off"/>


                <button type="button" class="btn reverse tip" title="Zamień przyjazd z odjazdem">
                    <img src="https://d1ovtcjitiy70m.cloudfront.net/vi-1/images/icons/reverse2.png" width="18"
                         height="16"
                         alt="Odwróć">
                </button>

                <form:input path="destination" type="text" id="search_to_name" data-autocomplete="name" name="tn"
                            title="Do"
                            placeholder="Do"
                            class="search-to place-autocomplete" autocomplete="off"/>


                <input type="text" id="simple_search_dateBegin" name="db" title="Data" placeholder="Data"
                       class="search-date date-picker">

                <input type="submit" class="btn-2action btn-large" value="Szukaj">
            </form:form>
        </div>

        <div class="search-empty">
            <s:url value="/resources/images/no-search.jpg" htmlEscape="true" var="picture"/>
            <img class="photo" src="${picture}" width="960" height="448"/>
        </div>
    </div>
</div>
</body>
</html>
