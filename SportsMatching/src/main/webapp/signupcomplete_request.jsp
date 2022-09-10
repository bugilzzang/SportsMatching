<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>

<%
String id = request.getParameter("id");
String isWinner = request.getParameter("isWinner_checked");
String MVP = request.getParameter("MVP_checked");
String result ;

System.out.println(id + "," + MVP + "," + isWinner);






out.print(result);
%>