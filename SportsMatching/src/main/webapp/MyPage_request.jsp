<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*" import="java.util.Map" import="java.util.HashMap" import = "org.json.simple.JSONObject"%>
<%
String id = request.getParameter("ssid");

Map<String, String>result = new userloadDAO().userloadingDAO(id);

String userid = result.get("UserId");
String username = result.get("UserName");
String useraddress = result.get("UserAddress");

String finalresult = userid + "," + username + "," + useraddress;

out.print(finalresult);
%>

