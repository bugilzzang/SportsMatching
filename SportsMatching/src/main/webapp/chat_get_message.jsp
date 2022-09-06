<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>
<%
	String no = request.getParameter("no");
	
	System.out.println("채팅 가져오기");
	
	String result = new ChattingDAO().GetChatting(no);
	
	out.print(result);
%>