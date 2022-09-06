<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>
<%
	String no = request.getParameter("no");
	String owner = request.getParameter("owner");
	String message = request.getParameter("message");
	
	System.out.println("채팅 보내기");
	System.out.println(no);
	System.out.println(owner);
	System.out.println(message);
	
	String result = new ChattingDAO().SendMessage(no, owner, message);
	
	out.print(result);
%>