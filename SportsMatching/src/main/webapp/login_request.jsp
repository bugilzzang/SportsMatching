<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>
<%
	String USER_ID = request.getParameter("id");
	String USER_PASSWORD = request.getParameter("pw");
	
	System.out.println(USER_ID);
	System.out.println(USER_PASSWORD);
	
	String result = new LoginDAO().enter_Member(USER_ID, USER_PASSWORD);
	out.print(result);
%>