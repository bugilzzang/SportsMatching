<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*" %>>
<%
	
	String USER_ID = request.getParameter("USER_ID");
	String USER_NAME = request.getParameter("USER_NAME");
	String USER_PASSWORD = request.getParameter("USER_PASSWORD");
	String USER_ADDRESS = request.getParameter("USER_ADDRESS");
	int USER_MMR = Integer.parseInt(request.getParameter("USER_MMR"));
	
	
	System.out.println(USER_ID);
	System.out.println(USER_NAME);
	System.out.println(USER_PASSWORD);
	System.out.println(USER_ADDRESS);
	System.out.println(USER_MMR);
	
	String result = new LoginDAO().Matchinng(USER_ID, USER_NAME, USER_PASSWORD, USER_ADDRESS, USER_MMR);
%>