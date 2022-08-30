<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*" %>>
<%
	new MatchingDAO().Matchinng();
	String d = request.getParameter("d");
	System.out.println(d);
%>