<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*,java.util.*"%>

<%

RankingDTO dto = new RankingDAO().selectOne("정부길");
System.out.println(dto.getUserID());
System.out.println(dto.getUserName());
System.out.println(dto.getAdress());
System.out.println(dto.getUserMmr());
System.out.println(dto.getIntroduction());
%>