<%@page import="hu.godenyd.servlet.kilatopont.util.ActionKeys"%>
<%@page import="hu.godenyd.servlet.kilatopont.util.WebKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
 Object doShow = request.getAttribute(WebKeys.DO_SHOW_KILATO);
boolean showData = false;
if (doShow != null && (boolean)doShow) {
	showData = true;
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Kilátópont</title>
</head>
<body>
    <div>
        <span>Kilátópontok</span>
    </div>
    
    <% if (showData) { %>
        <jsp:include page="currentKilato.jsp" />
    <% } %>
    
    <jsp:include page="advanceKilato.jsp"/>
    
    <jsp:include page="addKilatoForm.jsp" />
</body>
</html>