<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*" import= "java.util.Map"%>

<%
String id = request.getParameter("ssid");
Map<String, String> result = new userloadDAO().userloadingDAO(id);

String userid = result.get("UserId");

out.print(userid);

%>