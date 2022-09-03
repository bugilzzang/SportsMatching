<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String address = request.getParameter("address");
String mmr = request.getParameter("mmr");


System.out.println("회원정보");
System.out.println(name);
System.out.println(id);
System.out.println(pw);
System.out.println(address);
System.out.println(mmr);

String result = new SignDAO().SignUP(name, id, pw, address, mmr);
out.print(result);

%>