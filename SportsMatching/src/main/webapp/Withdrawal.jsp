<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>

<%
String id = request.getParameter("ssid");

System.out.println(id);

String result = new WithdrawalDAO().Withdrawal(id);

out.print(result);
%>