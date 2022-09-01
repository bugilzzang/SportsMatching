<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>
<%
	String owner = request.getParameter("owner");
	
	System.out.println("매칭 리스트");
	
	String result = new MatchingDAO().GetMatchingList(owner);
	
	out.print(result);
%>