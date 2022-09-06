<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>

<%
String id = request.getParameter("ssid");

System.out.println(id);

String result = new WithdrawalDAO().Withdrawal(id);

System.out.println("JSP ID :" + id);

out.print(result);
%>