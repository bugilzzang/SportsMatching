<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*,java.util.*"%>

<%
String ID = request.getParameter("ID");

String result = new RankingDAO().Gets_mmrList(ID);
String result2 = new RankingDAO().Getb_mmrList(ID);
String result3 = new RankingDAO().Gett_mmrList(ID);
String result4 = new RankingDAO().Geth_mmrList(ID);

out.print(result);
out.print(result2);
out.print(result3);
out.print(result4);
%>