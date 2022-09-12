<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>
<%
	String owner = request.getParameter("owner");
	String kind = request.getParameter("kind");
	String date = request.getParameter("date");
	String time1 = request.getParameter("time1");
	String time2 = request.getParameter("time2");
	String mmr1 = request.getParameter("mmr1");
	String mmr2 = request.getParameter("mmr2");
	String many1 = request.getParameter("many1");
	String many2 = request.getParameter("many2");
	String our = request.getParameter("our");
	String location = request.getParameter("location");
	
	System.out.println("매칭 등록");
	System.out.println(owner);
	System.out.println(kind);
	System.out.println(date);
	System.out.println(time1);
	System.out.println(time2);
	System.out.println(mmr1);
	System.out.println(mmr2);
	System.out.println(many1);
	System.out.println(many2);
	System.out.println(our);
	System.out.println(location);
	
	String result = new MatchingDAO().Matching(owner, kind, date, time1, time2, mmr1, mmr2, many1, many2, our, location);
	
	out.print(result);
%>