<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="SportsMatching.*"%>

<%
String id = request.getParameter("id");
String isWinner = request.getParameter("isWinner_checked");
String MVP = request.getParameter("MVP_checked");
String result ;

System.out.println(id + "," + MVP + "," + isWinner);


if(new RatingDAO().search_Member(id).equals("서칭성공")){
	if(isWinner.equals("true") && MVP.equals("true")){
		result = new RatingDAO().doubleCheck_MMR(id);
	}else if(isWinner.equals("true") && MVP.equals("false")){
		result = new RatingDAO().WINNER_MMR(id);
	}else if(isWinner.equals("false") && MVP.equals("true")){
		result = new RatingDAO().MVP_MMR(id);
	}else{
		result = "체크 오류";
	}
}else{
	result = "서칭실패";
}



out.print(result);
%>