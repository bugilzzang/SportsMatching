<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*,java.util.*"%>

<%
String UserID = request.getParameter("UserID");

String result = new RankingDAO().GetRankingList(UserID);

out.print(result);
	
%>